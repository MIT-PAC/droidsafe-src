package android.app;

// Droidsafe Imports
import java.util.LinkedList;

import droidsafe.annotations.*;
import droidsafe.helpers.*;

import droidsafe.runtime.*;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceActivity.Header;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ListActivity extends Activity {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.752 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "53F2F2B4BC3DCBFE8E814654BBA9129E")

    protected ListAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.752 -0400", hash_original_field = "F796A16BE866311501B24C73148D80F1", hash_generated_field = "1F541A4D7C9525AEC7D463BC69050466")

    protected ListView mList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.754 -0400", hash_original_field = "6781893E9FA50A9B7103FD3F674E566B", hash_generated_field = "2E60E17486AAEB1A4E1F1878A0354061")

    private Handler mHandler = new Handler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.755 -0400", hash_original_field = "FF0486143720AAA2762E6DFB7A1926B6", hash_generated_field = "37FB9735B131E97EBBBF7EF31E956D4C")

    private boolean mFinishedStart = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.757 -0400", hash_original_field = "F487762B42FCD79D908F11802425F9AE", hash_generated_field = "B11DF01C886CC15D12A595382174A0C1")

    private Runnable mRequestFocus = new Runnable() {        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.756 -0400", hash_original_method = "4F290F2508C3F0B44E09591C5B0749BC", hash_generated_method = "203642A5324F5F18B21A0D020E65FD5C")
        public void run() {
            mList.focusableViewAvailable(mList);
            // ---------- Original Method ----------
            //mList.focusableViewAvailable(mList);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.760 -0400", hash_original_field = "9B3F30A71979D6623D111E114AFFBE5E", hash_generated_field = "F601E5C2332EFF7D085096154B4D128B")

    private AdapterView.OnItemClickListener mOnClickListener = new AdapterView.OnItemClickListener() {        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.760 -0400", hash_original_method = "FBAC6E1DF4BED6C0A21E33622DB577EE", hash_generated_method = "833C533291E93907AE627CFADCA9E3A3")
        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(id);
            addTaint(position);
            addTaint(v.getTaint());
            addTaint(parent.getTaint());
            onListItemClick((ListView)parent, v, position, id);
            // ---------- Original Method ----------
            //onListItemClick((ListView)parent, v, position, id);
        }

        
};
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.761 -0400", hash_original_method = "E9A1B22E98BB93A49E0DD0DF78D68B8E", hash_generated_method = "E9A1B22E98BB93A49E0DD0DF78D68B8E")
    public ListActivity ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.764 -0400", hash_original_method = "BF490B4BB4BD29ACC689E0297B614061", hash_generated_method = "D4F933E3714595AC8E3D7A38148816F9")
    protected void onListItemClick(ListView l, View v, int position, long id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(id);
        addTaint(position);
        addTaint(v.getTaint());
        addTaint(l.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.765 -0400", hash_original_method = "39D3E8C83EC5D9AA90999E3A2D1BCB07", hash_generated_method = "066644180D6D98293ABB7CCE0CF4437A")
    @Override
    protected void onRestoreInstanceState(Bundle state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(state.getTaint());
        ensureList();
        super.onRestoreInstanceState(state);
        // ---------- Original Method ----------
        //ensureList();
        //super.onRestoreInstanceState(state);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.767 -0400", hash_original_method = "4F23093C6BEB1F491BB932E73A46BC35", hash_generated_method = "CF7A1C3476A79012F41BDF4FF64AE419")
    @Override
    protected void onDestroy() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mHandler.removeCallbacks(mRequestFocus);
        super.onDestroy();
        // ---------- Original Method ----------
        //mHandler.removeCallbacks(mRequestFocus);
        //super.onDestroy();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.771 -0400", hash_original_method = "955E85868B41B55EC53984762AF65544", hash_generated_method = "30388E3EF3BC0BDECE4758D0963DCC90")
    @Override
    public void onContentChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onContentChanged();
        View emptyView = findViewById(com.android.internal.R.id.empty);
        mList = (ListView)findViewById(com.android.internal.R.id.list);
        if(mList == null)        
        {
            RuntimeException var814898E2A75124B230F991BD301E888E_738625787 = new RuntimeException(
                    "Your content must have a ListView whose id attribute is " +
                    "'android.R.id.list'");
            var814898E2A75124B230F991BD301E888E_738625787.addTaint(taint);
            throw var814898E2A75124B230F991BD301E888E_738625787;
        } //End block
        if(emptyView != null)        
        {
            mList.setEmptyView(emptyView);
        } //End block
        mList.setOnItemClickListener(mOnClickListener);
        if(mFinishedStart)        
        {
            setListAdapter(mAdapter);
        } //End block
        mHandler.post(mRequestFocus);
        mFinishedStart = true;
        // ---------- Original Method ----------
        //super.onContentChanged();
        //View emptyView = findViewById(com.android.internal.R.id.empty);
        //mList = (ListView)findViewById(com.android.internal.R.id.list);
        //if (mList == null) {
            //throw new RuntimeException(
                    //"Your content must have a ListView whose id attribute is " +
                    //"'android.R.id.list'");
        //}
        //if (emptyView != null) {
            //mList.setEmptyView(emptyView);
        //}
        //mList.setOnItemClickListener(mOnClickListener);
        //if (mFinishedStart) {
            //setListAdapter(mAdapter);
        //}
        //mHandler.post(mRequestFocus);
        //mFinishedStart = true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.775 -0400", hash_original_method = "24FA4810D9E2927905358E0A26AF6AD1", hash_generated_method = "16A96C087EF2F39B7302E11E10E5E2C2")
    public void setListAdapter(ListAdapter adapter) {
        synchronized
(this)        {
            ensureList();
            mAdapter = adapter;
            mList.setAdapter(adapter);
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //ensureList();
            //mAdapter = adapter;
            //mList.setAdapter(adapter);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.777 -0400", hash_original_method = "567D9F46FDBA003818BBBCD086387BF6", hash_generated_method = "600CC98502A226E0867A545DC502CE66")
    public void setSelection(int position) {
        addTaint(position);
        mList.setSelection(position);
        // ---------- Original Method ----------
        //mList.setSelection(position);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.778 -0400", hash_original_method = "05075802629D70F2FE9B324F3D05972C", hash_generated_method = "A985CF7253319D9BED8FA52EF7C951CB")
    public int getSelectedItemPosition() {
        int varB3259E78107540D8D68BCBB3E503CBA4_1129259822 = (mList.getSelectedItemPosition());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2069996858 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2069996858;
        // ---------- Original Method ----------
        //return mList.getSelectedItemPosition();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.780 -0400", hash_original_method = "EBFC2CC18AED07D84008925040C28A97", hash_generated_method = "C6ECC6984E7560695C9119CC48BE63D7")
    public long getSelectedItemId() {
        long var9B989EB69692C97E4AB8970CCD694C25_235477858 = (mList.getSelectedItemId());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_295595463 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_295595463;
        // ---------- Original Method ----------
        //return mList.getSelectedItemId();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.781 -0400", hash_original_method = "B9D8406BF510100833C8B83670824289", hash_generated_method = "B02BB284A31CE1DAF903CA51F68D69C7")
    public ListView getListView() {
        ensureList();
ListView var344AE622895130273F3D062543816FEE_584396463 =         mList;
        var344AE622895130273F3D062543816FEE_584396463.addTaint(taint);
        return var344AE622895130273F3D062543816FEE_584396463;
        // ---------- Original Method ----------
        //ensureList();
        //return mList;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.782 -0400", hash_original_method = "6C199B6FBEC38BDF6D031387113C1DD5", hash_generated_method = "BCB65BDC5A8C2B81E757A67E7C05CFBD")
    public ListAdapter getListAdapter() {
ListAdapter varD72668EDE5E63ADF9340F3D8A19FD205_1101591930 =         mAdapter;
        varD72668EDE5E63ADF9340F3D8A19FD205_1101591930.addTaint(taint);
        return varD72668EDE5E63ADF9340F3D8A19FD205_1101591930;
        // ---------- Original Method ----------
        //return mAdapter;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.783 -0400", hash_original_method = "8B5C698EA2865F1A0F6EAF61F2AE4FB9", hash_generated_method = "8A39C1E8DD04D52E92C3522329566B10")
    private void ensureList() {
        if(mList != null)        
        {
            return;
        } //End block
        setContentView(com.android.internal.R.layout.list_content_simple);
        // ---------- Original Method ----------
        //if (mList != null) {
            //return;
        //}
        //setContentView(com.android.internal.R.layout.list_content_simple);
    }

    @DSModeled(DSC.BAN)
    @Override
    public void droidsafeOnSubActivityHook() {
        onListItemClick(mList, mList.getChildAt(0), getTaintInt(), getTaintInt());
    }

    
}

