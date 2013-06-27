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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.107 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "C8593FDE34702C978989DD9A527E81D9")

    ExpandableListAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.107 -0400", hash_original_field = "F796A16BE866311501B24C73148D80F1", hash_generated_field = "94BF7FD28918CF535D64E578C0C1523E")

    ExpandableListView mList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.126 -0400", hash_original_field = "FF0486143720AAA2762E6DFB7A1926B6", hash_generated_field = "5D1EC77CB5A18285CC99B754B6D1F724")

    boolean mFinishedStart = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.126 -0400", hash_original_method = "D0B536468FD65D0C7A3A3997AB1356FB", hash_generated_method = "D0B536468FD65D0C7A3A3997AB1356FB")
    public ExpandableListActivity ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.128 -0400", hash_original_method = "85F2A519B2781A30F4BC68DB47459C98", hash_generated_method = "EF5273206446CE58A67FA48842F38A9C")
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        addTaint(v.getTaint());
        addTaint(menuInfo.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.133 -0400", hash_original_method = "148B1F725EE0240ACB0F014B88EF7B7D", hash_generated_method = "D50BF0C134597D20A41EF3357AFE9DA7")
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition,
            int childPosition, long id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(parent.getTaint());
        addTaint(v.getTaint());
        addTaint(groupPosition);
        addTaint(childPosition);
        addTaint(id);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1260701992 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1260701992;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.135 -0400", hash_original_method = "2841CE4526AD3DDF27C3902DF7F1E509", hash_generated_method = "450666481CA5602827D87A6CF40F4A36")
    public void onGroupCollapse(int groupPosition) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(groupPosition);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.158 -0400", hash_original_method = "78995B15C7B4DD7E0C829C6483E342E9", hash_generated_method = "C709029D167B3D1FE7AEB11441234665")
    public void onGroupExpand(int groupPosition) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(groupPosition);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.160 -0400", hash_original_method = "39D3E8C83EC5D9AA90999E3A2D1BCB07", hash_generated_method = "BF7257B9ACDA2CB1B16AF9A1E032DB34")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.162 -0400", hash_original_method = "DC93441AA7886210FB8B7D4BBF66C0C2", hash_generated_method = "04D0F77EEEC2A0905DEC4968A385C743")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.176 -0400", hash_original_method = "A29D9C463A320B0EEFF4CD23C93CB5C7", hash_generated_method = "C63ADA8CAB0EDB43DBCD790638CC701E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.189 -0400", hash_original_method = "2F22B94C75DB37CE8939976B81D6509B", hash_generated_method = "2AAE15E3ED9FFB223B54CD49885EBFB0")
    public ExpandableListView getExpandableListView() {
        ExpandableListView varB4EAC82CA7396A68D541C85D26508E83_1432484933 = null; //Variable for return #1
        ensureList();
        varB4EAC82CA7396A68D541C85D26508E83_1432484933 = mList;
        varB4EAC82CA7396A68D541C85D26508E83_1432484933.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1432484933;
        // ---------- Original Method ----------
        //ensureList();
        //return mList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.203 -0400", hash_original_method = "0DEBB462BC2A68BA86FC192DC719C116", hash_generated_method = "05CA02105695FB52702FD14A557E9439")
    public ExpandableListAdapter getExpandableListAdapter() {
        ExpandableListAdapter varB4EAC82CA7396A68D541C85D26508E83_411580303 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_411580303 = mAdapter;
        varB4EAC82CA7396A68D541C85D26508E83_411580303.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_411580303;
        // ---------- Original Method ----------
        //return mAdapter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.205 -0400", hash_original_method = "747EB77893A53326BE6690546CE6B949", hash_generated_method = "542ACE1F6554559722EA9AE169C011BF")
    private void ensureList() {
        setContentView(com.android.internal.R.layout.expandable_list_content);
        // ---------- Original Method ----------
        //if (mList != null) {
            //return;
        //}
        //setContentView(com.android.internal.R.layout.expandable_list_content);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.218 -0400", hash_original_method = "D269A0D02850950126987DFFB8BC24BB", hash_generated_method = "9A69E17464094100190C15DF28FB4C85")
    public long getSelectedId() {
        long var275880C98508413C8AA1CCF0D9FCA240_1447053134 = (mList.getSelectedId());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_445037812 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_445037812;
        // ---------- Original Method ----------
        //return mList.getSelectedId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.225 -0400", hash_original_method = "0A3ABCC5DF6D266750E60E7B93EFBFA9", hash_generated_method = "B6BA0EDC5117F5B17ECEA95DE2D7E3C3")
    public long getSelectedPosition() {
        long var9D496FDFB5DF60B4E9FC191016FB8057_792443336 = (mList.getSelectedPosition());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_186377653 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_186377653;
        // ---------- Original Method ----------
        //return mList.getSelectedPosition();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.227 -0400", hash_original_method = "12D5BB1A8EA5B36CE9F4C13B45510FF0", hash_generated_method = "55E01401FA24FB4185D0FB114C4713B6")
    public boolean setSelectedChild(int groupPosition, int childPosition, boolean shouldExpandGroup) {
        boolean varC061CFB78B119A902BAA937D31B5F566_1818697566 = (mList.setSelectedChild(groupPosition, childPosition, shouldExpandGroup));
        addTaint(groupPosition);
        addTaint(childPosition);
        addTaint(shouldExpandGroup);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1666394200 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1666394200;
        // ---------- Original Method ----------
        //return mList.setSelectedChild(groupPosition, childPosition, shouldExpandGroup);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.228 -0400", hash_original_method = "3A247D892E79B521DDD1AEE43FAB3391", hash_generated_method = "F643F409B52515D14CF1DEE6083F3E1F")
    public void setSelectedGroup(int groupPosition) {
        mList.setSelectedGroup(groupPosition);
        addTaint(groupPosition);
        // ---------- Original Method ----------
        //mList.setSelectedGroup(groupPosition);
    }

    
}

