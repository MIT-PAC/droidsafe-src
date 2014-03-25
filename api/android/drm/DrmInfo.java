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
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

/**
 * An entity class that describes the information required to send transactions
 * between a device and an online DRM server. The DRM framework achieves
 * server registration, license acquisition, and any other server-related transactions
 * by passing an instance of this class to {@link DrmManagerClient#processDrmInfo}.
 *<p>
 * The caller can retrieve the {@link DrmInfo} instance by passing a {@link DrmInfoRequest}
 * instance to {@link DrmManagerClient#acquireDrmInfo}.
 *
 */
public class DrmInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:55.675 -0400", hash_original_field = "5D97F7C0534662C5183D05D4FFD1A145", hash_generated_field = "04254C7D5555806109D3DE22B9918A82")

    private byte[] mData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:55.678 -0400", hash_original_field = "B161F982909610C03B68BAACDD54E076", hash_generated_field = "D6D2783B71AE4BF9CBF84D44336E2BF9")

    private  String mMimeType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:55.681 -0400", hash_original_field = "4D604B9F85C7250E266E20B44F9DCAFB", hash_generated_field = "7E2E7F051ADD83BFA94254A3CED4855D")

    private  int mInfoType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:55.683 -0400", hash_original_field = "A34CBC9E86E2520F982C4272FE041EA9", hash_generated_field = "DA27EC6E87CC9520F0300B038B297F81")

    // DRM scheme such as account id, path or multiple path's
    private final HashMap<String, Object> mAttributes = new HashMap<String, Object>();

    /**
     * Creates a <code>DrmInfo</code> object with the given parameters.
     *
     * @param infoType The type of information.
     * @param data The trigger data.
     * @param mimeType The MIME type.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:55.686 -0400", hash_original_method = "9641FF451616EC3082A54513AAA1A1A4", hash_generated_method = "CF9ED3CF8BF1BA7AC9C1394B6CB12D83")
    
public DrmInfo(int infoType, byte[] data, String mimeType) {
        mInfoType = infoType;
        mMimeType = mimeType;
        mData = data;
    }

    /**
     * Creates a <code>DrmInfo</code> object with the given parameters.
     *
     * @param infoType The type of information.
     * @param path The trigger data.
     * @param mimeType The MIME type.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:55.690 -0400", hash_original_method = "F126CD2F3BB9DE0249E6E73DB0CDF6A0", hash_generated_method = "9F69DCEA83CF55127767154ED6A5F9AB")
    
public DrmInfo(int infoType, String path, String mimeType) {
        mInfoType = infoType;
        mMimeType = mimeType;
        try {
            mData = DrmUtils.readBytes(path);
        } catch (IOException e) {
            // As the given path is invalid,
            // set mData = null, so that further processDrmInfo()
            // call would fail with IllegalArgumentException because of mData = null
            mData = null;
        }
    }
    
    
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    public DrmInfo() {
    }
    
    /**
     * Adds optional information as key-value pairs to this object. To add a custom object
     * to the <code>DrmInfo</code> object, you must override the {@link #toString} implementation.
     *
     * @param key Key to add.
     * @param value Value to add.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:55.693 -0400", hash_original_method = "0DA0C3063B6F6B1E3CC722368F2F4DEE", hash_generated_method = "4F08AC1B433B8AEEDFFBF70FF684F0DD")
    
public void put(String key, Object value) {
        mAttributes.put(key, value);
    }

    /**
     * Retrieves the value of a given key.
     *
     * @param key The key whose value is being retrieved.
     *
     * @return The value of the key being retrieved. Returns null if the key cannot be found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:55.696 -0400", hash_original_method = "2E79E46904048BE0F757ACFC9327DE5C", hash_generated_method = "C60D4EB6A7F58CE4BC43D7AA67477F82")
    
public Object get(String key) {
        return mAttributes.get(key);
    }

    /**
     * Retrieves an iterator object that you can use to iterate over the keys associated with
     * this <code>DrmInfo</code> object.
     *
     * @return The iterator object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:55.698 -0400", hash_original_method = "42D1827311BA67664F99FFEEA46CA725", hash_generated_method = "738AD6FF9BCD206654511A42FC430A73")
    
public Iterator<String> keyIterator() {
        return mAttributes.keySet().iterator();
    }

    /**
     * Retrieves an iterator object that you can use to iterate over the values associated with
     * this <code>DrmInfo</code> object.
     *
     * @return The iterator object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:55.701 -0400", hash_original_method = "1E38E3E53E7B1BE68FC8A7D4B4A93B2F", hash_generated_method = "751B87B1A58A0F43E560EF564530B06E")
    
public Iterator<Object> iterator() {
        return mAttributes.values().iterator();
    }

    /**
     * Retrieves the trigger data associated with this object.
     *
     * @return The trigger data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:55.703 -0400", hash_original_method = "C504E29872F6095FD50571727F895C6C", hash_generated_method = "1423D1AC5A60EA45821C0CD4527438BA")
    
public byte[] getData() {
        return mData;
    }

    /**
     * Retrieves the MIME type associated with this object.
     *
     * @return The MIME type.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:55.706 -0400", hash_original_method = "FA5F1755E5361266828E073C873270CA", hash_generated_method = "B6BE0B3A83C82DC56DDAFE99F64DCDED")
    
public String getMimeType() {
        return mMimeType;
    }

    /**
     * Retrieves the information type associated with this object.
     *
     * @return The information type.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:55.709 -0400", hash_original_method = "DE26222960A7F2753B9FD7BB8BFE8354", hash_generated_method = "E50293ABED0146618B6E3D63C3BFB542")
    
public int getInfoType() {
        return mInfoType;
    }

    /**
     * Returns whether this instance is valid or not
     *
     * @return
     *     true if valid
     *     false if invalid
     */
     @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:55.712 -0400", hash_original_method = "DEE08FA5672D06831D622C34D52959EA", hash_generated_method = "DEE08FA5672D06831D622C34D52959EA")
    
boolean isValid() {
        return (null != mMimeType && !mMimeType.equals("")
                && null != mData && mData.length > 0 && DrmInfoRequest.isValidType(mInfoType));
    }
}

