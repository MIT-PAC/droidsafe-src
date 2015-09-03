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
 * Copyright (C) 2007-2008 The Android Open Source Project
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package com.android.internal.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;

public final class InputBindResult implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.542 -0500", hash_original_field = "BA5BCA8C303D166D6B803DE7E673C244", hash_generated_field = "736115F46CE1FBBCCD2B323047A41AE5")

    static final String TAG = "InputBindResult";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.746 -0400", hash_original_field = "5B120F1D91D62CFFE41182DB1B3AC094", hash_generated_field = "FB8CFB6623F2A703564B3A10377DAF9A")

    public static final Parcelable.Creator<InputBindResult> CREATOR = new Parcelable.Creator<InputBindResult>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.564 -0500", hash_original_method = "0DC17695F8002017E94E8D176AF259A9", hash_generated_method = "937E7F387D0B7D759630C2249BA9D9B8")
        
public InputBindResult createFromParcel(Parcel source) {
            return new InputBindResult(source);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.566 -0500", hash_original_method = "95F5C3EE4EE7A3EB96C435695C7EF89F", hash_generated_method = "9DC6B082A9F770950D3BD8430F4B01CA")
        
public InputBindResult[] newArray(int size) {
            return new InputBindResult[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.544 -0500", hash_original_field = "B3DFD026D099A351FCE70ED5BA045C8F", hash_generated_field = "71A10845724278118CE924D88491742A")

    public  IInputMethodSession method;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.547 -0500", hash_original_field = "960D0AAB4FA1CF92AEC1F360608BDEE3", hash_generated_field = "8B7CEC29663CDE44174BD9618FC65EBC")

    public  String id;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.549 -0500", hash_original_field = "2CA2193047A8E20AE3472C21C95BEDE4", hash_generated_field = "AA45D51908C57BB809E4FBCC2CD22135")

    public  int sequence;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.552 -0500", hash_original_method = "42A6111FE2D2686864FA2FE8E1A98CEE", hash_generated_method = "189B622E857FF9E544F81A87A7DD40FB")
    
public InputBindResult(IInputMethodSession _method, String _id, int _sequence) {
        method = _method;
        id = _id;
        sequence = _sequence;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.555 -0500", hash_original_method = "26E767C4231C3DD46E94F9C79DE09374", hash_generated_method = "26E767C4231C3DD46E94F9C79DE09374")
    
InputBindResult(Parcel source) {
        method = IInputMethodSession.Stub.asInterface(source.readStrongBinder());
        id = source.readString();
        sequence = source.readInt();
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.557 -0500", hash_original_method = "7D3C8FC32444FE9148F633706CA9BDDA", hash_generated_method = "5E43558B9DEBFC2C0E8618A196B25843")
    
@Override
    public String toString() {
        return "InputBindResult{" + method + " " + id
                + " #" + sequence + "}";
    }

    /**
     * Used to package this object into a {@link Parcel}.
     * 
     * @param dest The {@link Parcel} to be written.
     * @param flags The flags used for parceling.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.559 -0500", hash_original_method = "D059CB42BC9C8F046048FBE3BCB19D52", hash_generated_method = "38E7A42AC58BA3DB1FC477C56AE3241E")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeStrongInterface(method);
        dest.writeString(id);
        dest.writeInt(sequence);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:30.570 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }
    // orphaned legacy method
    public InputBindResult createFromParcel(Parcel source) {
            return new InputBindResult(source);
        }
    
    // orphaned legacy method
    public InputBindResult[] newArray(int size) {
            return new InputBindResult[size];
        }
    
}

