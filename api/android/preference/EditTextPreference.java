
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.684 -0500", hash_original_field = "A9B59832B2888AF35E1650CB0335B219", hash_generated_field = "586B4299BBF875661CEB2131396A9E01")

    private EditText mEditText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.686 -0500", hash_original_field = "5C1E1D7AA24FFCA320ADE83B66FB0AC4", hash_generated_field = "2EBA23F479A3FA4159B4CC40D57E4F25")
    
    private String mText;
    
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.689 -0500", hash_original_method = "1B48EB5F8CF3DC4D984298B6B0C90D10", hash_generated_method = "EC83FFC623BCAF07BB1299D8A9A0BF9D")
    
public EditTextPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        
        mEditText = new EditText(context, attrs);
        
        // Give it an ID so it can be saved/restored
        mEditText.setId(com.android.internal.R.id.edit);
        
        /*
         * The preference framework and view framework both have an 'enabled'
         * attribute. Most likely, the 'enabled' specified in this XML is for
         * the preference framework, but it was also given to the view framework.
         * We reset the enabled state.
         */
        mEditText.setEnabled(true);
    }

    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.691 -0500", hash_original_method = "494CFEDBEF358096AFA1B35C2A3DFF6C", hash_generated_method = "B52031657C6FBCA2718CF1E7C2477B6C")
    
public EditTextPreference(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.editTextPreferenceStyle);
    }

    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.694 -0500", hash_original_method = "204E2C5BC38780F40E54ECF3FAD0BB5A", hash_generated_method = "9016449D056F9E4AD532EC1E9337FFE1")
    
public EditTextPreference(Context context) {
        this(context, null);
    }
    
    /**
     * Saves the text to the {@link SharedPreferences}.
     * 
     * @param text The text to save
     */
    @DSComment("Persists text to disk")
    @DSSpec(DSCat.SPEC_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.696 -0500", hash_original_method = "CEF16EBC31082C193A3B95CCEE8E6067", hash_generated_method = "61C2AD4A3938034FD3E8FC91B0853EB0")
   @DSVerified 
public void setText(String text) {
        final boolean wasBlocking = shouldDisableDependents();
        
        mText = text;
        
        persistString(text);
        
        final boolean isBlocking = shouldDisableDependents(); 
        if (isBlocking != wasBlocking) {
            notifyDependencyChange(isBlocking);
        }
    }
    
    /**
     * Gets the text from the {@link SharedPreferences}.
     * 
     * @return The current preference value.
     */
    @DSComment("Perference UI, only change preference is spec")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.698 -0500", hash_original_method = "2FFFCC59A442EF1196B854805331F3A7", hash_generated_method = "7675B56A832FA6E1A4872CB2A7C75222")
    
public String getText() {
        return mText;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.701 -0500", hash_original_method = "D07B0890C399F21AD31B9014C9722593", hash_generated_method = "4BF2E8F6B1A0E651BB9C758014DA42D0")
    
@Override
    protected void onBindDialogView(View view) {
        super.onBindDialogView(view);

        EditText editText = mEditText;
        editText.setText(getText());
        
        ViewParent oldParent = editText.getParent();
        if (oldParent != view) {
            if (oldParent != null) {
                ((ViewGroup) oldParent).removeView(editText);
            }
            onAddEditTextToDialogView(view, editText);
        }
    }

    /**
     * Adds the EditText widget of this preference to the dialog's view.
     * 
     * @param dialogView The dialog view.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.703 -0500", hash_original_method = "F11E8CFFE1E2D808987B2E38C68D609A", hash_generated_method = "3D283D46B7B460AB16F48E80CAA027C2")
    
protected void onAddEditTextToDialogView(View dialogView, EditText editText) {
        ViewGroup container = (ViewGroup) dialogView
                .findViewById(com.android.internal.R.id.edittext_container);
        if (container != null) {
            container.addView(editText, ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.705 -0500", hash_original_method = "72D88295ED5747003A75C3EC7A0816A7", hash_generated_method = "672C4E9ABE56C73C368FA7637B485EF8")
    
@Override
    protected void onDialogClosed(boolean positiveResult) {
        super.onDialogClosed(positiveResult);
        
        if (positiveResult) {
            String value = mEditText.getText().toString();
            if (callChangeListener(value)) {
                setText(value);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.707 -0500", hash_original_method = "617E38A3300A64CD810B1ADC15B8238E", hash_generated_method = "497DF6D525CC8FE96585CAFDDA47A41E")
    
@Override
    protected Object onGetDefaultValue(TypedArray a, int index) {
        return a.getString(index);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.710 -0500", hash_original_method = "5BF4BAC56AB2C13ADD22317FD43163DE", hash_generated_method = "322E7D87A685480504218306C497ED95")
    
@Override
    protected void onSetInitialValue(boolean restoreValue, Object defaultValue) {
        setText(restoreValue ? getPersistedString(mText) : (String) defaultValue);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.712 -0500", hash_original_method = "F5D013C02C2861F04CB4C321BCA17B16", hash_generated_method = "5908363E36D2B1DB6BFF003809EBDD3E")
    
@Override
    public boolean shouldDisableDependents() {
        return TextUtils.isEmpty(mText) || super.shouldDisableDependents();
    }

    /**
     * Returns the {@link EditText} widget that will be shown in the dialog.
     * 
     * @return The {@link EditText} widget that will be shown in the dialog.
     */
    @DSComment("Perference UI, only change preference is spec")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.714 -0500", hash_original_method = "25F3ADCBABEE77EF933107206F4A63FB", hash_generated_method = "599AA86E6466590D2AF3F8CF2247EF7E")
    
public EditText getEditText() {
        return mEditText;
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.716 -0500", hash_original_method = "7FAD769054190EA8D5B257F9884DACB8", hash_generated_method = "9F4B76E5EFA8DFE24CF7F1AF0C8E62F4")
    
@Override
    protected boolean needInputMethod() {
        // We want the input method to show, if possible, when dialog is displayed
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.719 -0500", hash_original_method = "D74BC4DC00378E9BF3AD83FB4C28C295", hash_generated_method = "3891E3C211252A2F460A670B835B6188")
    
@Override
    protected Parcelable onSaveInstanceState() {
        final Parcelable superState = super.onSaveInstanceState();
        if (isPersistent()) {
            // No need to save instance state since it's persistent
            return superState;
        }
        
        final SavedState myState = new SavedState(superState);
        myState.text = getText();
        return myState;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.722 -0500", hash_original_method = "FDF67462F1789AF80412C105807187A6", hash_generated_method = "E02B0C4D3919AFA95EC4AD6A390902C7")
    
@Override
    protected void onRestoreInstanceState(Parcelable state) {
        if (state == null || !state.getClass().equals(SavedState.class)) {
            // Didn't save state for us in onSaveInstanceState
            super.onRestoreInstanceState(state);
            return;
        }
         
        SavedState myState = (SavedState) state;
        super.onRestoreInstanceState(myState.getSuperState());
        setText(myState.text);
    }
    
    private static class SavedState extends BaseSavedState {
        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.159 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

        public static final Parcelable.Creator<SavedState> CREATOR =
                new Parcelable.Creator<SavedState>() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.735 -0500", hash_original_method = "E26812089C072DDE1A14AECAA6CD6686", hash_generated_method = "C97AA17CB243756458D0FB7A2D786EA0")
            
public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.737 -0500", hash_original_method = "2D31E9CBAAAE05B696D738324F87FF78", hash_generated_method = "020465B62F970B98C266AF229149E391")
            
public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.724 -0500", hash_original_field = "9EF4B8A5DE4B8BD37EE465C3BB62CC6C", hash_generated_field = "9EF4B8A5DE4B8BD37EE465C3BB62CC6C")

        String text;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.727 -0500", hash_original_method = "9235B16AEF1C4BC8E8C8B3CF552C8FA1", hash_generated_method = "556D2E14C1EBBB03E15B32D810487FD4")
        
public SavedState(Parcel source) {
            super(source);
            text = source.readString();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.732 -0500", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "E32D4593A5A22DE64D4F3221E06324D4")
        
public SavedState(Parcelable superState) {
            super(superState);
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.729 -0500", hash_original_method = "A36EF7056AEE816C6C1E1134145BD2DB", hash_generated_method = "EFD6D0E27E147449B122E38ED1F2DF1C")
        
@Override
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeString(text);
        }
    }
    
}

