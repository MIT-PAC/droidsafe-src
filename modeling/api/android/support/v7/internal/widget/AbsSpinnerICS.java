/*
 * Copyright (C) 2006 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.support.v7.internal.widget;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;

/**
 * An abstract base class for spinner widgets. SDK users will probably not
 * need to use this class.
 */
abstract class AbsSpinnerICS extends AdapterViewICS<SpinnerAdapter> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.205 -0400", hash_original_field = "F3411DF47899C6681AB924958C72D742", hash_generated_field = "F3411DF47899C6681AB924958C72D742")

    SpinnerAdapter mAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.207 -0400", hash_original_field = "D04E3D07D063C4D19518074C3829A73C", hash_generated_field = "D04E3D07D063C4D19518074C3829A73C")

    int mHeightMeasureSpec;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.209 -0400", hash_original_field = "955DE0D4DCC8871A233CEA8D2F0A0C8A", hash_generated_field = "955DE0D4DCC8871A233CEA8D2F0A0C8A")

    int mWidthMeasureSpec;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.211 -0400", hash_original_field = "16D5ED00E6F87F853BA44CD6D3C6B5B1", hash_generated_field = "16D5ED00E6F87F853BA44CD6D3C6B5B1")

    boolean mBlockLayoutRequests;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.213 -0400", hash_original_field = "753C8FC0C4D631C54FF77F2B10210084", hash_generated_field = "753C8FC0C4D631C54FF77F2B10210084")

    int mSelectionLeftPadding = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.215 -0400", hash_original_field = "50BDF542563848097B98D0F9CA864924", hash_generated_field = "50BDF542563848097B98D0F9CA864924")

    int mSelectionTopPadding = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.217 -0400", hash_original_field = "3DC4FB7C9491C740968135A630596AA0", hash_generated_field = "3DC4FB7C9491C740968135A630596AA0")

    int mSelectionRightPadding = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.219 -0400", hash_original_field = "7187B403BE2B79CEAB01DB70095A8709", hash_generated_field = "7187B403BE2B79CEAB01DB70095A8709")

    int mSelectionBottomPadding = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.222 -0400", hash_original_field = "8D45CA69A5C12AC47874747EF2F5D26E", hash_generated_field = "4083C73A2606B3CF98A9A07B6027B252")

    final Rect mSpinnerPadding = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.224 -0400", hash_original_field = "707525CCDB9513E977E0C2123AF49590", hash_generated_field = "9569056224CF4BB7FAE062DA5103E35A")

    final RecycleBin mRecycler = new RecycleBin();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.227 -0400", hash_original_field = "CA23E511E6F9771CC47A35D664CF38CE", hash_generated_field = "F16E8B0F167DE3008550015271235F93")

    private DataSetObserver mDataSetObserver;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.229 -0400", hash_original_field = "4B8DBDF8B13299F4A9AA8215ABC5FF7F", hash_generated_field = "08F5569C270EF171D6F208986E4909DE")

    private Rect mTouchFrame;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.231 -0400", hash_original_method = "02883A5CFFF9C8353A60482003794D36", hash_generated_method = "02883A5CFFF9C8353A60482003794D36")
    
AbsSpinnerICS(Context context) {
        super(context);
        initAbsSpinner();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.234 -0400", hash_original_method = "E5275392163E4283FA4BEAA765FC6AF5", hash_generated_method = "E5275392163E4283FA4BEAA765FC6AF5")
    
AbsSpinnerICS(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.236 -0400", hash_original_method = "DFD8B2A87908B1D50D268EA235CFAD07", hash_generated_method = "DFD8B2A87908B1D50D268EA235CFAD07")
    
AbsSpinnerICS(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initAbsSpinner();
    }

    /**
     * Common code for different constructor flavors
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.239 -0400", hash_original_method = "189B5B9E645B86B5245C2FF55DEC5907", hash_generated_method = "362784A39455FECC93B9947BF59423D1")
    
private void initAbsSpinner() {
        setFocusable(true);
        setWillNotDraw(false);
    }

    /**
     * The Adapter is used to provide the data which backs this Spinner.
     * It also provides methods to transform spinner items based on their position
     * relative to the selected item.
     * @param adapter The SpinnerAdapter to use for this Spinner
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.242 -0400", hash_original_method = "E5824BE9B0ACFF3A1B32EE310E006300", hash_generated_method = "A8CD1C7048782E7BF32B6A2A7FAD0DB3")
    
@Override
    public void setAdapter(SpinnerAdapter adapter) {
        if (null != mAdapter) {
            mAdapter.unregisterDataSetObserver(mDataSetObserver);
            resetList();
        }

        mAdapter = adapter;

        mOldSelectedPosition = INVALID_POSITION;
        mOldSelectedRowId = INVALID_ROW_ID;

        if (mAdapter != null) {
            mOldItemCount = mItemCount;
            mItemCount = mAdapter.getCount();
            checkFocus();

            mDataSetObserver = new AdapterDataSetObserver();
            mAdapter.registerDataSetObserver(mDataSetObserver);

            int position = mItemCount > 0 ? 0 : INVALID_POSITION;

            setSelectedPositionInt(position);
            setNextSelectedPositionInt(position);

            if (mItemCount == 0) {
                // Nothing selected
                checkSelectionChanged();
            }

        } else {
            checkFocus();
            resetList();
            // Nothing selected
            checkSelectionChanged();
        }

        requestLayout();
    }

    /**
     * Clear out all children from the list
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.244 -0400", hash_original_method = "5DEE49E4A107B00C6160988898CCE14A", hash_generated_method = "5DEE49E4A107B00C6160988898CCE14A")
    
void resetList() {
        mDataChanged = false;
        mNeedSync = false;

        removeAllViewsInLayout();
        mOldSelectedPosition = INVALID_POSITION;
        mOldSelectedRowId = INVALID_ROW_ID;

        setSelectedPositionInt(INVALID_POSITION);
        setNextSelectedPositionInt(INVALID_POSITION);
        invalidate();
    }

    /**
     * @see android.view.View#measure(int, int)
     *
     * Figure out the dimensions of this Spinner. The width comes from
     * the widthMeasureSpec as Spinnners can't have their width set to
     * UNSPECIFIED. The height is based on the height of the selected item
     * plus padding.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.249 -0400", hash_original_method = "573DFCA3A6D45723DEFE4120CF8D651E", hash_generated_method = "3351E8E0A05A901D4AF73B1EC380150A")
    
@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize;
        int heightSize;

        final int paddingLeft = getPaddingLeft();
        final int paddingTop = getPaddingTop();
        final int paddingRight = getPaddingRight();
        final int paddingBottom = getPaddingBottom();

        mSpinnerPadding.left = paddingLeft > mSelectionLeftPadding ? paddingLeft
                : mSelectionLeftPadding;
        mSpinnerPadding.top = paddingTop > mSelectionTopPadding ? paddingTop
                : mSelectionTopPadding;
        mSpinnerPadding.right = paddingRight > mSelectionRightPadding ? paddingRight
                : mSelectionRightPadding;
        mSpinnerPadding.bottom = paddingBottom > mSelectionBottomPadding ? paddingBottom
                : mSelectionBottomPadding;

        if (mDataChanged) {
            handleDataChanged();
        }

        int preferredHeight = 0;
        int preferredWidth = 0;
        boolean needsMeasuring = true;

        int selectedPosition = getSelectedItemPosition();
        if (selectedPosition >= 0 && mAdapter != null && selectedPosition < mAdapter.getCount()) {
            // Try looking in the recycler. (Maybe we were measured once already)
            View view = mRecycler.get(selectedPosition);
            if (view == null) {
                // Make a new one
                view = mAdapter.getView(selectedPosition, null, this);
            }

            if (view != null) {
                // Put in recycler for re-measuring and/or layout
                mRecycler.put(selectedPosition, view);
            }

            if (view != null) {
                if (view.getLayoutParams() == null) {
                    mBlockLayoutRequests = true;
                    view.setLayoutParams(generateDefaultLayoutParams());
                    mBlockLayoutRequests = false;
                }
                measureChild(view, widthMeasureSpec, heightMeasureSpec);

                preferredHeight = getChildHeight(view) + mSpinnerPadding.top + mSpinnerPadding.bottom;
                preferredWidth = getChildWidth(view) + mSpinnerPadding.left + mSpinnerPadding.right;

                needsMeasuring = false;
            }
        }

        if (needsMeasuring) {
            // No views -- just use padding
            preferredHeight = mSpinnerPadding.top + mSpinnerPadding.bottom;
            if (widthMode == MeasureSpec.UNSPECIFIED) {
                preferredWidth = mSpinnerPadding.left + mSpinnerPadding.right;
            }
        }

        preferredHeight = Math.max(preferredHeight, getSuggestedMinimumHeight());
        preferredWidth = Math.max(preferredWidth, getSuggestedMinimumWidth());

        heightSize = resolveSize(preferredHeight, heightMeasureSpec);
        widthSize = resolveSize(preferredWidth, widthMeasureSpec);

        setMeasuredDimension(widthSize, heightSize);
        mHeightMeasureSpec = heightMeasureSpec;
        mWidthMeasureSpec = widthMeasureSpec;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.251 -0400", hash_original_method = "44D3B1A6F440757321735895159CF3F5", hash_generated_method = "44D3B1A6F440757321735895159CF3F5")
    
int getChildHeight(View child) {
        return child.getMeasuredHeight();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.254 -0400", hash_original_method = "3D627342594CC491E8B9982EF63DBDD8", hash_generated_method = "3D627342594CC491E8B9982EF63DBDD8")
    
int getChildWidth(View child) {
        return child.getMeasuredWidth();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.256 -0400", hash_original_method = "2179BEF90E842D00377926E5531ABF89", hash_generated_method = "ABC5E9F5739A26EC765110A888213B88")
    
@Override
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.259 -0400", hash_original_method = "DFD3706513DF6E8DDAF3349BC14B096B", hash_generated_method = "3756C1E95ADF2491444863684B6E563E")
    
void recycleAllViews() {
        final int childCount = getChildCount();
        final AbsSpinnerICS.RecycleBin recycleBin = mRecycler;
        final int position = mFirstPosition;

        // All views go in recycler
        for (int i = 0; i < childCount; i++) {
            View v = getChildAt(i);
            int index = position + i;
            recycleBin.put(index, v);
        }
    }

    /**
     * Jump directly to a specific item in the adapter data.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.262 -0400", hash_original_method = "D2708A7FDB907C7B6958E15DD672DA8E", hash_generated_method = "C3A5D610F87F4D3CECAE59DEBB9EE18C")
    
public void setSelection(int position, boolean animate) {
        // Animate only if requested position is already on screen somewhere
        boolean shouldAnimate = animate && mFirstPosition <= position &&
                position <= mFirstPosition + getChildCount() - 1;
        setSelectionInt(position, shouldAnimate);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.264 -0400", hash_original_method = "7E33360CBDBF59A4E473BBC01C4A9D09", hash_generated_method = "5A7C3B76C3326CF67657E51BD1F90B58")
    
@Override
    public void setSelection(int position) {
        setNextSelectedPositionInt(position);
        requestLayout();
        invalidate();
    }

    /**
     * Makes the item at the supplied position selected.
     *
     * @param position Position to select
     * @param animate Should the transition be animated
     *
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.267 -0400", hash_original_method = "63246E2C9E0D90A96046BA94228CF775", hash_generated_method = "63246E2C9E0D90A96046BA94228CF775")
    
void setSelectionInt(int position, boolean animate) {
        if (position != mOldSelectedPosition) {
            mBlockLayoutRequests = true;
            int delta  = position - mSelectedPosition;
            setNextSelectedPositionInt(position);
            layout(delta, animate);
            mBlockLayoutRequests = false;
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.269 -0400", hash_original_method = "E89B31DFCF88A65148B589897F629BD3", hash_generated_method = "DE3E4C3DF383C543F0AF8E96C0CE29EF")
    
abstract void layout(int delta, boolean animate);

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.271 -0400", hash_original_method = "B9D708BD110913DD38C752A46A05BBB4", hash_generated_method = "513703D89AB4B12AE4736D2F5E964FD5")
    
@Override
    public View getSelectedView() {
        if (mItemCount > 0 && mSelectedPosition >= 0) {
            return getChildAt(mSelectedPosition - mFirstPosition);
        } else {
            return null;
        }
    }

    /**
     * Override to prevent spamming ourselves with layout requests
     * as we place views
     *
     * @see android.view.View#requestLayout()
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.274 -0400", hash_original_method = "7199FF25ED586C3851E847C0919D8CB4", hash_generated_method = "07FC44E84DEB35164CA25A3FE21E0C66")
    
@Override
    public void requestLayout() {
        if (!mBlockLayoutRequests) {
            super.requestLayout();
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.276 -0400", hash_original_method = "0B2662100CCA74662649DCCD28954A76", hash_generated_method = "B2AD20E240F1F5A7AD66020C9F08265C")
    
@Override
    public SpinnerAdapter getAdapter() {
        return mAdapter;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.279 -0400", hash_original_method = "C515244CDC30F9529A71B0CAA70231C3", hash_generated_method = "01AD3C9DE5F33E89331C2C38A4EFAE12")
    
@Override
    public int getCount() {
        return mItemCount;
    }

    /**
     * Maps a point to a position in the list.
     *
     * @param x X in local coordinate
     * @param y Y in local coordinate
     * @return The position of the item which contains the specified point, or
     *         {@link #INVALID_POSITION} if the point does not intersect an item.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.282 -0400", hash_original_method = "AD87FEA47379DE9B1BE65A322C86E61D", hash_generated_method = "625D03B98CDA4B87EEAD3D117A57079B")
    
public int pointToPosition(int x, int y) {
        Rect frame = mTouchFrame;
        if (frame == null) {
            mTouchFrame = new Rect();
            frame = mTouchFrame;
        }

        final int count = getChildCount();
        for (int i = count - 1; i >= 0; i--) {
            View child = getChildAt(i);
            if (child.getVisibility() == View.VISIBLE) {
                child.getHitRect(frame);
                if (frame.contains(x, y)) {
                    return mFirstPosition + i;
                }
            }
        }
        return INVALID_POSITION;
    }

    static class SavedState extends BaseSavedState {

        public static final Parcelable.Creator<SavedState> CREATOR
                = new Parcelable.Creator<SavedState>() {
            @DSSafe(DSCat.SAFE_LIST)
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            @DSSafe(DSCat.SAFE_LIST)
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        long selectedId;
        int position;

        /**
         * Constructor called from {@link AbsSpinnerICS#onSaveInstanceState()}
         */
        SavedState(Parcelable superState) {
            super(superState);
        }

        /**
         * Constructor called from {@link #CREATOR}
         */
        private SavedState(Parcel in) {
            super(in);
            selectedId = in.readLong();
            position = in.readInt();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeLong(selectedId);
            out.writeInt(position);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public String toString() {
            return "AbsSpinner.SavedState{"
                    + Integer.toHexString(System.identityHashCode(this))
                    + " selectedId=" + selectedId
                    + " position=" + position + "}";
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.313 -0400", hash_original_method = "2B2E0178AF4521152109C90D1424ECD0", hash_generated_method = "0F01E07DD73E3F973CD57D0A62D38B74")
    
@Override
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        SavedState ss = new SavedState(superState);
        ss.selectedId = getSelectedItemId();
        if (ss.selectedId >= 0) {
            ss.position = getSelectedItemPosition();
        } else {
            ss.position = INVALID_POSITION;
        }
        return ss;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:42.315 -0400", hash_original_method = "41BC9B1A20EF7E956C712A8B84EE3401", hash_generated_method = "7D1B2596D4E45FA48A8841B2C2008EAA")
    
@Override
    public void onRestoreInstanceState(Parcelable state) {
        SavedState ss = (SavedState) state;

        super.onRestoreInstanceState(ss.getSuperState());

        if (ss.selectedId >= 0) {
            mDataChanged = true;
            mNeedSync = true;
            mSyncRowId = ss.selectedId;
            mSyncPosition = ss.position;
            mSyncMode = SYNC_SELECTED_POSITION;
            requestLayout();
        }
    }

    class RecycleBin {
        private final SparseArray<View> mScrapHeap = new SparseArray<View>();

        @DSSafe(DSCat.SAFE_LIST)
        public void put(int position, View v) {
            mScrapHeap.put(position, v);
        }

        @DSSafe(DSCat.SAFE_LIST)
        View get(int position) {
            // System.out.print("Looking for " + position);
            View result = mScrapHeap.get(position);
            if (result != null) {
                // System.out.println(" HIT");
                mScrapHeap.delete(position);
            } else {
                // System.out.println(" MISS");
            }
            return result;
        }

        @DSSafe(DSCat.SAFE_LIST)
        void clear() {
            final SparseArray<View> scrapHeap = mScrapHeap;
            final int count = scrapHeap.size();
            for (int i = 0; i < count; i++) {
                final View view = scrapHeap.valueAt(i);
                if (view != null) {
                    removeDetachedView(view, true);
                }
            }
            scrapHeap.clear();
        }
    }
}