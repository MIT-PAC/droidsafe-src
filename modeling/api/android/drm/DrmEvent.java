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
 * Copyright (C) 2010 The Android Open Source Project
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


package android.drm;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.HashMap;

/**
 * A base class that is used to send asynchronous event information from the DRM framework.
 *
 */
public class DrmEvent {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:51.291 -0400", hash_original_field = "DD0D2F312F76BF2DAE7836856C86A58A", hash_generated_field = "983FD6B7F9E9F53A192E856D20D03832")

    public static final int TYPE_ALL_RIGHTS_REMOVED = 1001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:51.302 -0400", hash_original_field = "DD3E078DDF69FA02E6F89EF00BEC14D1", hash_generated_field = "54CE7BA8DF7FEAA73BBF7684AC8B4C46")

    public static final int TYPE_DRM_INFO_PROCESSED = 1002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:51.309 -0400", hash_original_field = "4ED90EFD2A6F270F4C3D38B6B2A40753", hash_generated_field = "02F20BB5218BF7641A7702288E261D43")

    public static final String DRM_INFO_STATUS_OBJECT = "drm_info_status_object";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:51.317 -0400", hash_original_field = "16AC93FD857E6005808776A1EB50FBB5", hash_generated_field = "07708B2A4F85B77C3CDE0842ABD90F5A")

    public static final String DRM_INFO_OBJECT = "drm_info_object";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:51.324 -0400", hash_original_field = "9F92F4106274D2629F33867183512BB7", hash_generated_field = "702EBB63B52AE60657B34C8A34DF32C2")


    private  int mUniqueId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:51.343 -0400", hash_original_field = "B93BF1EFA6B57CC598632E54B97CD147", hash_generated_field = "E6B4AC7A48E0E54E09A504C828AF50C5")

    private  int mType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:51.350 -0400", hash_original_field = "0C1A8F98E602F0D42E4960320636CCFE", hash_generated_field = "890DBBD1EDBB8775F5F0E7ED80F30A0D")

    private String mMessage = "";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:51.356 -0400", hash_original_field = "A34CBC9E86E2520F982C4272FE041EA9", hash_generated_field = "3ED0C18D2B4A717F824F7F159DF62E96")


    private HashMap<String, Object> mAttributes = new HashMap<String, Object>();

    /**
     * Creates a <code>DrmEvent</code> object with the specified parameters.
     *
     * @param uniqueId Unique session identifier.
     * @param type Type of information.
     * @param message Message description.
     * @param attributes Attributes for extensible information.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:51.366 -0400", hash_original_method = "995562A88AB64E96C6246F34F5EFC890", hash_generated_method = "29CC6ED3C9950F5F3090A7D5209533A8")
    
protected DrmEvent(int uniqueId, int type, String message,
                            HashMap<String, Object> attributes) {
        mUniqueId = uniqueId;
        mType = type;

        if (null != message) {
            mMessage = message;
        }

        if (null != attributes) {
            mAttributes = attributes;
        }
    }

    /**
     * Creates a <code>DrmEvent</code> object with the specified parameters.
     *
     * @param uniqueId Unique session identifier.
     * @param type Type of information.
     * @param message Message description.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:51.375 -0400", hash_original_method = "3CBD59E51BDF71619DF7A535106C8B20", hash_generated_method = "727D3B804ABECC8E1705A29B02DBA6A9")
    
protected DrmEvent(int uniqueId, int type, String message) {
        mUniqueId = uniqueId;
        mType = type;

        if (null != message) {
            mMessage = message;
        }
    }

    /**
     * Retrieves the unique session identifier associated with this object.
     *
     * @return The unique session identifier.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:51.381 -0400", hash_original_method = "F64F21D16CFD05D4B80E501A354D44C1", hash_generated_method = "452A32334F84E7C77E7566A2CF2A80D9")
    
public int getUniqueId() {
        return mUniqueId;
    }

    /**
     * Retrieves the type of information that is associated with this object.
     *
     * @return The type of information.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:51.387 -0400", hash_original_method = "E9AD68D49398B2B9D86D12D221B14582", hash_generated_method = "32498FCDA3AC1E9A676800B51A331335")
    
public int getType() {
        return mType;
    }

    /**
     * Retrieves the message description associated with this object.
     *
     * @return The message description.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:51.393 -0400", hash_original_method = "6EBB1473E095A80ACB1399AB9A519C96", hash_generated_method = "FBCB535BB4259E7ACE32319681F8DAA5")
    
public String getMessage() {
        return mMessage;
    }

    /**
     * Retrieves the attribute associated with the specified key.
     *
     * @return One of the attributes or null if no mapping for
     * the key is found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:51.399 -0400", hash_original_method = "632178A3AB488B5415291C8B0F24618D", hash_generated_method = "53FF1439E1B3FA7CFC38F2E165A1648B")
    
public Object getAttribute(String key) {
        return mAttributes.get(key);
    }
}
