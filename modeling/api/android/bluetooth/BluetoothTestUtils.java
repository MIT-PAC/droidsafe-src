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

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.bluetooth.BluetoothPan;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Environment;
import android.util.Log;

import junit.framework.Assert;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BluetoothTestUtils extends Assert {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.481 -0400", hash_original_field = "35668E882F166A8A102A5DB5799F058E", hash_generated_field = "9CAF875023D9DC1B3E22608F5CD2CB82")

    private static final int ENABLE_DISABLE_TIMEOUT = 20000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.483 -0400", hash_original_field = "828E0E8D3DAB793E1B9136379F2E39FB", hash_generated_field = "7F9B7D696CEF089459127C60C7D90D26")

    private static final int DISCOVERABLE_UNDISCOVERABLE_TIMEOUT = 5000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.486 -0400", hash_original_field = "2F4DEF8CDF3BA4F49494791646A596B5", hash_generated_field = "29C1441954E52723B5D9F21D6C136DA1")

    private static final int START_STOP_SCAN_TIMEOUT = 5000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.488 -0400", hash_original_field = "08CB74DA65F27E149AB6B625B76DC7D8", hash_generated_field = "8AD9A55B5FE3F3326318810A58B9E91E")

    private static final int PAIR_UNPAIR_TIMEOUT = 20000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.490 -0400", hash_original_field = "020C4C347661CFF2822450400A51084E", hash_generated_field = "A9CB924CD9B6AD5C629B524EDC235F85")

    private static final int CONNECT_DISCONNECT_PROFILE_TIMEOUT = 20000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.492 -0400", hash_original_field = "B097232CD73E6E57A72A9DECD28A0B4E", hash_generated_field = "7E00F7D139C0150C5EE4466C1A6DE7AB")

    private static final int START_STOP_SCO_TIMEOUT = 10000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.495 -0400", hash_original_field = "0B6C4BD4D78A3E49508403976071531C", hash_generated_field = "FB7C1C11E4699E485733D6FD67D173C1")

    private static final int CONNECT_PROXY_TIMEOUT = 5000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.498 -0400", hash_original_field = "FC2CB66E7A7C80C3E90767C9642A1661", hash_generated_field = "513AE2B97584007D9A5B0D1DC8D3023A")

    private static final int POLL_TIME = 100;

    private abstract class FlagReceiver extends BroadcastReceiver {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.500 -0400", hash_original_field = "EC70603FA3433FCA64AD738D9DB8A705", hash_generated_field = "A326022799434D58EF7E3478211C96F7")

        private int mExpectedFlags = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.503 -0400", hash_original_field = "24612DA21F05E8BF165583185778E94E", hash_generated_field = "3794347F9EA1B998F7C4251607176A67")

        private int mFiredFlags = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.505 -0400", hash_original_field = "42FFEDC5DB091FD875E6D77A8789F653", hash_generated_field = "3534C842439703616BCCA401E912D128")

        private long mCompletedTime = -1;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.506 -0400", hash_original_method = "D2D5A956C3F1400EF933AD2C0BF14474", hash_generated_method = "C927DC4D30393197EE7620DBF4F98428")
        
public FlagReceiver(int expectedFlags) {
            mExpectedFlags = expectedFlags;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.508 -0400", hash_original_method = "843BD5BA764C7B5E64DD3EE8483AD216", hash_generated_method = "DBA5D266546F4D7A0799457C345B75F7")
        
public int getFiredFlags() {
            synchronized (this) {
                return mFiredFlags;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.510 -0400", hash_original_method = "E8CAABC0D35EC32ECF662A1AAD98E910", hash_generated_method = "971BDB99AC20E118AA620D8809E52103")
        
public long getCompletedTime() {
            synchronized (this) {
                return mCompletedTime;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.513 -0400", hash_original_method = "84E8394F60829D7A158D03765C5658DF", hash_generated_method = "63158B8C8D7C14D833D5BF0AFF51A2B6")
        
protected void setFiredFlag(int flag) {
            synchronized (this) {
                mFiredFlags |= flag;
                if ((mFiredFlags & mExpectedFlags) == mExpectedFlags) {
                    mCompletedTime = System.currentTimeMillis();
                }
            }
        }
    }

    private class BluetoothReceiver extends FlagReceiver {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.516 -0400", hash_original_field = "4272F124D4B0D83B69CF5A512C557159", hash_generated_field = "6829DA44C4D19656F0C3246AA544E84B")

        private static final int DISCOVERY_STARTED_FLAG = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.520 -0400", hash_original_field = "59C6073D28F971DACFFE624729286C05", hash_generated_field = "433F64742F0ADFBFF60F1A8CDE363A15")

        private static final int DISCOVERY_FINISHED_FLAG = 1 << 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.522 -0400", hash_original_field = "DAA54DC256963E623C08F1B0E033E2C8", hash_generated_field = "504B7D41F3E5600BD71383EA2D0E319A")

        private static final int SCAN_MODE_NONE_FLAG = 1 << 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.524 -0400", hash_original_field = "47082153B861F71E278B0256DA02E955", hash_generated_field = "6F34C0F85FCBD4E1D5D0B9BD4E1FACC1")

        private static final int SCAN_MODE_CONNECTABLE_FLAG = 1 << 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.526 -0400", hash_original_field = "DD8DF393385B4F99FA8F56DE99D7EF7A", hash_generated_field = "F6B1F17A5D1A93D6A0ADB7E615DBC6BC")

        private static final int SCAN_MODE_CONNECTABLE_DISCOVERABLE_FLAG = 1 << 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.529 -0400", hash_original_field = "70F0866206EB0D8EFB6142CE7CCDB83C", hash_generated_field = "4E993DE95E3A13F054FE88B3F2AD4EFC")

        private static final int STATE_OFF_FLAG = 1 << 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.531 -0400", hash_original_field = "937950E3307355652D55BE04566B4774", hash_generated_field = "F2F6DE46840A7F9D73DF93CA91842721")

        private static final int STATE_TURNING_ON_FLAG = 1 << 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.532 -0400", hash_original_field = "8AF856DD1B9F78754081982CA6E783B8", hash_generated_field = "BAD3B49A996BFD135E2170B62C750600")

        private static final int STATE_ON_FLAG = 1 << 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.535 -0400", hash_original_field = "C2462D66B6D35C34F2AC12BA2983ECB5", hash_generated_field = "71EDC6009B36DAFBC987B2D4EC7EACF0")

        private static final int STATE_TURNING_OFF_FLAG = 1 << 8;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.537 -0400", hash_original_method = "A33A1C87997A398ACE26678C302EFC18", hash_generated_method = "5CC0F6C7E3610329499C90092C3C0B5D")
        
public BluetoothReceiver(int expectedFlags) {
            super(expectedFlags);
        }

        @DSSafe(DSCat.IPC_CALLBACK)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.539 -0400", hash_original_method = "75C1ABE95D80A79A4011B8BC5342B31B", hash_generated_method = "07F34DE82D1CC1ABEEAD4BB5AA0F958D")
        
@Override
        public void onReceive(Context context, Intent intent) {
            if (BluetoothAdapter.ACTION_DISCOVERY_STARTED.equals(intent.getAction())) {
                setFiredFlag(DISCOVERY_STARTED_FLAG);
            } else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(intent.getAction())) {
                setFiredFlag(DISCOVERY_FINISHED_FLAG);
            } else if (BluetoothAdapter.ACTION_SCAN_MODE_CHANGED.equals(intent.getAction())) {
                int mode = intent.getIntExtra(BluetoothAdapter.EXTRA_SCAN_MODE, -1);
                assertNotSame(-1, mode);
                switch (mode) {
                    case BluetoothAdapter.SCAN_MODE_NONE:
                        setFiredFlag(SCAN_MODE_NONE_FLAG);
                        break;
                    case BluetoothAdapter.SCAN_MODE_CONNECTABLE:
                        setFiredFlag(SCAN_MODE_CONNECTABLE_FLAG);
                        break;
                    case BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE:
                        setFiredFlag(SCAN_MODE_CONNECTABLE_DISCOVERABLE_FLAG);
                        break;
                }
            } else if (BluetoothAdapter.ACTION_STATE_CHANGED.equals(intent.getAction())) {
                int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, -1);
                assertNotSame(-1, state);
                switch (state) {
                    case BluetoothAdapter.STATE_OFF:
                        setFiredFlag(STATE_OFF_FLAG);
                        break;
                    case BluetoothAdapter.STATE_TURNING_ON:
                        setFiredFlag(STATE_TURNING_ON_FLAG);
                        break;
                    case BluetoothAdapter.STATE_ON:
                        setFiredFlag(STATE_ON_FLAG);
                        break;
                    case BluetoothAdapter.STATE_TURNING_OFF:
                        setFiredFlag(STATE_TURNING_OFF_FLAG);
                        break;
                }
            }
        }
    }

    private class PairReceiver extends FlagReceiver {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.543 -0400", hash_original_field = "1EB762199B3700FD10D6C65DA9117FC0", hash_generated_field = "9EE1EEBED947746EE0A537B87E4715F8")

        private static final int STATE_BONDED_FLAG = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.544 -0400", hash_original_field = "D7EC4826374AEEAEFA860C7BDB4BEECE", hash_generated_field = "7A2DA8E0EAF92130815F8C91CF99467E")

        private static final int STATE_BONDING_FLAG = 1 << 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.546 -0400", hash_original_field = "FABD3707A0B8662861EFBFD99CF41D60", hash_generated_field = "091D5F23144480AB01F07A1095B26A87")

        private static final int STATE_NONE_FLAG = 1 << 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.547 -0400", hash_original_field = "793253818BA6C7B0BA0EE44002B9EC24", hash_generated_field = "E4571726F4118D3C8C7A8AF1D003C1BF")

        private BluetoothDevice mDevice;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.549 -0400", hash_original_field = "D52C02153F76E7B145AB24DDAA220FE4", hash_generated_field = "510E7DEE874C284A83522515DC49323D")

        private int mPasskey;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.550 -0400", hash_original_field = "D7925D25808AF10DA2FD91F24E061428", hash_generated_field = "C2C56407E6F06243AEA03FAFE40965D3")

        private byte[] mPin;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.552 -0400", hash_original_method = "B55C4EE3F53EB5B10E3778FC03783D39", hash_generated_method = "3C37466872A6EEF45547E3033881EA10")
        
public PairReceiver(BluetoothDevice device, int passkey, byte[] pin, int expectedFlags) {
            super(expectedFlags);

            mDevice = device;
            mPasskey = passkey;
            mPin = pin;
        }

        @DSSafe(DSCat.IPC_CALLBACK)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.554 -0400", hash_original_method = "58F0FAD155FF4B13D45592A973C4E988", hash_generated_method = "6BB220484C1DF0BA20C534A1CD51819B")
        
@Override
        public void onReceive(Context context, Intent intent) {
            if (!mDevice.equals(intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE))) {
                return;
            }

            if (BluetoothDevice.ACTION_PAIRING_REQUEST.equals(intent.getAction())) {
                int varient = intent.getIntExtra(BluetoothDevice.EXTRA_PAIRING_VARIANT, -1);
                assertNotSame(-1, varient);
                switch (varient) {
                    case BluetoothDevice.PAIRING_VARIANT_PIN:
                        mDevice.setPin(mPin);
                        break;
                    case BluetoothDevice.PAIRING_VARIANT_PASSKEY:
                        mDevice.setPasskey(mPasskey);
                        break;
                    case BluetoothDevice.PAIRING_VARIANT_PASSKEY_CONFIRMATION:
                    case BluetoothDevice.PAIRING_VARIANT_CONSENT:
                        mDevice.setPairingConfirmation(true);
                        break;
                    case BluetoothDevice.PAIRING_VARIANT_OOB_CONSENT:
                        mDevice.setRemoteOutOfBandData();
                        break;
                }
            } else if (BluetoothDevice.ACTION_BOND_STATE_CHANGED.equals(intent.getAction())) {
                int state = intent.getIntExtra(BluetoothDevice.EXTRA_BOND_STATE, -1);
                assertNotSame(-1, state);
                switch (state) {
                    case BluetoothDevice.BOND_NONE:
                        setFiredFlag(STATE_NONE_FLAG);
                        break;
                    case BluetoothDevice.BOND_BONDING:
                        setFiredFlag(STATE_BONDING_FLAG);
                        break;
                    case BluetoothDevice.BOND_BONDED:
                        setFiredFlag(STATE_BONDED_FLAG);
                        break;
                }
            }
        }
    }

    private class ConnectProfileReceiver extends FlagReceiver {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.558 -0400", hash_original_field = "58287905C0BD76A77473277AA7A2C329", hash_generated_field = "E70936A4376EA8CD6D3286CA7184B7D6")

        private static final int STATE_DISCONNECTED_FLAG = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.559 -0400", hash_original_field = "196070648B1EE54613A9AAA883420566", hash_generated_field = "9FC5A4D3DDD3FF040AA54F79FB5532E1")

        private static final int STATE_CONNECTING_FLAG = 1 << 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.561 -0400", hash_original_field = "5F90FBB29E2CF6021F2EF17305D3B822", hash_generated_field = "5CA4BC295A67F7CD7B409DE2EE83D179")

        private static final int STATE_CONNECTED_FLAG = 1 << 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.562 -0400", hash_original_field = "2BA6A7637C36479F0F8B96D954C430C8", hash_generated_field = "052450B6E1FA2A11DA281340511F7E19")

        private static final int STATE_DISCONNECTING_FLAG = 1 << 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.564 -0400", hash_original_field = "793253818BA6C7B0BA0EE44002B9EC24", hash_generated_field = "E4571726F4118D3C8C7A8AF1D003C1BF")

        private BluetoothDevice mDevice;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.565 -0400", hash_original_field = "6466AB47A4E8DAAE93C96826CBF42A86", hash_generated_field = "8016B178818EBB90ECC104CA00C7510B")

        private int mProfile;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.566 -0400", hash_original_field = "A09ACC92135BD9F304EBA579E8ACADC7", hash_generated_field = "9F4F92C939075469371BBDBA69E2FA3F")

        private String mConnectionAction;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.568 -0400", hash_original_method = "F8E5699C63013AB73E38F3197A0B0B9C", hash_generated_method = "C25F5AFD6005EB465D4171D6C4A358FE")
        
public ConnectProfileReceiver(BluetoothDevice device, int profile, int expectedFlags) {
            super(expectedFlags);

            mDevice = device;
            mProfile = profile;

            switch (mProfile) {
                case BluetoothProfile.A2DP:
                    mConnectionAction = BluetoothA2dp.ACTION_CONNECTION_STATE_CHANGED;
                    break;
                case BluetoothProfile.HEADSET:
                    mConnectionAction = BluetoothHeadset.ACTION_CONNECTION_STATE_CHANGED;
                    break;
                case BluetoothProfile.INPUT_DEVICE:
                    mConnectionAction = BluetoothInputDevice.ACTION_CONNECTION_STATE_CHANGED;
                    break;
                case BluetoothProfile.PAN:
                    mConnectionAction = BluetoothPan.ACTION_CONNECTION_STATE_CHANGED;
                    break;
                default:
                    mConnectionAction = null;
            }
        }

        @DSSafe(DSCat.IPC_CALLBACK)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.570 -0400", hash_original_method = "F5D523FBF8E24660B850A9FEDD7CDB84", hash_generated_method = "205EC4C4D3FCEC04D03443E53D405A98")
        
@Override
        public void onReceive(Context context, Intent intent) {
            if (mConnectionAction != null && mConnectionAction.equals(intent.getAction())) {
                if (!mDevice.equals(intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE))) {
                    return;
                }

                int state = intent.getIntExtra(BluetoothProfile.EXTRA_STATE, -1);
                assertNotSame(-1, state);
                switch (state) {
                    case BluetoothProfile.STATE_DISCONNECTED:
                        setFiredFlag(STATE_DISCONNECTED_FLAG);
                        break;
                    case BluetoothProfile.STATE_CONNECTING:
                        setFiredFlag(STATE_CONNECTING_FLAG);
                        break;
                    case BluetoothProfile.STATE_CONNECTED:
                        setFiredFlag(STATE_CONNECTED_FLAG);
                        break;
                    case BluetoothProfile.STATE_DISCONNECTING:
                        setFiredFlag(STATE_DISCONNECTING_FLAG);
                        break;
                }
            }
        }
    }

    private class ConnectPanReceiver extends ConnectProfileReceiver {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.574 -0400", hash_original_field = "D5084B79E2B08CD2E52A79F8CE55A4EF", hash_generated_field = "76F9775A9ADE67BEADFA0C6A215C040C")

        private int mRole;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.575 -0400", hash_original_method = "7A3D0B2A2B2D4971FD37C986EF0E36FE", hash_generated_method = "7F6F453A341112688B5E89E600E98E02")
        
public ConnectPanReceiver(BluetoothDevice device, int role, int expectedFlags) {
            super(device, BluetoothProfile.PAN, expectedFlags);

            mRole = role;
        }

        @DSSafe(DSCat.IPC_CALLBACK)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.577 -0400", hash_original_method = "16E4FCB6CB3F0259E1CE523CDAFAABF6", hash_generated_method = "EAF7E0CF4931262AC69B38301C9A5CF6")
        
@Override
        public void onReceive(Context context, Intent intent) {
            if (mRole != intent.getIntExtra(BluetoothPan.EXTRA_LOCAL_ROLE, -1)) {
                return;
            }

            super.onReceive(context, intent);
        }
    }

    private class StartStopScoReceiver extends FlagReceiver {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.579 -0400", hash_original_field = "0C75460D2D98D167C297C55D1550CF37", hash_generated_field = "E75EE3F11F2E80056E7031F78910BF55")

        private static final int STATE_CONNECTED_FLAG = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.581 -0400", hash_original_field = "22C1B8859423C3B4275FDA3B105CC4DF", hash_generated_field = "139882BF0BE532995436AE81B72FA662")

        private static final int STATE_DISCONNECTED_FLAG = 1 << 1;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.582 -0400", hash_original_method = "DF4D0330235578D317733877AF0FC5B8", hash_generated_method = "71AFB6EA8463E806972348ACBF709C03")
        
public StartStopScoReceiver(int expectedFlags) {
            super(expectedFlags);
        }

        @DSSafe(DSCat.IPC_CALLBACK)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.584 -0400", hash_original_method = "3A16938D08B9E77933F700F9D8B17E4D", hash_generated_method = "E4CC9072304BBC7685864CB166F6A779")
        
@Override
        public void onReceive(Context context, Intent intent) {
            if (AudioManager.ACTION_SCO_AUDIO_STATE_UPDATED.equals(intent.getAction())) {
                int state = intent.getIntExtra(AudioManager.EXTRA_SCO_AUDIO_STATE,
                        AudioManager.SCO_AUDIO_STATE_ERROR);
                assertNotSame(AudioManager.SCO_AUDIO_STATE_ERROR, state);
                switch(state) {
                    case AudioManager.SCO_AUDIO_STATE_CONNECTED:
                        setFiredFlag(STATE_CONNECTED_FLAG);
                        break;
                    case AudioManager.SCO_AUDIO_STATE_DISCONNECTED:
                        setFiredFlag(STATE_DISCONNECTED_FLAG);
                        break;
                }
            }
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.592 -0400", hash_original_field = "C355CA7426EE39CD66733A35FD2B05F4", hash_generated_field = "859AA50FE4EFB38CAC31689672EF9745")

    private BluetoothProfile.ServiceListener mServiceListener =
            new BluetoothProfile.ServiceListener() {
        @Override
        public void onServiceConnected(int profile, BluetoothProfile proxy) {
            synchronized (this) {
                switch (profile) {
                    case BluetoothProfile.A2DP:
                        mA2dp = (BluetoothA2dp) proxy;
                        break;
                    case BluetoothProfile.HEADSET:
                        mHeadset = (BluetoothHeadset) proxy;
                        break;
                    case BluetoothProfile.INPUT_DEVICE:
                        mInput = (BluetoothInputDevice) proxy;
                        break;
                    case BluetoothProfile.PAN:
                        mPan = (BluetoothPan) proxy;
                        break;
                }
            }
        }

        @Override
        public void onServiceDisconnected(int profile) {
            synchronized (this) {
                switch (profile) {
                    case BluetoothProfile.A2DP:
                        mA2dp = null;
                        break;
                    case BluetoothProfile.HEADSET:
                        mHeadset = null;
                        break;
                    case BluetoothProfile.INPUT_DEVICE:
                        mInput = null;
                        break;
                    case BluetoothProfile.PAN:
                        mPan = null;
                        break;
                }
            }
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.593 -0400", hash_original_field = "AF0C31E22D91F0A3FF7706E84C57ACF5", hash_generated_field = "57C239A8D629E793653F8820A0293846")

    private List<BroadcastReceiver> mReceivers = new ArrayList<BroadcastReceiver>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.595 -0400", hash_original_field = "28B83B9653005F5469FB1FEA8B002867", hash_generated_field = "EDEAE859CCBCC94F81FF558FFD9EA39B")

    private BufferedWriter mOutputWriter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.596 -0400", hash_original_field = "05B32B05746742D3A5261C827E7D8852", hash_generated_field = "0950070738D23525D6B35F116326FC98")

    private String mTag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.598 -0400", hash_original_field = "A1F5933AB00BF54A33AB8CA10DCB980A", hash_generated_field = "CAE1B35D3909623BE7437572B51B1062")

    private String mOutputFile;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.599 -0400", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.601 -0400", hash_original_field = "9704B6351549C051CC5CCFF08F4038E9", hash_generated_field = "B8A0E37D8036B450E0B783CADB8E0068")

    private BluetoothA2dp mA2dp = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.602 -0400", hash_original_field = "D6D472081D2E1634A5C7E30643671F34", hash_generated_field = "C2DA1267F4F1D03442608C09D776C166")

    private BluetoothHeadset mHeadset = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.604 -0400", hash_original_field = "5268F5FD1D1D72FD6DFCCFEF0D15EF41", hash_generated_field = "477F4263585C495D19F4B1836CB2349F")

    private BluetoothInputDevice mInput = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.605 -0400", hash_original_field = "54A476D8014BB212DE866CACF4919719", hash_generated_field = "50C5F84C4C4551EEBF0D1CF85D01F7F6")

    private BluetoothPan mPan = null;

    /**
     * Creates a utility instance for testing Bluetooth.
     *
     * @param context The context of the application using the utility.
     * @param tag The log tag of the application using the utility.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.606 -0400", hash_original_method = "791E08A45566A26326C335590ACE3F05", hash_generated_method = "97AA94405EA75C0F44551E28D8F18EF2")
    
public BluetoothTestUtils(Context context, String tag) {
        this(context, tag, null);
    }

    /**
     * Creates a utility instance for testing Bluetooth.
     *
     * @param context The context of the application using the utility.
     * @param tag The log tag of the application using the utility.
     * @param outputFile The path to an output file if the utility is to write results to a
     *        separate file.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.608 -0400", hash_original_method = "4810FC5CE3CAB0CAD1200C5A2A6DEBB2", hash_generated_method = "E6ED5A98613FAFF75741DD77BAA51BD3")
    
public BluetoothTestUtils(Context context, String tag, String outputFile) {
        mContext = context;
        mTag = tag;
        mOutputFile = outputFile;

        if (mOutputFile == null) {
            mOutputWriter = null;
        } else {
            try {
                mOutputWriter = new BufferedWriter(new FileWriter(new File(
                        Environment.getExternalStorageDirectory(), mOutputFile), true));
            } catch (IOException e) {
                Log.w(mTag, "Test output file could not be opened", e);
                mOutputWriter = null;
            }
        }
    }

    /**
     * Closes the utility instance and unregisters any BroadcastReceivers.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.610 -0400", hash_original_method = "D3E288ED7DA392D21CF8B22BB98C6758", hash_generated_method = "961E16E1A324629EAA5334AC9283309F")
    
public void close() {
        while (!mReceivers.isEmpty()) {
            mContext.unregisterReceiver(mReceivers.remove(0));
        }

        if (mOutputWriter != null) {
            try {
                mOutputWriter.close();
            } catch (IOException e) {
                Log.w(mTag, "Test output file could not be closed", e);
            }
        }
    }

    /**
     * Enables Bluetooth and checks to make sure that Bluetooth was turned on and that the correct
     * actions were broadcast.
     *
     * @param adapter The BT adapter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.612 -0400", hash_original_method = "D336BDB6264C4835A6DCD28216EF4935", hash_generated_method = "7A5A1E56A7E371652DBBF49CCF9E5ECC")
    
public void enable(BluetoothAdapter adapter) {
        int mask = (BluetoothReceiver.STATE_TURNING_ON_FLAG | BluetoothReceiver.STATE_ON_FLAG
                | BluetoothReceiver.SCAN_MODE_CONNECTABLE_FLAG);
        long start = -1;
        BluetoothReceiver receiver = getBluetoothReceiver(mask);

        int state = adapter.getState();
        switch (state) {
            case BluetoothAdapter.STATE_ON:
                assertTrue(adapter.isEnabled());
                removeReceiver(receiver);
                return;
            case BluetoothAdapter.STATE_TURNING_ON:
                assertFalse(adapter.isEnabled());
                mask = 0; // Don't check for received intents since we might have missed them.
                break;
            case BluetoothAdapter.STATE_OFF:
                assertFalse(adapter.isEnabled());
                start = System.currentTimeMillis();
                assertTrue(adapter.enable());
                break;
            case BluetoothAdapter.STATE_TURNING_OFF:
                start = System.currentTimeMillis();
                assertTrue(adapter.enable());
                break;
            default:
                removeReceiver(receiver);
                fail(String.format("enable() invalid state: state=%d", state));
        }

        long s = System.currentTimeMillis();
        while (System.currentTimeMillis() - s < ENABLE_DISABLE_TIMEOUT) {
            state = adapter.getState();
            if (state == BluetoothAdapter.STATE_ON
                    && (receiver.getFiredFlags() & mask) == mask) {
                assertTrue(adapter.isEnabled());
                long finish = receiver.getCompletedTime();
                if (start != -1 && finish != -1) {
                    writeOutput(String.format("enable() completed in %d ms", (finish - start)));
                } else {
                    writeOutput("enable() completed");
                }
                removeReceiver(receiver);
                return;
            }
            sleep(POLL_TIME);
        }

        int firedFlags = receiver.getFiredFlags();
        removeReceiver(receiver);
        fail(String.format("enable() timeout: state=%d (expected %d), flags=0x%x (expected 0x%x)",
                state, BluetoothAdapter.STATE_ON, firedFlags, mask));
    }

    /**
     * Disables Bluetooth and checks to make sure that Bluetooth was turned off and that the correct
     * actions were broadcast.
     *
     * @param adapter The BT adapter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.615 -0400", hash_original_method = "2A0FCF54F736DE946C3E9250E9959E88", hash_generated_method = "E811732D32C39FBA7AE60F19F5BA0D3F")
    
public void disable(BluetoothAdapter adapter) {
        int mask = (BluetoothReceiver.STATE_TURNING_OFF_FLAG | BluetoothReceiver.STATE_OFF_FLAG
                | BluetoothReceiver.SCAN_MODE_NONE_FLAG);
        long start = -1;
        BluetoothReceiver receiver = getBluetoothReceiver(mask);

        int state = adapter.getState();
        switch (state) {
            case BluetoothAdapter.STATE_OFF:
                assertFalse(adapter.isEnabled());
                removeReceiver(receiver);
                return;
            case BluetoothAdapter.STATE_TURNING_ON:
                assertFalse(adapter.isEnabled());
                start = System.currentTimeMillis();
                break;
            case BluetoothAdapter.STATE_ON:
                assertTrue(adapter.isEnabled());
                start = System.currentTimeMillis();
                assertTrue(adapter.disable());
                break;
            case BluetoothAdapter.STATE_TURNING_OFF:
                assertFalse(adapter.isEnabled());
                mask = 0; // Don't check for received intents since we might have missed them.
                break;
            default:
                removeReceiver(receiver);
                fail(String.format("disable() invalid state: state=%d", state));
        }

        long s = System.currentTimeMillis();
        while (System.currentTimeMillis() - s < ENABLE_DISABLE_TIMEOUT) {
            state = adapter.getState();
            if (state == BluetoothAdapter.STATE_OFF
                    && (receiver.getFiredFlags() & mask) == mask) {
                assertFalse(adapter.isEnabled());
                long finish = receiver.getCompletedTime();
                if (start != -1 && finish != -1) {
                    writeOutput(String.format("disable() completed in %d ms", (finish - start)));
                } else {
                    writeOutput("disable() completed");
                }
                removeReceiver(receiver);
                return;
            }
            sleep(POLL_TIME);
        }

        int firedFlags = receiver.getFiredFlags();
        removeReceiver(receiver);
        fail(String.format("disable() timeout: state=%d (expected %d), flags=0x%x (expected 0x%x)",
                state, BluetoothAdapter.STATE_OFF, firedFlags, mask));
    }

    /**
     * Puts the local device into discoverable mode and checks to make sure that the local device
     * is in discoverable mode and that the correct actions were broadcast.
     *
     * @param adapter The BT adapter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.617 -0400", hash_original_method = "212895DE1CCC36D7FFE1E65C62845FF5", hash_generated_method = "0A836339B509C44EB6708BA33F85384C")
    
public void discoverable(BluetoothAdapter adapter) {
        int mask = BluetoothReceiver.SCAN_MODE_CONNECTABLE_DISCOVERABLE_FLAG;

        if (!adapter.isEnabled()) {
            fail("discoverable() bluetooth not enabled");
        }

        int scanMode = adapter.getScanMode();
        if (scanMode == BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE) {
            return;
        }

        BluetoothReceiver receiver = getBluetoothReceiver(mask);

        assertEquals(BluetoothAdapter.SCAN_MODE_CONNECTABLE, scanMode);
        long start = System.currentTimeMillis();
        assertTrue(adapter.setScanMode(BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE));

        while (System.currentTimeMillis() - start < DISCOVERABLE_UNDISCOVERABLE_TIMEOUT) {
            scanMode = adapter.getScanMode();
            if (scanMode == BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE
                    && (receiver.getFiredFlags() & mask) == mask) {
                writeOutput(String.format("discoverable() completed in %d ms",
                        (receiver.getCompletedTime() - start)));
                removeReceiver(receiver);
                return;
            }
            sleep(POLL_TIME);
        }

        int firedFlags = receiver.getFiredFlags();
        removeReceiver(receiver);
        fail(String.format("discoverable() timeout: scanMode=%d (expected %d), flags=0x%x "
                + "(expected 0x%x)", scanMode, BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE,
                firedFlags, mask));
    }

    /**
     * Puts the local device into connectable only mode and checks to make sure that the local
     * device is in in connectable mode and that the correct actions were broadcast.
     *
     * @param adapter The BT adapter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.619 -0400", hash_original_method = "D965BC25FEFA85E7AE63C2091AC1AA93", hash_generated_method = "C10458EEF3FB564B7915B3AE25B019F7")
    
public void undiscoverable(BluetoothAdapter adapter) {
        int mask = BluetoothReceiver.SCAN_MODE_CONNECTABLE_FLAG;

        if (!adapter.isEnabled()) {
            fail("undiscoverable() bluetooth not enabled");
        }

        int scanMode = adapter.getScanMode();
        if (scanMode == BluetoothAdapter.SCAN_MODE_CONNECTABLE) {
            return;
        }

        BluetoothReceiver receiver = getBluetoothReceiver(mask);

        assertEquals(BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE, scanMode);
        long start = System.currentTimeMillis();
        assertTrue(adapter.setScanMode(BluetoothAdapter.SCAN_MODE_CONNECTABLE));

        while (System.currentTimeMillis() - start < DISCOVERABLE_UNDISCOVERABLE_TIMEOUT) {
            scanMode = adapter.getScanMode();
            if (scanMode == BluetoothAdapter.SCAN_MODE_CONNECTABLE
                    && (receiver.getFiredFlags() & mask) == mask) {
                writeOutput(String.format("undiscoverable() completed in %d ms",
                        (receiver.getCompletedTime() - start)));
                removeReceiver(receiver);
                return;
            }
            sleep(POLL_TIME);
        }

        int firedFlags = receiver.getFiredFlags();
        removeReceiver(receiver);
        fail(String.format("undiscoverable() timeout: scanMode=%d (expected %d), flags=0x%x "
                + "(expected 0x%x)", scanMode, BluetoothAdapter.SCAN_MODE_CONNECTABLE, firedFlags,
                mask));
    }

    /**
     * Starts a scan for remote devices and checks to make sure that the local device is scanning
     * and that the correct actions were broadcast.
     *
     * @param adapter The BT adapter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.622 -0400", hash_original_method = "CEFDE0EF3FE1B2CFA787E6D45491343D", hash_generated_method = "7A7FFF2FB76331987BFC0676BD890002")
    
public void startScan(BluetoothAdapter adapter) {
        int mask = BluetoothReceiver.DISCOVERY_STARTED_FLAG;

        if (!adapter.isEnabled()) {
            fail("startScan() bluetooth not enabled");
        }

        if (adapter.isDiscovering()) {
            return;
        }

        BluetoothReceiver receiver = getBluetoothReceiver(mask);

        long start = System.currentTimeMillis();
        assertTrue(adapter.startDiscovery());

        while (System.currentTimeMillis() - start < START_STOP_SCAN_TIMEOUT) {
            if (adapter.isDiscovering() && ((receiver.getFiredFlags() & mask) == mask)) {
                writeOutput(String.format("startScan() completed in %d ms",
                        (receiver.getCompletedTime() - start)));
                removeReceiver(receiver);
                return;
            }
            sleep(POLL_TIME);
        }

        int firedFlags = receiver.getFiredFlags();
        removeReceiver(receiver);
        fail(String.format("startScan() timeout: isDiscovering=%b, flags=0x%x (expected 0x%x)",
                adapter.isDiscovering(), firedFlags, mask));
    }

    /**
     * Stops a scan for remote devices and checks to make sure that the local device is not scanning
     * and that the correct actions were broadcast.
     *
     * @param adapter The BT adapter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.624 -0400", hash_original_method = "5755012F577381A327BAD069BD8E4F93", hash_generated_method = "DEA36B2371ABE056C2401C96D65C9F7E")
    
public void stopScan(BluetoothAdapter adapter) {
        int mask = BluetoothReceiver.DISCOVERY_FINISHED_FLAG;

        if (!adapter.isEnabled()) {
            fail("stopScan() bluetooth not enabled");
        }

        if (!adapter.isDiscovering()) {
            return;
        }

        BluetoothReceiver receiver = getBluetoothReceiver(mask);

        long start = System.currentTimeMillis();
        assertTrue(adapter.cancelDiscovery());

        while (System.currentTimeMillis() - start < START_STOP_SCAN_TIMEOUT) {
            if (!adapter.isDiscovering() && ((receiver.getFiredFlags() & mask) == mask)) {
                writeOutput(String.format("stopScan() completed in %d ms",
                        (receiver.getCompletedTime() - start)));
                removeReceiver(receiver);
                return;
            }
            sleep(POLL_TIME);
        }

        int firedFlags = receiver.getFiredFlags();
        removeReceiver(receiver);
        fail(String.format("stopScan() timeout: isDiscovering=%b, flags=0x%x (expected 0x%x)",
                adapter.isDiscovering(), firedFlags, mask));

    }

    /**
     * Enables PAN tethering on the local device and checks to make sure that tethering is enabled.
     *
     * @param adapter The BT adapter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.626 -0400", hash_original_method = "F6F7C5047DC0414882B99A9BDC4D3E2F", hash_generated_method = "EF2B772175AAE8D3466D59DBE8AC7D90")
    
public void enablePan(BluetoothAdapter adapter) {
        if (mPan == null) mPan = (BluetoothPan) connectProxy(adapter, BluetoothProfile.PAN);
        assertNotNull(mPan);

        long start = System.currentTimeMillis();
        mPan.setBluetoothTethering(true);
        long stop = System.currentTimeMillis();
        assertTrue(mPan.isTetheringOn());

        writeOutput(String.format("enablePan() completed in %d ms", (stop - start)));
    }

    /**
     * Disables PAN tethering on the local device and checks to make sure that tethering is
     * disabled.
     *
     * @param adapter The BT adapter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.627 -0400", hash_original_method = "3D881A9B82B3E29872B09F1BBABE8E3B", hash_generated_method = "8C81DCE5D4B2B381565BFD5582C26DF2")
    
public void disablePan(BluetoothAdapter adapter) {
        if (mPan == null) mPan = (BluetoothPan) connectProxy(adapter, BluetoothProfile.PAN);
        assertNotNull(mPan);

        long start = System.currentTimeMillis();
        mPan.setBluetoothTethering(false);
        long stop = System.currentTimeMillis();
        assertFalse(mPan.isTetheringOn());

        writeOutput(String.format("disablePan() completed in %d ms", (stop - start)));
    }

    /**
     * Initiates a pairing with a remote device and checks to make sure that the devices are paired
     * and that the correct actions were broadcast.
     *
     * @param adapter The BT adapter.
     * @param device The remote device.
     * @param passkey The pairing passkey if pairing requires a passkey. Any value if not.
     * @param pin The pairing pin if pairing requires a pin. Any value if not.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.629 -0400", hash_original_method = "618D7845515FD0AE91AC232728DBE8EB", hash_generated_method = "10A12555120830F4CD4383CA872BA8B8")
    
public void pair(BluetoothAdapter adapter, BluetoothDevice device, int passkey, byte[] pin) {
        pairOrAcceptPair(adapter, device, passkey, pin, true);
    }

    /**
     * Accepts a pairing with a remote device and checks to make sure that the devices are paired
     * and that the correct actions were broadcast.
     *
     * @param adapter The BT adapter.
     * @param device The remote device.
     * @param passkey The pairing passkey if pairing requires a passkey. Any value if not.
     * @param pin The pairing pin if pairing requires a pin. Any value if not.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.630 -0400", hash_original_method = "E8FD9AD99663D9910B261ED2A09CD1DD", hash_generated_method = "5ECB5540B212C82C9038F5E797456C69")
    
public void acceptPair(BluetoothAdapter adapter, BluetoothDevice device, int passkey,
            byte[] pin) {
        pairOrAcceptPair(adapter, device, passkey, pin, false);
    }

    /**
     * Helper method used by {@link #pair(BluetoothAdapter, BluetoothDevice, int, byte[])} and
     * {@link #acceptPair(BluetoothAdapter, BluetoothDevice, int, byte[])} to either pair or accept
     * a pairing request.
     *
     * @param adapter The BT adapter.
     * @param device The remote device.
     * @param passkey The pairing passkey if pairing requires a passkey. Any value if not.
     * @param pin The pairing pin if pairing requires a pin. Any value if not.
     * @param shouldPair Whether to pair or accept the pair.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.633 -0400", hash_original_method = "FFC71030834B1914B071B8A19A2359D5", hash_generated_method = "1D468C7FB94B20E7317D0707B0881F8D")
    
private void pairOrAcceptPair(BluetoothAdapter adapter, BluetoothDevice device, int passkey,
            byte[] pin, boolean shouldPair) {
        int mask = PairReceiver.STATE_BONDING_FLAG | PairReceiver.STATE_BONDED_FLAG;
        long start = -1;
        String methodName;
        if (shouldPair) {
            methodName = String.format("pair(device=%s)", device);
        } else {
            methodName = String.format("acceptPair(device=%s)", device);
        }

        if (!adapter.isEnabled()) {
            fail(String.format("%s bluetooth not enabled", methodName));
        }

        PairReceiver receiver = getPairReceiver(device, passkey, pin, mask);

        int state = device.getBondState();
        switch (state) {
            case BluetoothDevice.BOND_NONE:
                assertFalse(adapter.getBondedDevices().contains(device));
                start = System.currentTimeMillis();
                if (shouldPair) {
                    assertTrue(device.createBond());
                }
                break;
            case BluetoothDevice.BOND_BONDING:
                mask = 0; // Don't check for received intents since we might have missed them.
                break;
            case BluetoothDevice.BOND_BONDED:
                assertTrue(adapter.getBondedDevices().contains(device));
                return;
            default:
                removeReceiver(receiver);
                fail(String.format("%s invalid state: state=%d", methodName, state));
        }

        long s = System.currentTimeMillis();
        while (System.currentTimeMillis() - s < PAIR_UNPAIR_TIMEOUT) {
            state = device.getBondState();
            if (state == BluetoothDevice.BOND_BONDED && (receiver.getFiredFlags() & mask) == mask) {
                assertTrue(adapter.getBondedDevices().contains(device));
                long finish = receiver.getCompletedTime();
                if (start != -1 && finish != -1) {
                    writeOutput(String.format("%s completed in %d ms", methodName,
                            (finish - start)));
                } else {
                    writeOutput(String.format("%s completed", methodName));
                }
                removeReceiver(receiver);
                return;
            }
            sleep(POLL_TIME);
        }

        int firedFlags = receiver.getFiredFlags();
        removeReceiver(receiver);
        fail(String.format("%s timeout: state=%d (expected %d), flags=0x%x (expected 0x%x)",
                methodName, state, BluetoothDevice.BOND_BONDED, firedFlags, mask));
    }

    /**
     * Deletes a pairing with a remote device and checks to make sure that the devices are unpaired
     * and that the correct actions were broadcast.
     *
     * @param adapter The BT adapter.
     * @param device The remote device.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.635 -0400", hash_original_method = "41DE7E9291E165505FD6159A9B7D109B", hash_generated_method = "56C69BBE50704687FC94FD42A384CBE0")
    
public void unpair(BluetoothAdapter adapter, BluetoothDevice device) {
        int mask = PairReceiver.STATE_NONE_FLAG;
        long start = -1;
        String methodName = String.format("unpair(device=%s)", device);

        if (!adapter.isEnabled()) {
            fail(String.format("%s bluetooth not enabled", methodName));
        }

        PairReceiver receiver = getPairReceiver(device, 0, null, mask);

        int state = device.getBondState();
        switch (state) {
            case BluetoothDevice.BOND_NONE:
                assertFalse(adapter.getBondedDevices().contains(device));
                removeReceiver(receiver);
                return;
            case BluetoothDevice.BOND_BONDING:
                start = System.currentTimeMillis();
                assertTrue(device.removeBond());
                break;
            case BluetoothDevice.BOND_BONDED:
                assertTrue(adapter.getBondedDevices().contains(device));
                start = System.currentTimeMillis();
                assertTrue(device.removeBond());
                break;
            default:
                removeReceiver(receiver);
                fail(String.format("%s invalid state: state=%d", methodName, state));
        }

        long s = System.currentTimeMillis();
        while (System.currentTimeMillis() - s < PAIR_UNPAIR_TIMEOUT) {
            if (device.getBondState() == BluetoothDevice.BOND_NONE
                    && (receiver.getFiredFlags() & mask) == mask) {
                assertFalse(adapter.getBondedDevices().contains(device));
                long finish = receiver.getCompletedTime();
                if (start != -1 && finish != -1) {
                    writeOutput(String.format("%s completed in %d ms", methodName,
                            (finish - start)));
                } else {
                    writeOutput(String.format("%s completed", methodName));
                }
                removeReceiver(receiver);
                return;
            }
        }

        int firedFlags = receiver.getFiredFlags();
        removeReceiver(receiver);
        fail(String.format("%s timeout: state=%d (expected %d), flags=0x%x (expected 0x%x)",
                methodName, state, BluetoothDevice.BOND_BONDED, firedFlags, mask));
    }

    /**
     * Connects a profile from the local device to a remote device and checks to make sure that the
     * profile is connected and that the correct actions were broadcast.
     *
     * @param adapter The BT adapter.
     * @param device The remote device.
     * @param profile The profile to connect. One of {@link BluetoothProfile#A2DP},
     * {@link BluetoothProfile#HEADSET}, or {@link BluetoothProfile#INPUT_DEVICE}.
     * @param methodName The method name to printed in the logs.  If null, will be
     * "connectProfile(profile=&lt;profile&gt;, device=&lt;device&gt;)"
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.639 -0400", hash_original_method = "A3922F798A699BD1261828ED58232695", hash_generated_method = "E31C392EAAE382AF74C455E2DB2BCA76")
    
public void connectProfile(BluetoothAdapter adapter, BluetoothDevice device, int profile,
            String methodName) {
        if (methodName == null) {
            methodName = String.format("connectProfile(profile=%d, device=%s)", profile, device);
        }
        int mask = (ConnectProfileReceiver.STATE_CONNECTING_FLAG
                | ConnectProfileReceiver.STATE_CONNECTED_FLAG);
        long start = -1;

        if (!adapter.isEnabled()) {
            fail(String.format("%s bluetooth not enabled", methodName));
        }

        if (!adapter.getBondedDevices().contains(device)) {
            fail(String.format("%s device not paired", methodName));
        }

        BluetoothProfile proxy = connectProxy(adapter, profile);
        assertNotNull(proxy);

        ConnectProfileReceiver receiver = getConnectProfileReceiver(device, profile, mask);

        int state = proxy.getConnectionState(device);
        switch (state) {
            case BluetoothProfile.STATE_CONNECTED:
                removeReceiver(receiver);
                return;
            case BluetoothProfile.STATE_CONNECTING:
                mask = 0; // Don't check for received intents since we might have missed them.
                break;
            case BluetoothProfile.STATE_DISCONNECTED:
            case BluetoothProfile.STATE_DISCONNECTING:
                start = System.currentTimeMillis();
                if (profile == BluetoothProfile.A2DP) {
                    assertTrue(((BluetoothA2dp)proxy).connect(device));
                } else if (profile == BluetoothProfile.HEADSET) {
                    assertTrue(((BluetoothHeadset)proxy).connect(device));
                } else if (profile == BluetoothProfile.INPUT_DEVICE) {
                    assertTrue(((BluetoothInputDevice)proxy).connect(device));
                }
                break;
            default:
                removeReceiver(receiver);
                fail(String.format("%s invalid state: state=%d", methodName, state));
        }

        long s = System.currentTimeMillis();
        while (System.currentTimeMillis() - s < CONNECT_DISCONNECT_PROFILE_TIMEOUT) {
            state = proxy.getConnectionState(device);
            if (state == BluetoothProfile.STATE_CONNECTED
                    && (receiver.getFiredFlags() & mask) == mask) {
                long finish = receiver.getCompletedTime();
                if (start != -1 && finish != -1) {
                    writeOutput(String.format("%s completed in %d ms", methodName,
                            (finish - start)));
                } else {
                    writeOutput(String.format("%s completed", methodName));
                }
                removeReceiver(receiver);
                return;
            }
            sleep(POLL_TIME);
        }

        int firedFlags = receiver.getFiredFlags();
        removeReceiver(receiver);
        fail(String.format("%s timeout: state=%d (expected %d), flags=0x%x (expected 0x%x)",
                methodName, state, BluetoothProfile.STATE_CONNECTED, firedFlags, mask));
    }

    /**
     * Disconnects a profile between the local device and a remote device and checks to make sure
     * that the profile is disconnected and that the correct actions were broadcast.
     *
     * @param adapter The BT adapter.
     * @param device The remote device.
     * @param profile The profile to disconnect. One of {@link BluetoothProfile#A2DP},
     * {@link BluetoothProfile#HEADSET}, or {@link BluetoothProfile#INPUT_DEVICE}.
     * @param methodName The method name to printed in the logs.  If null, will be
     * "connectProfile(profile=&lt;profile&gt;, device=&lt;device&gt;)"
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.642 -0400", hash_original_method = "821BC76B6DA9B55C8308AD5BC14665AA", hash_generated_method = "DF94B0048DB84440DBEBA621E3076A47")
    
public void disconnectProfile(BluetoothAdapter adapter, BluetoothDevice device, int profile,
            String methodName) {
        if (methodName == null) {
            methodName = String.format("disconnectProfile(profile=%d, device=%s)", profile, device);
        }
        int mask = (ConnectProfileReceiver.STATE_DISCONNECTING_FLAG
                | ConnectProfileReceiver.STATE_DISCONNECTED_FLAG);
        long start = -1;

        if (!adapter.isEnabled()) {
            fail(String.format("%s bluetooth not enabled", methodName));
        }

        if (!adapter.getBondedDevices().contains(device)) {
            fail(String.format("%s device not paired", methodName));
        }

        BluetoothProfile proxy = connectProxy(adapter, profile);
        assertNotNull(proxy);

        ConnectProfileReceiver receiver = getConnectProfileReceiver(device, profile, mask);

        int state = proxy.getConnectionState(device);
        switch (state) {
            case BluetoothProfile.STATE_CONNECTED:
            case BluetoothProfile.STATE_CONNECTING:
                start = System.currentTimeMillis();
                if (profile == BluetoothProfile.A2DP) {
                    assertTrue(((BluetoothA2dp)proxy).disconnect(device));
                } else if (profile == BluetoothProfile.HEADSET) {
                    assertTrue(((BluetoothHeadset)proxy).disconnect(device));
                } else if (profile == BluetoothProfile.INPUT_DEVICE) {
                    assertTrue(((BluetoothInputDevice)proxy).disconnect(device));
                }
                break;
            case BluetoothProfile.STATE_DISCONNECTED:
                removeReceiver(receiver);
                return;
            case BluetoothProfile.STATE_DISCONNECTING:
                mask = 0; // Don't check for received intents since we might have missed them.
                break;
            default:
                removeReceiver(receiver);
                fail(String.format("%s invalid state: state=%d", methodName, state));
        }

        long s = System.currentTimeMillis();
        while (System.currentTimeMillis() - s < CONNECT_DISCONNECT_PROFILE_TIMEOUT) {
            state = proxy.getConnectionState(device);
            if (state == BluetoothProfile.STATE_DISCONNECTED
                    && (receiver.getFiredFlags() & mask) == mask) {
                long finish = receiver.getCompletedTime();
                if (start != -1 && finish != -1) {
                    writeOutput(String.format("%s completed in %d ms", methodName,
                            (finish - start)));
                } else {
                    writeOutput(String.format("%s completed", methodName));
                }
                removeReceiver(receiver);
                return;
            }
            sleep(POLL_TIME);
        }

        int firedFlags = receiver.getFiredFlags();
        removeReceiver(receiver);
        fail(String.format("%s timeout: state=%d (expected %d), flags=0x%x (expected 0x%x)",
                methodName, state, BluetoothProfile.STATE_DISCONNECTED, firedFlags, mask));
    }

    /**
     * Connects the PANU to a remote NAP and checks to make sure that the PANU is connected and that
     * the correct actions were broadcast.
     *
     * @param adapter The BT adapter.
     * @param device The remote device.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.643 -0400", hash_original_method = "37E512958F900B7FF1FC89E8F78EB9E1", hash_generated_method = "A2C5966E3B91C706083CA92FFA4B198C")
    
public void connectPan(BluetoothAdapter adapter, BluetoothDevice device) {
        connectPanOrIncomingPanConnection(adapter, device, true);
    }

    /**
     * Checks that a remote PANU connects to the local NAP correctly and that the correct actions
     * were broadcast.
     *
     * @param adapter The BT adapter.
     * @param device The remote device.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.645 -0400", hash_original_method = "E46607BFB7F04DB7D8CE36C6CC4FB9FC", hash_generated_method = "99F04E8EBD2AA5F8F1B97CCE695C2A79")
    
public void incomingPanConnection(BluetoothAdapter adapter, BluetoothDevice device) {
        connectPanOrIncomingPanConnection(adapter, device, false);
    }

    /**
     * Helper method used by {@link #connectPan(BluetoothAdapter, BluetoothDevice)} and
     * {@link #incomingPanConnection(BluetoothAdapter, BluetoothDevice)} to either connect to a
     * remote NAP or verify that a remote device connected to the local NAP.
     *
     * @param adapter The BT adapter.
     * @param device The remote device.
     * @param connect If the method should initiate the connection (is PANU)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.648 -0400", hash_original_method = "94B3B13489584430150E739F6BDD1594", hash_generated_method = "0B59436FDF5C27F4ED124611D885EF5B")
    
private void connectPanOrIncomingPanConnection(BluetoothAdapter adapter, BluetoothDevice device,
            boolean connect) {
        long start = -1;
        int mask, role;
        String methodName;

        if (connect) {
            methodName = String.format("connectPan(device=%s)", device);
            mask = (ConnectProfileReceiver.STATE_CONNECTED_FLAG |
                    ConnectProfileReceiver.STATE_CONNECTING_FLAG);
            role = BluetoothPan.LOCAL_PANU_ROLE;
        } else {
            methodName = String.format("incomingPanConnection(device=%s)", device);
            mask = ConnectProfileReceiver.STATE_CONNECTED_FLAG;
            role = BluetoothPan.LOCAL_NAP_ROLE;
        }

        if (!adapter.isEnabled()) {
            fail(String.format("%s bluetooth not enabled", methodName));
        }

        if (!adapter.getBondedDevices().contains(device)) {
            fail(String.format("%s device not paired", methodName));
        }

        mPan = (BluetoothPan) connectProxy(adapter, BluetoothProfile.PAN);
        assertNotNull(mPan);
        ConnectPanReceiver receiver = getConnectPanReceiver(device, role, mask);

        int state = mPan.getConnectionState(device);
        switch (state) {
            case BluetoothPan.STATE_CONNECTED:
                removeReceiver(receiver);
                return;
            case BluetoothPan.STATE_CONNECTING:
                mask = 0; // Don't check for received intents since we might have missed them.
                break;
            case BluetoothPan.STATE_DISCONNECTED:
            case BluetoothPan.STATE_DISCONNECTING:
                start = System.currentTimeMillis();
                if (role == BluetoothPan.LOCAL_PANU_ROLE) {
                    Log.i("BT", "connect to pan");
                    assertTrue(mPan.connect(device));
                }
                break;
            default:
                removeReceiver(receiver);
                fail(String.format("%s invalid state: state=%d", methodName, state));
        }

        long s = System.currentTimeMillis();
        while (System.currentTimeMillis() - s < CONNECT_DISCONNECT_PROFILE_TIMEOUT) {
            state = mPan.getConnectionState(device);
            if (state == BluetoothPan.STATE_CONNECTED
                    && (receiver.getFiredFlags() & mask) == mask) {
                long finish = receiver.getCompletedTime();
                if (start != -1 && finish != -1) {
                    writeOutput(String.format("%s completed in %d ms", methodName,
                            (finish - start)));
                } else {
                    writeOutput(String.format("%s completed", methodName));
                }
                removeReceiver(receiver);
                return;
            }
            sleep(POLL_TIME);
        }

        int firedFlags = receiver.getFiredFlags();
        removeReceiver(receiver);
        fail(String.format("%s timeout: state=%d (expected %d), flags=0x%x (expected 0x%s)",
                methodName, state, BluetoothPan.STATE_CONNECTED, firedFlags, mask));
    }

    /**
     * Disconnects the PANU from a remote NAP and checks to make sure that the PANU is disconnected
     * and that the correct actions were broadcast.
     *
     * @param adapter The BT adapter.
     * @param device The remote device.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.649 -0400", hash_original_method = "F60E13505FCE1E961698F4203CCAFE54", hash_generated_method = "A5305ECD0684874B33102094E29FF6FD")
    
public void disconnectPan(BluetoothAdapter adapter, BluetoothDevice device) {
        disconnectFromRemoteOrVerifyConnectNap(adapter, device, true);
    }

    /**
     * Checks that a remote PANU disconnects from the local NAP correctly and that the correct
     * actions were broadcast.
     *
     * @param adapter The BT adapter.
     * @param device The remote device.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.650 -0400", hash_original_method = "BD3079305B0DD44F3DF81179FC62E7EA", hash_generated_method = "39BB80CE54386C58EC6787A9B88E5371")
    
public void incomingPanDisconnection(BluetoothAdapter adapter, BluetoothDevice device) {
        disconnectFromRemoteOrVerifyConnectNap(adapter, device, false);
    }

    /**
     * Helper method used by {@link #disconnectPan(BluetoothAdapter, BluetoothDevice)} and
     * {@link #incomingPanDisconnection(BluetoothAdapter, BluetoothDevice)} to either disconnect
     * from a remote NAP or verify that a remote device disconnected from the local NAP.
     *
     * @param adapter The BT adapter.
     * @param device The remote device.
     * @param disconnect Whether the method should connect or verify.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.653 -0400", hash_original_method = "C324969DA7DBF44C0521780E7D066724", hash_generated_method = "99CA57A08D4D701D29B9BB3CE12640E6")
    
private void disconnectFromRemoteOrVerifyConnectNap(BluetoothAdapter adapter,
            BluetoothDevice device, boolean disconnect) {
        long start = -1;
        int mask, role;
        String methodName;

        if (disconnect) {
            methodName = String.format("disconnectPan(device=%s)", device);
            mask = (ConnectProfileReceiver.STATE_DISCONNECTED_FLAG |
                    ConnectProfileReceiver.STATE_DISCONNECTING_FLAG);
            role = BluetoothPan.LOCAL_PANU_ROLE;
        } else {
            methodName = String.format("incomingPanDisconnection(device=%s)", device);
            mask = ConnectProfileReceiver.STATE_DISCONNECTED_FLAG;
            role = BluetoothPan.LOCAL_NAP_ROLE;
        }

        if (!adapter.isEnabled()) {
            fail(String.format("%s bluetooth not enabled", methodName));
        }

        if (!adapter.getBondedDevices().contains(device)) {
            fail(String.format("%s device not paired", methodName));
        }

        mPan = (BluetoothPan) connectProxy(adapter, BluetoothProfile.PAN);
        assertNotNull(mPan);
        ConnectPanReceiver receiver = getConnectPanReceiver(device, role, mask);

        int state = mPan.getConnectionState(device);
        switch (state) {
            case BluetoothPan.STATE_CONNECTED:
            case BluetoothPan.STATE_CONNECTING:
                start = System.currentTimeMillis();
                if (role == BluetoothPan.LOCAL_PANU_ROLE) {
                    assertTrue(mPan.disconnect(device));
                }
                break;
            case BluetoothPan.STATE_DISCONNECTED:
                removeReceiver(receiver);
                return;
            case BluetoothPan.STATE_DISCONNECTING:
                mask = 0; // Don't check for received intents since we might have missed them.
                break;
            default:
                removeReceiver(receiver);
                fail(String.format("%s invalid state: state=%d", methodName, state));
        }

        long s = System.currentTimeMillis();
        while (System.currentTimeMillis() - s < CONNECT_DISCONNECT_PROFILE_TIMEOUT) {
            state = mPan.getConnectionState(device);
            if (state == BluetoothInputDevice.STATE_DISCONNECTED
                    && (receiver.getFiredFlags() & mask) == mask) {
                long finish = receiver.getCompletedTime();
                if (start != -1 && finish != -1) {
                    writeOutput(String.format("%s completed in %d ms", methodName,
                            (finish - start)));
                } else {
                    writeOutput(String.format("%s completed", methodName));
                }
                removeReceiver(receiver);
                return;
            }
            sleep(POLL_TIME);
        }

        int firedFlags = receiver.getFiredFlags();
        removeReceiver(receiver);
        fail(String.format("%s timeout: state=%d (expected %d), flags=0x%x (expected 0x%s)",
                methodName, state, BluetoothInputDevice.STATE_DISCONNECTED, firedFlags, mask));
    }

    /**
     * Opens a SCO channel using {@link android.media.AudioManager#startBluetoothSco()} and checks
     * to make sure that the channel is opened and that the correct actions were broadcast.
     *
     * @param adapter The BT adapter.
     * @param device The remote device.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.654 -0400", hash_original_method = "4882F43BEDAA151D1FC9AFC7601F4FE1", hash_generated_method = "51689CC70C3FB5EA575477B1621A104D")
    
public void startSco(BluetoothAdapter adapter, BluetoothDevice device) {
        startStopSco(adapter, device, true);
    }

    /**
     * Closes a SCO channel using {@link android.media.AudioManager#stopBluetoothSco()} and checks
     *  to make sure that the channel is closed and that the correct actions were broadcast.
     *
     * @param adapter The BT adapter.
     * @param device The remote device.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.656 -0400", hash_original_method = "557BF9FAF9543631EAC460415F60E60A", hash_generated_method = "13D441333DAC6EFF69ADCA38C1C76BED")
    
public void stopSco(BluetoothAdapter adapter, BluetoothDevice device) {
        startStopSco(adapter, device, false);
    }
    /**
     * Helper method for {@link #startSco(BluetoothAdapter, BluetoothDevice)} and
     * {@link #stopSco(BluetoothAdapter, BluetoothDevice)}.
     *
     * @param adapter The BT adapter.
     * @param device The remote device.
     * @param isStart Whether the SCO channel should be opened.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.658 -0400", hash_original_method = "D2C8F355BEBD2E7B23DCC48FB9408ACF", hash_generated_method = "118BF6997A86C773FC72DBF96512A510")
    
private void startStopSco(BluetoothAdapter adapter, BluetoothDevice device, boolean isStart) {
        long start = -1;
        int mask;
        String methodName;

        if (isStart) {
            methodName = String.format("startSco(device=%s)", device);
            mask = StartStopScoReceiver.STATE_CONNECTED_FLAG;
        } else {
            methodName = String.format("stopSco(device=%s)", device);
            mask = StartStopScoReceiver.STATE_DISCONNECTED_FLAG;
        }

        if (!adapter.isEnabled()) {
            fail(String.format("%s bluetooth not enabled", methodName));
        }

        if (!adapter.getBondedDevices().contains(device)) {
            fail(String.format("%s device not paired", methodName));
        }

        AudioManager manager = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
        assertNotNull(manager);

        if (!manager.isBluetoothScoAvailableOffCall()) {
            fail(String.format("%s device does not support SCO", methodName));
        }

        boolean isScoOn = manager.isBluetoothScoOn();
        if (isStart == isScoOn) {
            return;
        }

        StartStopScoReceiver receiver = getStartStopScoReceiver(mask);
        start = System.currentTimeMillis();
        if (isStart) {
            manager.startBluetoothSco();
        } else {
            manager.stopBluetoothSco();
        }

        long s = System.currentTimeMillis();
        while (System.currentTimeMillis() - s < START_STOP_SCO_TIMEOUT) {
            isScoOn = manager.isBluetoothScoOn();
            if (isStart == isScoOn && (receiver.getFiredFlags() & mask) == mask) {
                long finish = receiver.getCompletedTime();
                if (start != -1 && finish != -1) {
                    writeOutput(String.format("%s completed in %d ms", methodName,
                            (finish - start)));
                } else {
                    writeOutput(String.format("%s completed", methodName));
                }
                removeReceiver(receiver);
                return;
            }
            sleep(POLL_TIME);
        }

        int firedFlags = receiver.getFiredFlags();
        removeReceiver(receiver);
        fail(String.format("%s timeout: on=%b (expected %b), flags=0x%x (expected 0x%x)",
                methodName, isScoOn, isStart, firedFlags, mask));
    }

    /**
     * Writes a string to the logcat and a file if a file has been specified in the constructor.
     *
     * @param s The string to be written.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.660 -0400", hash_original_method = "E77DBB99AAC63689C49F05C858C64BFD", hash_generated_method = "A1D2F48185745E5BB5164E4391467486")
    
public void writeOutput(String s) {
        Log.i(mTag, s);
        if (mOutputWriter == null) {
            return;
        }
        try {
            mOutputWriter.write(s + "\n");
            mOutputWriter.flush();
        } catch (IOException e) {
            Log.w(mTag, "Could not write to output file", e);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.661 -0400", hash_original_method = "414008A303F0D79D2BB371A91A579111", hash_generated_method = "AF8812BE7C1201CD405193B9B2CC3066")
    
private void addReceiver(BroadcastReceiver receiver, String[] actions) {
        IntentFilter filter = new IntentFilter();
        for (String action: actions) {
            filter.addAction(action);
        }
        mContext.registerReceiver(receiver, filter);
        mReceivers.add(receiver);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.663 -0400", hash_original_method = "41D8EEA108A816161185A55710BDBBAB", hash_generated_method = "34394F3A90EC1C6E1EF6117F7953F85A")
    
private BluetoothReceiver getBluetoothReceiver(int expectedFlags) {
        String[] actions = {
                BluetoothAdapter.ACTION_DISCOVERY_FINISHED,
                BluetoothAdapter.ACTION_DISCOVERY_STARTED,
                BluetoothAdapter.ACTION_SCAN_MODE_CHANGED,
                BluetoothAdapter.ACTION_STATE_CHANGED};
        BluetoothReceiver receiver = new BluetoothReceiver(expectedFlags);
        addReceiver(receiver, actions);
        return receiver;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.664 -0400", hash_original_method = "885D523D2DE4BE13C348CCB8E79AEDEB", hash_generated_method = "1075E00E6F8545021E681CBDB42C75ED")
    
private PairReceiver getPairReceiver(BluetoothDevice device, int passkey, byte[] pin,
            int expectedFlags) {
        String[] actions = {
                BluetoothDevice.ACTION_PAIRING_REQUEST,
                BluetoothDevice.ACTION_BOND_STATE_CHANGED};
        PairReceiver receiver = new PairReceiver(device, passkey, pin, expectedFlags);
        addReceiver(receiver, actions);
        return receiver;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.666 -0400", hash_original_method = "D1937848472FA5F848B9FB3EF36F3BB6", hash_generated_method = "FE5DD08DCAE8037C48D00A6665BB3820")
    
private ConnectProfileReceiver getConnectProfileReceiver(BluetoothDevice device, int profile,
            int expectedFlags) {
        String[] actions = {
                BluetoothA2dp.ACTION_CONNECTION_STATE_CHANGED,
                BluetoothHeadset.ACTION_CONNECTION_STATE_CHANGED,
                BluetoothInputDevice.ACTION_CONNECTION_STATE_CHANGED};
        ConnectProfileReceiver receiver = new ConnectProfileReceiver(device, profile,
                expectedFlags);
        addReceiver(receiver, actions);
        return receiver;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.667 -0400", hash_original_method = "920B0937D2BC39540B2902DDBD79C6A3", hash_generated_method = "07CD248DC066EC14E1873DD059AC561F")
    
private ConnectPanReceiver getConnectPanReceiver(BluetoothDevice device, int role,
            int expectedFlags) {
        String[] actions = {BluetoothPan.ACTION_CONNECTION_STATE_CHANGED};
        ConnectPanReceiver receiver = new ConnectPanReceiver(device, role, expectedFlags);
        addReceiver(receiver, actions);
        return receiver;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.669 -0400", hash_original_method = "2D6F2B443D171E711B609D2AD7918BBD", hash_generated_method = "FFD7230622D08CB53B6B1C6A391635D1")
    
private StartStopScoReceiver getStartStopScoReceiver(int expectedFlags) {
        String[] actions = {AudioManager.ACTION_SCO_AUDIO_STATE_UPDATED};
        StartStopScoReceiver receiver = new StartStopScoReceiver(expectedFlags);
        addReceiver(receiver, actions);
        return receiver;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.670 -0400", hash_original_method = "9D9F5D67786955B52D164029A4480CAB", hash_generated_method = "09BA612C9CCCB687F3A76EC07E27E9AD")
    
private void removeReceiver(BroadcastReceiver receiver) {
        mContext.unregisterReceiver(receiver);
        mReceivers.remove(receiver);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.673 -0400", hash_original_method = "658AD0D11C97F7F3F4E35AAF221BE98A", hash_generated_method = "40F9EC858EEC8650967900296FE8340E")
    
private BluetoothProfile connectProxy(BluetoothAdapter adapter, int profile) {
        switch (profile) {
            case BluetoothProfile.A2DP:
                if (mA2dp != null) {
                    return mA2dp;
                }
                break;
            case BluetoothProfile.HEADSET:
                if (mHeadset != null) {
                    return mHeadset;
                }
                break;
            case BluetoothProfile.INPUT_DEVICE:
                if (mInput != null) {
                    return mInput;
                }
                break;
            case BluetoothProfile.PAN:
                if (mPan != null) {
                    return mPan;
                }
                break;
            default:
                return null;
        }
        adapter.getProfileProxy(mContext, mServiceListener, profile);
        long s = System.currentTimeMillis();
        switch (profile) {
            case BluetoothProfile.A2DP:
                while (mA2dp == null && System.currentTimeMillis() - s < CONNECT_PROXY_TIMEOUT) {
                    sleep(POLL_TIME);
                }
                return mA2dp;
            case BluetoothProfile.HEADSET:
                while (mHeadset == null && System.currentTimeMillis() - s < CONNECT_PROXY_TIMEOUT) {
                    sleep(POLL_TIME);
                }
                return mHeadset;
            case BluetoothProfile.INPUT_DEVICE:
                while (mInput == null && System.currentTimeMillis() - s < CONNECT_PROXY_TIMEOUT) {
                    sleep(POLL_TIME);
                }
                return mInput;
            case BluetoothProfile.PAN:
                while (mPan == null && System.currentTimeMillis() - s < CONNECT_PROXY_TIMEOUT) {
                    sleep(POLL_TIME);
                }
                return mPan;
            default:
                return null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:16.674 -0400", hash_original_method = "0629FC92FD2F8820DE83C8777475E7FC", hash_generated_method = "3FF705FC4F23F58048AC795EF0011B2E")
    
private void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }
}
