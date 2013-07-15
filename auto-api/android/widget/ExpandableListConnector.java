package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.623 -0400", hash_original_field = "8DBF5674055609276EEC97573F22FB4C", hash_generated_field = "18A81DFA989CC3FAA8A107E272992504")

    private ExpandableListAdapter mExpandableListAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.623 -0400", hash_original_field = "81712CC15C8A29FB14E2EB809C95AF8C", hash_generated_field = "3E8BCCD4064217A7C173330F3F39D938")

    private ArrayList<GroupMetadata> mExpGroupMetadataList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.623 -0400", hash_original_field = "47B9C7A29B9BD55ED03FF5EEB47C1AD0", hash_generated_field = "64833B5112863E55C291272F61C229B3")

    private int mTotalExpChildrenCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.623 -0400", hash_original_field = "8E2BD743CFF2027912F637A0645FAA05", hash_generated_field = "73604CF012E96086A83733575D92D3EC")

    private int mMaxExpGroupCount = Integer.MAX_VALUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.623 -0400", hash_original_field = "C38470C7D33F6F574A9D79357990B03A", hash_generated_field = "096B6AFF2D4BE73F0317C948A7EB332C")

    private final DataSetObserver mDataSetObserver = new MyDataSetObserver();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.624 -0400", hash_original_method = "BC5B318F45FBBBBC44050BD05FD123C0", hash_generated_method = "E08BB9AE8FDAD389F24F4277D59A3B63")
    public  ExpandableListConnector(ExpandableListAdapter expandableListAdapter) {
        mExpGroupMetadataList = new ArrayList<GroupMetadata>();
        setExpandableListAdapter(expandableListAdapter);
        addTaint(expandableListAdapter.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.624 -0400", hash_original_method = "20624F8A2041913E46624C5620B8C178", hash_generated_method = "FB1DC4090E6D5BD8E208E8CC70F2F954")
    public void setExpandableListAdapter(ExpandableListAdapter expandableListAdapter) {
        {
            mExpandableListAdapter.unregisterDataSetObserver(mDataSetObserver);
        } 
        mExpandableListAdapter = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(mDataSetObserver);
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.625 -0400", hash_original_method = "1168BEC82030FA7343EA44D40ECA13BC", hash_generated_method = "39348E96F774E53FC2C51327B6D7ECA2")
     PositionMetadata getUnflattenedPos(final int flPos) {
        PositionMetadata varB4EAC82CA7396A68D541C85D26508E83_629892889 = null; 
        PositionMetadata varB4EAC82CA7396A68D541C85D26508E83_757873259 = null; 
        PositionMetadata varB4EAC82CA7396A68D541C85D26508E83_1615895087 = null; 
        PositionMetadata varB4EAC82CA7396A68D541C85D26508E83_756672667 = null; 
        final ArrayList<GroupMetadata> egml = mExpGroupMetadataList;
        final int numExpGroups = egml.size();
        int leftExpGroupIndex = 0;
        int rightExpGroupIndex = numExpGroups - 1;
        int midExpGroupIndex = 0;
        GroupMetadata midExpGm;
        {
            varB4EAC82CA7396A68D541C85D26508E83_629892889 = PositionMetadata.obtain(flPos, ExpandableListPosition.GROUP, flPos,
                    -1, null, 0);
        } 
        {
            midExpGroupIndex =
                    (rightExpGroupIndex - leftExpGroupIndex) / 2
                            + leftExpGroupIndex;
            midExpGm = egml.get(midExpGroupIndex);
            {
                leftExpGroupIndex = midExpGroupIndex + 1;
            } 
            {
                rightExpGroupIndex = midExpGroupIndex - 1;
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_757873259 = PositionMetadata.obtain(flPos, ExpandableListPosition.GROUP,
                        midExpGm.gPos, -1, midExpGm, midExpGroupIndex);
            } 
            {
                final int childPos = flPos - (midExpGm.flPos + 1);
                varB4EAC82CA7396A68D541C85D26508E83_1615895087 = PositionMetadata.obtain(flPos, ExpandableListPosition.CHILD,
                        midExpGm.gPos, childPos, midExpGm, midExpGroupIndex);
            } 
        } 
        int insertPosition = 0;
        int groupPos = 0;
        {
            final GroupMetadata leftExpGm = egml.get(leftExpGroupIndex-1);
            insertPosition = leftExpGroupIndex;
            groupPos =
                (flPos - leftExpGm.lastChildFlPos) + leftExpGm.gPos;
        } 
        {
            final GroupMetadata rightExpGm = egml.get(++rightExpGroupIndex);
            insertPosition = rightExpGroupIndex;
            groupPos = rightExpGm.gPos - (rightExpGm.flPos - flPos);
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Unknown state");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_756672667 = PositionMetadata.obtain(flPos, ExpandableListPosition.GROUP, groupPos, -1,
                null, insertPosition);
        addTaint(flPos);
        PositionMetadata varA7E53CE21691AB073D9660D615818899_1376825990; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1376825990 = varB4EAC82CA7396A68D541C85D26508E83_629892889;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1376825990 = varB4EAC82CA7396A68D541C85D26508E83_757873259;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1376825990 = varB4EAC82CA7396A68D541C85D26508E83_1615895087;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1376825990 = varB4EAC82CA7396A68D541C85D26508E83_756672667;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1376825990.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1376825990;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.627 -0400", hash_original_method = "1D3F8862F07489DB803D2A10735D7C2B", hash_generated_method = "A469C1E63CDFA6D2845C53E8F2AE421D")
     PositionMetadata getFlattenedPos(final ExpandableListPosition pos) {
        PositionMetadata varB4EAC82CA7396A68D541C85D26508E83_1799621461 = null; 
        PositionMetadata varB4EAC82CA7396A68D541C85D26508E83_1515222213 = null; 
        PositionMetadata varB4EAC82CA7396A68D541C85D26508E83_1839701127 = null; 
        PositionMetadata varB4EAC82CA7396A68D541C85D26508E83_298298262 = null; 
        PositionMetadata varB4EAC82CA7396A68D541C85D26508E83_1755507044 = null; 
        PositionMetadata varB4EAC82CA7396A68D541C85D26508E83_1102370997 = null; 
        PositionMetadata varB4EAC82CA7396A68D541C85D26508E83_2014150619 = null; 
        PositionMetadata varB4EAC82CA7396A68D541C85D26508E83_1435748749 = null; 
        final ArrayList<GroupMetadata> egml = mExpGroupMetadataList;
        final int numExpGroups = egml.size();
        int leftExpGroupIndex = 0;
        int rightExpGroupIndex = numExpGroups - 1;
        int midExpGroupIndex = 0;
        GroupMetadata midExpGm;
        {
            varB4EAC82CA7396A68D541C85D26508E83_1799621461 = PositionMetadata.obtain(pos.groupPos, pos.type,
                    pos.groupPos, pos.childPos, null, 0);
        } 
        {
            midExpGroupIndex = (rightExpGroupIndex - leftExpGroupIndex)/2 + leftExpGroupIndex;
            midExpGm = egml.get(midExpGroupIndex);
            {
                leftExpGroupIndex = midExpGroupIndex + 1;
            } 
            {
                rightExpGroupIndex = midExpGroupIndex - 1;
            } 
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1515222213 = PositionMetadata.obtain(midExpGm.flPos, pos.type,
                            pos.groupPos, pos.childPos, midExpGm, midExpGroupIndex);
                } 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1839701127 = PositionMetadata.obtain(midExpGm.flPos + pos.childPos
                            + 1, pos.type, pos.groupPos, pos.childPos,
                            midExpGm, midExpGroupIndex);
                } 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_298298262 = null;
                } 
            } 
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1755507044 = null;
        } 
        {
            final GroupMetadata leftExpGm = egml.get(leftExpGroupIndex-1);
            final int flPos = leftExpGm.lastChildFlPos
                            + (pos.groupPos - leftExpGm.gPos);
            varB4EAC82CA7396A68D541C85D26508E83_1102370997 = PositionMetadata.obtain(flPos, pos.type, pos.groupPos,
                    pos.childPos, null, leftExpGroupIndex);
        } 
        {
            final GroupMetadata rightExpGm = egml.get(++rightExpGroupIndex);
            final int flPos = rightExpGm.flPos
                            - (rightExpGm.gPos - pos.groupPos);
            varB4EAC82CA7396A68D541C85D26508E83_2014150619 = PositionMetadata.obtain(flPos, pos.type, pos.groupPos,
                    pos.childPos, null, rightExpGroupIndex);
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1435748749 = null;
        } 
        addTaint(pos.getTaint());
        PositionMetadata varA7E53CE21691AB073D9660D615818899_1070293028; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1070293028 = varB4EAC82CA7396A68D541C85D26508E83_1799621461;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1070293028 = varB4EAC82CA7396A68D541C85D26508E83_1515222213;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1070293028 = varB4EAC82CA7396A68D541C85D26508E83_1839701127;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_1070293028 = varB4EAC82CA7396A68D541C85D26508E83_298298262;
                break;
            case 5: 
                varA7E53CE21691AB073D9660D615818899_1070293028 = varB4EAC82CA7396A68D541C85D26508E83_1755507044;
                break;
            case 6: 
                varA7E53CE21691AB073D9660D615818899_1070293028 = varB4EAC82CA7396A68D541C85D26508E83_1102370997;
                break;
            case 7: 
                varA7E53CE21691AB073D9660D615818899_1070293028 = varB4EAC82CA7396A68D541C85D26508E83_2014150619;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1070293028 = varB4EAC82CA7396A68D541C85D26508E83_1435748749;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1070293028.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1070293028;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.628 -0400", hash_original_method = "DAE4954D9EDE366A718556293A5AA5D3", hash_generated_method = "1B884AA4008C2DF3E1180DC7C85BB8D5")
    @Override
    public boolean areAllItemsEnabled() {
        boolean var5A180658E7F9DF714EBCBF2EE1C5FDF9_641425044 = (mExpandableListAdapter.areAllItemsEnabled());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1224196933 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1224196933;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.629 -0400", hash_original_method = "0084AC4844BFD434CBA804E2DF22BA27", hash_generated_method = "7C5D60ECB6FFCC9482B9F0116484CB21")
    @Override
    public boolean isEnabled(int flatListPos) {
        final ExpandableListPosition pos = getUnflattenedPos(flatListPos).position;
        boolean retValue;
        {
            retValue = mExpandableListAdapter.isChildSelectable(pos.groupPos, pos.childPos);
        } 
        {
            retValue = true;
        } 
        pos.recycle();
        addTaint(flatListPos);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1172240457 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1172240457;
        
        
        
        
            
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.629 -0400", hash_original_method = "E43CB6EF7F0706DB8CAE1E4EB2A6AE3E", hash_generated_method = "A6B568365B1240A77C225AD1FE153087")
    public int getCount() {
        int var46C97A40993028EB7F14B5C60FAA31C2_1771194953 = (mExpandableListAdapter.getGroupCount() + mTotalExpChildrenCount);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1937355214 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1937355214;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.630 -0400", hash_original_method = "06B72D417088BC3B17164CA741049075", hash_generated_method = "1B1194A056B9240EB312950635935C96")
    public Object getItem(int flatListPos) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1500904852 = null; 
        final PositionMetadata posMetadata = getUnflattenedPos(flatListPos);
        Object retValue;
        {
            retValue = mExpandableListAdapter
                    .getGroup(posMetadata.position.groupPos);
        } 
        {
            retValue = mExpandableListAdapter.getChild(posMetadata.position.groupPos,
                    posMetadata.position.childPos);
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Flat list position is of unknown type");
        } 
        posMetadata.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_1500904852 = retValue;
        addTaint(flatListPos);
        varB4EAC82CA7396A68D541C85D26508E83_1500904852.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1500904852;
        
        
        
        
            
                    
        
            
                    
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.630 -0400", hash_original_method = "4AC16A8A6C46491D50BE7E30F75A3576", hash_generated_method = "88FD5309B097943456601B976C89D39A")
    public long getItemId(int flatListPos) {
        final PositionMetadata posMetadata = getUnflattenedPos(flatListPos);
        final long groupId = mExpandableListAdapter.getGroupId(posMetadata.position.groupPos);
        long retValue;
        {
            retValue = mExpandableListAdapter.getCombinedGroupId(groupId);
        } 
        {
            final long childId = mExpandableListAdapter.getChildId(posMetadata.position.groupPos,
                    posMetadata.position.childPos);
            retValue = mExpandableListAdapter.getCombinedChildId(groupId, childId);
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Flat list position is of unknown type");
        } 
        posMetadata.recycle();
        addTaint(flatListPos);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2104088218 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2104088218;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.631 -0400", hash_original_method = "E8F063B04C087445609A9E5E66DA0C8E", hash_generated_method = "4BB6978740F30AB711B66A925BDA25DC")
    public View getView(int flatListPos, View convertView, ViewGroup parent) {
        View varB4EAC82CA7396A68D541C85D26508E83_233548295 = null; 
        final PositionMetadata posMetadata = getUnflattenedPos(flatListPos);
        View retValue;
        {
            retValue = mExpandableListAdapter.getGroupView(posMetadata.position.groupPos,
                    posMetadata.isExpanded(), convertView, parent);
        } 
        {
            final boolean isLastChild = posMetadata.groupMetadata.lastChildFlPos == flatListPos;
            retValue = mExpandableListAdapter.getChildView(posMetadata.position.groupPos,
                    posMetadata.position.childPos, isLastChild, convertView, parent);
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Flat list position is of unknown type");
        } 
        posMetadata.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_233548295 = retValue;
        addTaint(flatListPos);
        addTaint(convertView.getTaint());
        addTaint(parent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_233548295.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_233548295;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.632 -0400", hash_original_method = "99547DA2855DBC2792C3AF02654A4FE0", hash_generated_method = "E2AA2104ECD0BF19AE6830AD7FCF88A3")
    @Override
    public int getItemViewType(int flatListPos) {
        final ExpandableListPosition pos = getUnflattenedPos(flatListPos).position;
        int retValue;
        {
            HeterogeneousExpandableList adapter = (HeterogeneousExpandableList) mExpandableListAdapter;
            {
                retValue = adapter.getGroupType(pos.groupPos);
            } 
            {
                final int childType = adapter.getChildType(pos.groupPos, pos.childPos);
                retValue = adapter.getGroupTypeCount() + childType;
            } 
        } 
        {
            {
                retValue = 0;
            } 
            {
                retValue = 1;
            } 
        } 
        pos.recycle();
        addTaint(flatListPos);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1661287398 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1661287398;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.632 -0400", hash_original_method = "CE0634CAEF6413BEB2C07851873B554E", hash_generated_method = "0E8A0D536AA27AFCDAEACFAF096B0133")
    @Override
    public int getViewTypeCount() {
        {
            HeterogeneousExpandableList adapter = (HeterogeneousExpandableList) mExpandableListAdapter;
            int varE6779AD3637EC37D8C7FC74DBF1FBC3D_1822259845 = (adapter.getGroupTypeCount() + adapter.getChildTypeCount());
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_571370602 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_571370602;
        
        
            
                    
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.632 -0400", hash_original_method = "4910256FB1EE08A13057FF7D9F357251", hash_generated_method = "9D70C1C75AD02987062F59D3A3ADB87E")
    @Override
    public boolean hasStableIds() {
        boolean varD96F239D0CDB2AF91A2C618E3B3AED55_2039040995 = (mExpandableListAdapter.hasStableIds());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1251071383 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1251071383;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.633 -0400", hash_original_method = "E23B4E2A713C93A88E352378F7DC6B9B", hash_generated_method = "A8EF2E1192ABA88971AE5DC944ED6ABE")
    @SuppressWarnings("unchecked")
    private void refreshExpGroupMetadataList(boolean forceChildrenCountRefresh,
            boolean syncGroupPositions) {
        final ArrayList<GroupMetadata> egml = mExpGroupMetadataList;
        int egmlSize = egml.size();
        int curFlPos = 0;
        mTotalExpChildrenCount = 0;
        {
            boolean positionsChanged = false;
            {
                int i = egmlSize - 1;
                {
                    GroupMetadata curGm = egml.get(i);
                    int newGPos = findGroupPosition(curGm.gId, curGm.gPos);
                    {
                        {
                            egml.remove(i);
                        } 
                        curGm.gPos = newGPos;
                        positionsChanged = true;
                    } 
                } 
            } 
            {
                Collections.sort(egml);
            } 
        } 
        int gChildrenCount;
        int lastGPos = 0;
        {
            int i = 0;
            {
                GroupMetadata curGm = egml.get(i);
                {
                    gChildrenCount = mExpandableListAdapter.getChildrenCount(curGm.gPos);
                } 
                {
                    gChildrenCount = curGm.lastChildFlPos - curGm.flPos;
                } 
                mTotalExpChildrenCount += gChildrenCount;
                curFlPos += (curGm.gPos - lastGPos);
                lastGPos = curGm.gPos;
                curGm.flPos = curFlPos;
                curFlPos += gChildrenCount;
                curGm.lastChildFlPos = curFlPos;
            } 
        } 
        addTaint(forceChildrenCountRefresh);
        addTaint(syncGroupPositions);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.633 -0400", hash_original_method = "356AA5E78F17E2ABD0F401EB8EAF983A", hash_generated_method = "8C7FAC80EA5F54D1E8764EECF00BBB47")
     boolean collapseGroup(int groupPos) {
        PositionMetadata pm = getFlattenedPos(ExpandableListPosition.obtain(
                ExpandableListPosition.GROUP, groupPos, -1, -1));
        boolean retValue = collapseGroup(pm);
        pm.recycle();
        addTaint(groupPos);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1883186067 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1883186067;
        
        
                
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.634 -0400", hash_original_method = "B7CC4B14B03031BB8898031F497A0B04", hash_generated_method = "9ACCE19EFE11303CB5873C3D99797A53")
     boolean collapseGroup(PositionMetadata posMetadata) {
        mExpGroupMetadataList.remove(posMetadata.groupMetadata);
        refreshExpGroupMetadataList(false, false);
        notifyDataSetChanged();
        mExpandableListAdapter.onGroupCollapsed(posMetadata.groupMetadata.gPos);
        addTaint(posMetadata.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1860970689 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1860970689;
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.634 -0400", hash_original_method = "5E373C5564B1740CC801138FBC6EE83B", hash_generated_method = "B3A6125CDA34F903CD9119278DC6DDAE")
     boolean expandGroup(int groupPos) {
        PositionMetadata pm = getFlattenedPos(ExpandableListPosition.obtain(
                ExpandableListPosition.GROUP, groupPos, -1, -1));
        boolean retValue = expandGroup(pm);
        pm.recycle();
        addTaint(groupPos);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_842044108 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_842044108;
        
        
                
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.635 -0400", hash_original_method = "7C096EBC61E7C7FF959B994559196523", hash_generated_method = "CD7AA01FEC55A581294D875DD59306F6")
     boolean expandGroup(PositionMetadata posMetadata) {
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Need group");
        } 
        {
            boolean var0BF36D97B0462C030BBCF30B44542AC5_2086195371 = (mExpGroupMetadataList.size() >= mMaxExpGroupCount);
            {
                GroupMetadata collapsedGm = mExpGroupMetadataList.get(0);
                int collapsedIndex = mExpGroupMetadataList.indexOf(collapsedGm);
                collapseGroup(collapsedGm.gPos);
            } 
        } 
        GroupMetadata expandedGm = GroupMetadata.obtain(
                GroupMetadata.REFRESH,
                GroupMetadata.REFRESH,
                posMetadata.position.groupPos,
                mExpandableListAdapter.getGroupId(posMetadata.position.groupPos));
        mExpGroupMetadataList.add(posMetadata.groupInsertIndex, expandedGm);
        refreshExpGroupMetadataList(false, false);
        notifyDataSetChanged();
        mExpandableListAdapter.onGroupExpanded(expandedGm.gPos);
        addTaint(posMetadata.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1620861094 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1620861094;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.635 -0400", hash_original_method = "14DD7EE25463BE2F409F1A554DB1FBD9", hash_generated_method = "2024FAE80D2239D75847ADECCE1DAD04")
    public boolean isGroupExpanded(int groupPosition) {
        GroupMetadata groupMetadata;
        {
            int i = mExpGroupMetadataList.size() - 1;
            {
                groupMetadata = mExpGroupMetadataList.get(i);
            } 
        } 
        addTaint(groupPosition);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1696268175 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1696268175;
        
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.635 -0400", hash_original_method = "5DCA730791D083145030F1469300702C", hash_generated_method = "ADF6079EFB27B709D59795A65482C88A")
    public void setMaxExpGroupCount(int maxExpGroupCount) {
        mMaxExpGroupCount = maxExpGroupCount;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.636 -0400", hash_original_method = "473155659E1950E1738B6CCA8650B997", hash_generated_method = "C0099983E3D658185182660626BEC3B0")
     ExpandableListAdapter getAdapter() {
        ExpandableListAdapter varB4EAC82CA7396A68D541C85D26508E83_1508893619 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1508893619 = mExpandableListAdapter;
        varB4EAC82CA7396A68D541C85D26508E83_1508893619.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1508893619;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.636 -0400", hash_original_method = "D7C89EA0D9DD591B12578E8793100CE2", hash_generated_method = "E6A75A0665051CB9FCA5E1BB0A64C8A0")
    public Filter getFilter() {
        Filter varB4EAC82CA7396A68D541C85D26508E83_1545649734 = null; 
        Filter varB4EAC82CA7396A68D541C85D26508E83_263255082 = null; 
        ExpandableListAdapter adapter = getAdapter();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1545649734 = ((Filterable) adapter).getFilter();
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_263255082 = null;
        } 
        Filter varA7E53CE21691AB073D9660D615818899_1851924302; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1851924302 = varB4EAC82CA7396A68D541C85D26508E83_1545649734;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1851924302 = varB4EAC82CA7396A68D541C85D26508E83_263255082;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1851924302.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1851924302;
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.637 -0400", hash_original_method = "740752E96AF2B266538C6125F8E79937", hash_generated_method = "B5055ACE392D487F5C27C5D04B4D6D91")
     ArrayList<GroupMetadata> getExpandedGroupMetadataList() {
        ArrayList<GroupMetadata> varB4EAC82CA7396A68D541C85D26508E83_1266105252 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1266105252 = mExpGroupMetadataList;
        varB4EAC82CA7396A68D541C85D26508E83_1266105252.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1266105252;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.637 -0400", hash_original_method = "43D377DDC694A5D1EB7EAB73153EC2C8", hash_generated_method = "6BC186386BFA7D63493EA15C2FEB523E")
     void setExpandedGroupMetadataList(ArrayList<GroupMetadata> expandedGroupMetadataList) {
        int numGroups = mExpandableListAdapter.getGroupCount();
        {
            int i = expandedGroupMetadataList.size() - 1;
            {
                {
                    boolean var5AB2E6FDCD2FE74673EFC61C15C26F08_1924865286 = (expandedGroupMetadataList.get(i).gPos >= numGroups);
                } 
            } 
        } 
        mExpGroupMetadataList = expandedGroupMetadataList;
        refreshExpGroupMetadataList(true, false);
        
        
            
        
        
        
            
                
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.639 -0400", hash_original_method = "DF256FE26F67ED917C946C2E9410F027", hash_generated_method = "965E3B7763ECBCC09432802095F56EC7")
    @Override
    public boolean isEmpty() {
        ExpandableListAdapter adapter = getAdapter();
        {
            Object var0693446521B9036041825FEBAE0330F0_1830491914 = (adapter.isEmpty());
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2039760506 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2039760506;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.640 -0400", hash_original_method = "174FBE5747A707DB845F85C327785D51", hash_generated_method = "B213E411FC65760761FBF78E5873A7FF")
     int findGroupPosition(long groupIdToMatch, int seedGroupPosition) {
        int count = mExpandableListAdapter.getGroupCount();
        seedGroupPosition = Math.max(0, seedGroupPosition);
        seedGroupPosition = Math.min(count - 1, seedGroupPosition);
        long endTime = SystemClock.uptimeMillis() + AdapterView.SYNC_MAX_DURATION_MILLIS;
        long rowId;
        int first = seedGroupPosition;
        int last = seedGroupPosition;
        boolean next = false;
        boolean hitFirst;
        boolean hitLast;
        ExpandableListAdapter adapter = getAdapter();
        {
            boolean var456DAD1228A2E995CDD3C7508B2D1BC6_227636157 = (SystemClock.uptimeMillis() <= endTime);
            {
                rowId = adapter.getGroupId(seedGroupPosition);
                hitLast = last == count - 1;
                hitFirst = first == 0;
                {
                    seedGroupPosition = last;
                    next = false;
                } 
                {
                    seedGroupPosition = first;
                    next = true;
                } 
            } 
        } 
        addTaint(groupIdToMatch);
        addTaint(seedGroupPosition);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1315964467 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1315964467;
        
        
    }

    
    protected class MyDataSetObserver extends DataSetObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.640 -0400", hash_original_method = "B8855E81B638DE0F5C9202168EAE6D42", hash_generated_method = "B8855E81B638DE0F5C9202168EAE6D42")
        public MyDataSetObserver ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.640 -0400", hash_original_method = "6638C55358D7A5972C632ED02BA3E5C3", hash_generated_method = "423E58DDE1ED590711D4AB94EA334FA7")
        @Override
        public void onChanged() {
            
            refreshExpGroupMetadataList(true, true);
            notifyDataSetChanged();
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.641 -0400", hash_original_method = "097361F82E1EAFBA4D6D3BF1780C0DD3", hash_generated_method = "A5B595EB134C6A10414CBA53942E11E4")
        @Override
        public void onInvalidated() {
            
            refreshExpGroupMetadataList(true, true);
            notifyDataSetInvalidated();
            
            
            
        }

        
    }


    
    static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.641 -0400", hash_original_field = "15DD1CDB53D47E43A660BC30459C11BF", hash_generated_field = "58B6025F7C34D4075DA7A8B5B78AF226")

        int flPos;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.641 -0400", hash_original_field = "48A98D4B5525FED07D4C5320C1947CC6", hash_generated_field = "1D206009A6034643761BC2A5FF4F958A")

        int lastChildFlPos;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.641 -0400", hash_original_field = "C224E4C7E3CFB2F83B8DD85913D57702", hash_generated_field = "3DC369C72F1134212FEABAA7CBB84833")

        int gPos;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.641 -0400", hash_original_field = "EB1DAC2EEB151A9DF696A3B62D27B72F", hash_generated_field = "FF49466B0FCBC21119470C70559BF788")

        long gId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.641 -0400", hash_original_method = "D22B32F032ACC40BC7080CC4DC6C0D5E", hash_generated_method = "DE6C626044B8E9CC58838E683EF276B1")
        private  GroupMetadata() {
            
        }

        
        static GroupMetadata obtain(int flPos, int lastChildFlPos, int gPos, long gId) {
            GroupMetadata gm = new GroupMetadata();
            gm.flPos = flPos;
            gm.lastChildFlPos = lastChildFlPos;
            gm.gPos = gPos;
            gm.gId = gId;
            return gm;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.642 -0400", hash_original_method = "ECBFFC8C0ED7A961DBF56C4EE305170D", hash_generated_method = "748015B839A1FFFFC9533A69F90EE2BD")
        public int compareTo(GroupMetadata another) {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } 
            addTaint(another.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1713225388 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1713225388;
            
            
                
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.642 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "B18CDE741B042880241F70C6A35B05A6")
        public int describeContents() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1135117248 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1135117248;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.642 -0400", hash_original_method = "65A29D222E83CA17BC122C9C28EAFA8F", hash_generated_method = "CE7DB12EFE0432D0340C8B33BE83BCAC")
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(flPos);
            dest.writeInt(lastChildFlPos);
            dest.writeInt(gPos);
            dest.writeLong(gId);
            addTaint(dest.getTaint());
            addTaint(flags);
            
            
            
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.642 -0400", hash_original_field = "AF8BE5A0E29AD6467C3859275F3A6234", hash_generated_field = "AA4362F6390CEC3E3D3C031E047DB090")

        final static int REFRESH = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.642 -0400", hash_original_field = "78442AA8D3BDB00B3E51CD054914D00C", hash_generated_field = "904F1381FE24EA0344AB3807F0522586")

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
        
    }


    
    static public class PositionMetadata {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.642 -0400", hash_original_field = "4757FE07FD492A8BE0EA6A760D683D6E", hash_generated_field = "439A44C84644DDD041C72E7D8E43AE28")

        public ExpandableListPosition position;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.642 -0400", hash_original_field = "9D8E3C4FD98EA56A261B148A6E96B414", hash_generated_field = "1B4C4593E0FDCF44159ACC4FBB332E4C")

        public GroupMetadata groupMetadata;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.643 -0400", hash_original_field = "F4E97B1642ACB36AB72070AA444EF37B", hash_generated_field = "21E16F098268A299565F9E372C785629")

        public int groupInsertIndex;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.643 -0400", hash_original_method = "D695D4EB809D075329F88CC11AC9F37B", hash_generated_method = "72FA864FA9C855DE015B0EDB93BB6462")
        private  PositionMetadata() {
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.643 -0400", hash_original_method = "5AD4B913B9726C3345D273778B3773BA", hash_generated_method = "C2D78B097428DD4DBD267482388DC1E9")
        private void resetState() {
            position = null;
            groupMetadata = null;
            groupInsertIndex = 0;
            
            
            
            
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.644 -0400", hash_original_method = "8A154BA1D9B394A3D67E04E6A86589B2", hash_generated_method = "FD0F7497BA6A2388D65A8FC145C0F702")
        public void recycle() {
            {
                {
                    boolean var9985C19DB3277BD510D6C0334A18B696_2005416092 = (sPool.size() < MAX_POOL_SIZE);
                    {
                        sPool.add(this);
                    } 
                } 
            } 
            
            
                
                    
                
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.644 -0400", hash_original_method = "3DA77438EDE7E493B793AF2E840B43CD", hash_generated_method = "609142F02ED197F026F1FC88CD60EC0C")
        public boolean isExpanded() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1891001016 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1891001016;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.644 -0400", hash_original_field = "889E6ADBE471574497DA5C9E79EF7FCA", hash_generated_field = "7127A67374BF405D0F01EEB2429B1D48")

        private static final int MAX_POOL_SIZE = 5;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.644 -0400", hash_original_field = "026A57939A30BF75DDCB5D07D6847366", hash_generated_field = "8C9EE594696DB4880353F853B50DD5E0")

        private static ArrayList<PositionMetadata> sPool = new ArrayList<PositionMetadata>(MAX_POOL_SIZE);
    }


    
}

