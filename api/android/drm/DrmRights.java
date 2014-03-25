/*
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

package android.drm;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.File;
import java.io.IOException;

/**
 * An entity class that wraps the license information retrieved from the online DRM server.
 *<p>
 * A caller can instantiate a {@link DrmRights} object by first invoking the
 * {@link DrmManagerClient#processDrmInfo(DrmInfo)} method and then using the resulting
 * {@link ProcessedData} object to invoke the {@link DrmRights#DrmRights(ProcessedData, String)}
 * constructor.
 *<p>
 * A caller can also instantiate a {@link DrmRights} object by using the
 * {@link DrmRights#DrmRights(String, String)} constructor, which takes a path to a file
 * containing rights information instead of a <code>ProcessedData</code>.
 *
 */
public class DrmRights {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.549 -0400", hash_original_field = "5D97F7C0534662C5183D05D4FFD1A145", hash_generated_field = "04254C7D5555806109D3DE22B9918A82")

    private byte[] mData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.552 -0400", hash_original_field = "B161F982909610C03B68BAACDD54E076", hash_generated_field = "D6D2783B71AE4BF9CBF84D44336E2BF9")

    private String mMimeType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.556 -0400", hash_original_field = "D85447A3CA37E6BCB07FCED67EBBB6FF", hash_generated_field = "7A86A43C33BF66D071802DDFE549C88A")

    private String mAccountId = "_NO_USER";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.560 -0400", hash_original_field = "8AD11C2EF1AD46756D0DD5A388DC782E", hash_generated_field = "E2CD0E0C8FF6E6D3CCC107CE26A69473")

    private String mSubscriptionId = "";

    /**
     * Creates a <code>DrmRights</code> object with the given parameters.
     *
     * @param rightsFilePath Path to the file containing rights information.
     * @param mimeType MIME type.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.565 -0400", hash_original_method = "652160DEF53E3BBE1ED93CBEB3A7D1BB", hash_generated_method = "5948DDAD675235BAE1B0C2892DC5524C")
    
public DrmRights(String rightsFilePath, String mimeType) {
        File file = new File(rightsFilePath);
        instantiate(file, mimeType);
    }

    /**
     * Creates a <code>DrmRights</code> object with the given parameters.
     *
     * @param rightsFilePath Path to the file containing rights information.
     * @param mimeType MIME type.
     * @param accountId Account ID of the user.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.568 -0400", hash_original_method = "34F2E20893495C248AAA527279176D19", hash_generated_method = "E5B45A238614C2486E076E403CBCD18A")
    
public DrmRights(String rightsFilePath, String mimeType, String accountId) {
        this(rightsFilePath, mimeType);

        if (null != accountId && !accountId.equals("")) {
            mAccountId = accountId;
        }
    }

    /**
     * Creates a <code>DrmRights</code> object with the given parameters.
     *
     * @param rightsFilePath Path to the file containing rights information.
     * @param mimeType MIME type.
     * @param accountId Account ID of the user.
     * @param subscriptionId Subscription ID of the user.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.572 -0400", hash_original_method = "36CDB225443323903BF114046866E066", hash_generated_method = "BB33C83B47BD29FADF0DC592C2DABCF7")
    
public DrmRights(
            String rightsFilePath, String mimeType, String accountId, String subscriptionId) {
        this(rightsFilePath, mimeType);

        if (null != accountId && !accountId.equals("")) {
            mAccountId = accountId;
        }

        if (null != subscriptionId && !subscriptionId.equals("")) {
            mSubscriptionId = subscriptionId;
        }
    }

    /**
     * Creates a <code>DrmRights</code> object with the given parameters.
     *
     * @param rightsFile File containing rights information.
     * @param mimeType MIME type.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.576 -0400", hash_original_method = "AFE1AB9895979A58E234511DD824F565", hash_generated_method = "1E311385B5DD82231D5435AC404C14C3")
    
public DrmRights(File rightsFile, String mimeType) {
        instantiate(rightsFile, mimeType);
    }

    /**
     * Creates a <code>DrmRights</code> object with the given parameters.
     *
     * @param data A {@link ProcessedData} object containing rights information.
     *             data could be null because it's optional for some DRM schemes.
     * @param mimeType The MIME type.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.584 -0400", hash_original_method = "CC6D837CE598E8BC305E85D0B3ED9F4F", hash_generated_method = "767362F700CAFF6AA5CF864DEB692F91")
    
public DrmRights(ProcessedData data, String mimeType) {
        if (data != null) {
            mData = data.getData();

            String accountId = data.getAccountId();
            if (null != accountId && !accountId.equals("")) {
                mAccountId = accountId;
            }

            String subscriptionId = data.getSubscriptionId();
            if (null != subscriptionId && !subscriptionId.equals("")) {
                mSubscriptionId = subscriptionId;
            }
        }

        mMimeType = mimeType;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.580 -0400", hash_original_method = "1C20803633D6C72361CE418A1D7EDF2B", hash_generated_method = "39E2FFF06C77E5472E5CB69C025081C0")
    
private void instantiate(File rightsFile, String mimeType) {
        try {
            mData = DrmUtils.readBytes(rightsFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        mMimeType = mimeType;
    }

    /**
     * Retrieves the rights data associated with this <code>DrmRights</code> object.
     *
     * @return A <code>byte</code> array representing the rights data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.587 -0400", hash_original_method = "C504E29872F6095FD50571727F895C6C", hash_generated_method = "1423D1AC5A60EA45821C0CD4527438BA")
    
public byte[] getData() {
        return mData;
    }

    /**
     * Retrieves the MIME type associated with this <code>DrmRights</code> object.
     *
     * @return The MIME type.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.590 -0400", hash_original_method = "FA5F1755E5361266828E073C873270CA", hash_generated_method = "B6BE0B3A83C82DC56DDAFE99F64DCDED")
    
public String getMimeType() {
        return mMimeType;
    }

    /**
     * Retrieves the account ID associated with this <code>DrmRights</code> object.
     *
     * @return The account ID.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.593 -0400", hash_original_method = "0B9378DA4AB5FA62031753B73B334A6F", hash_generated_method = "EBB18BC57CD71A5BD4A21C72F05F315A")
    
public String getAccountId() {
        return mAccountId;
    }

    /**
     * Retrieves the subscription ID associated with this <code>DrmRights</code> object.
     *
     * @return The subscription ID.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.596 -0400", hash_original_method = "F53118D105DE8E4736120FC1713993C8", hash_generated_method = "8D259E98E43E65A7337D025D518B9F4F")
    
public String getSubscriptionId() {
        return mSubscriptionId;
    }

    /**
     * Determines whether this instance is valid or not.
     *
     * @return True if valid; false if invalid.
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.600 -0400", hash_original_method = "3EB1A4F1628CAC368761882425F0BB03", hash_generated_method = "3EB1A4F1628CAC368761882425F0BB03")
    
boolean isValid() {
        return (null != mMimeType && !mMimeType.equals("")
                && null != mData && mData.length > 0);
    }
}

