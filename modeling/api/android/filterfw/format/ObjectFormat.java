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


package android.filterfw.format;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.filterfw.core.FrameFormat;
import android.filterfw.core.MutableFrameFormat;
import android.filterfw.core.NativeBuffer;

/**
 * @hide
 */
public class ObjectFormat {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.634 -0400", hash_original_method = "361A793060F74CC879764B1360DE85B9", hash_generated_method = "8008DFB38DA02C9DFB8FD59A43403E9E")
    
public static MutableFrameFormat fromClass(Class clazz, int count, int target) {
        // Create frame format
        MutableFrameFormat result = new MutableFrameFormat(FrameFormat.TYPE_OBJECT, target);
        result.setObjectClass(getBoxedClass(clazz));
        if (count != FrameFormat.SIZE_UNSPECIFIED) {
            result.setDimensions(count);
        }
        result.setBytesPerSample(bytesPerSampleForClass(clazz, target));
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.636 -0400", hash_original_method = "533BDE392720823218AE077FAAE0F83E", hash_generated_method = "80F7350B60A2F38C12DAFF9202A7D135")
    
public static MutableFrameFormat fromClass(Class clazz, int target) {
        return fromClass(clazz, FrameFormat.SIZE_UNSPECIFIED, target);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.638 -0400", hash_original_method = "302893D5658FAFF47C4435C76C133963", hash_generated_method = "86C0BEE692B8FBB52CDC5301587A8EA2")
    
public static MutableFrameFormat fromObject(Object object, int target) {
        return object == null
            ? new MutableFrameFormat(FrameFormat.TYPE_OBJECT, target)
            : fromClass(object.getClass(), FrameFormat.SIZE_UNSPECIFIED, target);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.641 -0400", hash_original_method = "58F1288CF1FAE25D93270C39519B8537", hash_generated_method = "FC57FFC3C2C6416D0C474C2379F23F46")
    
public static MutableFrameFormat fromObject(Object object, int count, int target) {
        return object == null
            ? new MutableFrameFormat(FrameFormat.TYPE_OBJECT, target)
            : fromClass(object.getClass(), count, target);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.643 -0400", hash_original_method = "0C3A12DF0C3240D4F74A3A7B067AB4DB", hash_generated_method = "FCFDE3C41405D593101925ED9C77949F")
    
private static int bytesPerSampleForClass(Class clazz, int target) {
        // Native targets have objects manifested in a byte buffer. Thus it is important to
        // correctly determine the size of single element here.
        if (target == FrameFormat.TARGET_NATIVE) {
            if (!NativeBuffer.class.isAssignableFrom(clazz)) {
                throw new IllegalArgumentException("Native object-based formats must be of a " +
                    "NativeBuffer subclass! (Received class: " + clazz + ").");
            }
            try {
                return ((NativeBuffer)clazz.newInstance()).getElementSize();
            } catch (Exception e) {
                throw new RuntimeException("Could not determine the size of an element in a "
                    + "native object-based frame of type " + clazz + "! Perhaps it is missing a "
                    + "default constructor?");
            }
        } else {
            return FrameFormat.BYTES_PER_SAMPLE_UNSPECIFIED;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.646 -0400", hash_original_method = "D67095AAC3D13A1D25EE1867CD63EF2F", hash_generated_method = "85FC61DCA26CCD1006F476BCB72CF273")
    
private static Class getBoxedClass(Class type) {
        // Check if type is primitive
        if (type.isPrimitive()) {
            // Yes -> box it
            if (type == boolean.class) {
                return java.lang.Boolean.class;
            } else if (type == byte.class) {
                return java.lang.Byte.class;
            } else if (type == char.class) {
                return java.lang.Character.class;
            } else if (type == short.class) {
                return java.lang.Short.class;
            } else if (type == int.class) {
                return java.lang.Integer.class;
            } else if (type == long.class) {
                return java.lang.Long.class;
            } else if (type == float.class) {
                return java.lang.Float.class;
            } else if (type == double.class) {
                return java.lang.Double.class;
            } else {
                throw new IllegalArgumentException(
                    "Unknown primitive type: " + type.getSimpleName() + "!");
            }
        } else {
            // No -> return it
            return type;
        }
    }
}
