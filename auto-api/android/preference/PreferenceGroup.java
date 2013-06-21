package android.preference;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;

public abstract class PreferenceGroup extends Preference implements GenericInflater.Parent<Preference> {
    private List<Preference> mPreferenceList;
    private boolean mOrderingAsAdded = true;
    private int mCurrentPreferenceOrder = 0;
    private boolean mAttachedToActivity = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.656 -0400", hash_original_method = "8E566EF8D5358FA15B6B3A62F4F4EA92", hash_generated_method = "3CFD71CF7378974FE4EAA662880A25B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PreferenceGroup(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        mPreferenceList = new ArrayList<Preference>();
        TypedArray a;
        a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.PreferenceGroup, defStyle, 0);
        mOrderingAsAdded = a.getBoolean(com.android.internal.R.styleable.PreferenceGroup_orderingFromXml,
                mOrderingAsAdded);
        a.recycle();
        // ---------- Original Method ----------
        //mPreferenceList = new ArrayList<Preference>();
        //TypedArray a = context.obtainStyledAttributes(attrs,
                //com.android.internal.R.styleable.PreferenceGroup, defStyle, 0);
        //mOrderingAsAdded = a.getBoolean(com.android.internal.R.styleable.PreferenceGroup_orderingFromXml,
                //mOrderingAsAdded);
        //a.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.656 -0400", hash_original_method = "88A912CB88465E21C56F7A6B1304F32F", hash_generated_method = "74AC582E5E644D98662465340B5C9A6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PreferenceGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.657 -0400", hash_original_method = "6CBD3E9C112A20CE725E0B14080873B3", hash_generated_method = "09651E6400738A3DC24DAE1C4C494E95")
    @DSModeled(DSC.SAFE)
    public void setOrderingAsAdded(boolean orderingAsAdded) {
        dsTaint.addTaint(orderingAsAdded);
        // ---------- Original Method ----------
        //mOrderingAsAdded = orderingAsAdded;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.657 -0400", hash_original_method = "5AE1DA121FD737E8D77F265AA9EE4792", hash_generated_method = "E8BFFFF3995B08EFEB9A9A5552A32265")
    @DSModeled(DSC.SAFE)
    public boolean isOrderingAsAdded() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mOrderingAsAdded;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.657 -0400", hash_original_method = "DCFB2F7E3F738580B672E91DCD38CF42", hash_generated_method = "4E85808E2D2DF056610A7D1F5653D4B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addItemFromInflater(Preference preference) {
        dsTaint.addTaint(preference.dsTaint);
        addPreference(preference);
        // ---------- Original Method ----------
        //addPreference(preference);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.657 -0400", hash_original_method = "389AB97985CD6F44D465D155E8399BE9", hash_generated_method = "C943AA0322559726B7C6B394A9F709F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPreferenceCount() {
        int var0BB871AF6B245B4A49AE35894863E9A5_1228726415 = (mPreferenceList.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPreferenceList.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.658 -0400", hash_original_method = "109559B57B2B04AB981EEA935073C7C0", hash_generated_method = "172150BEED3E63C0C3383DC3183B8C36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Preference getPreference(int index) {
        dsTaint.addTaint(index);
        Preference var27F7A9065E2B8BA2F3DCD0DCBE17A675_1802191475 = (mPreferenceList.get(index));
        return (Preference)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mPreferenceList.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.658 -0400", hash_original_method = "6848FE69024CCCF475A64E7D742A1E83", hash_generated_method = "B8166A525F2BFA5C44D7DA6BE89B7C7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean addPreference(Preference preference) {
        dsTaint.addTaint(preference.dsTaint);
        {
            boolean varAA49CA455D741C477FFE8ADBFBD323F3_586017984 = (mPreferenceList.contains(preference));
        } //End collapsed parenthetic
        {
            boolean var5A335D067A83D83A8F4AC2D05532A103_424582454 = (preference.getOrder() == Preference.DEFAULT_ORDER);
            {
                {
                    preference.setOrder(mCurrentPreferenceOrder++);
                } //End block
                {
                    ((PreferenceGroup)preference).setOrderingAsAdded(mOrderingAsAdded);
                } //End block
            } //End block
        } //End collapsed parenthetic
        int insertionIndex;
        insertionIndex = Collections.binarySearch(mPreferenceList, preference);
        {
            insertionIndex = insertionIndex * -1 - 1;
        } //End block
        {
            boolean var756FE1F14894C08F38E5223F62838CF6_1908238628 = (!onPrepareAddPreference(preference));
        } //End collapsed parenthetic
        {
            mPreferenceList.add(insertionIndex, preference);
        } //End block
        preference.onAttachedToHierarchy(getPreferenceManager());
        {
            preference.onAttachedToActivity();
        } //End block
        notifyHierarchyChanged();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.658 -0400", hash_original_method = "72E836216B00BC7CD61ADE8B9836B308", hash_generated_method = "EFB9C3948E3E6B224D9B58BD76A7577B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean removePreference(Preference preference) {
        dsTaint.addTaint(preference.dsTaint);
        boolean returnValue;
        returnValue = removePreferenceInt(preference);
        notifyHierarchyChanged();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final boolean returnValue = removePreferenceInt(preference);
        //notifyHierarchyChanged();
        //return returnValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.659 -0400", hash_original_method = "4864D54B8C7134B3A64BC66D9DDCC7C4", hash_generated_method = "6FE840F0314E5D52C7211C5048461836")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean removePreferenceInt(Preference preference) {
        dsTaint.addTaint(preference.dsTaint);
        {
            preference.onPrepareForRemoval();
            boolean var1D2497A5EDC86D7B9B13C1103199C646_918149956 = (mPreferenceList.remove(preference));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized(this) {
            //preference.onPrepareForRemoval();
            //return mPreferenceList.remove(preference);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.659 -0400", hash_original_method = "70997B14FB6DABF4C7D8165F55B0B7BF", hash_generated_method = "4D740DCB50E421630D4716D5BAA06C83")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeAll() {
        {
            List<Preference> preferenceList;
            preferenceList = mPreferenceList;
            {
                int i;
                i = preferenceList.size() - 1;
                {
                    removePreferenceInt(preferenceList.get(0));
                } //End block
            } //End collapsed parenthetic
        } //End block
        notifyHierarchyChanged();
        // ---------- Original Method ----------
        //synchronized(this) {
            //List<Preference> preferenceList = mPreferenceList;
            //for (int i = preferenceList.size() - 1; i >= 0; i--) {
                //removePreferenceInt(preferenceList.get(0));
            //}
        //}
        //notifyHierarchyChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.660 -0400", hash_original_method = "6AE303446925DAEA15C349B1AB59000B", hash_generated_method = "A9EE48112E6919D7DCF986A2832E5E1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean onPrepareAddPreference(Preference preference) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(preference.dsTaint);
        {
            boolean var51D4CB112DEF9326A450B864472CC55B_142337310 = (!super.isEnabled());
            {
                preference.setEnabled(false);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!super.isEnabled()) {
            //preference.setEnabled(false);
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.660 -0400", hash_original_method = "28FD4F6AEC9563866A4A8A8A3B9D4A51", hash_generated_method = "0EBCCF74CA4E322156C786CEDA68A432")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Preference findPreference(CharSequence key) {
        dsTaint.addTaint(key);
        {
            boolean var88F3B56867814E544B1683E80DFE607F_210204957 = (TextUtils.equals(getKey(), key));
        } //End collapsed parenthetic
        int preferenceCount;
        preferenceCount = getPreferenceCount();
        {
            int i;
            i = 0;
            {
                Preference preference;
                preference = getPreference(i);
                String curKey;
                curKey = preference.getKey();
                {
                    boolean var0241FC8FE55008008E20898BB849D89C_1659516880 = (curKey != null && curKey.equals(key));
                } //End collapsed parenthetic
                {
                    Preference returnedPreference;
                    returnedPreference = ((PreferenceGroup)preference)
                        .findPreference(key);
                } //End block
            } //End block
        } //End collapsed parenthetic
        return (Preference)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (TextUtils.equals(getKey(), key)) {
            //return this;
        //}
        //final int preferenceCount = getPreferenceCount();
        //for (int i = 0; i < preferenceCount; i++) {
            //final Preference preference = getPreference(i);
            //final String curKey = preference.getKey();
            //if (curKey != null && curKey.equals(key)) {
                //return preference;
            //}
            //if (preference instanceof PreferenceGroup) {
                //final Preference returnedPreference = ((PreferenceGroup)preference)
                        //.findPreference(key);
                //if (returnedPreference != null) {
                    //return returnedPreference;
                //}
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.660 -0400", hash_original_method = "DAC56CE9E9B1E4D46C67382001476B7D", hash_generated_method = "B57D9007B230A3231ACE0F16BB214564")
    @DSModeled(DSC.SAFE)
    protected boolean isOnSameScreenAsChildren() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.661 -0400", hash_original_method = "1FE8E9DF20201DB390C6CDB4B44A4648", hash_generated_method = "217CFC112EC30BD5800D4038D3450227")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onAttachedToActivity() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAttachedToActivity();
        mAttachedToActivity = true;
        int preferenceCount;
        preferenceCount = getPreferenceCount();
        {
            int i;
            i = 0;
            {
                getPreference(i).onAttachedToActivity();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.onAttachedToActivity();
        //mAttachedToActivity = true;
        //final int preferenceCount = getPreferenceCount();
        //for (int i = 0; i < preferenceCount; i++) {
            //getPreference(i).onAttachedToActivity();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.661 -0400", hash_original_method = "3A7D9D1FD83E5C89A0E712EE5F3DBB8B", hash_generated_method = "A9FE2CD2FBC3C91399937F271D4EC0AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onPrepareForRemoval() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onPrepareForRemoval();
        mAttachedToActivity = false;
        // ---------- Original Method ----------
        //super.onPrepareForRemoval();
        //mAttachedToActivity = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.661 -0400", hash_original_method = "10614F6B57E80AB6C964E551AE06AF94", hash_generated_method = "DC2D95E1B2B2899347B3AAC1760F9C41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        super.setEnabled(enabled);
        int preferenceCount;
        preferenceCount = getPreferenceCount();
        {
            int i;
            i = 0;
            {
                getPreference(i).setEnabled(enabled);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.setEnabled(enabled);
        //final int preferenceCount = getPreferenceCount();
        //for (int i = 0; i < preferenceCount; i++) {
            //getPreference(i).setEnabled(enabled);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.662 -0400", hash_original_method = "8DBDAE7DDABF4AEFA524423E392EC9C9", hash_generated_method = "243BA09E7EDBC4A38A7B4E7339AB87BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void sortPreferences() {
        {
            Collections.sort(mPreferenceList);
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //Collections.sort(mPreferenceList);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.662 -0400", hash_original_method = "62B814BB73D262A241B770A4F50FC903", hash_generated_method = "E0C987E6EC736F35BEF5E321842DB026")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void dispatchSaveInstanceState(Bundle container) {
        dsTaint.addTaint(container.dsTaint);
        super.dispatchSaveInstanceState(container);
        int preferenceCount;
        preferenceCount = getPreferenceCount();
        {
            int i;
            i = 0;
            {
                getPreference(i).dispatchSaveInstanceState(container);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.dispatchSaveInstanceState(container);
        //final int preferenceCount = getPreferenceCount();
        //for (int i = 0; i < preferenceCount; i++) {
            //getPreference(i).dispatchSaveInstanceState(container);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.662 -0400", hash_original_method = "F1DE64EBADCED3709EBA936E1D8777C2", hash_generated_method = "29B3354649A35209D00C5CEF88D81E98")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void dispatchRestoreInstanceState(Bundle container) {
        dsTaint.addTaint(container.dsTaint);
        super.dispatchRestoreInstanceState(container);
        int preferenceCount;
        preferenceCount = getPreferenceCount();
        {
            int i;
            i = 0;
            {
                getPreference(i).dispatchRestoreInstanceState(container);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.dispatchRestoreInstanceState(container);
        //final int preferenceCount = getPreferenceCount();
        //for (int i = 0; i < preferenceCount; i++) {
            //getPreference(i).dispatchRestoreInstanceState(container);
        //}
    }

    
}

