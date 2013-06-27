package android.preference;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.294 -0400", hash_original_field = "2AB1BE4B6823B3E4EBFA67B16F6DBB6D", hash_generated_field = "586B4299BBF875661CEB2131396A9E01")

    private EditText mEditText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.294 -0400", hash_original_field = "39624508B9E3028D8A5DDA741D3E3DDE", hash_generated_field = "2EBA23F479A3FA4159B4CC40D57E4F25")

    private String mText;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.296 -0400", hash_original_method = "1B48EB5F8CF3DC4D984298B6B0C90D10", hash_generated_method = "9C8ACC8DA4F9DB29C5C780D2AE6D59EE")
    public  EditTextPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mEditText = new EditText(context, attrs);
        mEditText.setId(com.android.internal.R.id.edit);
        mEditText.setEnabled(true);
        addTaint(defStyle);
        // ---------- Original Method ----------
        //mEditText = new EditText(context, attrs);
        //mEditText.setId(com.android.internal.R.id.edit);
        //mEditText.setEnabled(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.305 -0400", hash_original_method = "494CFEDBEF358096AFA1B35C2A3DFF6C", hash_generated_method = "B5B502155FD74A28D5C31CE262A63AFD")
    public  EditTextPreference(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.editTextPreferenceStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.305 -0400", hash_original_method = "204E2C5BC38780F40E54ECF3FAD0BB5A", hash_generated_method = "A6110716D094C1A6EEAE9E3257EA862E")
    public  EditTextPreference(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.317 -0400", hash_original_method = "CEF16EBC31082C193A3B95CCEE8E6067", hash_generated_method = "7CE7BEA055A8CD9626976AEB4514B659")
    public void setText(String text) {
        boolean wasBlocking;
        wasBlocking = shouldDisableDependents();
        mText = text;
        persistString(text);
        boolean isBlocking;
        isBlocking = shouldDisableDependents();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.318 -0400", hash_original_method = "2FFFCC59A442EF1196B854805331F3A7", hash_generated_method = "FB67B1FD24B469FD3491950DC2D758B6")
    public String getText() {
        String varB4EAC82CA7396A68D541C85D26508E83_889299995 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_889299995 = mText;
        varB4EAC82CA7396A68D541C85D26508E83_889299995.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_889299995;
        // ---------- Original Method ----------
        //return mText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.319 -0400", hash_original_method = "D07B0890C399F21AD31B9014C9722593", hash_generated_method = "8569BC64CB922D9F0E7C1A4117E14D8E")
    @Override
    protected void onBindDialogView(View view) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onBindDialogView(view);
        EditText editText;
        editText = mEditText;
        editText.setText(getText());
        ViewParent oldParent;
        oldParent = editText.getParent();
        {
            {
                ((ViewGroup) oldParent).removeView(editText);
            } //End block
            onAddEditTextToDialogView(view, editText);
        } //End block
        addTaint(view.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.337 -0400", hash_original_method = "F11E8CFFE1E2D808987B2E38C68D609A", hash_generated_method = "BDF066ABE58DF8E42FEDA183BE731C4A")
    protected void onAddEditTextToDialogView(View dialogView, EditText editText) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        ViewGroup container;
        container = (ViewGroup) dialogView
                .findViewById(com.android.internal.R.id.edittext_container);
        {
            container.addView(editText, ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
        } //End block
        addTaint(dialogView.getTaint());
        addTaint(editText.getTaint());
        // ---------- Original Method ----------
        //ViewGroup container = (ViewGroup) dialogView
                //.findViewById(com.android.internal.R.id.edittext_container);
        //if (container != null) {
            //container.addView(editText, ViewGroup.LayoutParams.MATCH_PARENT,
                    //ViewGroup.LayoutParams.WRAP_CONTENT);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.338 -0400", hash_original_method = "72D88295ED5747003A75C3EC7A0816A7", hash_generated_method = "83AAE3740B0A7D6C9ABA9E4AAA350FD4")
    @Override
    protected void onDialogClosed(boolean positiveResult) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDialogClosed(positiveResult);
        {
            String value;
            value = mEditText.getText().toString();
            {
                boolean var48E48921DA53707F97C7F6D085D7ADDB_1518119530 = (callChangeListener(value));
                {
                    setText(value);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(positiveResult);
        // ---------- Original Method ----------
        //super.onDialogClosed(positiveResult);
        //if (positiveResult) {
            //String value = mEditText.getText().toString();
            //if (callChangeListener(value)) {
                //setText(value);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.339 -0400", hash_original_method = "617E38A3300A64CD810B1ADC15B8238E", hash_generated_method = "8F6F5407642E6F77F60FF94DE2450CF2")
    @Override
    protected Object onGetDefaultValue(TypedArray a, int index) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Object varB4EAC82CA7396A68D541C85D26508E83_812987803 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_812987803 = a.getString(index);
        addTaint(a.getTaint());
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_812987803.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_812987803;
        // ---------- Original Method ----------
        //return a.getString(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.339 -0400", hash_original_method = "5BF4BAC56AB2C13ADD22317FD43163DE", hash_generated_method = "36C43A0C50DD9D5074DC15C6ADF2FFD8")
    @Override
    protected void onSetInitialValue(boolean restoreValue, Object defaultValue) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        setText(restoreValue ? getPersistedString(mText) : (String) defaultValue);
        addTaint(restoreValue);
        addTaint(defaultValue.getTaint());
        // ---------- Original Method ----------
        //setText(restoreValue ? getPersistedString(mText) : (String) defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.356 -0400", hash_original_method = "F5D013C02C2861F04CB4C321BCA17B16", hash_generated_method = "5D721E2919DE3CBDB6AC06FE95FA62C7")
    @Override
    public boolean shouldDisableDependents() {
        boolean varCB5373E5EBBD696F207E1076E22918F0_2015768768 = (TextUtils.isEmpty(mText) || super.shouldDisableDependents());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1354073900 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1354073900;
        // ---------- Original Method ----------
        //return TextUtils.isEmpty(mText) || super.shouldDisableDependents();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.361 -0400", hash_original_method = "25F3ADCBABEE77EF933107206F4A63FB", hash_generated_method = "44F70CD73AE437B008E57CC8CAFCC5E5")
    public EditText getEditText() {
        EditText varB4EAC82CA7396A68D541C85D26508E83_1977840179 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1977840179 = mEditText;
        varB4EAC82CA7396A68D541C85D26508E83_1977840179.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1977840179;
        // ---------- Original Method ----------
        //return mEditText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.362 -0400", hash_original_method = "7FAD769054190EA8D5B257F9884DACB8", hash_generated_method = "3D38FE9B019D5244DE864C1E9B13ABC3")
    @Override
    protected boolean needInputMethod() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1472916392 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1472916392;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.370 -0400", hash_original_method = "D74BC4DC00378E9BF3AD83FB4C28C295", hash_generated_method = "263D5E7C84C49238C74ED69F4C341E5C")
    @Override
    protected Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_1788116923 = null; //Variable for return #1
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_1150631160 = null; //Variable for return #2
        Parcelable superState;
        superState = super.onSaveInstanceState();
        {
            boolean varA5BC476CED9D472D4630C0C0B6120523_1586008003 = (isPersistent());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1788116923 = superState;
            } //End block
        } //End collapsed parenthetic
        SavedState myState;
        myState = new SavedState(superState);
        myState.text = getText();
        varB4EAC82CA7396A68D541C85D26508E83_1150631160 = myState;
        Parcelable varA7E53CE21691AB073D9660D615818899_881137316; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_881137316 = varB4EAC82CA7396A68D541C85D26508E83_1788116923;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_881137316 = varB4EAC82CA7396A68D541C85D26508E83_1150631160;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_881137316.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_881137316;
        // ---------- Original Method ----------
        //final Parcelable superState = super.onSaveInstanceState();
        //if (isPersistent()) {
            //return superState;
        //}
        //final SavedState myState = new SavedState(superState);
        //myState.text = getText();
        //return myState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.371 -0400", hash_original_method = "FDF67462F1789AF80412C105807187A6", hash_generated_method = "6965A23A822CB249BF98E7E3462FC72A")
    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var9146082C23BCEB2285F1054C3B9F84EE_1489435142 = (state == null || !state.getClass().equals(SavedState.class));
            {
                super.onRestoreInstanceState(state);
            } //End block
        } //End collapsed parenthetic
        SavedState myState;
        myState = (SavedState) state;
        super.onRestoreInstanceState(myState.getSuperState());
        setText(myState.text);
        addTaint(state.getTaint());
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.371 -0400", hash_original_field = "1CB251EC0D568DE6A929B520C4AED8D1", hash_generated_field = "9EF4B8A5DE4B8BD37EE465C3BB62CC6C")

        String text;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.372 -0400", hash_original_method = "9235B16AEF1C4BC8E8C8B3CF552C8FA1", hash_generated_method = "638A08099505311B0010823A10F7B50D")
        public  SavedState(Parcel source) {
            super(source);
            text = source.readString();
            // ---------- Original Method ----------
            //text = source.readString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.372 -0400", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "AB11810075E98F66089A29D0DD89C4B4")
        public  SavedState(Parcelable superState) {
            super(superState);
            addTaint(superState.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.386 -0400", hash_original_method = "A36EF7056AEE816C6C1E1134145BD2DB", hash_generated_method = "97623166751F91E9CA64580982E11C63")
        @Override
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeString(text);
            addTaint(dest.getTaint());
            addTaint(flags);
            // ---------- Original Method ----------
            //super.writeToParcel(dest, flags);
            //dest.writeString(text);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.387 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

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

