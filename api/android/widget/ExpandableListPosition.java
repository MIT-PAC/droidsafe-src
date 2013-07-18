package android.widget;

// Droidsafe Imports
import java.util.ArrayList;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

class ExpandableListPosition {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.412 -0400", hash_original_field = "EE07D40A93E39122F7007E1922755F80", hash_generated_field = "2301C40FE9B33471D945A5226ECAAB38")

    public int groupPos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.413 -0400", hash_original_field = "DEB93B3708C76AD8AAD280EF94D7E2FE", hash_generated_field = "60A49C0AC4F2F0436AB7AB0C7B3140B6")

    public int childPos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.413 -0400", hash_original_field = "1CED080A89697925D9EEB8ECFC3C5C9C", hash_generated_field = "ABD45EB65AB80D8EB9E3EA196D9D59D5")

    int flatListPos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.413 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "6AC5CE4BE311ED1283E9BD812937901E")

    public int type;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.413 -0400", hash_original_method = "AC719FEF152399BDA1BD5A5CA7FBB765", hash_generated_method = "CA9DC1117656D5954D084C62466145DC")
    private  ExpandableListPosition() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.413 -0400", hash_original_method = "6E7C899DC67219985BD699CC84AD95E6", hash_generated_method = "D1043CAEEE96B318519BE4957822CE46")
    private void resetState() {
        groupPos = 0;
        childPos = 0;
        flatListPos = 0;
        type = 0;
        // ---------- Original Method ----------
        //groupPos = 0;
        //childPos = 0;
        //flatListPos = 0;
        //type = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.414 -0400", hash_original_method = "C8676DC8E5CB906E204449634591A777", hash_generated_method = "19157D8F75C76378422DF92393A1EC29")
     long getPackedPosition() {
        if(type == CHILD)        
        {
        long var93B7DCE54670510B5F23FE0D7DEBA2D1_1492324572 = (ExpandableListView.getPackedPositionForChild(groupPos, childPos));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_2086940721 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2086940721;
        }
        else
        {
        long var5C19C1E26BCC08E214635C9470A5922C_2113468639 = (ExpandableListView.getPackedPositionForGroup(groupPos));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_230356351 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_230356351;
        }
        // ---------- Original Method ----------
        //if (type == CHILD) return ExpandableListView.getPackedPositionForChild(groupPos, childPos);
        //else return ExpandableListView.getPackedPositionForGroup(groupPos);
    }

    
    static ExpandableListPosition obtainGroupPosition(int groupPosition) {
        return obtain(GROUP, groupPosition, 0, 0);
    }

    
    static ExpandableListPosition obtainChildPosition(int groupPosition, int childPosition) {
        return obtain(CHILD, groupPosition, childPosition, 0);
    }

    
    static ExpandableListPosition obtainPosition(long packedPosition) {
        if (packedPosition == ExpandableListView.PACKED_POSITION_VALUE_NULL) {
            return null;
        }
        ExpandableListPosition elp = getRecycledOrCreate();
        elp.groupPos = ExpandableListView.getPackedPositionGroup(packedPosition);
        if (ExpandableListView.getPackedPositionType(packedPosition) ==
                ExpandableListView.PACKED_POSITION_TYPE_CHILD) {
            elp.type = CHILD;
            elp.childPos = ExpandableListView.getPackedPositionChild(packedPosition);
        } else {
            elp.type = GROUP;
        }
        return elp;
    }

    
    static ExpandableListPosition obtain(int type, int groupPos, int childPos, int flatListPos) {
        ExpandableListPosition elp = getRecycledOrCreate();
        elp.type = type;
        elp.groupPos = groupPos;
        elp.childPos = childPos;
        elp.flatListPos = flatListPos;
        return elp;
    }

    
    private static ExpandableListPosition getRecycledOrCreate() {
        ExpandableListPosition elp;
        synchronized (sPool) {
            if (sPool.size() > 0) {
                elp = sPool.remove(0);
            } else {
                return new ExpandableListPosition();
            }
        }
        elp.resetState();
        return elp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.415 -0400", hash_original_method = "8A154BA1D9B394A3D67E04E6A86589B2", hash_generated_method = "630615FD0F25C98518FE11FF0693404C")
    public void recycle() {
        synchronized
(sPool)        {
            if(sPool.size() < MAX_POOL_SIZE)            
            {
                sPool.add(this);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (sPool) {
            //if (sPool.size() < MAX_POOL_SIZE) {
                //sPool.add(this);
            //}
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.415 -0400", hash_original_field = "889E6ADBE471574497DA5C9E79EF7FCA", hash_generated_field = "7127A67374BF405D0F01EEB2429B1D48")

    private static final int MAX_POOL_SIZE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.415 -0400", hash_original_field = "5A94D2210A3BD35C5C514A0AAE6A7DBD", hash_generated_field = "13B9F617BBB013357274E6300FD7AEA8")

    private static ArrayList<ExpandableListPosition> sPool = new ArrayList<ExpandableListPosition>(MAX_POOL_SIZE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.415 -0400", hash_original_field = "0FE51404ACE91FDA107540AE9D2D4278", hash_generated_field = "F0F5C77DA98AF028C1257C33F37951DA")

    public final static int CHILD = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.415 -0400", hash_original_field = "8B6AA562AB8083D61143786D8730F6DA", hash_generated_field = "4F320263FDA19E11C7632EEC3F961D53")

    public final static int GROUP = 2;
}

