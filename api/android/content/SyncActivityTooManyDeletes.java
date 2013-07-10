package android.content;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import com.android.internal.R;
import android.accounts.Account;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SyncActivityTooManyDeletes extends Activity implements AdapterView.OnItemClickListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.487 -0400", hash_original_field = "9396EDC1B0203C3E8377092DF4A9DD0F", hash_generated_field = "86D230D989C0289FA38126BD15162121")

    private long mNumDeletes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.487 -0400", hash_original_field = "591F77A70FEF1AA3112C01B360A63E9C", hash_generated_field = "3B055C3859C53A8ACDFC59C6C8440DF8")

    private Account mAccount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.487 -0400", hash_original_field = "2325EF4ABFCA50C092A123BB59FD3F59", hash_generated_field = "5E9A5C7D075BBF710B4D594B2F64B868")

    private String mAuthority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.487 -0400", hash_original_field = "BD1D19BC6BC3803BE152A977D479AC49", hash_generated_field = "644895AD43D171E05003EF08DEE63C8C")

    private String mProvider;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.487 -0400", hash_original_method = "F88E45C8A992B3EE5445BCFA92AD005E", hash_generated_method = "F88E45C8A992B3EE5445BCFA92AD005E")
    public SyncActivityTooManyDeletes ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.488 -0400", hash_original_method = "4083F5BA5A170FDE3F4AF132A8D59C6A", hash_generated_method = "96A390185D07FEA4340CA3DD72E1B003")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        {
            finish();
        } 
        mNumDeletes = extras.getLong("numDeletes");
        mAccount = (Account) extras.getParcelable("account");
        mAuthority = extras.getString("authority");
        mProvider = extras.getString("provider");
        CharSequence[] options = new CharSequence[]{
                getResources().getText(R.string.sync_really_delete),
                getResources().getText(R.string.sync_undo_deletes),
                getResources().getText(R.string.sync_do_nothing)
        };
        ListAdapter adapter = new ArrayAdapter<CharSequence>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                options);
        ListView listView = new ListView(this);
        listView.setAdapter(adapter);
        listView.setItemsCanFocus(true);
        listView.setOnItemClickListener(this);
        TextView textView = new TextView(this);
        CharSequence tooManyDeletesDescFormat = getResources().getText(R.string.sync_too_many_deletes_desc);
        textView.setText(String.format(tooManyDeletesDescFormat.toString(),
                mNumDeletes, mProvider, mAccount.name));
        final LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        final LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 0);
        ll.addView(textView, lp);
        ll.addView(listView, lp);
        setContentView(ll);
        addTaint(savedInstanceState.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.489 -0400", hash_original_method = "87A49239DD26172CC00A29DE94A05FAE", hash_generated_method = "CA5E3F964E690D64B4127A3602E2FAC1")
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        
        startSyncReallyDelete();
        startSyncUndoDeletes();
        finish();
        addTaint(parent.getTaint());
        addTaint(view.getTaint());
        addTaint(position);
        addTaint(id);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.489 -0400", hash_original_method = "8359BAD844441D7FEC2F631DA63D9ED3", hash_generated_method = "BEB460FCC20AE15F75E9651C3BDE0BA8")
    private void startSyncReallyDelete() {
        Bundle extras = new Bundle();
        extras.putBoolean(ContentResolver.SYNC_EXTRAS_OVERRIDE_TOO_MANY_DELETIONS, true);
        extras.putBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, true);
        extras.putBoolean(ContentResolver.SYNC_EXTRAS_EXPEDITED, true);
        extras.putBoolean(ContentResolver.SYNC_EXTRAS_UPLOAD, true);
        ContentResolver.requestSync(mAccount, mAuthority, extras);
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.490 -0400", hash_original_method = "CE7FC2B344B122C88B585FB58EADCEB6", hash_generated_method = "08C2B21588698550CD7D4D9DB4254D98")
    private void startSyncUndoDeletes() {
        Bundle extras = new Bundle();
        extras.putBoolean(ContentResolver.SYNC_EXTRAS_DISCARD_LOCAL_DELETIONS, true);
        extras.putBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, true);
        extras.putBoolean(ContentResolver.SYNC_EXTRAS_EXPEDITED, true);
        extras.putBoolean(ContentResolver.SYNC_EXTRAS_UPLOAD, true);
        ContentResolver.requestSync(mAccount, mAuthority, extras);
        
        
        
        
        
        
        
    }

    
}

