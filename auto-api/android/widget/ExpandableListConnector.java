package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.database.DataSetObserver;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;

class ExpandableListConnector extends BaseAdapter implements Filterable {
    private ExpandableListAdapter mExpandableListAdapter;
    private ArrayList<GroupMetadata> mExpGroupMetadataList;
    private int mTotalExpChildrenCount;
    private int mMaxExpGroupCount = Integer.MAX_VALUE;
    private DataSetObserver mDataSetObserver = new MyDataSetObserver();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.505 -0400", hash_original_method = "BC5B318F45FBBBBC44050BD05FD123C0", hash_generated_method = "9F65317D18CFB28AAB2127EC073BF060")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ExpandableListConnector(ExpandableListAdapter expandableListAdapter) {
        dsTaint.addTaint(expandableListAdapter.dsTaint);
        mExpGroupMetadataList = new ArrayList<GroupMetadata>();
        setExpandableListAdapter(expandableListAdapter);
        // ---------- Original Method ----------
        //mExpGroupMetadataList = new ArrayList<GroupMetadata>();
        //setExpandableListAdapter(expandableListAdapter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.505 -0400", hash_original_method = "20624F8A2041913E46624C5620B8C178", hash_generated_method = "DC970D39D664B8A15F67DC72F37C70C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setExpandableListAdapter(ExpandableListAdapter expandableListAdapter) {
        dsTaint.addTaint(expandableListAdapter.dsTaint);
        {
            mExpandableListAdapter.unregisterDataSetObserver(mDataSetObserver);
        } //End block
        expandableListAdapter.registerDataSetObserver(mDataSetObserver);
        // ---------- Original Method ----------
        //if (mExpandableListAdapter != null) {
            //mExpandableListAdapter.unregisterDataSetObserver(mDataSetObserver);
        //}
        //mExpandableListAdapter = expandableListAdapter;
        //expandableListAdapter.registerDataSetObserver(mDataSetObserver);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.506 -0400", hash_original_method = "1168BEC82030FA7343EA44D40ECA13BC", hash_generated_method = "F627FDF4FA2686DC6FA562DFBBC85897")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     PositionMetadata getUnflattenedPos(final int flPos) {
        dsTaint.addTaint(flPos);
        ArrayList<GroupMetadata> egml;
        egml = mExpGroupMetadataList;
        int numExpGroups;
        numExpGroups = egml.size();
        int leftExpGroupIndex;
        leftExpGroupIndex = 0;
        int rightExpGroupIndex;
        rightExpGroupIndex = numExpGroups - 1;
        int midExpGroupIndex;
        midExpGroupIndex = 0;
        GroupMetadata midExpGm;
        {
            PositionMetadata varAEAED91AE21B6A3B34B3936A8AD94877_1332301557 = (PositionMetadata.obtain(flPos, ExpandableListPosition.GROUP, flPos,
                    -1, null, 0));
        } //End block
        {
            midExpGroupIndex =
                    (rightExpGroupIndex - leftExpGroupIndex) / 2
                            + leftExpGroupIndex;
            midExpGm = egml.get(midExpGroupIndex);
            {
                leftExpGroupIndex = midExpGroupIndex + 1;
            } //End block
            {
                rightExpGroupIndex = midExpGroupIndex - 1;
            } //End block
            {
                PositionMetadata varE164DDE26F552A23B014E113AE43069A_998425842 = (PositionMetadata.obtain(flPos, ExpandableListPosition.GROUP,
                        midExpGm.gPos, -1, midExpGm, midExpGroupIndex));
            } //End block
            {
                int childPos;
                childPos = flPos - (midExpGm.flPos + 1);
                PositionMetadata var30B48E79491756755B6FB257A130FDF2_1348901365 = (PositionMetadata.obtain(flPos, ExpandableListPosition.CHILD,
                        midExpGm.gPos, childPos, midExpGm, midExpGroupIndex));
            } //End block
        } //End block
        int insertPosition;
        insertPosition = 0;
        int groupPos;
        groupPos = 0;
        {
            GroupMetadata leftExpGm;
            leftExpGm = egml.get(leftExpGroupIndex-1);
            insertPosition = leftExpGroupIndex;
            groupPos =
                (flPos - leftExpGm.lastChildFlPos) + leftExpGm.gPos;
        } //End block
        {
            GroupMetadata rightExpGm;
            rightExpGm = egml.get(++rightExpGroupIndex);
            insertPosition = rightExpGroupIndex;
            groupPos = rightExpGm.gPos - (rightExpGm.flPos - flPos);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Unknown state");
        } //End block
        PositionMetadata varD4989C274A365EB7D4FDFB3CE689F3F8_303201092 = (PositionMetadata.obtain(flPos, ExpandableListPosition.GROUP, groupPos, -1,
                null, insertPosition));
        return (PositionMetadata)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.507 -0400", hash_original_method = "1D3F8862F07489DB803D2A10735D7C2B", hash_generated_method = "DAE312CAE65EF4D01CD360C8F4377AFD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     PositionMetadata getFlattenedPos(final ExpandableListPosition pos) {
        dsTaint.addTaint(pos.dsTaint);
        ArrayList<GroupMetadata> egml;
        egml = mExpGroupMetadataList;
        int numExpGroups;
        numExpGroups = egml.size();
        int leftExpGroupIndex;
        leftExpGroupIndex = 0;
        int rightExpGroupIndex;
        rightExpGroupIndex = numExpGroups - 1;
        int midExpGroupIndex;
        midExpGroupIndex = 0;
        GroupMetadata midExpGm;
        {
            PositionMetadata var9F999C82AE955B0CA668C0DA543180D9_1243510781 = (PositionMetadata.obtain(pos.groupPos, pos.type,
                    pos.groupPos, pos.childPos, null, 0));
        } //End block
        {
            midExpGroupIndex = (rightExpGroupIndex - leftExpGroupIndex)/2 + leftExpGroupIndex;
            midExpGm = egml.get(midExpGroupIndex);
            {
                leftExpGroupIndex = midExpGroupIndex + 1;
            } //End block
            {
                rightExpGroupIndex = midExpGroupIndex - 1;
            } //End block
            {
                {
                    PositionMetadata varE3ACAFE409CCD8865E82387F2A51997E_2046159258 = (PositionMetadata.obtain(midExpGm.flPos, pos.type,
                            pos.groupPos, pos.childPos, midExpGm, midExpGroupIndex));
                } //End block
                {
                    PositionMetadata varD8E371D624B5F2681790C018F0F6BF74_460896987 = (PositionMetadata.obtain(midExpGm.flPos + pos.childPos
                            + 1, pos.type, pos.groupPos, pos.childPos,
                            midExpGm, midExpGroupIndex));
                } //End block
            } //End block
        } //End block
        {
            GroupMetadata leftExpGm;
            leftExpGm = egml.get(leftExpGroupIndex-1);
            int flPos;
            flPos = leftExpGm.lastChildFlPos
                            + (pos.groupPos - leftExpGm.gPos);
            PositionMetadata var63F3EC37CEBCAB7DC984A956603A4DA0_652731503 = (PositionMetadata.obtain(flPos, pos.type, pos.groupPos,
                    pos.childPos, null, leftExpGroupIndex));
        } //End block
        {
            GroupMetadata rightExpGm;
            rightExpGm = egml.get(++rightExpGroupIndex);
            int flPos;
            flPos = rightExpGm.flPos
                            - (rightExpGm.gPos - pos.groupPos);
            PositionMetadata var613E5E47D8716E8FA7FE24F2D9F78A6C_449731458 = (PositionMetadata.obtain(flPos, pos.type, pos.groupPos,
                    pos.childPos, null, rightExpGroupIndex));
        } //End block
        return (PositionMetadata)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.507 -0400", hash_original_method = "DAE4954D9EDE366A718556293A5AA5D3", hash_generated_method = "C01495736E921AE4D1464A7324704D04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean areAllItemsEnabled() {
        boolean var5A180658E7F9DF714EBCBF2EE1C5FDF9_1890188066 = (mExpandableListAdapter.areAllItemsEnabled());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mExpandableListAdapter.areAllItemsEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.507 -0400", hash_original_method = "0084AC4844BFD434CBA804E2DF22BA27", hash_generated_method = "9A3E6E9CCA982117D599F4DA9DB5D055")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isEnabled(int flatListPos) {
        dsTaint.addTaint(flatListPos);
        ExpandableListPosition pos;
        pos = getUnflattenedPos(flatListPos).position;
        boolean retValue;
        {
            retValue = mExpandableListAdapter.isChildSelectable(pos.groupPos, pos.childPos);
        } //End block
        {
            retValue = true;
        } //End block
        pos.recycle();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final ExpandableListPosition pos = getUnflattenedPos(flatListPos).position;
        //boolean retValue;
        //if (pos.type == ExpandableListPosition.CHILD) {
            //retValue = mExpandableListAdapter.isChildSelectable(pos.groupPos, pos.childPos);
        //} else {
            //retValue = true;
        //}
        //pos.recycle();
        //return retValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.507 -0400", hash_original_method = "E43CB6EF7F0706DB8CAE1E4EB2A6AE3E", hash_generated_method = "B0836CC680A3D04B5329E99174CB3D37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getCount() {
        int var46C97A40993028EB7F14B5C60FAA31C2_347437930 = (mExpandableListAdapter.getGroupCount() + mTotalExpChildrenCount);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mExpandableListAdapter.getGroupCount() + mTotalExpChildrenCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.508 -0400", hash_original_method = "06B72D417088BC3B17164CA741049075", hash_generated_method = "CD835E084027CAF6100E05BDA13FC071")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getItem(int flatListPos) {
        dsTaint.addTaint(flatListPos);
        PositionMetadata posMetadata;
        posMetadata = getUnflattenedPos(flatListPos);
        Object retValue;
        {
            retValue = mExpandableListAdapter
                    .getGroup(posMetadata.position.groupPos);
        } //End block
        {
            retValue = mExpandableListAdapter.getChild(posMetadata.position.groupPos,
                    posMetadata.position.childPos);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Flat list position is of unknown type");
        } //End block
        posMetadata.recycle();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final PositionMetadata posMetadata = getUnflattenedPos(flatListPos);
        //Object retValue;
        //if (posMetadata.position.type == ExpandableListPosition.GROUP) {
            //retValue = mExpandableListAdapter
                    //.getGroup(posMetadata.position.groupPos);
        //} else if (posMetadata.position.type == ExpandableListPosition.CHILD) {
            //retValue = mExpandableListAdapter.getChild(posMetadata.position.groupPos,
                    //posMetadata.position.childPos);
        //} else {
            //throw new RuntimeException("Flat list position is of unknown type");
        //}
        //posMetadata.recycle();
        //return retValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.508 -0400", hash_original_method = "4AC16A8A6C46491D50BE7E30F75A3576", hash_generated_method = "533C447880AFDB8E6A1884D59F23CEDD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getItemId(int flatListPos) {
        dsTaint.addTaint(flatListPos);
        PositionMetadata posMetadata;
        posMetadata = getUnflattenedPos(flatListPos);
        long groupId;
        groupId = mExpandableListAdapter.getGroupId(posMetadata.position.groupPos);
        long retValue;
        {
            retValue = mExpandableListAdapter.getCombinedGroupId(groupId);
        } //End block
        {
            long childId;
            childId = mExpandableListAdapter.getChildId(posMetadata.position.groupPos,
                    posMetadata.position.childPos);
            retValue = mExpandableListAdapter.getCombinedChildId(groupId, childId);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Flat list position is of unknown type");
        } //End block
        posMetadata.recycle();
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.508 -0400", hash_original_method = "E8F063B04C087445609A9E5E66DA0C8E", hash_generated_method = "145C4FFFC04737E495E618FA3B5932D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View getView(int flatListPos, View convertView, ViewGroup parent) {
        dsTaint.addTaint(flatListPos);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(convertView.dsTaint);
        PositionMetadata posMetadata;
        posMetadata = getUnflattenedPos(flatListPos);
        View retValue;
        {
            retValue = mExpandableListAdapter.getGroupView(posMetadata.position.groupPos,
                    posMetadata.isExpanded(), convertView, parent);
        } //End block
        {
            boolean isLastChild;
            isLastChild = posMetadata.groupMetadata.lastChildFlPos == flatListPos;
            retValue = mExpandableListAdapter.getChildView(posMetadata.position.groupPos,
                    posMetadata.position.childPos, isLastChild, convertView, parent);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Flat list position is of unknown type");
        } //End block
        posMetadata.recycle();
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.509 -0400", hash_original_method = "99547DA2855DBC2792C3AF02654A4FE0", hash_generated_method = "F86A62B8AC5CF85C40D497D85E3EC496")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getItemViewType(int flatListPos) {
        dsTaint.addTaint(flatListPos);
        ExpandableListPosition pos;
        pos = getUnflattenedPos(flatListPos).position;
        int retValue;
        {
            HeterogeneousExpandableList adapter;
            adapter = (HeterogeneousExpandableList) mExpandableListAdapter;
            {
                retValue = adapter.getGroupType(pos.groupPos);
            } //End block
            {
                int childType;
                childType = adapter.getChildType(pos.groupPos, pos.childPos);
                retValue = adapter.getGroupTypeCount() + childType;
            } //End block
        } //End block
        {
            {
                retValue = 0;
            } //End block
            {
                retValue = 1;
            } //End block
        } //End block
        pos.recycle();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.510 -0400", hash_original_method = "CE0634CAEF6413BEB2C07851873B554E", hash_generated_method = "333A8111678B219F3C9DFF77F6690F15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getViewTypeCount() {
        {
            HeterogeneousExpandableList adapter;
            adapter = (HeterogeneousExpandableList) mExpandableListAdapter;
            int varE6779AD3637EC37D8C7FC74DBF1FBC3D_2039680432 = (adapter.getGroupTypeCount() + adapter.getChildTypeCount());
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mExpandableListAdapter instanceof HeterogeneousExpandableList) {
            //HeterogeneousExpandableList adapter =
                    //(HeterogeneousExpandableList) mExpandableListAdapter;
            //return adapter.getGroupTypeCount() + adapter.getChildTypeCount();
        //} else {
            //return 2;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.511 -0400", hash_original_method = "4910256FB1EE08A13057FF7D9F357251", hash_generated_method = "525BF2743E41ADD426291F0FA970B4D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean hasStableIds() {
        boolean varD96F239D0CDB2AF91A2C618E3B3AED55_263816228 = (mExpandableListAdapter.hasStableIds());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mExpandableListAdapter.hasStableIds();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.511 -0400", hash_original_method = "E23B4E2A713C93A88E352378F7DC6B9B", hash_generated_method = "F2D6115D6BA7651E9C8221FE390C6081")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    private void refreshExpGroupMetadataList(boolean forceChildrenCountRefresh,
            boolean syncGroupPositions) {
        dsTaint.addTaint(syncGroupPositions);
        dsTaint.addTaint(forceChildrenCountRefresh);
        ArrayList<GroupMetadata> egml;
        egml = mExpGroupMetadataList;
        int egmlSize;
        egmlSize = egml.size();
        int curFlPos;
        curFlPos = 0;
        mTotalExpChildrenCount = 0;
        {
            boolean positionsChanged;
            positionsChanged = false;
            {
                int i;
                i = egmlSize - 1;
                {
                    GroupMetadata curGm;
                    curGm = egml.get(i);
                    int newGPos;
                    newGPos = findGroupPosition(curGm.gId, curGm.gPos);
                    {
                        {
                            egml.remove(i);
                        } //End block
                        curGm.gPos = newGPos;
                        positionsChanged = true;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                Collections.sort(egml);
            } //End block
        } //End block
        int gChildrenCount;
        int lastGPos;
        lastGPos = 0;
        {
            int i;
            i = 0;
            {
                GroupMetadata curGm;
                curGm = egml.get(i);
                {
                    gChildrenCount = mExpandableListAdapter.getChildrenCount(curGm.gPos);
                } //End block
                {
                    gChildrenCount = curGm.lastChildFlPos - curGm.flPos;
                } //End block
                mTotalExpChildrenCount += gChildrenCount;
                curFlPos += (curGm.gPos - lastGPos);
                lastGPos = curGm.gPos;
                curGm.flPos = curFlPos;
                curFlPos += gChildrenCount;
                curGm.lastChildFlPos = curFlPos;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.512 -0400", hash_original_method = "356AA5E78F17E2ABD0F401EB8EAF983A", hash_generated_method = "B05BEFFCEEFAA2C9BF919E817D1A50F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean collapseGroup(int groupPos) {
        dsTaint.addTaint(groupPos);
        PositionMetadata pm;
        pm = getFlattenedPos(ExpandableListPosition.obtain(
                ExpandableListPosition.GROUP, groupPos, -1, -1));
        boolean retValue;
        retValue = collapseGroup(pm);
        pm.recycle();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //PositionMetadata pm = getFlattenedPos(ExpandableListPosition.obtain(
                //ExpandableListPosition.GROUP, groupPos, -1, -1));
        //if (pm == null) return false;
        //boolean retValue = collapseGroup(pm);
        //pm.recycle();
        //return retValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.512 -0400", hash_original_method = "B7CC4B14B03031BB8898031F497A0B04", hash_generated_method = "4E73328274EAF51D910A145A846DE2FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean collapseGroup(PositionMetadata posMetadata) {
        dsTaint.addTaint(posMetadata.dsTaint);
        mExpGroupMetadataList.remove(posMetadata.groupMetadata);
        refreshExpGroupMetadataList(false, false);
        notifyDataSetChanged();
        mExpandableListAdapter.onGroupCollapsed(posMetadata.groupMetadata.gPos);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (posMetadata.groupMetadata == null) return false;
        //mExpGroupMetadataList.remove(posMetadata.groupMetadata);
        //refreshExpGroupMetadataList(false, false);
        //notifyDataSetChanged();
        //mExpandableListAdapter.onGroupCollapsed(posMetadata.groupMetadata.gPos);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.512 -0400", hash_original_method = "5E373C5564B1740CC801138FBC6EE83B", hash_generated_method = "EAC93A2ED56ED81D8F196FD8B8C9E7F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean expandGroup(int groupPos) {
        dsTaint.addTaint(groupPos);
        PositionMetadata pm;
        pm = getFlattenedPos(ExpandableListPosition.obtain(
                ExpandableListPosition.GROUP, groupPos, -1, -1));
        boolean retValue;
        retValue = expandGroup(pm);
        pm.recycle();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //PositionMetadata pm = getFlattenedPos(ExpandableListPosition.obtain(
                //ExpandableListPosition.GROUP, groupPos, -1, -1));
        //boolean retValue = expandGroup(pm);
        //pm.recycle();
        //return retValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.513 -0400", hash_original_method = "7C096EBC61E7C7FF959B994559196523", hash_generated_method = "2A79A55610F191C1984824BD2AEE02F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean expandGroup(PositionMetadata posMetadata) {
        dsTaint.addTaint(posMetadata.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Need group");
        } //End block
        {
            boolean var0BF36D97B0462C030BBCF30B44542AC5_108280302 = (mExpGroupMetadataList.size() >= mMaxExpGroupCount);
            {
                GroupMetadata collapsedGm;
                collapsedGm = mExpGroupMetadataList.get(0);
                int collapsedIndex;
                collapsedIndex = mExpGroupMetadataList.indexOf(collapsedGm);
                collapseGroup(collapsedGm.gPos);
            } //End block
        } //End collapsed parenthetic
        GroupMetadata expandedGm;
        expandedGm = GroupMetadata.obtain(
                GroupMetadata.REFRESH,
                GroupMetadata.REFRESH,
                posMetadata.position.groupPos,
                mExpandableListAdapter.getGroupId(posMetadata.position.groupPos));
        mExpGroupMetadataList.add(posMetadata.groupInsertIndex, expandedGm);
        refreshExpGroupMetadataList(false, false);
        notifyDataSetChanged();
        mExpandableListAdapter.onGroupExpanded(expandedGm.gPos);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.513 -0400", hash_original_method = "14DD7EE25463BE2F409F1A554DB1FBD9", hash_generated_method = "40D082641E22F7E4820B51AB778EAA0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isGroupExpanded(int groupPosition) {
        dsTaint.addTaint(groupPosition);
        GroupMetadata groupMetadata;
        {
            int i;
            i = mExpGroupMetadataList.size() - 1;
            {
                groupMetadata = mExpGroupMetadataList.get(i);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //GroupMetadata groupMetadata;
        //for (int i = mExpGroupMetadataList.size() - 1; i >= 0; i--) {
            //groupMetadata = mExpGroupMetadataList.get(i);
            //if (groupMetadata.gPos == groupPosition) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.513 -0400", hash_original_method = "5DCA730791D083145030F1469300702C", hash_generated_method = "97643A6ADFAF394FD88E31B8B9C186D7")
    @DSModeled(DSC.SAFE)
    public void setMaxExpGroupCount(int maxExpGroupCount) {
        dsTaint.addTaint(maxExpGroupCount);
        // ---------- Original Method ----------
        //mMaxExpGroupCount = maxExpGroupCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.513 -0400", hash_original_method = "473155659E1950E1738B6CCA8650B997", hash_generated_method = "0D843C6DC723155953F1D205D42F19A4")
    @DSModeled(DSC.SAFE)
     ExpandableListAdapter getAdapter() {
        return (ExpandableListAdapter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mExpandableListAdapter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.514 -0400", hash_original_method = "D7C89EA0D9DD591B12578E8793100CE2", hash_generated_method = "C1F2BB0F8E25555F6ABA8C854DAEC2D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Filter getFilter() {
        ExpandableListAdapter adapter;
        adapter = getAdapter();
        {
            Filter var1CCB8EA64CF0D38AB9C381D110EC3523_1903240825 = (((Filterable) adapter).getFilter());
        } //End block
        return (Filter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ExpandableListAdapter adapter = getAdapter();
        //if (adapter instanceof Filterable) {
            //return ((Filterable) adapter).getFilter();
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.514 -0400", hash_original_method = "740752E96AF2B266538C6125F8E79937", hash_generated_method = "F4EF6DFBD52565B4A4756DC8661A1559")
    @DSModeled(DSC.SAFE)
     ArrayList<GroupMetadata> getExpandedGroupMetadataList() {
        return (ArrayList<GroupMetadata>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mExpGroupMetadataList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.514 -0400", hash_original_method = "43D377DDC694A5D1EB7EAB73153EC2C8", hash_generated_method = "DD3062A0041861453A6030FBF5F6F836")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setExpandedGroupMetadataList(ArrayList<GroupMetadata> expandedGroupMetadataList) {
        dsTaint.addTaint(expandedGroupMetadataList.dsTaint);
        int numGroups;
        numGroups = mExpandableListAdapter.getGroupCount();
        {
            int i;
            i = expandedGroupMetadataList.size() - 1;
            {
                {
                    boolean var5AB2E6FDCD2FE74673EFC61C15C26F08_224544354 = (expandedGroupMetadataList.get(i).gPos >= numGroups);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        refreshExpGroupMetadataList(true, false);
        // ---------- Original Method ----------
        //if ((expandedGroupMetadataList == null) || (mExpandableListAdapter == null)) {
            //return;
        //}
        //int numGroups = mExpandableListAdapter.getGroupCount();
        //for (int i = expandedGroupMetadataList.size() - 1; i >= 0; i--) {
            //if (expandedGroupMetadataList.get(i).gPos >= numGroups) {
                //return;
            //}
        //}
        //mExpGroupMetadataList = expandedGroupMetadataList;
        //refreshExpGroupMetadataList(true, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.515 -0400", hash_original_method = "DF256FE26F67ED917C946C2E9410F027", hash_generated_method = "1891BAF1CCB337FC182302B39F16DC52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isEmpty() {
        ExpandableListAdapter adapter;
        adapter = getAdapter();
        {
            Object var0693446521B9036041825FEBAE0330F0_1126392042 = (adapter.isEmpty());
        } //End flattened ternary
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //ExpandableListAdapter adapter = getAdapter();
        //return adapter != null ? adapter.isEmpty() : true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.515 -0400", hash_original_method = "174FBE5747A707DB845F85C327785D51", hash_generated_method = "2D90DCDED62187022B9429C72B9856F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int findGroupPosition(long groupIdToMatch, int seedGroupPosition) {
        dsTaint.addTaint(groupIdToMatch);
        dsTaint.addTaint(seedGroupPosition);
        int count;
        count = mExpandableListAdapter.getGroupCount();
        seedGroupPosition = Math.max(0, seedGroupPosition);
        seedGroupPosition = Math.min(count - 1, seedGroupPosition);
        long endTime;
        endTime = SystemClock.uptimeMillis() + AdapterView.SYNC_MAX_DURATION_MILLIS;
        long rowId;
        int first;
        first = seedGroupPosition;
        int last;
        last = seedGroupPosition;
        boolean next;
        next = false;
        boolean hitFirst;
        boolean hitLast;
        ExpandableListAdapter adapter;
        adapter = getAdapter();
        {
            boolean var456DAD1228A2E995CDD3C7508B2D1BC6_926647899 = (SystemClock.uptimeMillis() <= endTime);
            {
                rowId = adapter.getGroupId(seedGroupPosition);
                hitLast = last == count - 1;
                hitFirst = first == 0;
                {
                    seedGroupPosition = last;
                    next = false;
                } //End block
                {
                    seedGroupPosition = first;
                    next = true;
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    protected class MyDataSetObserver extends DataSetObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.515 -0400", hash_original_method = "5E2A8F377B43602FCFED378011E19650", hash_generated_method = "5E2A8F377B43602FCFED378011E19650")
                public MyDataSetObserver ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.516 -0400", hash_original_method = "6638C55358D7A5972C632ED02BA3E5C3", hash_generated_method = "423E58DDE1ED590711D4AB94EA334FA7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            refreshExpGroupMetadataList(true, true);
            notifyDataSetChanged();
            // ---------- Original Method ----------
            //refreshExpGroupMetadataList(true, true);
            //notifyDataSetChanged();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.516 -0400", hash_original_method = "097361F82E1EAFBA4D6D3BF1780C0DD3", hash_generated_method = "A5B595EB134C6A10414CBA53942E11E4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onInvalidated() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            refreshExpGroupMetadataList(true, true);
            notifyDataSetInvalidated();
            // ---------- Original Method ----------
            //refreshExpGroupMetadataList(true, true);
            //notifyDataSetInvalidated();
        }

        
    }


    
    static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        int flPos;
        int lastChildFlPos;
        int gPos;
        long gId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.516 -0400", hash_original_method = "D22B32F032ACC40BC7080CC4DC6C0D5E", hash_generated_method = "DE6C626044B8E9CC58838E683EF276B1")
        @DSModeled(DSC.SAFE)
        private GroupMetadata() {
            // ---------- Original Method ----------
        }

        
                static GroupMetadata obtain(int flPos, int lastChildFlPos, int gPos, long gId) {
            GroupMetadata gm = new GroupMetadata();
            gm.flPos = flPos;
            gm.lastChildFlPos = lastChildFlPos;
            gm.gPos = gPos;
            gm.gId = gId;
            return gm;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.517 -0400", hash_original_method = "ECBFFC8C0ED7A961DBF56C4EE305170D", hash_generated_method = "4E8897ADEF1BF6F9F1306B1AE3EC4E25")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int compareTo(GroupMetadata another) {
            dsTaint.addTaint(another.dsTaint);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //if (another == null) {
                //throw new IllegalArgumentException();
            //}
            //return gPos - another.gPos;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.517 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
        @DSModeled(DSC.SAFE)
        public int describeContents() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.517 -0400", hash_original_method = "65A29D222E83CA17BC122C9C28EAFA8F", hash_generated_method = "27B2629F8A73787B88937B06ADB3BB17")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(dest.dsTaint);
            dest.writeInt(flPos);
            dest.writeInt(lastChildFlPos);
            dest.writeInt(gPos);
            dest.writeLong(gId);
            // ---------- Original Method ----------
            //dest.writeInt(flPos);
            //dest.writeInt(lastChildFlPos);
            //dest.writeInt(gPos);
            //dest.writeLong(gId);
        }

        
        final static int REFRESH = -1;
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new Parcelable.Creator<GroupMetadata>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.517 -0400", hash_original_method = "7666142641B123E4C50AF29F73470D4C", hash_generated_method = "73E895AE894DD1FC2E7FADF3B3E826D6")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public GroupMetadata createFromParcel(Parcel in) {
                dsTaint.addTaint(in.dsTaint);
                GroupMetadata gm;
                gm = GroupMetadata.obtain(
                        in.readInt(),
                        in.readInt(),
                        in.readInt(),
                        in.readLong());
                return (GroupMetadata)dsTaint.getTaint();
                // ---------- Original Method ----------
                //GroupMetadata gm = GroupMetadata.obtain(
                        //in.readInt(),
                        //in.readInt(),
                        //in.readInt(),
                        //in.readLong());
                //return gm;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.518 -0400", hash_original_method = "EF75B3740CF336BA8876BFA102D2490A", hash_generated_method = "671A4A4F958166AF479F65313FA36D60")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public GroupMetadata[] newArray(int size) {
                dsTaint.addTaint(size);
                GroupMetadata[] var465A1C602F747B3A9CB77944F3EE3A36_84630660 = (new GroupMetadata[size]);
                return (GroupMetadata[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new GroupMetadata[size];
            }

            
}; //Transformed anonymous class
    }


    
    static public class PositionMetadata {
        public ExpandableListPosition position;
        public GroupMetadata groupMetadata;
        public int groupInsertIndex;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.519 -0400", hash_original_method = "D695D4EB809D075329F88CC11AC9F37B", hash_generated_method = "72FA864FA9C855DE015B0EDB93BB6462")
        @DSModeled(DSC.SAFE)
        private PositionMetadata() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.520 -0400", hash_original_method = "5AD4B913B9726C3345D273778B3773BA", hash_generated_method = "C2D78B097428DD4DBD267482388DC1E9")
        @DSModeled(DSC.SAFE)
        private void resetState() {
            position = null;
            groupMetadata = null;
            groupInsertIndex = 0;
            // ---------- Original Method ----------
            //position = null;
            //groupMetadata = null;
            //groupInsertIndex = 0;
        }

        
                static PositionMetadata obtain(int flatListPos, int type, int groupPos,
                int childPos, GroupMetadata groupMetadata, int groupInsertIndex) {
            PositionMetadata pm = getRecycledOrCreate();
            pm.position = ExpandableListPosition.obtain(type, groupPos, childPos, flatListPos);
            pm.groupMetadata = groupMetadata;
            pm.groupInsertIndex = groupInsertIndex;
            return pm;
        }

        
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.520 -0400", hash_original_method = "8A154BA1D9B394A3D67E04E6A86589B2", hash_generated_method = "7CC9543DDB0C7C0557E7949C7087C73C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void recycle() {
            {
                {
                    boolean var9985C19DB3277BD510D6C0334A18B696_1711340274 = (sPool.size() < MAX_POOL_SIZE);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.521 -0400", hash_original_method = "3DA77438EDE7E493B793AF2E840B43CD", hash_generated_method = "19007AE56B5208D17EE3DC4117B444D1")
        @DSModeled(DSC.SAFE)
        public boolean isExpanded() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return groupMetadata != null;
        }

        
        private static final int MAX_POOL_SIZE = 5;
        private static ArrayList<PositionMetadata> sPool =
                new ArrayList<PositionMetadata>(MAX_POOL_SIZE);
    }


    
}

