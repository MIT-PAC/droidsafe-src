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
 * Copyright (C) 2007 The Android Open Source Project
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
import java.util.ArrayList;

class ExpandableListPosition {

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.519 -0500", hash_original_method = "F62027CF607D9C773A832245726377F9", hash_generated_method = "0EDAAA239E56E3025A3A7C8708AE6740")
    
static ExpandableListPosition obtainGroupPosition(int groupPosition) {
        return obtain(GROUP, groupPosition, 0, 0);
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.521 -0500", hash_original_method = "3BC06DD7BAAC54221802467D7ABA70B4", hash_generated_method = "7D00132CD7D625ACD9095D531AE25628")
    
static ExpandableListPosition obtainChildPosition(int groupPosition, int childPosition) {
        return obtain(CHILD, groupPosition, childPosition, 0);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.523 -0500", hash_original_method = "5FBB5616540ED7147D96F5EA87CDD381", hash_generated_method = "16EFAE12F0502E7E4169CA2300434A13")
    
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
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.525 -0500", hash_original_method = "349EA56CA9F69D1CACC3FF6BC3EC031E", hash_generated_method = "BAB573D7135C0F6404B48E82DD2925CF")
    
static ExpandableListPosition obtain(int type, int groupPos, int childPos, int flatListPos) {
        ExpandableListPosition elp = getRecycledOrCreate(); 
        elp.type = type;
        elp.groupPos = groupPos;
        elp.childPos = childPos;
        elp.flatListPos = flatListPos;
        return elp;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.528 -0500", hash_original_method = "3CE001A01E3340578213485CE2CE282A", hash_generated_method = "E96B19956B454CF64E593FF07678E85D")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.494 -0500", hash_original_field = "73A7DB4BA52C41C46FF2526949A8CECE", hash_generated_field = "7127A67374BF405D0F01EEB2429B1D48")
    
    private static final int MAX_POOL_SIZE = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.496 -0500", hash_original_field = "2497B91150CE738D981B2112EE504A93", hash_generated_field = "13B9F617BBB013357274E6300FD7AEA8")

    private static ArrayList<ExpandableListPosition> sPool =
        new ArrayList<ExpandableListPosition>(MAX_POOL_SIZE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.499 -0500", hash_original_field = "79E7C7881F4C946D076BEDD9E54FAC56", hash_generated_field = "F0F5C77DA98AF028C1257C33F37951DA")

    public final static int CHILD = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.501 -0500", hash_original_field = "51523F875D831FDC9782F54DC1DEA0FF", hash_generated_field = "4F320263FDA19E11C7632EEC3F961D53")

    public final static int GROUP = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.503 -0500", hash_original_field = "8D09A429544F3F96BAF7D186AB509F75", hash_generated_field = "2301C40FE9B33471D945A5226ECAAB38")

    public int groupPos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.505 -0500", hash_original_field = "9EA5543E65769251227F2A954E26F94A", hash_generated_field = "60A49C0AC4F2F0436AB7AB0C7B3140B6")

    public int childPos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.507 -0500", hash_original_field = "ABD45EB65AB80D8EB9E3EA196D9D59D5", hash_generated_field = "ABD45EB65AB80D8EB9E3EA196D9D59D5")

    int flatListPos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.510 -0500", hash_original_field = "961B4204667A4AE2FF8DD374E6728ADE", hash_generated_field = "6AC5CE4BE311ED1283E9BD812937901E")

    public int type;
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.514 -0500", hash_original_method = "AC719FEF152399BDA1BD5A5CA7FBB765", hash_generated_method = "651159CE316F03AD89288A0F5D8A9D64")
    
private ExpandableListPosition() {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.512 -0500", hash_original_method = "6E7C899DC67219985BD699CC84AD95E6", hash_generated_method = "BEC0D5BA67FE24EBC17F3819B1BC262B")
    
private void resetState() {
        groupPos = 0;
        childPos = 0;
        flatListPos = 0;
        type = 0;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.517 -0500", hash_original_method = "C8676DC8E5CB906E204449634591A777", hash_generated_method = "C8676DC8E5CB906E204449634591A777")
    
long getPackedPosition() {
        if (type == CHILD) return ExpandableListView.getPackedPositionForChild(groupPos, childPos);
        else return ExpandableListView.getPackedPositionForGroup(groupPos);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.530 -0500", hash_original_method = "8A154BA1D9B394A3D67E04E6A86589B2", hash_generated_method = "D64E89134CFC371784818AC6DB037546")
    
public void recycle() {
        synchronized (sPool) {
            if (sPool.size() < MAX_POOL_SIZE) {
                sPool.add(this);
            }
        }
    }
}

