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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.288 -0400", hash_original_field = "8DBF5674055609276EEC97573F22FB4C", hash_generated_field = "18A81DFA989CC3FAA8A107E272992504")

    private ExpandableListAdapter mExpandableListAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.288 -0400", hash_original_field = "81712CC15C8A29FB14E2EB809C95AF8C", hash_generated_field = "3E8BCCD4064217A7C173330F3F39D938")

    private ArrayList<GroupMetadata> mExpGroupMetadataList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.288 -0400", hash_original_field = "47B9C7A29B9BD55ED03FF5EEB47C1AD0", hash_generated_field = "64833B5112863E55C291272F61C229B3")

    private int mTotalExpChildrenCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.288 -0400", hash_original_field = "8E2BD743CFF2027912F637A0645FAA05", hash_generated_field = "73604CF012E96086A83733575D92D3EC")

    private int mMaxExpGroupCount = Integer.MAX_VALUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.288 -0400", hash_original_field = "C38470C7D33F6F574A9D79357990B03A", hash_generated_field = "0EA6690D229B959EA035B08E213E0E20")

    private DataSetObserver mDataSetObserver = new MyDataSetObserver();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.289 -0400", hash_original_method = "BC5B318F45FBBBBC44050BD05FD123C0", hash_generated_method = "E08BB9AE8FDAD389F24F4277D59A3B63")
    public  ExpandableListConnector(ExpandableListAdapter expandableListAdapter) {
        mExpGroupMetadataList = new ArrayList<GroupMetadata>();
        setExpandableListAdapter(expandableListAdapter);
        addTaint(expandableListAdapter.getTaint());
        // ---------- Original Method ----------
        //mExpGroupMetadataList = new ArrayList<GroupMetadata>();
        //setExpandableListAdapter(expandableListAdapter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.289 -0400", hash_original_method = "20624F8A2041913E46624C5620B8C178", hash_generated_method = "FB1DC4090E6D5BD8E208E8CC70F2F954")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.295 -0400", hash_original_method = "1168BEC82030FA7343EA44D40ECA13BC", hash_generated_method = "49E8FCF94A08FF58500C930DC99E59B2")
     PositionMetadata getUnflattenedPos(final int flPos) {
        PositionMetadata varB4EAC82CA7396A68D541C85D26508E83_850342672 = null; //Variable for return #1
        PositionMetadata varB4EAC82CA7396A68D541C85D26508E83_780873560 = null; //Variable for return #2
        PositionMetadata varB4EAC82CA7396A68D541C85D26508E83_1002925678 = null; //Variable for return #3
        PositionMetadata varB4EAC82CA7396A68D541C85D26508E83_830438039 = null; //Variable for return #4
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
            varB4EAC82CA7396A68D541C85D26508E83_850342672 = PositionMetadata.obtain(flPos, ExpandableListPosition.GROUP, flPos,
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
                varB4EAC82CA7396A68D541C85D26508E83_780873560 = PositionMetadata.obtain(flPos, ExpandableListPosition.GROUP,
                        midExpGm.gPos, -1, midExpGm, midExpGroupIndex);
            } //End block
            {
                int childPos;
                childPos = flPos - (midExpGm.flPos + 1);
                varB4EAC82CA7396A68D541C85D26508E83_1002925678 = PositionMetadata.obtain(flPos, ExpandableListPosition.CHILD,
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
        varB4EAC82CA7396A68D541C85D26508E83_830438039 = PositionMetadata.obtain(flPos, ExpandableListPosition.GROUP, groupPos, -1,
                null, insertPosition);
        addTaint(flPos);
        PositionMetadata varA7E53CE21691AB073D9660D615818899_1027252562; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1027252562 = varB4EAC82CA7396A68D541C85D26508E83_850342672;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1027252562 = varB4EAC82CA7396A68D541C85D26508E83_780873560;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1027252562 = varB4EAC82CA7396A68D541C85D26508E83_1002925678;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1027252562 = varB4EAC82CA7396A68D541C85D26508E83_830438039;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1027252562.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1027252562;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.314 -0400", hash_original_method = "1D3F8862F07489DB803D2A10735D7C2B", hash_generated_method = "A5A13917A2496FEF7DE3206D98C16A02")
     PositionMetadata getFlattenedPos(final ExpandableListPosition pos) {
        PositionMetadata varB4EAC82CA7396A68D541C85D26508E83_968757805 = null; //Variable for return #1
        PositionMetadata varB4EAC82CA7396A68D541C85D26508E83_1638946227 = null; //Variable for return #2
        PositionMetadata varB4EAC82CA7396A68D541C85D26508E83_1878317007 = null; //Variable for return #3
        PositionMetadata varB4EAC82CA7396A68D541C85D26508E83_2085923915 = null; //Variable for return #4
        PositionMetadata varB4EAC82CA7396A68D541C85D26508E83_794551491 = null; //Variable for return #5
        PositionMetadata varB4EAC82CA7396A68D541C85D26508E83_457496145 = null; //Variable for return #6
        PositionMetadata varB4EAC82CA7396A68D541C85D26508E83_1448486783 = null; //Variable for return #7
        PositionMetadata varB4EAC82CA7396A68D541C85D26508E83_161557534 = null; //Variable for return #8
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
            varB4EAC82CA7396A68D541C85D26508E83_968757805 = PositionMetadata.obtain(pos.groupPos, pos.type,
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
                    varB4EAC82CA7396A68D541C85D26508E83_1638946227 = PositionMetadata.obtain(midExpGm.flPos, pos.type,
                            pos.groupPos, pos.childPos, midExpGm, midExpGroupIndex);
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1878317007 = PositionMetadata.obtain(midExpGm.flPos + pos.childPos
                            + 1, pos.type, pos.groupPos, pos.childPos,
                            midExpGm, midExpGroupIndex);
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_2085923915 = null;
                } //End block
            } //End block
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_794551491 = null;
        } //End block
        {
            GroupMetadata leftExpGm;
            leftExpGm = egml.get(leftExpGroupIndex-1);
            int flPos;
            flPos = leftExpGm.lastChildFlPos
                            + (pos.groupPos - leftExpGm.gPos);
            varB4EAC82CA7396A68D541C85D26508E83_457496145 = PositionMetadata.obtain(flPos, pos.type, pos.groupPos,
                    pos.childPos, null, leftExpGroupIndex);
        } //End block
        {
            GroupMetadata rightExpGm;
            rightExpGm = egml.get(++rightExpGroupIndex);
            int flPos;
            flPos = rightExpGm.flPos
                            - (rightExpGm.gPos - pos.groupPos);
            varB4EAC82CA7396A68D541C85D26508E83_1448486783 = PositionMetadata.obtain(flPos, pos.type, pos.groupPos,
                    pos.childPos, null, rightExpGroupIndex);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_161557534 = null;
        } //End block
        addTaint(pos.getTaint());
        PositionMetadata varA7E53CE21691AB073D9660D615818899_164301577; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_164301577 = varB4EAC82CA7396A68D541C85D26508E83_968757805;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_164301577 = varB4EAC82CA7396A68D541C85D26508E83_1638946227;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_164301577 = varB4EAC82CA7396A68D541C85D26508E83_1878317007;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_164301577 = varB4EAC82CA7396A68D541C85D26508E83_2085923915;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_164301577 = varB4EAC82CA7396A68D541C85D26508E83_794551491;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_164301577 = varB4EAC82CA7396A68D541C85D26508E83_457496145;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_164301577 = varB4EAC82CA7396A68D541C85D26508E83_1448486783;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_164301577 = varB4EAC82CA7396A68D541C85D26508E83_161557534;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_164301577.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_164301577;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.315 -0400", hash_original_method = "DAE4954D9EDE366A718556293A5AA5D3", hash_generated_method = "5A8AA9E6A5D2E075641BD47862710175")
    @Override
    public boolean areAllItemsEnabled() {
        boolean var5A180658E7F9DF714EBCBF2EE1C5FDF9_2082113378 = (mExpandableListAdapter.areAllItemsEnabled());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1349768214 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1349768214;
        // ---------- Original Method ----------
        //return mExpandableListAdapter.areAllItemsEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.320 -0400", hash_original_method = "0084AC4844BFD434CBA804E2DF22BA27", hash_generated_method = "C2B1234F3B9819ED59CCF3B4B7A67994")
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_18894897 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_18894897;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.336 -0400", hash_original_method = "E43CB6EF7F0706DB8CAE1E4EB2A6AE3E", hash_generated_method = "BFD242BA2BD35E32F4D5EB77FE767058")
    public int getCount() {
        int var46C97A40993028EB7F14B5C60FAA31C2_92336677 = (mExpandableListAdapter.getGroupCount() + mTotalExpChildrenCount);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_384992228 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_384992228;
        // ---------- Original Method ----------
        //return mExpandableListAdapter.getGroupCount() + mTotalExpChildrenCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.340 -0400", hash_original_method = "06B72D417088BC3B17164CA741049075", hash_generated_method = "DBCF1EDC1D8AA15C409E5518EBD0C469")
    public Object getItem(int flatListPos) {
        Object varB4EAC82CA7396A68D541C85D26508E83_894652628 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_894652628 = retValue;
        addTaint(flatListPos);
        varB4EAC82CA7396A68D541C85D26508E83_894652628.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_894652628;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.340 -0400", hash_original_method = "4AC16A8A6C46491D50BE7E30F75A3576", hash_generated_method = "0221D4676D5077FA22B5D463B6E10CAC")
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
        long var0F5264038205EDFB1AC05FBB0E8C5E94_944165677 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_944165677;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.341 -0400", hash_original_method = "E8F063B04C087445609A9E5E66DA0C8E", hash_generated_method = "1E0F001E54150BEDFFC7EF6076A32822")
    public View getView(int flatListPos, View convertView, ViewGroup parent) {
        View varB4EAC82CA7396A68D541C85D26508E83_332951093 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_332951093 = retValue;
        addTaint(flatListPos);
        addTaint(convertView.getTaint());
        addTaint(parent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_332951093.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_332951093;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.344 -0400", hash_original_method = "99547DA2855DBC2792C3AF02654A4FE0", hash_generated_method = "C516FF89968AD339BF6C26C3EF94351F")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1118445046 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1118445046;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.359 -0400", hash_original_method = "CE0634CAEF6413BEB2C07851873B554E", hash_generated_method = "348340A57E2B9272AECFEE88D63A7809")
    @Override
    public int getViewTypeCount() {
        {
            HeterogeneousExpandableList adapter;
            adapter = (HeterogeneousExpandableList) mExpandableListAdapter;
            int varE6779AD3637EC37D8C7FC74DBF1FBC3D_2001476872 = (adapter.getGroupTypeCount() + adapter.getChildTypeCount());
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_981570641 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_981570641;
        // ---------- Original Method ----------
        //if (mExpandableListAdapter instanceof HeterogeneousExpandableList) {
            //HeterogeneousExpandableList adapter =
                    //(HeterogeneousExpandableList) mExpandableListAdapter;
            //return adapter.getGroupTypeCount() + adapter.getChildTypeCount();
        //} else {
            //return 2;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.359 -0400", hash_original_method = "4910256FB1EE08A13057FF7D9F357251", hash_generated_method = "B201786E9B9CA8FCA33D18F9D8A8274E")
    @Override
    public boolean hasStableIds() {
        boolean varD96F239D0CDB2AF91A2C618E3B3AED55_245208436 = (mExpandableListAdapter.hasStableIds());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1965990561 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1965990561;
        // ---------- Original Method ----------
        //return mExpandableListAdapter.hasStableIds();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.360 -0400", hash_original_method = "E23B4E2A713C93A88E352378F7DC6B9B", hash_generated_method = "C60127E53EDF15E526F21523C282D049")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.371 -0400", hash_original_method = "356AA5E78F17E2ABD0F401EB8EAF983A", hash_generated_method = "97AE3CB8B4DE2C2B232EC1AEC4B0F384")
     boolean collapseGroup(int groupPos) {
        PositionMetadata pm;
        pm = getFlattenedPos(ExpandableListPosition.obtain(
                ExpandableListPosition.GROUP, groupPos, -1, -1));
        boolean retValue;
        retValue = collapseGroup(pm);
        pm.recycle();
        addTaint(groupPos);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1506739816 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1506739816;
        // ---------- Original Method ----------
        //PositionMetadata pm = getFlattenedPos(ExpandableListPosition.obtain(
                //ExpandableListPosition.GROUP, groupPos, -1, -1));
        //if (pm == null) return false;
        //boolean retValue = collapseGroup(pm);
        //pm.recycle();
        //return retValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.372 -0400", hash_original_method = "B7CC4B14B03031BB8898031F497A0B04", hash_generated_method = "2AF4882ECBFD5BBEC32157DFC88DAFEA")
     boolean collapseGroup(PositionMetadata posMetadata) {
        mExpGroupMetadataList.remove(posMetadata.groupMetadata);
        refreshExpGroupMetadataList(false, false);
        notifyDataSetChanged();
        mExpandableListAdapter.onGroupCollapsed(posMetadata.groupMetadata.gPos);
        addTaint(posMetadata.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_352013165 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_352013165;
        // ---------- Original Method ----------
        //if (posMetadata.groupMetadata == null) return false;
        //mExpGroupMetadataList.remove(posMetadata.groupMetadata);
        //refreshExpGroupMetadataList(false, false);
        //notifyDataSetChanged();
        //mExpandableListAdapter.onGroupCollapsed(posMetadata.groupMetadata.gPos);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.372 -0400", hash_original_method = "5E373C5564B1740CC801138FBC6EE83B", hash_generated_method = "812765D99CC7B4FC4F76CE91CEC05A9E")
     boolean expandGroup(int groupPos) {
        PositionMetadata pm;
        pm = getFlattenedPos(ExpandableListPosition.obtain(
                ExpandableListPosition.GROUP, groupPos, -1, -1));
        boolean retValue;
        retValue = expandGroup(pm);
        pm.recycle();
        addTaint(groupPos);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2076907240 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2076907240;
        // ---------- Original Method ----------
        //PositionMetadata pm = getFlattenedPos(ExpandableListPosition.obtain(
                //ExpandableListPosition.GROUP, groupPos, -1, -1));
        //boolean retValue = expandGroup(pm);
        //pm.recycle();
        //return retValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.373 -0400", hash_original_method = "7C096EBC61E7C7FF959B994559196523", hash_generated_method = "4B3376ACA84282BF0809035E1FE29708")
     boolean expandGroup(PositionMetadata posMetadata) {
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Need group");
        } //End block
        {
            boolean var0BF36D97B0462C030BBCF30B44542AC5_1993954682 = (mExpGroupMetadataList.size() >= mMaxExpGroupCount);
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1892832910 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1892832910;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.385 -0400", hash_original_method = "14DD7EE25463BE2F409F1A554DB1FBD9", hash_generated_method = "0EA059893B37B2978A2BC1BF6FEBAA2A")
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2053708985 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2053708985;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.385 -0400", hash_original_method = "5DCA730791D083145030F1469300702C", hash_generated_method = "ADF6079EFB27B709D59795A65482C88A")
    public void setMaxExpGroupCount(int maxExpGroupCount) {
        mMaxExpGroupCount = maxExpGroupCount;
        // ---------- Original Method ----------
        //mMaxExpGroupCount = maxExpGroupCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.386 -0400", hash_original_method = "473155659E1950E1738B6CCA8650B997", hash_generated_method = "E3D75078989CB77439107D6618D9954C")
     ExpandableListAdapter getAdapter() {
        ExpandableListAdapter varB4EAC82CA7396A68D541C85D26508E83_1358110848 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1358110848 = mExpandableListAdapter;
        varB4EAC82CA7396A68D541C85D26508E83_1358110848.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1358110848;
        // ---------- Original Method ----------
        //return mExpandableListAdapter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.386 -0400", hash_original_method = "D7C89EA0D9DD591B12578E8793100CE2", hash_generated_method = "185B447EBDF09DEC731A98E68AC1A083")
    public Filter getFilter() {
        Filter varB4EAC82CA7396A68D541C85D26508E83_1937438142 = null; //Variable for return #1
        Filter varB4EAC82CA7396A68D541C85D26508E83_1369306414 = null; //Variable for return #2
        ExpandableListAdapter adapter;
        adapter = getAdapter();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1937438142 = ((Filterable) adapter).getFilter();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1369306414 = null;
        } //End block
        Filter varA7E53CE21691AB073D9660D615818899_990926949; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_990926949 = varB4EAC82CA7396A68D541C85D26508E83_1937438142;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_990926949 = varB4EAC82CA7396A68D541C85D26508E83_1369306414;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_990926949.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_990926949;
        // ---------- Original Method ----------
        //ExpandableListAdapter adapter = getAdapter();
        //if (adapter instanceof Filterable) {
            //return ((Filterable) adapter).getFilter();
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.387 -0400", hash_original_method = "740752E96AF2B266538C6125F8E79937", hash_generated_method = "2D5DB5D7DFEAB9B57EEF021C62A299F0")
     ArrayList<GroupMetadata> getExpandedGroupMetadataList() {
        ArrayList<GroupMetadata> varB4EAC82CA7396A68D541C85D26508E83_1501516418 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1501516418 = mExpGroupMetadataList;
        varB4EAC82CA7396A68D541C85D26508E83_1501516418.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1501516418;
        // ---------- Original Method ----------
        //return mExpGroupMetadataList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.389 -0400", hash_original_method = "43D377DDC694A5D1EB7EAB73153EC2C8", hash_generated_method = "67477F82C3BF3A4647BBE620A69F0285")
     void setExpandedGroupMetadataList(ArrayList<GroupMetadata> expandedGroupMetadataList) {
        int numGroups;
        numGroups = mExpandableListAdapter.getGroupCount();
        {
            int i;
            i = expandedGroupMetadataList.size() - 1;
            {
                {
                    boolean var5AB2E6FDCD2FE74673EFC61C15C26F08_883573847 = (expandedGroupMetadataList.get(i).gPos >= numGroups);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.398 -0400", hash_original_method = "DF256FE26F67ED917C946C2E9410F027", hash_generated_method = "058972CACB84F2E8FCFD881744485AAF")
    @Override
    public boolean isEmpty() {
        ExpandableListAdapter adapter;
        adapter = getAdapter();
        {
            Object var0693446521B9036041825FEBAE0330F0_1298344223 = (adapter.isEmpty());
        } //End flattened ternary
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_211358755 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_211358755;
        // ---------- Original Method ----------
        //ExpandableListAdapter adapter = getAdapter();
        //return adapter != null ? adapter.isEmpty() : true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.418 -0400", hash_original_method = "174FBE5747A707DB845F85C327785D51", hash_generated_method = "C7C22AEA1EC5174E45B956A4F8960B3B")
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
            boolean var456DAD1228A2E995CDD3C7508B2D1BC6_1410930160 = (SystemClock.uptimeMillis() <= endTime);
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2107363599 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2107363599;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    protected class MyDataSetObserver extends DataSetObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.419 -0400", hash_original_method = "B8855E81B638DE0F5C9202168EAE6D42", hash_generated_method = "B8855E81B638DE0F5C9202168EAE6D42")
        public MyDataSetObserver ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.419 -0400", hash_original_method = "6638C55358D7A5972C632ED02BA3E5C3", hash_generated_method = "423E58DDE1ED590711D4AB94EA334FA7")
        @Override
        public void onChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            refreshExpGroupMetadataList(true, true);
            notifyDataSetChanged();
            // ---------- Original Method ----------
            //refreshExpGroupMetadataList(true, true);
            //notifyDataSetChanged();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.420 -0400", hash_original_method = "097361F82E1EAFBA4D6D3BF1780C0DD3", hash_generated_method = "A5B595EB134C6A10414CBA53942E11E4")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.420 -0400", hash_original_field = "15DD1CDB53D47E43A660BC30459C11BF", hash_generated_field = "58B6025F7C34D4075DA7A8B5B78AF226")

        int flPos;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.420 -0400", hash_original_field = "48A98D4B5525FED07D4C5320C1947CC6", hash_generated_field = "1D206009A6034643761BC2A5FF4F958A")

        int lastChildFlPos;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.420 -0400", hash_original_field = "C224E4C7E3CFB2F83B8DD85913D57702", hash_generated_field = "3DC369C72F1134212FEABAA7CBB84833")

        int gPos;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.420 -0400", hash_original_field = "EB1DAC2EEB151A9DF696A3B62D27B72F", hash_generated_field = "FF49466B0FCBC21119470C70559BF788")

        long gId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.421 -0400", hash_original_method = "D22B32F032ACC40BC7080CC4DC6C0D5E", hash_generated_method = "DE6C626044B8E9CC58838E683EF276B1")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.425 -0400", hash_original_method = "ECBFFC8C0ED7A961DBF56C4EE305170D", hash_generated_method = "C434C92ED639ED94AF53F8BFFCE19B2B")
        public int compareTo(GroupMetadata another) {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
            addTaint(another.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_953193262 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_953193262;
            // ---------- Original Method ----------
            //if (another == null) {
                //throw new IllegalArgumentException();
            //}
            //return gPos - another.gPos;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.426 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "6958168F7EC60A49FF35AEA3972917CB")
        public int describeContents() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_84674141 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_84674141;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.433 -0400", hash_original_method = "65A29D222E83CA17BC122C9C28EAFA8F", hash_generated_method = "CE7DB12EFE0432D0340C8B33BE83BCAC")
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.433 -0400", hash_original_field = "AF8BE5A0E29AD6467C3859275F3A6234", hash_generated_field = "43B6F58A517CE0A99101D5EFE80E8329")

        static int REFRESH = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.433 -0400", hash_original_field = "78442AA8D3BDB00B3E51CD054914D00C", hash_generated_field = "904F1381FE24EA0344AB3807F0522586")

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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.433 -0400", hash_original_field = "4757FE07FD492A8BE0EA6A760D683D6E", hash_generated_field = "439A44C84644DDD041C72E7D8E43AE28")

        public ExpandableListPosition position;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.433 -0400", hash_original_field = "9D8E3C4FD98EA56A261B148A6E96B414", hash_generated_field = "1B4C4593E0FDCF44159ACC4FBB332E4C")

        public GroupMetadata groupMetadata;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.433 -0400", hash_original_field = "F4E97B1642ACB36AB72070AA444EF37B", hash_generated_field = "21E16F098268A299565F9E372C785629")

        public int groupInsertIndex;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.434 -0400", hash_original_method = "D695D4EB809D075329F88CC11AC9F37B", hash_generated_method = "72FA864FA9C855DE015B0EDB93BB6462")
        private  PositionMetadata() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.434 -0400", hash_original_method = "5AD4B913B9726C3345D273778B3773BA", hash_generated_method = "C2D78B097428DD4DBD267482388DC1E9")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.435 -0400", hash_original_method = "8A154BA1D9B394A3D67E04E6A86589B2", hash_generated_method = "2FF1096553247B2A187146F6B326DFED")
        public void recycle() {
            {
                {
                    boolean var9985C19DB3277BD510D6C0334A18B696_1271567324 = (sPool.size() < MAX_POOL_SIZE);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.435 -0400", hash_original_method = "3DA77438EDE7E493B793AF2E840B43CD", hash_generated_method = "5E34DD112FCD640A8727B40CCE7C236D")
        public boolean isExpanded() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1666216948 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1666216948;
            // ---------- Original Method ----------
            //return groupMetadata != null;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.435 -0400", hash_original_field = "889E6ADBE471574497DA5C9E79EF7FCA", hash_generated_field = "F95AA3BBD7F2EE021B9A9B5059C2D36B")

        private static int MAX_POOL_SIZE = 5;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.435 -0400", hash_original_field = "026A57939A30BF75DDCB5D07D6847366", hash_generated_field = "8C9EE594696DB4880353F853B50DD5E0")

        private static ArrayList<PositionMetadata> sPool = new ArrayList<PositionMetadata>(MAX_POOL_SIZE);
    }


    
}

