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


package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface Parcelable {
    
    public static final int PARCELABLE_WRITE_RETURN_VALUE = 0x0001;
    
    public static final int CONTENTS_FILE_DESCRIPTOR = 0x0001;
    
    public int describeContents();

    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void writeToParcel(Parcel dest, int flags);
    
    public interface Creator<T> {
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
        public T createFromParcel(Parcel source);
        
        @DSVerified
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public T[] newArray(int size);
    }
    
    public interface ClassLoaderCreator<T> extends Creator<T> {
        @DSVerified
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public T createFromParcel(Parcel source, ClassLoader loader);
    }
}
