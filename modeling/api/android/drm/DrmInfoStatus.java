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

/**
 * An entity class that wraps the result of communication between a device and an online DRM
 * server. Specifically, when the {@link DrmManagerClient#processDrmInfo processDrmInfo()} method
 * is called, an instance of <code>DrmInfoStatus</code> is returned.
 *<p>
 * This class contains the {@link ProcessedData} object, which can be used to instantiate a
 * {@link DrmRights} object during license acquisition.
 *
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class DrmInfoStatus {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.931 -0400", hash_original_field = "00B954A1128F1A6475853AA1EC8B2314", hash_generated_field = "BB9C33EF47F6BCD2FC0D2F2F6B4CC698")

    public static final int STATUS_OK = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.935 -0400", hash_original_field = "3DB08E6EC1EC14D2AEF91CCF54DBF5DC", hash_generated_field = "295455569744D62AC64C1785BE5FE748")

    public static final int STATUS_ERROR = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.939 -0400", hash_original_field = "7D58E974091311E54CFA3738B5F585EF", hash_generated_field = "45DE62900D5728D18C3A5DCF87BD5FE8")

    public  int statusCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.942 -0400", hash_original_field = "FC3C83CAFEBB612A854DA07ADFA0AFE8", hash_generated_field = "3D6B1892A2C73E244598D27D91CED8F4")

    public  int infoType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.946 -0400", hash_original_field = "199378A118748448CD8C8A5B6EE3C464", hash_generated_field = "7392B175222DBFE73444BEBB76802D17")

    public  String mimeType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.950 -0400", hash_original_field = "C3B4FB51245D3CE9269E8404E5EE381F", hash_generated_field = "919EB93AF9F823E4E7BE19EDEC7AF709")

    public  ProcessedData data;

    /**
     * Creates a <code>DrmInfoStatus</code> object with the specified parameters.
     *
     * @param _statusCode The status of the communication.
     * @param _infoType The type of the DRM information processed.
     * @param _data The processed data.
     * @param _mimeType The MIME type.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.953 -0400", hash_original_method = "04E39E51E22AEC2B13BC19CC957BBEE0", hash_generated_method = "82F0FA11A2B1327D2D560BACCF021942")
    
public DrmInfoStatus(int _statusCode, int _infoType, ProcessedData _data, String _mimeType) {
        statusCode = _statusCode;
        infoType = _infoType;
        data = _data;
        mimeType = _mimeType;
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    public DrmInfoStatus() {

    }
        
    public DrmInfoStatus(DSOnlyType doncare) {
        
    }
}

