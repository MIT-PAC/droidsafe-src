package android.preference;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.319 -0400", hash_original_field = "A2A3482E1757A40787036BBDB9FBE706", hash_generated_field = "4FC648754770C3205F9446C9F7605834")

    private CharSequence[] mEntries;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.319 -0400", hash_original_field = "9AC5F83BDA028FF60DFC91B64DF2F656", hash_generated_field = "486CAA606E1574F138C16E77F1B9619F")

    private CharSequence[] mEntryValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.319 -0400", hash_original_field = "CBAFE11E7BAE23358D70D54D132C3064", hash_generated_field = "FA33B8039DB7AC1B219DF637773A1B0E")

    private String mValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.319 -0400", hash_original_field = "364E1929FED648A0A411C548B6A6CE28", hash_generated_field = "6DB7061A14FC4D33EA524963BB16CF57")

    private String mSummary;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.319 -0400", hash_original_field = "D67DCB4D6296848E78093D2EF37CA2F4", hash_generated_field = "B7DEBD301D0CCED616CB72A3C559E310")

    private int mClickedDialogEntryIndex;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.320 -0400", hash_original_method = "2CB69D78EE187D68AAE6FD5CB1694152", hash_generated_method = "08A497F5BDFC819DA39063BDC08E510E")
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
        
        
                
        
        
        
        
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.321 -0400", hash_original_method = "EFEFAC33FEDF5CFCCDC225AF06B658FF", hash_generated_method = "25239011DAC03D575E85B0D1ECC95906")
    public  ListPreference(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.321 -0400", hash_original_method = "92444C405286C6A282911C360FA1B20D", hash_generated_method = "C62CC4A5A33DFC543ABA49B4451B21C1")
    public void setEntries(CharSequence[] entries) {
        mEntries = entries;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.322 -0400", hash_original_method = "F8AB6256811E3BA7AD610D04605DBEC4", hash_generated_method = "7F29CDDA2E6A00E5FD60C5EACAC3FE19")
    public void setEntries(int entriesResId) {
        addTaint(entriesResId);
        setEntries(getContext().getResources().getTextArray(entriesResId));
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.322 -0400", hash_original_method = "F69A5267D165BB7292A2F7B29A70DF84", hash_generated_method = "F4E764D0D82E0F9A101A2AD676EAA13C")
    public CharSequence[] getEntries() {
CharSequence[] varDFEB20DF106F6A2CD6E980CC40196305_1253586815 =         mEntries;
        varDFEB20DF106F6A2CD6E980CC40196305_1253586815.addTaint(taint);
        return varDFEB20DF106F6A2CD6E980CC40196305_1253586815;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.322 -0400", hash_original_method = "33C67F5304EFCF57E93FE56574A29FD8", hash_generated_method = "784E1B92FE82DF1BFF22EEB8A8902145")
    public void setEntryValues(CharSequence[] entryValues) {
        mEntryValues = entryValues;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.323 -0400", hash_original_method = "7F861B3AE1A834F9F6742B52B4830C35", hash_generated_method = "6DAF9580580CE2E0BA959DDF93D45C34")
    public void setEntryValues(int entryValuesResId) {
        addTaint(entryValuesResId);
        setEntryValues(getContext().getResources().getTextArray(entryValuesResId));
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.323 -0400", hash_original_method = "4077A49F0088F4F9F53375DFF9727B97", hash_generated_method = "BA24D96577B1528C7F5E8A5E9FD47BCA")
    public CharSequence[] getEntryValues() {
CharSequence[] var8191EBE8B88208B04001F3EB9757A462_513535984 =         mEntryValues;
        var8191EBE8B88208B04001F3EB9757A462_513535984.addTaint(taint);
        return var8191EBE8B88208B04001F3EB9757A462_513535984;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.323 -0400", hash_original_method = "C381E833D619D719391B620073306BFE", hash_generated_method = "A041F9E43957DB69CEF4AD3D2F625BA5")
    public void setValue(String value) {
        mValue = value;
        persistString(value);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.324 -0400", hash_original_method = "C91AC61B4049FB662B529C1D1FF98F02", hash_generated_method = "8601236892856C5491FB60A8D27D6183")
    @Override
    public CharSequence getSummary() {
        final CharSequence entry = getEntry();
    if(mSummary == null || entry == null)        
        {
CharSequence var360515AA178D28B01C4528F92C4DD1E1_1766404663 =             super.getSummary();
            var360515AA178D28B01C4528F92C4DD1E1_1766404663.addTaint(taint);
            return var360515AA178D28B01C4528F92C4DD1E1_1766404663;
        } 
        else
        {
CharSequence varB94F03AB2102AC083EBCD479B7D73881_1183870725 =             String.format(mSummary, entry);
            varB94F03AB2102AC083EBCD479B7D73881_1183870725.addTaint(taint);
            return varB94F03AB2102AC083EBCD479B7D73881_1183870725;
        } 
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.324 -0400", hash_original_method = "4C1B142B1B7C5EA1E6C6981CF6E13968", hash_generated_method = "F2567B4C67BA8A6BC5319A5FD8656F75")
    @Override
    public void setSummary(CharSequence summary) {
        super.setSummary(summary);
    if(summary == null && mSummary != null)        
        {
            mSummary = null;
        } 
        else
    if(summary != null && !summary.equals(mSummary))        
        {
            mSummary = summary.toString();
        } 
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.324 -0400", hash_original_method = "BCD9DE4E5FC7BA2AD13976209DEB6B06", hash_generated_method = "D8EE9CF7614CCBD13236BDD5B06EA6B5")
    public void setValueIndex(int index) {
        addTaint(index);
    if(mEntryValues != null)        
        {
            setValue(mEntryValues[index].toString());
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.325 -0400", hash_original_method = "20F1B7D715A473C2ABE076C27B2A3109", hash_generated_method = "0EFC7B214082BF2FB4D9BB07AB2A004C")
    public String getValue() {
String varD1FEA3F5EE4618A9C3646312F018E4AC_903727116 =         mValue;
        varD1FEA3F5EE4618A9C3646312F018E4AC_903727116.addTaint(taint);
        return varD1FEA3F5EE4618A9C3646312F018E4AC_903727116;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.325 -0400", hash_original_method = "70FF40F71A0C525EB8753661CD710EE3", hash_generated_method = "8FCB8AF288E6999981EC449FB9F87B73")
    public CharSequence getEntry() {
        int index = getValueIndex();
CharSequence varCFEC00F16F2300EEED067902F15C00E3_1560493708 =         index >= 0 && mEntries != null ? mEntries[index] : null;
        varCFEC00F16F2300EEED067902F15C00E3_1560493708.addTaint(taint);
        return varCFEC00F16F2300EEED067902F15C00E3_1560493708;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.325 -0400", hash_original_method = "4E596FDEE64331A25D2B8DFD1BC8797E", hash_generated_method = "43832613F5889951874B34362EE5A193")
    public int findIndexOfValue(String value) {
        addTaint(value.getTaint());
    if(value != null && mEntryValues != null)        
        {
for(int i = mEntryValues.length - 1;i >= 0;i--)
            {
    if(mEntryValues[i].equals(value))                
                {
                    int var865C0C0B4AB0E063E5CAA3387C1A8741_396658158 = (i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1661749716 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1661749716;
                } 
            } 
        } 
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1307081249 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1104752560 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1104752560;
        
        
            
                
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.326 -0400", hash_original_method = "72A7028E3449428A8EE1CE440273EEC8", hash_generated_method = "1F0BFA8F134EDF6A16073CF2748183B9")
    private int getValueIndex() {
        int var343FBCBF4C59CD973D936304A5C127F2_574733738 = (findIndexOfValue(mValue));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_223190855 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_223190855;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.327 -0400", hash_original_method = "6F3CE4AF4F3E6C4B07BCF51D003E1B7E", hash_generated_method = "AF844631D932DC17246C5DC84557E9DA")
    @Override
    protected void onPrepareDialogBuilder(Builder builder) {
        
        addTaint(builder.getTaint());
        super.onPrepareDialogBuilder(builder);
    if(mEntries == null || mEntryValues == null)        
        {
            IllegalStateException var6F35E473F86986E34DA9CF072D588836_252451286 = new IllegalStateException(
                    "ListPreference requires an entries array and an entryValues array.");
            var6F35E473F86986E34DA9CF072D588836_252451286.addTaint(taint);
            throw var6F35E473F86986E34DA9CF072D588836_252451286;
        } 
        mClickedDialogEntryIndex = getValueIndex();
        builder.setSingleChoiceItems(mEntries, mClickedDialogEntryIndex, 
                new DialogInterface.OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.327 -0400", hash_original_method = "94320A757316F0721659D408D90FCBEE", hash_generated_method = "B684DF1BB9775C019B78194C8D14CB06")
        public void onClick(DialogInterface dialog, int which) {
            
            addTaint(which);
            addTaint(dialog.getTaint());
            mClickedDialogEntryIndex = which;
            ListPreference.this.onClick(dialog, DialogInterface.BUTTON_POSITIVE);
            dialog.dismiss();
            
            
            
            
        }
});
        builder.setPositiveButton(null, null);
        
        
        
            
                    
        
        
        
                
                    
                        
                        
                        
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.327 -0400", hash_original_method = "CCC14398C5ED43EC620F4801AA3D0865", hash_generated_method = "9AFB137C53B8F0B1F09285172610E472")
    @Override
    protected void onDialogClosed(boolean positiveResult) {
        
        addTaint(positiveResult);
        super.onDialogClosed(positiveResult);
    if(positiveResult && mClickedDialogEntryIndex >= 0 && mEntryValues != null)        
        {
            String value = mEntryValues[mClickedDialogEntryIndex].toString();
    if(callChangeListener(value))            
            {
                setValue(value);
            } 
        } 
        
        
        
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.328 -0400", hash_original_method = "617E38A3300A64CD810B1ADC15B8238E", hash_generated_method = "2A24DB9571BCA4A37E48FB7643C4DC27")
    @Override
    protected Object onGetDefaultValue(TypedArray a, int index) {
        
        addTaint(index);
        addTaint(a.getTaint());
Object var0AC0FFFECD61C5D7F483CEEBDC224FAC_416145351 =         a.getString(index);
        var0AC0FFFECD61C5D7F483CEEBDC224FAC_416145351.addTaint(taint);
        return var0AC0FFFECD61C5D7F483CEEBDC224FAC_416145351;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.328 -0400", hash_original_method = "267399412B1F2706B566A7FA45C565D6", hash_generated_method = "2E70A4EC011DBDE8909784007AECB090")
    @Override
    protected void onSetInitialValue(boolean restoreValue, Object defaultValue) {
        
        addTaint(defaultValue.getTaint());
        addTaint(restoreValue);
        setValue(restoreValue ? getPersistedString(mValue) : (String) defaultValue);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.328 -0400", hash_original_method = "D580D34207BE421621E2D4F2F9CC874F", hash_generated_method = "63EE87681021D8115DAA05D1A9311FEF")
    @Override
    protected Parcelable onSaveInstanceState() {
        
        final Parcelable superState = super.onSaveInstanceState();
    if(isPersistent())        
        {
Parcelable varBA7A3E641095ABD11C9DBE16D47F122C_1798100305 =             superState;
            varBA7A3E641095ABD11C9DBE16D47F122C_1798100305.addTaint(taint);
            return varBA7A3E641095ABD11C9DBE16D47F122C_1798100305;
        } 
        final SavedState myState = new SavedState(superState);
        myState.value = getValue();
Parcelable varA730247CC64767D7A83D25979CFF71FB_477283659 =         myState;
        varA730247CC64767D7A83D25979CFF71FB_477283659.addTaint(taint);
        return varA730247CC64767D7A83D25979CFF71FB_477283659;
        
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.329 -0400", hash_original_method = "2C7D4FC1A8B86A2A9B820B68195C8000", hash_generated_method = "924E619FB4F0BA5989DB9F361694B328")
    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        
        addTaint(state.getTaint());
    if(state == null || !state.getClass().equals(SavedState.class))        
        {
            super.onRestoreInstanceState(state);
            return;
        } 
        SavedState myState = (SavedState) state;
        super.onRestoreInstanceState(myState.getSuperState());
        setValue(myState.value);
        
        
            
            
        
        
        
        
    }

    
    private static class SavedState extends BaseSavedState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.329 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "EE6B270D979EDA88DA18EA680B9EE570")

        String value;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.329 -0400", hash_original_method = "EB5201084C34C9002E59147CD94E6432", hash_generated_method = "97DF8A5854D440E8F23D4502AA177E01")
        public  SavedState(Parcel source) {
            super(source);
            value = source.readString();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.329 -0400", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "AB11810075E98F66089A29D0DD89C4B4")
        public  SavedState(Parcelable superState) {
            super(superState);
            addTaint(superState.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.330 -0400", hash_original_method = "8DFCA3C36BA7A53489D20A0BA4FD0CC0", hash_generated_method = "DFD78310508838EF86747742625B2D7B")
        @Override
        public void writeToParcel(Parcel dest, int flags) {
            addTaint(flags);
            addTaint(dest.getTaint());
            super.writeToParcel(dest, flags);
            dest.writeString(value);
            
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.330 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

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

