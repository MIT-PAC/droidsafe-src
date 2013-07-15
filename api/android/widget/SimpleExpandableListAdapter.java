package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import java.util.List;
import java.util.Map;

public class SimpleExpandableListAdapter extends BaseExpandableListAdapter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.590 -0400", hash_original_field = "035E16F29CDA719D867DE29B4F5284B7", hash_generated_field = "611E54FE69D6A51734B23ACE9D45487D")

    private List<? extends Map<String, ?>> mGroupData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.590 -0400", hash_original_field = "2D803F6321FFBA140DEDC790B00841EB", hash_generated_field = "29232D89B007E5845ED651666E71F7E5")

    private int mExpandedGroupLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.590 -0400", hash_original_field = "19F065E9F4502FD8BD4E0774A53B8ECA", hash_generated_field = "4ACE38296ABE9FF8B0D8B5F1CA7AAC83")

    private int mCollapsedGroupLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.590 -0400", hash_original_field = "3A6224430427F43CC581E224B913CDA3", hash_generated_field = "7657AAC628E0AED66031A87720EE14BF")

    private String[] mGroupFrom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.590 -0400", hash_original_field = "42FE03D924A915724B2AAD0E159514A0", hash_generated_field = "D29802DAAD0CD96400697E0FA27386FC")

    private int[] mGroupTo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.590 -0400", hash_original_field = "C1D2A81F373586752A4EDFF571BAFFAC", hash_generated_field = "CA27BAF20820F25F83F483D671CEEFD5")

    private List<? extends List<? extends Map<String, ?>>> mChildData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.590 -0400", hash_original_field = "C5E5DFAFB181975D75B0A925D11B002C", hash_generated_field = "3B28367C61855DFAB7FD9BAF80DDA1B4")

    private int mChildLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.590 -0400", hash_original_field = "0FF92EBE59A30A2A0A1D2F7E41F03768", hash_generated_field = "7A84288CA4669530FB7C66A4F2F4784B")

    private int mLastChildLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.590 -0400", hash_original_field = "8D0DCAE0DED6772202030EA5F3F3ACC7", hash_generated_field = "12E8B31CE0B217A1E808E5C36374BDCF")

    private String[] mChildFrom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.590 -0400", hash_original_field = "B51973EFD935C9A20D5C9774B58D2F03", hash_generated_field = "19640240BA0FE32753085D0DC0ABE6AF")

    private int[] mChildTo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.591 -0400", hash_original_field = "D03597FDEDE23F3823480E0520822BB2", hash_generated_field = "CBB0EE0A851756643DA52E1D33B6B161")

    private LayoutInflater mInflater;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.591 -0400", hash_original_method = "1707053CE8BCCF89B8DA20E3B0C31E90", hash_generated_method = "22595569D61D7B392039F05EB3E563D7")
    public  SimpleExpandableListAdapter(Context context,
            List<? extends Map<String, ?>> groupData, int groupLayout,
            String[] groupFrom, int[] groupTo,
            List<? extends List<? extends Map<String, ?>>> childData,
            int childLayout, String[] childFrom, int[] childTo) {
        this(context, groupData, groupLayout, groupLayout, groupFrom, groupTo, childData,
                childLayout, childLayout, childFrom, childTo);
        addTaint(childTo[0]);
        addTaint(childFrom[0].getTaint());
        addTaint(childLayout);
        addTaint(childData.getTaint());
        addTaint(groupTo[0]);
        addTaint(groupFrom[0].getTaint());
        addTaint(groupLayout);
        addTaint(groupData.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.592 -0400", hash_original_method = "34D445F41C1AC47E0D3B438B48C7B750", hash_generated_method = "B4925E7384717EF9D03149D74C376F4E")
    public  SimpleExpandableListAdapter(Context context,
            List<? extends Map<String, ?>> groupData, int expandedGroupLayout,
            int collapsedGroupLayout, String[] groupFrom, int[] groupTo,
            List<? extends List<? extends Map<String, ?>>> childData,
            int childLayout, String[] childFrom, int[] childTo) {
        this(context, groupData, expandedGroupLayout, collapsedGroupLayout,
                groupFrom, groupTo, childData, childLayout, childLayout,
                childFrom, childTo);
        addTaint(childTo[0]);
        addTaint(childFrom[0].getTaint());
        addTaint(childLayout);
        addTaint(childData.getTaint());
        addTaint(groupTo[0]);
        addTaint(groupFrom[0].getTaint());
        addTaint(collapsedGroupLayout);
        addTaint(expandedGroupLayout);
        addTaint(groupData.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.594 -0400", hash_original_method = "9B08A7CAFAE37727B01A163820667DFA", hash_generated_method = "96A969F5AD111940FF62A045AB9CE1BB")
    public  SimpleExpandableListAdapter(Context context,
            List<? extends Map<String, ?>> groupData, int expandedGroupLayout,
            int collapsedGroupLayout, String[] groupFrom, int[] groupTo,
            List<? extends List<? extends Map<String, ?>>> childData,
            int childLayout, int lastChildLayout, String[] childFrom,
            int[] childTo) {
        mGroupData = groupData;
        mExpandedGroupLayout = expandedGroupLayout;
        mCollapsedGroupLayout = collapsedGroupLayout;
        mGroupFrom = groupFrom;
        mGroupTo = groupTo;
        mChildData = childData;
        mChildLayout = childLayout;
        mLastChildLayout = lastChildLayout;
        mChildFrom = childFrom;
        mChildTo = childTo;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // ---------- Original Method ----------
        //mGroupData = groupData;
        //mExpandedGroupLayout = expandedGroupLayout;
        //mCollapsedGroupLayout = collapsedGroupLayout;
        //mGroupFrom = groupFrom;
        //mGroupTo = groupTo;
        //mChildData = childData;
        //mChildLayout = childLayout;
        //mLastChildLayout = lastChildLayout;
        //mChildFrom = childFrom;
        //mChildTo = childTo;
        //mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.594 -0400", hash_original_method = "3B29A9946FDE7DB2BC2B7FECDB06C302", hash_generated_method = "0BADA12351EC82A23B2E5AA45810BFC2")
    public Object getChild(int groupPosition, int childPosition) {
        addTaint(childPosition);
        addTaint(groupPosition);
Object varF4E472F530EEA6342931FA947EA4E3DB_1630149624 =         mChildData.get(groupPosition).get(childPosition);
        varF4E472F530EEA6342931FA947EA4E3DB_1630149624.addTaint(taint);
        return varF4E472F530EEA6342931FA947EA4E3DB_1630149624;
        // ---------- Original Method ----------
        //return mChildData.get(groupPosition).get(childPosition);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.595 -0400", hash_original_method = "D97177086C567E768212D7EB3B556195", hash_generated_method = "102C3190E8E01E2AA9CA385F1EF69B86")
    public long getChildId(int groupPosition, int childPosition) {
        addTaint(childPosition);
        addTaint(groupPosition);
        long var84D3B89E96B7ED6301A311E22EC81097_1672031128 = (childPosition);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1640108838 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1640108838;
        // ---------- Original Method ----------
        //return childPosition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.595 -0400", hash_original_method = "B5BC721CBE3E6381873586BBD7303E85", hash_generated_method = "87885A284EFEB82BC052D4B7CBB23383")
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
            View convertView, ViewGroup parent) {
        addTaint(parent.getTaint());
        addTaint(convertView.getTaint());
        addTaint(isLastChild);
        addTaint(childPosition);
        addTaint(groupPosition);
        View v;
    if(convertView == null)        
        {
            v = newChildView(isLastChild, parent);
        } //End block
        else
        {
            v = convertView;
        } //End block
        bindView(v, mChildData.get(groupPosition).get(childPosition), mChildFrom, mChildTo);
View var6DC76BC51820DD65E8396280E884AA78_853191126 =         v;
        var6DC76BC51820DD65E8396280E884AA78_853191126.addTaint(taint);
        return var6DC76BC51820DD65E8396280E884AA78_853191126;
        // ---------- Original Method ----------
        //View v;
        //if (convertView == null) {
            //v = newChildView(isLastChild, parent);
        //} else {
            //v = convertView;
        //}
        //bindView(v, mChildData.get(groupPosition).get(childPosition), mChildFrom, mChildTo);
        //return v;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.596 -0400", hash_original_method = "2B94AAD68C0284CF5F35BA4F8A812DF1", hash_generated_method = "8E9E994086023FB78AF6777BB3BA848A")
    public View newChildView(boolean isLastChild, ViewGroup parent) {
        addTaint(parent.getTaint());
        addTaint(isLastChild);
View varE89DA9D9E61A89C376400D709F3C6A62_1516319127 =         mInflater.inflate((isLastChild) ? mLastChildLayout : mChildLayout, parent, false);
        varE89DA9D9E61A89C376400D709F3C6A62_1516319127.addTaint(taint);
        return varE89DA9D9E61A89C376400D709F3C6A62_1516319127;
        // ---------- Original Method ----------
        //return mInflater.inflate((isLastChild) ? mLastChildLayout : mChildLayout, parent, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.596 -0400", hash_original_method = "8C1FB274099C6E014BD8D472B7606CCC", hash_generated_method = "35157A1CF793A1EDF5DDB9E3DB4D07CA")
    private void bindView(View view, Map<String, ?> data, String[] from, int[] to) {
        addTaint(to[0]);
        addTaint(from[0].getTaint());
        addTaint(data.getTaint());
        addTaint(view.getTaint());
        int len = to.length;
for(int i = 0;i < len;i++)
        {
            TextView v = (TextView)view.findViewById(to[i]);
    if(v != null)            
            {
                v.setText((String)data.get(from[i]));
            } //End block
        } //End block
        // ---------- Original Method ----------
        //int len = to.length;
        //for (int i = 0; i < len; i++) {
            //TextView v = (TextView)view.findViewById(to[i]);
            //if (v != null) {
                //v.setText((String)data.get(from[i]));
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.597 -0400", hash_original_method = "DB60A6F52FD4A812349DCBFAC6A2EF69", hash_generated_method = "4303A34F1A141E60049D9934A22C01F3")
    public int getChildrenCount(int groupPosition) {
        addTaint(groupPosition);
        int varBC42FEB3B9BBFFF4B151382DA91DDCB5_1131978886 = (mChildData.get(groupPosition).size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1896630329 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1896630329;
        // ---------- Original Method ----------
        //return mChildData.get(groupPosition).size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.597 -0400", hash_original_method = "5B52A8158602AE20A4F579EAAE50F913", hash_generated_method = "80A45BBEE961343A9CE7518EDD3B7CD3")
    public Object getGroup(int groupPosition) {
        addTaint(groupPosition);
Object varFB97261B2587C339E611EC0290582245_574721243 =         mGroupData.get(groupPosition);
        varFB97261B2587C339E611EC0290582245_574721243.addTaint(taint);
        return varFB97261B2587C339E611EC0290582245_574721243;
        // ---------- Original Method ----------
        //return mGroupData.get(groupPosition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.598 -0400", hash_original_method = "03F06DE167267E877853E48CD36FB25E", hash_generated_method = "80B46F90F8815C7F717B08AC69B05DBC")
    public int getGroupCount() {
        int varC6B62FA0B1852F78AF644C60F1A00840_894800416 = (mGroupData.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1374969896 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1374969896;
        // ---------- Original Method ----------
        //return mGroupData.size();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.598 -0400", hash_original_method = "F50F0A33E6E1377DC0B6921910BA68AA", hash_generated_method = "C2318CDAB44E709A757BA1457F10BB63")
    public long getGroupId(int groupPosition) {
        addTaint(groupPosition);
        long var9C6117705CE34CB15E85C3B060C9B3C1_992381989 = (groupPosition);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_609783687 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_609783687;
        // ---------- Original Method ----------
        //return groupPosition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.599 -0400", hash_original_method = "5DB7DDAF22073EDDFB746FC51BE4BAAE", hash_generated_method = "0DE68F39E044DD565ED244C000C56684")
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
            ViewGroup parent) {
        addTaint(parent.getTaint());
        addTaint(convertView.getTaint());
        addTaint(isExpanded);
        addTaint(groupPosition);
        View v;
    if(convertView == null)        
        {
            v = newGroupView(isExpanded, parent);
        } //End block
        else
        {
            v = convertView;
        } //End block
        bindView(v, mGroupData.get(groupPosition), mGroupFrom, mGroupTo);
View var6DC76BC51820DD65E8396280E884AA78_2054455674 =         v;
        var6DC76BC51820DD65E8396280E884AA78_2054455674.addTaint(taint);
        return var6DC76BC51820DD65E8396280E884AA78_2054455674;
        // ---------- Original Method ----------
        //View v;
        //if (convertView == null) {
            //v = newGroupView(isExpanded, parent);
        //} else {
            //v = convertView;
        //}
        //bindView(v, mGroupData.get(groupPosition), mGroupFrom, mGroupTo);
        //return v;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.599 -0400", hash_original_method = "F1834FC5D553230B29FB844FEC56B83F", hash_generated_method = "7D12234659A67A6EF56A25D7C938FA54")
    public View newGroupView(boolean isExpanded, ViewGroup parent) {
        addTaint(parent.getTaint());
        addTaint(isExpanded);
View varF23ED6A15665B35A3ACCEE938622D385_361442666 =         mInflater.inflate((isExpanded) ? mExpandedGroupLayout : mCollapsedGroupLayout,
                parent, false);
        varF23ED6A15665B35A3ACCEE938622D385_361442666.addTaint(taint);
        return varF23ED6A15665B35A3ACCEE938622D385_361442666;
        // ---------- Original Method ----------
        //return mInflater.inflate((isExpanded) ? mExpandedGroupLayout : mCollapsedGroupLayout,
                //parent, false);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.599 -0400", hash_original_method = "03906FE5F79D1C16D6358EAB518B811D", hash_generated_method = "BDFE47E85630762BC2CAB18732A7A308")
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        addTaint(childPosition);
        addTaint(groupPosition);
        boolean varB326B5062B2F0E69046810717534CB09_1163837163 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_928852196 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_928852196;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.600 -0400", hash_original_method = "047E07C1992C7400A48E08BF432AD584", hash_generated_method = "9AFDC67B1D633070C0BCD76AD18936A7")
    public boolean hasStableIds() {
        boolean varB326B5062B2F0E69046810717534CB09_1441366311 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1001674905 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1001674905;
        // ---------- Original Method ----------
        //return true;
    }

    
}

