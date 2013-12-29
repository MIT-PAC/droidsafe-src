package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Collections;

import android.database.DataSetObserver;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;





class ExpandableListConnector extends BaseAdapter implements Filterable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.241 -0500", hash_original_field = "F740C7542DC629DE756D7957303B1D05", hash_generated_field = "18A81DFA989CC3FAA8A107E272992504")

    private ExpandableListAdapter mExpandableListAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.242 -0500", hash_original_field = "F2FDDB550851DBE7270480C9FF934C87", hash_generated_field = "3E8BCCD4064217A7C173330F3F39D938")

    private ArrayList<GroupMetadata> mExpGroupMetadataList;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.243 -0500", hash_original_field = "37887A3E62399A0ACB7249DD77013A39", hash_generated_field = "64833B5112863E55C291272F61C229B3")

    private int mTotalExpChildrenCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.244 -0500", hash_original_field = "D4E3BB0538C28AEDDB9AC38FB2177D5E", hash_generated_field = "73604CF012E96086A83733575D92D3EC")

    private int mMaxExpGroupCount = Integer.MAX_VALUE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.245 -0500", hash_original_field = "16BBF73E74D7AA68ED02DDB0C88EAD36", hash_generated_field = "096B6AFF2D4BE73F0317C948A7EB332C")

    private final DataSetObserver mDataSetObserver = new MyDataSetObserver();

    /**
     * Constructs the connector
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.245 -0500", hash_original_method = "BC5B318F45FBBBBC44050BD05FD123C0", hash_generated_method = "D399C7E10126385D5C50DCE64A629E53")
    public ExpandableListConnector(ExpandableListAdapter expandableListAdapter) {
        mExpGroupMetadataList = new ArrayList<GroupMetadata>();

        setExpandableListAdapter(expandableListAdapter);
    }

    /**
     * Point to the {@link ExpandableListAdapter} that will give us data/Views
     * 
     * @param expandableListAdapter the adapter that supplies us with data/Views
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.246 -0500", hash_original_method = "20624F8A2041913E46624C5620B8C178", hash_generated_method = "5FF1A583D1FF272FC786661E94CCA714")
    public void setExpandableListAdapter(ExpandableListAdapter expandableListAdapter) {
        if (mExpandableListAdapter != null) {
            mExpandableListAdapter.unregisterDataSetObserver(mDataSetObserver);
        }
        
        mExpandableListAdapter = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(mDataSetObserver);
    }

    /**
     * Translates a flat list position to either a) group pos if the specified
     * flat list position corresponds to a group, or b) child pos if it
     * corresponds to a child.  Performs a binary search on the expanded
     * groups list to find the flat list pos if it is an exp group, otherwise
     * finds where the flat list pos fits in between the exp groups.
     * 
     * @param flPos the flat list position to be translated
     * @return the group position or child position of the specified flat list
     *         position encompassed in a {@link PositionMetadata} object
     *         that contains additional useful info for insertion, etc.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.248 -0500", hash_original_method = "1168BEC82030FA7343EA44D40ECA13BC", hash_generated_method = "98E44E4E5FE99FDAB046C6B842A4D180")
    PositionMetadata getUnflattenedPos(final int flPos) {
        /* Keep locally since frequent use */
        final ArrayList<GroupMetadata> egml = mExpGroupMetadataList;
        final int numExpGroups = egml.size();
        
        /* Binary search variables */
        int leftExpGroupIndex = 0;
        int rightExpGroupIndex = numExpGroups - 1;
        int midExpGroupIndex = 0;
        GroupMetadata midExpGm; 
        
        if (numExpGroups == 0) {
            /*
             * There aren't any expanded groups (hence no visible children
             * either), so flPos must be a group and its group pos will be the
             * same as its flPos
             */
            return PositionMetadata.obtain(flPos, ExpandableListPosition.GROUP, flPos,
                    -1, null, 0);
        }

        /*
         * Binary search over the expanded groups to find either the exact
         * expanded group (if we're looking for a group) or the group that
         * contains the child we're looking for. If we are looking for a
         * collapsed group, we will not have a direct match here, but we will
         * find the expanded group just before the group we're searching for (so
         * then we can calculate the group position of the group we're searching
         * for). If there isn't an expanded group prior to the group being
         * searched for, then the group being searched for's group position is
         * the same as the flat list position (since there are no children before
         * it, and all groups before it are collapsed).
         */
        while (leftExpGroupIndex <= rightExpGroupIndex) {
            midExpGroupIndex =
                    (rightExpGroupIndex - leftExpGroupIndex) / 2
                            + leftExpGroupIndex;
            midExpGm = egml.get(midExpGroupIndex);
            
            if (flPos > midExpGm.lastChildFlPos) {
                /*
                 * The flat list position is after the current middle group's
                 * last child's flat list position, so search right
                 */
                leftExpGroupIndex = midExpGroupIndex + 1;
            } else if (flPos < midExpGm.flPos) {
                /*
                 * The flat list position is before the current middle group's
                 * flat list position, so search left
                 */
                rightExpGroupIndex = midExpGroupIndex - 1;
            } else if (flPos == midExpGm.flPos) {
                /*
                 * The flat list position is this middle group's flat list
                 * position, so we've found an exact hit
                 */
                return PositionMetadata.obtain(flPos, ExpandableListPosition.GROUP,
                        midExpGm.gPos, -1, midExpGm, midExpGroupIndex);
            } else if (flPos <= midExpGm.lastChildFlPos
                    /* && flPos > midGm.flPos as deduced from previous
                     * conditions */) {
                /* The flat list position is a child of the middle group */
                
                /* 
                 * Subtract the first child's flat list position from the
                 * specified flat list pos to get the child's position within
                 * the group
                 */
                final int childPos = flPos - (midExpGm.flPos + 1);
                return PositionMetadata.obtain(flPos, ExpandableListPosition.CHILD,
                        midExpGm.gPos, childPos, midExpGm, midExpGroupIndex);
            } 
        }

        /* 
         * If we've reached here, it means the flat list position must be a
         * group that is not expanded, since otherwise we would have hit it
         * in the above search.
         */


        /**
         * If we are to expand this group later, where would it go in the
         * mExpGroupMetadataList ?
         */
        int insertPosition = 0;
        
        /** What is its group position in the list of all groups? */
        int groupPos = 0;
        
        /*
         * To figure out exact insertion and prior group positions, we need to
         * determine how we broke out of the binary search.  We backtrack
         * to see this.
         */ 
        if (leftExpGroupIndex > midExpGroupIndex) {
            
            /*
             * This would occur in the first conditional, so the flat list
             * insertion position is after the left group. Also, the
             * leftGroupPos is one more than it should be (since that broke out
             * of our binary search), so we decrement it.
             */  
            final GroupMetadata leftExpGm = egml.get(leftExpGroupIndex-1);            

            insertPosition = leftExpGroupIndex;

            /*
             * Sums the number of groups between the prior exp group and this
             * one, and then adds it to the prior group's group pos
             */
            groupPos =
                (flPos - leftExpGm.lastChildFlPos) + leftExpGm.gPos;            
        } else if (rightExpGroupIndex < midExpGroupIndex) {

            /*
             * This would occur in the second conditional, so the flat list
             * insertion position is before the right group. Also, the
             * rightGroupPos is one less than it should be, so increment it.
             */
            final GroupMetadata rightExpGm = egml.get(++rightExpGroupIndex);            

            insertPosition = rightExpGroupIndex;
            
            /*
             * Subtracts this group's flat list pos from the group after's flat
             * list position to find out how many groups are in between the two
             * groups. Then, subtracts that number from the group after's group
             * pos to get this group's pos.
             */
            groupPos = rightExpGm.gPos - (rightExpGm.flPos - flPos);
        } else {
            // TODO: clean exit
            throw new RuntimeException("Unknown state");
        }
        
        return PositionMetadata.obtain(flPos, ExpandableListPosition.GROUP, groupPos, -1,
                null, insertPosition);
    }

    /**
     * Translates either a group pos or a child pos (+ group it belongs to) to a
     * flat list position.  If searching for a child and its group is not expanded, this will
     * return null since the child isn't being shown in the ListView, and hence it has no
     * position.
     * 
     * @param pos a {@link ExpandableListPosition} representing either a group position
     *        or child position
     * @return the flat list position encompassed in a {@link PositionMetadata}
     *         object that contains additional useful info for insertion, etc., or null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.249 -0500", hash_original_method = "1D3F8862F07489DB803D2A10735D7C2B", hash_generated_method = "47E59E70BB5AAAA10CA364DAE8C4BCC5")
    PositionMetadata getFlattenedPos(final ExpandableListPosition pos) {
        final ArrayList<GroupMetadata> egml = mExpGroupMetadataList;
        final int numExpGroups = egml.size();

        /* Binary search variables */
        int leftExpGroupIndex = 0;
        int rightExpGroupIndex = numExpGroups - 1;
        int midExpGroupIndex = 0;
        GroupMetadata midExpGm; 
        
        if (numExpGroups == 0) {
            /*
             * There aren't any expanded groups, so flPos must be a group and
             * its flPos will be the same as its group pos.  The
             * insert position is 0 (since the list is empty).
             */
            return PositionMetadata.obtain(pos.groupPos, pos.type,
                    pos.groupPos, pos.childPos, null, 0);
        }

        /*
         * Binary search over the expanded groups to find either the exact
         * expanded group (if we're looking for a group) or the group that
         * contains the child we're looking for.
         */
        while (leftExpGroupIndex <= rightExpGroupIndex) {
            midExpGroupIndex = (rightExpGroupIndex - leftExpGroupIndex)/2 + leftExpGroupIndex;
            midExpGm = egml.get(midExpGroupIndex);
            
            if (pos.groupPos > midExpGm.gPos) {
                /*
                 * It's after the current middle group, so search right
                 */
                leftExpGroupIndex = midExpGroupIndex + 1;
            } else if (pos.groupPos < midExpGm.gPos) {
                /*
                 * It's before the current middle group, so search left
                 */
                rightExpGroupIndex = midExpGroupIndex - 1;
            } else if (pos.groupPos == midExpGm.gPos) {
                /*
                 * It's this middle group, exact hit
                 */
                
                if (pos.type == ExpandableListPosition.GROUP) {
                    /* If it's a group, give them this matched group's flPos */
                    return PositionMetadata.obtain(midExpGm.flPos, pos.type,
                            pos.groupPos, pos.childPos, midExpGm, midExpGroupIndex);
                } else if (pos.type == ExpandableListPosition.CHILD) {
                    /* If it's a child, calculate the flat list pos */
                    return PositionMetadata.obtain(midExpGm.flPos + pos.childPos
                            + 1, pos.type, pos.groupPos, pos.childPos,
                            midExpGm, midExpGroupIndex);
                } else {
                    return null;
                }
            } 
        }

        /* 
         * If we've reached here, it means there was no match in the expanded
         * groups, so it must be a collapsed group that they're search for
         */
        if (pos.type != ExpandableListPosition.GROUP) {
            /* If it isn't a group, return null */
            return null;
        }
        
        /*
         * To figure out exact insertion and prior group positions, we need to
         * determine how we broke out of the binary search. We backtrack to see
         * this.
         */ 
        if (leftExpGroupIndex > midExpGroupIndex) {
            
            /*
             * This would occur in the first conditional, so the flat list
             * insertion position is after the left group.
             * 
             * The leftGroupPos is one more than it should be (from the binary
             * search loop) so we subtract 1 to get the actual left group.  Since
             * the insertion point is AFTER the left group, we keep this +1
             * value as the insertion point
             */  
            final GroupMetadata leftExpGm = egml.get(leftExpGroupIndex-1);            
            final int flPos =
                    leftExpGm.lastChildFlPos
                            + (pos.groupPos - leftExpGm.gPos);

            return PositionMetadata.obtain(flPos, pos.type, pos.groupPos,
                    pos.childPos, null, leftExpGroupIndex);
        } else if (rightExpGroupIndex < midExpGroupIndex) {

            /*
             * This would occur in the second conditional, so the flat list
             * insertion position is before the right group. Also, the
             * rightGroupPos is one less than it should be (from binary search
             * loop), so we increment to it.
             */
            final GroupMetadata rightExpGm = egml.get(++rightExpGroupIndex);            
            final int flPos =
                    rightExpGm.flPos
                            - (rightExpGm.gPos - pos.groupPos);
            return PositionMetadata.obtain(flPos, pos.type, pos.groupPos,
                    pos.childPos, null, rightExpGroupIndex);
        } else {
            return null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.251 -0500", hash_original_method = "DAE4954D9EDE366A718556293A5AA5D3", hash_generated_method = "DE28B911F155222C0193C0AD581248C1")
    @Override
public boolean areAllItemsEnabled() {
        return mExpandableListAdapter.areAllItemsEnabled();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.252 -0500", hash_original_method = "0084AC4844BFD434CBA804E2DF22BA27", hash_generated_method = "7432A7A6BA74BE172448AF50DF9AFE19")
    @Override
public boolean isEnabled(int flatListPos) {
        final ExpandableListPosition pos = getUnflattenedPos(flatListPos).position;
        
        boolean retValue;
        if (pos.type == ExpandableListPosition.CHILD) {
            retValue = mExpandableListAdapter.isChildSelectable(pos.groupPos, pos.childPos);
        } else {
            // Groups are always selectable
            retValue = true;
        }
        
        pos.recycle();
        
        return retValue;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.252 -0500", hash_original_method = "E43CB6EF7F0706DB8CAE1E4EB2A6AE3E", hash_generated_method = "47DB55305C8A6796D86224A1FE93B0AA")
    public int getCount() {
        /*
         * Total count for the list view is the number groups plus the 
         * number of children from currently expanded groups (a value we keep
         * cached in this class)
         */ 
        return mExpandableListAdapter.getGroupCount() + mTotalExpChildrenCount;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.253 -0500", hash_original_method = "06B72D417088BC3B17164CA741049075", hash_generated_method = "AB9F9881D27F80592D3E7BA9E009E48F")
    public Object getItem(int flatListPos) {
        final PositionMetadata posMetadata = getUnflattenedPos(flatListPos);

        Object retValue;
        if (posMetadata.position.type == ExpandableListPosition.GROUP) {
            retValue = mExpandableListAdapter
                    .getGroup(posMetadata.position.groupPos);
        } else if (posMetadata.position.type == ExpandableListPosition.CHILD) {
            retValue = mExpandableListAdapter.getChild(posMetadata.position.groupPos,
                    posMetadata.position.childPos);
        } else {
            // TODO: clean exit
            throw new RuntimeException("Flat list position is of unknown type");
        }
        
        posMetadata.recycle();
        
        return retValue;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.254 -0500", hash_original_method = "4AC16A8A6C46491D50BE7E30F75A3576", hash_generated_method = "9C1FA81FA45FB4F67BB0BA95A8E37A70")
    public long getItemId(int flatListPos) {
        final PositionMetadata posMetadata = getUnflattenedPos(flatListPos);
        final long groupId = mExpandableListAdapter.getGroupId(posMetadata.position.groupPos);
        
        long retValue;
        if (posMetadata.position.type == ExpandableListPosition.GROUP) {
            retValue = mExpandableListAdapter.getCombinedGroupId(groupId);
        } else if (posMetadata.position.type == ExpandableListPosition.CHILD) {
            final long childId = mExpandableListAdapter.getChildId(posMetadata.position.groupPos,
                    posMetadata.position.childPos);
            retValue = mExpandableListAdapter.getCombinedChildId(groupId, childId);
        } else {
            // TODO: clean exit
            throw new RuntimeException("Flat list position is of unknown type");
        }
        
        posMetadata.recycle();
        
        return retValue;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.256 -0500", hash_original_method = "E8F063B04C087445609A9E5E66DA0C8E", hash_generated_method = "278DAC0FDBB3963CE3BC73B3B7D74A5B")
    public View getView(int flatListPos, View convertView, ViewGroup parent) {
        final PositionMetadata posMetadata = getUnflattenedPos(flatListPos);

        View retValue;
        if (posMetadata.position.type == ExpandableListPosition.GROUP) {
            retValue = mExpandableListAdapter.getGroupView(posMetadata.position.groupPos,
                    posMetadata.isExpanded(), convertView, parent);
        } else if (posMetadata.position.type == ExpandableListPosition.CHILD) {
            final boolean isLastChild = posMetadata.groupMetadata.lastChildFlPos == flatListPos;
            
            retValue = mExpandableListAdapter.getChildView(posMetadata.position.groupPos,
                    posMetadata.position.childPos, isLastChild, convertView, parent);
        } else {
            // TODO: clean exit
            throw new RuntimeException("Flat list position is of unknown type");
        }
        
        posMetadata.recycle();
        
        return retValue;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.257 -0500", hash_original_method = "99547DA2855DBC2792C3AF02654A4FE0", hash_generated_method = "C3666CABD146D7E0B72B8235EAFF3D01")
    @Override
public int getItemViewType(int flatListPos) {
        final ExpandableListPosition pos = getUnflattenedPos(flatListPos).position;

        int retValue;
        if (mExpandableListAdapter instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList adapter =
                    (HeterogeneousExpandableList) mExpandableListAdapter;
            if (pos.type == ExpandableListPosition.GROUP) {
                retValue = adapter.getGroupType(pos.groupPos);
            } else {
                final int childType = adapter.getChildType(pos.groupPos, pos.childPos);
                retValue = adapter.getGroupTypeCount() + childType;
            }
        } else {
            if (pos.type == ExpandableListPosition.GROUP) {
                retValue = 0;
            } else {
                retValue = 1;
            }
        }
        
        pos.recycle();
        
        return retValue;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.257 -0500", hash_original_method = "CE0634CAEF6413BEB2C07851873B554E", hash_generated_method = "A5F3735927BB5E300DA60480B75908FF")
    @Override
public int getViewTypeCount() {
        if (mExpandableListAdapter instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList adapter =
                    (HeterogeneousExpandableList) mExpandableListAdapter;
            return adapter.getGroupTypeCount() + adapter.getChildTypeCount();
        } else {
            return 2;
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.258 -0500", hash_original_method = "4910256FB1EE08A13057FF7D9F357251", hash_generated_method = "2A0DFAE132E3C5C2CA6E69107DE71084")
    @Override
public boolean hasStableIds() {
        return mExpandableListAdapter.hasStableIds();
    }

    /**
     * Traverses the expanded group metadata list and fills in the flat list
     * positions.
     * 
     * @param forceChildrenCountRefresh Forces refreshing of the children count
     *        for all expanded groups.
     * @param syncGroupPositions Whether to search for the group positions
     *         based on the group IDs. This should only be needed when calling
     *         this from an onChanged callback.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.259 -0500", hash_original_method = "E23B4E2A713C93A88E352378F7DC6B9B", hash_generated_method = "F6328C3E10841AEBBE550B2E6E81DCC3")
    @SuppressWarnings("unchecked")
private void refreshExpGroupMetadataList(boolean forceChildrenCountRefresh,
            boolean syncGroupPositions) {
        final ArrayList<GroupMetadata> egml = mExpGroupMetadataList;
        int egmlSize = egml.size();
        int curFlPos = 0;
        
        /* Update child count as we go through */
        mTotalExpChildrenCount = 0;
        
        if (syncGroupPositions) {
            // We need to check whether any groups have moved positions
            boolean positionsChanged = false;
            
            for (int i = egmlSize - 1; i >= 0; i--) {
                GroupMetadata curGm = egml.get(i);
                int newGPos = findGroupPosition(curGm.gId, curGm.gPos);
                if (newGPos != curGm.gPos) {
                    if (newGPos == AdapterView.INVALID_POSITION) {
                        // Doh, just remove it from the list of expanded groups
                        egml.remove(i);
                        egmlSize--;
                    }
                    
                    curGm.gPos = newGPos;
                    if (!positionsChanged) positionsChanged = true;
                }
            }
            
            if (positionsChanged) {
                // At least one group changed positions, so re-sort
                Collections.sort(egml);
            }
        }
        
        int gChildrenCount;
        int lastGPos = 0;
        for (int i = 0; i < egmlSize; i++) {
            /* Store in local variable since we'll access freq */
            GroupMetadata curGm = egml.get(i);
            
            /*
             * Get the number of children, try to refrain from calling
             * another class's method unless we have to (so do a subtraction)
             */
            if ((curGm.lastChildFlPos == GroupMetadata.REFRESH) || forceChildrenCountRefresh) {
                gChildrenCount = mExpandableListAdapter.getChildrenCount(curGm.gPos);
            } else {
                /* Num children for this group is its last child's fl pos minus
                 * the group's fl pos
                 */
                gChildrenCount = curGm.lastChildFlPos - curGm.flPos;
            }
            
            /* Update */
            mTotalExpChildrenCount += gChildrenCount;
            
            /*
             * This skips the collapsed groups and increments the flat list
             * position (for subsequent exp groups) by accounting for the collapsed
             * groups
             */
            curFlPos += (curGm.gPos - lastGPos);
            lastGPos = curGm.gPos;
            
            /* Update the flat list positions, and the current flat list pos */
            curGm.flPos = curFlPos;
            curFlPos += gChildrenCount; 
            curGm.lastChildFlPos = curFlPos; 
        }
    }
    
    /**
     * Collapse a group in the grouped list view
     * 
     * @param groupPos position of the group to collapse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.260 -0500", hash_original_method = "356AA5E78F17E2ABD0F401EB8EAF983A", hash_generated_method = "356AA5E78F17E2ABD0F401EB8EAF983A")
    boolean collapseGroup(int groupPos) {
        PositionMetadata pm = getFlattenedPos(ExpandableListPosition.obtain(
                ExpandableListPosition.GROUP, groupPos, -1, -1)); 
        if (pm == null) return false;
        
        boolean retValue = collapseGroup(pm);
        pm.recycle();
        return retValue;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.261 -0500", hash_original_method = "B7CC4B14B03031BB8898031F497A0B04", hash_generated_method = "267E8E0A4BB170AAE242A75ACEE5AB84")
    boolean collapseGroup(PositionMetadata posMetadata) {
        /*
         * Collapsing requires removal from mExpGroupMetadataList 
         */
        
        /*
         * If it is null, it must be already collapsed. This group metadata
         * object should have been set from the search that returned the
         * position metadata object.
         */
        if (posMetadata.groupMetadata == null) return false;
        
        // Remove the group from the list of expanded groups 
        mExpGroupMetadataList.remove(posMetadata.groupMetadata);

        // Refresh the metadata
        refreshExpGroupMetadataList(false, false);
        
        // Notify of change
        notifyDataSetChanged();
        
        // Give the callback
        mExpandableListAdapter.onGroupCollapsed(posMetadata.groupMetadata.gPos);
        
        return true;
    }

    /**
     * Expand a group in the grouped list view
     * @param groupPos the group to be expanded
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.262 -0500", hash_original_method = "5E373C5564B1740CC801138FBC6EE83B", hash_generated_method = "5E373C5564B1740CC801138FBC6EE83B")
    boolean expandGroup(int groupPos) {
        PositionMetadata pm = getFlattenedPos(ExpandableListPosition.obtain(
                ExpandableListPosition.GROUP, groupPos, -1, -1));
        boolean retValue = expandGroup(pm);
        pm.recycle();
        return retValue;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.263 -0500", hash_original_method = "7C096EBC61E7C7FF959B994559196523", hash_generated_method = "02C8AEB6F7EB50B90C736E8109445974")
    boolean expandGroup(PositionMetadata posMetadata) {
        /*
         * Expanding requires insertion into the mExpGroupMetadataList 
         */

        if (posMetadata.position.groupPos < 0) {
            // TODO clean exit
            throw new RuntimeException("Need group");
        }

        if (mMaxExpGroupCount == 0) return false;
        
        // Check to see if it's already expanded
        if (posMetadata.groupMetadata != null) return false;
        
        /* Restrict number of expanded groups to mMaxExpGroupCount */
        if (mExpGroupMetadataList.size() >= mMaxExpGroupCount) {
            /* Collapse a group */
            // TODO: Collapse something not on the screen instead of the first one?
            // TODO: Could write overloaded function to take GroupMetadata to collapse
            GroupMetadata collapsedGm = mExpGroupMetadataList.get(0);
            
            int collapsedIndex = mExpGroupMetadataList.indexOf(collapsedGm);
            
            collapseGroup(collapsedGm.gPos);

            /* Decrement index if it is after the group we removed */
            if (posMetadata.groupInsertIndex > collapsedIndex) {
                posMetadata.groupInsertIndex--;
            }
        }
        
        GroupMetadata expandedGm = GroupMetadata.obtain(
                GroupMetadata.REFRESH,
                GroupMetadata.REFRESH,
                posMetadata.position.groupPos,
                mExpandableListAdapter.getGroupId(posMetadata.position.groupPos));
        
        mExpGroupMetadataList.add(posMetadata.groupInsertIndex, expandedGm);

        // Refresh the metadata
        refreshExpGroupMetadataList(false, false);
        
        // Notify of change
        notifyDataSetChanged();
        
        // Give the callback
        mExpandableListAdapter.onGroupExpanded(expandedGm.gPos);

        return true;
    }
    
    /**
     * Whether the given group is currently expanded.
     * @param groupPosition The group to check.
     * @return Whether the group is currently expanded.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.264 -0500", hash_original_method = "14DD7EE25463BE2F409F1A554DB1FBD9", hash_generated_method = "90AC6F49BA9BBA0C4EBC7A0E5C05A64C")
    public boolean isGroupExpanded(int groupPosition) {
        GroupMetadata groupMetadata;
        for (int i = mExpGroupMetadataList.size() - 1; i >= 0; i--) {
            groupMetadata = mExpGroupMetadataList.get(i);
            
            if (groupMetadata.gPos == groupPosition) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Set the maximum number of groups that can be expanded at any given time
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.264 -0500", hash_original_method = "5DCA730791D083145030F1469300702C", hash_generated_method = "3A314B2BF11D01C42E3E0FA03748D4B3")
    public void setMaxExpGroupCount(int maxExpGroupCount) {
        mMaxExpGroupCount = maxExpGroupCount;
    }    

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.266 -0500", hash_original_method = "473155659E1950E1738B6CCA8650B997", hash_generated_method = "473155659E1950E1738B6CCA8650B997")
    ExpandableListAdapter getAdapter() {
        return mExpandableListAdapter;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.267 -0500", hash_original_method = "D7C89EA0D9DD591B12578E8793100CE2", hash_generated_method = "D406C3BE28EC3D0684B6ED6E2E370ED0")
    public Filter getFilter() {
        ExpandableListAdapter adapter = getAdapter();
        if (adapter instanceof Filterable) {
            return ((Filterable) adapter).getFilter();
        } else {
            return null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.267 -0500", hash_original_method = "740752E96AF2B266538C6125F8E79937", hash_generated_method = "740752E96AF2B266538C6125F8E79937")
    ArrayList<GroupMetadata> getExpandedGroupMetadataList() {
        return mExpGroupMetadataList;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.268 -0500", hash_original_method = "43D377DDC694A5D1EB7EAB73153EC2C8", hash_generated_method = "0EA033DF078D862B1BB25A2BC8FF1ADC")
    void setExpandedGroupMetadataList(ArrayList<GroupMetadata> expandedGroupMetadataList) {
        
        if ((expandedGroupMetadataList == null) || (mExpandableListAdapter == null)) {
            return;
        }
        
        // Make sure our current data set is big enough for the previously
        // expanded groups, if not, ignore this request
        int numGroups = mExpandableListAdapter.getGroupCount();
        for (int i = expandedGroupMetadataList.size() - 1; i >= 0; i--) {
            if (expandedGroupMetadataList.get(i).gPos >= numGroups) {
                // Doh, for some reason the client doesn't have some of the groups
                return;
            }
        }
        
        mExpGroupMetadataList = expandedGroupMetadataList;
        refreshExpGroupMetadataList(true, false);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.269 -0500", hash_original_method = "DF256FE26F67ED917C946C2E9410F027", hash_generated_method = "9D851244A11EC8F22F920F089137062E")
    @Override
public boolean isEmpty() {
        ExpandableListAdapter adapter = getAdapter();
        return adapter != null ? adapter.isEmpty() : true;
    }

    /**
     * Searches the expandable list adapter for a group position matching the
     * given group ID. The search starts at the given seed position and then
     * alternates between moving up and moving down until 1) we find the right
     * position, or 2) we run out of time, or 3) we have looked at every
     * position
     * 
     * @return Position of the row that matches the given row ID, or
     *         {@link AdapterView#INVALID_POSITION} if it can't be found
     * @see AdapterView#findSyncPosition()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.270 -0500", hash_original_method = "174FBE5747A707DB845F85C327785D51", hash_generated_method = "FA57EACDCE0D3B1E10B241C2A5BB18B2")
    int findGroupPosition(long groupIdToMatch, int seedGroupPosition) {
        int count = mExpandableListAdapter.getGroupCount();

        if (count == 0) {
            return AdapterView.INVALID_POSITION;
        }

        // If there isn't a selection don't hunt for it
        if (groupIdToMatch == AdapterView.INVALID_ROW_ID) {
            return AdapterView.INVALID_POSITION;
        }

        // Pin seed to reasonable values
        seedGroupPosition = Math.max(0, seedGroupPosition);
        seedGroupPosition = Math.min(count - 1, seedGroupPosition);

        long endTime = SystemClock.uptimeMillis() + AdapterView.SYNC_MAX_DURATION_MILLIS;

        long rowId;

        // first position scanned so far
        int first = seedGroupPosition;

        // last position scanned so far
        int last = seedGroupPosition;

        // True if we should move down on the next iteration
        boolean next = false;

        // True when we have looked at the first item in the data
        boolean hitFirst;

        // True when we have looked at the last item in the data
        boolean hitLast;

        // Get the item ID locally (instead of getItemIdAtPosition), so
        // we need the adapter
        ExpandableListAdapter adapter = getAdapter();
        if (adapter == null) {
            return AdapterView.INVALID_POSITION;
        }

        while (SystemClock.uptimeMillis() <= endTime) {
            rowId = adapter.getGroupId(seedGroupPosition);
            if (rowId == groupIdToMatch) {
                // Found it!
                return seedGroupPosition;
            }

            hitLast = last == count - 1;
            hitFirst = first == 0;

            if (hitLast && hitFirst) {
                // Looked at everything
                break;
            }

            if (hitFirst || (next && !hitLast)) {
                // Either we hit the top, or we are trying to move down
                last++;
                seedGroupPosition = last;
                // Try going up next time
                next = false;
            } else if (hitLast || (!next && !hitFirst)) {
                // Either we hit the bottom, or we are trying to move up
                first--;
                seedGroupPosition = first;
                // Try going down next time
                next = true;
            }

        }

        return AdapterView.INVALID_POSITION;
    }

    
    protected class MyDataSetObserver extends DataSetObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.396 -0400", hash_original_method = "B8855E81B638DE0F5C9202168EAE6D42", hash_generated_method = "B8855E81B638DE0F5C9202168EAE6D42")
        public MyDataSetObserver ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.271 -0500", hash_original_method = "6638C55358D7A5972C632ED02BA3E5C3", hash_generated_method = "B265B43DFC29D8AF82A6D948594046AD")
        @Override
public void onChanged() {
            refreshExpGroupMetadataList(true, true);
            
            notifyDataSetChanged();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.272 -0500", hash_original_method = "097361F82E1EAFBA4D6D3BF1780C0DD3", hash_generated_method = "122D3CAD2026DFBB4A415C8D12DED51C")
        @Override
public void onInvalidated() {
            refreshExpGroupMetadataList(true, true);
            
            notifyDataSetInvalidated();
        }

        
    }


    
    static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.279 -0500", hash_original_method = "2B12A460F68F821AFB893D8E745D52C4", hash_generated_method = "7A619C7E7D1D4CD22319AE170751805D")
        static GroupMetadata obtain(int flPos, int lastChildFlPos, int gPos, long gId) {
            GroupMetadata gm = new GroupMetadata();
            gm.flPos = flPos;
            gm.lastChildFlPos = lastChildFlPos;
            gm.gPos = gPos;
            gm.gId = gId;
            return gm;
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.274 -0500", hash_original_field = "84B4B68A7FC7370DC7068FDF8FE255E0", hash_generated_field = "AA4362F6390CEC3E3D3C031E047DB090")

        final static int REFRESH = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.397 -0400", hash_original_field = "78442AA8D3BDB00B3E51CD054914D00C", hash_generated_field = "904F1381FE24EA0344AB3807F0522586")

        public static final Parcelable.Creator<GroupMetadata> CREATOR =
                new Parcelable.Creator<GroupMetadata>() {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.283 -0500", hash_original_method = "7666142641B123E4C50AF29F73470D4C", hash_generated_method = "EC2ECA427037B9F9CB737317DAE26498")
            public GroupMetadata createFromParcel(Parcel in) {
                GroupMetadata gm = GroupMetadata.obtain(
                        in.readInt(),
                        in.readInt(),
                        in.readInt(),
                        in.readLong());
                return gm;
            }
    
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.284 -0500", hash_original_method = "EF75B3740CF336BA8876BFA102D2490A", hash_generated_method = "BEA2FC89CEEEC1BF914754800F6CDB26")
            public GroupMetadata[] newArray(int size) {
                return new GroupMetadata[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.275 -0500", hash_original_field = "58B6025F7C34D4075DA7A8B5B78AF226", hash_generated_field = "58B6025F7C34D4075DA7A8B5B78AF226")

        int flPos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:34:42.779 -0500", hash_original_field = "1D206009A6034643761BC2A5FF4F958A", hash_generated_field = "CA711A65235C080BF7996DBB0A1BD502")

        
        /**
         * This group's last child's flat list position, so basically
         * the range of this group in the flat list
         */
        int lastChildFlPos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.276 -0500", hash_original_field = "3DC369C72F1134212FEABAA7CBB84833", hash_generated_field = "3DC369C72F1134212FEABAA7CBB84833")

        int gPos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.277 -0500", hash_original_field = "FF49466B0FCBC21119470C70559BF788", hash_generated_field = "FF49466B0FCBC21119470C70559BF788")

        long gId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.278 -0500", hash_original_method = "D22B32F032ACC40BC7080CC4DC6C0D5E", hash_generated_method = "66B3DA2A621E45583C4F654641E42F64")
        private GroupMetadata() {
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.280 -0500", hash_original_method = "ECBFFC8C0ED7A961DBF56C4EE305170D", hash_generated_method = "F866B1A80686D809602404CC871A528E")
        public int compareTo(GroupMetadata another) {
            if (another == null) {
                throw new IllegalArgumentException();
            }
            
            return gPos - another.gPos;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.281 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
        public int describeContents() {
            return 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.281 -0500", hash_original_method = "65A29D222E83CA17BC122C9C28EAFA8F", hash_generated_method = "2E3B19BB47FEF2A550C9EC556F865025")
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(flPos);
            dest.writeInt(lastChildFlPos);
            dest.writeInt(gPos);
            dest.writeLong(gId);
        }
        // orphaned legacy method
        public GroupMetadata createFromParcel(Parcel in) {
                GroupMetadata gm = GroupMetadata.obtain(
                        in.readInt(),
                        in.readInt(),
                        in.readInt(),
                        in.readLong());
                return gm;
            }
        
        // orphaned legacy method
        public GroupMetadata[] newArray(int size) {
                return new GroupMetadata[size];
            }
        
    }


    
    static public class PositionMetadata {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.292 -0500", hash_original_method = "649262705A74E8A0806C94474C513B14", hash_generated_method = "44AC1CC38A599427EC0C253D6A7AACAA")
        static PositionMetadata obtain(int flatListPos, int type, int groupPos,
                int childPos, GroupMetadata groupMetadata, int groupInsertIndex) {
            PositionMetadata pm = getRecycledOrCreate();
            pm.position = ExpandableListPosition.obtain(type, groupPos, childPos, flatListPos);
            pm.groupMetadata = groupMetadata;
            pm.groupInsertIndex = groupInsertIndex;
            return pm;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.293 -0500", hash_original_method = "9149D60AD78C864FCC50349463BE3741", hash_generated_method = "8F2EA208F3D1BFA826E16A80AB1BC40C")
        private static PositionMetadata getRecycledOrCreate() {
            PositionMetadata pm;
            synchronized (sPool) {
                if (sPool.size() > 0) {
                    pm = sPool.remove(0);
                } else {
                    return new PositionMetadata();
                }
            }
            pm.resetState();
            return pm;
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.286 -0500", hash_original_field = "73A7DB4BA52C41C46FF2526949A8CECE", hash_generated_field = "7127A67374BF405D0F01EEB2429B1D48")

        
        private static final int MAX_POOL_SIZE = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.287 -0500", hash_original_field = "E5612D1F77D6B8D6ECF15E38DB9451F9", hash_generated_field = "8C9EE594696DB4880353F853B50DD5E0")

        private static ArrayList<PositionMetadata> sPool =
                new ArrayList<PositionMetadata>(MAX_POOL_SIZE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.288 -0500", hash_original_field = "5CE0DE49289E9E4A92A29888327E246E", hash_generated_field = "439A44C84644DDD041C72E7D8E43AE28")

        public ExpandableListPosition position;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.289 -0500", hash_original_field = "CFA5706C7EB0D6C13E6F2F74CED23C0E", hash_generated_field = "1B4C4593E0FDCF44159ACC4FBB332E4C")

        public GroupMetadata groupMetadata;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.290 -0500", hash_original_field = "60AEE389EED8EDE628BA8FEFA78FE807", hash_generated_field = "21E16F098268A299565F9E372C785629")

        public int groupInsertIndex;
        
        /**
         * Use {@link #obtain(int, int, int, int, GroupMetadata, int)}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.292 -0500", hash_original_method = "D695D4EB809D075329F88CC11AC9F37B", hash_generated_method = "A9ADC97C919B0932908B14D94925CB26")
        private PositionMetadata() {
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.291 -0500", hash_original_method = "5AD4B913B9726C3345D273778B3773BA", hash_generated_method = "FF685B47CD5846D30FF011982012AE01")
        private void resetState() {
            position = null;
            groupMetadata = null;
            groupInsertIndex = 0;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.294 -0500", hash_original_method = "8A154BA1D9B394A3D67E04E6A86589B2", hash_generated_method = "D64E89134CFC371784818AC6DB037546")
        public void recycle() {
            synchronized (sPool) {
                if (sPool.size() < MAX_POOL_SIZE) {
                    sPool.add(this);
                }
            }
        }
        
        /**
         * Checks whether the group referred to in this object is expanded,
         * or not (at the time this object was created)
         * 
         * @return whether the group at groupPos is expanded or not
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:09.295 -0500", hash_original_method = "3DA77438EDE7E493B793AF2E840B43CD", hash_generated_method = "D01D31263CC47F8D2C2E50DB6F92AA06")
        public boolean isExpanded() {
            return groupMetadata != null;
        }
    }


    
}

