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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.610 -0400", hash_original_field = "8DBF5674055609276EEC97573F22FB4C", hash_generated_field = "18A81DFA989CC3FAA8A107E272992504")

    private ExpandableListAdapter mExpandableListAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.610 -0400", hash_original_field = "81712CC15C8A29FB14E2EB809C95AF8C", hash_generated_field = "3E8BCCD4064217A7C173330F3F39D938")

    private ArrayList<GroupMetadata> mExpGroupMetadataList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.610 -0400", hash_original_field = "47B9C7A29B9BD55ED03FF5EEB47C1AD0", hash_generated_field = "64833B5112863E55C291272F61C229B3")

    private int mTotalExpChildrenCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.610 -0400", hash_original_field = "8E2BD743CFF2027912F637A0645FAA05", hash_generated_field = "73604CF012E96086A83733575D92D3EC")

    private int mMaxExpGroupCount = Integer.MAX_VALUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.610 -0400", hash_original_field = "C38470C7D33F6F574A9D79357990B03A", hash_generated_field = "0EA6690D229B959EA035B08E213E0E20")

    private DataSetObserver mDataSetObserver = new MyDataSetObserver();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.612 -0400", hash_original_method = "BC5B318F45FBBBBC44050BD05FD123C0", hash_generated_method = "E08BB9AE8FDAD389F24F4277D59A3B63")
    public  ExpandableListConnector(ExpandableListAdapter expandableListAdapter) {
        mExpGroupMetadataList = new ArrayList<GroupMetadata>();
        setExpandableListAdapter(expandableListAdapter);
        addTaint(expandableListAdapter.getTaint());
        // ---------- Original Method ----------
        //mExpGroupMetadataList = new ArrayList<GroupMetadata>();
        //setExpandableListAdapter(expandableListAdapter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.612 -0400", hash_original_method = "20624F8A2041913E46624C5620B8C178", hash_generated_method = "FB1DC4090E6D5BD8E208E8CC70F2F954")
    public void setExpandableListAdapter(ExpandableListAdapter expandableListAdapter) {
        {
            mExpandableListAdapter.unregisterDataSetObserver(mDataSetObserver);
        } //End block
        mExpandableListAdapter = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(mDataSetObserver);
        // ---------- Original Method ----------
        //if (mExpandableListAdapter != null) {
            //mExpandableListAdapter.unregisterDataSetObserver(mDataSetObserver);
        //}
        //mExpandableListAdapter = expandableListAdapter;
        //expandableListAdapter.registerDataSetObserver(mDataSetObserver);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.618 -0400", hash_original_method = "1168BEC82030FA7343EA44D40ECA13BC", hash_generated_method = "0FB9FB5EED32D73C83F4D479191DDB5B")
     PositionMetadata getUnflattenedPos(final int flPos) {
        PositionMetadata varB4EAC82CA7396A68D541C85D26508E83_1039001144 = null; //Variable for return #1
        PositionMetadata varB4EAC82CA7396A68D541C85D26508E83_204080210 = null; //Variable for return #2
        PositionMetadata varB4EAC82CA7396A68D541C85D26508E83_652859063 = null; //Variable for return #3
        PositionMetadata varB4EAC82CA7396A68D541C85D26508E83_1891048840 = null; //Variable for return #4
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
            varB4EAC82CA7396A68D541C85D26508E83_1039001144 = PositionMetadata.obtain(flPos, ExpandableListPosition.GROUP, flPos,
                    -1, null, 0);
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
                varB4EAC82CA7396A68D541C85D26508E83_204080210 = PositionMetadata.obtain(flPos, ExpandableListPosition.GROUP,
                        midExpGm.gPos, -1, midExpGm, midExpGroupIndex);
            } //End block
            {
                int childPos;
                childPos = flPos - (midExpGm.flPos + 1);
                varB4EAC82CA7396A68D541C85D26508E83_652859063 = PositionMetadata.obtain(flPos, ExpandableListPosition.CHILD,
                        midExpGm.gPos, childPos, midExpGm, midExpGroupIndex);
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
        varB4EAC82CA7396A68D541C85D26508E83_1891048840 = PositionMetadata.obtain(flPos, ExpandableListPosition.GROUP, groupPos, -1,
                null, insertPosition);
        addTaint(flPos);
        PositionMetadata varA7E53CE21691AB073D9660D615818899_229819739; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_229819739 = varB4EAC82CA7396A68D541C85D26508E83_1039001144;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_229819739 = varB4EAC82CA7396A68D541C85D26508E83_204080210;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_229819739 = varB4EAC82CA7396A68D541C85D26508E83_652859063;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_229819739 = varB4EAC82CA7396A68D541C85D26508E83_1891048840;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_229819739.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_229819739;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.635 -0400", hash_original_method = "1D3F8862F07489DB803D2A10735D7C2B", hash_generated_method = "582B8E89BE020146E6B9BEDE9C295942")
     PositionMetadata getFlattenedPos(final ExpandableListPosition pos) {
        PositionMetadata varB4EAC82CA7396A68D541C85D26508E83_595209063 = null; //Variable for return #1
        PositionMetadata varB4EAC82CA7396A68D541C85D26508E83_905607505 = null; //Variable for return #2
        PositionMetadata varB4EAC82CA7396A68D541C85D26508E83_2120366692 = null; //Variable for return #3
        PositionMetadata varB4EAC82CA7396A68D541C85D26508E83_1556647251 = null; //Variable for return #4
        PositionMetadata varB4EAC82CA7396A68D541C85D26508E83_687024376 = null; //Variable for return #5
        PositionMetadata varB4EAC82CA7396A68D541C85D26508E83_181048688 = null; //Variable for return #6
        PositionMetadata varB4EAC82CA7396A68D541C85D26508E83_1263526037 = null; //Variable for return #7
        PositionMetadata varB4EAC82CA7396A68D541C85D26508E83_762430801 = null; //Variable for return #8
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
            varB4EAC82CA7396A68D541C85D26508E83_595209063 = PositionMetadata.obtain(pos.groupPos, pos.type,
                    pos.groupPos, pos.childPos, null, 0);
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
                    varB4EAC82CA7396A68D541C85D26508E83_905607505 = PositionMetadata.obtain(midExpGm.flPos, pos.type,
                            pos.groupPos, pos.childPos, midExpGm, midExpGroupIndex);
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_2120366692 = PositionMetadata.obtain(midExpGm.flPos + pos.childPos
                            + 1, pos.type, pos.groupPos, pos.childPos,
                            midExpGm, midExpGroupIndex);
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1556647251 = null;
                } //End block
            } //End block
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_687024376 = null;
        } //End block
        {
            GroupMetadata leftExpGm;
            leftExpGm = egml.get(leftExpGroupIndex-1);
            int flPos;
            flPos = leftExpGm.lastChildFlPos
                            + (pos.groupPos - leftExpGm.gPos);
            varB4EAC82CA7396A68D541C85D26508E83_181048688 = PositionMetadata.obtain(flPos, pos.type, pos.groupPos,
                    pos.childPos, null, leftExpGroupIndex);
        } //End block
        {
            GroupMetadata rightExpGm;
            rightExpGm = egml.get(++rightExpGroupIndex);
            int flPos;
            flPos = rightExpGm.flPos
                            - (rightExpGm.gPos - pos.groupPos);
            varB4EAC82CA7396A68D541C85D26508E83_1263526037 = PositionMetadata.obtain(flPos, pos.type, pos.groupPos,
                    pos.childPos, null, rightExpGroupIndex);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_762430801 = null;
        } //End block
        addTaint(pos.getTaint());
        PositionMetadata varA7E53CE21691AB073D9660D615818899_1582308843; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1582308843 = varB4EAC82CA7396A68D541C85D26508E83_595209063;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1582308843 = varB4EAC82CA7396A68D541C85D26508E83_905607505;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1582308843 = varB4EAC82CA7396A68D541C85D26508E83_2120366692;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1582308843 = varB4EAC82CA7396A68D541C85D26508E83_1556647251;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1582308843 = varB4EAC82CA7396A68D541C85D26508E83_687024376;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_1582308843 = varB4EAC82CA7396A68D541C85D26508E83_181048688;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_1582308843 = varB4EAC82CA7396A68D541C85D26508E83_1263526037;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1582308843 = varB4EAC82CA7396A68D541C85D26508E83_762430801;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1582308843.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1582308843;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.649 -0400", hash_original_method = "DAE4954D9EDE366A718556293A5AA5D3", hash_generated_method = "248E4F51611970F6A416654CBEDF46FC")
    @Override
    public boolean areAllItemsEnabled() {
        boolean var5A180658E7F9DF714EBCBF2EE1C5FDF9_1459990482 = (mExpandableListAdapter.areAllItemsEnabled());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_333169045 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_333169045;
        // ---------- Original Method ----------
        //return mExpandableListAdapter.areAllItemsEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.737 -0400", hash_original_method = "0084AC4844BFD434CBA804E2DF22BA27", hash_generated_method = "348FCC9A9EA0B9C52F1B068A4148605E")
    @Override
    public boolean isEnabled(int flatListPos) {
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
        addTaint(flatListPos);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_985719115 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_985719115;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.737 -0400", hash_original_method = "E43CB6EF7F0706DB8CAE1E4EB2A6AE3E", hash_generated_method = "82CA9FAE0DD26231AB7F77FCE27DF7CE")
    public int getCount() {
        int var46C97A40993028EB7F14B5C60FAA31C2_47781318 = (mExpandableListAdapter.getGroupCount() + mTotalExpChildrenCount);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_353463118 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_353463118;
        // ---------- Original Method ----------
        //return mExpandableListAdapter.getGroupCount() + mTotalExpChildrenCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.758 -0400", hash_original_method = "06B72D417088BC3B17164CA741049075", hash_generated_method = "2D215FE0CBF87BAEACDE06EC5BB177CC")
    public Object getItem(int flatListPos) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1758575671 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1758575671 = retValue;
        addTaint(flatListPos);
        varB4EAC82CA7396A68D541C85D26508E83_1758575671.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1758575671;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.759 -0400", hash_original_method = "4AC16A8A6C46491D50BE7E30F75A3576", hash_generated_method = "51370CC17BC82C7A7CC4775243ED7CA5")
    public long getItemId(int flatListPos) {
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
        addTaint(flatListPos);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1288481081 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1288481081;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.760 -0400", hash_original_method = "E8F063B04C087445609A9E5E66DA0C8E", hash_generated_method = "3B8ABAC44EB86C5602682FB538CA99FF")
    public View getView(int flatListPos, View convertView, ViewGroup parent) {
        View varB4EAC82CA7396A68D541C85D26508E83_50525833 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_50525833 = retValue;
        addTaint(flatListPos);
        addTaint(convertView.getTaint());
        addTaint(parent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_50525833.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_50525833;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.770 -0400", hash_original_method = "99547DA2855DBC2792C3AF02654A4FE0", hash_generated_method = "6F18C00E65B514D3BC81B80E8DF12BA6")
    @Override
    public int getItemViewType(int flatListPos) {
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
        addTaint(flatListPos);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1113661691 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1113661691;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.771 -0400", hash_original_method = "CE0634CAEF6413BEB2C07851873B554E", hash_generated_method = "1F67EE565C3546F2750E9C910648F999")
    @Override
    public int getViewTypeCount() {
        {
            HeterogeneousExpandableList adapter;
            adapter = (HeterogeneousExpandableList) mExpandableListAdapter;
            int varE6779AD3637EC37D8C7FC74DBF1FBC3D_927468157 = (adapter.getGroupTypeCount() + adapter.getChildTypeCount());
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1575343246 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1575343246;
        // ---------- Original Method ----------
        //if (mExpandableListAdapter instanceof HeterogeneousExpandableList) {
            //HeterogeneousExpandableList adapter =
                    //(HeterogeneousExpandableList) mExpandableListAdapter;
            //return adapter.getGroupTypeCount() + adapter.getChildTypeCount();
        //} else {
            //return 2;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.771 -0400", hash_original_method = "4910256FB1EE08A13057FF7D9F357251", hash_generated_method = "EF97D9434BB7E64BF369E928ED7DF3EC")
    @Override
    public boolean hasStableIds() {
        boolean varD96F239D0CDB2AF91A2C618E3B3AED55_210433039 = (mExpandableListAdapter.hasStableIds());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1324374432 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1324374432;
        // ---------- Original Method ----------
        //return mExpandableListAdapter.hasStableIds();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.794 -0400", hash_original_method = "E23B4E2A713C93A88E352378F7DC6B9B", hash_generated_method = "C60127E53EDF15E526F21523C282D049")
    @SuppressWarnings("unchecked")
    private void refreshExpGroupMetadataList(boolean forceChildrenCountRefresh,
            boolean syncGroupPositions) {
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
        addTaint(forceChildrenCountRefresh);
        addTaint(syncGroupPositions);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.798 -0400", hash_original_method = "356AA5E78F17E2ABD0F401EB8EAF983A", hash_generated_method = "1425636C5E9401B74D4BEEA2B51DDB75")
     boolean collapseGroup(int groupPos) {
        PositionMetadata pm;
        pm = getFlattenedPos(ExpandableListPosition.obtain(
                ExpandableListPosition.GROUP, groupPos, -1, -1));
        boolean retValue;
        retValue = collapseGroup(pm);
        pm.recycle();
        addTaint(groupPos);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1815594850 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1815594850;
        // ---------- Original Method ----------
        //PositionMetadata pm = getFlattenedPos(ExpandableListPosition.obtain(
                //ExpandableListPosition.GROUP, groupPos, -1, -1));
        //if (pm == null) return false;
        //boolean retValue = collapseGroup(pm);
        //pm.recycle();
        //return retValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.799 -0400", hash_original_method = "B7CC4B14B03031BB8898031F497A0B04", hash_generated_method = "4478444D3BB536F30B9C3FCFF3B737F7")
     boolean collapseGroup(PositionMetadata posMetadata) {
        mExpGroupMetadataList.remove(posMetadata.groupMetadata);
        refreshExpGroupMetadataList(false, false);
        notifyDataSetChanged();
        mExpandableListAdapter.onGroupCollapsed(posMetadata.groupMetadata.gPos);
        addTaint(posMetadata.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_343287799 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_343287799;
        // ---------- Original Method ----------
        //if (posMetadata.groupMetadata == null) return false;
        //mExpGroupMetadataList.remove(posMetadata.groupMetadata);
        //refreshExpGroupMetadataList(false, false);
        //notifyDataSetChanged();
        //mExpandableListAdapter.onGroupCollapsed(posMetadata.groupMetadata.gPos);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.799 -0400", hash_original_method = "5E373C5564B1740CC801138FBC6EE83B", hash_generated_method = "571422D4D148404BAA9DFF55EBECBE26")
     boolean expandGroup(int groupPos) {
        PositionMetadata pm;
        pm = getFlattenedPos(ExpandableListPosition.obtain(
                ExpandableListPosition.GROUP, groupPos, -1, -1));
        boolean retValue;
        retValue = expandGroup(pm);
        pm.recycle();
        addTaint(groupPos);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_662966641 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_662966641;
        // ---------- Original Method ----------
        //PositionMetadata pm = getFlattenedPos(ExpandableListPosition.obtain(
                //ExpandableListPosition.GROUP, groupPos, -1, -1));
        //boolean retValue = expandGroup(pm);
        //pm.recycle();
        //return retValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.815 -0400", hash_original_method = "7C096EBC61E7C7FF959B994559196523", hash_generated_method = "EBCF9E8A8390C1179D5C440B1D5EDC5C")
     boolean expandGroup(PositionMetadata posMetadata) {
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Need group");
        } //End block
        {
            boolean var0BF36D97B0462C030BBCF30B44542AC5_1140561549 = (mExpGroupMetadataList.size() >= mMaxExpGroupCount);
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
        addTaint(posMetadata.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2108222654 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2108222654;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.816 -0400", hash_original_method = "14DD7EE25463BE2F409F1A554DB1FBD9", hash_generated_method = "5D119F5A8C719765C6738406BA8DDAC5")
    public boolean isGroupExpanded(int groupPosition) {
        GroupMetadata groupMetadata;
        {
            int i;
            i = mExpGroupMetadataList.size() - 1;
            {
                groupMetadata = mExpGroupMetadataList.get(i);
            } //End block
        } //End collapsed parenthetic
        addTaint(groupPosition);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1605377179 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1605377179;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.817 -0400", hash_original_method = "5DCA730791D083145030F1469300702C", hash_generated_method = "ADF6079EFB27B709D59795A65482C88A")
    public void setMaxExpGroupCount(int maxExpGroupCount) {
        mMaxExpGroupCount = maxExpGroupCount;
        // ---------- Original Method ----------
        //mMaxExpGroupCount = maxExpGroupCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.817 -0400", hash_original_method = "473155659E1950E1738B6CCA8650B997", hash_generated_method = "1613E6393CEE0E925214BDF909AF96F2")
     ExpandableListAdapter getAdapter() {
        ExpandableListAdapter varB4EAC82CA7396A68D541C85D26508E83_870135266 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_870135266 = mExpandableListAdapter;
        varB4EAC82CA7396A68D541C85D26508E83_870135266.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_870135266;
        // ---------- Original Method ----------
        //return mExpandableListAdapter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.826 -0400", hash_original_method = "D7C89EA0D9DD591B12578E8793100CE2", hash_generated_method = "E29B99ACC41C5CA3EBF24F77964041AC")
    public Filter getFilter() {
        Filter varB4EAC82CA7396A68D541C85D26508E83_1469472082 = null; //Variable for return #1
        Filter varB4EAC82CA7396A68D541C85D26508E83_871484067 = null; //Variable for return #2
        ExpandableListAdapter adapter;
        adapter = getAdapter();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1469472082 = ((Filterable) adapter).getFilter();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_871484067 = null;
        } //End block
        Filter varA7E53CE21691AB073D9660D615818899_64856265; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_64856265 = varB4EAC82CA7396A68D541C85D26508E83_1469472082;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_64856265 = varB4EAC82CA7396A68D541C85D26508E83_871484067;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_64856265.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_64856265;
        // ---------- Original Method ----------
        //ExpandableListAdapter adapter = getAdapter();
        //if (adapter instanceof Filterable) {
            //return ((Filterable) adapter).getFilter();
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.827 -0400", hash_original_method = "740752E96AF2B266538C6125F8E79937", hash_generated_method = "CFB6FE646BB788E8E1223DCB95FF7DE5")
     ArrayList<GroupMetadata> getExpandedGroupMetadataList() {
        ArrayList<GroupMetadata> varB4EAC82CA7396A68D541C85D26508E83_1633234322 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1633234322 = mExpGroupMetadataList;
        varB4EAC82CA7396A68D541C85D26508E83_1633234322.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1633234322;
        // ---------- Original Method ----------
        //return mExpGroupMetadataList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.841 -0400", hash_original_method = "43D377DDC694A5D1EB7EAB73153EC2C8", hash_generated_method = "92DCCCFDF9AD7BF0950432E9D5572133")
     void setExpandedGroupMetadataList(ArrayList<GroupMetadata> expandedGroupMetadataList) {
        int numGroups;
        numGroups = mExpandableListAdapter.getGroupCount();
        {
            int i;
            i = expandedGroupMetadataList.size() - 1;
            {
                {
                    boolean var5AB2E6FDCD2FE74673EFC61C15C26F08_731861995 = (expandedGroupMetadataList.get(i).gPos >= numGroups);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        mExpGroupMetadataList = expandedGroupMetadataList;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.843 -0400", hash_original_method = "DF256FE26F67ED917C946C2E9410F027", hash_generated_method = "8DF7C7FDB483B176FF7FC2ACCF047D76")
    @Override
    public boolean isEmpty() {
        ExpandableListAdapter adapter;
        adapter = getAdapter();
        {
            Object var0693446521B9036041825FEBAE0330F0_1777383806 = (adapter.isEmpty());
        } //End flattened ternary
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_769779159 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_769779159;
        // ---------- Original Method ----------
        //ExpandableListAdapter adapter = getAdapter();
        //return adapter != null ? adapter.isEmpty() : true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.845 -0400", hash_original_method = "174FBE5747A707DB845F85C327785D51", hash_generated_method = "FDE9B336A87724E241C9FF484802DCCC")
     int findGroupPosition(long groupIdToMatch, int seedGroupPosition) {
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
            boolean var456DAD1228A2E995CDD3C7508B2D1BC6_334745240 = (SystemClock.uptimeMillis() <= endTime);
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
        addTaint(groupIdToMatch);
        addTaint(seedGroupPosition);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_326095822 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_326095822;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    protected class MyDataSetObserver extends DataSetObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.845 -0400", hash_original_method = "B8855E81B638DE0F5C9202168EAE6D42", hash_generated_method = "B8855E81B638DE0F5C9202168EAE6D42")
        public MyDataSetObserver ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.846 -0400", hash_original_method = "6638C55358D7A5972C632ED02BA3E5C3", hash_generated_method = "423E58DDE1ED590711D4AB94EA334FA7")
        @Override
        public void onChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            refreshExpGroupMetadataList(true, true);
            notifyDataSetChanged();
            // ---------- Original Method ----------
            //refreshExpGroupMetadataList(true, true);
            //notifyDataSetChanged();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.857 -0400", hash_original_method = "097361F82E1EAFBA4D6D3BF1780C0DD3", hash_generated_method = "A5B595EB134C6A10414CBA53942E11E4")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.858 -0400", hash_original_field = "15DD1CDB53D47E43A660BC30459C11BF", hash_generated_field = "58B6025F7C34D4075DA7A8B5B78AF226")

        int flPos;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.858 -0400", hash_original_field = "48A98D4B5525FED07D4C5320C1947CC6", hash_generated_field = "1D206009A6034643761BC2A5FF4F958A")

        int lastChildFlPos;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.858 -0400", hash_original_field = "C224E4C7E3CFB2F83B8DD85913D57702", hash_generated_field = "3DC369C72F1134212FEABAA7CBB84833")

        int gPos;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.858 -0400", hash_original_field = "EB1DAC2EEB151A9DF696A3B62D27B72F", hash_generated_field = "FF49466B0FCBC21119470C70559BF788")

        long gId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.858 -0400", hash_original_method = "D22B32F032ACC40BC7080CC4DC6C0D5E", hash_generated_method = "DE6C626044B8E9CC58838E683EF276B1")
        private  GroupMetadata() {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.859 -0400", hash_original_method = "ECBFFC8C0ED7A961DBF56C4EE305170D", hash_generated_method = "DBA075A67DEF30C121DBC8F8F203B5DC")
        public int compareTo(GroupMetadata another) {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
            addTaint(another.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_883067790 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_883067790;
            // ---------- Original Method ----------
            //if (another == null) {
                //throw new IllegalArgumentException();
            //}
            //return gPos - another.gPos;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.859 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "728E447C97DE8429EBF86C48D199B4C0")
        public int describeContents() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1448077393 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1448077393;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.859 -0400", hash_original_method = "65A29D222E83CA17BC122C9C28EAFA8F", hash_generated_method = "CE7DB12EFE0432D0340C8B33BE83BCAC")
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(flPos);
            dest.writeInt(lastChildFlPos);
            dest.writeInt(gPos);
            dest.writeLong(gId);
            addTaint(dest.getTaint());
            addTaint(flags);
            // ---------- Original Method ----------
            //dest.writeInt(flPos);
            //dest.writeInt(lastChildFlPos);
            //dest.writeInt(gPos);
            //dest.writeLong(gId);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.859 -0400", hash_original_field = "AF8BE5A0E29AD6467C3859275F3A6234", hash_generated_field = "43B6F58A517CE0A99101D5EFE80E8329")

        static int REFRESH = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.859 -0400", hash_original_field = "78442AA8D3BDB00B3E51CD054914D00C", hash_generated_field = "904F1381FE24EA0344AB3807F0522586")

        public static final Parcelable.Creator<GroupMetadata> CREATOR =
                new Parcelable.Creator<GroupMetadata>() {
            
            public GroupMetadata createFromParcel(Parcel in) {
                GroupMetadata gm = GroupMetadata.obtain(
                        in.readInt(),
                        in.readInt(),
                        in.readInt(),
                        in.readLong());
                return gm;
            }
    
            public GroupMetadata[] newArray(int size) {
                return new GroupMetadata[size];
            }
        };
    }


    
    static public class PositionMetadata {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.859 -0400", hash_original_field = "4757FE07FD492A8BE0EA6A760D683D6E", hash_generated_field = "439A44C84644DDD041C72E7D8E43AE28")

        public ExpandableListPosition position;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.859 -0400", hash_original_field = "9D8E3C4FD98EA56A261B148A6E96B414", hash_generated_field = "1B4C4593E0FDCF44159ACC4FBB332E4C")

        public GroupMetadata groupMetadata;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.860 -0400", hash_original_field = "F4E97B1642ACB36AB72070AA444EF37B", hash_generated_field = "21E16F098268A299565F9E372C785629")

        public int groupInsertIndex;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.862 -0400", hash_original_method = "D695D4EB809D075329F88CC11AC9F37B", hash_generated_method = "72FA864FA9C855DE015B0EDB93BB6462")
        private  PositionMetadata() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.873 -0400", hash_original_method = "5AD4B913B9726C3345D273778B3773BA", hash_generated_method = "C2D78B097428DD4DBD267482388DC1E9")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.877 -0400", hash_original_method = "8A154BA1D9B394A3D67E04E6A86589B2", hash_generated_method = "B9FC643FA72C7F2B29A396C20C232926")
        public void recycle() {
            {
                {
                    boolean var9985C19DB3277BD510D6C0334A18B696_130872729 = (sPool.size() < MAX_POOL_SIZE);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.877 -0400", hash_original_method = "3DA77438EDE7E493B793AF2E840B43CD", hash_generated_method = "B440663612328C9F28135C8E3C83B06C")
        public boolean isExpanded() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_403739567 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_403739567;
            // ---------- Original Method ----------
            //return groupMetadata != null;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.877 -0400", hash_original_field = "889E6ADBE471574497DA5C9E79EF7FCA", hash_generated_field = "F95AA3BBD7F2EE021B9A9B5059C2D36B")

        private static int MAX_POOL_SIZE = 5;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.877 -0400", hash_original_field = "026A57939A30BF75DDCB5D07D6847366", hash_generated_field = "8C9EE594696DB4880353F853B50DD5E0")

        private static ArrayList<PositionMetadata> sPool = new ArrayList<PositionMetadata>(MAX_POOL_SIZE);
    }


    
}

