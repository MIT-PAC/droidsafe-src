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
 * An entity class that wraps converted data, conversion status, and the
 * offset for appending the header and body signature to the converted data. An instance of this
 * class is returned by the {@link DrmManagerClient#convertData convertData()} and
 * {@link DrmManagerClient#closeConvertSession closeConvertSession()} methods. The offset is provided only when a
 * conversion session is closed by calling {@link DrmManagerClient#closeConvertSession closeConvertSession()}.
 *
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class DrmConvertedStatus {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:54.007 -0400", hash_original_field = "00B954A1128F1A6475853AA1EC8B2314", hash_generated_field = "BB9C33EF47F6BCD2FC0D2F2F6B4CC698")

    public static final int STATUS_OK = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:54.011 -0400", hash_original_field = "3A8370DBF55406B198151F1ADABDF820", hash_generated_field = "086B6473EDBA4EE83B33454746C894EF")

    public static final int STATUS_INPUTDATA_ERROR = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:54.015 -0400", hash_original_field = "C093109B454223A4D889537826CBADB7", hash_generated_field = "7709E8C1F9E1BC9160C72052C2FA3B06")

    public static final int STATUS_ERROR = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:54.018 -0400", hash_original_field = "7D58E974091311E54CFA3738B5F585EF", hash_generated_field = "45DE62900D5728D18C3A5DCF87BD5FE8")

    public  int statusCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:54.022 -0400", hash_original_field = "83640473BBFF49D19E2FDFB6A6718F0B", hash_generated_field = "D3342A6BD67617B0E1D6544661ACC1FB")

    public  byte[] convertedData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:54.025 -0400", hash_original_field = "B7E810BF01B52122CB927525A0CA4721", hash_generated_field = "29401E0923088C769B2CF76AB91921CE")

    public  int offset;

    /**
     * Creates a <code>DrmConvertedStatus</code> object with the specified parameters.
     *
     * @param _statusCode Conversion status.
     * @param _convertedData Converted data.
     * @param _offset Offset value for appending the header and body signature.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:54.029 -0400", hash_original_method = "870ABDCCA7C01B06A5561037DA9EA7AE", hash_generated_method = "7B0195A29CA73339ECC643AD274A8F86")
    
public DrmConvertedStatus(int _statusCode, byte[] _convertedData, int _offset) {
        statusCode = _statusCode;
        convertedData = _convertedData;
        offset = _offset;
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    public DrmConvertedStatus() {
    }
}

