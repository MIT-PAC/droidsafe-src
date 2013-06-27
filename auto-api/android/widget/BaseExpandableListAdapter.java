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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.977 -0400", hash_original_field = "DEB4CF927428CCF05DDA4EF4FEB1005E", hash_generated_field = "72B7909438DD6FEADC92BE27BA79AE37")

    private DataSetObservable mDataSetObservable = new DataSetObservable();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.977 -0400", hash_original_method = "7B80614A139C618C091804954249D80D", hash_generated_method = "7B80614A139C618C091804954249D80D")
    public BaseExpandableListAdapter ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.980 -0400", hash_original_method = "5BE178AB760CC925EF7E1111F1B4915D", hash_generated_method = "D80BACDB53770E495497918A52F212CE")
    public void registerDataSetObserver(DataSetObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mDataSetObservable.registerObserver(observer);
        addTaint(observer.getTaint());
        // ---------- Original Method ----------
        //mDataSetObservable.registerObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.981 -0400", hash_original_method = "8548074F279CEB9C75C60995B3E76B4B", hash_generated_method = "18957645919BC1B25C95D955828DA072")
    public void unregisterDataSetObserver(DataSetObserver observer) {
        mDataSetObservable.unregisterObserver(observer);
        addTaint(observer.getTaint());
        // ---------- Original Method ----------
        //mDataSetObservable.unregisterObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.981 -0400", hash_original_method = "733D96117EC068A88A560CFA24913D79", hash_generated_method = "A7F0E4AF3D0109D819E8AFDA57AB77CC")
    public void notifyDataSetInvalidated() {
        mDataSetObservable.notifyInvalidated();
        // ---------- Original Method ----------
        //mDataSetObservable.notifyInvalidated();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.982 -0400", hash_original_method = "6B5DF5B4CDDD51D923DE488520E93535", hash_generated_method = "3158F3A56E63A128E4489E6003CA7FEA")
    public void notifyDataSetChanged() {
        mDataSetObservable.notifyChanged();
        // ---------- Original Method ----------
        //mDataSetObservable.notifyChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.982 -0400", hash_original_method = "DC1745DFF85763BBC0B3711D531FD60B", hash_generated_method = "5B80FFF7D756F3DBD39096FB404A2F74")
    public boolean areAllItemsEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_821592323 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_821592323;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.982 -0400", hash_original_method = "C8A32BD5B228826DAE8ECAF9C52D77CC", hash_generated_method = "4AB5127AC0DCCE6566F0CDD02EC70069")
    public void onGroupCollapsed(int groupPosition) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(groupPosition);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.982 -0400", hash_original_method = "EDE3519F9C72D4A644C7E6D1DFFECD4D", hash_generated_method = "5C64D6D0F3D5AA2D9DE1377CB3A7558C")
    public void onGroupExpanded(int groupPosition) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(groupPosition);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.983 -0400", hash_original_method = "62D751D6B99293BC12E6D4807928381F", hash_generated_method = "7B358AE7677EE660B1DE508FBF126715")
    public long getCombinedChildId(long groupId, long childId) {
        addTaint(groupId);
        addTaint(childId);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_104747603 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_104747603;
        // ---------- Original Method ----------
        //return 0x8000000000000000L | ((groupId & 0x7FFFFFFF) << 32) | (childId & 0xFFFFFFFF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.987 -0400", hash_original_method = "EB7194051A92C01EF508538BB57C4064", hash_generated_method = "B5D98E8FF0D0FC7FCC845DDD05F9E7E7")
    public long getCombinedGroupId(long groupId) {
        addTaint(groupId);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1966480068 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1966480068;
        // ---------- Original Method ----------
        //return (groupId & 0x7FFFFFFF) << 32;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.987 -0400", hash_original_method = "5FAC6FB77FD1E9F9E1ADE9FFEE4D8A44", hash_generated_method = "94F76F7A0B83099085D11A896E8A5342")
    public boolean isEmpty() {
        boolean varF04683A2E6644A2E953AB70856E2B39D_1708645440 = (getGroupCount() == 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_780107164 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_780107164;
        // ---------- Original Method ----------
        //return getGroupCount() == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.987 -0400", hash_original_method = "3976CE9E755202E3C931B6278940CC72", hash_generated_method = "A84622A4B0F4D2A4562FD456B6D1EA79")
    public int getChildType(int groupPosition, int childPosition) {
        addTaint(groupPosition);
        addTaint(childPosition);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2061636384 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2061636384;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.997 -0400", hash_original_method = "CBF60407A4D820C72FB94E8B743C23B8", hash_generated_method = "229630458591C2E2F3318C57D66F5FB6")
    public int getChildTypeCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2129260843 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2129260843;
        // ---------- Original Method ----------
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.998 -0400", hash_original_method = "386488F689E9AEDF8DF1CAB1FEBD53FC", hash_generated_method = "4FBB2C115507941009B88B2EC942C8AC")
    public int getGroupType(int groupPosition) {
        addTaint(groupPosition);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_238047666 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_238047666;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.999 -0400", hash_original_method = "BE48BAFD668175AB338E2F1890BDC5F9", hash_generated_method = "6DA760F3767D4922C1C987C8BC1EFF46")
    public int getGroupTypeCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_577051867 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_577051867;
        // ---------- Original Method ----------
        //return 1;
    }

    
}

