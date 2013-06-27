package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.database.Cursor;
import android.os.Bundle;
import java.util.List;
import android.view.ContextMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnCreateContextMenuListener;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.SimpleCursorTreeAdapter;
import android.widget.SimpleExpandableListAdapter;
import android.widget.AdapterView.AdapterContextMenuInfo;
import java.util.Map;

public class ExpandableListActivity extends Activity implements OnCreateContextMenuListener, ExpandableListView.OnChildClickListener, ExpandableListView.OnGroupCollapseListener, ExpandableListView.OnGroupExpandListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.709 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "C8593FDE34702C978989DD9A527E81D9")

    ExpandableListAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.709 -0400", hash_original_field = "F796A16BE866311501B24C73148D80F1", hash_generated_field = "94BF7FD28918CF535D64E578C0C1523E")

    ExpandableListView mList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.710 -0400", hash_original_field = "FF0486143720AAA2762E6DFB7A1926B6", hash_generated_field = "5D1EC77CB5A18285CC99B754B6D1F724")

    boolean mFinishedStart = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.711 -0400", hash_original_method = "D0B536468FD65D0C7A3A3997AB1356FB", hash_generated_method = "D0B536468FD65D0C7A3A3997AB1356FB")
    public ExpandableListActivity ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.712 -0400", hash_original_method = "85F2A519B2781A30F4BC68DB47459C98", hash_generated_method = "EF5273206446CE58A67FA48842F38A9C")
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        addTaint(v.getTaint());
        addTaint(menuInfo.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.729 -0400", hash_original_method = "148B1F725EE0240ACB0F014B88EF7B7D", hash_generated_method = "A0B089E7652685720B3208F7DC3051AB")
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition,
            int childPosition, long id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(parent.getTaint());
        addTaint(v.getTaint());
        addTaint(groupPosition);
        addTaint(childPosition);
        addTaint(id);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_163621705 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_163621705;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.734 -0400", hash_original_method = "2841CE4526AD3DDF27C3902DF7F1E509", hash_generated_method = "450666481CA5602827D87A6CF40F4A36")
    public void onGroupCollapse(int groupPosition) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(groupPosition);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.735 -0400", hash_original_method = "78995B15C7B4DD7E0C829C6483E342E9", hash_generated_method = "C709029D167B3D1FE7AEB11441234665")
    public void onGroupExpand(int groupPosition) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(groupPosition);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.754 -0400", hash_original_method = "39D3E8C83EC5D9AA90999E3A2D1BCB07", hash_generated_method = "BF7257B9ACDA2CB1B16AF9A1E032DB34")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.774 -0400", hash_original_method = "DC93441AA7886210FB8B7D4BBF66C0C2", hash_generated_method = "04D0F77EEEC2A0905DEC4968A385C743")
    @Override
    public void onContentChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onContentChanged();
        View emptyView;
        emptyView = findViewById(com.android.internal.R.id.empty);
        mList = (ExpandableListView)findViewById(com.android.internal.R.id.list);
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "Your content must have a ExpandableListView whose id attribute is " +
                    "'android.R.id.list'");
        } //End block
        {
            mList.setEmptyView(emptyView);
        } //End block
        mList.setOnChildClickListener(this);
        mList.setOnGroupExpandListener(this);
        mList.setOnGroupCollapseListener(this);
        {
            setListAdapter(mAdapter);
        } //End block
        mFinishedStart = true;
        // ---------- Original Method ----------
        //super.onContentChanged();
        //View emptyView = findViewById(com.android.internal.R.id.empty);
        //mList = (ExpandableListView)findViewById(com.android.internal.R.id.list);
        //if (mList == null) {
            //throw new RuntimeException(
                    //"Your content must have a ExpandableListView whose id attribute is " +
                    //"'android.R.id.list'");
        //}
        //if (emptyView != null) {
            //mList.setEmptyView(emptyView);
        //}
        //mList.setOnChildClickListener(this);
        //mList.setOnGroupExpandListener(this);
        //mList.setOnGroupCollapseListener(this);
        //if (mFinishedStart) {
            //setListAdapter(mAdapter);
        //}
        //mFinishedStart = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.804 -0400", hash_original_method = "A29D9C463A320B0EEFF4CD23C93CB5C7", hash_generated_method = "C63ADA8CAB0EDB43DBCD790638CC701E")
    public void setListAdapter(ExpandableListAdapter adapter) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.814 -0400", hash_original_method = "2F22B94C75DB37CE8939976B81D6509B", hash_generated_method = "6AC557AA7E80990269C71AFBFC3A3FE9")
    public ExpandableListView getExpandableListView() {
        ExpandableListView varB4EAC82CA7396A68D541C85D26508E83_1605955963 = null; //Variable for return #1
        ensureList();
        varB4EAC82CA7396A68D541C85D26508E83_1605955963 = mList;
        varB4EAC82CA7396A68D541C85D26508E83_1605955963.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1605955963;
        // ---------- Original Method ----------
        //ensureList();
        //return mList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.824 -0400", hash_original_method = "0DEBB462BC2A68BA86FC192DC719C116", hash_generated_method = "F5351174BF30C77E87D6FB6F5AE90AAE")
    public ExpandableListAdapter getExpandableListAdapter() {
        ExpandableListAdapter varB4EAC82CA7396A68D541C85D26508E83_328897880 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_328897880 = mAdapter;
        varB4EAC82CA7396A68D541C85D26508E83_328897880.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_328897880;
        // ---------- Original Method ----------
        //return mAdapter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.826 -0400", hash_original_method = "747EB77893A53326BE6690546CE6B949", hash_generated_method = "542ACE1F6554559722EA9AE169C011BF")
    private void ensureList() {
        setContentView(com.android.internal.R.layout.expandable_list_content);
        // ---------- Original Method ----------
        //if (mList != null) {
            //return;
        //}
        //setContentView(com.android.internal.R.layout.expandable_list_content);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.842 -0400", hash_original_method = "D269A0D02850950126987DFFB8BC24BB", hash_generated_method = "ACAC586910AC6A192C39742BFFDC7409")
    public long getSelectedId() {
        long var275880C98508413C8AA1CCF0D9FCA240_1370204997 = (mList.getSelectedId());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1573881792 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1573881792;
        // ---------- Original Method ----------
        //return mList.getSelectedId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.853 -0400", hash_original_method = "0A3ABCC5DF6D266750E60E7B93EFBFA9", hash_generated_method = "40DEB09964ECD17E9364B73BAE6576A9")
    public long getSelectedPosition() {
        long var9D496FDFB5DF60B4E9FC191016FB8057_1238913957 = (mList.getSelectedPosition());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1677742373 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1677742373;
        // ---------- Original Method ----------
        //return mList.getSelectedPosition();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.856 -0400", hash_original_method = "12D5BB1A8EA5B36CE9F4C13B45510FF0", hash_generated_method = "C1D3706920B5F86D0BAEE2ED1F2416F7")
    public boolean setSelectedChild(int groupPosition, int childPosition, boolean shouldExpandGroup) {
        boolean varC061CFB78B119A902BAA937D31B5F566_189638818 = (mList.setSelectedChild(groupPosition, childPosition, shouldExpandGroup));
        addTaint(groupPosition);
        addTaint(childPosition);
        addTaint(shouldExpandGroup);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2116953027 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2116953027;
        // ---------- Original Method ----------
        //return mList.setSelectedChild(groupPosition, childPosition, shouldExpandGroup);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.881 -0400", hash_original_method = "3A247D892E79B521DDD1AEE43FAB3391", hash_generated_method = "F643F409B52515D14CF1DEE6083F3E1F")
    public void setSelectedGroup(int groupPosition) {
        mList.setSelectedGroup(groupPosition);
        addTaint(groupPosition);
        // ---------- Original Method ----------
        //mList.setSelectedGroup(groupPosition);
    }

    
}

