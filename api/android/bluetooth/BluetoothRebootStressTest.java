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
 * Instrumentation test case for stress test involving rebooting the device.
 * <p>
 * This test case tests that bluetooth is enabled after a device reboot. Because
 * the device will reboot, the instrumentation must be driven by a script on the
 * host side.
 */
public class BluetoothRebootStressTest extends InstrumentationTestCase {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.340 -0400", hash_original_field = "7FBBC2BAABAEE60CD82BE27CD982C524", hash_generated_field = "316E5B99B6376873B247B5E0B6AB44FF")

    private static final String TAG = "BluetoothRebootStressTest";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.342 -0400", hash_original_field = "B2FCBB849BB7C41B3476B8980CC6A495", hash_generated_field = "B82BA8A500FD042F7A25C291B7C38975")

    private static final String OUTPUT_FILE = "BluetoothRebootStressTestOutput.txt";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.343 -0400", hash_original_field = "E4ED05226F38F4A27003E8BF404E518E", hash_generated_field = "1F986A3D670BBE53C4AFF5EF8F4000A4")

    private BluetoothTestUtils mTestUtils;

    @DSComment("Added for droidsafe")
    @DSSafe(DSCat.SAFE_OTHERS)
    public BluetoothRebootStressTest() {}

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.345 -0400", hash_original_method = "745BD85BD6E3F460090608614DE3001E", hash_generated_method = "5114D2B289C3438393FBBA280AC00621")
    
@Override
    protected void setUp() throws Exception {
        super.setUp();

        Context context = getInstrumentation().getTargetContext();
        mTestUtils = new BluetoothTestUtils(context, TAG, OUTPUT_FILE);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.346 -0400", hash_original_method = "8C01DB275AC54900BE62C9306B918F59", hash_generated_method = "C96DF5C1B2951DB4DDE42C3D910A46CA")
    
@Override
    protected void tearDown() throws Exception {
        super.tearDown();

        mTestUtils.close();
    }

    /**
     * Test method used to start the test by turning bluetooth on.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.348 -0400", hash_original_method = "E7B9D3390C68BECAF734E454EE7DE061", hash_generated_method = "E1786D5BDAAA600C2AA485187A781C8F")
    
public void testStart() {
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        mTestUtils.enable(adapter);
    }

    /**
     * Test method used in the middle iterations of the test to check if
     * bluetooth is on. Does not toggle bluetooth after the check. Assumes that
     * bluetooth has been turned on by {@code #testStart()}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.349 -0400", hash_original_method = "50A7F272B0913EFF8595AF43259262D3", hash_generated_method = "1DF9D780AC311DB0A5F9975E55BB7C2D")
    
public void testMiddleNoToggle() {
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();

        assertTrue(adapter.isEnabled());
    }

    /**
     * Test method used in the middle iterations of the test to check if
     * bluetooth is on. Toggles bluetooth after the check. Assumes that
     * bluetooth has been turned on by {@code #testStart()}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.351 -0400", hash_original_method = "ACFD814E4F3AC6F9C3C66331CDAFB3A1", hash_generated_method = "25D347B49E2B32BAB79E2B611A6F336A")
    
public void testMiddleToggle() {
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();

        assertTrue(adapter.isEnabled());

        mTestUtils.disable(adapter);
        mTestUtils.enable(adapter);
    }

    /**
     * Test method used in the stop the test by turning bluetooth off. Assumes
     * that bluetooth has been turned on by {@code #testStart()}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:15.352 -0400", hash_original_method = "572F8BEBC19033F043F09A275AB5774E", hash_generated_method = "3340F2960AB44847B31774A0508CC450")
    
public void testStop() {
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();

        assertTrue(adapter.isEnabled());

        mTestUtils.disable(adapter);
    }
}
