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

/**
 * An entity class that wraps the result of a 
 * {@link DrmManagerClient#processDrmInfo(DrmInfo) processDrmInfo()}
 * transaction between a device and a DRM server.
 *
 * In a license acquisition scenario this class holds the rights information in binary form.
 *
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class ProcessedData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.854 -0400", hash_original_field = "5D97F7C0534662C5183D05D4FFD1A145", hash_generated_field = "04254C7D5555806109D3DE22B9918A82")

    private  byte[] mData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.857 -0400", hash_original_field = "D85447A3CA37E6BCB07FCED67EBBB6FF", hash_generated_field = "7A86A43C33BF66D071802DDFE549C88A")

    private String mAccountId = "_NO_USER";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.861 -0400", hash_original_field = "8AD11C2EF1AD46756D0DD5A388DC782E", hash_generated_field = "E2CD0E0C8FF6E6D3CCC107CE26A69473")

    private String mSubscriptionId = "";

    /**
     * Creates a <code>ProcessedData</code> object with the given parameters.
     *
     * @param data Rights data.
     * @param accountId Account ID of the user.
     */
    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.864 -0400", hash_original_method = "90E92362AB1D9096EC0423D1327115A2", hash_generated_method = "90E92362AB1D9096EC0423D1327115A2")
    
ProcessedData(byte[] data, String accountId) {
        mData = data;
        mAccountId = accountId;
    }

    /**
     * Creates a <code>ProcessedData</code> object with the given parameters.
     *
     * @param data Rights data.
     * @param accountId Account ID of the user.
     * @param subscriptionId Subscription ID of the user.
     */
    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.867 -0400", hash_original_method = "1762D1065F3B8BFF5FE334F57DD796D3", hash_generated_method = "1762D1065F3B8BFF5FE334F57DD796D3")
    
ProcessedData(byte[] data, String accountId, String subscriptionId) {
        mData = data;
        mAccountId = accountId;
        mSubscriptionId = subscriptionId;
    }

    /**
     * Retrieves the processed data.
     *
     * @return The rights data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.870 -0400", hash_original_method = "C504E29872F6095FD50571727F895C6C", hash_generated_method = "1423D1AC5A60EA45821C0CD4527438BA")
    
public byte[] getData() {
        return mData;
    }

    /**
     * Retrieves the account ID associated with this object.
     *
     * @return The account ID of the user.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.873 -0400", hash_original_method = "0B9378DA4AB5FA62031753B73B334A6F", hash_generated_method = "EBB18BC57CD71A5BD4A21C72F05F315A")
    
public String getAccountId() {
        return mAccountId;
    }

    /**
     * Returns the subscription ID associated with this object.
     *
     * @return The subscription ID of the user.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.875 -0400", hash_original_method = "F53118D105DE8E4736120FC1713993C8", hash_generated_method = "8D259E98E43E65A7337D025D518B9F4F")
    
public String getSubscriptionId() {
        return mSubscriptionId;
    }
}

