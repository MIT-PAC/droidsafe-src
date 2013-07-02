package android.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.741 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "C8593FDE34702C978989DD9A527E81D9")

    ExpandableListAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.741 -0400", hash_original_field = "F796A16BE866311501B24C73148D80F1", hash_generated_field = "94BF7FD28918CF535D64E578C0C1523E")

    ExpandableListView mList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.741 -0400", hash_original_field = "FF0486143720AAA2762E6DFB7A1926B6", hash_generated_field = "5D1EC77CB5A18285CC99B754B6D1F724")

    boolean mFinishedStart = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.741 -0400", hash_original_method = "D0B536468FD65D0C7A3A3997AB1356FB", hash_generated_method = "D0B536468FD65D0C7A3A3997AB1356FB")
    public ExpandableListActivity ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.741 -0400", hash_original_method = "85F2A519B2781A30F4BC68DB47459C98", hash_generated_method = "EF5273206446CE58A67FA48842F38A9C")
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        
        addTaint(menu.getTaint());
        addTaint(v.getTaint());
        addTaint(menuInfo.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.742 -0400", hash_original_method = "148B1F725EE0240ACB0F014B88EF7B7D", hash_generated_method = "623D57167DF44B7078A5BD300B12430A")
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition,
            int childPosition, long id) {
        
        addTaint(parent.getTaint());
        addTaint(v.getTaint());
        addTaint(groupPosition);
        addTaint(childPosition);
        addTaint(id);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_604273189 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_604273189;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.742 -0400", hash_original_method = "2841CE4526AD3DDF27C3902DF7F1E509", hash_generated_method = "450666481CA5602827D87A6CF40F4A36")
    public void onGroupCollapse(int groupPosition) {
        
        addTaint(groupPosition);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.743 -0400", hash_original_method = "78995B15C7B4DD7E0C829C6483E342E9", hash_generated_method = "C709029D167B3D1FE7AEB11441234665")
    public void onGroupExpand(int groupPosition) {
        
        addTaint(groupPosition);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.744 -0400", hash_original_method = "39D3E8C83EC5D9AA90999E3A2D1BCB07", hash_generated_method = "BF7257B9ACDA2CB1B16AF9A1E032DB34")
    @Override
    protected void onRestoreInstanceState(Bundle state) {
        
        ensureList();
        super.onRestoreInstanceState(state);
        addTaint(state.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.745 -0400", hash_original_method = "DC93441AA7886210FB8B7D4BBF66C0C2", hash_generated_method = "9324DC00A2517C8AD00C6B9C1FD2CF91")
    @Override
    public void onContentChanged() {
        
        super.onContentChanged();
        View emptyView = findViewById(com.android.internal.R.id.empty);
        mList = (ExpandableListView)findViewById(com.android.internal.R.id.list);
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "Your content must have a ExpandableListView whose id attribute is " +
                    "'android.R.id.list'");
        } 
        {
            mList.setEmptyView(emptyView);
        } 
        mList.setOnChildClickListener(this);
        mList.setOnGroupExpandListener(this);
        mList.setOnGroupCollapseListener(this);
        {
            setListAdapter(mAdapter);
        } 
        mFinishedStart = true;
        
        
        
        
        
            
                    
                    
        
        
            
        
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.746 -0400", hash_original_method = "A29D9C463A320B0EEFF4CD23C93CB5C7", hash_generated_method = "C63ADA8CAB0EDB43DBCD790638CC701E")
    public void setListAdapter(ExpandableListAdapter adapter) {
        {
            ensureList();
            mAdapter = adapter;
            mList.setAdapter(adapter);
        } 
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.747 -0400", hash_original_method = "2F22B94C75DB37CE8939976B81D6509B", hash_generated_method = "C0F1F2C57F74E1BCE4221C268D714D2F")
    public ExpandableListView getExpandableListView() {
        ExpandableListView varB4EAC82CA7396A68D541C85D26508E83_1328745966 = null; 
        ensureList();
        varB4EAC82CA7396A68D541C85D26508E83_1328745966 = mList;
        varB4EAC82CA7396A68D541C85D26508E83_1328745966.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1328745966;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.748 -0400", hash_original_method = "0DEBB462BC2A68BA86FC192DC719C116", hash_generated_method = "DADE37D4B14134E5D74449CAB12D98B9")
    public ExpandableListAdapter getExpandableListAdapter() {
        ExpandableListAdapter varB4EAC82CA7396A68D541C85D26508E83_559791915 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_559791915 = mAdapter;
        varB4EAC82CA7396A68D541C85D26508E83_559791915.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_559791915;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.748 -0400", hash_original_method = "747EB77893A53326BE6690546CE6B949", hash_generated_method = "542ACE1F6554559722EA9AE169C011BF")
    private void ensureList() {
        setContentView(com.android.internal.R.layout.expandable_list_content);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.749 -0400", hash_original_method = "D269A0D02850950126987DFFB8BC24BB", hash_generated_method = "28A0F5233805B392AE2EFC37EAAC7460")
    public long getSelectedId() {
        long var275880C98508413C8AA1CCF0D9FCA240_1875237550 = (mList.getSelectedId());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1256923823 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1256923823;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.750 -0400", hash_original_method = "0A3ABCC5DF6D266750E60E7B93EFBFA9", hash_generated_method = "ED3712F6ADBFAB8260CF6BC1DF2F68D0")
    public long getSelectedPosition() {
        long var9D496FDFB5DF60B4E9FC191016FB8057_1544117294 = (mList.getSelectedPosition());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_630482363 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_630482363;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.750 -0400", hash_original_method = "12D5BB1A8EA5B36CE9F4C13B45510FF0", hash_generated_method = "A7EF25F58B4581ACF59643D753F56448")
    public boolean setSelectedChild(int groupPosition, int childPosition, boolean shouldExpandGroup) {
        boolean varC061CFB78B119A902BAA937D31B5F566_78820873 = (mList.setSelectedChild(groupPosition, childPosition, shouldExpandGroup));
        addTaint(groupPosition);
        addTaint(childPosition);
        addTaint(shouldExpandGroup);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_831356430 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_831356430;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.751 -0400", hash_original_method = "3A247D892E79B521DDD1AEE43FAB3391", hash_generated_method = "F643F409B52515D14CF1DEE6083F3E1F")
    public void setSelectedGroup(int groupPosition) {
        mList.setSelectedGroup(groupPosition);
        addTaint(groupPosition);
        
        
    }

    
}

