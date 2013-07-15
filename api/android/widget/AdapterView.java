package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.253 -0400", hash_original_field = "8E50E9FFA5F23A5C36A761E8937EC922", hash_generated_field = "4CE3CF821E7A7D08A592A5CA9EDE4305")

    @ViewDebug.ExportedProperty(category = "scrolling") int mFirstPosition = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.253 -0400", hash_original_field = "F193766DFB19C4A493EF1C6412FB606C", hash_generated_field = "1356C3FA4037F030D6AAE99FCBE84372")

    int mSpecificTop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.253 -0400", hash_original_field = "59BCD2861376D613E18A97D4BF8FA2DD", hash_generated_field = "7CC7B89C1FD47B35803D575B68BC5B76")

    int mSyncPosition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.254 -0400", hash_original_field = "9EFF8C7B72AD24AED030E64D92912EAB", hash_generated_field = "4F8608A52A53AF9807409C41B4527AFB")

    long mSyncRowId = INVALID_ROW_ID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.254 -0400", hash_original_field = "B3CB76660F13884C2DEBA3FD490E11A3", hash_generated_field = "F7AF8C2BAFE5F1DFE6D7A4BF607BDBCD")

    long mSyncHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.254 -0400", hash_original_field = "2EF8A52963F5274DFB069D7ECBB42932", hash_generated_field = "36E09949FE1A68F854979C9033FBC538")

    boolean mNeedSync = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.254 -0400", hash_original_field = "75F18F0A1ADD19F0084A18B514E65D47", hash_generated_field = "2B35CC092A6C6E8EEC9E34C6BB35EE65")

    int mSyncMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.255 -0400", hash_original_field = "520D9EA4242DB911A0F3C826F30FBBB3", hash_generated_field = "2D1B3EFC128ADAB2A0F451FD22243A4A")

    private int mLayoutHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.255 -0400", hash_original_field = "BC93A99EA774F75F2A69A75731F09DB1", hash_generated_field = "A271CAA49C9300336DF6C9AF1632606C")

    boolean mInLayout = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.255 -0400", hash_original_field = "773B78B8354D6C9F88CCABB4FB2C5772", hash_generated_field = "8F5666816AF47A9E3F5850773164443C")

    OnItemSelectedListener mOnItemSelectedListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.255 -0400", hash_original_field = "83E8FC6B1DFB1AB13582963A76A27676", hash_generated_field = "08FFFEF948BF0E48E5DC5A108DD5C034")

    OnItemClickListener mOnItemClickListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.255 -0400", hash_original_field = "D5EF51375FD5B5E8FB89E01EB8EAF448", hash_generated_field = "4BAB6029D01B2FF02C842E49999DC46D")

    OnItemLongClickListener mOnItemLongClickListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.256 -0400", hash_original_field = "B22EA86E5DDE95010F9B86C843A0A649", hash_generated_field = "83E549BBF91CC465CA61B08DEBC896EF")

    boolean mDataChanged;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.256 -0400", hash_original_field = "4FBA782449994D4250C7B450B888242D", hash_generated_field = "66B8EF13CF844CE1F3C5141C656F857A")

    @ViewDebug.ExportedProperty(category = "list") int mNextSelectedPosition = INVALID_POSITION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.256 -0400", hash_original_field = "CF6CBF3F15C3F9619C117B341B53B488", hash_generated_field = "906F39A3FAE64762B6F7A2D4072C0BAD")

    long mNextSelectedRowId = INVALID_ROW_ID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.256 -0400", hash_original_field = "C41320DE8711922E73E25AF73A13EE50", hash_generated_field = "E706686D8FE4DBC37237587CD10C50B2")

    @ViewDebug.ExportedProperty(category = "list") int mSelectedPosition = INVALID_POSITION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.256 -0400", hash_original_field = "EAECE08635AB3CD69250AF5D63D64F55", hash_generated_field = "98FDE0E0DABA26150FB8FA9058D8AFC6")

    long mSelectedRowId = INVALID_ROW_ID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.256 -0400", hash_original_field = "70C77B82E1F7307619839CA84E110E30", hash_generated_field = "23D73844C09FA19BF301A2A8334AD4E3")

    private View mEmptyView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.256 -0400", hash_original_field = "A7392E7FB156CE90DBA601C30BDAD9A0", hash_generated_field = "E38048D7118EEC0395C87E12259EFC13")

    @ViewDebug.ExportedProperty(category = "list") int mItemCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.256 -0400", hash_original_field = "E44C23C9220B221440C647F151534AE9", hash_generated_field = "11CEF45C71860367629AA01FA1F19186")

    int mOldItemCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.256 -0400", hash_original_field = "660CF5A43D07D5B2B75AAAE4E574C0D0", hash_generated_field = "45F58AF0B51928EE668B688AA98FB139")

    int mOldSelectedPosition = INVALID_POSITION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.256 -0400", hash_original_field = "D2FC674BFBC3B0165C93957BC182DE15", hash_generated_field = "CB32ED3EEEBFFF33346065AAF76C3C3F")

    long mOldSelectedRowId = INVALID_ROW_ID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.256 -0400", hash_original_field = "8007A60A4DF695EEE4B7A7DFDBF42113", hash_generated_field = "0083FDFAC63D8D5618A73B94F2CA2AA1")

    private boolean mDesiredFocusableState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.257 -0400", hash_original_field = "AC9A5948B7A0101ED51B6704B71D68C3", hash_generated_field = "131C0A29C612D5C490F82CC6B3FE313B")

    private boolean mDesiredFocusableInTouchModeState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.257 -0400", hash_original_field = "FE7E74512E6682C2B99C555B029D4EDE", hash_generated_field = "D942A048D23A80D010658FB1C8D03182")

    private SelectionNotifier mSelectionNotifier;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.257 -0400", hash_original_field = "FD54F4B9ADF9F654ECD215741AD80C16", hash_generated_field = "9EF8ED98BBEB87000E69C25673FFDD81")

    boolean mBlockLayoutRequests = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.257 -0400", hash_original_method = "57FCDFF67BC1DAFCD174DA15B87A1337", hash_generated_method = "89DE8E953EDF7F5507A398476298E1EB")
    public  AdapterView(Context context) {
        super(context);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.257 -0400", hash_original_method = "A1536CC4437039F5CF27987414A5A415", hash_generated_method = "80A576B430D29812426EB1FB0298A662")
    public  AdapterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.258 -0400", hash_original_method = "4DD39388BA45E8CBF534A54DFA59E3BD", hash_generated_method = "B03AA63B21C301AAB7F40BA9A1F82543")
    public  AdapterView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.258 -0400", hash_original_method = "3AA164DD2030E1BF06F3CA1CD9427DA1", hash_generated_method = "A196844E345185ADD2A42B24D8C435A9")
    public void setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickListener = listener;
        // ---------- Original Method ----------
        //mOnItemClickListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.258 -0400", hash_original_method = "53FBB33228561FD1F46130BA576FD131", hash_generated_method = "AB0824864F8910D0D9A704365E688A70")
    public final OnItemClickListener getOnItemClickListener() {
OnItemClickListener varD254B46FAB7FC8D09F3A710661ABA175_242105574 =         mOnItemClickListener;
        varD254B46FAB7FC8D09F3A710661ABA175_242105574.addTaint(taint);
        return varD254B46FAB7FC8D09F3A710661ABA175_242105574;
        // ---------- Original Method ----------
        //return mOnItemClickListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.259 -0400", hash_original_method = "60B3F62567C83CF5181D16CCAFD621F4", hash_generated_method = "FE856C8583E533EDFFD5ECF1DAE54119")
    public boolean performItemClick(View view, int position, long id) {
        addTaint(id);
        addTaint(position);
        addTaint(view.getTaint());
    if(mOnItemClickListener != null)        
        {
            playSoundEffect(SoundEffectConstants.CLICK);
    if(view != null)            
            {
                view.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_CLICKED);
            } //End block
            mOnItemClickListener.onItemClick(this, view, position, id);
            boolean varB326B5062B2F0E69046810717534CB09_1669954132 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1130784805 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1130784805;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_78789104 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1321480216 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1321480216;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.259 -0400", hash_original_method = "8890007B6750F9F3A0AF363421C33470", hash_generated_method = "F162F51BC532A614A55DA3903B6A9AC3")
    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
    if(!isLongClickable())        
        {
            setLongClickable(true);
        } //End block
        mOnItemLongClickListener = listener;
        // ---------- Original Method ----------
        //if (!isLongClickable()) {
            //setLongClickable(true);
        //}
        //mOnItemLongClickListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.259 -0400", hash_original_method = "450D7DEA9BB200CD772C171D001DF2F0", hash_generated_method = "E04594418B99E3604A7C83B6E9A7F464")
    public final OnItemLongClickListener getOnItemLongClickListener() {
OnItemLongClickListener var75586EA0D5BA47B01ECAB15621117474_1842369482 =         mOnItemLongClickListener;
        var75586EA0D5BA47B01ECAB15621117474_1842369482.addTaint(taint);
        return var75586EA0D5BA47B01ECAB15621117474_1842369482;
        // ---------- Original Method ----------
        //return mOnItemLongClickListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.260 -0400", hash_original_method = "9092AD2A5F83CE601E3913D803C386F2", hash_generated_method = "3770EE67FA344D6B0564B2ED3CB34217")
    public void setOnItemSelectedListener(OnItemSelectedListener listener) {
        mOnItemSelectedListener = listener;
        // ---------- Original Method ----------
        //mOnItemSelectedListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.260 -0400", hash_original_method = "C1B2E8F5BC8E80BA634AE326A645C328", hash_generated_method = "4D0EE83116B2A2F994C643C4C0FCE944")
    public final OnItemSelectedListener getOnItemSelectedListener() {
OnItemSelectedListener varBA18540411FAC3CE0DDA59569C04B324_233297817 =         mOnItemSelectedListener;
        varBA18540411FAC3CE0DDA59569C04B324_233297817.addTaint(taint);
        return varBA18540411FAC3CE0DDA59569C04B324_233297817;
        // ---------- Original Method ----------
        //return mOnItemSelectedListener;
    }

    
    public abstract T getAdapter();

    
    public abstract void setAdapter(T adapter);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.260 -0400", hash_original_method = "F16CCCAA9B27A0794F506D96FD601909", hash_generated_method = "9B1C5F145087D7C86605E283B71F1270")
    @Override
    public void addView(View child) {
        addTaint(child.getTaint());
        UnsupportedOperationException var2533360ED6399AAB03E56C81EC39F3B7_1082543851 = new UnsupportedOperationException("addView(View) is not supported in AdapterView");
        var2533360ED6399AAB03E56C81EC39F3B7_1082543851.addTaint(taint);
        throw var2533360ED6399AAB03E56C81EC39F3B7_1082543851;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.261 -0400", hash_original_method = "A0B74413A848464618EA89DE3FE41FDC", hash_generated_method = "78F5A1B01263775AA3F1F55F20C34F69")
    @Override
    public void addView(View child, int index) {
        addTaint(index);
        addTaint(child.getTaint());
        UnsupportedOperationException varBE31CDC155E4492A38E52134364C6E28_731812800 = new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
        varBE31CDC155E4492A38E52134364C6E28_731812800.addTaint(taint);
        throw varBE31CDC155E4492A38E52134364C6E28_731812800;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.261 -0400", hash_original_method = "18B2907968F7312EE2BBDDA25EF143B2", hash_generated_method = "E64152BA2B79036CB6B9E836BFE5A6D0")
    @Override
    public void addView(View child, LayoutParams params) {
        addTaint(params.getTaint());
        addTaint(child.getTaint());
        UnsupportedOperationException var024154228C5F59E2C80746FBCCE6AE5E_1043347439 = new UnsupportedOperationException("addView(View, LayoutParams) "
                + "is not supported in AdapterView");
        var024154228C5F59E2C80746FBCCE6AE5E_1043347439.addTaint(taint);
        throw var024154228C5F59E2C80746FBCCE6AE5E_1043347439;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("addView(View, LayoutParams) "
                //+ "is not supported in AdapterView");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.261 -0400", hash_original_method = "ECB319B81CB6A3F46E583210A29BAF16", hash_generated_method = "A3AEA730A27B6580EE07B2B1118E8A33")
    @Override
    public void addView(View child, int index, LayoutParams params) {
        addTaint(params.getTaint());
        addTaint(index);
        addTaint(child.getTaint());
        UnsupportedOperationException varC67D9BF964DEDF985B4385AA5FD6B534_1894978988 = new UnsupportedOperationException("addView(View, int, LayoutParams) "
                + "is not supported in AdapterView");
        varC67D9BF964DEDF985B4385AA5FD6B534_1894978988.addTaint(taint);
        throw varC67D9BF964DEDF985B4385AA5FD6B534_1894978988;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("addView(View, int, LayoutParams) "
                //+ "is not supported in AdapterView");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.261 -0400", hash_original_method = "886BA97B45AC28A61B534339E77983B5", hash_generated_method = "3F1AF4455B59E93B17562C851B6FD5C4")
    @Override
    public void removeView(View child) {
        addTaint(child.getTaint());
        UnsupportedOperationException varEDFDED9444056490E8F70544D5B613E9_1660464092 = new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
        varEDFDED9444056490E8F70544D5B613E9_1660464092.addTaint(taint);
        throw varEDFDED9444056490E8F70544D5B613E9_1660464092;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.262 -0400", hash_original_method = "EB15614617786EFEBA3A034D912AA71E", hash_generated_method = "8F0F7A5399B73984267CC9038481C8CB")
    @Override
    public void removeViewAt(int index) {
        addTaint(index);
        UnsupportedOperationException var74B1321D3D912A2B0A4A5BCB066B72F2_85667041 = new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
        var74B1321D3D912A2B0A4A5BCB066B72F2_85667041.addTaint(taint);
        throw var74B1321D3D912A2B0A4A5BCB066B72F2_85667041;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.262 -0400", hash_original_method = "F33294BE6C28FDF867EC6161A7E416F0", hash_generated_method = "5535E81FCA4CF8CC1A6922F500D29445")
    @Override
    public void removeAllViews() {
        UnsupportedOperationException var0ED36242034B855C121509AD81242BC9_1713218696 = new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
        var0ED36242034B855C121509AD81242BC9_1713218696.addTaint(taint);
        throw var0ED36242034B855C121509AD81242BC9_1713218696;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.262 -0400", hash_original_method = "5EA85597DECD951B7F4C51D999F17C5D", hash_generated_method = "60FCAE715C2837FB3066391DF5F3B05E")
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        addTaint(changed);
        mLayoutHeight = getHeight();
        // ---------- Original Method ----------
        //mLayoutHeight = getHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.263 -0400", hash_original_method = "40CA9E4E71293F3BC1D33E874AD305A1", hash_generated_method = "AD36FDC2F7DF761E56D906F891A5AF75")
    @ViewDebug.CapturedViewProperty
    public int getSelectedItemPosition() {
        int var57E0DB23DC7E939A6164752A87579292_1046639513 = (mNextSelectedPosition);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_430665538 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_430665538;
        // ---------- Original Method ----------
        //return mNextSelectedPosition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.263 -0400", hash_original_method = "52C80BDBAB2E8D6D945028E83F843260", hash_generated_method = "893E009FD2E98408D30ADC25D1170ECF")
    @ViewDebug.CapturedViewProperty
    public long getSelectedItemId() {
        long varA832193E43FA150B2D56A5E9387A7CE0_1439371880 = (mNextSelectedRowId);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1498586205 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1498586205;
        // ---------- Original Method ----------
        //return mNextSelectedRowId;
    }

    
    public abstract View getSelectedView();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.263 -0400", hash_original_method = "F45E40D646583F63F7A00B28C1D0B4AE", hash_generated_method = "E52FAEEC40F81267E4CCB77E3656D545")
    public Object getSelectedItem() {
        T adapter = getAdapter();
        int selection = getSelectedItemPosition();
    if(adapter != null && adapter.getCount() > 0 && selection >= 0)        
        {
Object var116C7BBD0089C854E4ADE90D9ECB20FE_1872789229 =             adapter.getItem(selection);
            var116C7BBD0089C854E4ADE90D9ECB20FE_1872789229.addTaint(taint);
            return var116C7BBD0089C854E4ADE90D9ECB20FE_1872789229;
        } //End block
        else
        {
Object var540C13E9E156B687226421B24F2DF178_114156516 =             null;
            var540C13E9E156B687226421B24F2DF178_114156516.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_114156516;
        } //End block
        // ---------- Original Method ----------
        //T adapter = getAdapter();
        //int selection = getSelectedItemPosition();
        //if (adapter != null && adapter.getCount() > 0 && selection >= 0) {
            //return adapter.getItem(selection);
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.264 -0400", hash_original_method = "C515244CDC30F9529A71B0CAA70231C3", hash_generated_method = "E0E693373C541E7E9173EC0541365B6C")
    @ViewDebug.CapturedViewProperty
    public int getCount() {
        int varA7392E7FB156CE90DBA601C30BDAD9A0_1096356633 = (mItemCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_458221213 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_458221213;
        // ---------- Original Method ----------
        //return mItemCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.264 -0400", hash_original_method = "7F8A3609232C6E4C7447DF803294CB0C", hash_generated_method = "712BAB8158E7DE15A7DAF0EA88832A6D")
    public int getPositionForView(View view) {
        addTaint(view.getTaint());
        View listItem = view;
        try 
        {
            View v;
            while
(!(v = (View) listItem.getParent()).equals(this))            
            {
                listItem = v;
            } //End block
        } //End block
        catch (ClassCastException e)
        {
            int var296D6C732A05FBA51C5854FA7933FE23_926718419 = (INVALID_POSITION);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_446085414 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_446085414;
        } //End block
        final int childCount = getChildCount();
for(int i = 0;i < childCount;i++)
        {
    if(getChildAt(i).equals(listItem))            
            {
                int varB4D2F09D0AD5244C9E57B5AF8AB759AE_1539221357 = (mFirstPosition + i);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_826373572 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_826373572;
            } //End block
        } //End block
        int var296D6C732A05FBA51C5854FA7933FE23_903860741 = (INVALID_POSITION);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1681780953 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1681780953;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.265 -0400", hash_original_method = "3F582E36FEB434C42F8F2A7A83CA506D", hash_generated_method = "C19652C5D923EE165324FB9E1DFFC568")
    public int getFirstVisiblePosition() {
        int varD3995CD54227E7252588C2EFBE75FDC4_1739252461 = (mFirstPosition);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1420868604 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1420868604;
        // ---------- Original Method ----------
        //return mFirstPosition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.265 -0400", hash_original_method = "E5B0A16A7A6C9870BA6F980F2DB39BC0", hash_generated_method = "76E025109436AD86CCC11B7177769C71")
    public int getLastVisiblePosition() {
        int var88D2F1C12237EBDC1144B58EE07D2651_847263910 = (mFirstPosition + getChildCount() - 1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1486531739 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1486531739;
        // ---------- Original Method ----------
        //return mFirstPosition + getChildCount() - 1;
    }

    
    public abstract void setSelection(int position);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.265 -0400", hash_original_method = "0D2B56D1373B44CFA7E95FC0E87B79DB", hash_generated_method = "8E748D2326E52097E9FAD33718F590E4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.266 -0400", hash_original_method = "1914B98508B1C21B71F42F5D07F0BF47", hash_generated_method = "DDBCCAC251E4D6FE6ED4CA1CD2408B7F")
    public View getEmptyView() {
View varAE7C11E50171EC79263635AB3464BCAA_209234301 =         mEmptyView;
        varAE7C11E50171EC79263635AB3464BCAA_209234301.addTaint(taint);
        return varAE7C11E50171EC79263635AB3464BCAA_209234301;
        // ---------- Original Method ----------
        //return mEmptyView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.266 -0400", hash_original_method = "FD285526E2677013E6DDAFB01C953F85", hash_generated_method = "F4CB8C7835C7DBF611F0CD650F6370EE")
     boolean isInFilterMode() {
        boolean var68934A3E9455FA72420237EB05902327_1889004359 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_837635925 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_837635925;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.267 -0400", hash_original_method = "2405FD914E83FFA9F0D8BC78F36E017E", hash_generated_method = "DB8931A6889B0879F648D1FC588151DC")
    @Override
    public void setFocusable(boolean focusable) {
        final T adapter = getAdapter();
        final boolean empty = adapter == null || adapter.getCount() == 0;
        mDesiredFocusableState = focusable;
    if(!focusable)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.268 -0400", hash_original_method = "510CB97D998AEB67CD24BEC214B467D4", hash_generated_method = "B8739B507E9341E15884A14D945586C4")
    @Override
    public void setFocusableInTouchMode(boolean focusable) {
        final T adapter = getAdapter();
        final boolean empty = adapter == null || adapter.getCount() == 0;
        mDesiredFocusableInTouchModeState = focusable;
    if(focusable)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.268 -0400", hash_original_method = "247C1C860FE83D8C6969E8D7AD161A84", hash_generated_method = "58D08DB55015F9BCB625AB2354FCDF52")
     void checkFocus() {
        final T adapter = getAdapter();
        final boolean empty = adapter == null || adapter.getCount() == 0;
        final boolean focusable = !empty || isInFilterMode();
        super.setFocusableInTouchMode(focusable && mDesiredFocusableInTouchModeState);
        super.setFocusable(focusable && mDesiredFocusableState);
    if(mEmptyView != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.269 -0400", hash_original_method = "3E542C38250D34B64375C7B9ACE53374", hash_generated_method = "502081D276FF2F79E79E07F25B55700E")
    private void updateEmptyStatus(boolean empty) {
        addTaint(empty);
    if(isInFilterMode())        
        {
            empty = false;
        } //End block
    if(empty)        
        {
    if(mEmptyView != null)            
            {
                mEmptyView.setVisibility(View.VISIBLE);
                setVisibility(View.GONE);
            } //End block
            else
            {
                setVisibility(View.VISIBLE);
            } //End block
    if(mDataChanged)            
            {
                this.onLayout(false, mLeft, mTop, mRight, mBottom);
            } //End block
        } //End block
        else
        {
    if(mEmptyView != null)            
            mEmptyView.setVisibility(View.GONE);
            setVisibility(View.VISIBLE);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.269 -0400", hash_original_method = "D3C6D351E34AE1C5D83960F098A550AE", hash_generated_method = "D10A06629D341344463F5F87788BFF9C")
    public Object getItemAtPosition(int position) {
        addTaint(position);
        T adapter = getAdapter();
Object var17A047747B6E56B7BE9D3B130AAAD3CE_779402286 =         (adapter == null || position < 0) ? null : adapter.getItem(position);
        var17A047747B6E56B7BE9D3B130AAAD3CE_779402286.addTaint(taint);
        return var17A047747B6E56B7BE9D3B130AAAD3CE_779402286;
        // ---------- Original Method ----------
        //T adapter = getAdapter();
        //return (adapter == null || position < 0) ? null : adapter.getItem(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.270 -0400", hash_original_method = "1B8B19ED8D728A74BB7DD4694FA31397", hash_generated_method = "6863E10B11199F8CED6BA2B7ECADF7CF")
    public long getItemIdAtPosition(int position) {
        addTaint(position);
        T adapter = getAdapter();
        long var60B121627742874C7E72AD0B63E2220C_2028019593 = ((adapter == null || position < 0) ? INVALID_ROW_ID : adapter.getItemId(position));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_561616172 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_561616172;
        // ---------- Original Method ----------
        //T adapter = getAdapter();
        //return (adapter == null || position < 0) ? INVALID_ROW_ID : adapter.getItemId(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.270 -0400", hash_original_method = "1A557FA8FE05A519D86B900EB24DF4D7", hash_generated_method = "EAAFF91B297E7BFCCB65EF32464A7C9F")
    @Override
    public void setOnClickListener(OnClickListener l) {
        addTaint(l.getTaint());
        RuntimeException var0F3C9DA23186B000AD75794284F86383_2086542794 = new RuntimeException("Don't call setOnClickListener for an AdapterView. "
                + "You probably want setOnItemClickListener instead");
        var0F3C9DA23186B000AD75794284F86383_2086542794.addTaint(taint);
        throw var0F3C9DA23186B000AD75794284F86383_2086542794;
        // ---------- Original Method ----------
        //throw new RuntimeException("Don't call setOnClickListener for an AdapterView. "
                //+ "You probably want setOnItemClickListener instead");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.270 -0400", hash_original_method = "0F3E63187E008FDE1692E75AF7E8484F", hash_generated_method = "DCFE5437586B2B72B2033C20A5FC2846")
    @Override
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        addTaint(container.getTaint());
        dispatchFreezeSelfOnly(container);
        // ---------- Original Method ----------
        //dispatchFreezeSelfOnly(container);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.271 -0400", hash_original_method = "3B9D7DC916535DA1F64238687579C1A4", hash_generated_method = "049C55C9929D94261AAC15AFD146322A")
    @Override
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        addTaint(container.getTaint());
        dispatchThawSelfOnly(container);
        // ---------- Original Method ----------
        //dispatchThawSelfOnly(container);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.271 -0400", hash_original_method = "8130EF0B42BA515F653DEDC83DE0BC01", hash_generated_method = "8B173CA825B846127BB6829734ADDC00")
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDetachedFromWindow();
        removeCallbacks(mSelectionNotifier);
        // ---------- Original Method ----------
        //super.onDetachedFromWindow();
        //removeCallbacks(mSelectionNotifier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.271 -0400", hash_original_method = "BC6042705725732210E15D64CD41C7D9", hash_generated_method = "808E331730657039B00195A9822E4CAE")
     void selectionChanged() {
    if(mOnItemSelectedListener != null)        
        {
    if(mInLayout || mBlockLayoutRequests)            
            {
    if(mSelectionNotifier == null)                
                {
                    mSelectionNotifier = new SelectionNotifier();
                } //End block
                post(mSelectionNotifier);
            } //End block
            else
            {
                fireOnSelected();
            } //End block
        } //End block
    if(mSelectedPosition != ListView.INVALID_POSITION && isShown() && !isInTouchMode())        
        {
            sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SELECTED);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.272 -0400", hash_original_method = "02337B5D029912B3F89D3F5D70F11AFE", hash_generated_method = "6327696DC11503774657EB30F752E79C")
    private void fireOnSelected() {
    if(mOnItemSelectedListener == null)        
        return;
        int selection = this.getSelectedItemPosition();
    if(selection >= 0)        
        {
            View v = getSelectedView();
            mOnItemSelectedListener.onItemSelected(this, v, selection,
                    getAdapter().getItemId(selection));
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.272 -0400", hash_original_method = "2ECE900C628E5D932F56A2139561AD87", hash_generated_method = "D9E1DFAE331E5FDAC4C90CE1098CA5E8")
    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        addTaint(event.getTaint());
        View selectedView = getSelectedView();
    if(selectedView != null && selectedView.getVisibility() == VISIBLE
                && selectedView.dispatchPopulateAccessibilityEvent(event))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1090679091 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1147605697 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1147605697;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_124615414 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_973895756 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_973895756;
        // ---------- Original Method ----------
        //View selectedView = getSelectedView();
        //if (selectedView != null && selectedView.getVisibility() == VISIBLE
                //&& selectedView.dispatchPopulateAccessibilityEvent(event)) {
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.273 -0400", hash_original_method = "6C132B6F44CAB6ECEF4D7E674DFB11BC", hash_generated_method = "00C907C5656D4A98451824C1A9330FBB")
    @Override
    public boolean onRequestSendAccessibilityEvent(View child, AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(child.getTaint());
    if(super.onRequestSendAccessibilityEvent(child, event))        
        {
            AccessibilityEvent record = AccessibilityEvent.obtain();
            onInitializeAccessibilityEvent(record);
            child.dispatchPopulateAccessibilityEvent(record);
            event.appendRecord(record);
            boolean varB326B5062B2F0E69046810717534CB09_77536370 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1482247532 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1482247532;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_519638842 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1812991819 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1812991819;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.273 -0400", hash_original_method = "A92D1861287ECAEDED59E2308FF3FC59", hash_generated_method = "405EBC4358C70D7CACFABF931DC56575")
    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(info.getTaint());
        super.onInitializeAccessibilityNodeInfo(info);
        info.setScrollable(isScrollableForAccessibility());
        View selectedView = getSelectedView();
    if(selectedView != null)        
        {
            info.setEnabled(selectedView.isEnabled());
        } //End block
        // ---------- Original Method ----------
        //super.onInitializeAccessibilityNodeInfo(info);
        //info.setScrollable(isScrollableForAccessibility());
        //View selectedView = getSelectedView();
        //if (selectedView != null) {
            //info.setEnabled(selectedView.isEnabled());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.274 -0400", hash_original_method = "73EE58FB2C3D5181C9EEF91D06B60047", hash_generated_method = "1CCD0C261E83C31D68C648A184994AFA")
    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        super.onInitializeAccessibilityEvent(event);
        event.setScrollable(isScrollableForAccessibility());
        View selectedView = getSelectedView();
    if(selectedView != null)        
        {
            event.setEnabled(selectedView.isEnabled());
        } //End block
        event.setCurrentItemIndex(getSelectedItemPosition());
        event.setFromIndex(getFirstVisiblePosition());
        event.setToIndex(getLastVisiblePosition());
        event.setItemCount(getCount());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.275 -0400", hash_original_method = "1A6615688A72EC8D9F005EEFA4CD86A3", hash_generated_method = "55ED00AD8F91311A938ACD8FA7CEE087")
    private boolean isScrollableForAccessibility() {
        T adapter = getAdapter();
    if(adapter != null)        
        {
            final int itemCount = adapter.getCount();
            boolean varE94042D7EFD42FFAED9E843CFFA674FB_1660887517 = (itemCount > 0
                && (getFirstVisiblePosition() > 0 || getLastVisiblePosition() < itemCount - 1));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_677827693 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_677827693;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_737898509 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2128696974 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2128696974;
        // ---------- Original Method ----------
        //T adapter = getAdapter();
        //if (adapter != null) {
            //final int itemCount = adapter.getCount();
            //return itemCount > 0
                //&& (getFirstVisiblePosition() > 0 || getLastVisiblePosition() < itemCount - 1);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.275 -0400", hash_original_method = "F40AC428F4D570BD34339564A5B5BB04", hash_generated_method = "72B395E49D584FB5D6DFD696D16F625C")
    @Override
    protected boolean canAnimate() {
        boolean varF7CAFEF190EA84220A90E3FE54FABF95_862652973 = (super.canAnimate() && mItemCount > 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_224444336 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_224444336;
        // ---------- Original Method ----------
        //return super.canAnimate() && mItemCount > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.290 -0400", hash_original_method = "E1C2247A84AC5366AD699C7DB3F92349", hash_generated_method = "F38E344BFCC1E039A8E598C9A9296E43")
     void handleDataChanged() {
        final int count = mItemCount;
        boolean found = false;
    if(count > 0)        
        {
            int newPos;
    if(mNeedSync)            
            {
                mNeedSync = false;
                newPos = findSyncPosition();
    if(newPos >= 0)                
                {
                    int selectablePos = lookForSelectablePosition(newPos, true);
    if(selectablePos == newPos)                    
                    {
                        setNextSelectedPositionInt(newPos);
                        found = true;
                    } //End block
                } //End block
            } //End block
    if(!found)            
            {
                newPos = getSelectedItemPosition();
    if(newPos >= count)                
                {
                    newPos = count - 1;
                } //End block
    if(newPos < 0)                
                {
                    newPos = 0;
                } //End block
                int selectablePos = lookForSelectablePosition(newPos, true);
    if(selectablePos < 0)                
                {
                    selectablePos = lookForSelectablePosition(newPos, false);
                } //End block
    if(selectablePos >= 0)                
                {
                    setNextSelectedPositionInt(selectablePos);
                    checkSelectionChanged();
                    found = true;
                } //End block
            } //End block
        } //End block
    if(!found)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.290 -0400", hash_original_method = "25705A5902194616A467B0383F1D3CBC", hash_generated_method = "2817C77069C4BD4E9D35D7BAC332C040")
     void checkSelectionChanged() {
    if((mSelectedPosition != mOldSelectedPosition) || (mSelectedRowId != mOldSelectedRowId))        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.291 -0400", hash_original_method = "40C5EABEA31AF953B54DF3485AA93D4F", hash_generated_method = "AD7AC5F413CCBBBC8178C303A30CAD30")
     int findSyncPosition() {
        int count = mItemCount;
    if(count == 0)        
        {
            int var296D6C732A05FBA51C5854FA7933FE23_1015261893 = (INVALID_POSITION);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1545707856 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1545707856;
        } //End block
        long idToMatch = mSyncRowId;
        int seed = mSyncPosition;
    if(idToMatch == INVALID_ROW_ID)        
        {
            int var296D6C732A05FBA51C5854FA7933FE23_1695436227 = (INVALID_POSITION);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1720139123 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1720139123;
        } //End block
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
    if(adapter == null)        
        {
            int var296D6C732A05FBA51C5854FA7933FE23_125680452 = (INVALID_POSITION);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_301144378 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_301144378;
        } //End block
        while
(SystemClock.uptimeMillis() <= endTime)        
        {
            rowId = adapter.getItemId(seed);
    if(rowId == idToMatch)            
            {
                int varFE4C0F30AA359C41D9F9A5F69C8C4192_979518496 = (seed);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_283469820 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_283469820;
            } //End block
            hitLast = last == count - 1;
            hitFirst = first == 0;
    if(hitLast && hitFirst)            
            {
                break;
            } //End block
    if(hitFirst || (next && !hitLast))            
            {
                last++;
                seed = last;
                next = false;
            } //End block
            else
    if(hitLast || (!next && !hitFirst))            
            {
                first--;
                seed = first;
                next = true;
            } //End block
        } //End block
        int var296D6C732A05FBA51C5854FA7933FE23_281711836 = (INVALID_POSITION);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1604318866 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1604318866;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.292 -0400", hash_original_method = "63DA3BDCCF3458E05F2C2D5853C22A6D", hash_generated_method = "72253937140CEB957F4EBCF3F13F1622")
     int lookForSelectablePosition(int position, boolean lookDown) {
        addTaint(lookDown);
        addTaint(position);
        int var4757FE07FD492A8BE0EA6A760D683D6E_606801472 = (position);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_189172225 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_189172225;
        // ---------- Original Method ----------
        //return position;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.292 -0400", hash_original_method = "DDA5E37B089AD4C213077E832500B341", hash_generated_method = "AC9CE4D7DE645D7E21690385786C7051")
     void setSelectedPositionInt(int position) {
        mSelectedPosition = position;
        mSelectedRowId = getItemIdAtPosition(position);
        // ---------- Original Method ----------
        //mSelectedPosition = position;
        //mSelectedRowId = getItemIdAtPosition(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.292 -0400", hash_original_method = "8F63B2D5F340C4F249BDEC055C5E8E67", hash_generated_method = "7F126109D347D0583DE2119B8460CD40")
     void setNextSelectedPositionInt(int position) {
        mNextSelectedPosition = position;
        mNextSelectedRowId = getItemIdAtPosition(position);
    if(mNeedSync && mSyncMode == SYNC_SELECTED_POSITION && position >= 0)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.293 -0400", hash_original_method = "1A0C0740A6F6610404D57CE1BAD32EA0", hash_generated_method = "D27E72BFCE3FC92A54FC585A49E31484")
     void rememberSyncState() {
    if(getChildCount() > 0)        
        {
            mNeedSync = true;
            mSyncHeight = mLayoutHeight;
    if(mSelectedPosition >= 0)            
            {
                View v = getChildAt(mSelectedPosition - mFirstPosition);
                mSyncRowId = mNextSelectedRowId;
                mSyncPosition = mNextSelectedPosition;
    if(v != null)                
                {
                    mSpecificTop = v.getTop();
                } //End block
                mSyncMode = SYNC_SELECTED_POSITION;
            } //End block
            else
            {
                View v = getChildAt(0);
                T adapter = getAdapter();
    if(mFirstPosition >= 0 && mFirstPosition < adapter.getCount())                
                {
                    mSyncRowId = adapter.getItemId(mFirstPosition);
                } //End block
                else
                {
                    mSyncRowId = NO_ID;
                } //End block
                mSyncPosition = mFirstPosition;
    if(v != null)                
                {
                    mSpecificTop = v.getTop();
                } //End block
                mSyncMode = SYNC_FIRST_POSITION;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static class AdapterContextMenuInfo implements ContextMenu.ContextMenuInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.294 -0400", hash_original_field = "5A24EF215C56029F60B6A6CBF69F7CB4", hash_generated_field = "7EF03B9C3ED3327C63848AE59101E3FF")

        public View targetView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.294 -0400", hash_original_field = "4757FE07FD492A8BE0EA6A760D683D6E", hash_generated_field = "B2F6CC92E86B46C8537E13B7CC7F6689")

        public int position;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.294 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "ED8148F95ABDB86AF6D25639B34D9053")

        public long id;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.294 -0400", hash_original_method = "4451CA35940742220E7BA55A02F436E7", hash_generated_method = "102314932B7CFACD3B161C44070D542F")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.294 -0400", hash_original_field = "9226893FC186C87D2EE76992FCE02058", hash_generated_field = "15D7943AB2107BDB644324BD26EFE009")

        private Parcelable mInstanceState = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.294 -0400", hash_original_method = "7D160EE0593E52FB18E5F3C663310860", hash_generated_method = "7D160EE0593E52FB18E5F3C663310860")
        public AdapterDataSetObserver ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.294 -0400", hash_original_method = "26DD6C25DA2F390817D1ECC15F4F8536", hash_generated_method = "783C63005299CAAC4AAF9DB1F4ECF3F3")
        @Override
        public void onChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mDataChanged = true;
            mOldItemCount = mItemCount;
            mItemCount = getAdapter().getCount();
    if(AdapterView.this.getAdapter().hasStableIds() && mInstanceState != null
                    && mOldItemCount == 0 && mItemCount > 0)            
            {
                AdapterView.this.onRestoreInstanceState(mInstanceState);
                mInstanceState = null;
            } //End block
            else
            {
                rememberSyncState();
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.295 -0400", hash_original_method = "384362603CD3BC78F8E9701AA98D7AA3", hash_generated_method = "DBFCFDA7B82A6CFE9D4E24F05C7CECEA")
        @Override
        public void onInvalidated() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mDataChanged = true;
    if(AdapterView.this.getAdapter().hasStableIds())            
            {
                mInstanceState = AdapterView.this.onSaveInstanceState();
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.295 -0400", hash_original_method = "FEB1A2B1EE4CD2130FB08EC4E4CC489E", hash_generated_method = "45FAE979B6EF5255E98919F10948FE73")
        public void clearSavedState() {
            mInstanceState = null;
            // ---------- Original Method ----------
            //mInstanceState = null;
        }

        
    }


    
    private class SelectionNotifier implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.295 -0400", hash_original_method = "FB2FB370914C04BE018162856CF2098F", hash_generated_method = "FB2FB370914C04BE018162856CF2098F")
        public SelectionNotifier ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.295 -0400", hash_original_method = "D0BC3F1278F7B077D905A46BC661B1BD", hash_generated_method = "F3546F6646A836939F21E468396FE05A")
        public void run() {
    if(mDataChanged)            
            {
    if(getAdapter() != null)                
                {
                    post(this);
                } //End block
            } //End block
            else
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.295 -0400", hash_original_field = "59CB0C8407D37A458445E91F69D172AD", hash_generated_field = "AD689E79534925CB9E4BA4D493671F95")

    public static final int ITEM_VIEW_TYPE_IGNORE = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.295 -0400", hash_original_field = "BEE9C739D61F0989C7813DE23973BC9C", hash_generated_field = "2656BB1EECC5FAA0C353EF817B838CEE")

    public static final int ITEM_VIEW_TYPE_HEADER_OR_FOOTER = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.295 -0400", hash_original_field = "E5E70A339E147D3AA1E5D0962A19FBE1", hash_generated_field = "2ACDB95EC8FD03E59D37276160271BE6")

    static final int SYNC_SELECTED_POSITION = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.295 -0400", hash_original_field = "D9B92ABAF8DF19B70EFF9092A49F578F", hash_generated_field = "067E495BB5F5DE55AD427633175B121C")

    static final int SYNC_FIRST_POSITION = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.295 -0400", hash_original_field = "E1CDB006410C98DEF6DBC22BC17664DA", hash_generated_field = "E651483062BE384270CDB5009C3349DB")

    static final int SYNC_MAX_DURATION_MILLIS = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.295 -0400", hash_original_field = "78D008574FF4877A72651C9D9100850E", hash_generated_field = "74326D0EB2E635FB68B20B0C678CCDFD")

    public static final int INVALID_POSITION = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.295 -0400", hash_original_field = "3EDD10D278D00962919B3AE436975FFC", hash_generated_field = "716DCF1EC82526D22545C9F2FC7D9345")

    public static final long INVALID_ROW_ID = Long.MIN_VALUE;
}

