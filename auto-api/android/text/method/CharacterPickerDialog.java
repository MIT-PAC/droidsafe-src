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
    private View mView;
    private Editable mText;
    private String mOptions;
    private boolean mInsert;
    private LayoutInflater mInflater;
    private Button mCancelButton;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.234 -0400", hash_original_method = "B85B2CE2D9925643AD72FE26FAC534DC", hash_generated_method = "D47D2601D917EB165A9B77365927AC9C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharacterPickerDialog(Context context, View view,
                                 Editable text, String options,
                                 boolean insert) {
        super(context, com.android.internal.R.style.Theme_Panel);
        dsTaint.addTaint(text.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        dsTaint.addTaint(insert);
        dsTaint.addTaint(options);
        mInflater = LayoutInflater.from(context);
        // ---------- Original Method ----------
        //mView = view;
        //mText = text;
        //mOptions = options;
        //mInsert = insert;
        //mInflater = LayoutInflater.from(context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.235 -0400", hash_original_method = "E0AAB102B3ED3AF261F94C84219E8ECE", hash_generated_method = "1A84563D1780CC3EC2C22E943B0A9355")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(savedInstanceState.dsTaint);
        super.onCreate(savedInstanceState);
        WindowManager.LayoutParams params;
        params = getWindow().getAttributes();
        params.token = mView.getApplicationWindowToken();
        params.type = params.TYPE_APPLICATION_ATTACHED_DIALOG;
        params.flags = params.flags | Window.FEATURE_NO_TITLE;
        setContentView(R.layout.character_picker);
        GridView grid;
        grid = (GridView) findViewById(R.id.characterPicker);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.236 -0400", hash_original_method = "EEFA1E961CDBB58662ABBCDF41F1AD2A", hash_generated_method = "B1BFF422E30E0BA0633FC7A5D4B8DF4A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onItemClick(AdapterView parent, View view, int position, long id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(id);
        dsTaint.addTaint(position);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        String result;
        result = String.valueOf(mOptions.charAt(position));
        replaceCharacterAndClose(result);
        // ---------- Original Method ----------
        //String result = String.valueOf(mOptions.charAt(position));
        //replaceCharacterAndClose(result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.237 -0400", hash_original_method = "889637D7E351CCF8A657470FC2914F00", hash_generated_method = "AE68A56F42CAAC40956D001A1AAF8DE6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void replaceCharacterAndClose(CharSequence replace) {
        dsTaint.addTaint(replace);
        int selEnd;
        selEnd = Selection.getSelectionEnd(mText);
        {
            mText.insert(selEnd, replace);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.238 -0400", hash_original_method = "3104127334A31B48E0F0795A4514B3FB", hash_generated_method = "8D14E5868F771DCBB1D21A53C7C505A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onClick(View v) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(v.dsTaint);
        {
            dismiss();
        } //End block
        {
            CharSequence result;
            result = ((Button) v).getText();
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.245 -0400", hash_original_method = "AC698511382015922DCBD4CE64D2CC39", hash_generated_method = "C42AE62BCAE1CB862C07626D2FBE18BA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public OptionsAdapter(Context context) {
            super();
            dsTaint.addTaint(context.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.246 -0400", hash_original_method = "2F3D5346969689C1B0E524EA0F83CDB3", hash_generated_method = "FFB75A53E859C8830687D14D8478C0BE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public View getView(int position, View convertView, ViewGroup parent) {
            dsTaint.addTaint(position);
            dsTaint.addTaint(parent.dsTaint);
            dsTaint.addTaint(convertView.dsTaint);
            Button b;
            b = (Button)
                mInflater.inflate(R.layout.character_picker_button, null);
            b.setText(String.valueOf(mOptions.charAt(position)));
            b.setOnClickListener(CharacterPickerDialog.this);
            return (View)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Button b = (Button)
                //mInflater.inflate(R.layout.character_picker_button, null);
            //b.setText(String.valueOf(mOptions.charAt(position)));
            //b.setOnClickListener(CharacterPickerDialog.this);
            //return b;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.246 -0400", hash_original_method = "DE59A8E1295F8E334D75F62942CFDC7D", hash_generated_method = "29B00354D3744D406547BEBDA4EF9272")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final int getCount() {
            int var26AF6CEC60F9F491B249EA13D65F516B_167922636 = (mOptions.length());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mOptions.length();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.247 -0400", hash_original_method = "8B0C0E62DBC532F544A3C62A19BF4060", hash_generated_method = "86790785CC747A4E0879C7F343946C98")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final Object getItem(int position) {
            dsTaint.addTaint(position);
            Object var975C316FBC4C6526F9673CE4271E7723_1331058910 = (String.valueOf(mOptions.charAt(position)));
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return String.valueOf(mOptions.charAt(position));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.247 -0400", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "8433394FD59634E17492FFF1CF9A28F0")
        @DSModeled(DSC.SAFE)
        public final long getItemId(int position) {
            dsTaint.addTaint(position);
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //return position;
        }

        
    }


    
}

