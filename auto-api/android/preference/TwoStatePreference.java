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
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.TextView;

public abstract class TwoStatePreference extends Preference {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.029 -0400", hash_original_field = "16D20186D5AA4CF4BF1132594D02BA75", hash_generated_field = "0A63C4508093BBBDC63A916183312B21")

    private CharSequence mSummaryOn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.029 -0400", hash_original_field = "B78FF240CB74BC7C7CDDCEB5DC4DDDFF", hash_generated_field = "7936F2388E5FECE5D26263562952AF1C")

    private CharSequence mSummaryOff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.029 -0400", hash_original_field = "B7985199D35C1155A55567C458443B15", hash_generated_field = "2095822BEB25A977611B30C48AE7794D")

    boolean mChecked;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.029 -0400", hash_original_field = "BA02A487DDDF80B1BCEFB080B47DA49C", hash_generated_field = "35334A485195E89BB569733AA9D3EF56")

    private boolean mSendClickAccessibilityEvent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.029 -0400", hash_original_field = "B485C56B2E2F60A8579BB8CCE5F5F8B6", hash_generated_field = "A45150049825FDCDA3DE269C67272345")

    private boolean mDisableDependentsState;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.041 -0400", hash_original_method = "9308B3B15F4DE8F7508C8EA50D56D8AD", hash_generated_method = "F183B34F7393365163FCA9B9D53A402B")
    public  TwoStatePreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.050 -0400", hash_original_method = "069F398059373859493FBC4CB93F22AA", hash_generated_method = "10E8F65EFE3AB6B3CBF2A2E3DA34A9FB")
    public  TwoStatePreference(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.075 -0400", hash_original_method = "DE7459DE73702557DE26E7B158A3632F", hash_generated_method = "1C73A2C1F02E9B56C524EA06321EA376")
    public  TwoStatePreference(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.076 -0400", hash_original_method = "41BF424D5DCED4AFC88BB1561E7758B1", hash_generated_method = "65A805B6128C537AFE30EFEBDD5EBDD7")
    @Override
    protected void onClick() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onClick();
        boolean newValue;
        newValue = !isChecked();
        mSendClickAccessibilityEvent = true;
        {
            boolean var646EAAA42B72A4554CF370999933F6B5_1846800403 = (!callChangeListener(newValue));
        } //End collapsed parenthetic
        setChecked(newValue);
        // ---------- Original Method ----------
        //super.onClick();
        //boolean newValue = !isChecked();
        //mSendClickAccessibilityEvent = true;
        //if (!callChangeListener(newValue)) {
            //return;
        //}
        //setChecked(newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.076 -0400", hash_original_method = "12D9CEBA0208655576D33A98ED54981A", hash_generated_method = "FE56351616BBEF6ED4506E2301243834")
    public void setChecked(boolean checked) {
        {
            mChecked = checked;
            persistBoolean(checked);
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        } //End block
        // ---------- Original Method ----------
        //if (mChecked != checked) {
            //mChecked = checked;
            //persistBoolean(checked);
            //notifyDependencyChange(shouldDisableDependents());
            //notifyChanged();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.077 -0400", hash_original_method = "1057BD246BBC96B40BF6B862055C5AB8", hash_generated_method = "92E6FB395AE779BA1D27EED1D9BA89CD")
    public boolean isChecked() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1228397001 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1228397001;
        // ---------- Original Method ----------
        //return mChecked;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.078 -0400", hash_original_method = "4E403BDF8313BB473693F04068F62649", hash_generated_method = "CD609C2A29E7A5F1ADE1D9276E97C513")
    @Override
    public boolean shouldDisableDependents() {
        boolean shouldDisable;
        shouldDisable = mChecked;
        shouldDisable = !mChecked;
        boolean var5FE8267438C182B12CFCA4607EBA178F_1217888194 = (shouldDisable || super.shouldDisableDependents());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_476186313 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_476186313;
        // ---------- Original Method ----------
        //boolean shouldDisable = mDisableDependentsState ? mChecked : !mChecked;
        //return shouldDisable || super.shouldDisableDependents();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.078 -0400", hash_original_method = "ABD6122B04EABCC29A2D57307245871E", hash_generated_method = "1115850682574E691750C4090B09E77A")
    public void setSummaryOn(CharSequence summary) {
        mSummaryOn = summary;
        {
            boolean varCEC0E711DC0F7C8E920C6F998438D53D_290973922 = (isChecked());
            {
                notifyChanged();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //mSummaryOn = summary;
        //if (isChecked()) {
            //notifyChanged();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.079 -0400", hash_original_method = "840A2DF332BCD4D47FC113ECD5767E5E", hash_generated_method = "9535FD15F85C4BB169CAD5365B9B6253")
    public void setSummaryOn(int summaryResId) {
        setSummaryOn(getContext().getString(summaryResId));
        addTaint(summaryResId);
        // ---------- Original Method ----------
        //setSummaryOn(getContext().getString(summaryResId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.079 -0400", hash_original_method = "53022197E36EDF9F1FD4F6F19ADFC277", hash_generated_method = "B2B9A41FE8B160ACC54400FF1F682414")
    public CharSequence getSummaryOn() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1095356194 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1095356194 = mSummaryOn;
        varB4EAC82CA7396A68D541C85D26508E83_1095356194.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1095356194;
        // ---------- Original Method ----------
        //return mSummaryOn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.080 -0400", hash_original_method = "D2C60679B7A2716D92F9A6A90EE31D5E", hash_generated_method = "935AC94D7F83DA7C2724A56D283DB11D")
    public void setSummaryOff(CharSequence summary) {
        mSummaryOff = summary;
        {
            boolean var7AB0DED7B5B158F799F9F55A9C38731D_63080264 = (!isChecked());
            {
                notifyChanged();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //mSummaryOff = summary;
        //if (!isChecked()) {
            //notifyChanged();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.080 -0400", hash_original_method = "A777E36B9565634072F09AB599AD44D9", hash_generated_method = "6DF224296C78363DE8AA271CE4668533")
    public void setSummaryOff(int summaryResId) {
        setSummaryOff(getContext().getString(summaryResId));
        addTaint(summaryResId);
        // ---------- Original Method ----------
        //setSummaryOff(getContext().getString(summaryResId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.100 -0400", hash_original_method = "71CAEB9E0C109885D80E1240FC68BC2D", hash_generated_method = "A0EBCDB02324DD3100E1E78BEA221B31")
    public CharSequence getSummaryOff() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1592902794 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1592902794 = mSummaryOff;
        varB4EAC82CA7396A68D541C85D26508E83_1592902794.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1592902794;
        // ---------- Original Method ----------
        //return mSummaryOff;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.100 -0400", hash_original_method = "3884E74D45C3003321F5E57E22265849", hash_generated_method = "6B0988B5414D4532170C2357C7C7DCD8")
    public boolean getDisableDependentsState() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1125854612 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1125854612;
        // ---------- Original Method ----------
        //return mDisableDependentsState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.101 -0400", hash_original_method = "DD37671E97B19E2FAA5E6DF537625889", hash_generated_method = "74CF59A9D65521DE993E4BF0B8B81534")
    public void setDisableDependentsState(boolean disableDependentsState) {
        mDisableDependentsState = disableDependentsState;
        // ---------- Original Method ----------
        //mDisableDependentsState = disableDependentsState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.102 -0400", hash_original_method = "CD855B5FF5EBE7A616F45EDA9F1DAEC1", hash_generated_method = "755F7AEE95812AB1BA23F673CD3FDAD5")
    @Override
    protected Object onGetDefaultValue(TypedArray a, int index) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Object varB4EAC82CA7396A68D541C85D26508E83_1564980417 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1564980417 = a.getBoolean(index, false);
        addTaint(a.getTaint());
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1564980417.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1564980417;
        // ---------- Original Method ----------
        //return a.getBoolean(index, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.103 -0400", hash_original_method = "EEED4140B5DC5D316316DEC318D41EA8", hash_generated_method = "920D04AAC82E167C809651D1E5A5EBD3")
    @Override
    protected void onSetInitialValue(boolean restoreValue, Object defaultValue) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        setChecked(restoreValue ? getPersistedBoolean(mChecked)
                : (Boolean) defaultValue);
        addTaint(restoreValue);
        addTaint(defaultValue.getTaint());
        // ---------- Original Method ----------
        //setChecked(restoreValue ? getPersistedBoolean(mChecked)
                //: (Boolean) defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.103 -0400", hash_original_method = "6184398C925EDFB35C067E47CDB9F78F", hash_generated_method = "4EB500BE6AE43356BE095987853B5D8D")
     void sendAccessibilityEvent(View view) {
        AccessibilityManager accessibilityManager;
        accessibilityManager = AccessibilityManager.getInstance(getContext());
        {
            boolean var285DE9BF74F919C880FF243DB8CFF0FF_409364513 = (mSendClickAccessibilityEvent && accessibilityManager.isEnabled());
            {
                AccessibilityEvent event;
                event = AccessibilityEvent.obtain();
                event.setEventType(AccessibilityEvent.TYPE_VIEW_CLICKED);
                view.onInitializeAccessibilityEvent(event);
                view.dispatchPopulateAccessibilityEvent(event);
                accessibilityManager.sendAccessibilityEvent(event);
            } //End block
        } //End collapsed parenthetic
        mSendClickAccessibilityEvent = false;
        addTaint(view.getTaint());
        // ---------- Original Method ----------
        //AccessibilityManager accessibilityManager = AccessibilityManager.getInstance(getContext());
        //if (mSendClickAccessibilityEvent && accessibilityManager.isEnabled()) {
            //AccessibilityEvent event = AccessibilityEvent.obtain();
            //event.setEventType(AccessibilityEvent.TYPE_VIEW_CLICKED);
            //view.onInitializeAccessibilityEvent(event);
            //view.dispatchPopulateAccessibilityEvent(event);
            //accessibilityManager.sendAccessibilityEvent(event);
        //}
        //mSendClickAccessibilityEvent = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.104 -0400", hash_original_method = "901B0F4CA28424233D996D3F63CA3D29", hash_generated_method = "FF6D82061EDB35E8A63CD627443FD690")
     void syncSummaryView(View view) {
        TextView summaryView;
        summaryView = (TextView) view.findViewById(com.android.internal.R.id.summary);
        {
            boolean useDefaultSummary;
            useDefaultSummary = true;
            {
                summaryView.setText(mSummaryOn);
                useDefaultSummary = false;
            } //End block
            {
                summaryView.setText(mSummaryOff);
                useDefaultSummary = false;
            } //End block
            {
                CharSequence summary;
                summary = getSummary();
                {
                    summaryView.setText(summary);
                    useDefaultSummary = false;
                } //End block
            } //End block
            int newVisibility;
            newVisibility = View.GONE;
            {
                newVisibility = View.VISIBLE;
            } //End block
            {
                boolean var282B783561E8A4D274F38786CE52D9D5_1123877705 = (newVisibility != summaryView.getVisibility());
                {
                    summaryView.setVisibility(newVisibility);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(view.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.117 -0400", hash_original_method = "128E228DA264F73B8973AB4629CC5B53", hash_generated_method = "40738D7A6442AB1B0685D6B3F4005971")
    @Override
    protected Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_1223338480 = null; //Variable for return #1
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_618607213 = null; //Variable for return #2
        Parcelable superState;
        superState = super.onSaveInstanceState();
        {
            boolean varA5BC476CED9D472D4630C0C0B6120523_805701202 = (isPersistent());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1223338480 = superState;
            } //End block
        } //End collapsed parenthetic
        SavedState myState;
        myState = new SavedState(superState);
        myState.checked = isChecked();
        varB4EAC82CA7396A68D541C85D26508E83_618607213 = myState;
        Parcelable varA7E53CE21691AB073D9660D615818899_428739416; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_428739416 = varB4EAC82CA7396A68D541C85D26508E83_1223338480;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_428739416 = varB4EAC82CA7396A68D541C85D26508E83_618607213;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_428739416.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_428739416;
        // ---------- Original Method ----------
        //final Parcelable superState = super.onSaveInstanceState();
        //if (isPersistent()) {
            //return superState;
        //}
        //final SavedState myState = new SavedState(superState);
        //myState.checked = isChecked();
        //return myState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.118 -0400", hash_original_method = "391D589FD70A1E2CE27C524E3DFC61F4", hash_generated_method = "C5E917C799FEAC42D95A93280C943713")
    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var9146082C23BCEB2285F1054C3B9F84EE_1744457507 = (state == null || !state.getClass().equals(SavedState.class));
            {
                super.onRestoreInstanceState(state);
            } //End block
        } //End collapsed parenthetic
        SavedState myState;
        myState = (SavedState) state;
        super.onRestoreInstanceState(myState.getSuperState());
        setChecked(myState.checked);
        addTaint(state.getTaint());
        // ---------- Original Method ----------
        //if (state == null || !state.getClass().equals(SavedState.class)) {
            //super.onRestoreInstanceState(state);
            //return;
        //}
        //SavedState myState = (SavedState) state;
        //super.onRestoreInstanceState(myState.getSuperState());
        //setChecked(myState.checked);
    }

    
    static class SavedState extends BaseSavedState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.118 -0400", hash_original_field = "3793EA52A7BE2D7DEAFD858FDA50775C", hash_generated_field = "6F0D05495423C9405B09D32CCA18EA7F")

        boolean checked;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.118 -0400", hash_original_method = "BB6B7FCEDF34CA74F36D6258486FF337", hash_generated_method = "49AC5E3B0A809768E3B5980304872239")
        public  SavedState(Parcel source) {
            super(source);
            checked = source.readInt() == 1;
            // ---------- Original Method ----------
            //checked = source.readInt() == 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.118 -0400", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "AB11810075E98F66089A29D0DD89C4B4")
        public  SavedState(Parcelable superState) {
            super(superState);
            addTaint(superState.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.119 -0400", hash_original_method = "5F0C2D7310332C4BBDEFEA2518DC2D5F", hash_generated_method = "98B308E78B364742D36D4D3D1507373F")
        @Override
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(checked ? 1 : 0);
            addTaint(dest.getTaint());
            addTaint(flags);
            // ---------- Original Method ----------
            //super.writeToParcel(dest, flags);
            //dest.writeInt(checked ? 1 : 0);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.119 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

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

