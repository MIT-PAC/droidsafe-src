package android.preference;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.963 -0500", hash_original_field = "AA94F4A4BB2311E5FFF451A9F8B32E0B", hash_generated_field = "18F192958EC897931FD8B3DA5BF85A77")

    private List<Preference> mPreferenceList;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.965 -0500", hash_original_field = "EF6436D4AA102956E4336C640C78C9D8", hash_generated_field = "C2971599AC8149900D387CCAE8E63B08")


    private boolean mOrderingAsAdded = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.967 -0500", hash_original_field = "409474000390D5B61F8A6A16539E8BC0", hash_generated_field = "89C3262ADB33D2CAACE003244FE80C06")


    private int mCurrentPreferenceOrder = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.969 -0500", hash_original_field = "8EFBD00F7D5F5CC77C63FE080498A166", hash_generated_field = "5A686733D92531666006F9E403A759CD")


    private boolean mAttachedToActivity = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.972 -0500", hash_original_method = "8E566EF8D5358FA15B6B3A62F4F4EA92", hash_generated_method = "71F455325815CAB22CA5E90F3B38FB33")
    
public PreferenceGroup(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        mPreferenceList = new ArrayList<Preference>();

        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.PreferenceGroup, defStyle, 0);
        mOrderingAsAdded = a.getBoolean(com.android.internal.R.styleable.PreferenceGroup_orderingFromXml,
                mOrderingAsAdded);
        a.recycle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.974 -0500", hash_original_method = "88A912CB88465E21C56F7A6B1304F32F", hash_generated_method = "7E0ECBEDBF37D6443AE2000EB3966FFC")
    
public PreferenceGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * Whether to order the {@link Preference} children of this group as they
     * are added. If this is false, the ordering will follow each Preference
     * order and default to alphabetic for those without an order.
     * <p>
     * If this is called after preferences are added, they will not be
     * re-ordered in the order they were added, hence call this method early on.
     * 
     * @param orderingAsAdded Whether to order according to the order added.
     * @see Preference#setOrder(int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.977 -0500", hash_original_method = "6CBD3E9C112A20CE725E0B14080873B3", hash_generated_method = "0835EE10FA34895F80AF5C0A0D2EBAF2")
    
public void setOrderingAsAdded(boolean orderingAsAdded) {
        mOrderingAsAdded = orderingAsAdded;
    }

    /**
     * Whether this group is ordering preferences in the order they are added.
     * 
     * @return Whether this group orders based on the order the children are added.
     * @see #setOrderingAsAdded(boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.979 -0500", hash_original_method = "5AE1DA121FD737E8D77F265AA9EE4792", hash_generated_method = "FBA23CB8D0C8962C2F06E9D44D4C7408")
    
public boolean isOrderingAsAdded() {
        return mOrderingAsAdded;
    }

    /**
     * Called by the inflater to add an item to this group.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.981 -0500", hash_original_method = "DCFB2F7E3F738580B672E91DCD38CF42", hash_generated_method = "F908F063590E806AC04D7ACB6D9B9CC1")
    
public void addItemFromInflater(Preference preference) {
        addPreference(preference);
    }

    /**
     * Returns the number of children {@link Preference}s.
     * @return The number of preference children in this group.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.983 -0500", hash_original_method = "389AB97985CD6F44D465D155E8399BE9", hash_generated_method = "E7DB08B274C9259DE3854E25D9D2A0CD")
    
public int getPreferenceCount() {
        return mPreferenceList.size();
    }

    /**
     * Returns the {@link Preference} at a particular index.
     * 
     * @param index The index of the {@link Preference} to retrieve.
     * @return The {@link Preference}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.985 -0500", hash_original_method = "109559B57B2B04AB981EEA935073C7C0", hash_generated_method = "996B696A80D0B5186DA171C96FE413E5")
    
public Preference getPreference(int index) {
        return mPreferenceList.get(index);
    }

    /**
     * Adds a {@link Preference} at the correct position based on the
     * preference's order.
     * 
     * @param preference The preference to add.
     * @return Whether the preference is now in this group.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.988 -0500", hash_original_method = "6848FE69024CCCF475A64E7D742A1E83", hash_generated_method = "72854703B35A3CDBA10D0B8803BD4FDF")
    
public boolean addPreference(Preference preference) {
        if (mPreferenceList.contains(preference)) {
            // Exists
            return true;
        }
        
        if (preference.getOrder() == Preference.DEFAULT_ORDER) {
            if (mOrderingAsAdded) {
                preference.setOrder(mCurrentPreferenceOrder++);
            }

            if (preference instanceof PreferenceGroup) {
                // TODO: fix (method is called tail recursively when inflating,
                // so we won't end up properly passing this flag down to children
                ((PreferenceGroup)preference).setOrderingAsAdded(mOrderingAsAdded);
            }
        }

        int insertionIndex = Collections.binarySearch(mPreferenceList, preference);
        if (insertionIndex < 0) {
            insertionIndex = insertionIndex * -1 - 1;
        }

        if (!onPrepareAddPreference(preference)) {
            return false;
        }

        synchronized(this) {
            mPreferenceList.add(insertionIndex, preference);
        }

        preference.onAttachedToHierarchy(getPreferenceManager());
        
        if (mAttachedToActivity) {
            preference.onAttachedToActivity();
        }
        
        notifyHierarchyChanged();

        return true;
    }

    /**
     * Removes a {@link Preference} from this group.
     * 
     * @param preference The preference to remove.
     * @return Whether the preference was found and removed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.990 -0500", hash_original_method = "72E836216B00BC7CD61ADE8B9836B308", hash_generated_method = "10C1FE01868DD10D0DB4D8BFF205AEDD")
    
public boolean removePreference(Preference preference) {
        final boolean returnValue = removePreferenceInt(preference);
        notifyHierarchyChanged();
        return returnValue;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.992 -0500", hash_original_method = "4864D54B8C7134B3A64BC66D9DDCC7C4", hash_generated_method = "3DAE919CEBCE7DF8DCC2B51162CA8CD0")
    
private boolean removePreferenceInt(Preference preference) {
        synchronized(this) {
            preference.onPrepareForRemoval();
            return mPreferenceList.remove(preference);
        }
    }
    
    /**
     * Removes all {@link Preference Preferences} from this group.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.995 -0500", hash_original_method = "70997B14FB6DABF4C7D8165F55B0B7BF", hash_generated_method = "6B5525D33BE28D16BF09599FCD753CCC")
    
public void removeAll() {
        synchronized(this) {
            List<Preference> preferenceList = mPreferenceList;
            for (int i = preferenceList.size() - 1; i >= 0; i--) {
                removePreferenceInt(preferenceList.get(0));
            }
        }
        notifyHierarchyChanged();
    }
    
    /**
     * Prepares a {@link Preference} to be added to the group.
     * 
     * @param preference The preference to add.
     * @return Whether to allow adding the preference (true), or not (false).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.997 -0500", hash_original_method = "6AE303446925DAEA15C349B1AB59000B", hash_generated_method = "AA32D000C2F7490CCFDCB37B05E35324")
    
protected boolean onPrepareAddPreference(Preference preference) {
        if (!super.isEnabled()) {
            preference.setEnabled(false);
        }
        
        return true;
    }

    /**
     * Finds a {@link Preference} based on its key. If two {@link Preference}
     * share the same key (not recommended), the first to appear will be
     * returned (to retrieve the other preference with the same key, call this
     * method on the first preference). If this preference has the key, it will
     * not be returned.
     * <p>
     * This will recursively search for the preference into children that are
     * also {@link PreferenceGroup PreferenceGroups}.
     * 
     * @param key The key of the preference to retrieve.
     * @return The {@link Preference} with the key, or null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.001 -0500", hash_original_method = "28FD4F6AEC9563866A4A8A8A3B9D4A51", hash_generated_method = "610323619310552A4DB208919917AD46")
    
public Preference findPreference(CharSequence key) {
        if (TextUtils.equals(getKey(), key)) {
            return this;
        }
        final int preferenceCount = getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            final Preference preference = getPreference(i);
            final String curKey = preference.getKey();

            if (curKey != null && curKey.equals(key)) {
                return preference;
            }
            
            if (preference instanceof PreferenceGroup) {
                final Preference returnedPreference = ((PreferenceGroup)preference)
                        .findPreference(key);
                if (returnedPreference != null) {
                    return returnedPreference;
                }
            }
        }

        return null;
    }

    /**
     * Whether this preference group should be shown on the same screen as its
     * contained preferences.
     * 
     * @return True if the contained preferences should be shown on the same
     *         screen as this preference.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.003 -0500", hash_original_method = "DAC56CE9E9B1E4D46C67382001476B7D", hash_generated_method = "03203CD5DF79291B20C6273EBC2A10F1")
    
protected boolean isOnSameScreenAsChildren() {
        return true;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.005 -0500", hash_original_method = "1FE8E9DF20201DB390C6CDB4B44A4648", hash_generated_method = "B2C8588A585FEA245CBD62A4A0FCE927")
    
@Override
    protected void onAttachedToActivity() {
        super.onAttachedToActivity();

        // Mark as attached so if a preference is later added to this group, we
        // can tell it we are already attached
        mAttachedToActivity = true;
        
        // Dispatch to all contained preferences
        final int preferenceCount = getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            getPreference(i).onAttachedToActivity();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.008 -0500", hash_original_method = "3A7D9D1FD83E5C89A0E712EE5F3DBB8B", hash_generated_method = "64F4E197E0F9D16BE9EEF208D4B193DE")
    
@Override
    protected void onPrepareForRemoval() {
        super.onPrepareForRemoval();
        
        // We won't be attached to the activity anymore
        mAttachedToActivity = false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.010 -0500", hash_original_method = "10614F6B57E80AB6C964E551AE06AF94", hash_generated_method = "C311D30DF36A23FA5C6362FA5BAC7096")
    
@Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        
        // Dispatch to all contained preferences
        final int preferenceCount = getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            getPreference(i).setEnabled(enabled);
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.012 -0500", hash_original_method = "8DBDAE7DDABF4AEFA524423E392EC9C9", hash_generated_method = "8DBDAE7DDABF4AEFA524423E392EC9C9")
    
void sortPreferences() {
        synchronized (this) {
            Collections.sort(mPreferenceList);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.014 -0500", hash_original_method = "62B814BB73D262A241B770A4F50FC903", hash_generated_method = "20BC2F893AE986C6378A03878CFD6B34")
    
@Override
    protected void dispatchSaveInstanceState(Bundle container) {
        super.dispatchSaveInstanceState(container);

        // Dispatch to all contained preferences
        final int preferenceCount = getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            getPreference(i).dispatchSaveInstanceState(container);
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:26.017 -0500", hash_original_method = "F1DE64EBADCED3709EBA936E1D8777C2", hash_generated_method = "5F71E682ED5DE7F6C3896F7AA07004C0")
    
@Override
    protected void dispatchRestoreInstanceState(Bundle container) {
        super.dispatchRestoreInstanceState(container);

        // Dispatch to all contained preferences
        final int preferenceCount = getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            getPreference(i).dispatchRestoreInstanceState(container);
        }
    }

    
}

