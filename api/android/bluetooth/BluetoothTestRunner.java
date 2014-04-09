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
import junit.framework.TestSuite;

import android.os.Bundle;
import android.test.InstrumentationTestRunner;
import android.test.InstrumentationTestSuite;
import android.util.Log;

/**
 * Instrumentation test runner for Bluetooth tests.
 * <p>
 * To run:
 * <pre>
 * {@code
 * adb shell am instrument \
 *     [-e enable_iterations <iterations>] \
 *     [-e discoverable_iterations <iterations>] \
 *     [-e scan_iterations <iterations>] \
 *     [-e enable_pan_iterations <iterations>] \
 *     [-e pair_iterations <iterations>] \
 *     [-e connect_a2dp_iterations <iterations>] \
 *     [-e connect_headset_iterations <iterations>] \
 *     [-e connect_input_iterations <iterations>] \
 *     [-e connect_pan_iterations <iterations>] \
 *     [-e start_stop_sco_iterations <iterations>] \
 *     [-e pair_address <address>] \
 *     [-e headset_address <address>] \
 *     [-e a2dp_address <address>] \
 *     [-e input_address <address>] \
 *     [-e pan_address <address>] \
 *     [-e pair_pin <pin>] \
 *     [-e pair_passkey <passkey>] \
 *     -w com.android.bluetooth.tests/android.bluetooth.BluetoothTestRunner
 * }
 * </pre>
 */
public class BluetoothTestRunner extends InstrumentationTestRunner {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.688 -0400", hash_original_field = "76CC11793FD2CBCD84AAD2E8D6ACA33D", hash_generated_field = "79D2F83C1726F164E1BE99815B70145D")

    private static final String TAG = "BluetoothTestRunner";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.690 -0400", hash_original_field = "D2B0DFAACDF6F7E0FFB5DF2A817A1954", hash_generated_field = "9CE60CC943D948091C0DF92B60BF1FC7")


    public static int sEnableIterations = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.691 -0400", hash_original_field = "7C9EA34F272B6D145312F3256CACBA83", hash_generated_field = "C861F5626B3939F37493BEAE1B55976C")

    public static int sDiscoverableIterations = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.693 -0400", hash_original_field = "B532A494189AB5D2D417B2829AB79152", hash_generated_field = "FCEDC3FCA0828C267901D788F882567C")

    public static int sScanIterations = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.694 -0400", hash_original_field = "DF6842B6089F9AC30BBB50007265E1D6", hash_generated_field = "06D682F7136F9D15F7E690796FE7FDA4")

    public static int sEnablePanIterations = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.695 -0400", hash_original_field = "DE9DC56EDC6C7F0D95D8D149E42C9ED1", hash_generated_field = "05F1D8BED30CAF8ADC6F12FD0A11BEE5")

    public static int sPairIterations = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.697 -0400", hash_original_field = "94D7C5B93E2843C22FD2E8FEBB7639F5", hash_generated_field = "BD3834FEA9205F94090C7E2A2DD1B915")

    public static int sConnectHeadsetIterations = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.698 -0400", hash_original_field = "6B0DE6A1461A35E012A4450DAE96DE50", hash_generated_field = "82604183BF9FBB40FFA603977DC21105")

    public static int sConnectA2dpIterations = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.700 -0400", hash_original_field = "EE005281C61683579E719188E4A54313", hash_generated_field = "C04D777C4E837C262443FFA8B1E97F8E")

    public static int sConnectInputIterations = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.701 -0400", hash_original_field = "C987ED6113A94271763DE19D08261207", hash_generated_field = "211E69D6ED5CA2A09B879D0D06D7AEC6")

    public static int sConnectPanIterations = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.703 -0400", hash_original_field = "7499517D31F6BB5A8C81E7F214D9B3AE", hash_generated_field = "6174F7D700555E8351851299D2389EB2")

    public static int sStartStopScoIterations = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.705 -0400", hash_original_field = "D414B4387A58E3149586DBF07CBA2F34", hash_generated_field = "BD59FD23958FD253FF1BE49A1C3DA287")


    public static String sDeviceAddress = "";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.706 -0400", hash_original_field = "7AC94FC12D19944DE4B9B13EF6AD3C9B", hash_generated_field = "2608B9D6E1287395AA18278423C728CF")

    public static byte[] sDevicePairPin = {'1', '2', '3', '4'};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.708 -0400", hash_original_field = "D5F4883077D38BBACD82C332C7CD7095", hash_generated_field = "F518A84DF58E12B063D9AC94CF9A79CE")

    public static int sDevicePairPasskey = 123456;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.709 -0400", hash_original_method = "E1CF533FD89A655DCE04867B3BFB79D6", hash_generated_method = "86F2F0AB1C2F02B85447D9FDD4B5EFAF")
    
@Override
    public TestSuite getAllTests() {
        TestSuite suite = new InstrumentationTestSuite(this);
        suite.addTestSuite(BluetoothStressTest.class);
        return suite;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.710 -0400", hash_original_method = "92BF38D76FCA7EC92F2745F55D16EDC5", hash_generated_method = "C9600D1781D0203883A6968C9840F396")
    
@Override
    public ClassLoader getLoader() {
        return BluetoothTestRunner.class.getClassLoader();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.714 -0400", hash_original_method = "B23C38DDA9C2F4F491A865A88841BBB7", hash_generated_method = "E7DB1B86EEE484B04E61DC9CB6B489C7")
    
@Override
    public void onCreate(Bundle arguments) {
        String val = arguments.getString("enable_iterations");
        if (val != null) {
            try {
                sEnableIterations = Integer.parseInt(val);
            } catch (NumberFormatException e) {
                // Invalid argument, fall back to default value
            }
        }

        val = arguments.getString("discoverable_iterations");
        if (val != null) {
            try {
                sDiscoverableIterations = Integer.parseInt(val);
            } catch (NumberFormatException e) {
                // Invalid argument, fall back to default value
            }
        }

        val = arguments.getString("scan_iterations");
        if (val != null) {
            try {
                sScanIterations = Integer.parseInt(val);
            } catch (NumberFormatException e) {
                // Invalid argument, fall back to default value
            }
        }

        val = arguments.getString("enable_pan_iterations");
        if (val != null) {
            try {
                sEnablePanIterations = Integer.parseInt(val);
            } catch (NumberFormatException e) {
                // Invalid argument, fall back to default value
            }
        }

        val = arguments.getString("pair_iterations");
        if (val != null) {
            try {
                sPairIterations = Integer.parseInt(val);
            } catch (NumberFormatException e) {
                // Invalid argument, fall back to default value
            }
        }

        val = arguments.getString("connect_a2dp_iterations");
        if (val != null) {
            try {
                sConnectA2dpIterations = Integer.parseInt(val);
            } catch (NumberFormatException e) {
                // Invalid argument, fall back to default value
            }
        }

        val = arguments.getString("connect_headset_iterations");
        if (val != null) {
            try {
                sConnectHeadsetIterations = Integer.parseInt(val);
            } catch (NumberFormatException e) {
                // Invalid argument, fall back to default value
            }
        }

        val = arguments.getString("connect_input_iterations");
        if (val != null) {
            try {
                sConnectInputIterations = Integer.parseInt(val);
            } catch (NumberFormatException e) {
                // Invalid argument, fall back to default value
            }
        }

        val = arguments.getString("connect_pan_iterations");
        if (val != null) {
            try {
                sConnectPanIterations = Integer.parseInt(val);
            } catch (NumberFormatException e) {
                // Invalid argument, fall back to default value
            }
        }

        val = arguments.getString("start_stop_sco_iterations");
        if (val != null) {
            try {
                sStartStopScoIterations = Integer.parseInt(val);
            } catch (NumberFormatException e) {
                // Invalid argument, fall back to default value
            }
        }

        val = arguments.getString("device_address");
        if (val != null) {
            sDeviceAddress = val;
        }

        val = arguments.getString("device_pair_pin");
        if (val != null) {
            byte[] pin = BluetoothDevice.convertPinToBytes(val);
            if (pin != null) {
                sDevicePairPin = pin;
            }
        }

        val = arguments.getString("device_pair_passkey");
        if (val != null) {
            try {
                sDevicePairPasskey = Integer.parseInt(val);
            } catch (NumberFormatException e) {
                // Invalid argument, fall back to default value
            }
        }

        Log.i(TAG, String.format("enable_iterations=%d", sEnableIterations));
        Log.i(TAG, String.format("discoverable_iterations=%d", sDiscoverableIterations));
        Log.i(TAG, String.format("scan_iterations=%d", sScanIterations));
        Log.i(TAG, String.format("pair_iterations=%d", sPairIterations));
        Log.i(TAG, String.format("connect_a2dp_iterations=%d", sConnectA2dpIterations));
        Log.i(TAG, String.format("connect_headset_iterations=%d", sConnectHeadsetIterations));
        Log.i(TAG, String.format("connect_input_iterations=%d", sConnectInputIterations));
        Log.i(TAG, String.format("connect_pan_iterations=%d", sConnectPanIterations));
        Log.i(TAG, String.format("start_stop_sco_iterations=%d", sStartStopScoIterations));
        Log.i(TAG, String.format("device_address=%s", sDeviceAddress));
        Log.i(TAG, String.format("device_pair_pin=%s", new String(sDevicePairPin)));
        Log.i(TAG, String.format("device_pair_passkey=%d", sDevicePairPasskey));

        // Call onCreate last since we want to set the static variables first.
        super.onCreate(arguments);
    }
}
