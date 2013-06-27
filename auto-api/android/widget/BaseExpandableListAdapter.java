package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.database.DataSetObservable;
import android.database.DataSetObserver;

public abstract class BaseExpandableListAdapter implements ExpandableListAdapter, HeterogeneousExpandableList {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.383 -0400", hash_original_field = "DEB4CF927428CCF05DDA4EF4FEB1005E", hash_generated_field = "72B7909438DD6FEADC92BE27BA79AE37")

    private DataSetObservable mDataSetObservable = new DataSetObservable();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.383 -0400", hash_original_method = "7B80614A139C618C091804954249D80D", hash_generated_method = "7B80614A139C618C091804954249D80D")
    public BaseExpandableListAdapter ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.384 -0400", hash_original_method = "5BE178AB760CC925EF7E1111F1B4915D", hash_generated_method = "D80BACDB53770E495497918A52F212CE")
    public void registerDataSetObserver(DataSetObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mDataSetObservable.registerObserver(observer);
        addTaint(observer.getTaint());
        // ---------- Original Method ----------
        //mDataSetObservable.registerObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.384 -0400", hash_original_method = "8548074F279CEB9C75C60995B3E76B4B", hash_generated_method = "18957645919BC1B25C95D955828DA072")
    public void unregisterDataSetObserver(DataSetObserver observer) {
        mDataSetObservable.unregisterObserver(observer);
        addTaint(observer.getTaint());
        // ---------- Original Method ----------
        //mDataSetObservable.unregisterObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.385 -0400", hash_original_method = "733D96117EC068A88A560CFA24913D79", hash_generated_method = "A7F0E4AF3D0109D819E8AFDA57AB77CC")
    public void notifyDataSetInvalidated() {
        mDataSetObservable.notifyInvalidated();
        // ---------- Original Method ----------
        //mDataSetObservable.notifyInvalidated();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.385 -0400", hash_original_method = "6B5DF5B4CDDD51D923DE488520E93535", hash_generated_method = "3158F3A56E63A128E4489E6003CA7FEA")
    public void notifyDataSetChanged() {
        mDataSetObservable.notifyChanged();
        // ---------- Original Method ----------
        //mDataSetObservable.notifyChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.397 -0400", hash_original_method = "DC1745DFF85763BBC0B3711D531FD60B", hash_generated_method = "41FFF898F6CB61CD62141D71C997B94E")
    public boolean areAllItemsEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1558596548 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1558596548;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.398 -0400", hash_original_method = "C8A32BD5B228826DAE8ECAF9C52D77CC", hash_generated_method = "4AB5127AC0DCCE6566F0CDD02EC70069")
    public void onGroupCollapsed(int groupPosition) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(groupPosition);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.398 -0400", hash_original_method = "EDE3519F9C72D4A644C7E6D1DFFECD4D", hash_generated_method = "5C64D6D0F3D5AA2D9DE1377CB3A7558C")
    public void onGroupExpanded(int groupPosition) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(groupPosition);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.398 -0400", hash_original_method = "62D751D6B99293BC12E6D4807928381F", hash_generated_method = "7882094BF74E0882C4B875A1674A9193")
    public long getCombinedChildId(long groupId, long childId) {
        addTaint(groupId);
        addTaint(childId);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1747541255 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1747541255;
        // ---------- Original Method ----------
        //return 0x8000000000000000L | ((groupId & 0x7FFFFFFF) << 32) | (childId & 0xFFFFFFFF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.399 -0400", hash_original_method = "EB7194051A92C01EF508538BB57C4064", hash_generated_method = "670EA45AC40CB5BC2E567171DC5C816F")
    public long getCombinedGroupId(long groupId) {
        addTaint(groupId);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1050388925 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1050388925;
        // ---------- Original Method ----------
        //return (groupId & 0x7FFFFFFF) << 32;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.399 -0400", hash_original_method = "5FAC6FB77FD1E9F9E1ADE9FFEE4D8A44", hash_generated_method = "1CDEFA19840AD3D0958B69FCDE2A3214")
    public boolean isEmpty() {
        boolean varF04683A2E6644A2E953AB70856E2B39D_1416953841 = (getGroupCount() == 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1828876237 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1828876237;
        // ---------- Original Method ----------
        //return getGroupCount() == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.400 -0400", hash_original_method = "3976CE9E755202E3C931B6278940CC72", hash_generated_method = "C78A5311B2F7B8D837624B6959718B0D")
    public int getChildType(int groupPosition, int childPosition) {
        addTaint(groupPosition);
        addTaint(childPosition);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1804088388 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1804088388;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.400 -0400", hash_original_method = "CBF60407A4D820C72FB94E8B743C23B8", hash_generated_method = "655FDB6AC6D4AD0775E10B16814DAE06")
    public int getChildTypeCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1550960104 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1550960104;
        // ---------- Original Method ----------
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.400 -0400", hash_original_method = "386488F689E9AEDF8DF1CAB1FEBD53FC", hash_generated_method = "512E9CE66F7B1121BC2C891866148369")
    public int getGroupType(int groupPosition) {
        addTaint(groupPosition);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_33174278 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_33174278;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.400 -0400", hash_original_method = "BE48BAFD668175AB338E2F1890BDC5F9", hash_generated_method = "1C1F3EBE07A1B6F8FEAF12156B320884")
    public int getGroupTypeCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_425091884 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_425091884;
        // ---------- Original Method ----------
        //return 1;
    }

    
}

