package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.database.DataSetObservable;
import android.database.DataSetObserver;

public abstract class BaseExpandableListAdapter implements ExpandableListAdapter, HeterogeneousExpandableList {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.173 -0500", hash_original_field = "6D0681B9CC29887CCBA4001347A5783B", hash_generated_field = "1CDD3690953D684D62F0461546A52041")

    private final DataSetObservable mDataSetObservable = new DataSetObservable();
    
    @DSComment("Binding data, need modeling to be safe")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.720 -0400", hash_original_method = "7B80614A139C618C091804954249D80D", hash_generated_method = "7B80614A139C618C091804954249D80D")
    public BaseExpandableListAdapter ()
    {
        //Synthesized constructor
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.176 -0500", hash_original_method = "5BE178AB760CC925EF7E1111F1B4915D", hash_generated_method = "6A22BA8F56D7F69EA0195E58760DC1E9")
    
public void registerDataSetObserver(DataSetObserver observer) {
        mDataSetObservable.registerObserver(observer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.178 -0500", hash_original_method = "8548074F279CEB9C75C60995B3E76B4B", hash_generated_method = "031B2EC0C55A5BC43BE2C370EF5FFD75")
    
public void unregisterDataSetObserver(DataSetObserver observer) {
        mDataSetObservable.unregisterObserver(observer);
    }
    
    /**
     * @see DataSetObservable#notifyInvalidated()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.180 -0500", hash_original_method = "733D96117EC068A88A560CFA24913D79", hash_generated_method = "9039EDC909D1B84EC6F4A43479C7428B")
    
public void notifyDataSetInvalidated() {
        mDataSetObservable.notifyInvalidated();
    }
    
    /**
     * @see DataSetObservable#notifyChanged()
     */
    @DSComment("Binding data, need modeling to be safe")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.182 -0500", hash_original_method = "6B5DF5B4CDDD51D923DE488520E93535", hash_generated_method = "782276BFD026F517836F431E691733F0")
    
public void notifyDataSetChanged() {
        mDataSetObservable.notifyChanged();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.184 -0500", hash_original_method = "DC1745DFF85763BBC0B3711D531FD60B", hash_generated_method = "9EDAFF54639C3972375E50BCC11C975C")
    
public boolean areAllItemsEnabled() {
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.186 -0500", hash_original_method = "C8A32BD5B228826DAE8ECAF9C52D77CC", hash_generated_method = "CD556DBBC3F016A5F45D164E2FAD9FB9")
    
public void onGroupCollapsed(int groupPosition) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.188 -0500", hash_original_method = "EDE3519F9C72D4A644C7E6D1DFFECD4D", hash_generated_method = "49808C084B4B01D54BE1EFAEB77B34A1")
    
public void onGroupExpanded(int groupPosition) {
    }

    /**
     * Override this method if you foresee a clash in IDs based on this scheme:
     * <p>
     * Base implementation returns a long:
     * <li> bit 0: Whether this ID points to a child (unset) or group (set), so for this method
     *             this bit will be 1.
     * <li> bit 1-31: Lower 31 bits of the groupId
     * <li> bit 32-63: Lower 32 bits of the childId.
     * <p> 
     * {@inheritDoc}
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.190 -0500", hash_original_method = "62D751D6B99293BC12E6D4807928381F", hash_generated_method = "6465D2056D8597E0CC2C9B9CA2758AFB")
    
public long getCombinedChildId(long groupId, long childId) {
        return 0x8000000000000000L | ((groupId & 0x7FFFFFFF) << 32) | (childId & 0xFFFFFFFF);
    }

    /**
     * Override this method if you foresee a clash in IDs based on this scheme:
     * <p>
     * Base implementation returns a long:
     * <li> bit 0: Whether this ID points to a child (unset) or group (set), so for this method
     *             this bit will be 0.
     * <li> bit 1-31: Lower 31 bits of the groupId
     * <li> bit 32-63: Lower 32 bits of the childId.
     * <p> 
     * {@inheritDoc}
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.192 -0500", hash_original_method = "EB7194051A92C01EF508538BB57C4064", hash_generated_method = "A6B5948E4CFC2A70DFA565DAE5B3E394")
    
public long getCombinedGroupId(long groupId) {
        return (groupId & 0x7FFFFFFF) << 32;
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.194 -0500", hash_original_method = "5FAC6FB77FD1E9F9E1ADE9FFEE4D8A44", hash_generated_method = "CF0E0A1E05EE00EDF89E1A3DB720D3AB")
    
public boolean isEmpty() {
        return getGroupCount() == 0;
    }

    /**
     * {@inheritDoc}
     * @return 0 for any group or child position, since only one child type count is declared.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.196 -0500", hash_original_method = "3976CE9E755202E3C931B6278940CC72", hash_generated_method = "999FBDAE3197B42FB3EC8F719EE6CD8F")
    
public int getChildType(int groupPosition, int childPosition) {
        return 0;
    }

    /**
     * {@inheritDoc}
     * @return 1 as a default value in BaseExpandableListAdapter.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.199 -0500", hash_original_method = "CBF60407A4D820C72FB94E8B743C23B8", hash_generated_method = "B1A8E554B1853B1951395EE4A522DDA0")
    
public int getChildTypeCount() {
        return 1;
    }

    /**
     * {@inheritDoc}
     * @return 0 for any groupPosition, since only one group type count is declared.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.202 -0500", hash_original_method = "386488F689E9AEDF8DF1CAB1FEBD53FC", hash_generated_method = "01866240BF10528F9C91DC25EC86B254")
    
public int getGroupType(int groupPosition) {
        return 0;
    }

    /**
     * {@inheritDoc}
     * @return 1 as a default value in BaseExpandableListAdapter.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:48.204 -0500", hash_original_method = "BE48BAFD668175AB338E2F1890BDC5F9", hash_generated_method = "AFFDBFBE921B50F3ADD3AF9A710A785F")
    
public int getGroupTypeCount() {
        return 1;
    }
    
}

