/*
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

package android.mtp;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.os.storage.StorageVolume;

/**
 * This class represents a storage unit on an MTP device.
 * Used only for MTP support in USB responder mode.
 * MtpStorageInfo is used in MTP host mode
 *
 * @hide
 */
public class MtpStorage {

    /**
     * Generates a storage ID for storage of given index.
     * Index 0 is for primary external storage
     *
     * @return the storage ID
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.325 -0400", hash_original_method = "22F2A591F64E66737ED736D625F8452A", hash_generated_method = "6A0FFB9DCB9B776705A23F08EEADAB76")
    
public static int getStorageId(int index) {
        // storage ID is 0x00010001 for primary storage,
        // then 0x00020001, 0x00030001, etc. for secondary storages
        return ((index + 1) << 16) + 1;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.307 -0400", hash_original_field = "7015602EB998005E8CF8D68C38A07905", hash_generated_field = "BE33FDB6E306D30BAB61D2858311778E")


    private  int mStorageId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.309 -0400", hash_original_field = "1D4D0FAE668EECF10ED75DDC284FFC16", hash_generated_field = "6FACC3B41470C8330B5F0BB43FA7FD9F")

    private  String mPath;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.311 -0400", hash_original_field = "6FC53B81BF2A7EC21138D42F363D7B9A", hash_generated_field = "D58E2E2E369193E8B6C54168B334B477")

    private  String mDescription;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.312 -0400", hash_original_field = "805C991595FFFF13D468AEBE7266ABD3", hash_generated_field = "6868F134263C4CFE9CAD638F2A1B2EA9")

    private  long mReserveSpace;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.316 -0400", hash_original_field = "696798CD45B23CF8083C2B5D225854FB", hash_generated_field = "57B6957FF069933A34A8E50356617F8D")

    private  boolean mRemovable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.318 -0400", hash_original_field = "B4DF076C80EC235681E863FB3B792301", hash_generated_field = "3759AF9F2CB67BE0B7EF12E3261B6410")

    private  long mMaxFileSize;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.321 -0400", hash_original_method = "9B91A7CCEE1592A21CE71232825501E6", hash_generated_method = "FB828098DAB2522C1C44A9163CEAFD1F")
    
public MtpStorage(StorageVolume volume) {
        mStorageId = volume.getStorageId();
        mPath = volume.getPath();
        mDescription = volume.getDescription();
        mReserveSpace = volume.getMtpReserveSpace();
        mRemovable = volume.isRemovable();
        mMaxFileSize = volume.getMaxFileSize();
    }

    /**
     * Returns the storage ID for the storage unit
     *
     * @return the storage ID
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.323 -0400", hash_original_method = "D91614A87EF069B6CB0CB580F9424F2A", hash_generated_method = "A88D8D5DDA3C547F37961C3ED8395874")
    
public final int getStorageId() {
        return mStorageId;
    }

   /**
     * Returns the file path for the storage unit's storage in the file system
     *
     * @return the storage file path
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.327 -0400", hash_original_method = "F177C5B02553C0E0327F321BDDCEAFD5", hash_generated_method = "571136F21505319981CAF88E560329CE")
    
public final String getPath() {
        return mPath;
    }

   /**
     * Returns the description string for the storage unit
     *
     * @return the storage unit description
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.328 -0400", hash_original_method = "177DD147D2F75620FD2B154278EC57FA", hash_generated_method = "AF47178AE096A217C9CCCE65E6068029")
    
public final String getDescription() {
        return mDescription;
    }

   /**
     * Returns the amount of space to reserve on the storage file system.
     * This can be set to a non-zero value to prevent MTP from filling up the entire storage.
     *
     * @return the storage unit description
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.330 -0400", hash_original_method = "643C6873B8FBA5A0BDB5DC5F040A4AC1", hash_generated_method = "A31C278530442068C9703FDD4F9CC1C8")
    
public final long getReserveSpace() {
        return mReserveSpace;
    }

   /**
     * Returns true if the storage is removable.
     *
     * @return is removable
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.331 -0400", hash_original_method = "C8355C5823499E966C6E9C9BBED7B59B", hash_generated_method = "9159C99DD868B027F6EA2DFF5B80A576")
    
public final boolean isRemovable() {
        return mRemovable;
    }

   /**
     * Returns maximum file size for the storage, or zero if it is unbounded.
     *
     * @return maximum file size
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:21.333 -0400", hash_original_method = "F3A7583351778AC1576078A1D9F37684", hash_generated_method = "22342D3197EC7B5656813A600C785D5C")
    
public long getMaxFileSize() {
        return mMaxFileSize;
    }
}
