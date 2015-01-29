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
import java.util.HashMap;
import java.util.Iterator;

/**
 * An entity class that is used to pass information to an online DRM server. An instance of this
 * class is passed to the {@link DrmManagerClient#acquireDrmInfo acquireDrmInfo()} method to get an
 * instance of a {@link DrmInfo}.
 *
 */
public class DrmInfoRequest {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.185 -0400", hash_original_field = "545295ABB1FC5732667DA1EB01AD3C49", hash_generated_field = "191A7C384B79A26D78737B08B9CF7E42")

    /**
     * Acquires DRM server registration information.
     */
    public static final int TYPE_REGISTRATION_INFO = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.191 -0400", hash_original_field = "D36EC3BC1E559E1305B61B5965D7DF2C", hash_generated_field = "816992DFBF756D8DCF81E87B5CE35B82")

    public static final int TYPE_UNREGISTRATION_INFO = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.196 -0400", hash_original_field = "B97CF13408803D8CDA08BE34A29358C7", hash_generated_field = "162E1758DFE05275594BD39DD3CAEC77")

    public static final int TYPE_RIGHTS_ACQUISITION_INFO = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.202 -0400", hash_original_field = "09882410EA7CBE873A4469CD0360BB9D", hash_generated_field = "F4109C92406A8AC305C22D78E31C1D7D")

    public static final int TYPE_RIGHTS_ACQUISITION_PROGRESS_INFO = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.207 -0400", hash_original_field = "BDD0ACFCEBD86B7BEEE62343184EB35D", hash_generated_field = "7721DC9321FEC2F0F0C73FCBB4A85066")

    public static final String ACCOUNT_ID = "account_id";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.211 -0400", hash_original_field = "EC91474F64017AE863FCCAF52E21A52B", hash_generated_field = "7045FC573454041E6E80BF5C6D252F66")

    public static final String SUBSCRIPTION_ID = "subscription_id";

    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.260 -0400", hash_original_method = "AABCC18372241F410390423CCF4490C0", hash_generated_method = "D6B0074861B31B0894F7C6F56E647059")
    
static boolean isValidType(int infoType) {
        boolean isValid = false;

        switch (infoType) {
        case TYPE_REGISTRATION_INFO:
        case TYPE_UNREGISTRATION_INFO:
        case TYPE_RIGHTS_ACQUISITION_INFO:
        case TYPE_RIGHTS_ACQUISITION_PROGRESS_INFO:
            isValid = true;
            break;
        }
        return isValid;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.215 -0400", hash_original_field = "4D604B9F85C7250E266E20B44F9DCAFB", hash_generated_field = "7E2E7F051ADD83BFA94254A3CED4855D")


    private  int mInfoType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.220 -0400", hash_original_field = "B161F982909610C03B68BAACDD54E076", hash_generated_field = "D6D2783B71AE4BF9CBF84D44336E2BF9")

    private  String mMimeType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.225 -0400", hash_original_field = "C30A425D85638362B081847FFA31ECD1", hash_generated_field = "1D63B74FBCB3167E708EE02463D007FB")

    private final HashMap<String, Object> mRequestInformation = new HashMap<String, Object>();

    /**
     * Creates a <code>DrmInfoRequest</code> object with type and MIME type.
     *
     * @param infoType Type of information.
     * @param mimeType MIME type.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.229 -0400", hash_original_method = "9672E9BF1AC4A843B7E62F19261170F0", hash_generated_method = "AA4280D1F86E349FD8E5DE687F0062DA")
    
public DrmInfoRequest(int infoType, String mimeType) {
        mInfoType = infoType;
        mMimeType = mimeType;
    }

    /**
     * Retrieves the MIME type associated with this object.
     *
     * @return The MIME type.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.233 -0400", hash_original_method = "FA5F1755E5361266828E073C873270CA", hash_generated_method = "B6BE0B3A83C82DC56DDAFE99F64DCDED")
    
public String getMimeType() {
        return mMimeType;
    }

    /**
     * Retrieves the information type associated with this object.
     *
     * @return The information type.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.236 -0400", hash_original_method = "DE26222960A7F2753B9FD7BB8BFE8354", hash_generated_method = "E50293ABED0146618B6E3D63C3BFB542")
    
public int getInfoType() {
        return mInfoType;
    }

    /**
     * Adds optional information as key-value pairs to this object.
     *
     * @param key The key to add.
     * @param value The value to add.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.241 -0400", hash_original_method = "D9802BC24EA78140947C4C72ACC44CDC", hash_generated_method = "87EF2FF2B3CDF81DD81253CD4DBBF7DC")
    
public void put(String key, Object value) {
        mRequestInformation.put(key, value);
    }

    /**
     * Retrieves the value of a given key.
     *
     * @param key The key whose value is being retrieved.
     *
     * @return The value of the key that is being retrieved. Returns null if the key cannot be
     * found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.245 -0400", hash_original_method = "883F3C6C0F9DC7D1E3F7763FEE62DA4F", hash_generated_method = "015C6ACB3F0EE922A1BD9C654A26615C")
    
public Object get(String key) {
        return mRequestInformation.get(key);
    }

    /**
     * Retrieves an iterator object that you can use to iterate over the keys associated with
     * this <code>DrmInfoRequest</code> object.
     *
     * @return The iterator object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.249 -0400", hash_original_method = "2D80866903D5AC76D21C996C1CD44AE9", hash_generated_method = "87FA7015A6BEF10215A5F136F56DF297")
    
public Iterator<String> keyIterator() {
        return mRequestInformation.keySet().iterator();
    }

    /**
     * Retrieves an iterator object that you can use to iterate over the values associated with
     * this <code>DrmInfoRequest</code> object.
     *
     * @return The iterator object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.253 -0400", hash_original_method = "287F9DF1F3EC779A1B6621AC35B2F33A", hash_generated_method = "AD969FA86394D581EAD76569C39BCB27")
    
public Iterator<Object> iterator() {
        return mRequestInformation.values().iterator();
    }

    /**
     * Returns whether this instance is valid or not
     *
     * @return
     *     true if valid
     *     false if invalid
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.256 -0400", hash_original_method = "591C2A5A520643F864AF1B0C29FDD4AF", hash_generated_method = "591C2A5A520643F864AF1B0C29FDD4AF")
    
boolean isValid() {
        return (null != mMimeType && !mMimeType.equals("")
                && null != mRequestInformation && isValidType(mInfoType));
    }
}

