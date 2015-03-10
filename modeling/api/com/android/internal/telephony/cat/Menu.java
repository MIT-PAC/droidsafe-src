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


package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class Menu implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.446 -0400", hash_original_field = "F280FAF502E3EC830C212739EA877C0E", hash_generated_field = "55BC0B4641874E81A5D070AF9C451A82")

    public static final Parcelable.Creator<Menu> CREATOR = new Parcelable.Creator<Menu>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.349 -0500", hash_original_method = "B445093B170171BD842D7C958982DF35", hash_generated_method = "5C3E027DD36916072C7B7E47CAD26C6C")
        
public Menu createFromParcel(Parcel in) {
            return new Menu(in);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.351 -0500", hash_original_method = "F22AD3E8083B6C85A43FA20A727DB120", hash_generated_method = "BEE442E1D4E4AB2586D4414202649923")
        
public Menu[] newArray(int size) {
            return new Menu[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.314 -0500", hash_original_field = "504AB3FB1E5B1C39FB8CA7492E7C6B08", hash_generated_field = "476ABB1F52C3A12124EEACDB58E8E189")

    public List<Item> items;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.316 -0500", hash_original_field = "979E482D9831581A45DDD209FF980757", hash_generated_field = "5A5E763DDA809E466D258B0BEF7B3CF1")

    public List<TextAttribute> titleAttrs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.319 -0500", hash_original_field = "166115DA03D971570A0FC8CC753D1E33", hash_generated_field = "CB58C9A657B05B968317B537DCD37634")

    public PresentationType presentationType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.321 -0500", hash_original_field = "4634D43F1F56446A3D3F34FA20A1C19C", hash_generated_field = "8A90568C6E332919F11E323BA0057155")

    public String title;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.323 -0500", hash_original_field = "2736371919AC28397CB841134FC8E95D", hash_generated_field = "098A35A0443838BE0B42D9CC5F647B03")

    public Bitmap titleIcon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.325 -0500", hash_original_field = "15E0DE2D0029CCDD6916F8F2FAB47533", hash_generated_field = "3A0377EDF9C782CB4D4BFE39FE615D31")

    public int defaultItem;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.327 -0500", hash_original_field = "83179DB1BA936E31D88CB8410C1F467F", hash_generated_field = "C7573512761AE15B4F2E1EC9799C356F")

    public boolean softKeyPreferred;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.330 -0500", hash_original_field = "E131DAF35CC59A8CEE38290A7F7F7AD8", hash_generated_field = "B089F8BA7DD3EF733FF9A54CE2F03291")

    public boolean helpAvailable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.332 -0500", hash_original_field = "67C2A8BAB6DA288843B165A591D8B125", hash_generated_field = "0FAF24D8129D04267CF76644994A3196")

    public boolean titleIconSelfExplanatory;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.334 -0500", hash_original_field = "14AC6A8C0B4E6DDC2771F4AD3E015538", hash_generated_field = "6B371AD473F156CDACB463C287BE9F73")

    public boolean itemsIconSelfExplanatory;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.337 -0500", hash_original_method = "2E99B961E06FFBDF1C6EFBD0F84C03B4", hash_generated_method = "A963A89D2776C4758E3A6BD8BB0ADD34")
    
public Menu() {
        // Create an empty list.
        items = new ArrayList<Item>();
        title = null;
        titleAttrs = null;
        defaultItem = 0;
        softKeyPreferred = false;
        helpAvailable = false;
        titleIconSelfExplanatory = false;
        itemsIconSelfExplanatory = false;
        titleIcon = null;
        // set default style to be navigation menu.
        presentationType = PresentationType.NAVIGATION_OPTIONS;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.340 -0500", hash_original_method = "170B02CF9C000CCCFFA0390811062CB3", hash_generated_method = "140E64DEF93781CA196625408970BCC4")
    
private Menu(Parcel in) {
        title = in.readString();
        titleIcon = in.readParcelable(null);
        // rebuild items list.
        items = new ArrayList<Item>();
        int size = in.readInt();
        for (int i=0; i<size; i++) {
            Item item = in.readParcelable(null);
            items.add(item);
        }
        defaultItem = in.readInt();
        softKeyPreferred = in.readInt() == 1 ? true : false;
        helpAvailable = in.readInt() == 1 ? true : false;
        titleIconSelfExplanatory = in.readInt() == 1 ? true : false;
        itemsIconSelfExplanatory = in.readInt() == 1 ? true : false;
        presentationType = PresentationType.values()[in.readInt()];
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.343 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.346 -0500", hash_original_method = "B96ACF1C9395307298AAD1BDB077B52A", hash_generated_method = "BBD87D434EAE7BDE803BA8138E825E35")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeParcelable(titleIcon, flags);
        // write items list to the parcel.
        int size = items.size();
        dest.writeInt(size);
        for (int i=0; i<size; i++) {
            dest.writeParcelable(items.get(i), flags);
        }
        dest.writeInt(defaultItem);
        dest.writeInt(softKeyPreferred ? 1 : 0);
        dest.writeInt(helpAvailable ? 1 : 0);
        dest.writeInt(titleIconSelfExplanatory ? 1 : 0);
        dest.writeInt(itemsIconSelfExplanatory ? 1 : 0);
        dest.writeInt(presentationType.ordinal());
    }
    // orphaned legacy method
    public Menu createFromParcel(Parcel in) {
            return new Menu(in);
        }
    
    // orphaned legacy method
    public Menu[] newArray(int size) {
            return new Menu[size];
        }
    
}

