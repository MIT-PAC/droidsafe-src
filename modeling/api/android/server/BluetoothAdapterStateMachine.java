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


package android.server;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.IBluetoothStateChangeCallback;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Log;

import com.android.internal.util.IState;
import com.android.internal.util.State;
import com.android.internal.util.StateMachine;

import java.io.PrintWriter;

/**
 * Bluetooth Adapter StateMachine
 * All the states are at the same level, ie, no hierarchy.
 *                         (BluetootOn)<----------------------<-
 *                           |    ^    -------------------->-  |
 *                           |    |                         |  |
 *                 TURN_OFF  |    | SCAN_MODE_CHANGED    m1 |  | USER_TURN_ON
 *         AIRPLANE_MODE_ON  |    |                         |  |
 *                           V    |                         |  |
 *                         (Switching)                   (PerProcessState)
 *                           |    ^                         |  |
 *     POWER_STATE_CHANGED & |    | TURN_ON(_CONTINUE)      |  |
 * ALL_DEVICES_DISCONNECTED  |    |                     m2  |  |
 *                           V    |------------------------<   | SCAN_MODE_CHANGED
 *                          (HotOff)-------------------------->- PER_PROCESS_TURN_ON
 *                           /    ^
 *                          /     |  SERVICE_RECORD_LOADED
 *                         |      |
 *              TURN_COLD  |   (Warmup)
 *                         \      ^
 *                          \     |  TURN_HOT/TURN_ON
 *                           |    |  AIRPLANE_MODE_OFF(when Bluetooth was on before)
 *                           V    |
 *                           (PowerOff)   <----- initial state
 *
 * Legend:
 * m1 = TURN_HOT
 * m2 = Transition to HotOff when number of process wanting BT on is 0.
 *      POWER_STATE_CHANGED will make the transition.
 */
final class BluetoothAdapterStateMachine extends StateMachine {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.667 -0400", hash_original_field = "2815CCBDA5DAA3567095CE79A83C322C", hash_generated_field = "DB1ECFFC3DE25ED0A0A2E2F5505A8960")

    private static final String TAG = "BluetoothAdapterStateMachine";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.669 -0400", hash_original_field = "B2601CA7445F6BA19FA7884763D82281", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.672 -0400", hash_original_field = "616693EDB4BCD3C70AACEF8600987F4D", hash_generated_field = "221CDFD2B45C2DCC6D029E856755F877")

    //
    // We get this message when user tries to turn on BT
    static final int USER_TURN_ON = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.673 -0400", hash_original_field = "CBBE0A1F2A7C2B415A914EA640DB7337", hash_generated_field = "E5F9783C75B8DF65FE39D1BFD2ED4F4F")

    static final int USER_TURN_OFF = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.677 -0400", hash_original_field = "22DE49B2DB0A87E8482E708C8D42FEA6", hash_generated_field = "C79DFA56EE8007EB04A066B25CAAF29E")

    static final int PER_PROCESS_TURN_ON = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.679 -0400", hash_original_field = "CA438EB9721DC21EEA3E03E7B4E6EA41", hash_generated_field = "65FAC38167964AEEF1456EA4B0A66B3B")

    static final int PER_PROCESS_TURN_OFF = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.681 -0400", hash_original_field = "F569E0FA80E50C8DB74B72B20BFF0D1C", hash_generated_field = "12A8D7484066FAC937149849F6AB8AD6")

    // needed to get the Bluetooth Module ready but keep it not discoverable
    // and not connectable. This way the Bluetooth Module can be quickly
    // switched on if needed
    static final int TURN_HOT = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.684 -0400", hash_original_field = "BBAAA57A313594099943E97036131897", hash_generated_field = "C530549ACE19AD800A07F759DF1F5D1F")

    //
    // Event indicates sevice records have been loaded
    static final int SERVICE_RECORD_LOADED = 51;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.686 -0400", hash_original_field = "A294A4C7C405084A3435012B0CC7B4EA", hash_generated_field = "F3EBFEDFD0B37AC90AAC3C0236D0E63F")

    static final int ALL_DEVICES_DISCONNECTED = 52;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.688 -0400", hash_original_field = "CE14E6C18CE252CD0313394625A3B552", hash_generated_field = "DF7E531C458178CB7AC6811C49985CBF")

    static final int SCAN_MODE_CHANGED = 53;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.691 -0400", hash_original_field = "C122C9051304469538797CFD7C1347E5", hash_generated_field = "42C68B982BB90AF313FC5584B0405D88")

    static final int POWER_STATE_CHANGED = 54;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.694 -0400", hash_original_field = "D59CE0388B619178612A522D7798BBA3", hash_generated_field = "1154C309650282B8268F0E4498248B12")

    static final int AIRPLANE_MODE_ON = 55;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.696 -0400", hash_original_field = "88F52F56F06130818E1747BBBA008FB0", hash_generated_field = "92D585B893CDB41FC8B576D7B9B75779")

    static final int AIRPLANE_MODE_OFF = 56;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.698 -0400", hash_original_field = "4152F40C2FECA0DF8FF57C898905EB1E", hash_generated_field = "3F29775B95A135B2B299287C1BAEE14A")

    //
    // USER_TURN_ON is changed to TURN_ON_CONTINUE after we broadcast the
    // state change intent so that we will not broadcast the intent again in
    // other state
    private static final int TURN_ON_CONTINUE = 101;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.699 -0400", hash_original_field = "589BD8A8CBD32994ED3A5AA5F0D1DCDD", hash_generated_field = "D4077D6DE5BE1AF974C6EC13D0B3DE54")

    private static final int TURN_COLD = 102;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.701 -0400", hash_original_field = "F2C23CB7BA3E35787F03D12C12FF98A5", hash_generated_field = "BF7A7A5F3E7E7E4895BA3DCC2A1997F9")

    private static final int DEVICES_DISCONNECT_TIMEOUT = 103;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.703 -0400", hash_original_field = "D79844B473495A98DA4E1A89E5F5A68E", hash_generated_field = "D308E97154998F7F62B52F753BE77690")

    private static final int PREPARE_BLUETOOTH_TIMEOUT = 104;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.705 -0400", hash_original_field = "F429DC5EF22B7BAC740055D40169DBD0", hash_generated_field = "991419AB908F33E543347C076BCF2F08")

    private static final int POWER_DOWN_TIMEOUT = 105;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.724 -0400", hash_original_field = "E2114739EBDD0CB0A250749624807648", hash_generated_field = "A7418C696ABD5AFFE19D2AACE6FED773")

    private static final int DEVICES_DISCONNECT_TIMEOUT_TIME = 3000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.726 -0400", hash_original_field = "20B9AB2347FC5804DB681418266DFE3D", hash_generated_field = "8C215B59126FAFDB53FA8E989E131CF0")


    private static final int PREPARE_BLUETOOTH_TIMEOUT_TIME = 10000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.727 -0400", hash_original_field = "B904DE1C975D2B756F37868CBD1C2C10", hash_generated_field = "948477CF070D34236B431F3CF59E73AD")


    private static final int POWER_DOWN_TIMEOUT_TIME = 5000;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.810 -0400", hash_original_method = "0EBF7673E44AF610ADC3AB53A65BD597", hash_generated_method = "12E4FDCE2D2661CC6DF9F077D2C0BB73")
    
private static void log(String msg) {
        Log.d(TAG, msg);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.706 -0400", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")


    private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.707 -0400", hash_original_field = "A159F05F3527228E8E398101D1BCF02A", hash_generated_field = "63FC39FA8AD5AA0E0E655FCBD5956634")

    private BluetoothService mBluetoothService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.710 -0400", hash_original_field = "29AEAD506F58EF5BD6922B133DEF064F", hash_generated_field = "A7A3F5E37FF8494C7EC414037E39E69C")

    private BluetoothEventLoop mEventLoop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.714 -0400", hash_original_field = "977D443E42E1033B12787CFC530BCC66", hash_generated_field = "1EA16979320F8C9A8F54DE2B66DA21B5")


    private BluetoothOn mBluetoothOn;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.715 -0400", hash_original_field = "99AF896B2BA9536CFFC651E3133F9BF8", hash_generated_field = "27C277FAA87CFC94B4EFDD678C3D95F5")

    private Switching mSwitching;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.717 -0400", hash_original_field = "E1D618EB2E1E24508E392138D991E37C", hash_generated_field = "92EFCF4861123FF3871C31D1A9724580")

    private HotOff mHotOff;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.718 -0400", hash_original_field = "2A9DA0A27DA30EBC1DB835ED506B4452", hash_generated_field = "D787886767436B4EF7D29FE0A451ADB0")

    private WarmUp mWarmUp;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.720 -0400", hash_original_field = "5A14FCF5BA804543B7EBFA9EB247383A", hash_generated_field = "9F2585F44D3D25BA2B067F21095BC18E")

    private PowerOff mPowerOff;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.721 -0400", hash_original_field = "991007C3D9AE9854984180C332841E15", hash_generated_field = "1C502127D257AD1906C4A75E58466F31")

    private PerProcessState mPerProcessState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.723 -0400", hash_original_field = "B9009146A331EBBC943E776336A8D3F8", hash_generated_field = "08F15FA89B109FFA88AA18C0E69F9647")

    private int mPublicState;

    /**
     * Bluetooth module's power is off, firmware is not loaded.
     */
    private class PowerOff extends State {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.731 -0400", hash_original_method = "04FA28784CBA3583AE3FBB05477FB236", hash_generated_method = "19C41BCBE8BFFA2E466CE6D9BC093A59")
        
@Override
        public void enter() {
            if (DBG) log("Enter PowerOff: " + getCurrentMessage().what);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.735 -0400", hash_original_method = "C20B17C8D5D5520B3FDC7974E3C587A8", hash_generated_method = "E03377C6737961ECC140F9E6A163605B")
        
@Override
        public boolean processMessage(Message message) {
            log("PowerOff process message: " + message.what);

            boolean retValue = HANDLED;
            switch(message.what) {
                case USER_TURN_ON:
                    // starts turning on BT module, broadcast this out
                    broadcastState(BluetoothAdapter.STATE_TURNING_ON);
                    transitionTo(mWarmUp);
                    if (prepareBluetooth()) {
                        // this is user request, save the setting
                        if ((Boolean) message.obj) {
                            persistSwitchSetting(true);
                        }
                        // We will continue turn the BT on all the way to the BluetoothOn state
                        deferMessage(obtainMessage(TURN_ON_CONTINUE));
                    } else {
                        Log.e(TAG, "failed to prepare bluetooth, abort turning on");
                        transitionTo(mPowerOff);
                        broadcastState(BluetoothAdapter.STATE_OFF);
                    }
                    break;
                case TURN_HOT:
                    if (prepareBluetooth()) {
                        transitionTo(mWarmUp);
                    }
                    break;
                case AIRPLANE_MODE_OFF:
                    if (getBluetoothPersistedSetting()) {
                        // starts turning on BT module, broadcast this out
                        broadcastState(BluetoothAdapter.STATE_TURNING_ON);
                        transitionTo(mWarmUp);
                        if (prepareBluetooth()) {
                            // We will continue turn the BT on all the way to the BluetoothOn state
                            deferMessage(obtainMessage(TURN_ON_CONTINUE));
                            transitionTo(mWarmUp);
                        } else {
                            Log.e(TAG, "failed to prepare bluetooth, abort turning on");
                            transitionTo(mPowerOff);
                            broadcastState(BluetoothAdapter.STATE_OFF);
                        }
                    } else if (mContext.getResources().getBoolean
                            (com.android.internal.R.bool.config_bluetooth_adapter_quick_switch)) {
                        sendMessage(TURN_HOT);
                    }
                    break;
                case PER_PROCESS_TURN_ON:
                    if (prepareBluetooth()) {
                        transitionTo(mWarmUp);
                    }
                    deferMessage(obtainMessage(PER_PROCESS_TURN_ON));
                    break;
                case PER_PROCESS_TURN_OFF:
                    perProcessCallback(false, (IBluetoothStateChangeCallback) message.obj);
                    break;
                case USER_TURN_OFF:
                    Log.w(TAG, "PowerOff received: " + message.what);
                case AIRPLANE_MODE_ON: // ignore
                    break;
                default:
                    return NOT_HANDLED;
            }
            return retValue;
        }

        /**
         * Turn on Bluetooth Module, Load firmware, and do all the preparation
         * needed to get the Bluetooth Module ready but keep it not discoverable
         * and not connectable.
         * The last step of this method sets up the local service record DB.
         * There will be a event reporting the status of the SDP setup.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.738 -0400", hash_original_method = "3443DDA1C14BFAA02F9B5213E85AAAB3", hash_generated_method = "B0099F078640672953CCD031EEBC9D5E")
        
private boolean prepareBluetooth() {
            if (mBluetoothService.enableNative() != 0) {
                return false;
            }

            // try to start event loop, give 2 attempts
            int retryCount = 2;
            boolean eventLoopStarted = false;
            while ((retryCount-- > 0) && !eventLoopStarted) {
                mEventLoop.start();
                // it may take a moment for the other thread to do its
                // thing.  Check periodically for a while.
                int pollCount = 5;
                while ((pollCount-- > 0) && !eventLoopStarted) {
                    if (mEventLoop.isEventLoopRunning()) {
                        eventLoopStarted = true;
                        break;
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        log("prepareBluetooth sleep interrupted: " + pollCount);
                        break;
                    }
                }
            }

            if (!eventLoopStarted) {
                mBluetoothService.disableNative();
                return false;
            }

            // get BluetoothService ready
            if (!mBluetoothService.prepareBluetooth()) {
                mEventLoop.stop();
                mBluetoothService.disableNative();
                return false;
            }

            sendMessageDelayed(PREPARE_BLUETOOTH_TIMEOUT, PREPARE_BLUETOOTH_TIMEOUT_TIME);
            return true;
        }
    }

    /**
     * Turning on Bluetooth module's power, loading firmware, starting
     * event loop thread to listen on Bluetooth module event changes.
     */
    private class WarmUp extends State {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.742 -0400", hash_original_method = "A3E83A5A1AB63BF55CA35AE6F87AD3CC", hash_generated_method = "D54CB9E3D24376651624DB808E79A278")
        
@Override
        public void enter() {
            if (DBG) log("Enter WarmUp: " + getCurrentMessage().what);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.744 -0400", hash_original_method = "9CF9D4EA926FCF9452625C28414CD5C0", hash_generated_method = "03625000EB4B8285F7248B8552A79C45")
        
@Override
        public boolean processMessage(Message message) {
            log("WarmUp process message: " + message.what);

            boolean retValue = HANDLED;
            switch(message.what) {
                case SERVICE_RECORD_LOADED:
                    removeMessages(PREPARE_BLUETOOTH_TIMEOUT);
                    transitionTo(mHotOff);
                    break;
                case PREPARE_BLUETOOTH_TIMEOUT:
                    Log.e(TAG, "Bluetooth adapter SDP failed to load");
                    shutoffBluetooth();
                    transitionTo(mPowerOff);
                    broadcastState(BluetoothAdapter.STATE_OFF);
                    break;
                case USER_TURN_ON: // handle this at HotOff state
                case TURN_ON_CONTINUE: // Once in HotOff state, continue turn bluetooth
                                       // on to the BluetoothOn state
                case AIRPLANE_MODE_ON:
                case AIRPLANE_MODE_OFF:
                case PER_PROCESS_TURN_ON:
                case PER_PROCESS_TURN_OFF:
                    deferMessage(message);
                    break;
                case USER_TURN_OFF:
                    Log.w(TAG, "WarmUp received: " + message.what);
                    break;
                default:
                    return NOT_HANDLED;
            }
            return retValue;
        }

    }

    /**
     * Bluetooth Module has powered, firmware loaded, event loop started,
     * SDP loaded, but the modules stays non-discoverable and
     * non-connectable.
     */
    private class HotOff extends State {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.748 -0400", hash_original_method = "F863E0F61C0075F7A6672A77B8F04A64", hash_generated_method = "2FFBB023AC2CE863FBEA548659642AD3")
        
@Override
        public void enter() {
            if (DBG) log("Enter HotOff: " + getCurrentMessage().what);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.760 -0400", hash_original_method = "2ACC588CA21322CAEDD331557FAED878", hash_generated_method = "647F640D6B61D70E433CD759DC731B07")
        
@Override
        public boolean processMessage(Message message) {
            log("HotOff process message: " + message.what);

            boolean retValue = HANDLED;
            switch(message.what) {
                case USER_TURN_ON:
                    broadcastState(BluetoothAdapter.STATE_TURNING_ON);
                    if ((Boolean) message.obj) {
                        persistSwitchSetting(true);
                    }
                    // let it fall to TURN_ON_CONTINUE:
                    //$FALL-THROUGH$
                case TURN_ON_CONTINUE:
                    mBluetoothService.switchConnectable(true);
                    transitionTo(mSwitching);
                    break;
                case AIRPLANE_MODE_ON:
                case TURN_COLD:
                    shutoffBluetooth();
                    transitionTo(mPowerOff);
                    broadcastState(BluetoothAdapter.STATE_OFF);
                    break;
                case AIRPLANE_MODE_OFF:
                    if (getBluetoothPersistedSetting()) {
                        broadcastState(BluetoothAdapter.STATE_TURNING_ON);
                        transitionTo(mSwitching);
                        mBluetoothService.switchConnectable(true);
                    }
                    break;
                case PER_PROCESS_TURN_ON:
                    transitionTo(mPerProcessState);

                    // Resend the PER_PROCESS_TURN_ON message so that the callback
                    // can be sent through.
                    deferMessage(message);

                    mBluetoothService.switchConnectable(true);
                    break;
                case PER_PROCESS_TURN_OFF:
                    perProcessCallback(false, (IBluetoothStateChangeCallback)message.obj);
                    break;
                case USER_TURN_OFF: // ignore
                    break;
                case POWER_STATE_CHANGED:
                    if ((Boolean) message.obj) {
                        recoverStateMachine(TURN_HOT, null);
                    }
                    break;
                default:
                    return NOT_HANDLED;
            }
            return retValue;
        }

    }

    private class Switching extends State {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.764 -0400", hash_original_method = "7F8395FDA7A3EE3386C93220B71F874B", hash_generated_method = "1401AE66970285F870603461321B07FB")
        
@Override
        public void enter() {
            if (DBG) log("Enter Switching: " + getCurrentMessage().what);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.767 -0400", hash_original_method = "F866F8DC681A7D04D067A07516E44AC6", hash_generated_method = "456DDEFFFA1FC7EE6AD0E6D601E39DD9")
        
@Override
        public boolean processMessage(Message message) {
            log("Switching process message: " + message.what);

            boolean retValue = HANDLED;
            switch(message.what) {
                case SCAN_MODE_CHANGED:
                    // This event matches mBluetoothService.switchConnectable action
                    if (mPublicState == BluetoothAdapter.STATE_TURNING_ON) {
                        // set pairable if it's not
                        mBluetoothService.setPairable();
                        mBluetoothService.initBluetoothAfterTurningOn();
                        transitionTo(mBluetoothOn);
                        broadcastState(BluetoothAdapter.STATE_ON);
                        // run bluetooth now that it's turned on
                        // Note runBluetooth should be called only in adapter STATE_ON
                        mBluetoothService.runBluetooth();
                    }
                    break;
                case POWER_STATE_CHANGED:
                    removeMessages(POWER_DOWN_TIMEOUT);
                    if (!((Boolean) message.obj)) {
                        if (mPublicState == BluetoothAdapter.STATE_TURNING_OFF) {
                            transitionTo(mHotOff);
                            finishSwitchingOff();
                            if (!mContext.getResources().getBoolean
                            (com.android.internal.R.bool.config_bluetooth_adapter_quick_switch)) {
                                deferMessage(obtainMessage(TURN_COLD));
                            }
                        }
                    } else {
                        if (mPublicState != BluetoothAdapter.STATE_TURNING_ON) {
                            if (mContext.getResources().getBoolean
                            (com.android.internal.R.bool.config_bluetooth_adapter_quick_switch)) {
                                recoverStateMachine(TURN_HOT, null);
                            } else {
                                recoverStateMachine(TURN_COLD, null);
                            }
                        }
                    }
                    break;
                case ALL_DEVICES_DISCONNECTED:
                    removeMessages(DEVICES_DISCONNECT_TIMEOUT);
                    mBluetoothService.switchConnectable(false);
                    sendMessageDelayed(POWER_DOWN_TIMEOUT, POWER_DOWN_TIMEOUT_TIME);
                    break;
                case DEVICES_DISCONNECT_TIMEOUT:
                    sendMessage(ALL_DEVICES_DISCONNECTED);
                    // reset the hardware for error recovery
                    Log.e(TAG, "Devices failed to disconnect, reseting...");
                    deferMessage(obtainMessage(TURN_COLD));
                    if (mContext.getResources().getBoolean
                        (com.android.internal.R.bool.config_bluetooth_adapter_quick_switch)) {
                        deferMessage(obtainMessage(TURN_HOT));
                    }
                    break;
                case POWER_DOWN_TIMEOUT:
                    transitionTo(mHotOff);
                    finishSwitchingOff();
                    // reset the hardware for error recovery
                    Log.e(TAG, "Devices failed to power down, reseting...");
                    deferMessage(obtainMessage(TURN_COLD));
                    if (mContext.getResources().getBoolean
                        (com.android.internal.R.bool.config_bluetooth_adapter_quick_switch)) {
                        deferMessage(obtainMessage(TURN_HOT));
                    }
                    break;
                case USER_TURN_ON:
                case AIRPLANE_MODE_OFF:
                case AIRPLANE_MODE_ON:
                case PER_PROCESS_TURN_ON:
                case PER_PROCESS_TURN_OFF:
                case USER_TURN_OFF:
                    deferMessage(message);
                    break;

                default:
                    return NOT_HANDLED;
            }
            return retValue;
        }
    }

    private class BluetoothOn extends State {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.771 -0400", hash_original_method = "FC3E6D9421C14E02B0D37180EA7FE411", hash_generated_method = "30949A05A784A560D7ED3E969695CBAC")
        
@Override
        public void enter() {
            if (DBG) log("Enter BluetoothOn: " + getCurrentMessage().what);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.774 -0400", hash_original_method = "68DCE80182F70BC03204E7389B80A7F5", hash_generated_method = "4DCB90B0AF624481EB65DAA359E73AB4")
        
@Override
        public boolean processMessage(Message message) {
            log("BluetoothOn process message: " + message.what);

            boolean retValue = HANDLED;
            switch(message.what) {
                case USER_TURN_OFF:
                    if ((Boolean) message.obj) {
                        persistSwitchSetting(false);
                    }

                    if (mBluetoothService.isDiscovering()) {
                        mBluetoothService.cancelDiscovery();
                    }
                    if (!mBluetoothService.isApplicationStateChangeTrackerEmpty()) {
                        transitionTo(mPerProcessState);
                        deferMessage(obtainMessage(TURN_HOT));
                        break;
                    }
                    //$FALL-THROUGH$ to AIRPLANE_MODE_ON
                case AIRPLANE_MODE_ON:
                    broadcastState(BluetoothAdapter.STATE_TURNING_OFF);
                    transitionTo(mSwitching);
                    if (mBluetoothService.getAdapterConnectionState() !=
                        BluetoothAdapter.STATE_DISCONNECTED) {
                        mBluetoothService.disconnectDevices();
                        sendMessageDelayed(DEVICES_DISCONNECT_TIMEOUT,
                                           DEVICES_DISCONNECT_TIMEOUT_TIME);
                    } else {
                        mBluetoothService.switchConnectable(false);
                        sendMessageDelayed(POWER_DOWN_TIMEOUT, POWER_DOWN_TIMEOUT_TIME);
                    }

                    // we turn all the way to PowerOff with AIRPLANE_MODE_ON
                    if (message.what == AIRPLANE_MODE_ON) {
                        // We inform all the per process callbacks
                        allProcessesCallback(false);
                        deferMessage(obtainMessage(AIRPLANE_MODE_ON));
                    }
                    break;
                case AIRPLANE_MODE_OFF:
                case USER_TURN_ON:
                    Log.w(TAG, "BluetoothOn received: " + message.what);
                    break;
                case PER_PROCESS_TURN_ON:
                    perProcessCallback(true, (IBluetoothStateChangeCallback)message.obj);
                    break;
                case PER_PROCESS_TURN_OFF:
                    perProcessCallback(false, (IBluetoothStateChangeCallback)message.obj);
                    break;
                case POWER_STATE_CHANGED:
                    if ((Boolean) message.obj) {
                        // reset the state machine and send it TURN_ON_CONTINUE message
                        recoverStateMachine(USER_TURN_ON, false);
                    }
                    break;
                default:
                    return NOT_HANDLED;
            }
            return retValue;
        }

    }


    private class PerProcessState extends State {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.777 -0400", hash_original_field = "FB4A260540693623D9B3763C9186A6DD", hash_generated_field = "FB4A260540693623D9B3763C9186A6DD")

        IBluetoothStateChangeCallback mCallback = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.778 -0400", hash_original_field = "001919A46004DFD4FE9B1FC5F3526C04", hash_generated_field = "001919A46004DFD4FE9B1FC5F3526C04")

        boolean isTurningOn = false;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.781 -0400", hash_original_method = "6C52EC50E6113571B8F4E718CC3AC378", hash_generated_method = "0C439EB0D32A03EBCD1F987909F308A9")
        
@Override
        public void enter() {
            int what = getCurrentMessage().what;
            if (DBG) log("Enter PerProcessState: " + what);

            if (what == PER_PROCESS_TURN_ON) {
                isTurningOn = true;
            } else if (what == USER_TURN_OFF) {
                isTurningOn = false;
            } else {
                Log.e(TAG, "enter PerProcessState: wrong msg: " + what);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.785 -0400", hash_original_method = "BB117AB2125C3E2BC14FA9697846259B", hash_generated_method = "225786779213D2A10DE05B491FA3BD4C")
        
@Override
        public boolean processMessage(Message message) {
            log("PerProcessState process message: " + message.what);

            boolean retValue = HANDLED;
            switch (message.what) {
                case PER_PROCESS_TURN_ON:
                    mCallback = (IBluetoothStateChangeCallback)getCurrentMessage().obj;

                    // If this is not the first application call the callback.
                    if (mBluetoothService.getNumberOfApplicationStateChangeTrackers() > 1) {
                        perProcessCallback(true, mCallback);
                    }
                    break;
                case SCAN_MODE_CHANGED:
                    if (isTurningOn) {
                        perProcessCallback(true, mCallback);
                        isTurningOn = false;
                    }
                    break;
                case POWER_STATE_CHANGED:
                    removeMessages(POWER_DOWN_TIMEOUT);
                    if (!((Boolean) message.obj)) {
                        transitionTo(mHotOff);
                        if (!mContext.getResources().getBoolean
                            (com.android.internal.R.bool.config_bluetooth_adapter_quick_switch)) {
                            deferMessage(obtainMessage(TURN_COLD));
                        }
                    } else {
                        if (!isTurningOn) {
                            recoverStateMachine(TURN_COLD, null);
                            for (IBluetoothStateChangeCallback c:
                                     mBluetoothService.getApplicationStateChangeCallbacks()) {
                                perProcessCallback(false, c);
                                deferMessage(obtainMessage(PER_PROCESS_TURN_ON, c));
                            }
                        }
                    }
                    break;
                case POWER_DOWN_TIMEOUT:
                    transitionTo(mHotOff);
                    Log.e(TAG, "Power-down timed out, resetting...");
                    deferMessage(obtainMessage(TURN_COLD));
                    if (mContext.getResources().getBoolean
                        (com.android.internal.R.bool.config_bluetooth_adapter_quick_switch)) {
                        deferMessage(obtainMessage(TURN_HOT));
                    }
                    break;
                case USER_TURN_ON:
                    broadcastState(BluetoothAdapter.STATE_TURNING_ON);
                    persistSwitchSetting(true);
                    mBluetoothService.initBluetoothAfterTurningOn();
                    transitionTo(mBluetoothOn);
                    broadcastState(BluetoothAdapter.STATE_ON);
                    // run bluetooth now that it's turned on
                    mBluetoothService.runBluetooth();
                    break;
                case TURN_HOT:
                    broadcastState(BluetoothAdapter.STATE_TURNING_OFF);
                    if (mBluetoothService.getAdapterConnectionState() !=
                        BluetoothAdapter.STATE_DISCONNECTED) {
                        mBluetoothService.disconnectDevices();
                        sendMessageDelayed(DEVICES_DISCONNECT_TIMEOUT,
                                           DEVICES_DISCONNECT_TIMEOUT_TIME);
                        break;
                    }
                    //$FALL-THROUGH$ all devices are already disconnected
                case ALL_DEVICES_DISCONNECTED:
                    removeMessages(DEVICES_DISCONNECT_TIMEOUT);
                    finishSwitchingOff();
                    break;
                case DEVICES_DISCONNECT_TIMEOUT:
                    finishSwitchingOff();
                    Log.e(TAG, "Devices fail to disconnect, reseting...");
                    transitionTo(mHotOff);
                    deferMessage(obtainMessage(TURN_COLD));
                    for (IBluetoothStateChangeCallback c:
                             mBluetoothService.getApplicationStateChangeCallbacks()) {
                        perProcessCallback(false, c);
                        deferMessage(obtainMessage(PER_PROCESS_TURN_ON, c));
                    }
                    break;
                case PER_PROCESS_TURN_OFF:
                    perProcessCallback(false, (IBluetoothStateChangeCallback)message.obj);
                    if (mBluetoothService.isApplicationStateChangeTrackerEmpty()) {
                        mBluetoothService.switchConnectable(false);
                        sendMessageDelayed(POWER_DOWN_TIMEOUT, POWER_DOWN_TIMEOUT_TIME);
                    }
                    break;
                case AIRPLANE_MODE_ON:
                    mBluetoothService.switchConnectable(false);
                    sendMessageDelayed(POWER_DOWN_TIMEOUT, POWER_DOWN_TIMEOUT_TIME);
                    allProcessesCallback(false);
                    // we turn all the way to PowerOff with AIRPLANE_MODE_ON
                    deferMessage(obtainMessage(AIRPLANE_MODE_ON));
                    break;
                case USER_TURN_OFF:
                    Log.w(TAG, "PerProcessState received: " + message.what);
                    break;
                default:
                    return NOT_HANDLED;
            }
            return retValue;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.729 -0400", hash_original_method = "0CF097407FB28C7138EB0ABD89B5B7A3", hash_generated_method = "0CF097407FB28C7138EB0ABD89B5B7A3")
    
BluetoothAdapterStateMachine(Context context, BluetoothService bluetoothService,
                                 BluetoothAdapter bluetoothAdapter) {
        super(TAG);
        mContext = context;
        mBluetoothService = bluetoothService;
        mEventLoop = new BluetoothEventLoop(context, bluetoothAdapter, bluetoothService, this);

        mBluetoothOn = new BluetoothOn();
        mSwitching = new Switching();
        mHotOff = new HotOff();
        mWarmUp = new WarmUp();
        mPowerOff = new PowerOff();
        mPerProcessState = new PerProcessState();

        addState(mBluetoothOn);
        addState(mSwitching);
        addState(mHotOff);
        addState(mWarmUp);
        addState(mPowerOff);
        addState(mPerProcessState);

        setInitialState(mPowerOff);
        mPublicState = BluetoothAdapter.STATE_OFF;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.789 -0400", hash_original_method = "FFD135444D58ECF7CF9753204C4ABC35", hash_generated_method = "5B864E0E4BF51EE51D1F4CEEC6951A6F")
    
private void finishSwitchingOff() {
        mBluetoothService.finishDisable();
        broadcastState(BluetoothAdapter.STATE_OFF);
        mBluetoothService.cleanupAfterFinishDisable();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.791 -0400", hash_original_method = "F67A7DC43FEB01E967B484AB89114AB4", hash_generated_method = "96F65FE6367A7144B65824DC35BA3B7E")
    
private void shutoffBluetooth() {
        mBluetoothService.shutoffBluetooth();
        mEventLoop.stop();
        mBluetoothService.cleanNativeAfterShutoffBluetooth();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.792 -0400", hash_original_method = "A5AB1C6B03CCAB809F45E6BFF4838148", hash_generated_method = "B4353173AC571C637B16A808D3321C81")
    
private void perProcessCallback(boolean on, IBluetoothStateChangeCallback c) {
        if (c == null) return;

        try {
            c.onBluetoothStateChange(on);
        } catch (RemoteException e) {}
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.794 -0400", hash_original_method = "91D2BE35844830F61D5A6A50EFC301A2", hash_generated_method = "30486D1D8D1E4765DAE57D4C6E58B61C")
    
private void allProcessesCallback(boolean on) {
        for (IBluetoothStateChangeCallback c:
             mBluetoothService.getApplicationStateChangeCallbacks()) {
            perProcessCallback(on, c);
        }
        if (!on) {
            mBluetoothService.clearApplicationStateChangeTracker();
        }
    }

    /**
     * Return the public BluetoothAdapter state
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.795 -0400", hash_original_method = "002F9CA418A9D1E901D2DC1FB4553A1E", hash_generated_method = "002F9CA418A9D1E901D2DC1FB4553A1E")
    
int getBluetoothAdapterState() {
        return mPublicState;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.796 -0400", hash_original_method = "8F85367D025819AD18F591A50A13AA11", hash_generated_method = "8F85367D025819AD18F591A50A13AA11")
    
BluetoothEventLoop getBluetoothEventLoop() {
        return mEventLoop;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.798 -0400", hash_original_method = "F2754CC95BEB16BA82A020DE907DAAC7", hash_generated_method = "0EE9C8DBE118D07DAE7D0CDFC69F7C3D")
    
private void persistSwitchSetting(boolean setOn) {
        long origCallerIdentityToken = Binder.clearCallingIdentity();
        Settings.Secure.putInt(mContext.getContentResolver(),
                               Settings.Secure.BLUETOOTH_ON,
                               setOn ? 1 : 0);
        Binder.restoreCallingIdentity(origCallerIdentityToken);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.799 -0400", hash_original_method = "E8AE1786FC39008FAC335C2BE983FCBD", hash_generated_method = "FB4352F29A417AEDD35F9F9AE92566AC")
    
private boolean getBluetoothPersistedSetting() {
        ContentResolver contentResolver = mContext.getContentResolver();
        return (Settings.Secure.getInt(contentResolver,
                                       Settings.Secure.BLUETOOTH_ON, 0) > 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.801 -0400", hash_original_method = "6CC0D97DF3C3B571CDDEF525BD4802B7", hash_generated_method = "831F099FD59449E23C59FB3C3E0B1D98")
    
private void broadcastState(int newState) {

        log("Bluetooth state " + mPublicState + " -> " + newState);
        if (mPublicState == newState) {
            return;
        }

        Intent intent = new Intent(BluetoothAdapter.ACTION_STATE_CHANGED);
        intent.putExtra(BluetoothAdapter.EXTRA_PREVIOUS_STATE, mPublicState);
        intent.putExtra(BluetoothAdapter.EXTRA_STATE, newState);
        intent.addFlags(Intent.FLAG_RECEIVER_REGISTERED_ONLY_BEFORE_BOOT);
        mPublicState = newState;

        mContext.sendBroadcast(intent, BluetoothService.BLUETOOTH_PERM);
    }

    /**
     * bluetoothd has crashed and recovered, the adapter state machine has to
     * reset itself and try to return to previous state
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.803 -0400", hash_original_method = "A0C1F272D157A3A99E9FD719A2632888", hash_generated_method = "C1762171FA85031E6382CA2125245FA1")
    
private void recoverStateMachine(int what, Object obj) {
        Log.e(TAG, "Get unexpected power on event, reset with: " + what);
        transitionTo(mHotOff);
        deferMessage(obtainMessage(TURN_COLD));
        deferMessage(obtainMessage(what, obj));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:22.806 -0400", hash_original_method = "90B5DC2734E668D024B2C24674000146", hash_generated_method = "24A76E3C8FEF8ECE9C4669E5E78F381D")
    
private void dump(PrintWriter pw) {
        IState currentState = getCurrentState();
        if (currentState == mPowerOff) {
            pw.println("Bluetooth OFF - power down\n");
        } else if (currentState == mWarmUp) {
            pw.println("Bluetooth OFF - warm up\n");
        } else if (currentState == mHotOff) {
            pw.println("Bluetooth OFF - hot but off\n");
        } else if (currentState == mSwitching) {
            pw.println("Bluetooth Switching\n");
        } else if (currentState == mBluetoothOn) {
            pw.println("Bluetooth ON\n");
        } else {
            pw.println("ERROR: Bluetooth UNKNOWN STATE ");
        }
    }
}
