package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

public abstract class AdapterView<T extends Adapter> extends ViewGroup {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.655 -0400", hash_original_field = "8E50E9FFA5F23A5C36A761E8937EC922", hash_generated_field = "4CE3CF821E7A7D08A592A5CA9EDE4305")

    @ViewDebug.ExportedProperty(category = "scrolling") int mFirstPosition = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.655 -0400", hash_original_field = "F193766DFB19C4A493EF1C6412FB606C", hash_generated_field = "1356C3FA4037F030D6AAE99FCBE84372")

    int mSpecificTop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.655 -0400", hash_original_field = "59BCD2861376D613E18A97D4BF8FA2DD", hash_generated_field = "7CC7B89C1FD47B35803D575B68BC5B76")

    int mSyncPosition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.655 -0400", hash_original_field = "9EFF8C7B72AD24AED030E64D92912EAB", hash_generated_field = "4F8608A52A53AF9807409C41B4527AFB")

    long mSyncRowId = INVALID_ROW_ID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.655 -0400", hash_original_field = "B3CB76660F13884C2DEBA3FD490E11A3", hash_generated_field = "F7AF8C2BAFE5F1DFE6D7A4BF607BDBCD")

    long mSyncHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.655 -0400", hash_original_field = "2EF8A52963F5274DFB069D7ECBB42932", hash_generated_field = "36E09949FE1A68F854979C9033FBC538")

    boolean mNeedSync = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.655 -0400", hash_original_field = "75F18F0A1ADD19F0084A18B514E65D47", hash_generated_field = "2B35CC092A6C6E8EEC9E34C6BB35EE65")

    int mSyncMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.655 -0400", hash_original_field = "520D9EA4242DB911A0F3C826F30FBBB3", hash_generated_field = "2D1B3EFC128ADAB2A0F451FD22243A4A")

    private int mLayoutHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.655 -0400", hash_original_field = "BC93A99EA774F75F2A69A75731F09DB1", hash_generated_field = "A271CAA49C9300336DF6C9AF1632606C")

    boolean mInLayout = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.655 -0400", hash_original_field = "773B78B8354D6C9F88CCABB4FB2C5772", hash_generated_field = "8F5666816AF47A9E3F5850773164443C")

    OnItemSelectedListener mOnItemSelectedListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.655 -0400", hash_original_field = "83E8FC6B1DFB1AB13582963A76A27676", hash_generated_field = "08FFFEF948BF0E48E5DC5A108DD5C034")

    OnItemClickListener mOnItemClickListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.655 -0400", hash_original_field = "D5EF51375FD5B5E8FB89E01EB8EAF448", hash_generated_field = "4BAB6029D01B2FF02C842E49999DC46D")

    OnItemLongClickListener mOnItemLongClickListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.655 -0400", hash_original_field = "B22EA86E5DDE95010F9B86C843A0A649", hash_generated_field = "83E549BBF91CC465CA61B08DEBC896EF")

    boolean mDataChanged;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.655 -0400", hash_original_field = "4FBA782449994D4250C7B450B888242D", hash_generated_field = "66B8EF13CF844CE1F3C5141C656F857A")

    @ViewDebug.ExportedProperty(category = "list") int mNextSelectedPosition = INVALID_POSITION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.655 -0400", hash_original_field = "CF6CBF3F15C3F9619C117B341B53B488", hash_generated_field = "906F39A3FAE64762B6F7A2D4072C0BAD")

    long mNextSelectedRowId = INVALID_ROW_ID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.655 -0400", hash_original_field = "C41320DE8711922E73E25AF73A13EE50", hash_generated_field = "E706686D8FE4DBC37237587CD10C50B2")

    @ViewDebug.ExportedProperty(category = "list") int mSelectedPosition = INVALID_POSITION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.655 -0400", hash_original_field = "EAECE08635AB3CD69250AF5D63D64F55", hash_generated_field = "98FDE0E0DABA26150FB8FA9058D8AFC6")

    long mSelectedRowId = INVALID_ROW_ID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.655 -0400", hash_original_field = "70C77B82E1F7307619839CA84E110E30", hash_generated_field = "23D73844C09FA19BF301A2A8334AD4E3")

    private View mEmptyView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.655 -0400", hash_original_field = "A7392E7FB156CE90DBA601C30BDAD9A0", hash_generated_field = "E38048D7118EEC0395C87E12259EFC13")

    @ViewDebug.ExportedProperty(category = "list") int mItemCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.655 -0400", hash_original_field = "E44C23C9220B221440C647F151534AE9", hash_generated_field = "11CEF45C71860367629AA01FA1F19186")

    int mOldItemCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.655 -0400", hash_original_field = "660CF5A43D07D5B2B75AAAE4E574C0D0", hash_generated_field = "45F58AF0B51928EE668B688AA98FB139")

    int mOldSelectedPosition = INVALID_POSITION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.655 -0400", hash_original_field = "D2FC674BFBC3B0165C93957BC182DE15", hash_generated_field = "CB32ED3EEEBFFF33346065AAF76C3C3F")

    long mOldSelectedRowId = INVALID_ROW_ID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.655 -0400", hash_original_field = "8007A60A4DF695EEE4B7A7DFDBF42113", hash_generated_field = "0083FDFAC63D8D5618A73B94F2CA2AA1")

    private boolean mDesiredFocusableState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.655 -0400", hash_original_field = "AC9A5948B7A0101ED51B6704B71D68C3", hash_generated_field = "131C0A29C612D5C490F82CC6B3FE313B")

    private boolean mDesiredFocusableInTouchModeState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.655 -0400", hash_original_field = "FE7E74512E6682C2B99C555B029D4EDE", hash_generated_field = "D942A048D23A80D010658FB1C8D03182")

    private SelectionNotifier mSelectionNotifier;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.656 -0400", hash_original_field = "FD54F4B9ADF9F654ECD215741AD80C16", hash_generated_field = "9EF8ED98BBEB87000E69C25673FFDD81")

    boolean mBlockLayoutRequests = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.656 -0400", hash_original_method = "57FCDFF67BC1DAFCD174DA15B87A1337", hash_generated_method = "89DE8E953EDF7F5507A398476298E1EB")
    public  AdapterView(Context context) {
        super(context);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.656 -0400", hash_original_method = "A1536CC4437039F5CF27987414A5A415", hash_generated_method = "69B53137A2C873788E8CC0B1CA842AD4")
    public  AdapterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.656 -0400", hash_original_method = "4DD39388BA45E8CBF534A54DFA59E3BD", hash_generated_method = "036DB569FA35F269CA0E8B35B9D86C71")
    public  AdapterView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.656 -0400", hash_original_method = "3AA164DD2030E1BF06F3CA1CD9427DA1", hash_generated_method = "A196844E345185ADD2A42B24D8C435A9")
    public void setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickListener = listener;
        // ---------- Original Method ----------
        //mOnItemClickListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.657 -0400", hash_original_method = "53FBB33228561FD1F46130BA576FD131", hash_generated_method = "AC353587F26123B5CD6F87D80F6DD45C")
    public final OnItemClickListener getOnItemClickListener() {
        OnItemClickListener varB4EAC82CA7396A68D541C85D26508E83_443223381 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_443223381 = mOnItemClickListener;
        varB4EAC82CA7396A68D541C85D26508E83_443223381.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_443223381;
        // ---------- Original Method ----------
        //return mOnItemClickListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.657 -0400", hash_original_method = "60B3F62567C83CF5181D16CCAFD621F4", hash_generated_method = "4B5256CBF5873AA3C8338760C636A51D")
    public boolean performItemClick(View view, int position, long id) {
        {
            playSoundEffect(SoundEffectConstants.CLICK);
            {
                view.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_CLICKED);
            } //End block
            mOnItemClickListener.onItemClick(this, view, position, id);
        } //End block
        addTaint(view.getTaint());
        addTaint(position);
        addTaint(id);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2101864350 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2101864350;
        // ---------- Original Method ----------
        //if (mOnItemClickListener != null) {
            //playSoundEffect(SoundEffectConstants.CLICK);
            //if (view != null) {
                //view.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_CLICKED);
            //}
            //mOnItemClickListener.onItemClick(this, view, position, id);
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.658 -0400", hash_original_method = "8890007B6750F9F3A0AF363421C33470", hash_generated_method = "9EE6301EF4174B880BE5A4CEC51CAA65")
    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        {
            boolean var4E9822764F29F607F332912995A375BC_103617009 = (!isLongClickable());
            {
                setLongClickable(true);
            } //End block
        } //End collapsed parenthetic
        mOnItemLongClickListener = listener;
        // ---------- Original Method ----------
        //if (!isLongClickable()) {
            //setLongClickable(true);
        //}
        //mOnItemLongClickListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.658 -0400", hash_original_method = "450D7DEA9BB200CD772C171D001DF2F0", hash_generated_method = "238555DFA1DFFD4319D99A04B84D2E45")
    public final OnItemLongClickListener getOnItemLongClickListener() {
        OnItemLongClickListener varB4EAC82CA7396A68D541C85D26508E83_1199985309 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1199985309 = mOnItemLongClickListener;
        varB4EAC82CA7396A68D541C85D26508E83_1199985309.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1199985309;
        // ---------- Original Method ----------
        //return mOnItemLongClickListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.659 -0400", hash_original_method = "9092AD2A5F83CE601E3913D803C386F2", hash_generated_method = "3770EE67FA344D6B0564B2ED3CB34217")
    public void setOnItemSelectedListener(OnItemSelectedListener listener) {
        mOnItemSelectedListener = listener;
        // ---------- Original Method ----------
        //mOnItemSelectedListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.660 -0400", hash_original_method = "C1B2E8F5BC8E80BA634AE326A645C328", hash_generated_method = "1C219A0E6A332FFE7CCAD72AE26F9EE1")
    public final OnItemSelectedListener getOnItemSelectedListener() {
        OnItemSelectedListener varB4EAC82CA7396A68D541C85D26508E83_572233792 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_572233792 = mOnItemSelectedListener;
        varB4EAC82CA7396A68D541C85D26508E83_572233792.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_572233792;
        // ---------- Original Method ----------
        //return mOnItemSelectedListener;
    }

    
    public abstract T getAdapter();

    
    public abstract void setAdapter(T adapter);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.660 -0400", hash_original_method = "F16CCCAA9B27A0794F506D96FD601909", hash_generated_method = "145FB997CFFDA211F54C792B23BD6B23")
    @Override
    public void addView(View child) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
        addTaint(child.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.660 -0400", hash_original_method = "A0B74413A848464618EA89DE3FE41FDC", hash_generated_method = "BDFE00069BAF86F8A8675385540DAFE6")
    @Override
    public void addView(View child, int index) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
        addTaint(child.getTaint());
        addTaint(index);
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.661 -0400", hash_original_method = "18B2907968F7312EE2BBDDA25EF143B2", hash_generated_method = "13C55062F9764CD4D10AD980050D42B8")
    @Override
    public void addView(View child, LayoutParams params) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("addView(View, LayoutParams) "
                + "is not supported in AdapterView");
        addTaint(child.getTaint());
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("addView(View, LayoutParams) "
                //+ "is not supported in AdapterView");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.661 -0400", hash_original_method = "ECB319B81CB6A3F46E583210A29BAF16", hash_generated_method = "3E655DE7D9E177E0A19B383C743C7702")
    @Override
    public void addView(View child, int index, LayoutParams params) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("addView(View, int, LayoutParams) "
                + "is not supported in AdapterView");
        addTaint(child.getTaint());
        addTaint(index);
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("addView(View, int, LayoutParams) "
                //+ "is not supported in AdapterView");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.661 -0400", hash_original_method = "886BA97B45AC28A61B534339E77983B5", hash_generated_method = "9458AD14565524CD534FC86DB9F70667")
    @Override
    public void removeView(View child) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
        addTaint(child.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.661 -0400", hash_original_method = "EB15614617786EFEBA3A034D912AA71E", hash_generated_method = "9947B53FCC6EB24849248A2ECA8A900D")
    @Override
    public void removeViewAt(int index) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
        addTaint(index);
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.661 -0400", hash_original_method = "F33294BE6C28FDF867EC6161A7E416F0", hash_generated_method = "7B3E7F45AB92E9FDE7B41CDFC06F8C22")
    @Override
    public void removeAllViews() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.662 -0400", hash_original_method = "5EA85597DECD951B7F4C51D999F17C5D", hash_generated_method = "7B98BB087C42822E2587A6A5049ABD44")
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mLayoutHeight = getHeight();
        addTaint(changed);
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        // ---------- Original Method ----------
        //mLayoutHeight = getHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.662 -0400", hash_original_method = "40CA9E4E71293F3BC1D33E874AD305A1", hash_generated_method = "3656A4BD094B8D766CDC277268B48D82")
    @ViewDebug.CapturedViewProperty
    public int getSelectedItemPosition() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_733903633 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_733903633;
        // ---------- Original Method ----------
        //return mNextSelectedPosition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.662 -0400", hash_original_method = "52C80BDBAB2E8D6D945028E83F843260", hash_generated_method = "E0FFADFE16DEF8697855AAC434A6F934")
    @ViewDebug.CapturedViewProperty
    public long getSelectedItemId() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2104032660 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2104032660;
        // ---------- Original Method ----------
        //return mNextSelectedRowId;
    }

    
    public abstract View getSelectedView();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.663 -0400", hash_original_method = "F45E40D646583F63F7A00B28C1D0B4AE", hash_generated_method = "2D25797152FA93EA554D85C08FA52FAD")
    public Object getSelectedItem() {
        Object varB4EAC82CA7396A68D541C85D26508E83_290831941 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1933273891 = null; //Variable for return #2
        T adapter = getAdapter();
        int selection = getSelectedItemPosition();
        {
            boolean varC431EBC257F1DAB69F88175BCB5250FC_1899139464 = (adapter != null && adapter.getCount() > 0 && selection >= 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_290831941 = adapter.getItem(selection);
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1933273891 = null;
            } //End block
        } //End collapsed parenthetic
        Object varA7E53CE21691AB073D9660D615818899_187677226; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_187677226 = varB4EAC82CA7396A68D541C85D26508E83_290831941;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_187677226 = varB4EAC82CA7396A68D541C85D26508E83_1933273891;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_187677226.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_187677226;
        // ---------- Original Method ----------
        //T adapter = getAdapter();
        //int selection = getSelectedItemPosition();
        //if (adapter != null && adapter.getCount() > 0 && selection >= 0) {
            //return adapter.getItem(selection);
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.663 -0400", hash_original_method = "C515244CDC30F9529A71B0CAA70231C3", hash_generated_method = "F6E1BF723D4FAB19492B011A4A6B54C6")
    @ViewDebug.CapturedViewProperty
    public int getCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_566346818 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_566346818;
        // ---------- Original Method ----------
        //return mItemCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.663 -0400", hash_original_method = "7F8A3609232C6E4C7447DF803294CB0C", hash_generated_method = "2B416CAA9081846759E587ECCA3C5614")
    public int getPositionForView(View view) {
        View listItem = view;
        try 
        {
            View v;
            {
                boolean varE341D27A264F3482D6A76BDFDFF68A64_1265717426 = (!(v = (View) listItem.getParent()).equals(this));
                {
                    listItem = v;
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (ClassCastException e)
        { }
        final int childCount = getChildCount();
        {
            int i = 0;
            {
                {
                    boolean varAB7E8859D0826E12EC53AD21DB274535_2132787503 = (getChildAt(i).equals(listItem));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(view.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_800221358 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_800221358;
        // ---------- Original Method ----------
        //View listItem = view;
        //try {
            //View v;
            //while (!(v = (View) listItem.getParent()).equals(this)) {
                //listItem = v;
            //}
        //} catch (ClassCastException e) {
            //return INVALID_POSITION;
        //}
        //final int childCount = getChildCount();
        //for (int i = 0; i < childCount; i++) {
            //if (getChildAt(i).equals(listItem)) {
                //return mFirstPosition + i;
            //}
        //}
        //return INVALID_POSITION;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.664 -0400", hash_original_method = "3F582E36FEB434C42F8F2A7A83CA506D", hash_generated_method = "27754E7CB6B75E7B132D5A3B22B01EEE")
    public int getFirstVisiblePosition() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_836518183 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_836518183;
        // ---------- Original Method ----------
        //return mFirstPosition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.664 -0400", hash_original_method = "E5B0A16A7A6C9870BA6F980F2DB39BC0", hash_generated_method = "518F5D18719EC6A3943ECDA49552EE2C")
    public int getLastVisiblePosition() {
        int var502BAFD3638A317DEFA14DE990B7A10C_764515066 = (mFirstPosition + getChildCount() - 1);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_174504277 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_174504277;
        // ---------- Original Method ----------
        //return mFirstPosition + getChildCount() - 1;
    }

    
    public abstract void setSelection(int position);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.664 -0400", hash_original_method = "0D2B56D1373B44CFA7E95FC0E87B79DB", hash_generated_method = "8E748D2326E52097E9FAD33718F590E4")
    @android.view.RemotableViewMethod
    public void setEmptyView(View emptyView) {
        mEmptyView = emptyView;
        final T adapter = getAdapter();
        final boolean empty = ((adapter == null) || adapter.isEmpty());
        updateEmptyStatus(empty);
        // ---------- Original Method ----------
        //mEmptyView = emptyView;
        //final T adapter = getAdapter();
        //final boolean empty = ((adapter == null) || adapter.isEmpty());
        //updateEmptyStatus(empty);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.665 -0400", hash_original_method = "1914B98508B1C21B71F42F5D07F0BF47", hash_generated_method = "58200381F95EE06C721FBAEBA51CDA61")
    public View getEmptyView() {
        View varB4EAC82CA7396A68D541C85D26508E83_978037219 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_978037219 = mEmptyView;
        varB4EAC82CA7396A68D541C85D26508E83_978037219.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_978037219;
        // ---------- Original Method ----------
        //return mEmptyView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.665 -0400", hash_original_method = "FD285526E2677013E6DDAFB01C953F85", hash_generated_method = "86D12ECC1FDC46303CAE019F0AA55EBF")
     boolean isInFilterMode() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_920754135 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_920754135;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.666 -0400", hash_original_method = "2405FD914E83FFA9F0D8BC78F36E017E", hash_generated_method = "3C1A3801E2E9BE95FDAD7C802E345168")
    @Override
    public void setFocusable(boolean focusable) {
        final T adapter = getAdapter();
        final boolean empty = adapter == null || adapter.getCount() == 0;
        mDesiredFocusableState = focusable;
        {
            mDesiredFocusableInTouchModeState = false;
        } //End block
        super.setFocusable(focusable && (!empty || isInFilterMode()));
        // ---------- Original Method ----------
        //final T adapter = getAdapter();
        //final boolean empty = adapter == null || adapter.getCount() == 0;
        //mDesiredFocusableState = focusable;
        //if (!focusable) {
            //mDesiredFocusableInTouchModeState = false;
        //}
        //super.setFocusable(focusable && (!empty || isInFilterMode()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.666 -0400", hash_original_method = "510CB97D998AEB67CD24BEC214B467D4", hash_generated_method = "D9E463ADA716348E686B158F98DCCC6B")
    @Override
    public void setFocusableInTouchMode(boolean focusable) {
        final T adapter = getAdapter();
        final boolean empty = adapter == null || adapter.getCount() == 0;
        mDesiredFocusableInTouchModeState = focusable;
        {
            mDesiredFocusableState = true;
        } //End block
        super.setFocusableInTouchMode(focusable && (!empty || isInFilterMode()));
        // ---------- Original Method ----------
        //final T adapter = getAdapter();
        //final boolean empty = adapter == null || adapter.getCount() == 0;
        //mDesiredFocusableInTouchModeState = focusable;
        //if (focusable) {
            //mDesiredFocusableState = true;
        //}
        //super.setFocusableInTouchMode(focusable && (!empty || isInFilterMode()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.666 -0400", hash_original_method = "247C1C860FE83D8C6969E8D7AD161A84", hash_generated_method = "C7CA13E55B65E643CE8BF7FFAAFBDA63")
     void checkFocus() {
        final T adapter = getAdapter();
        final boolean empty = adapter == null || adapter.getCount() == 0;
        final boolean focusable = !empty || isInFilterMode();
        super.setFocusableInTouchMode(focusable && mDesiredFocusableInTouchModeState);
        super.setFocusable(focusable && mDesiredFocusableState);
        {
            updateEmptyStatus((adapter == null) || adapter.isEmpty());
        } //End block
        // ---------- Original Method ----------
        //final T adapter = getAdapter();
        //final boolean empty = adapter == null || adapter.getCount() == 0;
        //final boolean focusable = !empty || isInFilterMode();
        //super.setFocusableInTouchMode(focusable && mDesiredFocusableInTouchModeState);
        //super.setFocusable(focusable && mDesiredFocusableState);
        //if (mEmptyView != null) {
            //updateEmptyStatus((adapter == null) || adapter.isEmpty());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.667 -0400", hash_original_method = "3E542C38250D34B64375C7B9ACE53374", hash_generated_method = "09E958A226B03F987B91F63090D28978")
    private void updateEmptyStatus(boolean empty) {
        {
            boolean varF35CB9186B7E386AC3090FFD7A78DB53_896461751 = (isInFilterMode());
            {
                empty = false;
            } //End block
        } //End collapsed parenthetic
        {
            {
                mEmptyView.setVisibility(View.VISIBLE);
                setVisibility(View.GONE);
            } //End block
            {
                setVisibility(View.VISIBLE);
            } //End block
            {
                this.onLayout(false, mLeft, mTop, mRight, mBottom);
            } //End block
        } //End block
        {
            mEmptyView.setVisibility(View.GONE);
            setVisibility(View.VISIBLE);
        } //End block
        addTaint(empty);
        // ---------- Original Method ----------
        //if (isInFilterMode()) {
            //empty = false;
        //}
        //if (empty) {
            //if (mEmptyView != null) {
                //mEmptyView.setVisibility(View.VISIBLE);
                //setVisibility(View.GONE);
            //} else {
                //setVisibility(View.VISIBLE);
            //}
            //if (mDataChanged) {           
                //this.onLayout(false, mLeft, mTop, mRight, mBottom); 
            //}
        //} else {
            //if (mEmptyView != null) mEmptyView.setVisibility(View.GONE);
            //setVisibility(View.VISIBLE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.667 -0400", hash_original_method = "D3C6D351E34AE1C5D83960F098A550AE", hash_generated_method = "BB8C6B975AB1DD97192D0175CF18F97C")
    public Object getItemAtPosition(int position) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1643090665 = null; //Variable for return #1
        T adapter = getAdapter();
        varB4EAC82CA7396A68D541C85D26508E83_1643090665 = (adapter == null || position < 0) ? null : adapter.getItem(position);
        addTaint(position);
        varB4EAC82CA7396A68D541C85D26508E83_1643090665.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1643090665;
        // ---------- Original Method ----------
        //T adapter = getAdapter();
        //return (adapter == null || position < 0) ? null : adapter.getItem(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.668 -0400", hash_original_method = "1B8B19ED8D728A74BB7DD4694FA31397", hash_generated_method = "ED742B74348124C6531D6A277C1CEA00")
    public long getItemIdAtPosition(int position) {
        T adapter = getAdapter();
        {
            Object var97E149A12F4F82A568B3B77523943250_1965816234 = (adapter.getItemId(position));
        } //End flattened ternary
        addTaint(position);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2022687397 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2022687397;
        // ---------- Original Method ----------
        //T adapter = getAdapter();
        //return (adapter == null || position < 0) ? INVALID_ROW_ID : adapter.getItemId(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.669 -0400", hash_original_method = "1A557FA8FE05A519D86B900EB24DF4D7", hash_generated_method = "74042BFF42114FD364A865223DB74646")
    @Override
    public void setOnClickListener(OnClickListener l) {
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Don't call setOnClickListener for an AdapterView. "
                + "You probably want setOnItemClickListener instead");
        addTaint(l.getTaint());
        // ---------- Original Method ----------
        //throw new RuntimeException("Don't call setOnClickListener for an AdapterView. "
                //+ "You probably want setOnItemClickListener instead");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.669 -0400", hash_original_method = "0F3E63187E008FDE1692E75AF7E8484F", hash_generated_method = "54957434D3FBF941E99B0E4D72721821")
    @Override
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        dispatchFreezeSelfOnly(container);
        addTaint(container.getTaint());
        // ---------- Original Method ----------
        //dispatchFreezeSelfOnly(container);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.669 -0400", hash_original_method = "3B9D7DC916535DA1F64238687579C1A4", hash_generated_method = "E362119FE0F4B2603664E90AC9E36821")
    @Override
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        dispatchThawSelfOnly(container);
        addTaint(container.getTaint());
        // ---------- Original Method ----------
        //dispatchThawSelfOnly(container);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.670 -0400", hash_original_method = "8130EF0B42BA515F653DEDC83DE0BC01", hash_generated_method = "8B173CA825B846127BB6829734ADDC00")
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDetachedFromWindow();
        removeCallbacks(mSelectionNotifier);
        // ---------- Original Method ----------
        //super.onDetachedFromWindow();
        //removeCallbacks(mSelectionNotifier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.671 -0400", hash_original_method = "BC6042705725732210E15D64CD41C7D9", hash_generated_method = "0C180C7DB637EEA7E2A006109772E974")
     void selectionChanged() {
        {
            {
                {
                    mSelectionNotifier = new SelectionNotifier();
                } //End block
                post(mSelectionNotifier);
            } //End block
            {
                fireOnSelected();
            } //End block
        } //End block
        {
            boolean var5C1F0A052282BDFB4F8B56B7331CF594_1661730815 = (mSelectedPosition != ListView.INVALID_POSITION && isShown() && !isInTouchMode());
            {
                sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SELECTED);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mOnItemSelectedListener != null) {
            //if (mInLayout || mBlockLayoutRequests) {
                //if (mSelectionNotifier == null) {
                    //mSelectionNotifier = new SelectionNotifier();
                //}
                //post(mSelectionNotifier);
            //} else {
                //fireOnSelected();
            //}
        //}
        //if (mSelectedPosition != ListView.INVALID_POSITION && isShown() && !isInTouchMode()) {
            //sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SELECTED);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.672 -0400", hash_original_method = "02337B5D029912B3F89D3F5D70F11AFE", hash_generated_method = "6422F7AC624F59A2CEBC51DC2246B68F")
    private void fireOnSelected() {
        int selection = this.getSelectedItemPosition();
        {
            View v = getSelectedView();
            mOnItemSelectedListener.onItemSelected(this, v, selection,
                    getAdapter().getItemId(selection));
        } //End block
        {
            mOnItemSelectedListener.onNothingSelected(this);
        } //End block
        // ---------- Original Method ----------
        //if (mOnItemSelectedListener == null)
            //return;
        //int selection = this.getSelectedItemPosition();
        //if (selection >= 0) {
            //View v = getSelectedView();
            //mOnItemSelectedListener.onItemSelected(this, v, selection,
                    //getAdapter().getItemId(selection));
        //} else {
            //mOnItemSelectedListener.onNothingSelected(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.673 -0400", hash_original_method = "2ECE900C628E5D932F56A2139561AD87", hash_generated_method = "B9DA440C20624BB8955229D0158655BB")
    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        View selectedView = getSelectedView();
        {
            boolean varAB0D18640FD723634A00876A9A643B2A_1978878627 = (selectedView != null && selectedView.getVisibility() == VISIBLE
                && selectedView.dispatchPopulateAccessibilityEvent(event));
        } //End collapsed parenthetic
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1725112724 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1725112724;
        // ---------- Original Method ----------
        //View selectedView = getSelectedView();
        //if (selectedView != null && selectedView.getVisibility() == VISIBLE
                //&& selectedView.dispatchPopulateAccessibilityEvent(event)) {
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.673 -0400", hash_original_method = "6C132B6F44CAB6ECEF4D7E674DFB11BC", hash_generated_method = "7849D826B08CDDB303CCE48F0CA86E83")
    @Override
    public boolean onRequestSendAccessibilityEvent(View child, AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varFFC657A579ED797FAC38E2B4B1796721_2054377995 = (super.onRequestSendAccessibilityEvent(child, event));
            {
                AccessibilityEvent record = AccessibilityEvent.obtain();
                onInitializeAccessibilityEvent(record);
                child.dispatchPopulateAccessibilityEvent(record);
                event.appendRecord(record);
            } //End block
        } //End collapsed parenthetic
        addTaint(child.getTaint());
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1561616376 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1561616376;
        // ---------- Original Method ----------
        //if (super.onRequestSendAccessibilityEvent(child, event)) {
            //AccessibilityEvent record = AccessibilityEvent.obtain();
            //onInitializeAccessibilityEvent(record);
            //child.dispatchPopulateAccessibilityEvent(record);
            //event.appendRecord(record);
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.674 -0400", hash_original_method = "A92D1861287ECAEDED59E2308FF3FC59", hash_generated_method = "8C931D9C56CF0750D8BE151B28042B57")
    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onInitializeAccessibilityNodeInfo(info);
        info.setScrollable(isScrollableForAccessibility());
        View selectedView = getSelectedView();
        {
            info.setEnabled(selectedView.isEnabled());
        } //End block
        addTaint(info.getTaint());
        // ---------- Original Method ----------
        //super.onInitializeAccessibilityNodeInfo(info);
        //info.setScrollable(isScrollableForAccessibility());
        //View selectedView = getSelectedView();
        //if (selectedView != null) {
            //info.setEnabled(selectedView.isEnabled());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.674 -0400", hash_original_method = "73EE58FB2C3D5181C9EEF91D06B60047", hash_generated_method = "A63E2FA155253A45CF2A5BE4133C09C1")
    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onInitializeAccessibilityEvent(event);
        event.setScrollable(isScrollableForAccessibility());
        View selectedView = getSelectedView();
        {
            event.setEnabled(selectedView.isEnabled());
        } //End block
        event.setCurrentItemIndex(getSelectedItemPosition());
        event.setFromIndex(getFirstVisiblePosition());
        event.setToIndex(getLastVisiblePosition());
        event.setItemCount(getCount());
        addTaint(event.getTaint());
        // ---------- Original Method ----------
        //super.onInitializeAccessibilityEvent(event);
        //event.setScrollable(isScrollableForAccessibility());
        //View selectedView = getSelectedView();
        //if (selectedView != null) {
            //event.setEnabled(selectedView.isEnabled());
        //}
        //event.setCurrentItemIndex(getSelectedItemPosition());
        //event.setFromIndex(getFirstVisiblePosition());
        //event.setToIndex(getLastVisiblePosition());
        //event.setItemCount(getCount());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.674 -0400", hash_original_method = "1A6615688A72EC8D9F005EEFA4CD86A3", hash_generated_method = "6D2D47124B750355C2C2064FD9FBF9A8")
    private boolean isScrollableForAccessibility() {
        T adapter = getAdapter();
        {
            final int itemCount = adapter.getCount();
            boolean var0CADBBA3C9973A4C32A29A1A7D305AA3_1109090806 = (itemCount > 0
                && (getFirstVisiblePosition() > 0 || getLastVisiblePosition() < itemCount - 1));
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1323850662 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1323850662;
        // ---------- Original Method ----------
        //T adapter = getAdapter();
        //if (adapter != null) {
            //final int itemCount = adapter.getCount();
            //return itemCount > 0
                //&& (getFirstVisiblePosition() > 0 || getLastVisiblePosition() < itemCount - 1);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.675 -0400", hash_original_method = "F40AC428F4D570BD34339564A5B5BB04", hash_generated_method = "D96FE4DD182116F54A2E3EA775C9F017")
    @Override
    protected boolean canAnimate() {
        boolean varDA480D2F8FF037BACA5DB54A8FBF9642_867754124 = (super.canAnimate() && mItemCount > 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1010783647 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1010783647;
        // ---------- Original Method ----------
        //return super.canAnimate() && mItemCount > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.675 -0400", hash_original_method = "E1C2247A84AC5366AD699C7DB3F92349", hash_generated_method = "F717AFA3EB334057D0A4393746191E24")
     void handleDataChanged() {
        final int count = mItemCount;
        boolean found = false;
        {
            int newPos;
            {
                mNeedSync = false;
                newPos = findSyncPosition();
                {
                    int selectablePos = lookForSelectablePosition(newPos, true);
                    {
                        setNextSelectedPositionInt(newPos);
                        found = true;
                    } //End block
                } //End block
            } //End block
            {
                newPos = getSelectedItemPosition();
                {
                    newPos = count - 1;
                } //End block
                {
                    newPos = 0;
                } //End block
                int selectablePos = lookForSelectablePosition(newPos, true);
                {
                    selectablePos = lookForSelectablePosition(newPos, false);
                } //End block
                {
                    setNextSelectedPositionInt(selectablePos);
                    checkSelectionChanged();
                    found = true;
                } //End block
            } //End block
        } //End block
        {
            mSelectedPosition = INVALID_POSITION;
            mSelectedRowId = INVALID_ROW_ID;
            mNextSelectedPosition = INVALID_POSITION;
            mNextSelectedRowId = INVALID_ROW_ID;
            mNeedSync = false;
            checkSelectionChanged();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.676 -0400", hash_original_method = "25705A5902194616A467B0383F1D3CBC", hash_generated_method = "C4F0AB53E38DFFA650B0899EA0C97EF9")
     void checkSelectionChanged() {
        {
            selectionChanged();
            mOldSelectedPosition = mSelectedPosition;
            mOldSelectedRowId = mSelectedRowId;
        } //End block
        // ---------- Original Method ----------
        //if ((mSelectedPosition != mOldSelectedPosition) || (mSelectedRowId != mOldSelectedRowId)) {
            //selectionChanged();
            //mOldSelectedPosition = mSelectedPosition;
            //mOldSelectedRowId = mSelectedRowId;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.676 -0400", hash_original_method = "40C5EABEA31AF953B54DF3485AA93D4F", hash_generated_method = "E9CAFA7707DEF1B03FAB829D487A3400")
     int findSyncPosition() {
        int count = mItemCount;
        long idToMatch = mSyncRowId;
        int seed = mSyncPosition;
        seed = Math.max(0, seed);
        seed = Math.min(count - 1, seed);
        long endTime = SystemClock.uptimeMillis() + SYNC_MAX_DURATION_MILLIS;
        long rowId;
        int first = seed;
        int last = seed;
        boolean next = false;
        boolean hitFirst;
        boolean hitLast;
        T adapter = getAdapter();
        {
            boolean var456DAD1228A2E995CDD3C7508B2D1BC6_366488977 = (SystemClock.uptimeMillis() <= endTime);
            {
                rowId = adapter.getItemId(seed);
                hitLast = last == count - 1;
                hitFirst = first == 0;
                {
                    seed = last;
                    next = false;
                } //End block
                {
                    seed = first;
                    next = true;
                } //End block
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1144109001 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1144109001;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.677 -0400", hash_original_method = "63DA3BDCCF3458E05F2C2D5853C22A6D", hash_generated_method = "9BF9CFEFD32A051DE3DE39CF390F35F1")
     int lookForSelectablePosition(int position, boolean lookDown) {
        addTaint(position);
        addTaint(lookDown);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1733919945 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1733919945;
        // ---------- Original Method ----------
        //return position;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.677 -0400", hash_original_method = "DDA5E37B089AD4C213077E832500B341", hash_generated_method = "AC9CE4D7DE645D7E21690385786C7051")
     void setSelectedPositionInt(int position) {
        mSelectedPosition = position;
        mSelectedRowId = getItemIdAtPosition(position);
        // ---------- Original Method ----------
        //mSelectedPosition = position;
        //mSelectedRowId = getItemIdAtPosition(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.677 -0400", hash_original_method = "8F63B2D5F340C4F249BDEC055C5E8E67", hash_generated_method = "7C117729EAB4D3BE69EC2797A24AF1CB")
     void setNextSelectedPositionInt(int position) {
        mNextSelectedPosition = position;
        mNextSelectedRowId = getItemIdAtPosition(position);
        {
            mSyncPosition = position;
            mSyncRowId = mNextSelectedRowId;
        } //End block
        // ---------- Original Method ----------
        //mNextSelectedPosition = position;
        //mNextSelectedRowId = getItemIdAtPosition(position);
        //if (mNeedSync && mSyncMode == SYNC_SELECTED_POSITION && position >= 0) {
            //mSyncPosition = position;
            //mSyncRowId = mNextSelectedRowId;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.678 -0400", hash_original_method = "1A0C0740A6F6610404D57CE1BAD32EA0", hash_generated_method = "4EBA7C856D0FC3CCDFA45475B799741E")
     void rememberSyncState() {
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_530703522 = (getChildCount() > 0);
            {
                mNeedSync = true;
                mSyncHeight = mLayoutHeight;
                {
                    View v = getChildAt(mSelectedPosition - mFirstPosition);
                    mSyncRowId = mNextSelectedRowId;
                    mSyncPosition = mNextSelectedPosition;
                    {
                        mSpecificTop = v.getTop();
                    } //End block
                    mSyncMode = SYNC_SELECTED_POSITION;
                } //End block
                {
                    View v = getChildAt(0);
                    T adapter = getAdapter();
                    {
                        boolean var4513742AC4398C98A59B8301E0BEEF78_471868160 = (mFirstPosition >= 0 && mFirstPosition < adapter.getCount());
                        {
                            mSyncRowId = adapter.getItemId(mFirstPosition);
                        } //End block
                        {
                            mSyncRowId = NO_ID;
                        } //End block
                    } //End collapsed parenthetic
                    mSyncPosition = mFirstPosition;
                    {
                        mSpecificTop = v.getTop();
                    } //End block
                    mSyncMode = SYNC_FIRST_POSITION;
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static class AdapterContextMenuInfo implements ContextMenu.ContextMenuInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.678 -0400", hash_original_field = "5A24EF215C56029F60B6A6CBF69F7CB4", hash_generated_field = "7EF03B9C3ED3327C63848AE59101E3FF")

        public View targetView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.678 -0400", hash_original_field = "4757FE07FD492A8BE0EA6A760D683D6E", hash_generated_field = "B2F6CC92E86B46C8537E13B7CC7F6689")

        public int position;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.678 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "ED8148F95ABDB86AF6D25639B34D9053")

        public long id;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.679 -0400", hash_original_method = "4451CA35940742220E7BA55A02F436E7", hash_generated_method = "102314932B7CFACD3B161C44070D542F")
        public  AdapterContextMenuInfo(View targetView, int position, long id) {
            this.targetView = targetView;
            this.position = position;
            this.id = id;
            // ---------- Original Method ----------
            //this.targetView = targetView;
            //this.position = position;
            //this.id = id;
        }

        
    }


    
    class AdapterDataSetObserver extends DataSetObserver {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.679 -0400", hash_original_field = "9226893FC186C87D2EE76992FCE02058", hash_generated_field = "15D7943AB2107BDB644324BD26EFE009")

        private Parcelable mInstanceState = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.679 -0400", hash_original_method = "7D160EE0593E52FB18E5F3C663310860", hash_generated_method = "7D160EE0593E52FB18E5F3C663310860")
        public AdapterDataSetObserver ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.679 -0400", hash_original_method = "26DD6C25DA2F390817D1ECC15F4F8536", hash_generated_method = "D29D763468B134E4C168523A2AF4F4DF")
        @Override
        public void onChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mDataChanged = true;
            mOldItemCount = mItemCount;
            mItemCount = getAdapter().getCount();
            {
                boolean var863BC7806B599EEA548F40281B88AA1A_372116636 = (AdapterView.this.getAdapter().hasStableIds() && mInstanceState != null
                    && mOldItemCount == 0 && mItemCount > 0);
                {
                    AdapterView.this.onRestoreInstanceState(mInstanceState);
                    mInstanceState = null;
                } //End block
                {
                    rememberSyncState();
                } //End block
            } //End collapsed parenthetic
            checkFocus();
            requestLayout();
            // ---------- Original Method ----------
            //mDataChanged = true;
            //mOldItemCount = mItemCount;
            //mItemCount = getAdapter().getCount();
            //if (AdapterView.this.getAdapter().hasStableIds() && mInstanceState != null
                    //&& mOldItemCount == 0 && mItemCount > 0) {
                //AdapterView.this.onRestoreInstanceState(mInstanceState);
                //mInstanceState = null;
            //} else {
                //rememberSyncState();
            //}
            //checkFocus();
            //requestLayout();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.680 -0400", hash_original_method = "384362603CD3BC78F8E9701AA98D7AA3", hash_generated_method = "FC4CEF7E31B7C06600CB5B29A899B6E6")
        @Override
        public void onInvalidated() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mDataChanged = true;
            {
                boolean var7489B38452FA33CED2860E46905E6201_1855342886 = (AdapterView.this.getAdapter().hasStableIds());
                {
                    mInstanceState = AdapterView.this.onSaveInstanceState();
                } //End block
            } //End collapsed parenthetic
            mOldItemCount = mItemCount;
            mItemCount = 0;
            mSelectedPosition = INVALID_POSITION;
            mSelectedRowId = INVALID_ROW_ID;
            mNextSelectedPosition = INVALID_POSITION;
            mNextSelectedRowId = INVALID_ROW_ID;
            mNeedSync = false;
            checkFocus();
            requestLayout();
            // ---------- Original Method ----------
            //mDataChanged = true;
            //if (AdapterView.this.getAdapter().hasStableIds()) {
                //mInstanceState = AdapterView.this.onSaveInstanceState();
            //}
            //mOldItemCount = mItemCount;
            //mItemCount = 0;
            //mSelectedPosition = INVALID_POSITION;
            //mSelectedRowId = INVALID_ROW_ID;
            //mNextSelectedPosition = INVALID_POSITION;
            //mNextSelectedRowId = INVALID_ROW_ID;
            //mNeedSync = false;
            //checkFocus();
            //requestLayout();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.682 -0400", hash_original_method = "FEB1A2B1EE4CD2130FB08EC4E4CC489E", hash_generated_method = "45FAE979B6EF5255E98919F10948FE73")
        public void clearSavedState() {
            mInstanceState = null;
            // ---------- Original Method ----------
            //mInstanceState = null;
        }

        
    }


    
    private class SelectionNotifier implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.682 -0400", hash_original_method = "FB2FB370914C04BE018162856CF2098F", hash_generated_method = "FB2FB370914C04BE018162856CF2098F")
        public SelectionNotifier ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.682 -0400", hash_original_method = "D0BC3F1278F7B077D905A46BC661B1BD", hash_generated_method = "161195C825E796E6541DE9A18CB6F95D")
        public void run() {
            {
                {
                    boolean var6E1AA78244E28A1874D7E5FE58FB0DD3_806660851 = (getAdapter() != null);
                    {
                        post(this);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                fireOnSelected();
            } //End block
            // ---------- Original Method ----------
            //if (mDataChanged) {
                //if (getAdapter() != null) {
                    //post(this);
                //}
            //} else {
                //fireOnSelected();
            //}
        }

        
    }


    
    public interface OnItemClickListener {

        
        void onItemClick(AdapterView<?> parent, View view, int position, long id);
    }
    
    public interface OnItemLongClickListener {
        
        boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id);
    }
    
    public interface OnItemSelectedListener {
        
        void onItemSelected(AdapterView<?> parent, View view, int position, long id);

        
        void onNothingSelected(AdapterView<?> parent);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.682 -0400", hash_original_field = "59CB0C8407D37A458445E91F69D172AD", hash_generated_field = "AD689E79534925CB9E4BA4D493671F95")

    public static final int ITEM_VIEW_TYPE_IGNORE = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.682 -0400", hash_original_field = "BEE9C739D61F0989C7813DE23973BC9C", hash_generated_field = "2656BB1EECC5FAA0C353EF817B838CEE")

    public static final int ITEM_VIEW_TYPE_HEADER_OR_FOOTER = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.682 -0400", hash_original_field = "E5E70A339E147D3AA1E5D0962A19FBE1", hash_generated_field = "2ACDB95EC8FD03E59D37276160271BE6")

    static final int SYNC_SELECTED_POSITION = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.682 -0400", hash_original_field = "D9B92ABAF8DF19B70EFF9092A49F578F", hash_generated_field = "067E495BB5F5DE55AD427633175B121C")

    static final int SYNC_FIRST_POSITION = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.682 -0400", hash_original_field = "E1CDB006410C98DEF6DBC22BC17664DA", hash_generated_field = "E651483062BE384270CDB5009C3349DB")

    static final int SYNC_MAX_DURATION_MILLIS = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.682 -0400", hash_original_field = "78D008574FF4877A72651C9D9100850E", hash_generated_field = "74326D0EB2E635FB68B20B0C678CCDFD")

    public static final int INVALID_POSITION = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.682 -0400", hash_original_field = "3EDD10D278D00962919B3AE436975FFC", hash_generated_field = "716DCF1EC82526D22545C9F2FC7D9345")

    public static final long INVALID_ROW_ID = Long.MIN_VALUE;
}

