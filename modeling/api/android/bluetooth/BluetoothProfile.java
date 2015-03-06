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


package android.bluetooth;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.List;

public interface BluetoothProfile {

    
    public static final String EXTRA_STATE = "android.bluetooth.profile.extra.STATE";

    
    public static final String EXTRA_PREVIOUS_STATE =
        "android.bluetooth.profile.extra.PREVIOUS_STATE";

    
    public static final int STATE_DISCONNECTED  = 0;
    
    public static final int STATE_CONNECTING    = 1;
    
    public static final int STATE_CONNECTED     = 2;
    
    public static final int STATE_DISCONNECTING = 3;

    
    public static final int HEADSET = 1;

    
    public static final int A2DP = 2;

    
    public static final int HEALTH = 3;

    
    public static final int INPUT_DEVICE = 4;

    
    public static final int PAN = 5;

    
    public static final int PBAP = 6;

    
    public static final int PRIORITY_AUTO_CONNECT = 1000;

    
    public static final int PRIORITY_ON = 100;

    
    public static final int PRIORITY_OFF = 0;

    
    public static final int PRIORITY_UNDEFINED = -1;

    
    public List<BluetoothDevice> getConnectedDevices();

    
    public List<BluetoothDevice> getDevicesMatchingConnectionStates(int[] states);

    
    public int getConnectionState(BluetoothDevice device);

    
    public interface ServiceListener {
        
        public void onServiceConnected(int profile, BluetoothProfile proxy);

        
        public void onServiceDisconnected(int profile);
    }
}
