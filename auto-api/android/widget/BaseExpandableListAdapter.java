package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.database.DataSetObservable;
import android.database.DataSetObserver;

public abstract class BaseExpandableListAdapter implements ExpandableListAdapter, HeterogeneousExpandableList {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.996 -0400", hash_original_field = "DEB4CF927428CCF05DDA4EF4FEB1005E", hash_generated_field = "1CDD3690953D684D62F0461546A52041")

    private final DataSetObservable mDataSetObservable = new DataSetObservable();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.996 -0400", hash_original_method = "7B80614A139C618C091804954249D80D", hash_generated_method = "7B80614A139C618C091804954249D80D")
    public BaseExpandableListAdapter ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.997 -0400", hash_original_method = "5BE178AB760CC925EF7E1111F1B4915D", hash_generated_method = "D80BACDB53770E495497918A52F212CE")
    public void registerDataSetObserver(DataSetObserver observer) {
        
        mDataSetObservable.registerObserver(observer);
        addTaint(observer.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.997 -0400", hash_original_method = "8548074F279CEB9C75C60995B3E76B4B", hash_generated_method = "18957645919BC1B25C95D955828DA072")
    public void unregisterDataSetObserver(DataSetObserver observer) {
        mDataSetObservable.unregisterObserver(observer);
        addTaint(observer.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.997 -0400", hash_original_method = "733D96117EC068A88A560CFA24913D79", hash_generated_method = "A7F0E4AF3D0109D819E8AFDA57AB77CC")
    public void notifyDataSetInvalidated() {
        mDataSetObservable.notifyInvalidated();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.998 -0400", hash_original_method = "6B5DF5B4CDDD51D923DE488520E93535", hash_generated_method = "3158F3A56E63A128E4489E6003CA7FEA")
    public void notifyDataSetChanged() {
        mDataSetObservable.notifyChanged();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.998 -0400", hash_original_method = "DC1745DFF85763BBC0B3711D531FD60B", hash_generated_method = "6C83FAAEED479EAD9086A6E3CA7FB963")
    public boolean areAllItemsEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2056396757 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2056396757;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.998 -0400", hash_original_method = "C8A32BD5B228826DAE8ECAF9C52D77CC", hash_generated_method = "4AB5127AC0DCCE6566F0CDD02EC70069")
    public void onGroupCollapsed(int groupPosition) {
        
        addTaint(groupPosition);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.999 -0400", hash_original_method = "EDE3519F9C72D4A644C7E6D1DFFECD4D", hash_generated_method = "5C64D6D0F3D5AA2D9DE1377CB3A7558C")
    public void onGroupExpanded(int groupPosition) {
        
        addTaint(groupPosition);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.999 -0400", hash_original_method = "62D751D6B99293BC12E6D4807928381F", hash_generated_method = "05DF13B36EC35A901A8AEA4FB2B50B52")
    public long getCombinedChildId(long groupId, long childId) {
        addTaint(groupId);
        addTaint(childId);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_885111183 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_885111183;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.999 -0400", hash_original_method = "EB7194051A92C01EF508538BB57C4064", hash_generated_method = "98DCF2050B9004EF5CF0D29E3EFD3620")
    public long getCombinedGroupId(long groupId) {
        addTaint(groupId);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_9056238 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_9056238;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.000 -0400", hash_original_method = "5FAC6FB77FD1E9F9E1ADE9FFEE4D8A44", hash_generated_method = "954A8B3F53299E86E029B0D72DD6A97C")
    public boolean isEmpty() {
        boolean varF04683A2E6644A2E953AB70856E2B39D_1785413889 = (getGroupCount() == 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_184903623 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_184903623;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.000 -0400", hash_original_method = "3976CE9E755202E3C931B6278940CC72", hash_generated_method = "E6A2A7421155AE0E86BF887B66BC7E2B")
    public int getChildType(int groupPosition, int childPosition) {
        addTaint(groupPosition);
        addTaint(childPosition);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_762969036 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_762969036;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.000 -0400", hash_original_method = "CBF60407A4D820C72FB94E8B743C23B8", hash_generated_method = "F44A47DB57798C3FAC016066F2EEAEDB")
    public int getChildTypeCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_341666282 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_341666282;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.001 -0400", hash_original_method = "386488F689E9AEDF8DF1CAB1FEBD53FC", hash_generated_method = "A998BDFD041966BCC2C5A2E16924324B")
    public int getGroupType(int groupPosition) {
        addTaint(groupPosition);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1608433985 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1608433985;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.002 -0400", hash_original_method = "BE48BAFD668175AB338E2F1890BDC5F9", hash_generated_method = "0D175E7D90319C31FD32C9D943231052")
    public int getGroupTypeCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_38240341 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_38240341;
        
        
    }

    
}

