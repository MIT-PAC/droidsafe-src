package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.502 -0400", hash_original_field = "47E234C72F8463B7C6770D658A5E41C2", hash_generated_field = "CAA46A02DF073835D5C8346AD9A9CB63")

    private int mNumColumns = AUTO_FIT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.502 -0400", hash_original_field = "984A75716F93CAE1C49F1090E6A0CB2C", hash_generated_field = "E9FAC14F36FB56A0DCAB954B62C2DF2B")

    private int mHorizontalSpacing = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.502 -0400", hash_original_field = "FE80057B725E738FDE5E09E6B3B7F8F2", hash_generated_field = "A39AD23AD5FCB84AB23C237FC706C8F3")

    private int mRequestedHorizontalSpacing;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.502 -0400", hash_original_field = "04A0AE56E019E90823DFCF538F9EB200", hash_generated_field = "84EB60F5A5BD3F778480F01C86BB8AA9")

    private int mVerticalSpacing = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.503 -0400", hash_original_field = "D2D9B35C5FA16AAC3C153C6F6D51079F", hash_generated_field = "AEA63239A963A24EEC1FCFD67B3B96A7")

    private int mStretchMode = STRETCH_COLUMN_WIDTH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.503 -0400", hash_original_field = "E1663A40DA302B5F0D865267D61B180B", hash_generated_field = "20F46DBB58574C7E2F33333D8FE15571")

    private int mColumnWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.503 -0400", hash_original_field = "145243760978B68BCAB5FA8129C172AE", hash_generated_field = "7063064B546DF13BA7FDA901DDEC5780")

    private int mRequestedColumnWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.503 -0400", hash_original_field = "53E8A93614B65E7EB80706CE2B65D07B", hash_generated_field = "583D48FC72E3B18BBAD06B1F4E148F28")

    private int mRequestedNumColumns;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.503 -0400", hash_original_field = "94710AAABC607EA664B744BE97844000", hash_generated_field = "7823B4B6322E0EBEB34297B0E440B23B")

    private View mReferenceView = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.503 -0400", hash_original_field = "5238F9CB997751442CCEC167A710A933", hash_generated_field = "E909A7C80DCAC01F178BEF4C30386FF5")

    private View mReferenceViewInSelectedRow = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.503 -0400", hash_original_field = "32B080F2E8D2B31FD5606656CD48D0F9", hash_generated_field = "B1F879D1C3141C34182BB7A64318C608")

    private int mGravity = Gravity.LEFT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.503 -0400", hash_original_field = "DF43B278CEE8933271AB3D9F9E312F86", hash_generated_field = "A498F2A4744F31D22F9C4ABEBB254F2F")

    private final Rect mTempRect = new Rect();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.503 -0400", hash_original_method = "6B9AD93D67DF35D03ADA1536C0A58FBF", hash_generated_method = "983C8391566F7BB71FF28D509435B241")
    public  GridView(Context context) {
        super(context);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.504 -0400", hash_original_method = "2A531A248703ACB5E0E1C6A31088A2B2", hash_generated_method = "EEB07A616C5F4990326869DA8C2CA4AF")
    public  GridView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.gridViewStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.505 -0400", hash_original_method = "49F6501DFACF5B2EADDBFC02F7376929", hash_generated_method = "7C7CDE27B7256C7A12014A5C8ADE373F")
    public  GridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.GridView, defStyle, 0);
        int hSpacing = a.getDimensionPixelOffset(
                com.android.internal.R.styleable.GridView_horizontalSpacing, 0);
        setHorizontalSpacing(hSpacing);
        int vSpacing = a.getDimensionPixelOffset(
                com.android.internal.R.styleable.GridView_verticalSpacing, 0);
        setVerticalSpacing(vSpacing);
        int index = a.getInt(com.android.internal.R.styleable.GridView_stretchMode, STRETCH_COLUMN_WIDTH);
    if(index >= 0)        
        {
            setStretchMode(index);
        } //End block
        int columnWidth = a.getDimensionPixelOffset(com.android.internal.R.styleable.GridView_columnWidth, -1);
    if(columnWidth > 0)        
        {
            setColumnWidth(columnWidth);
        } //End block
        int numColumns = a.getInt(com.android.internal.R.styleable.GridView_numColumns, 1);
        setNumColumns(numColumns);
        index = a.getInt(com.android.internal.R.styleable.GridView_gravity, -1);
    if(index >= 0)        
        {
            setGravity(index);
        } //End block
        a.recycle();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.505 -0400", hash_original_method = "0E1A05724C497F45D7FB6AC34C501814", hash_generated_method = "B97A3DFBBA7A1A53C03E1DE808EC8EAB")
    @Override
    public ListAdapter getAdapter() {
ListAdapter varD72668EDE5E63ADF9340F3D8A19FD205_388333419 =         mAdapter;
        varD72668EDE5E63ADF9340F3D8A19FD205_388333419.addTaint(taint);
        return varD72668EDE5E63ADF9340F3D8A19FD205_388333419;
        // ---------- Original Method ----------
        //return mAdapter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.505 -0400", hash_original_method = "8AB2C6958FD7CEC3A8A71FE59763D6A4", hash_generated_method = "F411B04A9F1D200E30F181818B8C9DCB")
    @android.view.RemotableViewMethod
    public void setRemoteViewsAdapter(Intent intent) {
        addTaint(intent.getTaint());
        super.setRemoteViewsAdapter(intent);
        // ---------- Original Method ----------
        //super.setRemoteViewsAdapter(intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.507 -0400", hash_original_method = "3B0F7EFF2AD6466D19A6F404E2E1BAAD", hash_generated_method = "659411209A2A02CFCA1A09BF8E3B8DF8")
    @Override
    public void setAdapter(ListAdapter adapter) {
        addTaint(adapter.getTaint());
    if(mAdapter != null && mDataSetObserver != null)        
        {
            mAdapter.unregisterDataSetObserver(mDataSetObserver);
        } //End block
        resetList();
        mRecycler.clear();
        mAdapter = adapter;
        mOldSelectedPosition = INVALID_POSITION;
        mOldSelectedRowId = INVALID_ROW_ID;
        super.setAdapter(adapter);
    if(mAdapter != null)        
        {
            mOldItemCount = mItemCount;
            mItemCount = mAdapter.getCount();
            mDataChanged = true;
            checkFocus();
            mDataSetObserver = new AdapterDataSetObserver();
            mAdapter.registerDataSetObserver(mDataSetObserver);
            mRecycler.setViewTypeCount(mAdapter.getViewTypeCount());
            int position;
    if(mStackFromBottom)            
            {
                position = lookForSelectablePosition(mItemCount - 1, false);
            } //End block
            else
            {
                position = lookForSelectablePosition(0, true);
            } //End block
            setSelectedPositionInt(position);
            setNextSelectedPositionInt(position);
            checkSelectionChanged();
        } //End block
        else
        {
            checkFocus();
            checkSelectionChanged();
        } //End block
        requestLayout();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.507 -0400", hash_original_method = "D52FAC74E641441314EFBB7F4E58B879", hash_generated_method = "BA3A9ACB0D4A0428F45C7B663D822689")
    @Override
     int lookForSelectablePosition(int position, boolean lookDown) {
        addTaint(lookDown);
        addTaint(position);
        final ListAdapter adapter = mAdapter;
    if(adapter == null || isInTouchMode())        
        {
            int var296D6C732A05FBA51C5854FA7933FE23_131965340 = (INVALID_POSITION);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_936492366 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_936492366;
        } //End block
    if(position < 0 || position >= mItemCount)        
        {
            int var296D6C732A05FBA51C5854FA7933FE23_1757312548 = (INVALID_POSITION);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1453042449 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1453042449;
        } //End block
        int var4757FE07FD492A8BE0EA6A760D683D6E_1806312305 = (position);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1552390094 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1552390094;
        // ---------- Original Method ----------
        //final ListAdapter adapter = mAdapter;
        //if (adapter == null || isInTouchMode()) {
            //return INVALID_POSITION;
        //}
        //if (position < 0 || position >= mItemCount) {
            //return INVALID_POSITION;
        //}
        //return position;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.508 -0400", hash_original_method = "A62E9A831AF61A8CD347891B2F9D44DF", hash_generated_method = "1C16C5B9777022FCAA13A2F48DA29487")
    @Override
     void fillGap(boolean down) {
        addTaint(down);
        final int numColumns = mNumColumns;
        final int verticalSpacing = mVerticalSpacing;
        final int count = getChildCount();
    if(down)        
        {
            int paddingTop = 0;
    if((mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK)            
            {
                paddingTop = getListPaddingTop();
            } //End block
            final int startOffset = count > 0 ?
                    getChildAt(count - 1).getBottom() + verticalSpacing : paddingTop;
            int position = mFirstPosition + count;
    if(mStackFromBottom)            
            {
                position += numColumns - 1;
            } //End block
            fillDown(position, startOffset);
            correctTooHigh(numColumns, verticalSpacing, getChildCount());
        } //End block
        else
        {
            int paddingBottom = 0;
    if((mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK)            
            {
                paddingBottom = getListPaddingBottom();
            } //End block
            final int startOffset = count > 0 ?
                    getChildAt(0).getTop() - verticalSpacing : getHeight() - paddingBottom;
            int position = mFirstPosition;
    if(!mStackFromBottom)            
            {
                position -= numColumns;
            } //End block
            else
            {
                position--;
            } //End block
            fillUp(position, startOffset);
            correctTooLow(numColumns, verticalSpacing, getChildCount());
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.509 -0400", hash_original_method = "6F9360E73E1EB4E0BD6CC48A029E26CB", hash_generated_method = "02A8F205473D5792462B9ED968322B99")
    private View fillDown(int pos, int nextTop) {
        addTaint(nextTop);
        addTaint(pos);
        View selectedView = null;
        int end = (mBottom - mTop);
    if((mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK)        
        {
            end -= mListPadding.bottom;
        } //End block
        while
(nextTop < end && pos < mItemCount)        
        {
            View temp = makeRow(pos, nextTop, true);
    if(temp != null)            
            {
                selectedView = temp;
            } //End block
            nextTop = mReferenceView.getBottom() + mVerticalSpacing;
            pos += mNumColumns;
        } //End block
View var11299FD0AF79690829705998589379E5_1714955426 =         selectedView;
        var11299FD0AF79690829705998589379E5_1714955426.addTaint(taint);
        return var11299FD0AF79690829705998589379E5_1714955426;
        // ---------- Original Method ----------
        //View selectedView = null;
        //int end = (mBottom - mTop);
        //if ((mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK) {
            //end -= mListPadding.bottom;
        //}
        //while (nextTop < end && pos < mItemCount) {
            //View temp = makeRow(pos, nextTop, true);
            //if (temp != null) {
                //selectedView = temp;
            //}
            //nextTop = mReferenceView.getBottom() + mVerticalSpacing;
            //pos += mNumColumns;
        //}
        //return selectedView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.511 -0400", hash_original_method = "DFB797BE7486A81865BE6BA7ABEE8F5A", hash_generated_method = "3C4C26E49A5E68AD3F3A8C7B0A3AAFE3")
    private View makeRow(int startPos, int y, boolean flow) {
        addTaint(flow);
        addTaint(y);
        addTaint(startPos);
        final int columnWidth = mColumnWidth;
        final int horizontalSpacing = mHorizontalSpacing;
        int last;
        int nextLeft = mListPadding.left +
                ((mStretchMode == STRETCH_SPACING_UNIFORM) ? horizontalSpacing : 0);
    if(!mStackFromBottom)        
        {
            last = Math.min(startPos + mNumColumns, mItemCount);
        } //End block
        else
        {
            last = startPos + 1;
            startPos = Math.max(0, startPos - mNumColumns + 1);
    if(last - startPos < mNumColumns)            
            {
                nextLeft += (mNumColumns - (last - startPos)) * (columnWidth + horizontalSpacing);
            } //End block
        } //End block
        View selectedView = null;
        final boolean hasFocus = shouldShowSelector();
        final boolean inClick = touchModeDrawsInPressedState();
        final int selectedPosition = mSelectedPosition;
        View child = null;
for(int pos = startPos;pos < last;pos++)
        {
            boolean selected = pos == selectedPosition;
            final int where = flow ? -1 : pos - startPos;
            child = makeAndAddView(pos, y, flow, nextLeft, selected, where);
            nextLeft += columnWidth;
    if(pos < last - 1)            
            {
                nextLeft += horizontalSpacing;
            } //End block
    if(selected && (hasFocus || inClick))            
            {
                selectedView = child;
            } //End block
        } //End block
        mReferenceView = child;
    if(selectedView != null)        
        {
            mReferenceViewInSelectedRow = mReferenceView;
        } //End block
View var11299FD0AF79690829705998589379E5_679113588 =         selectedView;
        var11299FD0AF79690829705998589379E5_679113588.addTaint(taint);
        return var11299FD0AF79690829705998589379E5_679113588;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.512 -0400", hash_original_method = "0AADB00D4F358179B46AC864F825D76F", hash_generated_method = "DFF0B8522701B95A12893EA8F416965C")
    private View fillUp(int pos, int nextBottom) {
        addTaint(nextBottom);
        addTaint(pos);
        View selectedView = null;
        int end = 0;
    if((mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK)        
        {
            end = mListPadding.top;
        } //End block
        while
(nextBottom > end && pos >= 0)        
        {
            View temp = makeRow(pos, nextBottom, false);
    if(temp != null)            
            {
                selectedView = temp;
            } //End block
            nextBottom = mReferenceView.getTop() - mVerticalSpacing;
            mFirstPosition = pos;
            pos -= mNumColumns;
        } //End block
    if(mStackFromBottom)        
        {
            mFirstPosition = Math.max(0, pos + 1);
        } //End block
View var11299FD0AF79690829705998589379E5_1691519471 =         selectedView;
        var11299FD0AF79690829705998589379E5_1691519471.addTaint(taint);
        return var11299FD0AF79690829705998589379E5_1691519471;
        // ---------- Original Method ----------
        //View selectedView = null;
        //int end = 0;
        //if ((mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK) {
            //end = mListPadding.top;
        //}
        //while (nextBottom > end && pos >= 0) {
            //View temp = makeRow(pos, nextBottom, false);
            //if (temp != null) {
                //selectedView = temp;
            //}
            //nextBottom = mReferenceView.getTop() - mVerticalSpacing;
            //mFirstPosition = pos;
            //pos -= mNumColumns;
        //}
        //if (mStackFromBottom) {
            //mFirstPosition = Math.max(0, pos + 1);
        //}
        //return selectedView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.513 -0400", hash_original_method = "ECD7EEB642891ACE11FADF160200B8D1", hash_generated_method = "C77B7F0FA73D9E4B6E9C833402D7FB06")
    private View fillFromTop(int nextTop) {
        addTaint(nextTop);
        mFirstPosition = Math.min(mFirstPosition, mSelectedPosition);
        mFirstPosition = Math.min(mFirstPosition, mItemCount - 1);
    if(mFirstPosition < 0)        
        {
            mFirstPosition = 0;
        } //End block
        mFirstPosition -= mFirstPosition % mNumColumns;
View var49BCC10837EDABC5CED602D8E493B0B0_1234997447 =         fillDown(mFirstPosition, nextTop);
        var49BCC10837EDABC5CED602D8E493B0B0_1234997447.addTaint(taint);
        return var49BCC10837EDABC5CED602D8E493B0B0_1234997447;
        // ---------- Original Method ----------
        //mFirstPosition = Math.min(mFirstPosition, mSelectedPosition);
        //mFirstPosition = Math.min(mFirstPosition, mItemCount - 1);
        //if (mFirstPosition < 0) {
            //mFirstPosition = 0;
        //}
        //mFirstPosition -= mFirstPosition % mNumColumns;
        //return fillDown(mFirstPosition, nextTop);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.514 -0400", hash_original_method = "0818B9EEFC7CF79A0018AB61F39070C0", hash_generated_method = "4F6E057E6CCC7D7459F0F1D3E1D27B30")
    private View fillFromBottom(int lastPosition, int nextBottom) {
        addTaint(nextBottom);
        addTaint(lastPosition);
        lastPosition = Math.max(lastPosition, mSelectedPosition);
        lastPosition = Math.min(lastPosition, mItemCount - 1);
        final int invertedPosition = mItemCount - 1 - lastPosition;
        lastPosition = mItemCount - 1 - (invertedPosition - (invertedPosition % mNumColumns));
View var7A713FC2785F6AF8547BE1D5F9426B88_2021211930 =         fillUp(lastPosition, nextBottom);
        var7A713FC2785F6AF8547BE1D5F9426B88_2021211930.addTaint(taint);
        return var7A713FC2785F6AF8547BE1D5F9426B88_2021211930;
        // ---------- Original Method ----------
        //lastPosition = Math.max(lastPosition, mSelectedPosition);
        //lastPosition = Math.min(lastPosition, mItemCount - 1);
        //final int invertedPosition = mItemCount - 1 - lastPosition;
        //lastPosition = mItemCount - 1 - (invertedPosition - (invertedPosition % mNumColumns));
        //return fillUp(lastPosition, nextBottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.515 -0400", hash_original_method = "B869E7B5DD0E41AF8A9344426795B32C", hash_generated_method = "EFA989880DD80C55534BE3B42399FF7A")
    private View fillSelection(int childrenTop, int childrenBottom) {
        addTaint(childrenBottom);
        addTaint(childrenTop);
        final int selectedPosition = reconcileSelectedPosition();
        final int numColumns = mNumColumns;
        final int verticalSpacing = mVerticalSpacing;
        int rowStart;
        int rowEnd = -1;
    if(!mStackFromBottom)        
        {
            rowStart = selectedPosition - (selectedPosition % numColumns);
        } //End block
        else
        {
            final int invertedSelection = mItemCount - 1 - selectedPosition;
            rowEnd = mItemCount - 1 - (invertedSelection - (invertedSelection % numColumns));
            rowStart = Math.max(0, rowEnd - numColumns + 1);
        } //End block
        final int fadingEdgeLength = getVerticalFadingEdgeLength();
        final int topSelectionPixel = getTopSelectionPixel(childrenTop, fadingEdgeLength, rowStart);
        final View sel = makeRow(mStackFromBottom ? rowEnd : rowStart, topSelectionPixel, true);
        mFirstPosition = rowStart;
        final View referenceView = mReferenceView;
    if(!mStackFromBottom)        
        {
            fillDown(rowStart + numColumns, referenceView.getBottom() + verticalSpacing);
            pinToBottom(childrenBottom);
            fillUp(rowStart - numColumns, referenceView.getTop() - verticalSpacing);
            adjustViewsUpOrDown();
        } //End block
        else
        {
            final int bottomSelectionPixel = getBottomSelectionPixel(childrenBottom,
                    fadingEdgeLength, numColumns, rowStart);
            final int offset = bottomSelectionPixel - referenceView.getBottom();
            offsetChildrenTopAndBottom(offset);
            fillUp(rowStart - 1, referenceView.getTop() - verticalSpacing);
            pinToTop(childrenTop);
            fillDown(rowEnd + numColumns, referenceView.getBottom() + verticalSpacing);
            adjustViewsUpOrDown();
        } //End block
View var7B839F21D0245BE275F8017F44DD4441_873808537 =         sel;
        var7B839F21D0245BE275F8017F44DD4441_873808537.addTaint(taint);
        return var7B839F21D0245BE275F8017F44DD4441_873808537;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.515 -0400", hash_original_method = "535BA4E594C209A488B214DB13AE774F", hash_generated_method = "BDB1F94EE6F59E21910186FB9574C923")
    private void pinToTop(int childrenTop) {
        addTaint(childrenTop);
    if(mFirstPosition == 0)        
        {
            final int top = getChildAt(0).getTop();
            final int offset = childrenTop - top;
    if(offset < 0)            
            {
                offsetChildrenTopAndBottom(offset);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mFirstPosition == 0) {
            //final int top = getChildAt(0).getTop();
            //final int offset = childrenTop - top;
            //if (offset < 0) {
                //offsetChildrenTopAndBottom(offset);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.516 -0400", hash_original_method = "554B5C3A9DEE69BDD0B0F70052D29046", hash_generated_method = "5DE8813A6CFB2660C7D790230AC35F53")
    private void pinToBottom(int childrenBottom) {
        addTaint(childrenBottom);
        final int count = getChildCount();
    if(mFirstPosition + count == mItemCount)        
        {
            final int bottom = getChildAt(count - 1).getBottom();
            final int offset = childrenBottom - bottom;
    if(offset > 0)            
            {
                offsetChildrenTopAndBottom(offset);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //final int count = getChildCount();
        //if (mFirstPosition + count == mItemCount) {
            //final int bottom = getChildAt(count - 1).getBottom();
            //final int offset = childrenBottom - bottom;
            //if (offset > 0) {
                //offsetChildrenTopAndBottom(offset);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.517 -0400", hash_original_method = "584D06EE6653E11D28AE97D7ADF4C3E4", hash_generated_method = "452A5CAED35F6F512E996A394E1C379B")
    @Override
     int findMotionRow(int y) {
        addTaint(y);
        final int childCount = getChildCount();
    if(childCount > 0)        
        {
            final int numColumns = mNumColumns;
    if(!mStackFromBottom)            
            {
for(int i = 0;i < childCount;i += numColumns)
                {
    if(y <= getChildAt(i).getBottom())                    
                    {
                        int varB4D2F09D0AD5244C9E57B5AF8AB759AE_605371873 = (mFirstPosition + i);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_326237460 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_326237460;
                    } //End block
                } //End block
            } //End block
            else
            {
for(int i = childCount - 1;i >= 0;i -= numColumns)
                {
    if(y >= getChildAt(i).getTop())                    
                    {
                        int varB4D2F09D0AD5244C9E57B5AF8AB759AE_1138041787 = (mFirstPosition + i);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1057442312 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1057442312;
                    } //End block
                } //End block
            } //End block
        } //End block
        int var296D6C732A05FBA51C5854FA7933FE23_692582123 = (INVALID_POSITION);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_768304741 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_768304741;
        // ---------- Original Method ----------
        //final int childCount = getChildCount();
        //if (childCount > 0) {
            //final int numColumns = mNumColumns;
            //if (!mStackFromBottom) {
                //for (int i = 0; i < childCount; i += numColumns) {
                    //if (y <= getChildAt(i).getBottom()) {
                        //return mFirstPosition + i;
                    //}
                //}
            //} else {
                //for (int i = childCount - 1; i >= 0; i -= numColumns) {
                    //if (y >= getChildAt(i).getTop()) {
                        //return mFirstPosition + i;
                    //}
                //}
            //}
        //}
        //return INVALID_POSITION;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.518 -0400", hash_original_method = "2BE5C63CD6BB6072D8C1046433555060", hash_generated_method = "53C3E7E62B08512AD9385C0B9C8A6B87")
    private View fillSpecific(int position, int top) {
        addTaint(top);
        addTaint(position);
        final int numColumns = mNumColumns;
        int motionRowStart;
        int motionRowEnd = -1;
    if(!mStackFromBottom)        
        {
            motionRowStart = position - (position % numColumns);
        } //End block
        else
        {
            final int invertedSelection = mItemCount - 1 - position;
            motionRowEnd = mItemCount - 1 - (invertedSelection - (invertedSelection % numColumns));
            motionRowStart = Math.max(0, motionRowEnd - numColumns + 1);
        } //End block
        final View temp = makeRow(mStackFromBottom ? motionRowEnd : motionRowStart, top, true);
        mFirstPosition = motionRowStart;
        final View referenceView = mReferenceView;
    if(referenceView == null)        
        {
View var540C13E9E156B687226421B24F2DF178_1671334874 =             null;
            var540C13E9E156B687226421B24F2DF178_1671334874.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1671334874;
        } //End block
        final int verticalSpacing = mVerticalSpacing;
        View above;
        View below;
    if(!mStackFromBottom)        
        {
            above = fillUp(motionRowStart - numColumns, referenceView.getTop() - verticalSpacing);
            adjustViewsUpOrDown();
            below = fillDown(motionRowStart + numColumns, referenceView.getBottom() + verticalSpacing);
            final int childCount = getChildCount();
    if(childCount > 0)            
            {
                correctTooHigh(numColumns, verticalSpacing, childCount);
            } //End block
        } //End block
        else
        {
            below = fillDown(motionRowEnd + numColumns, referenceView.getBottom() + verticalSpacing);
            adjustViewsUpOrDown();
            above = fillUp(motionRowStart - 1, referenceView.getTop() - verticalSpacing);
            final int childCount = getChildCount();
    if(childCount > 0)            
            {
                correctTooLow(numColumns, verticalSpacing, childCount);
            } //End block
        } //End block
    if(temp != null)        
        {
View var85AF0530723FAED0F9065F029B9D6041_1683142764 =             temp;
            var85AF0530723FAED0F9065F029B9D6041_1683142764.addTaint(taint);
            return var85AF0530723FAED0F9065F029B9D6041_1683142764;
        } //End block
        else
    if(above != null)        
        {
View varCD3155DFCED4EB61161BED1FF630FDBA_388041583 =             above;
            varCD3155DFCED4EB61161BED1FF630FDBA_388041583.addTaint(taint);
            return varCD3155DFCED4EB61161BED1FF630FDBA_388041583;
        } //End block
        else
        {
View var2F0E8DD6CEEAC90C0D2F6260FE322E29_2059771418 =             below;
            var2F0E8DD6CEEAC90C0D2F6260FE322E29_2059771418.addTaint(taint);
            return var2F0E8DD6CEEAC90C0D2F6260FE322E29_2059771418;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.519 -0400", hash_original_method = "61C0C7B3D4F01380F7804BB62430F50F", hash_generated_method = "9D4F8BE31322A3C9A5D969A9C7DE2E41")
    private void correctTooHigh(int numColumns, int verticalSpacing, int childCount) {
        addTaint(childCount);
        addTaint(verticalSpacing);
        addTaint(numColumns);
        final int lastPosition = mFirstPosition + childCount - 1;
    if(lastPosition == mItemCount - 1 && childCount > 0)        
        {
            final View lastChild = getChildAt(childCount - 1);
            final int lastBottom = lastChild.getBottom();
            final int end = (mBottom - mTop) - mListPadding.bottom;
            int bottomOffset = end - lastBottom;
            final View firstChild = getChildAt(0);
            final int firstTop = firstChild.getTop();
    if(bottomOffset > 0 && (mFirstPosition > 0 || firstTop < mListPadding.top))            
            {
    if(mFirstPosition == 0)                
                {
                    bottomOffset = Math.min(bottomOffset, mListPadding.top - firstTop);
                } //End block
                offsetChildrenTopAndBottom(bottomOffset);
    if(mFirstPosition > 0)                
                {
                    fillUp(mFirstPosition - (mStackFromBottom ? 1 : numColumns),
                            firstChild.getTop() - verticalSpacing);
                    adjustViewsUpOrDown();
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.520 -0400", hash_original_method = "C582B4D472853F3118C6A87E3BA2D3CE", hash_generated_method = "6E238BF7C99DFF1F30656005ACA29E77")
    private void correctTooLow(int numColumns, int verticalSpacing, int childCount) {
        addTaint(childCount);
        addTaint(verticalSpacing);
        addTaint(numColumns);
    if(mFirstPosition == 0 && childCount > 0)        
        {
            final View firstChild = getChildAt(0);
            final int firstTop = firstChild.getTop();
            final int start = mListPadding.top;
            final int end = (mBottom - mTop) - mListPadding.bottom;
            int topOffset = firstTop - start;
            final View lastChild = getChildAt(childCount - 1);
            final int lastBottom = lastChild.getBottom();
            final int lastPosition = mFirstPosition + childCount - 1;
    if(topOffset > 0 && (lastPosition < mItemCount - 1 || lastBottom > end))            
            {
    if(lastPosition == mItemCount - 1)                
                {
                    topOffset = Math.min(topOffset, lastBottom - end);
                } //End block
                offsetChildrenTopAndBottom(-topOffset);
    if(lastPosition < mItemCount - 1)                
                {
                    fillDown(lastPosition + (!mStackFromBottom ? 1 : numColumns),
                            lastChild.getBottom() + verticalSpacing);
                    adjustViewsUpOrDown();
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.521 -0400", hash_original_method = "AC707126EF44BD77373D761D306CE415", hash_generated_method = "9BFDF62A7819FA35FF1E56CC1AE086D3")
    private View fillFromSelection(int selectedTop, int childrenTop, int childrenBottom) {
        addTaint(childrenBottom);
        addTaint(childrenTop);
        addTaint(selectedTop);
        final int fadingEdgeLength = getVerticalFadingEdgeLength();
        final int selectedPosition = mSelectedPosition;
        final int numColumns = mNumColumns;
        final int verticalSpacing = mVerticalSpacing;
        int rowStart;
        int rowEnd = -1;
    if(!mStackFromBottom)        
        {
            rowStart = selectedPosition - (selectedPosition % numColumns);
        } //End block
        else
        {
            int invertedSelection = mItemCount - 1 - selectedPosition;
            rowEnd = mItemCount - 1 - (invertedSelection - (invertedSelection % numColumns));
            rowStart = Math.max(0, rowEnd - numColumns + 1);
        } //End block
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
    if(!mStackFromBottom)        
        {
            fillUp(rowStart - numColumns, referenceView.getTop() - verticalSpacing);
            adjustViewsUpOrDown();
            fillDown(rowStart + numColumns, referenceView.getBottom() + verticalSpacing);
        } //End block
        else
        {
            fillDown(rowEnd + numColumns, referenceView.getBottom() + verticalSpacing);
            adjustViewsUpOrDown();
            fillUp(rowStart - 1, referenceView.getTop() - verticalSpacing);
        } //End block
View var7B839F21D0245BE275F8017F44DD4441_33947314 =         sel;
        var7B839F21D0245BE275F8017F44DD4441_33947314.addTaint(taint);
        return var7B839F21D0245BE275F8017F44DD4441_33947314;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.522 -0400", hash_original_method = "3B93521E4F8B514C6E0E966E64E45808", hash_generated_method = "BBF1E790E1411C8D353BC548D7792598")
    private int getBottomSelectionPixel(int childrenBottom, int fadingEdgeLength,
            int numColumns, int rowStart) {
        addTaint(rowStart);
        addTaint(numColumns);
        addTaint(fadingEdgeLength);
        addTaint(childrenBottom);
        int bottomSelectionPixel = childrenBottom;
    if(rowStart + numColumns - 1 < mItemCount - 1)        
        {
            bottomSelectionPixel -= fadingEdgeLength;
        } //End block
        int var8C1BAEE08BF7BBE553C84235F7A5E3D8_1164199446 = (bottomSelectionPixel);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_464909078 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_464909078;
        // ---------- Original Method ----------
        //int bottomSelectionPixel = childrenBottom;
        //if (rowStart + numColumns - 1 < mItemCount - 1) {
            //bottomSelectionPixel -= fadingEdgeLength;
        //}
        //return bottomSelectionPixel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.522 -0400", hash_original_method = "D0A32123B024D3BD3B829FD608C467F8", hash_generated_method = "F76AF681FC47C642CA462F568BC24C95")
    private int getTopSelectionPixel(int childrenTop, int fadingEdgeLength, int rowStart) {
        addTaint(rowStart);
        addTaint(fadingEdgeLength);
        addTaint(childrenTop);
        int topSelectionPixel = childrenTop;
    if(rowStart > 0)        
        {
            topSelectionPixel += fadingEdgeLength;
        } //End block
        int var9B1B38FE46FCA5DD3FBB400FF9DA31B9_1650190503 = (topSelectionPixel);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1765592100 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1765592100;
        // ---------- Original Method ----------
        //int topSelectionPixel = childrenTop;
        //if (rowStart > 0) {
            //topSelectionPixel += fadingEdgeLength;
        //}
        //return topSelectionPixel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.523 -0400", hash_original_method = "683433A1D2226A93C6C052E4367B337E", hash_generated_method = "27F6419AA3C2D4101663C980DA14D6CA")
    private void adjustForBottomFadingEdge(View childInSelectedRow,
            int topSelectionPixel, int bottomSelectionPixel) {
        addTaint(bottomSelectionPixel);
        addTaint(topSelectionPixel);
        addTaint(childInSelectedRow.getTaint());
    if(childInSelectedRow.getBottom() > bottomSelectionPixel)        
        {
            int spaceAbove = childInSelectedRow.getTop() - topSelectionPixel;
            int spaceBelow = childInSelectedRow.getBottom() - bottomSelectionPixel;
            int offset = Math.min(spaceAbove, spaceBelow);
            offsetChildrenTopAndBottom(-offset);
        } //End block
        // ---------- Original Method ----------
        //if (childInSelectedRow.getBottom() > bottomSelectionPixel) {
            //int spaceAbove = childInSelectedRow.getTop() - topSelectionPixel;
            //int spaceBelow = childInSelectedRow.getBottom() - bottomSelectionPixel;
            //int offset = Math.min(spaceAbove, spaceBelow);
            //offsetChildrenTopAndBottom(-offset);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.523 -0400", hash_original_method = "E9E54F71CD8326C8AF2C780315CD689D", hash_generated_method = "9D027445A4AA270459F47B17617A7921")
    private void adjustForTopFadingEdge(View childInSelectedRow,
            int topSelectionPixel, int bottomSelectionPixel) {
        addTaint(bottomSelectionPixel);
        addTaint(topSelectionPixel);
        addTaint(childInSelectedRow.getTaint());
    if(childInSelectedRow.getTop() < topSelectionPixel)        
        {
            int spaceAbove = topSelectionPixel - childInSelectedRow.getTop();
            int spaceBelow = bottomSelectionPixel - childInSelectedRow.getBottom();
            int offset = Math.min(spaceAbove, spaceBelow);
            offsetChildrenTopAndBottom(offset);
        } //End block
        // ---------- Original Method ----------
        //if (childInSelectedRow.getTop() < topSelectionPixel) {
            //int spaceAbove = topSelectionPixel - childInSelectedRow.getTop();
            //int spaceBelow = bottomSelectionPixel - childInSelectedRow.getBottom();
            //int offset = Math.min(spaceAbove, spaceBelow);
            //offsetChildrenTopAndBottom(offset);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.524 -0400", hash_original_method = "19B54E9E42F50C19B80602093C26BC32", hash_generated_method = "13D89CD9CDD5D76B097C78A9C6F471D8")
    @android.view.RemotableViewMethod
    public void smoothScrollToPosition(int position) {
        addTaint(position);
        super.smoothScrollToPosition(position);
        // ---------- Original Method ----------
        //super.smoothScrollToPosition(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.524 -0400", hash_original_method = "9A2E566018459C8A4F9FE2F49DBB98B8", hash_generated_method = "3F9C88E5F8435EC02B22E53B890AC667")
    @android.view.RemotableViewMethod
    public void smoothScrollByOffset(int offset) {
        addTaint(offset);
        super.smoothScrollByOffset(offset);
        // ---------- Original Method ----------
        //super.smoothScrollByOffset(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.527 -0400", hash_original_method = "55F676D436FF1EC67ECC1C028E81ED27", hash_generated_method = "7B954DA38A021F0C0A18BF3A2ACE005F")
    private View moveSelection(int delta, int childrenTop, int childrenBottom) {
        addTaint(childrenBottom);
        addTaint(childrenTop);
        addTaint(delta);
        final int fadingEdgeLength = getVerticalFadingEdgeLength();
        final int selectedPosition = mSelectedPosition;
        final int numColumns = mNumColumns;
        final int verticalSpacing = mVerticalSpacing;
        int oldRowStart;
        int rowStart;
        int rowEnd = -1;
    if(!mStackFromBottom)        
        {
            oldRowStart = (selectedPosition - delta) - ((selectedPosition - delta) % numColumns);
            rowStart = selectedPosition - (selectedPosition % numColumns);
        } //End block
        else
        {
            int invertedSelection = mItemCount - 1 - selectedPosition;
            rowEnd = mItemCount - 1 - (invertedSelection - (invertedSelection % numColumns));
            rowStart = Math.max(0, rowEnd - numColumns + 1);
            invertedSelection = mItemCount - 1 - (selectedPosition - delta);
            oldRowStart = mItemCount - 1 - (invertedSelection - (invertedSelection % numColumns));
            oldRowStart = Math.max(0, oldRowStart - numColumns + 1);
        } //End block
        final int rowDelta = rowStart - oldRowStart;
        final int topSelectionPixel = getTopSelectionPixel(childrenTop, fadingEdgeLength, rowStart);
        final int bottomSelectionPixel = getBottomSelectionPixel(childrenBottom, fadingEdgeLength,
                numColumns, rowStart);
        mFirstPosition = rowStart;
        View sel;
        View referenceView;
    if(rowDelta > 0)        
        {
            final int oldBottom = mReferenceViewInSelectedRow == null ? 0 :
                    mReferenceViewInSelectedRow.getBottom();
            sel = makeRow(mStackFromBottom ? rowEnd : rowStart, oldBottom + verticalSpacing, true);
            referenceView = mReferenceView;
            adjustForBottomFadingEdge(referenceView, topSelectionPixel, bottomSelectionPixel);
        } //End block
        else
    if(rowDelta < 0)        
        {
            final int oldTop = mReferenceViewInSelectedRow == null ?
                    0 : mReferenceViewInSelectedRow .getTop();
            sel = makeRow(mStackFromBottom ? rowEnd : rowStart, oldTop - verticalSpacing, false);
            referenceView = mReferenceView;
            adjustForTopFadingEdge(referenceView, topSelectionPixel, bottomSelectionPixel);
        } //End block
        else
        {
            final int oldTop = mReferenceViewInSelectedRow == null ?
                    0 : mReferenceViewInSelectedRow .getTop();
            sel = makeRow(mStackFromBottom ? rowEnd : rowStart, oldTop, true);
            referenceView = mReferenceView;
        } //End block
    if(!mStackFromBottom)        
        {
            fillUp(rowStart - numColumns, referenceView.getTop() - verticalSpacing);
            adjustViewsUpOrDown();
            fillDown(rowStart + numColumns, referenceView.getBottom() + verticalSpacing);
        } //End block
        else
        {
            fillDown(rowEnd + numColumns, referenceView.getBottom() + verticalSpacing);
            adjustViewsUpOrDown();
            fillUp(rowStart - 1, referenceView.getTop() - verticalSpacing);
        } //End block
View var7B839F21D0245BE275F8017F44DD4441_319328580 =         sel;
        var7B839F21D0245BE275F8017F44DD4441_319328580.addTaint(taint);
        return var7B839F21D0245BE275F8017F44DD4441_319328580;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.529 -0400", hash_original_method = "971C7C8872B1F8EEBA5FB107FC6F8364", hash_generated_method = "9AFB77F8E43DA3E545973A6957607FBC")
    private boolean determineColumns(int availableSpace) {
        final int requestedHorizontalSpacing = mRequestedHorizontalSpacing;
        final int stretchMode = mStretchMode;
        final int requestedColumnWidth = mRequestedColumnWidth;
        boolean didNotInitiallyFit = false;
    if(mRequestedNumColumns == AUTO_FIT)        
        {
    if(requestedColumnWidth > 0)            
            {
                mNumColumns = (availableSpace + requestedHorizontalSpacing) /
                        (requestedColumnWidth + requestedHorizontalSpacing);
            } //End block
            else
            {
                mNumColumns = 2;
            } //End block
        } //End block
        else
        {
            mNumColumns = mRequestedNumColumns;
        } //End block
    if(mNumColumns <= 0)        
        {
            mNumColumns = 1;
        } //End block
switch(stretchMode){
        case NO_STRETCH:
        mColumnWidth = requestedColumnWidth;
        mHorizontalSpacing = requestedHorizontalSpacing;
        break;
        default:
        int spaceLeftOver = availableSpace - (mNumColumns * requestedColumnWidth) -
                    ((mNumColumns - 1) * requestedHorizontalSpacing);
    if(spaceLeftOver < 0)        
        {
            didNotInitiallyFit = true;
        } //End block
switch(stretchMode){
        case STRETCH_COLUMN_WIDTH:
        mColumnWidth = requestedColumnWidth + spaceLeftOver / mNumColumns;
        mHorizontalSpacing = requestedHorizontalSpacing;
        break;
        case STRETCH_SPACING:
        mColumnWidth = requestedColumnWidth;
    if(mNumColumns > 1)        
        {
            mHorizontalSpacing = requestedHorizontalSpacing + 
                        spaceLeftOver / (mNumColumns - 1);
        } //End block
        else
        {
            mHorizontalSpacing = requestedHorizontalSpacing + spaceLeftOver;
        } //End block
        break;
        case STRETCH_SPACING_UNIFORM:
        mColumnWidth = requestedColumnWidth;
    if(mNumColumns > 1)        
        {
            mHorizontalSpacing = requestedHorizontalSpacing + 
                        spaceLeftOver / (mNumColumns + 1);
        } //End block
        else
        {
            mHorizontalSpacing = requestedHorizontalSpacing + spaceLeftOver;
        } //End block
        break;
}        break;
}        boolean var2BD242B1C363F4BFB823FD7C70B8F10A_1309785927 = (didNotInitiallyFit);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_519458509 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_519458509;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.532 -0400", hash_original_method = "DE2B2122B3B8477B4CE53B0961FAB462", hash_generated_method = "AE0E1CEA61A98D89298EB2A83C8813BE")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
    if(widthMode == MeasureSpec.UNSPECIFIED)        
        {
    if(mColumnWidth > 0)            
            {
                widthSize = mColumnWidth + mListPadding.left + mListPadding.right;
            } //End block
            else
            {
                widthSize = mListPadding.left + mListPadding.right;
            } //End block
            widthSize += getVerticalScrollbarWidth();
        } //End block
        int childWidth = widthSize - mListPadding.left - mListPadding.right;
        boolean didNotInitiallyFit = determineColumns(childWidth);
        int childHeight = 0;
        int childState = 0;
        mItemCount = mAdapter == null ? 0 : mAdapter.getCount();
        final int count = mItemCount;
    if(count > 0)        
        {
            final View child = obtainView(0, mIsScrap);
            AbsListView.LayoutParams p = (AbsListView.LayoutParams)child.getLayoutParams();
    if(p == null)            
            {
                p = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, 0);
                child.setLayoutParams(p);
            } //End block
            p.viewType = mAdapter.getItemViewType(0);
            p.forceAdd = true;
            int childHeightSpec = getChildMeasureSpec(
                    MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED), 0, p.height);
            int childWidthSpec = getChildMeasureSpec(
                    MeasureSpec.makeMeasureSpec(mColumnWidth, MeasureSpec.EXACTLY), 0, p.width);
            child.measure(childWidthSpec, childHeightSpec);
            childHeight = child.getMeasuredHeight();
            childState = combineMeasuredStates(childState, child.getMeasuredState());
    if(mRecycler.shouldRecycleViewType(p.viewType))            
            {
                mRecycler.addScrapView(child, -1);
            } //End block
        } //End block
    if(heightMode == MeasureSpec.UNSPECIFIED)        
        {
            heightSize = mListPadding.top + mListPadding.bottom + childHeight +
                    getVerticalFadingEdgeLength() * 2;
        } //End block
    if(heightMode == MeasureSpec.AT_MOST)        
        {
            int ourSize = mListPadding.top + mListPadding.bottom;
            final int numColumns = mNumColumns;
for(int i = 0;i < count;i += numColumns)
            {
                ourSize += childHeight;
    if(i + numColumns < count)                
                {
                    ourSize += mVerticalSpacing;
                } //End block
    if(ourSize >= heightSize)                
                {
                    ourSize = heightSize;
                    break;
                } //End block
            } //End block
            heightSize = ourSize;
        } //End block
    if(widthMode == MeasureSpec.AT_MOST && mRequestedNumColumns != AUTO_FIT)        
        {
            int ourSize = (mRequestedNumColumns*mColumnWidth)
                    + ((mRequestedNumColumns-1)*mHorizontalSpacing)
                    + mListPadding.left + mListPadding.right;
    if(ourSize > widthSize || didNotInitiallyFit)            
            {
                widthSize |= MEASURED_STATE_TOO_SMALL;
            } //End block
        } //End block
        setMeasuredDimension(widthSize, heightSize);
        mWidthMeasureSpec = widthMeasureSpec;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.534 -0400", hash_original_method = "B083102DF451B0F743637B4C2ECFBD00", hash_generated_method = "5E27CFE091CC3840FC4DB29E4CFBCDB8")
    @Override
    protected void attachLayoutAnimationParameters(View child,
            ViewGroup.LayoutParams params, int index, int count) {
        addTaint(count);
        addTaint(index);
        addTaint(params.getTaint());
        addTaint(child.getTaint());
        GridLayoutAnimationController.AnimationParameters animationParams = (GridLayoutAnimationController.AnimationParameters) params.layoutAnimationParameters;
    if(animationParams == null)        
        {
            animationParams = new GridLayoutAnimationController.AnimationParameters();
            params.layoutAnimationParameters = animationParams;
        } //End block
        animationParams.count = count;
        animationParams.index = index;
        animationParams.columnsCount = mNumColumns;
        animationParams.rowsCount = count / mNumColumns;
    if(!mStackFromBottom)        
        {
            animationParams.column = index % mNumColumns;
            animationParams.row = index / mNumColumns;
        } //End block
        else
        {
            final int invertedIndex = count - 1 - index;
            animationParams.column = mNumColumns - 1 - (invertedIndex % mNumColumns);
            animationParams.row = animationParams.rowsCount - 1 - invertedIndex / mNumColumns;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.540 -0400", hash_original_method = "22970971C8FD1FE9524617A911939C41", hash_generated_method = "ED0AD9F99E2F1D92620941BDA3C89DC2")
    @Override
    protected void layoutChildren() {
        final boolean blockLayoutRequests = mBlockLayoutRequests;
    if(!blockLayoutRequests)        
        {
            mBlockLayoutRequests = true;
        } //End block
        try 
        {
            super.layoutChildren();
            invalidate();
    if(mAdapter == null)            
            {
                resetList();
                invokeOnItemScrollListener();
                return;
            } //End block
            final int childrenTop = mListPadding.top;
            final int childrenBottom = mBottom - mTop - mListPadding.bottom;
            int childCount = getChildCount();
            int index;
            int delta = 0;
            View sel;
            View oldSel = null;
            View oldFirst = null;
            View newSel = null;
switch(mLayoutMode){
            case LAYOUT_SET_SELECTION:
            index = mNextSelectedPosition - mFirstPosition;
    if(index >= 0 && index < childCount)            
            {
                newSel = getChildAt(index);
            } //End block
            break;
            case LAYOUT_FORCE_TOP:
            case LAYOUT_FORCE_BOTTOM:
            case LAYOUT_SPECIFIC:
            case LAYOUT_SYNC:
            break;
            case LAYOUT_MOVE_SELECTION:
    if(mNextSelectedPosition >= 0)            
            {
                delta = mNextSelectedPosition - mSelectedPosition;
            } //End block
            break;
            default:
            index = mSelectedPosition - mFirstPosition;
    if(index >= 0 && index < childCount)            
            {
                oldSel = getChildAt(index);
            } //End block
            oldFirst = getChildAt(0);
}            boolean dataChanged = mDataChanged;
    if(dataChanged)            
            {
                handleDataChanged();
            } //End block
    if(mItemCount == 0)            
            {
                resetList();
                invokeOnItemScrollListener();
                return;
            } //End block
            setSelectedPositionInt(mNextSelectedPosition);
            final int firstPosition = mFirstPosition;
            final RecycleBin recycleBin = mRecycler;
    if(dataChanged)            
            {
for(int i = 0;i < childCount;i++)
                {
                    recycleBin.addScrapView(getChildAt(i), firstPosition+i);
                } //End block
            } //End block
            else
            {
                recycleBin.fillActiveViews(childCount, firstPosition);
            } //End block
            detachAllViewsFromParent();
switch(mLayoutMode){
            case LAYOUT_SET_SELECTION:
    if(newSel != null)            
            {
                sel = fillFromSelection(newSel.getTop(), childrenTop, childrenBottom);
            } //End block
            else
            {
                sel = fillSelection(childrenTop, childrenBottom);
            } //End block
            break;
            case LAYOUT_FORCE_TOP:
            mFirstPosition = 0;
            sel = fillFromTop(childrenTop);
            adjustViewsUpOrDown();
            break;
            case LAYOUT_FORCE_BOTTOM:
            sel = fillUp(mItemCount - 1, childrenBottom);
            adjustViewsUpOrDown();
            break;
            case LAYOUT_SPECIFIC:
            sel = fillSpecific(mSelectedPosition, mSpecificTop);
            break;
            case LAYOUT_SYNC:
            sel = fillSpecific(mSyncPosition, mSpecificTop);
            break;
            case LAYOUT_MOVE_SELECTION:
            sel = moveSelection(delta, childrenTop, childrenBottom);
            break;
            default:
    if(childCount == 0)            
            {
    if(!mStackFromBottom)                
                {
                    setSelectedPositionInt(mAdapter == null || isInTouchMode() ?
                                INVALID_POSITION : 0);
                    sel = fillFromTop(childrenTop);
                } //End block
                else
                {
                    final int last = mItemCount - 1;
                    setSelectedPositionInt(mAdapter == null || isInTouchMode() ?
                                INVALID_POSITION : last);
                    sel = fillFromBottom(last, childrenBottom);
                } //End block
            } //End block
            else
            {
    if(mSelectedPosition >= 0 && mSelectedPosition < mItemCount)                
                {
                    sel = fillSpecific(mSelectedPosition, oldSel == null ?
                                childrenTop : oldSel.getTop());
                } //End block
                else
    if(mFirstPosition < mItemCount)                
                {
                    sel = fillSpecific(mFirstPosition, oldFirst == null ?
                                childrenTop : oldFirst.getTop());
                } //End block
                else
                {
                    sel = fillSpecific(0, childrenTop);
                } //End block
            } //End block
            break;
}            recycleBin.scrapActiveViews();
    if(sel != null)            
            {
                positionSelector(INVALID_POSITION, sel);
                mSelectedTop = sel.getTop();
            } //End block
            else
    if(mTouchMode > TOUCH_MODE_DOWN && mTouchMode < TOUCH_MODE_SCROLL)            
            {
                View child = getChildAt(mMotionPosition - mFirstPosition);
    if(child != null)                
                positionSelector(mMotionPosition, child);
            } //End block
            else
            {
                mSelectedTop = 0;
                mSelectorRect.setEmpty();
            } //End block
            mLayoutMode = LAYOUT_NORMAL;
            mDataChanged = false;
            mNeedSync = false;
            setNextSelectedPositionInt(mSelectedPosition);
            updateScrollIndicators();
    if(mItemCount > 0)            
            {
                checkSelectionChanged();
            } //End block
            invokeOnItemScrollListener();
        } //End block
        finally 
        {
    if(!blockLayoutRequests)            
            {
                mBlockLayoutRequests = false;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.542 -0400", hash_original_method = "D1571833DCBC36BAA4E4DA8F2A5DB363", hash_generated_method = "90822BD03850B6693FE609E9943B4E1E")
    private View makeAndAddView(int position, int y, boolean flow, int childrenLeft,
            boolean selected, int where) {
        addTaint(where);
        addTaint(selected);
        addTaint(childrenLeft);
        addTaint(flow);
        addTaint(y);
        addTaint(position);
        View child;
    if(!mDataChanged)        
        {
            child = mRecycler.getActiveView(position);
    if(child != null)            
            {
                setupChild(child, position, y, flow, childrenLeft, selected, true, where);
View var73902FD3E151130B4329B76EF04D2A54_47144564 =                 child;
                var73902FD3E151130B4329B76EF04D2A54_47144564.addTaint(taint);
                return var73902FD3E151130B4329B76EF04D2A54_47144564;
            } //End block
        } //End block
        child = obtainView(position, mIsScrap);
        setupChild(child, position, y, flow, childrenLeft, selected, mIsScrap[0], where);
View var73902FD3E151130B4329B76EF04D2A54_764665500 =         child;
        var73902FD3E151130B4329B76EF04D2A54_764665500.addTaint(taint);
        return var73902FD3E151130B4329B76EF04D2A54_764665500;
        // ---------- Original Method ----------
        //View child;
        //if (!mDataChanged) {
            //child = mRecycler.getActiveView(position);
            //if (child != null) {
                //setupChild(child, position, y, flow, childrenLeft, selected, true, where);
                //return child;
            //}
        //}
        //child = obtainView(position, mIsScrap);
        //setupChild(child, position, y, flow, childrenLeft, selected, mIsScrap[0], where);
        //return child;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.544 -0400", hash_original_method = "F1D84EEF4E6902A923E61B402C707D18", hash_generated_method = "D153C9658BDAA0A897BF386B18FE08C9")
    private void setupChild(View child, int position, int y, boolean flow, int childrenLeft,
            boolean selected, boolean recycled, int where) {
        addTaint(where);
        addTaint(recycled);
        addTaint(selected);
        addTaint(childrenLeft);
        addTaint(flow);
        addTaint(y);
        addTaint(position);
        addTaint(child.getTaint());
        boolean isSelected = selected && shouldShowSelector();
        final boolean updateChildSelected = isSelected != child.isSelected();
        final int mode = mTouchMode;
        final boolean isPressed = mode > TOUCH_MODE_DOWN && mode < TOUCH_MODE_SCROLL &&
                mMotionPosition == position;
        final boolean updateChildPressed = isPressed != child.isPressed();
        boolean needToMeasure = !recycled || updateChildSelected || child.isLayoutRequested();
        AbsListView.LayoutParams p = (AbsListView.LayoutParams)child.getLayoutParams();
    if(p == null)        
        {
            p = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, 0);
        } //End block
        p.viewType = mAdapter.getItemViewType(position);
    if(recycled && !p.forceAdd)        
        {
            attachViewToParent(child, where, p);
        } //End block
        else
        {
            p.forceAdd = false;
            addViewInLayout(child, where, p, true);
        } //End block
    if(updateChildSelected)        
        {
            child.setSelected(isSelected);
    if(isSelected)            
            {
                requestFocus();
            } //End block
        } //End block
    if(updateChildPressed)        
        {
            child.setPressed(isPressed);
        } //End block
    if(mChoiceMode != CHOICE_MODE_NONE && mCheckStates != null)        
        {
    if(child instanceof Checkable)            
            {
                ((Checkable) child).setChecked(mCheckStates.get(position));
            } //End block
            else
    if(getContext().getApplicationInfo().targetSdkVersion
                    >= android.os.Build.VERSION_CODES.HONEYCOMB)            
            {
                child.setActivated(mCheckStates.get(position));
            } //End block
        } //End block
    if(needToMeasure)        
        {
            int childHeightSpec = ViewGroup.getChildMeasureSpec(
                    MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED), 0, p.height);
            int childWidthSpec = ViewGroup.getChildMeasureSpec(
                    MeasureSpec.makeMeasureSpec(mColumnWidth, MeasureSpec.EXACTLY), 0, p.width);
            child.measure(childWidthSpec, childHeightSpec);
        } //End block
        else
        {
            cleanupLayoutState(child);
        } //End block
        final int w = child.getMeasuredWidth();
        final int h = child.getMeasuredHeight();
        int childLeft;
        final int childTop = flow ? y : y - h;
        final int layoutDirection = getResolvedLayoutDirection();
        final int absoluteGravity = Gravity.getAbsoluteGravity(mGravity, layoutDirection);
switch(absoluteGravity & Gravity.HORIZONTAL_GRAVITY_MASK){
        case Gravity.LEFT:
        childLeft = childrenLeft;
        break;
        case Gravity.CENTER_HORIZONTAL:
        childLeft = childrenLeft + ((mColumnWidth - w) / 2);
        break;
        case Gravity.RIGHT:
        childLeft = childrenLeft + mColumnWidth - w;
        break;
        default:
        childLeft = childrenLeft;
        break;
}    if(needToMeasure)        
        {
            final int childRight = childLeft + w;
            final int childBottom = childTop + h;
            child.layout(childLeft, childTop, childRight, childBottom);
        } //End block
        else
        {
            child.offsetLeftAndRight(childLeft - child.getLeft());
            child.offsetTopAndBottom(childTop - child.getTop());
        } //End block
    if(mCachingStarted)        
        {
            child.setDrawingCacheEnabled(true);
        } //End block
    if(recycled && (((AbsListView.LayoutParams)child.getLayoutParams()).scrappedFromPosition)
                != position)        
        {
            child.jumpDrawablesToCurrentState();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.545 -0400", hash_original_method = "F036989DC17B53D064E56E9048AF8088", hash_generated_method = "F1141BD156BB8EAE32B892D196866A9E")
    @Override
    public void setSelection(int position) {
        addTaint(position);
    if(!isInTouchMode())        
        {
            setNextSelectedPositionInt(position);
        } //End block
        else
        {
            mResurrectToPosition = position;
        } //End block
        mLayoutMode = LAYOUT_SET_SELECTION;
        requestLayout();
        // ---------- Original Method ----------
        //if (!isInTouchMode()) {
            //setNextSelectedPositionInt(position);
        //} else {
            //mResurrectToPosition = position;
        //}
        //mLayoutMode = LAYOUT_SET_SELECTION;
        //requestLayout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.545 -0400", hash_original_method = "BFD03D39F54176AB600127B7C1132704", hash_generated_method = "D85582E0D16BCA9BD3A267DCA5A605CB")
    @Override
     void setSelectionInt(int position) {
        addTaint(position);
        int previousSelectedPosition = mNextSelectedPosition;
        setNextSelectedPositionInt(position);
        layoutChildren();
        final int next = mStackFromBottom ? mItemCount - 1  - mNextSelectedPosition : 
            mNextSelectedPosition;
        final int previous = mStackFromBottom ? mItemCount - 1
                - previousSelectedPosition : previousSelectedPosition;
        final int nextRow = next / mNumColumns;
        final int previousRow = previous / mNumColumns;
    if(nextRow != previousRow)        
        {
            awakenScrollBars();
        } //End block
        // ---------- Original Method ----------
        //int previousSelectedPosition = mNextSelectedPosition;
        //setNextSelectedPositionInt(position);
        //layoutChildren();
        //final int next = mStackFromBottom ? mItemCount - 1  - mNextSelectedPosition : 
            //mNextSelectedPosition;
        //final int previous = mStackFromBottom ? mItemCount - 1
                //- previousSelectedPosition : previousSelectedPosition;
        //final int nextRow = next / mNumColumns;
        //final int previousRow = previous / mNumColumns;
        //if (nextRow != previousRow) {
            //awakenScrollBars();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.546 -0400", hash_original_method = "82498D99AFEB0700B1F959E9E9927B59", hash_generated_method = "81D1E76242976B2922D6113588E74204")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        boolean var7EF652CB3ACE03C95ABA8817CA740A6C_1121020242 = (commonKey(keyCode, 1, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_876731656 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_876731656;
        // ---------- Original Method ----------
        //return commonKey(keyCode, 1, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.546 -0400", hash_original_method = "C105EC1B6481173F2A66D1C47882507B", hash_generated_method = "AC1CC37538A1FFE25688B38357795958")
    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(repeatCount);
        addTaint(keyCode);
        boolean var7E22E05ED0529C3D32A81C1D21110D89_2084057745 = (commonKey(keyCode, repeatCount, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_92373702 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_92373702;
        // ---------- Original Method ----------
        //return commonKey(keyCode, repeatCount, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.547 -0400", hash_original_method = "FFB4A1626C41573790F9B17FF23F8A09", hash_generated_method = "EF458CAFEE2C8A29481860945C35FC84")
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        boolean var7EF652CB3ACE03C95ABA8817CA740A6C_517947103 = (commonKey(keyCode, 1, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_192780620 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_192780620;
        // ---------- Original Method ----------
        //return commonKey(keyCode, 1, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.550 -0400", hash_original_method = "91535B300D60431313446AA401FFCFE7", hash_generated_method = "DA5AD3AF39988D776A66547BF6E80AF0")
    private boolean commonKey(int keyCode, int count, KeyEvent event) {
        addTaint(event.getTaint());
        addTaint(count);
        addTaint(keyCode);
    if(mAdapter == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1880891382 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_755034513 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_755034513;
        } //End block
    if(mDataChanged)        
        {
            layoutChildren();
        } //End block
        boolean handled = false;
        int action = event.getAction();
    if(action != KeyEvent.ACTION_UP)        
        {
switch(keyCode){
            case KeyEvent.KEYCODE_DPAD_LEFT:
    if(event.hasNoModifiers())            
            {
                handled = resurrectSelectionIfNeeded() || arrowScroll(FOCUS_LEFT);
            } //End block
            break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
    if(event.hasNoModifiers())            
            {
                handled = resurrectSelectionIfNeeded() || arrowScroll(FOCUS_RIGHT);
            } //End block
            break;
            case KeyEvent.KEYCODE_DPAD_UP:
    if(event.hasNoModifiers())            
            {
                handled = resurrectSelectionIfNeeded() || arrowScroll(FOCUS_UP);
            } //End block
            else
    if(event.hasModifiers(KeyEvent.META_ALT_ON))            
            {
                handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_UP);
            } //End block
            break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
    if(event.hasNoModifiers())            
            {
                handled = resurrectSelectionIfNeeded() || arrowScroll(FOCUS_DOWN);
            } //End block
            else
    if(event.hasModifiers(KeyEvent.META_ALT_ON))            
            {
                handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_DOWN);
            } //End block
            break;
            case KeyEvent.KEYCODE_DPAD_CENTER:
            case KeyEvent.KEYCODE_ENTER:
    if(event.hasNoModifiers())            
            {
                handled = resurrectSelectionIfNeeded();
    if(!handled
                                && event.getRepeatCount() == 0 && getChildCount() > 0)                
                {
                    keyPressed();
                    handled = true;
                } //End block
            } //End block
            break;
            case KeyEvent.KEYCODE_SPACE:
    if(mPopup == null || !mPopup.isShowing())            
            {
    if(event.hasNoModifiers())                
                {
                    handled = resurrectSelectionIfNeeded() || pageScroll(FOCUS_DOWN);
                } //End block
                else
    if(event.hasModifiers(KeyEvent.META_SHIFT_ON))                
                {
                    handled = resurrectSelectionIfNeeded() || pageScroll(FOCUS_UP);
                } //End block
            } //End block
            break;
            case KeyEvent.KEYCODE_PAGE_UP:
    if(event.hasNoModifiers())            
            {
                handled = resurrectSelectionIfNeeded() || pageScroll(FOCUS_UP);
            } //End block
            else
    if(event.hasModifiers(KeyEvent.META_ALT_ON))            
            {
                handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_UP);
            } //End block
            break;
            case KeyEvent.KEYCODE_PAGE_DOWN:
    if(event.hasNoModifiers())            
            {
                handled = resurrectSelectionIfNeeded() || pageScroll(FOCUS_DOWN);
            } //End block
            else
    if(event.hasModifiers(KeyEvent.META_ALT_ON))            
            {
                handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_DOWN);
            } //End block
            break;
            case KeyEvent.KEYCODE_MOVE_HOME:
    if(event.hasNoModifiers())            
            {
                handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_UP);
            } //End block
            break;
            case KeyEvent.KEYCODE_MOVE_END:
    if(event.hasNoModifiers())            
            {
                handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_DOWN);
            } //End block
            break;
            case KeyEvent.KEYCODE_TAB:
    if(false)            
            {
    if(event.hasNoModifiers())                
                {
                    handled = resurrectSelectionIfNeeded()
                                    || sequenceScroll(FOCUS_FORWARD);
                } //End block
                else
    if(event.hasModifiers(KeyEvent.META_SHIFT_ON))                
                {
                    handled = resurrectSelectionIfNeeded()
                                    || sequenceScroll(FOCUS_BACKWARD);
                } //End block
            } //End block
            break;
}
        } //End block
    if(handled)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1565047930 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_39265713 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_39265713;
        } //End block
    if(sendToTextFilter(keyCode, count, event))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_984306967 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1245016069 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1245016069;
        } //End block
switch(action){
        case KeyEvent.ACTION_DOWN:
        boolean var947F0C250323B9F4475E02588E9A9740_717577513 = (super.onKeyDown(keyCode, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1850484530 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1850484530;
        case KeyEvent.ACTION_UP:
        boolean varAD33E8F21A74B923C1A24761EAF2F4A9_2112999127 = (super.onKeyUp(keyCode, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1705753676 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1705753676;
        case KeyEvent.ACTION_MULTIPLE:
        boolean varAE6EFDECB7172A439AD0AFF79E9160E9_686070534 = (super.onKeyMultiple(keyCode, count, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1070435193 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1070435193;
        default:
        boolean var68934A3E9455FA72420237EB05902327_693314865 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_27404638 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_27404638;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.551 -0400", hash_original_method = "7F69D44B4A5B870A2ADF67B34BC1B3FD", hash_generated_method = "2E5E268FDA0F47734E784D826C1AAA4D")
     boolean pageScroll(int direction) {
        addTaint(direction);
        int nextPage = -1;
    if(direction == FOCUS_UP)        
        {
            nextPage = Math.max(0, mSelectedPosition - getChildCount());
        } //End block
        else
    if(direction == FOCUS_DOWN)        
        {
            nextPage = Math.min(mItemCount - 1, mSelectedPosition + getChildCount());
        } //End block
    if(nextPage >= 0)        
        {
            setSelectionInt(nextPage);
            invokeOnItemScrollListener();
            awakenScrollBars();
            boolean varB326B5062B2F0E69046810717534CB09_1825835392 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_660759056 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_660759056;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_150971743 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2035325228 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2035325228;
        // ---------- Original Method ----------
        //int nextPage = -1;
        //if (direction == FOCUS_UP) {
            //nextPage = Math.max(0, mSelectedPosition - getChildCount());
        //} else if (direction == FOCUS_DOWN) {
            //nextPage = Math.min(mItemCount - 1, mSelectedPosition + getChildCount());
        //}
        //if (nextPage >= 0) {
            //setSelectionInt(nextPage);
            //invokeOnItemScrollListener();
            //awakenScrollBars();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.552 -0400", hash_original_method = "8921946161DEF2C387CE09B16F70206C", hash_generated_method = "0A211BBAB319F02D3145FE893B7B37C1")
     boolean fullScroll(int direction) {
        addTaint(direction);
        boolean moved = false;
    if(direction == FOCUS_UP)        
        {
            mLayoutMode = LAYOUT_SET_SELECTION;
            setSelectionInt(0);
            invokeOnItemScrollListener();
            moved = true;
        } //End block
        else
    if(direction == FOCUS_DOWN)        
        {
            mLayoutMode = LAYOUT_SET_SELECTION;
            setSelectionInt(mItemCount - 1);
            invokeOnItemScrollListener();
            moved = true;
        } //End block
    if(moved)        
        {
            awakenScrollBars();
        } //End block
        boolean var11DFD868D93BC2B0E4CE0BEE5756F8B1_1817400971 = (moved);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_12978109 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_12978109;
        // ---------- Original Method ----------
        //boolean moved = false;
        //if (direction == FOCUS_UP) {
            //mLayoutMode = LAYOUT_SET_SELECTION;
            //setSelectionInt(0);
            //invokeOnItemScrollListener();
            //moved = true;
        //} else if (direction == FOCUS_DOWN) {
            //mLayoutMode = LAYOUT_SET_SELECTION;
            //setSelectionInt(mItemCount - 1);
            //invokeOnItemScrollListener();
            //moved = true;
        //}
        //if (moved) {
            //awakenScrollBars();
        //}
        //return moved;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.554 -0400", hash_original_method = "8CD79681F48962D4344E68AA337F0770", hash_generated_method = "CDB32518BC23121E174676DAC374D22F")
     boolean arrowScroll(int direction) {
        addTaint(direction);
        final int selectedPosition = mSelectedPosition;
        final int numColumns = mNumColumns;
        int startOfRowPos;
        int endOfRowPos;
        boolean moved = false;
    if(!mStackFromBottom)        
        {
            startOfRowPos = (selectedPosition / numColumns) * numColumns;
            endOfRowPos = Math.min(startOfRowPos + numColumns - 1, mItemCount - 1);
        } //End block
        else
        {
            final int invertedSelection = mItemCount - 1 - selectedPosition;
            endOfRowPos = mItemCount - 1 - (invertedSelection / numColumns) * numColumns;
            startOfRowPos = Math.max(0, endOfRowPos - numColumns + 1);
        } //End block
switch(direction){
        case FOCUS_UP:
    if(startOfRowPos > 0)        
        {
            mLayoutMode = LAYOUT_MOVE_SELECTION;
            setSelectionInt(Math.max(0, selectedPosition - numColumns));
            moved = true;
        } //End block
        break;
        case FOCUS_DOWN:
    if(endOfRowPos < mItemCount - 1)        
        {
            mLayoutMode = LAYOUT_MOVE_SELECTION;
            setSelectionInt(Math.min(selectedPosition + numColumns, mItemCount - 1));
            moved = true;
        } //End block
        break;
        case FOCUS_LEFT:
    if(selectedPosition > startOfRowPos)        
        {
            mLayoutMode = LAYOUT_MOVE_SELECTION;
            setSelectionInt(Math.max(0, selectedPosition - 1));
            moved = true;
        } //End block
        break;
        case FOCUS_RIGHT:
    if(selectedPosition < endOfRowPos)        
        {
            mLayoutMode = LAYOUT_MOVE_SELECTION;
            setSelectionInt(Math.min(selectedPosition + 1, mItemCount - 1));
            moved = true;
        } //End block
        break;
}    if(moved)        
        {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(direction));
            invokeOnItemScrollListener();
        } //End block
    if(moved)        
        {
            awakenScrollBars();
        } //End block
        boolean var11DFD868D93BC2B0E4CE0BEE5756F8B1_1914437975 = (moved);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1822445137 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1822445137;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.556 -0400", hash_original_method = "3D7E63CDF154AB38FFF5F8515CF699BF", hash_generated_method = "7BF37CE44484A2ED52C7055CF3440122")
     boolean sequenceScroll(int direction) {
        addTaint(direction);
        int selectedPosition = mSelectedPosition;
        int numColumns = mNumColumns;
        int count = mItemCount;
        int startOfRow;
        int endOfRow;
    if(!mStackFromBottom)        
        {
            startOfRow = (selectedPosition / numColumns) * numColumns;
            endOfRow = Math.min(startOfRow + numColumns - 1, count - 1);
        } //End block
        else
        {
            int invertedSelection = count - 1 - selectedPosition;
            endOfRow = count - 1 - (invertedSelection / numColumns) * numColumns;
            startOfRow = Math.max(0, endOfRow - numColumns + 1);
        } //End block
        boolean moved = false;
        boolean showScroll = false;
switch(direction){
        case FOCUS_FORWARD:
    if(selectedPosition < count - 1)        
        {
            mLayoutMode = LAYOUT_MOVE_SELECTION;
            setSelectionInt(selectedPosition + 1);
            moved = true;
            showScroll = selectedPosition == endOfRow;
        } //End block
        break;
        case FOCUS_BACKWARD:
    if(selectedPosition > 0)        
        {
            mLayoutMode = LAYOUT_MOVE_SELECTION;
            setSelectionInt(selectedPosition - 1);
            moved = true;
            showScroll = selectedPosition == startOfRow;
        } //End block
        break;
}    if(moved)        
        {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(direction));
            invokeOnItemScrollListener();
        } //End block
    if(showScroll)        
        {
            awakenScrollBars();
        } //End block
        boolean var11DFD868D93BC2B0E4CE0BEE5756F8B1_1599637262 = (moved);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1281672520 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1281672520;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.558 -0400", hash_original_method = "0FD361D132773200063DCB66E88E964C", hash_generated_method = "5CD468BB4DBE44131B84C97FC2635B2C")
    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(previouslyFocusedRect.getTaint());
        addTaint(direction);
        addTaint(gainFocus);
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        int closestChildIndex = -1;
    if(gainFocus && previouslyFocusedRect != null)        
        {
            previouslyFocusedRect.offset(mScrollX, mScrollY);
            Rect otherRect = mTempRect;
            int minDistance = Integer.MAX_VALUE;
            final int childCount = getChildCount();
for(int i = 0;i < childCount;i++)
            {
    if(!isCandidateSelection(i, direction))                
                {
                    continue;
                } //End block
                final View other = getChildAt(i);
                other.getDrawingRect(otherRect);
                offsetDescendantRectToMyCoords(other, otherRect);
                int distance = getDistance(previouslyFocusedRect, otherRect, direction);
    if(distance < minDistance)                
                {
                    minDistance = distance;
                    closestChildIndex = i;
                } //End block
            } //End block
        } //End block
    if(closestChildIndex >= 0)        
        {
            setSelection(closestChildIndex + mFirstPosition);
        } //End block
        else
        {
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.561 -0400", hash_original_method = "84D213429BEB1496C8F56DF85FD23E87", hash_generated_method = "91D4DFA42758904112CBEE5F9DEDE76E")
    private boolean isCandidateSelection(int childIndex, int direction) {
        addTaint(direction);
        addTaint(childIndex);
        final int count = getChildCount();
        final int invertedIndex = count - 1 - childIndex;
        int rowStart;
        int rowEnd;
    if(!mStackFromBottom)        
        {
            rowStart = childIndex - (childIndex % mNumColumns);
            rowEnd = Math.max(rowStart + mNumColumns - 1, count);
        } //End block
        else
        {
            rowEnd = count - 1 - (invertedIndex - (invertedIndex % mNumColumns));
            rowStart = Math.max(0, rowEnd - mNumColumns + 1);
        } //End block
switch(direction){
        case View.FOCUS_RIGHT:
        boolean varE3C592428323E223764E217BCA45C6F2_231345256 = (childIndex == rowStart);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1336940947 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1336940947;
        case View.FOCUS_DOWN:
        boolean var375663F1B9E9BDE44C192AB430C1C055_1422415049 = (rowStart == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_497945924 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_497945924;
        case View.FOCUS_LEFT:
        boolean varA0487644439B48A879135B570581133E_2139563227 = (childIndex == rowEnd);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_409840584 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_409840584;
        case View.FOCUS_UP:
        boolean var47A27714995EE4AAEBD0BC74AA849F96_1799415857 = (rowEnd == count - 1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_866516435 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_866516435;
        case View.FOCUS_FORWARD:
        boolean var45EB01626CE96943B8627E084C4864CE_188640303 = (childIndex == rowStart && rowStart == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1809625871 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1809625871;
        case View.FOCUS_BACKWARD:
        boolean varDD97749B3A47C4DB260673B17C13355B_545720488 = (childIndex == rowEnd && rowEnd == count - 1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1155472902 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1155472902;
        default:
        IllegalArgumentException var312E8BFCD4DB95BFC9041723CFDD2D20_350293693 = new IllegalArgumentException("direction must be one of "
                        + "{FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, "
                        + "FOCUS_FORWARD, FOCUS_BACKWARD}.");
        var312E8BFCD4DB95BFC9041723CFDD2D20_350293693.addTaint(taint);
        throw var312E8BFCD4DB95BFC9041723CFDD2D20_350293693;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.563 -0400", hash_original_method = "FC2053B842AF8EFA285EBFCDE9A6D098", hash_generated_method = "7651FAE378FCD1C5C8D832C78E53463C")
    public void setGravity(int gravity) {
    if(mGravity != gravity)        
        {
            mGravity = gravity;
            requestLayoutIfNecessary();
        } //End block
        // ---------- Original Method ----------
        //if (mGravity != gravity) {
            //mGravity = gravity;
            //requestLayoutIfNecessary();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.564 -0400", hash_original_method = "F4AD294FF1286508B5C248EDCA212E5B", hash_generated_method = "6AE42A70275DEC4A85D458C27872A426")
    public void setHorizontalSpacing(int horizontalSpacing) {
    if(horizontalSpacing != mRequestedHorizontalSpacing)        
        {
            mRequestedHorizontalSpacing = horizontalSpacing;
            requestLayoutIfNecessary();
        } //End block
        // ---------- Original Method ----------
        //if (horizontalSpacing != mRequestedHorizontalSpacing) {
            //mRequestedHorizontalSpacing = horizontalSpacing;
            //requestLayoutIfNecessary();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.564 -0400", hash_original_method = "18D0FB9D8A0D215DBABAAD70588CEE39", hash_generated_method = "61E99EF7ED5F6001F1AE0694ED7CC815")
    public void setVerticalSpacing(int verticalSpacing) {
    if(verticalSpacing != mVerticalSpacing)        
        {
            mVerticalSpacing = verticalSpacing;
            requestLayoutIfNecessary();
        } //End block
        // ---------- Original Method ----------
        //if (verticalSpacing != mVerticalSpacing) {
            //mVerticalSpacing = verticalSpacing;
            //requestLayoutIfNecessary();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.565 -0400", hash_original_method = "C49A7586B9CFE9BA77F47A780C0C8544", hash_generated_method = "96A230D9BC780121F83A97140C351EE1")
    public void setStretchMode(int stretchMode) {
    if(stretchMode != mStretchMode)        
        {
            mStretchMode = stretchMode;
            requestLayoutIfNecessary();
        } //End block
        // ---------- Original Method ----------
        //if (stretchMode != mStretchMode) {
            //mStretchMode = stretchMode;
            //requestLayoutIfNecessary();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.566 -0400", hash_original_method = "B323AFE5AE5939BBDA58166A4DF4B096", hash_generated_method = "3DFB8D3A9DCB1D562F65DA53E3DD6C6E")
    public int getStretchMode() {
        int var6A66D00918859F42D851F505ADE6AA46_90784199 = (mStretchMode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1041918997 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1041918997;
        // ---------- Original Method ----------
        //return mStretchMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.566 -0400", hash_original_method = "2D3707A47407D7324964709BC50279C2", hash_generated_method = "84786CA15DE1CC9B737C4658EAE1650D")
    public void setColumnWidth(int columnWidth) {
    if(columnWidth != mRequestedColumnWidth)        
        {
            mRequestedColumnWidth = columnWidth;
            requestLayoutIfNecessary();
        } //End block
        // ---------- Original Method ----------
        //if (columnWidth != mRequestedColumnWidth) {
            //mRequestedColumnWidth = columnWidth;
            //requestLayoutIfNecessary();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.567 -0400", hash_original_method = "EB843153C85390AE48F1C91EE0B42CDB", hash_generated_method = "DF909A972746555C83BF1873A671E9EC")
    public void setNumColumns(int numColumns) {
    if(numColumns != mRequestedNumColumns)        
        {
            mRequestedNumColumns = numColumns;
            requestLayoutIfNecessary();
        } //End block
        // ---------- Original Method ----------
        //if (numColumns != mRequestedNumColumns) {
            //mRequestedNumColumns = numColumns;
            //requestLayoutIfNecessary();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.567 -0400", hash_original_method = "B011FDCEBE38F0939F62249D6B5BC711", hash_generated_method = "C4D0B59BEC82536518DAD640B4D7252D")
    @ViewDebug.ExportedProperty
    public int getNumColumns() {
        int var3C11F31A23C7905177BA6A1A74A63160_322570108 = (mNumColumns);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1085182177 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1085182177;
        // ---------- Original Method ----------
        //return mNumColumns;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.569 -0400", hash_original_method = "614329ACA245384517EF28FF3609B04B", hash_generated_method = "C987A8817E39D35B11DFA58E52F09D50")
    private void adjustViewsUpOrDown() {
        final int childCount = getChildCount();
    if(childCount > 0)        
        {
            int delta;
            View child;
    if(!mStackFromBottom)            
            {
                child = getChildAt(0);
                delta = child.getTop() - mListPadding.top;
    if(mFirstPosition != 0)                
                {
                    delta -= mVerticalSpacing;
                } //End block
    if(delta < 0)                
                {
                    delta = 0;
                } //End block
            } //End block
            else
            {
                child = getChildAt(childCount - 1);
                delta = child.getBottom() - (getHeight() - mListPadding.bottom);
    if(mFirstPosition + childCount < mItemCount)                
                {
                    delta += mVerticalSpacing;
                } //End block
    if(delta > 0)                
                {
                    delta = 0;
                } //End block
            } //End block
    if(delta != 0)            
            {
                offsetChildrenTopAndBottom(-delta);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.570 -0400", hash_original_method = "0FB16985DD2A598E66D7882D349B86AF", hash_generated_method = "4D4E88856BD484B600BC9CA3986FC2FA")
    @Override
    protected int computeVerticalScrollExtent() {
        final int count = getChildCount();
    if(count > 0)        
        {
            final int numColumns = mNumColumns;
            final int rowCount = (count + numColumns - 1) / numColumns;
            int extent = rowCount * 100;
            View view = getChildAt(0);
            final int top = view.getTop();
            int height = view.getHeight();
    if(height > 0)            
            {
                extent += (top * 100) / height;
            } //End block
            view = getChildAt(count - 1);
            final int bottom = view.getBottom();
            height = view.getHeight();
    if(height > 0)            
            {
                extent -= ((bottom - getHeight()) * 100) / height;
            } //End block
            int var0793046CD12DB418149C2B688AF9B27F_882145723 = (extent);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1265442092 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1265442092;
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_2098144620 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_77180740 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_77180740;
        // ---------- Original Method ----------
        //final int count = getChildCount();
        //if (count > 0) {
            //final int numColumns = mNumColumns;
            //final int rowCount = (count + numColumns - 1) / numColumns;
            //int extent = rowCount * 100;
            //View view = getChildAt(0);
            //final int top = view.getTop();
            //int height = view.getHeight();
            //if (height > 0) {
                //extent += (top * 100) / height;
            //}
            //view = getChildAt(count - 1);
            //final int bottom = view.getBottom();
            //height = view.getHeight();
            //if (height > 0) {
                //extent -= ((bottom - getHeight()) * 100) / height;
            //}
            //return extent;
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.571 -0400", hash_original_method = "77C851014C1118924C7173C75459421E", hash_generated_method = "CC8063CC75680A67E4B0A43C59877176")
    @Override
    protected int computeVerticalScrollOffset() {
    if(mFirstPosition >= 0 && getChildCount() > 0)        
        {
            final View view = getChildAt(0);
            final int top = view.getTop();
            int height = view.getHeight();
    if(height > 0)            
            {
                final int numColumns = mNumColumns;
                final int whichRow = mFirstPosition / numColumns;
                final int rowCount = (mItemCount + numColumns - 1) / numColumns;
                int varBDB02E367A751F85AB56A797E679B26F_1343720133 = (Math.max(whichRow * 100 - (top * 100) / height +
                        (int) ((float) mScrollY / getHeight() * rowCount * 100), 0));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1917562347 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1917562347;
            } //End block
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_1078781949 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_165155287 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_165155287;
        // ---------- Original Method ----------
        //if (mFirstPosition >= 0 && getChildCount() > 0) {
            //final View view = getChildAt(0);
            //final int top = view.getTop();
            //int height = view.getHeight();
            //if (height > 0) {
                //final int numColumns = mNumColumns;
                //final int whichRow = mFirstPosition / numColumns;
                //final int rowCount = (mItemCount + numColumns - 1) / numColumns;
                //return Math.max(whichRow * 100 - (top * 100) / height +
                        //(int) ((float) mScrollY / getHeight() * rowCount * 100), 0);
            //}
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.571 -0400", hash_original_method = "2E67C9F09804D125789DA130D24F2E03", hash_generated_method = "A0270D3FA6D83E614C90D7AFAED410E2")
    @Override
    protected int computeVerticalScrollRange() {
        final int numColumns = mNumColumns;
        final int rowCount = (mItemCount + numColumns - 1) / numColumns;
        int result = Math.max(rowCount * 100, 0);
    if(mScrollY != 0)        
        {
            result += Math.abs((int) ((float) mScrollY / getHeight() * rowCount * 100));
        } //End block
        int varB4A88417B3D0170D754C647C30B7216A_546708032 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1533179568 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1533179568;
        // ---------- Original Method ----------
        //final int numColumns = mNumColumns;
        //final int rowCount = (mItemCount + numColumns - 1) / numColumns;
        //int result = Math.max(rowCount * 100, 0);
        //if (mScrollY != 0) {
            //result += Math.abs((int) ((float) mScrollY / getHeight() * rowCount * 100));
        //}
        //return result;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.572 -0400", hash_original_field = "3C6C842350FA9DF4AF7C1577C5481D7F", hash_generated_field = "9591D43DFDB00D3CA815C6412336BEEB")

    public static final int NO_STRETCH = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.572 -0400", hash_original_field = "C781279666F1CFCA96E5F3E8F379648C", hash_generated_field = "9E8C93D13663D982A634A608E98FDD9B")

    public static final int STRETCH_SPACING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.572 -0400", hash_original_field = "93F50EC30CD0856C8A19939E9B64DED3", hash_generated_field = "289B7802E2F88C85889BF1B0A565B14F")

    public static final int STRETCH_COLUMN_WIDTH = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.572 -0400", hash_original_field = "321EC49DA83893E4048EDCC856EFEFB3", hash_generated_field = "6D329753C82DAECBEDD98AD073821537")

    public static final int STRETCH_SPACING_UNIFORM = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.572 -0400", hash_original_field = "57174C1594A18EA6304DDA366FEF8B68", hash_generated_field = "4306712C3BDDA946F401316F516F19DA")

    public static final int AUTO_FIT = -1;
}

