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
 * Copyright (C) 2007 The Android Open Source Project
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


package com.android.internal.location;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.location.ILocationManager;
import android.location.LocationProvider;





public class DummyLocationProvider extends LocationProvider {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.030 -0500", hash_original_field = "036700B587116F08160B17126A41D222", hash_generated_field = "901EFB6E43A09AC53DEA608D292AE5C5")


    private static final String TAG = "DummyLocationProvider";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.032 -0500", hash_original_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C", hash_generated_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C")


    String mName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.034 -0500", hash_original_field = "DF2B3171B11A67F621676EF40A236159", hash_generated_field = "DF2B3171B11A67F621676EF40A236159")

    boolean mRequiresNetwork;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.036 -0500", hash_original_field = "2FAE948EF0EDA44AE36030A345BCA7F9", hash_generated_field = "2FAE948EF0EDA44AE36030A345BCA7F9")

    boolean mRequiresSatellite;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.038 -0500", hash_original_field = "CD2451BEADF29CB4B04A5FBF2BECE7A5", hash_generated_field = "CD2451BEADF29CB4B04A5FBF2BECE7A5")

    boolean mRequiresCell;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.040 -0500", hash_original_field = "9BB0C6F2515CD3D4097971FB7222AFC9", hash_generated_field = "9BB0C6F2515CD3D4097971FB7222AFC9")

    boolean mHasMonetaryCost;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.043 -0500", hash_original_field = "FE17A406A6FDB81F55F27A7ED9FDCF16", hash_generated_field = "FE17A406A6FDB81F55F27A7ED9FDCF16")

    boolean mSupportsAltitude;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.045 -0500", hash_original_field = "E9787058DB54707705A7DDFE4B3B4B19", hash_generated_field = "E9787058DB54707705A7DDFE4B3B4B19")

    boolean mSupportsSpeed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.047 -0500", hash_original_field = "8D283BB3EB5888B0DE27DB1FD6DF7003", hash_generated_field = "8D283BB3EB5888B0DE27DB1FD6DF7003")

    boolean mSupportsBearing;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.049 -0500", hash_original_field = "16051051674F42DF07BACDCFF2C64789", hash_generated_field = "16051051674F42DF07BACDCFF2C64789")

    int mPowerRequirement;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.051 -0500", hash_original_field = "A988C0B68D6A03FA302108721EA90905", hash_generated_field = "A988C0B68D6A03FA302108721EA90905")

    int mAccuracy;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.054 -0500", hash_original_method = "2D2A21251E5C69E5D6553C80AB5C5FAF", hash_generated_method = "77A112D458E6A40C738F3C0C3F4BB179")
    
public DummyLocationProvider(String name, ILocationManager service) {
        super(name, service);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.056 -0500", hash_original_method = "1F8DE8B3742DB968D48AC8E46FA2231B", hash_generated_method = "AA31186A12DB92065A478F48B0BE825D")
    
public void setRequiresNetwork(boolean requiresNetwork) {
        mRequiresNetwork = requiresNetwork;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.059 -0500", hash_original_method = "29EAF7BAC1D59C67F0068E19069EC95C", hash_generated_method = "F7AFF99EA5D3C318D5F05503D073A715")
    
public void setRequiresSatellite(boolean requiresSatellite) {
        mRequiresSatellite = requiresSatellite;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.061 -0500", hash_original_method = "800DBE9AB92460271BA9850123B2E01B", hash_generated_method = "8FBC2E7D75E676CE49EE396162D25759")
    
public void setRequiresCell(boolean requiresCell) {
        mRequiresCell = requiresCell;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.063 -0500", hash_original_method = "3E58BDCD583420258AF42AE15C5A1B66", hash_generated_method = "FA0E3966BECC2561945DE8D222E3026E")
    
public void setHasMonetaryCost(boolean hasMonetaryCost) {
        mHasMonetaryCost = hasMonetaryCost;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.065 -0500", hash_original_method = "CCF8D193AEBD5AA7F01F4990E2AE806C", hash_generated_method = "7ACE697EC1276D601BE4E5AD2F080716")
    
public void setSupportsAltitude(boolean supportsAltitude) {
        mSupportsAltitude = supportsAltitude;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.068 -0500", hash_original_method = "92E2AFB41DD112983B18606F5344DACF", hash_generated_method = "0AAA6CDE501E529F4A8CA553E3CB3172")
    
public void setSupportsSpeed(boolean supportsSpeed) {
        mSupportsSpeed = supportsSpeed;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.070 -0500", hash_original_method = "F9CE2AAA32ACB1BAFD2F9DDDA0BB7D16", hash_generated_method = "A40D06EC4786DD8106FB746A26F20DF2")
    
public void setSupportsBearing(boolean supportsBearing) {
        mSupportsBearing = supportsBearing;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.073 -0500", hash_original_method = "2C88F96CAFDD5DC38199E97F56E6E512", hash_generated_method = "611108FDCE2C9F18E25748D3B8F04F90")
    
public void setPowerRequirement(int powerRequirement) {
        mPowerRequirement = powerRequirement;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.075 -0500", hash_original_method = "50C70CC35BE1C99F5177BBD5E6545CA6", hash_generated_method = "47A7BF805C789816786B7EAA529FB25E")
    
public void setAccuracy(int accuracy) {
        mAccuracy = accuracy;
    }

    /**
     * Returns true if the provider requires access to a
     * data network (e.g., the Internet), false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.078 -0500", hash_original_method = "12AE735753CC1F454105371651D9BBA1", hash_generated_method = "A81B33F763D33088121941BE1E8C1B6E")
    
public boolean requiresNetwork() {
        return mRequiresNetwork;
    }

    /**
     * Returns true if the provider requires access to a
     * satellite-based positioning system (e.g., GPS), false
     * otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.080 -0500", hash_original_method = "A3DAE9100E63CBDE8137FDA5BE5C7B6B", hash_generated_method = "E0928F8D947374F2A6FB1E21C53181F2")
    
public boolean requiresSatellite() {
        return mRequiresSatellite;
    }

    /**
     * Returns true if the provider requires access to an appropriate
     * cellular network (e.g., to make use of cell tower IDs), false
     * otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.082 -0500", hash_original_method = "BE22582F45632E0BED7FA33E3D9F0EE8", hash_generated_method = "F6F8BD7FBA472C986BE96F01F2A83000")
    
public boolean requiresCell() {
        return mRequiresCell;
    }

    /**
     * Returns true if the use of this provider may result in a
     * monetary charge to the user, false if use is free.  It is up to
     * each provider to give accurate information.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.085 -0500", hash_original_method = "464B91F9461F0393A5548F6081396811", hash_generated_method = "B757C01EA85FA3AA8E87FB8B83D365B8")
    
public boolean hasMonetaryCost() {
        return mHasMonetaryCost;
    }

    /**
     * Returns true if the provider is able to provide altitude
     * information, false otherwise.  A provider that reports altitude
     * under most circumstances but may occassionally not report it
     * should return true.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.087 -0500", hash_original_method = "80EB2267564425834001A2243EC06FBE", hash_generated_method = "05AF2D80C1C2969F40EC19317DB18762")
    
public boolean supportsAltitude() {
        return mSupportsAltitude;
    }

    /**
     * Returns true if the provider is able to provide speed
     * information, false otherwise.  A provider that reports speed
     * under most circumstances but may occassionally not report it
     * should return true.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.089 -0500", hash_original_method = "F5A7ECCEC7D24AC04E83E34652847C55", hash_generated_method = "699F071C1CBEEB2E6FEA6030D9D2E614")
    
public boolean supportsSpeed() {
        return mSupportsSpeed;
    }

    /**
     * Returns true if the provider is able to provide bearing
     * information, false otherwise.  A provider that reports bearing
     * under most circumstances but may occassionally not report it
     * should return true.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.091 -0500", hash_original_method = "ADDCD70E458E7B4958723B2C0A9B7ABB", hash_generated_method = "26C0FDB7EDCC79336E3E1458678B9E65")
    
public boolean supportsBearing() {
        return mSupportsBearing;
    }

    /**
     * Returns the power requirement for this provider.
     *
     * @return the power requirement for this provider, as one of the
     * constants Criteria.POWER_REQUIREMENT_*.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.094 -0500", hash_original_method = "50AB5D6061392E8FAC8A81CA41B14FB2", hash_generated_method = "3E881DFE958F83CAFAEFC8ECCCA7BA30")
    
public int getPowerRequirement() {
        return mPowerRequirement;
    }

    /**
     * Returns a constant describing the horizontal accuracy returned
     * by this provider.
     *
     * @return the horizontal accuracy for this provider, as one of the
     * constants Criteria.ACCURACY_*.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:40.096 -0500", hash_original_method = "8D132D636D1C633E7B8C919AFBA33B78", hash_generated_method = "D17199E4C2197E334AA29FCE6A47DA23")
    
public int getAccuracy() {
        return mAccuracy;
    }
}

