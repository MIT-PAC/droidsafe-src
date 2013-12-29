package android.preference;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.TextView;





public abstract class TwoStatePreference extends Preference {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.348 -0500", hash_original_field = "79F956D2046D3349120E2925E931AB04", hash_generated_field = "0A63C4508093BBBDC63A916183312B21")


    private CharSequence mSummaryOn;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.349 -0500", hash_original_field = "C9C703DAFAF0CC0824DEBF823C9E9923", hash_generated_field = "7936F2388E5FECE5D26263562952AF1C")

    private CharSequence mSummaryOff;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.349 -0500", hash_original_field = "2095822BEB25A977611B30C48AE7794D", hash_generated_field = "2095822BEB25A977611B30C48AE7794D")

    boolean mChecked;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.351 -0500", hash_original_field = "D485DAA0B69379179DC2A5907E551868", hash_generated_field = "35334A485195E89BB569733AA9D3EF56")

    private boolean mSendClickAccessibilityEvent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.351 -0500", hash_original_field = "6DE548F910A03AB37C1AA22EC9C7CFC6", hash_generated_field = "A45150049825FDCDA3DE269C67272345")

    private boolean mDisableDependentsState;


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.352 -0500", hash_original_method = "9308B3B15F4DE8F7508C8EA50D56D8AD", hash_generated_method = "258A6CAC93AAD14C03652E28A1D45CF7")
    public TwoStatePreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.353 -0500", hash_original_method = "069F398059373859493FBC4CB93F22AA", hash_generated_method = "BA81303DD1058CFB4FCD0E4BA9BCFF71")
    public TwoStatePreference(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.354 -0500", hash_original_method = "DE7459DE73702557DE26E7B158A3632F", hash_generated_method = "17C7EEBC783299CAF8A59F3BE5CBE456")
    public TwoStatePreference(Context context) {
        this(context, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.355 -0500", hash_original_method = "41BF424D5DCED4AFC88BB1561E7758B1", hash_generated_method = "7A03287DCF28281EA2B997AF41CC167E")
    @Override
protected void onClick() {
        super.onClick();

        boolean newValue = !isChecked();

        mSendClickAccessibilityEvent = true;

        if (!callChangeListener(newValue)) {
            return;
        }

        setChecked(newValue);
    }

    /**
     * Sets the checked state and saves it to the {@link SharedPreferences}.
     *
     * @param checked The checked state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.356 -0500", hash_original_method = "12D9CEBA0208655576D33A98ED54981A", hash_generated_method = "784176010AB6914D1ADE8C4FD8CEA97D")
    public void setChecked(boolean checked) {
        if (mChecked != checked) {
            mChecked = checked;
            persistBoolean(checked);
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        }
    }

    /**
     * Returns the checked state.
     *
     * @return The checked state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.356 -0500", hash_original_method = "1057BD246BBC96B40BF6B862055C5AB8", hash_generated_method = "7DBC96472843914D224753BAD760B683")
    public boolean isChecked() {
        return mChecked;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.357 -0500", hash_original_method = "4E403BDF8313BB473693F04068F62649", hash_generated_method = "E4EBFCC7536539CE59A70909C958FE50")
    @Override
public boolean shouldDisableDependents() {
        boolean shouldDisable = mDisableDependentsState ? mChecked : !mChecked;
        return shouldDisable || super.shouldDisableDependents();
    }

    /**
     * Sets the summary to be shown when checked.
     *
     * @param summary The summary to be shown when checked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.358 -0500", hash_original_method = "ABD6122B04EABCC29A2D57307245871E", hash_generated_method = "C46997D2300F9B96A75CB0A2563ADC11")
    public void setSummaryOn(CharSequence summary) {
        mSummaryOn = summary;
        if (isChecked()) {
            notifyChanged();
        }
    }

    /**
     * @see #setSummaryOn(CharSequence)
     * @param summaryResId The summary as a resource.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.359 -0500", hash_original_method = "840A2DF332BCD4D47FC113ECD5767E5E", hash_generated_method = "2AD79D3C20A788609781E3D3765ED605")
    public void setSummaryOn(int summaryResId) {
        setSummaryOn(getContext().getString(summaryResId));
    }

    /**
     * Returns the summary to be shown when checked.
     * @return The summary.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.359 -0500", hash_original_method = "53022197E36EDF9F1FD4F6F19ADFC277", hash_generated_method = "1BBE5CF26238E024D5A2941A62474B93")
    public CharSequence getSummaryOn() {
        return mSummaryOn;
    }

    /**
     * Sets the summary to be shown when unchecked.
     *
     * @param summary The summary to be shown when unchecked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.360 -0500", hash_original_method = "D2C60679B7A2716D92F9A6A90EE31D5E", hash_generated_method = "7D192ED844E9ECE7FDC04FC71260413E")
    public void setSummaryOff(CharSequence summary) {
        mSummaryOff = summary;
        if (!isChecked()) {
            notifyChanged();
        }
    }

    /**
     * @see #setSummaryOff(CharSequence)
     * @param summaryResId The summary as a resource.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.361 -0500", hash_original_method = "A777E36B9565634072F09AB599AD44D9", hash_generated_method = "76D16EE5D58E9509BE497B7372C08656")
    public void setSummaryOff(int summaryResId) {
        setSummaryOff(getContext().getString(summaryResId));
    }

    /**
     * Returns the summary to be shown when unchecked.
     * @return The summary.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.362 -0500", hash_original_method = "71CAEB9E0C109885D80E1240FC68BC2D", hash_generated_method = "1620D3A9C805C85EA5E74E56DD32733F")
    public CharSequence getSummaryOff() {
        return mSummaryOff;
    }

    /**
     * Returns whether dependents are disabled when this preference is on ({@code true})
     * or when this preference is off ({@code false}).
     *
     * @return Whether dependents are disabled when this preference is on ({@code true})
     *         or when this preference is off ({@code false}).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.362 -0500", hash_original_method = "3884E74D45C3003321F5E57E22265849", hash_generated_method = "DF82E5FF12077E56CA645577AFB253B0")
    public boolean getDisableDependentsState() {
        return mDisableDependentsState;
    }

    /**
     * Sets whether dependents are disabled when this preference is on ({@code true})
     * or when this preference is off ({@code false}).
     *
     * @param disableDependentsState The preference state that should disable dependents.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.363 -0500", hash_original_method = "DD37671E97B19E2FAA5E6DF537625889", hash_generated_method = "AEF138ACE5F0FB3869C0DC0DC2B58971")
    public void setDisableDependentsState(boolean disableDependentsState) {
        mDisableDependentsState = disableDependentsState;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.364 -0500", hash_original_method = "CD855B5FF5EBE7A616F45EDA9F1DAEC1", hash_generated_method = "23A47C106A4DFFA0F1C09F22F89964B6")
    @Override
protected Object onGetDefaultValue(TypedArray a, int index) {
        return a.getBoolean(index, false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.365 -0500", hash_original_method = "EEED4140B5DC5D316316DEC318D41EA8", hash_generated_method = "3EECB24A18B50FA0BD4E2DAFD0A4E349")
    @Override
protected void onSetInitialValue(boolean restoreValue, Object defaultValue) {
        setChecked(restoreValue ? getPersistedBoolean(mChecked)
                : (Boolean) defaultValue);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.366 -0500", hash_original_method = "6184398C925EDFB35C067E47CDB9F78F", hash_generated_method = "164EFE9A1695D41D60B2616745708182")
    void sendAccessibilityEvent(View view) {
        // Since the view is still not attached we create, populate,
        // and send the event directly since we do not know when it
        // will be attached and posting commands is not as clean.
        AccessibilityManager accessibilityManager = AccessibilityManager.getInstance(getContext());
        if (mSendClickAccessibilityEvent && accessibilityManager.isEnabled()) {
            AccessibilityEvent event = AccessibilityEvent.obtain();
            event.setEventType(AccessibilityEvent.TYPE_VIEW_CLICKED);
            view.onInitializeAccessibilityEvent(event);
            view.dispatchPopulateAccessibilityEvent(event);
            accessibilityManager.sendAccessibilityEvent(event);
        }
        mSendClickAccessibilityEvent = false;
    }

    /**
     * Sync a summary view contained within view's subhierarchy with the correct summary text.
     * @param view View where a summary should be located
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.367 -0500", hash_original_method = "901B0F4CA28424233D996D3F63CA3D29", hash_generated_method = "4B5893EEDD3C4DA62552168499070307")
    void syncSummaryView(View view) {
        // Sync the summary view
        TextView summaryView = (TextView) view.findViewById(com.android.internal.R.id.summary);
        if (summaryView != null) {
            boolean useDefaultSummary = true;
            if (mChecked && mSummaryOn != null) {
                summaryView.setText(mSummaryOn);
                useDefaultSummary = false;
            } else if (!mChecked && mSummaryOff != null) {
                summaryView.setText(mSummaryOff);
                useDefaultSummary = false;
            }

            if (useDefaultSummary) {
                final CharSequence summary = getSummary();
                if (summary != null) {
                    summaryView.setText(summary);
                    useDefaultSummary = false;
                }
            }

            int newVisibility = View.GONE;
            if (!useDefaultSummary) {
                // Someone has written to it
                newVisibility = View.VISIBLE;
            }
            if (newVisibility != summaryView.getVisibility()) {
                summaryView.setVisibility(newVisibility);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.368 -0500", hash_original_method = "128E228DA264F73B8973AB4629CC5B53", hash_generated_method = "0E47EB36BA3D571B10DE0502F108D59F")
    @Override
protected Parcelable onSaveInstanceState() {
        final Parcelable superState = super.onSaveInstanceState();
        if (isPersistent()) {
            // No need to save instance state since it's persistent
            return superState;
        }

        final SavedState myState = new SavedState(superState);
        myState.checked = isChecked();
        return myState;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.369 -0500", hash_original_method = "391D589FD70A1E2CE27C524E3DFC61F4", hash_generated_method = "926A533289D83272AC9E9930FAC04CBC")
    @Override
protected void onRestoreInstanceState(Parcelable state) {
        if (state == null || !state.getClass().equals(SavedState.class)) {
            // Didn't save state for us in onSaveInstanceState
            super.onRestoreInstanceState(state);
            return;
        }

        SavedState myState = (SavedState) state;
        super.onRestoreInstanceState(myState.getSuperState());
        setChecked(myState.checked);
    }

    
    static class SavedState extends BaseSavedState {

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.937 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

        public static final Parcelable.Creator<SavedState> CREATOR =
                new Parcelable.Creator<SavedState>() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.374 -0500", hash_original_method = "E26812089C072DDE1A14AECAA6CD6686", hash_generated_method = "C97AA17CB243756458D0FB7A2D786EA0")
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.375 -0500", hash_original_method = "2D31E9CBAAAE05B696D738324F87FF78", hash_generated_method = "020465B62F970B98C266AF229149E391")
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.370 -0500", hash_original_field = "6F0D05495423C9405B09D32CCA18EA7F", hash_generated_field = "6F0D05495423C9405B09D32CCA18EA7F")

        boolean checked;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.371 -0500", hash_original_method = "BB6B7FCEDF34CA74F36D6258486FF337", hash_generated_method = "920C12215E1E25AF653D9E914DEAF2FE")
        public SavedState(Parcel source) {
            super(source);
            checked = source.readInt() == 1;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.373 -0500", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "E32D4593A5A22DE64D4F3221E06324D4")
        public SavedState(Parcelable superState) {
            super(superState);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:14.372 -0500", hash_original_method = "5F0C2D7310332C4BBDEFEA2518DC2D5F", hash_generated_method = "D7BCD3CA61BA8DBE593392F304F188F0")
        @Override
public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(checked ? 1 : 0);
        }
        // orphaned legacy method
        public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }
        
        // orphaned legacy method
        public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        
    }


    
}

