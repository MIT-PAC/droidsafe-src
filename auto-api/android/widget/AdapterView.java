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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.856 -0400", hash_original_field = "8E50E9FFA5F23A5C36A761E8937EC922", hash_generated_field = "4CE3CF821E7A7D08A592A5CA9EDE4305")

    @ViewDebug.ExportedProperty(category = "scrolling") int mFirstPosition = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.856 -0400", hash_original_field = "F193766DFB19C4A493EF1C6412FB606C", hash_generated_field = "1356C3FA4037F030D6AAE99FCBE84372")

    int mSpecificTop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.856 -0400", hash_original_field = "59BCD2861376D613E18A97D4BF8FA2DD", hash_generated_field = "7CC7B89C1FD47B35803D575B68BC5B76")

    int mSyncPosition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.856 -0400", hash_original_field = "9EFF8C7B72AD24AED030E64D92912EAB", hash_generated_field = "4F8608A52A53AF9807409C41B4527AFB")

    long mSyncRowId = INVALID_ROW_ID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.856 -0400", hash_original_field = "B3CB76660F13884C2DEBA3FD490E11A3", hash_generated_field = "F7AF8C2BAFE5F1DFE6D7A4BF607BDBCD")

    long mSyncHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.856 -0400", hash_original_field = "2EF8A52963F5274DFB069D7ECBB42932", hash_generated_field = "36E09949FE1A68F854979C9033FBC538")

    boolean mNeedSync = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.856 -0400", hash_original_field = "75F18F0A1ADD19F0084A18B514E65D47", hash_generated_field = "2B35CC092A6C6E8EEC9E34C6BB35EE65")

    int mSyncMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.856 -0400", hash_original_field = "520D9EA4242DB911A0F3C826F30FBBB3", hash_generated_field = "2D1B3EFC128ADAB2A0F451FD22243A4A")

    private int mLayoutHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.856 -0400", hash_original_field = "BC93A99EA774F75F2A69A75731F09DB1", hash_generated_field = "A271CAA49C9300336DF6C9AF1632606C")

    boolean mInLayout = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.856 -0400", hash_original_field = "773B78B8354D6C9F88CCABB4FB2C5772", hash_generated_field = "8F5666816AF47A9E3F5850773164443C")

    OnItemSelectedListener mOnItemSelectedListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.856 -0400", hash_original_field = "83E8FC6B1DFB1AB13582963A76A27676", hash_generated_field = "08FFFEF948BF0E48E5DC5A108DD5C034")

    OnItemClickListener mOnItemClickListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.856 -0400", hash_original_field = "D5EF51375FD5B5E8FB89E01EB8EAF448", hash_generated_field = "4BAB6029D01B2FF02C842E49999DC46D")

    OnItemLongClickListener mOnItemLongClickListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.857 -0400", hash_original_field = "B22EA86E5DDE95010F9B86C843A0A649", hash_generated_field = "83E549BBF91CC465CA61B08DEBC896EF")

    boolean mDataChanged;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.857 -0400", hash_original_field = "4FBA782449994D4250C7B450B888242D", hash_generated_field = "66B8EF13CF844CE1F3C5141C656F857A")

    @ViewDebug.ExportedProperty(category = "list") int mNextSelectedPosition = INVALID_POSITION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.857 -0400", hash_original_field = "CF6CBF3F15C3F9619C117B341B53B488", hash_generated_field = "906F39A3FAE64762B6F7A2D4072C0BAD")

    long mNextSelectedRowId = INVALID_ROW_ID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.857 -0400", hash_original_field = "C41320DE8711922E73E25AF73A13EE50", hash_generated_field = "E706686D8FE4DBC37237587CD10C50B2")

    @ViewDebug.ExportedProperty(category = "list") int mSelectedPosition = INVALID_POSITION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.857 -0400", hash_original_field = "EAECE08635AB3CD69250AF5D63D64F55", hash_generated_field = "98FDE0E0DABA26150FB8FA9058D8AFC6")

    long mSelectedRowId = INVALID_ROW_ID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.857 -0400", hash_original_field = "70C77B82E1F7307619839CA84E110E30", hash_generated_field = "23D73844C09FA19BF301A2A8334AD4E3")

    private View mEmptyView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.857 -0400", hash_original_field = "A7392E7FB156CE90DBA601C30BDAD9A0", hash_generated_field = "E38048D7118EEC0395C87E12259EFC13")

    @ViewDebug.ExportedProperty(category = "list") int mItemCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.857 -0400", hash_original_field = "E44C23C9220B221440C647F151534AE9", hash_generated_field = "11CEF45C71860367629AA01FA1F19186")

    int mOldItemCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.857 -0400", hash_original_field = "660CF5A43D07D5B2B75AAAE4E574C0D0", hash_generated_field = "45F58AF0B51928EE668B688AA98FB139")

    int mOldSelectedPosition = INVALID_POSITION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.857 -0400", hash_original_field = "D2FC674BFBC3B0165C93957BC182DE15", hash_generated_field = "CB32ED3EEEBFFF33346065AAF76C3C3F")

    long mOldSelectedRowId = INVALID_ROW_ID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.857 -0400", hash_original_field = "8007A60A4DF695EEE4B7A7DFDBF42113", hash_generated_field = "0083FDFAC63D8D5618A73B94F2CA2AA1")

    private boolean mDesiredFocusableState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.857 -0400", hash_original_field = "AC9A5948B7A0101ED51B6704B71D68C3", hash_generated_field = "131C0A29C612D5C490F82CC6B3FE313B")

    private boolean mDesiredFocusableInTouchModeState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.857 -0400", hash_original_field = "FE7E74512E6682C2B99C555B029D4EDE", hash_generated_field = "D942A048D23A80D010658FB1C8D03182")

    private SelectionNotifier mSelectionNotifier;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.857 -0400", hash_original_field = "FD54F4B9ADF9F654ECD215741AD80C16", hash_generated_field = "9EF8ED98BBEB87000E69C25673FFDD81")

    boolean mBlockLayoutRequests = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.872 -0400", hash_original_method = "57FCDFF67BC1DAFCD174DA15B87A1337", hash_generated_method = "89DE8E953EDF7F5507A398476298E1EB")
    public  AdapterView(Context context) {
        super(context);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.873 -0400", hash_original_method = "A1536CC4437039F5CF27987414A5A415", hash_generated_method = "69B53137A2C873788E8CC0B1CA842AD4")
    public  AdapterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.873 -0400", hash_original_method = "4DD39388BA45E8CBF534A54DFA59E3BD", hash_generated_method = "036DB569FA35F269CA0E8B35B9D86C71")
    public  AdapterView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.873 -0400", hash_original_method = "3AA164DD2030E1BF06F3CA1CD9427DA1", hash_generated_method = "A196844E345185ADD2A42B24D8C435A9")
    public void setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickListener = listener;
        // ---------- Original Method ----------
        //mOnItemClickListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.874 -0400", hash_original_method = "53FBB33228561FD1F46130BA576FD131", hash_generated_method = "D72A83C611165D02A20B748DCB61F362")
    public final OnItemClickListener getOnItemClickListener() {
        OnItemClickListener varB4EAC82CA7396A68D541C85D26508E83_632393183 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_632393183 = mOnItemClickListener;
        varB4EAC82CA7396A68D541C85D26508E83_632393183.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_632393183;
        // ---------- Original Method ----------
        //return mOnItemClickListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.874 -0400", hash_original_method = "60B3F62567C83CF5181D16CCAFD621F4", hash_generated_method = "54B42238B3B25B086D531258CD8BEE25")
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1372182415 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1372182415;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.875 -0400", hash_original_method = "8890007B6750F9F3A0AF363421C33470", hash_generated_method = "4AC3D1F66982E1892CC8DBF4A7A7DC36")
    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        {
            boolean var4E9822764F29F607F332912995A375BC_280556062 = (!isLongClickable());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.875 -0400", hash_original_method = "450D7DEA9BB200CD772C171D001DF2F0", hash_generated_method = "17E9CD911D73B160E2B7D29CE80AE614")
    public final OnItemLongClickListener getOnItemLongClickListener() {
        OnItemLongClickListener varB4EAC82CA7396A68D541C85D26508E83_1472611434 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1472611434 = mOnItemLongClickListener;
        varB4EAC82CA7396A68D541C85D26508E83_1472611434.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1472611434;
        // ---------- Original Method ----------
        //return mOnItemLongClickListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.875 -0400", hash_original_method = "9092AD2A5F83CE601E3913D803C386F2", hash_generated_method = "3770EE67FA344D6B0564B2ED3CB34217")
    public void setOnItemSelectedListener(OnItemSelectedListener listener) {
        mOnItemSelectedListener = listener;
        // ---------- Original Method ----------
        //mOnItemSelectedListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.876 -0400", hash_original_method = "C1B2E8F5BC8E80BA634AE326A645C328", hash_generated_method = "C4E67E0E08A489FD1E293DB75F1426F4")
    public final OnItemSelectedListener getOnItemSelectedListener() {
        OnItemSelectedListener varB4EAC82CA7396A68D541C85D26508E83_194914617 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_194914617 = mOnItemSelectedListener;
        varB4EAC82CA7396A68D541C85D26508E83_194914617.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_194914617;
        // ---------- Original Method ----------
        //return mOnItemSelectedListener;
    }

    
    public abstract T getAdapter();

    
    public abstract void setAdapter(T adapter);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.877 -0400", hash_original_method = "F16CCCAA9B27A0794F506D96FD601909", hash_generated_method = "145FB997CFFDA211F54C792B23BD6B23")
    @Override
    public void addView(View child) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
        addTaint(child.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.877 -0400", hash_original_method = "A0B74413A848464618EA89DE3FE41FDC", hash_generated_method = "BDFE00069BAF86F8A8675385540DAFE6")
    @Override
    public void addView(View child, int index) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
        addTaint(child.getTaint());
        addTaint(index);
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.905 -0400", hash_original_method = "18B2907968F7312EE2BBDDA25EF143B2", hash_generated_method = "13C55062F9764CD4D10AD980050D42B8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.906 -0400", hash_original_method = "ECB319B81CB6A3F46E583210A29BAF16", hash_generated_method = "3E655DE7D9E177E0A19B383C743C7702")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.906 -0400", hash_original_method = "886BA97B45AC28A61B534339E77983B5", hash_generated_method = "9458AD14565524CD534FC86DB9F70667")
    @Override
    public void removeView(View child) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
        addTaint(child.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.906 -0400", hash_original_method = "EB15614617786EFEBA3A034D912AA71E", hash_generated_method = "9947B53FCC6EB24849248A2ECA8A900D")
    @Override
    public void removeViewAt(int index) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
        addTaint(index);
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.907 -0400", hash_original_method = "F33294BE6C28FDF867EC6161A7E416F0", hash_generated_method = "7B3E7F45AB92E9FDE7B41CDFC06F8C22")
    @Override
    public void removeAllViews() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.907 -0400", hash_original_method = "5EA85597DECD951B7F4C51D999F17C5D", hash_generated_method = "7B98BB087C42822E2587A6A5049ABD44")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.907 -0400", hash_original_method = "40CA9E4E71293F3BC1D33E874AD305A1", hash_generated_method = "5C0C20C292DFC56F9AF72DE594DE03E8")
    @ViewDebug.CapturedViewProperty
    public int getSelectedItemPosition() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1678346502 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1678346502;
        // ---------- Original Method ----------
        //return mNextSelectedPosition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.908 -0400", hash_original_method = "52C80BDBAB2E8D6D945028E83F843260", hash_generated_method = "BA310588EFFAD33375E81BA08982DB8D")
    @ViewDebug.CapturedViewProperty
    public long getSelectedItemId() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_35480338 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_35480338;
        // ---------- Original Method ----------
        //return mNextSelectedRowId;
    }

    
    public abstract View getSelectedView();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.909 -0400", hash_original_method = "F45E40D646583F63F7A00B28C1D0B4AE", hash_generated_method = "149D2CFFC8D90A6AE45218F614D1EFF6")
    public Object getSelectedItem() {
        Object varB4EAC82CA7396A68D541C85D26508E83_166000400 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1790486475 = null; //Variable for return #2
        T adapter;
        adapter = getAdapter();
        int selection;
        selection = getSelectedItemPosition();
        {
            boolean varC431EBC257F1DAB69F88175BCB5250FC_2067646295 = (adapter != null && adapter.getCount() > 0 && selection >= 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_166000400 = adapter.getItem(selection);
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1790486475 = null;
            } //End block
        } //End collapsed parenthetic
        Object varA7E53CE21691AB073D9660D615818899_1284173264; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1284173264 = varB4EAC82CA7396A68D541C85D26508E83_166000400;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1284173264 = varB4EAC82CA7396A68D541C85D26508E83_1790486475;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1284173264.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1284173264;
        // ---------- Original Method ----------
        //T adapter = getAdapter();
        //int selection = getSelectedItemPosition();
        //if (adapter != null && adapter.getCount() > 0 && selection >= 0) {
            //return adapter.getItem(selection);
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.909 -0400", hash_original_method = "C515244CDC30F9529A71B0CAA70231C3", hash_generated_method = "B17B7BB39C75785AABDED843D8F4856A")
    @ViewDebug.CapturedViewProperty
    public int getCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_27614908 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_27614908;
        // ---------- Original Method ----------
        //return mItemCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.915 -0400", hash_original_method = "7F8A3609232C6E4C7447DF803294CB0C", hash_generated_method = "D414AE9A74137698D8AB1D1EC48D72D0")
    public int getPositionForView(View view) {
        View listItem;
        listItem = view;
        try 
        {
            View v;
            {
                boolean varE341D27A264F3482D6A76BDFDFF68A64_1657502294 = (!(v = (View) listItem.getParent()).equals(this));
                {
                    listItem = v;
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (ClassCastException e)
        { }
        int childCount;
        childCount = getChildCount();
        {
            int i;
            i = 0;
            {
                {
                    boolean varAB7E8859D0826E12EC53AD21DB274535_898087212 = (getChildAt(i).equals(listItem));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(view.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_93215420 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_93215420;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.943 -0400", hash_original_method = "3F582E36FEB434C42F8F2A7A83CA506D", hash_generated_method = "DED3C650CDE1BEE97718173CDF6CE44B")
    public int getFirstVisiblePosition() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1735059291 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1735059291;
        // ---------- Original Method ----------
        //return mFirstPosition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.944 -0400", hash_original_method = "E5B0A16A7A6C9870BA6F980F2DB39BC0", hash_generated_method = "BA5A20CDBE08DF4055CFD0EB2EA41C50")
    public int getLastVisiblePosition() {
        int var502BAFD3638A317DEFA14DE990B7A10C_921911381 = (mFirstPosition + getChildCount() - 1);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1830901178 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1830901178;
        // ---------- Original Method ----------
        //return mFirstPosition + getChildCount() - 1;
    }

    
    public abstract void setSelection(int position);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.944 -0400", hash_original_method = "0D2B56D1373B44CFA7E95FC0E87B79DB", hash_generated_method = "01BE9ACE1CA385713538C364B0283635")
    @android.view.RemotableViewMethod
    public void setEmptyView(View emptyView) {
        mEmptyView = emptyView;
        T adapter;
        adapter = getAdapter();
        boolean empty;
        empty = ((adapter == null) || adapter.isEmpty());
        updateEmptyStatus(empty);
        // ---------- Original Method ----------
        //mEmptyView = emptyView;
        //final T adapter = getAdapter();
        //final boolean empty = ((adapter == null) || adapter.isEmpty());
        //updateEmptyStatus(empty);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.945 -0400", hash_original_method = "1914B98508B1C21B71F42F5D07F0BF47", hash_generated_method = "C8900FB9D900844C3F15C12C19709DA8")
    public View getEmptyView() {
        View varB4EAC82CA7396A68D541C85D26508E83_1916451895 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1916451895 = mEmptyView;
        varB4EAC82CA7396A68D541C85D26508E83_1916451895.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1916451895;
        // ---------- Original Method ----------
        //return mEmptyView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.945 -0400", hash_original_method = "FD285526E2677013E6DDAFB01C953F85", hash_generated_method = "E2A617AE2D45DB31AC83E726C1D13D14")
     boolean isInFilterMode() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1209878217 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1209878217;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.945 -0400", hash_original_method = "2405FD914E83FFA9F0D8BC78F36E017E", hash_generated_method = "39A90FA0C9F4AEE217CAF7975C53CC2C")
    @Override
    public void setFocusable(boolean focusable) {
        T adapter;
        adapter = getAdapter();
        boolean empty;
        empty = adapter == null || adapter.getCount() == 0;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.946 -0400", hash_original_method = "510CB97D998AEB67CD24BEC214B467D4", hash_generated_method = "8E7B86E1A083865B2237685FB1E81038")
    @Override
    public void setFocusableInTouchMode(boolean focusable) {
        T adapter;
        adapter = getAdapter();
        boolean empty;
        empty = adapter == null || adapter.getCount() == 0;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.946 -0400", hash_original_method = "247C1C860FE83D8C6969E8D7AD161A84", hash_generated_method = "34214D909D342D706EB49D1E32B9A23E")
     void checkFocus() {
        T adapter;
        adapter = getAdapter();
        boolean empty;
        empty = adapter == null || adapter.getCount() == 0;
        boolean focusable;
        focusable = !empty || isInFilterMode();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.971 -0400", hash_original_method = "3E542C38250D34B64375C7B9ACE53374", hash_generated_method = "F5EB52D4FB9652278D24958D43D4B980")
    private void updateEmptyStatus(boolean empty) {
        {
            boolean varF35CB9186B7E386AC3090FFD7A78DB53_1840839689 = (isInFilterMode());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.972 -0400", hash_original_method = "D3C6D351E34AE1C5D83960F098A550AE", hash_generated_method = "F827C547C886324381FBF21E298D31F9")
    public Object getItemAtPosition(int position) {
        Object varB4EAC82CA7396A68D541C85D26508E83_467658552 = null; //Variable for return #1
        T adapter;
        adapter = getAdapter();
        varB4EAC82CA7396A68D541C85D26508E83_467658552 = (adapter == null || position < 0) ? null : adapter.getItem(position);
        addTaint(position);
        varB4EAC82CA7396A68D541C85D26508E83_467658552.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_467658552;
        // ---------- Original Method ----------
        //T adapter = getAdapter();
        //return (adapter == null || position < 0) ? null : adapter.getItem(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.973 -0400", hash_original_method = "1B8B19ED8D728A74BB7DD4694FA31397", hash_generated_method = "27412C4EF04FF589524AEBCBDA9B4FDD")
    public long getItemIdAtPosition(int position) {
        T adapter;
        adapter = getAdapter();
        {
            Object var97E149A12F4F82A568B3B77523943250_1146600419 = (adapter.getItemId(position));
        } //End flattened ternary
        addTaint(position);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1740369924 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1740369924;
        // ---------- Original Method ----------
        //T adapter = getAdapter();
        //return (adapter == null || position < 0) ? INVALID_ROW_ID : adapter.getItemId(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.974 -0400", hash_original_method = "1A557FA8FE05A519D86B900EB24DF4D7", hash_generated_method = "74042BFF42114FD364A865223DB74646")
    @Override
    public void setOnClickListener(OnClickListener l) {
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Don't call setOnClickListener for an AdapterView. "
                + "You probably want setOnItemClickListener instead");
        addTaint(l.getTaint());
        // ---------- Original Method ----------
        //throw new RuntimeException("Don't call setOnClickListener for an AdapterView. "
                //+ "You probably want setOnItemClickListener instead");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.974 -0400", hash_original_method = "0F3E63187E008FDE1692E75AF7E8484F", hash_generated_method = "54957434D3FBF941E99B0E4D72721821")
    @Override
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        dispatchFreezeSelfOnly(container);
        addTaint(container.getTaint());
        // ---------- Original Method ----------
        //dispatchFreezeSelfOnly(container);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.974 -0400", hash_original_method = "3B9D7DC916535DA1F64238687579C1A4", hash_generated_method = "E362119FE0F4B2603664E90AC9E36821")
    @Override
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        dispatchThawSelfOnly(container);
        addTaint(container.getTaint());
        // ---------- Original Method ----------
        //dispatchThawSelfOnly(container);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.977 -0400", hash_original_method = "8130EF0B42BA515F653DEDC83DE0BC01", hash_generated_method = "8B173CA825B846127BB6829734ADDC00")
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDetachedFromWindow();
        removeCallbacks(mSelectionNotifier);
        // ---------- Original Method ----------
        //super.onDetachedFromWindow();
        //removeCallbacks(mSelectionNotifier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.983 -0400", hash_original_method = "BC6042705725732210E15D64CD41C7D9", hash_generated_method = "376AE60B93002CC9000E051D07E94EDF")
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
            boolean var5C1F0A052282BDFB4F8B56B7331CF594_999883762 = (mSelectedPosition != ListView.INVALID_POSITION && isShown() && !isInTouchMode());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.994 -0400", hash_original_method = "02337B5D029912B3F89D3F5D70F11AFE", hash_generated_method = "5209C9FA757C7C3C94F7FDDD5A7801CB")
    private void fireOnSelected() {
        int selection;
        selection = this.getSelectedItemPosition();
        {
            View v;
            v = getSelectedView();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.995 -0400", hash_original_method = "2ECE900C628E5D932F56A2139561AD87", hash_generated_method = "88A79A3CD5F48F85D7B76C1072E5ADBA")
    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        View selectedView;
        selectedView = getSelectedView();
        {
            boolean varAB0D18640FD723634A00876A9A643B2A_1049342386 = (selectedView != null && selectedView.getVisibility() == VISIBLE
                && selectedView.dispatchPopulateAccessibilityEvent(event));
        } //End collapsed parenthetic
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_241777129 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_241777129;
        // ---------- Original Method ----------
        //View selectedView = getSelectedView();
        //if (selectedView != null && selectedView.getVisibility() == VISIBLE
                //&& selectedView.dispatchPopulateAccessibilityEvent(event)) {
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.995 -0400", hash_original_method = "6C132B6F44CAB6ECEF4D7E674DFB11BC", hash_generated_method = "3B7716A8AC04F3F410A42E4BE55287B3")
    @Override
    public boolean onRequestSendAccessibilityEvent(View child, AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varFFC657A579ED797FAC38E2B4B1796721_966201912 = (super.onRequestSendAccessibilityEvent(child, event));
            {
                AccessibilityEvent record;
                record = AccessibilityEvent.obtain();
                onInitializeAccessibilityEvent(record);
                child.dispatchPopulateAccessibilityEvent(record);
                event.appendRecord(record);
            } //End block
        } //End collapsed parenthetic
        addTaint(child.getTaint());
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1959587687 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1959587687;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.996 -0400", hash_original_method = "A92D1861287ECAEDED59E2308FF3FC59", hash_generated_method = "9F53923DE423AA98E84AB64CC605C9C1")
    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onInitializeAccessibilityNodeInfo(info);
        info.setScrollable(isScrollableForAccessibility());
        View selectedView;
        selectedView = getSelectedView();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.996 -0400", hash_original_method = "73EE58FB2C3D5181C9EEF91D06B60047", hash_generated_method = "0EF17F61D4A0F404BC16FE5E884F5FCE")
    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onInitializeAccessibilityEvent(event);
        event.setScrollable(isScrollableForAccessibility());
        View selectedView;
        selectedView = getSelectedView();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.011 -0400", hash_original_method = "1A6615688A72EC8D9F005EEFA4CD86A3", hash_generated_method = "2EC0CFB049A9ABE99A1A6D7A59701978")
    private boolean isScrollableForAccessibility() {
        T adapter;
        adapter = getAdapter();
        {
            int itemCount;
            itemCount = adapter.getCount();
            boolean var0CADBBA3C9973A4C32A29A1A7D305AA3_1569246779 = (itemCount > 0
                && (getFirstVisiblePosition() > 0 || getLastVisiblePosition() < itemCount - 1));
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_594421554 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_594421554;
        // ---------- Original Method ----------
        //T adapter = getAdapter();
        //if (adapter != null) {
            //final int itemCount = adapter.getCount();
            //return itemCount > 0
                //&& (getFirstVisiblePosition() > 0 || getLastVisiblePosition() < itemCount - 1);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.012 -0400", hash_original_method = "F40AC428F4D570BD34339564A5B5BB04", hash_generated_method = "29D2E9F0B65E1A31F807A15BCABE3602")
    @Override
    protected boolean canAnimate() {
        boolean varDA480D2F8FF037BACA5DB54A8FBF9642_1082870914 = (super.canAnimate() && mItemCount > 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_312636046 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_312636046;
        // ---------- Original Method ----------
        //return super.canAnimate() && mItemCount > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.014 -0400", hash_original_method = "E1C2247A84AC5366AD699C7DB3F92349", hash_generated_method = "3793C88056766A8AEA525957AC559964")
     void handleDataChanged() {
        int count;
        count = mItemCount;
        boolean found;
        found = false;
        {
            int newPos;
            {
                mNeedSync = false;
                newPos = findSyncPosition();
                {
                    int selectablePos;
                    selectablePos = lookForSelectablePosition(newPos, true);
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
                int selectablePos;
                selectablePos = lookForSelectablePosition(newPos, true);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.014 -0400", hash_original_method = "25705A5902194616A467B0383F1D3CBC", hash_generated_method = "C4F0AB53E38DFFA650B0899EA0C97EF9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.028 -0400", hash_original_method = "40C5EABEA31AF953B54DF3485AA93D4F", hash_generated_method = "4727CAF3A42270E072FE9FF03A1F6887")
     int findSyncPosition() {
        int count;
        count = mItemCount;
        long idToMatch;
        idToMatch = mSyncRowId;
        int seed;
        seed = mSyncPosition;
        seed = Math.max(0, seed);
        seed = Math.min(count - 1, seed);
        long endTime;
        endTime = SystemClock.uptimeMillis() + SYNC_MAX_DURATION_MILLIS;
        long rowId;
        int first;
        first = seed;
        int last;
        last = seed;
        boolean next;
        next = false;
        boolean hitFirst;
        boolean hitLast;
        T adapter;
        adapter = getAdapter();
        {
            boolean var456DAD1228A2E995CDD3C7508B2D1BC6_1341013122 = (SystemClock.uptimeMillis() <= endTime);
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_462655947 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_462655947;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.029 -0400", hash_original_method = "63DA3BDCCF3458E05F2C2D5853C22A6D", hash_generated_method = "66568BEB23D0B50D6408C4B8CC1079D4")
     int lookForSelectablePosition(int position, boolean lookDown) {
        addTaint(position);
        addTaint(lookDown);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_40716886 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_40716886;
        // ---------- Original Method ----------
        //return position;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.029 -0400", hash_original_method = "DDA5E37B089AD4C213077E832500B341", hash_generated_method = "AC9CE4D7DE645D7E21690385786C7051")
     void setSelectedPositionInt(int position) {
        mSelectedPosition = position;
        mSelectedRowId = getItemIdAtPosition(position);
        // ---------- Original Method ----------
        //mSelectedPosition = position;
        //mSelectedRowId = getItemIdAtPosition(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.030 -0400", hash_original_method = "8F63B2D5F340C4F249BDEC055C5E8E67", hash_generated_method = "7C117729EAB4D3BE69EC2797A24AF1CB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.043 -0400", hash_original_method = "1A0C0740A6F6610404D57CE1BAD32EA0", hash_generated_method = "2A7BAC3DDA13AB86564848B688B2C416")
     void rememberSyncState() {
        {
            boolean varBF62E6C23FE36C17A3594E034FF46D2E_1597636168 = (getChildCount() > 0);
            {
                mNeedSync = true;
                mSyncHeight = mLayoutHeight;
                {
                    View v;
                    v = getChildAt(mSelectedPosition - mFirstPosition);
                    mSyncRowId = mNextSelectedRowId;
                    mSyncPosition = mNextSelectedPosition;
                    {
                        mSpecificTop = v.getTop();
                    } //End block
                    mSyncMode = SYNC_SELECTED_POSITION;
                } //End block
                {
                    View v;
                    v = getChildAt(0);
                    T adapter;
                    adapter = getAdapter();
                    {
                        boolean var4513742AC4398C98A59B8301E0BEEF78_135610009 = (mFirstPosition >= 0 && mFirstPosition < adapter.getCount());
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.043 -0400", hash_original_field = "5A24EF215C56029F60B6A6CBF69F7CB4", hash_generated_field = "7EF03B9C3ED3327C63848AE59101E3FF")

        public View targetView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.043 -0400", hash_original_field = "4757FE07FD492A8BE0EA6A760D683D6E", hash_generated_field = "B2F6CC92E86B46C8537E13B7CC7F6689")

        public int position;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.043 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "ED8148F95ABDB86AF6D25639B34D9053")

        public long id;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.044 -0400", hash_original_method = "4451CA35940742220E7BA55A02F436E7", hash_generated_method = "102314932B7CFACD3B161C44070D542F")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.044 -0400", hash_original_field = "9226893FC186C87D2EE76992FCE02058", hash_generated_field = "15D7943AB2107BDB644324BD26EFE009")

        private Parcelable mInstanceState = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.044 -0400", hash_original_method = "7D160EE0593E52FB18E5F3C663310860", hash_generated_method = "7D160EE0593E52FB18E5F3C663310860")
        public AdapterDataSetObserver ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.045 -0400", hash_original_method = "26DD6C25DA2F390817D1ECC15F4F8536", hash_generated_method = "A91C33EE5A5197C4006B2D35C0788385")
        @Override
        public void onChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mDataChanged = true;
            mOldItemCount = mItemCount;
            mItemCount = getAdapter().getCount();
            {
                boolean var863BC7806B599EEA548F40281B88AA1A_168586997 = (AdapterView.this.getAdapter().hasStableIds() && mInstanceState != null
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.053 -0400", hash_original_method = "384362603CD3BC78F8E9701AA98D7AA3", hash_generated_method = "06AD59A81B24DE88573A71EB532D0A16")
        @Override
        public void onInvalidated() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mDataChanged = true;
            {
                boolean var7489B38452FA33CED2860E46905E6201_544714183 = (AdapterView.this.getAdapter().hasStableIds());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.054 -0400", hash_original_method = "FEB1A2B1EE4CD2130FB08EC4E4CC489E", hash_generated_method = "45FAE979B6EF5255E98919F10948FE73")
        public void clearSavedState() {
            mInstanceState = null;
            // ---------- Original Method ----------
            //mInstanceState = null;
        }

        
    }


    
    private class SelectionNotifier implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.054 -0400", hash_original_method = "FB2FB370914C04BE018162856CF2098F", hash_generated_method = "FB2FB370914C04BE018162856CF2098F")
        public SelectionNotifier ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.064 -0400", hash_original_method = "D0BC3F1278F7B077D905A46BC661B1BD", hash_generated_method = "B0C219C2A6DAA12B8B758B4CB664B84D")
        public void run() {
            {
                {
                    boolean var6E1AA78244E28A1874D7E5FE58FB0DD3_239468632 = (getAdapter() != null);
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.065 -0400", hash_original_field = "59CB0C8407D37A458445E91F69D172AD", hash_generated_field = "AD689E79534925CB9E4BA4D493671F95")

    public static final int ITEM_VIEW_TYPE_IGNORE = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.065 -0400", hash_original_field = "BEE9C739D61F0989C7813DE23973BC9C", hash_generated_field = "2656BB1EECC5FAA0C353EF817B838CEE")

    public static final int ITEM_VIEW_TYPE_HEADER_OR_FOOTER = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.065 -0400", hash_original_field = "E5E70A339E147D3AA1E5D0962A19FBE1", hash_generated_field = "B34886BDDD3DDBA4D560A0577C4D51C0")

    static int SYNC_SELECTED_POSITION = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.065 -0400", hash_original_field = "D9B92ABAF8DF19B70EFF9092A49F578F", hash_generated_field = "2A6762032B10336CBD128BC316547BFF")

    static int SYNC_FIRST_POSITION = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.065 -0400", hash_original_field = "E1CDB006410C98DEF6DBC22BC17664DA", hash_generated_field = "058245A64C6BE848631F7CA3051A6FC1")

    static int SYNC_MAX_DURATION_MILLIS = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.065 -0400", hash_original_field = "78D008574FF4877A72651C9D9100850E", hash_generated_field = "74326D0EB2E635FB68B20B0C678CCDFD")

    public static final int INVALID_POSITION = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.065 -0400", hash_original_field = "3EDD10D278D00962919B3AE436975FFC", hash_generated_field = "716DCF1EC82526D22545C9F2FC7D9345")

    public static final long INVALID_ROW_ID = Long.MIN_VALUE;
}

