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
package android.bluetooth;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Message;
import android.util.Log;

import com.android.internal.util.State;
import com.android.internal.util.StateMachine;

/**
 * This state machine is used to serialize the connections
 * to a particular profile. Currently, we only allow one device
 * to be connected to a particular profile.
 * States:
 *      {@link StableState} : No pending commands. Send the
 *      command to the appropriate remote device specific state machine.
 *
 *      {@link PendingCommandState} : A profile connection / disconnection
 *      command is being executed. This will result in a profile state
 *      change. Defer all commands.
 * @hide
 */

public class BluetoothProfileState extends StateMachine {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:08.615 -0400", hash_original_field = "95D5733A0C83DB3D047D109C028C9F02", hash_generated_field = "B7707D757F0604821CCAF673B2122320")

    private static final boolean DBG = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:08.617 -0400", hash_original_field = "0B1C1906ED40F27BD65E38E6A489CF26", hash_generated_field = "3E5B699AD8AC62FDCFA3E01C59B5FBB8")

    private static final String TAG = "BluetoothProfileState";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:08.620 -0400", hash_original_field = "F817599DA54B8B0654A9A5DD08DD6A8A", hash_generated_field = "14762174F850B89AAC739E0609F6A93D")


    public static final int HFP = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:08.623 -0400", hash_original_field = "1573653F07A63C22864FFD302D3B725C", hash_generated_field = "E97123E4A07910C586B37C573B12EEE5")

    public static final int A2DP = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:08.625 -0400", hash_original_field = "5BA072C388A7DE0B6A870C3FA91673AB", hash_generated_field = "C0A75222D4970A2E79FD66E302A42F6E")

    public static final int HID = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:08.628 -0400", hash_original_field = "657BACC5434AD77EC0383C7CF3EF190A", hash_generated_field = "5E55276BFE220EA3370CD8EDF121AC45")


    static final int TRANSITION_TO_STABLE = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:08.630 -0400", hash_original_field = "6466AB47A4E8DAAE93C96826CBF42A86", hash_generated_field = "8016B178818EBB90ECC104CA00C7510B")


    private int mProfile;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:08.632 -0400", hash_original_field = "1CEDC7236F47139A40226C4959FF9A09", hash_generated_field = "20BD63EF10A50D9E387F91479DFBD5E3")

    private BluetoothDevice mPendingDevice;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:08.634 -0400", hash_original_field = "2EABAF2DF94DA50B268F5BECCA28237F", hash_generated_field = "42C28C331DB213680512535EC1F670BF")

    private PendingCommandState mPendingCommandState = new PendingCommandState();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:08.638 -0400", hash_original_field = "43D527B83F232B3C740AA5DABB2D6400", hash_generated_field = "5CA8BE0FC0DA2AC7BB8B427797BB65CD")

    private StableState mStableState = new StableState();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:08.645 -0400", hash_original_field = "B187F0B147329EB13293668F1A42E43F", hash_generated_field = "BA17BB6E682CB1349951C3018672794B")


    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.237 -0400", hash_original_method = "A5B907A2BE55D1826A6FCD8EFEF64977", hash_generated_method = "7153FC8A2555480B9A73BBAE70C5BAE7")
        
@Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            if (device == null) {
                return;
            }
            if (action.equals(BluetoothHeadset.ACTION_CONNECTION_STATE_CHANGED)) {
                int newState = intent.getIntExtra(BluetoothProfile.EXTRA_STATE, 0);
                if (mProfile == HFP && (newState == BluetoothProfile.STATE_CONNECTED ||
                    newState == BluetoothProfile.STATE_DISCONNECTED)) {
                    sendMessage(TRANSITION_TO_STABLE);
                }
            } else if (action.equals(BluetoothA2dp.ACTION_CONNECTION_STATE_CHANGED)) {
                int newState = intent.getIntExtra(BluetoothProfile.EXTRA_STATE, 0);
                if (mProfile == A2DP && (newState == BluetoothProfile.STATE_CONNECTED ||
                    newState == BluetoothProfile.STATE_DISCONNECTED)) {
                    sendMessage(TRANSITION_TO_STABLE);
                }
            } else if (action.equals(BluetoothInputDevice.ACTION_CONNECTION_STATE_CHANGED)) {
                int newState = intent.getIntExtra(BluetoothProfile.EXTRA_STATE, 0);
                if (mProfile == HID && (newState == BluetoothProfile.STATE_CONNECTED ||
                    newState == BluetoothProfile.STATE_DISCONNECTED)) {
                    sendMessage(TRANSITION_TO_STABLE);
                }
            } else if (action.equals(BluetoothDevice.ACTION_ACL_DISCONNECTED)) {
                if (device.equals(mPendingDevice)) {
                    sendMessage(TRANSITION_TO_STABLE);
                }
            }
        }
    };

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:08.648 -0400", hash_original_method = "2CAA53DEBB5977BF3CC6014DE52CD3F9", hash_generated_method = "C126A296A5E265BAD2F9F6A71666B117")
    
public BluetoothProfileState(Context context, int profile) {
        super("BluetoothProfileState:" + profile);
        mProfile = profile;
        addState(mStableState);
        addState(mPendingCommandState);
        setInitialState(mStableState);

        IntentFilter filter = new IntentFilter();
        filter.addAction(BluetoothA2dp.ACTION_CONNECTION_STATE_CHANGED);
        filter.addAction(BluetoothHeadset.ACTION_CONNECTION_STATE_CHANGED);
        filter.addAction(BluetoothInputDevice.ACTION_CONNECTION_STATE_CHANGED);
        filter.addAction(BluetoothDevice.ACTION_ACL_DISCONNECTED);
        context.registerReceiver(mBroadcastReceiver, filter);
    }

    private class StableState extends State {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:08.651 -0400", hash_original_method = "EF3E17E90EA30F098B358BE3AC02C586", hash_generated_method = "3A721A9E84A527EBC20BA43582B2DC4C")
        
@Override
        public void enter() {
            log("Entering Stable State");
            mPendingDevice = null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:08.654 -0400", hash_original_method = "BF95950A6BC3478E13B2B81DB0B6F6C0", hash_generated_method = "58363711989077FE0D92CB5C7105F3C5")
        
@Override
        public boolean processMessage(Message msg) {
            if (msg.what != TRANSITION_TO_STABLE) {
                transitionTo(mPendingCommandState);
            }
            return true;
        }
    }

    private class PendingCommandState extends State {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:08.658 -0400", hash_original_method = "77FE748984673120440F1617064741EB", hash_generated_method = "91E333213E55C041D65491DAEFC3C3FC")
        
@Override
        public void enter() {
            log("Entering PendingCommandState State");
            dispatchMessage(getCurrentMessage());
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:08.661 -0400", hash_original_method = "D81C39731225C303E9C9F75BB985316B", hash_generated_method = "F7E0F33EBEDCB1A23423C47AD64A32D7")
        
@Override
        public boolean processMessage(Message msg) {
            if (msg.what == TRANSITION_TO_STABLE) {
                transitionTo(mStableState);
            } else {
                dispatchMessage(msg);
            }
            return true;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:08.664 -0400", hash_original_method = "0EFABAAD2384BD216539A26373F1DE53", hash_generated_method = "C7A175BBAEF609A342377A2BBC9748E4")
        
private void dispatchMessage(Message msg) {
            BluetoothDeviceProfileState deviceProfileMgr =
              (BluetoothDeviceProfileState)msg.obj;
            int cmd = msg.arg1;
            if (mPendingDevice == null || mPendingDevice.equals(deviceProfileMgr.getDevice())) {
                mPendingDevice = deviceProfileMgr.getDevice();
                deviceProfileMgr.sendMessage(cmd);
            } else {
                Message deferMsg = new Message();
                deferMsg.arg1 = cmd;
                deferMsg.obj = deviceProfileMgr;
                deferMessage(deferMsg);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:08.669 -0400", hash_original_method = "A14D8C412FCFE900332A037356349069", hash_generated_method = "5F9ED9F715B1265F25143D46C6A3754C")
    
private void log(String message) {
        if (DBG) {
            Log.i(TAG, "Message:" + message);
        }
    }
}
