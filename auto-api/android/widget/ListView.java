package android.widget;

// Droidsafe Imports
import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
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

import com.android.internal.R;
import com.android.internal.util.Predicate;
import com.google.android.collect.Lists;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.runtime.DroidSafeAndroidRuntime;

// import Iterator to deal with enhanced for loop translation

public class ListView extends AbsListView {
	static final int NO_POSITION = -1;
	private static final float MAX_SCROLL_FACTOR = 0.33f;
	private static final int MIN_SCROLL_PREVIEW_PIXELS = 2;
	private ArrayList<FixedViewInfo> mHeaderViewInfos = Lists.newArrayList();
	private ArrayList<FixedViewInfo> mFooterViewInfos = Lists.newArrayList();
	Drawable mDivider;
	int mDividerHeight;
	Drawable mOverScrollHeader;
	Drawable mOverScrollFooter;
	private boolean mIsCacheColorOpaque;
	private boolean mDividerIsOpaque;
	private boolean mHeaderDividersEnabled;
	private boolean mFooterDividersEnabled;
	private boolean mAreAllItemsSelectable = true;
	private boolean mItemsCanFocus = false;
	private final Rect mTempRect = new Rect();
	private Paint mDividerPaint;
	private final ArrowScrollFocusResult mArrowScrollFocusResult = new ArrowScrollFocusResult();
	private FocusSelector mFocusSelector;

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.038 -0400", hash_original_method = "90B4B4BF6E484BC26800C5A789F4708D", hash_generated_method = "1D97A485DBE344E3190E07E67536060E")
	// DSFIXME: CODE0002: Requires DSC value to be set
	public ListView(Context context) {
		this(context, null);
		dsTaint.addTaint(context.dsTaint);
		// ---------- Original Method ----------
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.038 -0400", hash_original_method = "5C8040E9D31754EC73AE53985C54C1B3", hash_generated_method = "D474E467E40CD9DA9A5A427EB67A5E31")
	// DSFIXME: CODE0002: Requires DSC value to be set
	public ListView(Context context, AttributeSet attrs) {
		this(context, attrs, com.android.internal.R.attr.listViewStyle);
		dsTaint.addTaint(attrs.dsTaint);
		dsTaint.addTaint(context.dsTaint);
		// ---------- Original Method ----------
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.038 -0400", hash_original_method = "1588C0DF1CDF9192487B09246AC39E9C", hash_generated_method = "AD36F2370198729AD5AF06179F8C100F")
	// DSFIXME: CODE0002: Requires DSC value to be set
	public ListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		dsTaint.addTaint(attrs.dsTaint);
		dsTaint.addTaint(defStyle);
		dsTaint.addTaint(context.dsTaint);
		TypedArray a;
		a = context.obtainStyledAttributes(attrs,
				com.android.internal.R.styleable.ListView, defStyle, 0);
		CharSequence[] entries;
		entries = a
				.getTextArray(com.android.internal.R.styleable.ListView_entries);
		{
			setAdapter(new ArrayAdapter<CharSequence>(context,
					com.android.internal.R.layout.simple_list_item_1, entries));
		} // End block
		final Drawable d;
		d = a.getDrawable(com.android.internal.R.styleable.ListView_divider);
		{
			setDivider(d);
		} // End block
		final Drawable osHeader;
		osHeader = a
				.getDrawable(com.android.internal.R.styleable.ListView_overScrollHeader);
		{
			setOverscrollHeader(osHeader);
		} // End block
		final Drawable osFooter;
		osFooter = a
				.getDrawable(com.android.internal.R.styleable.ListView_overScrollFooter);
		{
			setOverscrollFooter(osFooter);
		} // End block
		final int dividerHeight;
		dividerHeight = a.getDimensionPixelSize(
				com.android.internal.R.styleable.ListView_dividerHeight, 0);
		{
			setDividerHeight(dividerHeight);
		} // End block
		mHeaderDividersEnabled = a.getBoolean(
				R.styleable.ListView_headerDividersEnabled, true);
		mFooterDividersEnabled = a.getBoolean(
				R.styleable.ListView_footerDividersEnabled, true);
		a.recycle();
		// ---------- Original Method ----------
		// Original Method Too Long, Refer to Original Implementation
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.038 -0400", hash_original_method = "13CC3D3BB67006B8B223FEAA5CEB8AD3", hash_generated_method = "CEAAABD4DE747FC0C910B456C1725542")
	@DSModeled(DSC.SAFE)
	public int getMaxScrollAmount() {
		return dsTaint.getTaintInt();
		// ---------- Original Method ----------
		// return (int) (MAX_SCROLL_FACTOR * (mBottom - mTop));
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.038 -0400", hash_original_method = "C98C1C3289511C3CD05158CF07015375", hash_generated_method = "263E2D83CF3B0114E8AD8F9B7F2E454B")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private void adjustViewsUpOrDown() {
		final int childCount;
		childCount = getChildCount();
		int delta;
		{
			View child;
			{
				child = getChildAt(0);
				delta = child.getTop() - mListPadding.top;
				{
					delta -= mDividerHeight;
				} // End block
				{
					delta = 0;
				} // End block
			} // End block
			{
				child = getChildAt(childCount - 1);
				delta = child.getBottom() - (getHeight() - mListPadding.bottom);
				{
					delta += mDividerHeight;
				} // End block
				{
					delta = 0;
				} // End block
			} // End block
			{
				offsetChildrenTopAndBottom(-delta);
			} // End block
		} // End block
			// ---------- Original Method ----------
			// Original Method Too Long, Refer to Original Implementation
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.039 -0400", hash_original_method = "52D3689EBA08A028E74C350405FC2CA4", hash_generated_method = "89120E095DF21C5F9D25DB216FCA9397")
	@DSModeled(DSC.SAFE)
	public void addHeaderView(View v, Object data, boolean isSelectable) {
		dsTaint.addTaint(v.dsTaint);
		dsTaint.addTaint(isSelectable);
		dsTaint.addTaint(data.dsTaint);
		{
			if (DroidSafeAndroidRuntime.control)
				throw new IllegalStateException(
						"Cannot add header view to list -- setAdapter has already been called.");
		} // End block
		FixedViewInfo info;
		info = new FixedViewInfo();
		info.view = v;
		info.data = data;
		info.isSelectable = isSelectable;
		mHeaderViewInfos.add(info);
		{
			mDataSetObserver.onChanged();
		} // End block
			// ---------- Original Method ----------
			// if (mAdapter != null && ! (mAdapter instanceof
			// HeaderViewListAdapter)) {
			// throw new IllegalStateException(
			// "Cannot add header view to list -- setAdapter has already been called.");
		// }
		// FixedViewInfo info = new FixedViewInfo();
		// info.view = v;
		// info.data = data;
		// info.isSelectable = isSelectable;
		// mHeaderViewInfos.add(info);
		// if (mAdapter != null && mDataSetObserver != null) {
		// mDataSetObserver.onChanged();
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.039 -0400", hash_original_method = "9CDB9BC1941825D09F579B09BA5203C8", hash_generated_method = "6EA0445BE2A1060F5B30747853910C50")
	@DSModeled(DSC.SAFE)
	public void addHeaderView(View v) {
		dsTaint.addTaint(v.dsTaint);
		addHeaderView(v, null, true);
		// ---------- Original Method ----------
		// addHeaderView(v, null, true);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.039 -0400", hash_original_method = "9A198FE2F7DAA22CDFAB063EB95C8DFA", hash_generated_method = "51F57CBAAAA8EE426225C9185371987D")
	// DSFIXME: CODE0002: Requires DSC value to be set
	@Override
	public int getHeaderViewsCount() {
		int var51EB21BA6322BC21883B38109F793DB7_1020600479 = (mHeaderViewInfos
				.size());
		return dsTaint.getTaintInt();
		// ---------- Original Method ----------
		// return mHeaderViewInfos.size();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.039 -0400", hash_original_method = "8EF6528E21853FD53F2FB8406F9F06D5", hash_generated_method = "1CE202E2215DD325367C2C09E888B19B")
	// DSFIXME: CODE0002: Requires DSC value to be set
	public boolean removeHeaderView(View v) {
		dsTaint.addTaint(v.dsTaint);
		{
			boolean varFC339A57DD06D9F6F47BBD3A88B06E10_343013477 = (mHeaderViewInfos
					.size() > 0);
			{
				boolean result;
				result = false;
				{
					boolean var9BFD45A2F2990893F8C6EA8C90DB82AA_1753428130 = (mAdapter != null && ((HeaderViewListAdapter) mAdapter)
							.removeHeader(v));
					{
						{
							mDataSetObserver.onChanged();
						} // End block
						result = true;
					} // End block
				} // End collapsed parenthetic
				removeFixedViewInfo(v, mHeaderViewInfos);
			} // End block
		} // End collapsed parenthetic
		return dsTaint.getTaintBoolean();
		// ---------- Original Method ----------
		// if (mHeaderViewInfos.size() > 0) {
		// boolean result = false;
		// if (mAdapter != null && ((HeaderViewListAdapter)
		// mAdapter).removeHeader(v)) {
		// if (mDataSetObserver != null) {
		// mDataSetObserver.onChanged();
		// }
		// result = true;
		// }
		// removeFixedViewInfo(v, mHeaderViewInfos);
		// return result;
		// }
		// return false;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.039 -0400", hash_original_method = "56A07A9A1AC012F692F90759B155683C", hash_generated_method = "C1A7BF97F6E367878F274C724643AD51")
	@DSModeled(DSC.SAFE)
	private void removeFixedViewInfo(View v, ArrayList<FixedViewInfo> where) {
		dsTaint.addTaint(v.dsTaint);
		dsTaint.addTaint(where.dsTaint);
		int len;
		len = where.size();
		{
			int i;
			i = 0;
			{
				FixedViewInfo info;
				info = where.get(i);
				{
					where.remove(i);
				} // End block
			} // End block
		} // End collapsed parenthetic
			// ---------- Original Method ----------
			// int len = where.size();
			// for (int i = 0; i < len; ++i) {
			// FixedViewInfo info = where.get(i);
			// if (info.view == v) {
			// where.remove(i);
			// break;
		// }
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.039 -0400", hash_original_method = "854663FFCE0B2EEEA12F571F4E080752", hash_generated_method = "2F5A07624412AC5642B0636AA0D503FD")
	@DSModeled(DSC.SAFE)
	public void addFooterView(View v, Object data, boolean isSelectable) {
		dsTaint.addTaint(v.dsTaint);
		dsTaint.addTaint(isSelectable);
		dsTaint.addTaint(data.dsTaint);
		FixedViewInfo info;
		info = new FixedViewInfo();
		info.view = v;
		info.data = data;
		info.isSelectable = isSelectable;
		mFooterViewInfos.add(info);
		{
			mDataSetObserver.onChanged();
		} // End block
			// ---------- Original Method ----------
			// FixedViewInfo info = new FixedViewInfo();
			// info.view = v;
			// info.data = data;
			// info.isSelectable = isSelectable;
			// mFooterViewInfos.add(info);
			// if (mAdapter != null && mDataSetObserver != null) {
			// mDataSetObserver.onChanged();
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.039 -0400", hash_original_method = "06A7CBCF71002E57CE516EE24D5E8CDC", hash_generated_method = "596E0DC14555C36CA262403E82C374E9")
	@DSModeled(DSC.SAFE)
	public void addFooterView(View v) {
		dsTaint.addTaint(v.dsTaint);
		addFooterView(v, null, true);
		// ---------- Original Method ----------
		// addFooterView(v, null, true);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.039 -0400", hash_original_method = "83BE551B6778E6D258871D9949AEF538", hash_generated_method = "A9E4956739BBF3C529F10FAFB035F0F1")
	// DSFIXME: CODE0002: Requires DSC value to be set
	@Override
	public int getFooterViewsCount() {
		int var05D2A206262A11BE7E645CDC53B4074D_20617839 = (mFooterViewInfos
				.size());
		return dsTaint.getTaintInt();
		// ---------- Original Method ----------
		// return mFooterViewInfos.size();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.039 -0400", hash_original_method = "D2E29F254410117CE819574854BB79EC", hash_generated_method = "A1F4DAB7F370957D2702356F537660C3")
	// DSFIXME: CODE0002: Requires DSC value to be set
	public boolean removeFooterView(View v) {
		dsTaint.addTaint(v.dsTaint);
		{
			boolean var16785181560AF1EBB84626B752BB868A_1465349529 = (mFooterViewInfos
					.size() > 0);
			{
				boolean result;
				result = false;
				{
					boolean var9C4812C55FB91AE0FCF1729C742654B1_1080804465 = (mAdapter != null && ((HeaderViewListAdapter) mAdapter)
							.removeFooter(v));
					{
						{
							mDataSetObserver.onChanged();
						} // End block
						result = true;
					} // End block
				} // End collapsed parenthetic
				removeFixedViewInfo(v, mFooterViewInfos);
			} // End block
		} // End collapsed parenthetic
		return dsTaint.getTaintBoolean();
		// ---------- Original Method ----------
		// if (mFooterViewInfos.size() > 0) {
		// boolean result = false;
		// if (mAdapter != null && ((HeaderViewListAdapter)
		// mAdapter).removeFooter(v)) {
		// if (mDataSetObserver != null) {
		// mDataSetObserver.onChanged();
		// }
		// result = true;
		// }
		// removeFixedViewInfo(v, mFooterViewInfos);
		// return result;
		// }
		// return false;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.039 -0400", hash_original_method = "0E1A05724C497F45D7FB6AC34C501814", hash_generated_method = "6F2CFA0A476E08F2F9D4BE3572FCFD68")
	@DSModeled(DSC.SAFE)
	@Override
	public ListAdapter getAdapter() {
		return (ListAdapter) dsTaint.getTaint();
		// ---------- Original Method ----------
		// return mAdapter;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.040 -0400", hash_original_method = "8AB2C6958FD7CEC3A8A71FE59763D6A4", hash_generated_method = "84CEB738663F6311E41BDDBB6C4CBE4F")
	@DSModeled(DSC.SPEC)
	@android.view.RemotableViewMethod
	public void setRemoteViewsAdapter(Intent intent) {
		dsTaint.addTaint(intent.dsTaint);
		super.setRemoteViewsAdapter(intent);
		// ---------- Original Method ----------
		// super.setRemoteViewsAdapter(intent);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.040 -0400", hash_original_method = "41402E7D77C488BF4C279E76F34BC4E2", hash_generated_method = "4954339B02ACA00B1900B75042B432FC")
	// DSFIXME: CODE0002: Requires DSC value to be set
	@Override
	public void setAdapter(ListAdapter adapter) {
		dsTaint.addTaint(adapter.dsTaint);
		{
			mAdapter.unregisterDataSetObserver(mDataSetObserver);
		} // End block
		resetList();
		mRecycler.clear();
		{
			boolean var424DAEFA84C4CC446223C4E25F5F060B_1182732816 = (mHeaderViewInfos
					.size() > 0 || mFooterViewInfos.size() > 0);
			{
				mAdapter = new HeaderViewListAdapter(mHeaderViewInfos,
						mFooterViewInfos, adapter);
			} // End block
			{
				mAdapter = adapter;
			} // End block
		} // End collapsed parenthetic
		mOldSelectedPosition = INVALID_POSITION;
		mOldSelectedRowId = INVALID_ROW_ID;
		super.setAdapter(adapter);
		{
			mAreAllItemsSelectable = mAdapter.areAllItemsEnabled();
			mOldItemCount = mItemCount;
			mItemCount = mAdapter.getCount();
			checkFocus();
			mDataSetObserver = new AdapterDataSetObserver();
			mAdapter.registerDataSetObserver(mDataSetObserver);
			mRecycler.setViewTypeCount(mAdapter.getViewTypeCount());
			int position;
			{
				position = lookForSelectablePosition(mItemCount - 1, false);
			} // End block
			{
				position = lookForSelectablePosition(0, true);
			} // End block
			setSelectedPositionInt(position);
			setNextSelectedPositionInt(position);
			{
				checkSelectionChanged();
			} // End block
		} // End block
		{
			mAreAllItemsSelectable = true;
			checkFocus();
			checkSelectionChanged();
		} // End block
		requestLayout();
		// ---------- Original Method ----------
		// Original Method Too Long, Refer to Original Implementation
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.040 -0400", hash_original_method = "2C61A8961B533B2EFAE2B5516136BD48", hash_generated_method = "4DDAA83C2A813121F8C8C39969864EE1")
	@DSModeled(DSC.SAFE)
	@Override
	void resetList() {
		clearRecycledState(mHeaderViewInfos);
		clearRecycledState(mFooterViewInfos);
		super.resetList();
		mLayoutMode = LAYOUT_NORMAL;
		// ---------- Original Method ----------
		// clearRecycledState(mHeaderViewInfos);
		// clearRecycledState(mFooterViewInfos);
		// super.resetList();
		// mLayoutMode = LAYOUT_NORMAL;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.040 -0400", hash_original_method = "917FCC60A4286C5138F872CFDA18A6AE", hash_generated_method = "134C2138ECAA34756AD611C03ADBA0D6")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private void clearRecycledState(ArrayList<FixedViewInfo> infos) {
		dsTaint.addTaint(infos.dsTaint);
		{
			final int count;
			count = infos.size();
			{
				int i;
				i = 0;
				{
					final View child;
					child = infos.get(i).view;
					final LayoutParams p;
					p = (LayoutParams) child.getLayoutParams();
					{
						p.recycledHeaderFooter = false;
					} // End block
				} // End block
			} // End collapsed parenthetic
		} // End block
			// ---------- Original Method ----------
			// if (infos != null) {
			// final int count = infos.size();
			// for (int i = 0; i < count; i++) {
			// final View child = infos.get(i).view;
			// final LayoutParams p = (LayoutParams) child.getLayoutParams();
			// if (p != null) {
			// p.recycledHeaderFooter = false;
		// }
		// }
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.040 -0400", hash_original_method = "AE08170EA161B6A1BF0E53E679181532", hash_generated_method = "F09597878EC7C0578558DA85004D4AD3")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private boolean showingTopFadingEdge() {
		final int listTop;
		listTop = mScrollY + mListPadding.top;
		boolean varCCBED360491DE804AB67732329ABF3EB_2086633923 = ((mFirstPosition > 0) || (getChildAt(
				0).getTop() > listTop));
		return dsTaint.getTaintBoolean();
		// ---------- Original Method ----------
		// final int listTop = mScrollY + mListPadding.top;
		// return (mFirstPosition > 0) || (getChildAt(0).getTop() > listTop);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.040 -0400", hash_original_method = "471206817827115E6FDE8330BC3BFE06", hash_generated_method = "5FE82DBA46D2C55E556EB9571BDF147A")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private boolean showingBottomFadingEdge() {
		final int childCount;
		childCount = getChildCount();
		final int bottomOfBottomChild;
		bottomOfBottomChild = getChildAt(childCount - 1).getBottom();
		final int lastVisiblePosition;
		lastVisiblePosition = mFirstPosition + childCount - 1;
		final int listBottom;
		listBottom = mScrollY + getHeight() - mListPadding.bottom;
		return dsTaint.getTaintBoolean();
		// ---------- Original Method ----------
		// final int childCount = getChildCount();
		// final int bottomOfBottomChild = getChildAt(childCount -
		// 1).getBottom();
		// final int lastVisiblePosition = mFirstPosition + childCount - 1;
		// final int listBottom = mScrollY + getHeight() - mListPadding.bottom;
		// return (lastVisiblePosition < mItemCount - 1)
		// || (bottomOfBottomChild < listBottom);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.041 -0400", hash_original_method = "0248A9BC20DE00C469CC3A8962885EF5", hash_generated_method = "7F52D29F34AA09EA61629AD16D403850")
	// DSFIXME: CODE0002: Requires DSC value to be set
	@Override
	public boolean requestChildRectangleOnScreen(View child, Rect rect,
			boolean immediate) {
		dsTaint.addTaint(child.dsTaint);
		dsTaint.addTaint(immediate);
		dsTaint.addTaint(rect.dsTaint);
		int rectTopWithinChild;
		rectTopWithinChild = rect.top;
		rect.offset(child.getLeft(), child.getTop());
		rect.offset(-child.getScrollX(), -child.getScrollY());
		final int height;
		height = getHeight();
		int listUnfadedTop;
		listUnfadedTop = getScrollY();
		int listUnfadedBottom;
		listUnfadedBottom = listUnfadedTop + height;
		final int fadingEdge;
		fadingEdge = getVerticalFadingEdgeLength();
		{
			boolean var60D2B66A5E3C386C88687929883234E5_188653830 = (showingTopFadingEdge());
			{
				{
					listUnfadedTop += fadingEdge;
				} // End block
			} // End block
		} // End collapsed parenthetic
		int childCount;
		childCount = getChildCount();
		int bottomOfBottomChild;
		bottomOfBottomChild = getChildAt(childCount - 1).getBottom();
		{
			boolean varEC085D03DEF6DF005C7F3192FEB447ED_1664905662 = (showingBottomFadingEdge());
			{
				{
					listUnfadedBottom -= fadingEdge;
				} // End block
			} // End block
		} // End collapsed parenthetic
		int scrollYDelta;
		scrollYDelta = 0;
		{
			{
				boolean var1852437954D6FC93B41EE304F855C339_927792044 = (rect
						.height() > height);
				{
					scrollYDelta += (rect.top - listUnfadedTop);
				} // End block
				{
					scrollYDelta += (rect.bottom - listUnfadedBottom);
				} // End block
			} // End collapsed parenthetic
			int distanceToBottom;
			distanceToBottom = bottomOfBottomChild - listUnfadedBottom;
			scrollYDelta = Math.min(scrollYDelta, distanceToBottom);
		} // End block
		{
			{
				boolean var1852437954D6FC93B41EE304F855C339_1378121851 = (rect
						.height() > height);
				{
					scrollYDelta -= (listUnfadedBottom - rect.bottom);
				} // End block
				{
					scrollYDelta -= (listUnfadedTop - rect.top);
				} // End block
			} // End collapsed parenthetic
			int top;
			top = getChildAt(0).getTop();
			int deltaToTop;
			deltaToTop = top - listUnfadedTop;
			scrollYDelta = Math.max(scrollYDelta, deltaToTop);
		} // End block
		final boolean scroll;
		scroll = scrollYDelta != 0;
		{
			scrollListItemsBy(-scrollYDelta);
			positionSelector(INVALID_POSITION, child);
			mSelectedTop = child.getTop();
			invalidate();
		} // End block
		return dsTaint.getTaintBoolean();
		// ---------- Original Method ----------
		// Original Method Too Long, Refer to Original Implementation
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.041 -0400", hash_original_method = "E78CA340B6692592484560299AF7A587", hash_generated_method = "08260607A3BA11EA45F64F39D38D5418")
	// DSFIXME: CODE0002: Requires DSC value to be set
	@Override
	void fillGap(boolean down) {
		dsTaint.addTaint(down);
		final int count;
		count = getChildCount();
		{
			int paddingTop;
			paddingTop = 0;
			{
				paddingTop = getListPaddingTop();
			} // End block
			int startOffset;
			startOffset = getChildAt(count - 1).getBottom() + mDividerHeight;
			startOffset = paddingTop;
			fillDown(mFirstPosition + count, startOffset);
			correctTooHigh(getChildCount());
		} // End block
		{
			int paddingBottom;
			paddingBottom = 0;
			{
				paddingBottom = getListPaddingBottom();
			} // End block
			int startOffset;
			startOffset = getChildAt(0).getTop() - mDividerHeight;
			startOffset = getHeight() - paddingBottom;
			fillUp(mFirstPosition - 1, startOffset);
			correctTooLow(getChildCount());
		} // End block
			// ---------- Original Method ----------
			// Original Method Too Long, Refer to Original Implementation
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.041 -0400", hash_original_method = "A51DD6537C0400974E1B605AE841C465", hash_generated_method = "F65638D8491BF091E7CB638F4DB2E821")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private View fillDown(int pos, int nextTop) {
		dsTaint.addTaint(nextTop);
		dsTaint.addTaint(pos);
		View selectedView;
		selectedView = null;
		int end;
		end = (mBottom - mTop);
		{
			end -= mListPadding.bottom;
		} // End block
		{
			boolean selected;
			selected = pos == mSelectedPosition;
			View child;
			child = makeAndAddView(pos, nextTop, true, mListPadding.left,
					selected);
			nextTop = child.getBottom() + mDividerHeight;
			{
				selectedView = child;
			} // End block
			pos++;
		} // End block
		return (View) dsTaint.getTaint();
		// ---------- Original Method ----------
		// View selectedView = null;
		// int end = (mBottom - mTop);
		// if ((mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK) {
		// end -= mListPadding.bottom;
		// }
		// while (nextTop < end && pos < mItemCount) {
		// boolean selected = pos == mSelectedPosition;
		// View child = makeAndAddView(pos, nextTop, true, mListPadding.left,
		// selected);
		// nextTop = child.getBottom() + mDividerHeight;
		// if (selected) {
		// selectedView = child;
		// }
		// pos++;
		// }
		// return selectedView;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.041 -0400", hash_original_method = "05C528C2066045A21E9535AE6FF4CD3D", hash_generated_method = "5CAF6CCF4E63E8C5D4C817911D254935")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private View fillUp(int pos, int nextBottom) {
		dsTaint.addTaint(pos);
		dsTaint.addTaint(nextBottom);
		View selectedView;
		selectedView = null;
		int end;
		end = 0;
		{
			end = mListPadding.top;
		} // End block
		{
			boolean selected;
			selected = pos == mSelectedPosition;
			View child;
			child = makeAndAddView(pos, nextBottom, false, mListPadding.left,
					selected);
			nextBottom = child.getTop() - mDividerHeight;
			{
				selectedView = child;
			} // End block
			pos--;
		} // End block
		mFirstPosition = pos + 1;
		return (View) dsTaint.getTaint();
		// ---------- Original Method ----------
		// View selectedView = null;
		// int end = 0;
		// if ((mGroupFlags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK) {
		// end = mListPadding.top;
		// }
		// while (nextBottom > end && pos >= 0) {
		// boolean selected = pos == mSelectedPosition;
		// View child = makeAndAddView(pos, nextBottom, false,
		// mListPadding.left, selected);
		// nextBottom = child.getTop() - mDividerHeight;
		// if (selected) {
		// selectedView = child;
		// }
		// pos--;
		// }
		// mFirstPosition = pos + 1;
		// return selectedView;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.041 -0400", hash_original_method = "E858B13EC4F52DD7B2125F2E9BA15919", hash_generated_method = "FFE7D6D3DFAB57A4664780EE25B259BA")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private View fillFromTop(int nextTop) {
		dsTaint.addTaint(nextTop);
		mFirstPosition = Math.min(mFirstPosition, mSelectedPosition);
		mFirstPosition = Math.min(mFirstPosition, mItemCount - 1);
		{
			mFirstPosition = 0;
		} // End block
		View varBC3312FAE5DAD2D4DA02F3A8FDDCF8D0_1960110493 = (fillDown(
				mFirstPosition, nextTop));
		return (View) dsTaint.getTaint();
		// ---------- Original Method ----------
		// mFirstPosition = Math.min(mFirstPosition, mSelectedPosition);
		// mFirstPosition = Math.min(mFirstPosition, mItemCount - 1);
		// if (mFirstPosition < 0) {
		// mFirstPosition = 0;
		// }
		// return fillDown(mFirstPosition, nextTop);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.042 -0400", hash_original_method = "BB6F12E082A75859BCEF500D953CB8EE", hash_generated_method = "BADD6FD76B94FE45EC6032769F7A1812")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private View fillFromMiddle(int childrenTop, int childrenBottom) {
		dsTaint.addTaint(childrenBottom);
		dsTaint.addTaint(childrenTop);
		int height;
		height = childrenBottom - childrenTop;
		int position;
		position = reconcileSelectedPosition();
		View sel;
		sel = makeAndAddView(position, childrenTop, true, mListPadding.left,
				true);
		mFirstPosition = position;
		int selHeight;
		selHeight = sel.getMeasuredHeight();
		{
			sel.offsetTopAndBottom((height - selHeight) / 2);
		} // End block
		fillAboveAndBelow(sel, position);
		{
			correctTooHigh(getChildCount());
		} // End block
		{
			correctTooLow(getChildCount());
		} // End block
		return (View) dsTaint.getTaint();
		// ---------- Original Method ----------
		// int height = childrenBottom - childrenTop;
		// int position = reconcileSelectedPosition();
		// View sel = makeAndAddView(position, childrenTop, true,
		// mListPadding.left, true);
		// mFirstPosition = position;
		// int selHeight = sel.getMeasuredHeight();
		// if (selHeight <= height) {
		// sel.offsetTopAndBottom((height - selHeight) / 2);
		// }
		// fillAboveAndBelow(sel, position);
		// if (!mStackFromBottom) {
		// correctTooHigh(getChildCount());
		// } else {
		// correctTooLow(getChildCount());
		// }
		// return sel;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.042 -0400", hash_original_method = "E7EAC0AC74052E989A5F3C8A8979A51D", hash_generated_method = "5AA4065E34FB6E04D2951C1D43B92324")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private void fillAboveAndBelow(View sel, int position) {
		dsTaint.addTaint(position);
		dsTaint.addTaint(sel.dsTaint);
		final int dividerHeight;
		dividerHeight = mDividerHeight;
		{
			fillUp(position - 1, sel.getTop() - dividerHeight);
			adjustViewsUpOrDown();
			fillDown(position + 1, sel.getBottom() + dividerHeight);
		} // End block
		{
			fillDown(position + 1, sel.getBottom() + dividerHeight);
			adjustViewsUpOrDown();
			fillUp(position - 1, sel.getTop() - dividerHeight);
		} // End block
			// ---------- Original Method ----------
			// final int dividerHeight = mDividerHeight;
			// if (!mStackFromBottom) {
			// fillUp(position - 1, sel.getTop() - dividerHeight);
			// adjustViewsUpOrDown();
			// fillDown(position + 1, sel.getBottom() + dividerHeight);
		// } else {
		// fillDown(position + 1, sel.getBottom() + dividerHeight);
		// adjustViewsUpOrDown();
		// fillUp(position - 1, sel.getTop() - dividerHeight);
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.042 -0400", hash_original_method = "439BAC8174DEF92DB2EFE731B080B752", hash_generated_method = "6257B72A9D7E679ACA897668A7A3EC1E")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private View fillFromSelection(int selectedTop, int childrenTop,
			int childrenBottom) {
		dsTaint.addTaint(childrenBottom);
		dsTaint.addTaint(childrenTop);
		dsTaint.addTaint(selectedTop);
		int fadingEdgeLength;
		fadingEdgeLength = getVerticalFadingEdgeLength();
		final int selectedPosition;
		selectedPosition = mSelectedPosition;
		View sel;
		final int topSelectionPixel;
		topSelectionPixel = getTopSelectionPixel(childrenTop, fadingEdgeLength,
				selectedPosition);
		final int bottomSelectionPixel;
		bottomSelectionPixel = getBottomSelectionPixel(childrenBottom,
				fadingEdgeLength, selectedPosition);
		sel = makeAndAddView(selectedPosition, selectedTop, true,
				mListPadding.left, true);
		{
			boolean varBFC41726DC719E4AF23B91CEB6FCBE3E_898021140 = (sel
					.getBottom() > bottomSelectionPixel);
			{
				final int spaceAbove;
				spaceAbove = sel.getTop() - topSelectionPixel;
				final int spaceBelow;
				spaceBelow = sel.getBottom() - bottomSelectionPixel;
				final int offset;
				offset = Math.min(spaceAbove, spaceBelow);
				sel.offsetTopAndBottom(-offset);
			} // End block
			{
				boolean var14C65EDD6D5526A3271EC007E995AA33_1087825664 = (sel
						.getTop() < topSelectionPixel);
				{
					final int spaceAbove;
					spaceAbove = topSelectionPixel - sel.getTop();
					final int spaceBelow;
					spaceBelow = bottomSelectionPixel - sel.getBottom();
					final int offset;
					offset = Math.min(spaceAbove, spaceBelow);
					sel.offsetTopAndBottom(offset);
				} // End block
			} // End collapsed parenthetic
		} // End collapsed parenthetic
		fillAboveAndBelow(sel, selectedPosition);
		{
			correctTooHigh(getChildCount());
		} // End block
		{
			correctTooLow(getChildCount());
		} // End block
		return (View) dsTaint.getTaint();
		// ---------- Original Method ----------
		// Original Method Too Long, Refer to Original Implementation
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.042 -0400", hash_original_method = "DDE472821830C07DE1368C905BA02EE1", hash_generated_method = "E9C079B7D6CD5018275B312449FAB0EA")
	@DSModeled(DSC.SAFE)
	private int getBottomSelectionPixel(int childrenBottom,
			int fadingEdgeLength, int selectedPosition) {
		dsTaint.addTaint(childrenBottom);
		dsTaint.addTaint(fadingEdgeLength);
		dsTaint.addTaint(selectedPosition);
		int bottomSelectionPixel;
		bottomSelectionPixel = childrenBottom;
		{
			bottomSelectionPixel -= fadingEdgeLength;
		} // End block
		return dsTaint.getTaintInt();
		// ---------- Original Method ----------
		// int bottomSelectionPixel = childrenBottom;
		// if (selectedPosition != mItemCount - 1) {
		// bottomSelectionPixel -= fadingEdgeLength;
		// }
		// return bottomSelectionPixel;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.042 -0400", hash_original_method = "173BB2BFF18272B67A930A02164FEB0F", hash_generated_method = "AF8F9E27E45037D940280DA9A733EA5A")
	@DSModeled(DSC.SAFE)
	private int getTopSelectionPixel(int childrenTop, int fadingEdgeLength,
			int selectedPosition) {
		dsTaint.addTaint(childrenTop);
		dsTaint.addTaint(fadingEdgeLength);
		dsTaint.addTaint(selectedPosition);
		int topSelectionPixel;
		topSelectionPixel = childrenTop;
		{
			topSelectionPixel += fadingEdgeLength;
		} // End block
		return dsTaint.getTaintInt();
		// ---------- Original Method ----------
		// int topSelectionPixel = childrenTop;
		// if (selectedPosition > 0) {
		// topSelectionPixel += fadingEdgeLength;
		// }
		// return topSelectionPixel;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.042 -0400", hash_original_method = "19B54E9E42F50C19B80602093C26BC32", hash_generated_method = "D109026B08F0F14050BEA0F78931D1C6")
	@DSModeled(DSC.SAFE)
	@android.view.RemotableViewMethod
	public void smoothScrollToPosition(int position) {
		dsTaint.addTaint(position);
		super.smoothScrollToPosition(position);
		// ---------- Original Method ----------
		// super.smoothScrollToPosition(position);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.042 -0400", hash_original_method = "9A2E566018459C8A4F9FE2F49DBB98B8", hash_generated_method = "D4BDF357776EAEFB5B1DDE3E23278DAE")
	@DSModeled(DSC.SAFE)
	@android.view.RemotableViewMethod
	public void smoothScrollByOffset(int offset) {
		dsTaint.addTaint(offset);
		super.smoothScrollByOffset(offset);
		// ---------- Original Method ----------
		// super.smoothScrollByOffset(offset);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.043 -0400", hash_original_method = "A6BE2578E6D412634113B39CFD73986F", hash_generated_method = "498EDDF5CFAF7D6E1806EF9E5B93CA26")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private View moveSelection(View oldSel, View newSel, int delta,
			int childrenTop, int childrenBottom) {
		dsTaint.addTaint(delta);
		dsTaint.addTaint(oldSel.dsTaint);
		dsTaint.addTaint(childrenBottom);
		dsTaint.addTaint(childrenTop);
		dsTaint.addTaint(newSel.dsTaint);
		int fadingEdgeLength;
		fadingEdgeLength = getVerticalFadingEdgeLength();
		final int selectedPosition;
		selectedPosition = mSelectedPosition;
		View sel;
		final int topSelectionPixel;
		topSelectionPixel = getTopSelectionPixel(childrenTop, fadingEdgeLength,
				selectedPosition);
		final int bottomSelectionPixel;
		bottomSelectionPixel = getBottomSelectionPixel(childrenTop,
				fadingEdgeLength, selectedPosition);
		{
			oldSel = makeAndAddView(selectedPosition - 1, oldSel.getTop(),
					true, mListPadding.left, false);
			final int dividerHeight;
			dividerHeight = mDividerHeight;
			sel = makeAndAddView(selectedPosition, oldSel.getBottom()
					+ dividerHeight, true, mListPadding.left, true);
			{
				boolean var809044946283DBF63F29397A5670A6D0_1319842570 = (sel
						.getBottom() > bottomSelectionPixel);
				{
					int spaceAbove;
					spaceAbove = sel.getTop() - topSelectionPixel;
					int spaceBelow;
					spaceBelow = sel.getBottom() - bottomSelectionPixel;
					int halfVerticalSpace;
					halfVerticalSpace = (childrenBottom - childrenTop) / 2;
					int offset;
					offset = Math.min(spaceAbove, spaceBelow);
					offset = Math.min(offset, halfVerticalSpace);
					oldSel.offsetTopAndBottom(-offset);
					sel.offsetTopAndBottom(-offset);
				} // End block
			} // End collapsed parenthetic
			{
				fillUp(mSelectedPosition - 2, sel.getTop() - dividerHeight);
				adjustViewsUpOrDown();
				fillDown(mSelectedPosition + 1, sel.getBottom() + dividerHeight);
			} // End block
			{
				fillDown(mSelectedPosition + 1, sel.getBottom() + dividerHeight);
				adjustViewsUpOrDown();
				fillUp(mSelectedPosition - 2, sel.getTop() - dividerHeight);
			} // End block
		} // End block
		{
			{
				sel = makeAndAddView(selectedPosition, newSel.getTop(), true,
						mListPadding.left, true);
			} // End block
			{
				sel = makeAndAddView(selectedPosition, oldSel.getTop(), false,
						mListPadding.left, true);
			} // End block
			{
				boolean var14C65EDD6D5526A3271EC007E995AA33_719601420 = (sel
						.getTop() < topSelectionPixel);
				{
					int spaceAbove;
					spaceAbove = topSelectionPixel - sel.getTop();
					int spaceBelow;
					spaceBelow = bottomSelectionPixel - sel.getBottom();
					int halfVerticalSpace;
					halfVerticalSpace = (childrenBottom - childrenTop) / 2;
					int offset;
					offset = Math.min(spaceAbove, spaceBelow);
					offset = Math.min(offset, halfVerticalSpace);
					sel.offsetTopAndBottom(offset);
				} // End block
			} // End collapsed parenthetic
			fillAboveAndBelow(sel, selectedPosition);
		} // End block
		{
			int oldTop;
			oldTop = oldSel.getTop();
			sel = makeAndAddView(selectedPosition, oldTop, true,
					mListPadding.left, true);
			{
				int newBottom;
				newBottom = sel.getBottom();
				{
					sel.offsetTopAndBottom(childrenTop - sel.getTop());
				} // End block
			} // End block
			fillAboveAndBelow(sel, selectedPosition);
		} // End block
		return (View) dsTaint.getTaint();
		// ---------- Original Method ----------
		// Original Method Too Long, Refer to Original Implementation
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.043 -0400", hash_original_method = "CB33E140CB7C8CB590395A9B1EF6CC8D", hash_generated_method = "FE3A6BC7897C01E80C8153897C365E79")
	// DSFIXME: CODE0002: Requires DSC value to be set
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		// DSFIXME: CODE0009: Possible callback target function detected
		dsTaint.addTaint(w);
		dsTaint.addTaint(oldw);
		dsTaint.addTaint(oldh);
		dsTaint.addTaint(h);
		{
			boolean varBF62E6C23FE36C17A3594E034FF46D2E_988543401 = (getChildCount() > 0);
			{
				View focusedChild;
				focusedChild = getFocusedChild();
				{
					final int childPosition;
					childPosition = mFirstPosition + indexOfChild(focusedChild);
					final int childBottom;
					childBottom = focusedChild.getBottom();
					final int offset;
					offset = Math.max(0, childBottom - (h - mPaddingTop));
					final int top;
					top = focusedChild.getTop() - offset;
					{
						mFocusSelector = new FocusSelector();
					} // End block
					post(mFocusSelector.setup(childPosition, top));
				} // End block
			} // End block
		} // End collapsed parenthetic
		super.onSizeChanged(w, h, oldw, oldh);
		// ---------- Original Method ----------
		// if (getChildCount() > 0) {
		// View focusedChild = getFocusedChild();
		// if (focusedChild != null) {
		// final int childPosition = mFirstPosition +
		// indexOfChild(focusedChild);
		// final int childBottom = focusedChild.getBottom();
		// final int offset = Math.max(0, childBottom - (h - mPaddingTop));
		// final int top = focusedChild.getTop() - offset;
		// if (mFocusSelector == null) {
		// mFocusSelector = new FocusSelector();
		// }
		// post(mFocusSelector.setup(childPosition, top));
		// }
		// }
		// super.onSizeChanged(w, h, oldw, oldh);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.044 -0400", hash_original_method = "593EBCA8FD80357C209889704061F804", hash_generated_method = "4AB97FC86AB83FB5E5EC4C85CC4941E1")
	// DSFIXME: CODE0002: Requires DSC value to be set
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// DSFIXME: CODE0009: Possible callback target function detected
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
		int childWidth;
		childWidth = 0;
		int childHeight;
		childHeight = 0;
		int childState;
		childState = 0;
		mItemCount = mAdapter == null ? 0 : mAdapter.getCount();
		{
			final View child;
			child = obtainView(0, mIsScrap);
			measureScrapChild(child, 0, widthMeasureSpec);
			childWidth = child.getMeasuredWidth();
			childHeight = child.getMeasuredHeight();
			childState = combineMeasuredStates(childState,
					child.getMeasuredState());
			{
				boolean varEB7649CB6D51B846BFB1D35E91D4E330_109676319 = (recycleOnMeasure() && mRecycler
						.shouldRecycleViewType(((LayoutParams) child
								.getLayoutParams()).viewType));
				{
					mRecycler.addScrapView(child, -1);
				} // End block
			} // End collapsed parenthetic
		} // End block
		{
			widthSize = mListPadding.left + mListPadding.right + childWidth
					+ getVerticalScrollbarWidth();
		} // End block
		{
			widthSize |= (childState & MEASURED_STATE_MASK);
		} // End block
		{
			heightSize = mListPadding.top + mListPadding.bottom + childHeight
					+ getVerticalFadingEdgeLength() * 2;
		} // End block
		{
			heightSize = measureHeightOfChildren(widthMeasureSpec, 0,
					NO_POSITION, heightSize, -1);
		} // End block
		setMeasuredDimension(widthSize, heightSize);
		mWidthMeasureSpec = widthMeasureSpec;
		// ---------- Original Method ----------
		// Original Method Too Long, Refer to Original Implementation
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.044 -0400", hash_original_method = "F21C4EE74005F045F306FF7685001DDA", hash_generated_method = "ED653619D986F85D05D5EBE69893DFCC")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private void measureScrapChild(View child, int position,
			int widthMeasureSpec) {
		dsTaint.addTaint(child.dsTaint);
		dsTaint.addTaint(position);
		dsTaint.addTaint(widthMeasureSpec);
		LayoutParams p;
		p = (LayoutParams) child.getLayoutParams();
		{
			p = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
					ViewGroup.LayoutParams.WRAP_CONTENT, 0);
			child.setLayoutParams(p);
		} // End block
		p.viewType = mAdapter.getItemViewType(position);
		p.forceAdd = true;
		int childWidthSpec;
		childWidthSpec = ViewGroup.getChildMeasureSpec(widthMeasureSpec,
				mListPadding.left + mListPadding.right, p.width);
		int lpHeight;
		lpHeight = p.height;
		int childHeightSpec;
		{
			childHeightSpec = MeasureSpec.makeMeasureSpec(lpHeight,
					MeasureSpec.EXACTLY);
		} // End block
		{
			childHeightSpec = MeasureSpec.makeMeasureSpec(0,
					MeasureSpec.UNSPECIFIED);
		} // End block
		child.measure(childWidthSpec, childHeightSpec);
		// ---------- Original Method ----------
		// Original Method Too Long, Refer to Original Implementation
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.044 -0400", hash_original_method = "8F0B08D4426D8F4F23EF014B56CDCFE6", hash_generated_method = "0961EC3EC195E9BC9294CDEC01FB7099")
	@DSModeled(DSC.SAFE)
	@ViewDebug.ExportedProperty(category = "list")
	protected boolean recycleOnMeasure() {
		return dsTaint.getTaintBoolean();
		// ---------- Original Method ----------
		// return true;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.044 -0400", hash_original_method = "4E8DF0CF85AB0B6CF8E1C94B60E67D20", hash_generated_method = "06E4B3EFD9BEDF72E0F35AEFB9599A19")
	// DSFIXME: CODE0002: Requires DSC value to be set
	final int measureHeightOfChildren(int widthMeasureSpec, int startPosition,
			int endPosition, final int maxHeight,
			int disallowPartialChildPosition) {
		dsTaint.addTaint(disallowPartialChildPosition);
		dsTaint.addTaint(maxHeight);
		dsTaint.addTaint(widthMeasureSpec);
		dsTaint.addTaint(endPosition);
		dsTaint.addTaint(startPosition);
		final ListAdapter adapter;
		adapter = mAdapter;
		int returnedHeight;
		returnedHeight = mListPadding.top + mListPadding.bottom;
		int dividerHeight;
		dividerHeight = mDividerHeight;
		dividerHeight = 0;
		int prevHeightWithoutPartialChild;
		prevHeightWithoutPartialChild = 0;
		int i;
		View child;
		endPosition = (endPosition == NO_POSITION) ? adapter.getCount() - 1
				: endPosition;
		final AbsListView.RecycleBin recycleBin;
		recycleBin = mRecycler;
		final boolean recyle;
		recyle = recycleOnMeasure();
		final boolean[] isScrap;
		isScrap = mIsScrap;
		{
			i = startPosition;
			{
				child = obtainView(i, isScrap);
				measureScrapChild(child, i, widthMeasureSpec);
				{
					returnedHeight += dividerHeight;
				} // End block
				{
					boolean var533FFAA3904216431C0F5E425FC7EAF1_1842765288 = (recyle && recycleBin
							.shouldRecycleViewType(((LayoutParams) child
									.getLayoutParams()).viewType));
					{
						recycleBin.addScrapView(child, -1);
					} // End block
				} // End collapsed parenthetic
				returnedHeight += child.getMeasuredHeight();
				{
					prevHeightWithoutPartialChild = returnedHeight;
				} // End block
			} // End block
		} // End collapsed parenthetic
		return dsTaint.getTaintInt();
		// ---------- Original Method ----------
		// Original Method Too Long, Refer to Original Implementation
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.044 -0400", hash_original_method = "79128C90442A789B94FF9502F8C045C1", hash_generated_method = "72890CFD7DA5B87FAC7396698ABB06F2")
	// DSFIXME: CODE0002: Requires DSC value to be set
	@Override
	int findMotionRow(int y) {
		// DSFIXME: CODE0009: Possible callback target function detected
		dsTaint.addTaint(y);
		int childCount;
		childCount = getChildCount();
		{
			{
				{
					int i;
					i = 0;
					{
						View v;
						v = getChildAt(i);
						{
							boolean var737FD9EF3BFA62490E57511E301591D9_1102472858 = (y <= v
									.getBottom());
						} // End collapsed parenthetic
					} // End block
				} // End collapsed parenthetic
			} // End block
			{
				{
					int i;
					i = childCount - 1;
					{
						View v;
						v = getChildAt(i);
						{
							boolean varE7C2FBE8C17E6A36CCD2B0AC678BC146_869199421 = (y >= v
									.getTop());
						} // End collapsed parenthetic
					} // End block
				} // End collapsed parenthetic
			} // End block
		} // End block
		return dsTaint.getTaintInt();
		// ---------- Original Method ----------
		// int childCount = getChildCount();
		// if (childCount > 0) {
		// if (!mStackFromBottom) {
		// for (int i = 0; i < childCount; i++) {
		// View v = getChildAt(i);
		// if (y <= v.getBottom()) {
		// return mFirstPosition + i;
		// }
		// }
		// } else {
		// for (int i = childCount - 1; i >= 0; i--) {
		// View v = getChildAt(i);
		// if (y >= v.getTop()) {
		// return mFirstPosition + i;
		// }
		// }
		// }
		// }
		// return INVALID_POSITION;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.045 -0400", hash_original_method = "C0E9548D6FEBBB39DCAB5DD502EC06AD", hash_generated_method = "1ED3EAD90ABF6BEE420954309EA13272")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private View fillSpecific(int position, int top) {
		dsTaint.addTaint(position);
		dsTaint.addTaint(top);
		boolean tempIsSelected;
		tempIsSelected = position == mSelectedPosition;
		View temp;
		temp = makeAndAddView(position, top, true, mListPadding.left,
				tempIsSelected);
		mFirstPosition = position;
		View above;
		View below;
		final int dividerHeight;
		dividerHeight = mDividerHeight;
		{
			above = fillUp(position - 1, temp.getTop() - dividerHeight);
			adjustViewsUpOrDown();
			below = fillDown(position + 1, temp.getBottom() + dividerHeight);
			int childCount;
			childCount = getChildCount();
			{
				correctTooHigh(childCount);
			} // End block
		} // End block
		{
			below = fillDown(position + 1, temp.getBottom() + dividerHeight);
			adjustViewsUpOrDown();
			above = fillUp(position - 1, temp.getTop() - dividerHeight);
			int childCount;
			childCount = getChildCount();
			{
				correctTooLow(childCount);
			} // End block
		} // End block
		return (View) dsTaint.getTaint();
		// ---------- Original Method ----------
		// Original Method Too Long, Refer to Original Implementation
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.045 -0400", hash_original_method = "C65533A90B04CD548C8B98EAAB2119A6", hash_generated_method = "ECE7F23AF6C46A84B3D55A5CBA911B7C")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private void correctTooHigh(int childCount) {
		dsTaint.addTaint(childCount);
		int lastPosition;
		lastPosition = mFirstPosition + childCount - 1;
		{
			final View lastChild;
			lastChild = getChildAt(childCount - 1);
			final int lastBottom;
			lastBottom = lastChild.getBottom();
			final int end;
			end = (mBottom - mTop) - mListPadding.bottom;
			int bottomOffset;
			bottomOffset = end - lastBottom;
			View firstChild;
			firstChild = getChildAt(0);
			final int firstTop;
			firstTop = firstChild.getTop();
			{
				{
					bottomOffset = Math.min(bottomOffset, mListPadding.top
							- firstTop);
				} // End block
				offsetChildrenTopAndBottom(bottomOffset);
				{
					fillUp(mFirstPosition - 1, firstChild.getTop()
							- mDividerHeight);
					adjustViewsUpOrDown();
				} // End block
			} // End block
		} // End block
			// ---------- Original Method ----------
			// Original Method Too Long, Refer to Original Implementation
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.045 -0400", hash_original_method = "D798F76D04F235C59E38C4C924A6B5C2", hash_generated_method = "9940802A0B96809D015B91D970C9EAA4")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private void correctTooLow(int childCount) {
		dsTaint.addTaint(childCount);
		{
			final View firstChild;
			firstChild = getChildAt(0);
			final int firstTop;
			firstTop = firstChild.getTop();
			final int start;
			start = mListPadding.top;
			final int end;
			end = (mBottom - mTop) - mListPadding.bottom;
			int topOffset;
			topOffset = firstTop - start;
			View lastChild;
			lastChild = getChildAt(childCount - 1);
			final int lastBottom;
			lastBottom = lastChild.getBottom();
			int lastPosition;
			lastPosition = mFirstPosition + childCount - 1;
			{
				{
					{
						topOffset = Math.min(topOffset, lastBottom - end);
					} // End block
					offsetChildrenTopAndBottom(-topOffset);
					{
						fillDown(lastPosition + 1, lastChild.getBottom()
								+ mDividerHeight);
						adjustViewsUpOrDown();
					} // End block
				} // End block
				{
					adjustViewsUpOrDown();
				} // End block
			} // End block
		} // End block
			// ---------- Original Method ----------
			// Original Method Too Long, Refer to Original Implementation
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.046 -0400", hash_original_method = "9877500E639FE4AE4AB75D2F74BF2E4E", hash_generated_method = "4386FF1B4BDC0718FC428F7C9206989C")
	// DSFIXME: CODE0002: Requires DSC value to be set
	@Override
	protected void layoutChildren() {
		final boolean blockLayoutRequests;
		blockLayoutRequests = mBlockLayoutRequests;
		{
			mBlockLayoutRequests = true;
		} // End block
		try {
			super.layoutChildren();
			invalidate();
			{
				resetList();
				invokeOnItemScrollListener();
			} // End block
			int childrenTop;
			childrenTop = mListPadding.top;
			int childrenBottom;
			childrenBottom = mBottom - mTop - mListPadding.bottom;
			int childCount;
			childCount = getChildCount();
			int index;
			index = 0;
			int delta;
			delta = 0;
			View sel;
			View oldSel;
			oldSel = null;
			View oldFirst;
			oldFirst = null;
			View newSel;
			newSel = null;
			View focusLayoutRestoreView;
			focusLayoutRestoreView = null;
			// Begin case LAYOUT_SET_SELECTION
			index = mNextSelectedPosition - mFirstPosition;
			// End case LAYOUT_SET_SELECTION
			// Begin case LAYOUT_SET_SELECTION
			{
				newSel = getChildAt(index);
			} // End block
				// End case LAYOUT_SET_SELECTION
				// Begin case LAYOUT_MOVE_SELECTION default
			index = mSelectedPosition - mFirstPosition;
			// End case LAYOUT_MOVE_SELECTION default
			// Begin case LAYOUT_MOVE_SELECTION default
			{
				oldSel = getChildAt(index);
			} // End block
				// End case LAYOUT_MOVE_SELECTION default
				// Begin case LAYOUT_MOVE_SELECTION default
			oldFirst = getChildAt(0);
			// End case LAYOUT_MOVE_SELECTION default
			// Begin case LAYOUT_MOVE_SELECTION default
			{
				delta = mNextSelectedPosition - mSelectedPosition;
			} // End block
				// End case LAYOUT_MOVE_SELECTION default
				// Begin case LAYOUT_MOVE_SELECTION default
			newSel = getChildAt(index + delta);
			// End case LAYOUT_MOVE_SELECTION default
			boolean dataChanged;
			dataChanged = mDataChanged;
			{
				handleDataChanged();
			} // End block
			{
				resetList();
				invokeOnItemScrollListener();
			} // End block
			{
				boolean varA298A0CB79AEDD2E132E7DADF2F1B74D_1348409580 = (mItemCount != mAdapter
						.getCount());
				{
					if (DroidSafeAndroidRuntime.control)
						throw new IllegalStateException(
								"The content of the adapter has changed but "
										+ "ListView did not receive a notification. Make sure the content of "
										+ "your adapter is not modified from a background thread, but only "
										+ "from the UI thread. [in ListView("
										+ getId() + ", " + getClass()
										+ ") with Adapter("
										+ mAdapter.getClass() + ")]");
				} // End block
			} // End collapsed parenthetic
			setSelectedPositionInt(mNextSelectedPosition);
			final int firstPosition;
			firstPosition = mFirstPosition;
			final RecycleBin recycleBin;
			recycleBin = mRecycler;
			View focusLayoutRestoreDirectChild;
			focusLayoutRestoreDirectChild = null;
			{
				{
					int i;
					i = 0;
					{
						recycleBin.addScrapView(getChildAt(i), firstPosition
								+ i);
						{
							ViewDebug
									.trace(getChildAt(i),
											ViewDebug.RecyclerTraceType.MOVE_TO_SCRAP_HEAP,
											index, i);
						} // End block
					} // End block
				} // End collapsed parenthetic
			} // End block
			{
				recycleBin.fillActiveViews(childCount, firstPosition);
			} // End block
			final View focusedChild;
			focusedChild = getFocusedChild();
			{
				{
					boolean varE616BE978FFFDD1A37C1939042B395B1_334044100 = (!dataChanged || isDirectChildHeaderOrFooter(focusedChild));
					{
						focusLayoutRestoreDirectChild = focusedChild;
						focusLayoutRestoreView = findFocus();
						{
							focusLayoutRestoreView.onStartTemporaryDetach();
						} // End block
					} // End block
				} // End collapsed parenthetic
				requestFocus();
			} // End block
			detachAllViewsFromParent();
			// Begin case LAYOUT_SET_SELECTION
			{
				sel = fillFromSelection(newSel.getTop(), childrenTop,
						childrenBottom);
			} // End block
			{
				sel = fillFromMiddle(childrenTop, childrenBottom);
			} // End block
				// End case LAYOUT_SET_SELECTION
				// Begin case LAYOUT_SYNC
			sel = fillSpecific(mSyncPosition, mSpecificTop);
			// End case LAYOUT_SYNC
			// Begin case LAYOUT_FORCE_BOTTOM
			sel = fillUp(mItemCount - 1, childrenBottom);
			// End case LAYOUT_FORCE_BOTTOM
			// Begin case LAYOUT_FORCE_BOTTOM
			adjustViewsUpOrDown();
			// End case LAYOUT_FORCE_BOTTOM
			// Begin case LAYOUT_FORCE_TOP
			mFirstPosition = 0;
			// End case LAYOUT_FORCE_TOP
			// Begin case LAYOUT_FORCE_TOP
			sel = fillFromTop(childrenTop);
			// End case LAYOUT_FORCE_TOP
			// Begin case LAYOUT_FORCE_TOP
			adjustViewsUpOrDown();
			// End case LAYOUT_FORCE_TOP
			// Begin case LAYOUT_SPECIFIC
			sel = fillSpecific(reconcileSelectedPosition(), mSpecificTop);
			// End case LAYOUT_SPECIFIC
			// Begin case LAYOUT_MOVE_SELECTION
			sel = moveSelection(oldSel, newSel, delta, childrenTop,
					childrenBottom);
			// End case LAYOUT_MOVE_SELECTION
			// Begin case default
			{
				{
					final int position;
					position = lookForSelectablePosition(0, true);
					setSelectedPositionInt(position);
					sel = fillFromTop(childrenTop);
				} // End block
				{
					final int position;
					position = lookForSelectablePosition(mItemCount - 1, false);
					setSelectedPositionInt(position);
					sel = fillUp(mItemCount - 1, childrenBottom);
				} // End block
			} // End block
			{
				{
					sel = fillSpecific(mSelectedPosition,
							oldSel == null ? childrenTop : oldSel.getTop());
				} // End block
				{
					sel = fillSpecific(mFirstPosition,
							oldFirst == null ? childrenTop : oldFirst.getTop());
				} // End block
				{
					sel = fillSpecific(0, childrenTop);
				} // End block
			} // End block
				// End case default
			recycleBin.scrapActiveViews();
			{
				{
					boolean var9085EE91A28170DA4ACA96D9BF477D88_313196392 = (mItemsCanFocus
							&& hasFocus() && !sel.hasFocus());
					{
						final boolean focusWasTaken;
						focusWasTaken = (sel == focusLayoutRestoreDirectChild && focusLayoutRestoreView
								.requestFocus()) || sel.requestFocus();
						{
							final View focused;
							focused = getFocusedChild();
							{
								focused.clearFocus();
							} // End block
							positionSelector(INVALID_POSITION, sel);
						} // End block
						{
							sel.setSelected(false);
							mSelectorRect.setEmpty();
						} // End block
					} // End block
					{
						positionSelector(INVALID_POSITION, sel);
					} // End block
				} // End collapsed parenthetic
				mSelectedTop = sel.getTop();
			} // End block
			{
				{
					View child;
					child = getChildAt(mMotionPosition - mFirstPosition);
					positionSelector(mMotionPosition, child);
				} // End block
				{
					mSelectedTop = 0;
					mSelectorRect.setEmpty();
				} // End block
				{
					boolean var3353F8886B6D2D3385EBD44764EEC6B6_1713786889 = (hasFocus() && focusLayoutRestoreView != null);
					{
						focusLayoutRestoreView.requestFocus();
					} // End block
				} // End collapsed parenthetic
			} // End block
			{
				boolean var371628C1F86A56F688D98D9EF6B87E07_252783079 = (focusLayoutRestoreView != null && focusLayoutRestoreView
						.getWindowToken() != null);
				{
					focusLayoutRestoreView.onFinishTemporaryDetach();
				} // End block
			} // End collapsed parenthetic
			mLayoutMode = LAYOUT_NORMAL;
			mDataChanged = false;
			mNeedSync = false;
			setNextSelectedPositionInt(mSelectedPosition);
			updateScrollIndicators();
			{
				checkSelectionChanged();
			} // End block
			invokeOnItemScrollListener();
		} // End block
		finally {
			{
				mBlockLayoutRequests = false;
			} // End block
		} // End block
			// ---------- Original Method ----------
			// Original Method Too Long, Refer to Original Implementation
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.047 -0400", hash_original_method = "1975AA11D0AB4A92B498BEF09326AA69", hash_generated_method = "CE63D4DE6DB37D9E5056E9BDA449A2EF")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private boolean isDirectChildHeaderOrFooter(View child) {
		dsTaint.addTaint(child.dsTaint);
		final ArrayList<FixedViewInfo> headers;
		headers = mHeaderViewInfos;
		final int numHeaders;
		numHeaders = headers.size();
		{
			int i;
			i = 0;
			{
				{
					boolean var2E97F2DD1ECC5E322C5090F5951EC49E_256530202 = (child == headers
							.get(i).view);
				} // End collapsed parenthetic
			} // End block
		} // End collapsed parenthetic
		final ArrayList<FixedViewInfo> footers;
		footers = mFooterViewInfos;
		final int numFooters;
		numFooters = footers.size();
		{
			int i;
			i = 0;
			{
				{
					boolean varA845DE916470E49791E6F275395553FA_1125362397 = (child == footers
							.get(i).view);
				} // End collapsed parenthetic
			} // End block
		} // End collapsed parenthetic
		return dsTaint.getTaintBoolean();
		// ---------- Original Method ----------
		// final ArrayList<FixedViewInfo> headers = mHeaderViewInfos;
		// final int numHeaders = headers.size();
		// for (int i = 0; i < numHeaders; i++) {
		// if (child == headers.get(i).view) {
		// return true;
		// }
		// }
		// final ArrayList<FixedViewInfo> footers = mFooterViewInfos;
		// final int numFooters = footers.size();
		// for (int i = 0; i < numFooters; i++) {
		// if (child == footers.get(i).view) {
		// return true;
		// }
		// }
		// return false;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.047 -0400", hash_original_method = "EAF848DCFCD435D3CED323F008D83518", hash_generated_method = "1E3627E9379C7F367A577EE90FB11C1C")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private View makeAndAddView(int position, int y, boolean flow,
			int childrenLeft, boolean selected) {
		dsTaint.addTaint(position);
		dsTaint.addTaint(selected);
		dsTaint.addTaint(childrenLeft);
		dsTaint.addTaint(flow);
		dsTaint.addTaint(y);
		View child;
		{
			child = mRecycler.getActiveView(position);
			{
				{
					ViewDebug
							.trace(child,
									ViewDebug.RecyclerTraceType.RECYCLE_FROM_ACTIVE_HEAP,
									position, getChildCount());
				} // End block
				setupChild(child, position, y, flow, childrenLeft, selected,
						true);
			} // End block
		} // End block
		child = obtainView(position, mIsScrap);
		setupChild(child, position, y, flow, childrenLeft, selected,
				mIsScrap[0]);
		return (View) dsTaint.getTaint();
		// ---------- Original Method ----------
		// View child;
		// if (!mDataChanged) {
		// child = mRecycler.getActiveView(position);
		// if (child != null) {
		// if (ViewDebug.TRACE_RECYCLER) {
		// ViewDebug.trace(child,
		// ViewDebug.RecyclerTraceType.RECYCLE_FROM_ACTIVE_HEAP,
		// position, getChildCount());
		// }
		// setupChild(child, position, y, flow, childrenLeft, selected, true);
		// return child;
		// }
		// }
		// child = obtainView(position, mIsScrap);
		// setupChild(child, position, y, flow, childrenLeft, selected,
		// mIsScrap[0]);
		// return child;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.048 -0400", hash_original_method = "06B6C56B5992091F7319E58A5C4AE35A", hash_generated_method = "A0F1160550319C2B5D992DCB15FB6633")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private void setupChild(View child, int position, int y, boolean flowDown,
			int childrenLeft, boolean selected, boolean recycled) {
		dsTaint.addTaint(child.dsTaint);
		dsTaint.addTaint(position);
		dsTaint.addTaint(selected);
		dsTaint.addTaint(recycled);
		dsTaint.addTaint(childrenLeft);
		dsTaint.addTaint(flowDown);
		dsTaint.addTaint(y);
		final boolean isSelected;
		isSelected = selected && shouldShowSelector();
		final boolean updateChildSelected;
		updateChildSelected = isSelected != child.isSelected();
		final int mode;
		mode = mTouchMode;
		final boolean isPressed;
		isPressed = mode > TOUCH_MODE_DOWN && mode < TOUCH_MODE_SCROLL
				&& mMotionPosition == position;
		final boolean updateChildPressed;
		updateChildPressed = isPressed != child.isPressed();
		final boolean needToMeasure;
		needToMeasure = !recycled || updateChildSelected
				|| child.isLayoutRequested();
		AbsListView.LayoutParams p;
		p = (AbsListView.LayoutParams) child.getLayoutParams();
		{
			p = new AbsListView.LayoutParams(
					ViewGroup.LayoutParams.MATCH_PARENT,
					ViewGroup.LayoutParams.WRAP_CONTENT, 0);
		} // End block
		p.viewType = mAdapter.getItemViewType(position);
		{
			attachViewToParent(child, flowDown ? -1 : 0, p);
		} // End block
		{
			p.forceAdd = false;
			{
				p.recycledHeaderFooter = true;
			} // End block
			addViewInLayout(child, flowDown ? -1 : 0, p, true);
		} // End block
		{
			child.setSelected(isSelected);
		} // End block
		{
			child.setPressed(isPressed);
		} // End block
		{
			{
				((Checkable) child).setChecked(mCheckStates.get(position));
			} // End block
			{
				boolean var6B8ECFCCB35D70022AE775423EF95EFF_651106050 = (getContext()
						.getApplicationInfo().targetSdkVersion >= android.os.Build.VERSION_CODES.HONEYCOMB);
				{
					child.setActivated(mCheckStates.get(position));
				} // End block
			} // End collapsed parenthetic
		} // End block
		{
			int childWidthSpec;
			childWidthSpec = ViewGroup.getChildMeasureSpec(mWidthMeasureSpec,
					mListPadding.left + mListPadding.right, p.width);
			int lpHeight;
			lpHeight = p.height;
			int childHeightSpec;
			{
				childHeightSpec = MeasureSpec.makeMeasureSpec(lpHeight,
						MeasureSpec.EXACTLY);
			} // End block
			{
				childHeightSpec = MeasureSpec.makeMeasureSpec(0,
						MeasureSpec.UNSPECIFIED);
			} // End block
			child.measure(childWidthSpec, childHeightSpec);
		} // End block
		{
			cleanupLayoutState(child);
		} // End block
		final int w;
		w = child.getMeasuredWidth();
		final int h;
		h = child.getMeasuredHeight();
		int childTop;
		childTop = y;
		childTop = y - h;
		{
			final int childRight;
			childRight = childrenLeft + w;
			final int childBottom;
			childBottom = childTop + h;
			child.layout(childrenLeft, childTop, childRight, childBottom);
		} // End block
		{
			child.offsetLeftAndRight(childrenLeft - child.getLeft());
			child.offsetTopAndBottom(childTop - child.getTop());
		} // End block
		{
			boolean varFE983D8157D9C3BB7AF96BB07D8A50F7_1943307480 = (mCachingStarted && !child
					.isDrawingCacheEnabled());
			{
				child.setDrawingCacheEnabled(true);
			} // End block
		} // End collapsed parenthetic
		{
			boolean varCA9C9DB394586E5C1281E2A995FFCD63_1988569713 = (recycled && (((AbsListView.LayoutParams) child
					.getLayoutParams()).scrappedFromPosition) != position);
			{
				child.jumpDrawablesToCurrentState();
			} // End block
		} // End collapsed parenthetic
			// ---------- Original Method ----------
			// Original Method Too Long, Refer to Original Implementation
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.048 -0400", hash_original_method = "F40AC428F4D570BD34339564A5B5BB04", hash_generated_method = "911C97C5458F73A78DF7FF670F0B0900")
	// DSFIXME: CODE0002: Requires DSC value to be set
	@Override
	protected boolean canAnimate() {
		boolean varDA480D2F8FF037BACA5DB54A8FBF9642_1134092885 = (super
				.canAnimate() && mItemCount > 0);
		return dsTaint.getTaintBoolean();
		// ---------- Original Method ----------
		// return super.canAnimate() && mItemCount > 0;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.048 -0400", hash_original_method = "94D2F20BDBA41376781BE37B36941A8A", hash_generated_method = "4442D5EF0F0E10A62F87EC521CF8746F")
	@DSModeled(DSC.SAFE)
	@Override
	public void setSelection(int position) {
		dsTaint.addTaint(position);
		setSelectionFromTop(position, 0);
		// ---------- Original Method ----------
		// setSelectionFromTop(position, 0);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.048 -0400", hash_original_method = "04FF3361CA0379851E7CD86AE0D8A950", hash_generated_method = "498619EE22BE02B77D2729BB77A3E23C")
	// DSFIXME: CODE0002: Requires DSC value to be set
	public void setSelectionFromTop(int position, int y) {
		// DSFIXME: CODE0009: Possible callback target function detected
		dsTaint.addTaint(position);
		dsTaint.addTaint(y);
		{
			boolean var3DA6B9D2A4DFFBF2A8164819B7AFE9DF_1749325608 = (!isInTouchMode());
			{
				position = lookForSelectablePosition(position, true);
				{
					setNextSelectedPositionInt(position);
				} // End block
			} // End block
			{
				mResurrectToPosition = position;
			} // End block
		} // End collapsed parenthetic
		{
			mLayoutMode = LAYOUT_SPECIFIC;
			mSpecificTop = mListPadding.top + y;
			{
				mSyncPosition = position;
				mSyncRowId = mAdapter.getItemId(position);
			} // End block
			requestLayout();
		} // End block
			// ---------- Original Method ----------
			// if (mAdapter == null) {
			// return;
		// }
		// if (!isInTouchMode()) {
		// position = lookForSelectablePosition(position, true);
		// if (position >= 0) {
		// setNextSelectedPositionInt(position);
		// }
		// } else {
		// mResurrectToPosition = position;
		// }
		// if (position >= 0) {
		// mLayoutMode = LAYOUT_SPECIFIC;
		// mSpecificTop = mListPadding.top + y;
		// if (mNeedSync) {
		// mSyncPosition = position;
		// mSyncRowId = mAdapter.getItemId(position);
		// }
		// requestLayout();
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.048 -0400", hash_original_method = "813C2C2B521DC76439D7A0687ADC333C", hash_generated_method = "53D53AB205A5DA5C35F7131426D8D82D")
	@DSModeled(DSC.SAFE)
	@Override
	void setSelectionInt(int position) {
		// DSFIXME: CODE0009: Possible callback target function detected
		dsTaint.addTaint(position);
		setNextSelectedPositionInt(position);
		boolean awakeScrollbars;
		awakeScrollbars = false;
		final int selectedPosition;
		selectedPosition = mSelectedPosition;
		{
			{
				awakeScrollbars = true;
			} // End block
			{
				awakeScrollbars = true;
			} // End block
		} // End block
		layoutChildren();
		{
			awakenScrollBars();
		} // End block
			// ---------- Original Method ----------
			// setNextSelectedPositionInt(position);
			// boolean awakeScrollbars = false;
			// final int selectedPosition = mSelectedPosition;
			// if (selectedPosition >= 0) {
			// if (position == selectedPosition - 1) {
			// awakeScrollbars = true;
		// } else if (position == selectedPosition + 1) {
		// awakeScrollbars = true;
		// }
		// }
		// layoutChildren();
		// if (awakeScrollbars) {
		// awakenScrollBars();
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.049 -0400", hash_original_method = "F611253C286EB5F8129DFD60BE22D44F", hash_generated_method = "AEB48F3D123A7BA4E4EC4DD58833C9C8")
	// DSFIXME: CODE0002: Requires DSC value to be set
	@Override
	int lookForSelectablePosition(int position, boolean lookDown) {
		dsTaint.addTaint(position);
		dsTaint.addTaint(lookDown);
		final ListAdapter adapter;
		adapter = mAdapter;
		{
			boolean var35A1F64E67CC6E0C06A8BA9582F2435F_1092232750 = (adapter == null || isInTouchMode());
		} // End collapsed parenthetic
		final int count;
		count = adapter.getCount();
		{
			{
				position = Math.max(0, position);
				{
					boolean varF9E3A5AB0092C9F908FE41D43CDE1F43_1880647955 = (position < count && !adapter
							.isEnabled(position));
					{
						position++;
					} // End block
				} // End collapsed parenthetic
			} // End block
			{
				position = Math.min(position, count - 1);
				{
					boolean var86CF05D4F4C580D8A474D386CDE84CF9_519685611 = (position >= 0 && !adapter
							.isEnabled(position));
					{
						position--;
					} // End block
				} // End collapsed parenthetic
			} // End block
		} // End block
		return dsTaint.getTaintInt();
		// ---------- Original Method ----------
		// Original Method Too Long, Refer to Original Implementation
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.049 -0400", hash_original_method = "BA94B118F7B33B042A8A5EE913A2CAC9", hash_generated_method = "08767169D44EE3EF045B125643EAC3BE")
	@DSModeled(DSC.SAFE)
	public void setSelectionAfterHeaderView() {
		// DSFIXME: CODE0009: Possible callback target function detected
		final int count;
		count = mHeaderViewInfos.size();
		{
			mNextSelectedPosition = 0;
		} // End block
		{
			setSelection(count);
		} // End block
		{
			mNextSelectedPosition = count;
			mLayoutMode = LAYOUT_SET_SELECTION;
		} // End block
			// ---------- Original Method ----------
			// final int count = mHeaderViewInfos.size();
			// if (count > 0) {
			// mNextSelectedPosition = 0;
			// return;
		// }
		// if (mAdapter != null) {
		// setSelection(count);
		// } else {
		// mNextSelectedPosition = count;
		// mLayoutMode = LAYOUT_SET_SELECTION;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.049 -0400", hash_original_method = "C6695FE09C5666FBD7C0ECDD7FFCA6CE", hash_generated_method = "54406175580D4B6864B30A321358BB56")
	// DSFIXME: CODE0002: Requires DSC value to be set
	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		dsTaint.addTaint(event.dsTaint);
		boolean handled;
		handled = super.dispatchKeyEvent(event);
		{
			View focused;
			focused = getFocusedChild();
			{
				boolean varD6F50D5E6BAAF6A4042506AB741CE740_1652603774 = (focused != null && event
						.getAction() == KeyEvent.ACTION_DOWN);
				{
					handled = onKeyDown(event.getKeyCode(), event);
				} // End block
			} // End collapsed parenthetic
		} // End block
		return dsTaint.getTaintBoolean();
		// ---------- Original Method ----------
		// boolean handled = super.dispatchKeyEvent(event);
		// if (!handled) {
		// View focused = getFocusedChild();
		// if (focused != null && event.getAction() == KeyEvent.ACTION_DOWN) {
		// handled = onKeyDown(event.getKeyCode(), event);
		// }
		// }
		// return handled;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.049 -0400", hash_original_method = "82498D99AFEB0700B1F959E9E9927B59", hash_generated_method = "BE7F0678176538CA7D87D58570E870FC")
	// DSFIXME: CODE0002: Requires DSC value to be set
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// DSFIXME: CODE0009: Possible callback target function detected
		dsTaint.addTaint(keyCode);
		dsTaint.addTaint(event.dsTaint);
		boolean var7B6BE27715D36B6032CB7DA2718D4FF1_969671088 = (commonKey(
				keyCode, 1, event));
		return dsTaint.getTaintBoolean();
		// ---------- Original Method ----------
		// return commonKey(keyCode, 1, event);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.049 -0400", hash_original_method = "C105EC1B6481173F2A66D1C47882507B", hash_generated_method = "EA6443CED3D6ACEE8A6ED2B4C4F33E69")
	// DSFIXME: CODE0002: Requires DSC value to be set
	@Override
	public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
		// DSFIXME: CODE0009: Possible callback target function detected
		dsTaint.addTaint(keyCode);
		dsTaint.addTaint(event.dsTaint);
		dsTaint.addTaint(repeatCount);
		boolean varACEC8A58158104BC4BBB2FE543212B03_44639931 = (commonKey(
				keyCode, repeatCount, event));
		return dsTaint.getTaintBoolean();
		// ---------- Original Method ----------
		// return commonKey(keyCode, repeatCount, event);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.049 -0400", hash_original_method = "FFB4A1626C41573790F9B17FF23F8A09", hash_generated_method = "9D9FAEF89340422FF14F2C3619918729")
	// DSFIXME: CODE0002: Requires DSC value to be set
	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		// DSFIXME: CODE0009: Possible callback target function detected
		dsTaint.addTaint(keyCode);
		dsTaint.addTaint(event.dsTaint);
		boolean var7B6BE27715D36B6032CB7DA2718D4FF1_1029206093 = (commonKey(
				keyCode, 1, event));
		return dsTaint.getTaintBoolean();
		// ---------- Original Method ----------
		// return commonKey(keyCode, 1, event);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.050 -0400", hash_original_method = "1DD47D400FE7B21B7ADCD2D234FB64A7", hash_generated_method = "B74010344EC0C701735A7EFC897CB787")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private boolean commonKey(int keyCode, int count, KeyEvent event) {
		dsTaint.addTaint(keyCode);
		dsTaint.addTaint(count);
		dsTaint.addTaint(event.dsTaint);
		{
			layoutChildren();
		} // End block
		boolean handled;
		handled = false;
		int action;
		action = event.getAction();
		{
			// Begin case KeyEvent.KEYCODE_DPAD_UP
			{
				boolean var01265F35364458CD2A88FFB15C2C1B92_1519082579 = (event
						.hasNoModifiers());
				{
					handled = resurrectSelectionIfNeeded();
					{
						{
							{
								boolean varA5B62ED4C691B4536F3BE2ACFD937D16_583969065 = (arrowScroll(FOCUS_UP));
								{
									handled = true;
								} // End block
							} // End collapsed parenthetic
						} // End block
					} // End block
				} // End block
				{
					boolean varAB36CD08CFCE6244F546B808D5F456D4_60372687 = (event
							.hasModifiers(KeyEvent.META_ALT_ON));
					{
						handled = resurrectSelectionIfNeeded()
								|| fullScroll(FOCUS_UP);
					} // End block
				} // End collapsed parenthetic
			} // End collapsed parenthetic
				// End case KeyEvent.KEYCODE_DPAD_UP
				// Begin case KeyEvent.KEYCODE_DPAD_DOWN
			{
				boolean var01265F35364458CD2A88FFB15C2C1B92_1332914032 = (event
						.hasNoModifiers());
				{
					handled = resurrectSelectionIfNeeded();
					{
						{
							{
								boolean varAA5CCD5687C9D983EE1C69076A1EA7F2_1175067759 = (arrowScroll(FOCUS_DOWN));
								{
									handled = true;
								} // End block
							} // End collapsed parenthetic
						} // End block
					} // End block
				} // End block
				{
					boolean varAB36CD08CFCE6244F546B808D5F456D4_1828245040 = (event
							.hasModifiers(KeyEvent.META_ALT_ON));
					{
						handled = resurrectSelectionIfNeeded()
								|| fullScroll(FOCUS_DOWN);
					} // End block
				} // End collapsed parenthetic
			} // End collapsed parenthetic
				// End case KeyEvent.KEYCODE_DPAD_DOWN
				// Begin case KeyEvent.KEYCODE_DPAD_LEFT
			{
				boolean var01265F35364458CD2A88FFB15C2C1B92_489612125 = (event
						.hasNoModifiers());
				{
					handled = handleHorizontalFocusWithinListItem(View.FOCUS_LEFT);
				} // End block
			} // End collapsed parenthetic
				// End case KeyEvent.KEYCODE_DPAD_LEFT
				// Begin case KeyEvent.KEYCODE_DPAD_RIGHT
			{
				boolean var01265F35364458CD2A88FFB15C2C1B92_1120045696 = (event
						.hasNoModifiers());
				{
					handled = handleHorizontalFocusWithinListItem(View.FOCUS_RIGHT);
				} // End block
			} // End collapsed parenthetic
				// End case KeyEvent.KEYCODE_DPAD_RIGHT
				// Begin case KeyEvent.KEYCODE_DPAD_CENTER
				// KeyEvent.KEYCODE_ENTER
			{
				boolean var01265F35364458CD2A88FFB15C2C1B92_1810253264 = (event
						.hasNoModifiers());
				{
					handled = resurrectSelectionIfNeeded();
					{
						boolean var0998D8B15B32EB34977168615D32B617_1770879879 = (!handled
								&& event.getRepeatCount() == 0 && getChildCount() > 0);
						{
							keyPressed();
							handled = true;
						} // End block
					} // End collapsed parenthetic
				} // End block
			} // End collapsed parenthetic
				// End case KeyEvent.KEYCODE_DPAD_CENTER KeyEvent.KEYCODE_ENTER
				// Begin case KeyEvent.KEYCODE_SPACE
			{
				boolean varC5267D5BFE7A3E261BDE80A07A8ECCFA_1109104599 = (mPopup == null || !mPopup
						.isShowing());
				{
					{
						boolean var3A3095F7575E47050F710FB26AF5006E_570177592 = (event
								.hasNoModifiers());
						{
							handled = resurrectSelectionIfNeeded()
									|| pageScroll(FOCUS_DOWN);
						} // End block
						{
							boolean varC6F58190DE4A31A0CF9704EF99A62451_1406499314 = (event
									.hasModifiers(KeyEvent.META_SHIFT_ON));
							{
								handled = resurrectSelectionIfNeeded()
										|| pageScroll(FOCUS_UP);
							} // End block
						} // End collapsed parenthetic
					} // End collapsed parenthetic
					handled = true;
				} // End block
			} // End collapsed parenthetic
				// End case KeyEvent.KEYCODE_SPACE
				// Begin case KeyEvent.KEYCODE_PAGE_UP
			{
				boolean var01265F35364458CD2A88FFB15C2C1B92_1694631038 = (event
						.hasNoModifiers());
				{
					handled = resurrectSelectionIfNeeded()
							|| pageScroll(FOCUS_UP);
				} // End block
				{
					boolean varAB36CD08CFCE6244F546B808D5F456D4_1358363534 = (event
							.hasModifiers(KeyEvent.META_ALT_ON));
					{
						handled = resurrectSelectionIfNeeded()
								|| fullScroll(FOCUS_UP);
					} // End block
				} // End collapsed parenthetic
			} // End collapsed parenthetic
				// End case KeyEvent.KEYCODE_PAGE_UP
				// Begin case KeyEvent.KEYCODE_PAGE_DOWN
			{
				boolean var01265F35364458CD2A88FFB15C2C1B92_650464591 = (event
						.hasNoModifiers());
				{
					handled = resurrectSelectionIfNeeded()
							|| pageScroll(FOCUS_DOWN);
				} // End block
				{
					boolean varAB36CD08CFCE6244F546B808D5F456D4_1027470224 = (event
							.hasModifiers(KeyEvent.META_ALT_ON));
					{
						handled = resurrectSelectionIfNeeded()
								|| fullScroll(FOCUS_DOWN);
					} // End block
				} // End collapsed parenthetic
			} // End collapsed parenthetic
				// End case KeyEvent.KEYCODE_PAGE_DOWN
				// Begin case KeyEvent.KEYCODE_MOVE_HOME
			{
				boolean var01265F35364458CD2A88FFB15C2C1B92_842778261 = (event
						.hasNoModifiers());
				{
					handled = resurrectSelectionIfNeeded()
							|| fullScroll(FOCUS_UP);
				} // End block
			} // End collapsed parenthetic
				// End case KeyEvent.KEYCODE_MOVE_HOME
				// Begin case KeyEvent.KEYCODE_MOVE_END
			{
				boolean var01265F35364458CD2A88FFB15C2C1B92_812664848 = (event
						.hasNoModifiers());
				{
					handled = resurrectSelectionIfNeeded()
							|| fullScroll(FOCUS_DOWN);
				} // End block
			} // End collapsed parenthetic
				// End case KeyEvent.KEYCODE_MOVE_END
				// Begin case KeyEvent.KEYCODE_TAB
			{
				{
					boolean varC77C0C11194BD87DFEE086A32DCE5C18_1628799913 = (event
							.hasNoModifiers());
					{
						handled = resurrectSelectionIfNeeded()
								|| arrowScroll(FOCUS_DOWN);
					} // End block
					{
						boolean var7B1040B2192949CFC257B6EE7F25C319_358035334 = (event
								.hasModifiers(KeyEvent.META_SHIFT_ON));
						{
							handled = resurrectSelectionIfNeeded()
									|| arrowScroll(FOCUS_UP);
						} // End block
					} // End collapsed parenthetic
				} // End collapsed parenthetic
			} // End block
				// End case KeyEvent.KEYCODE_TAB
		} // End block
		{
			boolean varF6449376E291BB335EF050093EE80110_1994463380 = (sendToTextFilter(
					keyCode, count, event));
		} // End collapsed parenthetic
			// Begin case KeyEvent.ACTION_DOWN
		boolean var8C6E6C19273FC56B5C56CC7DEF63ED7B_1260971650 = (super
				.onKeyDown(keyCode, event));
		// End case KeyEvent.ACTION_DOWN
		// Begin case KeyEvent.ACTION_UP
		boolean varEDD771EBF66425AD21882AB08CD0EE48_1498727121 = (super
				.onKeyUp(keyCode, event));
		// End case KeyEvent.ACTION_UP
		// Begin case KeyEvent.ACTION_MULTIPLE
		boolean varC0357E39557DD275ECAF43C782C78502_687978959 = (super
				.onKeyMultiple(keyCode, count, event));
		// End case KeyEvent.ACTION_MULTIPLE
		return dsTaint.getTaintBoolean();
		// ---------- Original Method ----------
		// Original Method Too Long, Refer to Original Implementation
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.051 -0400", hash_original_method = "CFFD02C88D512DC860E9CC0FE1096C45", hash_generated_method = "2A762DDA4682B041BAF2C7648F4C0950")
	// DSFIXME: CODE0002: Requires DSC value to be set
	boolean pageScroll(int direction) {
		dsTaint.addTaint(direction);
		int nextPage;
		nextPage = -1;
		boolean down;
		down = false;
		{
			nextPage = Math.max(0, mSelectedPosition - getChildCount() - 1);
		} // End block
		{
			nextPage = Math.min(mItemCount - 1, mSelectedPosition
					+ getChildCount() - 1);
			down = true;
		} // End block
		{
			int position;
			position = lookForSelectablePosition(nextPage, down);
			{
				mLayoutMode = LAYOUT_SPECIFIC;
				mSpecificTop = mPaddingTop + getVerticalFadingEdgeLength();
				{
					boolean varA164A5303752DF647D9BF6996D101837_1538604425 = (down && position > mItemCount
							- getChildCount());
					{
						mLayoutMode = LAYOUT_FORCE_BOTTOM;
					} // End block
				} // End collapsed parenthetic
				{
					boolean var110612621C7A8EA496F1D2C158694581_1817255269 = (!down && position < getChildCount());
					{
						mLayoutMode = LAYOUT_FORCE_TOP;
					} // End block
				} // End collapsed parenthetic
				setSelectionInt(position);
				invokeOnItemScrollListener();
				{
					boolean var23B792A36C4A2414CF3FD466E934AAC2_1492720917 = (!awakenScrollBars());
					{
						invalidate();
					} // End block
				} // End collapsed parenthetic
			} // End block
		} // End block
		return dsTaint.getTaintBoolean();
		// ---------- Original Method ----------
		// Original Method Too Long, Refer to Original Implementation
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.051 -0400", hash_original_method = "8893A9BFD4970E039D8D32407D02C15E", hash_generated_method = "56A842BA37BB82456C399312E3800769")
	// DSFIXME: CODE0002: Requires DSC value to be set
	boolean fullScroll(int direction) {
		dsTaint.addTaint(direction);
		boolean moved;
		moved = false;
		{
			{
				int position;
				position = lookForSelectablePosition(0, true);
				{
					mLayoutMode = LAYOUT_FORCE_TOP;
					setSelectionInt(position);
					invokeOnItemScrollListener();
				} // End block
				moved = true;
			} // End block
		} // End block
		{
			{
				int position;
				position = lookForSelectablePosition(mItemCount - 1, true);
				{
					mLayoutMode = LAYOUT_FORCE_BOTTOM;
					setSelectionInt(position);
					invokeOnItemScrollListener();
				} // End block
				moved = true;
			} // End block
		} // End block
		{
			boolean var5B952B5E17217FEE8BC4BB0979561FA3_1422408847 = (moved && !awakenScrollBars());
			{
				awakenScrollBars();
				invalidate();
			} // End block
		} // End collapsed parenthetic
		return dsTaint.getTaintBoolean();
		// ---------- Original Method ----------
		// Original Method Too Long, Refer to Original Implementation
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.051 -0400", hash_original_method = "27083050B4DD915BDC5D45A692A1DFB7", hash_generated_method = "80585676933D6AE5AA96175E52EE0734")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private boolean handleHorizontalFocusWithinListItem(int direction) {
		dsTaint.addTaint(direction);
		{
			if (DroidSafeAndroidRuntime.control)
				throw new IllegalArgumentException("direction must be one of"
						+ " {View.FOCUS_LEFT, View.FOCUS_RIGHT}");
		} // End block
		int numChildren;
		numChildren = getChildCount();
		{
			final View selectedView;
			selectedView = getSelectedView();
			{
				boolean var5A370CFD3CE8F716DF439EFB07635CD0_879253447 = (selectedView != null
						&& selectedView.hasFocus() && selectedView instanceof ViewGroup);
				{
					final View currentFocus;
					currentFocus = selectedView.findFocus();
					final View nextFocus;
					nextFocus = FocusFinder.getInstance().findNextFocus(
							(ViewGroup) selectedView, currentFocus, direction);
					{
						currentFocus.getFocusedRect(mTempRect);
						offsetDescendantRectToMyCoords(currentFocus, mTempRect);
						offsetRectIntoDescendantCoords(nextFocus, mTempRect);
						{
							boolean var76D8898CFBC448597F15A4BC0E876792_1268909338 = (nextFocus
									.requestFocus(direction, mTempRect));
						} // End collapsed parenthetic
					} // End block
					final View globalNextFocus;
					globalNextFocus = FocusFinder.getInstance().findNextFocus(
							(ViewGroup) getRootView(), currentFocus, direction);
					{
						boolean varB2F32E25506228F03370ADE074F28912_1573872977 = (isViewAncestorOf(
								globalNextFocus, this));
					} // End block
				} // End block
			} // End collapsed parenthetic
		} // End block
		return dsTaint.getTaintBoolean();
		// ---------- Original Method ----------
		// Original Method Too Long, Refer to Original Implementation
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.051 -0400", hash_original_method = "6B5D7DFA7F5B692B993CC3912D59B646", hash_generated_method = "91DF1579ED6398C31DAB65D744AD13CD")
	// DSFIXME: CODE0002: Requires DSC value to be set
	boolean arrowScroll(int direction) {
		dsTaint.addTaint(direction);
		try {
			mInLayout = true;
			final boolean handled;
			handled = arrowScrollImpl(direction);
			{
				playSoundEffect(SoundEffectConstants
						.getContantForFocusDirection(direction));
			} // End block
		} // End block
		finally {
			mInLayout = false;
		} // End block
		return dsTaint.getTaintBoolean();
		// ---------- Original Method ----------
		// try {
		// mInLayout = true;
		// final boolean handled = arrowScrollImpl(direction);
		// if (handled) {
		// playSoundEffect(SoundEffectConstants.getContantForFocusDirection(direction));
		// }
		// return handled;
		// } finally {
		// mInLayout = false;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.052 -0400", hash_original_method = "5F8F1549FF6A2936584D81A340335636", hash_generated_method = "413521ACECDF56E93B3EA60145C8BA37")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private boolean arrowScrollImpl(int direction) {
		dsTaint.addTaint(direction);
		{
			boolean var4229DDB8D3BBE3C4FC615E86EF9AD4FF_729636819 = (getChildCount() <= 0);
		} // End collapsed parenthetic
		View selectedView;
		selectedView = getSelectedView();
		int selectedPos;
		selectedPos = mSelectedPosition;
		int nextSelectedPosition;
		nextSelectedPosition = lookForSelectablePositionOnScreen(direction);
		int amountToScroll;
		amountToScroll = amountToScroll(direction, nextSelectedPosition);
		ArrowScrollFocusResult focusResult;
		focusResult = arrowScrollFocused(direction);
		focusResult = null;
		{
			nextSelectedPosition = focusResult.getSelectedPosition();
			amountToScroll = focusResult.getAmountToScroll();
		} // End block
		boolean needToRedraw;
		needToRedraw = focusResult != null;
		{
			handleNewSelectionChange(selectedView, direction,
					nextSelectedPosition, focusResult != null);
			setSelectedPositionInt(nextSelectedPosition);
			setNextSelectedPositionInt(nextSelectedPosition);
			selectedView = getSelectedView();
			selectedPos = nextSelectedPosition;
			{
				final View focused;
				focused = getFocusedChild();
				{
					focused.clearFocus();
				} // End block
			} // End block
			needToRedraw = true;
			checkSelectionChanged();
		} // End block
		{
			scrollListItemsBy((direction == View.FOCUS_UP) ? amountToScroll
					: -amountToScroll);
			needToRedraw = true;
		} // End block
		{
			boolean varB8E5D6C0579FB6C2780425B3D1ABD141_855837889 = (mItemsCanFocus
					&& (focusResult == null) && selectedView != null && selectedView
					.hasFocus());
			{
				final View focused;
				focused = selectedView.findFocus();
				{
					boolean var3BB0A88B4E6FC6416F98323008226B4B_2013347477 = (!isViewAncestorOf(
							focused, this) || distanceToView(focused) > 0);
					{
						focused.clearFocus();
					} // End block
				} // End collapsed parenthetic
			} // End block
		} // End collapsed parenthetic
		{
			boolean var089D086D835620A272CDDA708424B586_596239455 = (nextSelectedPosition == INVALID_POSITION
					&& selectedView != null && !isViewAncestorOf(selectedView,
					this));
			{
				selectedView = null;
				hideSelector();
				mResurrectToPosition = INVALID_POSITION;
			} // End block
		} // End collapsed parenthetic
		{
			{
				positionSelector(selectedPos, selectedView);
				mSelectedTop = selectedView.getTop();
			} // End block
			{
				boolean varC828E793AFDA5CD988FA9008B6EB3B30_1552327465 = (!awakenScrollBars());
				{
					invalidate();
				} // End block
			} // End collapsed parenthetic
			invokeOnItemScrollListener();
		} // End block
		return dsTaint.getTaintBoolean();
		// ---------- Original Method ----------
		// Original Method Too Long, Refer to Original Implementation
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.052 -0400", hash_original_method = "5F7DFDAF299194D301FC447E78E3FD87", hash_generated_method = "A5FF5B1FFCA4CC8757A31C50CE7546A0")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private void handleNewSelectionChange(View selectedView, int direction,
			int newSelectedPosition, boolean newFocusAssigned) {
		dsTaint.addTaint(newFocusAssigned);
		dsTaint.addTaint(direction);
		dsTaint.addTaint(selectedView.dsTaint);
		dsTaint.addTaint(newSelectedPosition);
		{
			if (DroidSafeAndroidRuntime.control)
				throw new IllegalArgumentException(
						"newSelectedPosition needs to be valid");
		} // End block
		View topView;
		View bottomView;
		int topViewIndex, bottomViewIndex;
		boolean topSelected;
		topSelected = false;
		final int selectedIndex;
		selectedIndex = mSelectedPosition - mFirstPosition;
		final int nextSelectedIndex;
		nextSelectedIndex = newSelectedPosition - mFirstPosition;
		{
			topViewIndex = nextSelectedIndex;
			bottomViewIndex = selectedIndex;
			topView = getChildAt(topViewIndex);
			bottomView = selectedView;
			topSelected = true;
		} // End block
		{
			topViewIndex = selectedIndex;
			bottomViewIndex = nextSelectedIndex;
			topView = selectedView;
			bottomView = getChildAt(bottomViewIndex);
		} // End block
		final int numChildren;
		numChildren = getChildCount();
		{
			topView.setSelected(!newFocusAssigned && topSelected);
			measureAndAdjustDown(topView, topViewIndex, numChildren);
		} // End block
		{
			bottomView.setSelected(!newFocusAssigned && !topSelected);
			measureAndAdjustDown(bottomView, bottomViewIndex, numChildren);
		} // End block
			// ---------- Original Method ----------
			// Original Method Too Long, Refer to Original Implementation
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.052 -0400", hash_original_method = "D9B7EDD91437C9CF7E31BD236F25B8F3", hash_generated_method = "BED92E39C189D0F7D54F8166A52ED1D0")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private void measureAndAdjustDown(View child, int childIndex,
			int numChildren) {
		dsTaint.addTaint(child.dsTaint);
		dsTaint.addTaint(numChildren);
		dsTaint.addTaint(childIndex);
		int oldHeight;
		oldHeight = child.getHeight();
		measureItem(child);
		{
			boolean var7B22EF90C45277911AB272B76E96E5DA_2082014703 = (child
					.getMeasuredHeight() != oldHeight);
			{
				relayoutMeasuredItem(child);
				final int heightDelta;
				heightDelta = child.getMeasuredHeight() - oldHeight;
				{
					int i;
					i = childIndex + 1;
					{
						getChildAt(i).offsetTopAndBottom(heightDelta);
					} // End block
				} // End collapsed parenthetic
			} // End block
		} // End collapsed parenthetic
			// ---------- Original Method ----------
			// int oldHeight = child.getHeight();
			// measureItem(child);
			// if (child.getMeasuredHeight() != oldHeight) {
			// relayoutMeasuredItem(child);
			// final int heightDelta = child.getMeasuredHeight() - oldHeight;
			// for (int i = childIndex + 1; i < numChildren; i++) {
			// getChildAt(i).offsetTopAndBottom(heightDelta);
		// }
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.052 -0400", hash_original_method = "195C1D433E8B0F15028E4D73EB2D6DE2", hash_generated_method = "EFAD0945EEA22CECF401337DBE548657")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private void measureItem(View child) {
		dsTaint.addTaint(child.dsTaint);
		ViewGroup.LayoutParams p;
		p = child.getLayoutParams();
		{
			p = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
					ViewGroup.LayoutParams.WRAP_CONTENT);
		} // End block
		int childWidthSpec;
		childWidthSpec = ViewGroup.getChildMeasureSpec(mWidthMeasureSpec,
				mListPadding.left + mListPadding.right, p.width);
		int lpHeight;
		lpHeight = p.height;
		int childHeightSpec;
		{
			childHeightSpec = MeasureSpec.makeMeasureSpec(lpHeight,
					MeasureSpec.EXACTLY);
		} // End block
		{
			childHeightSpec = MeasureSpec.makeMeasureSpec(0,
					MeasureSpec.UNSPECIFIED);
		} // End block
		child.measure(childWidthSpec, childHeightSpec);
		// ---------- Original Method ----------
		// ViewGroup.LayoutParams p = child.getLayoutParams();
		// if (p == null) {
		// p = new ViewGroup.LayoutParams(
		// ViewGroup.LayoutParams.MATCH_PARENT,
		// ViewGroup.LayoutParams.WRAP_CONTENT);
		// }
		// int childWidthSpec = ViewGroup.getChildMeasureSpec(mWidthMeasureSpec,
		// mListPadding.left + mListPadding.right, p.width);
		// int lpHeight = p.height;
		// int childHeightSpec;
		// if (lpHeight > 0) {
		// childHeightSpec = MeasureSpec.makeMeasureSpec(lpHeight,
		// MeasureSpec.EXACTLY);
		// } else {
		// childHeightSpec = MeasureSpec.makeMeasureSpec(0,
		// MeasureSpec.UNSPECIFIED);
		// }
		// child.measure(childWidthSpec, childHeightSpec);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.053 -0400", hash_original_method = "69D49227DB6AC5D384C2E3A710CB930F", hash_generated_method = "C7B477ED1A7EF148546E933AB0BFEB7F")
	@DSModeled(DSC.SAFE)
	private void relayoutMeasuredItem(View child) {
		dsTaint.addTaint(child.dsTaint);
		final int w;
		w = child.getMeasuredWidth();
		final int h;
		h = child.getMeasuredHeight();
		final int childLeft;
		childLeft = mListPadding.left;
		final int childRight;
		childRight = childLeft + w;
		final int childTop;
		childTop = child.getTop();
		final int childBottom;
		childBottom = childTop + h;
		child.layout(childLeft, childTop, childRight, childBottom);
		// ---------- Original Method ----------
		// final int w = child.getMeasuredWidth();
		// final int h = child.getMeasuredHeight();
		// final int childLeft = mListPadding.left;
		// final int childRight = childLeft + w;
		// final int childTop = child.getTop();
		// final int childBottom = childTop + h;
		// child.layout(childLeft, childTop, childRight, childBottom);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.053 -0400", hash_original_method = "42F2E28C8994E7757E02659DFEBDEFA8", hash_generated_method = "34B7B547E9F02F8BA137F88F8CFBAE17")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private int getArrowScrollPreviewLength() {
		int var32C3DF276D4CC5AB85EAD318AE4B92AE_1449696667 = (Math.max(
				MIN_SCROLL_PREVIEW_PIXELS, getVerticalFadingEdgeLength()));
		return dsTaint.getTaintInt();
		// ---------- Original Method ----------
		// return Math.max(MIN_SCROLL_PREVIEW_PIXELS,
		// getVerticalFadingEdgeLength());
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.053 -0400", hash_original_method = "0CBCA538A833739B1FF13F8466C4BF4D", hash_generated_method = "DB57448C32AB24B7644E7AD9E19AB8ED")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private int amountToScroll(int direction, int nextSelectedPosition) {
		dsTaint.addTaint(direction);
		dsTaint.addTaint(nextSelectedPosition);
		final int listBottom;
		listBottom = getHeight() - mListPadding.bottom;
		final int listTop;
		listTop = mListPadding.top;
		final int numChildren;
		numChildren = getChildCount();
		{
			int indexToMakeVisible;
			indexToMakeVisible = numChildren - 1;
			{
				indexToMakeVisible = nextSelectedPosition - mFirstPosition;
			} // End block
			final int positionToMakeVisible;
			positionToMakeVisible = mFirstPosition + indexToMakeVisible;
			final View viewToMakeVisible;
			viewToMakeVisible = getChildAt(indexToMakeVisible);
			int goalBottom;
			goalBottom = listBottom;
			{
				goalBottom -= getArrowScrollPreviewLength();
			} // End block
			{
				boolean var5F736F6450B740E6E9E57C387C57D4DD_679448115 = (viewToMakeVisible
						.getBottom() <= goalBottom);
			} // End collapsed parenthetic
			{
				boolean var8324A997C3E5144DDD35F3BF25EFB670_327563943 = (nextSelectedPosition != INVALID_POSITION && (goalBottom - viewToMakeVisible
						.getTop()) >= getMaxScrollAmount());
			} // End collapsed parenthetic
			int amountToScroll;
			amountToScroll = (viewToMakeVisible.getBottom() - goalBottom);
			{
				final int max;
				max = getChildAt(numChildren - 1).getBottom() - listBottom;
				amountToScroll = Math.min(amountToScroll, max);
			} // End block
			int var1934DA7AFCB63592141CB73FE3F03962_1481432678 = (Math.min(
					amountToScroll, getMaxScrollAmount()));
		} // End block
		{
			int indexToMakeVisible;
			indexToMakeVisible = 0;
			{
				indexToMakeVisible = nextSelectedPosition - mFirstPosition;
			} // End block
			final int positionToMakeVisible;
			positionToMakeVisible = mFirstPosition + indexToMakeVisible;
			final View viewToMakeVisible;
			viewToMakeVisible = getChildAt(indexToMakeVisible);
			int goalTop;
			goalTop = listTop;
			{
				goalTop += getArrowScrollPreviewLength();
			} // End block
			{
				boolean var40E2B917BF16844A067981F2A72A29CC_261060950 = (viewToMakeVisible
						.getTop() >= goalTop);
			} // End collapsed parenthetic
			{
				boolean varC22CD0C0296052301FAE425C57E08A6B_1015866320 = (nextSelectedPosition != INVALID_POSITION && (viewToMakeVisible
						.getBottom() - goalTop) >= getMaxScrollAmount());
			} // End collapsed parenthetic
			int amountToScroll;
			amountToScroll = (goalTop - viewToMakeVisible.getTop());
			{
				final int max;
				max = listTop - getChildAt(0).getTop();
				amountToScroll = Math.min(amountToScroll, max);
			} // End block
			int var1934DA7AFCB63592141CB73FE3F03962_1363194120 = (Math.min(
					amountToScroll, getMaxScrollAmount()));
		} // End block
		return dsTaint.getTaintInt();
		// ---------- Original Method ----------
		// Original Method Too Long, Refer to Original Implementation
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.054 -0400", hash_original_method = "760C70065AEFE7BC7EE2B10D159765ED", hash_generated_method = "7B5CF387BF031C27C21E5E3F825984E4")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private int lookForSelectablePositionOnScreen(int direction) {
		dsTaint.addTaint(direction);
		final int firstPosition;
		firstPosition = mFirstPosition;
		{
			int startPos;
			startPos = mSelectedPosition + 1;
			startPos = firstPosition;
			{
				boolean varFD8F153F7B9B0445D1C8B98618EA7E23_950989444 = (startPos >= mAdapter
						.getCount());
			} // End collapsed parenthetic
			{
				startPos = firstPosition;
			} // End block
			final int lastVisiblePos;
			lastVisiblePos = getLastVisiblePosition();
			final ListAdapter adapter;
			adapter = getAdapter();
			{
				int pos;
				pos = startPos;
				{
					{
						boolean var705701EB8E699AA442E2F4E862DC96E7_944833240 = (adapter
								.isEnabled(pos) && getChildAt(
								pos - firstPosition).getVisibility() == View.VISIBLE);
					} // End collapsed parenthetic
				} // End block
			} // End collapsed parenthetic
		} // End block
		{
			int last;
			last = firstPosition + getChildCount() - 1;
			int startPos;
			startPos = mSelectedPosition - 1;
			startPos = firstPosition + getChildCount() - 1;
			{
				boolean var52FACA214769BF23A240C7E957876F70_2077619591 = (startPos < 0 || startPos >= mAdapter
						.getCount());
			} // End collapsed parenthetic
			{
				startPos = last;
			} // End block
			final ListAdapter adapter;
			adapter = getAdapter();
			{
				int pos;
				pos = startPos;
				{
					{
						boolean var705701EB8E699AA442E2F4E862DC96E7_1528179305 = (adapter
								.isEnabled(pos) && getChildAt(
								pos - firstPosition).getVisibility() == View.VISIBLE);
					} // End collapsed parenthetic
				} // End block
			} // End collapsed parenthetic
		} // End block
		return dsTaint.getTaintInt();
		// ---------- Original Method ----------
		// Original Method Too Long, Refer to Original Implementation
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.054 -0400", hash_original_method = "2622F1B1638C7BCDD9C32B9CBE54AF85", hash_generated_method = "48B6CF0E9AE8A1CC14FADFFDF1587EE3")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private ArrowScrollFocusResult arrowScrollFocused(final int direction) {
		dsTaint.addTaint(direction);
		final View selectedView;
		selectedView = getSelectedView();
		View newFocus;
		{
			boolean varA1513A08695E8074CF4C05D652884B2C_753467391 = (selectedView != null && selectedView
					.hasFocus());
			{
				View oldFocus;
				oldFocus = selectedView.findFocus();
				newFocus = FocusFinder.getInstance().findNextFocus(this,
						oldFocus, direction);
			} // End block
			{
				{
					final boolean topFadingEdgeShowing;
					topFadingEdgeShowing = (mFirstPosition > 0);
					final int listTop;
					listTop = mListPadding.top
							+ (topFadingEdgeShowing ? getArrowScrollPreviewLength()
									: 0);// DSFIXME: CODE0008: Nested ternary
											// operator in expression
					int ySearchPoint;
					boolean var0C9DFED1B79DF626EEB83B6645BDE791_674340204 = ((selectedView != null && selectedView
							.getTop() > listTop));
					ySearchPoint = selectedView.getTop();
					ySearchPoint = listTop;
					mTempRect.set(0, ySearchPoint, 0, ySearchPoint);
				} // End block
				{
					final boolean bottomFadingEdgeShowing;
					bottomFadingEdgeShowing = (mFirstPosition + getChildCount() - 1) < mItemCount;
					final int listBottom;
					listBottom = getHeight()
							- mListPadding.bottom
							- (bottomFadingEdgeShowing ? getArrowScrollPreviewLength()
									: 0);// DSFIXME: CODE0008: Nested ternary
											// operator in expression
					int ySearchPoint;
					boolean var535C017266C0FE7A092B0CC38B96CB22_1851086298 = ((selectedView != null && selectedView
							.getBottom() < listBottom));
					ySearchPoint = selectedView.getBottom();
					ySearchPoint = listBottom;
					mTempRect.set(0, ySearchPoint, 0, ySearchPoint);
				} // End block
				newFocus = FocusFinder.getInstance().findNextFocusFromRect(
						this, mTempRect, direction);
			} // End block
		} // End collapsed parenthetic
		{
			final int positionOfNewFocus;
			positionOfNewFocus = positionOfNewFocus(newFocus);
			{
				final int selectablePosition;
				selectablePosition = lookForSelectablePositionOnScreen(direction);
			} // End block
			int focusScroll;
			focusScroll = amountToScrollToNewFocus(direction, newFocus,
					positionOfNewFocus);
			final int maxScrollAmount;
			maxScrollAmount = getMaxScrollAmount();
			{
				newFocus.requestFocus(direction);
				mArrowScrollFocusResult.populate(positionOfNewFocus,
						focusScroll);
			} // End block
			{
				boolean varEB2D69BE3268364AC7D3855A8FF1F45F_1204025139 = (distanceToView(newFocus) < maxScrollAmount);
				{
					newFocus.requestFocus(direction);
					mArrowScrollFocusResult.populate(positionOfNewFocus,
							maxScrollAmount);
				} // End block
			} // End collapsed parenthetic
		} // End block
		return (ArrowScrollFocusResult) dsTaint.getTaint();
		// ---------- Original Method ----------
		// Original Method Too Long, Refer to Original Implementation
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.055 -0400", hash_original_method = "E7A74EC59726801D8AE9EB276549022E", hash_generated_method = "FD554A11ECDE8F761404E6CF1C77B501")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private int positionOfNewFocus(View newFocus) {
		dsTaint.addTaint(newFocus.dsTaint);
		final int numChildren;
		numChildren = getChildCount();
		{
			int i;
			i = 0;
			{
				final View child;
				child = getChildAt(i);
				{
					boolean var743CF1855186FF404A0881633A428604_899185573 = (isViewAncestorOf(
							newFocus, child));
				} // End collapsed parenthetic
			} // End block
		} // End collapsed parenthetic
		if (DroidSafeAndroidRuntime.control)
			throw new IllegalArgumentException(
					"newFocus is not a child of any of the"
							+ " children of the list!");
		return dsTaint.getTaintInt();
		// ---------- Original Method ----------
		// final int numChildren = getChildCount();
		// for (int i = 0; i < numChildren; i++) {
		// final View child = getChildAt(i);
		// if (isViewAncestorOf(newFocus, child)) {
		// return mFirstPosition + i;
		// }
		// }
		// throw new
		// IllegalArgumentException("newFocus is not a child of any of the"
		// + " children of the list!");
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.055 -0400", hash_original_method = "3B08BDE00067F884387760F12D698F42", hash_generated_method = "5D630542896B22A15703D7CC23E88C11")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private boolean isViewAncestorOf(View child, View parent) {
		dsTaint.addTaint(child.dsTaint);
		dsTaint.addTaint(parent.dsTaint);
		final ViewParent theParent;
		theParent = child.getParent();
		boolean var31AD4BA23C577C9A637BA02E579FD0B2_598816079 = ((theParent instanceof ViewGroup) && isViewAncestorOf(
				(View) theParent, parent));
		return dsTaint.getTaintBoolean();
		// ---------- Original Method ----------
		// if (child == parent) {
		// return true;
		// }
		// final ViewParent theParent = child.getParent();
		// return (theParent instanceof ViewGroup) && isViewAncestorOf((View)
		// theParent, parent);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.055 -0400", hash_original_method = "972857949DC34A723A630B605759B3EF", hash_generated_method = "A35A011B6CA570D9DCDF369D0FB4398D")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private int amountToScrollToNewFocus(int direction, View newFocus,
			int positionOfNewFocus) {
		dsTaint.addTaint(positionOfNewFocus);
		dsTaint.addTaint(direction);
		dsTaint.addTaint(newFocus.dsTaint);
		int amountToScroll;
		amountToScroll = 0;
		newFocus.getDrawingRect(mTempRect);
		offsetDescendantRectToMyCoords(newFocus, mTempRect);
		{
			{
				amountToScroll = mListPadding.top - mTempRect.top;
				{
					amountToScroll += getArrowScrollPreviewLength();
				} // End block
			} // End block
		} // End block
		{
			final int listBottom;
			listBottom = getHeight() - mListPadding.bottom;
			{
				amountToScroll = mTempRect.bottom - listBottom;
				{
					amountToScroll += getArrowScrollPreviewLength();
				} // End block
			} // End block
		} // End block
		return dsTaint.getTaintInt();
		// ---------- Original Method ----------
		// Original Method Too Long, Refer to Original Implementation
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.055 -0400", hash_original_method = "2468FB71A40A0019FA8D57CEA81AC8A6", hash_generated_method = "86C46905F21175CB3E4B7E270C294644")
	@DSModeled(DSC.SAFE)
	private int distanceToView(View descendant) {
		dsTaint.addTaint(descendant.dsTaint);
		int distance;
		distance = 0;
		descendant.getDrawingRect(mTempRect);
		offsetDescendantRectToMyCoords(descendant, mTempRect);
		final int listBottom;
		listBottom = mBottom - mTop - mListPadding.bottom;
		{
			distance = mListPadding.top - mTempRect.bottom;
		} // End block
		{
			distance = mTempRect.top - listBottom;
		} // End block
		return dsTaint.getTaintInt();
		// ---------- Original Method ----------
		// int distance = 0;
		// descendant.getDrawingRect(mTempRect);
		// offsetDescendantRectToMyCoords(descendant, mTempRect);
		// final int listBottom = mBottom - mTop - mListPadding.bottom;
		// if (mTempRect.bottom < mListPadding.top) {
		// distance = mListPadding.top - mTempRect.bottom;
		// } else if (mTempRect.top > listBottom) {
		// distance = mTempRect.top - listBottom;
		// }
		// return distance;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.056 -0400", hash_original_method = "FAA0316A71F66D005638E2A277415AFB", hash_generated_method = "FEDA30AE7136A4EFF2F94172339559F3")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private void scrollListItemsBy(int amount) {
		dsTaint.addTaint(amount);
		offsetChildrenTopAndBottom(amount);
		final int listBottom;
		listBottom = getHeight() - mListPadding.bottom;
		final int listTop;
		listTop = mListPadding.top;
		final AbsListView.RecycleBin recycleBin;
		recycleBin = mRecycler;
		{
			int numChildren;
			numChildren = getChildCount();
			View last;
			last = getChildAt(numChildren - 1);
			{
				boolean var5F1380678D3DF277A8634CE4F78FA5E2_809424582 = (last
						.getBottom() < listBottom);
				{
					final int lastVisiblePosition;
					lastVisiblePosition = mFirstPosition + numChildren - 1;
					{
						last = addViewBelow(last, lastVisiblePosition);
						numChildren++;
					} // End block
				} // End block
			} // End collapsed parenthetic
			{
				boolean var5F1380678D3DF277A8634CE4F78FA5E2_1859603352 = (last
						.getBottom() < listBottom);
				{
					offsetChildrenTopAndBottom(listBottom - last.getBottom());
				} // End block
			} // End collapsed parenthetic
			View first;
			first = getChildAt(0);
			{
				boolean var5DEAA936426734BA7061F416FF8C6D22_174794262 = (first
						.getBottom() < listTop);
				{
					AbsListView.LayoutParams layoutParams;
					layoutParams = (LayoutParams) first.getLayoutParams();
					{
						boolean var2ED08FF5DD3428B26AE67127DC8E5467_434997313 = (recycleBin
								.shouldRecycleViewType(layoutParams.viewType));
						{
							detachViewFromParent(first);
							recycleBin.addScrapView(first, mFirstPosition);
						} // End block
						{
							removeViewInLayout(first);
						} // End block
					} // End collapsed parenthetic
					first = getChildAt(0);
					mFirstPosition++;
				} // End block
			} // End collapsed parenthetic
		} // End block
		{
			View first;
			first = getChildAt(0);
			{
				boolean var4D6C61E96E1628FDB98784EB678A415B_1055384848 = ((first
						.getTop() > listTop) && (mFirstPosition > 0));
				{
					first = addViewAbove(first, mFirstPosition);
					mFirstPosition--;
				} // End block
			} // End collapsed parenthetic
			{
				boolean varEA4423DF7697B0235733DDAA9E5B11E5_312562508 = (first
						.getTop() > listTop);
				{
					offsetChildrenTopAndBottom(listTop - first.getTop());
				} // End block
			} // End collapsed parenthetic
			int lastIndex;
			lastIndex = getChildCount() - 1;
			View last;
			last = getChildAt(lastIndex);
			{
				boolean var6CFFE8EA59E4FF6F1E1615BCEB3548F9_835884994 = (last
						.getTop() > listBottom);
				{
					AbsListView.LayoutParams layoutParams;
					layoutParams = (LayoutParams) last.getLayoutParams();
					{
						boolean var2ED08FF5DD3428B26AE67127DC8E5467_709739131 = (recycleBin
								.shouldRecycleViewType(layoutParams.viewType));
						{
							detachViewFromParent(last);
							recycleBin.addScrapView(last, mFirstPosition
									+ lastIndex);
						} // End block
						{
							removeViewInLayout(last);
						} // End block
					} // End collapsed parenthetic
					last = getChildAt(--lastIndex);
				} // End block
			} // End collapsed parenthetic
		} // End block
			// ---------- Original Method ----------
			// Original Method Too Long, Refer to Original Implementation
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.056 -0400", hash_original_method = "9F36487536DE2965CEF1C4C9236F1DF4", hash_generated_method = "267C7AC49EDB184CB7F5B4796349E13B")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private View addViewAbove(View theView, int position) {
		dsTaint.addTaint(position);
		dsTaint.addTaint(theView.dsTaint);
		int abovePosition;
		abovePosition = position - 1;
		View view;
		view = obtainView(abovePosition, mIsScrap);
		int edgeOfNewChild;
		edgeOfNewChild = theView.getTop() - mDividerHeight;
		setupChild(view, abovePosition, edgeOfNewChild, false,
				mListPadding.left, false, mIsScrap[0]);
		return (View) dsTaint.getTaint();
		// ---------- Original Method ----------
		// int abovePosition = position - 1;
		// View view = obtainView(abovePosition, mIsScrap);
		// int edgeOfNewChild = theView.getTop() - mDividerHeight;
		// setupChild(view, abovePosition, edgeOfNewChild, false,
		// mListPadding.left,
		// false, mIsScrap[0]);
		// return view;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.056 -0400", hash_original_method = "D4F2FE3018B44C78CF4E93EBC6FE5FC7", hash_generated_method = "F0EF0C280354EF2678808319EE578889")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private View addViewBelow(View theView, int position) {
		dsTaint.addTaint(position);
		dsTaint.addTaint(theView.dsTaint);
		int belowPosition;
		belowPosition = position + 1;
		View view;
		view = obtainView(belowPosition, mIsScrap);
		int edgeOfNewChild;
		edgeOfNewChild = theView.getBottom() + mDividerHeight;
		setupChild(view, belowPosition, edgeOfNewChild, true,
				mListPadding.left, false, mIsScrap[0]);
		return (View) dsTaint.getTaint();
		// ---------- Original Method ----------
		// int belowPosition = position + 1;
		// View view = obtainView(belowPosition, mIsScrap);
		// int edgeOfNewChild = theView.getBottom() + mDividerHeight;
		// setupChild(view, belowPosition, edgeOfNewChild, true,
		// mListPadding.left,
		// false, mIsScrap[0]);
		// return view;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.056 -0400", hash_original_method = "B028681B6F4AF7B56D2E022B96A1F853", hash_generated_method = "9FEABB7B55BDA6BEEF48436F40D117BD")
	@DSModeled(DSC.SAFE)
	public void setItemsCanFocus(boolean itemsCanFocus) {
		dsTaint.addTaint(itemsCanFocus);
		{
			setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
		} // End block
			// ---------- Original Method ----------
			// mItemsCanFocus = itemsCanFocus;
			// if (!itemsCanFocus) {
			// setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.056 -0400", hash_original_method = "1C95AE1007B5CDC38C9B3E3B2904F365", hash_generated_method = "E820381255C1C06F3355357976010E3E")
	@DSModeled(DSC.SAFE)
	public boolean getItemsCanFocus() {
		return dsTaint.getTaintBoolean();
		// ---------- Original Method ----------
		// return mItemsCanFocus;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.056 -0400", hash_original_method = "719E5FD40BAA2B7205DD0269FBFE398A", hash_generated_method = "F0C38809C714D656F38B7644B087BA0B")
	// DSFIXME: CODE0002: Requires DSC value to be set
	@Override
	public boolean isOpaque() {
		boolean retValue;
		retValue = (mCachingActive && mIsCacheColorOpaque && mDividerIsOpaque && hasOpaqueScrollbars())
				|| super.isOpaque();
		{
			int listTop;
			listTop = mListPadding.top;
			listTop = mPaddingTop;
			View first;
			first = getChildAt(0);
			{
				boolean var37967F45E1391B4313D5330FBE659A90_667247148 = (first == null || first
						.getTop() > listTop);
			} // End collapsed parenthetic
			final int listBottom;
			listBottom = getHeight()
					- (mListPadding != null ? mListPadding.bottom
							: mPaddingBottom);// DSFIXME: CODE0008: Nested
												// ternary operator in
												// expression
			View last;
			last = getChildAt(getChildCount() - 1);
			{
				boolean varA905B41E3DA83EC3F86F88778ACFCAD2_1862014909 = (last == null || last
						.getBottom() < listBottom);
			} // End collapsed parenthetic
		} // End block
		return dsTaint.getTaintBoolean();
		// ---------- Original Method ----------
		// boolean retValue = (mCachingActive && mIsCacheColorOpaque &&
		// mDividerIsOpaque &&
		// hasOpaqueScrollbars()) || super.isOpaque();
		// if (retValue) {
		// final int listTop = mListPadding != null ? mListPadding.top :
		// mPaddingTop;
		// View first = getChildAt(0);
		// if (first == null || first.getTop() > listTop) {
		// return false;
		// }
		// final int listBottom = getHeight() -
		// (mListPadding != null ? mListPadding.bottom : mPaddingBottom);
		// View last = getChildAt(getChildCount() - 1);
		// if (last == null || last.getBottom() < listBottom) {
		// return false;
		// }
		// }
		// return retValue;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.056 -0400", hash_original_method = "465D449366429949FD8ADA654918A0E2", hash_generated_method = "9F4CEF48854BE0654FE3AF18809524B4")
	@DSModeled(DSC.SAFE)
	@Override
	public void setCacheColorHint(int color) {
		dsTaint.addTaint(color);
		final boolean opaque;
		opaque = (color >>> 24) == 0xFF;
		mIsCacheColorOpaque = opaque;
		{
			{
				mDividerPaint = new Paint();
			} // End block
			mDividerPaint.setColor(color);
		} // End block
		super.setCacheColorHint(color);
		// ---------- Original Method ----------
		// final boolean opaque = (color >>> 24) == 0xFF;
		// mIsCacheColorOpaque = opaque;
		// if (opaque) {
		// if (mDividerPaint == null) {
		// mDividerPaint = new Paint();
		// }
		// mDividerPaint.setColor(color);
		// }
		// super.setCacheColorHint(color);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.057 -0400", hash_original_method = "9A5C934D25A361940ECD1D897C78B567", hash_generated_method = "7EA197DA3487CF19C10A9F07B4B86426")
	@DSModeled(DSC.SAFE)
	void drawOverscrollHeader(Canvas canvas, Drawable drawable, Rect bounds) {
		dsTaint.addTaint(bounds.dsTaint);
		dsTaint.addTaint(canvas.dsTaint);
		dsTaint.addTaint(drawable.dsTaint);
		final int height;
		height = drawable.getMinimumHeight();
		canvas.save();
		canvas.clipRect(bounds);
		final int span;
		span = bounds.bottom - bounds.top;
		{
			bounds.top = bounds.bottom - height;
		} // End block
		drawable.setBounds(bounds);
		drawable.draw(canvas);
		canvas.restore();
		// ---------- Original Method ----------
		// final int height = drawable.getMinimumHeight();
		// canvas.save();
		// canvas.clipRect(bounds);
		// final int span = bounds.bottom - bounds.top;
		// if (span < height) {
		// bounds.top = bounds.bottom - height;
		// }
		// drawable.setBounds(bounds);
		// drawable.draw(canvas);
		// canvas.restore();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.057 -0400", hash_original_method = "3C862E16BE3AA71DC427E03E79AFA46F", hash_generated_method = "CC336FB223A9F0FE0CD43570023E355D")
	@DSModeled(DSC.SAFE)
	void drawOverscrollFooter(Canvas canvas, Drawable drawable, Rect bounds) {
		dsTaint.addTaint(bounds.dsTaint);
		dsTaint.addTaint(canvas.dsTaint);
		dsTaint.addTaint(drawable.dsTaint);
		final int height;
		height = drawable.getMinimumHeight();
		canvas.save();
		canvas.clipRect(bounds);
		final int span;
		span = bounds.bottom - bounds.top;
		{
			bounds.bottom = bounds.top + height;
		} // End block
		drawable.setBounds(bounds);
		drawable.draw(canvas);
		canvas.restore();
		// ---------- Original Method ----------
		// final int height = drawable.getMinimumHeight();
		// canvas.save();
		// canvas.clipRect(bounds);
		// final int span = bounds.bottom - bounds.top;
		// if (span < height) {
		// bounds.bottom = bounds.top + height;
		// }
		// drawable.setBounds(bounds);
		// drawable.draw(canvas);
		// canvas.restore();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.058 -0400", hash_original_method = "2FA3D064F2DBB643D61459E2FE6AA64C", hash_generated_method = "48F5542789DAC301C5D1ACEA4BF52DCE")
	// DSFIXME: CODE0002: Requires DSC value to be set
	@Override
	protected void dispatchDraw(Canvas canvas) {
		dsTaint.addTaint(canvas.dsTaint);
		{
			mCachingActive = true;
		} // End block
		final int dividerHeight;
		dividerHeight = mDividerHeight;
		final Drawable overscrollHeader;
		overscrollHeader = mOverScrollHeader;
		final Drawable overscrollFooter;
		overscrollFooter = mOverScrollFooter;
		final boolean drawOverscrollHeader;
		drawOverscrollHeader = overscrollHeader != null;
		final boolean drawOverscrollFooter;
		drawOverscrollFooter = overscrollFooter != null;
		final boolean drawDividers;
		drawDividers = dividerHeight > 0 && mDivider != null;
		{
			final Rect bounds;
			bounds = mTempRect;
			bounds.left = mPaddingLeft;
			bounds.right = mRight - mLeft - mPaddingRight;
			final int count;
			count = getChildCount();
			final int headerCount;
			headerCount = mHeaderViewInfos.size();
			final int itemCount;
			itemCount = mItemCount;
			final int footerLimit;
			footerLimit = itemCount - mFooterViewInfos.size() - 1;
			final boolean headerDividers;
			headerDividers = mHeaderDividersEnabled;
			final boolean footerDividers;
			footerDividers = mFooterDividersEnabled;
			final int first;
			first = mFirstPosition;
			final boolean areAllItemsSelectable;
			areAllItemsSelectable = mAreAllItemsSelectable;
			final ListAdapter adapter;
			adapter = mAdapter;
			final boolean fillForMissingDividers;
			fillForMissingDividers = isOpaque() && !super.isOpaque();
			{
				mDividerPaint = new Paint();
				mDividerPaint.setColor(getCacheColorHint());
			} // End block
			final Paint paint;
			paint = mDividerPaint;
			int effectivePaddingTop;
			effectivePaddingTop = 0;
			int effectivePaddingBottom;
			effectivePaddingBottom = 0;
			{
				effectivePaddingTop = mListPadding.top;
				effectivePaddingBottom = mListPadding.bottom;
			} // End block
			final int listBottom;
			listBottom = mBottom - mTop - effectivePaddingBottom + mScrollY;
			{
				int bottom;
				bottom = 0;
				final int scrollY;
				scrollY = mScrollY;
				{
					{
						bounds.bottom = 0;
						bounds.top = scrollY;
						drawOverscrollHeader(canvas, overscrollHeader, bounds);
					} // End block
					{
						bounds.bottom = 0;
						bounds.top = -dividerHeight;
						drawDivider(canvas, bounds, -1);
					} // End block
				} // End block
				{
					int i;
					i = 0;
					{
						{
							View child;
							child = getChildAt(i);
							bottom = child.getBottom();
							{
								{
									boolean var6726FD4BAAAC9954E951547807371C28_413190838 = ((areAllItemsSelectable || (adapter
											.isEnabled(first + i) && (i == count - 1 || adapter
											.isEnabled(first + i + 1)))));
									{
										bounds.top = bottom;
										bounds.bottom = bottom + dividerHeight;
										drawDivider(canvas, bounds, i);
									} // End block
									{
										bounds.top = bottom;
										bounds.bottom = bottom + dividerHeight;
										canvas.drawRect(bounds, paint);
									} // End block
								} // End collapsed parenthetic
							} // End block
						} // End block
					} // End block
				} // End collapsed parenthetic
				final int overFooterBottom;
				overFooterBottom = mBottom + mScrollY;
				{
					bounds.top = bottom;
					bounds.bottom = overFooterBottom;
					drawOverscrollFooter(canvas, overscrollFooter, bounds);
				} // End block
			} // End block
			{
				int top;
				final int scrollY;
				scrollY = mScrollY;
				{
					bounds.top = scrollY;
					bounds.bottom = getChildAt(0).getTop();
					drawOverscrollHeader(canvas, overscrollHeader, bounds);
				} // End block
				int start;
				start = 1;
				start = 0;
				{
					int i;
					i = start;
					{
						{
							View child;
							child = getChildAt(i);
							top = child.getTop();
							{
								{
									boolean var6726FD4BAAAC9954E951547807371C28_1332125819 = ((areAllItemsSelectable || (adapter
											.isEnabled(first + i) && (i == count - 1 || adapter
											.isEnabled(first + i + 1)))));
									{
										bounds.top = top - dividerHeight;
										bounds.bottom = top;
										drawDivider(canvas, bounds, i - 1);
									} // End block
									{
										bounds.top = top - dividerHeight;
										bounds.bottom = top;
										canvas.drawRect(bounds, paint);
									} // End block
								} // End collapsed parenthetic
							} // End block
						} // End block
					} // End block
				} // End collapsed parenthetic
				{
					{
						final int absListBottom;
						absListBottom = mBottom;
						bounds.top = absListBottom;
						bounds.bottom = absListBottom + scrollY;
						drawOverscrollFooter(canvas, overscrollFooter, bounds);
					} // End block
					{
						bounds.top = listBottom;
						bounds.bottom = listBottom + dividerHeight;
						drawDivider(canvas, bounds, -1);
					} // End block
				} // End block
			} // End block
		} // End block
		super.dispatchDraw(canvas);
		// ---------- Original Method ----------
		// Original Method Too Long, Refer to Original Implementation
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.058 -0400", hash_original_method = "4EC2B6750B1C7732AC3B627095EC138F", hash_generated_method = "183A1F213694AAC50765936CB042A51B")
	@DSModeled(DSC.SAFE)
	@Override
	protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
		dsTaint.addTaint(child.dsTaint);
		dsTaint.addTaint(canvas.dsTaint);
		dsTaint.addTaint(drawingTime);
		boolean more;
		more = super.drawChild(canvas, child, drawingTime);
		{
			mCachingActive = false;
		} // End block
		return dsTaint.getTaintBoolean();
		// ---------- Original Method ----------
		// boolean more = super.drawChild(canvas, child, drawingTime);
		// if (mCachingActive && child.mCachingFailed) {
		// mCachingActive = false;
		// }
		// return more;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.058 -0400", hash_original_method = "AB3CC143C94AF212348DFB5018C60850", hash_generated_method = "B0CC4D9094CA8FE7DDE1CD293B73EA9C")
	@DSModeled(DSC.SAFE)
	void drawDivider(Canvas canvas, Rect bounds, int childIndex) {
		dsTaint.addTaint(bounds.dsTaint);
		dsTaint.addTaint(canvas.dsTaint);
		dsTaint.addTaint(childIndex);
		final Drawable divider;
		divider = mDivider;
		divider.setBounds(bounds);
		divider.draw(canvas);
		// ---------- Original Method ----------
		// final Drawable divider = mDivider;
		// divider.setBounds(bounds);
		// divider.draw(canvas);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.058 -0400", hash_original_method = "7B5403D1FD6AC98A776FCB41ADD8E487", hash_generated_method = "4D0BBE967CF7F5CF41780C71061F1EF4")
	@DSModeled(DSC.SAFE)
	public Drawable getDivider() {
		return (Drawable) dsTaint.getTaint();
		// ---------- Original Method ----------
		// return mDivider;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.058 -0400", hash_original_method = "7913B276C2BDCD5302E597BC9A4CB654", hash_generated_method = "044F15FC5414448786624346A4BF100C")
	// DSFIXME: CODE0002: Requires DSC value to be set
	public void setDivider(Drawable divider) {
		dsTaint.addTaint(divider.dsTaint);
		{
			mDividerHeight = divider.getIntrinsicHeight();
		} // End block
		{
			mDividerHeight = 0;
		} // End block
		mDividerIsOpaque = divider == null
				|| divider.getOpacity() == PixelFormat.OPAQUE;
		requestLayout();
		invalidate();
		// ---------- Original Method ----------
		// if (divider != null) {
		// mDividerHeight = divider.getIntrinsicHeight();
		// } else {
		// mDividerHeight = 0;
		// }
		// mDivider = divider;
		// mDividerIsOpaque = divider == null || divider.getOpacity() ==
		// PixelFormat.OPAQUE;
		// requestLayout();
		// invalidate();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.059 -0400", hash_original_method = "229663AAAB1BC0B50485AD0B5CC199F3", hash_generated_method = "D691CA51EBD06CA263F75A8CBDA13D66")
	@DSModeled(DSC.SAFE)
	public int getDividerHeight() {
		return dsTaint.getTaintInt();
		// ---------- Original Method ----------
		// return mDividerHeight;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.059 -0400", hash_original_method = "D3D08555D2F9E637F163A09E680CBA08", hash_generated_method = "5C25BDF7936B00013B836C06CF9D9D58")
	@DSModeled(DSC.SAFE)
	public void setDividerHeight(int height) {
		dsTaint.addTaint(height);
		requestLayout();
		invalidate();
		// ---------- Original Method ----------
		// mDividerHeight = height;
		// requestLayout();
		// invalidate();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.059 -0400", hash_original_method = "97442AC2339A7874BFA41866E47D7310", hash_generated_method = "CF78482AB77BF660CAFF1D525A46C822")
	@DSModeled(DSC.SAFE)
	public void setHeaderDividersEnabled(boolean headerDividersEnabled) {
		dsTaint.addTaint(headerDividersEnabled);
		invalidate();
		// ---------- Original Method ----------
		// mHeaderDividersEnabled = headerDividersEnabled;
		// invalidate();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.059 -0400", hash_original_method = "74ACE2244DDEB7C7F913E5E0F875653E", hash_generated_method = "45EEA81BF5C76D1C7C50F46A65EC3555")
	@DSModeled(DSC.SAFE)
	public void setFooterDividersEnabled(boolean footerDividersEnabled) {
		dsTaint.addTaint(footerDividersEnabled);
		invalidate();
		// ---------- Original Method ----------
		// mFooterDividersEnabled = footerDividersEnabled;
		// invalidate();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.059 -0400", hash_original_method = "953E541E16240F0325506F6534EE33B4", hash_generated_method = "241F76020016E25626443D1E0CCB64C7")
	@DSModeled(DSC.SAFE)
	public void setOverscrollHeader(Drawable header) {
		dsTaint.addTaint(header.dsTaint);
		{
			invalidate();
		} // End block
			// ---------- Original Method ----------
			// mOverScrollHeader = header;
			// if (mScrollY < 0) {
			// invalidate();
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.059 -0400", hash_original_method = "95FFBAE371294243FE9AD2355C3622A4", hash_generated_method = "4218BD8192EB46D092A2E7CAC7A9E817")
	@DSModeled(DSC.SAFE)
	public Drawable getOverscrollHeader() {
		return (Drawable) dsTaint.getTaint();
		// ---------- Original Method ----------
		// return mOverScrollHeader;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.059 -0400", hash_original_method = "E2CA032ECDDC156C9CE8335D95975846", hash_generated_method = "5608D1850B8A3909AED37CA78557022D")
	@DSModeled(DSC.SAFE)
	public void setOverscrollFooter(Drawable footer) {
		dsTaint.addTaint(footer.dsTaint);
		invalidate();
		// ---------- Original Method ----------
		// mOverScrollFooter = footer;
		// invalidate();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.059 -0400", hash_original_method = "C43851852530BF4773181DC349AD3704", hash_generated_method = "76ED3FC9DBE3A1CCC001EBF6B823EEA8")
	@DSModeled(DSC.SAFE)
	public Drawable getOverscrollFooter() {
		return (Drawable) dsTaint.getTaint();
		// ---------- Original Method ----------
		// return mOverScrollFooter;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.059 -0400", hash_original_method = "A140BD3D04197A195532B0C2217798E2", hash_generated_method = "B83068B84A04D5FB4B87572733EAEA9E")
	// DSFIXME: CODE0002: Requires DSC value to be set
	@Override
	protected void onFocusChanged(boolean gainFocus, int direction,
			Rect previouslyFocusedRect) {
		// DSFIXME: CODE0009: Possible callback target function detected
		dsTaint.addTaint(gainFocus);
		dsTaint.addTaint(direction);
		dsTaint.addTaint(previouslyFocusedRect.dsTaint);
		super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
		final ListAdapter adapter;
		adapter = mAdapter;
		int closetChildIndex;
		closetChildIndex = -1;
		int closestChildTop;
		closestChildTop = 0;
		{
			previouslyFocusedRect.offset(mScrollX, mScrollY);
			{
				boolean var834FA86141DD35F45E58D6AC3B8AC266_1767453773 = (adapter
						.getCount() < getChildCount() + mFirstPosition);
				{
					mLayoutMode = LAYOUT_NORMAL;
					layoutChildren();
				} // End block
			} // End collapsed parenthetic
			Rect otherRect;
			otherRect = mTempRect;
			int minDistance;
			minDistance = Integer.MAX_VALUE;
			final int childCount;
			childCount = getChildCount();
			final int firstPosition;
			firstPosition = mFirstPosition;
			{
				int i;
				i = 0;
				{
					{
						boolean varF0493CBC36FEE8A37314533655677361_1145526357 = (!adapter
								.isEnabled(firstPosition + i));
					} // End collapsed parenthetic
					View other;
					other = getChildAt(i);
					other.getDrawingRect(otherRect);
					offsetDescendantRectToMyCoords(other, otherRect);
					int distance;
					distance = getDistance(previouslyFocusedRect, otherRect,
							direction);
					{
						minDistance = distance;
						closetChildIndex = i;
						closestChildTop = other.getTop();
					} // End block
				} // End block
			} // End collapsed parenthetic
		} // End block
		{
			setSelectionFromTop(closetChildIndex + mFirstPosition,
					closestChildTop);
		} // End block
		{
			requestLayout();
		} // End block
			// ---------- Original Method ----------
			// Original Method Too Long, Refer to Original Implementation
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.059 -0400", hash_original_method = "33666A5E6A3C0638CD57027CC0FE1CC1", hash_generated_method = "C21862CE6CFF38C23D32CEC1B43B0339")
	// DSFIXME: CODE0002: Requires DSC value to be set
	@Override
	protected void onFinishInflate() {
		// DSFIXME: CODE0009: Possible callback target function detected
		super.onFinishInflate();
		int count;
		count = getChildCount();
		{
			{
				int i;
				i = 0;
				{
					addHeaderView(getChildAt(i));
				} // End block
			} // End collapsed parenthetic
			removeAllViews();
		} // End block
			// ---------- Original Method ----------
			// super.onFinishInflate();
			// int count = getChildCount();
			// if (count > 0) {
			// for (int i = 0; i < count; ++i) {
			// addHeaderView(getChildAt(i));
		// }
		// removeAllViews();
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.060 -0400", hash_original_method = "55B474F0526D1B513F7B1BB91F273A6A", hash_generated_method = "5278F3312CCE20069AA8693EB595F93B")
	// DSFIXME: CODE0002: Requires DSC value to be set
	@Override
	protected View findViewTraversal(int id) {
		dsTaint.addTaint(id);
		View v;
		v = super.findViewTraversal(id);
		{
			v = findViewInHeadersOrFooters(mHeaderViewInfos, id);
			v = findViewInHeadersOrFooters(mFooterViewInfos, id);
		} // End block
		return (View) dsTaint.getTaint();
		// ---------- Original Method ----------
		// View v;
		// v = super.findViewTraversal(id);
		// if (v == null) {
		// v = findViewInHeadersOrFooters(mHeaderViewInfos, id);
		// if (v != null) {
		// return v;
		// }
		// v = findViewInHeadersOrFooters(mFooterViewInfos, id);
		// if (v != null) {
		// return v;
		// }
		// }
		// return v;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.060 -0400", hash_original_method = "CE5790FF46C8EC9157EF966632ADD833", hash_generated_method = "E31C3B03225433783C4DB8C5662B7135")
	// DSFIXME: CODE0002: Requires DSC value to be set
	View findViewInHeadersOrFooters(ArrayList<FixedViewInfo> where, int id) {
		dsTaint.addTaint(id);
		dsTaint.addTaint(where.dsTaint);
		{
			int len;
			len = where.size();
			View v;
			{
				int i;
				i = 0;
				{
					v = where.get(i).view;
					{
						boolean var3F751ABEC959446BA6608C20A1A0BA91_1615077492 = (!v
								.isRootNamespace());
						{
							v = v.findViewById(id);
						} // End block
					} // End collapsed parenthetic
				} // End block
			} // End collapsed parenthetic
		} // End block
		return (View) dsTaint.getTaint();
		// ---------- Original Method ----------
		// if (where != null) {
		// int len = where.size();
		// View v;
		// for (int i = 0; i < len; i++) {
		// v = where.get(i).view;
		// if (!v.isRootNamespace()) {
		// v = v.findViewById(id);
		// if (v != null) {
		// return v;
		// }
		// }
		// }
		// }
		// return null;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.060 -0400", hash_original_method = "3E2A521CFE9847E9FDB3AEC6F88A76DD", hash_generated_method = "A3D50BDFEE2AFC34D30D46A9FAA0D3DA")
	// DSFIXME: CODE0002: Requires DSC value to be set
	@Override
	protected View findViewWithTagTraversal(Object tag) {
		dsTaint.addTaint(tag.dsTaint);
		View v;
		v = super.findViewWithTagTraversal(tag);
		{
			v = findViewWithTagInHeadersOrFooters(mHeaderViewInfos, tag);
			v = findViewWithTagInHeadersOrFooters(mFooterViewInfos, tag);
		} // End block
		return (View) dsTaint.getTaint();
		// ---------- Original Method ----------
		// View v;
		// v = super.findViewWithTagTraversal(tag);
		// if (v == null) {
		// v = findViewWithTagInHeadersOrFooters(mHeaderViewInfos, tag);
		// if (v != null) {
		// return v;
		// }
		// v = findViewWithTagInHeadersOrFooters(mFooterViewInfos, tag);
		// if (v != null) {
		// return v;
		// }
		// }
		// return v;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.060 -0400", hash_original_method = "FB5700AACE78A96EA34C4186153EA1D8", hash_generated_method = "46342F25230685CA4FB0AE0A6F2D218B")
	// DSFIXME: CODE0002: Requires DSC value to be set
	View findViewWithTagInHeadersOrFooters(ArrayList<FixedViewInfo> where,
			Object tag) {
		dsTaint.addTaint(tag.dsTaint);
		dsTaint.addTaint(where.dsTaint);
		{
			int len;
			len = where.size();
			View v;
			{
				int i;
				i = 0;
				{
					v = where.get(i).view;
					{
						boolean var3F751ABEC959446BA6608C20A1A0BA91_944594246 = (!v
								.isRootNamespace());
						{
							v = v.findViewWithTag(tag);
						} // End block
					} // End collapsed parenthetic
				} // End block
			} // End collapsed parenthetic
		} // End block
		return (View) dsTaint.getTaint();
		// ---------- Original Method ----------
		// if (where != null) {
		// int len = where.size();
		// View v;
		// for (int i = 0; i < len; i++) {
		// v = where.get(i).view;
		// if (!v.isRootNamespace()) {
		// v = v.findViewWithTag(tag);
		// if (v != null) {
		// return v;
		// }
		// }
		// }
		// }
		// return null;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.060 -0400", hash_original_method = "C4FCF9CDE386456E06D0A36ACE84F436", hash_generated_method = "FAD2B0A2FE8BFA278682666DDD62C6E7")
	// DSFIXME: CODE0002: Requires DSC value to be set
	@Override
	protected View findViewByPredicateTraversal(Predicate<View> predicate,
			View childToSkip) {
		dsTaint.addTaint(childToSkip.dsTaint);
		dsTaint.addTaint(predicate.dsTaint);
		View v;
		v = super.findViewByPredicateTraversal(predicate, childToSkip);
		{
			v = findViewByPredicateInHeadersOrFooters(mHeaderViewInfos,
					predicate, childToSkip);
			v = findViewByPredicateInHeadersOrFooters(mFooterViewInfos,
					predicate, childToSkip);
		} // End block
		return (View) dsTaint.getTaint();
		// ---------- Original Method ----------
		// View v;
		// v = super.findViewByPredicateTraversal(predicate, childToSkip);
		// if (v == null) {
		// v = findViewByPredicateInHeadersOrFooters(mHeaderViewInfos,
		// predicate, childToSkip);
		// if (v != null) {
		// return v;
		// }
		// v = findViewByPredicateInHeadersOrFooters(mFooterViewInfos,
		// predicate, childToSkip);
		// if (v != null) {
		// return v;
		// }
		// }
		// return v;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.060 -0400", hash_original_method = "D1F1A1145A67766E94BF084DFEF4A6A9", hash_generated_method = "725BC13362C2E395D39F5FFBE18A72B5")
	// DSFIXME: CODE0002: Requires DSC value to be set
	View findViewByPredicateInHeadersOrFooters(ArrayList<FixedViewInfo> where,
			Predicate<View> predicate, View childToSkip) {
		dsTaint.addTaint(childToSkip.dsTaint);
		dsTaint.addTaint(predicate.dsTaint);
		dsTaint.addTaint(where.dsTaint);
		{
			int len;
			len = where.size();
			View v;
			{
				int i;
				i = 0;
				{
					v = where.get(i).view;
					{
						boolean varE559F145C9972D4F93FC59CF981B09D2_673286627 = (v != childToSkip && !v
								.isRootNamespace());
						{
							v = v.findViewByPredicate(predicate);
						} // End block
					} // End collapsed parenthetic
				} // End block
			} // End collapsed parenthetic
		} // End block
		return (View) dsTaint.getTaint();
		// ---------- Original Method ----------
		// if (where != null) {
		// int len = where.size();
		// View v;
		// for (int i = 0; i < len; i++) {
		// v = where.get(i).view;
		// if (v != childToSkip && !v.isRootNamespace()) {
		// v = v.findViewByPredicate(predicate);
		// if (v != null) {
		// return v;
		// }
		// }
		// }
		// }
		// return null;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.061 -0400", hash_original_method = "7376DB3A956D54D1A994EA4B9B95B8AF", hash_generated_method = "9C65E391C6F15D608586BFC3B55335A9")
	// DSFIXME: CODE0002: Requires DSC value to be set
	@Deprecated
	public long[] getCheckItemIds() {
		{
			boolean var92A5B2B773F784D23AACADEC549061AE_1606781501 = (mAdapter != null && mAdapter
					.hasStableIds());
			{
				long[] varEA0F92157511B761BCA87A37A949584F_741852893 = (getCheckedItemIds());
			} // End block
		} // End collapsed parenthetic
		{
			final SparseBooleanArray states;
			states = mCheckStates;
			final int count;
			count = states.size();
			final long[] ids;
			ids = new long[count];
			final ListAdapter adapter;
			adapter = mAdapter;
			int checkedCount;
			checkedCount = 0;
			{
				int i;
				i = 0;
				{
					{
						boolean var06DB0322BE5DDF244F3C57344F69D711_905401677 = (states
								.valueAt(i));
						{
							ids[checkedCount++] = adapter.getItemId(states
									.keyAt(i));
						} // End block
					} // End collapsed parenthetic
				} // End block
			} // End collapsed parenthetic
			{
				final long[] result;
				result = new long[checkedCount];
				System.arraycopy(ids, 0, result, 0, checkedCount);
			} // End block
		} // End block
		long[] retVal = new long[1];
		retVal[0] = dsTaint.getTaintInt();
		return retVal;
		// ---------- Original Method ----------
		// Original Method Too Long, Refer to Original Implementation
	}

	public class FixedViewInfo {
		public View view;
		public Object data;
		public boolean isSelectable;

	}

	private class FocusSelector implements Runnable {
		private int mPosition;
		private int mPositionTop;

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.061 -0400", hash_original_method = "5C0213FE7A42F47411000D870177F1B7", hash_generated_method = "4754A85737E3D6AC56B52AADF951F980")
		@DSModeled(DSC.SAFE)
		public FocusSelector setup(int position, int top) {
			dsTaint.addTaint(position);
			dsTaint.addTaint(top);
			return (FocusSelector) dsTaint.getTaint();
			// ---------- Original Method ----------
			// mPosition = position;
			// mPositionTop = top;
			// return this;
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.061 -0400", hash_original_method = "1C9CFC3992CD17CE1A3B73D68C8C6081", hash_generated_method = "34C441CA23B4EB90FAD80CF0B15696D0")
		@DSModeled(DSC.SAFE)
		public void run() {
			setSelectionFromTop(mPosition, mPositionTop);
			// ---------- Original Method ----------
			// setSelectionFromTop(mPosition, mPositionTop);
		}

	}

	static private class ArrowScrollFocusResult {
		private int mSelectedPosition;
		private int mAmountToScroll;

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.061 -0400", hash_original_method = "E4C7C1A71AB7D603722F7CE31ED09575", hash_generated_method = "C3F9250E9EE780E25C3CD25BB9AB4CB4")
		@DSModeled(DSC.SAFE)
		void populate(int selectedPosition, int amountToScroll) {
			dsTaint.addTaint(amountToScroll);
			dsTaint.addTaint(selectedPosition);
			// ---------- Original Method ----------
			// mSelectedPosition = selectedPosition;
			// mAmountToScroll = amountToScroll;
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.061 -0400", hash_original_method = "57FF42983620727F309A47A5C295AFEC", hash_generated_method = "F36C9C9CEFADAE1192B09F15CEFF3402")
		@DSModeled(DSC.SAFE)
		public int getSelectedPosition() {
			return dsTaint.getTaintInt();
			// ---------- Original Method ----------
			// return mSelectedPosition;
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.061 -0400", hash_original_method = "547539826ED165E8A574C9320A564E9F", hash_generated_method = "D9D69A821B7FF5C02DFA6AF6F6467097")
		@DSModeled(DSC.SAFE)
		public int getAmountToScroll() {
			return dsTaint.getTaintInt();
			// ---------- Original Method ----------
			// return mAmountToScroll;
		}

	}

}
