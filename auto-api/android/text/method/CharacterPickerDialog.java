package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.R;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.*;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

public class CharacterPickerDialog extends Dialog implements OnItemClickListener, OnClickListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.083 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "E606D96B6FC531BB030B680E135C95D0")

    private View mView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.083 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "4D56A7421E5A9A046126DAEE3F2ADC1F")

    private Editable mText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.083 -0400", hash_original_field = "105589D648A274CCDDF1FDF6715B56D8", hash_generated_field = "C4E4EFD2F278AF0CA31B4D2B65C0BA3F")

    private String mOptions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.083 -0400", hash_original_field = "3E34F7598213CF269B3FEBC4E6B813DD", hash_generated_field = "2F18391B0FEF3A9AD8385744A3286F25")

    private boolean mInsert;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.083 -0400", hash_original_field = "D03597FDEDE23F3823480E0520822BB2", hash_generated_field = "CBB0EE0A851756643DA52E1D33B6B161")

    private LayoutInflater mInflater;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.083 -0400", hash_original_field = "3351AD49475624461A9BF79E94A4220C", hash_generated_field = "ABAA2B18FA7C6BED1CB3E1E533F796CB")

    private Button mCancelButton;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.083 -0400", hash_original_method = "B85B2CE2D9925643AD72FE26FAC534DC", hash_generated_method = "5B1A2735870F24FE62447B6CF58004A1")
    public  CharacterPickerDialog(Context context, View view,
                                 Editable text, String options,
                                 boolean insert) {
        super(context, com.android.internal.R.style.Theme_Panel);
        mView = view;
        mText = text;
        mOptions = options;
        mInsert = insert;
        mInflater = LayoutInflater.from(context);
        // ---------- Original Method ----------
        //mView = view;
        //mText = text;
        //mOptions = options;
        //mInsert = insert;
        //mInflater = LayoutInflater.from(context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.084 -0400", hash_original_method = "E0AAB102B3ED3AF261F94C84219E8ECE", hash_generated_method = "3CFD387C5C84150EFA47D38FE1258ED5")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onCreate(savedInstanceState);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.token = mView.getApplicationWindowToken();
        params.type = params.TYPE_APPLICATION_ATTACHED_DIALOG;
        params.flags = params.flags | Window.FEATURE_NO_TITLE;
        setContentView(R.layout.character_picker);
        GridView grid = (GridView) findViewById(R.id.characterPicker);
        grid.setAdapter(new OptionsAdapter(getContext()));
        grid.setOnItemClickListener(this);
        mCancelButton = (Button) findViewById(R.id.cancel);
        mCancelButton.setOnClickListener(this);
        addTaint(savedInstanceState.getTaint());
        // ---------- Original Method ----------
        //super.onCreate(savedInstanceState);
        //WindowManager.LayoutParams params = getWindow().getAttributes();
        //params.token = mView.getApplicationWindowToken();
        //params.type = params.TYPE_APPLICATION_ATTACHED_DIALOG;
        //params.flags = params.flags | Window.FEATURE_NO_TITLE;
        //setContentView(R.layout.character_picker);
        //GridView grid = (GridView) findViewById(R.id.characterPicker);
        //grid.setAdapter(new OptionsAdapter(getContext()));
        //grid.setOnItemClickListener(this);
        //mCancelButton = (Button) findViewById(R.id.cancel);
        //mCancelButton.setOnClickListener(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.084 -0400", hash_original_method = "EEFA1E961CDBB58662ABBCDF41F1AD2A", hash_generated_method = "B2C8704C8BC425A022D457DFA050AB64")
    public void onItemClick(AdapterView parent, View view, int position, long id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        String result = String.valueOf(mOptions.charAt(position));
        replaceCharacterAndClose(result);
        addTaint(parent.getTaint());
        addTaint(view.getTaint());
        addTaint(position);
        addTaint(id);
        // ---------- Original Method ----------
        //String result = String.valueOf(mOptions.charAt(position));
        //replaceCharacterAndClose(result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.085 -0400", hash_original_method = "889637D7E351CCF8A657470FC2914F00", hash_generated_method = "8B307DCEB8332CCF830AE73C36AB5053")
    private void replaceCharacterAndClose(CharSequence replace) {
        int selEnd = Selection.getSelectionEnd(mText);
        {
            mText.insert(selEnd, replace);
        } //End block
        {
            mText.replace(selEnd - 1, selEnd, replace);
        } //End block
        dismiss();
        addTaint(replace.getTaint());
        // ---------- Original Method ----------
        //int selEnd = Selection.getSelectionEnd(mText);
        //if (mInsert || selEnd == 0) {
            //mText.insert(selEnd, replace);
        //} else {
            //mText.replace(selEnd - 1, selEnd, replace);
        //}
        //dismiss();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.085 -0400", hash_original_method = "3104127334A31B48E0F0795A4514B3FB", hash_generated_method = "1E4080BAD5AACFC165208D6FA7CFB129")
    public void onClick(View v) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            dismiss();
        } //End block
        {
            CharSequence result = ((Button) v).getText();
            replaceCharacterAndClose(result);
        } //End block
        addTaint(v.getTaint());
        // ---------- Original Method ----------
        //if (v == mCancelButton) {
            //dismiss();
        //} else if (v instanceof Button) {
            //CharSequence result = ((Button) v).getText();
            //replaceCharacterAndClose(result);
        //}
    }

    
    private class OptionsAdapter extends BaseAdapter {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.086 -0400", hash_original_method = "AC698511382015922DCBD4CE64D2CC39", hash_generated_method = "4CB448F3AC319182556080A4A7EEB149")
        public  OptionsAdapter(Context context) {
            super();
            addTaint(context.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.087 -0400", hash_original_method = "2F3D5346969689C1B0E524EA0F83CDB3", hash_generated_method = "EB08B7BDD7EE78590B52EB5FDD2FA902")
        public View getView(int position, View convertView, ViewGroup parent) {
            View varB4EAC82CA7396A68D541C85D26508E83_710551471 = null; //Variable for return #1
            Button b = (Button)
                mInflater.inflate(R.layout.character_picker_button, null);
            b.setText(String.valueOf(mOptions.charAt(position)));
            b.setOnClickListener(CharacterPickerDialog.this);
            varB4EAC82CA7396A68D541C85D26508E83_710551471 = b;
            addTaint(position);
            addTaint(convertView.getTaint());
            addTaint(parent.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_710551471.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_710551471;
            // ---------- Original Method ----------
            //Button b = (Button)
                //mInflater.inflate(R.layout.character_picker_button, null);
            //b.setText(String.valueOf(mOptions.charAt(position)));
            //b.setOnClickListener(CharacterPickerDialog.this);
            //return b;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.087 -0400", hash_original_method = "DE59A8E1295F8E334D75F62942CFDC7D", hash_generated_method = "6BB4E030F55B1286B8F1D902670E99AD")
        public final int getCount() {
            int var26AF6CEC60F9F491B249EA13D65F516B_1072528554 = (mOptions.length());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_559467940 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_559467940;
            // ---------- Original Method ----------
            //return mOptions.length();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.088 -0400", hash_original_method = "8B0C0E62DBC532F544A3C62A19BF4060", hash_generated_method = "A3B106C4386A9BCD4838805BD2378763")
        public final Object getItem(int position) {
            Object varB4EAC82CA7396A68D541C85D26508E83_1089074894 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1089074894 = String.valueOf(mOptions.charAt(position));
            addTaint(position);
            varB4EAC82CA7396A68D541C85D26508E83_1089074894.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1089074894;
            // ---------- Original Method ----------
            //return String.valueOf(mOptions.charAt(position));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.088 -0400", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "74DE7E56591FC1D605CEF494E2AF67E2")
        public final long getItemId(int position) {
            addTaint(position);
            long var0F5264038205EDFB1AC05FBB0E8C5E94_771049828 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_771049828;
            // ---------- Original Method ----------
            //return position;
        }

        
    }


    
}

