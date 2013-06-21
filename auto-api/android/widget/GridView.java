package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private int mNumColumns = AUTO_FIT;
    private int mHorizontalSpacing = 0;
    private int mRequestedHorizontalSpacing;
    private int mVerticalSpacing = 0;
    private int mStretchMode = STRETCH_COLUMN_WIDTH;
    private int mColumnWidth;
    private int mRequestedColumnWidth;
    private int mRequestedNumColumns;
    private View mReferenceView = null;
    private View mReferenceViewInSelectedRow = null;
    private int mGravity = Gravity.LEFT;
    private Rect mTempRect = new Rect();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.909 -0400", hash_original_method = "6B9AD93D67DF35D03ADA1536C0A58FBF", hash_generated_method = "0C87CFFA8A806671F16DAC5B5F1B9B26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GridView(Context context) {
        super(context);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.909 -0400", hash_original_method = "2A531A248703ACB5E0E1C6A31088A2B2", hash_generated_method = "67E5C4253D991D4402633308F108E719")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GridView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.gridViewStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.910 -0400", hash_original_method = "49F6501DFACF5B2EADDBFC02F7376929", hash_generated_method = "9C1AD551F4A1C633006F0E0A31B48BCF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        TypedArray a;
        a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.GridView, defStyle, 0);
        int hSpacing;
        hSpacing = a.getDimensionPixelOffset(
                com.android.internal.R.styleable.GridView_horizontalSpacing, 0);
        setHorizontalSpacing(hSpacing);
        int vSpacing;
        vSpacing = a.getDimensionPixelOffset(
                com.android.internal.R.styleable.GridView_verticalSpacing, 0);
        setVerticalSpacing(vSpacing);
        int index;
        index = a.getInt(com.android.internal.R.styleable.GridView_stretchMode, STRETCH_COLUMN_WIDTH);
        {
            setStretchMode(index);
        } //End block
        int columnWidth;
        columnWidth = a.getDimensionPixelOffset(com.android.internal.R.styleable.GridView_columnWidth, -1);
        {
            setColumnWidth(columnWidth);
        } //End block
        int numColumns;
        numColumns = a.getInt(com.android.internal.R.styleable.GridView_numColumns, 1);
        setNumColumns(numColumns);
        index = a.getInt(com.android.internal.R.styleable.GridView_gravity, -1);
        {
            setGravity(index);
        } //End block
        a.recycle();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.910 -0400", hash_original_method = "0E1A05724C497F45D7FB6AC34C501814", hash_generated_method = "72F9192184BF51AC84CCAC2675006688")
    @DSModeled(DSC.SAFE)
    @Override
    public ListAdapter getAdapter() {
        return (ListAdapter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mAdapter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.910 -0400", hash_original_method = "8AB2C6958FD7CEC3A8A71FE59763D6A4", hash_generated_method = "BABB9E618C0360D6B56D5B89A4C9F94A")
    @DSModeled(DSC.SPEC)
    @android.view.RemotableViewMethod
    public void setRemoteViewsAdapter(Intent intent) {
        dsTaint.addTaint(intent.dsTaint);
        super.setRemoteViewsAdapter(intent);
        // ---------- Original Method ----------
        //super.setRemoteViewsAdapter(intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.910 -0400", hash_original_method = "3B0F7EFF2AD6466D19A6F404E2E1BAAD", hash_generated_method = "CDAF9880DC5C3BA45694D20551BF7480")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setAdapter(ListAdapter adapter) {
        dsTaint.addTaint(adapter.dsTaint);
        {
            mAdapter.unregisterDataSetObserver(mDataSetObserver);
        } //End block
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
            } //End block
            {
                position = lookForSelectablePosition(0, true);
            } //End block
            setSelectedPositionInt(position);
            setNextSelectedPositionInt(position);
            checkSelectionChanged();
        } //End block
        {
            checkFocus();
            checkSelectionChanged();
        } //End block
        requestLayout();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.911 -0400", hash_original_method = "D52FAC74E641441314EFBB7F4E58B879", hash_generated_method = "401CA54858EDF24A15DEC4D7205DB798")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     int lookForSelectablePosition(int position, boolean lookDown) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(lookDown);
        ListAdapter adapter;
        adapter = mAdapter;
        {
            boolean var35A1F64E67CC6E0C06A8BA9582F2435F_1044845624 = (adapter == null || isInTouchMode());
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.911 -0400", hash_original_method = "A62E9A831AF61A8CD347891B2F9D44DF", hash_generated_method = "9CA03B9717CFFBB93F5B6941B792F742")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     void fillGap(boolean down) {
        dsTaint.addTaint(down);
        int numColumns;
        numColumns = mNumColumns;
        int verticalSpacing;
        verticalSpacing = mVerticalSpacing;
        int count;
        count = getChildCount();
        {
            int paddingTop;
            paddingTop = 0;
            {
                paddingTop = getListPaddingTop();
            } //End block
            int startOffset;
            startOffset = getChildAt(count - 1).getBottom() + verticalSpacing;
            startOffset = paddingTop;
            int position;
            position = mFirstPosition + count;
            {
                position += numColumns - 1;
            } //End block
            fillDown(position, startOffset);
            correctTooHigh(numColumns, verticalSpacing, getChildCount());
        } //End block
        {
            int paddingBottom;
            paddingBottom = 0;
            {
                paddingBottom = getListPaddingBottom();
            } //End block
            int startOffset;
            startOffset = getChildAt(0).getTop() - verticalSpacing;
            startOffset = getHeight() - paddingBottom;
            int position;
            position = mFirstPosition;
            {
                position -= numColumns;
            } //End block
            fillUp(position, startOffset);
            correctTooLow(numColumns, verticalSpacing, getChildCount());
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.911 -0400", hash_original_method = "6F9360E73E1EB4E0BD6CC48A029E26CB", hash_generated_method = "406732A4E918CDD2D0D45AC77E538A85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private View fillDown(int pos, int nextTop) {
        dsTaint.addTaint(nextTop);
        dsTaint.addTaint(pos);
        View selectedView;
        selectedView = null;
        int end;
        end = (mBottom - mTop);
        {
            end -= mListPadding.bottom;
        } //End block
        {
            View temp;
            temp = makeRow(pos, nextTop, true);
            {
                selectedView = temp;
            } //End block
            nextTop = mReferenceView.getBottom() + mVerticalSpacing;
            pos += mNumColumns;
        } //End block
        return (View)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.912 -0400", hash_original_method = "DFB797BE7486A81865BE6BA7ABEE8F5A", hash_generated_method = "FB56D0D0345B8D047EF2215EC0EC886F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private View makeRow(int startPos, int y, boolean flow) {
        dsTaint.addTaint(startPos);
        dsTaint.addTaint(flow);
        dsTaint.addTaint(y);
        int columnWidth;
        columnWidth = mColumnWidth;
        int horizontalSpacing;
        horizontalSpacing = mHorizontalSpacing;
        int last;
        int nextLeft;
        nextLeft = mListPadding.left +
                ((mStretchMode == STRETCH_SPACING_UNIFORM) ? horizontalSpacing : 0);//DSFIXME:  CODE0008: Nested ternary operator in expression
        {
            last = Math.min(startPos + mNumColumns, mItemCount);
        } //End block
        {
            last = startPos + 1;
            startPos = Math.max(0, startPos - mNumColumns + 1);
            {
                nextLeft += (mNumColumns - (last - startPos)) * (columnWidth + horizontalSpacing);
            } //End block
        } //End block
        View selectedView;
        selectedView = null;
        boolean hasFocus;
        hasFocus = shouldShowSelector();
        boolean inClick;
        inClick = touchModeDrawsInPressedState();
        int selectedPosition;
        selectedPosition = mSelectedPosition;
        View child;
        child = null;
        {
            int pos;
            pos = startPos;
            {
                boolean selected;
                selected = pos == selectedPosition;
                int where;
                where = -1;
                where = pos - startPos;
                child = makeAndAddView(pos, y, flow, nextLeft, selected, where);
                nextLeft += columnWidth;
                {
                    nextLeft += horizontalSpacing;
                } //End block
                {
                    selectedView = child;
                } //End block
            } //End block
        } //End collapsed parenthetic
        mReferenceView = child;
        {
            mReferenceViewInSelectedRow = mReferenceView;
        } //End block
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.912 -0400", hash_original_method = "0AADB00D4F358179B46AC864F825D76F", hash_generated_method = "3E53B804E3DE1E472A8D15E2DE7F3779")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private View fillUp(int pos, int nextBottom) {
        dsTaint.addTaint(nextBottom);
        dsTaint.addTaint(pos);
        View selectedView;
        selectedView = null;
        int end;
        end = 0;
        {
            end = mListPadding.top;
        } //End block
        {
            View temp;
            temp = makeRow(pos, nextBottom, false);
            {
                selectedView = temp;
            } //End block
            nextBottom = mReferenceView.getTop() - mVerticalSpacing;
            mFirstPosition = pos;
            pos -= mNumColumns;
        } //End block
        {
            mFirstPosition = Math.max(0, pos + 1);
        } //End block
        return (View)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.913 -0400", hash_original_method = "ECD7EEB642891ACE11FADF160200B8D1", hash_generated_method = "D9BEF491C9161936AB350C6888577672")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private View fillFromTop(int nextTop) {
        dsTaint.addTaint(nextTop);
        mFirstPosition = Math.min(mFirstPosition, mSelectedPosition);
        mFirstPosition = Math.min(mFirstPosition, mItemCount - 1);
        {
            mFirstPosition = 0;
        } //End block
        mFirstPosition -= mFirstPosition % mNumColumns;
        View varBC3312FAE5DAD2D4DA02F3A8FDDCF8D0_1659869465 = (fillDown(mFirstPosition, nextTop));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mFirstPosition = Math.min(mFirstPosition, mSelectedPosition);
        //mFirstPosition = Math.min(mFirstPosition, mItemCount - 1);
        //if (mFirstPosition < 0) {
            //mFirstPosition = 0;
        //}
        //mFirstPosition -= mFirstPosition % mNumColumns;
        //return fillDown(mFirstPosition, nextTop);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.913 -0400", hash_original_method = "0818B9EEFC7CF79A0018AB61F39070C0", hash_generated_method = "339496D563665AF712B4B7B26B4C03E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private View fillFromBottom(int lastPosition, int nextBottom) {
        dsTaint.addTaint(lastPosition);
        dsTaint.addTaint(nextBottom);
        lastPosition = Math.max(lastPosition, mSelectedPosition);
        lastPosition = Math.min(lastPosition, mItemCount - 1);
        int invertedPosition;
        invertedPosition = mItemCount - 1 - lastPosition;
        lastPosition = mItemCount - 1 - (invertedPosition - (invertedPosition % mNumColumns));
        View var02A1FF78F1F92E56626E7BC987633D27_1587956636 = (fillUp(lastPosition, nextBottom));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //lastPosition = Math.max(lastPosition, mSelectedPosition);
        //lastPosition = Math.min(lastPosition, mItemCount - 1);
        //final int invertedPosition = mItemCount - 1 - lastPosition;
        //lastPosition = mItemCount - 1 - (invertedPosition - (invertedPosition % mNumColumns));
        //return fillUp(lastPosition, nextBottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.914 -0400", hash_original_method = "B869E7B5DD0E41AF8A9344426795B32C", hash_generated_method = "C97D52CEDA58F54A3A405917DED0E50C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private View fillSelection(int childrenTop, int childrenBottom) {
        dsTaint.addTaint(childrenBottom);
        dsTaint.addTaint(childrenTop);
        int selectedPosition;
        selectedPosition = reconcileSelectedPosition();
        int numColumns;
        numColumns = mNumColumns;
        int verticalSpacing;
        verticalSpacing = mVerticalSpacing;
        int rowStart;
        int rowEnd;
        rowEnd = -1;
        {
            rowStart = selectedPosition - (selectedPosition % numColumns);
        } //End block
        {
            int invertedSelection;
            invertedSelection = mItemCount - 1 - selectedPosition;
            rowEnd = mItemCount - 1 - (invertedSelection - (invertedSelection % numColumns));
            rowStart = Math.max(0, rowEnd - numColumns + 1);
        } //End block
        int fadingEdgeLength;
        fadingEdgeLength = getVerticalFadingEdgeLength();
        int topSelectionPixel;
        topSelectionPixel = getTopSelectionPixel(childrenTop, fadingEdgeLength, rowStart);
        View sel;
        sel = makeRow(mStackFromBottom ? rowEnd : rowStart, topSelectionPixel, true);//DSFIXME:  CODE0008: Nested ternary operator in expression
        mFirstPosition = rowStart;
        View referenceView;
        referenceView = mReferenceView;
        {
            fillDown(rowStart + numColumns, referenceView.getBottom() + verticalSpacing);
            pinToBottom(childrenBottom);
            fillUp(rowStart - numColumns, referenceView.getTop() - verticalSpacing);
            adjustViewsUpOrDown();
        } //End block
        {
            int bottomSelectionPixel;
            bottomSelectionPixel = getBottomSelectionPixel(childrenBottom,
                    fadingEdgeLength, numColumns, rowStart);
            int offset;
            offset = bottomSelectionPixel - referenceView.getBottom();
            offsetChildrenTopAndBottom(offset);
            fillUp(rowStart - 1, referenceView.getTop() - verticalSpacing);
            pinToTop(childrenTop);
            fillDown(rowEnd + numColumns, referenceView.getBottom() + verticalSpacing);
            adjustViewsUpOrDown();
        } //End block
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.915 -0400", hash_original_method = "535BA4E594C209A488B214DB13AE774F", hash_generated_method = "976E7693C52F1D67E7DA17BF14FF19EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void pinToTop(int childrenTop) {
        dsTaint.addTaint(childrenTop);
        {
            int top;
            top = getChildAt(0).getTop();
            int offset;
            offset = childrenTop - top;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.915 -0400", hash_original_method = "554B5C3A9DEE69BDD0B0F70052D29046", hash_generated_method = "F887E95EB7DF943CF5053B6F60FB0888")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void pinToBottom(int childrenBottom) {
        dsTaint.addTaint(childrenBottom);
        int count;
        count = getChildCount();
        {
            int bottom;
            bottom = getChildAt(count - 1).getBottom();
            int offset;
            offset = childrenBottom - bottom;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.915 -0400", hash_original_method = "584D06EE6653E11D28AE97D7ADF4C3E4", hash_generated_method = "BE90BE30B498594729D9348D8FFE2C61")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     int findMotionRow(int y) {
        dsTaint.addTaint(y);
        int childCount;
        childCount = getChildCount();
        {
            int numColumns;
            numColumns = mNumColumns;
            {
                {
                    int i;
                    i = 0;
                    i += numColumns;
                    {
                        {
                            boolean varC0173D202327EB6C7A35540C10A8AA25_878249202 = (y <= getChildAt(i).getBottom());
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    int i;
                    i = childCount - 1;
                    i -= numColumns;
                    {
                        {
                            boolean var0C308B788546DD5F7421232B1F43CEB9_1125848923 = (y >= getChildAt(i).getTop());
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.916 -0400", hash_original_method = "2BE5C63CD6BB6072D8C1046433555060", hash_generated_method = "C861BA0CE113023F5426C0F5AB10FD8D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private View fillSpecific(int position, int top) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(top);
        int numColumns;
        numColumns = mNumColumns;
        int motionRowStart;
        int motionRowEnd;
        motionRowEnd = -1;
        {
            motionRowStart = position - (position % numColumns);
        } //End block
        {
            int invertedSelection;
            invertedSelection = mItemCount - 1 - position;
            motionRowEnd = mItemCount - 1 - (invertedSelection - (invertedSelection % numColumns));
            motionRowStart = Math.max(0, motionRowEnd - numColumns + 1);
        } //End block
        View temp;
        temp = makeRow(mStackFromBottom ? motionRowEnd : motionRowStart, top, true);//DSFIXME:  CODE0008: Nested ternary operator in expression
        mFirstPosition = motionRowStart;
        View referenceView;
        referenceView = mReferenceView;
        int verticalSpacing;
        verticalSpacing = mVerticalSpacing;
        View above;
        View below;
        {
            above = fillUp(motionRowStart - numColumns, referenceView.getTop() - verticalSpacing);
            adjustViewsUpOrDown();
            below = fillDown(motionRowStart + numColumns, referenceView.getBottom() + verticalSpacing);
            int childCount;
            childCount = getChildCount();
            {
                correctTooHigh(numColumns, verticalSpacing, childCount);
            } //End block
        } //End block
        {
            below = fillDown(motionRowEnd + numColumns, referenceView.getBottom() + verticalSpacing);
            adjustViewsUpOrDown();
            above = fillUp(motionRowStart - 1, referenceView.getTop() - verticalSpacing);
            int childCount;
            childCount = getChildCount();
            {
                correctTooLow(numColumns, verticalSpacing, childCount);
            } //End block
        } //End block
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.917 -0400", hash_original_method = "61C0C7B3D4F01380F7804BB62430F50F", hash_generated_method = "01B28E9615DB63AE3DA0524D59525095")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void correctTooHigh(int numColumns, int verticalSpacing, int childCount) {
        dsTaint.addTaint(childCount);
        dsTaint.addTaint(verticalSpacing);
        dsTaint.addTaint(numColumns);
        int lastPosition;
        lastPosition = mFirstPosition + childCount - 1;
        {
            View lastChild;
            lastChild = getChildAt(childCount - 1);
            int lastBottom;
            lastBottom = lastChild.getBottom();
            int end;
            end = (mBottom - mTop) - mListPadding.bottom;
            int bottomOffset;
            bottomOffset = end - lastBottom;
            View firstChild;
            firstChild = getChildAt(0);
            int firstTop;
            firstTop = firstChild.getTop();
            {
                {
                    bottomOffset = Math.min(bottomOffset, mListPadding.top - firstTop);
                } //End block
                offsetChildrenTopAndBottom(bottomOffset);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.917 -0400", hash_original_method = "C582B4D472853F3118C6A87E3BA2D3CE", hash_generated_method = "20A88CF3A223AC28800500738156A260")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void correctTooLow(int numColumns, int verticalSpacing, int childCount) {
        dsTaint.addTaint(childCount);
        dsTaint.addTaint(verticalSpacing);
        dsTaint.addTaint(numColumns);
        {
            View firstChild;
            firstChild = getChildAt(0);
            int firstTop;
            firstTop = firstChild.getTop();
            int start;
            start = mListPadding.top;
            int end;
            end = (mBottom - mTop) - mListPadding.bottom;
            int topOffset;
            topOffset = firstTop - start;
            View lastChild;
            lastChild = getChildAt(childCount - 1);
            int lastBottom;
            lastBottom = lastChild.getBottom();
            int lastPosition;
            lastPosition = mFirstPosition + childCount - 1;
            {
                {
                    topOffset = Math.min(topOffset, lastBottom - end);
                } //End block
                offsetChildrenTopAndBottom(-topOffset);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.918 -0400", hash_original_method = "AC707126EF44BD77373D761D306CE415", hash_generated_method = "D4984143CA8E01A6D9C72765E163E5AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private View fillFromSelection(int selectedTop, int childrenTop, int childrenBottom) {
        dsTaint.addTaint(childrenBottom);
        dsTaint.addTaint(childrenTop);
        dsTaint.addTaint(selectedTop);
        int fadingEdgeLength;
        fadingEdgeLength = getVerticalFadingEdgeLength();
        int selectedPosition;
        selectedPosition = mSelectedPosition;
        int numColumns;
        numColumns = mNumColumns;
        int verticalSpacing;
        verticalSpacing = mVerticalSpacing;
        int rowStart;
        int rowEnd;
        rowEnd = -1;
        {
            rowStart = selectedPosition - (selectedPosition % numColumns);
        } //End block
        {
            int invertedSelection;
            invertedSelection = mItemCount - 1 - selectedPosition;
            rowEnd = mItemCount - 1 - (invertedSelection - (invertedSelection % numColumns));
            rowStart = Math.max(0, rowEnd - numColumns + 1);
        } //End block
        View sel;
        View referenceView;
        int topSelectionPixel;
        topSelectionPixel = getTopSelectionPixel(childrenTop, fadingEdgeLength, rowStart);
        int bottomSelectionPixel;
        bottomSelectionPixel = getBottomSelectionPixel(childrenBottom, fadingEdgeLength,
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
        } //End block
        {
            fillDown(rowEnd + numColumns, referenceView.getBottom() + verticalSpacing);
            adjustViewsUpOrDown();
            fillUp(rowStart - 1, referenceView.getTop() - verticalSpacing);
        } //End block
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.918 -0400", hash_original_method = "3B93521E4F8B514C6E0E966E64E45808", hash_generated_method = "A39E8452EF0C65C48E676ABA828208F2")
    @DSModeled(DSC.SAFE)
    private int getBottomSelectionPixel(int childrenBottom, int fadingEdgeLength,
            int numColumns, int rowStart) {
        dsTaint.addTaint(rowStart);
        dsTaint.addTaint(numColumns);
        dsTaint.addTaint(childrenBottom);
        dsTaint.addTaint(fadingEdgeLength);
        int bottomSelectionPixel;
        bottomSelectionPixel = childrenBottom;
        {
            bottomSelectionPixel -= fadingEdgeLength;
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int bottomSelectionPixel = childrenBottom;
        //if (rowStart + numColumns - 1 < mItemCount - 1) {
            //bottomSelectionPixel -= fadingEdgeLength;
        //}
        //return bottomSelectionPixel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.918 -0400", hash_original_method = "D0A32123B024D3BD3B829FD608C467F8", hash_generated_method = "8A098D8B926378FA488AB38F6F6082C5")
    @DSModeled(DSC.SAFE)
    private int getTopSelectionPixel(int childrenTop, int fadingEdgeLength, int rowStart) {
        dsTaint.addTaint(rowStart);
        dsTaint.addTaint(childrenTop);
        dsTaint.addTaint(fadingEdgeLength);
        int topSelectionPixel;
        topSelectionPixel = childrenTop;
        {
            topSelectionPixel += fadingEdgeLength;
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int topSelectionPixel = childrenTop;
        //if (rowStart > 0) {
            //topSelectionPixel += fadingEdgeLength;
        //}
        //return topSelectionPixel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.918 -0400", hash_original_method = "683433A1D2226A93C6C052E4367B337E", hash_generated_method = "D377A7F21FB22E4E6420CB8DAEE3638D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void adjustForBottomFadingEdge(View childInSelectedRow,
            int topSelectionPixel, int bottomSelectionPixel) {
        dsTaint.addTaint(bottomSelectionPixel);
        dsTaint.addTaint(childInSelectedRow.dsTaint);
        dsTaint.addTaint(topSelectionPixel);
        {
            boolean var2726325E9F58F141269CF4C5709BEFD8_312087279 = (childInSelectedRow.getBottom() > bottomSelectionPixel);
            {
                int spaceAbove;
                spaceAbove = childInSelectedRow.getTop() - topSelectionPixel;
                int spaceBelow;
                spaceBelow = childInSelectedRow.getBottom() - bottomSelectionPixel;
                int offset;
                offset = Math.min(spaceAbove, spaceBelow);
                offsetChildrenTopAndBottom(-offset);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (childInSelectedRow.getBottom() > bottomSelectionPixel) {
            //int spaceAbove = childInSelectedRow.getTop() - topSelectionPixel;
            //int spaceBelow = childInSelectedRow.getBottom() - bottomSelectionPixel;
            //int offset = Math.min(spaceAbove, spaceBelow);
            //offsetChildrenTopAndBottom(-offset);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.918 -0400", hash_original_method = "E9E54F71CD8326C8AF2C780315CD689D", hash_generated_method = "BC6A0558AAF6BC149EE8DAA3457E052E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void adjustForTopFadingEdge(View childInSelectedRow,
            int topSelectionPixel, int bottomSelectionPixel) {
        dsTaint.addTaint(bottomSelectionPixel);
        dsTaint.addTaint(childInSelectedRow.dsTaint);
        dsTaint.addTaint(topSelectionPixel);
        {
            boolean varA6AD2992672F69243A86BE094F867981_2000043129 = (childInSelectedRow.getTop() < topSelectionPixel);
            {
                int spaceAbove;
                spaceAbove = topSelectionPixel - childInSelectedRow.getTop();
                int spaceBelow;
                spaceBelow = bottomSelectionPixel - childInSelectedRow.getBottom();
                int offset;
                offset = Math.min(spaceAbove, spaceBelow);
                offsetChildrenTopAndBottom(offset);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (childInSelectedRow.getTop() < topSelectionPixel) {
            //int spaceAbove = topSelectionPixel - childInSelectedRow.getTop();
            //int spaceBelow = bottomSelectionPixel - childInSelectedRow.getBottom();
            //int offset = Math.min(spaceAbove, spaceBelow);
            //offsetChildrenTopAndBottom(offset);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.919 -0400", hash_original_method = "19B54E9E42F50C19B80602093C26BC32", hash_generated_method = "C57ED4CF81BD8746881B4F077DBD4F0D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @android.view.RemotableViewMethod
    public void smoothScrollToPosition(int position) {
        dsTaint.addTaint(position);
        super.smoothScrollToPosition(position);
        // ---------- Original Method ----------
        //super.smoothScrollToPosition(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.919 -0400", hash_original_method = "9A2E566018459C8A4F9FE2F49DBB98B8", hash_generated_method = "1553B8DCA139E22A83755C1BBBB59543")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @android.view.RemotableViewMethod
    public void smoothScrollByOffset(int offset) {
        dsTaint.addTaint(offset);
        super.smoothScrollByOffset(offset);
        // ---------- Original Method ----------
        //super.smoothScrollByOffset(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.920 -0400", hash_original_method = "55F676D436FF1EC67ECC1C028E81ED27", hash_generated_method = "B17B7E467B2B0703BCEC918A803001DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private View moveSelection(int delta, int childrenTop, int childrenBottom) {
        dsTaint.addTaint(delta);
        dsTaint.addTaint(childrenBottom);
        dsTaint.addTaint(childrenTop);
        int fadingEdgeLength;
        fadingEdgeLength = getVerticalFadingEdgeLength();
        int selectedPosition;
        selectedPosition = mSelectedPosition;
        int numColumns;
        numColumns = mNumColumns;
        int verticalSpacing;
        verticalSpacing = mVerticalSpacing;
        int oldRowStart;
        int rowStart;
        int rowEnd;
        rowEnd = -1;
        {
            oldRowStart = (selectedPosition - delta) - ((selectedPosition - delta) % numColumns);
            rowStart = selectedPosition - (selectedPosition % numColumns);
        } //End block
        {
            int invertedSelection;
            invertedSelection = mItemCount - 1 - selectedPosition;
            rowEnd = mItemCount - 1 - (invertedSelection - (invertedSelection % numColumns));
            rowStart = Math.max(0, rowEnd - numColumns + 1);
            invertedSelection = mItemCount - 1 - (selectedPosition - delta);
            oldRowStart = mItemCount - 1 - (invertedSelection - (invertedSelection % numColumns));
            oldRowStart = Math.max(0, oldRowStart - numColumns + 1);
        } //End block
        int rowDelta;
        rowDelta = rowStart - oldRowStart;
        int topSelectionPixel;
        topSelectionPixel = getTopSelectionPixel(childrenTop, fadingEdgeLength, rowStart);
        int bottomSelectionPixel;
        bottomSelectionPixel = getBottomSelectionPixel(childrenBottom, fadingEdgeLength,
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
        } //End block
        {
            int oldTop;
            oldTop = 0;
            oldTop = mReferenceViewInSelectedRow .getTop();
            sel = makeRow(mStackFromBottom ? rowEnd : rowStart, oldTop - verticalSpacing, false);
            referenceView = mReferenceView;
            adjustForTopFadingEdge(referenceView, topSelectionPixel, bottomSelectionPixel);
        } //End block
        {
            int oldTop;
            oldTop = 0;
            oldTop = mReferenceViewInSelectedRow .getTop();
            sel = makeRow(mStackFromBottom ? rowEnd : rowStart, oldTop, true);
            referenceView = mReferenceView;
        } //End block
        {
            fillUp(rowStart - numColumns, referenceView.getTop() - verticalSpacing);
            adjustViewsUpOrDown();
            fillDown(rowStart + numColumns, referenceView.getBottom() + verticalSpacing);
        } //End block
        {
            fillDown(rowEnd + numColumns, referenceView.getBottom() + verticalSpacing);
            adjustViewsUpOrDown();
            fillUp(rowStart - 1, referenceView.getTop() - verticalSpacing);
        } //End block
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.920 -0400", hash_original_method = "971C7C8872B1F8EEBA5FB107FC6F8364", hash_generated_method = "574D03A105D935AFD260E2B2E7229E5D")
    @DSModeled(DSC.SAFE)
    private boolean determineColumns(int availableSpace) {
        dsTaint.addTaint(availableSpace);
        int requestedHorizontalSpacing;
        requestedHorizontalSpacing = mRequestedHorizontalSpacing;
        int stretchMode;
        stretchMode = mStretchMode;
        int requestedColumnWidth;
        requestedColumnWidth = mRequestedColumnWidth;
        boolean didNotInitiallyFit;
        didNotInitiallyFit = false;
        {
            {
                mNumColumns = (availableSpace + requestedHorizontalSpacing) /
                        (requestedColumnWidth + requestedHorizontalSpacing);
            } //End block
            {
                mNumColumns = 2;
            } //End block
        } //End block
        {
            mNumColumns = mRequestedNumColumns;
        } //End block
        {
            mNumColumns = 1;
        } //End block
        //Begin case NO_STRETCH 
        mColumnWidth = requestedColumnWidth;
        //End case NO_STRETCH 
        //Begin case NO_STRETCH 
        mHorizontalSpacing = requestedHorizontalSpacing;
        //End case NO_STRETCH 
        //Begin case default 
        int spaceLeftOver;
        spaceLeftOver = availableSpace - (mNumColumns * requestedColumnWidth) -
                    ((mNumColumns - 1) * requestedHorizontalSpacing);
        //End case default 
        //Begin case default 
        {
            didNotInitiallyFit = true;
        } //End block
        //End case default 
        //Begin case default 
        //Begin case STRETCH_COLUMN_WIDTH 
        mColumnWidth = requestedColumnWidth + spaceLeftOver / mNumColumns;
        //End case STRETCH_COLUMN_WIDTH 
        //Begin case STRETCH_COLUMN_WIDTH 
        mHorizontalSpacing = requestedHorizontalSpacing;
        //End case STRETCH_COLUMN_WIDTH 
        //Begin case STRETCH_SPACING 
        mColumnWidth = requestedColumnWidth;
        //End case STRETCH_SPACING 
        //Begin case STRETCH_SPACING 
        {
            mHorizontalSpacing = requestedHorizontalSpacing + 
                        spaceLeftOver / (mNumColumns - 1);
        } //End block
        {
            mHorizontalSpacing = requestedHorizontalSpacing + spaceLeftOver;
        } //End block
        //End case STRETCH_SPACING 
        //Begin case STRETCH_SPACING_UNIFORM 
        mColumnWidth = requestedColumnWidth;
        //End case STRETCH_SPACING_UNIFORM 
        //Begin case STRETCH_SPACING_UNIFORM 
        {
            mHorizontalSpacing = requestedHorizontalSpacing + 
                        spaceLeftOver / (mNumColumns + 1);
        } //End block
        {
            mHorizontalSpacing = requestedHorizontalSpacing + spaceLeftOver;
        } //End block
        //End case STRETCH_SPACING_UNIFORM 
        //End case default 
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.921 -0400", hash_original_method = "DE2B2122B3B8477B4CE53B0961FAB462", hash_generated_method = "E3AE67DC9B5A6A67A6F42B2563CFFCAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(heightMeasureSpec);
        dsTaint.addTaint(widthMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode;
        widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode;
        heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize;
        widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize;
        heightSize = MeasureSpec.getSize(heightMeasureSpec);
        {
            {
                widthSize = mColumnWidth + mListPadding.left + mListPadding.right;
            } //End block
            {
                widthSize = mListPadding.left + mListPadding.right;
            } //End block
            widthSize += getVerticalScrollbarWidth();
        } //End block
        int childWidth;
        childWidth = widthSize - mListPadding.left - mListPadding.right;
        boolean didNotInitiallyFit;
        didNotInitiallyFit = determineColumns(childWidth);
        int childHeight;
        childHeight = 0;
        int childState;
        childState = 0;
        mItemCount = mAdapter == null ? 0 : mAdapter.getCount();
        int count;
        count = mItemCount;
        {
            View child;
            child = obtainView(0, mIsScrap);
            AbsListView.LayoutParams p;
            p = (AbsListView.LayoutParams)child.getLayoutParams();
            {
                p = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT, 0);
                child.setLayoutParams(p);
            } //End block
            p.viewType = mAdapter.getItemViewType(0);
            p.forceAdd = true;
            int childHeightSpec;
            childHeightSpec = getChildMeasureSpec(
                    MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED), 0, p.height);
            int childWidthSpec;
            childWidthSpec = getChildMeasureSpec(
                    MeasureSpec.makeMeasureSpec(mColumnWidth, MeasureSpec.EXACTLY), 0, p.width);
            child.measure(childWidthSpec, childHeightSpec);
            childHeight = child.getMeasuredHeight();
            childState = combineMeasuredStates(childState, child.getMeasuredState());
            {
                boolean varE2DAD11F47B1E984D553A4A012EB052E_1435110482 = (mRecycler.shouldRecycleViewType(p.viewType));
                {
                    mRecycler.addScrapView(child, -1);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            heightSize = mListPadding.top + mListPadding.bottom + childHeight +
                    getVerticalFadingEdgeLength() * 2;
        } //End block
        {
            int ourSize;
            ourSize = mListPadding.top + mListPadding.bottom;
            int numColumns;
            numColumns = mNumColumns;
            {
                int i;
                i = 0;
                i += numColumns;
                {
                    ourSize += childHeight;
                    {
                        ourSize += mVerticalSpacing;
                    } //End block
                    {
                        ourSize = heightSize;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            heightSize = ourSize;
        } //End block
        {
            int ourSize;
            ourSize = (mRequestedNumColumns*mColumnWidth)
                    + ((mRequestedNumColumns-1)*mHorizontalSpacing)
                    + mListPadding.left + mListPadding.right;
            {
                widthSize |= MEASURED_STATE_TOO_SMALL;
            } //End block
        } //End block
        setMeasuredDimension(widthSize, heightSize);
        mWidthMeasureSpec = widthMeasureSpec;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.922 -0400", hash_original_method = "B083102DF451B0F743637B4C2ECFBD00", hash_generated_method = "7D1344448E18EEAC5D5B67B700E41C9C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void attachLayoutAnimationParameters(View child,
            ViewGroup.LayoutParams params, int index, int count) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(index);
        dsTaint.addTaint(count);
        dsTaint.addTaint(params.dsTaint);
        GridLayoutAnimationController.AnimationParameters animationParams;
        animationParams = (GridLayoutAnimationController.AnimationParameters) params.layoutAnimationParameters;
        {
            animationParams = new GridLayoutAnimationController.AnimationParameters();
            params.layoutAnimationParameters = animationParams;
        } //End block
        animationParams.count = count;
        animationParams.index = index;
        animationParams.columnsCount = mNumColumns;
        animationParams.rowsCount = count / mNumColumns;
        {
            animationParams.column = index % mNumColumns;
            animationParams.row = index / mNumColumns;
        } //End block
        {
            int invertedIndex;
            invertedIndex = count - 1 - index;
            animationParams.column = mNumColumns - 1 - (invertedIndex % mNumColumns);
            animationParams.row = animationParams.rowsCount - 1 - invertedIndex / mNumColumns;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.923 -0400", hash_original_method = "22970971C8FD1FE9524617A911939C41", hash_generated_method = "4D763A2F7F05DEDD50AF13E353065290")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void layoutChildren() {
        boolean blockLayoutRequests;
        blockLayoutRequests = mBlockLayoutRequests;
        {
            mBlockLayoutRequests = true;
        } //End block
        try 
        {
            super.layoutChildren();
            invalidate();
            {
                resetList();
                invokeOnItemScrollListener();
            } //End block
            int childrenTop;
            childrenTop = mListPadding.top;
            int childrenBottom;
            childrenBottom = mBottom - mTop - mListPadding.bottom;
            int childCount;
            childCount = getChildCount();
            int index;
            int delta;
            delta = 0;
            View sel;
            View oldSel;
            oldSel = null;
            View oldFirst;
            oldFirst = null;
            View newSel;
            newSel = null;
            //Begin case LAYOUT_SET_SELECTION 
            index = mNextSelectedPosition - mFirstPosition;
            //End case LAYOUT_SET_SELECTION 
            //Begin case LAYOUT_SET_SELECTION 
            {
                newSel = getChildAt(index);
            } //End block
            //End case LAYOUT_SET_SELECTION 
            //Begin case LAYOUT_MOVE_SELECTION 
            {
                delta = mNextSelectedPosition - mSelectedPosition;
            } //End block
            //End case LAYOUT_MOVE_SELECTION 
            //Begin case default 
            index = mSelectedPosition - mFirstPosition;
            //End case default 
            //Begin case default 
            {
                oldSel = getChildAt(index);
            } //End block
            //End case default 
            //Begin case default 
            oldFirst = getChildAt(0);
            //End case default 
            boolean dataChanged;
            dataChanged = mDataChanged;
            {
                handleDataChanged();
            } //End block
            {
                resetList();
                invokeOnItemScrollListener();
            } //End block
            setSelectedPositionInt(mNextSelectedPosition);
            int firstPosition;
            firstPosition = mFirstPosition;
            RecycleBin recycleBin;
            recycleBin = mRecycler;
            {
                {
                    int i;
                    i = 0;
                    {
                        recycleBin.addScrapView(getChildAt(i), firstPosition+i);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                recycleBin.fillActiveViews(childCount, firstPosition);
            } //End block
            detachAllViewsFromParent();
            //Begin case LAYOUT_SET_SELECTION 
            {
                sel = fillFromSelection(newSel.getTop(), childrenTop, childrenBottom);
            } //End block
            {
                sel = fillSelection(childrenTop, childrenBottom);
            } //End block
            //End case LAYOUT_SET_SELECTION 
            //Begin case LAYOUT_FORCE_TOP 
            mFirstPosition = 0;
            //End case LAYOUT_FORCE_TOP 
            //Begin case LAYOUT_FORCE_TOP 
            sel = fillFromTop(childrenTop);
            //End case LAYOUT_FORCE_TOP 
            //Begin case LAYOUT_FORCE_TOP 
            adjustViewsUpOrDown();
            //End case LAYOUT_FORCE_TOP 
            //Begin case LAYOUT_FORCE_BOTTOM 
            sel = fillUp(mItemCount - 1, childrenBottom);
            //End case LAYOUT_FORCE_BOTTOM 
            //Begin case LAYOUT_FORCE_BOTTOM 
            adjustViewsUpOrDown();
            //End case LAYOUT_FORCE_BOTTOM 
            //Begin case LAYOUT_SPECIFIC 
            sel = fillSpecific(mSelectedPosition, mSpecificTop);
            //End case LAYOUT_SPECIFIC 
            //Begin case LAYOUT_SYNC 
            sel = fillSpecific(mSyncPosition, mSpecificTop);
            //End case LAYOUT_SYNC 
            //Begin case LAYOUT_MOVE_SELECTION 
            sel = moveSelection(delta, childrenTop, childrenBottom);
            //End case LAYOUT_MOVE_SELECTION 
            //Begin case default 
            {
                {
                    setSelectedPositionInt(mAdapter == null || isInTouchMode() ?
                                INVALID_POSITION : 0);
                    sel = fillFromTop(childrenTop);
                } //End block
                {
                    int last;
                    last = mItemCount - 1;
                    setSelectedPositionInt(mAdapter == null || isInTouchMode() ?
                                INVALID_POSITION : last);
                    sel = fillFromBottom(last, childrenBottom);
                } //End block
            } //End block
            {
                {
                    sel = fillSpecific(mSelectedPosition, oldSel == null ?
                                childrenTop : oldSel.getTop());
                } //End block
                {
                    sel = fillSpecific(mFirstPosition, oldFirst == null ?
                                childrenTop : oldFirst.getTop());
                } //End block
                {
                    sel = fillSpecific(0, childrenTop);
                } //End block
            } //End block
            //End case default 
            recycleBin.scrapActiveViews();
            {
                positionSelector(INVALID_POSITION, sel);
                mSelectedTop = sel.getTop();
            } //End block
            {
                View child;
                child = getChildAt(mMotionPosition - mFirstPosition);
                positionSelector(mMotionPosition, child);
            } //End block
            {
                mSelectedTop = 0;
                mSelectorRect.setEmpty();
            } //End block
            mLayoutMode = LAYOUT_NORMAL;
            mDataChanged = false;
            mNeedSync = false;
            setNextSelectedPositionInt(mSelectedPosition);
            updateScrollIndicators();
            {
                checkSelectionChanged();
            } //End block
            invokeOnItemScrollListener();
        } //End block
        finally 
        {
            {
                mBlockLayoutRequests = false;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.924 -0400", hash_original_method = "D1571833DCBC36BAA4E4DA8F2A5DB363", hash_generated_method = "7801AF994F5C2AA2FD4FE71778767C58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private View makeAndAddView(int position, int y, boolean flow, int childrenLeft,
            boolean selected, int where) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(selected);
        dsTaint.addTaint(childrenLeft);
        dsTaint.addTaint(flow);
        dsTaint.addTaint(where);
        dsTaint.addTaint(y);
        View child;
        {
            child = mRecycler.getActiveView(position);
            {
                setupChild(child, position, y, flow, childrenLeft, selected, true, where);
            } //End block
        } //End block
        child = obtainView(position, mIsScrap);
        setupChild(child, position, y, flow, childrenLeft, selected, mIsScrap[0], where);
        return (View)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.925 -0400", hash_original_method = "F1D84EEF4E6902A923E61B402C707D18", hash_generated_method = "FCD01A31176F59C24E2266344BF64FE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setupChild(View child, int position, int y, boolean flow, int childrenLeft,
            boolean selected, boolean recycled, int where) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(selected);
        dsTaint.addTaint(recycled);
        dsTaint.addTaint(childrenLeft);
        dsTaint.addTaint(flow);
        dsTaint.addTaint(where);
        dsTaint.addTaint(y);
        boolean isSelected;
        isSelected = selected && shouldShowSelector();
        boolean updateChildSelected;
        updateChildSelected = isSelected != child.isSelected();
        int mode;
        mode = mTouchMode;
        boolean isPressed;
        isPressed = mode > TOUCH_MODE_DOWN && mode < TOUCH_MODE_SCROLL &&
                mMotionPosition == position;
        boolean updateChildPressed;
        updateChildPressed = isPressed != child.isPressed();
        boolean needToMeasure;
        needToMeasure = !recycled || updateChildSelected || child.isLayoutRequested();
        AbsListView.LayoutParams p;
        p = (AbsListView.LayoutParams)child.getLayoutParams();
        {
            p = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, 0);
        } //End block
        p.viewType = mAdapter.getItemViewType(position);
        {
            attachViewToParent(child, where, p);
        } //End block
        {
            p.forceAdd = false;
            addViewInLayout(child, where, p, true);
        } //End block
        {
            child.setSelected(isSelected);
            {
                requestFocus();
            } //End block
        } //End block
        {
            child.setPressed(isPressed);
        } //End block
        {
            {
                ((Checkable) child).setChecked(mCheckStates.get(position));
            } //End block
            {
                boolean var6B8ECFCCB35D70022AE775423EF95EFF_933481421 = (getContext().getApplicationInfo().targetSdkVersion
                    >= android.os.Build.VERSION_CODES.HONEYCOMB);
                {
                    child.setActivated(mCheckStates.get(position));
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            int childHeightSpec;
            childHeightSpec = ViewGroup.getChildMeasureSpec(
                    MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED), 0, p.height);
            int childWidthSpec;
            childWidthSpec = ViewGroup.getChildMeasureSpec(
                    MeasureSpec.makeMeasureSpec(mColumnWidth, MeasureSpec.EXACTLY), 0, p.width);
            child.measure(childWidthSpec, childHeightSpec);
        } //End block
        {
            cleanupLayoutState(child);
        } //End block
        int w;
        w = child.getMeasuredWidth();
        int h;
        h = child.getMeasuredHeight();
        int childLeft;
        int childTop;
        childTop = y;
        childTop = y - h;
        int layoutDirection;
        layoutDirection = getResolvedLayoutDirection();
        int absoluteGravity;
        absoluteGravity = Gravity.getAbsoluteGravity(mGravity, layoutDirection);
        //Begin case Gravity.LEFT 
        childLeft = childrenLeft;
        //End case Gravity.LEFT 
        //Begin case Gravity.CENTER_HORIZONTAL 
        childLeft = childrenLeft + ((mColumnWidth - w) / 2);
        //End case Gravity.CENTER_HORIZONTAL 
        //Begin case Gravity.RIGHT 
        childLeft = childrenLeft + mColumnWidth - w;
        //End case Gravity.RIGHT 
        //Begin case default 
        childLeft = childrenLeft;
        //End case default 
        {
            int childRight;
            childRight = childLeft + w;
            int childBottom;
            childBottom = childTop + h;
            child.layout(childLeft, childTop, childRight, childBottom);
        } //End block
        {
            child.offsetLeftAndRight(childLeft - child.getLeft());
            child.offsetTopAndBottom(childTop - child.getTop());
        } //End block
        {
            child.setDrawingCacheEnabled(true);
        } //End block
        {
            boolean varCA9C9DB394586E5C1281E2A995FFCD63_359671803 = (recycled && (((AbsListView.LayoutParams)child.getLayoutParams()).scrappedFromPosition)
                != position);
            {
                child.jumpDrawablesToCurrentState();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.925 -0400", hash_original_method = "F036989DC17B53D064E56E9048AF8088", hash_generated_method = "12E6404BD489D5BBDD4BC09A17B40250")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setSelection(int position) {
        dsTaint.addTaint(position);
        {
            boolean var3DA6B9D2A4DFFBF2A8164819B7AFE9DF_1308511093 = (!isInTouchMode());
            {
                setNextSelectedPositionInt(position);
            } //End block
            {
                mResurrectToPosition = position;
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.925 -0400", hash_original_method = "BFD03D39F54176AB600127B7C1132704", hash_generated_method = "9F8F923D70DC16EA36F06EAFD26B1C24")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     void setSelectionInt(int position) {
        dsTaint.addTaint(position);
        int previousSelectedPosition;
        previousSelectedPosition = mNextSelectedPosition;
        setNextSelectedPositionInt(position);
        layoutChildren();
        int next;
        next = mItemCount - 1  - mNextSelectedPosition;
        next = mNextSelectedPosition;
        int previous;
        previous = mItemCount - 1
                - previousSelectedPosition;
        previous = previousSelectedPosition;
        int nextRow;
        nextRow = next / mNumColumns;
        int previousRow;
        previousRow = previous / mNumColumns;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.926 -0400", hash_original_method = "82498D99AFEB0700B1F959E9E9927B59", hash_generated_method = "9C3A4AA7BB01354EEF46E4FDFF96AF88")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        boolean var7B6BE27715D36B6032CB7DA2718D4FF1_469712089 = (commonKey(keyCode, 1, event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return commonKey(keyCode, 1, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.926 -0400", hash_original_method = "C105EC1B6481173F2A66D1C47882507B", hash_generated_method = "F0E8BBE8400726981137A9EA98145A80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(repeatCount);
        boolean varACEC8A58158104BC4BBB2FE543212B03_1044124671 = (commonKey(keyCode, repeatCount, event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return commonKey(keyCode, repeatCount, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.926 -0400", hash_original_method = "FFB4A1626C41573790F9B17FF23F8A09", hash_generated_method = "0F07A0D4E8A0369E903427D477D9E419")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        boolean var7B6BE27715D36B6032CB7DA2718D4FF1_1637320715 = (commonKey(keyCode, 1, event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return commonKey(keyCode, 1, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.927 -0400", hash_original_method = "91535B300D60431313446AA401FFCFE7", hash_generated_method = "8DF953550E61C3F8B556980DA7505261")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean commonKey(int keyCode, int count, KeyEvent event) {
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(count);
        dsTaint.addTaint(event.dsTaint);
        {
            layoutChildren();
        } //End block
        boolean handled;
        handled = false;
        int action;
        action = event.getAction();
        {
            //Begin case KeyEvent.KEYCODE_DPAD_LEFT 
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_1131407244 = (event.hasNoModifiers());
                {
                    handled = resurrectSelectionIfNeeded() || arrowScroll(FOCUS_LEFT);
                } //End block
            } //End collapsed parenthetic
            //End case KeyEvent.KEYCODE_DPAD_LEFT 
            //Begin case KeyEvent.KEYCODE_DPAD_RIGHT 
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_862583472 = (event.hasNoModifiers());
                {
                    handled = resurrectSelectionIfNeeded() || arrowScroll(FOCUS_RIGHT);
                } //End block
            } //End collapsed parenthetic
            //End case KeyEvent.KEYCODE_DPAD_RIGHT 
            //Begin case KeyEvent.KEYCODE_DPAD_UP 
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_1365333229 = (event.hasNoModifiers());
                {
                    handled = resurrectSelectionIfNeeded() || arrowScroll(FOCUS_UP);
                } //End block
                {
                    boolean varAB36CD08CFCE6244F546B808D5F456D4_1599445184 = (event.hasModifiers(KeyEvent.META_ALT_ON));
                    {
                        handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_UP);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            //End case KeyEvent.KEYCODE_DPAD_UP 
            //Begin case KeyEvent.KEYCODE_DPAD_DOWN 
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_2036009006 = (event.hasNoModifiers());
                {
                    handled = resurrectSelectionIfNeeded() || arrowScroll(FOCUS_DOWN);
                } //End block
                {
                    boolean varAB36CD08CFCE6244F546B808D5F456D4_1804145689 = (event.hasModifiers(KeyEvent.META_ALT_ON));
                    {
                        handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_DOWN);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            //End case KeyEvent.KEYCODE_DPAD_DOWN 
            //Begin case KeyEvent.KEYCODE_DPAD_CENTER KeyEvent.KEYCODE_ENTER 
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_471508539 = (event.hasNoModifiers());
                {
                    handled = resurrectSelectionIfNeeded();
                    {
                        boolean var8C90301B2F58C5750CCB877C7F321644_1649005211 = (!handled
                                && event.getRepeatCount() == 0 && getChildCount() > 0);
                        {
                            keyPressed();
                            handled = true;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            //End case KeyEvent.KEYCODE_DPAD_CENTER KeyEvent.KEYCODE_ENTER 
            //Begin case KeyEvent.KEYCODE_SPACE 
            {
                boolean varC5267D5BFE7A3E261BDE80A07A8ECCFA_1891039692 = (mPopup == null || !mPopup.isShowing());
                {
                    {
                        boolean var3A3095F7575E47050F710FB26AF5006E_1622203721 = (event.hasNoModifiers());
                        {
                            handled = resurrectSelectionIfNeeded() || pageScroll(FOCUS_DOWN);
                        } //End block
                        {
                            boolean varC6F58190DE4A31A0CF9704EF99A62451_987836368 = (event.hasModifiers(KeyEvent.META_SHIFT_ON));
                            {
                                handled = resurrectSelectionIfNeeded() || pageScroll(FOCUS_UP);
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            //End case KeyEvent.KEYCODE_SPACE 
            //Begin case KeyEvent.KEYCODE_PAGE_UP 
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_1201337101 = (event.hasNoModifiers());
                {
                    handled = resurrectSelectionIfNeeded() || pageScroll(FOCUS_UP);
                } //End block
                {
                    boolean varAB36CD08CFCE6244F546B808D5F456D4_1829613177 = (event.hasModifiers(KeyEvent.META_ALT_ON));
                    {
                        handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_UP);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            //End case KeyEvent.KEYCODE_PAGE_UP 
            //Begin case KeyEvent.KEYCODE_PAGE_DOWN 
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_1474482768 = (event.hasNoModifiers());
                {
                    handled = resurrectSelectionIfNeeded() || pageScroll(FOCUS_DOWN);
                } //End block
                {
                    boolean varAB36CD08CFCE6244F546B808D5F456D4_527325233 = (event.hasModifiers(KeyEvent.META_ALT_ON));
                    {
                        handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_DOWN);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            //End case KeyEvent.KEYCODE_PAGE_DOWN 
            //Begin case KeyEvent.KEYCODE_MOVE_HOME 
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_1007099250 = (event.hasNoModifiers());
                {
                    handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_UP);
                } //End block
            } //End collapsed parenthetic
            //End case KeyEvent.KEYCODE_MOVE_HOME 
            //Begin case KeyEvent.KEYCODE_MOVE_END 
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_931132653 = (event.hasNoModifiers());
                {
                    handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_DOWN);
                } //End block
            } //End collapsed parenthetic
            //End case KeyEvent.KEYCODE_MOVE_END 
            //Begin case KeyEvent.KEYCODE_TAB 
            {
                {
                    boolean varC77C0C11194BD87DFEE086A32DCE5C18_123651385 = (event.hasNoModifiers());
                    {
                        handled = resurrectSelectionIfNeeded()
                                    || sequenceScroll(FOCUS_FORWARD);
                    } //End block
                    {
                        boolean var7B1040B2192949CFC257B6EE7F25C319_2083481503 = (event.hasModifiers(KeyEvent.META_SHIFT_ON));
                        {
                            handled = resurrectSelectionIfNeeded()
                                    || sequenceScroll(FOCUS_BACKWARD);
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
            //End case KeyEvent.KEYCODE_TAB 
        } //End block
        {
            boolean varF6449376E291BB335EF050093EE80110_252209398 = (sendToTextFilter(keyCode, count, event));
        } //End collapsed parenthetic
        //Begin case KeyEvent.ACTION_DOWN 
        boolean var8C6E6C19273FC56B5C56CC7DEF63ED7B_1096029629 = (super.onKeyDown(keyCode, event));
        //End case KeyEvent.ACTION_DOWN 
        //Begin case KeyEvent.ACTION_UP 
        boolean varEDD771EBF66425AD21882AB08CD0EE48_399455514 = (super.onKeyUp(keyCode, event));
        //End case KeyEvent.ACTION_UP 
        //Begin case KeyEvent.ACTION_MULTIPLE 
        boolean varC0357E39557DD275ECAF43C782C78502_508534176 = (super.onKeyMultiple(keyCode, count, event));
        //End case KeyEvent.ACTION_MULTIPLE 
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.928 -0400", hash_original_method = "7F69D44B4A5B870A2ADF67B34BC1B3FD", hash_generated_method = "6FB724B598A1E8674A67C6C7F2A7DA5B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean pageScroll(int direction) {
        dsTaint.addTaint(direction);
        int nextPage;
        nextPage = -1;
        {
            nextPage = Math.max(0, mSelectedPosition - getChildCount());
        } //End block
        {
            nextPage = Math.min(mItemCount - 1, mSelectedPosition + getChildCount());
        } //End block
        {
            setSelectionInt(nextPage);
            invokeOnItemScrollListener();
            awakenScrollBars();
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.928 -0400", hash_original_method = "8921946161DEF2C387CE09B16F70206C", hash_generated_method = "87C1E1651617B00F0E89254E1C00575F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean fullScroll(int direction) {
        dsTaint.addTaint(direction);
        boolean moved;
        moved = false;
        {
            mLayoutMode = LAYOUT_SET_SELECTION;
            setSelectionInt(0);
            invokeOnItemScrollListener();
            moved = true;
        } //End block
        {
            mLayoutMode = LAYOUT_SET_SELECTION;
            setSelectionInt(mItemCount - 1);
            invokeOnItemScrollListener();
            moved = true;
        } //End block
        {
            awakenScrollBars();
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.929 -0400", hash_original_method = "8CD79681F48962D4344E68AA337F0770", hash_generated_method = "C042614E10D2E2BB8C2FAF66FF3179D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean arrowScroll(int direction) {
        dsTaint.addTaint(direction);
        int selectedPosition;
        selectedPosition = mSelectedPosition;
        int numColumns;
        numColumns = mNumColumns;
        int startOfRowPos;
        int endOfRowPos;
        boolean moved;
        moved = false;
        {
            startOfRowPos = (selectedPosition / numColumns) * numColumns;
            endOfRowPos = Math.min(startOfRowPos + numColumns - 1, mItemCount - 1);
        } //End block
        {
            int invertedSelection;
            invertedSelection = mItemCount - 1 - selectedPosition;
            endOfRowPos = mItemCount - 1 - (invertedSelection / numColumns) * numColumns;
            startOfRowPos = Math.max(0, endOfRowPos - numColumns + 1);
        } //End block
        //Begin case FOCUS_UP 
        {
            mLayoutMode = LAYOUT_MOVE_SELECTION;
            setSelectionInt(Math.max(0, selectedPosition - numColumns));
            moved = true;
        } //End block
        //End case FOCUS_UP 
        //Begin case FOCUS_DOWN 
        {
            mLayoutMode = LAYOUT_MOVE_SELECTION;
            setSelectionInt(Math.min(selectedPosition + numColumns, mItemCount - 1));
            moved = true;
        } //End block
        //End case FOCUS_DOWN 
        //Begin case FOCUS_LEFT 
        {
            mLayoutMode = LAYOUT_MOVE_SELECTION;
            setSelectionInt(Math.max(0, selectedPosition - 1));
            moved = true;
        } //End block
        //End case FOCUS_LEFT 
        //Begin case FOCUS_RIGHT 
        {
            mLayoutMode = LAYOUT_MOVE_SELECTION;
            setSelectionInt(Math.min(selectedPosition + 1, mItemCount - 1));
            moved = true;
        } //End block
        //End case FOCUS_RIGHT 
        {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(direction));
            invokeOnItemScrollListener();
        } //End block
        {
            awakenScrollBars();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.929 -0400", hash_original_method = "3D7E63CDF154AB38FFF5F8515CF699BF", hash_generated_method = "CA402622F5A2AA938F00C73C0544E78D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean sequenceScroll(int direction) {
        dsTaint.addTaint(direction);
        int selectedPosition;
        selectedPosition = mSelectedPosition;
        int numColumns;
        numColumns = mNumColumns;
        int count;
        count = mItemCount;
        int startOfRow;
        int endOfRow;
        {
            startOfRow = (selectedPosition / numColumns) * numColumns;
            endOfRow = Math.min(startOfRow + numColumns - 1, count - 1);
        } //End block
        {
            int invertedSelection;
            invertedSelection = count - 1 - selectedPosition;
            endOfRow = count - 1 - (invertedSelection / numColumns) * numColumns;
            startOfRow = Math.max(0, endOfRow - numColumns + 1);
        } //End block
        boolean moved;
        moved = false;
        boolean showScroll;
        showScroll = false;
        //Begin case FOCUS_FORWARD 
        {
            mLayoutMode = LAYOUT_MOVE_SELECTION;
            setSelectionInt(selectedPosition + 1);
            moved = true;
            showScroll = selectedPosition == endOfRow;
        } //End block
        //End case FOCUS_FORWARD 
        //Begin case FOCUS_BACKWARD 
        {
            mLayoutMode = LAYOUT_MOVE_SELECTION;
            setSelectionInt(selectedPosition - 1);
            moved = true;
            showScroll = selectedPosition == startOfRow;
        } //End block
        //End case FOCUS_BACKWARD 
        {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(direction));
            invokeOnItemScrollListener();
        } //End block
        {
            awakenScrollBars();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.930 -0400", hash_original_method = "0FD361D132773200063DCB66E88E964C", hash_generated_method = "670713CFEAD6F6BB6C98B44FA87C99D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(gainFocus);
        dsTaint.addTaint(direction);
        dsTaint.addTaint(previouslyFocusedRect.dsTaint);
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        int closestChildIndex;
        closestChildIndex = -1;
        {
            previouslyFocusedRect.offset(mScrollX, mScrollY);
            Rect otherRect;
            otherRect = mTempRect;
            int minDistance;
            minDistance = Integer.MAX_VALUE;
            int childCount;
            childCount = getChildCount();
            {
                int i;
                i = 0;
                {
                    {
                        boolean var4F49F74F736BC8C7CC9FE76A9F30A707_1591849818 = (!isCandidateSelection(i, direction));
                    } //End collapsed parenthetic
                    View other;
                    other = getChildAt(i);
                    other.getDrawingRect(otherRect);
                    offsetDescendantRectToMyCoords(other, otherRect);
                    int distance;
                    distance = getDistance(previouslyFocusedRect, otherRect, direction);
                    {
                        minDistance = distance;
                        closestChildIndex = i;
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            setSelection(closestChildIndex + mFirstPosition);
        } //End block
        {
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.931 -0400", hash_original_method = "84D213429BEB1496C8F56DF85FD23E87", hash_generated_method = "65211036C7892DE6E7597B02770B241A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isCandidateSelection(int childIndex, int direction) {
        dsTaint.addTaint(direction);
        dsTaint.addTaint(childIndex);
        int count;
        count = getChildCount();
        int invertedIndex;
        invertedIndex = count - 1 - childIndex;
        int rowStart;
        int rowEnd;
        {
            rowStart = childIndex - (childIndex % mNumColumns);
            rowEnd = Math.max(rowStart + mNumColumns - 1, count);
        } //End block
        {
            rowEnd = count - 1 - (invertedIndex - (invertedIndex % mNumColumns));
            rowStart = Math.max(0, rowEnd - mNumColumns + 1);
        } //End block
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("direction must be one of "
                        + "{FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, "
                        + "FOCUS_FORWARD, FOCUS_BACKWARD}.");
        //End case default 
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.932 -0400", hash_original_method = "FC2053B842AF8EFA285EBFCDE9A6D098", hash_generated_method = "28DDD4202BD998FA84289DAFF1C8A0B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setGravity(int gravity) {
        dsTaint.addTaint(gravity);
        {
            requestLayoutIfNecessary();
        } //End block
        // ---------- Original Method ----------
        //if (mGravity != gravity) {
            //mGravity = gravity;
            //requestLayoutIfNecessary();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.932 -0400", hash_original_method = "F4AD294FF1286508B5C248EDCA212E5B", hash_generated_method = "E28F6A545CCADBE7942C9386FCD70E9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setHorizontalSpacing(int horizontalSpacing) {
        dsTaint.addTaint(horizontalSpacing);
        {
            requestLayoutIfNecessary();
        } //End block
        // ---------- Original Method ----------
        //if (horizontalSpacing != mRequestedHorizontalSpacing) {
            //mRequestedHorizontalSpacing = horizontalSpacing;
            //requestLayoutIfNecessary();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.932 -0400", hash_original_method = "18D0FB9D8A0D215DBABAAD70588CEE39", hash_generated_method = "950DDCFD636C5B41FA354E19CDC2FF06")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setVerticalSpacing(int verticalSpacing) {
        dsTaint.addTaint(verticalSpacing);
        {
            requestLayoutIfNecessary();
        } //End block
        // ---------- Original Method ----------
        //if (verticalSpacing != mVerticalSpacing) {
            //mVerticalSpacing = verticalSpacing;
            //requestLayoutIfNecessary();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.932 -0400", hash_original_method = "C49A7586B9CFE9BA77F47A780C0C8544", hash_generated_method = "F12B280C96DCF869EE89F5FB820BA0E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setStretchMode(int stretchMode) {
        dsTaint.addTaint(stretchMode);
        {
            requestLayoutIfNecessary();
        } //End block
        // ---------- Original Method ----------
        //if (stretchMode != mStretchMode) {
            //mStretchMode = stretchMode;
            //requestLayoutIfNecessary();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.932 -0400", hash_original_method = "B323AFE5AE5939BBDA58166A4DF4B096", hash_generated_method = "41250BE68CCF2A135521A31999955C46")
    @DSModeled(DSC.SAFE)
    public int getStretchMode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mStretchMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.933 -0400", hash_original_method = "2D3707A47407D7324964709BC50279C2", hash_generated_method = "7A0D94B08FE0A26944A850D255A2BE97")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setColumnWidth(int columnWidth) {
        dsTaint.addTaint(columnWidth);
        {
            requestLayoutIfNecessary();
        } //End block
        // ---------- Original Method ----------
        //if (columnWidth != mRequestedColumnWidth) {
            //mRequestedColumnWidth = columnWidth;
            //requestLayoutIfNecessary();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.933 -0400", hash_original_method = "EB843153C85390AE48F1C91EE0B42CDB", hash_generated_method = "E7983305713715D4F6905D57C81A2F84")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setNumColumns(int numColumns) {
        dsTaint.addTaint(numColumns);
        {
            requestLayoutIfNecessary();
        } //End block
        // ---------- Original Method ----------
        //if (numColumns != mRequestedNumColumns) {
            //mRequestedNumColumns = numColumns;
            //requestLayoutIfNecessary();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.933 -0400", hash_original_method = "B011FDCEBE38F0939F62249D6B5BC711", hash_generated_method = "3836C1A3AF9CE8E81CEC6FE3C60291BD")
    @DSModeled(DSC.SAFE)
    @ViewDebug.ExportedProperty
    public int getNumColumns() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mNumColumns;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.933 -0400", hash_original_method = "614329ACA245384517EF28FF3609B04B", hash_generated_method = "9FA2292934F9A98536289BB9C57477FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void adjustViewsUpOrDown() {
        int childCount;
        childCount = getChildCount();
        {
            int delta;
            View child;
            {
                child = getChildAt(0);
                delta = child.getTop() - mListPadding.top;
                {
                    delta -= mVerticalSpacing;
                } //End block
                {
                    delta = 0;
                } //End block
            } //End block
            {
                child = getChildAt(childCount - 1);
                delta = child.getBottom() - (getHeight() - mListPadding.bottom);
                {
                    delta += mVerticalSpacing;
                } //End block
                {
                    delta = 0;
                } //End block
            } //End block
            {
                offsetChildrenTopAndBottom(-delta);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.934 -0400", hash_original_method = "0FB16985DD2A598E66D7882D349B86AF", hash_generated_method = "60859BF1B865EEF88BEC3CA6B5030998")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int computeVerticalScrollExtent() {
        int count;
        count = getChildCount();
        {
            int numColumns;
            numColumns = mNumColumns;
            int rowCount;
            rowCount = (count + numColumns - 1) / numColumns;
            int extent;
            extent = rowCount * 100;
            View view;
            view = getChildAt(0);
            int top;
            top = view.getTop();
            int height;
            height = view.getHeight();
            {
                extent += (top * 100) / height;
            } //End block
            view = getChildAt(count - 1);
            int bottom;
            bottom = view.getBottom();
            height = view.getHeight();
            {
                extent -= ((bottom - getHeight()) * 100) / height;
            } //End block
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.934 -0400", hash_original_method = "77C851014C1118924C7173C75459421E", hash_generated_method = "F62446D798D238D0387CE9CC284B9992")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int computeVerticalScrollOffset() {
        {
            boolean var55F650244283761A6D0270E03F2533A0_143921330 = (mFirstPosition >= 0 && getChildCount() > 0);
            {
                View view;
                view = getChildAt(0);
                int top;
                top = view.getTop();
                int height;
                height = view.getHeight();
                {
                    int numColumns;
                    numColumns = mNumColumns;
                    int whichRow;
                    whichRow = mFirstPosition / numColumns;
                    int rowCount;
                    rowCount = (mItemCount + numColumns - 1) / numColumns;
                    int varBBCDFA4A3F60B9FD9A50F6BC86F61153_522653005 = (Math.max(whichRow * 100 - (top * 100) / height +
                        (int) ((float) mScrollY / getHeight() * rowCount * 100), 0));
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.934 -0400", hash_original_method = "2E67C9F09804D125789DA130D24F2E03", hash_generated_method = "E9682B2E77F98905C5407A7972F98A59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int computeVerticalScrollRange() {
        int numColumns;
        numColumns = mNumColumns;
        int rowCount;
        rowCount = (mItemCount + numColumns - 1) / numColumns;
        int result;
        result = Math.max(rowCount * 100, 0);
        {
            result += Math.abs((int) ((float) mScrollY / getHeight() * rowCount * 100));
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //final int numColumns = mNumColumns;
        //final int rowCount = (mItemCount + numColumns - 1) / numColumns;
        //int result = Math.max(rowCount * 100, 0);
        //if (mScrollY != 0) {
            //result += Math.abs((int) ((float) mScrollY / getHeight() * rowCount * 100));
        //}
        //return result;
    }

    
    public static final int NO_STRETCH = 0;
    public static final int STRETCH_SPACING = 1;
    public static final int STRETCH_COLUMN_WIDTH = 2;
    public static final int STRETCH_SPACING_UNIFORM = 3;
    public static final int AUTO_FIT = -1;
}

