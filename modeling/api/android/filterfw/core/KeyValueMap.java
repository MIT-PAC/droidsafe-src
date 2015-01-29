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

package android.filterfw.core;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @hide
 */
public class KeyValueMap extends HashMap<String, Object> {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.611 -0400", hash_original_method = "FE3C69E46190B817B958F99D587231F6", hash_generated_method = "E971EC039A8D24D9668635CF4670593A")
    
public static KeyValueMap fromKeyValues(Object... keyValues) {
        KeyValueMap result = new KeyValueMap();
        result.setKeyValues(keyValues);
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.609 -0400", hash_original_method = "D0286CAE8B89E9A35B9F7916673345BB", hash_generated_method = "862D8A42BE37C3084F36258A12742E4C")
    
public void setKeyValues(Object... keyValues) {
        if (keyValues.length % 2 != 0) {
            throw new RuntimeException("Key-Value arguments passed into setKeyValues must be "
            + "an alternating list of keys and values!");
        }
        for (int i = 0; i < keyValues.length; i += 2) {
            if (!(keyValues[i] instanceof String)) {
                throw new RuntimeException("Key-value argument " + i + " must be a key of type "
                    + "String, but found an object of type " + keyValues[i].getClass() + "!");
            }
            String key = (String)keyValues[i];
            Object value = keyValues[i+1];
            put(key, value);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.613 -0400", hash_original_method = "FBEB2F366012C84DDC32721B11BBB97B", hash_generated_method = "0A2D767D9F858C1C05ACA60EAC2AEFCA")
    
public String getString(String key) {
        Object result = get(key);
        return result != null ? (String)result : null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.615 -0400", hash_original_method = "213E5013D3917B0E38BEC95C9A8C8E13", hash_generated_method = "7C1323B963A529F01BF68789239AE5CE")
    
public int getInt(String key) {
        Object result = get(key);
        return result != null ? (Integer)result : null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.617 -0400", hash_original_method = "D954ACDC9A0341A90ED1D3D8E9B80C49", hash_generated_method = "FF3D1982B3DC44949DB74BCFD53D5187")
    
public float getFloat(String key) {
        Object result = get(key);
        return result != null ? (Float)result : null;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:06:03.619 -0400", hash_original_method = "B7B69E971D2D8AFF91029559CA0F4A16", hash_generated_method = "82B57D4F9AA87042DBC798AA4C4B8587")
    
@Override
    public String toString() {
        StringWriter writer = new StringWriter();
        for (Map.Entry<String, Object> entry : entrySet()) {
            String valueString;
            Object value = entry.getValue();
            if (value instanceof String) {
                valueString = "\"" + value + "\"";
            } else {
                valueString = value.toString();
            }
            writer.write(entry.getKey() + " = " + valueString + ";\n");
        }
        return writer.toString();
    }

}
