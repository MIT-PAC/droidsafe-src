package android.preference;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;

public class ListPreference extends DialogPreference {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:23.255 -0500", hash_original_field = "9DDB32C07C355CC1743DA55671D8927A", hash_generated_field = "4FC648754770C3205F9446C9F7605834")

    private CharSequence[] mEntries;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:23.257 -0500", hash_original_field = "4DB99650D71389E3CF4F88C43A044297", hash_generated_field = "486CAA606E1574F138C16E77F1B9619F")

    private CharSequence[] mEntryValues;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:23.259 -0500", hash_original_field = "1160D21D7F9CB66571466142BB3983BB", hash_generated_field = "FA33B8039DB7AC1B219DF637773A1B0E")

    private String mValue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:23.261 -0500", hash_original_field = "A5736795EF7ECED1554FF33331F50AC0", hash_generated_field = "6DB7061A14FC4D33EA524963BB16CF57")

    private String mSummary;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:23.263 -0500", hash_original_field = "36D65142D83AC602E983FC3F9350A007", hash_generated_field = "B7DEBD301D0CCED616CB72A3C559E310")

    private int mClickedDialogEntryIndex;
    
    @DSComment("Perference UI, only change preference is spec")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:23.265 -0500", hash_original_method = "2CB69D78EE187D68AAE6FD5CB1694152", hash_generated_method = "3F0E4E0A9EAAAA071DEE9D34451B43F7")
    
public ListPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.ListPreference, 0, 0);
        mEntries = a.getTextArray(com.android.internal.R.styleable.ListPreference_entries);
        mEntryValues = a.getTextArray(com.android.internal.R.styleable.ListPreference_entryValues);
        a.recycle();

        /* Retrieve the Preference summary attribute since it's private
         * in the Preference class.
         */
        a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.Preference, 0, 0);
        mSummary = a.getString(com.android.internal.R.styleable.Preference_summary);
        a.recycle();
    }

    @DSComment("Perference UI, only change preference is spec")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:23.268 -0500", hash_original_method = "EFEFAC33FEDF5CFCCDC225AF06B658FF", hash_generated_method = "8B0B4F9D4A0EA67C4E871D43D65AAB57")
    
public ListPreference(Context context) {
        this(context, null);
    }

    /**
     * Sets the human-readable entries to be shown in the list. This will be
     * shown in subsequent dialogs.
     * <p>
     * Each entry must have a corresponding index in
     * {@link #setEntryValues(CharSequence[])}.
     * 
     * @param entries The entries.
     * @see #setEntryValues(CharSequence[])
     */
    @DSComment("Perference UI, only change preference is spec")
    @DSSpec(DSCat.SPEC_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:23.270 -0500", hash_original_method = "92444C405286C6A282911C360FA1B20D", hash_generated_method = "302950FB7BED9885645124DF239A43F9")
    
public void setEntries(CharSequence[] entries) {
        mEntries = entries;
    }
    
    /**
     * @see #setEntries(CharSequence[])
     * @param entriesResId The entries array as a resource.
     */
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:23.272 -0500", hash_original_method = "F8AB6256811E3BA7AD610D04605DBEC4", hash_generated_method = "7BA5761937675BD0B0EC2B67C45A8475")
    @DSSpec(DSCat.SPEC_OTHERS)
    @DSVerified
public void setEntries(int entriesResId) {
        setEntries(getContext().getResources().getTextArray(entriesResId));
    }
    
    /**
     * The list of entries to be shown in the list in subsequent dialogs.
     * 
     * @return The list as an array.
     */
    @DSComment("Perference UI, only change preference is spec")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:23.274 -0500", hash_original_method = "F69A5267D165BB7292A2F7B29A70DF84", hash_generated_method = "AD714FB946096D4173F39D089447A889")
    
public CharSequence[] getEntries() {
        return mEntries;
    }
    
    /**
     * The array to find the value to save for a preference when an entry from
     * entries is selected. If a user clicks on the second item in entries, the
     * second item in this array will be saved to the preference.
     * 
     * @param entryValues The array to be used as values to save for the preference.
     */
    @DSComment("Perference UI, only change preference is spec")
    @DSSpec(DSCat.SPEC_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:23.276 -0500", hash_original_method = "33C67F5304EFCF57E93FE56574A29FD8", hash_generated_method = "5508A90163592EA1632D80E304D0522A")
    @DSVerified
public void setEntryValues(CharSequence[] entryValues) {
        mEntryValues = entryValues;
    }

    /**
     * @see #setEntryValues(CharSequence[])
     * @param entryValuesResId The entry values array as a resource.
     */
    @DSComment("Perference UI, only change preference is spec")
    @DSSpec(DSCat.SPEC_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:23.278 -0500", hash_original_method = "7F861B3AE1A834F9F6742B52B4830C35", hash_generated_method = "3F6606757B98ACF0AA1E729E6A5C13C6")
    
public void setEntryValues(int entryValuesResId) {
        setEntryValues(getContext().getResources().getTextArray(entryValuesResId));
    }
    
    /**
     * Returns the array of values to be saved for the preference.
     * 
     * @return The array of values.
     */
    @DSComment("Perference UI, only change preference is spec")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:23.281 -0500", hash_original_method = "4077A49F0088F4F9F53375DFF9727B97", hash_generated_method = "6ACEC0A2332CD82A4012F7701E2D45F0")
    
public CharSequence[] getEntryValues() {
        return mEntryValues;
    }

    /**
     * Sets the value of the key. This should be one of the entries in
     * {@link #getEntryValues()}.
     * 
     * @param value The value to set for the key.
     */
    @DSComment("Storing value")
    @DSSpec(DSCat.SPEC_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:23.283 -0500", hash_original_method = "C381E833D619D719391B620073306BFE", hash_generated_method = "220A5BD7A62524EB3744B4EB6DB31206")
    @DSVerified 
public void setValue(String value) {
        mValue = value;
        
        persistString(value);
    }

    /**
     * Returns the summary of this ListPreference. If the summary
     * has a {@linkplain java.lang.String#format String formatting}
     * marker in it (i.e. "%s" or "%1$s"), then the current entry
     * value will be substituted in its place.
     *
     * @return the summary with appropriate string substitution
     */
    @DSComment("Preference summary")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:23.286 -0500", hash_original_method = "C91AC61B4049FB662B529C1D1FF98F02", hash_generated_method = "1ADDD367AAA1A08308E8609EB30FA51B")
    @DSVerified
@Override
    public CharSequence getSummary() {
        final CharSequence entry = getEntry();
        if (mSummary == null || entry == null) {
            return super.getSummary();
        } else {
            return String.format(mSummary, entry);
        }
    }

    /**
     * Sets the summary for this Preference with a CharSequence.
     * If the summary has a
     * {@linkplain java.lang.String#format String formatting}
     * marker in it (i.e. "%s" or "%1$s"), then the current entry
     * value will be substituted in its place when it's retrieved.
     *
     * @param summary The summary for the preference.
     */
    @DSComment("Perference UI, only change preference is spec")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:23.288 -0500", hash_original_method = "4C1B142B1B7C5EA1E6C6981CF6E13968", hash_generated_method = "E5338CAD084404E4E11D1C8474AFBED4")
    @DSVerified
@Override
    public void setSummary(CharSequence summary) {
        super.setSummary(summary);
        if (summary == null && mSummary != null) {
            mSummary = null;
        } else if (summary != null && !summary.equals(mSummary)) {
            mSummary = summary.toString();
        }
    }

    /**
     * Sets the value to the given index from the entry values.
     * 
     * @param index The index of the value to set.
     */
    @DSSpec(DSCat.SPEC_OTHERS)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:23.290 -0500", hash_original_method = "BCD9DE4E5FC7BA2AD13976209DEB6B06", hash_generated_method = "8CFE42693252720D86102FC0820AEB8D")
    @DSVerified
public void setValueIndex(int index) {
        if (mEntryValues != null) {
            setValue(mEntryValues[index].toString());
        }
    }
    
    /**
     * Returns the value of the key. This should be one of the entries in
     * {@link #getEntryValues()}.
     * 
     * @return The value of the key.
     */
    @DSComment("Perference UI, only change preference is spec")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:23.292 -0500", hash_original_method = "20F1B7D715A473C2ABE076C27B2A3109", hash_generated_method = "A248978541C494C9EDC5F8C81B52BA84")
    
public String getValue() {
        return mValue; 
    }
    
    /**
     * Returns the entry corresponding to the current value.
     * 
     * @return The entry corresponding to the current value, or null.
     */
    @DSComment("Perference UI, only change preference is spec")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:23.294 -0500", hash_original_method = "70FF40F71A0C525EB8753661CD710EE3", hash_generated_method = "02453E38705146C3F0DF2115880BE813")
    
public CharSequence getEntry() {
        int index = getValueIndex();
        return index >= 0 && mEntries != null ? mEntries[index] : null;
    }
    
    /**
     * Returns the index of the given value (in the entry values array).
     * 
     * @param value The value whose index should be returned.
     * @return The index of the value, or -1 if not found.
     */
    @DSComment("Perference UI, only change preference is spec")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:23.297 -0500", hash_original_method = "4E596FDEE64331A25D2B8DFD1BC8797E", hash_generated_method = "AB7808B7EE20CA1E95E83FE48A0F1C7F")
    
public int findIndexOfValue(String value) {
        if (value != null && mEntryValues != null) {
            for (int i = mEntryValues.length - 1; i >= 0; i--) {
                if (mEntryValues[i].equals(value)) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:23.299 -0500", hash_original_method = "72A7028E3449428A8EE1CE440273EEC8", hash_generated_method = "F24C2807E7E031260CA7D67E51A7B1FF")
    
private int getValueIndex() {
        return findIndexOfValue(mValue);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:23.304 -0500", hash_original_method = "6F3CE4AF4F3E6C4B07BCF51D003E1B7E", hash_generated_method = "73111827A73C21FBD2BF40D1534D7447")
    
@Override
    protected void onPrepareDialogBuilder(Builder builder) {
        super.onPrepareDialogBuilder(builder);
        
        if (mEntries == null || mEntryValues == null) {
            throw new IllegalStateException(
                    "ListPreference requires an entries array and an entryValues array.");
        }

        mClickedDialogEntryIndex = getValueIndex();
        builder.setSingleChoiceItems(mEntries, mClickedDialogEntryIndex, 
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        mClickedDialogEntryIndex = which;

                        /*
                         * Clicking on an item simulates the positive button
                         * click, and dismisses the dialog.
                         */
                        ListPreference.this.onClick(dialog, DialogInterface.BUTTON_POSITIVE);
                        dialog.dismiss();
                    }
        });
        
        /*
         * The typical interaction for list-based dialogs is to have
         * click-on-an-item dismiss the dialog instead of the user having to
         * press 'Ok'.
         */
        builder.setPositiveButton(null, null);
    }

    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:23.307 -0500", hash_original_method = "CCC14398C5ED43EC620F4801AA3D0865", hash_generated_method = "FEC5BAB72F3DD0B29A357E2A229CDD96")
    
@Override
    protected void onDialogClosed(boolean positiveResult) {
        super.onDialogClosed(positiveResult);
        
        if (positiveResult && mClickedDialogEntryIndex >= 0 && mEntryValues != null) {
            String value = mEntryValues[mClickedDialogEntryIndex].toString();
            if (callChangeListener(value)) {
                setValue(value);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:23.309 -0500", hash_original_method = "617E38A3300A64CD810B1ADC15B8238E", hash_generated_method = "497DF6D525CC8FE96585CAFDDA47A41E")
    
@Override
    protected Object onGetDefaultValue(TypedArray a, int index) {
        return a.getString(index);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:23.311 -0500", hash_original_method = "267399412B1F2706B566A7FA45C565D6", hash_generated_method = "B0BB9796C19897FFDEC9EDAB7308A133")
    
@Override
    protected void onSetInitialValue(boolean restoreValue, Object defaultValue) {
        setValue(restoreValue ? getPersistedString(mValue) : (String) defaultValue);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:23.313 -0500", hash_original_method = "D580D34207BE421621E2D4F2F9CC874F", hash_generated_method = "9709F4193FF45E48BD2CD73EDB974E4C")
    
@Override
    protected Parcelable onSaveInstanceState() {
        final Parcelable superState = super.onSaveInstanceState();
        if (isPersistent()) {
            // No need to save instance state since it's persistent
            return superState;
        }
        
        final SavedState myState = new SavedState(superState);
        myState.value = getValue();
        return myState;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:23.317 -0500", hash_original_method = "2C7D4FC1A8B86A2A9B820B68195C8000", hash_generated_method = "36DB5FB42370477AEC46CBB0D80A489D")
    
@Override
    protected void onRestoreInstanceState(Parcelable state) {
        if (state == null || !state.getClass().equals(SavedState.class)) {
            // Didn't save state for us in onSaveInstanceState
            super.onRestoreInstanceState(state);
            return;
        }
         
        SavedState myState = (SavedState) state;
        super.onRestoreInstanceState(myState.getSuperState());
        setValue(myState.value);
    }
    
    private static class SavedState extends BaseSavedState {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:23.335 -0500", hash_original_field = "AD99978CDC5E698C2A4DD1DC3100EFC5", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

        public static final Parcelable.Creator<SavedState> CREATOR =
                new Parcelable.Creator<SavedState>() {
            @DSSafe(DSCat.SAFE_OTHERS)
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:23.320 -0500", hash_original_field = "EE6B270D979EDA88DA18EA680B9EE570", hash_generated_field = "EE6B270D979EDA88DA18EA680B9EE570")

        String value;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:23.322 -0500", hash_original_method = "EB5201084C34C9002E59147CD94E6432", hash_generated_method = "F476DDF8775657AA275FE2894FBC3F67")
        
public SavedState(Parcel source) {
            super(source);
            value = source.readString();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:23.327 -0500", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "E32D4593A5A22DE64D4F3221E06324D4")
        
public SavedState(Parcelable superState) {
            super(superState);
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:23.325 -0500", hash_original_method = "8DFCA3C36BA7A53489D20A0BA4FD0CC0", hash_generated_method = "C1C6F47B2086812F826D2D3D1657D081")
        
@Override
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeString(value);
        }
    }
    
}

