/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2006 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SimpleExpandableListAdapter extends BaseExpandableListAdapter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.034 -0500", hash_original_field = "DCC83A353D601CD0A4E94CC77E93FD9D", hash_generated_field = "611E54FE69D6A51734B23ACE9D45487D")

    private List<? extends Map<String, ?>> mGroupData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.036 -0500", hash_original_field = "B0557CF6416849E3BBC146CBD32EE0B4", hash_generated_field = "29232D89B007E5845ED651666E71F7E5")

    private int mExpandedGroupLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.038 -0500", hash_original_field = "7764B05EBCD36D219F9EAE45C01B8096", hash_generated_field = "4ACE38296ABE9FF8B0D8B5F1CA7AAC83")

    private int mCollapsedGroupLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.040 -0500", hash_original_field = "B240F86D3AF6236264DEA56DD98767D3", hash_generated_field = "7657AAC628E0AED66031A87720EE14BF")

    private String[] mGroupFrom;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.042 -0500", hash_original_field = "E7DCF32FB3F8894F4B7C1A4DC20258C4", hash_generated_field = "D29802DAAD0CD96400697E0FA27386FC")

    private int[] mGroupTo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.044 -0500", hash_original_field = "D2624B5EE8EA5B76409574C61FCD5715", hash_generated_field = "CA27BAF20820F25F83F483D671CEEFD5")
    
    private List<? extends List<? extends Map<String, ?>>> mChildData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.047 -0500", hash_original_field = "E411898B9199DF6F8B109F615D9759C4", hash_generated_field = "3B28367C61855DFAB7FD9BAF80DDA1B4")

    private int mChildLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.049 -0500", hash_original_field = "F149F0167E8532D200025C337161E23F", hash_generated_field = "7A84288CA4669530FB7C66A4F2F4784B")

    private int mLastChildLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.051 -0500", hash_original_field = "E97422B08B6D6A8BDB33D1EAFB05B36D", hash_generated_field = "12E8B31CE0B217A1E808E5C36374BDCF")

    private String[] mChildFrom;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.053 -0500", hash_original_field = "D35DFDA2183C443B0E181E6730756AA7", hash_generated_field = "19640240BA0FE32753085D0DC0ABE6AF")

    private int[] mChildTo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.055 -0500", hash_original_field = "B03B4DAE3F576B7166425BEE37B96C5E", hash_generated_field = "CBB0EE0A851756643DA52E1D33B6B161")
    
    private LayoutInflater mInflater;
    
    /**
     * Constructor
     * 
     * @param context The context where the {@link ExpandableListView}
     *            associated with this {@link SimpleExpandableListAdapter} is
     *            running
     * @param groupData A List of Maps. Each entry in the List corresponds to
     *            one group in the list. The Maps contain the data for each
     *            group, and should include all the entries specified in
     *            "groupFrom"
     * @param groupFrom A list of keys that will be fetched from the Map
     *            associated with each group.
     * @param groupTo The group views that should display column in the
     *            "groupFrom" parameter. These should all be TextViews. The
     *            first N views in this list are given the values of the first N
     *            columns in the groupFrom parameter.
     * @param groupLayout resource identifier of a view layout that defines the
     *            views for a group. The layout file should include at least
     *            those named views defined in "groupTo"
     * @param childData A List of List of Maps. Each entry in the outer List
     *            corresponds to a group (index by group position), each entry
     *            in the inner List corresponds to a child within the group
     *            (index by child position), and the Map corresponds to the data
     *            for a child (index by values in the childFrom array). The Map
     *            contains the data for each child, and should include all the
     *            entries specified in "childFrom"
     * @param childFrom A list of keys that will be fetched from the Map
     *            associated with each child.
     * @param childTo The child views that should display column in the
     *            "childFrom" parameter. These should all be TextViews. The
     *            first N views in this list are given the values of the first N
     *            columns in the childFrom parameter.
     * @param childLayout resource identifier of a view layout that defines the
     *            views for a child. The layout file should include at least
     *            those named views defined in "childTo"
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.058 -0500", hash_original_method = "1707053CE8BCCF89B8DA20E3B0C31E90", hash_generated_method = "F5BD05065AC0BBA492D8CB8CE1A07961")
    
public SimpleExpandableListAdapter(Context context,
            List<? extends Map<String, ?>> groupData, int groupLayout,
            String[] groupFrom, int[] groupTo,
            List<? extends List<? extends Map<String, ?>>> childData,
            int childLayout, String[] childFrom, int[] childTo) {
        this(context, groupData, groupLayout, groupLayout, groupFrom, groupTo, childData,
                childLayout, childLayout, childFrom, childTo);
    }

    /**
     * Constructor
     * 
     * @param context The context where the {@link ExpandableListView}
     *            associated with this {@link SimpleExpandableListAdapter} is
     *            running
     * @param groupData A List of Maps. Each entry in the List corresponds to
     *            one group in the list. The Maps contain the data for each
     *            group, and should include all the entries specified in
     *            "groupFrom"
     * @param groupFrom A list of keys that will be fetched from the Map
     *            associated with each group.
     * @param groupTo The group views that should display column in the
     *            "groupFrom" parameter. These should all be TextViews. The
     *            first N views in this list are given the values of the first N
     *            columns in the groupFrom parameter.
     * @param expandedGroupLayout resource identifier of a view layout that
     *            defines the views for an expanded group. The layout file
     *            should include at least those named views defined in "groupTo"
     * @param collapsedGroupLayout resource identifier of a view layout that
     *            defines the views for a collapsed group. The layout file
     *            should include at least those named views defined in "groupTo"
     * @param childData A List of List of Maps. Each entry in the outer List
     *            corresponds to a group (index by group position), each entry
     *            in the inner List corresponds to a child within the group
     *            (index by child position), and the Map corresponds to the data
     *            for a child (index by values in the childFrom array). The Map
     *            contains the data for each child, and should include all the
     *            entries specified in "childFrom"
     * @param childFrom A list of keys that will be fetched from the Map
     *            associated with each child.
     * @param childTo The child views that should display column in the
     *            "childFrom" parameter. These should all be TextViews. The
     *            first N views in this list are given the values of the first N
     *            columns in the childFrom parameter.
     * @param childLayout resource identifier of a view layout that defines the
     *            views for a child. The layout file should include at least
     *            those named views defined in "childTo"
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.061 -0500", hash_original_method = "34D445F41C1AC47E0D3B438B48C7B750", hash_generated_method = "484914171DB2365F2D71E1F28E6561BE")
    
public SimpleExpandableListAdapter(Context context,
            List<? extends Map<String, ?>> groupData, int expandedGroupLayout,
            int collapsedGroupLayout, String[] groupFrom, int[] groupTo,
            List<? extends List<? extends Map<String, ?>>> childData,
            int childLayout, String[] childFrom, int[] childTo) {
        this(context, groupData, expandedGroupLayout, collapsedGroupLayout,
                groupFrom, groupTo, childData, childLayout, childLayout,
                childFrom, childTo);
    }

    /**
     * Constructor
     * 
     * @param context The context where the {@link ExpandableListView}
     *            associated with this {@link SimpleExpandableListAdapter} is
     *            running
     * @param groupData A List of Maps. Each entry in the List corresponds to
     *            one group in the list. The Maps contain the data for each
     *            group, and should include all the entries specified in
     *            "groupFrom"
     * @param groupFrom A list of keys that will be fetched from the Map
     *            associated with each group.
     * @param groupTo The group views that should display column in the
     *            "groupFrom" parameter. These should all be TextViews. The
     *            first N views in this list are given the values of the first N
     *            columns in the groupFrom parameter.
     * @param expandedGroupLayout resource identifier of a view layout that
     *            defines the views for an expanded group. The layout file
     *            should include at least those named views defined in "groupTo"
     * @param collapsedGroupLayout resource identifier of a view layout that
     *            defines the views for a collapsed group. The layout file
     *            should include at least those named views defined in "groupTo"
     * @param childData A List of List of Maps. Each entry in the outer List
     *            corresponds to a group (index by group position), each entry
     *            in the inner List corresponds to a child within the group
     *            (index by child position), and the Map corresponds to the data
     *            for a child (index by values in the childFrom array). The Map
     *            contains the data for each child, and should include all the
     *            entries specified in "childFrom"
     * @param childFrom A list of keys that will be fetched from the Map
     *            associated with each child.
     * @param childTo The child views that should display column in the
     *            "childFrom" parameter. These should all be TextViews. The
     *            first N views in this list are given the values of the first N
     *            columns in the childFrom parameter.
     * @param childLayout resource identifier of a view layout that defines the
     *            views for a child (unless it is the last child within a group,
     *            in which case the lastChildLayout is used). The layout file
     *            should include at least those named views defined in "childTo"
     * @param lastChildLayout resource identifier of a view layout that defines
     *            the views for the last child within each group. The layout
     *            file should include at least those named views defined in
     *            "childTo"
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.064 -0500", hash_original_method = "9B08A7CAFAE37727B01A163820667DFA", hash_generated_method = "D51DF074DCB296EAC99B3541E490DDE7")
    
public SimpleExpandableListAdapter(Context context,
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
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.066 -0500", hash_original_method = "3B29A9946FDE7DB2BC2B7FECDB06C302", hash_generated_method = "63EFEA7A0C0040A127AA8D1303DEECA8")
    
public Object getChild(int groupPosition, int childPosition) {
        return mChildData.get(groupPosition).get(childPosition);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.068 -0500", hash_original_method = "D97177086C567E768212D7EB3B556195", hash_generated_method = "370D335910A4246E725D3CB93CC19FB9")
    
public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.071 -0500", hash_original_method = "B5BC721CBE3E6381873586BBD7303E85", hash_generated_method = "4F3428878C329078BC674C39C436746C")
    
public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
            View convertView, ViewGroup parent) {
        View v;
        if (convertView == null) {
            v = newChildView(isLastChild, parent);
        } else {
            v = convertView;
        }
        bindView(v, mChildData.get(groupPosition).get(childPosition), mChildFrom, mChildTo);
        return v;
    }

    /**
     * Instantiates a new View for a child.
     * @param isLastChild Whether the child is the last child within its group.
     * @param parent The eventual parent of this new View.
     * @return A new child View
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.074 -0500", hash_original_method = "2B94AAD68C0284CF5F35BA4F8A812DF1", hash_generated_method = "9D308F535A65D6BE0D71D35DFF425D99")
    
public View newChildView(boolean isLastChild, ViewGroup parent) {
        return mInflater.inflate((isLastChild) ? mLastChildLayout : mChildLayout, parent, false);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.076 -0500", hash_original_method = "8C1FB274099C6E014BD8D472B7606CCC", hash_generated_method = "816AD0505AAE681738E5FF7413C939CA")
    
private void bindView(View view, Map<String, ?> data, String[] from, int[] to) {
        int len = to.length;

        for (int i = 0; i < len; i++) {
            TextView v = (TextView)view.findViewById(to[i]);
            if (v != null) {
                v.setText((String)data.get(from[i]));
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.078 -0500", hash_original_method = "DB60A6F52FD4A812349DCBFAC6A2EF69", hash_generated_method = "B3D6FA935961B507260E8F3955036BDE")
    
public int getChildrenCount(int groupPosition) {
        return mChildData.get(groupPosition).size();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.080 -0500", hash_original_method = "5B52A8158602AE20A4F579EAAE50F913", hash_generated_method = "D30975035A71F8DDC97B69D1F96D1362")
    
public Object getGroup(int groupPosition) {
        return mGroupData.get(groupPosition);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.082 -0500", hash_original_method = "03F06DE167267E877853E48CD36FB25E", hash_generated_method = "F208CB620028F535E603D8C5C8B1FCC9")
    
public int getGroupCount() {
        return mGroupData.size();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.084 -0500", hash_original_method = "F50F0A33E6E1377DC0B6921910BA68AA", hash_generated_method = "4FC615C8A10079EEE6BE289703B0123E")
    
public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.086 -0500", hash_original_method = "5DB7DDAF22073EDDFB746FC51BE4BAAE", hash_generated_method = "37B70F54DA1E3092B3F7FFC7B3023E98")
    
public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
            ViewGroup parent) {
        View v;
        if (convertView == null) {
            v = newGroupView(isExpanded, parent);
        } else {
            v = convertView;
        }
        bindView(v, mGroupData.get(groupPosition), mGroupFrom, mGroupTo);
        return v;
    }

    /**
     * Instantiates a new View for a group.
     * @param isExpanded Whether the group is currently expanded.
     * @param parent The eventual parent of this new View.
     * @return A new group View
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.088 -0500", hash_original_method = "F1834FC5D553230B29FB844FEC56B83F", hash_generated_method = "7F757EFF2EA2D46B47A3E605693E0E2C")
    
public View newGroupView(boolean isExpanded, ViewGroup parent) {
        return mInflater.inflate((isExpanded) ? mExpandedGroupLayout : mCollapsedGroupLayout,
                parent, false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.091 -0500", hash_original_method = "03906FE5F79D1C16D6358EAB518B811D", hash_generated_method = "E03DD5A22614C8BAB41B35BB562B596E")
    
public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:29.093 -0500", hash_original_method = "047E07C1992C7400A48E08BF432AD584", hash_generated_method = "E79C5A78A2EF753B72A06AEDBA4B0AA3")
    
public boolean hasStableIds() {
        return true;
    }
    
}

