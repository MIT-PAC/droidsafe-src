package android.preference;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.443 -0400", hash_original_field = "49E5F06342B9A756471C57C41582CFFB", hash_generated_field = "18F192958EC897931FD8B3DA5BF85A77")

    private List<Preference> mPreferenceList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.443 -0400", hash_original_field = "BFB6611E214C8472FF036C77EE32C446", hash_generated_field = "C2971599AC8149900D387CCAE8E63B08")

    private boolean mOrderingAsAdded = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.443 -0400", hash_original_field = "04B749A6CF9DDEB82655F535E8D335A2", hash_generated_field = "89C3262ADB33D2CAACE003244FE80C06")

    private int mCurrentPreferenceOrder = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.443 -0400", hash_original_field = "291B1E207D704F5AC4DDD6CA2EB1ACB3", hash_generated_field = "5A686733D92531666006F9E403A759CD")

    private boolean mAttachedToActivity = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.443 -0400", hash_original_method = "8E566EF8D5358FA15B6B3A62F4F4EA92", hash_generated_method = "D58739CB5BA989893A47946759C5ABE8")
    public  PreferenceGroup(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mPreferenceList = new ArrayList<Preference>();
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.PreferenceGroup, defStyle, 0);
        mOrderingAsAdded = a.getBoolean(com.android.internal.R.styleable.PreferenceGroup_orderingFromXml,
                mOrderingAsAdded);
        a.recycle();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        
        
        
                
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.444 -0400", hash_original_method = "88A912CB88465E21C56F7A6B1304F32F", hash_generated_method = "7B856457141458BC85CD92B1486A591C")
    public  PreferenceGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.444 -0400", hash_original_method = "6CBD3E9C112A20CE725E0B14080873B3", hash_generated_method = "FBB1310A5EFCDF2B72BEFBD717EF881F")
    public void setOrderingAsAdded(boolean orderingAsAdded) {
        mOrderingAsAdded = orderingAsAdded;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.445 -0400", hash_original_method = "5AE1DA121FD737E8D77F265AA9EE4792", hash_generated_method = "20539B9454DC789D271BB2DEB70F31D8")
    public boolean isOrderingAsAdded() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_615480814 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_615480814;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.445 -0400", hash_original_method = "DCFB2F7E3F738580B672E91DCD38CF42", hash_generated_method = "712FAC34D063796FEB63E5648E112F69")
    public void addItemFromInflater(Preference preference) {
        addPreference(preference);
        addTaint(preference.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.445 -0400", hash_original_method = "389AB97985CD6F44D465D155E8399BE9", hash_generated_method = "3370C54B24CF58F2495F9546EA3148B6")
    public int getPreferenceCount() {
        int var0BB871AF6B245B4A49AE35894863E9A5_1157696672 = (mPreferenceList.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_710973485 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_710973485;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.446 -0400", hash_original_method = "109559B57B2B04AB981EEA935073C7C0", hash_generated_method = "50874C27B79CB2864AB9EC6D28CE3F1A")
    public Preference getPreference(int index) {
        Preference varB4EAC82CA7396A68D541C85D26508E83_640142517 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_640142517 = mPreferenceList.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_640142517.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_640142517;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.447 -0400", hash_original_method = "6848FE69024CCCF475A64E7D742A1E83", hash_generated_method = "B52619591ADBCDE8B95D14D2CC80AB2E")
    public boolean addPreference(Preference preference) {
        {
            boolean varAA49CA455D741C477FFE8ADBFBD323F3_783520417 = (mPreferenceList.contains(preference));
        } 
        {
            boolean var5A335D067A83D83A8F4AC2D05532A103_1876165265 = (preference.getOrder() == Preference.DEFAULT_ORDER);
            {
                {
                    preference.setOrder(mCurrentPreferenceOrder++);
                } 
                {
                    ((PreferenceGroup)preference).setOrderingAsAdded(mOrderingAsAdded);
                } 
            } 
        } 
        int insertionIndex = Collections.binarySearch(mPreferenceList, preference);
        {
            insertionIndex = insertionIndex * -1 - 1;
        } 
        {
            boolean var756FE1F14894C08F38E5223F62838CF6_1113416928 = (!onPrepareAddPreference(preference));
        } 
        {
            mPreferenceList.add(insertionIndex, preference);
        } 
        preference.onAttachedToHierarchy(getPreferenceManager());
        {
            preference.onAttachedToActivity();
        } 
        notifyHierarchyChanged();
        addTaint(preference.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_840974583 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_840974583;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.447 -0400", hash_original_method = "72E836216B00BC7CD61ADE8B9836B308", hash_generated_method = "272B6FEA3B0E640D18FD87C846373493")
    public boolean removePreference(Preference preference) {
        final boolean returnValue = removePreferenceInt(preference);
        notifyHierarchyChanged();
        addTaint(preference.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_488322014 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_488322014;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.448 -0400", hash_original_method = "4864D54B8C7134B3A64BC66D9DDCC7C4", hash_generated_method = "840105DFA5EE6FFAB872877B916F66B9")
    private boolean removePreferenceInt(Preference preference) {
        {
            preference.onPrepareForRemoval();
            boolean var1D2497A5EDC86D7B9B13C1103199C646_252493078 = (mPreferenceList.remove(preference));
        } 
        addTaint(preference.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_667195326 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_667195326;
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.448 -0400", hash_original_method = "70997B14FB6DABF4C7D8165F55B0B7BF", hash_generated_method = "0279F38C368E2296A5ACE3DC3A0D4F09")
    public void removeAll() {
        {
            List<Preference> preferenceList = mPreferenceList;
            {
                int i = preferenceList.size() - 1;
                {
                    removePreferenceInt(preferenceList.get(0));
                } 
            } 
        } 
        notifyHierarchyChanged();
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.449 -0400", hash_original_method = "6AE303446925DAEA15C349B1AB59000B", hash_generated_method = "856619832867906C52B850A00B4A8DED")
    protected boolean onPrepareAddPreference(Preference preference) {
        
        {
            boolean var51D4CB112DEF9326A450B864472CC55B_2028387119 = (!super.isEnabled());
            {
                preference.setEnabled(false);
            } 
        } 
        addTaint(preference.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_585064593 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_585064593;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.449 -0400", hash_original_method = "28FD4F6AEC9563866A4A8A8A3B9D4A51", hash_generated_method = "750F40435CC59464D32DD9B06A2D7DCF")
    public Preference findPreference(CharSequence key) {
        Preference varB4EAC82CA7396A68D541C85D26508E83_426350234 = null; 
        Preference varB4EAC82CA7396A68D541C85D26508E83_1255538870 = null; 
        Preference varB4EAC82CA7396A68D541C85D26508E83_1417630891 = null; 
        Preference varB4EAC82CA7396A68D541C85D26508E83_156091160 = null; 
        {
            boolean var88F3B56867814E544B1683E80DFE607F_1318163271 = (TextUtils.equals(getKey(), key));
            {
                varB4EAC82CA7396A68D541C85D26508E83_426350234 = this;
            } 
        } 
        final int preferenceCount = getPreferenceCount();
        {
            int i = 0;
            {
                final Preference preference = getPreference(i);
                final String curKey = preference.getKey();
                {
                    boolean var0241FC8FE55008008E20898BB849D89C_776716819 = (curKey != null && curKey.equals(key));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1255538870 = preference;
                    } 
                } 
                {
                    final Preference returnedPreference = ((PreferenceGroup)preference)
                        .findPreference(key);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1417630891 = returnedPreference;
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_156091160 = null;
        addTaint(key.getTaint());
        Preference varA7E53CE21691AB073D9660D615818899_966047440; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_966047440 = varB4EAC82CA7396A68D541C85D26508E83_426350234;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_966047440 = varB4EAC82CA7396A68D541C85D26508E83_1255538870;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_966047440 = varB4EAC82CA7396A68D541C85D26508E83_1417630891;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_966047440 = varB4EAC82CA7396A68D541C85D26508E83_156091160;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_966047440.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_966047440;
        
        
            
        
        
        
            
            
            
                
            
            
                
                        
                
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.450 -0400", hash_original_method = "DAC56CE9E9B1E4D46C67382001476B7D", hash_generated_method = "210B9EC880DC870AA4ACA045E488B4EF")
    protected boolean isOnSameScreenAsChildren() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_837872571 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_837872571;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.450 -0400", hash_original_method = "1FE8E9DF20201DB390C6CDB4B44A4648", hash_generated_method = "415B3A4EA6E8B07ED5F0B0654A34CDD7")
    @Override
    protected void onAttachedToActivity() {
        
        super.onAttachedToActivity();
        mAttachedToActivity = true;
        final int preferenceCount = getPreferenceCount();
        {
            int i = 0;
            {
                getPreference(i).onAttachedToActivity();
            } 
        } 
        
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.451 -0400", hash_original_method = "3A7D9D1FD83E5C89A0E712EE5F3DBB8B", hash_generated_method = "A9FE2CD2FBC3C91399937F271D4EC0AC")
    @Override
    protected void onPrepareForRemoval() {
        
        super.onPrepareForRemoval();
        mAttachedToActivity = false;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.451 -0400", hash_original_method = "10614F6B57E80AB6C964E551AE06AF94", hash_generated_method = "7D82B8EF13ED99A2DBC5F1E345231183")
    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        final int preferenceCount = getPreferenceCount();
        {
            int i = 0;
            {
                getPreference(i).setEnabled(enabled);
            } 
        } 
        addTaint(enabled);
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.451 -0400", hash_original_method = "8DBDAE7DDABF4AEFA524423E392EC9C9", hash_generated_method = "243BA09E7EDBC4A38A7B4E7339AB87BC")
     void sortPreferences() {
        {
            Collections.sort(mPreferenceList);
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.452 -0400", hash_original_method = "62B814BB73D262A241B770A4F50FC903", hash_generated_method = "20674FB57A4BDA360AFA3178C023880D")
    @Override
    protected void dispatchSaveInstanceState(Bundle container) {
        super.dispatchSaveInstanceState(container);
        final int preferenceCount = getPreferenceCount();
        {
            int i = 0;
            {
                getPreference(i).dispatchSaveInstanceState(container);
            } 
        } 
        addTaint(container.getTaint());
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.452 -0400", hash_original_method = "F1DE64EBADCED3709EBA936E1D8777C2", hash_generated_method = "C87F8806C69D016C9258F257689D8E74")
    @Override
    protected void dispatchRestoreInstanceState(Bundle container) {
        super.dispatchRestoreInstanceState(container);
        final int preferenceCount = getPreferenceCount();
        {
            int i = 0;
            {
                getPreference(i).dispatchRestoreInstanceState(container);
            } 
        } 
        addTaint(container.getTaint());
        
        
        
        
            
        
    }

    
}

