package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.373 -0500", hash_original_field = "AA9505FB63AC8A6E04FA498825632C58", hash_generated_field = "9591D43DFDB00D3CA815C6412336BEEB")

    public static final int NO_STRETCH = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.375 -0500", hash_original_field = "2B8F6C80CB7656380C71A26D86BF35B8", hash_generated_field = "9E8C93D13663D982A634A608E98FDD9B")

    public static final int STRETCH_SPACING = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.377 -0500", hash_original_field = "FADB7B990BED7CB16448F2B495075292", hash_generated_field = "289B7802E2F88C85889BF1B0A565B14F")

    public static final int STRETCH_COLUMN_WIDTH = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.380 -0500", hash_original_field = "2C3B314821C01D79900ED76E9568C123", hash_generated_field = "6D329753C82DAECBEDD98AD073821537")

    public static final int STRETCH_SPACING_UNIFORM = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.382 -0500", hash_original_field = "7AE414B6E3FDF5794DA2E7F5F95AD4E7", hash_generated_field = "4306712C3BDDA946F401316F516F19DA")

    public static final int AUTO_FIT = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.384 -0500", hash_original_field = "FF954460C058F9850B071838DB89D777", hash_generated_field = "CAA46A02DF073835D5C8346AD9A9CB63")

    private int mNumColumns = AUTO_FIT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.386 -0500", hash_original_field = "36532247BB66EBCEC9C2909C8C214F9A", hash_generated_field = "E9FAC14F36FB56A0DCAB954B62C2DF2B")

    private int mHorizontalSpacing = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.388 -0500", hash_original_field = "CC8BFE99FA435C599B5CE534CA3668C2", hash_generated_field = "A39AD23AD5FCB84AB23C237FC706C8F3")

    private int mRequestedHorizontalSpacing;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.390 -0500", hash_original_field = "5024B7F3F3982CE57078015544AC97DA", hash_generated_field = "84EB60F5A5BD3F778480F01C86BB8AA9")

    private int mVerticalSpacing = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.392 -0500", hash_original_field = "CD4B3749DEA299C5D382D9566F41C60C", hash_generated_field = "AEA63239A963A24EEC1FCFD67B3B96A7")

    private int mStretchMode = STRETCH_COLUMN_WIDTH;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.394 -0500", hash_original_field = "FA95CF42D267D5EDBA7356F252235DAA", hash_generated_field = "20F46DBB58574C7E2F33333D8FE15571")

    private int mColumnWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.397 -0500", hash_original_field = "08E369086E00B2136AA41BC71D6E0434", hash_generated_field = "7063064B546DF13BA7FDA901DDEC5780")

    private int mRequestedColumnWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.400 -0500", hash_original_field = "222C7835339618E2856578BAC1EE214A", hash_generated_field = "583D48FC72E3B18BBAD06B1F4E148F28")

    private int mRequestedNumColumns;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.401 -0500", hash_original_field = "6F0C9DF59CFE2519A9B8815AD263A61C", hash_generated_field = "7823B4B6322E0EBEB34297B0E440B23B")

    private View mReferenceView = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.404 -0500", hash_original_field = "1B403D9B6056B08D3947AD2750BD356A", hash_generated_field = "E909A7C80DCAC01F178BEF4C30386FF5")

    private View mReferenceViewInSelectedRow = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.405 -0500", hash_original_field = "355EDF65F5C1DDC97F67C7157FA2BE28", hash_generated_field = "B1F879D1C3141C34182BB7A64318C608")

    private int mGravity = Gravity.LEFT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.408 -0500", hash_original_field = "1732EB32F2D77CCA26590AEEA670A175", hash_generated_field = "A498F2A4744F31D22F9C4ABEBB254F2F")

    private final Rect mTempRect = new Rect();

    @DSComment("GUI GridView")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.410 -0500", hash_original_method = "6B9AD93D67DF35D03ADA1536C0A58FBF", hash_generated_method = "ABE07628F01D694A867DBF39CAE0DF48")
    
public GridView(Context context) {
        super(context);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.413 -0500", hash_original_method = "2A531A248703ACB5E0E1C6A31088A2B2", hash_generated_method = "C8E003F513916A22C8931158363EF113")
    
public GridView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.gridViewStyle);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.416 -0500", hash_original_method = "49F6501DFACF5B2EADDBFC02F7376929", hash_generated_method = "DCB10ACAC309C5FAFBFCB89156380193")
    
public GridView(Context context, AttributeSet attrs, int defStyle) {
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
        if (index >= 0) {
            setStretchMode(index);
        }

        int columnWidth = a.getDimensionPixelOffset(com.android.internal.R.styleable.GridView_columnWidth, -1);
        if (columnWidth > 0) {
            setColumnWidth(columnWidth);
        }

        int numColumns = a.getInt(com.android.internal.R.styleable.GridView_numColumns, 1);
        setNumColumns(numColumns);

        index = a.getInt(com.android.internal.R.styleable.GridView_gravity, -1);
        if (index >= 0) {
            setGravity(index);
        }
        
        a.recycle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.418 -0500", hash_original_method = "0E1A05724C497F45D7FB6AC34C501814", hash_generated_method = "5911CDE294032BE1D85FC272F0A8BA9B")
    
@Override
    public ListAdapter getAdapter() {
        return mAdapter;
    }

    /**
     * Sets up this AbsListView to use a remote views adapter which connects to a RemoteViewsService
     * through the specified intent.
     * @param intent the intent used to identify the RemoteViewsService for the adapter to connect to.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.420 -0500", hash_original_method = "8AB2C6958FD7CEC3A8A71FE59763D6A4", hash_generated_method = "06FC87714B69CEC8209EE3A8D52302FA")
    
@android.view.RemotableViewMethod
    public void setRemoteViewsAdapter(Intent intent) {
        super.setRemoteViewsAdapter(intent);
    }

    /**
     * Sets the data behind this GridView.
     *
     * @param adapter the adapter providing the grid's data
     */
    @DSComment("GUI GridView")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.423 -0500", hash_original_method = "3B0F7EFF2AD6466D19A6F404E2E1BAAD", hash_generated_method = "95DC0512BE57B2D786ABF045066D9B37")
    
@Override
    public void setAdapter(ListAdapter adapter) {
        if (mAdapter != null && mDataSetObserver != null) {
            mAdapter.unregisterDataSetObserver(mDataSetObserver);
        }

        resetList();
        mRecycler.clear();        
        mAdapter = adapter;

        mOldSelectedPosition = INVALID_POSITION;
        mOldSelectedRowId = INVALID_ROW_ID;

        // AbsListView#setAdapter will update choice mode states.
        super.setAdapter(adapter);

        if (mAdapter != null) {
            mOldItemCount = mItemCount;
            mItemCount = mAdapter.getCount();
            mDataChanged = true;
            checkFocus();

            mDataSetObserver = new AdapterDataSetObserver();
            mAdapter.registerDataSetObserver(mDataSetObserver);

            mRecycler.setViewTypeCount(mAdapter.getViewTypeCount());

            int position;
            if (mStackFromBottom) {
                position = lookForSelectablePosition(mItemCount - 1, false);
            } else {
                position = lookForSelectablePosition(0, true);
            }
            setSelectedPositionInt(position);
            setNextSelectedPositionInt(position);
            checkSelectionChanged();
        } else {
            checkFocus();            
            // Nothing selected
            checkSelectionChanged();
        }

        requestLayout();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.426 -0500", hash_original_method = "D52FAC74E641441314EFBB7F4E58B879", hash_generated_method = "5BE650E550795B7D2F93D3D9635973EB")
    
@Override
    int lookForSelectablePosition(int position, boolean lookDown) {
        final ListAdapter adapter = mAdapter;
        if (adapter == null || isInTouchMode()) {
            return INVALID_POSITION;
        }

        if (position < 0 || position >= mItemCount) {
            return INVALID_POSITION;
        }
        return position;
    }

    /**
     * {@inheritDoc}
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.429 -0500", hash_original_method = "A62E9A831AF61A8CD347891B2F9D44DF", hash_generated_method = "6BE84A6B8663E3303FA976ACD011B45D")
    
@Override
    void fillGap(boolean down) {
        final int numColumns = mNumColumns;
        final int verticalSpacing = mVerticalSpacing;

        final int count = getChildCount();

        if (down) {
            int paddingTop = 0;
            if ((mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK) {
                paddingTop = getListPaddingTop();
            }
            final int startOffset = count > 0 ?
                    getChildAt(count - 1).getBottom() + verticalSpacing : paddingTop;
            int position = mFirstPosition + count;
            if (mStackFromBottom) {
                position += numColumns - 1;
            }
            fillDown(position, startOffset);
            correctTooHigh(numColumns, verticalSpacing, getChildCount());
        } else {
            int paddingBottom = 0;
            if ((mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK) {
                paddingBottom = getListPaddingBottom();
            }
            final int startOffset = count > 0 ?
                    getChildAt(0).getTop() - verticalSpacing : getHeight() - paddingBottom;
            int position = mFirstPosition;
            if (!mStackFromBottom) {
                position -= numColumns;
            } else {
                position--;
            }
            fillUp(position, startOffset);
            correctTooLow(numColumns, verticalSpacing, getChildCount());
        }
    }

    /**
     * Fills the list from pos down to the end of the list view.
     *
     * @param pos The first position to put in the list
     *
     * @param nextTop The location where the top of the item associated with pos
     *        should be drawn
     *
     * @return The view that is currently selected, if it happens to be in the
     *         range that we draw.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.431 -0500", hash_original_method = "6F9360E73E1EB4E0BD6CC48A029E26CB", hash_generated_method = "9B7A92D2BF07B2DF3B6AEF824EA1D2A5")
    
private View fillDown(int pos, int nextTop) {
        View selectedView = null;

        int end = (mBottom - mTop);
        if ((mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK) {
            end -= mListPadding.bottom;
        }

        while (nextTop < end && pos < mItemCount) {
            View temp = makeRow(pos, nextTop, true);
            if (temp != null) {
                selectedView = temp;
            }

            // mReferenceView will change with each call to makeRow()
            // do not cache in a local variable outside of this loop
            nextTop = mReferenceView.getBottom() + mVerticalSpacing;

            pos += mNumColumns;
        }

        return selectedView;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.435 -0500", hash_original_method = "DFB797BE7486A81865BE6BA7ABEE8F5A", hash_generated_method = "24F3B769B15A0DA67FF034B71647A995")
    
private View makeRow(int startPos, int y, boolean flow) {
        final int columnWidth = mColumnWidth;
        final int horizontalSpacing = mHorizontalSpacing;

        int last;
        int nextLeft = mListPadding.left +
                ((mStretchMode == STRETCH_SPACING_UNIFORM) ? horizontalSpacing : 0);

        if (!mStackFromBottom) {
            last = Math.min(startPos + mNumColumns, mItemCount);
        } else {
            last = startPos + 1;
            startPos = Math.max(0, startPos - mNumColumns + 1);

            if (last - startPos < mNumColumns) {
                nextLeft += (mNumColumns - (last - startPos)) * (columnWidth + horizontalSpacing);
            }
        }

        View selectedView = null;

        final boolean hasFocus = shouldShowSelector();
        final boolean inClick = touchModeDrawsInPressedState();
        final int selectedPosition = mSelectedPosition;

        View child = null;
        for (int pos = startPos; pos < last; pos++) {
            // is this the selected item?
            boolean selected = pos == selectedPosition;
            // does the list view have focus or contain focus

            final int where = flow ? -1 : pos - startPos;
            child = makeAndAddView(pos, y, flow, nextLeft, selected, where);

            nextLeft += columnWidth;
            if (pos < last - 1) {
                nextLeft += horizontalSpacing;
            }

            if (selected && (hasFocus || inClick)) {
                selectedView = child;
            }
        }

        mReferenceView = child;
        
        if (selectedView != null) {
            mReferenceViewInSelectedRow = mReferenceView;
        }

        return selectedView;
    }

    /**
     * Fills the list from pos up to the top of the list view.
     *
     * @param pos The first position to put in the list
     *
     * @param nextBottom The location where the bottom of the item associated
     *        with pos should be drawn
     *
     * @return The view that is currently selected
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.437 -0500", hash_original_method = "0AADB00D4F358179B46AC864F825D76F", hash_generated_method = "4719EEDEE4C902BF241C158D768547A3")
    
private View fillUp(int pos, int nextBottom) {
        View selectedView = null;

        int end = 0;
        if ((mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK) {
            end = mListPadding.top;
        }

        while (nextBottom > end && pos >= 0) {

            View temp = makeRow(pos, nextBottom, false);
            if (temp != null) {
                selectedView = temp;
            }

            nextBottom = mReferenceView.getTop() - mVerticalSpacing;

            mFirstPosition = pos;

            pos -= mNumColumns;
        }

        if (mStackFromBottom) {
            mFirstPosition = Math.max(0, pos + 1);
        }

        return selectedView;
    }

    /**
     * Fills the list from top to bottom, starting with mFirstPosition
     *
     * @param nextTop The location where the top of the first item should be
     *        drawn
     *
     * @return The view that is currently selected
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.440 -0500", hash_original_method = "ECD7EEB642891ACE11FADF160200B8D1", hash_generated_method = "33C179F165B0173000D1AC24FD82604B")
    
private View fillFromTop(int nextTop) {
        mFirstPosition = Math.min(mFirstPosition, mSelectedPosition);
        mFirstPosition = Math.min(mFirstPosition, mItemCount - 1);
        if (mFirstPosition < 0) {
            mFirstPosition = 0;
        }
        mFirstPosition -= mFirstPosition % mNumColumns;
        return fillDown(mFirstPosition, nextTop);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.442 -0500", hash_original_method = "0818B9EEFC7CF79A0018AB61F39070C0", hash_generated_method = "99596D7CD85B855E8DABA66A5052D9A7")
    
private View fillFromBottom(int lastPosition, int nextBottom) {
        lastPosition = Math.max(lastPosition, mSelectedPosition);
        lastPosition = Math.min(lastPosition, mItemCount - 1);

        final int invertedPosition = mItemCount - 1 - lastPosition;
        lastPosition = mItemCount - 1 - (invertedPosition - (invertedPosition % mNumColumns));

        return fillUp(lastPosition, nextBottom);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.445 -0500", hash_original_method = "B869E7B5DD0E41AF8A9344426795B32C", hash_generated_method = "F8B85C969CFEEC3D8547C620DF054DBA")
    
private View fillSelection(int childrenTop, int childrenBottom) {
        final int selectedPosition = reconcileSelectedPosition();
        final int numColumns = mNumColumns;
        final int verticalSpacing = mVerticalSpacing;

        int rowStart;
        int rowEnd = -1;

        if (!mStackFromBottom) {
            rowStart = selectedPosition - (selectedPosition % numColumns);
        } else {
            final int invertedSelection = mItemCount - 1 - selectedPosition;

            rowEnd = mItemCount - 1 - (invertedSelection - (invertedSelection % numColumns));
            rowStart = Math.max(0, rowEnd - numColumns + 1);
        }

        final int fadingEdgeLength = getVerticalFadingEdgeLength();
        final int topSelectionPixel = getTopSelectionPixel(childrenTop, fadingEdgeLength, rowStart);

        final View sel = makeRow(mStackFromBottom ? rowEnd : rowStart, topSelectionPixel, true);
        mFirstPosition = rowStart;

        final View referenceView = mReferenceView;

        if (!mStackFromBottom) {
            fillDown(rowStart + numColumns, referenceView.getBottom() + verticalSpacing);
            pinToBottom(childrenBottom);
            fillUp(rowStart - numColumns, referenceView.getTop() - verticalSpacing);
            adjustViewsUpOrDown();
        } else {
            final int bottomSelectionPixel = getBottomSelectionPixel(childrenBottom,
                    fadingEdgeLength, numColumns, rowStart);
            final int offset = bottomSelectionPixel - referenceView.getBottom();
            offsetChildrenTopAndBottom(offset);
            fillUp(rowStart - 1, referenceView.getTop() - verticalSpacing);
            pinToTop(childrenTop);
            fillDown(rowEnd + numColumns, referenceView.getBottom() + verticalSpacing);
            adjustViewsUpOrDown();
        }

        return sel;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.501 -0500", hash_original_method = "535BA4E594C209A488B214DB13AE774F", hash_generated_method = "EB24F9663D958D121E266B1DF47E08C5")
    
private void pinToTop(int childrenTop) {
        if (mFirstPosition == 0) {
            final int top = getChildAt(0).getTop();
            final int offset = childrenTop - top;
            if (offset < 0) {
                offsetChildrenTopAndBottom(offset);
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.504 -0500", hash_original_method = "554B5C3A9DEE69BDD0B0F70052D29046", hash_generated_method = "B5244A1E92CCBB44E425821B936F64D4")
    
private void pinToBottom(int childrenBottom) {
        final int count = getChildCount();
        if (mFirstPosition + count == mItemCount) {
            final int bottom = getChildAt(count - 1).getBottom();
            final int offset = childrenBottom - bottom;
            if (offset > 0) {
                offsetChildrenTopAndBottom(offset);
            }
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.506 -0500", hash_original_method = "584D06EE6653E11D28AE97D7ADF4C3E4", hash_generated_method = "8861CD9CEAD89E19D16DF2CF0D1962F3")
    
@Override
    int findMotionRow(int y) {
        final int childCount = getChildCount();
        if (childCount > 0) {

            final int numColumns = mNumColumns;
            if (!mStackFromBottom) {
                for (int i = 0; i < childCount; i += numColumns) {
                    if (y <= getChildAt(i).getBottom()) {
                        return mFirstPosition + i;
                    }
                }
            } else {
                for (int i = childCount - 1; i >= 0; i -= numColumns) {
                    if (y >= getChildAt(i).getTop()) {
                        return mFirstPosition + i;
                    }
                }
            }
        }
        return INVALID_POSITION;
    }

    /**
     * Layout during a scroll that results from tracking motion events. Places
     * the mMotionPosition view at the offset specified by mMotionViewTop, and
     * then build surrounding views from there.
     *
     * @param position the position at which to start filling
     * @param top the top of the view at that position
     * @return The selected view, or null if the selected view is outside the
     *         visible area.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.509 -0500", hash_original_method = "2BE5C63CD6BB6072D8C1046433555060", hash_generated_method = "5AD83F81760763EF512D2ACACD902724")
    
private View fillSpecific(int position, int top) {
        final int numColumns = mNumColumns;

        int motionRowStart;
        int motionRowEnd = -1;

        if (!mStackFromBottom) {
            motionRowStart = position - (position % numColumns);
        } else {
            final int invertedSelection = mItemCount - 1 - position;

            motionRowEnd = mItemCount - 1 - (invertedSelection - (invertedSelection % numColumns));
            motionRowStart = Math.max(0, motionRowEnd - numColumns + 1);
        }

        final View temp = makeRow(mStackFromBottom ? motionRowEnd : motionRowStart, top, true);

        // Possibly changed again in fillUp if we add rows above this one.
        mFirstPosition = motionRowStart;

        final View referenceView = mReferenceView;
        // We didn't have anything to layout, bail out
        if (referenceView == null) {
            return null;
        }

        final int verticalSpacing = mVerticalSpacing;

        View above;
        View below;

        if (!mStackFromBottom) {
            above = fillUp(motionRowStart - numColumns, referenceView.getTop() - verticalSpacing);
            adjustViewsUpOrDown();
            below = fillDown(motionRowStart + numColumns, referenceView.getBottom() + verticalSpacing);
            // Check if we have dragged the bottom of the grid too high
            final int childCount = getChildCount();
            if (childCount > 0) {
                correctTooHigh(numColumns, verticalSpacing, childCount);
            }
        } else {
            below = fillDown(motionRowEnd + numColumns, referenceView.getBottom() + verticalSpacing);
            adjustViewsUpOrDown();
            above = fillUp(motionRowStart - 1, referenceView.getTop() - verticalSpacing);
            // Check if we have dragged the bottom of the grid too high
            final int childCount = getChildCount();
            if (childCount > 0) {
                correctTooLow(numColumns, verticalSpacing, childCount);
            }
        }

        if (temp != null) {
            return temp;
        } else if (above != null) {
            return above;
        } else {
            return below;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.512 -0500", hash_original_method = "61C0C7B3D4F01380F7804BB62430F50F", hash_generated_method = "8888D64E11489B800674836006836C16")
    
private void correctTooHigh(int numColumns, int verticalSpacing, int childCount) {
        // First see if the last item is visible
        final int lastPosition = mFirstPosition + childCount - 1;
        if (lastPosition == mItemCount - 1 && childCount > 0) {
            // Get the last child ...
            final View lastChild = getChildAt(childCount - 1);

            // ... and its bottom edge
            final int lastBottom = lastChild.getBottom();
            // This is bottom of our drawable area
            final int end = (mBottom - mTop) - mListPadding.bottom;

            // This is how far the bottom edge of the last view is from the bottom of the
            // drawable area
            int bottomOffset = end - lastBottom;

            final View firstChild = getChildAt(0);
            final int firstTop = firstChild.getTop();

            // Make sure we are 1) Too high, and 2) Either there are more rows above the
            // first row or the first row is scrolled off the top of the drawable area
            if (bottomOffset > 0 && (mFirstPosition > 0 || firstTop < mListPadding.top))  {
                if (mFirstPosition == 0) {
                    // Don't pull the top too far down
                    bottomOffset = Math.min(bottomOffset, mListPadding.top - firstTop);
                }
                
                // Move everything down
                offsetChildrenTopAndBottom(bottomOffset);
                if (mFirstPosition > 0) {
                    // Fill the gap that was opened above mFirstPosition with more rows, if
                    // possible
                    fillUp(mFirstPosition - (mStackFromBottom ? 1 : numColumns),
                            firstChild.getTop() - verticalSpacing);
                    // Close up the remaining gap
                    adjustViewsUpOrDown();
                }
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.516 -0500", hash_original_method = "C582B4D472853F3118C6A87E3BA2D3CE", hash_generated_method = "D524678A7249BA14D4C9884359609912")
    
private void correctTooLow(int numColumns, int verticalSpacing, int childCount) {
        if (mFirstPosition == 0 && childCount > 0) {
            // Get the first child ...
            final View firstChild = getChildAt(0);

            // ... and its top edge
            final int firstTop = firstChild.getTop();

            // This is top of our drawable area
            final int start = mListPadding.top;

            // This is bottom of our drawable area
            final int end = (mBottom - mTop) - mListPadding.bottom;

            // This is how far the top edge of the first view is from the top of the
            // drawable area
            int topOffset = firstTop - start;
            final View lastChild = getChildAt(childCount - 1);
            final int lastBottom = lastChild.getBottom();
            final int lastPosition = mFirstPosition + childCount - 1;

            // Make sure we are 1) Too low, and 2) Either there are more rows below the
            // last row or the last row is scrolled off the bottom of the drawable area
            if (topOffset > 0 && (lastPosition < mItemCount - 1 || lastBottom > end))  {
                if (lastPosition == mItemCount - 1 ) {
                    // Don't pull the bottom too far up
                    topOffset = Math.min(topOffset, lastBottom - end);
                }
                
                // Move everything up
                offsetChildrenTopAndBottom(-topOffset);
                if (lastPosition < mItemCount - 1) {
                    // Fill the gap that was opened below the last position with more rows, if
                    // possible
                    fillDown(lastPosition + (!mStackFromBottom ? 1 : numColumns),
                            lastChild.getBottom() + verticalSpacing);
                    // Close up the remaining gap
                    adjustViewsUpOrDown();
                }
            }
        }
    }

    /**
     * Fills the grid based on positioning the new selection at a specific
     * location. The selection may be moved so that it does not intersect the
     * faded edges. The grid is then filled upwards and downwards from there.
     *
     * @param selectedTop Where the selected item should be
     * @param childrenTop Where to start drawing children
     * @param childrenBottom Last pixel where children can be drawn
     * @return The view that currently has selection
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.519 -0500", hash_original_method = "AC707126EF44BD77373D761D306CE415", hash_generated_method = "D0E41D6528D270D96ED7F0179237EF44")
    
private View fillFromSelection(int selectedTop, int childrenTop, int childrenBottom) {
        final int fadingEdgeLength = getVerticalFadingEdgeLength();
        final int selectedPosition = mSelectedPosition;
        final int numColumns = mNumColumns;
        final int verticalSpacing = mVerticalSpacing;

        int rowStart;
        int rowEnd = -1;

        if (!mStackFromBottom) {
            rowStart = selectedPosition - (selectedPosition % numColumns);
        } else {
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
        // Possibly changed again in fillUp if we add rows above this one.
        mFirstPosition = rowStart;

        referenceView = mReferenceView;
        adjustForTopFadingEdge(referenceView, topSelectionPixel, bottomSelectionPixel);
        adjustForBottomFadingEdge(referenceView, topSelectionPixel, bottomSelectionPixel);

        if (!mStackFromBottom) {
            fillUp(rowStart - numColumns, referenceView.getTop() - verticalSpacing);
            adjustViewsUpOrDown();
            fillDown(rowStart + numColumns, referenceView.getBottom() + verticalSpacing);
        } else {
            fillDown(rowEnd + numColumns, referenceView.getBottom() + verticalSpacing);
            adjustViewsUpOrDown();
            fillUp(rowStart - 1, referenceView.getTop() - verticalSpacing);
        }

        return sel;
    }

    /**
     * Calculate the bottom-most pixel we can draw the selection into
     *
     * @param childrenBottom Bottom pixel were children can be drawn
     * @param fadingEdgeLength Length of the fading edge in pixels, if present
     * @param numColumns Number of columns in the grid
     * @param rowStart The start of the row that will contain the selection
     * @return The bottom-most pixel we can draw the selection into
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.521 -0500", hash_original_method = "3B93521E4F8B514C6E0E966E64E45808", hash_generated_method = "06BF56C805E06046C6C4BDA431C1DB2F")
    
private int getBottomSelectionPixel(int childrenBottom, int fadingEdgeLength,
            int numColumns, int rowStart) {
        // Last pixel we can draw the selection into
        int bottomSelectionPixel = childrenBottom;
        if (rowStart + numColumns - 1 < mItemCount - 1) {
            bottomSelectionPixel -= fadingEdgeLength;
        }
        return bottomSelectionPixel;
    }

    /**
     * Calculate the top-most pixel we can draw the selection into
     *
     * @param childrenTop Top pixel were children can be drawn
     * @param fadingEdgeLength Length of the fading edge in pixels, if present
     * @param rowStart The start of the row that will contain the selection
     * @return The top-most pixel we can draw the selection into
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.523 -0500", hash_original_method = "D0A32123B024D3BD3B829FD608C467F8", hash_generated_method = "39666F385A9AB5B1D8AF12E0E0620C2A")
    
private int getTopSelectionPixel(int childrenTop, int fadingEdgeLength, int rowStart) {
        // first pixel we can draw the selection into
        int topSelectionPixel = childrenTop;
        if (rowStart > 0) {
            topSelectionPixel += fadingEdgeLength;
        }
        return topSelectionPixel;
    }

    /**
     * Move all views upwards so the selected row does not interesect the bottom
     * fading edge (if necessary).
     *
     * @param childInSelectedRow A child in the row that contains the selection
     * @param topSelectionPixel The topmost pixel we can draw the selection into
     * @param bottomSelectionPixel The bottommost pixel we can draw the
     *        selection into
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.526 -0500", hash_original_method = "683433A1D2226A93C6C052E4367B337E", hash_generated_method = "E878B686A2591643DAA083868B7AD669")
    
private void adjustForBottomFadingEdge(View childInSelectedRow,
            int topSelectionPixel, int bottomSelectionPixel) {
        // Some of the newly selected item extends below the bottom of the
        // list
        if (childInSelectedRow.getBottom() > bottomSelectionPixel) {

            // Find space available above the selection into which we can
            // scroll upwards
            int spaceAbove = childInSelectedRow.getTop() - topSelectionPixel;

            // Find space required to bring the bottom of the selected item
            // fully into view
            int spaceBelow = childInSelectedRow.getBottom() - bottomSelectionPixel;
            int offset = Math.min(spaceAbove, spaceBelow);

            // Now offset the selected item to get it into view
            offsetChildrenTopAndBottom(-offset);
        }
    }

    /**
     * Move all views upwards so the selected row does not interesect the top
     * fading edge (if necessary).
     *
     * @param childInSelectedRow A child in the row that contains the selection
     * @param topSelectionPixel The topmost pixel we can draw the selection into
     * @param bottomSelectionPixel The bottommost pixel we can draw the
     *        selection into
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.528 -0500", hash_original_method = "E9E54F71CD8326C8AF2C780315CD689D", hash_generated_method = "E55330C8EE6F8D117A9BF2110C3DAF64")
    
private void adjustForTopFadingEdge(View childInSelectedRow,
            int topSelectionPixel, int bottomSelectionPixel) {
        // Some of the newly selected item extends above the top of the list
        if (childInSelectedRow.getTop() < topSelectionPixel) {
            // Find space required to bring the top of the selected item
            // fully into view
            int spaceAbove = topSelectionPixel - childInSelectedRow.getTop();

            // Find space available below the selection into which we can
            // scroll downwards
            int spaceBelow = bottomSelectionPixel - childInSelectedRow.getBottom();
            int offset = Math.min(spaceAbove, spaceBelow);

            // Now offset the selected item to get it into view
            offsetChildrenTopAndBottom(offset);
        }
    }

    /**
     * Smoothly scroll to the specified adapter position. The view will
     * scroll such that the indicated position is displayed.
     * @param position Scroll to this adapter position.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.530 -0500", hash_original_method = "19B54E9E42F50C19B80602093C26BC32", hash_generated_method = "A8A3C236FF85813945F7C1B0B7869E60")
    
@android.view.RemotableViewMethod
    public void smoothScrollToPosition(int position) {
        super.smoothScrollToPosition(position);
    }

    /**
     * Smoothly scroll to the specified adapter position offset. The view will
     * scroll such that the indicated position is displayed.
     * @param offset The amount to offset from the adapter position to scroll to.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.532 -0500", hash_original_method = "9A2E566018459C8A4F9FE2F49DBB98B8", hash_generated_method = "8E840BFE7E6405298EC13CA3DE52B347")
    
@android.view.RemotableViewMethod
    public void smoothScrollByOffset(int offset) {
        super.smoothScrollByOffset(offset);
    }

    /**
     * Fills the grid based on positioning the new selection relative to the old
     * selection. The new selection will be placed at, above, or below the
     * location of the new selection depending on how the selection is moving.
     * The selection will then be pinned to the visible part of the screen,
     * excluding the edges that are faded. The grid is then filled upwards and
     * downwards from there.
     *
     * @param delta Which way we are moving
     * @param childrenTop Where to start drawing children
     * @param childrenBottom Last pixel where children can be drawn
     * @return The view that currently has selection
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.536 -0500", hash_original_method = "55F676D436FF1EC67ECC1C028E81ED27", hash_generated_method = "AC9FD73229CF68305BF944740C6C29B7")
    
private View moveSelection(int delta, int childrenTop, int childrenBottom) {
        final int fadingEdgeLength = getVerticalFadingEdgeLength();
        final int selectedPosition = mSelectedPosition;
        final int numColumns = mNumColumns;
        final int verticalSpacing = mVerticalSpacing;

        int oldRowStart;
        int rowStart;
        int rowEnd = -1;

        if (!mStackFromBottom) {
            oldRowStart = (selectedPosition - delta) - ((selectedPosition - delta) % numColumns);

            rowStart = selectedPosition - (selectedPosition % numColumns);
        } else {
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

        // Possibly changed again in fillUp if we add rows above this one.
        mFirstPosition = rowStart;

        View sel;
        View referenceView;

        if (rowDelta > 0) {
            /*
             * Case 1: Scrolling down.
             */

            final int oldBottom = mReferenceViewInSelectedRow == null ? 0 :
                    mReferenceViewInSelectedRow.getBottom();

            sel = makeRow(mStackFromBottom ? rowEnd : rowStart, oldBottom + verticalSpacing, true);
            referenceView = mReferenceView;

            adjustForBottomFadingEdge(referenceView, topSelectionPixel, bottomSelectionPixel);
        } else if (rowDelta < 0) {
            /*
             * Case 2: Scrolling up.
             */
            final int oldTop = mReferenceViewInSelectedRow == null ?
                    0 : mReferenceViewInSelectedRow .getTop();

            sel = makeRow(mStackFromBottom ? rowEnd : rowStart, oldTop - verticalSpacing, false);
            referenceView = mReferenceView;

            adjustForTopFadingEdge(referenceView, topSelectionPixel, bottomSelectionPixel);
        } else {
            /*
             * Keep selection where it was
             */
            final int oldTop = mReferenceViewInSelectedRow == null ?
                    0 : mReferenceViewInSelectedRow .getTop();

            sel = makeRow(mStackFromBottom ? rowEnd : rowStart, oldTop, true);
            referenceView = mReferenceView;
        }

        if (!mStackFromBottom) {
            fillUp(rowStart - numColumns, referenceView.getTop() - verticalSpacing);
            adjustViewsUpOrDown();
            fillDown(rowStart + numColumns, referenceView.getBottom() + verticalSpacing);
        } else {
            fillDown(rowEnd + numColumns, referenceView.getBottom() + verticalSpacing);
            adjustViewsUpOrDown();
            fillUp(rowStart - 1, referenceView.getTop() - verticalSpacing);
        }

        return sel;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.540 -0500", hash_original_method = "971C7C8872B1F8EEBA5FB107FC6F8364", hash_generated_method = "8132EE35DB741A8DBF4373270403A74E")
    
private boolean determineColumns(int availableSpace) {
        final int requestedHorizontalSpacing = mRequestedHorizontalSpacing;
        final int stretchMode = mStretchMode;
        final int requestedColumnWidth = mRequestedColumnWidth;
        boolean didNotInitiallyFit = false;
        
        if (mRequestedNumColumns == AUTO_FIT) {
            if (requestedColumnWidth > 0) {
                // Client told us to pick the number of columns
                mNumColumns = (availableSpace + requestedHorizontalSpacing) /
                        (requestedColumnWidth + requestedHorizontalSpacing);
            } else {
                // Just make up a number if we don't have enough info
                mNumColumns = 2;
            }
        } else {
            // We picked the columns
            mNumColumns = mRequestedNumColumns;
        }
        
        if (mNumColumns <= 0) {
            mNumColumns = 1;
        }

        switch (stretchMode) {
        case NO_STRETCH:
            // Nobody stretches
            mColumnWidth = requestedColumnWidth;
            mHorizontalSpacing = requestedHorizontalSpacing;
            break;

        default:
            int spaceLeftOver = availableSpace - (mNumColumns * requestedColumnWidth) -
                    ((mNumColumns - 1) * requestedHorizontalSpacing);

            if (spaceLeftOver < 0) {
                didNotInitiallyFit = true;
            }

            switch (stretchMode) {
            case STRETCH_COLUMN_WIDTH:
                // Stretch the columns
                mColumnWidth = requestedColumnWidth + spaceLeftOver / mNumColumns;
                mHorizontalSpacing = requestedHorizontalSpacing;
                break;

            case STRETCH_SPACING:
                // Stretch the spacing between columns
                mColumnWidth = requestedColumnWidth;
                if (mNumColumns > 1) {
                    mHorizontalSpacing = requestedHorizontalSpacing + 
                        spaceLeftOver / (mNumColumns - 1);
                } else {
                    mHorizontalSpacing = requestedHorizontalSpacing + spaceLeftOver;
                }
                break;

            case STRETCH_SPACING_UNIFORM:
                // Stretch the spacing between columns
                mColumnWidth = requestedColumnWidth;
                if (mNumColumns > 1) {
                    mHorizontalSpacing = requestedHorizontalSpacing + 
                        spaceLeftOver / (mNumColumns + 1);
                } else {
                    mHorizontalSpacing = requestedHorizontalSpacing + spaceLeftOver;
                }
                break;
            }

            break;
        }
        return didNotInitiallyFit;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.545 -0500", hash_original_method = "DE2B2122B3B8477B4CE53B0961FAB462", hash_generated_method = "050517F766584F8B04D6031409D0D1C2")
    
@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // Sets up mListPadding
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthMode == MeasureSpec.UNSPECIFIED) {
            if (mColumnWidth > 0) {
                widthSize = mColumnWidth + mListPadding.left + mListPadding.right;
            } else {
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
        if (count > 0) {
            final View child = obtainView(0, mIsScrap);

            AbsListView.LayoutParams p = (AbsListView.LayoutParams)child.getLayoutParams();
            if (p == null) {
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

            if (mRecycler.shouldRecycleViewType(p.viewType)) {
                mRecycler.addScrapView(child, -1);
            }
        }
        
        if (heightMode == MeasureSpec.UNSPECIFIED) {
            heightSize = mListPadding.top + mListPadding.bottom + childHeight +
                    getVerticalFadingEdgeLength() * 2;
        }

        if (heightMode == MeasureSpec.AT_MOST) {
            int ourSize =  mListPadding.top + mListPadding.bottom;
           
            final int numColumns = mNumColumns;
            for (int i = 0; i < count; i += numColumns) {
                ourSize += childHeight;
                if (i + numColumns < count) {
                    ourSize += mVerticalSpacing;
                }
                if (ourSize >= heightSize) {
                    ourSize = heightSize;
                    break;
                }
            }
            heightSize = ourSize;
        }

        if (widthMode == MeasureSpec.AT_MOST && mRequestedNumColumns != AUTO_FIT) {
            int ourSize = (mRequestedNumColumns*mColumnWidth)
                    + ((mRequestedNumColumns-1)*mHorizontalSpacing)
                    + mListPadding.left + mListPadding.right;
            if (ourSize > widthSize || didNotInitiallyFit) {
                widthSize |= MEASURED_STATE_TOO_SMALL;
            }
        }

        setMeasuredDimension(widthSize, heightSize);
        mWidthMeasureSpec = widthMeasureSpec;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.547 -0500", hash_original_method = "B083102DF451B0F743637B4C2ECFBD00", hash_generated_method = "58B4C1518563241B9EF56650B99C05B9")
    
@Override
    protected void attachLayoutAnimationParameters(View child,
            ViewGroup.LayoutParams params, int index, int count) {

        GridLayoutAnimationController.AnimationParameters animationParams =
                (GridLayoutAnimationController.AnimationParameters) params.layoutAnimationParameters;

        if (animationParams == null) {
            animationParams = new GridLayoutAnimationController.AnimationParameters();
            params.layoutAnimationParameters = animationParams;
        }

        animationParams.count = count;
        animationParams.index = index;
        animationParams.columnsCount = mNumColumns;
        animationParams.rowsCount = count / mNumColumns;

        if (!mStackFromBottom) {
            animationParams.column = index % mNumColumns;
            animationParams.row = index / mNumColumns;
        } else {
            final int invertedIndex = count - 1 - index;

            animationParams.column = mNumColumns - 1 - (invertedIndex % mNumColumns);
            animationParams.row = animationParams.rowsCount - 1 - invertedIndex / mNumColumns;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.552 -0500", hash_original_method = "22970971C8FD1FE9524617A911939C41", hash_generated_method = "89243079EC32817BDC4B1BB2B0E0A65D")
    
@Override
    protected void layoutChildren() {
        final boolean blockLayoutRequests = mBlockLayoutRequests;
        if (!blockLayoutRequests) {
            mBlockLayoutRequests = true;
        }

        try {
            super.layoutChildren();

            invalidate();

            if (mAdapter == null) {
                resetList();
                invokeOnItemScrollListener();
                return;
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

            // Remember stuff we will need down below
            switch (mLayoutMode) {
            case LAYOUT_SET_SELECTION:
                index = mNextSelectedPosition - mFirstPosition;
                if (index >= 0 && index < childCount) {
                    newSel = getChildAt(index);
                }
                break;
            case LAYOUT_FORCE_TOP:
            case LAYOUT_FORCE_BOTTOM:
            case LAYOUT_SPECIFIC:
            case LAYOUT_SYNC:
                break;
            case LAYOUT_MOVE_SELECTION:
                if (mNextSelectedPosition >= 0) {
                    delta = mNextSelectedPosition - mSelectedPosition;
                }
                break;
            default:
                // Remember the previously selected view
                index = mSelectedPosition - mFirstPosition;
                if (index >= 0 && index < childCount) {
                    oldSel = getChildAt(index);
                }

                // Remember the previous first child
                oldFirst = getChildAt(0);
            }

            boolean dataChanged = mDataChanged;
            if (dataChanged) {
                handleDataChanged();
            }

            // Handle the empty set by removing all views that are visible
            // and calling it a day
            if (mItemCount == 0) {
                resetList();
                invokeOnItemScrollListener();
                return;
            }

            setSelectedPositionInt(mNextSelectedPosition);

            // Pull all children into the RecycleBin.
            // These views will be reused if possible
            final int firstPosition = mFirstPosition;
            final RecycleBin recycleBin = mRecycler;

            if (dataChanged) {
                for (int i = 0; i < childCount; i++) {
                    recycleBin.addScrapView(getChildAt(i), firstPosition+i);
                }
            } else {
                recycleBin.fillActiveViews(childCount, firstPosition);
            }

            // Clear out old views
            //removeAllViewsInLayout();
            detachAllViewsFromParent();

            switch (mLayoutMode) {
            case LAYOUT_SET_SELECTION:
                if (newSel != null) {
                    sel = fillFromSelection(newSel.getTop(), childrenTop, childrenBottom);
                } else {
                    sel = fillSelection(childrenTop, childrenBottom);
                }
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
                // Move the selection relative to its old position
                sel = moveSelection(delta, childrenTop, childrenBottom);
                break;
            default:
                if (childCount == 0) {
                    if (!mStackFromBottom) {
                        setSelectedPositionInt(mAdapter == null || isInTouchMode() ?
                                INVALID_POSITION : 0);
                        sel = fillFromTop(childrenTop);
                    } else {
                        final int last = mItemCount - 1;
                        setSelectedPositionInt(mAdapter == null || isInTouchMode() ?
                                INVALID_POSITION : last);
                        sel = fillFromBottom(last, childrenBottom);
                    }
                } else {
                    if (mSelectedPosition >= 0 && mSelectedPosition < mItemCount) {
                        sel = fillSpecific(mSelectedPosition, oldSel == null ?
                                childrenTop : oldSel.getTop());
                    } else if (mFirstPosition < mItemCount)  {
                        sel = fillSpecific(mFirstPosition, oldFirst == null ?
                                childrenTop : oldFirst.getTop());
                    } else {
                        sel = fillSpecific(0, childrenTop);
                    }
                }
                break;
            }

            // Flush any cached views that did not get reused above
            recycleBin.scrapActiveViews();

            if (sel != null) {
               positionSelector(INVALID_POSITION, sel);
               mSelectedTop = sel.getTop();
            } else if (mTouchMode > TOUCH_MODE_DOWN && mTouchMode < TOUCH_MODE_SCROLL) {
                View child = getChildAt(mMotionPosition - mFirstPosition);
                if (child != null) positionSelector(mMotionPosition, child);
            } else {
                mSelectedTop = 0;
                mSelectorRect.setEmpty();
            }

            mLayoutMode = LAYOUT_NORMAL;
            mDataChanged = false;
            mNeedSync = false;
            setNextSelectedPositionInt(mSelectedPosition);

            updateScrollIndicators();

            if (mItemCount > 0) {
                checkSelectionChanged();
            }

            invokeOnItemScrollListener();
        } finally {
            if (!blockLayoutRequests) {
                mBlockLayoutRequests = false;
            }
        }
    }

    /**
     * Obtain the view and add it to our list of children. The view can be made
     * fresh, converted from an unused view, or used as is if it was in the
     * recycle bin.
     *
     * @param position Logical position in the list
     * @param y Top or bottom edge of the view to add
     * @param flow if true, align top edge to y. If false, align bottom edge to
     *        y.
     * @param childrenLeft Left edge where children should be positioned
     * @param selected Is this position selected?
     * @param where to add new item in the list
     * @return View that was added
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.555 -0500", hash_original_method = "D1571833DCBC36BAA4E4DA8F2A5DB363", hash_generated_method = "1936EA1E115B9D19E1420BAFC14E457A")
    
private View makeAndAddView(int position, int y, boolean flow, int childrenLeft,
            boolean selected, int where) {
        View child;

        if (!mDataChanged) {
            // Try to use an existing view for this position
            child = mRecycler.getActiveView(position);
            if (child != null) {
                // Found it -- we're using an existing child
                // This just needs to be positioned
                setupChild(child, position, y, flow, childrenLeft, selected, true, where);
                return child;
            }
        }

        // Make a new view for this position, or convert an unused view if
        // possible
        child = obtainView(position, mIsScrap);

        // This needs to be positioned and measured
        setupChild(child, position, y, flow, childrenLeft, selected, mIsScrap[0], where);

        return child;
    }

    /**
     * Add a view as a child and make sure it is measured (if necessary) and
     * positioned properly.
     *
     * @param child The view to add
     * @param position The position of the view
     * @param y The y position relative to which this view will be positioned
     * @param flow if true, align top edge to y. If false, align bottom edge
     *        to y.
     * @param childrenLeft Left edge where children should be positioned
     * @param selected Is this position selected?
     * @param recycled Has this view been pulled from the recycle bin? If so it
     *        does not need to be remeasured.
     * @param where Where to add the item in the list
     *
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.559 -0500", hash_original_method = "F1D84EEF4E6902A923E61B402C707D18", hash_generated_method = "B11BF244AF65541B26D893EA71037CB4")
    
private void setupChild(View child, int position, int y, boolean flow, int childrenLeft,
            boolean selected, boolean recycled, int where) {
        boolean isSelected = selected && shouldShowSelector();
        final boolean updateChildSelected = isSelected != child.isSelected();
        final int mode = mTouchMode;
        final boolean isPressed = mode > TOUCH_MODE_DOWN && mode < TOUCH_MODE_SCROLL &&
                mMotionPosition == position;
        final boolean updateChildPressed = isPressed != child.isPressed();
        
        boolean needToMeasure = !recycled || updateChildSelected || child.isLayoutRequested();

        // Respect layout params that are already in the view. Otherwise make
        // some up...
        AbsListView.LayoutParams p = (AbsListView.LayoutParams)child.getLayoutParams();
        if (p == null) {
            p = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, 0);
        }
        p.viewType = mAdapter.getItemViewType(position);

        if (recycled && !p.forceAdd) {
            attachViewToParent(child, where, p);
        } else {
            p.forceAdd = false;
            addViewInLayout(child, where, p, true);
        }

        if (updateChildSelected) {
            child.setSelected(isSelected);
            if (isSelected) {
                requestFocus();
            }
        }

        if (updateChildPressed) {
            child.setPressed(isPressed);
        }

        if (mChoiceMode != CHOICE_MODE_NONE && mCheckStates != null) {
            if (child instanceof Checkable) {
                ((Checkable) child).setChecked(mCheckStates.get(position));
            } else if (getContext().getApplicationInfo().targetSdkVersion
                    >= android.os.Build.VERSION_CODES.HONEYCOMB) {
                child.setActivated(mCheckStates.get(position));
            }
        }

        if (needToMeasure) {
            int childHeightSpec = ViewGroup.getChildMeasureSpec(
                    MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED), 0, p.height);

            int childWidthSpec = ViewGroup.getChildMeasureSpec(
                    MeasureSpec.makeMeasureSpec(mColumnWidth, MeasureSpec.EXACTLY), 0, p.width);
            child.measure(childWidthSpec, childHeightSpec);
        } else {
            cleanupLayoutState(child);
        }

        final int w = child.getMeasuredWidth();
        final int h = child.getMeasuredHeight();

        int childLeft;
        final int childTop = flow ? y : y - h;

        final int layoutDirection = getResolvedLayoutDirection();
        final int absoluteGravity = Gravity.getAbsoluteGravity(mGravity, layoutDirection);
        switch (absoluteGravity & Gravity.HORIZONTAL_GRAVITY_MASK) {
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
        }

        if (needToMeasure) {
            final int childRight = childLeft + w;
            final int childBottom = childTop + h;
            child.layout(childLeft, childTop, childRight, childBottom);
        } else {
            child.offsetLeftAndRight(childLeft - child.getLeft());
            child.offsetTopAndBottom(childTop - child.getTop());
        }

        if (mCachingStarted) {
            child.setDrawingCacheEnabled(true);
        }

        if (recycled && (((AbsListView.LayoutParams)child.getLayoutParams()).scrappedFromPosition)
                != position) {
            child.jumpDrawablesToCurrentState();
        }
    }

    /**
     * Sets the currently selected item
     * 
     * @param position Index (starting at 0) of the data item to be selected.
     * 
     * If in touch mode, the item will not be selected but it will still be positioned
     * appropriately.
     */
    @DSComment("GUI GridView")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.561 -0500", hash_original_method = "F036989DC17B53D064E56E9048AF8088", hash_generated_method = "746F894122617A5FC5CDD581A3E19301")
    
@Override
    public void setSelection(int position) {
        if (!isInTouchMode()) {
            setNextSelectedPositionInt(position);
        } else {
            mResurrectToPosition = position;
        }
        mLayoutMode = LAYOUT_SET_SELECTION;
        requestLayout();
    }

    /**
     * Makes the item at the supplied position selected.
     *
     * @param position the position of the new selection
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.564 -0500", hash_original_method = "BFD03D39F54176AB600127B7C1132704", hash_generated_method = "1AE311F3CCE236E32F6E093104CBDC91")
    
@Override
    void setSelectionInt(int position) {
        int previousSelectedPosition = mNextSelectedPosition;

        setNextSelectedPositionInt(position);
        layoutChildren();
        
        final int next = mStackFromBottom ? mItemCount - 1  - mNextSelectedPosition : 
            mNextSelectedPosition;
        final int previous = mStackFromBottom ? mItemCount - 1
                - previousSelectedPosition : previousSelectedPosition;

        final int nextRow = next / mNumColumns;
        final int previousRow = previous / mNumColumns;

        if (nextRow != previousRow) {
            awakenScrollBars();
        }

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.566 -0500", hash_original_method = "82498D99AFEB0700B1F959E9E9927B59", hash_generated_method = "6AF9706850820C4FEB302E37B50B2BED")
    
@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return commonKey(keyCode, 1, event);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.568 -0500", hash_original_method = "C105EC1B6481173F2A66D1C47882507B", hash_generated_method = "263108ED482A3329DC5C40738EBD240E")
    
@Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        return commonKey(keyCode, repeatCount, event);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.570 -0500", hash_original_method = "FFB4A1626C41573790F9B17FF23F8A09", hash_generated_method = "A27D10E92D871F3F89D05FD06501971F")
    
@Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return commonKey(keyCode, 1, event);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.574 -0500", hash_original_method = "91535B300D60431313446AA401FFCFE7", hash_generated_method = "7E6FA88E9A17CFD253CC010555D73ED3")
    
private boolean commonKey(int keyCode, int count, KeyEvent event) {
        if (mAdapter == null) {
            return false;
        }

        if (mDataChanged) {
            layoutChildren();
        }

        boolean handled = false;
        int action = event.getAction();

        if (action != KeyEvent.ACTION_UP) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_DPAD_LEFT:
                    if (event.hasNoModifiers()) {
                        handled = resurrectSelectionIfNeeded() || arrowScroll(FOCUS_LEFT);
                    }
                    break;

                case KeyEvent.KEYCODE_DPAD_RIGHT:
                    if (event.hasNoModifiers()) {
                        handled = resurrectSelectionIfNeeded() || arrowScroll(FOCUS_RIGHT);
                    }
                    break;

                case KeyEvent.KEYCODE_DPAD_UP:
                    if (event.hasNoModifiers()) {
                        handled = resurrectSelectionIfNeeded() || arrowScroll(FOCUS_UP);
                    } else if (event.hasModifiers(KeyEvent.META_ALT_ON)) {
                        handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_UP);
                    }
                    break;

                case KeyEvent.KEYCODE_DPAD_DOWN:
                    if (event.hasNoModifiers()) {
                        handled = resurrectSelectionIfNeeded() || arrowScroll(FOCUS_DOWN);
                    } else if (event.hasModifiers(KeyEvent.META_ALT_ON)) {
                        handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_DOWN);
                    }
                    break;

                case KeyEvent.KEYCODE_DPAD_CENTER:
                case KeyEvent.KEYCODE_ENTER:
                    if (event.hasNoModifiers()) {
                        handled = resurrectSelectionIfNeeded();
                        if (!handled
                                && event.getRepeatCount() == 0 && getChildCount() > 0) {
                            keyPressed();
                            handled = true;
                        }
                    }
                    break;

                case KeyEvent.KEYCODE_SPACE:
                    if (mPopup == null || !mPopup.isShowing()) {
                        if (event.hasNoModifiers()) {
                            handled = resurrectSelectionIfNeeded() || pageScroll(FOCUS_DOWN);
                        } else if (event.hasModifiers(KeyEvent.META_SHIFT_ON)) {
                            handled = resurrectSelectionIfNeeded() || pageScroll(FOCUS_UP);
                        }
                    }
                    break;

                case KeyEvent.KEYCODE_PAGE_UP:
                    if (event.hasNoModifiers()) {
                        handled = resurrectSelectionIfNeeded() || pageScroll(FOCUS_UP);
                    } else if (event.hasModifiers(KeyEvent.META_ALT_ON)) {
                        handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_UP);
                    }
                    break;

                case KeyEvent.KEYCODE_PAGE_DOWN:
                    if (event.hasNoModifiers()) {
                        handled = resurrectSelectionIfNeeded() || pageScroll(FOCUS_DOWN);
                    } else if (event.hasModifiers(KeyEvent.META_ALT_ON)) {
                        handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_DOWN);
                    }
                    break;

                case KeyEvent.KEYCODE_MOVE_HOME:
                    if (event.hasNoModifiers()) {
                        handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_UP);
                    }
                    break;

                case KeyEvent.KEYCODE_MOVE_END:
                    if (event.hasNoModifiers()) {
                        handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_DOWN);
                    }
                    break;

                case KeyEvent.KEYCODE_TAB:
                    // XXX Sometimes it is useful to be able to TAB through the items in
                    //     a GridView sequentially.  Unfortunately this can create an
                    //     asymmetry in TAB navigation order unless the list selection
                    //     always reverts to the top or bottom when receiving TAB focus from
                    //     another widget.  Leaving this behavior disabled for now but
                    //     perhaps it should be configurable (and more comprehensive).
                    if (false) {
                        if (event.hasNoModifiers()) {
                            handled = resurrectSelectionIfNeeded()
                                    || sequenceScroll(FOCUS_FORWARD);
                        } else if (event.hasModifiers(KeyEvent.META_SHIFT_ON)) {
                            handled = resurrectSelectionIfNeeded()
                                    || sequenceScroll(FOCUS_BACKWARD);
                        }
                    }
                    break;
            }
        }

        if (handled) {
            return true;
        }

        if (sendToTextFilter(keyCode, count, event)) {
            return true;
        }

        switch (action) {
            case KeyEvent.ACTION_DOWN:
                return super.onKeyDown(keyCode, event);
            case KeyEvent.ACTION_UP:
                return super.onKeyUp(keyCode, event);
            case KeyEvent.ACTION_MULTIPLE:
                return super.onKeyMultiple(keyCode, count, event);
            default:
                return false;
        }
    }

    /**
     * Scrolls up or down by the number of items currently present on screen.
     *
     * @param direction either {@link View#FOCUS_UP} or {@link View#FOCUS_DOWN}
     * @return whether selection was moved
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.578 -0500", hash_original_method = "7F69D44B4A5B870A2ADF67B34BC1B3FD", hash_generated_method = "7F69D44B4A5B870A2ADF67B34BC1B3FD")
    
boolean pageScroll(int direction) {
        int nextPage = -1;

        if (direction == FOCUS_UP) {
            nextPage = Math.max(0, mSelectedPosition - getChildCount());
        } else if (direction == FOCUS_DOWN) {
            nextPage = Math.min(mItemCount - 1, mSelectedPosition + getChildCount());
        }

        if (nextPage >= 0) {
            setSelectionInt(nextPage);
            invokeOnItemScrollListener();
            awakenScrollBars();
            return true;
        }

        return false;
    }

    /**
     * Go to the last or first item if possible.
     *
     * @param direction either {@link View#FOCUS_UP} or {@link View#FOCUS_DOWN}.
     *
     * @return Whether selection was moved.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.580 -0500", hash_original_method = "8921946161DEF2C387CE09B16F70206C", hash_generated_method = "8921946161DEF2C387CE09B16F70206C")
    
boolean fullScroll(int direction) {
        boolean moved = false;
        if (direction == FOCUS_UP) {
            mLayoutMode = LAYOUT_SET_SELECTION;
            setSelectionInt(0);
            invokeOnItemScrollListener();
            moved = true;
        } else if (direction == FOCUS_DOWN) {
            mLayoutMode = LAYOUT_SET_SELECTION;
            setSelectionInt(mItemCount - 1);
            invokeOnItemScrollListener();
            moved = true;
        }
        
        if (moved) {
            awakenScrollBars();
        }

        return moved;
    }

    /**
     * Scrolls to the next or previous item, horizontally or vertically.
     *
     * @param direction either {@link View#FOCUS_LEFT}, {@link View#FOCUS_RIGHT},
     *        {@link View#FOCUS_UP} or {@link View#FOCUS_DOWN}
     *
     * @return whether selection was moved
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.583 -0500", hash_original_method = "8CD79681F48962D4344E68AA337F0770", hash_generated_method = "8CD79681F48962D4344E68AA337F0770")
    
boolean arrowScroll(int direction) {
        final int selectedPosition = mSelectedPosition;
        final int numColumns = mNumColumns;

        int startOfRowPos;
        int endOfRowPos;

        boolean moved = false;

        if (!mStackFromBottom) {
            startOfRowPos = (selectedPosition / numColumns) * numColumns;
            endOfRowPos = Math.min(startOfRowPos + numColumns - 1, mItemCount - 1);
        } else {
            final int invertedSelection = mItemCount - 1 - selectedPosition;
            endOfRowPos = mItemCount - 1 - (invertedSelection / numColumns) * numColumns;
            startOfRowPos = Math.max(0, endOfRowPos - numColumns + 1);
        }

        switch (direction) {
            case FOCUS_UP:
                if (startOfRowPos > 0) {
                    mLayoutMode = LAYOUT_MOVE_SELECTION;
                    setSelectionInt(Math.max(0, selectedPosition - numColumns));
                    moved = true;
                }
                break;
            case FOCUS_DOWN:
                if (endOfRowPos < mItemCount - 1) {
                    mLayoutMode = LAYOUT_MOVE_SELECTION;
                    setSelectionInt(Math.min(selectedPosition + numColumns, mItemCount - 1));
                    moved = true;
                }
                break;
            case FOCUS_LEFT:
                if (selectedPosition > startOfRowPos) {
                    mLayoutMode = LAYOUT_MOVE_SELECTION;
                    setSelectionInt(Math.max(0, selectedPosition - 1));
                    moved = true;
                }
                break;
            case FOCUS_RIGHT:
                if (selectedPosition < endOfRowPos) {
                    mLayoutMode = LAYOUT_MOVE_SELECTION;
                    setSelectionInt(Math.min(selectedPosition + 1, mItemCount - 1));
                    moved = true;
                }
                break;
        }

        if (moved) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(direction));
            invokeOnItemScrollListener();
        }

        if (moved) {
            awakenScrollBars();
        }
        
        return moved;
    }

    /**
     * Goes to the next or previous item according to the order set by the
     * adapter.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.585 -0500", hash_original_method = "3D7E63CDF154AB38FFF5F8515CF699BF", hash_generated_method = "6922CC887F15BE18EBAC154EF990D97C")
    
boolean sequenceScroll(int direction) {
        int selectedPosition = mSelectedPosition;
        int numColumns = mNumColumns;
        int count = mItemCount;

        int startOfRow;
        int endOfRow;
        if (!mStackFromBottom) {
            startOfRow = (selectedPosition / numColumns) * numColumns;
            endOfRow = Math.min(startOfRow + numColumns - 1, count - 1);
        } else {
            int invertedSelection = count - 1 - selectedPosition;
            endOfRow = count - 1 - (invertedSelection / numColumns) * numColumns;
            startOfRow = Math.max(0, endOfRow - numColumns + 1);
        }

        boolean moved = false;
        boolean showScroll = false;
        switch (direction) {
            case FOCUS_FORWARD:
                if (selectedPosition < count - 1) {
                    // Move to the next item.
                    mLayoutMode = LAYOUT_MOVE_SELECTION;
                    setSelectionInt(selectedPosition + 1);
                    moved = true;
                    // Show the scrollbar only if changing rows.
                    showScroll = selectedPosition == endOfRow;
                }
                break;

            case FOCUS_BACKWARD:
                if (selectedPosition > 0) {
                    // Move to the previous item.
                    mLayoutMode = LAYOUT_MOVE_SELECTION;
                    setSelectionInt(selectedPosition - 1);
                    moved = true;
                    // Show the scrollbar only if changing rows.
                    showScroll = selectedPosition == startOfRow;
                }
                break;
        }

        if (moved) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(direction));
            invokeOnItemScrollListener();
        }

        if (showScroll) {
            awakenScrollBars();
        }

        return moved;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.589 -0500", hash_original_method = "0FD361D132773200063DCB66E88E964C", hash_generated_method = "000338988C6A6B83070CEDE35DA49C05")
    
@Override
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);

        int closestChildIndex = -1;
        if (gainFocus && previouslyFocusedRect != null) {
            previouslyFocusedRect.offset(mScrollX, mScrollY);

            // figure out which item should be selected based on previously
            // focused rect
            Rect otherRect = mTempRect;
            int minDistance = Integer.MAX_VALUE;
            final int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                // only consider view's on appropriate edge of grid
                if (!isCandidateSelection(i, direction)) {
                    continue;
                }

                final View other = getChildAt(i);
                other.getDrawingRect(otherRect);
                offsetDescendantRectToMyCoords(other, otherRect);
                int distance = getDistance(previouslyFocusedRect, otherRect, direction);

                if (distance < minDistance) {
                    minDistance = distance;
                    closestChildIndex = i;
                }
            }
        }

        if (closestChildIndex >= 0) {
            setSelection(closestChildIndex + mFirstPosition);
        } else {
            requestLayout();
        }
    }

    /**
     * Is childIndex a candidate for next focus given the direction the focus
     * change is coming from?
     * @param childIndex The index to check.
     * @param direction The direction, one of
     *        {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, FOCUS_FORWARD, FOCUS_BACKWARD}
     * @return Whether childIndex is a candidate.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.591 -0500", hash_original_method = "84D213429BEB1496C8F56DF85FD23E87", hash_generated_method = "4A51426B49B23A339C74B0353EE11C7F")
    
private boolean isCandidateSelection(int childIndex, int direction) {
        final int count = getChildCount();
        final int invertedIndex = count - 1 - childIndex;

        int rowStart;
        int rowEnd;

        if (!mStackFromBottom) {
            rowStart = childIndex - (childIndex % mNumColumns);
            rowEnd = Math.max(rowStart + mNumColumns - 1, count);
        } else {
            rowEnd = count - 1 - (invertedIndex - (invertedIndex % mNumColumns));
            rowStart = Math.max(0, rowEnd - mNumColumns + 1);
        }

        switch (direction) {
            case View.FOCUS_RIGHT:
                // coming from left, selection is only valid if it is on left
                // edge
                return childIndex == rowStart;
            case View.FOCUS_DOWN:
                // coming from top; only valid if in top row
                return rowStart == 0;
            case View.FOCUS_LEFT:
                // coming from right, must be on right edge
                return childIndex == rowEnd;
            case View.FOCUS_UP:
                // coming from bottom, need to be in last row
                return rowEnd == count - 1;
            case View.FOCUS_FORWARD:
                // coming from top-left, need to be first in top row
                return childIndex == rowStart && rowStart == 0;
            case View.FOCUS_BACKWARD:
                // coming from bottom-right, need to be last in bottom row
                return childIndex == rowEnd && rowEnd == count - 1;
            default:
                throw new IllegalArgumentException("direction must be one of "
                        + "{FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, "
                        + "FOCUS_FORWARD, FOCUS_BACKWARD}.");
        }
    }

    /**
     * Describes how the child views are horizontally aligned. Defaults to Gravity.LEFT
     *
     * @param gravity the gravity to apply to this grid's children
     *
     * @attr ref android.R.styleable#GridView_gravity
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.594 -0500", hash_original_method = "FC2053B842AF8EFA285EBFCDE9A6D098", hash_generated_method = "257402A56C3595C77B8909D79F2C3593")
    
public void setGravity(int gravity) {
        if (mGravity != gravity) {
            mGravity = gravity;
            requestLayoutIfNecessary();
        }
    }

    /**
     * Set the amount of horizontal (x) spacing to place between each item
     * in the grid.
     *
     * @param horizontalSpacing The amount of horizontal space between items,
     * in pixels.
     *
     * @attr ref android.R.styleable#GridView_horizontalSpacing
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.596 -0500", hash_original_method = "F4AD294FF1286508B5C248EDCA212E5B", hash_generated_method = "5DEE44ABB512D0CC9A048216808F8B17")
    
public void setHorizontalSpacing(int horizontalSpacing) {
        if (horizontalSpacing != mRequestedHorizontalSpacing) {
            mRequestedHorizontalSpacing = horizontalSpacing;
            requestLayoutIfNecessary();
        }
    }

    /**
     * Set the amount of vertical (y) spacing to place between each item
     * in the grid.
     *
     * @param verticalSpacing The amount of vertical space between items,
     * in pixels.
     *
     * @attr ref android.R.styleable#GridView_verticalSpacing
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.598 -0500", hash_original_method = "18D0FB9D8A0D215DBABAAD70588CEE39", hash_generated_method = "543EC8DA62BBEF590A2B2362755B8950")
    
public void setVerticalSpacing(int verticalSpacing) {
        if (verticalSpacing != mVerticalSpacing) {
            mVerticalSpacing = verticalSpacing;
            requestLayoutIfNecessary();
        }
    }

    /**
     * Control how items are stretched to fill their space.
     *
     * @param stretchMode Either {@link #NO_STRETCH},
     * {@link #STRETCH_SPACING}, {@link #STRETCH_SPACING_UNIFORM}, or {@link #STRETCH_COLUMN_WIDTH}.
     *
     * @attr ref android.R.styleable#GridView_stretchMode
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.600 -0500", hash_original_method = "C49A7586B9CFE9BA77F47A780C0C8544", hash_generated_method = "3CACC7AB0EB24497AB99DF73637693E8")
    
public void setStretchMode(int stretchMode) {
        if (stretchMode != mStretchMode) {
            mStretchMode = stretchMode;
            requestLayoutIfNecessary();
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.602 -0500", hash_original_method = "B323AFE5AE5939BBDA58166A4DF4B096", hash_generated_method = "8B261CCDF0ABD78D7C27D70E5708281B")
    
public int getStretchMode() {
        return mStretchMode;
    }

    /**
     * Set the width of columns in the grid.
     *
     * @param columnWidth The column width, in pixels.
     *
     * @attr ref android.R.styleable#GridView_columnWidth
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.605 -0500", hash_original_method = "2D3707A47407D7324964709BC50279C2", hash_generated_method = "8D3B64827C11D10879C4EF5C7CB79CD5")
    
public void setColumnWidth(int columnWidth) {
        if (columnWidth != mRequestedColumnWidth) {
            mRequestedColumnWidth = columnWidth;
            requestLayoutIfNecessary();
        }
    }

    /**
     * Set the number of columns in the grid
     *
     * @param numColumns The desired number of columns.
     *
     * @attr ref android.R.styleable#GridView_numColumns
     */
    @DSComment("GUI GridView")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.607 -0500", hash_original_method = "EB843153C85390AE48F1C91EE0B42CDB", hash_generated_method = "32237D441F88BBE7A70E783E7A6D387A")
    
public void setNumColumns(int numColumns) {
        if (numColumns != mRequestedNumColumns) {
            mRequestedNumColumns = numColumns;
            requestLayoutIfNecessary();
        }
    }
    
    /**
     * Get the number of columns in the grid. 
     * Returns {@link #AUTO_FIT} if the Grid has never been laid out.
     *
     * @attr ref android.R.styleable#GridView_numColumns
     * 
     * @see #setNumColumns(int)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.609 -0500", hash_original_method = "B011FDCEBE38F0939F62249D6B5BC711", hash_generated_method = "D8CF91B9DE565DB32EB07EB1ECA367C7")
    
@ViewDebug.ExportedProperty
    public int getNumColumns() {  
        return mNumColumns;
    }

    /**
     * Make sure views are touching the top or bottom edge, as appropriate for
     * our gravity
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.612 -0500", hash_original_method = "614329ACA245384517EF28FF3609B04B", hash_generated_method = "9BACAE2057F7A0E8F3874F7616D578C1")
    
private void adjustViewsUpOrDown() {
        final int childCount = getChildCount();

        if (childCount > 0) {
            int delta;
            View child;

            if (!mStackFromBottom) {
                // Uh-oh -- we came up short. Slide all views up to make them
                // align with the top
                child = getChildAt(0);
                delta = child.getTop() - mListPadding.top;
                if (mFirstPosition != 0) {
                    // It's OK to have some space above the first item if it is
                    // part of the vertical spacing
                    delta -= mVerticalSpacing;
                }
                if (delta < 0) {
                    // We only are looking to see if we are too low, not too high
                    delta = 0;
                }
            } else {
                // we are too high, slide all views down to align with bottom
                child = getChildAt(childCount - 1);
                delta = child.getBottom() - (getHeight() - mListPadding.bottom);
                
                if (mFirstPosition + childCount < mItemCount) {
                    // It's OK to have some space below the last item if it is
                    // part of the vertical spacing
                    delta += mVerticalSpacing;
                }
                
                if (delta > 0) {
                    // We only are looking to see if we are too high, not too low
                    delta = 0;
                }
            }

            if (delta != 0) {
                offsetChildrenTopAndBottom(-delta);
            }
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.614 -0500", hash_original_method = "0FB16985DD2A598E66D7882D349B86AF", hash_generated_method = "819AF93A5870428BF9285B3DC7EF3A40")
    
@Override
    protected int computeVerticalScrollExtent() {
        final int count = getChildCount();
        if (count > 0) {
            final int numColumns = mNumColumns;
            final int rowCount = (count + numColumns - 1) / numColumns;
            
            int extent = rowCount * 100;

            View view = getChildAt(0);
            final int top = view.getTop();
            int height = view.getHeight();
            if (height > 0) {
                extent += (top * 100) / height;
            }

            view = getChildAt(count - 1);
            final int bottom = view.getBottom();
            height = view.getHeight();
            if (height > 0) {
                extent -= ((bottom - getHeight()) * 100) / height;
            }

            return extent;
        }
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.617 -0500", hash_original_method = "77C851014C1118924C7173C75459421E", hash_generated_method = "EA31FD8F6DDC482EB26984D2E841D9C8")
    
@Override
    protected int computeVerticalScrollOffset() {
        if (mFirstPosition >= 0 && getChildCount() > 0) {
            final View view = getChildAt(0);
            final int top = view.getTop();
            int height = view.getHeight();
            if (height > 0) {
                final int numColumns = mNumColumns;
                final int whichRow = mFirstPosition / numColumns;
                final int rowCount = (mItemCount + numColumns - 1) / numColumns;
                return Math.max(whichRow * 100 - (top * 100) / height +
                        (int) ((float) mScrollY / getHeight() * rowCount * 100), 0);
            }
        }
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:30.619 -0500", hash_original_method = "2E67C9F09804D125789DA130D24F2E03", hash_generated_method = "79D520D501B7164C9A87D44DCA0E9555")
    
@Override
    protected int computeVerticalScrollRange() {
        // TODO: Account for vertical spacing too
        final int numColumns = mNumColumns;
        final int rowCount = (mItemCount + numColumns - 1) / numColumns;
        int result = Math.max(rowCount * 100, 0);
        if (mScrollY != 0) {
            // Compensate for overscroll
            result += Math.abs((int) ((float) mScrollY / getHeight() * rowCount * 100));
        }
        return result;
    }
}

