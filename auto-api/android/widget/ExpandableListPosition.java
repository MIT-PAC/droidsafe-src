package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;

class ExpandableListPosition {
    public int groupPos;
    public int childPos;
    int flatListPos;
    public int type;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.529 -0400", hash_original_method = "AC719FEF152399BDA1BD5A5CA7FBB765", hash_generated_method = "CA9DC1117656D5954D084C62466145DC")
    @DSModeled(DSC.SAFE)
    private ExpandableListPosition() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.529 -0400", hash_original_method = "6E7C899DC67219985BD699CC84AD95E6", hash_generated_method = "D1043CAEEE96B318519BE4957822CE46")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.529 -0400", hash_original_method = "C8676DC8E5CB906E204449634591A777", hash_generated_method = "FD1688EE32790EEA624A5A638F6BF28C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     long getPackedPosition() {
        long varF1CDC56F9484B79C6147A2A49F08CA17_1006587355 = (ExpandableListView.getPackedPositionForChild(groupPos, childPos));
        long varC88519A853E40A47ED20C816E0704D5D_553772256 = (ExpandableListView.getPackedPositionForGroup(groupPos));
        return dsTaint.getTaintLong();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.530 -0400", hash_original_method = "8A154BA1D9B394A3D67E04E6A86589B2", hash_generated_method = "849BD917BEA565049CBB992B8F8FA281")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void recycle() {
        {
            {
                boolean varFD1AE4DE39490BAA16F88E57693E4F3C_1847958401 = (sPool.size() < MAX_POOL_SIZE);
                {
                    sPool.add(this);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //synchronized (sPool) {
            //if (sPool.size() < MAX_POOL_SIZE) {
                //sPool.add(this);
            //}
        //}
    }

    
    private static final int MAX_POOL_SIZE = 5;
    private static ArrayList<ExpandableListPosition> sPool =
        new ArrayList<ExpandableListPosition>(MAX_POOL_SIZE);
    public final static int CHILD = 1;
    public final static int GROUP = 2;
}

