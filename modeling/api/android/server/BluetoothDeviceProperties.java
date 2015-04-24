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


package android.server;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.os.ParcelUuid;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class BluetoothDeviceProperties {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.395 -0400", hash_original_field = "C0E80495EFCE3B748199B55952E97E8E", hash_generated_field = "BB2117F9B18FBDED4EBA25A8EDFE9CE5")


    private static final String TAG = "BluetoothDeviceProperties";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.396 -0400", hash_original_field = "2D267A72298D23E242BF7E8D3630F9DA", hash_generated_field = "A2C3A8F0CDD07DE3A6FC49D29D47ED6E")


    private  HashMap<String, Map<String, String>> mPropertiesMap;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.398 -0400", hash_original_field = "F41AE71D622FDCA6BB622192685F5E5F", hash_generated_field = "595579B9977CA2238E14150EEB2A2C75")

    private  BluetoothService mService;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.400 -0400", hash_original_method = "B4CF16CC78C4799A8A2D70561B20CDCE", hash_generated_method = "B4CF16CC78C4799A8A2D70561B20CDCE")
    
BluetoothDeviceProperties(BluetoothService service) {
        mPropertiesMap = new HashMap<String, Map<String, String>>();
        mService = service;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.402 -0400", hash_original_method = "A55C633BCA78531F7157E527464D137C", hash_generated_method = "307207450E93A37CD8B89CD690A4ADBE")
    
Map<String, String> addProperties(String address, String[] properties) {
        /*
         * We get a DeviceFound signal every time RSSI changes or name changes.
         * Don't create a new Map object every time.
         */
        Map<String, String> propertyValues;
        synchronized(mPropertiesMap) {
            propertyValues = mPropertiesMap.get(address);
            if (propertyValues == null) {
                propertyValues = new HashMap<String, String>();
            }

            for (int i = 0; i < properties.length; i++) {
                String name = properties[i];
                String newValue = null;
                int len;
                if (name == null) {
                    Log.e(TAG, "Error: Remote Device Property at index "
                        + i + " is null");
                    continue;
                }
                if (name.equals("UUIDs") || name.equals("Nodes")) {
                    StringBuilder str = new StringBuilder();
                    len = Integer.valueOf(properties[++i]);
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

                propertyValues.put(name, newValue);
            }
            mPropertiesMap.put(address, propertyValues);
        }

        // We have added a new remote device or updated its properties.
        // Also update the serviceChannel cache.
        mService.updateDeviceServiceChannelCache(address);
        return propertyValues;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.404 -0400", hash_original_method = "C5C9B941B2DC7C4A5824E5128FA2E13E", hash_generated_method = "C5C9B941B2DC7C4A5824E5128FA2E13E")
    
void setProperty(String address, String name, String value) {
        synchronized(mPropertiesMap) {
            Map <String, String> propVal = mPropertiesMap.get(address);
            if (propVal != null) {
                propVal.put(name, value);
                mPropertiesMap.put(address, propVal);
            } else {
                Log.e(TAG, "setRemoteDeviceProperty for a device not in cache:" + address);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.406 -0400", hash_original_method = "ED0A1DD9DB1D2E0344E5BDD0156E9303", hash_generated_method = "ED0A1DD9DB1D2E0344E5BDD0156E9303")
    
boolean isInCache(String address) {
        synchronized (mPropertiesMap) {
            return (mPropertiesMap.get(address) != null);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.408 -0400", hash_original_method = "13BC63ED091965611BAED75D1DAE5CAE", hash_generated_method = "13BC63ED091965611BAED75D1DAE5CAE")
    
boolean isEmpty() {
        synchronized (mPropertiesMap) {
            return mPropertiesMap.isEmpty();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.409 -0400", hash_original_method = "277240E249FA4DEBF286A8BC0D2898A3", hash_generated_method = "277240E249FA4DEBF286A8BC0D2898A3")
    
Set<String> keySet() {
        synchronized (mPropertiesMap) {
            return mPropertiesMap.keySet();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.411 -0400", hash_original_method = "CD1913092BDE5EDE76598E42951B8BEC", hash_generated_method = "49A3C3A8771D587DDECA3F45BF7B4CF6")
    
String getProperty(String address, String property) {
        synchronized(mPropertiesMap) {
            Map<String, String> properties = mPropertiesMap.get(address);
            if (properties != null) {
                return properties.get(property);
            } else {
                // Query for remote device properties, again.
                // We will need to reload the cache when we switch Bluetooth on / off
                // or if we crash.
                properties = updateCache(address);
                if (properties != null) {
                    return properties.get(property);
                }
            }
        }
        Log.e(TAG, "getRemoteDeviceProperty: " + property + " not present: " + address);
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:23.413 -0400", hash_original_method = "868E079DC9D24E37B274FD0A214607C8", hash_generated_method = "868E079DC9D24E37B274FD0A214607C8")
    
Map<String, String> updateCache(String address) {
        String[] propValues = mService.getRemoteDeviceProperties(address);
        if (propValues != null) {
            return addProperties(address, propValues);
        }
        return null;
    }
}
