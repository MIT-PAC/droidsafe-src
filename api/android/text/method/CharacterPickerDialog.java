package android.text.method;

// Droidsafe Imports
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

import com.android.internal.R;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class CharacterPickerDialog extends Dialog implements OnItemClickListener, OnClickListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.159 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "E606D96B6FC531BB030B680E135C95D0")

    private View mView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.159 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "4D56A7421E5A9A046126DAEE3F2ADC1F")

    private Editable mText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.161 -0400", hash_original_field = "105589D648A274CCDDF1FDF6715B56D8", hash_generated_field = "C4E4EFD2F278AF0CA31B4D2B65C0BA3F")

    private String mOptions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.161 -0400", hash_original_field = "3E34F7598213CF269B3FEBC4E6B813DD", hash_generated_field = "2F18391B0FEF3A9AD8385744A3286F25")

    private boolean mInsert;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.161 -0400", hash_original_field = "D03597FDEDE23F3823480E0520822BB2", hash_generated_field = "CBB0EE0A851756643DA52E1D33B6B161")

    private LayoutInflater mInflater;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.161 -0400", hash_original_field = "3351AD49475624461A9BF79E94A4220C", hash_generated_field = "ABAA2B18FA7C6BED1CB3E1E533F796CB")

    private Button mCancelButton;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.167 -0400", hash_original_method = "B85B2CE2D9925643AD72FE26FAC534DC", hash_generated_method = "5B1A2735870F24FE62447B6CF58004A1")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.168 -0400", hash_original_method = "E0AAB102B3ED3AF261F94C84219E8ECE", hash_generated_method = "1E82034CB2BEE30118EE08B066C35E97")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(savedInstanceState.getTaint());
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.169 -0400", hash_original_method = "EEFA1E961CDBB58662ABBCDF41F1AD2A", hash_generated_method = "170B01C4C4FF962B5E92C6E55F29F411")
    public void onItemClick(AdapterView parent, View view, int position, long id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(id);
        addTaint(position);
        addTaint(view.getTaint());
        addTaint(parent.getTaint());
        String result = String.valueOf(mOptions.charAt(position));
        replaceCharacterAndClose(result);
        // ---------- Original Method ----------
        //String result = String.valueOf(mOptions.charAt(position));
        //replaceCharacterAndClose(result);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.169 -0400", hash_original_method = "889637D7E351CCF8A657470FC2914F00", hash_generated_method = "2C0F226862C0876664AAF28FB22531CB")
    private void replaceCharacterAndClose(CharSequence replace) {
        addTaint(replace.getTaint());
        int selEnd = Selection.getSelectionEnd(mText);
        if(mInsert || selEnd == 0)        
        {
            mText.insert(selEnd, replace);
        } //End block
        else
        {
            mText.replace(selEnd - 1, selEnd, replace);
        } //End block
        dismiss();
        // ---------- Original Method ----------
        //int selEnd = Selection.getSelectionEnd(mText);
        //if (mInsert || selEnd == 0) {
            //mText.insert(selEnd, replace);
        //} else {
            //mText.replace(selEnd - 1, selEnd, replace);
        //}
        //dismiss();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.169 -0400", hash_original_method = "3104127334A31B48E0F0795A4514B3FB", hash_generated_method = "53A278E2106857ED38FA4656E65A914A")
    public void onClick(View v) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(v.getTaint());
        if(v == mCancelButton)        
        {
            dismiss();
        } //End block
        else
        if(v instanceof Button)        
        {
            CharSequence result = ((Button) v).getText();
            replaceCharacterAndClose(result);
        } //End block
        // ---------- Original Method ----------
        //if (v == mCancelButton) {
            //dismiss();
        //} else if (v instanceof Button) {
            //CharSequence result = ((Button) v).getText();
            //replaceCharacterAndClose(result);
        //}
    }

    
    private class OptionsAdapter extends BaseAdapter {
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.170 -0400", hash_original_method = "AC698511382015922DCBD4CE64D2CC39", hash_generated_method = "4CB448F3AC319182556080A4A7EEB149")
        public  OptionsAdapter(Context context) {
            super();
            addTaint(context.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.170 -0400", hash_original_method = "2F3D5346969689C1B0E524EA0F83CDB3", hash_generated_method = "67825FE576A49ABA8A23D5DFB1FF499D")
        public View getView(int position, View convertView, ViewGroup parent) {
            addTaint(parent.getTaint());
            addTaint(convertView.getTaint());
            addTaint(position);
            Button b = (Button)
                mInflater.inflate(R.layout.character_picker_button, null);
            b.setText(String.valueOf(mOptions.charAt(position)));
            b.setOnClickListener(CharacterPickerDialog.this);
View var73F89FAC8F369DF0913D10C37C1E0EA1_1981619032 =             b;
            var73F89FAC8F369DF0913D10C37C1E0EA1_1981619032.addTaint(taint);
            return var73F89FAC8F369DF0913D10C37C1E0EA1_1981619032;
            // ---------- Original Method ----------
            //Button b = (Button)
                //mInflater.inflate(R.layout.character_picker_button, null);
            //b.setText(String.valueOf(mOptions.charAt(position)));
            //b.setOnClickListener(CharacterPickerDialog.this);
            //return b;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.170 -0400", hash_original_method = "DE59A8E1295F8E334D75F62942CFDC7D", hash_generated_method = "C19C921F45A2F951C325B20250D2E739")
        public final int getCount() {
            int varEA81FFBB75952D26DCB258293ABA8690_1709994060 = (mOptions.length());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1681048471 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1681048471;
            // ---------- Original Method ----------
            //return mOptions.length();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.170 -0400", hash_original_method = "8B0C0E62DBC532F544A3C62A19BF4060", hash_generated_method = "C1B7DF46DCB8BB17ED6EE06FD9AAE2FE")
        public final Object getItem(int position) {
            addTaint(position);
Object var87AE1E24DC46164AD61DEEB89268C372_494025095 =             String.valueOf(mOptions.charAt(position));
            var87AE1E24DC46164AD61DEEB89268C372_494025095.addTaint(taint);
            return var87AE1E24DC46164AD61DEEB89268C372_494025095;
            // ---------- Original Method ----------
            //return String.valueOf(mOptions.charAt(position));
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.171 -0400", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "0770264674DC77A707E9BE8D97F885B7")
        public final long getItemId(int position) {
            addTaint(position);
            long var4757FE07FD492A8BE0EA6A760D683D6E_1697009686 = (position);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_296161568 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_296161568;
            // ---------- Original Method ----------
            //return position;
        }

        
    }


    
}

