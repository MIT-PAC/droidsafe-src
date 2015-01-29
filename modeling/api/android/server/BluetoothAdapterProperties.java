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

package android.server;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

class BluetoothAdapterProperties {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.427 -0400", hash_original_field = "4671D397E1D8EC00DF54FEAACE14C97A", hash_generated_field = "4F8E948BA5B63798789FDC00FB173828")


    private static final String TAG = "BluetoothAdapterProperties";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.428 -0400", hash_original_field = "4FFEAEBE909BB2B57DD86EE6DB8AC376", hash_generated_field = "9E04A46AD05C6EF53BE2BA66D278684A")


    private  Map<String, String> mPropertiesMap;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.430 -0400", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.431 -0400", hash_original_field = "F41AE71D622FDCA6BB622192685F5E5F", hash_generated_field = "595579B9977CA2238E14150EEB2A2C75")

    private  BluetoothService mService;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.433 -0400", hash_original_method = "421D870298E4F15144BBECFE98355C77", hash_generated_method = "421D870298E4F15144BBECFE98355C77")
    
BluetoothAdapterProperties(Context context, BluetoothService service) {
        mPropertiesMap = new HashMap<String, String>();
        mContext = context;
        mService = service;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.435 -0400", hash_original_method = "C2118E99CB4C41B79F82FB2F8125F2CD", hash_generated_method = "C7A3607BB2B86E5E1E7D010B7853F2CB")
    
synchronized String getProperty(String name) {
        if (mPropertiesMap.isEmpty()) {
            getAllProperties();
        }
        return mPropertiesMap.get(name);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.437 -0400", hash_original_method = "703069E801F24B9358AABE7AEC6D1BD0", hash_generated_method = "703069E801F24B9358AABE7AEC6D1BD0")
    
String getObjectPath() {
        return getProperty("ObjectPath");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.438 -0400", hash_original_method = "05E9C03337CF667F9FE5069F2024C664", hash_generated_method = "E5ED69F204DBACC96EFCDBFED658CFF9")
    
synchronized void clear() {
        mPropertiesMap.clear();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.439 -0400", hash_original_method = "B8518E4452AEF0EA73DD4A2C4390C59F", hash_generated_method = "220CCEBD7E94E05DF9B59C56C25ED9E4")
    
synchronized boolean isEmpty() {
        return mPropertiesMap.isEmpty();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.441 -0400", hash_original_method = "95C94155E8016F0355EF83A6997A7D7D", hash_generated_method = "74C5C688AD23968627CB1DF84E757862")
    
synchronized void setProperty(String name, String value) {
        mPropertiesMap.put(name, value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.443 -0400", hash_original_method = "E7C6E684111D8BFCB9FF8EB0F6ED2DE0", hash_generated_method = "71180BDF59642E53A1D40B1E52C11960")
    
synchronized void getAllProperties() {
        mContext.enforceCallingOrSelfPermission(
                BluetoothService.BLUETOOTH_PERM,
                "Need BLUETOOTH permission");
        mPropertiesMap.clear();

        String properties[] = (String[]) mService
                .getAdapterPropertiesNative();
        // The String Array consists of key-value pairs.
        if (properties == null) {
            Log.e(TAG, "*Error*: GetAdapterProperties returned NULL");
            return;
        }

        for (int i = 0; i < properties.length; i++) {
            String name = properties[i];
            String newValue = null;
            if (name == null) {
                Log.e(TAG, "Error:Adapter Property at index " + i + " is null");
                continue;
            }
            if (name.equals("Devices") || name.equals("UUIDs")) {
                StringBuilder str = new StringBuilder();
                int len = Integer.valueOf(properties[++i]);
                for (int j = 0; j < len; j++) {
                    str.append(properties[++i]);
                    str.append(",");
                }
                if (len > 0) {
                    newValue = str.toString();
                }
            } else {
                newValue = properties[++i];
            }
            mPropertiesMap.put(name, newValue);
        }

        // Add adapter object path property.
        String adapterPath = mService.getAdapterPathNative();
        if (adapterPath != null) {
            mPropertiesMap.put("ObjectPath", adapterPath + "/dev_");
        }
    }
}
