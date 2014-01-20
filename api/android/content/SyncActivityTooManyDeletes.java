package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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

import com.android.internal.R;

public class SyncActivityTooManyDeletes extends Activity implements AdapterView.OnItemClickListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.902 -0500", hash_original_field = "8767D22D0CC33D20371C3E004058DD78", hash_generated_field = "86D230D989C0289FA38126BD15162121")

    private long mNumDeletes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.904 -0500", hash_original_field = "77E70EE964F6B49E35EDB9210610AC8E", hash_generated_field = "3B055C3859C53A8ACDFC59C6C8440DF8")

    private Account mAccount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.906 -0500", hash_original_field = "BC4522E788A053F96319766AEE95ACCB", hash_generated_field = "5E9A5C7D075BBF710B4D594B2F64B868")

    private String mAuthority;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.908 -0500", hash_original_field = "91E507DC461800B2755826CF50C3CFFF", hash_generated_field = "644895AD43D171E05003EF08DEE63C8C")

    private String mProvider;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.847 -0400", hash_original_method = "F88E45C8A992B3EE5445BCFA92AD005E", hash_generated_method = "F88E45C8A992B3EE5445BCFA92AD005E")
    public SyncActivityTooManyDeletes ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.911 -0500", hash_original_method = "4083F5BA5A170FDE3F4AF132A8D59C6A", hash_generated_method = "9C321ACB0A6CFD8B64CE048840CF0262")
    
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            finish();
            return;
        }

        mNumDeletes = extras.getLong("numDeletes");
        mAccount = (Account) extras.getParcelable("account");
        mAuthority = extras.getString("authority");
        mProvider = extras.getString("provider");

        // the order of these must match up with the constants for position used in onItemClick
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
        CharSequence tooManyDeletesDescFormat =
                getResources().getText(R.string.sync_too_many_deletes_desc);
        textView.setText(String.format(tooManyDeletesDescFormat.toString(),
                mNumDeletes, mProvider, mAccount.name));

        final LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        final LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 0);
        ll.addView(textView, lp);
        ll.addView(listView, lp);

        // TODO: consider displaying the icon of the account type
//        AuthenticatorDescription[] descs = AccountManager.get(this).getAuthenticatorTypes();
//        for (AuthenticatorDescription desc : descs) {
//            if (desc.type.equals(mAccount.type)) {
//                try {
//                    final Context authContext = createPackageContext(desc.packageName, 0);
//                    ImageView imageView = new ImageView(this);
//                    imageView.setImageDrawable(authContext.getResources().getDrawable(desc.iconId));
//                    ll.addView(imageView, lp);
//                } catch (PackageManager.NameNotFoundException e) {
//                }
//                break;
//            }
//        }

        setContentView(ll);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.913 -0500", hash_original_method = "87A49239DD26172CC00A29DE94A05FAE", hash_generated_method = "F4A4C31FC566753A19B35BB739E03C5E")
    
public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // the constants for position correspond to the items options array in onCreate()
        if (position == 0) startSyncReallyDelete();
        else if (position == 1) startSyncUndoDeletes();
        finish();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.916 -0500", hash_original_method = "8359BAD844441D7FEC2F631DA63D9ED3", hash_generated_method = "7A50F5BF6B553B57A60C5B28B009277B")
    
private void startSyncReallyDelete() {
        Bundle extras = new Bundle();
        extras.putBoolean(ContentResolver.SYNC_EXTRAS_OVERRIDE_TOO_MANY_DELETIONS, true);
        extras.putBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, true);
        extras.putBoolean(ContentResolver.SYNC_EXTRAS_EXPEDITED, true);
        extras.putBoolean(ContentResolver.SYNC_EXTRAS_UPLOAD, true);
        ContentResolver.requestSync(mAccount, mAuthority, extras);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.918 -0500", hash_original_method = "CE7FC2B344B122C88B585FB58EADCEB6", hash_generated_method = "37D3C13826B9713FFEEFD1B75D1CF62C")
    
private void startSyncUndoDeletes() {
        Bundle extras = new Bundle();
        extras.putBoolean(ContentResolver.SYNC_EXTRAS_DISCARD_LOCAL_DELETIONS, true);
        extras.putBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, true);
        extras.putBoolean(ContentResolver.SYNC_EXTRAS_EXPEDITED, true);
        extras.putBoolean(ContentResolver.SYNC_EXTRAS_UPLOAD, true);
        ContentResolver.requestSync(mAccount, mAuthority, extras);
    }
    
}

