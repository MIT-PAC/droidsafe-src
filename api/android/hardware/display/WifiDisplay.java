/*
 * Copyright (C) 2012 The Android Open Source Project
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

package android.hardware.display;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.os.Parcel;
import android.os.Parcelable;

import libcore.util.Objects;

/**
 * Describes the properties of a Wifi display.
 * <p>
 * This object is immutable.
 * </p>
 *
 * @hide
 */
public final class WifiDisplay implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:08.652 -0500", hash_original_field = "4A02427663ED3D7F138DA005376E21FF", hash_generated_field = "F39094F93DC7CC1686FD67A759CAA311")

    public static final WifiDisplay[] EMPTY_ARRAY = new WifiDisplay[0];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:08.670 -0500", hash_original_field = "B3557C6228303312B6AE7E799F55A5BF", hash_generated_field = "C4BA2A490F483DE6F6AF7A2534C33D99")

    public static final Creator<WifiDisplay> CREATOR = new Creator<WifiDisplay>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        public WifiDisplay createFromParcel(Parcel in) {
            String deviceAddress = in.readString();
            String deviceName = in.readString();
            String deviceAlias = in.readString();
            return new WifiDisplay(deviceAddress, deviceName, deviceAlias);
        }

        public WifiDisplay[] newArray(int size) {
            return size == 0 ? EMPTY_ARRAY : new WifiDisplay[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:08.642 -0500", hash_original_field = "3DFFEC0FA6955302CD82CBD0356F484B", hash_generated_field = "F4CEC45B42345F41D8FF7ED671A9A657")

    private  String mDeviceAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:08.646 -0500", hash_original_field = "566F4EB7977D85801D08234BC5D15ADF", hash_generated_field = "3AD32A5CE294660214447F3714F60A2E")

    private  String mDeviceName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:08.649 -0500", hash_original_field = "0FA3A67BFB610CBE3DD9C569B495B10A", hash_generated_field = "BAC9657E94F05ED28DBB787093FFE8F6")

    private  String mDeviceAlias;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:08.674 -0500", hash_original_method = "9DB41187D03739301D59CCA0C6F1E77F", hash_generated_method = "316B780B44D670C00C10D6C6692AC818")
    
public WifiDisplay(String deviceAddress, String deviceName, String deviceAlias) {
        if (deviceAddress == null) {
            throw new IllegalArgumentException("deviceAddress must not be null");
        }
        if (deviceName == null) {
            throw new IllegalArgumentException("deviceName must not be null");
        }

        mDeviceAddress = deviceAddress;
        mDeviceName = deviceName;
        mDeviceAlias = deviceAlias;
    }

    /**
     * Gets the MAC address of the Wifi display device.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:08.677 -0500", hash_original_method = "7AA2324895779C2456841B71D9D85077", hash_generated_method = "DE34C7BC8326628EDAEB26C50A905F19")
    
public String getDeviceAddress() {
        return mDeviceAddress;
    }

    /**
     * Gets the name of the Wifi display device.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:08.680 -0500", hash_original_method = "0AB67DD511C65F520F02D9758785E393", hash_generated_method = "6FD2B40033562C042DA5F8054453793C")
    
public String getDeviceName() {
        return mDeviceName;
    }

    /**
     * Gets the user-specified alias of the Wifi display device, or null if none.
     * <p>
     * The alias should be used in the UI whenever available.  It is the value
     * provided by the user when renaming the device.
     * </p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:08.683 -0500", hash_original_method = "8A8A0C33B70679FF03CE0ABC769DF5FB", hash_generated_method = "A7C77686D4C245223C1E2EAC51169B78")
    
public String getDeviceAlias() {
        return mDeviceAlias;
    }

    /**
     * Gets the name to show in the UI.
     * Uses the device alias if available, otherwise uses the device name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:08.686 -0500", hash_original_method = "F2C8EE04C4DFB1E8E44D829D8454169A", hash_generated_method = "D2451393E96C422AA5CDA132044617F5")
    
public String getFriendlyDisplayName() {
        return mDeviceAlias != null ? mDeviceAlias : mDeviceName;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:08.689 -0500", hash_original_method = "48B1FFAC43E2A3211570BE656A8BCBB2", hash_generated_method = "06DC343B4C7DCDEEA0769ABF3AA4960D")
    
@Override
    public boolean equals(Object o) {
        return o instanceof WifiDisplay && equals((WifiDisplay)o);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:08.692 -0500", hash_original_method = "02782289F52040DE0CFDA7897FDFAA19", hash_generated_method = "5CFCC1F4C6B90EF8E099D7248F27BA35")
    
public boolean equals(WifiDisplay other) {
        return other != null
                && mDeviceAddress.equals(other.mDeviceAddress)
                && mDeviceName.equals(other.mDeviceName)
                && Objects.equal(mDeviceAlias, other.mDeviceAlias);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:08.697 -0500", hash_original_method = "BF375FEAE634C3CE8F7B9C89395C26C2", hash_generated_method = "1F9B47249BDD27F76E694739E6D6DA69")
    
@Override
    public int hashCode() {
        // The address on its own should be sufficiently unique for hashing purposes.
        return mDeviceAddress.hashCode();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:08.702 -0500", hash_original_method = "E003799A019573BD86D0DBB167237F94", hash_generated_method = "97AD0E43200865188A05F6122A8081A7")
    
@Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mDeviceAddress);
        dest.writeString(mDeviceName);
        dest.writeString(mDeviceAlias);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:08.705 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
    
@Override
    public int describeContents() {
        return 0;
    }

    // For debugging purposes only.
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:08.709 -0500", hash_original_method = "BB0785DC6141082208E0D254C2B8D066", hash_generated_method = "3769D69ECD61F6278F59EB6C47B4AC5E")
    
@Override
    public String toString() {
        String result = mDeviceName + " (" + mDeviceAddress + ")";
        if (mDeviceAlias != null) {
            result += ", alias " + mDeviceAlias;
        }
        return result;
    }
}
