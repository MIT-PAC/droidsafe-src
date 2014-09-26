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
import android.content.ComponentName;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/**
 * This class represents the unique id of a printer.
 */
public final class PrinterId implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.285 -0400", hash_original_field = "81D4D8C35ABE745F54E95E00043DA64C", hash_generated_field = "571F59E8A16B4C0145B8EF5686357A4A")

    public static final Parcelable.Creator<PrinterId> CREATOR =
            new Creator<PrinterId>() {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public PrinterId createFromParcel(Parcel parcel) {
            return new PrinterId(parcel);
        }

        @Override
        public PrinterId[] newArray(int size) {
            return new PrinterId[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.263 -0400", hash_original_field = "32F872234804B44EE8CD8DA963EAF97C", hash_generated_field = "A427BBA67BB83D5D53B7231F4F2CB87A")

    private  ComponentName mServiceName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.264 -0400", hash_original_field = "C45ADAE9E016EB39E6FE83F74AE9F96F", hash_generated_field = "F75485050A5C28B43276DC5D122C77FF")

    private  String mLocalId;

    /**
     * Creates a new instance.
     *
     * @param serviceName The managing print service.
     * @param localId The locally unique id within the managing service.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.266 -0400", hash_original_method = "50AA210C134272535C2F18DAB643D1FD", hash_generated_method = "CDD9E1E4FDCE8292D9BA85C44A9A69CE")
    
public PrinterId(ComponentName serviceName, String localId) {
        mServiceName = serviceName;
        mLocalId = localId;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.267 -0400", hash_original_method = "067E02FA44A49CBCFB072701F615691E", hash_generated_method = "F8900AD2329A813FA1F7CA1228E05F27")
    
private PrinterId(Parcel parcel) {
        mServiceName = parcel.readParcelable(null);
        mLocalId = parcel.readString();
    }

    /**
     * The id of the print service this printer is managed by.
     *
     * @return The print service component name.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.268 -0400", hash_original_method = "6885BAD95E644C9A41C18CC81FBEAF3B", hash_generated_method = "9977A7A70B10AA9D1C684EFCA3AF447B")
    
public ComponentName getServiceName() {
        return mServiceName;
    }

    /**
     * Gets the id of this printer which is unique in the context
     * of the print service that manages it.
     *
     * @return The printer name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.269 -0400", hash_original_method = "173D1F62010E1B6468F13173405BD23C", hash_generated_method = "7777335D52E4FD953014AD1AAEFABBC9")
    
public String getLocalId() {
        return mLocalId;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.271 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
    
@Override
    public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.272 -0400", hash_original_method = "CF6AB0377CC11E69F17F34D757CD634E", hash_generated_method = "9CB9BCFBFC59053D1D8483EA4725F52B")
    
@Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeParcelable(mServiceName, flags);
        parcel.writeString(mLocalId);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.274 -0400", hash_original_method = "C865D1EA86F33166CBA3BB3A9AE7613D", hash_generated_method = "5C2000294A810153C270E00DF46A76D5")
    
@Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        PrinterId other = (PrinterId) object;
        if (mServiceName == null) {
            if (other.mServiceName != null) {
                return false;
            }
        } else if (!mServiceName.equals(other.mServiceName)) {
            return false;
        }
        if (!TextUtils.equals(mLocalId, other.mLocalId)) {
            return false;
        }
        return true;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.276 -0400", hash_original_method = "F034D4FF3DB0CDBC9F14D5214FE5A565", hash_generated_method = "44C1F65DF08B4F84CB4EE112FFE361AF")
    
@Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        hashCode = prime * hashCode + ((mServiceName != null)
                ? mServiceName.hashCode() : 1);
        hashCode = prime * hashCode + mLocalId.hashCode();
        return hashCode;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:01.278 -0400", hash_original_method = "1604933C7C47AEB9DF5B7238CA0DA895", hash_generated_method = "74F21BD61EE69934DAED098F8940AB16")
    
@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PrinterId{");
        builder.append("serviceName=").append(mServiceName.flattenToString());
        builder.append(", localId=").append(mLocalId);
        builder.append('}');
        return builder.toString();
    }
}
