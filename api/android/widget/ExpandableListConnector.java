package android.widget;

// Droidsafe Imports
import java.util.ArrayList;
import java.util.Collections;

import android.database.DataSetObserver;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

class ExpandableListConnector extends BaseAdapter implements Filterable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.380 -0400", hash_original_field = "8DBF5674055609276EEC97573F22FB4C", hash_generated_field = "18A81DFA989CC3FAA8A107E272992504")

    private ExpandableListAdapter mExpandableListAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.380 -0400", hash_original_field = "81712CC15C8A29FB14E2EB809C95AF8C", hash_generated_field = "3E8BCCD4064217A7C173330F3F39D938")

    private ArrayList<GroupMetadata> mExpGroupMetadataList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.380 -0400", hash_original_field = "47B9C7A29B9BD55ED03FF5EEB47C1AD0", hash_generated_field = "64833B5112863E55C291272F61C229B3")

    private int mTotalExpChildrenCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.380 -0400", hash_original_field = "8E2BD743CFF2027912F637A0645FAA05", hash_generated_field = "73604CF012E96086A83733575D92D3EC")

    private int mMaxExpGroupCount = Integer.MAX_VALUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.380 -0400", hash_original_field = "C38470C7D33F6F574A9D79357990B03A", hash_generated_field = "096B6AFF2D4BE73F0317C948A7EB332C")

    private final DataSetObserver mDataSetObserver = new MyDataSetObserver();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.380 -0400", hash_original_method = "BC5B318F45FBBBBC44050BD05FD123C0", hash_generated_method = "66507A1E8E1BD06CACECCA86BFD115FC")
    public  ExpandableListConnector(ExpandableListAdapter expandableListAdapter) {
        addTaint(expandableListAdapter.getTaint());
        mExpGroupMetadataList = new ArrayList<GroupMetadata>();
        setExpandableListAdapter(expandableListAdapter);
        // ---------- Original Method ----------
        //mExpGroupMetadataList = new ArrayList<GroupMetadata>();
        //setExpandableListAdapter(expandableListAdapter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.380 -0400", hash_original_method = "20624F8A2041913E46624C5620B8C178", hash_generated_method = "99C4AE7AC2940E195D82F3575EC0A0E9")
    public void setExpandableListAdapter(ExpandableListAdapter expandableListAdapter) {
        if(mExpandableListAdapter != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.382 -0400", hash_original_method = "1168BEC82030FA7343EA44D40ECA13BC", hash_generated_method = "048D1B26F404B6FC152542AE44019C2C")
     PositionMetadata getUnflattenedPos(final int flPos) {
        addTaint(flPos);
        final ArrayList<GroupMetadata> egml = mExpGroupMetadataList;
        final int numExpGroups = egml.size();
        int leftExpGroupIndex = 0;
        int rightExpGroupIndex = numExpGroups - 1;
        int midExpGroupIndex = 0;
        GroupMetadata midExpGm;
        if(numExpGroups == 0)        
        {
PositionMetadata var532E6308BF3219705761E3B9AAFBE41A_1339820375 =             PositionMetadata.obtain(flPos, ExpandableListPosition.GROUP, flPos,
                    -1, null, 0);
            var532E6308BF3219705761E3B9AAFBE41A_1339820375.addTaint(taint);
            return var532E6308BF3219705761E3B9AAFBE41A_1339820375;
        } //End block
        while
(leftExpGroupIndex <= rightExpGroupIndex)        
        {
            midExpGroupIndex =
                    (rightExpGroupIndex - leftExpGroupIndex) / 2
                            + leftExpGroupIndex;
            midExpGm = egml.get(midExpGroupIndex);
            if(flPos > midExpGm.lastChildFlPos)            
            {
                leftExpGroupIndex = midExpGroupIndex + 1;
            } //End block
            else
            if(flPos < midExpGm.flPos)            
            {
                rightExpGroupIndex = midExpGroupIndex - 1;
            } //End block
            else
            if(flPos == midExpGm.flPos)            
            {
PositionMetadata var2ABF34BE903AA6A07F9DF5EE9EF3B347_785287005 =                 PositionMetadata.obtain(flPos, ExpandableListPosition.GROUP,
                        midExpGm.gPos, -1, midExpGm, midExpGroupIndex);
                var2ABF34BE903AA6A07F9DF5EE9EF3B347_785287005.addTaint(taint);
                return var2ABF34BE903AA6A07F9DF5EE9EF3B347_785287005;
            } //End block
            else
            if(flPos <= midExpGm.lastChildFlPos)            
            {
                final int childPos = flPos - (midExpGm.flPos + 1);
PositionMetadata var35A4CB6C50CFB7D5E02E786043C78817_497653659 =                 PositionMetadata.obtain(flPos, ExpandableListPosition.CHILD,
                        midExpGm.gPos, childPos, midExpGm, midExpGroupIndex);
                var35A4CB6C50CFB7D5E02E786043C78817_497653659.addTaint(taint);
                return var35A4CB6C50CFB7D5E02E786043C78817_497653659;
            } //End block
        } //End block
        int insertPosition = 0;
        int groupPos = 0;
        if(leftExpGroupIndex > midExpGroupIndex)        
        {
            final GroupMetadata leftExpGm = egml.get(leftExpGroupIndex-1);
            insertPosition = leftExpGroupIndex;
            groupPos =
                (flPos - leftExpGm.lastChildFlPos) + leftExpGm.gPos;
        } //End block
        else
        if(rightExpGroupIndex < midExpGroupIndex)        
        {
            final GroupMetadata rightExpGm = egml.get(++rightExpGroupIndex);
            insertPosition = rightExpGroupIndex;
            groupPos = rightExpGm.gPos - (rightExpGm.flPos - flPos);
        } //End block
        else
        {
            RuntimeException var024072320E15906553CB4573ABED2BB0_1321969792 = new RuntimeException("Unknown state");
            var024072320E15906553CB4573ABED2BB0_1321969792.addTaint(taint);
            throw var024072320E15906553CB4573ABED2BB0_1321969792;
        } //End block
PositionMetadata var0286E2BBC69197A9CBE39684ACEAAC4E_896243061 =         PositionMetadata.obtain(flPos, ExpandableListPosition.GROUP, groupPos, -1,
                null, insertPosition);
        var0286E2BBC69197A9CBE39684ACEAAC4E_896243061.addTaint(taint);
        return var0286E2BBC69197A9CBE39684ACEAAC4E_896243061;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.384 -0400", hash_original_method = "1D3F8862F07489DB803D2A10735D7C2B", hash_generated_method = "3C50271F722D56A41961B8EC57160FAE")
     PositionMetadata getFlattenedPos(final ExpandableListPosition pos) {
        addTaint(pos.getTaint());
        final ArrayList<GroupMetadata> egml = mExpGroupMetadataList;
        final int numExpGroups = egml.size();
        int leftExpGroupIndex = 0;
        int rightExpGroupIndex = numExpGroups - 1;
        int midExpGroupIndex = 0;
        GroupMetadata midExpGm;
        if(numExpGroups == 0)        
        {
PositionMetadata varF44E378D6A51AC16B8883E3F3489CD90_1050971772 =             PositionMetadata.obtain(pos.groupPos, pos.type,
                    pos.groupPos, pos.childPos, null, 0);
            varF44E378D6A51AC16B8883E3F3489CD90_1050971772.addTaint(taint);
            return varF44E378D6A51AC16B8883E3F3489CD90_1050971772;
        } //End block
        while
(leftExpGroupIndex <= rightExpGroupIndex)        
        {
            midExpGroupIndex = (rightExpGroupIndex - leftExpGroupIndex)/2 + leftExpGroupIndex;
            midExpGm = egml.get(midExpGroupIndex);
            if(pos.groupPos > midExpGm.gPos)            
            {
                leftExpGroupIndex = midExpGroupIndex + 1;
            } //End block
            else
            if(pos.groupPos < midExpGm.gPos)            
            {
                rightExpGroupIndex = midExpGroupIndex - 1;
            } //End block
            else
            if(pos.groupPos == midExpGm.gPos)            
            {
                if(pos.type == ExpandableListPosition.GROUP)                
                {
PositionMetadata var0600C4725D4E05F6C5AD18A84C5ECC43_478558237 =                     PositionMetadata.obtain(midExpGm.flPos, pos.type,
                            pos.groupPos, pos.childPos, midExpGm, midExpGroupIndex);
                    var0600C4725D4E05F6C5AD18A84C5ECC43_478558237.addTaint(taint);
                    return var0600C4725D4E05F6C5AD18A84C5ECC43_478558237;
                } //End block
                else
                if(pos.type == ExpandableListPosition.CHILD)                
                {
PositionMetadata var48A8CE9F60B09B63FA9D3AAEDEEA84C1_1255225420 =                     PositionMetadata.obtain(midExpGm.flPos + pos.childPos
                            + 1, pos.type, pos.groupPos, pos.childPos,
                            midExpGm, midExpGroupIndex);
                    var48A8CE9F60B09B63FA9D3AAEDEEA84C1_1255225420.addTaint(taint);
                    return var48A8CE9F60B09B63FA9D3AAEDEEA84C1_1255225420;
                } //End block
                else
                {
PositionMetadata var540C13E9E156B687226421B24F2DF178_1943851233 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1943851233.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1943851233;
                } //End block
            } //End block
        } //End block
        if(pos.type != ExpandableListPosition.GROUP)        
        {
PositionMetadata var540C13E9E156B687226421B24F2DF178_2126342864 =             null;
            var540C13E9E156B687226421B24F2DF178_2126342864.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2126342864;
        } //End block
        if(leftExpGroupIndex > midExpGroupIndex)        
        {
            final GroupMetadata leftExpGm = egml.get(leftExpGroupIndex-1);
            final int flPos = leftExpGm.lastChildFlPos
                            + (pos.groupPos - leftExpGm.gPos);
PositionMetadata var83B55BE62D2C770516658BB428BD44D4_1897304448 =             PositionMetadata.obtain(flPos, pos.type, pos.groupPos,
                    pos.childPos, null, leftExpGroupIndex);
            var83B55BE62D2C770516658BB428BD44D4_1897304448.addTaint(taint);
            return var83B55BE62D2C770516658BB428BD44D4_1897304448;
        } //End block
        else
        if(rightExpGroupIndex < midExpGroupIndex)        
        {
            final GroupMetadata rightExpGm = egml.get(++rightExpGroupIndex);
            final int flPos = rightExpGm.flPos
                            - (rightExpGm.gPos - pos.groupPos);
PositionMetadata var4EFF1590177417D60FCAC97875E32CE2_1205770378 =             PositionMetadata.obtain(flPos, pos.type, pos.groupPos,
                    pos.childPos, null, rightExpGroupIndex);
            var4EFF1590177417D60FCAC97875E32CE2_1205770378.addTaint(taint);
            return var4EFF1590177417D60FCAC97875E32CE2_1205770378;
        } //End block
        else
        {
PositionMetadata var540C13E9E156B687226421B24F2DF178_1317216326 =             null;
            var540C13E9E156B687226421B24F2DF178_1317216326.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1317216326;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.385 -0400", hash_original_method = "DAE4954D9EDE366A718556293A5AA5D3", hash_generated_method = "419963C3C47AE6D7FC2082C721CDADD3")
    @Override
    public boolean areAllItemsEnabled() {
        boolean var853445806DC6B04E750BF5DA59E523E4_1137919738 = (mExpandableListAdapter.areAllItemsEnabled());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1308523653 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1308523653;
        // ---------- Original Method ----------
        //return mExpandableListAdapter.areAllItemsEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.385 -0400", hash_original_method = "0084AC4844BFD434CBA804E2DF22BA27", hash_generated_method = "2EBF0C2A9E8446151369FDDABBBD3500")
    @Override
    public boolean isEnabled(int flatListPos) {
        addTaint(flatListPos);
        final ExpandableListPosition pos = getUnflattenedPos(flatListPos).position;
        boolean retValue;
        if(pos.type == ExpandableListPosition.CHILD)        
        {
            retValue = mExpandableListAdapter.isChildSelectable(pos.groupPos, pos.childPos);
        } //End block
        else
        {
            retValue = true;
        } //End block
        pos.recycle();
        boolean var9C7BD17E8EB1C3D0F843684A79A18570_492009405 = (retValue);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1938417053 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1938417053;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.386 -0400", hash_original_method = "E43CB6EF7F0706DB8CAE1E4EB2A6AE3E", hash_generated_method = "CAEE5CFF7CF8357025DE082195DF905E")
    public int getCount() {
        int var7877BF70B64A37ED869F37D69C3A78CA_318433018 = (mExpandableListAdapter.getGroupCount() + mTotalExpChildrenCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_480305611 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_480305611;
        // ---------- Original Method ----------
        //return mExpandableListAdapter.getGroupCount() + mTotalExpChildrenCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.387 -0400", hash_original_method = "06B72D417088BC3B17164CA741049075", hash_generated_method = "8736369F6855DD635A9C01511279276D")
    public Object getItem(int flatListPos) {
        addTaint(flatListPos);
        final PositionMetadata posMetadata = getUnflattenedPos(flatListPos);
        Object retValue;
        if(posMetadata.position.type == ExpandableListPosition.GROUP)        
        {
            retValue = mExpandableListAdapter
                    .getGroup(posMetadata.position.groupPos);
        } //End block
        else
        if(posMetadata.position.type == ExpandableListPosition.CHILD)        
        {
            retValue = mExpandableListAdapter.getChild(posMetadata.position.groupPos,
                    posMetadata.position.childPos);
        } //End block
        else
        {
            RuntimeException var256588F33C8C0818D5119AF562663C89_1677928968 = new RuntimeException("Flat list position is of unknown type");
            var256588F33C8C0818D5119AF562663C89_1677928968.addTaint(taint);
            throw var256588F33C8C0818D5119AF562663C89_1677928968;
        } //End block
        posMetadata.recycle();
Object var8A3AE42CF4D96FEAF203C6E7E2606E2D_1613226699 =         retValue;
        var8A3AE42CF4D96FEAF203C6E7E2606E2D_1613226699.addTaint(taint);
        return var8A3AE42CF4D96FEAF203C6E7E2606E2D_1613226699;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.387 -0400", hash_original_method = "4AC16A8A6C46491D50BE7E30F75A3576", hash_generated_method = "2AED9F768DDC03C239AAA04791839CDD")
    public long getItemId(int flatListPos) {
        addTaint(flatListPos);
        final PositionMetadata posMetadata = getUnflattenedPos(flatListPos);
        final long groupId = mExpandableListAdapter.getGroupId(posMetadata.position.groupPos);
        long retValue;
        if(posMetadata.position.type == ExpandableListPosition.GROUP)        
        {
            retValue = mExpandableListAdapter.getCombinedGroupId(groupId);
        } //End block
        else
        if(posMetadata.position.type == ExpandableListPosition.CHILD)        
        {
            final long childId = mExpandableListAdapter.getChildId(posMetadata.position.groupPos,
                    posMetadata.position.childPos);
            retValue = mExpandableListAdapter.getCombinedChildId(groupId, childId);
        } //End block
        else
        {
            RuntimeException var256588F33C8C0818D5119AF562663C89_896155611 = new RuntimeException("Flat list position is of unknown type");
            var256588F33C8C0818D5119AF562663C89_896155611.addTaint(taint);
            throw var256588F33C8C0818D5119AF562663C89_896155611;
        } //End block
        posMetadata.recycle();
        long var9C7BD17E8EB1C3D0F843684A79A18570_419732139 = (retValue);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1846044190 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1846044190;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.388 -0400", hash_original_method = "E8F063B04C087445609A9E5E66DA0C8E", hash_generated_method = "4882BF3A14E08D2C1F8E6977819C24CC")
    public View getView(int flatListPos, View convertView, ViewGroup parent) {
        addTaint(parent.getTaint());
        addTaint(convertView.getTaint());
        addTaint(flatListPos);
        final PositionMetadata posMetadata = getUnflattenedPos(flatListPos);
        View retValue;
        if(posMetadata.position.type == ExpandableListPosition.GROUP)        
        {
            retValue = mExpandableListAdapter.getGroupView(posMetadata.position.groupPos,
                    posMetadata.isExpanded(), convertView, parent);
        } //End block
        else
        if(posMetadata.position.type == ExpandableListPosition.CHILD)        
        {
            final boolean isLastChild = posMetadata.groupMetadata.lastChildFlPos == flatListPos;
            retValue = mExpandableListAdapter.getChildView(posMetadata.position.groupPos,
                    posMetadata.position.childPos, isLastChild, convertView, parent);
        } //End block
        else
        {
            RuntimeException var256588F33C8C0818D5119AF562663C89_1965437842 = new RuntimeException("Flat list position is of unknown type");
            var256588F33C8C0818D5119AF562663C89_1965437842.addTaint(taint);
            throw var256588F33C8C0818D5119AF562663C89_1965437842;
        } //End block
        posMetadata.recycle();
View var8A3AE42CF4D96FEAF203C6E7E2606E2D_177848195 =         retValue;
        var8A3AE42CF4D96FEAF203C6E7E2606E2D_177848195.addTaint(taint);
        return var8A3AE42CF4D96FEAF203C6E7E2606E2D_177848195;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.389 -0400", hash_original_method = "99547DA2855DBC2792C3AF02654A4FE0", hash_generated_method = "2372E4D0C64A659E1C9B2C2F7BA584D8")
    @Override
    public int getItemViewType(int flatListPos) {
        addTaint(flatListPos);
        final ExpandableListPosition pos = getUnflattenedPos(flatListPos).position;
        int retValue;
        if(mExpandableListAdapter instanceof HeterogeneousExpandableList)        
        {
            HeterogeneousExpandableList adapter = (HeterogeneousExpandableList) mExpandableListAdapter;
            if(pos.type == ExpandableListPosition.GROUP)            
            {
                retValue = adapter.getGroupType(pos.groupPos);
            } //End block
            else
            {
                final int childType = adapter.getChildType(pos.groupPos, pos.childPos);
                retValue = adapter.getGroupTypeCount() + childType;
            } //End block
        } //End block
        else
        {
            if(pos.type == ExpandableListPosition.GROUP)            
            {
                retValue = 0;
            } //End block
            else
            {
                retValue = 1;
            } //End block
        } //End block
        pos.recycle();
        int var9C7BD17E8EB1C3D0F843684A79A18570_1350748654 = (retValue);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_844556375 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_844556375;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.390 -0400", hash_original_method = "CE0634CAEF6413BEB2C07851873B554E", hash_generated_method = "90F8CF844E80D3D7387011B4B4CD7B7B")
    @Override
    public int getViewTypeCount() {
        if(mExpandableListAdapter instanceof HeterogeneousExpandableList)        
        {
            HeterogeneousExpandableList adapter = (HeterogeneousExpandableList) mExpandableListAdapter;
            int var587FB58AF43E1FCB6CEB29BFE33E040A_783881422 = (adapter.getGroupTypeCount() + adapter.getChildTypeCount());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1821465532 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1821465532;
        } //End block
        else
        {
            int varC81E728D9D4C2F636F067F89CC14862C_1355101521 = (2);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1321500213 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1321500213;
        } //End block
        // ---------- Original Method ----------
        //if (mExpandableListAdapter instanceof HeterogeneousExpandableList) {
            //HeterogeneousExpandableList adapter =
                    //(HeterogeneousExpandableList) mExpandableListAdapter;
            //return adapter.getGroupTypeCount() + adapter.getChildTypeCount();
        //} else {
            //return 2;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.390 -0400", hash_original_method = "4910256FB1EE08A13057FF7D9F357251", hash_generated_method = "ED15B0C015E3AA3A4F72A334258A1C31")
    @Override
    public boolean hasStableIds() {
        boolean var6AC663F78C04CA8D4834C87FA8609598_1910544881 = (mExpandableListAdapter.hasStableIds());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1553002286 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1553002286;
        // ---------- Original Method ----------
        //return mExpandableListAdapter.hasStableIds();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.391 -0400", hash_original_method = "E23B4E2A713C93A88E352378F7DC6B9B", hash_generated_method = "A7CAF66E68CF82BE5509A3C225FE49D6")
    @SuppressWarnings("unchecked")
    private void refreshExpGroupMetadataList(boolean forceChildrenCountRefresh,
            boolean syncGroupPositions) {
        addTaint(syncGroupPositions);
        addTaint(forceChildrenCountRefresh);
        final ArrayList<GroupMetadata> egml = mExpGroupMetadataList;
        int egmlSize = egml.size();
        int curFlPos = 0;
        mTotalExpChildrenCount = 0;
        if(syncGroupPositions)        
        {
            boolean positionsChanged = false;
for(int i = egmlSize - 1;i >= 0;i--)
            {
                GroupMetadata curGm = egml.get(i);
                int newGPos = findGroupPosition(curGm.gId, curGm.gPos);
                if(newGPos != curGm.gPos)                
                {
                    if(newGPos == AdapterView.INVALID_POSITION)                    
                    {
                        egml.remove(i);
                        egmlSize--;
                    } //End block
                    curGm.gPos = newGPos;
                    if(!positionsChanged)                    
                    positionsChanged = true;
                } //End block
            } //End block
            if(positionsChanged)            
            {
                Collections.sort(egml);
            } //End block
        } //End block
        int gChildrenCount;
        int lastGPos = 0;
for(int i = 0;i < egmlSize;i++)
        {
            GroupMetadata curGm = egml.get(i);
            if((curGm.lastChildFlPos == GroupMetadata.REFRESH) || forceChildrenCountRefresh)            
            {
                gChildrenCount = mExpandableListAdapter.getChildrenCount(curGm.gPos);
            } //End block
            else
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.392 -0400", hash_original_method = "356AA5E78F17E2ABD0F401EB8EAF983A", hash_generated_method = "5750B978AC14CA75FC8B7464B8E5C496")
     boolean collapseGroup(int groupPos) {
        addTaint(groupPos);
        PositionMetadata pm = getFlattenedPos(ExpandableListPosition.obtain(
                ExpandableListPosition.GROUP, groupPos, -1, -1));
        if(pm == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1141971364 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_721056200 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_721056200;
        }
        boolean retValue = collapseGroup(pm);
        pm.recycle();
        boolean var9C7BD17E8EB1C3D0F843684A79A18570_320049553 = (retValue);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_950667432 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_950667432;
        // ---------- Original Method ----------
        //PositionMetadata pm = getFlattenedPos(ExpandableListPosition.obtain(
                //ExpandableListPosition.GROUP, groupPos, -1, -1));
        //if (pm == null) return false;
        //boolean retValue = collapseGroup(pm);
        //pm.recycle();
        //return retValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.392 -0400", hash_original_method = "B7CC4B14B03031BB8898031F497A0B04", hash_generated_method = "4440FCC60DD81842306553AF36BCC2F5")
     boolean collapseGroup(PositionMetadata posMetadata) {
        addTaint(posMetadata.getTaint());
        if(posMetadata.groupMetadata == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_686282234 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1366018566 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1366018566;
        }
        mExpGroupMetadataList.remove(posMetadata.groupMetadata);
        refreshExpGroupMetadataList(false, false);
        notifyDataSetChanged();
        mExpandableListAdapter.onGroupCollapsed(posMetadata.groupMetadata.gPos);
        boolean varB326B5062B2F0E69046810717534CB09_786648651 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_326339780 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_326339780;
        // ---------- Original Method ----------
        //if (posMetadata.groupMetadata == null) return false;
        //mExpGroupMetadataList.remove(posMetadata.groupMetadata);
        //refreshExpGroupMetadataList(false, false);
        //notifyDataSetChanged();
        //mExpandableListAdapter.onGroupCollapsed(posMetadata.groupMetadata.gPos);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.392 -0400", hash_original_method = "5E373C5564B1740CC801138FBC6EE83B", hash_generated_method = "0597CE533E1F189ABA570CE126180C2A")
     boolean expandGroup(int groupPos) {
        addTaint(groupPos);
        PositionMetadata pm = getFlattenedPos(ExpandableListPosition.obtain(
                ExpandableListPosition.GROUP, groupPos, -1, -1));
        boolean retValue = expandGroup(pm);
        pm.recycle();
        boolean var9C7BD17E8EB1C3D0F843684A79A18570_262561775 = (retValue);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_24994335 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_24994335;
        // ---------- Original Method ----------
        //PositionMetadata pm = getFlattenedPos(ExpandableListPosition.obtain(
                //ExpandableListPosition.GROUP, groupPos, -1, -1));
        //boolean retValue = expandGroup(pm);
        //pm.recycle();
        //return retValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.392 -0400", hash_original_method = "7C096EBC61E7C7FF959B994559196523", hash_generated_method = "46EB9DE45235E46F6533ECF52A14B57C")
     boolean expandGroup(PositionMetadata posMetadata) {
        addTaint(posMetadata.getTaint());
        if(posMetadata.position.groupPos < 0)        
        {
            RuntimeException var5B16C044ACAF0493BB1FD037C38DCD2F_609660833 = new RuntimeException("Need group");
            var5B16C044ACAF0493BB1FD037C38DCD2F_609660833.addTaint(taint);
            throw var5B16C044ACAF0493BB1FD037C38DCD2F_609660833;
        } //End block
        if(mMaxExpGroupCount == 0)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1501528266 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1761791019 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1761791019;
        }
        if(posMetadata.groupMetadata != null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1843655107 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_448978401 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_448978401;
        }
        if(mExpGroupMetadataList.size() >= mMaxExpGroupCount)        
        {
            GroupMetadata collapsedGm = mExpGroupMetadataList.get(0);
            int collapsedIndex = mExpGroupMetadataList.indexOf(collapsedGm);
            collapseGroup(collapsedGm.gPos);
            if(posMetadata.groupInsertIndex > collapsedIndex)            
            {
                posMetadata.groupInsertIndex--;
            } //End block
        } //End block
        GroupMetadata expandedGm = GroupMetadata.obtain(
                GroupMetadata.REFRESH,
                GroupMetadata.REFRESH,
                posMetadata.position.groupPos,
                mExpandableListAdapter.getGroupId(posMetadata.position.groupPos));
        mExpGroupMetadataList.add(posMetadata.groupInsertIndex, expandedGm);
        refreshExpGroupMetadataList(false, false);
        notifyDataSetChanged();
        mExpandableListAdapter.onGroupExpanded(expandedGm.gPos);
        boolean varB326B5062B2F0E69046810717534CB09_1540285710 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_194456991 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_194456991;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.393 -0400", hash_original_method = "14DD7EE25463BE2F409F1A554DB1FBD9", hash_generated_method = "E50914333299514FC8A0B86C635D491C")
    public boolean isGroupExpanded(int groupPosition) {
        addTaint(groupPosition);
        GroupMetadata groupMetadata;
for(int i = mExpGroupMetadataList.size() - 1;i >= 0;i--)
        {
            groupMetadata = mExpGroupMetadataList.get(i);
            if(groupMetadata.gPos == groupPosition)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1343419116 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_81800440 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_81800440;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_661296360 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_769727210 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_769727210;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.393 -0400", hash_original_method = "5DCA730791D083145030F1469300702C", hash_generated_method = "ADF6079EFB27B709D59795A65482C88A")
    public void setMaxExpGroupCount(int maxExpGroupCount) {
        mMaxExpGroupCount = maxExpGroupCount;
        // ---------- Original Method ----------
        //mMaxExpGroupCount = maxExpGroupCount;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.394 -0400", hash_original_method = "473155659E1950E1738B6CCA8650B997", hash_generated_method = "90921FACF18CBF0D0F33DF00CB432A41")
     ExpandableListAdapter getAdapter() {
ExpandableListAdapter var6138734355307F47AFFDB0E0F3A9A71E_375120147 =         mExpandableListAdapter;
        var6138734355307F47AFFDB0E0F3A9A71E_375120147.addTaint(taint);
        return var6138734355307F47AFFDB0E0F3A9A71E_375120147;
        // ---------- Original Method ----------
        //return mExpandableListAdapter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.394 -0400", hash_original_method = "D7C89EA0D9DD591B12578E8793100CE2", hash_generated_method = "891A39CA8F69DF27F8A3478D82C77483")
    public Filter getFilter() {
        ExpandableListAdapter adapter = getAdapter();
        if(adapter instanceof Filterable)        
        {
Filter varF6CB8B0E6848549E20D5699BD1919234_1899490443 =             ((Filterable) adapter).getFilter();
            varF6CB8B0E6848549E20D5699BD1919234_1899490443.addTaint(taint);
            return varF6CB8B0E6848549E20D5699BD1919234_1899490443;
        } //End block
        else
        {
Filter var540C13E9E156B687226421B24F2DF178_675363409 =             null;
            var540C13E9E156B687226421B24F2DF178_675363409.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_675363409;
        } //End block
        // ---------- Original Method ----------
        //ExpandableListAdapter adapter = getAdapter();
        //if (adapter instanceof Filterable) {
            //return ((Filterable) adapter).getFilter();
        //} else {
            //return null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.394 -0400", hash_original_method = "740752E96AF2B266538C6125F8E79937", hash_generated_method = "1084A07E976929C1ACE7CCE76D8C7E6F")
     ArrayList<GroupMetadata> getExpandedGroupMetadataList() {
ArrayList<GroupMetadata> var16CF2BAF0A5F7FECA6491A4F87231A85_1794616620 =         mExpGroupMetadataList;
        var16CF2BAF0A5F7FECA6491A4F87231A85_1794616620.addTaint(taint);
        return var16CF2BAF0A5F7FECA6491A4F87231A85_1794616620;
        // ---------- Original Method ----------
        //return mExpGroupMetadataList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.395 -0400", hash_original_method = "43D377DDC694A5D1EB7EAB73153EC2C8", hash_generated_method = "610457F9C5DCD14D4D71CB67DA3B834A")
     void setExpandedGroupMetadataList(ArrayList<GroupMetadata> expandedGroupMetadataList) {
        if((expandedGroupMetadataList == null) || (mExpandableListAdapter == null))        
        {
            return;
        } //End block
        int numGroups = mExpandableListAdapter.getGroupCount();
for(int i = expandedGroupMetadataList.size() - 1;i >= 0;i--)
        {
            if(expandedGroupMetadataList.get(i).gPos >= numGroups)            
            {
                return;
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.395 -0400", hash_original_method = "DF256FE26F67ED917C946C2E9410F027", hash_generated_method = "4F83A3343B354823E40BC3F534DED66D")
    @Override
    public boolean isEmpty() {
        ExpandableListAdapter adapter = getAdapter();
        boolean var6AB8D04C6AF71AC2BFB44509786E6C4E_2114980053 = (adapter != null ? adapter.isEmpty() : true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_854216676 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_854216676;
        // ---------- Original Method ----------
        //ExpandableListAdapter adapter = getAdapter();
        //return adapter != null ? adapter.isEmpty() : true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.396 -0400", hash_original_method = "174FBE5747A707DB845F85C327785D51", hash_generated_method = "D918A5B307DDC44AF5B0FFDF00479472")
     int findGroupPosition(long groupIdToMatch, int seedGroupPosition) {
        addTaint(seedGroupPosition);
        addTaint(groupIdToMatch);
        int count = mExpandableListAdapter.getGroupCount();
        if(count == 0)        
        {
            int var73991B5AC8F55F7B73B83AE3AB0CCA16_1628069812 = (AdapterView.INVALID_POSITION);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2016140472 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2016140472;
        } //End block
        if(groupIdToMatch == AdapterView.INVALID_ROW_ID)        
        {
            int var73991B5AC8F55F7B73B83AE3AB0CCA16_1038005539 = (AdapterView.INVALID_POSITION);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_592540113 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_592540113;
        } //End block
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
        if(adapter == null)        
        {
            int var73991B5AC8F55F7B73B83AE3AB0CCA16_992167767 = (AdapterView.INVALID_POSITION);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1177249807 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1177249807;
        } //End block
        while
(SystemClock.uptimeMillis() <= endTime)        
        {
            rowId = adapter.getGroupId(seedGroupPosition);
            if(rowId == groupIdToMatch)            
            {
                int varAA9C4C7546C7043F9FEB20B62EBCB74A_1872267394 = (seedGroupPosition);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1844211312 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1844211312;
            } //End block
            hitLast = last == count - 1;
            hitFirst = first == 0;
            if(hitLast && hitFirst)            
            {
                break;
            } //End block
            if(hitFirst || (next && !hitLast))            
            {
                last++;
                seedGroupPosition = last;
                next = false;
            } //End block
            else
            if(hitLast || (!next && !hitFirst))            
            {
                first--;
                seedGroupPosition = first;
                next = true;
            } //End block
        } //End block
        int var73991B5AC8F55F7B73B83AE3AB0CCA16_1544298493 = (AdapterView.INVALID_POSITION);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_966808193 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_966808193;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    protected class MyDataSetObserver extends DataSetObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.396 -0400", hash_original_method = "B8855E81B638DE0F5C9202168EAE6D42", hash_generated_method = "B8855E81B638DE0F5C9202168EAE6D42")
        public MyDataSetObserver ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.396 -0400", hash_original_method = "6638C55358D7A5972C632ED02BA3E5C3", hash_generated_method = "423E58DDE1ED590711D4AB94EA334FA7")
        @Override
        public void onChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            refreshExpGroupMetadataList(true, true);
            notifyDataSetChanged();
            // ---------- Original Method ----------
            //refreshExpGroupMetadataList(true, true);
            //notifyDataSetChanged();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.396 -0400", hash_original_method = "097361F82E1EAFBA4D6D3BF1780C0DD3", hash_generated_method = "A5B595EB134C6A10414CBA53942E11E4")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.396 -0400", hash_original_field = "15DD1CDB53D47E43A660BC30459C11BF", hash_generated_field = "58B6025F7C34D4075DA7A8B5B78AF226")

        int flPos;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.396 -0400", hash_original_field = "48A98D4B5525FED07D4C5320C1947CC6", hash_generated_field = "1D206009A6034643761BC2A5FF4F958A")

        int lastChildFlPos;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.396 -0400", hash_original_field = "C224E4C7E3CFB2F83B8DD85913D57702", hash_generated_field = "3DC369C72F1134212FEABAA7CBB84833")

        int gPos;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.396 -0400", hash_original_field = "EB1DAC2EEB151A9DF696A3B62D27B72F", hash_generated_field = "FF49466B0FCBC21119470C70559BF788")

        long gId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.396 -0400", hash_original_method = "D22B32F032ACC40BC7080CC4DC6C0D5E", hash_generated_method = "DE6C626044B8E9CC58838E683EF276B1")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.396 -0400", hash_original_method = "ECBFFC8C0ED7A961DBF56C4EE305170D", hash_generated_method = "D629266ECE10DF8365442925AF4F574C")
        public int compareTo(GroupMetadata another) {
            addTaint(another.getTaint());
            if(another == null)            
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_919188440 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_919188440.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_919188440;
            } //End block
            int varD40B4EC49DB6DC78A23707773E67A373_2018816557 = (gPos - another.gPos);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1214200083 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1214200083;
            // ---------- Original Method ----------
            //if (another == null) {
                //throw new IllegalArgumentException();
            //}
            //return gPos - another.gPos;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.397 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "07354BABE693FAEB18F126830D3D195A")
        public int describeContents() {
            int varCFCD208495D565EF66E7DFF9F98764DA_701155213 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1398245040 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1398245040;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.397 -0400", hash_original_method = "65A29D222E83CA17BC122C9C28EAFA8F", hash_generated_method = "9D926208C71A531B45583C75A700FA90")
        public void writeToParcel(Parcel dest, int flags) {
            addTaint(flags);
            addTaint(dest.getTaint());
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.397 -0400", hash_original_field = "AF8BE5A0E29AD6467C3859275F3A6234", hash_generated_field = "AA4362F6390CEC3E3D3C031E047DB090")

        final static int REFRESH = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.397 -0400", hash_original_field = "78442AA8D3BDB00B3E51CD054914D00C", hash_generated_field = "904F1381FE24EA0344AB3807F0522586")

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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.397 -0400", hash_original_field = "4757FE07FD492A8BE0EA6A760D683D6E", hash_generated_field = "439A44C84644DDD041C72E7D8E43AE28")

        public ExpandableListPosition position;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.397 -0400", hash_original_field = "9D8E3C4FD98EA56A261B148A6E96B414", hash_generated_field = "1B4C4593E0FDCF44159ACC4FBB332E4C")

        public GroupMetadata groupMetadata;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.397 -0400", hash_original_field = "F4E97B1642ACB36AB72070AA444EF37B", hash_generated_field = "21E16F098268A299565F9E372C785629")

        public int groupInsertIndex;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.397 -0400", hash_original_method = "D695D4EB809D075329F88CC11AC9F37B", hash_generated_method = "72FA864FA9C855DE015B0EDB93BB6462")
        private  PositionMetadata() {
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.397 -0400", hash_original_method = "5AD4B913B9726C3345D273778B3773BA", hash_generated_method = "C2D78B097428DD4DBD267482388DC1E9")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.398 -0400", hash_original_method = "8A154BA1D9B394A3D67E04E6A86589B2", hash_generated_method = "630615FD0F25C98518FE11FF0693404C")
        public void recycle() {
            synchronized
(sPool)            {
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.398 -0400", hash_original_method = "3DA77438EDE7E493B793AF2E840B43CD", hash_generated_method = "182C8A3CCD236781EFAD539CDDE66947")
        public boolean isExpanded() {
            boolean varB3BC9AD7B79E12A165E034A47E593F8B_1153163013 = (groupMetadata != null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1407063741 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1407063741;
            // ---------- Original Method ----------
            //return groupMetadata != null;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.398 -0400", hash_original_field = "889E6ADBE471574497DA5C9E79EF7FCA", hash_generated_field = "7127A67374BF405D0F01EEB2429B1D48")

        private static final int MAX_POOL_SIZE = 5;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.398 -0400", hash_original_field = "026A57939A30BF75DDCB5D07D6847366", hash_generated_field = "8C9EE594696DB4880353F853B50DD5E0")

        private static ArrayList<PositionMetadata> sPool = new ArrayList<PositionMetadata>(MAX_POOL_SIZE);
    }


    
}

