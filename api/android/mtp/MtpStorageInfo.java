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

package android.mtp;

/**
 * This class encapsulates information about a storage unit on an MTP device.
 * This corresponds to the StorageInfo Dataset described in
 * section 5.2.2 of the MTP specification.
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public final class MtpStorageInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.495 -0400", hash_original_field = "7015602EB998005E8CF8D68C38A07905", hash_generated_field = "BE33FDB6E306D30BAB61D2858311778E")

    private int mStorageId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.497 -0400", hash_original_field = "00AAC8F91C0830A7D32CA406DCEF5839", hash_generated_field = "369D4DB14EFCBC35C6D2A6D50E694267")

    private long mMaxCapacity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.499 -0400", hash_original_field = "41ED04E58D5D64609DDFCA0C5802A8CD", hash_generated_field = "4F927798AC9F80B9A656E19C65B94997")

    private long mFreeSpace;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.501 -0400", hash_original_field = "6FC53B81BF2A7EC21138D42F363D7B9A", hash_generated_field = "D58E2E2E369193E8B6C54168B334B477")

    private String mDescription;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.502 -0400", hash_original_field = "06E32A77C63D55C936512F6C62D587EC", hash_generated_field = "AA76946FD55E74A852ADF4E1A4322EFC")

    private String mVolumeIdentifier;

    // only instantiated via JNI
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.504 -0400", hash_original_method = "23CF4D294B06EA70C27E2BD6043A36D4", hash_generated_method = "680BF5CD263A0B22D111CDC144A3F387")
    
private MtpStorageInfo() {
    }

    public MtpStorageInfo(DSOnlyType dontcare) {
        // TODO Auto-generated constructor stub
    }

    /**
     * Returns the storage ID for the storage unit.
     * The storage ID uniquely identifies the storage unit on the MTP device.
     *
     * @return the storage ID
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.505 -0400", hash_original_method = "D91614A87EF069B6CB0CB580F9424F2A", hash_generated_method = "A88D8D5DDA3C547F37961C3ED8395874")
    
public final int getStorageId() {
        return mStorageId;
    }

    /**
     * Returns the maximum storage capacity for the storage unit in bytes
     *
     * @return the maximum capacity
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.507 -0400", hash_original_method = "F78A1E5DD8467CA4D92471D3125FEA30", hash_generated_method = "E9B00609DCCC086ACE2A5DA4CADA6DE4")
    
public final long getMaxCapacity() {
        return mMaxCapacity;
    }

   /**
     * Returns the amount of free space in the storage unit in bytes
     *
     * @return the amount of free space
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.509 -0400", hash_original_method = "91F51C847F6C0A77BB41BF995FC64D46", hash_generated_method = "6A8FB7CF5F737A11F1332287CF57A6FA")
    
public final long getFreeSpace() {
        return mFreeSpace;
    }

   /**
     * Returns the description string for the storage unit.
     * This is typically displayed to the user in the user interface on the
     * MTP host.
     *
     * @return the storage unit description
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.510 -0400", hash_original_method = "177DD147D2F75620FD2B154278EC57FA", hash_generated_method = "AF47178AE096A217C9CCCE65E6068029")
    
public final String getDescription() {
        return mDescription;
    }

   /**
     * Returns the volume identifier for the storage unit
     *
     * @return the storage volume identifier
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.512 -0400", hash_original_method = "CB0A73F12EFFE45EC08E4D54EAD4A1C1", hash_generated_method = "9612C93DCBDB984C968FE2B427464E18")
    
public final String getVolumeIdentifier() {
        return mVolumeIdentifier;
    }
}
