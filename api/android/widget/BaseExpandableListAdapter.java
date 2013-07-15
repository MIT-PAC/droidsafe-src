package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.database.DataSetObservable;
import android.database.DataSetObserver;

public abstract class BaseExpandableListAdapter implements ExpandableListAdapter, HeterogeneousExpandableList {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.591 -0400", hash_original_field = "DEB4CF927428CCF05DDA4EF4FEB1005E", hash_generated_field = "1CDD3690953D684D62F0461546A52041")

    private final DataSetObservable mDataSetObservable = new DataSetObservable();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.591 -0400", hash_original_method = "7B80614A139C618C091804954249D80D", hash_generated_method = "7B80614A139C618C091804954249D80D")
    public BaseExpandableListAdapter ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.591 -0400", hash_original_method = "5BE178AB760CC925EF7E1111F1B4915D", hash_generated_method = "F16E110729CB74D6A482E558D8B8E47B")
    public void registerDataSetObserver(DataSetObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(observer.getTaint());
        mDataSetObservable.registerObserver(observer);
        // ---------- Original Method ----------
        //mDataSetObservable.registerObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.591 -0400", hash_original_method = "8548074F279CEB9C75C60995B3E76B4B", hash_generated_method = "55A6C9663FBA723DF8786E07BEFE465A")
    public void unregisterDataSetObserver(DataSetObserver observer) {
        addTaint(observer.getTaint());
        mDataSetObservable.unregisterObserver(observer);
        // ---------- Original Method ----------
        //mDataSetObservable.unregisterObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.591 -0400", hash_original_method = "733D96117EC068A88A560CFA24913D79", hash_generated_method = "A7F0E4AF3D0109D819E8AFDA57AB77CC")
    public void notifyDataSetInvalidated() {
        mDataSetObservable.notifyInvalidated();
        // ---------- Original Method ----------
        //mDataSetObservable.notifyInvalidated();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.592 -0400", hash_original_method = "6B5DF5B4CDDD51D923DE488520E93535", hash_generated_method = "3158F3A56E63A128E4489E6003CA7FEA")
    public void notifyDataSetChanged() {
        mDataSetObservable.notifyChanged();
        // ---------- Original Method ----------
        //mDataSetObservable.notifyChanged();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.592 -0400", hash_original_method = "DC1745DFF85763BBC0B3711D531FD60B", hash_generated_method = "9D139762A48D165B2D359B8A1401D120")
    public boolean areAllItemsEnabled() {
        boolean varB326B5062B2F0E69046810717534CB09_1411690843 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1453828728 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1453828728;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.592 -0400", hash_original_method = "C8A32BD5B228826DAE8ECAF9C52D77CC", hash_generated_method = "4AB5127AC0DCCE6566F0CDD02EC70069")
    public void onGroupCollapsed(int groupPosition) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(groupPosition);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.592 -0400", hash_original_method = "EDE3519F9C72D4A644C7E6D1DFFECD4D", hash_generated_method = "5C64D6D0F3D5AA2D9DE1377CB3A7558C")
    public void onGroupExpanded(int groupPosition) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(groupPosition);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.593 -0400", hash_original_method = "62D751D6B99293BC12E6D4807928381F", hash_generated_method = "C83CEB800F3AAEF6DDFA9A6D8D050CFD")
    public long getCombinedChildId(long groupId, long childId) {
        addTaint(childId);
        addTaint(groupId);
        long varA5B07B9DE869F43C3646F23BCB5B5889_634902278 = (0x8000000000000000L | ((groupId & 0x7FFFFFFF) << 32) | (childId & 0xFFFFFFFF));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1249233805 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1249233805;
        // ---------- Original Method ----------
        //return 0x8000000000000000L | ((groupId & 0x7FFFFFFF) << 32) | (childId & 0xFFFFFFFF);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.593 -0400", hash_original_method = "EB7194051A92C01EF508538BB57C4064", hash_generated_method = "8635EF93B1910ACADAEDF6A3668D733F")
    public long getCombinedGroupId(long groupId) {
        addTaint(groupId);
        long varBDF3E2B648ABB522407F25C482819CE1_1103968374 = ((groupId & 0x7FFFFFFF) << 32);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1069564904 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1069564904;
        // ---------- Original Method ----------
        //return (groupId & 0x7FFFFFFF) << 32;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.593 -0400", hash_original_method = "5FAC6FB77FD1E9F9E1ADE9FFEE4D8A44", hash_generated_method = "69A516A2B10CA2B3283685C17236EF94")
    public boolean isEmpty() {
        boolean var4B7840671273F91292DC14DC84C69C76_1306190353 = (getGroupCount() == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1834415571 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1834415571;
        // ---------- Original Method ----------
        //return getGroupCount() == 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.593 -0400", hash_original_method = "3976CE9E755202E3C931B6278940CC72", hash_generated_method = "54D8DBF33594F9F95562F314F1BFEC50")
    public int getChildType(int groupPosition, int childPosition) {
        addTaint(childPosition);
        addTaint(groupPosition);
        int varCFCD208495D565EF66E7DFF9F98764DA_1620418435 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1039523220 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1039523220;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.594 -0400", hash_original_method = "CBF60407A4D820C72FB94E8B743C23B8", hash_generated_method = "3287D6452BDB9B73584F5FF362390B27")
    public int getChildTypeCount() {
        int varC4CA4238A0B923820DCC509A6F75849B_1736845842 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1889582849 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1889582849;
        // ---------- Original Method ----------
        //return 1;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.594 -0400", hash_original_method = "386488F689E9AEDF8DF1CAB1FEBD53FC", hash_generated_method = "91F99E55041A9FED98E97CFE2339AE0F")
    public int getGroupType(int groupPosition) {
        addTaint(groupPosition);
        int varCFCD208495D565EF66E7DFF9F98764DA_1535570365 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1441983769 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1441983769;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.594 -0400", hash_original_method = "BE48BAFD668175AB338E2F1890BDC5F9", hash_generated_method = "0F7458FB817E4E10906ACE841D0E228E")
    public int getGroupTypeCount() {
        int varC4CA4238A0B923820DCC509A6F75849B_1644598146 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2099316779 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2099316779;
        // ---------- Original Method ----------
        //return 1;
    }

    
}

