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


package android.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static android.telephony.TelephonyManager.NETWORK_TYPE_EDGE;
import static android.telephony.TelephonyManager.NETWORK_TYPE_GPRS;
import static android.telephony.TelephonyManager.NETWORK_TYPE_HSDPA;
import static android.telephony.TelephonyManager.NETWORK_TYPE_HSPA;
import static android.telephony.TelephonyManager.NETWORK_TYPE_HSUPA;
import static android.telephony.TelephonyManager.NETWORK_TYPE_UMTS;
import static android.telephony.TelephonyManager.NETWORK_TYPE_UNKNOWN;
import android.os.Parcel;
import android.os.Parcelable;

public class NeighboringCellInfo implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:53.304 -0500", hash_original_field = "DE40DCEBC0CEAA8E834B09B53A4DFBD7", hash_generated_field = "F6EDBF72ECD8A61081441E4AC3C870CD")

    static final public int UNKNOWN_RSSI = 99;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:53.307 -0500", hash_original_field = "3F6A300A7936035128A367B8A1DAA3A4", hash_generated_field = "D9FCCDBBA982AD41A39B7F3CA7D935CF")

    static final public int UNKNOWN_CID = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.141 -0400", hash_original_field = "DE988715B069DAB2E1B83C6FB9A3EF2B", hash_generated_field = "C13A3537973EEEB5EAFEC3144DEB5B69")

    public static final Parcelable.Creator<NeighboringCellInfo> CREATOR
    = new Parcelable.Creator<NeighboringCellInfo>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:53.383 -0500", hash_original_method = "4C52218844DBE15F12DBE2E4C66F708D", hash_generated_method = "D01A9E1C8AB9F70815173D49984FFCD7")
        
public NeighboringCellInfo createFromParcel(Parcel in) {
            return new NeighboringCellInfo(in);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:53.386 -0500", hash_original_method = "95F5832CD053ACEB785D83B20718CEE6", hash_generated_method = "83AF30452F08CB9A12883AF1F35F49F6")
        
public NeighboringCellInfo[] newArray(int size) {
            return new NeighboringCellInfo[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:53.310 -0500", hash_original_field = "099A808424BA5E503C844DE262FD5F84", hash_generated_field = "6944DD992E34997F099DF17CBFD1CEA4")

    private int mRssi;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:53.314 -0500", hash_original_field = "3FDE358D194E184A7314E5F9932F2066", hash_generated_field = "6613038ECFEA58ECF70AB91998D5EB03")

    private int mCid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:53.317 -0500", hash_original_field = "DD653ED27FEE3ABB69B8731CF5FBE1FA", hash_generated_field = "E1DF72766EAA7700CC09E2EF71762BF7")

    private int mLac;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:53.320 -0500", hash_original_field = "DCD75389F80E9394B7B52A1B1EFB37AD", hash_generated_field = "EC9E5D02BA114935D10D39D2FABA270A")

    private int mPsc;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:53.323 -0500", hash_original_field = "DA9EFA3C01E2AE9028200C499AD621FC", hash_generated_field = "60BE94F590B2B55E7F16606AE64523A2")

    private int mNetworkType;

    /**
     * Empty constructor.  Initializes the RSSI and CID.
     *
     * NeighboringCellInfo is one time shot for the neighboring cells based on
     * the radio network type at that moment. Its constructor needs radio network
     * type.
     *
     * @deprecated by {@link #NeighboringCellInfo(int, String, int)}
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:53.327 -0500", hash_original_method = "BD76A3213F8AC49348CAF06FA32CACCC", hash_generated_method = "60DD6DB1EB7CD4DA3DC21B209839C437")
    
@Deprecated
    public NeighboringCellInfo() {
        mRssi = UNKNOWN_RSSI;
        mLac = UNKNOWN_CID;
        mCid = UNKNOWN_CID;
        mPsc = UNKNOWN_CID;
        mNetworkType = NETWORK_TYPE_UNKNOWN;
    }

    /**
     * Initialize the object from rssi and cid.
     *
     * NeighboringCellInfo is one time shot for the neighboring cells based on
     * the radio network type at that moment. Its constructor needs radio network
     * type.
     *
     * @deprecated by {@link #NeighboringCellInfo(int, String, int)}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:53.331 -0500", hash_original_method = "19B23EA98615F51662865132429A9393", hash_generated_method = "D32A2256FC48B63918B20D745C5E46AC")
    
@Deprecated
    public NeighboringCellInfo(int rssi, int cid) {
        mRssi = rssi;
        mCid = cid;
    }

    /**
     * Initialize the object from rssi, location string, and radioType
     * radioType is one of following
     * {@link TelephonyManager#NETWORK_TYPE_GPRS TelephonyManager.NETWORK_TYPE_GPRS},
     * {@link TelephonyManager#NETWORK_TYPE_EDGE TelephonyManager.NETWORK_TYPE_EDGE},
     * {@link TelephonyManager#NETWORK_TYPE_UMTS TelephonyManager.NETWORK_TYPE_UMTS},
     * {@link TelephonyManager#NETWORK_TYPE_HSDPA TelephonyManager.NETWORK_TYPE_HSDPA},
     * {@link TelephonyManager#NETWORK_TYPE_HSUPA TelephonyManager.NETWORK_TYPE_HSUPA},
     * and {@link TelephonyManager#NETWORK_TYPE_HSPA TelephonyManager.NETWORK_TYPE_HSPA}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:53.336 -0500", hash_original_method = "F57F6CF0E582113B7CF21CF2AAAD28CD", hash_generated_method = "3EB60783DA4FC1E5F93F34D92F09A0F1")
    
public NeighboringCellInfo(int rssi, String location, int radioType) {
        // set default value
        mRssi = rssi;
        mNetworkType = NETWORK_TYPE_UNKNOWN;
        mPsc = UNKNOWN_CID;
        mLac = UNKNOWN_CID;
        mCid = UNKNOWN_CID;

        // pad location string with leading "0"
        int l = location.length();
        if (l > 8) return;
        if (l < 8) {
            for (int i = 0; i < (8-l); i++) {
                location = "0" + location;
            }
        }
        // TODO - handle LTE and eHRPD (or find they can't be supported)
        try {// set LAC/CID or PSC based on radioType
            switch (radioType) {
            case NETWORK_TYPE_GPRS:
            case NETWORK_TYPE_EDGE:
                mNetworkType = radioType;
                // check if 0xFFFFFFFF for UNKNOWN_CID
                if (!location.equalsIgnoreCase("FFFFFFFF")) {
                    mCid = Integer.valueOf(location.substring(4), 16);
                    mLac = Integer.valueOf(location.substring(0, 4), 16);
                }
                break;
            case NETWORK_TYPE_UMTS:
            case NETWORK_TYPE_HSDPA:
            case NETWORK_TYPE_HSUPA:
            case NETWORK_TYPE_HSPA:
                mNetworkType = radioType;
                mPsc = Integer.valueOf(location, 16);
                break;
            }
        } catch (NumberFormatException e) {
            // parsing location error
            mPsc = UNKNOWN_CID;
            mLac = UNKNOWN_CID;
            mCid = UNKNOWN_CID;
            mNetworkType = NETWORK_TYPE_UNKNOWN;
        }
    }

    /**
     * Initialize the object from a parcel.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:53.340 -0500", hash_original_method = "17FDCF259E4D17E2ACC4CF1446DF5669", hash_generated_method = "D90BD738D4964C7B89299F008DECB9AE")
    
public NeighboringCellInfo(Parcel in) {
        mRssi = in.readInt();
        mLac = in.readInt();
        mCid = in.readInt();
        mPsc = in.readInt();
        mNetworkType = in.readInt();
    }

    /**
     * @return received signal strength or UNKNOWN_RSSI if unknown
     *
     * For GSM, it is in "asu" ranging from 0 to 31 (dBm = -113 + 2*asu)
     * 0 means "-113 dBm or less" and 31 means "-51 dBm or greater"
     * For UMTS, it is the Level index of CPICH RSCP defined in TS 25.125
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:53.343 -0500", hash_original_method = "EAA2EB56C456A75F6A36236287457095", hash_generated_method = "941E5DA09E96558F6267EFA8918B8C44")
    
public int getRssi() {
        return mRssi;
    }

    /**
     * @return LAC in GSM, 0xffff max legal value
     *  UNKNOWN_CID if in UMTS or CMDA or unknown
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:53.347 -0500", hash_original_method = "9D27DA83295DE88E54D1A14DE01D13B2", hash_generated_method = "A18DED515734753DC64C50C9F3494A83")
    
public int getLac() {
        return mLac;
    }

    /**
     * @return cell id in GSM, 0xffff max legal value
     *  UNKNOWN_CID if in UMTS or CDMA or unknown
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:53.351 -0500", hash_original_method = "03F3B6133F275A943C2D43BD3469FDB7", hash_generated_method = "ED491AA69C7D5EA58049D948836E075E")
    
public int getCid() {
        return mCid;
    }

    /**
     * @return Primary Scrambling Code in 9 bits format in UMTS, 0x1ff max value
     *  UNKNOWN_CID if in GSM or CMDA or unknown
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:53.355 -0500", hash_original_method = "0E29DC7205E312820087B8B417C09B13", hash_generated_method = "27709C0F99A78EF49BB7521467E3693E")
    
public int getPsc() {
        return mPsc;
    }

    /**
     * @return Radio network type while neighboring cell location is stored.
     *
     * Return {@link TelephonyManager#NETWORK_TYPE_UNKNOWN TelephonyManager.NETWORK_TYPE_UNKNOWN}
     * means that the location information is unavailable.
     *
     * Return {@link TelephonyManager#NETWORK_TYPE_GPRS TelephonyManager.NETWORK_TYPE_GPRS} or
     * {@link TelephonyManager#NETWORK_TYPE_EDGE TelephonyManager.NETWORK_TYPE_EDGE}
     * means that Neighboring Cell information is stored for GSM network, in
     * which {@link NeighboringCellInfo#getLac NeighboringCellInfo.getLac} and
     * {@link NeighboringCellInfo#getCid NeighboringCellInfo.getCid} should be
     * called to access location.
     *
     * Return {@link TelephonyManager#NETWORK_TYPE_UMTS TelephonyManager.NETWORK_TYPE_UMTS},
     * {@link TelephonyManager#NETWORK_TYPE_HSDPA TelephonyManager.NETWORK_TYPE_HSDPA},
     * {@link TelephonyManager#NETWORK_TYPE_HSUPA TelephonyManager.NETWORK_TYPE_HSUPA},
     * or {@link TelephonyManager#NETWORK_TYPE_HSPA TelephonyManager.NETWORK_TYPE_HSPA}
     * means that Neighboring Cell information is stored for UMTS network, in
     * which {@link NeighboringCellInfo#getPsc NeighboringCellInfo.getPsc}
     * should be called to access location.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:53.359 -0500", hash_original_method = "BA8FF13D9B34325771E51CDF8D4F958D", hash_generated_method = "3D7DA4F48FFE0ADC9CF5C63B2EFB399C")
    
public int getNetworkType() {
        return mNetworkType;
    }
    /**
     * Set the cell id.
     *
     * NeighboringCellInfo is a one time shot for the neighboring cells based on
     * the radio network type at that moment. It shouldn't be changed after
     * creation.
     *
     * @deprecated cid value passed as in location parameter passed to constructor
     *              {@link #NeighboringCellInfo(int, String, int)}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:53.362 -0500", hash_original_method = "6316D6CF1176EA8E415E44B17DEEB68F", hash_generated_method = "4E8FF9681D2F682EE59D6A3756AA6E4B")
    
@Deprecated
    public void setCid(int cid) {
        mCid = cid;
    }

    /**
     * Set the signal strength of the cell.
     *
     * NeighboringCellInfo is a one time shot for the neighboring cells based on
     * the radio network type at that moment. It shouldn't be changed after
     * creation.
     *
     * @deprecated initial rssi value passed as parameter to constructor
     *              {@link #NeighboringCellInfo(int, String, int)}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:53.366 -0500", hash_original_method = "DC61695B2550927FEF6924BD6DCCD37F", hash_generated_method = "8DEEF14FBDDFA5EE171AA109D4E4A8CC")
    
@Deprecated
    public void setRssi(int rssi) {
        mRssi = rssi;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:53.370 -0500", hash_original_method = "8F5318BC3FCF7BF30F83B998176BAD1B", hash_generated_method = "1F44B4C64F2483A0B6483992276D06CA")
    
@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        if (mPsc != UNKNOWN_CID) {
            sb.append(Integer.toHexString(mPsc))
                    .append("@").append(((mRssi == UNKNOWN_RSSI)? "-" : mRssi));
        } else if(mLac != UNKNOWN_CID && mCid != UNKNOWN_CID) {
            sb.append(Integer.toHexString(mLac))
                    .append(Integer.toHexString(mCid))
                    .append("@").append(((mRssi == UNKNOWN_RSSI)? "-" : mRssi));
        }
        sb.append("]");

        return sb.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:53.373 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:53.378 -0500", hash_original_method = "1E78D18C8DE0132253C9C6F62415E5D0", hash_generated_method = "019A82B39A29F1E619FA6D16D96C3DC3")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mRssi);
        dest.writeInt(mLac);
        dest.writeInt(mCid);
        dest.writeInt(mPsc);
        dest.writeInt(mNetworkType);
    }
    // orphaned legacy method
    public NeighboringCellInfo createFromParcel(Parcel in) {
            return new NeighboringCellInfo(in);
        }
    
    // orphaned legacy method
    public NeighboringCellInfo[] newArray(int size) {
            return new NeighboringCellInfo[size];
        }
    
}

