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


package android.filterfw.core;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.filterfw.core.FrameFormat;
import android.filterfw.core.KeyValueMap;

import java.util.Arrays;

/**
 * @hide
 */
public class MutableFrameFormat extends FrameFormat {

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.670 -0400", hash_original_method = "DC9C26E6E459CEACEF6CAC640B451B3E", hash_generated_method = "5D855EA98210374D9D4D8B8DDD840354")
    
public MutableFrameFormat() {
        super();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.672 -0400", hash_original_method = "DC086D0A9893C10FECEAEF6001518C4A", hash_generated_method = "7ED9926DDDACF473E18E0D92781F1658")
    
public MutableFrameFormat(int baseType, int target) {
        super(baseType, target);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.674 -0400", hash_original_method = "1411598D6247A0FE5E04A334A06A5794", hash_generated_method = "4FE1EBEEF426A7D1421CC22D5BFA80E0")
    
public void setBaseType(int baseType) {
        mBaseType = baseType;
        mBytesPerSample = bytesPerSampleOf(baseType);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.676 -0400", hash_original_method = "B6B847D962B2E7BEFE10566CE43F18AB", hash_generated_method = "4950A56AE5B3867F72D9846CFB253944")
    
public void setTarget(int target) {
        mTarget = target;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.678 -0400", hash_original_method = "D3081A06EEE4D72A3F243CF9FA020E8A", hash_generated_method = "3D5C9E0056FC4D2B7354E223B7D3C4F4")
    
public void setBytesPerSample(int bytesPerSample) {
        mBytesPerSample = bytesPerSample;
        mSize = SIZE_UNKNOWN;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.680 -0400", hash_original_method = "0DE954A39606806CB9645C7D0C9B934A", hash_generated_method = "5E4FA11D84AEA8EA1CB4EDAD70E92C91")
    
public void setDimensions(int[] dimensions) {
        mDimensions = (dimensions == null) ? null : Arrays.copyOf(dimensions, dimensions.length);
        mSize = SIZE_UNKNOWN;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.681 -0400", hash_original_method = "2556BAD6B63F5888C45A1DADF9CEEA5E", hash_generated_method = "608CA08920DBEE26C9F9BC0B515BF346")
    
public void setDimensions(int size) {
        int[] dimensions = new int[1];
        dimensions[0] = size;
        mDimensions = dimensions;
        mSize = SIZE_UNKNOWN;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.683 -0400", hash_original_method = "56C03ABE40F03ED7EA4571C56F9798C5", hash_generated_method = "95666374821CCBEDA78713A98B0E439C")
    
public void setDimensions(int width, int height) {
        int[] dimensions = new int[2];
        dimensions[0] = width;
        dimensions[1] = height;
        mDimensions = dimensions;
        mSize = SIZE_UNKNOWN;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.686 -0400", hash_original_method = "AFCA0EAAA720D84AE0F5A75B3D47E2C1", hash_generated_method = "E23B58FC654FA080BDC9F38FB2714C17")
    
public void setDimensions(int width, int height, int depth) {
        int[] dimensions = new int[3];
        dimensions[0] = width;
        dimensions[1] = height;
        dimensions[2] = depth;
        mDimensions = dimensions;
        mSize = SIZE_UNKNOWN;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.688 -0400", hash_original_method = "889FB39DDAE9F8BAC65CF11250F679E8", hash_generated_method = "5C38CEDC521325E7750F3AB0C78C0FD2")
    
public void setDimensionCount(int count) {
        mDimensions = new int[count];
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.690 -0400", hash_original_method = "CF86A5EB17FC548364BC120DEFD98A74", hash_generated_method = "F5721E0512A1955AB3BCB9C0955370AC")
    
public void setObjectClass(Class objectClass) {
        mObjectClass = objectClass;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.692 -0400", hash_original_method = "86A26BEA8E75A786A0E7447C0C9A028C", hash_generated_method = "22B48A82DF0F31B14D579D0596C157BC")
    
public void setMetaValue(String key, Object value) {
        if (mMetaData == null) {
            mMetaData = new KeyValueMap();
        }
        mMetaData.put(key, value);
    }

}
