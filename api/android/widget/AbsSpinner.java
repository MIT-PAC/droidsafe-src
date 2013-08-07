package android.widget;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.853 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "F3411DF47899C6681AB924958C72D742")

    SpinnerAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.853 -0400", hash_original_field = "83EF3BEC73E74162514FD9850370830D", hash_generated_field = "D04E3D07D063C4D19518074C3829A73C")

    int mHeightMeasureSpec;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.853 -0400", hash_original_field = "E4DC884788F434BA56F0CFA9C4932AD6", hash_generated_field = "955DE0D4DCC8871A233CEA8D2F0A0C8A")

    int mWidthMeasureSpec;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.853 -0400", hash_original_field = "F81233D150D3DB2682CC30D24A9419DC", hash_generated_field = "16D5ED00E6F87F853BA44CD6D3C6B5B1")

    boolean mBlockLayoutRequests;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.853 -0400", hash_original_field = "EC383219D6D8A4B6B87A786F4327EE03", hash_generated_field = "753C8FC0C4D631C54FF77F2B10210084")

    int mSelectionLeftPadding = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.853 -0400", hash_original_field = "FA8EABBC9D79FB4F912796BE168AD76D", hash_generated_field = "50BDF542563848097B98D0F9CA864924")

    int mSelectionTopPadding = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.853 -0400", hash_original_field = "F2D6183DA068D77902D36BB38A7570E0", hash_generated_field = "3DC4FB7C9491C740968135A630596AA0")

    int mSelectionRightPadding = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.853 -0400", hash_original_field = "63EC0412604CE1A7BE02B1C77E43E6CF", hash_generated_field = "7187B403BE2B79CEAB01DB70095A8709")

    int mSelectionBottomPadding = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.853 -0400", hash_original_field = "DD19C67D0D02D080ABB6E81DCB716347", hash_generated_field = "4083C73A2606B3CF98A9A07B6027B252")

    final Rect mSpinnerPadding = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.853 -0400", hash_original_field = "850AAD212EF4F4A7E8993BB802A79E8B", hash_generated_field = "9569056224CF4BB7FAE062DA5103E35A")

    final RecycleBin mRecycler = new RecycleBin();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.853 -0400", hash_original_field = "1AB0B744C03B78F09E9DEC3C88684ED1", hash_generated_field = "F16E8B0F167DE3008550015271235F93")

    private DataSetObserver mDataSetObserver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.853 -0400", hash_original_field = "2D90C7DCE7997683B43703723C5CE198", hash_generated_field = "08F5569C270EF171D6F208986E4909DE")

    private Rect mTouchFrame;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.854 -0400", hash_original_method = "CE4C0E9ECE12F7FD7C8BEF83C3609839", hash_generated_method = "45E125BEF22DEC4C40277086D3E5D084")
    public  AbsSpinner(Context context) {
        super(context);
        addTaint(context.getTaint());
        initAbsSpinner();
        // ---------- Original Method ----------
        //initAbsSpinner();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.854 -0400", hash_original_method = "48F93C8F12C5C0BCE27736B4F067DE36", hash_generated_method = "64113F39096B63BF664F9CDE3913FABA")
    public  AbsSpinner(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.855 -0400", hash_original_method = "22AD9CC9923933C5995E60FF80D5916E", hash_generated_method = "9610A512BAE2819EB7960A3F5242475E")
    public  AbsSpinner(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        initAbsSpinner();
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.AbsSpinner, defStyle, 0);
        CharSequence[] entries = a.getTextArray(R.styleable.AbsSpinner_entries);
        if(entries != null)        
        {
            ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(context,
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.855 -0400", hash_original_method = "189B5B9E645B86B5245C2FF55DEC5907", hash_generated_method = "95F290FF3D8900B1A5D05DB6AC9E34A4")
    private void initAbsSpinner() {
        setFocusable(true);
        setWillNotDraw(false);
        // ---------- Original Method ----------
        //setFocusable(true);
        //setWillNotDraw(false);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.856 -0400", hash_original_method = "E5824BE9B0ACFF3A1B32EE310E006300", hash_generated_method = "150FA04CE925D03BD9792E408F6E07BE")
    @Override
    public void setAdapter(SpinnerAdapter adapter) {
        if(null != mAdapter)        
        {
            mAdapter.unregisterDataSetObserver(mDataSetObserver);
            resetList();
        } //End block
        mAdapter = adapter;
        mOldSelectedPosition = INVALID_POSITION;
        mOldSelectedRowId = INVALID_ROW_ID;
        if(mAdapter != null)        
        {
            mOldItemCount = mItemCount;
            mItemCount = mAdapter.getCount();
            checkFocus();
            mDataSetObserver = new AdapterDataSetObserver();
            mAdapter.registerDataSetObserver(mDataSetObserver);
            int position = mItemCount > 0 ? 0 : INVALID_POSITION;
            setSelectedPositionInt(position);
            setNextSelectedPositionInt(position);
            if(mItemCount == 0)            
            {
                checkSelectionChanged();
            } //End block
        } //End block
        else
        {
            checkFocus();
            resetList();
            checkSelectionChanged();
        } //End block
        requestLayout();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.857 -0400", hash_original_method = "5DEE49E4A107B00C6160988898CCE14A", hash_generated_method = "0FFDFA172FF8DE0D08C732AFE9AF8AB3")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.860 -0400", hash_original_method = "29BB60D69D80C0C6339E2E86482D98C0", hash_generated_method = "7F65E16E6BD324D6AD8260BD7215B900")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
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
        if(mDataChanged)        
        {
            handleDataChanged();
        } //End block
        int preferredHeight = 0;
        int preferredWidth = 0;
        boolean needsMeasuring = true;
        int selectedPosition = getSelectedItemPosition();
        if(selectedPosition >= 0 && mAdapter != null && selectedPosition < mAdapter.getCount())        
        {
            View view = mRecycler.get(selectedPosition);
            if(view == null)            
            {
                view = mAdapter.getView(selectedPosition, null, this);
            } //End block
            if(view != null)            
            {
                mRecycler.put(selectedPosition, view);
            } //End block
            if(view != null)            
            {
                if(view.getLayoutParams() == null)                
                {
                    mBlockLayoutRequests = true;
                    view.setLayoutParams(generateDefaultLayoutParams());
                    mBlockLayoutRequests = false;
                } //End block
                measureChild(view, widthMeasureSpec, heightMeasureSpec);
                preferredHeight = getChildHeight(view) + mSpinnerPadding.top + mSpinnerPadding.bottom;
                preferredWidth = getChildWidth(view) + mSpinnerPadding.left + mSpinnerPadding.right;
                needsMeasuring = false;
            } //End block
        } //End block
        if(needsMeasuring)        
        {
            preferredHeight = mSpinnerPadding.top + mSpinnerPadding.bottom;
            if(widthMode == MeasureSpec.UNSPECIFIED)            
            {
                preferredWidth = mSpinnerPadding.left + mSpinnerPadding.right;
            } //End block
        } //End block
        preferredHeight = Math.max(preferredHeight, getSuggestedMinimumHeight());
        preferredWidth = Math.max(preferredWidth, getSuggestedMinimumWidth());
        heightSize = resolveSizeAndState(preferredHeight, heightMeasureSpec, 0);
        widthSize = resolveSizeAndState(preferredWidth, widthMeasureSpec, 0);
        setMeasuredDimension(widthSize, heightSize);
        mHeightMeasureSpec = heightMeasureSpec;
        mWidthMeasureSpec = widthMeasureSpec;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.861 -0400", hash_original_method = "44D3B1A6F440757321735895159CF3F5", hash_generated_method = "B1889B54552F110F8A8049C1D371486B")
     int getChildHeight(View child) {
        addTaint(child.getTaint());
        int var4E2C59BAAB25C5B90D5B4A9309C0D212_1491991331 = (child.getMeasuredHeight());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1583532406 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1583532406;
        // ---------- Original Method ----------
        //return child.getMeasuredHeight();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.862 -0400", hash_original_method = "3D627342594CC491E8B9982EF63DBDD8", hash_generated_method = "57FC472AEFDF6DBF4B365E5A0B5B1F49")
     int getChildWidth(View child) {
        addTaint(child.getTaint());
        int varA148F7A70A75E615286508B90DEBEEA7_2072588695 = (child.getMeasuredWidth());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_474766750 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_474766750;
        // ---------- Original Method ----------
        //return child.getMeasuredWidth();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.862 -0400", hash_original_method = "2179BEF90E842D00377926E5531ABF89", hash_generated_method = "68441272E5C182478196FD083AE20DBA")
    @Override
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
ViewGroup.LayoutParams varC7143A11FF7EC06883706B8F169DCB38_537325208 =         new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        varC7143A11FF7EC06883706B8F169DCB38_537325208.addTaint(taint);
        return varC7143A11FF7EC06883706B8F169DCB38_537325208;
        // ---------- Original Method ----------
        //return new ViewGroup.LayoutParams(
                //ViewGroup.LayoutParams.MATCH_PARENT,
                //ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.862 -0400", hash_original_method = "44A3231F2CD8F60C6B590B4146A8EF3F", hash_generated_method = "DA95383C3794040F6ED9210E395418B7")
     void recycleAllViews() {
        final int childCount = getChildCount();
        final AbsSpinner.RecycleBin recycleBin = mRecycler;
        final int position = mFirstPosition;
for(int i = 0;i < childCount;i++)
        {
            View v = getChildAt(i);
            int index = position + i;
            recycleBin.put(index, v);
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.862 -0400", hash_original_method = "D2708A7FDB907C7B6958E15DD672DA8E", hash_generated_method = "DB2DD21D96AA192577D4BFB0A2BACF6C")
    public void setSelection(int position, boolean animate) {
        addTaint(animate);
        addTaint(position);
        boolean shouldAnimate = animate && mFirstPosition <= position &&
                position <= mFirstPosition + getChildCount() - 1;
        setSelectionInt(position, shouldAnimate);
        // ---------- Original Method ----------
        //boolean shouldAnimate = animate && mFirstPosition <= position &&
                //position <= mFirstPosition + getChildCount() - 1;
        //setSelectionInt(position, shouldAnimate);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.863 -0400", hash_original_method = "7E33360CBDBF59A4E473BBC01C4A9D09", hash_generated_method = "3376B4242D53CEB38DECEBD083FEF032")
    @Override
    public void setSelection(int position) {
        addTaint(position);
        setNextSelectedPositionInt(position);
        requestLayout();
        invalidate();
        // ---------- Original Method ----------
        //setNextSelectedPositionInt(position);
        //requestLayout();
        //invalidate();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.863 -0400", hash_original_method = "63246E2C9E0D90A96046BA94228CF775", hash_generated_method = "A2473CD28EF4C23A0F021A2683A0599D")
     void setSelectionInt(int position, boolean animate) {
        addTaint(animate);
        addTaint(position);
        if(position != mOldSelectedPosition)        
        {
            mBlockLayoutRequests = true;
            int delta = position - mSelectedPosition;
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

    
    @DSModeled(DSC.SAFE)
    abstract void layout(int delta, boolean animate);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.863 -0400", hash_original_method = "B9D708BD110913DD38C752A46A05BBB4", hash_generated_method = "F1FAC70B46F4541384D908F98EED2AFB")
    @Override
    public View getSelectedView() {
        if(mItemCount > 0 && mSelectedPosition >= 0)        
        {
View var9232114380D348AA08914BA6993F21A2_1957143739 =             getChildAt(mSelectedPosition - mFirstPosition);
            var9232114380D348AA08914BA6993F21A2_1957143739.addTaint(taint);
            return var9232114380D348AA08914BA6993F21A2_1957143739;
        } //End block
        else
        {
View var540C13E9E156B687226421B24F2DF178_887779325 =             null;
            var540C13E9E156B687226421B24F2DF178_887779325.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_887779325;
        } //End block
        // ---------- Original Method ----------
        //if (mItemCount > 0 && mSelectedPosition >= 0) {
            //return getChildAt(mSelectedPosition - mFirstPosition);
        //} else {
            //return null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.864 -0400", hash_original_method = "7199FF25ED586C3851E847C0919D8CB4", hash_generated_method = "BA6402604F9BC69D8F8A8B3C80BF4819")
    @Override
    public void requestLayout() {
        if(!mBlockLayoutRequests)        
        {
            super.requestLayout();
        } //End block
        // ---------- Original Method ----------
        //if (!mBlockLayoutRequests) {
            //super.requestLayout();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.864 -0400", hash_original_method = "0B2662100CCA74662649DCCD28954A76", hash_generated_method = "D608FFC14FB40B63968679462FEBE496")
    @Override
    public SpinnerAdapter getAdapter() {
SpinnerAdapter varD72668EDE5E63ADF9340F3D8A19FD205_1334298826 =         mAdapter;
        varD72668EDE5E63ADF9340F3D8A19FD205_1334298826.addTaint(taint);
        return varD72668EDE5E63ADF9340F3D8A19FD205_1334298826;
        // ---------- Original Method ----------
        //return mAdapter;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.864 -0400", hash_original_method = "C515244CDC30F9529A71B0CAA70231C3", hash_generated_method = "6FA295B1B2DF7609E6502B6C711BF563")
    @Override
    public int getCount() {
        int varA7392E7FB156CE90DBA601C30BDAD9A0_777807961 = (mItemCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_438092208 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_438092208;
        // ---------- Original Method ----------
        //return mItemCount;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.865 -0400", hash_original_method = "AD87FEA47379DE9B1BE65A322C86E61D", hash_generated_method = "7A5CAADEAF350013DEB7DF31F5469631")
    public int pointToPosition(int x, int y) {
        addTaint(y);
        addTaint(x);
        Rect frame = mTouchFrame;
        if(frame == null)        
        {
            mTouchFrame = new Rect();
            frame = mTouchFrame;
        } //End block
        final int count = getChildCount();
for(int i = count - 1;i >= 0;i--)
        {
            View child = getChildAt(i);
            if(child.getVisibility() == View.VISIBLE)            
            {
                child.getHitRect(frame);
                if(frame.contains(x, y))                
                {
                    int varB4D2F09D0AD5244C9E57B5AF8AB759AE_1233503096 = (mFirstPosition + i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1795481488 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1795481488;
                } //End block
            } //End block
        } //End block
        int var296D6C732A05FBA51C5854FA7933FE23_181035889 = (INVALID_POSITION);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_621355882 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_621355882;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.866 -0400", hash_original_method = "2B2E0178AF4521152109C90D1424ECD0", hash_generated_method = "0D190B84F9B4C787C6A098B84BA3D0D1")
    @Override
    public Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Parcelable superState = super.onSaveInstanceState();
        SavedState ss = new SavedState(superState);
        ss.selectedId = getSelectedItemId();
        if(ss.selectedId >= 0)        
        {
            ss.position = getSelectedItemPosition();
        } //End block
        else
        {
            ss.position = INVALID_POSITION;
        } //End block
Parcelable var182E37827114C3F455816E0E29D81D76_382991945 =         ss;
        var182E37827114C3F455816E0E29D81D76_382991945.addTaint(taint);
        return var182E37827114C3F455816E0E29D81D76_382991945;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.867 -0400", hash_original_method = "41BC9B1A20EF7E956C712A8B84EE3401", hash_generated_method = "6E6C67961C05C24613BBF803BB4B7D0E")
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(state.getTaint());
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        if(ss.selectedId >= 0)        
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.868 -0400", hash_original_field = "74B7CE7BE804A955E8E20EA04653DEE6", hash_generated_field = "C7298A539520D9945816CD36ABAD339C")

        long selectedId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.868 -0400", hash_original_field = "4757FE07FD492A8BE0EA6A760D683D6E", hash_generated_field = "92D7808EB8CD548A137230400384C6DC")

        int position;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.868 -0400", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "3F4F70129FCB46E4AE0D334AE4D70CF6")
          SavedState(Parcelable superState) {
            super(superState);
            addTaint(superState.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.869 -0400", hash_original_method = "65E5A0CAB50633949DC788A62A186FA9", hash_generated_method = "5605444F121F9896A1C4C86DC8A5C0CA")
        private  SavedState(Parcel in) {
            super(in);
            selectedId = in.readLong();
            position = in.readInt();
            // ---------- Original Method ----------
            //selectedId = in.readLong();
            //position = in.readInt();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.869 -0400", hash_original_method = "0007C2F01F0ACF691918256360E82965", hash_generated_method = "F5937594D59A756735DED12EE46A3860")
        @Override
        public void writeToParcel(Parcel out, int flags) {
            addTaint(flags);
            addTaint(out.getTaint());
            super.writeToParcel(out, flags);
            out.writeLong(selectedId);
            out.writeInt(position);
            // ---------- Original Method ----------
            //super.writeToParcel(out, flags);
            //out.writeLong(selectedId);
            //out.writeInt(position);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.869 -0400", hash_original_method = "7A4BA85F6ACBC7FE9656B24BA8A57B9A", hash_generated_method = "F0440F1834A5939016E4B763143BB44A")
        @Override
        public String toString() {
String var7F98A14C1972F3FDF68002B7A4E6BB79_1824766963 =             "AbsSpinner.SavedState{"
                    + Integer.toHexString(System.identityHashCode(this))
                    + " selectedId=" + selectedId
                    + " position=" + position + "}";
            var7F98A14C1972F3FDF68002B7A4E6BB79_1824766963.addTaint(taint);
            return var7F98A14C1972F3FDF68002B7A4E6BB79_1824766963;
            // ---------- Original Method ----------
            //return "AbsSpinner.SavedState{"
                    //+ Integer.toHexString(System.identityHashCode(this))
                    //+ " selectedId=" + selectedId
                    //+ " position=" + position + "}";
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.869 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

        public static final Parcelable.Creator<SavedState> CREATOR
                = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.870 -0400", hash_original_field = "ED381F69EA048DBD7DEC6FEB8091230C", hash_generated_field = "344735C1BC7661738F3886E8FB539FBF")

        private final SparseArray<View> mScrapHeap = new SparseArray<View>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.870 -0400", hash_original_method = "8B96BADF61C6544CC3B73116E3B60C53", hash_generated_method = "8B96BADF61C6544CC3B73116E3B60C53")
        public RecycleBin ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.870 -0400", hash_original_method = "12E9E54F63615166D97804FCD5F19EB6", hash_generated_method = "2EC5D81587167BC91E2E1BB9F0690B71")
        public void put(int position, View v) {
            addTaint(v.getTaint());
            addTaint(position);
            mScrapHeap.put(position, v);
            // ---------- Original Method ----------
            //mScrapHeap.put(position, v);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.870 -0400", hash_original_method = "13D5A4FF59BF1643EBD5228E429384EA", hash_generated_method = "29B802FE1C945BB12582532A43A27299")
         View get(int position) {
            addTaint(position);
            View result = mScrapHeap.get(position);
            if(result != null)            
            {
                mScrapHeap.delete(position);
            } //End block
            else
            {
            } //End block
View varDC838461EE2FA0CA4C9BBB70A15456B0_1135660274 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1135660274.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1135660274;
            // ---------- Original Method ----------
            //View result = mScrapHeap.get(position);
            //if (result != null) {
                //mScrapHeap.delete(position);
            //} else {
            //}
            //return result;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:57.870 -0400", hash_original_method = "1B173351B88254AC852DFD7E9D6DC12C", hash_generated_method = "5F8216B28B89B55E3F67460770F4FE01")
         void clear() {
            final SparseArray<View> scrapHeap = mScrapHeap;
            final int count = scrapHeap.size();
for(int i = 0;i < count;i++)
            {
                final View view = scrapHeap.valueAt(i);
                if(view != null)                
                {
                    removeDetachedView(view, true);
                } //End block
            } //End block
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

