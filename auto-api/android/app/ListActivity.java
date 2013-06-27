package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ListActivity extends Activity {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:49.842 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "53F2F2B4BC3DCBFE8E814654BBA9129E")

    protected ListAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:49.843 -0400", hash_original_field = "F796A16BE866311501B24C73148D80F1", hash_generated_field = "1F541A4D7C9525AEC7D463BC69050466")

    protected ListView mList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:49.844 -0400", hash_original_field = "6781893E9FA50A9B7103FD3F674E566B", hash_generated_field = "2E60E17486AAEB1A4E1F1878A0354061")

    private Handler mHandler = new Handler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:49.845 -0400", hash_original_field = "FF0486143720AAA2762E6DFB7A1926B6", hash_generated_field = "37FB9735B131E97EBBBF7EF31E956D4C")

    private boolean mFinishedStart = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:49.934 -0400", hash_original_field = "F487762B42FCD79D908F11802425F9AE", hash_generated_field = "0F7618824B545F7438074C9B3ED2B879")

    private Runnable mRequestFocus = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:49.934 -0400", hash_original_method = "4F290F2508C3F0B44E09591C5B0749BC", hash_generated_method = "203642A5324F5F18B21A0D020E65FD5C")
        public void run() {
            mList.focusableViewAvailable(mList);
            // ---------- Original Method ----------
            //mList.focusableViewAvailable(mList);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:49.943 -0400", hash_original_field = "9B3F30A71979D6623D111E114AFFBE5E", hash_generated_field = "6D790E9F9FA03BA3AA85760F46B859BE")

    private AdapterView.OnItemClickListener mOnClickListener = new AdapterView.OnItemClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:49.942 -0400", hash_original_method = "FBAC6E1DF4BED6C0A21E33622DB577EE", hash_generated_method = "D00BEF8ABA88B27607955BB6270FA24E")
        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            onListItemClick((ListView)parent, v, position, id);
            addTaint(parent.getTaint());
            addTaint(v.getTaint());
            addTaint(position);
            addTaint(id);
            // ---------- Original Method ----------
            //onListItemClick((ListView)parent, v, position, id);
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:49.944 -0400", hash_original_method = "E9A1B22E98BB93A49E0DD0DF78D68B8E", hash_generated_method = "E9A1B22E98BB93A49E0DD0DF78D68B8E")
    public ListActivity ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:49.964 -0400", hash_original_method = "BF490B4BB4BD29ACC689E0297B614061", hash_generated_method = "3805C5145656BF072B093F0A06FA3650")
    protected void onListItemClick(ListView l, View v, int position, long id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(l.getTaint());
        addTaint(v.getTaint());
        addTaint(position);
        addTaint(id);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:49.967 -0400", hash_original_method = "39D3E8C83EC5D9AA90999E3A2D1BCB07", hash_generated_method = "BF7257B9ACDA2CB1B16AF9A1E032DB34")
    @Override
    protected void onRestoreInstanceState(Bundle state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        ensureList();
        super.onRestoreInstanceState(state);
        addTaint(state.getTaint());
        // ---------- Original Method ----------
        //ensureList();
        //super.onRestoreInstanceState(state);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:49.968 -0400", hash_original_method = "4F23093C6BEB1F491BB932E73A46BC35", hash_generated_method = "CF7A1C3476A79012F41BDF4FF64AE419")
    @Override
    protected void onDestroy() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mHandler.removeCallbacks(mRequestFocus);
        super.onDestroy();
        // ---------- Original Method ----------
        //mHandler.removeCallbacks(mRequestFocus);
        //super.onDestroy();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:49.982 -0400", hash_original_method = "955E85868B41B55EC53984762AF65544", hash_generated_method = "85D4922C2E7B07F003B24191A4BA0D37")
    @Override
    public void onContentChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onContentChanged();
        View emptyView;
        emptyView = findViewById(com.android.internal.R.id.empty);
        mList = (ListView)findViewById(com.android.internal.R.id.list);
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "Your content must have a ListView whose id attribute is " +
                    "'android.R.id.list'");
        } //End block
        {
            mList.setEmptyView(emptyView);
        } //End block
        mList.setOnItemClickListener(mOnClickListener);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:50.000 -0400", hash_original_method = "24FA4810D9E2927905358E0A26AF6AD1", hash_generated_method = "665700C96E36B932B21CF69481264DAD")
    public void setListAdapter(ListAdapter adapter) {
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:50.018 -0400", hash_original_method = "567D9F46FDBA003818BBBCD086387BF6", hash_generated_method = "FA33ABDA4F4BCB896109EF9065F5A2F0")
    public void setSelection(int position) {
        mList.setSelection(position);
        addTaint(position);
        // ---------- Original Method ----------
        //mList.setSelection(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:50.020 -0400", hash_original_method = "05075802629D70F2FE9B324F3D05972C", hash_generated_method = "95EA213DE4D4AC35C37159236D186601")
    public int getSelectedItemPosition() {
        int varA719D7AB33A194F7536365FE9FEAD214_1494181663 = (mList.getSelectedItemPosition());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1021881349 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1021881349;
        // ---------- Original Method ----------
        //return mList.getSelectedItemPosition();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:50.030 -0400", hash_original_method = "EBFC2CC18AED07D84008925040C28A97", hash_generated_method = "B53E4B03F837A979CC56597F77BE7F0F")
    public long getSelectedItemId() {
        long var182667D91D2A4233A45F2A88B322602D_1760673709 = (mList.getSelectedItemId());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_779991480 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_779991480;
        // ---------- Original Method ----------
        //return mList.getSelectedItemId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:50.044 -0400", hash_original_method = "B9D8406BF510100833C8B83670824289", hash_generated_method = "AC8829A8344122D9AC7CADFE77DEDA5C")
    public ListView getListView() {
        ListView varB4EAC82CA7396A68D541C85D26508E83_1935790629 = null; //Variable for return #1
        ensureList();
        varB4EAC82CA7396A68D541C85D26508E83_1935790629 = mList;
        varB4EAC82CA7396A68D541C85D26508E83_1935790629.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1935790629;
        // ---------- Original Method ----------
        //ensureList();
        //return mList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:50.058 -0400", hash_original_method = "6C199B6FBEC38BDF6D031387113C1DD5", hash_generated_method = "EEEB73FDB8DCDC5889855C6EF6225C04")
    public ListAdapter getListAdapter() {
        ListAdapter varB4EAC82CA7396A68D541C85D26508E83_2065834831 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2065834831 = mAdapter;
        varB4EAC82CA7396A68D541C85D26508E83_2065834831.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2065834831;
        // ---------- Original Method ----------
        //return mAdapter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:50.076 -0400", hash_original_method = "8B5C698EA2865F1A0F6EAF61F2AE4FB9", hash_generated_method = "0AFC2A7F51DB102B04742A605DE5ECCA")
    private void ensureList() {
        setContentView(com.android.internal.R.layout.list_content_simple);
        // ---------- Original Method ----------
        //if (mList != null) {
            //return;
        //}
        //setContentView(com.android.internal.R.layout.list_content_simple);
    }

    
}

