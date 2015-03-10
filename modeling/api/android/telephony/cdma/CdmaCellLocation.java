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
 * Copyright (C) 2006 The Android Open Source Project
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


package android.telephony.cdma;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Bundle;
import android.telephony.CellLocation;

public class CdmaCellLocation extends CellLocation {

    /**
     * Test whether two objects hold the same data values or both are null
     *
     * @param a first obj
     * @param b second obj
     * @return true if two objects equal or both are null
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:50.390 -0500", hash_original_method = "BC145A1DE2472995676ED9A315FB0956", hash_generated_method = "171409CD29A7B7D5AD18DD4C394534AC")
    
private static boolean equalsHandlesNulls(Object a, Object b) {
        return (a == null) ? (b == null) : a.equals (b);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:50.328 -0500", hash_original_field = "AB22FEF41F054524882E280FBA21BFF9", hash_generated_field = "28DC8731CB240B39E76829C4149A3B3B")

    public final static int INVALID_LAT_LONG = Integer.MAX_VALUE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:50.325 -0500", hash_original_field = "1DAAC22FDD0CACDE0DF992CF4E041CAC", hash_generated_field = "880CD477F89AEF4CABEE47659812611F")

    private int mBaseStationId = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:50.332 -0500", hash_original_field = "F492F0E5332633244CE0BBCD1A9F2CF1", hash_generated_field = "F33E82AA4D4032A9950970FEC5999108")

    private int mBaseStationLatitude = INVALID_LAT_LONG;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:50.335 -0500", hash_original_field = "FCE49C5F806697C4D625CA7B24AA8724", hash_generated_field = "72B050148DB085190086BCC6506DAE80")

    private int mBaseStationLongitude = INVALID_LAT_LONG;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:50.338 -0500", hash_original_field = "1C3D2A2E0A02FAC6C32003C68BDB416D", hash_generated_field = "5B31DE8CC89DD13B11EA69E8D17F6B69")

    private int mSystemId = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:50.342 -0500", hash_original_field = "99E5913F52142C86A537ABB02FD4C95D", hash_generated_field = "61B4BCE8DF023A8A81D64AB2D58B0D50")

    private int mNetworkId = -1;

    /**
     * Empty constructor.
     * Initializes the BID, SID, NID and base station latitude and longitude
     * to invalid values.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:50.346 -0500", hash_original_method = "5C896DC446B6DB5EAC37BD66E663CEA5", hash_generated_method = "72C49FE94E405546FA5F71F3CADB7473")
    
public CdmaCellLocation() {
        this.mBaseStationId = -1;
        this.mBaseStationLatitude = INVALID_LAT_LONG;
        this.mBaseStationLongitude = INVALID_LAT_LONG;
        this.mSystemId = -1;
        this.mNetworkId = -1;
    }

    /**
     * Initialize the object from a bundle.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:50.350 -0500", hash_original_method = "8EA08E2DEACD96E97EA367485FCE09D0", hash_generated_method = "5249F70A2FFA509D6B2B6D4E7A13567C")
    
public CdmaCellLocation(Bundle bundle) {
        this.mBaseStationId = bundle.getInt("baseStationId", mBaseStationId);
        this.mBaseStationLatitude = bundle.getInt("baseStationLatitude", mBaseStationLatitude);
        this.mBaseStationLongitude = bundle.getInt("baseStationLongitude", mBaseStationLongitude);
        this.mSystemId = bundle.getInt("systemId", mSystemId);
        this.mNetworkId = bundle.getInt("networkId", mNetworkId);
    }

    /**
     * @return cdma base station identification number, -1 if unknown
     */
    @DSSource({DSSourceKind.LOCATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:50.353 -0500", hash_original_method = "5BA2DB973405907BCB7576020C4BB767", hash_generated_method = "B6E0DF355EB8A553E136B7CE28C8F20A")
    
public int getBaseStationId() {
        return this.mBaseStationId;
    }

    /**
     * @return cdma base station latitude, Integer.MAX_VALUE if unknown
     */
    @DSSource({DSSourceKind.LOCATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:50.356 -0500", hash_original_method = "8D32771FFADF2E37F4C4C4E7BB2945F8", hash_generated_method = "D01FD695044C5CF144C02ED4988FC0CB")
    
public int getBaseStationLatitude() {
        return this.mBaseStationLatitude;
    }

    /**
     * @return cdma base station longitude, Integer.MAX_VALUE if unknown
     */
    @DSSource({DSSourceKind.LOCATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:50.359 -0500", hash_original_method = "B2E759A184D0C15083668122E08B0641", hash_generated_method = "C51EF04CAB8F8FD62698DF135133A2C2")
    
public int getBaseStationLongitude() {
        return this.mBaseStationLongitude;
    }

    /**
     * @return cdma system identification number, -1 if unknown
     */
    @DSSource({DSSourceKind.LOCATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:50.363 -0500", hash_original_method = "E5E4F22C1EB64E5BA2863333F6C891A3", hash_generated_method = "318DA97F6722F5CBE558371991B6EC9C")
    
public int getSystemId() {
        return this.mSystemId;
    }

    /**
     * @return cdma network identification number, -1 if unknown
     */
    @DSSource({DSSourceKind.LOCATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:50.365 -0500", hash_original_method = "909C93F66AD557988A123F548D8C31FC", hash_generated_method = "3C8DAA33B7EF9A3BB4D25A7A63500EE0")
    
public int getNetworkId() {
        return this.mNetworkId;
    }

    /**
     * Invalidate this object.  The cell location data is set to invalid values.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:50.368 -0500", hash_original_method = "0C9042B8D6AE69440E11B69CE7953639", hash_generated_method = "76D3AE40DFA461A76CB68934EB39961A")
    
public void setStateInvalid() {
        this.mBaseStationId = -1;
        this.mBaseStationLatitude = INVALID_LAT_LONG;
        this.mBaseStationLongitude = INVALID_LAT_LONG;
        this.mSystemId = -1;
        this.mNetworkId = -1;
    }

    /**
     * Set the cell location data.
     */
     @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:50.372 -0500", hash_original_method = "61B794D65EE283C3FD04A14E94D0946D", hash_generated_method = "BDFAF739B4F3A03A1EDDA8F98695DAF4")
    
public void setCellLocationData(int baseStationId, int baseStationLatitude,
         int baseStationLongitude) {
         // The following values have to be written in the correct sequence
         this.mBaseStationId = baseStationId;
         this.mBaseStationLatitude = baseStationLatitude;   //values[2];
         this.mBaseStationLongitude = baseStationLongitude; //values[3];
    }

    /**
     * Set the cell location data.
     */
     @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:50.376 -0500", hash_original_method = "4013196C0844C1883550E95EB904B1DA", hash_generated_method = "D7EE527371FAAECF69E9ACD28ECFBA6E")
    
public void setCellLocationData(int baseStationId, int baseStationLatitude,
         int baseStationLongitude, int systemId, int networkId) {
         // The following values have to be written in the correct sequence
         this.mBaseStationId = baseStationId;
         this.mBaseStationLatitude = baseStationLatitude;   //values[2];
         this.mBaseStationLongitude = baseStationLongitude; //values[3];
         this.mSystemId = systemId;
         this.mNetworkId = networkId;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:50.380 -0500", hash_original_method = "E85418559CBFBFDF0470CD6A904DEAD1", hash_generated_method = "E5373DFFC18A2CEF7D1A5390BFDBF977")
    
@Override
    public int hashCode() {
        return this.mBaseStationId ^ this.mBaseStationLatitude ^ this.mBaseStationLongitude
                ^ this.mSystemId ^ this.mNetworkId;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:50.383 -0500", hash_original_method = "38D738FF275D66A3A0FE767FC9AC4FB9", hash_generated_method = "A0A2C615D71201572F077EB4640CAEA8")
    
@Override
    public boolean equals(Object o) {
        CdmaCellLocation s;

        try {
            s = (CdmaCellLocation)o;
        } catch (ClassCastException ex) {
            return false;
        }

        if (o == null) {
            return false;
        }

        return (equalsHandlesNulls(this.mBaseStationId, s.mBaseStationId) &&
                equalsHandlesNulls(this.mBaseStationLatitude, s.mBaseStationLatitude) &&
                equalsHandlesNulls(this.mBaseStationLongitude, s.mBaseStationLongitude) &&
                equalsHandlesNulls(this.mSystemId, s.mSystemId) &&
                equalsHandlesNulls(this.mNetworkId, s.mNetworkId)
        );
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:50.387 -0500", hash_original_method = "3AD4832D3A3F9EB2D9CB5CAE1051FD90", hash_generated_method = "F3A266AAE5B33F24D312A4D2BC366BCB")
    
@Override
    public String toString() {
        return "[" + this.mBaseStationId + ","
                   + this.mBaseStationLatitude + ","
                   + this.mBaseStationLongitude + ","
                   + this.mSystemId + ","
                   + this.mNetworkId + "]";
    }

    /**
     * Fill the cell location data into the intent notifier Bundle based on service state
     *
     * @param bundleToFill intent notifier Bundle
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:50.393 -0500", hash_original_method = "A94D1CCD0A9181704E5BCB2385E1DEF3", hash_generated_method = "B480E4364F540DFC4E4FFC1299A7E946")
    
public void fillInNotifierBundle(Bundle bundleToFill) {
        bundleToFill.putInt("baseStationId", this.mBaseStationId);
        bundleToFill.putInt("baseStationLatitude", this.mBaseStationLatitude);
        bundleToFill.putInt("baseStationLongitude", this.mBaseStationLongitude);
        bundleToFill.putInt("systemId", this.mSystemId);
        bundleToFill.putInt("networkId", this.mNetworkId);
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:50.397 -0500", hash_original_method = "8DF1697B3E0EEA68CA131C0067500EBA", hash_generated_method = "09A4D6F7700DC997EE8C8599C21D05AF")
    
public boolean isEmpty() {
        return (this.mBaseStationId == -1 &&
                this.mBaseStationLatitude == INVALID_LAT_LONG &&
                this.mBaseStationLongitude == INVALID_LAT_LONG &&
                this.mSystemId == -1 &&
                this.mNetworkId == -1);
    }
}

