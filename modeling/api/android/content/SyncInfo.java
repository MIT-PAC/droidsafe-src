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
 * Copyright (C) 2009 The Android Open Source Project
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


package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;

public class SyncInfo implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.962 -0400", hash_original_field = "A01FEEA498E9DC325074E88D0BA2C977", hash_generated_field = "5C265E4318FC6B04FC842570ABED2BA1")

    public static final Creator<SyncInfo> CREATOR = new Creator<SyncInfo>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:26.951 -0500", hash_original_method = "8CC1AEB78BBF2ED2FA2D9F459276B44F", hash_generated_method = "C46E649958AD9AF7AEBFCDBF4A9B07B0")
        
public SyncInfo createFromParcel(Parcel in) {
            return new SyncInfo(in);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:26.953 -0500", hash_original_method = "5C1CA30D4924E9B917C7F0C224EF3A13", hash_generated_method = "4BD82869B2CF2ED58C81B824C1EC9047")
        
public SyncInfo[] newArray(int size) {
            return new SyncInfo[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:26.932 -0500", hash_original_field = "B11D0145EE299937169261FF5464F8E6", hash_generated_field = "A9902B6EC2628AF68CD4117B511E65F0")

    public  int authorityId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:26.934 -0500", hash_original_field = "9D630FBF90643CC60961CCF48FECCA0B", hash_generated_field = "48DCC252B03FBCBEDBDE2E34968668DF")

    public  Account account;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:26.937 -0500", hash_original_field = "246C0F9F2C0270494BEB2E9C6833888B", hash_generated_field = "FB6B5528A361C1A6848B87F8DAC52043")

    public  String authority;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:26.939 -0500", hash_original_field = "25508983FDF3B80C66EC7EEA7637B7D4", hash_generated_field = "48AB5BE3A45BACCF7E8CB1591E803C43")

    public  long startTime;

    /** @hide */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:26.941 -0500", hash_original_method = "08CB15341E378B91930C38215FF9CE0F", hash_generated_method = "08CB15341E378B91930C38215FF9CE0F")
    
SyncInfo(int authorityId, Account account, String authority,
            long startTime) {
        this.authorityId = authorityId;
        this.account = account;
        this.authority = authority;
        this.startTime = startTime;
    }

    /** @hide */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:26.948 -0500", hash_original_method = "C517E1FF2489673370FA690A620D127C", hash_generated_method = "C517E1FF2489673370FA690A620D127C")
    
SyncInfo(Parcel parcel) {
        authorityId = parcel.readInt();
        account = new Account(parcel);
        authority = parcel.readString();
        startTime = parcel.readLong();
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:26.943 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    /** @hide */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:26.946 -0500", hash_original_method = "1C5B91DE7E7E8D04DC252E4EE5F1DBAA", hash_generated_method = "E75C285F771F0D084E4A01ED837DFBA2")
    
public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(authorityId);
        account.writeToParcel(parcel, 0);
        parcel.writeString(authority);
        parcel.writeLong(startTime);
    }
    // orphaned legacy method
    public SyncInfo createFromParcel(Parcel in) {
            return new SyncInfo(in);
        }
    
    // orphaned legacy method
    public SyncInfo[] newArray(int size) {
            return new SyncInfo[size];
        }
    
}

