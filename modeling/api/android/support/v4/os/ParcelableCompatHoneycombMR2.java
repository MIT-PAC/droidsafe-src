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
 * Copyright (C) 2011 The Android Open Source Project
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


package android.support.v4.os;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.os.Parcel;
import android.os.Parcelable;

class ParcelableCompatCreatorHoneycombMR2Stub {
    @DSSafe(DSCat.SAFE_LIST)
    static <T> Parcelable.Creator<T> instantiate(ParcelableCompatCreatorCallbacks<T> callbacks) {
        return new ParcelableCompatCreatorHoneycombMR2<T>(callbacks);
    }
}

class ParcelableCompatCreatorHoneycombMR2<T> implements Parcelable.ClassLoaderCreator<T> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:55:56.125 -0500", hash_original_field = "BE8C2310A42C4AF4CAB9F639C1E3BDCF", hash_generated_field = "9BB02B023178A1524000C6B48D874A89")

    private  ParcelableCompatCreatorCallbacks<T> mCallbacks;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:55:56.126 -0500", hash_original_method = "6B4EA7F5329B9AD7AB24C24081C5781B", hash_generated_method = "EFC4D9F60004D73746F7E3E14F0D6D06")
    @DSSafe(DSCat.SAFE_LIST)
    
public ParcelableCompatCreatorHoneycombMR2(ParcelableCompatCreatorCallbacks<T> callbacks) {
        mCallbacks = callbacks;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:55:56.127 -0500", hash_original_method = "52A728D45CED91BA6B017F7FCEEE53FB", hash_generated_method = "89D844B06D3C2CADBA949A9CE0796070")
    
public T createFromParcel(Parcel in) {
        return mCallbacks.createFromParcel(in, null);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:55:56.128 -0500", hash_original_method = "A7CE79B4A20BAA4EA8FDFB810F2AE2AD", hash_generated_method = "D170AF0E8C4238F0C6694A57558F704F")
    
public T createFromParcel(Parcel in, ClassLoader loader) {
        return mCallbacks.createFromParcel(in, loader);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:55:56.129 -0500", hash_original_method = "5AB872DFD1AEB45ECC63ABABFF71FE11", hash_generated_method = "AD0C03D4514BA515FAA23549907CF8C4")
    @DSSafe(DSCat.SAFE_LIST)
    
public T[] newArray(int size) {
        return mCallbacks.newArray(size);
    }
}
