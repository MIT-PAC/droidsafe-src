/*
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

package android.print;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import java.util.UUID;

/**
 * This class represents the id of a print job.
 */
public final class PrintJobId implements Parcelable {

    /**
     * Unflattens a print job id from a string.
     *
     * @string The string.
     * @return The unflattened id, or null if the string is malformed.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.322 -0400", hash_original_method = "376293A3CE70EA0FB2E3C1A63DEB8BCE", hash_generated_method = "72585AC5EDC5D844BA0733F6DEBF2695")
    
public static PrintJobId unflattenFromString(String string) {
        return new PrintJobId(string);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.326 -0400", hash_original_field = "161E974FF011DCC33619CED882FCFBEB", hash_generated_field = "BE2E37B98029B240EB6E2491F25C097B")


    public static final Parcelable.Creator<PrintJobId> CREATOR =
            new Parcelable.Creator<PrintJobId>() {
        @Override
        public PrintJobId createFromParcel(Parcel parcel) {
            return new PrintJobId(parcel.readString());
        }

        @Override
        public PrintJobId[] newArray(int size) {
            return new PrintJobId[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.315 -0400", hash_original_field = "1160D21D7F9CB66571466142BB3983BB", hash_generated_field = "FA33B8039DB7AC1B219DF637773A1B0E")

    private  String mValue;

    /**
     * Creates a new instance.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.316 -0400", hash_original_method = "93D5EA71D57AAC89A68536A4AED77A20", hash_generated_method = "B31B447F69047C7829C96CD8A2337BBA")
    
public PrintJobId() {
        this(UUID.randomUUID().toString());
    }

    /**
     * Creates a new instance.
     *
     * @param value The internal value.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.317 -0400", hash_original_method = "FF17A204E3629066EF83E9AD1421D6AB", hash_generated_method = "C6459CF8CC640AB010A38797D56E41DA")
    
public PrintJobId(String value) {
        mValue = value;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.317 -0400", hash_original_method = "0D1BCE5EF5FB8A155399DB132D10D4C6", hash_generated_method = "36E1FFC43650120096BD4E5F9110B455")
    
@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((mValue != null) ? mValue.hashCode() : 0);
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.318 -0400", hash_original_method = "B5B0042016D0742F0C11F3E36079A2CA", hash_generated_method = "DC3C3C57483372761C5F11A9FB7AAE01")
    
@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        PrintJobId other = (PrintJobId) obj;
        if (!TextUtils.equals(mValue, other.mValue)) {
            return false;
        }
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.319 -0400", hash_original_method = "2F8410ED81C8781E5A4683514A9CE4E8", hash_generated_method = "90439D2D43ED6AFD81094B2EDB3107F8")
    
@Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(mValue);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.320 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
    
@Override
    public int describeContents() {
        return 0;
    }

    /**
     * Flattens this id to a string.
     *
     * @return The flattened id.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.321 -0400", hash_original_method = "EF448538603DF9678C43993C9C67A762", hash_generated_method = "8B46B6EE8B5EE9FC37766D9D032B0286")
    
public String flattenToString() {
        return mValue;
    }
}
