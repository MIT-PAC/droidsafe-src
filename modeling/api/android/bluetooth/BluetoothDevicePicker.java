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
 * Copyright (C) 2009 The Android Open Source Project
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


package android.bluetooth;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;

/**
 * A helper to show a system "Device Picker" activity to the user.
 *
 * @hide
 */
public interface BluetoothDevicePicker {
    public static final String EXTRA_NEED_AUTH =
            "android.bluetooth.devicepicker.extra.NEED_AUTH";
    public static final String EXTRA_FILTER_TYPE =
            "android.bluetooth.devicepicker.extra.FILTER_TYPE";
    public static final String EXTRA_LAUNCH_PACKAGE =
            "android.bluetooth.devicepicker.extra.LAUNCH_PACKAGE";
    public static final String EXTRA_LAUNCH_CLASS =
            "android.bluetooth.devicepicker.extra.DEVICE_PICKER_LAUNCH_CLASS";

    /**
     * Broadcast when one BT device is selected from BT device picker screen.
     * Selected {@link BluetoothDevice} is returned in extra data named
     * {@link BluetoothDevice#EXTRA_DEVICE}.
     */
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DEVICE_SELECTED =
            "android.bluetooth.devicepicker.action.DEVICE_SELECTED";

    /**
     * Broadcast when someone want to select one BT device from devices list.
     * This intent contains below extra data:
     * - {@link #EXTRA_NEED_AUTH} (boolean): if need authentication
     * - {@link #EXTRA_FILTER_TYPE} (int): what kinds of device should be
     *                                     listed
     * - {@link #EXTRA_LAUNCH_PACKAGE} (string): where(which package) this
     *                                           intent come from
     * - {@link #EXTRA_LAUNCH_CLASS} (string): where(which class) this intent
     *                                         come from
     */
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_LAUNCH =
            "android.bluetooth.devicepicker.action.LAUNCH";

    /** Ask device picker to show all kinds of BT devices */
    public static final int FILTER_TYPE_ALL = 0;
    /** Ask device picker to show BT devices that support AUDIO profiles */
    public static final int FILTER_TYPE_AUDIO = 1;
    /** Ask device picker to show BT devices that support Object Transfer */
    public static final int FILTER_TYPE_TRANSFER = 2;
    /** Ask device picker to show BT devices that support
     * Personal Area Networking User (PANU) profile*/
    public static final int FILTER_TYPE_PANU = 3;
    /** Ask device picker to show BT devices that support Network Access Point (NAP) profile */
    public static final int FILTER_TYPE_NAP = 4;
}
