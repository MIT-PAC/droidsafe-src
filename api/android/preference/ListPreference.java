package android.preference;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;

public class ListPreference extends DialogPreference {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.312 -0400", hash_original_field = "A2A3482E1757A40787036BBDB9FBE706", hash_generated_field = "4FC648754770C3205F9446C9F7605834")

    private CharSequence[] mEntries;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.312 -0400", hash_original_field = "9AC5F83BDA028FF60DFC91B64DF2F656", hash_generated_field = "486CAA606E1574F138C16E77F1B9619F")

    private CharSequence[] mEntryValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.312 -0400", hash_original_field = "CBAFE11E7BAE23358D70D54D132C3064", hash_generated_field = "FA33B8039DB7AC1B219DF637773A1B0E")

    private String mValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.313 -0400", hash_original_field = "364E1929FED648A0A411C548B6A6CE28", hash_generated_field = "6DB7061A14FC4D33EA524963BB16CF57")

    private String mSummary;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.313 -0400", hash_original_field = "D67DCB4D6296848E78093D2EF37CA2F4", hash_generated_field = "B7DEBD301D0CCED616CB72A3C559E310")

    private int mClickedDialogEntryIndex;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.314 -0400", hash_original_method = "2CB69D78EE187D68AAE6FD5CB1694152", hash_generated_method = "08A497F5BDFC819DA39063BDC08E510E")
    public  ListPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.ListPreference, 0, 0);
        mEntries = a.getTextArray(com.android.internal.R.styleable.ListPreference_entries);
        mEntryValues = a.getTextArray(com.android.internal.R.styleable.ListPreference_entryValues);
        a.recycle();
        a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.Preference, 0, 0);
        mSummary = a.getString(com.android.internal.R.styleable.Preference_summary);
        a.recycle();
        // ---------- Original Method ----------
        //TypedArray a = context.obtainStyledAttributes(attrs,
                //com.android.internal.R.styleable.ListPreference, 0, 0);
        //mEntries = a.getTextArray(com.android.internal.R.styleable.ListPreference_entries);
        //mEntryValues = a.getTextArray(com.android.internal.R.styleable.ListPreference_entryValues);
        //a.recycle();
        //a = context.obtainStyledAttributes(attrs,
                //com.android.internal.R.styleable.Preference, 0, 0);
        //mSummary = a.getString(com.android.internal.R.styleable.Preference_summary);
        //a.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.314 -0400", hash_original_method = "EFEFAC33FEDF5CFCCDC225AF06B658FF", hash_generated_method = "25239011DAC03D575E85B0D1ECC95906")
    public  ListPreference(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.314 -0400", hash_original_method = "92444C405286C6A282911C360FA1B20D", hash_generated_method = "C62CC4A5A33DFC543ABA49B4451B21C1")
    public void setEntries(CharSequence[] entries) {
        mEntries = entries;
        // ---------- Original Method ----------
        //mEntries = entries;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.315 -0400", hash_original_method = "F8AB6256811E3BA7AD610D04605DBEC4", hash_generated_method = "7F29CDDA2E6A00E5FD60C5EACAC3FE19")
    public void setEntries(int entriesResId) {
        addTaint(entriesResId);
        setEntries(getContext().getResources().getTextArray(entriesResId));
        // ---------- Original Method ----------
        //setEntries(getContext().getResources().getTextArray(entriesResId));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.315 -0400", hash_original_method = "F69A5267D165BB7292A2F7B29A70DF84", hash_generated_method = "A5DF56318CA57A568B021DC644344023")
    public CharSequence[] getEntries() {
CharSequence[] varDFEB20DF106F6A2CD6E980CC40196305_1033064800 =         mEntries;
        varDFEB20DF106F6A2CD6E980CC40196305_1033064800.addTaint(taint);
        return varDFEB20DF106F6A2CD6E980CC40196305_1033064800;
        // ---------- Original Method ----------
        //return mEntries;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.315 -0400", hash_original_method = "33C67F5304EFCF57E93FE56574A29FD8", hash_generated_method = "784E1B92FE82DF1BFF22EEB8A8902145")
    public void setEntryValues(CharSequence[] entryValues) {
        mEntryValues = entryValues;
        // ---------- Original Method ----------
        //mEntryValues = entryValues;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.316 -0400", hash_original_method = "7F861B3AE1A834F9F6742B52B4830C35", hash_generated_method = "6DAF9580580CE2E0BA959DDF93D45C34")
    public void setEntryValues(int entryValuesResId) {
        addTaint(entryValuesResId);
        setEntryValues(getContext().getResources().getTextArray(entryValuesResId));
        // ---------- Original Method ----------
        //setEntryValues(getContext().getResources().getTextArray(entryValuesResId));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.316 -0400", hash_original_method = "4077A49F0088F4F9F53375DFF9727B97", hash_generated_method = "7602A468A2797A40028B16D7F1B21917")
    public CharSequence[] getEntryValues() {
CharSequence[] var8191EBE8B88208B04001F3EB9757A462_1035405289 =         mEntryValues;
        var8191EBE8B88208B04001F3EB9757A462_1035405289.addTaint(taint);
        return var8191EBE8B88208B04001F3EB9757A462_1035405289;
        // ---------- Original Method ----------
        //return mEntryValues;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.316 -0400", hash_original_method = "C381E833D619D719391B620073306BFE", hash_generated_method = "A041F9E43957DB69CEF4AD3D2F625BA5")
    public void setValue(String value) {
        mValue = value;
        persistString(value);
        // ---------- Original Method ----------
        //mValue = value;
        //persistString(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.317 -0400", hash_original_method = "C91AC61B4049FB662B529C1D1FF98F02", hash_generated_method = "2690E0EE9125629DB0F68ED4ECDB39E0")
    @Override
    public CharSequence getSummary() {
        final CharSequence entry = getEntry();
        if(mSummary == null || entry == null)        
        {
CharSequence var360515AA178D28B01C4528F92C4DD1E1_1759513601 =             super.getSummary();
            var360515AA178D28B01C4528F92C4DD1E1_1759513601.addTaint(taint);
            return var360515AA178D28B01C4528F92C4DD1E1_1759513601;
        } //End block
        else
        {
CharSequence varB94F03AB2102AC083EBCD479B7D73881_979453654 =             String.format(mSummary, entry);
            varB94F03AB2102AC083EBCD479B7D73881_979453654.addTaint(taint);
            return varB94F03AB2102AC083EBCD479B7D73881_979453654;
        } //End block
        // ---------- Original Method ----------
        //final CharSequence entry = getEntry();
        //if (mSummary == null || entry == null) {
            //return super.getSummary();
        //} else {
            //return String.format(mSummary, entry);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.317 -0400", hash_original_method = "4C1B142B1B7C5EA1E6C6981CF6E13968", hash_generated_method = "F2567B4C67BA8A6BC5319A5FD8656F75")
    @Override
    public void setSummary(CharSequence summary) {
        super.setSummary(summary);
        if(summary == null && mSummary != null)        
        {
            mSummary = null;
        } //End block
        else
        if(summary != null && !summary.equals(mSummary))        
        {
            mSummary = summary.toString();
        } //End block
        // ---------- Original Method ----------
        //super.setSummary(summary);
        //if (summary == null && mSummary != null) {
            //mSummary = null;
        //} else if (summary != null && !summary.equals(mSummary)) {
            //mSummary = summary.toString();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.318 -0400", hash_original_method = "BCD9DE4E5FC7BA2AD13976209DEB6B06", hash_generated_method = "D8EE9CF7614CCBD13236BDD5B06EA6B5")
    public void setValueIndex(int index) {
        addTaint(index);
        if(mEntryValues != null)        
        {
            setValue(mEntryValues[index].toString());
        } //End block
        // ---------- Original Method ----------
        //if (mEntryValues != null) {
            //setValue(mEntryValues[index].toString());
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.319 -0400", hash_original_method = "20F1B7D715A473C2ABE076C27B2A3109", hash_generated_method = "C7BE41FFE853277CF4C930F46BFA5EDC")
    public String getValue() {
String varD1FEA3F5EE4618A9C3646312F018E4AC_709229868 =         mValue;
        varD1FEA3F5EE4618A9C3646312F018E4AC_709229868.addTaint(taint);
        return varD1FEA3F5EE4618A9C3646312F018E4AC_709229868;
        // ---------- Original Method ----------
        //return mValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.319 -0400", hash_original_method = "70FF40F71A0C525EB8753661CD710EE3", hash_generated_method = "7911DC489275D81E75A1FB6C435DEBAC")
    public CharSequence getEntry() {
        int index = getValueIndex();
CharSequence varCFEC00F16F2300EEED067902F15C00E3_1886547097 =         index >= 0 && mEntries != null ? mEntries[index] : null;
        varCFEC00F16F2300EEED067902F15C00E3_1886547097.addTaint(taint);
        return varCFEC00F16F2300EEED067902F15C00E3_1886547097;
        // ---------- Original Method ----------
        //int index = getValueIndex();
        //return index >= 0 && mEntries != null ? mEntries[index] : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.322 -0400", hash_original_method = "4E596FDEE64331A25D2B8DFD1BC8797E", hash_generated_method = "E8C3FA6D0496941C0A1BFDB045B333C1")
    public int findIndexOfValue(String value) {
        addTaint(value.getTaint());
        if(value != null && mEntryValues != null)        
        {
for(int i = mEntryValues.length - 1;i >= 0;i--)
            {
                if(mEntryValues[i].equals(value))                
                {
                    int var865C0C0B4AB0E063E5CAA3387C1A8741_1785618745 = (i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1643506951 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1643506951;
                } //End block
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1474022617 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_459022139 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_459022139;
        // ---------- Original Method ----------
        //if (value != null && mEntryValues != null) {
            //for (int i = mEntryValues.length - 1; i >= 0; i--) {
                //if (mEntryValues[i].equals(value)) {
                    //return i;
                //}
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.322 -0400", hash_original_method = "72A7028E3449428A8EE1CE440273EEC8", hash_generated_method = "087163CF6E9295B321982617764832A8")
    private int getValueIndex() {
        int var343FBCBF4C59CD973D936304A5C127F2_563519454 = (findIndexOfValue(mValue));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_539562742 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_539562742;
        // ---------- Original Method ----------
        //return findIndexOfValue(mValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.324 -0400", hash_original_method = "6F3CE4AF4F3E6C4B07BCF51D003E1B7E", hash_generated_method = "3114A4970509F69EE8C488178C32F683")
    @Override
    protected void onPrepareDialogBuilder(Builder builder) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(builder.getTaint());
        super.onPrepareDialogBuilder(builder);
        if(mEntries == null || mEntryValues == null)        
        {
            IllegalStateException var6F35E473F86986E34DA9CF072D588836_524305159 = new IllegalStateException(
                    "ListPreference requires an entries array and an entryValues array.");
            var6F35E473F86986E34DA9CF072D588836_524305159.addTaint(taint);
            throw var6F35E473F86986E34DA9CF072D588836_524305159;
        } //End block
        mClickedDialogEntryIndex = getValueIndex();
        builder.setSingleChoiceItems(mEntries, mClickedDialogEntryIndex, 
                new DialogInterface.OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.324 -0400", hash_original_method = "94320A757316F0721659D408D90FCBEE", hash_generated_method = "B684DF1BB9775C019B78194C8D14CB06")
        public void onClick(DialogInterface dialog, int which) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(which);
            addTaint(dialog.getTaint());
            mClickedDialogEntryIndex = which;
            ListPreference.this.onClick(dialog, DialogInterface.BUTTON_POSITIVE);
            dialog.dismiss();
            // ---------- Original Method ----------
            //mClickedDialogEntryIndex = which;
            //ListPreference.this.onClick(dialog, DialogInterface.BUTTON_POSITIVE);
            //dialog.dismiss();
        }
});
        builder.setPositiveButton(null, null);
        // ---------- Original Method ----------
        //super.onPrepareDialogBuilder(builder);
        //if (mEntries == null || mEntryValues == null) {
            //throw new IllegalStateException(
                    //"ListPreference requires an entries array and an entryValues array.");
        //}
        //mClickedDialogEntryIndex = getValueIndex();
        //builder.setSingleChoiceItems(mEntries, mClickedDialogEntryIndex, 
                //new DialogInterface.OnClickListener() {
                    //public void onClick(DialogInterface dialog, int which) {
                        //mClickedDialogEntryIndex = which;
                        //ListPreference.this.onClick(dialog, DialogInterface.BUTTON_POSITIVE);
                        //dialog.dismiss();
                    //}
        //});
        //builder.setPositiveButton(null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.326 -0400", hash_original_method = "CCC14398C5ED43EC620F4801AA3D0865", hash_generated_method = "9AFB137C53B8F0B1F09285172610E472")
    @Override
    protected void onDialogClosed(boolean positiveResult) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(positiveResult);
        super.onDialogClosed(positiveResult);
        if(positiveResult && mClickedDialogEntryIndex >= 0 && mEntryValues != null)        
        {
            String value = mEntryValues[mClickedDialogEntryIndex].toString();
            if(callChangeListener(value))            
            {
                setValue(value);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //super.onDialogClosed(positiveResult);
        //if (positiveResult && mClickedDialogEntryIndex >= 0 && mEntryValues != null) {
            //String value = mEntryValues[mClickedDialogEntryIndex].toString();
            //if (callChangeListener(value)) {
                //setValue(value);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.327 -0400", hash_original_method = "617E38A3300A64CD810B1ADC15B8238E", hash_generated_method = "B7D4EB6AAEB760D2C8C37A504CBADBD0")
    @Override
    protected Object onGetDefaultValue(TypedArray a, int index) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(index);
        addTaint(a.getTaint());
Object var0AC0FFFECD61C5D7F483CEEBDC224FAC_1628873747 =         a.getString(index);
        var0AC0FFFECD61C5D7F483CEEBDC224FAC_1628873747.addTaint(taint);
        return var0AC0FFFECD61C5D7F483CEEBDC224FAC_1628873747;
        // ---------- Original Method ----------
        //return a.getString(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.328 -0400", hash_original_method = "267399412B1F2706B566A7FA45C565D6", hash_generated_method = "2E70A4EC011DBDE8909784007AECB090")
    @Override
    protected void onSetInitialValue(boolean restoreValue, Object defaultValue) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(defaultValue.getTaint());
        addTaint(restoreValue);
        setValue(restoreValue ? getPersistedString(mValue) : (String) defaultValue);
        // ---------- Original Method ----------
        //setValue(restoreValue ? getPersistedString(mValue) : (String) defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.329 -0400", hash_original_method = "D580D34207BE421621E2D4F2F9CC874F", hash_generated_method = "6CA02369EA629B9005CFA08B1D917DAC")
    @Override
    protected Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        final Parcelable superState = super.onSaveInstanceState();
        if(isPersistent())        
        {
Parcelable varBA7A3E641095ABD11C9DBE16D47F122C_710478618 =             superState;
            varBA7A3E641095ABD11C9DBE16D47F122C_710478618.addTaint(taint);
            return varBA7A3E641095ABD11C9DBE16D47F122C_710478618;
        } //End block
        final SavedState myState = new SavedState(superState);
        myState.value = getValue();
Parcelable varA730247CC64767D7A83D25979CFF71FB_2017776165 =         myState;
        varA730247CC64767D7A83D25979CFF71FB_2017776165.addTaint(taint);
        return varA730247CC64767D7A83D25979CFF71FB_2017776165;
        // ---------- Original Method ----------
        //final Parcelable superState = super.onSaveInstanceState();
        //if (isPersistent()) {
            //return superState;
        //}
        //final SavedState myState = new SavedState(superState);
        //myState.value = getValue();
        //return myState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.330 -0400", hash_original_method = "2C7D4FC1A8B86A2A9B820B68195C8000", hash_generated_method = "924E619FB4F0BA5989DB9F361694B328")
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
        setValue(myState.value);
        // ---------- Original Method ----------
        //if (state == null || !state.getClass().equals(SavedState.class)) {
            //super.onRestoreInstanceState(state);
            //return;
        //}
        //SavedState myState = (SavedState) state;
        //super.onRestoreInstanceState(myState.getSuperState());
        //setValue(myState.value);
    }

    
    private static class SavedState extends BaseSavedState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.331 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "EE6B270D979EDA88DA18EA680B9EE570")

        String value;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.332 -0400", hash_original_method = "EB5201084C34C9002E59147CD94E6432", hash_generated_method = "97DF8A5854D440E8F23D4502AA177E01")
        public  SavedState(Parcel source) {
            super(source);
            value = source.readString();
            // ---------- Original Method ----------
            //value = source.readString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.332 -0400", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "AB11810075E98F66089A29D0DD89C4B4")
        public  SavedState(Parcelable superState) {
            super(superState);
            addTaint(superState.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.333 -0400", hash_original_method = "8DFCA3C36BA7A53489D20A0BA4FD0CC0", hash_generated_method = "DFD78310508838EF86747742625B2D7B")
        @Override
        public void writeToParcel(Parcel dest, int flags) {
            addTaint(flags);
            addTaint(dest.getTaint());
            super.writeToParcel(dest, flags);
            dest.writeString(value);
            // ---------- Original Method ----------
            //super.writeToParcel(dest, flags);
            //dest.writeString(value);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.333 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

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

