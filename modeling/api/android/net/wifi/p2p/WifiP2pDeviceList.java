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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.net.wifi.p2p;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import android.os.Parcel;
import android.os.Parcelable;

public class WifiP2pDeviceList implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.656 -0400", hash_original_field = "4A218AAA8D9C30DA3D56C41E5779AA21", hash_generated_field = "028C774B60D3FC71D12C3B348A35124D")

    public static final Creator<WifiP2pDeviceList> CREATOR =
        new Creator<WifiP2pDeviceList>() {
            @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.254 -0500", hash_original_method = "899194FDFB13E2439E0712865745CEA1", hash_generated_method = "A2578E388461582A75ECAE69FBBCFC08")
        
public WifiP2pDeviceList createFromParcel(Parcel in) {
                WifiP2pDeviceList deviceList = new WifiP2pDeviceList();

                int deviceCount = in.readInt();
                for (int i = 0; i < deviceCount; i++) {
                    deviceList.update((WifiP2pDevice)in.readParcelable(null));
                }
                return deviceList;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.257 -0500", hash_original_method = "F919F24B2CB73D8D3F9E4AF1E7014246", hash_generated_method = "11E22A1AA9EB4D65A9F192BAC0B8CE61")
        
public WifiP2pDeviceList[] newArray(int size) {
                return new WifiP2pDeviceList[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.228 -0500", hash_original_field = "0B43936F54F5CCBEECBA55FA194F2046", hash_generated_field = "DD90A9525404352AE853B3D0A4AC59A5")

    private Collection<WifiP2pDevice> mDevices;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.231 -0500", hash_original_method = "711A9A33382FDEBAFBD29DC2083BF3E5", hash_generated_method = "26BCD1798670B841955278A6D31256B1")
    
public WifiP2pDeviceList() {
        mDevices = new ArrayList<WifiP2pDevice>();
    }

    /** copy constructor */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.233 -0500", hash_original_method = "41227E772CD15F31E5452F0B2CEC5C6F", hash_generated_method = "BF6ECA95322C90C79BEABA05458EAC47")
    
public WifiP2pDeviceList(WifiP2pDeviceList source) {
        if (source != null) {
            mDevices = source.getDeviceList();
        }
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.236 -0500", hash_original_method = "A6AECDF562D4D05BB14FD089AEB17F29", hash_generated_method = "058A2AFD7EF4D71199333850A39F7903")
    
public WifiP2pDeviceList(ArrayList<WifiP2pDevice> devices) {
        mDevices = new ArrayList<WifiP2pDevice>();
        for (WifiP2pDevice device : devices) {
            mDevices.add(device);
        }
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.238 -0500", hash_original_method = "70CE399D4AEC1ED49C7E7903137A1A02", hash_generated_method = "19231D072586843694BB9568C2A6E24F")
    
public boolean clear() {
        if (mDevices.isEmpty()) return false;
        mDevices.clear();
        return true;
    }

    /** @hide */
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.240 -0500", hash_original_method = "FB31C2BA18EF767553E65099D683D802", hash_generated_method = "3CEA99DED796B4CF76FEBC133686A879")
    
public void update(WifiP2pDevice device) {
        if (device == null) return;
        for (WifiP2pDevice d : mDevices) {
            //Found, update fields that can change
            if (d.equals(device)) {
                d.deviceName = device.deviceName;
                d.primaryDeviceType = device.primaryDeviceType;
                d.secondaryDeviceType = device.secondaryDeviceType;
                d.wpsConfigMethodsSupported = device.wpsConfigMethodsSupported;
                d.deviceCapability = device.deviceCapability;
                d.groupCapability = device.groupCapability;
                return;
            }
        }
        //Not found, add a new one
        mDevices.add(device);
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.242 -0500", hash_original_method = "020B85F823F552419F9C1AF8A2509846", hash_generated_method = "355173943142F9D7382FBDF33843DFD0")
    
public boolean remove(WifiP2pDevice device) {
        if (device == null) return false;
        return mDevices.remove(device);
    }

    /** Get the list of devices */
    @DSComment("Wifi subsystem")
    @DSSpec(DSCat.WIFI)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.244 -0500", hash_original_method = "AF7D82D1BB8BCC5F50496B9C85783B3A", hash_generated_method = "0F8BB0ABBD0D8970C766D67373DAF414")
    
public Collection<WifiP2pDevice> getDeviceList() {
        return Collections.unmodifiableCollection(mDevices);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.246 -0500", hash_original_method = "5A8D6CF28770F332159DA6A027ABEE59", hash_generated_method = "03AB821FD1EB741C1E04964BCF6220CE")
    
public String toString() {
        StringBuffer sbuf = new StringBuffer();
        for (WifiP2pDevice device : mDevices) {
            sbuf.append("\n").append(device);
        }
        return sbuf.toString();
    }

    /** Implement the Parcelable interface */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.248 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    /** Implement the Parcelable interface */
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.250 -0500", hash_original_method = "55D2541614C0B12A14CA5FB457FCECCC", hash_generated_method = "E3296A84D34378A59883AF21A1FFDE05")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mDevices.size());
        for(WifiP2pDevice device : mDevices) {
            dest.writeParcelable(device, flags);
        }
    }
    // orphaned legacy method
    public WifiP2pDeviceList createFromParcel(Parcel in) {
                WifiP2pDeviceList deviceList = new WifiP2pDeviceList();

                int deviceCount = in.readInt();
                for (int i = 0; i < deviceCount; i++) {
                    deviceList.update((WifiP2pDevice)in.readParcelable(null));
                }
                return deviceList;
            }
    
    // orphaned legacy method
    public WifiP2pDeviceList[] newArray(int size) {
                return new WifiP2pDeviceList[size];
            }
    
}

