package android.widget;

// Droidsafe Imports
import droidsafe.annotations.*;
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





public class GridView extends AbsListView {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.621 -0400", hash_original_field = "47E234C72F8463B7C6770D658A5E41C2", hash_generated_field = "CAA46A02DF073835D5C8346AD9A9CB63")

    private int mNumColumns = AUTO_FIT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.622 -0400", hash_original_field = "984A75716F93CAE1C49F1090E6A0CB2C", hash_generated_field = "E9FAC14F36FB56A0DCAB954B62C2DF2B")

    private int mHorizontalSpacing = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.622 -0400", hash_original_field = "FE80057B725E738FDE5E09E6B3B7F8F2", hash_generated_field = "A39AD23AD5FCB84AB23C237FC706C8F3")

    private int mRequestedHorizontalSpacing;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.622 -0400", hash_original_field = "04A0AE56E019E90823DFCF538F9EB200", hash_generated_field = "84EB60F5A5BD3F778480F01C86BB8AA9")

    private int mVerticalSpacing = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.622 -0400", hash_original_field = "D2D9B35C5FA16AAC3C153C6F6D51079F", hash_generated_field = "AEA63239A963A24EEC1FCFD67B3B96A7")

    private int mStretchMode = STRETCH_COLUMN_WIDTH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.622 -0400", hash_original_field = "E1663A40DA302B5F0D865267D61B180B", hash_generated_field = "20F46DBB58574C7E2F33333D8FE15571")

    private int mColumnWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.622 -0400", hash_original_field = "145243760978B68BCAB5FA8129C172AE", hash_generated_field = "7063064B546DF13BA7FDA901DDEC5780")

    private int mRequestedColumnWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.622 -0400", hash_original_field = "53E8A93614B65E7EB80706CE2B65D07B", hash_generated_field = "583D48FC72E3B18BBAD06B1F4E148F28")

    private int mRequestedNumColumns;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.622 -0400", hash_original_field = "94710AAABC607EA664B744BE97844000", hash_generated_field = "7823B4B6322E0EBEB34297B0E440B23B")

    private View mReferenceView = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.622 -0400", hash_original_field = "5238F9CB997751442CCEC167A710A933", hash_generated_field = "E909A7C80DCAC01F178BEF4C30386FF5")

    private View mReferenceViewInSelectedRow = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.622 -0400", hash_original_field = "32B080F2E8D2B31FD5606656CD48D0F9", hash_generated_field = "B1F879D1C3141C34182BB7A64318C608")

    private int mGravity = Gravity.LEFT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.622 -0400", hash_original_field = "DF43B278CEE8933271AB3D9F9E312F86", hash_generated_field = "A498F2A4744F31D22F9C4ABEBB254F2F")

    private final Rect mTempRect = new Rect();
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.622 -0400", hash_original_method = "6B9AD93D67DF35D03ADA1536C0A58FBF", hash_generated_method = "983C8391566F7BB71FF28D509435B241")
    public  GridView(Context context) {
        super(context);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.623 -0400", hash_original_method = "2A531A248703ACB5E0E1C6A31088A2B2", hash_generated_method = "EEB07A616C5F4990326869DA8C2CA4AF")
    public  GridView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.gridViewStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.660 -0400", hash_original_method = "49F6501DFACF5B2EADDBFC02F7376929", hash_generated_method = "7C7CDE27B7256C7A12014A5C8ADE373F")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.660 -0400", hash_original_method = "0E1A05724C497F45D7FB6AC34C501814", hash_generated_method = "5D943CC5D986BCC71512128291B275EB")
    @Override
    public ListAdapter getAdapter() {
ListAdapter varD72668EDE5E63ADF9340F3D8A19FD205_936201250 =         mAdapter;
        varD72668EDE5E63ADF9340F3D8A19FD205_936201250.addTaint(taint);
        return varD72668EDE5E63ADF9340F3D8A19FD205_936201250;
        // ---------- Original Method ----------
        //return mAdapter;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.660 -0400", hash_original_method = "8AB2C6958FD7CEC3A8A71FE59763D6A4", hash_generated_method = "F411B04A9F1D200E30F181818B8C9DCB")
    @android.view.RemotableViewMethod
    public void setRemoteViewsAdapter(Intent intent) {
        addTaint(intent.getTaint());
        super.setRemoteViewsAdapter(intent);
        // ---------- Original Method ----------
        //super.setRemoteViewsAdapter(intent);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.662 -0400", hash_original_method = "3B0F7EFF2AD6466D19A6F404E2E1BAAD", hash_generated_method = "659411209A2A02CFCA1A09BF8E3B8DF8")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.662 -0400", hash_original_method = "D52FAC74E641441314EFBB7F4E58B879", hash_generated_method = "2C29D1FDB914FE8F1C6FFA7E51C6ADA1")
    @Override
     int lookForSelectablePosition(int position, boolean lookDown) {
        addTaint(lookDown);
        addTaint(position);
        final ListAdapter adapter = mAdapter;
        if(adapter == null || isInTouchMode())        
        {
            int var296D6C732A05FBA51C5854FA7933FE23_393839058 = (INVALID_POSITION);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2102508329 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2102508329;
        } //End block
        if(position < 0 || position >= mItemCount)        
        {
            int var296D6C732A05FBA51C5854FA7933FE23_653700508 = (INVALID_POSITION);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1964835682 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1964835682;
        } //End block
        int var4757FE07FD492A8BE0EA6A760D683D6E_77330949 = (position);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_110135401 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_110135401;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.663 -0400", hash_original_method = "A62E9A831AF61A8CD347891B2F9D44DF", hash_generated_method = "1C16C5B9777022FCAA13A2F48DA29487")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.664 -0400", hash_original_method = "6F9360E73E1EB4E0BD6CC48A029E26CB", hash_generated_method = "AEC2E9E3222D0C760CC8AEDB779EABC6")
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
View var11299FD0AF79690829705998589379E5_1717180454 =         selectedView;
        var11299FD0AF79690829705998589379E5_1717180454.addTaint(taint);
        return var11299FD0AF79690829705998589379E5_1717180454;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.666 -0400", hash_original_method = "DFB797BE7486A81865BE6BA7ABEE8F5A", hash_generated_method = "F058D207C103B522483D38D8F9DED2BA")
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
View var11299FD0AF79690829705998589379E5_1370012853 =         selectedView;
        var11299FD0AF79690829705998589379E5_1370012853.addTaint(taint);
        return var11299FD0AF79690829705998589379E5_1370012853;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.667 -0400", hash_original_method = "0AADB00D4F358179B46AC864F825D76F", hash_generated_method = "2DD7A765ABB0DDDE44225F41215DBE4D")
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
View var11299FD0AF79690829705998589379E5_240796271 =         selectedView;
        var11299FD0AF79690829705998589379E5_240796271.addTaint(taint);
        return var11299FD0AF79690829705998589379E5_240796271;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.667 -0400", hash_original_method = "ECD7EEB642891ACE11FADF160200B8D1", hash_generated_method = "C32227FE76D05473BF1068F8043E5D0E")
    private View fillFromTop(int nextTop) {
        addTaint(nextTop);
        mFirstPosition = Math.min(mFirstPosition, mSelectedPosition);
        mFirstPosition = Math.min(mFirstPosition, mItemCount - 1);
        if(mFirstPosition < 0)        
        {
            mFirstPosition = 0;
        } //End block
        mFirstPosition -= mFirstPosition % mNumColumns;
View var49BCC10837EDABC5CED602D8E493B0B0_957550161 =         fillDown(mFirstPosition, nextTop);
        var49BCC10837EDABC5CED602D8E493B0B0_957550161.addTaint(taint);
        return var49BCC10837EDABC5CED602D8E493B0B0_957550161;
        // ---------- Original Method ----------
        //mFirstPosition = Math.min(mFirstPosition, mSelectedPosition);
        //mFirstPosition = Math.min(mFirstPosition, mItemCount - 1);
        //if (mFirstPosition < 0) {
            //mFirstPosition = 0;
        //}
        //mFirstPosition -= mFirstPosition % mNumColumns;
        //return fillDown(mFirstPosition, nextTop);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.668 -0400", hash_original_method = "0818B9EEFC7CF79A0018AB61F39070C0", hash_generated_method = "61316447221188BBA7871AE83229DCF9")
    private View fillFromBottom(int lastPosition, int nextBottom) {
        addTaint(nextBottom);
        addTaint(lastPosition);
        lastPosition = Math.max(lastPosition, mSelectedPosition);
        lastPosition = Math.min(lastPosition, mItemCount - 1);
        final int invertedPosition = mItemCount - 1 - lastPosition;
        lastPosition = mItemCount - 1 - (invertedPosition - (invertedPosition % mNumColumns));
View var7A713FC2785F6AF8547BE1D5F9426B88_1260687443 =         fillUp(lastPosition, nextBottom);
        var7A713FC2785F6AF8547BE1D5F9426B88_1260687443.addTaint(taint);
        return var7A713FC2785F6AF8547BE1D5F9426B88_1260687443;
        // ---------- Original Method ----------
        //lastPosition = Math.max(lastPosition, mSelectedPosition);
        //lastPosition = Math.min(lastPosition, mItemCount - 1);
        //final int invertedPosition = mItemCount - 1 - lastPosition;
        //lastPosition = mItemCount - 1 - (invertedPosition - (invertedPosition % mNumColumns));
        //return fillUp(lastPosition, nextBottom);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.669 -0400", hash_original_method = "B869E7B5DD0E41AF8A9344426795B32C", hash_generated_method = "2AA8BEA0D076027472CE39EBDB16ED41")
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
View var7B839F21D0245BE275F8017F44DD4441_1334015250 =         sel;
        var7B839F21D0245BE275F8017F44DD4441_1334015250.addTaint(taint);
        return var7B839F21D0245BE275F8017F44DD4441_1334015250;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.670 -0400", hash_original_method = "535BA4E594C209A488B214DB13AE774F", hash_generated_method = "BDB1F94EE6F59E21910186FB9574C923")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.670 -0400", hash_original_method = "554B5C3A9DEE69BDD0B0F70052D29046", hash_generated_method = "5DE8813A6CFB2660C7D790230AC35F53")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.671 -0400", hash_original_method = "584D06EE6653E11D28AE97D7ADF4C3E4", hash_generated_method = "A35B897E51D9810A91EF80B571445B89")
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
                        int varB4D2F09D0AD5244C9E57B5AF8AB759AE_2074194732 = (mFirstPosition + i);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_937714823 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_937714823;
                    } //End block
                } //End block
            } //End block
            else
            {
for(int i = childCount - 1;i >= 0;i -= numColumns)
                {
                    if(y >= getChildAt(i).getTop())                    
                    {
                        int varB4D2F09D0AD5244C9E57B5AF8AB759AE_1528884612 = (mFirstPosition + i);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1794204017 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1794204017;
                    } //End block
                } //End block
            } //End block
        } //End block
        int var296D6C732A05FBA51C5854FA7933FE23_169774180 = (INVALID_POSITION);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1502916954 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1502916954;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.673 -0400", hash_original_method = "2BE5C63CD6BB6072D8C1046433555060", hash_generated_method = "1ACA2C36188F415C9867F75691B40849")
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
View var540C13E9E156B687226421B24F2DF178_1549572140 =             null;
            var540C13E9E156B687226421B24F2DF178_1549572140.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1549572140;
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
View var85AF0530723FAED0F9065F029B9D6041_365323855 =             temp;
            var85AF0530723FAED0F9065F029B9D6041_365323855.addTaint(taint);
            return var85AF0530723FAED0F9065F029B9D6041_365323855;
        } //End block
        else
        if(above != null)        
        {
View varCD3155DFCED4EB61161BED1FF630FDBA_1481623930 =             above;
            varCD3155DFCED4EB61161BED1FF630FDBA_1481623930.addTaint(taint);
            return varCD3155DFCED4EB61161BED1FF630FDBA_1481623930;
        } //End block
        else
        {
View var2F0E8DD6CEEAC90C0D2F6260FE322E29_1339804155 =             below;
            var2F0E8DD6CEEAC90C0D2F6260FE322E29_1339804155.addTaint(taint);
            return var2F0E8DD6CEEAC90C0D2F6260FE322E29_1339804155;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.674 -0400", hash_original_method = "61C0C7B3D4F01380F7804BB62430F50F", hash_generated_method = "9D4F8BE31322A3C9A5D969A9C7DE2E41")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.675 -0400", hash_original_method = "C582B4D472853F3118C6A87E3BA2D3CE", hash_generated_method = "6E238BF7C99DFF1F30656005ACA29E77")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.677 -0400", hash_original_method = "AC707126EF44BD77373D761D306CE415", hash_generated_method = "321A167F93E6A2CD99C6419833F5D30E")
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
View var7B839F21D0245BE275F8017F44DD4441_1526161123 =         sel;
        var7B839F21D0245BE275F8017F44DD4441_1526161123.addTaint(taint);
        return var7B839F21D0245BE275F8017F44DD4441_1526161123;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.677 -0400", hash_original_method = "3B93521E4F8B514C6E0E966E64E45808", hash_generated_method = "7F853AA078B5C44E0CD80325EEAEC3C7")
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
        int var8C1BAEE08BF7BBE553C84235F7A5E3D8_1154217846 = (bottomSelectionPixel);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_508184040 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_508184040;
        // ---------- Original Method ----------
        //int bottomSelectionPixel = childrenBottom;
        //if (rowStart + numColumns - 1 < mItemCount - 1) {
            //bottomSelectionPixel -= fadingEdgeLength;
        //}
        //return bottomSelectionPixel;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.678 -0400", hash_original_method = "D0A32123B024D3BD3B829FD608C467F8", hash_generated_method = "300918EAB6EB77B7255F8D6995D50A4C")
    private int getTopSelectionPixel(int childrenTop, int fadingEdgeLength, int rowStart) {
        addTaint(rowStart);
        addTaint(fadingEdgeLength);
        addTaint(childrenTop);
        int topSelectionPixel = childrenTop;
        if(rowStart > 0)        
        {
            topSelectionPixel += fadingEdgeLength;
        } //End block
        int var9B1B38FE46FCA5DD3FBB400FF9DA31B9_1586770741 = (topSelectionPixel);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1413683865 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1413683865;
        // ---------- Original Method ----------
        //int topSelectionPixel = childrenTop;
        //if (rowStart > 0) {
            //topSelectionPixel += fadingEdgeLength;
        //}
        //return topSelectionPixel;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.679 -0400", hash_original_method = "683433A1D2226A93C6C052E4367B337E", hash_generated_method = "27F6419AA3C2D4101663C980DA14D6CA")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.679 -0400", hash_original_method = "E9E54F71CD8326C8AF2C780315CD689D", hash_generated_method = "9D027445A4AA270459F47B17617A7921")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.680 -0400", hash_original_method = "19B54E9E42F50C19B80602093C26BC32", hash_generated_method = "13D89CD9CDD5D76B097C78A9C6F471D8")
    @android.view.RemotableViewMethod
    public void smoothScrollToPosition(int position) {
        addTaint(position);
        super.smoothScrollToPosition(position);
        // ---------- Original Method ----------
        //super.smoothScrollToPosition(position);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.680 -0400", hash_original_method = "9A2E566018459C8A4F9FE2F49DBB98B8", hash_generated_method = "3F9C88E5F8435EC02B22E53B890AC667")
    @android.view.RemotableViewMethod
    public void smoothScrollByOffset(int offset) {
        addTaint(offset);
        super.smoothScrollByOffset(offset);
        // ---------- Original Method ----------
        //super.smoothScrollByOffset(offset);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.682 -0400", hash_original_method = "55F676D436FF1EC67ECC1C028E81ED27", hash_generated_method = "77E614A013E8281D4D06315381859594")
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
View var7B839F21D0245BE275F8017F44DD4441_1780068322 =         sel;
        var7B839F21D0245BE275F8017F44DD4441_1780068322.addTaint(taint);
        return var7B839F21D0245BE275F8017F44DD4441_1780068322;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.684 -0400", hash_original_method = "971C7C8872B1F8EEBA5FB107FC6F8364", hash_generated_method = "8CF38DEC4D6A4B3D273EE461D011C65A")
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
}        boolean var2BD242B1C363F4BFB823FD7C70B8F10A_13762658 = (didNotInitiallyFit);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_903412384 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_903412384;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.687 -0400", hash_original_method = "DE2B2122B3B8477B4CE53B0961FAB462", hash_generated_method = "AE0E1CEA61A98D89298EB2A83C8813BE")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.689 -0400", hash_original_method = "B083102DF451B0F743637B4C2ECFBD00", hash_generated_method = "5E27CFE091CC3840FC4DB29E4CFBCDB8")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.692 -0400", hash_original_method = "22970971C8FD1FE9524617A911939C41", hash_generated_method = "ED0AD9F99E2F1D92620941BDA3C89DC2")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.693 -0400", hash_original_method = "D1571833DCBC36BAA4E4DA8F2A5DB363", hash_generated_method = "94FD31FCB115ABD9A4374DCA96905D09")
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
View var73902FD3E151130B4329B76EF04D2A54_2025495616 =                 child;
                var73902FD3E151130B4329B76EF04D2A54_2025495616.addTaint(taint);
                return var73902FD3E151130B4329B76EF04D2A54_2025495616;
            } //End block
        } //End block
        child = obtainView(position, mIsScrap);
        setupChild(child, position, y, flow, childrenLeft, selected, mIsScrap[0], where);
View var73902FD3E151130B4329B76EF04D2A54_27903299 =         child;
        var73902FD3E151130B4329B76EF04D2A54_27903299.addTaint(taint);
        return var73902FD3E151130B4329B76EF04D2A54_27903299;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.697 -0400", hash_original_method = "F1D84EEF4E6902A923E61B402C707D18", hash_generated_method = "D153C9658BDAA0A897BF386B18FE08C9")
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
}        if(needToMeasure)        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.699 -0400", hash_original_method = "F036989DC17B53D064E56E9048AF8088", hash_generated_method = "F1141BD156BB8EAE32B892D196866A9E")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.699 -0400", hash_original_method = "BFD03D39F54176AB600127B7C1132704", hash_generated_method = "D85582E0D16BCA9BD3A267DCA5A605CB")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.699 -0400", hash_original_method = "82498D99AFEB0700B1F959E9E9927B59", hash_generated_method = "B273D3875F42F57BC7DCE8D671491774")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        boolean var7EF652CB3ACE03C95ABA8817CA740A6C_1008856124 = (commonKey(keyCode, 1, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_453635991 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_453635991;
        // ---------- Original Method ----------
        //return commonKey(keyCode, 1, event);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.700 -0400", hash_original_method = "C105EC1B6481173F2A66D1C47882507B", hash_generated_method = "2E550753437BAE78901B0F5929984476")
    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(repeatCount);
        addTaint(keyCode);
        boolean var7E22E05ED0529C3D32A81C1D21110D89_2000840843 = (commonKey(keyCode, repeatCount, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_286699906 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_286699906;
        // ---------- Original Method ----------
        //return commonKey(keyCode, repeatCount, event);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.700 -0400", hash_original_method = "FFB4A1626C41573790F9B17FF23F8A09", hash_generated_method = "977E5AB5E6B87012D3D24BEC3751F59A")
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        boolean var7EF652CB3ACE03C95ABA8817CA740A6C_1693125368 = (commonKey(keyCode, 1, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_85876210 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_85876210;
        // ---------- Original Method ----------
        //return commonKey(keyCode, 1, event);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.702 -0400", hash_original_method = "91535B300D60431313446AA401FFCFE7", hash_generated_method = "E6652EAC3F88D14889AABF61212D612F")
    private boolean commonKey(int keyCode, int count, KeyEvent event) {
        addTaint(event.getTaint());
        addTaint(count);
        addTaint(keyCode);
        if(mAdapter == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1810263513 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1948184260 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1948184260;
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
            boolean varB326B5062B2F0E69046810717534CB09_177661821 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_645730149 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_645730149;
        } //End block
        if(sendToTextFilter(keyCode, count, event))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1306692282 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_466186542 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_466186542;
        } //End block
switch(action){
        case KeyEvent.ACTION_DOWN:
        boolean var947F0C250323B9F4475E02588E9A9740_402670928 = (super.onKeyDown(keyCode, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_220493493 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_220493493;
        case KeyEvent.ACTION_UP:
        boolean varAD33E8F21A74B923C1A24761EAF2F4A9_489785167 = (super.onKeyUp(keyCode, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_777616777 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_777616777;
        case KeyEvent.ACTION_MULTIPLE:
        boolean varAE6EFDECB7172A439AD0AFF79E9160E9_579639365 = (super.onKeyMultiple(keyCode, count, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_794984414 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_794984414;
        default:
        boolean var68934A3E9455FA72420237EB05902327_1504239813 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_906698319 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_906698319;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.703 -0400", hash_original_method = "7F69D44B4A5B870A2ADF67B34BC1B3FD", hash_generated_method = "25926713B8CC28CFBD427B50005BCFD0")
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
            boolean varB326B5062B2F0E69046810717534CB09_1588135098 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1470580516 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1470580516;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_336302864 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1341893940 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1341893940;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.705 -0400", hash_original_method = "8921946161DEF2C387CE09B16F70206C", hash_generated_method = "6838BEDAF16F85AC2714E1A2FCDD40C0")
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
        boolean var11DFD868D93BC2B0E4CE0BEE5756F8B1_2110199280 = (moved);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2133563037 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2133563037;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.738 -0400", hash_original_method = "8CD79681F48962D4344E68AA337F0770", hash_generated_method = "D6CC8BC21F3A725B217F4CC60940D4E7")
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
}        if(moved)        
        {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(direction));
            invokeOnItemScrollListener();
        } //End block
        if(moved)        
        {
            awakenScrollBars();
        } //End block
        boolean var11DFD868D93BC2B0E4CE0BEE5756F8B1_476333480 = (moved);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_188360441 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_188360441;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.739 -0400", hash_original_method = "3D7E63CDF154AB38FFF5F8515CF699BF", hash_generated_method = "52FCAC5CABA9C13F37C4555C1E3C5EED")
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
}        if(moved)        
        {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(direction));
            invokeOnItemScrollListener();
        } //End block
        if(showScroll)        
        {
            awakenScrollBars();
        } //End block
        boolean var11DFD868D93BC2B0E4CE0BEE5756F8B1_676091945 = (moved);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1207123865 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1207123865;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.740 -0400", hash_original_method = "0FD361D132773200063DCB66E88E964C", hash_generated_method = "5CD468BB4DBE44131B84C97FC2635B2C")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.740 -0400", hash_original_method = "84D213429BEB1496C8F56DF85FD23E87", hash_generated_method = "471DC7346643B2222340BB33D277241D")
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
        boolean varE3C592428323E223764E217BCA45C6F2_462366976 = (childIndex == rowStart);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1650057288 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1650057288;
        case View.FOCUS_DOWN:
        boolean var375663F1B9E9BDE44C192AB430C1C055_1107448146 = (rowStart == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_491879425 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_491879425;
        case View.FOCUS_LEFT:
        boolean varA0487644439B48A879135B570581133E_1072941981 = (childIndex == rowEnd);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1552255060 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1552255060;
        case View.FOCUS_UP:
        boolean var47A27714995EE4AAEBD0BC74AA849F96_1232025878 = (rowEnd == count - 1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_327840634 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_327840634;
        case View.FOCUS_FORWARD:
        boolean var45EB01626CE96943B8627E084C4864CE_202289361 = (childIndex == rowStart && rowStart == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1704512391 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1704512391;
        case View.FOCUS_BACKWARD:
        boolean varDD97749B3A47C4DB260673B17C13355B_846653472 = (childIndex == rowEnd && rowEnd == count - 1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1013754490 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1013754490;
        default:
        IllegalArgumentException var312E8BFCD4DB95BFC9041723CFDD2D20_594766140 = new IllegalArgumentException("direction must be one of "
                        + "{FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, "
                        + "FOCUS_FORWARD, FOCUS_BACKWARD}.");
        var312E8BFCD4DB95BFC9041723CFDD2D20_594766140.addTaint(taint);
        throw var312E8BFCD4DB95BFC9041723CFDD2D20_594766140;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.741 -0400", hash_original_method = "FC2053B842AF8EFA285EBFCDE9A6D098", hash_generated_method = "7651FAE378FCD1C5C8D832C78E53463C")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.741 -0400", hash_original_method = "F4AD294FF1286508B5C248EDCA212E5B", hash_generated_method = "6AE42A70275DEC4A85D458C27872A426")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.741 -0400", hash_original_method = "18D0FB9D8A0D215DBABAAD70588CEE39", hash_generated_method = "61E99EF7ED5F6001F1AE0694ED7CC815")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.741 -0400", hash_original_method = "C49A7586B9CFE9BA77F47A780C0C8544", hash_generated_method = "96A230D9BC780121F83A97140C351EE1")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.742 -0400", hash_original_method = "B323AFE5AE5939BBDA58166A4DF4B096", hash_generated_method = "E7D308CC13F34120CF1C25E10F82E0F1")
    public int getStretchMode() {
        int var6A66D00918859F42D851F505ADE6AA46_388267174 = (mStretchMode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_631734232 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_631734232;
        // ---------- Original Method ----------
        //return mStretchMode;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.742 -0400", hash_original_method = "2D3707A47407D7324964709BC50279C2", hash_generated_method = "84786CA15DE1CC9B737C4658EAE1650D")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.742 -0400", hash_original_method = "EB843153C85390AE48F1C91EE0B42CDB", hash_generated_method = "DF909A972746555C83BF1873A671E9EC")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.742 -0400", hash_original_method = "B011FDCEBE38F0939F62249D6B5BC711", hash_generated_method = "1EC0AE9AD1CD94F1A71D8A99433EEF1C")
    @ViewDebug.ExportedProperty
    public int getNumColumns() {
        int var3C11F31A23C7905177BA6A1A74A63160_200611550 = (mNumColumns);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1102655381 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1102655381;
        // ---------- Original Method ----------
        //return mNumColumns;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.743 -0400", hash_original_method = "614329ACA245384517EF28FF3609B04B", hash_generated_method = "C987A8817E39D35B11DFA58E52F09D50")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.746 -0400", hash_original_method = "0FB16985DD2A598E66D7882D349B86AF", hash_generated_method = "72C3A69C2E8BF2C0870E11E50F2313F7")
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
            int var0793046CD12DB418149C2B688AF9B27F_164202630 = (extent);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1313648243 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1313648243;
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_1526570255 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2081295786 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2081295786;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.746 -0400", hash_original_method = "77C851014C1118924C7173C75459421E", hash_generated_method = "0D9452A9C81F453F1C848DBEB7D0D07C")
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
                int varBDB02E367A751F85AB56A797E679B26F_1683284853 = (Math.max(whichRow * 100 - (top * 100) / height +
                        (int) ((float) mScrollY / getHeight() * rowCount * 100), 0));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_817628568 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_817628568;
            } //End block
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_2058119172 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1869139365 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1869139365;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.747 -0400", hash_original_method = "2E67C9F09804D125789DA130D24F2E03", hash_generated_method = "CFCDEBB2CAEFD729DA3B9B4C129C05C3")
    @Override
    protected int computeVerticalScrollRange() {
        final int numColumns = mNumColumns;
        final int rowCount = (mItemCount + numColumns - 1) / numColumns;
        int result = Math.max(rowCount * 100, 0);
        if(mScrollY != 0)        
        {
            result += Math.abs((int) ((float) mScrollY / getHeight() * rowCount * 100));
        } //End block
        int varB4A88417B3D0170D754C647C30B7216A_258689676 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_641886394 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_641886394;
        // ---------- Original Method ----------
        //final int numColumns = mNumColumns;
        //final int rowCount = (mItemCount + numColumns - 1) / numColumns;
        //int result = Math.max(rowCount * 100, 0);
        //if (mScrollY != 0) {
            //result += Math.abs((int) ((float) mScrollY / getHeight() * rowCount * 100));
        //}
        //return result;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.747 -0400", hash_original_field = "3C6C842350FA9DF4AF7C1577C5481D7F", hash_generated_field = "9591D43DFDB00D3CA815C6412336BEEB")

    public static final int NO_STRETCH = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.747 -0400", hash_original_field = "C781279666F1CFCA96E5F3E8F379648C", hash_generated_field = "9E8C93D13663D982A634A608E98FDD9B")

    public static final int STRETCH_SPACING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.747 -0400", hash_original_field = "93F50EC30CD0856C8A19939E9B64DED3", hash_generated_field = "289B7802E2F88C85889BF1B0A565B14F")

    public static final int STRETCH_COLUMN_WIDTH = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.747 -0400", hash_original_field = "321EC49DA83893E4048EDCC856EFEFB3", hash_generated_field = "6D329753C82DAECBEDD98AD073821537")

    public static final int STRETCH_SPACING_UNIFORM = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.747 -0400", hash_original_field = "57174C1594A18EA6304DDA366FEF8B68", hash_generated_field = "4306712C3BDDA946F401316F516F19DA")

    public static final int AUTO_FIT = -1;
}

