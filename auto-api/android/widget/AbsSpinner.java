package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.R;
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

public abstract class AbsSpinner extends AdapterView<SpinnerAdapter> {
    SpinnerAdapter mAdapter;
    int mHeightMeasureSpec;
    int mWidthMeasureSpec;
    boolean mBlockLayoutRequests;
    int mSelectionLeftPadding = 0;
    int mSelectionTopPadding = 0;
    int mSelectionRightPadding = 0;
    int mSelectionBottomPadding = 0;
    Rect mSpinnerPadding = new Rect();
    RecycleBin mRecycler = new RecycleBin();
    private DataSetObserver mDataSetObserver;
    private Rect mTouchFrame;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:34:42.348 -0400", hash_original_method = "CE4C0E9ECE12F7FD7C8BEF83C3609839", hash_generated_method = "869443E98EC91EB7957F28969A6BD4F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AbsSpinner(Context context) {
        super(context);
        dsTaint.addTaint(context.dsTaint);
        initAbsSpinner();
        // ---------- Original Method ----------
        //initAbsSpinner();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:34:42.358 -0400", hash_original_method = "48F93C8F12C5C0BCE27736B4F067DE36", hash_generated_method = "08C6897177EFB5217125400C084B1AE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AbsSpinner(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:34:42.395 -0400", hash_original_method = "22AD9CC9923933C5995E60FF80D5916E", hash_generated_method = "B1A0CE8243F7B7B23610B982FBF1E920")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AbsSpinner(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        initAbsSpinner();
        TypedArray a;
        a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.AbsSpinner, defStyle, 0);
        CharSequence[] entries;
        entries = a.getTextArray(R.styleable.AbsSpinner_entries);
        {
            ArrayAdapter<CharSequence> adapter;
            adapter = new ArrayAdapter<CharSequence>(context,
                            R.layout.simple_spinner_item, entries);
            adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
            setAdapter(adapter);
        } //End block
        a.recycle();
        // ---------- Original Method ----------
        //initAbsSpinner();
        //TypedArray a = context.obtainStyledAttributes(attrs,
                //com.android.internal.R.styleable.AbsSpinner, defStyle, 0);
        //CharSequence[] entries = a.getTextArray(R.styleable.AbsSpinner_entries);
        //if (entries != null) {
            //ArrayAdapter<CharSequence> adapter =
                    //new ArrayAdapter<CharSequence>(context,
                            //R.layout.simple_spinner_item, entries);
            //adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
            //setAdapter(adapter);
        //}
        //a.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:34:42.429 -0400", hash_original_method = "189B5B9E645B86B5245C2FF55DEC5907", hash_generated_method = "65AA139ADD2F38F5C7610659D5503359")
    @DSModeled(DSC.SAFE)
    private void initAbsSpinner() {
        setFocusable(true);
        setWillNotDraw(false);
        // ---------- Original Method ----------
        //setFocusable(true);
        //setWillNotDraw(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:34:42.485 -0400", hash_original_method = "E5824BE9B0ACFF3A1B32EE310E006300", hash_generated_method = "9C2EE3E7E15371D60239B4ADAC599701")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setAdapter(SpinnerAdapter adapter) {
        dsTaint.addTaint(adapter.dsTaint);
        {
            mAdapter.unregisterDataSetObserver(mDataSetObserver);
            resetList();
        } //End block
        mOldSelectedPosition = INVALID_POSITION;
        mOldSelectedRowId = INVALID_ROW_ID;
        {
            mOldItemCount = mItemCount;
            mItemCount = mAdapter.getCount();
            checkFocus();
            mDataSetObserver = new AdapterDataSetObserver();
            mAdapter.registerDataSetObserver(mDataSetObserver);
            int position;
            position = 0;
            position = INVALID_POSITION;
            setSelectedPositionInt(position);
            setNextSelectedPositionInt(position);
            {
                checkSelectionChanged();
            } //End block
        } //End block
        {
            checkFocus();
            resetList();
            checkSelectionChanged();
        } //End block
        requestLayout();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:34:42.544 -0400", hash_original_method = "5DEE49E4A107B00C6160988898CCE14A", hash_generated_method = "CF26B38755C7FA84296F64746DE0241D")
    @DSModeled(DSC.SAFE)
     void resetList() {
        mDataChanged = false;
        mNeedSync = false;
        removeAllViewsInLayout();
        mOldSelectedPosition = INVALID_POSITION;
        mOldSelectedRowId = INVALID_ROW_ID;
        setSelectedPositionInt(INVALID_POSITION);
        setNextSelectedPositionInt(INVALID_POSITION);
        invalidate();
        // ---------- Original Method ----------
        //mDataChanged = false;
        //mNeedSync = false;
        //removeAllViewsInLayout();
        //mOldSelectedPosition = INVALID_POSITION;
        //mOldSelectedRowId = INVALID_ROW_ID;
        //setSelectedPositionInt(INVALID_POSITION);
        //setNextSelectedPositionInt(INVALID_POSITION);
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:34:42.638 -0400", hash_original_method = "29BB60D69D80C0C6339E2E86482D98C0", hash_generated_method = "4FE87EC09EC0E67537C02FA2A2966597")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(heightMeasureSpec);
        dsTaint.addTaint(widthMeasureSpec);
        int widthMode;
        widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize;
        int heightSize;
        mSpinnerPadding.left = mPaddingLeft > mSelectionLeftPadding ? mPaddingLeft
                : mSelectionLeftPadding;
        mSpinnerPadding.top = mPaddingTop > mSelectionTopPadding ? mPaddingTop
                : mSelectionTopPadding;
        mSpinnerPadding.right = mPaddingRight > mSelectionRightPadding ? mPaddingRight
                : mSelectionRightPadding;
        mSpinnerPadding.bottom = mPaddingBottom > mSelectionBottomPadding ? mPaddingBottom
                : mSelectionBottomPadding;
        {
            handleDataChanged();
        } //End block
        int preferredHeight;
        preferredHeight = 0;
        int preferredWidth;
        preferredWidth = 0;
        boolean needsMeasuring;
        needsMeasuring = true;
        int selectedPosition;
        selectedPosition = getSelectedItemPosition();
        {
            boolean var0A913476FEE00BF2CC6981FB21FC379C_68213583 = (selectedPosition >= 0 && mAdapter != null && selectedPosition < mAdapter.getCount());
            {
                View view;
                view = mRecycler.get(selectedPosition);
                {
                    view = mAdapter.getView(selectedPosition, null, this);
                } //End block
                {
                    mRecycler.put(selectedPosition, view);
                } //End block
                {
                    {
                        boolean var5796118831C98F47A208EF62E7CCA9A9_385468782 = (view.getLayoutParams() == null);
                        {
                            mBlockLayoutRequests = true;
                            view.setLayoutParams(generateDefaultLayoutParams());
                            mBlockLayoutRequests = false;
                        } //End block
                    } //End collapsed parenthetic
                    measureChild(view, widthMeasureSpec, heightMeasureSpec);
                    preferredHeight = getChildHeight(view) + mSpinnerPadding.top + mSpinnerPadding.bottom;
                    preferredWidth = getChildWidth(view) + mSpinnerPadding.left + mSpinnerPadding.right;
                    needsMeasuring = false;
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            preferredHeight = mSpinnerPadding.top + mSpinnerPadding.bottom;
            {
                preferredWidth = mSpinnerPadding.left + mSpinnerPadding.right;
            } //End block
        } //End block
        preferredHeight = Math.max(preferredHeight, getSuggestedMinimumHeight());
        preferredWidth = Math.max(preferredWidth, getSuggestedMinimumWidth());
        heightSize = resolveSizeAndState(preferredHeight, heightMeasureSpec, 0);
        widthSize = resolveSizeAndState(preferredWidth, widthMeasureSpec, 0);
        setMeasuredDimension(widthSize, heightSize);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:34:42.653 -0400", hash_original_method = "44D3B1A6F440757321735895159CF3F5", hash_generated_method = "1CBD3D7981E030A427CF115EBA535EC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int getChildHeight(View child) {
        dsTaint.addTaint(child.dsTaint);
        int var58D497011C6F03727DC75B3DA924936B_1713841458 = (child.getMeasuredHeight());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return child.getMeasuredHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:34:42.661 -0400", hash_original_method = "3D627342594CC491E8B9982EF63DBDD8", hash_generated_method = "023269BF5AA68FC552BC3635E798B200")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int getChildWidth(View child) {
        dsTaint.addTaint(child.dsTaint);
        int var515E0207FEB0ACB672E13F622A8D400F_1290526470 = (child.getMeasuredWidth());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return child.getMeasuredWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:34:42.666 -0400", hash_original_method = "2179BEF90E842D00377926E5531ABF89", hash_generated_method = "37107B554F899169CCDE2462E221458A")
    @DSModeled(DSC.SAFE)
    @Override
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return (ViewGroup.LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ViewGroup.LayoutParams(
                //ViewGroup.LayoutParams.MATCH_PARENT,
                //ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:34:42.694 -0400", hash_original_method = "44A3231F2CD8F60C6B590B4146A8EF3F", hash_generated_method = "1BA790924B4B52195CE24BE0D8E02365")
    @DSModeled(DSC.SAFE)
     void recycleAllViews() {
        int childCount;
        childCount = getChildCount();
        AbsSpinner.RecycleBin recycleBin;
        recycleBin = mRecycler;
        int position;
        position = mFirstPosition;
        {
            int i;
            i = 0;
            {
                View v;
                v = getChildAt(i);
                int index;
                index = position + i;
                recycleBin.put(index, v);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //final int childCount = getChildCount();
        //final AbsSpinner.RecycleBin recycleBin = mRecycler;
        //final int position = mFirstPosition;
        //for (int i = 0; i < childCount; i++) {
            //View v = getChildAt(i);
            //int index = position + i;
            //recycleBin.put(index, v);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:34:42.715 -0400", hash_original_method = "D2708A7FDB907C7B6958E15DD672DA8E", hash_generated_method = "0D31DFA7165CD2A8468808B92D30FAB1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSelection(int position, boolean animate) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(animate);
        boolean shouldAnimate;
        shouldAnimate = animate && mFirstPosition <= position &&
                position <= mFirstPosition + getChildCount() - 1;
        setSelectionInt(position, shouldAnimate);
        // ---------- Original Method ----------
        //boolean shouldAnimate = animate && mFirstPosition <= position &&
                //position <= mFirstPosition + getChildCount() - 1;
        //setSelectionInt(position, shouldAnimate);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:34:42.722 -0400", hash_original_method = "7E33360CBDBF59A4E473BBC01C4A9D09", hash_generated_method = "644E82EC703FD3452471FB42D7BA2BEE")
    @DSModeled(DSC.SAFE)
    @Override
    public void setSelection(int position) {
        dsTaint.addTaint(position);
        setNextSelectedPositionInt(position);
        requestLayout();
        invalidate();
        // ---------- Original Method ----------
        //setNextSelectedPositionInt(position);
        //requestLayout();
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:34:42.731 -0400", hash_original_method = "63246E2C9E0D90A96046BA94228CF775", hash_generated_method = "07ACA77D37265C8DCEAAC324802CE84D")
    @DSModeled(DSC.SAFE)
     void setSelectionInt(int position, boolean animate) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(animate);
        {
            mBlockLayoutRequests = true;
            int delta;
            delta = position - mSelectedPosition;
            setNextSelectedPositionInt(position);
            layout(delta, animate);
            mBlockLayoutRequests = false;
        } //End block
        // ---------- Original Method ----------
        //if (position != mOldSelectedPosition) {
            //mBlockLayoutRequests = true;
            //int delta  = position - mSelectedPosition;
            //setNextSelectedPositionInt(position);
            //layout(delta, animate);
            //mBlockLayoutRequests = false;
        //}
    }

    
    abstract void layout(int delta, boolean animate);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:34:42.741 -0400", hash_original_method = "B9D708BD110913DD38C752A46A05BBB4", hash_generated_method = "1CFF2673FA3DC6FD9C41C91B8326DBB1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public View getSelectedView() {
        {
            View var32627160716DC777F524CC780C8B0164_2022173616 = (getChildAt(mSelectedPosition - mFirstPosition));
        } //End block
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mItemCount > 0 && mSelectedPosition >= 0) {
            //return getChildAt(mSelectedPosition - mFirstPosition);
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:34:42.748 -0400", hash_original_method = "7199FF25ED586C3851E847C0919D8CB4", hash_generated_method = "8049CB0EE75F673258BD8E132090352D")
    @DSModeled(DSC.SAFE)
    @Override
    public void requestLayout() {
        {
            super.requestLayout();
        } //End block
        // ---------- Original Method ----------
        //if (!mBlockLayoutRequests) {
            //super.requestLayout();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:34:42.754 -0400", hash_original_method = "0B2662100CCA74662649DCCD28954A76", hash_generated_method = "F44EA9DF4D69A7A72BFFF6CC6DA1FF29")
    @DSModeled(DSC.SAFE)
    @Override
    public SpinnerAdapter getAdapter() {
        return (SpinnerAdapter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mAdapter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:34:42.759 -0400", hash_original_method = "C515244CDC30F9529A71B0CAA70231C3", hash_generated_method = "D7F65C005A6A482602F9F30AB1F481D7")
    @DSModeled(DSC.SAFE)
    @Override
    public int getCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mItemCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:34:42.774 -0400", hash_original_method = "AD87FEA47379DE9B1BE65A322C86E61D", hash_generated_method = "74C27D4DC446F405AA3FDAE8CC94EAEF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int pointToPosition(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        Rect frame;
        frame = mTouchFrame;
        {
            mTouchFrame = new Rect();
            frame = mTouchFrame;
        } //End block
        int count;
        count = getChildCount();
        {
            int i;
            i = count - 1;
            {
                View child;
                child = getChildAt(i);
                {
                    boolean var02E23769C3E76AF1DC2C1CE956107022_239489342 = (child.getVisibility() == View.VISIBLE);
                    {
                        child.getHitRect(frame);
                        {
                            boolean var9F1DF48D8B435FACEEE6B40EFD85C398_1110506319 = (frame.contains(x, y));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //Rect frame = mTouchFrame;
        //if (frame == null) {
            //mTouchFrame = new Rect();
            //frame = mTouchFrame;
        //}
        //final int count = getChildCount();
        //for (int i = count - 1; i >= 0; i--) {
            //View child = getChildAt(i);
            //if (child.getVisibility() == View.VISIBLE) {
                //child.getHitRect(frame);
                //if (frame.contains(x, y)) {
                    //return mFirstPosition + i;
                //}
            //}
        //}
        //return INVALID_POSITION;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:34:42.786 -0400", hash_original_method = "2B2E0178AF4521152109C90D1424ECD0", hash_generated_method = "C0CE7D29A2C7F7B5F36AFDD10D97668A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Parcelable superState;
        superState = super.onSaveInstanceState();
        SavedState ss;
        ss = new SavedState(superState);
        ss.selectedId = getSelectedItemId();
        {
            ss.position = getSelectedItemPosition();
        } //End block
        {
            ss.position = INVALID_POSITION;
        } //End block
        return (Parcelable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Parcelable superState = super.onSaveInstanceState();
        //SavedState ss = new SavedState(superState);
        //ss.selectedId = getSelectedItemId();
        //if (ss.selectedId >= 0) {
            //ss.position = getSelectedItemPosition();
        //} else {
            //ss.position = INVALID_POSITION;
        //}
        //return ss;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:34:42.796 -0400", hash_original_method = "41BC9B1A20EF7E956C712A8B84EE3401", hash_generated_method = "2EAE3840C93493F3FD902707C6FF72DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(state.dsTaint);
        SavedState ss;
        ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        {
            mDataChanged = true;
            mNeedSync = true;
            mSyncRowId = ss.selectedId;
            mSyncPosition = ss.position;
            mSyncMode = SYNC_SELECTED_POSITION;
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        //SavedState ss = (SavedState) state;
        //super.onRestoreInstanceState(ss.getSuperState());
        //if (ss.selectedId >= 0) {
            //mDataChanged = true;
            //mNeedSync = true;
            //mSyncRowId = ss.selectedId;
            //mSyncPosition = ss.position;
            //mSyncMode = SYNC_SELECTED_POSITION;
            //requestLayout();
        //}
    }

    
    static class SavedState extends BaseSavedState {
        long selectedId;
        int position;
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:34:42.802 -0400", hash_original_method = "E26812089C072DDE1A14AECAA6CD6686", hash_generated_method = "6C6B0A873BD52E2752F88E9968D483CA")
            @DSModeled(DSC.SAFE)
            public SavedState createFromParcel(Parcel in) {
                dsTaint.addTaint(in.dsTaint);
                return (SavedState)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new SavedState(in);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:34:42.807 -0400", hash_original_method = "2D31E9CBAAAE05B696D738324F87FF78", hash_generated_method = "1325778BB443F872513E70F9A19C5918")
            @DSModeled(DSC.SAFE)
            public SavedState[] newArray(int size) {
                dsTaint.addTaint(size);
                return (SavedState[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new SavedState[size];
            }

            
}; //Transformed anonymous class
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:34:42.810 -0400", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "BBD854AA7A117C86D9FBF897ADE36FE1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SavedState(Parcelable superState) {
            super(superState);
            dsTaint.addTaint(superState.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:34:42.825 -0400", hash_original_method = "65E5A0CAB50633949DC788A62A186FA9", hash_generated_method = "B42BD906A969FA4240367AA4514458A1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private SavedState(Parcel in) {
            super(in);
            dsTaint.addTaint(in.dsTaint);
            selectedId = in.readLong();
            position = in.readInt();
            // ---------- Original Method ----------
            //selectedId = in.readLong();
            //position = in.readInt();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:34:42.831 -0400", hash_original_method = "0007C2F01F0ACF691918256360E82965", hash_generated_method = "484B3CAD92CCDE74E63EE91B7CC951D9")
        @DSModeled(DSC.SAFE)
        @Override
        public void writeToParcel(Parcel out, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(out.dsTaint);
            super.writeToParcel(out, flags);
            out.writeLong(selectedId);
            out.writeInt(position);
            // ---------- Original Method ----------
            //super.writeToParcel(out, flags);
            //out.writeLong(selectedId);
            //out.writeInt(position);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:34:42.849 -0400", hash_original_method = "7A4BA85F6ACBC7FE9656B24BA8A57B9A", hash_generated_method = "AE7985381C9A00CBD869E1754DC8A7A5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            String varF5593F943A5C5F2746EE7152B0258022_918338447 = ("AbsSpinner.SavedState{"
                    + Integer.toHexString(System.identityHashCode(this))
                    + " selectedId=" + selectedId
                    + " position=" + position + "}");
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "AbsSpinner.SavedState{"
                    //+ Integer.toHexString(System.identityHashCode(this))
                    //+ " selectedId=" + selectedId
                    //+ " position=" + position + "}";
        }

        
    }


    
    class RecycleBin {
        private SparseArray<View> mScrapHeap = new SparseArray<View>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:34:42.858 -0400", hash_original_method = "12E9E54F63615166D97804FCD5F19EB6", hash_generated_method = "D2A042EE30BD173C0D5B3C2EAA3815DA")
        @DSModeled(DSC.SAFE)
        public void put(int position, View v) {
            dsTaint.addTaint(position);
            dsTaint.addTaint(v.dsTaint);
            mScrapHeap.put(position, v);
            // ---------- Original Method ----------
            //mScrapHeap.put(position, v);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:34:42.866 -0400", hash_original_method = "13D5A4FF59BF1643EBD5228E429384EA", hash_generated_method = "EFE27363E285230649B3CE99C1D9E03B")
        @DSModeled(DSC.SAFE)
         View get(int position) {
            dsTaint.addTaint(position);
            View result;
            result = mScrapHeap.get(position);
            {
                mScrapHeap.delete(position);
            } //End block
            return (View)dsTaint.getTaint();
            // ---------- Original Method ----------
            //View result = mScrapHeap.get(position);
            //if (result != null) {
                //mScrapHeap.delete(position);
            //} else {
            //}
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:34:42.876 -0400", hash_original_method = "1B173351B88254AC852DFD7E9D6DC12C", hash_generated_method = "012F6C7C672722BBC93FD0030802FA66")
        @DSModeled(DSC.SAFE)
         void clear() {
            SparseArray<View> scrapHeap;
            scrapHeap = mScrapHeap;
            int count;
            count = scrapHeap.size();
            {
                int i;
                i = 0;
                {
                    View view;
                    view = scrapHeap.valueAt(i);
                    {
                        removeDetachedView(view, true);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            scrapHeap.clear();
            // ---------- Original Method ----------
            //final SparseArray<View> scrapHeap = mScrapHeap;
            //final int count = scrapHeap.size();
            //for (int i = 0; i < count; i++) {
                //final View view = scrapHeap.valueAt(i);
                //if (view != null) {
                    //removeDetachedView(view, true);
                //}
            //}
            //scrapHeap.clear();
        }

        
    }


    
}


