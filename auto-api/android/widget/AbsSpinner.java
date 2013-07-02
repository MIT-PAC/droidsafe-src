package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.166 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "F3411DF47899C6681AB924958C72D742")

    SpinnerAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.166 -0400", hash_original_field = "83EF3BEC73E74162514FD9850370830D", hash_generated_field = "D04E3D07D063C4D19518074C3829A73C")

    int mHeightMeasureSpec;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.166 -0400", hash_original_field = "E4DC884788F434BA56F0CFA9C4932AD6", hash_generated_field = "955DE0D4DCC8871A233CEA8D2F0A0C8A")

    int mWidthMeasureSpec;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.166 -0400", hash_original_field = "F81233D150D3DB2682CC30D24A9419DC", hash_generated_field = "16D5ED00E6F87F853BA44CD6D3C6B5B1")

    boolean mBlockLayoutRequests;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.166 -0400", hash_original_field = "EC383219D6D8A4B6B87A786F4327EE03", hash_generated_field = "753C8FC0C4D631C54FF77F2B10210084")

    int mSelectionLeftPadding = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.166 -0400", hash_original_field = "FA8EABBC9D79FB4F912796BE168AD76D", hash_generated_field = "50BDF542563848097B98D0F9CA864924")

    int mSelectionTopPadding = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.166 -0400", hash_original_field = "F2D6183DA068D77902D36BB38A7570E0", hash_generated_field = "3DC4FB7C9491C740968135A630596AA0")

    int mSelectionRightPadding = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.166 -0400", hash_original_field = "63EC0412604CE1A7BE02B1C77E43E6CF", hash_generated_field = "7187B403BE2B79CEAB01DB70095A8709")

    int mSelectionBottomPadding = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.166 -0400", hash_original_field = "DD19C67D0D02D080ABB6E81DCB716347", hash_generated_field = "4083C73A2606B3CF98A9A07B6027B252")

    final Rect mSpinnerPadding = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.166 -0400", hash_original_field = "850AAD212EF4F4A7E8993BB802A79E8B", hash_generated_field = "9569056224CF4BB7FAE062DA5103E35A")

    final RecycleBin mRecycler = new RecycleBin();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.167 -0400", hash_original_field = "1AB0B744C03B78F09E9DEC3C88684ED1", hash_generated_field = "F16E8B0F167DE3008550015271235F93")

    private DataSetObserver mDataSetObserver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.167 -0400", hash_original_field = "2D90C7DCE7997683B43703723C5CE198", hash_generated_field = "08F5569C270EF171D6F208986E4909DE")

    private Rect mTouchFrame;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.167 -0400", hash_original_method = "CE4C0E9ECE12F7FD7C8BEF83C3609839", hash_generated_method = "ECABB2D16EDB934B4633D7428463E47A")
    public  AbsSpinner(Context context) {
        super(context);
        initAbsSpinner();
        addTaint(context.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.167 -0400", hash_original_method = "48F93C8F12C5C0BCE27736B4F067DE36", hash_generated_method = "D5DB8376781CB824E0C969D164A8C92A")
    public  AbsSpinner(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.168 -0400", hash_original_method = "22AD9CC9923933C5995E60FF80D5916E", hash_generated_method = "43DAFD62F63C569FDDF165B9363EB1C6")
    public  AbsSpinner(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initAbsSpinner();
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.AbsSpinner, defStyle, 0);
        CharSequence[] entries = a.getTextArray(R.styleable.AbsSpinner_entries);
        {
            ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(context,
                            R.layout.simple_spinner_item, entries);
            adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
            setAdapter(adapter);
        } 
        a.recycle();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        
        
        
                
        
        
            
                    
                            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.168 -0400", hash_original_method = "189B5B9E645B86B5245C2FF55DEC5907", hash_generated_method = "95F290FF3D8900B1A5D05DB6AC9E34A4")
    private void initAbsSpinner() {
        setFocusable(true);
        setWillNotDraw(false);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.168 -0400", hash_original_method = "E5824BE9B0ACFF3A1B32EE310E006300", hash_generated_method = "865730D782B64768A3794AC6F204E276")
    @Override
    public void setAdapter(SpinnerAdapter adapter) {
        {
            mAdapter.unregisterDataSetObserver(mDataSetObserver);
            resetList();
        } 
        mAdapter = adapter;
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
            } 
        } 
        {
            checkFocus();
            resetList();
            checkSelectionChanged();
        } 
        requestLayout();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.169 -0400", hash_original_method = "5DEE49E4A107B00C6160988898CCE14A", hash_generated_method = "0FFDFA172FF8DE0D08C732AFE9AF8AB3")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.170 -0400", hash_original_method = "29BB60D69D80C0C6339E2E86482D98C0", hash_generated_method = "07F06A4367A4E6B52768CCB3A2740AAD")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        
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
        {
            handleDataChanged();
        } 
        int preferredHeight = 0;
        int preferredWidth = 0;
        boolean needsMeasuring = true;
        int selectedPosition = getSelectedItemPosition();
        {
            boolean var0A913476FEE00BF2CC6981FB21FC379C_1259325911 = (selectedPosition >= 0 && mAdapter != null && selectedPosition < mAdapter.getCount());
            {
                View view = mRecycler.get(selectedPosition);
                {
                    view = mAdapter.getView(selectedPosition, null, this);
                } 
                {
                    mRecycler.put(selectedPosition, view);
                } 
                {
                    {
                        boolean var5796118831C98F47A208EF62E7CCA9A9_894529429 = (view.getLayoutParams() == null);
                        {
                            mBlockLayoutRequests = true;
                            view.setLayoutParams(generateDefaultLayoutParams());
                            mBlockLayoutRequests = false;
                        } 
                    } 
                    measureChild(view, widthMeasureSpec, heightMeasureSpec);
                    preferredHeight = getChildHeight(view) + mSpinnerPadding.top + mSpinnerPadding.bottom;
                    preferredWidth = getChildWidth(view) + mSpinnerPadding.left + mSpinnerPadding.right;
                    needsMeasuring = false;
                } 
            } 
        } 
        {
            preferredHeight = mSpinnerPadding.top + mSpinnerPadding.bottom;
            {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.171 -0400", hash_original_method = "44D3B1A6F440757321735895159CF3F5", hash_generated_method = "65CC2049432B45845ECC8792071266D3")
     int getChildHeight(View child) {
        int var58D497011C6F03727DC75B3DA924936B_409851413 = (child.getMeasuredHeight());
        addTaint(child.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1811277488 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1811277488;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.171 -0400", hash_original_method = "3D627342594CC491E8B9982EF63DBDD8", hash_generated_method = "3D625B10C933DA2F1D3491C7C3999AE2")
     int getChildWidth(View child) {
        int var515E0207FEB0ACB672E13F622A8D400F_166777716 = (child.getMeasuredWidth());
        addTaint(child.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_390542201 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_390542201;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.172 -0400", hash_original_method = "2179BEF90E842D00377926E5531ABF89", hash_generated_method = "D306C3DBF781B259A76C683126CCC316")
    @Override
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        ViewGroup.LayoutParams varB4EAC82CA7396A68D541C85D26508E83_638468478 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_638468478 = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        varB4EAC82CA7396A68D541C85D26508E83_638468478.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_638468478;
        
        
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.172 -0400", hash_original_method = "44A3231F2CD8F60C6B590B4146A8EF3F", hash_generated_method = "A7620440A381073B188092E87143B021")
     void recycleAllViews() {
        final int childCount = getChildCount();
        final AbsSpinner.RecycleBin recycleBin = mRecycler;
        final int position = mFirstPosition;
        {
            int i = 0;
            {
                View v = getChildAt(i);
                int index = position + i;
                recycleBin.put(index, v);
            } 
        } 
        
        
        
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.172 -0400", hash_original_method = "D2708A7FDB907C7B6958E15DD672DA8E", hash_generated_method = "F39CE9F5ED7467029EAC46A2BB511D86")
    public void setSelection(int position, boolean animate) {
        boolean shouldAnimate = animate && mFirstPosition <= position &&
                position <= mFirstPosition + getChildCount() - 1;
        setSelectionInt(position, shouldAnimate);
        addTaint(position);
        addTaint(animate);
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.173 -0400", hash_original_method = "7E33360CBDBF59A4E473BBC01C4A9D09", hash_generated_method = "9104B6006943BC06479683337877C3BB")
    @Override
    public void setSelection(int position) {
        setNextSelectedPositionInt(position);
        requestLayout();
        invalidate();
        addTaint(position);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.173 -0400", hash_original_method = "63246E2C9E0D90A96046BA94228CF775", hash_generated_method = "EC16F84F87939DE6DFBCDCBC045FB2CD")
     void setSelectionInt(int position, boolean animate) {
        {
            mBlockLayoutRequests = true;
            int delta = position - mSelectedPosition;
            setNextSelectedPositionInt(position);
            layout(delta, animate);
            mBlockLayoutRequests = false;
        } 
        addTaint(position);
        addTaint(animate);
        
        
            
            
            
            
            
        
    }

    
    abstract void layout(int delta, boolean animate);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.174 -0400", hash_original_method = "B9D708BD110913DD38C752A46A05BBB4", hash_generated_method = "F8830D8EAD02158F7104B711DCC8D86E")
    @Override
    public View getSelectedView() {
        View varB4EAC82CA7396A68D541C85D26508E83_1712597896 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_1795881546 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1712597896 = getChildAt(mSelectedPosition - mFirstPosition);
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1795881546 = null;
        } 
        View varA7E53CE21691AB073D9660D615818899_1488100949; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1488100949 = varB4EAC82CA7396A68D541C85D26508E83_1712597896;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1488100949 = varB4EAC82CA7396A68D541C85D26508E83_1795881546;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1488100949.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1488100949;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.174 -0400", hash_original_method = "7199FF25ED586C3851E847C0919D8CB4", hash_generated_method = "4DAA914E3ADF769173AA0207A91E4AEA")
    @Override
    public void requestLayout() {
        {
            super.requestLayout();
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.175 -0400", hash_original_method = "0B2662100CCA74662649DCCD28954A76", hash_generated_method = "14D27C6525BFD7EB7D696933C008D797")
    @Override
    public SpinnerAdapter getAdapter() {
        SpinnerAdapter varB4EAC82CA7396A68D541C85D26508E83_1051455248 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1051455248 = mAdapter;
        varB4EAC82CA7396A68D541C85D26508E83_1051455248.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1051455248;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.175 -0400", hash_original_method = "C515244CDC30F9529A71B0CAA70231C3", hash_generated_method = "24B8E7D6A585CE032ADF2DE141429E1C")
    @Override
    public int getCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1164872065 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1164872065;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.175 -0400", hash_original_method = "AD87FEA47379DE9B1BE65A322C86E61D", hash_generated_method = "00030337FD7E28B459A9E6BC1575DDED")
    public int pointToPosition(int x, int y) {
        Rect frame = mTouchFrame;
        {
            mTouchFrame = new Rect();
            frame = mTouchFrame;
        } 
        final int count = getChildCount();
        {
            int i = count - 1;
            {
                View child = getChildAt(i);
                {
                    boolean var02E23769C3E76AF1DC2C1CE956107022_289538947 = (child.getVisibility() == View.VISIBLE);
                    {
                        child.getHitRect(frame);
                        {
                            boolean var9F1DF48D8B435FACEEE6B40EFD85C398_112076740 = (frame.contains(x, y));
                        } 
                    } 
                } 
            } 
        } 
        addTaint(x);
        addTaint(y);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_901846496 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_901846496;
        
        
        
            
            
        
        
        
            
            
                
                
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.176 -0400", hash_original_method = "2B2E0178AF4521152109C90D1424ECD0", hash_generated_method = "DCDD27BF6D79DD2411D0FF9C5EA6BACF")
    @Override
    public Parcelable onSaveInstanceState() {
        
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_775814061 = null; 
        Parcelable superState = super.onSaveInstanceState();
        SavedState ss = new SavedState(superState);
        ss.selectedId = getSelectedItemId();
        {
            ss.position = getSelectedItemPosition();
        } 
        {
            ss.position = INVALID_POSITION;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_775814061 = ss;
        varB4EAC82CA7396A68D541C85D26508E83_775814061.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_775814061;
        
        
        
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.176 -0400", hash_original_method = "41BC9B1A20EF7E956C712A8B84EE3401", hash_generated_method = "4E2383EB48CC9843E9907B01556FC731")
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        {
            mDataChanged = true;
            mNeedSync = true;
            mSyncRowId = ss.selectedId;
            mSyncPosition = ss.position;
            mSyncMode = SYNC_SELECTED_POSITION;
            requestLayout();
        } 
        addTaint(state.getTaint());
        
        
        
        
            
            
            
            
            
            
        
    }

    
    static class SavedState extends BaseSavedState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.176 -0400", hash_original_field = "74B7CE7BE804A955E8E20EA04653DEE6", hash_generated_field = "C7298A539520D9945816CD36ABAD339C")

        long selectedId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.176 -0400", hash_original_field = "4757FE07FD492A8BE0EA6A760D683D6E", hash_generated_field = "92D7808EB8CD548A137230400384C6DC")

        int position;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.177 -0400", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "3F4F70129FCB46E4AE0D334AE4D70CF6")
          SavedState(Parcelable superState) {
            super(superState);
            addTaint(superState.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.177 -0400", hash_original_method = "65E5A0CAB50633949DC788A62A186FA9", hash_generated_method = "5605444F121F9896A1C4C86DC8A5C0CA")
        private  SavedState(Parcel in) {
            super(in);
            selectedId = in.readLong();
            position = in.readInt();
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.177 -0400", hash_original_method = "0007C2F01F0ACF691918256360E82965", hash_generated_method = "347CA75C05F71CC1980710909652C080")
        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeLong(selectedId);
            out.writeInt(position);
            addTaint(out.getTaint());
            addTaint(flags);
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.178 -0400", hash_original_method = "7A4BA85F6ACBC7FE9656B24BA8A57B9A", hash_generated_method = "D407363F2B3793C2AEF6B75D0E8820DC")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1785075716 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1785075716 = "AbsSpinner.SavedState{"
                    + Integer.toHexString(System.identityHashCode(this))
                    + " selectedId=" + selectedId
                    + " position=" + position + "}";
            varB4EAC82CA7396A68D541C85D26508E83_1785075716.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1785075716;
            
            
                    
                    
                    
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.178 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

        public static final Parcelable.Creator<SavedState> CREATOR
                = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        
        public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }
        
        
        public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        
    }


    
    class RecycleBin {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.178 -0400", hash_original_field = "ED381F69EA048DBD7DEC6FEB8091230C", hash_generated_field = "344735C1BC7661738F3886E8FB539FBF")

        private final SparseArray<View> mScrapHeap = new SparseArray<View>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.178 -0400", hash_original_method = "8B96BADF61C6544CC3B73116E3B60C53", hash_generated_method = "8B96BADF61C6544CC3B73116E3B60C53")
        public RecycleBin ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.178 -0400", hash_original_method = "12E9E54F63615166D97804FCD5F19EB6", hash_generated_method = "FD5CD613A6FC2D8BC471B2C0D6206A01")
        public void put(int position, View v) {
            mScrapHeap.put(position, v);
            addTaint(position);
            addTaint(v.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.179 -0400", hash_original_method = "13D5A4FF59BF1643EBD5228E429384EA", hash_generated_method = "1D3E6EDB09EA7671798C830346D8574A")
         View get(int position) {
            View varB4EAC82CA7396A68D541C85D26508E83_2010319263 = null; 
            View result = mScrapHeap.get(position);
            {
                mScrapHeap.delete(position);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_2010319263 = result;
            addTaint(position);
            varB4EAC82CA7396A68D541C85D26508E83_2010319263.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2010319263;
            
            
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.179 -0400", hash_original_method = "1B173351B88254AC852DFD7E9D6DC12C", hash_generated_method = "A73B75028B4E0A5C6C0889A9C9B42503")
         void clear() {
            final SparseArray<View> scrapHeap = mScrapHeap;
            final int count = scrapHeap.size();
            {
                int i = 0;
                {
                    final View view = scrapHeap.valueAt(i);
                    {
                        removeDetachedView(view, true);
                    } 
                } 
            } 
            scrapHeap.clear();
            
            
            
            
                
                
                    
                
            
            
        }

        
    }


    
}

