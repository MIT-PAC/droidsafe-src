package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import com.android.internal.R;

public abstract class AbsSpinner extends AdapterView<SpinnerAdapter> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.316 -0500", hash_original_field = "F3411DF47899C6681AB924958C72D742", hash_generated_field = "F3411DF47899C6681AB924958C72D742")

    SpinnerAdapter mAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.318 -0500", hash_original_field = "D04E3D07D063C4D19518074C3829A73C", hash_generated_field = "D04E3D07D063C4D19518074C3829A73C")

    int mHeightMeasureSpec;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.320 -0500", hash_original_field = "955DE0D4DCC8871A233CEA8D2F0A0C8A", hash_generated_field = "955DE0D4DCC8871A233CEA8D2F0A0C8A")

    int mWidthMeasureSpec;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.321 -0500", hash_original_field = "16D5ED00E6F87F853BA44CD6D3C6B5B1", hash_generated_field = "16D5ED00E6F87F853BA44CD6D3C6B5B1")

    boolean mBlockLayoutRequests;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.323 -0500", hash_original_field = "753C8FC0C4D631C54FF77F2B10210084", hash_generated_field = "753C8FC0C4D631C54FF77F2B10210084")

    int mSelectionLeftPadding = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.326 -0500", hash_original_field = "50BDF542563848097B98D0F9CA864924", hash_generated_field = "50BDF542563848097B98D0F9CA864924")

    int mSelectionTopPadding = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.328 -0500", hash_original_field = "3DC4FB7C9491C740968135A630596AA0", hash_generated_field = "3DC4FB7C9491C740968135A630596AA0")

    int mSelectionRightPadding = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.330 -0500", hash_original_field = "7187B403BE2B79CEAB01DB70095A8709", hash_generated_field = "7187B403BE2B79CEAB01DB70095A8709")

    int mSelectionBottomPadding = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.332 -0500", hash_original_field = "8D45CA69A5C12AC47874747EF2F5D26E", hash_generated_field = "4083C73A2606B3CF98A9A07B6027B252")

    final Rect mSpinnerPadding = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.334 -0500", hash_original_field = "707525CCDB9513E977E0C2123AF49590", hash_generated_field = "9569056224CF4BB7FAE062DA5103E35A")

    final RecycleBin mRecycler = new RecycleBin();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.336 -0500", hash_original_field = "CA23E511E6F9771CC47A35D664CF38CE", hash_generated_field = "F16E8B0F167DE3008550015271235F93")

    private DataSetObserver mDataSetObserver;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.338 -0500", hash_original_field = "4B8DBDF8B13299F4A9AA8215ABC5FF7F", hash_generated_field = "08F5569C270EF171D6F208986E4909DE")

    private Rect mTouchFrame;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.340 -0500", hash_original_method = "CE4C0E9ECE12F7FD7C8BEF83C3609839", hash_generated_method = "C88C95489266CB21082196D3D9887AF4")
    
public AbsSpinner(Context context) {
        super(context);
        initAbsSpinner();
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.343 -0500", hash_original_method = "48F93C8F12C5C0BCE27736B4F067DE36", hash_generated_method = "BB7AE401C791CE88EB5416C56E9B6281")
    
public AbsSpinner(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.346 -0500", hash_original_method = "22AD9CC9923933C5995E60FF80D5916E", hash_generated_method = "6D727EB9C5BFAABF4BA8EC95894C7254")
    
public AbsSpinner(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initAbsSpinner();

        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.AbsSpinner, defStyle, 0);

        CharSequence[] entries = a.getTextArray(R.styleable.AbsSpinner_entries);
        if (entries != null) {
            ArrayAdapter<CharSequence> adapter =
                    new ArrayAdapter<CharSequence>(context,
                            R.layout.simple_spinner_item, entries);
            adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
            setAdapter(adapter);
        }

        a.recycle();
    }

    /**
     * Common code for different constructor flavors
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.348 -0500", hash_original_method = "189B5B9E645B86B5245C2FF55DEC5907", hash_generated_method = "362784A39455FECC93B9947BF59423D1")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.351 -0500", hash_original_method = "E5824BE9B0ACFF3A1B32EE310E006300", hash_generated_method = "A8CD1C7048782E7BF32B6A2A7FAD0DB3")
    
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
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.353 -0500", hash_original_method = "5DEE49E4A107B00C6160988898CCE14A", hash_generated_method = "5DEE49E4A107B00C6160988898CCE14A")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.357 -0500", hash_original_method = "29BB60D69D80C0C6339E2E86482D98C0", hash_generated_method = "73A567AF61A15B00BBAA2CBD15A6F18F")
    
@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize;
        int heightSize;
        mSpinnerPadding.addTaint(mPaddingLeft + mSelectionLeftPadding +
                mPaddingRight + mSelectionRightPadding + 
                mPaddingBottom + mSelectionBottomPadding + 
                mPaddingTop  + mSelectionTopPadding 
                );

/*        mSpinnerPadding.left = mPaddingLeft > mSelectionLeftPadding ? mPaddingLeft
                : mSelectionLeftPadding;
        mSpinnerPadding.top = mPaddingTop > mSelectionTopPadding ? mPaddingTop
                : mSelectionTopPadding;
        mSpinnerPadding.right = mPaddingRight > mSelectionRightPadding ? mPaddingRight
                : mSelectionRightPadding;
        mSpinnerPadding.bottom = mPaddingBottom > mSelectionBottomPadding ? mPaddingBottom
                : mSelectionBottomPadding;
*/
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

        heightSize = resolveSizeAndState(preferredHeight, heightMeasureSpec, 0);
        widthSize = resolveSizeAndState(preferredWidth, widthMeasureSpec, 0);

        setMeasuredDimension(widthSize, heightSize);
        mHeightMeasureSpec = heightMeasureSpec;
        mWidthMeasureSpec = widthMeasureSpec;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.359 -0500", hash_original_method = "44D3B1A6F440757321735895159CF3F5", hash_generated_method = "44D3B1A6F440757321735895159CF3F5")
    
int getChildHeight(View child) {
        return child.getMeasuredHeight();
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.360 -0500", hash_original_method = "3D627342594CC491E8B9982EF63DBDD8", hash_generated_method = "3D627342594CC491E8B9982EF63DBDD8")
    
int getChildWidth(View child) {
        return child.getMeasuredWidth();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.363 -0500", hash_original_method = "2179BEF90E842D00377926E5531ABF89", hash_generated_method = "ABC5E9F5739A26EC765110A888213B88")
    
@Override
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.365 -0500", hash_original_method = "44A3231F2CD8F60C6B590B4146A8EF3F", hash_generated_method = "2EA84CA676DADABC3A99643373B1BA51")
    
void recycleAllViews() {
        final int childCount = getChildCount();
        final AbsSpinner.RecycleBin recycleBin = mRecycler;
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
    @DSComment("Spinner")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.367 -0500", hash_original_method = "D2708A7FDB907C7B6958E15DD672DA8E", hash_generated_method = "C3A5D610F87F4D3CECAE59DEBB9EE18C")
    
public void setSelection(int position, boolean animate) {
        // Animate only if requested position is already on screen somewhere
        boolean shouldAnimate = animate && mFirstPosition <= position &&
                position <= mFirstPosition + getChildCount() - 1;
        setSelectionInt(position, shouldAnimate);
    }

    @DSComment("Spinner")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.369 -0500", hash_original_method = "7E33360CBDBF59A4E473BBC01C4A9D09", hash_generated_method = "5A7C3B76C3326CF67657E51BD1F90B58")
    
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
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.372 -0500", hash_original_method = "63246E2C9E0D90A96046BA94228CF775", hash_generated_method = "63246E2C9E0D90A96046BA94228CF775")
    
void setSelectionInt(int position, boolean animate) {
        if (position != mOldSelectedPosition) {
            mBlockLayoutRequests = true;
            int delta  = position - mSelectedPosition;
            setNextSelectedPositionInt(position);
            layout(delta, animate);
            mBlockLayoutRequests = false;
        }
    }

    @DSComment("Abstract Method")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.374 -0500", hash_original_method = "E89B31DFCF88A65148B589897F629BD3", hash_generated_method = "DE3E4C3DF383C543F0AF8E96C0CE29EF")
    
abstract void layout(int delta, boolean animate);

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.376 -0500", hash_original_method = "B9D708BD110913DD38C752A46A05BBB4", hash_generated_method = "513703D89AB4B12AE4736D2F5E964FD5")
    
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
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.379 -0500", hash_original_method = "7199FF25ED586C3851E847C0919D8CB4", hash_generated_method = "07FC44E84DEB35164CA25A3FE21E0C66")
    
@Override
    public void requestLayout() {
        if (!mBlockLayoutRequests) {
            super.requestLayout();
        }
    }

    @DSComment("Spinner")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.381 -0500", hash_original_method = "0B2662100CCA74662649DCCD28954A76", hash_generated_method = "B2AD20E240F1F5A7AD66020C9F08265C")
    
@Override
    public SpinnerAdapter getAdapter() {
        return mAdapter;
    }

    @DSComment("Spinner")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.383 -0500", hash_original_method = "C515244CDC30F9529A71B0CAA70231C3", hash_generated_method = "01AD3C9DE5F33E89331C2C38A4EFAE12")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.385 -0500", hash_original_method = "AD87FEA47379DE9B1BE65A322C86E61D", hash_generated_method = "625D03B98CDA4B87EEAD3D117A57079B")
    
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

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.413 -0500", hash_original_method = "2B2E0178AF4521152109C90D1424ECD0", hash_generated_method = "0F01E07DD73E3F973CD57D0A62D38B74")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.415 -0500", hash_original_method = "41BC9B1A20EF7E956C712A8B84EE3401", hash_generated_method = "7D1B2596D4E45FA48A8841B2C2008EAA")
    
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
    
    static class SavedState extends BaseSavedState {
        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.869 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

        public static final Parcelable.Creator<SavedState> CREATOR
                = new Parcelable.Creator<SavedState>() {
            @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.404 -0500", hash_original_method = "E26812089C072DDE1A14AECAA6CD6686", hash_generated_method = "C97AA17CB243756458D0FB7A2D786EA0")
            
public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.406 -0500", hash_original_method = "2D31E9CBAAAE05B696D738324F87FF78", hash_generated_method = "020465B62F970B98C266AF229149E391")
            
public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.388 -0500", hash_original_field = "C7298A539520D9945816CD36ABAD339C", hash_generated_field = "C7298A539520D9945816CD36ABAD339C")

        long selectedId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.390 -0500", hash_original_field = "92D7808EB8CD548A137230400384C6DC", hash_generated_field = "92D7808EB8CD548A137230400384C6DC")

        int position;

        /**
         * Constructor called from {@link AbsSpinner#onSaveInstanceState()}
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.392 -0500", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "89EB4EC154F05BF905ECA8E02BBD14BC")
        
SavedState(Parcelable superState) {
            super(superState);
        }
        
        /**
         * Constructor called from {@link #CREATOR}
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.395 -0500", hash_original_method = "65E5A0CAB50633949DC788A62A186FA9", hash_generated_method = "356CAD3778F2342124F6018DF5A7DD6E")
        
private SavedState(Parcel in) {
            super(in);
            selectedId = in.readLong();
            position = in.readInt();
        }

        @DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.397 -0500", hash_original_method = "0007C2F01F0ACF691918256360E82965", hash_generated_method = "C9F57015B00A965BDAEC37BE602A9B2C")
        
@Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeLong(selectedId);
            out.writeInt(position);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.399 -0500", hash_original_method = "7A4BA85F6ACBC7FE9656B24BA8A57B9A", hash_generated_method = "9BDE436EE95F0B725ABEA235B286B622")
        
@Override
        public String toString() {
            return "AbsSpinner.SavedState{"
                    + Integer.toHexString(System.identityHashCode(this))
                    + " selectedId=" + selectedId
                    + " position=" + position + "}";
        }
        // orphaned legacy method
        public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }
        
        // orphaned legacy method
        public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        
    }
    
    class RecycleBin {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.418 -0500", hash_original_field = "EEBE882C7B23621B1CEAAEFC3C766AE2", hash_generated_field = "344735C1BC7661738F3886E8FB539FBF")

        private final SparseArray<View> mScrapHeap = new SparseArray<View>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.870 -0400", hash_original_method = "8B96BADF61C6544CC3B73116E3B60C53", hash_generated_method = "8B96BADF61C6544CC3B73116E3B60C53")
        public RecycleBin ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.421 -0500", hash_original_method = "12E9E54F63615166D97804FCD5F19EB6", hash_generated_method = "592737E4726413560A9B7CE9C2327AB3")
        
public void put(int position, View v) {
            mScrapHeap.put(position, v);
        }
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.423 -0500", hash_original_method = "13D5A4FF59BF1643EBD5228E429384EA", hash_generated_method = "2636315F7184771A1F6940DBD366307F")
        
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

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:31.425 -0500", hash_original_method = "1B173351B88254AC852DFD7E9D6DC12C", hash_generated_method = "1B173351B88254AC852DFD7E9D6DC12C")
        
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

