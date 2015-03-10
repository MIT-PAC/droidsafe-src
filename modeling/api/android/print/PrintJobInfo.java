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
 * Copyright (C) 2013 The Android Open Source Project
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


package android.print;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;

/**
 * This class represents the description of a print job. The print job
 * state includes properties such as its id, print attributes used for
 * generating the content, and so on. Note that the print jobs state may
 * change over time and this class represents a snapshot of this state.
 */
public final class PrintJobInfo implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.137 -0400", hash_original_field = "F875360A42BFFD686B62F3565F8DB8F3", hash_generated_field = "F104F7F16CF2DA2F0164439FA4A6F27C")

    public static final int STATE_ANY = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.138 -0400", hash_original_field = "126CB267DD35D54E22FAD03503B07B44", hash_generated_field = "AD9A1E5624D1AECDA40306D9632E36AA")

    public static final int STATE_ANY_VISIBLE_TO_CLIENTS = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.139 -0400", hash_original_field = "4C0051C59A94093C4087C5A98A388D5C", hash_generated_field = "0C2C51FFD48EBD84C12C80CD2D967F8F")

    public static final int STATE_ANY_ACTIVE = -3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.140 -0400", hash_original_field = "AA07532912C1E1058C9CC68311D83F10", hash_generated_field = "9C86E73AAFAB652D5E5A7B533324D637")

    public static final int STATE_ANY_SCHEDULED = -4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.140 -0400", hash_original_field = "467228AB394C5C54B1CA24645DCA463B", hash_generated_field = "CFB777732A55FBDCD048980C6FC1FECC")

    public static final int STATE_CREATED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.141 -0400", hash_original_field = "B2DF0A70923D0F59C424662BA69AB93F", hash_generated_field = "CD77049150CFD1E5E3A92164230C7EB5")

    public static final int STATE_QUEUED = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.142 -0400", hash_original_field = "74807E6A8B0D2B30B7E793763F56FBF8", hash_generated_field = "9365DC6143C4EF389382EC83BDB3AB2D")

    public static final int STATE_STARTED = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.143 -0400", hash_original_field = "435E7B5E3E43C4BCDFB40364F52A01B8", hash_generated_field = "A3686185FF1BBD9010F0C56073D54412")

    public static final int STATE_BLOCKED = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.144 -0400", hash_original_field = "6C102CD033776242973D0F6F98DE1A03", hash_generated_field = "2A117B3E9A2236C2437F04E8B7CD5DC3")

    public static final int STATE_COMPLETED = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.145 -0400", hash_original_field = "E9D8FF9E74FEBAD21D802CB0E0AF0BFA", hash_generated_field = "6CCB9D90FCFF80A206DE40AB6670C5D5")

    public static final int STATE_FAILED = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.146 -0400", hash_original_field = "40D252A37B0B003266B7F0688F99C62D", hash_generated_field = "AF960FA5E6BD04D57BECE687552CC5D9")

    public static final int STATE_CANCELED = 7;

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.200 -0400", hash_original_method = "8F28F6B212CDF161F9D7643D9D17D419", hash_generated_method = "6D38DFAF830CFB95D23801FB45A00D39")
    
public static String stateToString(int state) {
        switch (state) {
            case STATE_CREATED: {
                return "STATE_CREATED";
            }
            case STATE_QUEUED: {
                return "STATE_QUEUED";
            }
            case STATE_STARTED: {
                return "STATE_STARTED";
            }
            case STATE_BLOCKED: {
                return "STATE_BLOCKED";
            }
            case STATE_FAILED: {
                return "STATE_FAILED";
            }
            case STATE_COMPLETED: {
                return "STATE_COMPLETED";
            }
            case STATE_CANCELED: {
                return "STATE_CANCELED";
            }
            default: {
                return "STATE_UNKNOWN";
            }
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.221 -0400", hash_original_field = "9B31C921390B7BA641729ADE21832582", hash_generated_field = "4D587533ED6DC3214C0A6B46BEA10274")

    public static final Parcelable.Creator<PrintJobInfo> CREATOR =
            new Creator<PrintJobInfo>() {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public PrintJobInfo createFromParcel(Parcel parcel) {
            return new PrintJobInfo(parcel);
        }

        @Override
        public PrintJobInfo[] newArray(int size) {
            return new PrintJobInfo[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.146 -0400", hash_original_field = "1D1944F8C092C3F1A9E7C2E60DBA9A4E", hash_generated_field = "0B2E48765641ECD36F31A4CAC0282946")

    private PrintJobId mId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.147 -0400", hash_original_field = "5D623CBCF86992E0D7786DE12566196C", hash_generated_field = "E99BBC07DBFDC8DED9A95F9F182A2FA4")

    private String mLabel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.148 -0400", hash_original_field = "0972E6CF02DCED2655E3007D865BF8FD", hash_generated_field = "9FCDFB74450C89EABDF631251D8A7822")

    private PrinterId mPrinterId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.149 -0400", hash_original_field = "9A17E4749987602586F3E6DF10E33536", hash_generated_field = "E575FA9ADFE58180FAD4EACD9C37C0C3")

    private String mPrinterName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.149 -0400", hash_original_field = "7BB479D2050B776CF48FB8B4E674911B", hash_generated_field = "19B55F2750B971E6310D64ADB9B2D0CF")

    private int mState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.150 -0400", hash_original_field = "54EC6B556ED06A7EEB6FB30D691B2735", hash_generated_field = "8154A56A721671AC1D9ADFD992BBEE15")

    private int mAppId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.151 -0400", hash_original_field = "05B32B05746742D3A5261C827E7D8852", hash_generated_field = "0950070738D23525D6B35F116326FC98")

    private String mTag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.152 -0400", hash_original_field = "35FD527EBB7BAEF8DB06C0190D4E7810", hash_generated_field = "52F0C42BBBE4E7C7AE0BF510265A7279")

    private long mCreationTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.153 -0400", hash_original_field = "53AEB6C70F0EFF4638DA9D6431EF1F82", hash_generated_field = "E7565BA8679E92AF833BC7BE9CFE4A12")

    private int mCopies;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.154 -0400", hash_original_field = "B4CEFCD64ED3B0FBB0B419250B707765", hash_generated_field = "8EED16A7AE8B46EF1D432059407EC5B5")

    private String mStateReason;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.155 -0400", hash_original_field = "46BE49D47C74B467A08EA01A716FB875", hash_generated_field = "63B98AAB7D8B868B1E9DE933E46EB139")

    private PageRange[] mPageRanges;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.155 -0400", hash_original_field = "C3D0A502C666CCB3B8CB0F8C1824C0A1", hash_generated_field = "934A0576FF1DC6BE401D5C2E5A96F2A6")

    private PrintAttributes mAttributes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.156 -0400", hash_original_field = "6E88F63EE3F087A2B39FCA39D8A4C3AE", hash_generated_field = "B7A9A6BCBCFCDF28805320DA60BD3623")

    private PrintDocumentInfo mDocumentInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.157 -0400", hash_original_field = "3910B6709760F2D892232370E397233C", hash_generated_field = "6BF0EFBBA97062B8FF48BEB9D5D60C17")

    private Bundle mAdvancedOptions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.158 -0400", hash_original_field = "E972AF7886DF3265EF718DCF6D2B99DC", hash_generated_field = "0F6894BA448EC358CA769B5A86EC5F11")

    private boolean mCanceling;

    /** @hide*/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.159 -0400", hash_original_method = "C272BDEF19618DD454AE7E62AB729BE7", hash_generated_method = "495A7493185E99970D1FE7BE40C11B76")
    
public PrintJobInfo() {
        /* do nothing */
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.160 -0400", hash_original_method = "6C7BE27668F71E99764151C3AB824CCD", hash_generated_method = "FDA13C6FE49172DA5D2CBD36D6A704F9")
    
public PrintJobInfo(PrintJobInfo other) {
        mId = other.mId;
        mLabel = other.mLabel;
        mPrinterId = other.mPrinterId;
        mPrinterName = other.mPrinterName;
        mState = other.mState;
        mAppId = other.mAppId;
        mTag = other.mTag;
        mCreationTime = other.mCreationTime;
        mCopies = other.mCopies;
        mStateReason = other.mStateReason;
        mPageRanges = other.mPageRanges;
        mAttributes = other.mAttributes;
        mDocumentInfo = other.mDocumentInfo;
        mCanceling = other.mCanceling;
        mAdvancedOptions = other.mAdvancedOptions;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.161 -0400", hash_original_method = "E12282CD7E1BFFC08155C905C6300EA8", hash_generated_method = "E4B4767C1B2C7598A597288C1ADB89CA")
    
private PrintJobInfo(Parcel parcel) {
        mId = parcel.readParcelable(null);
        mLabel = parcel.readString();
        mPrinterId = parcel.readParcelable(null);
        mPrinterName = parcel.readString();
        mState = parcel.readInt();
        mAppId = parcel.readInt();
        mTag = parcel.readString();
        mCreationTime = parcel.readLong();
        mCopies = parcel.readInt();
        mStateReason = parcel.readString();
        Parcelable[] parcelables = parcel.readParcelableArray(null);
        if (parcelables != null) {
            mPageRanges = new PageRange[parcelables.length];
            for (int i = 0; i < parcelables.length; i++) {
                mPageRanges[i] = (PageRange) parcelables[i];
            }
        }
        mAttributes = (PrintAttributes) parcel.readParcelable(null);
        mDocumentInfo = (PrintDocumentInfo) parcel.readParcelable(null);
        mCanceling = (parcel.readInt() == 1);
        mAdvancedOptions = parcel.readBundle();
    }

    /**
     * Gets the unique print job id.
     *
     * @return The id.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.162 -0400", hash_original_method = "412C15E4B55D5335416F43C7599CEB38", hash_generated_method = "C28EB815020E7945DB9000F3517BD454")
    
public PrintJobId getId() {
        return mId;
    }

    /**
     * Sets the unique print job id.
     *
     * @param The job id.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.163 -0400", hash_original_method = "E4BED940D937E3FBD853D895054FB006", hash_generated_method = "47EB1C358D8DD8187C00E5449B4FB79A")
    
public void setId(PrintJobId id) {
        this.mId = id;
    }

    /**
     * Gets the human readable job label.
     *
     * @return The label.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.164 -0400", hash_original_method = "D24F8C43FDA8FA651CC7D7CBC2E3D58B", hash_generated_method = "54E4D5CEB2CD6C4618FA3D2B41721D50")
    
public String getLabel() {
        return mLabel;
    }

    /**
     * Sets the human readable job label.
     *
     * @param label The label.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.165 -0400", hash_original_method = "6C6C1F0A173EA02FDBF30BA9C8955229", hash_generated_method = "2CE9DCFE017C31F46A4BE89ACB0B9C24")
    
public void setLabel(String label) {
        mLabel = label;
    }

    /**
     * Gets the unique target printer id.
     *
     * @return The target printer id.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.166 -0400", hash_original_method = "051AA68DF7A4D182012C2A1A265EAF45", hash_generated_method = "DE85B62F3E6C309963D1106B993D962A")
    
public PrinterId getPrinterId() {
        return mPrinterId;
    }

    /**
     * Sets the unique target pritner id.
     *
     * @param printerId The target printer id.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.166 -0400", hash_original_method = "94A99A8164E11D14AB41C67E8E44FCF6", hash_generated_method = "A1B41CC194A3B04EC1BCB6A5F0F6C7DA")
    
public void setPrinterId(PrinterId printerId) {
        mPrinterId = printerId;
    }

    /**
     * Gets the name of the target printer.
     *
     * @return The printer name.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.167 -0400", hash_original_method = "E5DE59D1F8E56EB0056EC27AB1274BE1", hash_generated_method = "AEF6543B4D3E748C552ED61893327A90")
    
public String getPrinterName() {
        return mPrinterName;
    }

    /**
     * Sets the name of the target printer.
     *
     * @param printerName The printer name.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.168 -0400", hash_original_method = "5A8E65E35360D593A4BA2DC9EA856C3B", hash_generated_method = "36392C5968C468574596440F4054ED25")
    
public void setPrinterName(String printerName) {
        mPrinterName = printerName;
    }

    /**
     * Gets the current job state.
     *
     * @return The job state.
     *
     * @see #STATE_CREATED
     * @see #STATE_QUEUED
     * @see #STATE_STARTED
     * @see #STATE_COMPLETED
     * @see #STATE_BLOCKED
     * @see #STATE_FAILED
     * @see #STATE_CANCELED
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.169 -0400", hash_original_method = "10E9373648D5DF4EE43B4904732E3886", hash_generated_method = "4C50D1866B5E804CF0B05EFBD6788B97")
    
public int getState() {
        return mState;
    }

    /**
     * Sets the current job state.
     *
     * @param state The job state.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.170 -0400", hash_original_method = "B2257FFBD3B79161D70D00C92F5BABD5", hash_generated_method = "EFE99E2A60D45952DF5CBB378D53BB18")
    
public void setState(int state) {
        mState = state;
    }

    /**
     * Sets the owning application id.
     *
     * @return The owning app id.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.171 -0400", hash_original_method = "31B50C9F5BCE149CB3AEB55D17AA56E5", hash_generated_method = "63E54AFA466968475D619FCE63725947")
    
public int getAppId() {
        return mAppId;
    }

    /**
     * Sets the owning application id.
     *
     * @param appId The owning app id.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.172 -0400", hash_original_method = "D9BBFE1E92FD2E429BD74712308C1960", hash_generated_method = "A6A29013E6A01D77ACDAFEA44D09E3A2")
    
public void setAppId(int appId) {
        mAppId = appId;
    }

    /**
     * Gets the optional tag assigned by a print service.
     *
     * @return The tag.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.173 -0400", hash_original_method = "ED26754F6A82B43F30EAE698B7941323", hash_generated_method = "0B538D6B7E10340EACEB66882A3752E4")
    
public String getTag() {
        return mTag;
    }

    /**
     * Sets the optional tag assigned by a print service.
     *
     * @param tag The tag.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.174 -0400", hash_original_method = "DDAE7ACC6E5448DE4AE0A0ED84BE81BF", hash_generated_method = "D904E5EA74F1749B1BDBEF2A95E87495")
    
public void setTag(String tag) {
        mTag = tag;
    }

    /**
     * Gets the wall time in millisecond when this print job was created.
     *
     * @return The creation time in milliseconds.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.175 -0400", hash_original_method = "D2C9CAB81E85BEE8D2B8AE161B1533AB", hash_generated_method = "49E028453D6BBE6ABB59528DA3E005D0")
    
public long getCreationTime() {
        return mCreationTime;
    }

    /**
     * Sets the wall time in milliseconds when this print job was created.
     *
     * @param creationTime The creation time in milliseconds.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.176 -0400", hash_original_method = "53AF518F10EE9A6EDCBED5A561ED4D81", hash_generated_method = "374F327C35D3E54C921AF363FD7B64D3")
    
public void setCreationTime(long creationTime) {
        if (creationTime < 0) {
            throw new IllegalArgumentException("creationTime must be non-negative.");
        }
        mCreationTime = creationTime;
    }

    /**
     * Gets the number of copies.
     *
     * @return The number of copies or zero if not set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.177 -0400", hash_original_method = "B93AC97982B244D7C328824E652778A1", hash_generated_method = "CAFF4CB772EB3A3B3DEC3905F2C0A5BE")
    
public int getCopies() {
        return mCopies;
    }

    /**
     * Sets the number of copies.
     *
     * @param copyCount The number of copies.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.178 -0400", hash_original_method = "C931FAF5B5C74AC9DA9A05DC4092F9D8", hash_generated_method = "34CD6FB4F01DB4EE3DBFA4598F87D18D")
    
public void setCopies(int copyCount) {
        if (copyCount < 1) {
            throw new IllegalArgumentException("Copies must be more than one.");
        }
        mCopies = copyCount;
    }

    /**
     * Gets the reason for the print job being in the current state.
     *
     * @return The reason, or null if there is no reason or the
     * reason is unknown.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.178 -0400", hash_original_method = "53BCF3FB2C93565A012FB5A7D4E2A52D", hash_generated_method = "96A3A12D1652E0FE08863DBC71E7D73F")
    
public String getStateReason() {
        return mStateReason;
    }

    /**
     * Sets the reason for the print job being in the current state.
     *
     * @param stateReason The reason, or null if there is no reason
     * or the reason is unknown.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.179 -0400", hash_original_method = "8EC24A591C857B102C5EDC82FD0783A6", hash_generated_method = "B316E2B05B976DDA86C055BB7BF7B938")
    
public void setStateReason(String stateReason) {
        mStateReason = stateReason;
    }

    /**
     * Gets the included pages.
     *
     * @return The included pages or <code>null</code> if not set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.180 -0400", hash_original_method = "CE16BB70AEE47D79EDE6FE0386C5E81D", hash_generated_method = "E5E6369B48F78D15181554C75BF21F24")
    
public PageRange[] getPages() {
        return mPageRanges;
    }

    /**
     * Sets the included pages.
     *
     * @param pageRanges The included pages.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.182 -0400", hash_original_method = "4BD63490668C5B657981A6FE1C843EE0", hash_generated_method = "D332344346F1A2597DB1F32BDD260058")
    
public void setPages(PageRange[] pageRanges) {
        mPageRanges = pageRanges;
    }

    /**
     * Gets the print job attributes.
     *
     * @return The attributes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.183 -0400", hash_original_method = "A5B8F2D7B108A81E4143C15316C1D2C9", hash_generated_method = "3AE3A822C21FC99B96CF25C1565F29F5")
    
public PrintAttributes getAttributes() {
        return mAttributes;
    }

    /**
     * Sets the print job attributes.
     *
     * @param attributes The attributes.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.184 -0400", hash_original_method = "937A73E9E5187049FD688E3300FA625B", hash_generated_method = "1AF7D4AB3CA5FEC26106CD1EEBA33A3F")
    
public void setAttributes(PrintAttributes attributes) {
        mAttributes = attributes;
    }

    /**
     * Gets the info describing the printed document.
     *
     * @return The document info.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.184 -0400", hash_original_method = "77D896829D4C8482EF9A9232106BE8BC", hash_generated_method = "363B9F1512ADA2BA55D3EFE2F9FE30EB")
    
public PrintDocumentInfo getDocumentInfo() {
        return mDocumentInfo;
    }

    /**
     * Sets the info describing the printed document.
     *
     * @param info The document info.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.185 -0400", hash_original_method = "17FE815937AEEAAE64975DC4EDFC7D04", hash_generated_method = "61CEA1A83836417E04684F600DA9FED0")
    
public void setDocumentInfo(PrintDocumentInfo info) {
        mDocumentInfo = info;
    }

    /**
     * Gets whether this print is being cancelled.
     *
     * @return True if the print job is being cancelled.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.186 -0400", hash_original_method = "443D4D0ED29B98EE49439D994126F289", hash_generated_method = "C2F95FF4A943FF66CDE846512C13DDCE")
    
public boolean isCancelling() {
        return mCanceling;
    }

    /**
     * Sets whether this print is being cancelled.
     *
     * @param cancelling True if the print job is being cancelled.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.187 -0400", hash_original_method = "6192537E4A8F5E9241282162A75BB0D3", hash_generated_method = "068AE7827F39308339A7A3E9A9FAAB3D")
    
public void setCancelling(boolean cancelling) {
        mCanceling = cancelling;
    }

    /**
     * Gets whether this job has a given advanced (printer specific) print
     * option.
     *
     * @param key The option key.
     * @return Whether the option is present.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.188 -0400", hash_original_method = "388919073D07CFDFCCC869F9C5699F45", hash_generated_method = "140FDF479F8CD7ED8C13870EA7B78923")
    
public boolean hasAdvancedOption(String key) {
        return mAdvancedOptions != null && mAdvancedOptions.containsKey(key);
    }

    /**
     * Gets the value of an advanced (printer specific) print option.
     *
     * @param key The option key.
     * @return The option value.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.189 -0400", hash_original_method = "13181EB38F2B93B1616A6E153F9DBDFD", hash_generated_method = "5EAEA6D260C7352DE7305AC0E40AF8C4")
    
public String getAdvancedStringOption(String key) {
        if (mAdvancedOptions != null) {
            return mAdvancedOptions.getString(key);
        }
        return null;
    }

    /**
     * Gets the value of an advanced (printer specific) print option.
     *
     * @param key The option key.
     * @return The option value.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.189 -0400", hash_original_method = "2922A902EDAFB3EA0D69778125CC0BCF", hash_generated_method = "363B5FD93F21EC6ABC8EC9B68D6AE0FD")
    
public int getAdvancedIntOption(String key) {
        if (mAdvancedOptions != null) {
            return mAdvancedOptions.getInt(key);
        }
        return 0;
    }

    /**
     * Gets the advanced options.
     *
     * @return The advanced options.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.190 -0400", hash_original_method = "9E83217A0DA98077BA2469544D56EBD7", hash_generated_method = "431C324F7C2E8C0AEF527F045E9D7E89")
    
public Bundle getAdvancedOptions() {
        return mAdvancedOptions;
    }

    /**
     * Sets the advanced options.
     *
     * @param options The advanced options.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.191 -0400", hash_original_method = "203C3A35D98393FB6892FB93520204E2", hash_generated_method = "CBBD0891C22F3B8B177132FA8DA40964")
    
public void setAdvancedOptions(Bundle options) {
        mAdvancedOptions = options;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.192 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
    
@Override
    public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.193 -0400", hash_original_method = "C7900E70C81932C98A9F759EEA6E0A37", hash_generated_method = "C4FAE27A39C9177BC58E2E4093858599")
    
@Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeParcelable(mId, flags);
        parcel.writeString(mLabel);
        parcel.writeParcelable(mPrinterId, flags);
        parcel.writeString(mPrinterName);
        parcel.writeInt(mState);
        parcel.writeInt(mAppId);
        parcel.writeString(mTag);
        parcel.writeLong(mCreationTime);
        parcel.writeInt(mCopies);
        parcel.writeString(mStateReason);
        parcel.writeParcelableArray(mPageRanges, flags);
        parcel.writeParcelable(mAttributes, flags);
        parcel.writeParcelable(mDocumentInfo, 0);
        parcel.writeInt(mCanceling ? 1 : 0);
        parcel.writeBundle(mAdvancedOptions);
    }

    /**
     * Builder for creating a {@link PrintJobInfo}.
     */
    public static final class Builder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.203 -0400", hash_original_field = "D875ECE2D6870861C5C8240E48DD0D61", hash_generated_field = "129BE52903A8D8DAB5DD9315861FF6EB")

        private  PrintJobInfo mPrototype;

        /**
         * Constructor.
         *
         * @param prototype Prototype to use as a starting point.
         * Can be <code>null</code>.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.207 -0400", hash_original_method = "1A17C9090E6C7321F6C892149B19EB10", hash_generated_method = "4A546D8C9F39202CFE1E27B290072A77")
        
public Builder(PrintJobInfo prototype) {
            mPrototype = (prototype != null)
                    ? new PrintJobInfo(prototype)
                    : new PrintJobInfo();
        }

        /**
         * Sets the number of copies.
         *
         * @param copies The number of copies.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.210 -0400", hash_original_method = "5847308B4B639CD8CED20A8B4AEB9E44", hash_generated_method = "3E0FB5A3B9B3E576538315BAE0095768")
        
public void setCopies(int copies) {
            mPrototype.mCopies = copies;
        }

        /**
         * Sets the print job attributes.
         *
         * @param attributes The attributes.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.212 -0400", hash_original_method = "A45272B8761F495C2583102F4437BB1E", hash_generated_method = "0A7812716380E702215E6D011B8767A8")
        
public void setAttributes(PrintAttributes attributes) {
            mPrototype.mAttributes = attributes;
        }

        /**
         * Sets the included pages.
         *
         * @param pages The included pages.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.214 -0400", hash_original_method = "22F599FEB3B649174920F56A40C55E42", hash_generated_method = "67238AD1A9941946D38BE2FC58944FBB")
        
public void setPages(PageRange[] pages) {
            mPrototype.mPageRanges = pages;
        }

        /**
         * Puts an advanced (printer specific) option.
         *
         * @param key The option key.
         * @param value The option value.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.215 -0400", hash_original_method = "8705224622C96FC6AB581B01CE2BBFF7", hash_generated_method = "912A6122ED0A3F4D3491BB7297C77AD3")
        
public void putAdvancedOption(String key, String value) {
            if (mPrototype.mAdvancedOptions == null) {
                mPrototype.mAdvancedOptions = new Bundle();
            }
            mPrototype.mAdvancedOptions.putString(key, value);
        }

        /**
         * Puts an advanced (printer specific) option.
         *
         * @param key The option key.
         * @param value The option value.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.216 -0400", hash_original_method = "19C6345BE120C3CA498C8DC19F1539F4", hash_generated_method = "8A3F20711BC57180EAAE7F66140628CA")
        
public void putAdvancedOption(String key, int value) {
            if (mPrototype.mAdvancedOptions == null) {
                mPrototype.mAdvancedOptions = new Bundle();
            }
            mPrototype.mAdvancedOptions.putInt(key, value);
        }

        /**
         * Creates a new {@link PrintJobInfo} instance.
         *
         * @return The new instance.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.217 -0400", hash_original_method = "9D87F46F8FC47460D5A39820E50435E9", hash_generated_method = "6ACBAE0C10371DEF979ED153599E9B65")
        
public PrintJobInfo build() {
            return mPrototype;
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:59.196 -0400", hash_original_method = "B3F42A840AA54CBF9391610A93644C5C", hash_generated_method = "1834A1CF4C40B31F937E48C19965D8B3")
    
@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PrintJobInfo{");
        builder.append("label: ").append(mLabel);
        builder.append(", id: ").append(mId);
        builder.append(", state: ").append(stateToString(mState));
        builder.append(", printer: " + mPrinterId);
        builder.append(", tag: ").append(mTag);
        builder.append(", creationTime: " + mCreationTime);
        builder.append(", copies: ").append(mCopies);
        builder.append(", attributes: " + (mAttributes != null
                ? mAttributes.toString() : null));
        builder.append(", documentInfo: " + (mDocumentInfo != null
                ? mDocumentInfo.toString() : null));
        builder.append(", cancelling: " + mCanceling);
        builder.append(", pages: " + (mPageRanges != null
                ? Arrays.toString(mPageRanges) : null));
        builder.append(", hasAdvancedOptions: " + (mAdvancedOptions != null));
        builder.append("}");
        return builder.toString();
    }
}
