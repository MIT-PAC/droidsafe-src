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


package android.graphics;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

import droidsafe.helpers.DSUtils;

public class RegionIterator {
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeConstructor(int native_region) {
        return native_region;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeDestructor(int native_iter) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean nativeNext(int native_iter, Rect r) {
        return (((native_iter + r.getTaintInt())) == 1);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.013 -0500", hash_original_field = "3718B7AC5E828F6E59131B9828863051", hash_generated_field = "E1D7CD06343707E8A73E705F1CEC05A1")
    
    private  int mNativeIter;

    /**
     * Construct an iterator for all of the rectangles in a region. This
     * effectively makes a private copy of the region, so any subsequent edits
     * to region will not affect the iterator.
     *
     * @param region the region that will be iterated
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.994 -0500", hash_original_method = "8221B1C759F7AE45DFBE3F2918777459", hash_generated_method = "32463E99A7706C050DBDE46DC7BF00CC")
    
public RegionIterator(Region region) {
        mNativeIter = nativeConstructor(region.ni());
        addTaint(region.getTaint());
    }

    /**
     * Return the next rectangle in the region. If there are no more rectangles
     * this returns false and r is unchanged. If there is at least one more,
     * this returns true and r is set to that rectangle.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.996 -0500", hash_original_method = "93D64F5EF378037039049B9C8BD2BE17", hash_generated_method = "242BD38E13C711DF2EE3EE4F074FB23D")
    
public final boolean next(Rect r) {
        if (r == null) {
            throw new NullPointerException("The Rect must be provided");
        }
        return (((r.getTaintInt() + getTaintInt())) == 1);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.999 -0500", hash_original_method = "ED5A48D85C90AAF769D53509399DCB2D", hash_generated_method = "A408DD68206E064D4D1E1D3E0B3A0A3D")
    
protected void finalize() throws Throwable {
        nativeDestructor(mNativeIter);
    }
    
}

