
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:40.786 -0500", hash_original_field = "CBDD62EF585589E92C0E00AE9F4F22E2", hash_generated_field = "53F2F2B4BC3DCBFE8E814654BBA9129E")

    protected ListAdapter mAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:40.788 -0500", hash_original_field = "A5B73AC2B922200A8C47FEAA8C3EB07A", hash_generated_field = "1F541A4D7C9525AEC7D463BC69050466")

    protected ListView mList;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:40.790 -0500", hash_original_field = "AD9C3D1E48D73BF1547D53C4C62401B2", hash_generated_field = "2E60E17486AAEB1A4E1F1878A0354061")

    private Handler mHandler = new Handler();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:40.792 -0500", hash_original_field = "5D1EC77CB5A18285CC99B754B6D1F724", hash_generated_field = "37FB9735B131E97EBBBF7EF31E956D4C")

    private boolean mFinishedStart = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.757 -0400", hash_original_field = "F487762B42FCD79D908F11802425F9AE", hash_generated_field = "B11DF01C886CC15D12A595382174A0C1")

    private Runnable mRequestFocus = new Runnable() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:40.795 -0500", hash_original_method = "4F290F2508C3F0B44E09591C5B0749BC", hash_generated_method = "6E91A76828706A9FC9B939DB082B9EB4")
        
public void run() {
            mList.focusableViewAvailable(mList);
        }
        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.760 -0400", hash_original_field = "9B3F30A71979D6623D111E114AFFBE5E", hash_generated_field = "F601E5C2332EFF7D085096154B4D128B")

    private AdapterView.OnItemClickListener mOnClickListener = new AdapterView.OnItemClickListener() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:40.824 -0500", hash_original_method = "FBAC6E1DF4BED6C0A21E33622DB577EE", hash_generated_method = "BC24D5DEFBC796DC11F2D9E3A402C8A4")
        
public void onItemClick(AdapterView<?> parent, View v, int position, long id)
        {
            onListItemClick((ListView)parent, v, position, id);
        }
        
};
    
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.761 -0400", hash_original_method = "E9A1B22E98BB93A49E0DD0DF78D68B8E", hash_generated_method = "E9A1B22E98BB93A49E0DD0DF78D68B8E")
    public ListActivity ()
    {
        //Synthesized constructor
    }

    /**
     * This method will be called when an item in the list is selected.
     * Subclasses should override. Subclasses can call
     * getListView().getItemAtPosition(position) if they need to access the
     * data associated with the selected item.
     *
     * @param l The ListView where the click happened
     * @param v The view that was clicked within the ListView
     * @param position The position of the view in the list
     * @param id The row id of the item that was clicked
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSVerified
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:40.799 -0500", hash_original_method = "BF490B4BB4BD29ACC689E0297B614061", hash_generated_method = "A5ED3456A9BC8D0D960D02BCCB1B3136")
    
protected void onListItemClick(ListView l, View v, int position, long id) {
    }

    /**
     * Ensures the list view has been created before Activity restores all
     * of the view states.
     *
     *@see Activity#onRestoreInstanceState(Bundle)
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:40.802 -0500", hash_original_method = "39D3E8C83EC5D9AA90999E3A2D1BCB07", hash_generated_method = "2DE8AD90C1A42DCA55687530BB5B9E78")
    @DSVerified("Called by Activity.droidsafe's method")
@Override
    protected void onRestoreInstanceState(Bundle state) {
        ensureList();
        super.onRestoreInstanceState(state);
    }

    /**
     * @see Activity#onDestroy()
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:40.804 -0500", hash_original_method = "4F23093C6BEB1F491BB932E73A46BC35", hash_generated_method = "38ECB1EC95321D4A833AF4322996CF7F")
    
@Override
    protected void onDestroy() {
        mHandler.removeCallbacks(mRequestFocus);
        super.onDestroy();
    }
    
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.771 -0400", hash_original_method = "955E85868B41B55EC53984762AF65544", hash_generated_method = "30388E3EF3BC0BDECE4758D0963DCC90")
    @Override
    public void onContentChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onContentChanged();
        View emptyView = findViewById(com.android.internal.R.id.empty);
        // The findViewById doesn't work yet, so just create one.
        // mList = (ListView)findViewById(com.android.internal.R.id.list);
        mList = new ListView(this);
        if(mList == null)        
        {
            RuntimeException var814898E2A75124B230F991BD301E888E_738625787 = new RuntimeException(
                    "Your content must have a ListView whose id attribute is " +
                    "'android.R.id.list'");
            var814898E2A75124B230F991BD301E888E_738625787.addTaint(getTaint());
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

    /**
     * Provide the cursor for the list view.
     */
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:40.809 -0500", hash_original_method = "24FA4810D9E2927905358E0A26AF6AD1", hash_generated_method = "DCB6C00F391D143EC695F73E5AD0F36E")
    
public void setListAdapter(ListAdapter adapter) {
        synchronized (this) {
            ensureList();
            mAdapter = adapter;
            mList.setAdapter(adapter);
        }
    }

    /**
     * Set the currently selected list item to the specified
     * position with the adapter's data
     *
     * @param position
     */
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:40.811 -0500", hash_original_method = "567D9F46FDBA003818BBBCD086387BF6", hash_generated_method = "1BC22E0D725F73FF205318ECE82C4843")
    
public void setSelection(int position) {
        mList.setSelection(position);
    }

    /**
     * Get the position of the currently selected list item.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:40.813 -0500", hash_original_method = "05075802629D70F2FE9B324F3D05972C", hash_generated_method = "5E1E27D0232228CDFD2C052E25F88466")
    
public int getSelectedItemPosition() {
        return mList.getSelectedItemPosition();
    }

    /**
     * Get the cursor row ID of the currently selected list item.
     */
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:40.814 -0500", hash_original_method = "EBFC2CC18AED07D84008925040C28A97", hash_generated_method = "A31713499E58C077CBAC1FA4CC02C5DE")
    
public long getSelectedItemId() {
        return mList.getSelectedItemId();
    }

    /**
     * Get the activity's list view widget.
     */
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:40.816 -0500", hash_original_method = "B9D8406BF510100833C8B83670824289", hash_generated_method = "F390A30877A55CE39C88D546BF9EAE07")
    
public ListView getListView() {
        ensureList();
        return mList;
    }

    /**
     * Get the ListAdapter associated with this activity's ListView.
     */
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:40.818 -0500", hash_original_method = "6C199B6FBEC38BDF6D031387113C1DD5", hash_generated_method = "F0392D746E5256DD5E352F87E4AB1051")
    
public ListAdapter getListAdapter() {
        return mAdapter;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.783 -0400", hash_original_method = "8B5C698EA2865F1A0F6EAF61F2AE4FB9", hash_generated_method = "8A39C1E8DD04D52E92C3522329566B10")
    private void ensureList() {
        if(mList != null)        
        {
            return;
        } //End block
        mList = new ListView (this);
        // We can't look up views by their ids and its not clear where mList
        // will get initialized
        // setContentView(com.android.internal.R.layout.list_content_simple);
        // ---------- Original Method ----------
        //if (mList != null) {
            //return;
        //}
        //setContentView(com.android.internal.R.layout.list_content_simple);
    }

    @DSVerified
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    @Override
    public void droidsafeSubActivityCallbackHook() {
        onListItemClick(mList, mList.getChildAt(0), getTaintInt(), getTaintInt());
    }
    
}

