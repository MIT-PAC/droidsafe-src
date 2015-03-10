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


package android.mtp;

/**
 * This class encapsulates information about an MTP device.
 * This corresponds to the DeviceInfo Dataset described in
 * section 5.1.1 of the MTP specification.
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class MtpDeviceInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.563 -0400", hash_original_field = "FAC2F85538315F855B4418F994096B5B", hash_generated_field = "FB8FA14B444DCDECB7E1F2DE256B790B")

    private String mManufacturer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.565 -0400", hash_original_field = "30F6FA923CB98DBE04C90A0F74F44429", hash_generated_field = "35458D5F083D1893A2F645F3B2CF5FC8")

    private String mModel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.566 -0400", hash_original_field = "BEB2EC516DDBAAA95FFA667FE90CB933", hash_generated_field = "AC3A255360E36E7AB143ED8BE7D264A7")

    private String mVersion;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.568 -0400", hash_original_field = "F0E072EB1BAEFFE91D9C6953C60ABE47", hash_generated_field = "87E1C352BA1FCD2C4D961AD3FA63C177")

    private String mSerialNumber;

    // only instantiated via JNI
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.570 -0400", hash_original_method = "63AF4C5B06472E53D57F0E9CF2BD1925", hash_generated_method = "6A683661154CB9027A890737FC2B29A5")
    
private MtpDeviceInfo() {
    }

    public MtpDeviceInfo(DSOnlyType doncare) {
    }

    /**
     * Returns the manufacturer's name for the MTP device
     *
     * @return the manufacturer name
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.571 -0400", hash_original_method = "EECC97019E28DA07B84EC558152DCFEE", hash_generated_method = "70E0456DF38F499D411723101E888E94")
    
public final String getManufacturer() {
        return mManufacturer;
    }

    /**
     * Returns the model name for the MTP device
     *
     * @return the model name
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.573 -0400", hash_original_method = "375C14568C2F8D8E7E614D0D011D7B99", hash_generated_method = "0D5C29BEF0F9E473DC27C4382076315E")
    
public final String getModel() {
        return mModel;
    }

    /**
     * Returns the version string the MTP device
     *
     * @return the device version
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.575 -0400", hash_original_method = "F243A33CF0A3D0D255225863927F4698", hash_generated_method = "EAE411E6F622ECF91C024DCDFB8DF0B4")
    
public final String getVersion() {
        return mVersion;
    }

    /**
     * Returns the unique serial number for the MTP device
     *
     * @return the serial number
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.576 -0400", hash_original_method = "067EAB37438646871A3C58A575E3AFCF", hash_generated_method = "F96E5A464AF8C313C932F76BC1CB9030")
    
public final String getSerialNumber() {
        return mSerialNumber;
    }
}
