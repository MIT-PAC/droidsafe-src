package android.preference;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;





public abstract class PreferenceGroup extends Preference implements GenericInflater.Parent<Preference> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.582 -0400", hash_original_field = "49E5F06342B9A756471C57C41582CFFB", hash_generated_field = "18F192958EC897931FD8B3DA5BF85A77")

    private List<Preference> mPreferenceList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.583 -0400", hash_original_field = "BFB6611E214C8472FF036C77EE32C446", hash_generated_field = "C2971599AC8149900D387CCAE8E63B08")

    private boolean mOrderingAsAdded = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.583 -0400", hash_original_field = "04B749A6CF9DDEB82655F535E8D335A2", hash_generated_field = "89C3262ADB33D2CAACE003244FE80C06")

    private int mCurrentPreferenceOrder = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.583 -0400", hash_original_field = "291B1E207D704F5AC4DDD6CA2EB1ACB3", hash_generated_field = "5A686733D92531666006F9E403A759CD")

    private boolean mAttachedToActivity = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.583 -0400", hash_original_method = "8E566EF8D5358FA15B6B3A62F4F4EA92", hash_generated_method = "DD18DE710FB568DD1D3444E9E0E7FC5F")
    public  PreferenceGroup(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        mPreferenceList = new ArrayList<Preference>();
        TypedArray a = context.obtainStyledAttributes(attrs,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.583 -0400", hash_original_method = "88A912CB88465E21C56F7A6B1304F32F", hash_generated_method = "29B21C0176E427C5BA271D642F8B7D5D")
    public  PreferenceGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.584 -0400", hash_original_method = "6CBD3E9C112A20CE725E0B14080873B3", hash_generated_method = "FBB1310A5EFCDF2B72BEFBD717EF881F")
    public void setOrderingAsAdded(boolean orderingAsAdded) {
        mOrderingAsAdded = orderingAsAdded;
        // ---------- Original Method ----------
        //mOrderingAsAdded = orderingAsAdded;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.584 -0400", hash_original_method = "5AE1DA121FD737E8D77F265AA9EE4792", hash_generated_method = "3874DD00630DEBFF5F759BBBD5AACB88")
    public boolean isOrderingAsAdded() {
        boolean var177908C532A27E32AC131CD0F3997D38_1789726556 = (mOrderingAsAdded);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1144887364 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1144887364;
        // ---------- Original Method ----------
        //return mOrderingAsAdded;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.584 -0400", hash_original_method = "DCFB2F7E3F738580B672E91DCD38CF42", hash_generated_method = "8A457159D9977C4A6273F678207C56D9")
    public void addItemFromInflater(Preference preference) {
        addTaint(preference.getTaint());
        addPreference(preference);
        // ---------- Original Method ----------
        //addPreference(preference);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.585 -0400", hash_original_method = "389AB97985CD6F44D465D155E8399BE9", hash_generated_method = "C2062EB5385267385B88AD83A36CA03C")
    public int getPreferenceCount() {
        int varC421430EA712BB31552DDD51082F5040_920431253 = (mPreferenceList.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_825296504 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_825296504;
        // ---------- Original Method ----------
        //return mPreferenceList.size();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.585 -0400", hash_original_method = "109559B57B2B04AB981EEA935073C7C0", hash_generated_method = "751D0AC86407E72D23F6EF226FE22501")
    public Preference getPreference(int index) {
        addTaint(index);
Preference var96B1561EF6B3618DA693F1BA358F1ABA_439023261 =         mPreferenceList.get(index);
        var96B1561EF6B3618DA693F1BA358F1ABA_439023261.addTaint(taint);
        return var96B1561EF6B3618DA693F1BA358F1ABA_439023261;
        // ---------- Original Method ----------
        //return mPreferenceList.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.586 -0400", hash_original_method = "6848FE69024CCCF475A64E7D742A1E83", hash_generated_method = "B1F3A418AE5ACEF3230FC5ED00FC77C2")
    public boolean addPreference(Preference preference) {
        addTaint(preference.getTaint());
        if(mPreferenceList.contains(preference))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_988667061 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_414996786 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_414996786;
        } //End block
        if(preference.getOrder() == Preference.DEFAULT_ORDER)        
        {
            if(mOrderingAsAdded)            
            {
                preference.setOrder(mCurrentPreferenceOrder++);
            } //End block
            if(preference instanceof PreferenceGroup)            
            {
                ((PreferenceGroup)preference).setOrderingAsAdded(mOrderingAsAdded);
            } //End block
        } //End block
        int insertionIndex = Collections.binarySearch(mPreferenceList, preference);
        if(insertionIndex < 0)        
        {
            insertionIndex = insertionIndex * -1 - 1;
        } //End block
        if(!onPrepareAddPreference(preference))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1867491272 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_141758665 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_141758665;
        } //End block
        synchronized
(this)        {
            mPreferenceList.add(insertionIndex, preference);
        } //End block
        preference.onAttachedToHierarchy(getPreferenceManager());
        if(mAttachedToActivity)        
        {
            preference.onAttachedToActivity();
        } //End block
        notifyHierarchyChanged();
        boolean varB326B5062B2F0E69046810717534CB09_1758648206 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_949792327 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_949792327;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.586 -0400", hash_original_method = "72E836216B00BC7CD61ADE8B9836B308", hash_generated_method = "D79D46D10DB02E009965E335C9AE7CA3")
    public boolean removePreference(Preference preference) {
        addTaint(preference.getTaint());
        final boolean returnValue = removePreferenceInt(preference);
        notifyHierarchyChanged();
        boolean varA7E53CE21691AB073D9660D615818899_370810181 = (returnValue);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1174986281 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1174986281;
        // ---------- Original Method ----------
        //final boolean returnValue = removePreferenceInt(preference);
        //notifyHierarchyChanged();
        //return returnValue;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.587 -0400", hash_original_method = "4864D54B8C7134B3A64BC66D9DDCC7C4", hash_generated_method = "62A0AFB42E4528A0A46D36D4E880A9D2")
    private boolean removePreferenceInt(Preference preference) {
        addTaint(preference.getTaint());
        synchronized
(this)        {
            preference.onPrepareForRemoval();
            boolean var31B2B0450D4CA243A322C9DB37C8C3A2_734826142 = (mPreferenceList.remove(preference));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_550955709 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_550955709;
        } //End block
        // ---------- Original Method ----------
        //synchronized(this) {
            //preference.onPrepareForRemoval();
            //return mPreferenceList.remove(preference);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.587 -0400", hash_original_method = "70997B14FB6DABF4C7D8165F55B0B7BF", hash_generated_method = "469366416CA59AC471CBDAF0932018AB")
    public void removeAll() {
        synchronized
(this)        {
            List<Preference> preferenceList = mPreferenceList;
for(int i = preferenceList.size() - 1;i >= 0;i--)
            {
                removePreferenceInt(preferenceList.get(0));
            } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.587 -0400", hash_original_method = "6AE303446925DAEA15C349B1AB59000B", hash_generated_method = "3024F5DC57BCCD9DC9AD6C29264FBD05")
    protected boolean onPrepareAddPreference(Preference preference) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(preference.getTaint());
        if(!super.isEnabled())        
        {
            preference.setEnabled(false);
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1984234168 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1165896351 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1165896351;
        // ---------- Original Method ----------
        //if (!super.isEnabled()) {
            //preference.setEnabled(false);
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.589 -0400", hash_original_method = "28FD4F6AEC9563866A4A8A8A3B9D4A51", hash_generated_method = "6114BE03059F8247AF4DC1F106A62D8F")
    public Preference findPreference(CharSequence key) {
        addTaint(key.getTaint());
        if(TextUtils.equals(getKey(), key))        
        {
Preference var72A74007B2BE62B849F475C7BDA4658B_271939079 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_271939079.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_271939079;
        } //End block
        final int preferenceCount = getPreferenceCount();
for(int i = 0;i < preferenceCount;i++)
        {
            final Preference preference = getPreference(i);
            final String curKey = preference.getKey();
            if(curKey != null && curKey.equals(key))            
            {
Preference var204804AD3E1DAEBFF2B86220D7DC88C3_241034239 =                 preference;
                var204804AD3E1DAEBFF2B86220D7DC88C3_241034239.addTaint(taint);
                return var204804AD3E1DAEBFF2B86220D7DC88C3_241034239;
            } //End block
            if(preference instanceof PreferenceGroup)            
            {
                final Preference returnedPreference = ((PreferenceGroup)preference)
                        .findPreference(key);
                if(returnedPreference != null)                
                {
Preference var0209C10F4B49591A05081D121FCC5A8D_665849559 =                     returnedPreference;
                    var0209C10F4B49591A05081D121FCC5A8D_665849559.addTaint(taint);
                    return var0209C10F4B49591A05081D121FCC5A8D_665849559;
                } //End block
            } //End block
        } //End block
Preference var540C13E9E156B687226421B24F2DF178_1696127965 =         null;
        var540C13E9E156B687226421B24F2DF178_1696127965.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1696127965;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.590 -0400", hash_original_method = "DAC56CE9E9B1E4D46C67382001476B7D", hash_generated_method = "7441CC1AC85D563BB57EB341DC1EB661")
    protected boolean isOnSameScreenAsChildren() {
        boolean varB326B5062B2F0E69046810717534CB09_243413166 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1553139482 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1553139482;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.590 -0400", hash_original_method = "1FE8E9DF20201DB390C6CDB4B44A4648", hash_generated_method = "A81E485AFA3FF1DFDA41504943B7800E")
    @Override
    protected void onAttachedToActivity() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAttachedToActivity();
        mAttachedToActivity = true;
        final int preferenceCount = getPreferenceCount();
for(int i = 0;i < preferenceCount;i++)
        {
            getPreference(i).onAttachedToActivity();
        } //End block
        // ---------- Original Method ----------
        //super.onAttachedToActivity();
        //mAttachedToActivity = true;
        //final int preferenceCount = getPreferenceCount();
        //for (int i = 0; i < preferenceCount; i++) {
            //getPreference(i).onAttachedToActivity();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.591 -0400", hash_original_method = "3A7D9D1FD83E5C89A0E712EE5F3DBB8B", hash_generated_method = "A9FE2CD2FBC3C91399937F271D4EC0AC")
    @Override
    protected void onPrepareForRemoval() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onPrepareForRemoval();
        mAttachedToActivity = false;
        // ---------- Original Method ----------
        //super.onPrepareForRemoval();
        //mAttachedToActivity = false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.591 -0400", hash_original_method = "10614F6B57E80AB6C964E551AE06AF94", hash_generated_method = "39BE01D538FACB38C87A7BE85A499456")
    @Override
    public void setEnabled(boolean enabled) {
        addTaint(enabled);
        super.setEnabled(enabled);
        final int preferenceCount = getPreferenceCount();
for(int i = 0;i < preferenceCount;i++)
        {
            getPreference(i).setEnabled(enabled);
        } //End block
        // ---------- Original Method ----------
        //super.setEnabled(enabled);
        //final int preferenceCount = getPreferenceCount();
        //for (int i = 0; i < preferenceCount; i++) {
            //getPreference(i).setEnabled(enabled);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.591 -0400", hash_original_method = "8DBDAE7DDABF4AEFA524423E392EC9C9", hash_generated_method = "96B131528306350140BAFEADCD443D97")
     void sortPreferences() {
        synchronized
(this)        {
            Collections.sort(mPreferenceList);
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //Collections.sort(mPreferenceList);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.592 -0400", hash_original_method = "62B814BB73D262A241B770A4F50FC903", hash_generated_method = "087684931AE1AE642EEFD82F6B190DD8")
    @Override
    protected void dispatchSaveInstanceState(Bundle container) {
        addTaint(container.getTaint());
        super.dispatchSaveInstanceState(container);
        final int preferenceCount = getPreferenceCount();
for(int i = 0;i < preferenceCount;i++)
        {
            getPreference(i).dispatchSaveInstanceState(container);
        } //End block
        // ---------- Original Method ----------
        //super.dispatchSaveInstanceState(container);
        //final int preferenceCount = getPreferenceCount();
        //for (int i = 0; i < preferenceCount; i++) {
            //getPreference(i).dispatchSaveInstanceState(container);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.592 -0400", hash_original_method = "F1DE64EBADCED3709EBA936E1D8777C2", hash_generated_method = "E8E0ED1FBC3EE7AD29DF562739797612")
    @Override
    protected void dispatchRestoreInstanceState(Bundle container) {
        addTaint(container.getTaint());
        super.dispatchRestoreInstanceState(container);
        final int preferenceCount = getPreferenceCount();
for(int i = 0;i < preferenceCount;i++)
        {
            getPreference(i).dispatchRestoreInstanceState(container);
        } //End block
        // ---------- Original Method ----------
        //super.dispatchRestoreInstanceState(container);
        //final int preferenceCount = getPreferenceCount();
        //for (int i = 0; i < preferenceCount; i++) {
            //getPreference(i).dispatchRestoreInstanceState(container);
        //}
    }

    
}

