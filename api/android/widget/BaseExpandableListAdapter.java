package android.widget;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.database.DataSetObservable;
import android.database.DataSetObserver;





public abstract class BaseExpandableListAdapter implements ExpandableListAdapter, HeterogeneousExpandableList {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.720 -0400", hash_original_field = "DEB4CF927428CCF05DDA4EF4FEB1005E", hash_generated_field = "1CDD3690953D684D62F0461546A52041")

    private final DataSetObservable mDataSetObservable = new DataSetObservable();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.720 -0400", hash_original_method = "7B80614A139C618C091804954249D80D", hash_generated_method = "7B80614A139C618C091804954249D80D")
    public BaseExpandableListAdapter ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.720 -0400", hash_original_method = "5BE178AB760CC925EF7E1111F1B4915D", hash_generated_method = "F16E110729CB74D6A482E558D8B8E47B")
    public void registerDataSetObserver(DataSetObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(observer.getTaint());
        mDataSetObservable.registerObserver(observer);
        // ---------- Original Method ----------
        //mDataSetObservable.registerObserver(observer);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.720 -0400", hash_original_method = "8548074F279CEB9C75C60995B3E76B4B", hash_generated_method = "55A6C9663FBA723DF8786E07BEFE465A")
    public void unregisterDataSetObserver(DataSetObserver observer) {
        addTaint(observer.getTaint());
        mDataSetObservable.unregisterObserver(observer);
        // ---------- Original Method ----------
        //mDataSetObservable.unregisterObserver(observer);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.720 -0400", hash_original_method = "733D96117EC068A88A560CFA24913D79", hash_generated_method = "A7F0E4AF3D0109D819E8AFDA57AB77CC")
    public void notifyDataSetInvalidated() {
        mDataSetObservable.notifyInvalidated();
        // ---------- Original Method ----------
        //mDataSetObservable.notifyInvalidated();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.720 -0400", hash_original_method = "6B5DF5B4CDDD51D923DE488520E93535", hash_generated_method = "3158F3A56E63A128E4489E6003CA7FEA")
    public void notifyDataSetChanged() {
        mDataSetObservable.notifyChanged();
        // ---------- Original Method ----------
        //mDataSetObservable.notifyChanged();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.720 -0400", hash_original_method = "DC1745DFF85763BBC0B3711D531FD60B", hash_generated_method = "238EC13A2DDA6ACCC4D87A9D8E2F52B3")
    public boolean areAllItemsEnabled() {
        boolean varB326B5062B2F0E69046810717534CB09_282400191 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_47640273 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_47640273;
        // ---------- Original Method ----------
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.720 -0400", hash_original_method = "C8A32BD5B228826DAE8ECAF9C52D77CC", hash_generated_method = "4AB5127AC0DCCE6566F0CDD02EC70069")
    public void onGroupCollapsed(int groupPosition) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(groupPosition);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.721 -0400", hash_original_method = "EDE3519F9C72D4A644C7E6D1DFFECD4D", hash_generated_method = "5C64D6D0F3D5AA2D9DE1377CB3A7558C")
    public void onGroupExpanded(int groupPosition) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(groupPosition);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.721 -0400", hash_original_method = "62D751D6B99293BC12E6D4807928381F", hash_generated_method = "11F38E1A7E8D52193B8115406AEAC893")
    public long getCombinedChildId(long groupId, long childId) {
        addTaint(childId);
        addTaint(groupId);
        long varA5B07B9DE869F43C3646F23BCB5B5889_1171223675 = (0x8000000000000000L | ((groupId & 0x7FFFFFFF) << 32) | (childId & 0xFFFFFFFF));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_546474502 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_546474502;
        // ---------- Original Method ----------
        //return 0x8000000000000000L | ((groupId & 0x7FFFFFFF) << 32) | (childId & 0xFFFFFFFF);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.721 -0400", hash_original_method = "EB7194051A92C01EF508538BB57C4064", hash_generated_method = "E341E575BACC5F3D19C066079D48DA3C")
    public long getCombinedGroupId(long groupId) {
        addTaint(groupId);
        long varBDF3E2B648ABB522407F25C482819CE1_128400217 = ((groupId & 0x7FFFFFFF) << 32);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_191206258 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_191206258;
        // ---------- Original Method ----------
        //return (groupId & 0x7FFFFFFF) << 32;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.721 -0400", hash_original_method = "5FAC6FB77FD1E9F9E1ADE9FFEE4D8A44", hash_generated_method = "0D541B9AA0A3FE1CE592307AC82D5150")
    public boolean isEmpty() {
        boolean var4B7840671273F91292DC14DC84C69C76_1923879540 = (getGroupCount() == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_285547925 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_285547925;
        // ---------- Original Method ----------
        //return getGroupCount() == 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.721 -0400", hash_original_method = "3976CE9E755202E3C931B6278940CC72", hash_generated_method = "8B3E90B58779274598DC4023ED9ECCE1")
    public int getChildType(int groupPosition, int childPosition) {
        addTaint(childPosition);
        addTaint(groupPosition);
        int varCFCD208495D565EF66E7DFF9F98764DA_480518219 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_5687202 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_5687202;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.721 -0400", hash_original_method = "CBF60407A4D820C72FB94E8B743C23B8", hash_generated_method = "F08E2642FB1B817717CA8D5973DF1FE6")
    public int getChildTypeCount() {
        int varC4CA4238A0B923820DCC509A6F75849B_947926906 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_821183799 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_821183799;
        // ---------- Original Method ----------
        //return 1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.721 -0400", hash_original_method = "386488F689E9AEDF8DF1CAB1FEBD53FC", hash_generated_method = "BA1305F55AA80ABCB63A2C9A4079C7B4")
    public int getGroupType(int groupPosition) {
        addTaint(groupPosition);
        int varCFCD208495D565EF66E7DFF9F98764DA_1672509015 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_779107668 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_779107668;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.721 -0400", hash_original_method = "BE48BAFD668175AB338E2F1890BDC5F9", hash_generated_method = "10960897663CE485E7407EC77FCCA966")
    public int getGroupTypeCount() {
        int varC4CA4238A0B923820DCC509A6F75849B_1273113271 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_913350711 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_913350711;
        // ---------- Original Method ----------
        //return 1;
    }

    
}

