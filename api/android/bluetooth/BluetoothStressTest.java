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
import android.content.Context;
import android.test.InstrumentationTestCase;

/**
 * Stress test suite for Bluetooth related functions.
 *
 * Includes tests for enabling/disabling bluetooth, enabling/disabling discoverable mode,
 * starting/stopping scans, connecting/disconnecting to HFP, A2DP, HID, PAN profiles, and verifying
 * that remote connections/disconnections occur for the PAN profile.
 * <p>
 * This test suite uses {@link android.bluetooth.BluetoothTestRunner} to for parameters such as the
 * number of iterations and the addresses of remote Bluetooth devices.
 */
public class BluetoothStressTest extends InstrumentationTestCase {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.455 -0400", hash_original_field = "082D58A9D6CB9BC7C9273B5B1A201D45", hash_generated_field = "15E47E8AD389E09D30464A8C4FA8C348")

    private static final String TAG = "BluetoothStressTest";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.457 -0400", hash_original_field = "9144E22E956EE2F951CFA8226E4DD0C5", hash_generated_field = "1AD28D40A6AD56177E6E6E8A416B0B0B")

    private static final String OUTPUT_FILE = "BluetoothStressTestOutput.txt";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.459 -0400", hash_original_field = "8413595C3B16D6EF4D15BCA17CD10734", hash_generated_field = "4F70543AE3722D965EF3C058D19A48A0")

    private static final long SCO_SLEEP_TIME = 2 * 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.461 -0400", hash_original_field = "E4ED05226F38F4A27003E8BF404E518E", hash_generated_field = "1F986A3D670BBE53C4AFF5EF8F4000A4")


    private BluetoothTestUtils mTestUtils;

    @DSComment("Added for droidsafe")
    @DSSafe(DSCat.DROIDSAFE_INTERNAL)
    public BluetoothStressTest () {
        super();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.462 -0400", hash_original_method = "745BD85BD6E3F460090608614DE3001E", hash_generated_method = "5114D2B289C3438393FBBA280AC00621")
    
@Override
    protected void setUp() throws Exception {
        super.setUp();

        Context context = getInstrumentation().getTargetContext();
        mTestUtils = new BluetoothTestUtils(context, TAG, OUTPUT_FILE);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.463 -0400", hash_original_method = "8C01DB275AC54900BE62C9306B918F59", hash_generated_method = "C96DF5C1B2951DB4DDE42C3D910A46CA")
    
@Override
    protected void tearDown() throws Exception {
        super.tearDown();

        mTestUtils.close();
    }

    /**
     * Stress test for enabling and disabling Bluetooth.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.465 -0400", hash_original_method = "8B9C9DA5FC3E4B4973EEF627B10AB2C3", hash_generated_method = "E5C48F7C4C445F8E9E1E390A2036B6DD")
    
public void testEnable() {
        int iterations = BluetoothTestRunner.sEnableIterations;
        if (iterations == 0) {
            return;
        }

        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        mTestUtils.disable(adapter);

        for (int i = 0; i < iterations; i++) {
            mTestUtils.writeOutput("enable iteration " + (i + 1) + " of " + iterations);
            mTestUtils.enable(adapter);
            mTestUtils.disable(adapter);
        }
    }

    /**
     * Stress test for putting the device in and taking the device out of discoverable mode.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.467 -0400", hash_original_method = "72773B6FD1BAF89A8E321B3FAD129281", hash_generated_method = "A06C768179BEE4123FFEB193A942CDB8")
    
public void testDiscoverable() {
        int iterations = BluetoothTestRunner.sDiscoverableIterations;
        if (iterations == 0) {
            return;
        }

        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        mTestUtils.disable(adapter);
        mTestUtils.enable(adapter);
        mTestUtils.undiscoverable(adapter);

        for (int i = 0; i < iterations; i++) {
            mTestUtils.writeOutput("discoverable iteration " + (i + 1) + " of " + iterations);
            mTestUtils.discoverable(adapter);
            mTestUtils.undiscoverable(adapter);
        }

        mTestUtils.disable(adapter);
    }

    /**
     * Stress test for starting and stopping Bluetooth scans.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.470 -0400", hash_original_method = "D9486A6F58546751D8369EF6825870E2", hash_generated_method = "F8E1636E64E8A8ADC3FABD70F2D84439")
    
public void testScan() {
        int iterations = BluetoothTestRunner.sScanIterations;
        if (iterations == 0) {
            return;
        }

        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        mTestUtils.disable(adapter);
        mTestUtils.enable(adapter);
        mTestUtils.stopScan(adapter);

        for (int i = 0; i < iterations; i++) {
            mTestUtils.writeOutput("scan iteration " + (i + 1) + " of " + iterations);
            mTestUtils.startScan(adapter);
            mTestUtils.stopScan(adapter);
        }

        mTestUtils.disable(adapter);
    }

    /**
     * Stress test for enabling and disabling the PAN NAP profile.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.471 -0400", hash_original_method = "4BC4820D321CD470B31CD7A09BA15480", hash_generated_method = "B9C82E57AD62EB002BF2F4FF7506E536")
    
public void testEnablePan() {
        int iterations = BluetoothTestRunner.sEnablePanIterations;
        if (iterations == 0) {
            return;
        }
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        mTestUtils.disable(adapter);
        mTestUtils.enable(adapter);
        mTestUtils.disablePan(adapter);

        for (int i = 0; i < iterations; i++) {
            mTestUtils.writeOutput("testEnablePan iteration " + (i + 1) + " of "
                    + iterations);
            mTestUtils.enablePan(adapter);
            mTestUtils.disablePan(adapter);
        }

        mTestUtils.disable(adapter);
    }

    /**
     * Stress test for pairing and unpairing with a remote device.
     * <p>
     * In this test, the local device initiates pairing with a remote device, and then unpairs with
     * the device after the pairing has successfully completed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.474 -0400", hash_original_method = "BB297CAFD750B39432B731757BB5A73D", hash_generated_method = "9D20AEAC81BE3A83A5489A9767BF57A8")
    
public void testPair() {
        int iterations = BluetoothTestRunner.sPairIterations;
        if (iterations == 0) {
            return;
        }

        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        BluetoothDevice device = adapter.getRemoteDevice(BluetoothTestRunner.sDeviceAddress);
        mTestUtils.disable(adapter);
        mTestUtils.enable(adapter);
        mTestUtils.unpair(adapter, device);

        for (int i = 0; i < iterations; i++) {
            mTestUtils.writeOutput("pair iteration " + (i + 1) + " of " + iterations);
            mTestUtils.pair(adapter, device, BluetoothTestRunner.sDevicePairPasskey,
                    BluetoothTestRunner.sDevicePairPin);
            mTestUtils.unpair(adapter, device);
        }
        mTestUtils.disable(adapter);
    }

    /**
     * Stress test for accepting a pairing request and unpairing with a remote device.
     * <p>
     * In this test, the local device waits for a pairing request from a remote device.  It accepts
     * the request and then unpairs after the paring has successfully completed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.476 -0400", hash_original_method = "7E0A74B7C6B5750220E60EABED544AD7", hash_generated_method = "7DFAA4502CD1400538DA255F791B58B0")
    
public void testAcceptPair() {
        int iterations = BluetoothTestRunner.sPairIterations;
        if (iterations == 0) {
            return;
        }
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        BluetoothDevice device = adapter.getRemoteDevice(BluetoothTestRunner.sDeviceAddress);
        mTestUtils.disable(adapter);
        mTestUtils.enable(adapter);
        mTestUtils.unpair(adapter, device);

        for (int i = 0; i < iterations; i++) {
            mTestUtils.writeOutput("acceptPair iteration " + (i + 1) + " of " + iterations);
            mTestUtils.acceptPair(adapter, device, BluetoothTestRunner.sDevicePairPasskey,
                    BluetoothTestRunner.sDevicePairPin);
            mTestUtils.unpair(adapter, device);
        }
        mTestUtils.disable(adapter);
    }

    /**
     * Stress test for connecting and disconnecting with an A2DP source.
     * <p>
     * In this test, the local device plays the role of an A2DP sink, and initiates connections and
     * disconnections with an A2DP source.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.479 -0400", hash_original_method = "B6499AFB25874554EAD148116227F41C", hash_generated_method = "70CFCC7000B115D8A6B14D0538991BA0")
    
public void testConnectA2dp() {
        int iterations = BluetoothTestRunner.sConnectA2dpIterations;
        if (iterations == 0) {
            return;
        }

        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        BluetoothDevice device = adapter.getRemoteDevice(BluetoothTestRunner.sDeviceAddress);
        mTestUtils.disable(adapter);
        mTestUtils.enable(adapter);
        mTestUtils.unpair(adapter, device);
        mTestUtils.pair(adapter, device, BluetoothTestRunner.sDevicePairPasskey,
                BluetoothTestRunner.sDevicePairPin);
        mTestUtils.disconnectProfile(adapter, device, BluetoothProfile.A2DP, null);

        for (int i = 0; i < iterations; i++) {
            mTestUtils.writeOutput("connectA2dp iteration " + (i + 1) + " of " + iterations);
            mTestUtils.connectProfile(adapter, device, BluetoothProfile.A2DP,
                    String.format("connectA2dp(device=%s)", device));
            mTestUtils.disconnectProfile(adapter, device, BluetoothProfile.A2DP,
                    String.format("disconnectA2dp(device=%s)", device));
        }

        mTestUtils.unpair(adapter, device);
        mTestUtils.disable(adapter);
    }

    /**
     * Stress test for connecting and disconnecting the HFP with a hands free device.
     * <p>
     * In this test, the local device plays the role of an HFP audio gateway, and initiates
     * connections and disconnections with a hands free device.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.481 -0400", hash_original_method = "953C45E0AC0E3330C0DA112A167E7505", hash_generated_method = "D4744E6A8E81B3052A8AD8080D4B0E46")
    
public void testConnectHeadset() {
        int iterations = BluetoothTestRunner.sConnectHeadsetIterations;
        if (iterations == 0) {
            return;
        }

        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        BluetoothDevice device = adapter.getRemoteDevice(BluetoothTestRunner.sDeviceAddress);
        mTestUtils.disable(adapter);
        mTestUtils.enable(adapter);
        mTestUtils.unpair(adapter, device);
        mTestUtils.pair(adapter, device, BluetoothTestRunner.sDevicePairPasskey,
                BluetoothTestRunner.sDevicePairPin);
        mTestUtils.disconnectProfile(adapter, device, BluetoothProfile.HEADSET, null);

        for (int i = 0; i < iterations; i++) {
            mTestUtils.writeOutput("connectHeadset iteration " + (i + 1) + " of " + iterations);
            mTestUtils.connectProfile(adapter, device, BluetoothProfile.HEADSET,
                    String.format("connectHeadset(device=%s)", device));
            mTestUtils.disconnectProfile(adapter, device, BluetoothProfile.HEADSET,
                    String.format("disconnectHeadset(device=%s)", device));
        }

        mTestUtils.unpair(adapter, device);
        mTestUtils.disable(adapter);
    }

    /**
     * Stress test for connecting and disconnecting with a HID device.
     * <p>
     * In this test, the local device plays the role of a HID host, and initiates connections and
     * disconnections with a HID device.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.483 -0400", hash_original_method = "1C28DB1C2E0E3429B1E7E978A47E1708", hash_generated_method = "F86FF65764F702E2AC455F5D8D050E1D")
    
public void testConnectInput() {
        int iterations = BluetoothTestRunner.sConnectInputIterations;
        if (iterations == 0) {
            return;
        }

        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        BluetoothDevice device = adapter.getRemoteDevice(BluetoothTestRunner.sDeviceAddress);
        mTestUtils.disable(adapter);
        mTestUtils.enable(adapter);
        mTestUtils.unpair(adapter, device);
        mTestUtils.pair(adapter, device, BluetoothTestRunner.sDevicePairPasskey,
                BluetoothTestRunner.sDevicePairPin);
        mTestUtils.disconnectProfile(adapter, device, BluetoothProfile.INPUT_DEVICE, null);

        for (int i = 0; i < iterations; i++) {
            mTestUtils.writeOutput("connectInput iteration " + (i + 1) + " of " + iterations);
            mTestUtils.connectProfile(adapter, device, BluetoothProfile.INPUT_DEVICE,
                    String.format("connectInput(device=%s)", device));
            mTestUtils.disconnectProfile(adapter, device, BluetoothProfile.INPUT_DEVICE,
                    String.format("disconnectInput(device=%s)", device));
        }

        mTestUtils.unpair(adapter, device);
        mTestUtils.disable(adapter);
    }

    /**
     * Stress test for connecting and disconnecting with a PAN NAP.
     * <p>
     * In this test, the local device plays the role of a PANU, and initiates connections and
     * disconnections with a NAP.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.485 -0400", hash_original_method = "61CF21D5626AAAED4DA1E8F18F7DC7B0", hash_generated_method = "8DE6D5EAB77828E6FFA3FF9E6AFE1CB8")
    
public void testConnectPan() {
        int iterations = BluetoothTestRunner.sConnectPanIterations;
        if (iterations == 0) {
            return;
        }

        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        BluetoothDevice device = adapter.getRemoteDevice(BluetoothTestRunner.sDeviceAddress);
        mTestUtils.disable(adapter);
        mTestUtils.enable(adapter);
        mTestUtils.unpair(adapter, device);
        mTestUtils.pair(adapter, device, BluetoothTestRunner.sDevicePairPasskey,
                BluetoothTestRunner.sDevicePairPin);

        for (int i = 0; i < iterations; i++) {
            mTestUtils.writeOutput("connectPan iteration " + (i + 1) + " of " + iterations);
            mTestUtils.connectPan(adapter, device);
            mTestUtils.disconnectPan(adapter, device);
        }

        mTestUtils.unpair(adapter, device);
        mTestUtils.disable(adapter);
    }

    /**
     * Stress test for verifying a PANU connecting and disconnecting with the device.
     * <p>
     * In this test, the local device plays the role of a NAP which a remote PANU connects and
     * disconnects from.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.487 -0400", hash_original_method = "AB50331EB13A7093DFB033A250FD5E79", hash_generated_method = "4E82241066805D693816137FDF614267")
    
public void testIncomingPanConnection() {
        int iterations = BluetoothTestRunner.sConnectPanIterations;
        if (iterations == 0) {
            return;
        }

        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        BluetoothDevice device = adapter.getRemoteDevice(BluetoothTestRunner.sDeviceAddress);
        mTestUtils.disable(adapter);
        mTestUtils.enable(adapter);
        mTestUtils.disablePan(adapter);
        mTestUtils.enablePan(adapter);
        mTestUtils.unpair(adapter, device);
        mTestUtils.acceptPair(adapter, device, BluetoothTestRunner.sDevicePairPasskey,
                BluetoothTestRunner.sDevicePairPin);

        for (int i = 0; i < iterations; i++) {
            mTestUtils.writeOutput("incomingPanConnection iteration " + (i + 1) + " of "
                    + iterations);
            mTestUtils.incomingPanConnection(adapter, device);
            mTestUtils.incomingPanDisconnection(adapter, device);
        }

        mTestUtils.unpair(adapter, device);
        mTestUtils.disablePan(adapter);
        mTestUtils.disable(adapter);
    }

    /**
     * Stress test for verifying that AudioManager can open and close SCO connections.
     * <p>
     * In this test, a HSP connection is opened with an external headset and the SCO connection is
     * repeatibly opened and closed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.490 -0400", hash_original_method = "C58FF31B6CE06AE1641E1EEB8394D33A", hash_generated_method = "167BD54252CA376600139F1023026E37")
    
public void testStartStopSco() {
        int iterations = BluetoothTestRunner.sStartStopScoIterations;
        if (iterations == 0) {
            return;
        }

        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        BluetoothDevice device = adapter.getRemoteDevice(BluetoothTestRunner.sDeviceAddress);
        mTestUtils.disable(adapter);
        mTestUtils.enable(adapter);
        mTestUtils.unpair(adapter, device);
        mTestUtils.pair(adapter, device, BluetoothTestRunner.sDevicePairPasskey,
                BluetoothTestRunner.sDevicePairPin);
        mTestUtils.disconnectProfile(adapter, device, BluetoothProfile.HEADSET, null);
        mTestUtils.connectProfile(adapter, device, BluetoothProfile.HEADSET, null);
        mTestUtils.stopSco(adapter, device);

        for (int i = 0; i < iterations; i++) {
            mTestUtils.writeOutput("startStopSco iteration " + (i + 1) + " of " + iterations);
            mTestUtils.startSco(adapter, device);
            sleep(SCO_SLEEP_TIME);
            mTestUtils.stopSco(adapter, device);
            sleep(SCO_SLEEP_TIME);
        }

        mTestUtils.disconnectProfile(adapter, device, BluetoothProfile.HEADSET, null);
        mTestUtils.unpair(adapter, device);
        mTestUtils.disable(adapter);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.493 -0400", hash_original_method = "0629FC92FD2F8820DE83C8777475E7FC", hash_generated_method = "3FF705FC4F23F58048AC795EF0011B2E")
    
private void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }
}
