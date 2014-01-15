package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.android.internal.util.Predicate;
import com.google.android.collect.Lists;

public class ListView extends AbsListView {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.127 -0500", hash_original_field = "3443E4194A67070571A62B265508BBAC", hash_generated_field = "AA54EBB1B05B810D7997E2317D48B2F5")

    static final int NO_POSITION = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.130 -0500", hash_original_field = "ECBC1EF5D4BF64AEF1DE37634E9C2A00", hash_generated_field = "F481F11D6BAC4699C15393640CE5DB57")

    private static final float MAX_SCROLL_FACTOR = 0.33f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.132 -0500", hash_original_field = "D9E6DC323DAFFB16445ABE8ECBE9C0FB", hash_generated_field = "992BEAE71211E256B201562C8AAD0326")

    private static final int MIN_SCROLL_PREVIEW_PIXELS = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.144 -0500", hash_original_field = "FA953311C6E4177A6EEEF7C20D7073E0", hash_generated_field = "4BC24FD3C886BCFFDF832386DEC27D09")

    private ArrayList<FixedViewInfo> mHeaderViewInfos = Lists.newArrayList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.146 -0500", hash_original_field = "AF5E758AF770E2C699722BF3713D9AA4", hash_generated_field = "FD730016C2B4D9973A08935CB5CEEF24")

    private ArrayList<FixedViewInfo> mFooterViewInfos = Lists.newArrayList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.147 -0500", hash_original_field = "3837E71D24376BABDBC6EE7CD182AABB", hash_generated_field = "3837E71D24376BABDBC6EE7CD182AABB")

    Drawable mDivider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.149 -0500", hash_original_field = "E9BA9D611B13DC4B2EC5075D3CBC28DA", hash_generated_field = "E9BA9D611B13DC4B2EC5075D3CBC28DA")

    int mDividerHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.151 -0500", hash_original_field = "61CEC74004B40DBE67743F5C54E8DAE8", hash_generated_field = "61CEC74004B40DBE67743F5C54E8DAE8")

    Drawable mOverScrollHeader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.153 -0500", hash_original_field = "FAAE7751E5086898A7D9334FDB1CBF58", hash_generated_field = "FAAE7751E5086898A7D9334FDB1CBF58")

    Drawable mOverScrollFooter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.156 -0500", hash_original_field = "14036FB46376BFA7990434F6A215FE94", hash_generated_field = "D67B6F8B88187DB827FEE4CD95C0CD84")

    private boolean mIsCacheColorOpaque;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.158 -0500", hash_original_field = "74F5F0AFF7D0CF5C5F7BE3C1FE313C26", hash_generated_field = "F64CA3AD07E4A441F83FB08509D5EA54")

    private boolean mDividerIsOpaque;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.160 -0500", hash_original_field = "CB54C0F411509A897FD90A8A456020AA", hash_generated_field = "E4D279F003B799932AE6A47EC9C65A6F")

    private boolean mHeaderDividersEnabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.162 -0500", hash_original_field = "54C1DDC428BB19C22C72A9F1869CAE34", hash_generated_field = "D61311FF24E9C122770C1CC46CD91809")

    private boolean mFooterDividersEnabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.164 -0500", hash_original_field = "E14E4D3D1F6712B452F187DA751BE80B", hash_generated_field = "1E6DAAB899E2A1039D680325576FF2F4")

    private boolean mAreAllItemsSelectable = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.167 -0500", hash_original_field = "9E81E0C2E54D4B0A451403FCCC4A885C", hash_generated_field = "B872CC30C5370C029EE2A26D5DBEB2D2")

    private boolean mItemsCanFocus = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.169 -0500", hash_original_field = "1732EB32F2D77CCA26590AEEA670A175", hash_generated_field = "A498F2A4744F31D22F9C4ABEBB254F2F")

    private final Rect mTempRect = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.171 -0500", hash_original_field = "D3B506AA5ECE601C42D62A4FBBAC6C8F", hash_generated_field = "4B2413695EEECE37901862E70E0ADF71")

    private Paint mDividerPaint;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.173 -0500", hash_original_field = "86E269DF3FCF7D0334C758833E01E651", hash_generated_field = "0FC80635AD914687076CCE4649849083")

    // allocating these thingies too often.
    private final ArrowScrollFocusResult mArrowScrollFocusResult = new ArrowScrollFocusResult();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.176 -0500", hash_original_field = "59FB706EA5D011340B8A8EF5B221E3CB", hash_generated_field = "21847DEAFE51D735E62E529ABB2AD8CB")

    private FocusSelector mFocusSelector;
    
	@DSComment("ListView")
    @DSSafe(DSCat.GUI)
    public ListView(Context context) {
		super(context);
	}
    
    @DSComment("ListView")
    @DSSafe(DSCat.GUI)
    public ListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
    
    @DSComment("ListView")
    @DSSafe(DSCat.GUI)
    public ListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

    /**
     * @return The maximum amount a list view will scroll in response to
     *   an arrow event.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.187 -0500", hash_original_method = "13CC3D3BB67006B8B223FEAA5CEB8AD3", hash_generated_method = "F4B27DCC3FC0D9E1A9D6D278F1CEE295")
    
public int getMaxScrollAmount() {
        return (int) (MAX_SCROLL_FACTOR * (mBottom - mTop));
    }

    /**
     * Make sure views are touching the top or bottom edge, as appropriate for
     * our gravity
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.189 -0500", hash_original_method = "C98C1C3289511C3CD05158CF07015375", hash_generated_method = "4B06B7DA9AFCA961A27A7E6E2AFFFDDE")
    
private void adjustViewsUpOrDown() {
        final int childCount = getChildCount();
        int delta;

        if (childCount > 0) {
            View child;

            if (!mStackFromBottom) {
                // Uh-oh -- we came up short. Slide all views up to make them
                // align with the top
                child = getChildAt(0);
                delta = child.getTop() - mListPadding.top;
                if (mFirstPosition != 0) {
                    // It's OK to have some space above the first item if it is
                    // part of the vertical spacing
                    delta -= mDividerHeight;
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
                    delta += mDividerHeight;
                }

                if (delta > 0) {
                    delta = 0;
                }
            }

            if (delta != 0) {
                offsetChildrenTopAndBottom(-delta);
            }
        }
    }

    /**
     * Add a fixed view to appear at the top of the list. If addHeaderView is
     * called more than once, the views will appear in the order they were
     * added. Views added using this call can take focus if they want.
     * <p>
     * NOTE: Call this before calling setAdapter. This is so ListView can wrap
     * the supplied cursor with one that will also account for header and footer
     * views.
     *
     * @param v The view to add.
     * @param data Data to associate with this view
     * @param isSelectable whether the item is selectable
     */
    @DSComment("ListView")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.192 -0500", hash_original_method = "52D3689EBA08A028E74C350405FC2CA4", hash_generated_method = "045363224276C4854AF4CA32ED4639D7")
    
public void addHeaderView(View v, Object data, boolean isSelectable) {

        if (mAdapter != null && ! (mAdapter instanceof HeaderViewListAdapter)) {
            throw new IllegalStateException(
                    "Cannot add header view to list -- setAdapter has already been called.");
        }

        FixedViewInfo info = new FixedViewInfo();
        info.view = v;
        info.data = data;
        info.isSelectable = isSelectable;
        mHeaderViewInfos.add(info);

        // in the case of re-adding a header view, or adding one later on,
        // we need to notify the observer
        if (mAdapter != null && mDataSetObserver != null) {
            mDataSetObserver.onChanged();
        }
    }

    /**
     * Add a fixed view to appear at the top of the list. If addHeaderView is
     * called more than once, the views will appear in the order they were
     * added. Views added using this call can take focus if they want.
     * <p>
     * NOTE: Call this before calling setAdapter. This is so ListView can wrap
     * the supplied cursor with one that will also account for header and footer
     * views.
     *
     * @param v The view to add.
     */
    @DSComment("ListView")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.194 -0500", hash_original_method = "9CDB9BC1941825D09F579B09BA5203C8", hash_generated_method = "4DF54523D3EC1F125E11DDC6B52B4BA2")
    
public void addHeaderView(View v) {
        addHeaderView(v, null, true);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.196 -0500", hash_original_method = "9A198FE2F7DAA22CDFAB063EB95C8DFA", hash_generated_method = "0C98AA20D95365DB82AB3DF0F0DB74B0")
    
@Override
    public int getHeaderViewsCount() {
        return mHeaderViewInfos.size();
    }

    /**
     * Removes a previously-added header view.
     *
     * @param v The view to remove
     * @return true if the view was removed, false if the view was not a header
     *         view
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.198 -0500", hash_original_method = "8EF6528E21853FD53F2FB8406F9F06D5", hash_generated_method = "1FBC85A83D94EF6B0DCAC0EE08B0F0E2")
    
public boolean removeHeaderView(View v) {
        if (mHeaderViewInfos.size() > 0) {
            boolean result = false;
            if (mAdapter != null && ((HeaderViewListAdapter) mAdapter).removeHeader(v)) {
                if (mDataSetObserver != null) {
                    mDataSetObserver.onChanged();
                }
                result = true;
            }
            removeFixedViewInfo(v, mHeaderViewInfos);
            return result;
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.201 -0500", hash_original_method = "56A07A9A1AC012F692F90759B155683C", hash_generated_method = "3AA47336953230010BA3D3E6F8F9A632")
    
private void removeFixedViewInfo(View v, ArrayList<FixedViewInfo> where) {
        int len = where.size();
        for (int i = 0; i < len; ++i) {
            FixedViewInfo info = where.get(i);
            if (info.view == v) {
                where.remove(i);
                break;
            }
        }
    }

    /**
     * Add a fixed view to appear at the bottom of the list. If addFooterView is
     * called more than once, the views will appear in the order they were
     * added. Views added using this call can take focus if they want.
     * <p>
     * NOTE: Call this before calling setAdapter. This is so ListView can wrap
     * the supplied cursor with one that will also account for header and footer
     * views.
     *
     * @param v The view to add.
     * @param data Data to associate with this view
     * @param isSelectable true if the footer view can be selected
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.204 -0500", hash_original_method = "854663FFCE0B2EEEA12F571F4E080752", hash_generated_method = "12CB9C16CBE240104F270BEBAAE219EE")
    
public void addFooterView(View v, Object data, boolean isSelectable) {

        // NOTE: do not enforce the adapter being null here, since unlike in
        // addHeaderView, it was never enforced here, and so existing apps are
        // relying on being able to add a footer and then calling setAdapter to
        // force creation of the HeaderViewListAdapter wrapper

        FixedViewInfo info = new FixedViewInfo();
        info.view = v;
        info.data = data;
        info.isSelectable = isSelectable;
        mFooterViewInfos.add(info);

        // in the case of re-adding a footer view, or adding one later on,
        // we need to notify the observer
        if (mAdapter != null && mDataSetObserver != null) {
            mDataSetObserver.onChanged();
        }
    }

    /**
     * Add a fixed view to appear at the bottom of the list. If addFooterView is called more
     * than once, the views will appear in the order they were added. Views added using
     * this call can take focus if they want.
     * <p>NOTE: Call this before calling setAdapter. This is so ListView can wrap the supplied
     * cursor with one that will also account for header and footer views.
     *
     *
     * @param v The view to add.
     */
    @DSComment("ListView")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.206 -0500", hash_original_method = "06A7CBCF71002E57CE516EE24D5E8CDC", hash_generated_method = "670DAD95C314A4774458F5AE45462EEF")
    
public void addFooterView(View v) {
        addFooterView(v, null, true);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.209 -0500", hash_original_method = "83BE551B6778E6D258871D9949AEF538", hash_generated_method = "5756AE65BD0787102B02E288262B94F8")
    
@Override
    public int getFooterViewsCount() {
        return mFooterViewInfos.size();
    }

    /**
     * Removes a previously-added footer view.
     *
     * @param v The view to remove
     * @return
     * true if the view was removed, false if the view was not a footer view
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.211 -0500", hash_original_method = "D2E29F254410117CE819574854BB79EC", hash_generated_method = "9E7D819F4E7FE83734719AA0B6321B58")
    
public boolean removeFooterView(View v) {
        if (mFooterViewInfos.size() > 0) {
            boolean result = false;
            if (mAdapter != null && ((HeaderViewListAdapter) mAdapter).removeFooter(v)) {
                if (mDataSetObserver != null) {
                    mDataSetObserver.onChanged();
                }
                result = true;
            }
            removeFixedViewInfo(v, mFooterViewInfos);
            return result;
        }
        return false;
    }
    
    @DSComment("ListView")
    @DSSafe(DSCat.GUI)
    @Override
	public ListAdapter getAdapter() {
		// TODO Auto-generated method stub
		return null;
	}

    /**
     * Sets up this AbsListView to use a remote views adapter which connects to a RemoteViewsService
     * through the specified intent.
     * @param intent the intent used to identify the RemoteViewsService for the adapter to connect to.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.216 -0500", hash_original_method = "8AB2C6958FD7CEC3A8A71FE59763D6A4", hash_generated_method = "06FC87714B69CEC8209EE3A8D52302FA")
    
@android.view.RemotableViewMethod
    public void setRemoteViewsAdapter(Intent intent) {
        super.setRemoteViewsAdapter(intent);
    }
    
    @DSComment("ListView")
    @DSSafe(DSCat.GUI)
    @Override
	
	public void setAdapter(ListAdapter adapter) {
      // Remember the list adapter so we can access it when registered
      mAdapter = adapter;
      super.setAdapter(adapter); // Taint in AbsListView

        // Original code
        /* 
        if (mAdapter != null && mDataSetObserver != null) {
            mAdapter.unregisterDataSetObserver(mDataSetObserver);
        }

        resetList();
        mRecycler.clear();

        if (mHeaderViewInfos.size() > 0|| mFooterViewInfos.size() > 0) {
            mAdapter = new HeaderViewListAdapter(mHeaderViewInfos, mFooterViewInfos, adapter);
        } else {
            mAdapter = adapter;
        }

        mOldSelectedPosition = INVALID_POSITION;
        mOldSelectedRowId = INVALID_ROW_ID;

        // AbsListView#setAdapter will update choice mode states.
        super.setAdapter(adapter);

        if (mAdapter != null) {
            mAreAllItemsSelectable = mAdapter.areAllItemsEnabled();
            mOldItemCount = mItemCount;
            mItemCount = mAdapter.getCount();
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

            if (mItemCount == 0) {
                // Nothing selected
                checkSelectionChanged();
            }
        } else {
            mAreAllItemsSelectable = true;
            checkFocus();
            // Nothing selected
            checkSelectionChanged();
        }

        requestLayout();
        */

	}

    /**
     * The list is empty. Clear everything out.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.221 -0500", hash_original_method = "2C61A8961B533B2EFAE2B5516136BD48", hash_generated_method = "26C2B10AFDA526EBD3AE5E8875BB8BDD")
    
@Override
    void resetList() {
        // The parent's resetList() will remove all views from the layout so we need to
        // cleanup the state of our footers and headers
        clearRecycledState(mHeaderViewInfos);
        clearRecycledState(mFooterViewInfos);

        super.resetList();

        mLayoutMode = LAYOUT_NORMAL;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.223 -0500", hash_original_method = "917FCC60A4286C5138F872CFDA18A6AE", hash_generated_method = "833B359465DE0427EC0C1B464B542A37")
    
private void clearRecycledState(ArrayList<FixedViewInfo> infos) {
        if (infos != null) {
            final int count = infos.size();

            for (int i = 0; i < count; i++) {
                final View child = infos.get(i).view;
                final LayoutParams p = (LayoutParams) child.getLayoutParams();
                if (p != null) {
                    p.recycledHeaderFooter = false;
                }
            }
        }
    }

    /**
     * @return Whether the list needs to show the top fading edge
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.226 -0500", hash_original_method = "AE08170EA161B6A1BF0E53E679181532", hash_generated_method = "E99EC7FA086AFFD53CE78C3E2C60DFF7")
    
private boolean showingTopFadingEdge() {
        final int listTop = mScrollY + mListPadding.top;
        return (mFirstPosition > 0) || (getChildAt(0).getTop() > listTop);
    }

    /**
     * @return Whether the list needs to show the bottom fading edge
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.228 -0500", hash_original_method = "471206817827115E6FDE8330BC3BFE06", hash_generated_method = "3885AC819B7A36887E76497C51D45C45")
    
private boolean showingBottomFadingEdge() {
        final int childCount = getChildCount();
        final int bottomOfBottomChild = getChildAt(childCount - 1).getBottom();
        final int lastVisiblePosition = mFirstPosition + childCount - 1;

        final int listBottom = mScrollY + getHeight() - mListPadding.bottom;

        return (lastVisiblePosition < mItemCount - 1)
                         || (bottomOfBottomChild < listBottom);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.232 -0500", hash_original_method = "0248A9BC20DE00C469CC3A8962885EF5", hash_generated_method = "1F58D1468C3A1BB5124FB8EC2CC05F8E")
    
@Override
    public boolean requestChildRectangleOnScreen(View child, Rect rect, boolean immediate) {

        int rectTopWithinChild = rect.top;

        // offset so rect is in coordinates of the this view
        rect.offset(child.getLeft(), child.getTop());
        rect.offset(-child.getScrollX(), -child.getScrollY());

        final int height = getHeight();
        int listUnfadedTop = getScrollY();
        int listUnfadedBottom = listUnfadedTop + height;
        final int fadingEdge = getVerticalFadingEdgeLength();

        if (showingTopFadingEdge()) {
            // leave room for top fading edge as long as rect isn't at very top
            if ((mSelectedPosition > 0) || (rectTopWithinChild > fadingEdge)) {
                listUnfadedTop += fadingEdge;
            }
        }

        int childCount = getChildCount();
        int bottomOfBottomChild = getChildAt(childCount - 1).getBottom();

        if (showingBottomFadingEdge()) {
            // leave room for bottom fading edge as long as rect isn't at very bottom
            if ((mSelectedPosition < mItemCount - 1)
                    || (rect.bottom < (bottomOfBottomChild - fadingEdge))) {
                listUnfadedBottom -= fadingEdge;
            }
        }

        int scrollYDelta = 0;

        if (rect.bottom > listUnfadedBottom && rect.top > listUnfadedTop) {
            // need to MOVE DOWN to get it in view: move down just enough so
            // that the entire rectangle is in view (or at least the first
            // screen size chunk).

            if (rect.height() > height) {
                // just enough to get screen size chunk on
                scrollYDelta += (rect.top - listUnfadedTop);
            } else {
                // get entire rect at bottom of screen
                scrollYDelta += (rect.bottom - listUnfadedBottom);
            }

            // make sure we aren't scrolling beyond the end of our children
            int distanceToBottom = bottomOfBottomChild - listUnfadedBottom;
            scrollYDelta = Math.min(scrollYDelta, distanceToBottom);
        } else if (rect.top < listUnfadedTop && rect.bottom < listUnfadedBottom) {
            // need to MOVE UP to get it in view: move up just enough so that
            // entire rectangle is in view (or at least the first screen
            // size chunk of it).

            if (rect.height() > height) {
                // screen size chunk
                scrollYDelta -= (listUnfadedBottom - rect.bottom);
            } else {
                // entire rect at top
                scrollYDelta -= (listUnfadedTop - rect.top);
            }

            // make sure we aren't scrolling any further than the top our children
            int top = getChildAt(0).getTop();
            int deltaToTop = top - listUnfadedTop;
            scrollYDelta = Math.max(scrollYDelta, deltaToTop);
        }

        final boolean scroll = scrollYDelta != 0;
        if (scroll) {
            scrollListItemsBy(-scrollYDelta);
            positionSelector(INVALID_POSITION, child);
            mSelectedTop = child.getTop();
            invalidate();
        }
        return scroll;
    }
    
    @Override
	void fillGap(boolean down) {
		// TODO Auto-generated method stub
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.237 -0500", hash_original_method = "A51DD6537C0400974E1B605AE841C465", hash_generated_method = "F4555E8F55AFB244C40B5C6733FA4C7A")
    
private View fillDown(int pos, int nextTop) {
        View selectedView = null;

        int end = (mBottom - mTop);
        if ((mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK) {
            end -= mListPadding.bottom;
        }

        while (nextTop < end && pos < mItemCount) {
            // is this the selected item?
            boolean selected = pos == mSelectedPosition;
            View child = makeAndAddView(pos, nextTop, true, mListPadding.left, selected);

            nextTop = child.getBottom() + mDividerHeight;
            if (selected) {
                selectedView = child;
            }
            pos++;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.239 -0500", hash_original_method = "05C528C2066045A21E9535AE6FF4CD3D", hash_generated_method = "7FC6F678059DC4C8F2D7F453905F534B")
    
private View fillUp(int pos, int nextBottom) {
        View selectedView = null;

        int end = 0;
        if ((mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK) {
            end = mListPadding.top;
        }

        while (nextBottom > end && pos >= 0) {
            // is this the selected item?
            boolean selected = pos == mSelectedPosition;
            View child = makeAndAddView(pos, nextBottom, false, mListPadding.left, selected);
            nextBottom = child.getTop() - mDividerHeight;
            if (selected) {
                selectedView = child;
            }
            pos--;
        }

        mFirstPosition = pos + 1;

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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.241 -0500", hash_original_method = "E858B13EC4F52DD7B2125F2E9BA15919", hash_generated_method = "56583347CE4DAE881DB0E0B40B64B1D2")
    
private View fillFromTop(int nextTop) {
        mFirstPosition = Math.min(mFirstPosition, mSelectedPosition);
        mFirstPosition = Math.min(mFirstPosition, mItemCount - 1);
        if (mFirstPosition < 0) {
            mFirstPosition = 0;
        }
        return fillDown(mFirstPosition, nextTop);
    }

    /**
     * Put mSelectedPosition in the middle of the screen and then build up and
     * down from there. This method forces mSelectedPosition to the center.
     *
     * @param childrenTop Top of the area in which children can be drawn, as
     *        measured in pixels
     * @param childrenBottom Bottom of the area in which children can be drawn,
     *        as measured in pixels
     * @return Currently selected view
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.244 -0500", hash_original_method = "BB6F12E082A75859BCEF500D953CB8EE", hash_generated_method = "77669E5E2E2E9E3420F4EC1BD5E0EDB7")
    
private View fillFromMiddle(int childrenTop, int childrenBottom) {
        int height = childrenBottom - childrenTop;

        int position = reconcileSelectedPosition();

        View sel = makeAndAddView(position, childrenTop, true,
                mListPadding.left, true);
        mFirstPosition = position;

        int selHeight = sel.getMeasuredHeight();
        if (selHeight <= height) {
            sel.offsetTopAndBottom((height - selHeight) / 2);
        }

        fillAboveAndBelow(sel, position);

        if (!mStackFromBottom) {
            correctTooHigh(getChildCount());
        } else {
            correctTooLow(getChildCount());
        }

        return sel;
    }

    /**
     * Once the selected view as been placed, fill up the visible area above and
     * below it.
     *
     * @param sel The selected view
     * @param position The position corresponding to sel
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.247 -0500", hash_original_method = "E7EAC0AC74052E989A5F3C8A8979A51D", hash_generated_method = "397E4D71254ADC49C2D37EA85C52BDCF")
    
private void fillAboveAndBelow(View sel, int position) {
        final int dividerHeight = mDividerHeight;
        if (!mStackFromBottom) {
            fillUp(position - 1, sel.getTop() - dividerHeight);
            adjustViewsUpOrDown();
            fillDown(position + 1, sel.getBottom() + dividerHeight);
        } else {
            fillDown(position + 1, sel.getBottom() + dividerHeight);
            adjustViewsUpOrDown();
            fillUp(position - 1, sel.getTop() - dividerHeight);
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.250 -0500", hash_original_method = "439BAC8174DEF92DB2EFE731B080B752", hash_generated_method = "34D6550190D69FAA6F588BBB6D31FA85")
    
private View fillFromSelection(int selectedTop, int childrenTop, int childrenBottom) {
        int fadingEdgeLength = getVerticalFadingEdgeLength();
        final int selectedPosition = mSelectedPosition;

        View sel;

        final int topSelectionPixel = getTopSelectionPixel(childrenTop, fadingEdgeLength,
                selectedPosition);
        final int bottomSelectionPixel = getBottomSelectionPixel(childrenBottom, fadingEdgeLength,
                selectedPosition);

        sel = makeAndAddView(selectedPosition, selectedTop, true, mListPadding.left, true);

        // Some of the newly selected item extends below the bottom of the list
        if (sel.getBottom() > bottomSelectionPixel) {
            // Find space available above the selection into which we can scroll
            // upwards
            final int spaceAbove = sel.getTop() - topSelectionPixel;

            // Find space required to bring the bottom of the selected item
            // fully into view
            final int spaceBelow = sel.getBottom() - bottomSelectionPixel;
            final int offset = Math.min(spaceAbove, spaceBelow);

            // Now offset the selected item to get it into view
            sel.offsetTopAndBottom(-offset);
        } else if (sel.getTop() < topSelectionPixel) {
            // Find space required to bring the top of the selected item fully
            // into view
            final int spaceAbove = topSelectionPixel - sel.getTop();

            // Find space available below the selection into which we can scroll
            // downwards
            final int spaceBelow = bottomSelectionPixel - sel.getBottom();
            final int offset = Math.min(spaceAbove, spaceBelow);

            // Offset the selected item to get it into view
            sel.offsetTopAndBottom(offset);
        }

        // Fill in views above and below
        fillAboveAndBelow(sel, selectedPosition);

        if (!mStackFromBottom) {
            correctTooHigh(getChildCount());
        } else {
            correctTooLow(getChildCount());
        }

        return sel;
    }

    /**
     * Calculate the bottom-most pixel we can draw the selection into
     *
     * @param childrenBottom Bottom pixel were children can be drawn
     * @param fadingEdgeLength Length of the fading edge in pixels, if present
     * @param selectedPosition The position that will be selected
     * @return The bottom-most pixel we can draw the selection into
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.252 -0500", hash_original_method = "DDE472821830C07DE1368C905BA02EE1", hash_generated_method = "886483FEF9232076250A658FCC8FD11C")
    
private int getBottomSelectionPixel(int childrenBottom, int fadingEdgeLength,
            int selectedPosition) {
        int bottomSelectionPixel = childrenBottom;
        if (selectedPosition != mItemCount - 1) {
            bottomSelectionPixel -= fadingEdgeLength;
        }
        return bottomSelectionPixel;
    }

    /**
     * Calculate the top-most pixel we can draw the selection into
     *
     * @param childrenTop Top pixel were children can be drawn
     * @param fadingEdgeLength Length of the fading edge in pixels, if present
     * @param selectedPosition The position that will be selected
     * @return The top-most pixel we can draw the selection into
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.254 -0500", hash_original_method = "173BB2BFF18272B67A930A02164FEB0F", hash_generated_method = "FA5EB2D447AE7E3C330D6E2E9FA7FBB8")
    
private int getTopSelectionPixel(int childrenTop, int fadingEdgeLength, int selectedPosition) {
        // first pixel we can draw the selection into
        int topSelectionPixel = childrenTop;
        if (selectedPosition > 0) {
            topSelectionPixel += fadingEdgeLength;
        }
        return topSelectionPixel;
    }

    /**
     * Smoothly scroll to the specified adapter position. The view will
     * scroll such that the indicated position is displayed.
     * @param position Scroll to this adapter position.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.257 -0500", hash_original_method = "19B54E9E42F50C19B80602093C26BC32", hash_generated_method = "A8A3C236FF85813945F7C1B0B7869E60")
    
@android.view.RemotableViewMethod
    public void smoothScrollToPosition(int position) {
        super.smoothScrollToPosition(position);
    }

    /**
     * Smoothly scroll to the specified adapter position offset. The view will
     * scroll such that the indicated position is displayed.
     * @param offset The amount to offset from the adapter position to scroll to.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.259 -0500", hash_original_method = "9A2E566018459C8A4F9FE2F49DBB98B8", hash_generated_method = "8E840BFE7E6405298EC13CA3DE52B347")
    
@android.view.RemotableViewMethod
    public void smoothScrollByOffset(int offset) {
        super.smoothScrollByOffset(offset);
    }

    /**
     * Fills the list based on positioning the new selection relative to the old
     * selection. The new selection will be placed at, above, or below the
     * location of the new selection depending on how the selection is moving.
     * The selection will then be pinned to the visible part of the screen,
     * excluding the edges that are faded. The list is then filled upwards and
     * downwards from there.
     *
     * @param oldSel The old selected view. Useful for trying to put the new
     *        selection in the same place
     * @param newSel The view that is to become selected. Useful for trying to
     *        put the new selection in the same place
     * @param delta Which way we are moving
     * @param childrenTop Where to start drawing children
     * @param childrenBottom Last pixel where children can be drawn
     * @return The view that currently has selection
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.264 -0500", hash_original_method = "A6BE2578E6D412634113B39CFD73986F", hash_generated_method = "1DAFB44181A2B5C36C4DF9798EEB6703")
    
private View moveSelection(View oldSel, View newSel, int delta, int childrenTop,
            int childrenBottom) {
        int fadingEdgeLength = getVerticalFadingEdgeLength();
        final int selectedPosition = mSelectedPosition;

        View sel;

        final int topSelectionPixel = getTopSelectionPixel(childrenTop, fadingEdgeLength,
                selectedPosition);
        final int bottomSelectionPixel = getBottomSelectionPixel(childrenTop, fadingEdgeLength,
                selectedPosition);

        if (delta > 0) {
            /*
             * Case 1: Scrolling down.
             */

            /*
             *     Before           After
             *    |       |        |       |
             *    +-------+        +-------+
             *    |   A   |        |   A   |
             *    |   1   |   =>   +-------+
             *    +-------+        |   B   |
             *    |   B   |        |   2   |
             *    +-------+        +-------+
             *    |       |        |       |
             *
             *    Try to keep the top of the previously selected item where it was.
             *    oldSel = A
             *    sel = B
             */

            // Put oldSel (A) where it belongs
            oldSel = makeAndAddView(selectedPosition - 1, oldSel.getTop(), true,
                    mListPadding.left, false);

            final int dividerHeight = mDividerHeight;

            // Now put the new selection (B) below that
            sel = makeAndAddView(selectedPosition, oldSel.getBottom() + dividerHeight, true,
                    mListPadding.left, true);

            // Some of the newly selected item extends below the bottom of the list
            if (sel.getBottom() > bottomSelectionPixel) {

                // Find space available above the selection into which we can scroll upwards
                int spaceAbove = sel.getTop() - topSelectionPixel;

                // Find space required to bring the bottom of the selected item fully into view
                int spaceBelow = sel.getBottom() - bottomSelectionPixel;

                // Don't scroll more than half the height of the list
                int halfVerticalSpace = (childrenBottom - childrenTop) / 2;
                int offset = Math.min(spaceAbove, spaceBelow);
                offset = Math.min(offset, halfVerticalSpace);

                // We placed oldSel, so offset that item
                oldSel.offsetTopAndBottom(-offset);
                // Now offset the selected item to get it into view
                sel.offsetTopAndBottom(-offset);
            }

            // Fill in views above and below
            if (!mStackFromBottom) {
                fillUp(mSelectedPosition - 2, sel.getTop() - dividerHeight);
                adjustViewsUpOrDown();
                fillDown(mSelectedPosition + 1, sel.getBottom() + dividerHeight);
            } else {
                fillDown(mSelectedPosition + 1, sel.getBottom() + dividerHeight);
                adjustViewsUpOrDown();
                fillUp(mSelectedPosition - 2, sel.getTop() - dividerHeight);
            }
        } else if (delta < 0) {
            /*
             * Case 2: Scrolling up.
             */

            /*
             *     Before           After
             *    |       |        |       |
             *    +-------+        +-------+
             *    |   A   |        |   A   |
             *    +-------+   =>   |   1   |
             *    |   B   |        +-------+
             *    |   2   |        |   B   |
             *    +-------+        +-------+
             *    |       |        |       |
             *
             *    Try to keep the top of the item about to become selected where it was.
             *    newSel = A
             *    olSel = B
             */

            if (newSel != null) {
                // Try to position the top of newSel (A) where it was before it was selected
                sel = makeAndAddView(selectedPosition, newSel.getTop(), true, mListPadding.left,
                        true);
            } else {
                // If (A) was not on screen and so did not have a view, position
                // it above the oldSel (B)
                sel = makeAndAddView(selectedPosition, oldSel.getTop(), false, mListPadding.left,
                        true);
            }

            // Some of the newly selected item extends above the top of the list
            if (sel.getTop() < topSelectionPixel) {
                // Find space required to bring the top of the selected item fully into view
                int spaceAbove = topSelectionPixel - sel.getTop();

               // Find space available below the selection into which we can scroll downwards
                int spaceBelow = bottomSelectionPixel - sel.getBottom();

                // Don't scroll more than half the height of the list
                int halfVerticalSpace = (childrenBottom - childrenTop) / 2;
                int offset = Math.min(spaceAbove, spaceBelow);
                offset = Math.min(offset, halfVerticalSpace);

                // Offset the selected item to get it into view
                sel.offsetTopAndBottom(offset);
            }

            // Fill in views above and below
            fillAboveAndBelow(sel, selectedPosition);
        } else {

            int oldTop = oldSel.getTop();

            /*
             * Case 3: Staying still
             */
            sel = makeAndAddView(selectedPosition, oldTop, true, mListPadding.left, true);

            // We're staying still...
            if (oldTop < childrenTop) {
                // ... but the top of the old selection was off screen.
                // (This can happen if the data changes size out from under us)
                int newBottom = sel.getBottom();
                if (newBottom < childrenTop + 20) {
                    // Not enough visible -- bring it onscreen
                    sel.offsetTopAndBottom(childrenTop - sel.getTop());
                }
            }

            // Fill in views above and below
            fillAboveAndBelow(sel, selectedPosition);
        }

        return sel;
    }
    
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
	}

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.281 -0500", hash_original_method = "593EBCA8FD80357C209889704061F804", hash_generated_method = "9881BC3D5B36212FEA51F4DAB3C855DD")
    
@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // Sets up mListPadding
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int childWidth = 0;
        int childHeight = 0;
        int childState = 0;

        mItemCount = mAdapter == null ? 0 : mAdapter.getCount();
        if (mItemCount > 0 && (widthMode == MeasureSpec.UNSPECIFIED ||
                heightMode == MeasureSpec.UNSPECIFIED)) {
            final View child = obtainView(0, mIsScrap);

            measureScrapChild(child, 0, widthMeasureSpec);

            childWidth = child.getMeasuredWidth();
            childHeight = child.getMeasuredHeight();
            childState = combineMeasuredStates(childState, child.getMeasuredState());

            if (recycleOnMeasure() && mRecycler.shouldRecycleViewType(
                    ((LayoutParams) child.getLayoutParams()).viewType)) {
                mRecycler.addScrapView(child, -1);
            }
        }

        if (widthMode == MeasureSpec.UNSPECIFIED) {
            widthSize = mListPadding.left + mListPadding.right + childWidth +
                    getVerticalScrollbarWidth();
        } else {
            widthSize |= (childState&MEASURED_STATE_MASK);
        }

        if (heightMode == MeasureSpec.UNSPECIFIED) {
            heightSize = mListPadding.top + mListPadding.bottom + childHeight +
                    getVerticalFadingEdgeLength() * 2;
        }

        if (heightMode == MeasureSpec.AT_MOST) {
            // TODO: after first layout we should maybe start at the first visible position, not 0
            heightSize = measureHeightOfChildren(widthMeasureSpec, 0, NO_POSITION, heightSize, -1);
        }

        setMeasuredDimension(widthSize , heightSize);
        mWidthMeasureSpec = widthMeasureSpec;        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.284 -0500", hash_original_method = "F21C4EE74005F045F306FF7685001DDA", hash_generated_method = "A2D09C9120F3F83EBF7780E64ADAA803")
    
private void measureScrapChild(View child, int position, int widthMeasureSpec) {
        LayoutParams p = (LayoutParams) child.getLayoutParams();
        if (p == null) {
            p = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, 0);
            child.setLayoutParams(p);
        }
        p.viewType = mAdapter.getItemViewType(position);
        p.forceAdd = true;

        int childWidthSpec = ViewGroup.getChildMeasureSpec(widthMeasureSpec,
                mListPadding.left + mListPadding.right, p.width);
        int lpHeight = p.height;
        int childHeightSpec;
        if (lpHeight > 0) {
            childHeightSpec = MeasureSpec.makeMeasureSpec(lpHeight, MeasureSpec.EXACTLY);
        } else {
            childHeightSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        }
        child.measure(childWidthSpec, childHeightSpec);
    }

    /**
     * @return True to recycle the views used to measure this ListView in
     *         UNSPECIFIED/AT_MOST modes, false otherwise.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.286 -0500", hash_original_method = "8F0B08D4426D8F4F23EF014B56CDCFE6", hash_generated_method = "223608FD957FABDB4BB703804987D3E3")
    
@ViewDebug.ExportedProperty(category = "list")
    protected boolean recycleOnMeasure() {
        return true;
    }

    /**
     * Measures the height of the given range of children (inclusive) and
     * returns the height with this ListView's padding and divider heights
     * included. If maxHeight is provided, the measuring will stop when the
     * current height reaches maxHeight.
     *
     * @param widthMeasureSpec The width measure spec to be given to a child's
     *            {@link View#measure(int, int)}.
     * @param startPosition The position of the first child to be shown.
     * @param endPosition The (inclusive) position of the last child to be
     *            shown. Specify {@link #NO_POSITION} if the last child should be
     *            the last available child from the adapter.
     * @param maxHeight The maximum height that will be returned (if all the
     *            children don't fit in this value, this value will be
     *            returned).
     * @param disallowPartialChildPosition In general, whether the returned
     *            height should only contain entire children. This is more
     *            powerful--it is the first inclusive position at which partial
     *            children will not be allowed. Example: it looks nice to have
     *            at least 3 completely visible children, and in portrait this
     *            will most likely fit; but in landscape there could be times
     *            when even 2 children can not be completely shown, so a value
     *            of 2 (remember, inclusive) would be good (assuming
     *            startPosition is 0).
     * @return The height of this ListView with the given children.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.290 -0500", hash_original_method = "4E8DF0CF85AB0B6CF8E1C94B60E67D20", hash_generated_method = "5F7A25BE62B38833D577957122137986")
    
final int measureHeightOfChildren(int widthMeasureSpec, int startPosition, int endPosition,
            final int maxHeight, int disallowPartialChildPosition) {

        final ListAdapter adapter = mAdapter;
        if (adapter == null) {
            return mListPadding.top + mListPadding.bottom;
        }

        // Include the padding of the list
        int returnedHeight = mListPadding.top + mListPadding.bottom;
        final int dividerHeight = ((mDividerHeight > 0) && mDivider != null) ? mDividerHeight : 0;
        // The previous height value that was less than maxHeight and contained
        // no partial children
        int prevHeightWithoutPartialChild = 0;
        int i;
        View child;

        // mItemCount - 1 since endPosition parameter is inclusive
        endPosition = (endPosition == NO_POSITION) ? adapter.getCount() - 1 : endPosition;
        final AbsListView.RecycleBin recycleBin = mRecycler;
        final boolean recyle = recycleOnMeasure();
        final boolean[] isScrap = mIsScrap;

        for (i = startPosition; i <= endPosition; ++i) {
            child = obtainView(i, isScrap);

            measureScrapChild(child, i, widthMeasureSpec);

            if (i > 0) {
                // Count the divider for all but one child
                returnedHeight += dividerHeight;
            }

            // Recycle the view before we possibly return from the method
            if (recyle && recycleBin.shouldRecycleViewType(
                    ((LayoutParams) child.getLayoutParams()).viewType)) {
                recycleBin.addScrapView(child, -1);
            }

            returnedHeight += child.getMeasuredHeight();

            if (returnedHeight >= maxHeight) {
                // We went over, figure out which height to return.  If returnedHeight > maxHeight,
                // then the i'th position did not fit completely.
                return (disallowPartialChildPosition >= 0) // Disallowing is enabled (> -1)
                            && (i > disallowPartialChildPosition) // We've past the min pos
                            && (prevHeightWithoutPartialChild > 0) // We have a prev height
                            && (returnedHeight != maxHeight) // i'th child did not fit completely
                        ? prevHeightWithoutPartialChild
                        : maxHeight;
            }

            if ((disallowPartialChildPosition >= 0) && (i >= disallowPartialChildPosition)) {
                prevHeightWithoutPartialChild = returnedHeight;
            }
        }

        // At this point, we went through the range of children, and they each
        // completely fit, so return the returnedHeight
        return returnedHeight;
    }
    
    @Override
	int findMotionRow(int y) {
		// TODO Auto-generated method stub
		return 0;
	}

    /**
     * Put a specific item at a specific location on the screen and then build
     * up and down from there.
     *
     * @param position The reference view to use as the starting point
     * @param top Pixel offset from the top of this view to the top of the
     *        reference view.
     *
     * @return The selected view, or null if the selected view is outside the
     *         visible area.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.295 -0500", hash_original_method = "C0E9548D6FEBBB39DCAB5DD502EC06AD", hash_generated_method = "D39D8B79B28699344B30CF82A503E4E0")
    
private View fillSpecific(int position, int top) {
        boolean tempIsSelected = position == mSelectedPosition;
        View temp = makeAndAddView(position, top, true, mListPadding.left, tempIsSelected);
        // Possibly changed again in fillUp if we add rows above this one.
        mFirstPosition = position;

        View above;
        View below;

        final int dividerHeight = mDividerHeight;
        if (!mStackFromBottom) {
            above = fillUp(position - 1, temp.getTop() - dividerHeight);
            // This will correct for the top of the first view not touching the top of the list
            adjustViewsUpOrDown();
            below = fillDown(position + 1, temp.getBottom() + dividerHeight);
            int childCount = getChildCount();
            if (childCount > 0) {
                correctTooHigh(childCount);
            }
        } else {
            below = fillDown(position + 1, temp.getBottom() + dividerHeight);
            // This will correct for the bottom of the last view not touching the bottom of the list
            adjustViewsUpOrDown();
            above = fillUp(position - 1, temp.getTop() - dividerHeight);
            int childCount = getChildCount();
            if (childCount > 0) {
                 correctTooLow(childCount);
            }
        }

        if (tempIsSelected) {
            return temp;
        } else if (above != null) {
            return above;
        } else {
            return below;
        }
    }

    /**
     * Check if we have dragged the bottom of the list too high (we have pushed the
     * top element off the top of the screen when we did not need to). Correct by sliding
     * everything back down.
     *
     * @param childCount Number of children
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.298 -0500", hash_original_method = "C65533A90B04CD548C8B98EAAB2119A6", hash_generated_method = "AF5446B5C911B4C540F3AF6999AEC3A4")
    
private void correctTooHigh(int childCount) {
        // First see if the last item is visible. If it is not, it is OK for the
        // top of the list to be pushed up.
        int lastPosition = mFirstPosition + childCount - 1;
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
            View firstChild = getChildAt(0);
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
                    fillUp(mFirstPosition - 1, firstChild.getTop() - mDividerHeight);
                    // Close up the remaining gap
                    adjustViewsUpOrDown();
                }

            }
        }
    }

    /**
     * Check if we have dragged the bottom of the list too low (we have pushed the
     * bottom element off the bottom of the screen when we did not need to). Correct by sliding
     * everything back up.
     *
     * @param childCount Number of children
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.301 -0500", hash_original_method = "D798F76D04F235C59E38C4C924A6B5C2", hash_generated_method = "FAC0E986F681F7BE1E346F1C463ED22C")
    
private void correctTooLow(int childCount) {
        // First see if the first item is visible. If it is not, it is OK for the
        // bottom of the list to be pushed down.
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
            View lastChild = getChildAt(childCount - 1);
            final int lastBottom = lastChild.getBottom();
            int lastPosition = mFirstPosition + childCount - 1;

            // Make sure we are 1) Too low, and 2) Either there are more rows below the
            // last row or the last row is scrolled off the bottom of the drawable area
            if (topOffset > 0) {
                if (lastPosition < mItemCount - 1 || lastBottom > end)  {
                    if (lastPosition == mItemCount - 1) {
                        // Don't pull the bottom too far up
                        topOffset = Math.min(topOffset, lastBottom - end);
                    }
                    // Move everything up
                    offsetChildrenTopAndBottom(-topOffset);
                    if (lastPosition < mItemCount - 1) {
                        // Fill the gap that was opened below the last position with more rows, if
                        // possible
                        fillDown(lastPosition + 1, lastChild.getBottom() + mDividerHeight);
                        // Close up the remaining gap
                        adjustViewsUpOrDown();
                    }
                } else if (lastPosition == mItemCount - 1) {
                    adjustViewsUpOrDown();                    
                }
            }
        }
    }

    @DSComment("ListView")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.309 -0500", hash_original_method = "9877500E639FE4AE4AB75D2F74BF2E4E", hash_generated_method = "BE141D66304C05E2B31D160C3ED88E85")
    
@Override
    protected void layoutChildren() {
        final boolean blockLayoutRequests = mBlockLayoutRequests;
        if (!blockLayoutRequests) {
            mBlockLayoutRequests = true;
        } else {
            return;
        }

        try {
            super.layoutChildren();

            invalidate();

            if (mAdapter == null) {
                resetList();
                invokeOnItemScrollListener();
                return;
            }

            int childrenTop = mListPadding.top;
            int childrenBottom = mBottom - mTop - mListPadding.bottom;

            int childCount = getChildCount();
            int index = 0;
            int delta = 0;

            View sel;
            View oldSel = null;
            View oldFirst = null;
            View newSel = null;

            View focusLayoutRestoreView = null;

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
            default:
                // Remember the previously selected view
                index = mSelectedPosition - mFirstPosition;
                if (index >= 0 && index < childCount) {
                    oldSel = getChildAt(index);
                }

                // Remember the previous first child
                oldFirst = getChildAt(0);

                if (mNextSelectedPosition >= 0) {
                    delta = mNextSelectedPosition - mSelectedPosition;
                }

                // Caution: newSel might be null
                newSel = getChildAt(index + delta);
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
            } else if (mItemCount != mAdapter.getCount()) {
                throw new IllegalStateException("The content of the adapter has changed but "
                        + "ListView did not receive a notification. Make sure the content of "
                        + "your adapter is not modified from a background thread, but only "
                        + "from the UI thread. [in ListView(" + getId() + ", " + getClass() 
                        + ") with Adapter(" + mAdapter.getClass() + ")]");
            }

            setSelectedPositionInt(mNextSelectedPosition);

            // Pull all children into the RecycleBin.
            // These views will be reused if possible
            final int firstPosition = mFirstPosition;
            final RecycleBin recycleBin = mRecycler;

            // reset the focus restoration
            View focusLayoutRestoreDirectChild = null;

            // Don't put header or footer views into the Recycler. Those are
            // already cached in mHeaderViews;
            if (dataChanged) {
                for (int i = 0; i < childCount; i++) {
                    recycleBin.addScrapView(getChildAt(i), firstPosition+i);
                    if (ViewDebug.TRACE_RECYCLER) {
                        ViewDebug.trace(getChildAt(i),
                                ViewDebug.RecyclerTraceType.MOVE_TO_SCRAP_HEAP, index, i);
                    }
                }
            } else {
                recycleBin.fillActiveViews(childCount, firstPosition);
            }

            // take focus back to us temporarily to avoid the eventual
            // call to clear focus when removing the focused child below
            // from messing things up when ViewAncestor assigns focus back
            // to someone else
            final View focusedChild = getFocusedChild();
            if (focusedChild != null) {
                // TODO: in some cases focusedChild.getParent() == null

                // we can remember the focused view to restore after relayout if the
                // data hasn't changed, or if the focused position is a header or footer
                if (!dataChanged || isDirectChildHeaderOrFooter(focusedChild)) {
                    focusLayoutRestoreDirectChild = focusedChild;
                    // remember the specific view that had focus
                    focusLayoutRestoreView = findFocus();
                    if (focusLayoutRestoreView != null) {
                        // tell it we are going to mess with it
                        focusLayoutRestoreView.onStartTemporaryDetach();
                    }
                }
                requestFocus();
            }

            // Clear out old views
            detachAllViewsFromParent();

            switch (mLayoutMode) {
            case LAYOUT_SET_SELECTION:
                if (newSel != null) {
                    sel = fillFromSelection(newSel.getTop(), childrenTop, childrenBottom);
                } else {
                    sel = fillFromMiddle(childrenTop, childrenBottom);
                }
                break;
            case LAYOUT_SYNC:
                sel = fillSpecific(mSyncPosition, mSpecificTop);
                break;
            case LAYOUT_FORCE_BOTTOM:
                sel = fillUp(mItemCount - 1, childrenBottom);
                adjustViewsUpOrDown();
                break;
            case LAYOUT_FORCE_TOP:
                mFirstPosition = 0;
                sel = fillFromTop(childrenTop);
                adjustViewsUpOrDown();
                break;
            case LAYOUT_SPECIFIC:
                sel = fillSpecific(reconcileSelectedPosition(), mSpecificTop);
                break;
            case LAYOUT_MOVE_SELECTION:
                sel = moveSelection(oldSel, newSel, delta, childrenTop, childrenBottom);
                break;
            default:
                if (childCount == 0) {
                    if (!mStackFromBottom) {
                        final int position = lookForSelectablePosition(0, true);
                        setSelectedPositionInt(position);
                        sel = fillFromTop(childrenTop);
                    } else {
                        final int position = lookForSelectablePosition(mItemCount - 1, false);
                        setSelectedPositionInt(position);
                        sel = fillUp(mItemCount - 1, childrenBottom);
                    }
                } else {
                    if (mSelectedPosition >= 0 && mSelectedPosition < mItemCount) {
                        sel = fillSpecific(mSelectedPosition,
                                oldSel == null ? childrenTop : oldSel.getTop());
                    } else if (mFirstPosition < mItemCount) {
                        sel = fillSpecific(mFirstPosition,
                                oldFirst == null ? childrenTop : oldFirst.getTop());
                    } else {
                        sel = fillSpecific(0, childrenTop);
                    }
                }
                break;
            }

            // Flush any cached views that did not get reused above
            recycleBin.scrapActiveViews();

            if (sel != null) {
                // the current selected item should get focus if items
                // are focusable
                if (mItemsCanFocus && hasFocus() && !sel.hasFocus()) {
                    final boolean focusWasTaken = (sel == focusLayoutRestoreDirectChild &&
                            focusLayoutRestoreView.requestFocus()) || sel.requestFocus();
                    if (!focusWasTaken) {
                        // selected item didn't take focus, fine, but still want
                        // to make sure something else outside of the selected view
                        // has focus
                        final View focused = getFocusedChild();
                        if (focused != null) {
                            focused.clearFocus();
                        }
                        positionSelector(INVALID_POSITION, sel);
                    } else {
                        sel.setSelected(false);
                        mSelectorRect.setEmpty();
                    }
                } else {
                    positionSelector(INVALID_POSITION, sel);
                }
                mSelectedTop = sel.getTop();
            } else {
                if (mTouchMode > TOUCH_MODE_DOWN && mTouchMode < TOUCH_MODE_SCROLL) {
                    View child = getChildAt(mMotionPosition - mFirstPosition);
                    if (child != null) positionSelector(mMotionPosition, child);
                } else {
                    mSelectedTop = 0;
                    mSelectorRect.setEmpty();
                }

                // even if there is not selected position, we may need to restore
                // focus (i.e. something focusable in touch mode)
                if (hasFocus() && focusLayoutRestoreView != null) {
                    focusLayoutRestoreView.requestFocus();
                }
            }

            // tell focus view we are done mucking with it, if it is still in
            // our view hierarchy.
            if (focusLayoutRestoreView != null
                    && focusLayoutRestoreView.getWindowToken() != null) {
                focusLayoutRestoreView.onFinishTemporaryDetach();
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
     * @param child a direct child of this list.
     * @return Whether child is a header or footer view.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.311 -0500", hash_original_method = "1975AA11D0AB4A92B498BEF09326AA69", hash_generated_method = "4154DF7AA840953F47E6D4A4AC142901")
    
private boolean isDirectChildHeaderOrFooter(View child) {

        final ArrayList<FixedViewInfo> headers = mHeaderViewInfos;
        final int numHeaders = headers.size();
        for (int i = 0; i < numHeaders; i++) {
            if (child == headers.get(i).view) {
                return true;
            }
        }
        final ArrayList<FixedViewInfo> footers = mFooterViewInfos;
        final int numFooters = footers.size();
        for (int i = 0; i < numFooters; i++) {
            if (child == footers.get(i).view) {
                return true;
            }
        }
        return false;
    }

    /**
     * Obtain the view and add it to our list of children. The view can be made
     * fresh, converted from an unused view, or used as is if it was in the
     * recycle bin.
     *
     * @param position Logical position in the list
     * @param y Top or bottom edge of the view to add
     * @param flow If flow is true, align top edge to y. If false, align bottom
     *        edge to y.
     * @param childrenLeft Left edge where children should be positioned
     * @param selected Is this position selected?
     * @return View that was added
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.314 -0500", hash_original_method = "EAF848DCFCD435D3CED323F008D83518", hash_generated_method = "C0C7BDD10DF621C4F2D590F2E84C235A")
    
private View makeAndAddView(int position, int y, boolean flow, int childrenLeft,
            boolean selected) {
        View child;

        if (!mDataChanged) {
            // Try to use an existing view for this position
            child = mRecycler.getActiveView(position);
            if (child != null) {
                if (ViewDebug.TRACE_RECYCLER) {
                    ViewDebug.trace(child, ViewDebug.RecyclerTraceType.RECYCLE_FROM_ACTIVE_HEAP,
                            position, getChildCount());
                }

                // Found it -- we're using an existing child
                // This just needs to be positioned
                setupChild(child, position, y, flow, childrenLeft, selected, true);

                return child;
            }
        }

        // Make a new view for this position, or convert an unused view if possible
        child = obtainView(position, mIsScrap);

        // This needs to be positioned and measured
        setupChild(child, position, y, flow, childrenLeft, selected, mIsScrap[0]);

        return child;
    }

    /**
     * Add a view as a child and make sure it is measured (if necessary) and
     * positioned properly.
     *
     * @param child The view to add
     * @param position The position of this child
     * @param y The y position relative to which this view will be positioned
     * @param flowDown If true, align top edge to y. If false, align bottom
     *        edge to y.
     * @param childrenLeft Left edge where children should be positioned
     * @param selected Is this position selected?
     * @param recycled Has this view been pulled from the recycle bin? If so it
     *        does not need to be remeasured.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.318 -0500", hash_original_method = "06B6C56B5992091F7319E58A5C4AE35A", hash_generated_method = "53701AC971C45AE450DD1DE8DA47CA5A")
    
private void setupChild(View child, int position, int y, boolean flowDown, int childrenLeft,
            boolean selected, boolean recycled) {
        final boolean isSelected = selected && shouldShowSelector();
        final boolean updateChildSelected = isSelected != child.isSelected();
        final int mode = mTouchMode;
        final boolean isPressed = mode > TOUCH_MODE_DOWN && mode < TOUCH_MODE_SCROLL &&
                mMotionPosition == position;
        final boolean updateChildPressed = isPressed != child.isPressed();
        final boolean needToMeasure = !recycled || updateChildSelected || child.isLayoutRequested();

        // Respect layout params that are already in the view. Otherwise make some up...
        // noinspection unchecked
        AbsListView.LayoutParams p = (AbsListView.LayoutParams) child.getLayoutParams();
        if (p == null) {
            p = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, 0);
        }
        p.viewType = mAdapter.getItemViewType(position);

        if ((recycled && !p.forceAdd) || (p.recycledHeaderFooter &&
                p.viewType == AdapterView.ITEM_VIEW_TYPE_HEADER_OR_FOOTER)) {
            attachViewToParent(child, flowDown ? -1 : 0, p);
        } else {
            p.forceAdd = false;
            if (p.viewType == AdapterView.ITEM_VIEW_TYPE_HEADER_OR_FOOTER) {
                p.recycledHeaderFooter = true;
            }
            addViewInLayout(child, flowDown ? -1 : 0, p, true);
        }

        if (updateChildSelected) {
            child.setSelected(isSelected);
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
            int childWidthSpec = ViewGroup.getChildMeasureSpec(mWidthMeasureSpec,
                    mListPadding.left + mListPadding.right, p.width);
            int lpHeight = p.height;
            int childHeightSpec;
            if (lpHeight > 0) {
                childHeightSpec = MeasureSpec.makeMeasureSpec(lpHeight, MeasureSpec.EXACTLY);
            } else {
                childHeightSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
            }
            child.measure(childWidthSpec, childHeightSpec);
        } else {
            cleanupLayoutState(child);
        }

        final int w = child.getMeasuredWidth();
        final int h = child.getMeasuredHeight();
        final int childTop = flowDown ? y : y - h;

        if (needToMeasure) {
            final int childRight = childrenLeft + w;
            final int childBottom = childTop + h;
            child.layout(childrenLeft, childTop, childRight, childBottom);
        } else {
            child.offsetLeftAndRight(childrenLeft - child.getLeft());
            child.offsetTopAndBottom(childTop - child.getTop());
        }

        if (mCachingStarted && !child.isDrawingCacheEnabled()) {
            child.setDrawingCacheEnabled(true);
        }

        if (recycled && (((AbsListView.LayoutParams)child.getLayoutParams()).scrappedFromPosition)
                != position) {
            child.jumpDrawablesToCurrentState();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.321 -0500", hash_original_method = "F40AC428F4D570BD34339564A5B5BB04", hash_generated_method = "CC1AEAD8AD1B4127904290637F03EBAB")
    
@Override
    protected boolean canAnimate() {
        return super.canAnimate() && mItemCount > 0;
    }
    
    @DSComment("ListView")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @Override
	public void setSelection(int position) {
		// TODO Auto-generated method stub
	}

    /**
     * Sets the selected item and positions the selection y pixels from the top edge
     * of the ListView. (If in touch mode, the item will not be selected but it will
     * still be positioned appropriately.)
     *
     * @param position Index (starting at 0) of the data item to be selected.
     * @param y The distance from the top edge of the ListView (plus padding) that the
     *        item will be positioned.
     */
    @DSComment("ListView")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.325 -0500", hash_original_method = "04FF3361CA0379851E7CD86AE0D8A950", hash_generated_method = "C2FDCD225F78F612479AF40759D4F085")
    
public void setSelectionFromTop(int position, int y) {
        if (mAdapter == null) {
            return;
        }

        if (!isInTouchMode()) {
            position = lookForSelectablePosition(position, true);
            if (position >= 0) {
                setNextSelectedPositionInt(position);
            }
        } else {
            mResurrectToPosition = position;
        }

        if (position >= 0) {
            mLayoutMode = LAYOUT_SPECIFIC;
            mSpecificTop = mListPadding.top + y;

            if (mNeedSync) {
                mSyncPosition = position;
                mSyncRowId = mAdapter.getItemId(position);
            }

            requestLayout();
        }
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @Override
	void setSelectionInt(int position) {
		// TODO Auto-generated method stub
	}

    /**
     * Find a position that can be selected (i.e., is not a separator).
     *
     * @param position The starting position to look at.
     * @param lookDown Whether to look down for other positions.
     * @return The next selectable position starting at position and then searching either up or
     *         down. Returns {@link #INVALID_POSITION} if nothing can be found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.331 -0500", hash_original_method = "F611253C286EB5F8129DFD60BE22D44F", hash_generated_method = "919DB1A574A34EE860ADDDF078FE731B")
    
@Override
    int lookForSelectablePosition(int position, boolean lookDown) {
        final ListAdapter adapter = mAdapter;
        if (adapter == null || isInTouchMode()) {
            return INVALID_POSITION;
        }

        final int count = adapter.getCount();
        if (!mAreAllItemsSelectable) {
            if (lookDown) {
                position = Math.max(0, position);
                while (position < count && !adapter.isEnabled(position)) {
                    position++;
                }
            } else {
                position = Math.min(position, count - 1);
                while (position >= 0 && !adapter.isEnabled(position)) {
                    position--;
                }
            }

            if (position < 0 || position >= count) {
                return INVALID_POSITION;
            }
            return position;
        } else {
            if (position < 0 || position >= count) {
                return INVALID_POSITION;
            }
            return position;
        }
    }

    /**
     * setSelectionAfterHeaderView set the selection to be the first list item
     * after the header views.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.333 -0500", hash_original_method = "BA94B118F7B33B042A8A5EE913A2CAC9", hash_generated_method = "A6C61013493B6608EE1A5AAAB6C30FC5")
    
public void setSelectionAfterHeaderView() {
        final int count = mHeaderViewInfos.size();
        if (count > 0) {
            mNextSelectedPosition = 0;
            return;
        }

        if (mAdapter != null) {
            setSelection(count);
        } else {
            mNextSelectedPosition = count;
            mLayoutMode = LAYOUT_SET_SELECTION;
        }

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.336 -0500", hash_original_method = "C6695FE09C5666FBD7C0ECDD7FFCA6CE", hash_generated_method = "8A2AF5AE525D6F36E81DBF2E00B23ADD")
    
@Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        // Dispatch in the normal way
        boolean handled = super.dispatchKeyEvent(event);
        if (!handled) {
            // If we didn't handle it...
            View focused = getFocusedChild();
            if (focused != null && event.getAction() == KeyEvent.ACTION_DOWN) {
                // ... and our focused child didn't handle it
                // ... give it to ourselves so we can scroll if necessary
                handled = onKeyDown(event.getKeyCode(), event);
            }
        }
        return handled;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.338 -0500", hash_original_method = "82498D99AFEB0700B1F959E9E9927B59", hash_generated_method = "6AF9706850820C4FEB302E37B50B2BED")
    
@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return commonKey(keyCode, 1, event);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.341 -0500", hash_original_method = "C105EC1B6481173F2A66D1C47882507B", hash_generated_method = "263108ED482A3329DC5C40738EBD240E")
    
@Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        return commonKey(keyCode, repeatCount, event);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.343 -0500", hash_original_method = "FFB4A1626C41573790F9B17FF23F8A09", hash_generated_method = "A27D10E92D871F3F89D05FD06501971F")
    
@Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return commonKey(keyCode, 1, event);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.348 -0500", hash_original_method = "1DD47D400FE7B21B7ADCD2D234FB64A7", hash_generated_method = "6C43D83C6F4D105A7792B80D392A7B0F")
    
private boolean commonKey(int keyCode, int count, KeyEvent event) {
        if (mAdapter == null || !mIsAttached) {
            return false;
        }

        if (mDataChanged) {
            layoutChildren();
        }

        boolean handled = false;
        int action = event.getAction();

        if (action != KeyEvent.ACTION_UP) {
            switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_UP:
                if (event.hasNoModifiers()) {
                    handled = resurrectSelectionIfNeeded();
                    if (!handled) {
                        while (count-- > 0) {
                            if (arrowScroll(FOCUS_UP)) {
                                handled = true;
                            } else {
                                break;
                            }
                        }
                    }
                } else if (event.hasModifiers(KeyEvent.META_ALT_ON)) {
                    handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_UP);
                }
                break;

            case KeyEvent.KEYCODE_DPAD_DOWN:
                if (event.hasNoModifiers()) {
                    handled = resurrectSelectionIfNeeded();
                    if (!handled) {
                        while (count-- > 0) {
                            if (arrowScroll(FOCUS_DOWN)) {
                                handled = true;
                            } else {
                                break;
                            }
                        }
                    }
                } else if (event.hasModifiers(KeyEvent.META_ALT_ON)) {
                    handled = resurrectSelectionIfNeeded() || fullScroll(FOCUS_DOWN);
                }
                break;

            case KeyEvent.KEYCODE_DPAD_LEFT:
                if (event.hasNoModifiers()) {
                    handled = handleHorizontalFocusWithinListItem(View.FOCUS_LEFT);
                }
                break;

            case KeyEvent.KEYCODE_DPAD_RIGHT:
                if (event.hasNoModifiers()) {
                    handled = handleHorizontalFocusWithinListItem(View.FOCUS_RIGHT);
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
                    handled = true;
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
                //     a ListView sequentially.  Unfortunately this can create an
                //     asymmetry in TAB navigation order unless the list selection
                //     always reverts to the top or bottom when receiving TAB focus from
                //     another widget.  Leaving this behavior disabled for now but
                //     perhaps it should be configurable (and more comprehensive).
                if (false) {
                    if (event.hasNoModifiers()) {
                        handled = resurrectSelectionIfNeeded() || arrowScroll(FOCUS_DOWN);
                    } else if (event.hasModifiers(KeyEvent.META_SHIFT_ON)) {
                        handled = resurrectSelectionIfNeeded() || arrowScroll(FOCUS_UP);
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

            default: // shouldn't happen
                return false;
        }
    }

    /**
     * Scrolls up or down by the number of items currently present on screen.
     *
     * @param direction either {@link View#FOCUS_UP} or {@link View#FOCUS_DOWN}
     * @return whether selection was moved
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.350 -0500", hash_original_method = "CFFD02C88D512DC860E9CC0FE1096C45", hash_generated_method = "CFFD02C88D512DC860E9CC0FE1096C45")
    
boolean pageScroll(int direction) {
        int nextPage = -1;
        boolean down = false;

        if (direction == FOCUS_UP) {
            nextPage = Math.max(0, mSelectedPosition - getChildCount() - 1);
        } else if (direction == FOCUS_DOWN) {
            nextPage = Math.min(mItemCount - 1, mSelectedPosition + getChildCount() - 1);
            down = true;
        }

        if (nextPage >= 0) {
            int position = lookForSelectablePosition(nextPage, down);
            if (position >= 0) {
                mLayoutMode = LAYOUT_SPECIFIC;
                mSpecificTop = mPaddingTop + getVerticalFadingEdgeLength();

                if (down && position > mItemCount - getChildCount()) {
                    mLayoutMode = LAYOUT_FORCE_BOTTOM;
                }

                if (!down && position < getChildCount()) {
                    mLayoutMode = LAYOUT_FORCE_TOP;
                }

                setSelectionInt(position);
                invokeOnItemScrollListener();
                if (!awakenScrollBars()) {
                    invalidate();
                }

                return true;
            }
        }

        return false;
    }

    /**
     * Go to the last or first item if possible (not worrying about panning across or navigating
     * within the internal focus of the currently selected item.)
     *
     * @param direction either {@link View#FOCUS_UP} or {@link View#FOCUS_DOWN}
     *
     * @return whether selection was moved
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.353 -0500", hash_original_method = "8893A9BFD4970E039D8D32407D02C15E", hash_generated_method = "8893A9BFD4970E039D8D32407D02C15E")
    
boolean fullScroll(int direction) {
        boolean moved = false;
        if (direction == FOCUS_UP) {
            if (mSelectedPosition != 0) {
                int position = lookForSelectablePosition(0, true);
                if (position >= 0) {
                    mLayoutMode = LAYOUT_FORCE_TOP;
                    setSelectionInt(position);
                    invokeOnItemScrollListener();
                }
                moved = true;
            }
        } else if (direction == FOCUS_DOWN) {
            if (mSelectedPosition < mItemCount - 1) {
                int position = lookForSelectablePosition(mItemCount - 1, true);
                if (position >= 0) {
                    mLayoutMode = LAYOUT_FORCE_BOTTOM;
                    setSelectionInt(position);
                    invokeOnItemScrollListener();
                }
                moved = true;
            }
        }

        if (moved && !awakenScrollBars()) {
            awakenScrollBars();
            invalidate();
        }

        return moved;
    }

    /**
     * To avoid horizontal focus searches changing the selected item, we
     * manually focus search within the selected item (as applicable), and
     * prevent focus from jumping to something within another item.
     * @param direction one of {View.FOCUS_LEFT, View.FOCUS_RIGHT}
     * @return Whether this consumes the key event.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.356 -0500", hash_original_method = "27083050B4DD915BDC5D45A692A1DFB7", hash_generated_method = "5D8D5205C46F5979CA7E985C63984DA0")
    
private boolean handleHorizontalFocusWithinListItem(int direction) {
        if (direction != View.FOCUS_LEFT && direction != View.FOCUS_RIGHT)  {
            throw new IllegalArgumentException("direction must be one of"
                    + " {View.FOCUS_LEFT, View.FOCUS_RIGHT}");
        }

        final int numChildren = getChildCount();
        if (mItemsCanFocus && numChildren > 0 && mSelectedPosition != INVALID_POSITION) {
            final View selectedView = getSelectedView();
            if (selectedView != null && selectedView.hasFocus() &&
                    selectedView instanceof ViewGroup) {

                final View currentFocus = selectedView.findFocus();
                final View nextFocus = FocusFinder.getInstance().findNextFocus(
                        (ViewGroup) selectedView, currentFocus, direction);
                if (nextFocus != null) {
                    // do the math to get interesting rect in next focus' coordinates
                    currentFocus.getFocusedRect(mTempRect);
                    offsetDescendantRectToMyCoords(currentFocus, mTempRect);
                    offsetRectIntoDescendantCoords(nextFocus, mTempRect);
                    if (nextFocus.requestFocus(direction, mTempRect)) {
                        return true;
                    }
                }
                // we are blocking the key from being handled (by returning true)
                // if the global result is going to be some other view within this
                // list.  this is to acheive the overall goal of having
                // horizontal d-pad navigation remain in the current item.
                final View globalNextFocus = FocusFinder.getInstance().findNextFocus(
                        (ViewGroup) getRootView(), currentFocus, direction);
                if (globalNextFocus != null) {
                    return isViewAncestorOf(globalNextFocus, this);
                }
            }
        }
        return false;
    }

    /**
     * Scrolls to the next or previous item if possible.
     *
     * @param direction either {@link View#FOCUS_UP} or {@link View#FOCUS_DOWN}
     *
     * @return whether selection was moved
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.359 -0500", hash_original_method = "6B5D7DFA7F5B692B993CC3912D59B646", hash_generated_method = "6B5D7DFA7F5B692B993CC3912D59B646")
    
boolean arrowScroll(int direction) {
        try {
            mInLayout = true;
            final boolean handled = arrowScrollImpl(direction);
            if (handled) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(direction));
            }
            return handled;
        } finally {
            mInLayout = false;
        }
    }

    /**
     * Handle an arrow scroll going up or down.  Take into account whether items are selectable,
     * whether there are focusable items etc.
     *
     * @param direction Either {@link android.view.View#FOCUS_UP} or {@link android.view.View#FOCUS_DOWN}.
     * @return Whether any scrolling, selection or focus change occured.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.363 -0500", hash_original_method = "5F8F1549FF6A2936584D81A340335636", hash_generated_method = "5BA1C973DC010B01221EFF58C702D710")
    
private boolean arrowScrollImpl(int direction) {
        if (getChildCount() <= 0) {
            return false;
        }

        View selectedView = getSelectedView();
        int selectedPos = mSelectedPosition;

        int nextSelectedPosition = lookForSelectablePositionOnScreen(direction);
        int amountToScroll = amountToScroll(direction, nextSelectedPosition);

        // if we are moving focus, we may OVERRIDE the default behavior
        final ArrowScrollFocusResult focusResult = mItemsCanFocus ? arrowScrollFocused(direction) : null;
        if (focusResult != null) {
            nextSelectedPosition = focusResult.getSelectedPosition();
            amountToScroll = focusResult.getAmountToScroll();
        }

        boolean needToRedraw = focusResult != null;
        if (nextSelectedPosition != INVALID_POSITION) {
            handleNewSelectionChange(selectedView, direction, nextSelectedPosition, focusResult != null);
            setSelectedPositionInt(nextSelectedPosition);
            setNextSelectedPositionInt(nextSelectedPosition);
            selectedView = getSelectedView();
            selectedPos = nextSelectedPosition;
            if (mItemsCanFocus && focusResult == null) {
                // there was no new view found to take focus, make sure we
                // don't leave focus with the old selection
                final View focused = getFocusedChild();
                if (focused != null) {
                    focused.clearFocus();
                }
            }
            needToRedraw = true;
            checkSelectionChanged();
        }

        if (amountToScroll > 0) {
            scrollListItemsBy((direction == View.FOCUS_UP) ? amountToScroll : -amountToScroll);
            needToRedraw = true;
        }

        // if we didn't find a new focusable, make sure any existing focused
        // item that was panned off screen gives up focus.
        if (mItemsCanFocus && (focusResult == null)
                && selectedView != null && selectedView.hasFocus()) {
            final View focused = selectedView.findFocus();
            if (!isViewAncestorOf(focused, this) || distanceToView(focused) > 0) {
                focused.clearFocus();
            }
        }

        // if  the current selection is panned off, we need to remove the selection
        if (nextSelectedPosition == INVALID_POSITION && selectedView != null
                && !isViewAncestorOf(selectedView, this)) {
            selectedView = null;
            hideSelector();

            // but we don't want to set the ressurect position (that would make subsequent
            // unhandled key events bring back the item we just scrolled off!)
            mResurrectToPosition = INVALID_POSITION;
        }

        if (needToRedraw) {
            if (selectedView != null) {
                positionSelector(selectedPos, selectedView);
                mSelectedTop = selectedView.getTop();
            }
            if (!awakenScrollBars()) {
                invalidate();
            }
            invokeOnItemScrollListener();
            return true;
        }

        return false;
    }

    /**
     * When selection changes, it is possible that the previously selected or the
     * next selected item will change its size.  If so, we need to offset some folks,
     * and re-layout the items as appropriate.
     *
     * @param selectedView The currently selected view (before changing selection).
     *   should be <code>null</code> if there was no previous selection.
     * @param direction Either {@link android.view.View#FOCUS_UP} or
     *        {@link android.view.View#FOCUS_DOWN}.
     * @param newSelectedPosition The position of the next selection.
     * @param newFocusAssigned whether new focus was assigned.  This matters because
     *        when something has focus, we don't want to show selection (ugh).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.366 -0500", hash_original_method = "5F7DFDAF299194D301FC447E78E3FD87", hash_generated_method = "C4CEAE19CEAE99E4E4C2197B865D333A")
    
private void handleNewSelectionChange(View selectedView, int direction, int newSelectedPosition,
            boolean newFocusAssigned) {
        if (newSelectedPosition == INVALID_POSITION) {
            throw new IllegalArgumentException("newSelectedPosition needs to be valid");
        }

        // whether or not we are moving down or up, we want to preserve the
        // top of whatever view is on top:
        // - moving down: the view that had selection
        // - moving up: the view that is getting selection
        View topView;
        View bottomView;
        int topViewIndex, bottomViewIndex;
        boolean topSelected = false;
        final int selectedIndex = mSelectedPosition - mFirstPosition;
        final int nextSelectedIndex = newSelectedPosition - mFirstPosition;
        if (direction == View.FOCUS_UP) {
            topViewIndex = nextSelectedIndex;
            bottomViewIndex = selectedIndex;
            topView = getChildAt(topViewIndex);
            bottomView = selectedView;
            topSelected = true;
        } else {
            topViewIndex = selectedIndex;
            bottomViewIndex = nextSelectedIndex;
            topView = selectedView;
            bottomView = getChildAt(bottomViewIndex);
        }

        final int numChildren = getChildCount();

        // start with top view: is it changing size?
        if (topView != null) {
            topView.setSelected(!newFocusAssigned && topSelected);
            measureAndAdjustDown(topView, topViewIndex, numChildren);
        }

        // is the bottom view changing size?
        if (bottomView != null) {
            bottomView.setSelected(!newFocusAssigned && !topSelected);
            measureAndAdjustDown(bottomView, bottomViewIndex, numChildren);
        }
    }

    /**
     * Re-measure a child, and if its height changes, lay it out preserving its
     * top, and adjust the children below it appropriately.
     * @param child The child
     * @param childIndex The view group index of the child.
     * @param numChildren The number of children in the view group.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.368 -0500", hash_original_method = "D9B7EDD91437C9CF7E31BD236F25B8F3", hash_generated_method = "069FA18CB3D91513A755E62D6A4898A5")
    
private void measureAndAdjustDown(View child, int childIndex, int numChildren) {
        int oldHeight = child.getHeight();
        measureItem(child);
        if (child.getMeasuredHeight() != oldHeight) {
            // lay out the view, preserving its top
            relayoutMeasuredItem(child);

            // adjust views below appropriately
            final int heightDelta = child.getMeasuredHeight() - oldHeight;
            for (int i = childIndex + 1; i < numChildren; i++) {
                getChildAt(i).offsetTopAndBottom(heightDelta);
            }
        }
    }

    /**
     * Measure a particular list child.
     * TODO: unify with setUpChild.
     * @param child The child.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.371 -0500", hash_original_method = "195C1D433E8B0F15028E4D73EB2D6DE2", hash_generated_method = "67E474B376AEA4F08E527A862E401D81")
    
private void measureItem(View child) {
        ViewGroup.LayoutParams p = child.getLayoutParams();
        if (p == null) {
            p = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
        }

        int childWidthSpec = ViewGroup.getChildMeasureSpec(mWidthMeasureSpec,
                mListPadding.left + mListPadding.right, p.width);
        int lpHeight = p.height;
        int childHeightSpec;
        if (lpHeight > 0) {
            childHeightSpec = MeasureSpec.makeMeasureSpec(lpHeight, MeasureSpec.EXACTLY);
        } else {
            childHeightSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        }
        child.measure(childWidthSpec, childHeightSpec);
    }

    /**
     * Layout a child that has been measured, preserving its top position.
     * TODO: unify with setUpChild.
     * @param child The child.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.373 -0500", hash_original_method = "69D49227DB6AC5D384C2E3A710CB930F", hash_generated_method = "0C9E256E310058EA1873381CA2B00688")
    
private void relayoutMeasuredItem(View child) {
        final int w = child.getMeasuredWidth();
        final int h = child.getMeasuredHeight();
        final int childLeft = mListPadding.left;
        final int childRight = childLeft + w;
        final int childTop = child.getTop();
        final int childBottom = childTop + h;
        child.layout(childLeft, childTop, childRight, childBottom);
    }

    /**
     * @return The amount to preview next items when arrow srolling.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.375 -0500", hash_original_method = "42F2E28C8994E7757E02659DFEBDEFA8", hash_generated_method = "83F0B808071233543CDA0F5E201BA2CB")
    
private int getArrowScrollPreviewLength() {
        return Math.max(MIN_SCROLL_PREVIEW_PIXELS, getVerticalFadingEdgeLength());
    }

    /**
     * Determine how much we need to scroll in order to get the next selected view
     * visible, with a fading edge showing below as applicable.  The amount is
     * capped at {@link #getMaxScrollAmount()} .
     *
     * @param direction either {@link android.view.View#FOCUS_UP} or
     *        {@link android.view.View#FOCUS_DOWN}.
     * @param nextSelectedPosition The position of the next selection, or
     *        {@link #INVALID_POSITION} if there is no next selectable position
     * @return The amount to scroll. Note: this is always positive!  Direction
     *         needs to be taken into account when actually scrolling.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.379 -0500", hash_original_method = "0CBCA538A833739B1FF13F8466C4BF4D", hash_generated_method = "5DCA661D907C6C4653DD5BBC355142A1")
    
private int amountToScroll(int direction, int nextSelectedPosition) {
        final int listBottom = getHeight() - mListPadding.bottom;
        final int listTop = mListPadding.top;

        final int numChildren = getChildCount();

        if (direction == View.FOCUS_DOWN) {
            int indexToMakeVisible = numChildren - 1;
            if (nextSelectedPosition != INVALID_POSITION) {
                indexToMakeVisible = nextSelectedPosition - mFirstPosition;
            }

            final int positionToMakeVisible = mFirstPosition + indexToMakeVisible;
            final View viewToMakeVisible = getChildAt(indexToMakeVisible);

            int goalBottom = listBottom;
            if (positionToMakeVisible < mItemCount - 1) {
                goalBottom -= getArrowScrollPreviewLength();
            }

            if (viewToMakeVisible.getBottom() <= goalBottom) {
                // item is fully visible.
                return 0;
            }

            if (nextSelectedPosition != INVALID_POSITION
                    && (goalBottom - viewToMakeVisible.getTop()) >= getMaxScrollAmount()) {
                // item already has enough of it visible, changing selection is good enough
                return 0;
            }

            int amountToScroll = (viewToMakeVisible.getBottom() - goalBottom);

            if ((mFirstPosition + numChildren) == mItemCount) {
                // last is last in list -> make sure we don't scroll past it
                final int max = getChildAt(numChildren - 1).getBottom() - listBottom;
                amountToScroll = Math.min(amountToScroll, max);
            }

            return Math.min(amountToScroll, getMaxScrollAmount());
        } else {
            int indexToMakeVisible = 0;
            if (nextSelectedPosition != INVALID_POSITION) {
                indexToMakeVisible = nextSelectedPosition - mFirstPosition;
            }
            final int positionToMakeVisible = mFirstPosition + indexToMakeVisible;
            final View viewToMakeVisible = getChildAt(indexToMakeVisible);
            int goalTop = listTop;
            if (positionToMakeVisible > 0) {
                goalTop += getArrowScrollPreviewLength();
            }
            if (viewToMakeVisible.getTop() >= goalTop) {
                // item is fully visible.
                return 0;
            }

            if (nextSelectedPosition != INVALID_POSITION &&
                    (viewToMakeVisible.getBottom() - goalTop) >= getMaxScrollAmount()) {
                // item already has enough of it visible, changing selection is good enough
                return 0;
            }

            int amountToScroll = (goalTop - viewToMakeVisible.getTop());
            if (mFirstPosition == 0) {
                // first is first in list -> make sure we don't scroll past it
                final int max = listTop - getChildAt(0).getTop();
                amountToScroll = Math.min(amountToScroll,  max);
            }
            return Math.min(amountToScroll, getMaxScrollAmount());
        }
    }

    /**
     * @param direction either {@link android.view.View#FOCUS_UP} or
     *        {@link android.view.View#FOCUS_DOWN}.
     * @return The position of the next selectable position of the views that
     *         are currently visible, taking into account the fact that there might
     *         be no selection.  Returns {@link #INVALID_POSITION} if there is no
     *         selectable view on screen in the given direction.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.396 -0500", hash_original_method = "760C70065AEFE7BC7EE2B10D159765ED", hash_generated_method = "C39A5F93696D99D4932B489F820CEB1F")
    
private int lookForSelectablePositionOnScreen(int direction) {
        final int firstPosition = mFirstPosition;
        if (direction == View.FOCUS_DOWN) {
            int startPos = (mSelectedPosition != INVALID_POSITION) ?
                    mSelectedPosition + 1 :
                    firstPosition;
            if (startPos >= mAdapter.getCount()) {
                return INVALID_POSITION;
            }
            if (startPos < firstPosition) {
                startPos = firstPosition;
            }
            
            final int lastVisiblePos = getLastVisiblePosition();
            final ListAdapter adapter = getAdapter();
            for (int pos = startPos; pos <= lastVisiblePos; pos++) {
                if (adapter.isEnabled(pos)
                        && getChildAt(pos - firstPosition).getVisibility() == View.VISIBLE) {
                    return pos;
                }
            }
        } else {
            int last = firstPosition + getChildCount() - 1;
            int startPos = (mSelectedPosition != INVALID_POSITION) ?
                    mSelectedPosition - 1 :
                    firstPosition + getChildCount() - 1;
            if (startPos < 0 || startPos >= mAdapter.getCount()) {
                return INVALID_POSITION;
            }
            if (startPos > last) {
                startPos = last;
            }

            final ListAdapter adapter = getAdapter();
            for (int pos = startPos; pos >= firstPosition; pos--) {
                if (adapter.isEnabled(pos)
                        && getChildAt(pos - firstPosition).getVisibility() == View.VISIBLE) {
                    return pos;
                }
            }
        }
        return INVALID_POSITION;
    }

    /**
     * Do an arrow scroll based on focus searching.  If a new view is
     * given focus, return the selection delta and amount to scroll via
     * an {@link ArrowScrollFocusResult}, otherwise, return null.
     *
     * @param direction either {@link android.view.View#FOCUS_UP} or
     *        {@link android.view.View#FOCUS_DOWN}.
     * @return The result if focus has changed, or <code>null</code>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.400 -0500", hash_original_method = "2622F1B1638C7BCDD9C32B9CBE54AF85", hash_generated_method = "B971B37F2EA45BC5C395723BBB1E5B39")
    
private ArrowScrollFocusResult arrowScrollFocused(final int direction) {
        final View selectedView = getSelectedView();
        View newFocus;
        if (selectedView != null && selectedView.hasFocus()) {
            View oldFocus = selectedView.findFocus();
            newFocus = FocusFinder.getInstance().findNextFocus(this, oldFocus, direction);
        } else {
            if (direction == View.FOCUS_DOWN) {
                final boolean topFadingEdgeShowing = (mFirstPosition > 0);
                final int listTop = mListPadding.top +
                        (topFadingEdgeShowing ? getArrowScrollPreviewLength() : 0);
                final int ySearchPoint =
                        (selectedView != null && selectedView.getTop() > listTop) ?
                                selectedView.getTop() :
                                listTop;
                mTempRect.set(0, ySearchPoint, 0, ySearchPoint);
            } else {
                final boolean bottomFadingEdgeShowing =
                        (mFirstPosition + getChildCount() - 1) < mItemCount;
                final int listBottom = getHeight() - mListPadding.bottom -
                        (bottomFadingEdgeShowing ? getArrowScrollPreviewLength() : 0);
                final int ySearchPoint =
                        (selectedView != null && selectedView.getBottom() < listBottom) ?
                                selectedView.getBottom() :
                                listBottom;
                mTempRect.set(0, ySearchPoint, 0, ySearchPoint);
            }
            newFocus = FocusFinder.getInstance().findNextFocusFromRect(this, mTempRect, direction);
        }

        if (newFocus != null) {
            final int positionOfNewFocus = positionOfNewFocus(newFocus);

            // if the focus change is in a different new position, make sure
            // we aren't jumping over another selectable position
            if (mSelectedPosition != INVALID_POSITION && positionOfNewFocus != mSelectedPosition) {
                final int selectablePosition = lookForSelectablePositionOnScreen(direction);
                if (selectablePosition != INVALID_POSITION &&
                        ((direction == View.FOCUS_DOWN && selectablePosition < positionOfNewFocus) ||
                        (direction == View.FOCUS_UP && selectablePosition > positionOfNewFocus))) {
                    return null;
                }
            }

            int focusScroll = amountToScrollToNewFocus(direction, newFocus, positionOfNewFocus);

            final int maxScrollAmount = getMaxScrollAmount();
            if (focusScroll < maxScrollAmount) {
                // not moving too far, safe to give next view focus
                newFocus.requestFocus(direction);
                mArrowScrollFocusResult.populate(positionOfNewFocus, focusScroll);
                return mArrowScrollFocusResult;
            } else if (distanceToView(newFocus) < maxScrollAmount){
                // Case to consider:
                // too far to get entire next focusable on screen, but by going
                // max scroll amount, we are getting it at least partially in view,
                // so give it focus and scroll the max ammount.
                newFocus.requestFocus(direction);
                mArrowScrollFocusResult.populate(positionOfNewFocus, maxScrollAmount);
                return mArrowScrollFocusResult;
            }
        }
        return null;
    }

    /**
     * @param newFocus The view that would have focus.
     * @return the position that contains newFocus
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.403 -0500", hash_original_method = "E7A74EC59726801D8AE9EB276549022E", hash_generated_method = "13F164A885A765E3B0B42BED2EA3C4C8")
    
private int positionOfNewFocus(View newFocus) {
        final int numChildren = getChildCount();
        for (int i = 0; i < numChildren; i++) {
            final View child = getChildAt(i);
            if (isViewAncestorOf(newFocus, child)) {
                return mFirstPosition + i;
            }
        }
        throw new IllegalArgumentException("newFocus is not a child of any of the"
                + " children of the list!");
    }

    /**
     * Return true if child is an ancestor of parent, (or equal to the parent).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.405 -0500", hash_original_method = "3B08BDE00067F884387760F12D698F42", hash_generated_method = "90A061C63C0EE738AA3B18172571066F")
    
private boolean isViewAncestorOf(View child, View parent) {
        if (child == parent) {
            return true;
        }

        final ViewParent theParent = child.getParent();
        return (theParent instanceof ViewGroup) && isViewAncestorOf((View) theParent, parent);
    }

    /**
     * Determine how much we need to scroll in order to get newFocus in view.
     * @param direction either {@link android.view.View#FOCUS_UP} or
     *        {@link android.view.View#FOCUS_DOWN}.
     * @param newFocus The view that would take focus.
     * @param positionOfNewFocus The position of the list item containing newFocus
     * @return The amount to scroll.  Note: this is always positive!  Direction
     *   needs to be taken into account when actually scrolling.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.407 -0500", hash_original_method = "972857949DC34A723A630B605759B3EF", hash_generated_method = "6043D574A03A320A084B8AA74F10E249")
    
private int amountToScrollToNewFocus(int direction, View newFocus, int positionOfNewFocus) {
        int amountToScroll = 0;
        newFocus.getDrawingRect(mTempRect);
        offsetDescendantRectToMyCoords(newFocus, mTempRect);
        if (direction == View.FOCUS_UP) {
            if (mTempRect.top < mListPadding.top) {
                amountToScroll = mListPadding.top - mTempRect.top;
                if (positionOfNewFocus > 0) {
                    amountToScroll += getArrowScrollPreviewLength();
                }
            }
        } else {
            final int listBottom = getHeight() - mListPadding.bottom;
            if (mTempRect.bottom > listBottom) {
                amountToScroll = mTempRect.bottom - listBottom;
                if (positionOfNewFocus < mItemCount - 1) {
                    amountToScroll += getArrowScrollPreviewLength();
                }
            }
        }
        return amountToScroll;
    }

    /**
     * Determine the distance to the nearest edge of a view in a particular
     * direction.
     * 
     * @param descendant A descendant of this list.
     * @return The distance, or 0 if the nearest edge is already on screen.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.410 -0500", hash_original_method = "2468FB71A40A0019FA8D57CEA81AC8A6", hash_generated_method = "B71728294A7ADAA6224D584B4DB6A1F8")
    
private int distanceToView(View descendant) {
        int distance = 0;
        descendant.getDrawingRect(mTempRect);
        offsetDescendantRectToMyCoords(descendant, mTempRect);
        final int listBottom = mBottom - mTop - mListPadding.bottom;
        if (mTempRect.bottom < mListPadding.top) {
            distance = mListPadding.top - mTempRect.bottom;
        } else if (mTempRect.top > listBottom) {
            distance = mTempRect.top - listBottom;
        }
        return distance;
    }

    /**
     * Scroll the children by amount, adding a view at the end and removing
     * views that fall off as necessary.
     *
     * @param amount The amount (positive or negative) to scroll.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.414 -0500", hash_original_method = "FAA0316A71F66D005638E2A277415AFB", hash_generated_method = "580877947D20840DFCDE16EC41EA7F37")
    
private void scrollListItemsBy(int amount) {
        offsetChildrenTopAndBottom(amount);

        final int listBottom = getHeight() - mListPadding.bottom;
        final int listTop = mListPadding.top;
        final AbsListView.RecycleBin recycleBin = mRecycler;

        if (amount < 0) {
            // shifted items up

            // may need to pan views into the bottom space
            int numChildren = getChildCount();
            View last = getChildAt(numChildren - 1);
            while (last.getBottom() < listBottom) {
                final int lastVisiblePosition = mFirstPosition + numChildren - 1;
                if (lastVisiblePosition < mItemCount - 1) {
                    last = addViewBelow(last, lastVisiblePosition);
                    numChildren++;
                } else {
                    break;
                }
            }

            // may have brought in the last child of the list that is skinnier
            // than the fading edge, thereby leaving space at the end.  need
            // to shift back
            if (last.getBottom() < listBottom) {
                offsetChildrenTopAndBottom(listBottom - last.getBottom());
            }

            // top views may be panned off screen
            View first = getChildAt(0);
            while (first.getBottom() < listTop) {
                AbsListView.LayoutParams layoutParams = (LayoutParams) first.getLayoutParams();
                if (recycleBin.shouldRecycleViewType(layoutParams.viewType)) {
                    detachViewFromParent(first);
                    recycleBin.addScrapView(first, mFirstPosition);
                } else {
                    removeViewInLayout(first);
                }
                first = getChildAt(0);
                mFirstPosition++;
            }
        } else {
            // shifted items down
            View first = getChildAt(0);

            // may need to pan views into top
            while ((first.getTop() > listTop) && (mFirstPosition > 0)) {
                first = addViewAbove(first, mFirstPosition);
                mFirstPosition--;
            }

            // may have brought the very first child of the list in too far and
            // need to shift it back
            if (first.getTop() > listTop) {
                offsetChildrenTopAndBottom(listTop - first.getTop());
            }

            int lastIndex = getChildCount() - 1;
            View last = getChildAt(lastIndex);

            // bottom view may be panned off screen
            while (last.getTop() > listBottom) {
                AbsListView.LayoutParams layoutParams = (LayoutParams) last.getLayoutParams();
                if (recycleBin.shouldRecycleViewType(layoutParams.viewType)) {
                    detachViewFromParent(last);
                    recycleBin.addScrapView(last, mFirstPosition+lastIndex);
                } else {
                    removeViewInLayout(last);
                }
                last = getChildAt(--lastIndex);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.416 -0500", hash_original_method = "9F36487536DE2965CEF1C4C9236F1DF4", hash_generated_method = "77870030F0AC6C58CAE58B279073313D")
    
private View addViewAbove(View theView, int position) {
        int abovePosition = position - 1;
        View view = obtainView(abovePosition, mIsScrap);
        int edgeOfNewChild = theView.getTop() - mDividerHeight;
        setupChild(view, abovePosition, edgeOfNewChild, false, mListPadding.left,
                false, mIsScrap[0]);
        return view;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.418 -0500", hash_original_method = "D4F2FE3018B44C78CF4E93EBC6FE5FC7", hash_generated_method = "75D6A1D4B7D45753306AAD89B83B724C")
    
private View addViewBelow(View theView, int position) {
        int belowPosition = position + 1;
        View view = obtainView(belowPosition, mIsScrap);
        int edgeOfNewChild = theView.getBottom() + mDividerHeight;
        setupChild(view, belowPosition, edgeOfNewChild, true, mListPadding.left,
                false, mIsScrap[0]);
        return view;
    }

    /**
     * Indicates that the views created by the ListAdapter can contain focusable
     * items.
     *
     * @param itemsCanFocus true if items can get focus, false otherwise
     */
    @DSComment("ListView")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.420 -0500", hash_original_method = "B028681B6F4AF7B56D2E022B96A1F853", hash_generated_method = "4E30DA1E9D79AFFADBD6C2DC03EEA463")
    
public void setItemsCanFocus(boolean itemsCanFocus) {
        mItemsCanFocus = itemsCanFocus;
        if (!itemsCanFocus) {
            setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
        }
    }

    /**
     * @return Whether the views created by the ListAdapter can contain focusable
     * items.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.422 -0500", hash_original_method = "1C95AE1007B5CDC38C9B3E3B2904F365", hash_generated_method = "F38108EEEA06E4A569997C4C6488F567")
    
public boolean getItemsCanFocus() {
        return mItemsCanFocus;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.426 -0500", hash_original_method = "719E5FD40BAA2B7205DD0269FBFE398A", hash_generated_method = "B7208F28CAE315BE373E921B1B938031")
    
@Override
    public boolean isOpaque() {
        boolean retValue = (mCachingActive && mIsCacheColorOpaque && mDividerIsOpaque &&
                hasOpaqueScrollbars()) || super.isOpaque();
        if (retValue) {
            // only return true if the list items cover the entire area of the view
            final int listTop = mListPadding != null ? mListPadding.top : mPaddingTop;
            View first = getChildAt(0);
            if (first == null || first.getTop() > listTop) {
                return false;
            }
            final int listBottom = getHeight() -
                    (mListPadding != null ? mListPadding.bottom : mPaddingBottom);
            View last = getChildAt(getChildCount() - 1);
            if (last == null || last.getBottom() < listBottom) {
                return false;
            }
        }
        return retValue;
    }

    @DSComment("ListView")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.428 -0500", hash_original_method = "465D449366429949FD8ADA654918A0E2", hash_generated_method = "342E58F6677C3BA7760B7791A690FB25")
    
@Override
    public void setCacheColorHint(int color) {
        final boolean opaque = (color >>> 24) == 0xFF;
        mIsCacheColorOpaque = opaque;
        if (opaque) {
            if (mDividerPaint == null) {
                mDividerPaint = new Paint();
            }
            mDividerPaint.setColor(color);
        }
        super.setCacheColorHint(color);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.430 -0500", hash_original_method = "9A5C934D25A361940ECD1D897C78B567", hash_generated_method = "9A5C934D25A361940ECD1D897C78B567")
    
void drawOverscrollHeader(Canvas canvas, Drawable drawable, Rect bounds) {
        final int height = drawable.getMinimumHeight();

        canvas.save();
        canvas.clipRect(bounds);

        final int span = bounds.bottom - bounds.top;
        if (span < height) {
            bounds.top = bounds.bottom - height;
        }

        drawable.setBounds(bounds);
        drawable.draw(canvas);

        canvas.restore();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.433 -0500", hash_original_method = "3C862E16BE3AA71DC427E03E79AFA46F", hash_generated_method = "3C862E16BE3AA71DC427E03E79AFA46F")
    
void drawOverscrollFooter(Canvas canvas, Drawable drawable, Rect bounds) {
        final int height = drawable.getMinimumHeight();

        canvas.save();
        canvas.clipRect(bounds);

        final int span = bounds.bottom - bounds.top;
        if (span < height) {
            bounds.bottom = bounds.top + height;
        }

        drawable.setBounds(bounds);
        drawable.draw(canvas);

        canvas.restore();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.438 -0500", hash_original_method = "2FA3D064F2DBB643D61459E2FE6AA64C", hash_generated_method = "A7FE68D1CA9D5475F3979ED980705797")
    
@Override
    protected void dispatchDraw(Canvas canvas) {
        if (mCachingStarted) {
            mCachingActive = true;
        }

        // Draw the dividers
        final int dividerHeight = mDividerHeight;
        final Drawable overscrollHeader = mOverScrollHeader;
        final Drawable overscrollFooter = mOverScrollFooter;
        final boolean drawOverscrollHeader = overscrollHeader != null;
        final boolean drawOverscrollFooter = overscrollFooter != null;
        final boolean drawDividers = dividerHeight > 0 && mDivider != null;

        if (drawDividers || drawOverscrollHeader || drawOverscrollFooter) {
            // Only modify the top and bottom in the loop, we set the left and right here
            final Rect bounds = mTempRect;
            bounds.left = mPaddingLeft;
            bounds.right = mRight - mLeft - mPaddingRight;

            final int count = getChildCount();
            final int headerCount = mHeaderViewInfos.size();
            final int itemCount = mItemCount;
            final int footerLimit = itemCount - mFooterViewInfos.size() - 1;
            final boolean headerDividers = mHeaderDividersEnabled;
            final boolean footerDividers = mFooterDividersEnabled;
            final int first = mFirstPosition;
            final boolean areAllItemsSelectable = mAreAllItemsSelectable;
            final ListAdapter adapter = mAdapter;
            // If the list is opaque *and* the background is not, we want to
            // fill a rect where the dividers would be for non-selectable items
            // If the list is opaque and the background is also opaque, we don't
            // need to draw anything since the background will do it for us
            final boolean fillForMissingDividers = isOpaque() && !super.isOpaque();

            if (fillForMissingDividers && mDividerPaint == null && mIsCacheColorOpaque) {
                mDividerPaint = new Paint();
                mDividerPaint.setColor(getCacheColorHint());
            }
            final Paint paint = mDividerPaint;

            int effectivePaddingTop = 0;
            int effectivePaddingBottom = 0;
            if ((mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK) {
                effectivePaddingTop = mListPadding.top;
                effectivePaddingBottom = mListPadding.bottom;
            }

            final int listBottom = mBottom - mTop - effectivePaddingBottom + mScrollY;
            if (!mStackFromBottom) {
                int bottom = 0;
                
                // Draw top divider or header for overscroll
                final int scrollY = mScrollY;
                if (count > 0 && scrollY < 0) {
                    if (drawOverscrollHeader) {
                        bounds.bottom = 0;
                        bounds.top = scrollY;
                        drawOverscrollHeader(canvas, overscrollHeader, bounds);
                    } else if (drawDividers) {
                        bounds.bottom = 0;
                        bounds.top = -dividerHeight;
                        drawDivider(canvas, bounds, -1);
                    }
                }

                for (int i = 0; i < count; i++) {
                    if ((headerDividers || first + i >= headerCount) &&
                            (footerDividers || first + i < footerLimit)) {
                        View child = getChildAt(i);
                        bottom = child.getBottom();
                        // Don't draw dividers next to items that are not enabled

                        if (drawDividers &&
                                (bottom < listBottom && !(drawOverscrollFooter && i == count - 1))) {
                            if ((areAllItemsSelectable ||
                                    (adapter.isEnabled(first + i) && (i == count - 1 ||
                                            adapter.isEnabled(first + i + 1))))) {
                                bounds.top = bottom;
                                bounds.bottom = bottom + dividerHeight;
                                drawDivider(canvas, bounds, i);
                            } else if (fillForMissingDividers) {
                                bounds.top = bottom;
                                bounds.bottom = bottom + dividerHeight;
                                canvas.drawRect(bounds, paint);
                            }
                        }
                    }
                }

                final int overFooterBottom = mBottom + mScrollY;
                if (drawOverscrollFooter && first + count == itemCount &&
                        overFooterBottom > bottom) {
                    bounds.top = bottom;
                    bounds.bottom = overFooterBottom;
                    drawOverscrollFooter(canvas, overscrollFooter, bounds);
                }
            } else {
                int top;

                final int scrollY = mScrollY;

                if (count > 0 && drawOverscrollHeader) {
                    bounds.top = scrollY;
                    bounds.bottom = getChildAt(0).getTop();
                    drawOverscrollHeader(canvas, overscrollHeader, bounds);
                }

                final int start = drawOverscrollHeader ? 1 : 0;
                for (int i = start; i < count; i++) {
                    if ((headerDividers || first + i >= headerCount) &&
                            (footerDividers || first + i < footerLimit)) {
                        View child = getChildAt(i);
                        top = child.getTop();
                        // Don't draw dividers next to items that are not enabled
                        if (top > effectivePaddingTop) {
                            if ((areAllItemsSelectable ||
                                    (adapter.isEnabled(first + i) && (i == count - 1 ||
                                            adapter.isEnabled(first + i + 1))))) {
                                bounds.top = top - dividerHeight;
                                bounds.bottom = top;
                                // Give the method the child ABOVE the divider, so we
                                // subtract one from our child
                                // position. Give -1 when there is no child above the
                                // divider.
                                drawDivider(canvas, bounds, i - 1);
                            } else if (fillForMissingDividers) {
                                bounds.top = top - dividerHeight;
                                bounds.bottom = top;
                                canvas.drawRect(bounds, paint);
                            }
                        }
                    }
                }
                
                if (count > 0 && scrollY > 0) {
                    if (drawOverscrollFooter) {
                        final int absListBottom = mBottom;
                        bounds.top = absListBottom;
                        bounds.bottom = absListBottom + scrollY;
                        drawOverscrollFooter(canvas, overscrollFooter, bounds);
                    } else if (drawDividers) {
                        bounds.top = listBottom;
                        bounds.bottom = listBottom + dividerHeight;
                        drawDivider(canvas, bounds, -1);
                    }
                }
            }
        }

        // Draw the indicators (these should be drawn above the dividers) and children
        super.dispatchDraw(canvas);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.441 -0500", hash_original_method = "4EC2B6750B1C7732AC3B627095EC138F", hash_generated_method = "36894D8E81BA5DB234AA1E7F9C6A1143")
    
@Override
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        boolean more = super.drawChild(canvas, child, drawingTime);
        if (mCachingActive && child.mCachingFailed) {
            mCachingActive = false;
        }
        return more;
    }

    /**
     * Draws a divider for the given child in the given bounds.
     *
     * @param canvas The canvas to draw to.
     * @param bounds The bounds of the divider.
     * @param childIndex The index of child (of the View) above the divider.
     *            This will be -1 if there is no child above the divider to be
     *            drawn.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.444 -0500", hash_original_method = "AB3CC143C94AF212348DFB5018C60850", hash_generated_method = "B2EF44B3A7B822E184164B205FA8E5FC")
    
void drawDivider(Canvas canvas, Rect bounds, int childIndex) {
        // This widget draws the same divider for all children
        final Drawable divider = mDivider;

        divider.setBounds(bounds);
        divider.draw(canvas);
    }

    /**
     * Returns the drawable that will be drawn between each item in the list.
     *
     * @return the current drawable drawn between list elements
     */
    @DSComment("ListView")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.446 -0500", hash_original_method = "7B5403D1FD6AC98A776FCB41ADD8E487", hash_generated_method = "6D7015A0035B7E7E6FFBA1DFBEFC56D9")
    
public Drawable getDivider() {
        return mDivider;
    }

    /**
     * Sets the drawable that will be drawn between each item in the list. If the drawable does
     * not have an intrinsic height, you should also call {@link #setDividerHeight(int)}
     *
     * @param divider The drawable to use.
     */
    @DSComment("ListView")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.448 -0500", hash_original_method = "7913B276C2BDCD5302E597BC9A4CB654", hash_generated_method = "B4700849B7DAB56CBE38DDAC5F26ACE3")
    
public void setDivider(Drawable divider) {
        if (divider != null) {
            mDividerHeight = divider.getIntrinsicHeight();
        } else {
            mDividerHeight = 0;
        }
        mDivider = divider;
        mDividerIsOpaque = divider == null || divider.getOpacity() == PixelFormat.OPAQUE;
        requestLayout();
        invalidate();
    }

    /**
     * @return Returns the height of the divider that will be drawn between each item in the list.
     */
    @DSComment("ListView")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.450 -0500", hash_original_method = "229663AAAB1BC0B50485AD0B5CC199F3", hash_generated_method = "2F62CF391761700AD78489304D8DCE6B")
    
public int getDividerHeight() {
        return mDividerHeight;
    }
    
    /**
     * Sets the height of the divider that will be drawn between each item in the list. Calling
     * this will override the intrinsic height as set by {@link #setDivider(Drawable)}
     *
     * @param height The new height of the divider in pixels.
     */
    @DSComment("ListView")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.452 -0500", hash_original_method = "D3D08555D2F9E637F163A09E680CBA08", hash_generated_method = "472E617F01D7984751BF56DF1247B0F2")
    
public void setDividerHeight(int height) {
        mDividerHeight = height;
        requestLayout();
        invalidate();
    }

    /**
     * Enables or disables the drawing of the divider for header views.
     *
     * @param headerDividersEnabled True to draw the headers, false otherwise.
     *
     * @see #setFooterDividersEnabled(boolean)
     * @see #addHeaderView(android.view.View)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.454 -0500", hash_original_method = "97442AC2339A7874BFA41866E47D7310", hash_generated_method = "C4129576C97A31741CB8EECB7C9E9DE8")
    
public void setHeaderDividersEnabled(boolean headerDividersEnabled) {
        mHeaderDividersEnabled = headerDividersEnabled;
        invalidate();
    }

    /**
     * Enables or disables the drawing of the divider for footer views.
     *
     * @param footerDividersEnabled True to draw the footers, false otherwise.
     *
     * @see #setHeaderDividersEnabled(boolean)
     * @see #addFooterView(android.view.View)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.457 -0500", hash_original_method = "74ACE2244DDEB7C7F913E5E0F875653E", hash_generated_method = "2641033F70975F7A197B81428ED05953")
    
public void setFooterDividersEnabled(boolean footerDividersEnabled) {
        mFooterDividersEnabled = footerDividersEnabled;
        invalidate();
    }
    
    /**
     * Sets the drawable that will be drawn above all other list content.
     * This area can become visible when the user overscrolls the list.
     *
     * @param header The drawable to use
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.459 -0500", hash_original_method = "953E541E16240F0325506F6534EE33B4", hash_generated_method = "FDF88B5DD551A2365B24B0957BD8DD35")
    
public void setOverscrollHeader(Drawable header) {
        mOverScrollHeader = header;
        if (mScrollY < 0) {
            invalidate();
        }
    }

    /**
     * @return The drawable that will be drawn above all other list content
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.461 -0500", hash_original_method = "95FFBAE371294243FE9AD2355C3622A4", hash_generated_method = "A22E72392B75DCF7C5CEC5AE532DFBF7")
    
public Drawable getOverscrollHeader() {
        return mOverScrollHeader;
    }

    /**
     * Sets the drawable that will be drawn below all other list content.
     * This area can become visible when the user overscrolls the list,
     * or when the list's content does not fully fill the container area.
     *
     * @param footer The drawable to use
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.463 -0500", hash_original_method = "E2CA032ECDDC156C9CE8335D95975846", hash_generated_method = "0EF534FBD693F755F47E4E1B5521038B")
    
public void setOverscrollFooter(Drawable footer) {
        mOverScrollFooter = footer;
        invalidate();
    }

    /**
     * @return The drawable that will be drawn below all other list content
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.465 -0500", hash_original_method = "C43851852530BF4773181DC349AD3704", hash_generated_method = "4A780287AA15E69E38B7937193AC5D03")
    
public Drawable getOverscrollFooter() {
        return mOverScrollFooter;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.468 -0500", hash_original_method = "A140BD3D04197A195532B0C2217798E2", hash_generated_method = "A7021BE844658E46087ACCBCE5572780")
    
@Override
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);

        final ListAdapter adapter = mAdapter;
        int closetChildIndex = -1;
        int closestChildTop = 0;
        if (adapter != null && gainFocus && previouslyFocusedRect != null) {
            previouslyFocusedRect.offset(mScrollX, mScrollY);

            // Don't cache the result of getChildCount or mFirstPosition here,
            // it could change in layoutChildren.
            if (adapter.getCount() < getChildCount() + mFirstPosition) {
                mLayoutMode = LAYOUT_NORMAL;
                layoutChildren();
            }

            // figure out which item should be selected based on previously
            // focused rect
            Rect otherRect = mTempRect;
            int minDistance = Integer.MAX_VALUE;
            final int childCount = getChildCount();
            final int firstPosition = mFirstPosition;

            for (int i = 0; i < childCount; i++) {
                // only consider selectable views
                if (!adapter.isEnabled(firstPosition + i)) {
                    continue;
                }

                View other = getChildAt(i);
                other.getDrawingRect(otherRect);
                offsetDescendantRectToMyCoords(other, otherRect);
                int distance = getDistance(previouslyFocusedRect, otherRect, direction);

                if (distance < minDistance) {
                    minDistance = distance;
                    closetChildIndex = i;
                    closestChildTop = other.getTop();
                }
            }
        }

        if (closetChildIndex >= 0) {
            setSelectionFromTop(closetChildIndex + mFirstPosition, closestChildTop);
        } else {
            requestLayout();
        }
    }

    /*
     * (non-Javadoc)
     *
     * Children specified in XML are assumed to be header views. After we have
     * parsed them move them out of the children list and into mHeaderViews.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.471 -0500", hash_original_method = "33666A5E6A3C0638CD57027CC0FE1CC1", hash_generated_method = "6DA94F0EF2EE92922D03B338765F77D6")
    
@Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        int count = getChildCount();
        if (count > 0) {
            for (int i = 0; i < count; ++i) {
                addHeaderView(getChildAt(i));
            }
            removeAllViews();
        }
    }

    /* (non-Javadoc)
     * @see android.view.View#findViewById(int)
     * First look in our children, then in any header and footer views that may be scrolled off.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.473 -0500", hash_original_method = "55B474F0526D1B513F7B1BB91F273A6A", hash_generated_method = "60858F5DDB1531F3A39ECECF984D2B45")
    
@Override
    protected View findViewTraversal(int id) {
        View v;
        v = super.findViewTraversal(id);
        if (v == null) {
            v = findViewInHeadersOrFooters(mHeaderViewInfos, id);
            if (v != null) {
                return v;
            }
            v = findViewInHeadersOrFooters(mFooterViewInfos, id);
            if (v != null) {
                return v;
            }
        }
        return v;
    }

    /* (non-Javadoc)
     *
     * Look in the passed in list of headers or footers for the view.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.476 -0500", hash_original_method = "CE5790FF46C8EC9157EF966632ADD833", hash_generated_method = "CE5790FF46C8EC9157EF966632ADD833")
    
View findViewInHeadersOrFooters(ArrayList<FixedViewInfo> where, int id) {
        if (where != null) {
            int len = where.size();
            View v;

            for (int i = 0; i < len; i++) {
                v = where.get(i).view;

                if (!v.isRootNamespace()) {
                    v = v.findViewById(id);

                    if (v != null) {
                        return v;
                    }
                }
            }
        }
        return null;
    }

    /* (non-Javadoc)
     * @see android.view.View#findViewWithTag(Object)
     * First look in our children, then in any header and footer views that may be scrolled off.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.478 -0500", hash_original_method = "3E2A521CFE9847E9FDB3AEC6F88A76DD", hash_generated_method = "E3A03711B3C42F2FE1A6886142ED7A7F")
    
@Override
    protected View findViewWithTagTraversal(Object tag) {
        View v;
        v = super.findViewWithTagTraversal(tag);
        if (v == null) {
            v = findViewWithTagInHeadersOrFooters(mHeaderViewInfos, tag);
            if (v != null) {
                return v;
            }

            v = findViewWithTagInHeadersOrFooters(mFooterViewInfos, tag);
            if (v != null) {
                return v;
            }
        }
        return v;
    }

    /* (non-Javadoc)
     *
     * Look in the passed in list of headers or footers for the view with the tag.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.480 -0500", hash_original_method = "FB5700AACE78A96EA34C4186153EA1D8", hash_generated_method = "FB5700AACE78A96EA34C4186153EA1D8")
    
View findViewWithTagInHeadersOrFooters(ArrayList<FixedViewInfo> where, Object tag) {
        if (where != null) {
            int len = where.size();
            View v;

            for (int i = 0; i < len; i++) {
                v = where.get(i).view;

                if (!v.isRootNamespace()) {
                    v = v.findViewWithTag(tag);

                    if (v != null) {
                        return v;
                    }
                }
            }
        }
        return null;
    }
    
    public class FixedViewInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.135 -0500", hash_original_field = "203A52904F64FA8CF6CE15F1E8FE3025", hash_generated_field = "F4E21118122450D7DE8C5B004AEA690D")

        public View view;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.137 -0500", hash_original_field = "CE7151C125F70523A3974F0B482E048E", hash_generated_field = "FC3B89DB1B4BAEFF0C8DFDD10399B12A")

        public Object data;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.140 -0500", hash_original_field = "DD982BFE0E88831C4AA101845067056A", hash_generated_field = "51BB0A155CFD263D81C29BB4668379B4")

        public boolean isSelectable;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.900 -0400", hash_original_method = "67C6F15893AD18CF0EAE06202C68D9E8", hash_generated_method = "67C6F15893AD18CF0EAE06202C68D9E8")
        public FixedViewInfo ()
        {
            //Synthesized constructor
        }

    }
    
    private class FocusSelector implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.267 -0500", hash_original_field = "4EE731A4D843C99A130C2ED24E5FDDEA", hash_generated_field = "D614AE7D1AAE0276EA05A974DCBF0210")

        private int mPosition;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.269 -0500", hash_original_field = "67BB2D76AD26A0B8CEA23A0BA7336FEF", hash_generated_field = "9F00838B177601A91ACC5BEF0B2B59E5")

        private int mPositionTop;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.900 -0400", hash_original_method = "34C9C9AFBDE05AECFED95C79C10A76BA", hash_generated_method = "34C9C9AFBDE05AECFED95C79C10A76BA")
        public FocusSelector ()
        {
            //Synthesized constructor
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.271 -0500", hash_original_method = "5C0213FE7A42F47411000D870177F1B7", hash_generated_method = "0E50CF581D357EC2BE340B87B2F2876A")
        
public FocusSelector setup(int position, int top) {
            mPosition = position;
            mPositionTop = top;
            return this;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.274 -0500", hash_original_method = "1C9CFC3992CD17CE1A3B73D68C8C6081", hash_generated_method = "E670ACF73BF7BA03457F170606925817")
        
public void run() {
            setSelectionFromTop(mPosition, mPositionTop);
        }
        
    }
    
    static private class ArrowScrollFocusResult {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.382 -0500", hash_original_field = "8CB1722C7F01C739E69816804A7000C1", hash_generated_field = "51E21A7A6543942D242B4E74F7651C70")

        private int mSelectedPosition;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.385 -0500", hash_original_field = "59E32B8DDC4B748C16272910ACFF23E4", hash_generated_field = "A1DDFEC53FF7E81352EF3B979C9E665D")

        private int mAmountToScroll;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.901 -0400", hash_original_method = "F12FA46FC2E286992F273AF0197118D3", hash_generated_method = "F12FA46FC2E286992F273AF0197118D3")
        public ArrowScrollFocusResult ()
        {
            //Synthesized constructor
        }

        /**
         * How {@link android.widget.ListView#arrowScrollFocused} returns its values.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.387 -0500", hash_original_method = "E4C7C1A71AB7D603722F7CE31ED09575", hash_generated_method = "E4C7C1A71AB7D603722F7CE31ED09575")
        
void populate(int selectedPosition, int amountToScroll) {
            mSelectedPosition = selectedPosition;
            mAmountToScroll = amountToScroll;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.389 -0500", hash_original_method = "57FF42983620727F309A47A5C295AFEC", hash_generated_method = "92A8B8896D91AD027F13B514D160C0A6")
        
public int getSelectedPosition() {
            return mSelectedPosition;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.391 -0500", hash_original_method = "547539826ED165E8A574C9320A564E9F", hash_generated_method = "1B14DA9BD3209431A7A70E8EAAC3C44C")
        
public int getAmountToScroll() {
            return mAmountToScroll;
        }
        
    }

    /**
     * @hide
     * @see android.view.View#findViewByPredicate(Predicate)
     * First look in our children, then in any header and footer views that may be scrolled off.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.484 -0500", hash_original_method = "C4FCF9CDE386456E06D0A36ACE84F436", hash_generated_method = "960790869B4758353358C7D006A5570D")
    
@Override
    protected View findViewByPredicateTraversal(Predicate<View> predicate, View childToSkip) {
        View v;
        v = super.findViewByPredicateTraversal(predicate, childToSkip);
        if (v == null) {
            v = findViewByPredicateInHeadersOrFooters(mHeaderViewInfos, predicate, childToSkip);
            if (v != null) {
                return v;
            }

            v = findViewByPredicateInHeadersOrFooters(mFooterViewInfos, predicate, childToSkip);
            if (v != null) {
                return v;
            }
        }
        return v;
    }

    /* (non-Javadoc)
     *
     * Look in the passed in list of headers or footers for the first view that matches
     * the predicate.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.486 -0500", hash_original_method = "D1F1A1145A67766E94BF084DFEF4A6A9", hash_generated_method = "D1F1A1145A67766E94BF084DFEF4A6A9")
    
View findViewByPredicateInHeadersOrFooters(ArrayList<FixedViewInfo> where,
            Predicate<View> predicate, View childToSkip) {
        if (where != null) {
            int len = where.size();
            View v;

            for (int i = 0; i < len; i++) {
                v = where.get(i).view;

                if (v != childToSkip && !v.isRootNamespace()) {
                    v = v.findViewByPredicate(predicate);

                    if (v != null) {
                        return v;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Returns the set of checked items ids. The result is only valid if the
     * choice mode has not been set to {@link #CHOICE_MODE_NONE}.
     * 
     * @return A new array which contains the id of each checked item in the
     *         list.
     *         
     * @deprecated Use {@link #getCheckedItemIds()} instead.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:18.489 -0500", hash_original_method = "7376DB3A956D54D1A994EA4B9B95B8AF", hash_generated_method = "8846D03C949588374F3DF84CE285E00E")
    
@Deprecated
    public long[] getCheckItemIds() {
        // Use new behavior that correctly handles stable ID mapping.
        if (mAdapter != null && mAdapter.hasStableIds()) {
            return getCheckedItemIds();
        }

        // Old behavior was buggy, but would sort of work for adapters without stable IDs.
        // Fall back to it to support legacy apps.
        if (mChoiceMode != CHOICE_MODE_NONE && mCheckStates != null && mAdapter != null) {
            final SparseBooleanArray states = mCheckStates;
            final int count = states.size();
            final long[] ids = new long[count];
            final ListAdapter adapter = mAdapter;

            int checkedCount = 0;
            for (int i = 0; i < count; i++) {
                if (states.valueAt(i)) {
                    ids[checkedCount++] = adapter.getItemId(states.keyAt(i));
                }
            }

            // Trim array if needed. mCheckStates may contain false values
            // resulting in checkedCount being smaller than count.
            if (checkedCount == count) {
                return ids;
            } else {
                final long[] result = new long[checkedCount];
                System.arraycopy(ids, 0, result, 0, checkedCount);

                return result;
            }
        }
        return new long[0];
    }
    // orphaned legacy method
    @Override
	public void updateViewLayout(View view,
			android.view.ViewGroup.LayoutParams params) {
		// TODO Auto-generated method stub
		
	}
    
}

