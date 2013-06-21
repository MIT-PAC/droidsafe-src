package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private long mNumDeletes;
    private Account mAccount;
    private String mAuthority;
    private String mProvider;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.084 -0400", hash_original_method = "3DE72B1C1D1066DA4ED10F3673A3809B", hash_generated_method = "3DE72B1C1D1066DA4ED10F3673A3809B")
        public SyncActivityTooManyDeletes ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.085 -0400", hash_original_method = "4083F5BA5A170FDE3F4AF132A8D59C6A", hash_generated_method = "3019CEB2AD35ADEEA25BE753871C9AE6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(savedInstanceState.dsTaint);
        super.onCreate(savedInstanceState);
        Bundle extras;
        extras = getIntent().getExtras();
        {
            finish();
        } //End block
        mNumDeletes = extras.getLong("numDeletes");
        mAccount = (Account) extras.getParcelable("account");
        mAuthority = extras.getString("authority");
        mProvider = extras.getString("provider");
        CharSequence[] options;
        options = new CharSequence[]{
                getResources().getText(R.string.sync_really_delete),
                getResources().getText(R.string.sync_undo_deletes),
                getResources().getText(R.string.sync_do_nothing)
        };
        ListAdapter adapter;
        adapter = new ArrayAdapter<CharSequence>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                options);
        ListView listView;
        listView = new ListView(this);
        listView.setAdapter(adapter);
        listView.setItemsCanFocus(true);
        listView.setOnItemClickListener(this);
        TextView textView;
        textView = new TextView(this);
        CharSequence tooManyDeletesDescFormat;
        tooManyDeletesDescFormat = getResources().getText(R.string.sync_too_many_deletes_desc);
        textView.setText(String.format(tooManyDeletesDescFormat.toString(),
                mNumDeletes, mProvider, mAccount.name));
        LinearLayout ll;
        ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams lp;
        lp = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 0);
        ll.addView(textView, lp);
        ll.addView(listView, lp);
        setContentView(ll);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.085 -0400", hash_original_method = "87A49239DD26172CC00A29DE94A05FAE", hash_generated_method = "B34EFD4A103C983200F2EA60E1C71F8B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(id);
        dsTaint.addTaint(position);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        startSyncReallyDelete();
        startSyncUndoDeletes();
        finish();
        // ---------- Original Method ----------
        //if (position == 0) startSyncReallyDelete();
        //else if (position == 1) startSyncUndoDeletes();
        //finish();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.086 -0400", hash_original_method = "8359BAD844441D7FEC2F631DA63D9ED3", hash_generated_method = "CFCEA0941212F1D667322D5DB853916E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void startSyncReallyDelete() {
        Bundle extras;
        extras = new Bundle();
        extras.putBoolean(ContentResolver.SYNC_EXTRAS_OVERRIDE_TOO_MANY_DELETIONS, true);
        extras.putBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, true);
        extras.putBoolean(ContentResolver.SYNC_EXTRAS_EXPEDITED, true);
        extras.putBoolean(ContentResolver.SYNC_EXTRAS_UPLOAD, true);
        ContentResolver.requestSync(mAccount, mAuthority, extras);
        // ---------- Original Method ----------
        //Bundle extras = new Bundle();
        //extras.putBoolean(ContentResolver.SYNC_EXTRAS_OVERRIDE_TOO_MANY_DELETIONS, true);
        //extras.putBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, true);
        //extras.putBoolean(ContentResolver.SYNC_EXTRAS_EXPEDITED, true);
        //extras.putBoolean(ContentResolver.SYNC_EXTRAS_UPLOAD, true);
        //ContentResolver.requestSync(mAccount, mAuthority, extras);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.087 -0400", hash_original_method = "CE7FC2B344B122C88B585FB58EADCEB6", hash_generated_method = "5FA7505F4A7BDD6A293DA88B629F450F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void startSyncUndoDeletes() {
        Bundle extras;
        extras = new Bundle();
        extras.putBoolean(ContentResolver.SYNC_EXTRAS_DISCARD_LOCAL_DELETIONS, true);
        extras.putBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, true);
        extras.putBoolean(ContentResolver.SYNC_EXTRAS_EXPEDITED, true);
        extras.putBoolean(ContentResolver.SYNC_EXTRAS_UPLOAD, true);
        ContentResolver.requestSync(mAccount, mAuthority, extras);
        // ---------- Original Method ----------
        //Bundle extras = new Bundle();
        //extras.putBoolean(ContentResolver.SYNC_EXTRAS_DISCARD_LOCAL_DELETIONS, true);
        //extras.putBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, true);
        //extras.putBoolean(ContentResolver.SYNC_EXTRAS_EXPEDITED, true);
        //extras.putBoolean(ContentResolver.SYNC_EXTRAS_UPLOAD, true);
        //ContentResolver.requestSync(mAccount, mAuthority, extras);
    }

    
}

