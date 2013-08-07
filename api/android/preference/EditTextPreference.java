package android.preference;

// Droidsafe Imports
import droidsafe.annotations.*;
import droidsafe.helpers.*;

import droidsafe.runtime.*;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;

public class EditTextPreference extends DialogPreference {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.083 -0400", hash_original_field = "2AB1BE4B6823B3E4EBFA67B16F6DBB6D", hash_generated_field = "586B4299BBF875661CEB2131396A9E01")

    private EditText mEditText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.084 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "2EBA23F479A3FA4159B4CC40D57E4F25")

    private String mText;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.088 -0400", hash_original_method = "1B48EB5F8CF3DC4D984298B6B0C90D10", hash_generated_method = "141BBDEE5930CEC402C841E62C580BF0")
    public  EditTextPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        mEditText = new EditText(context, attrs);
        mEditText.setId(com.android.internal.R.id.edit);
        mEditText.setEnabled(true);
        // ---------- Original Method ----------
        //mEditText = new EditText(context, attrs);
        //mEditText.setId(com.android.internal.R.id.edit);
        //mEditText.setEnabled(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.092 -0400", hash_original_method = "494CFEDBEF358096AFA1B35C2A3DFF6C", hash_generated_method = "8F84AFF71792B0D99CC4FDF64A961326")
    public  EditTextPreference(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.editTextPreferenceStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.096 -0400", hash_original_method = "204E2C5BC38780F40E54ECF3FAD0BB5A", hash_generated_method = "A6110716D094C1A6EEAE9E3257EA862E")
    public  EditTextPreference(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.099 -0400", hash_original_method = "CEF16EBC31082C193A3B95CCEE8E6067", hash_generated_method = "08798DA0F4FB40C12FA0493F975C5920")
    public void setText(String text) {
        final boolean wasBlocking = shouldDisableDependents();
        mText = text;
        persistString(text);
        final boolean isBlocking = shouldDisableDependents();
        if(isBlocking != wasBlocking)        
        {
            notifyDependencyChange(isBlocking);
        } //End block
        // ---------- Original Method ----------
        //final boolean wasBlocking = shouldDisableDependents();
        //mText = text;
        //persistString(text);
        //final boolean isBlocking = shouldDisableDependents();
        //if (isBlocking != wasBlocking) {
            //notifyDependencyChange(isBlocking);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.103 -0400", hash_original_method = "2FFFCC59A442EF1196B854805331F3A7", hash_generated_method = "78F0577AB1A805F183E32F1C6426A226")
    public String getText() {
String var7F7ECB4B14362FFBA020956966B29A66_931637996 =         mText;
        var7F7ECB4B14362FFBA020956966B29A66_931637996.addTaint(taint);
        return var7F7ECB4B14362FFBA020956966B29A66_931637996;
        // ---------- Original Method ----------
        //return mText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.107 -0400", hash_original_method = "D07B0890C399F21AD31B9014C9722593", hash_generated_method = "2E8257ED009A75E674824EAF80287BB1")
    @Override
    protected void onBindDialogView(View view) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(view.getTaint());
        super.onBindDialogView(view);
        EditText editText = mEditText;
        editText.setText(getText());
        ViewParent oldParent = editText.getParent();
        if(oldParent != view)        
        {
            if(oldParent != null)            
            {
                ((ViewGroup) oldParent).removeView(editText);
            } //End block
            onAddEditTextToDialogView(view, editText);
        } //End block
        // ---------- Original Method ----------
        //super.onBindDialogView(view);
        //EditText editText = mEditText;
        //editText.setText(getText());
        //ViewParent oldParent = editText.getParent();
        //if (oldParent != view) {
            //if (oldParent != null) {
                //((ViewGroup) oldParent).removeView(editText);
            //}
            //onAddEditTextToDialogView(view, editText);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.111 -0400", hash_original_method = "F11E8CFFE1E2D808987B2E38C68D609A", hash_generated_method = "19793DB2C12226F41D7D7E2A05006CE7")
    protected void onAddEditTextToDialogView(View dialogView, EditText editText) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(editText.getTaint());
        addTaint(dialogView.getTaint());
        ViewGroup container = (ViewGroup) dialogView
                .findViewById(com.android.internal.R.id.edittext_container);
        if(container != null)        
        {
            container.addView(editText, ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
        } //End block
        // ---------- Original Method ----------
        //ViewGroup container = (ViewGroup) dialogView
                //.findViewById(com.android.internal.R.id.edittext_container);
        //if (container != null) {
            //container.addView(editText, ViewGroup.LayoutParams.MATCH_PARENT,
                    //ViewGroup.LayoutParams.WRAP_CONTENT);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.115 -0400", hash_original_method = "72D88295ED5747003A75C3EC7A0816A7", hash_generated_method = "62B28E49042F5E300CB5CAF0CA1601E6")
    @Override
    protected void onDialogClosed(boolean positiveResult) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(positiveResult);
        super.onDialogClosed(positiveResult);
        if(positiveResult)        
        {
            String value = mEditText.getText().toString();
            if(callChangeListener(value))            
            {
                setText(value);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //super.onDialogClosed(positiveResult);
        //if (positiveResult) {
            //String value = mEditText.getText().toString();
            //if (callChangeListener(value)) {
                //setText(value);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.122 -0400", hash_original_method = "617E38A3300A64CD810B1ADC15B8238E", hash_generated_method = "F2531A065F0B40C2CF202DDB939A90CF")
    @Override
    protected Object onGetDefaultValue(TypedArray a, int index) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(index);
        addTaint(a.getTaint());
Object var0AC0FFFECD61C5D7F483CEEBDC224FAC_1016672297 =         a.getString(index);
        var0AC0FFFECD61C5D7F483CEEBDC224FAC_1016672297.addTaint(taint);
        return var0AC0FFFECD61C5D7F483CEEBDC224FAC_1016672297;
        // ---------- Original Method ----------
        //return a.getString(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.125 -0400", hash_original_method = "5BF4BAC56AB2C13ADD22317FD43163DE", hash_generated_method = "2A4F287573259A9E5010D7168EE4EBBA")
    @Override
    protected void onSetInitialValue(boolean restoreValue, Object defaultValue) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(defaultValue.getTaint());
        addTaint(restoreValue);
        setText(restoreValue ? getPersistedString(mText) : (String) defaultValue);
        // ---------- Original Method ----------
        //setText(restoreValue ? getPersistedString(mText) : (String) defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.129 -0400", hash_original_method = "F5D013C02C2861F04CB4C321BCA17B16", hash_generated_method = "92C034A43CCDBA0FE88002B0126CB30A")
    @Override
    public boolean shouldDisableDependents() {
        boolean var3A32CAC0B317F40942FB3620BF0001C5_256632952 = (TextUtils.isEmpty(mText) || super.shouldDisableDependents());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1518329072 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1518329072;
        // ---------- Original Method ----------
        //return TextUtils.isEmpty(mText) || super.shouldDisableDependents();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.131 -0400", hash_original_method = "25F3ADCBABEE77EF933107206F4A63FB", hash_generated_method = "B59C05E6184051797C41801947C0CF9B")
    public EditText getEditText() {
EditText var8A50566AD29B7D2AD5438781BF3A5FB4_773345932 =         mEditText;
        var8A50566AD29B7D2AD5438781BF3A5FB4_773345932.addTaint(taint);
        return var8A50566AD29B7D2AD5438781BF3A5FB4_773345932;
        // ---------- Original Method ----------
        //return mEditText;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.134 -0400", hash_original_method = "7FAD769054190EA8D5B257F9884DACB8", hash_generated_method = "77C53E8C3A8DADFF7BA567287754DD1F")
    @Override
    protected boolean needInputMethod() {
        boolean varB326B5062B2F0E69046810717534CB09_824786353 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_322005104 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_322005104;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.139 -0400", hash_original_method = "D74BC4DC00378E9BF3AD83FB4C28C295", hash_generated_method = "172BF784D046AC626274FFEF7DA3026D")
    @Override
    protected Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        final Parcelable superState = super.onSaveInstanceState();
        if(isPersistent())        
        {
Parcelable varBA7A3E641095ABD11C9DBE16D47F122C_21466936 =             superState;
            varBA7A3E641095ABD11C9DBE16D47F122C_21466936.addTaint(taint);
            return varBA7A3E641095ABD11C9DBE16D47F122C_21466936;
        } //End block
        final SavedState myState = new SavedState(superState);
        myState.text = getText();
Parcelable varA730247CC64767D7A83D25979CFF71FB_660847683 =         myState;
        varA730247CC64767D7A83D25979CFF71FB_660847683.addTaint(taint);
        return varA730247CC64767D7A83D25979CFF71FB_660847683;
        // ---------- Original Method ----------
        //final Parcelable superState = super.onSaveInstanceState();
        //if (isPersistent()) {
            //return superState;
        //}
        //final SavedState myState = new SavedState(superState);
        //myState.text = getText();
        //return myState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.145 -0400", hash_original_method = "FDF67462F1789AF80412C105807187A6", hash_generated_method = "E3D2F56C4CDE6490026C81D0342CAD28")
    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(state.getTaint());
        if(state == null || !state.getClass().equals(SavedState.class))        
        {
            super.onRestoreInstanceState(state);
            return;
        } //End block
        SavedState myState = (SavedState) state;
        super.onRestoreInstanceState(myState.getSuperState());
        setText(myState.text);
        // ---------- Original Method ----------
        //if (state == null || !state.getClass().equals(SavedState.class)) {
            //super.onRestoreInstanceState(state);
            //return;
        //}
        //SavedState myState = (SavedState) state;
        //super.onRestoreInstanceState(myState.getSuperState());
        //setText(myState.text);
    }

    
    private static class SavedState extends BaseSavedState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.149 -0400", hash_original_field = "1CB251EC0D568DE6A929B520C4AED8D1", hash_generated_field = "9EF4B8A5DE4B8BD37EE465C3BB62CC6C")

        String text;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.153 -0400", hash_original_method = "9235B16AEF1C4BC8E8C8B3CF552C8FA1", hash_generated_method = "638A08099505311B0010823A10F7B50D")
        public  SavedState(Parcel source) {
            super(source);
            text = source.readString();
            // ---------- Original Method ----------
            //text = source.readString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.155 -0400", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "AB11810075E98F66089A29D0DD89C4B4")
        public  SavedState(Parcelable superState) {
            super(superState);
            addTaint(superState.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.157 -0400", hash_original_method = "A36EF7056AEE816C6C1E1134145BD2DB", hash_generated_method = "2E819E5C16AA9831AEB0D9E76D2822A5")
        @Override
        public void writeToParcel(Parcel dest, int flags) {
            addTaint(flags);
            addTaint(dest.getTaint());
            super.writeToParcel(dest, flags);
            dest.writeString(text);
            // ---------- Original Method ----------
            //super.writeToParcel(dest, flags);
            //dest.writeString(text);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.159 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

        public static final Parcelable.Creator<SavedState> CREATOR =
                new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
    }


    
}

