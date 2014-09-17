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

/**
 * This class represents the description of a printer. Instances of
 * this class are created by print services to report to the system
 * the printers they manage. The information of this class has two
 * major components, printer properties such as name, id, status,
 * description and printer capabilities which describe the various
 * print modes a printer supports such as media sizes, margins, etc.
 */
public final class PrinterInfo implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.904 -0400", hash_original_field = "351E23DF2D5BAB369096AFAA218A0F90", hash_generated_field = "3075F79FFDA92279D59FF15629F9F2BB")

    public static final int STATUS_IDLE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.905 -0400", hash_original_field = "D8BA251945DB0D19FF581576075F0900", hash_generated_field = "F84EDCEA9CD9B118770D7964D33CFEEF")

    public static final int STATUS_BUSY = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.906 -0400", hash_original_field = "0497B1FF408C2AA8E1C5E25B2F9788E9", hash_generated_field = "6E7777654E81F20EC3EFB6FD524C3D43")

    public static final int STATUS_UNAVAILABLE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.937 -0400", hash_original_field = "AA11EF2C51E607F520D02EA96015E5AD", hash_generated_field = "1DD1D7305ADBD70E5EA7B9DD82058EF1")


    public static final Parcelable.Creator<PrinterInfo> CREATOR =
            new Parcelable.Creator<PrinterInfo>() {
        @Override
        public PrinterInfo createFromParcel(Parcel parcel) {
            return new PrinterInfo(parcel);
        }

        @Override
        public PrinterInfo[] newArray(int size) {
            return new PrinterInfo[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.907 -0400", hash_original_field = "F4D3A8423B8CAD9C28735AC09E3E8BA9", hash_generated_field = "D192F9F7FAB0E66597CA6A6530AA5534")


    private PrinterId mId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.907 -0400", hash_original_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")


    private String mName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.908 -0400", hash_original_field = "6E71E23BE02FA84765B242F31AE918F7", hash_generated_field = "FEDEA1F9A1711C8ECD406AE0575049A4")


    private int mStatus;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.909 -0400", hash_original_field = "6FC53B81BF2A7EC21138D42F363D7B9A", hash_generated_field = "D58E2E2E369193E8B6C54168B334B477")


    private String mDescription;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.910 -0400", hash_original_field = "7D7B0885C439D54D39E5CDEC23AD7264", hash_generated_field = "58B2C92A9785FB9DB53E7AC166626CA7")


    private PrinterCapabilitiesInfo mCapabilities;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.910 -0400", hash_original_method = "103A3909FFB08D5E335F6A7EB3811455", hash_generated_method = "1F782CF5E800A1B20D9101D9BA671C0E")
    
private PrinterInfo() {
        /* do nothing */
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.911 -0400", hash_original_method = "93BA3FD3B211276E5112217F3C4F22E9", hash_generated_method = "13E2A0D7CC831EE5E9A0356FCE8B7D27")
    
private PrinterInfo(PrinterInfo prototype) {
        copyFrom(prototype);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.917 -0400", hash_original_method = "C3E3CFDB010C5A86C67820A5C524B914", hash_generated_method = "F5A607CFEBAC596822D68D103E6AEB66")
    
private PrinterInfo(Parcel parcel) {
        mId = parcel.readParcelable(null);
        mName = parcel.readString();
        mStatus = parcel.readInt();
        mDescription = parcel.readString();
        mCapabilities = parcel.readParcelable(null);
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.912 -0400", hash_original_method = "9A514A69E4A258ED1684DF22E0A5960E", hash_generated_method = "2C589C506D9702C7000A5219FEEDD6B9")
    
public void copyFrom(PrinterInfo other) {
        if (this == other) {
            return;
        }
        mId = other.mId;
        mName = other.mName;
        mStatus = other.mStatus;
        mDescription = other.mDescription;
        if (other.mCapabilities != null) {
            if (mCapabilities != null) {
                mCapabilities.copyFrom(other.mCapabilities);
            } else {
                mCapabilities = new PrinterCapabilitiesInfo(other.mCapabilities);
            }
        } else {
            mCapabilities = null;
        }
    }

    /**
     * Get the globally unique printer id.
     *
     * @return The printer id.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.913 -0400", hash_original_method = "3EEAD70617301ADAEE2C697660DF5983", hash_generated_method = "F992E2DC1CF40D3976F8A782A970E25C")
    
public PrinterId getId() {
        return mId;
    }

    /**
     * Get the printer name.
     *
     * @return The printer name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.914 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "AD920925278DEAFAFBD283F9C2E39E5D")
    
public String getName() {
        return mName;
    }

    /**
     * Gets the printer status.
     *
     * @return The status.
     *
     * @see #STATUS_BUSY
     * @see #STATUS_IDLE
     * @see #STATUS_UNAVAILABLE
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.915 -0400", hash_original_method = "53606EE136895CC7C861B05BDE5B9AD2", hash_generated_method = "8F089638B19C44F0F1119F8643AAAECB")
    
public int getStatus() {
        return mStatus;
    }

    /**
     * Gets the  printer description.
     *
     * @return The description.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.916 -0400", hash_original_method = "177DD147D2F75620FD2B154278EC57FA", hash_generated_method = "C24A704C1B7693A32CE618B690D2C768")
    
public String getDescription() {
        return mDescription;
    }

    /**
     * Gets the printer capabilities.
     *
     * @return The capabilities.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.916 -0400", hash_original_method = "D57F64C61483B2A9B050AF6A8EAECC96", hash_generated_method = "B7D6AB49D8768EF0DF878129160595FA")
    
public PrinterCapabilitiesInfo getCapabilities() {
        return mCapabilities;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.918 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
    
@Override
    public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.919 -0400", hash_original_method = "BD9F2EC6C2743720D3E55F0C070CD4BF", hash_generated_method = "52308ECFD657422097664A1E73BB62ED")
    
@Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeParcelable(mId, flags);
        parcel.writeString(mName);
        parcel.writeInt(mStatus);
        parcel.writeString(mDescription);
        parcel.writeParcelable(mCapabilities, flags);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.920 -0400", hash_original_method = "4E0BB6AF7268854CC2073DC5246CCE4D", hash_generated_method = "3CF30CD2FC58F603B349C073297703A8")
    
@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((mId != null) ? mId.hashCode() : 0);
        result = prime * result + ((mName != null) ? mName.hashCode() : 0);
        result = prime * result + mStatus;
        result = prime * result + ((mDescription != null) ? mDescription.hashCode() : 0);
        result = prime * result + ((mCapabilities != null) ? mCapabilities.hashCode() : 0);
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.922 -0400", hash_original_method = "9F45CBD7941382A82867142B4DBDE036", hash_generated_method = "C4EB66614BC912CBDFD4A3F7A0F76C14")
    
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
        PrinterInfo other = (PrinterInfo) obj;
        if (mId == null) {
            if (other.mId != null) {
                return false;
            }
        } else if (!mId.equals(other.mId)) {
            return false;
        }
        if (!TextUtils.equals(mName, other.mName)) {
            return false;
        }
        if (mStatus != other.mStatus) {
            return false;
        }
        if (!TextUtils.equals(mDescription, other.mDescription)) {
            return false;
        }
        if (mCapabilities == null) {
            if (other.mCapabilities != null) {
                return false;
            }
        } else if (!mCapabilities.equals(other.mCapabilities)) {
            return false;
        }
        return true;
    }

    /**
     * Builder for creating of a {@link PrinterInfo}.
     */
    public static final class Builder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.924 -0400", hash_original_field = "FA60D4A21A4CA867085D36499323D2E9", hash_generated_field = "CBDC49DF4F2A619E687397B0C8B5926E")

        private  PrinterInfo mPrototype;

        /**
         * Constructor.
         *
         * @param printerId The printer id. Cannot be null.
         * @param name The printer name. Cannot be empty.
         * @param status The printer status. Must be a valid status.
         * @throws IllegalArgumentException If the printer id is null, or the
         * printer name is empty or the status is not a valid one.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.926 -0400", hash_original_method = "E0DE92B8941B59189DEA975C2EC60790", hash_generated_method = "13BB983FC45BC0F51AD717CBE0E61EF7")
        
public Builder(PrinterId printerId, String name, int status) {
            if (printerId == null) {
                throw new IllegalArgumentException("printerId cannot be null.");
            }
            if (TextUtils.isEmpty(name)) {
                throw new IllegalArgumentException("name cannot be empty.");
            }
            if (!isValidStatus(status)) {
                throw new IllegalArgumentException("status is invalid.");
            }
            mPrototype = new PrinterInfo();
            mPrototype.mId = printerId;
            mPrototype.mName = name;
            mPrototype.mStatus = status;
        }

        /**
         * Constructor.
         *
         * @param other Other info from which to start building.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.927 -0400", hash_original_method = "AC35553EF7EE155B7007EF5C6FB91168", hash_generated_method = "83E6FAF064BBCEA04A95F63F72349ADA")
        
public Builder(PrinterInfo other) {
            mPrototype = new PrinterInfo();
            mPrototype.copyFrom(other);
        }

        /**
         * Sets the printer status.
         *
         * @param status The status.
         * @return This builder.
         *
         * @see PrinterInfo#STATUS_IDLE
         * @see PrinterInfo#STATUS_BUSY
         * @see PrinterInfo#STATUS_UNAVAILABLE
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.928 -0400", hash_original_method = "7FA4D1974421F43A93B48303B0F04C17", hash_generated_method = "0F71D9818A3096329C9ABE8084DBFED1")
        
public Builder setStatus(int status) {
            mPrototype.mStatus = status;
            return this;
        }

        /**
         * Sets the <strong>localized</strong> printer name which
         * is shown to the user
         *
         * @param name The name.
         * @return This builder.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.929 -0400", hash_original_method = "0E58E7BCDD017843626E4A3D2E049667", hash_generated_method = "BA957F6DD010D08EA942EAC761DFA8F6")
        
public Builder setName(String name) {
            mPrototype.mName = name;
            return this;
        }

        /**
         * Sets the <strong>localized</strong> printer description
         * which is shown to the user
         *
         * @param description The description.
         * @return This builder.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.930 -0400", hash_original_method = "030F6E3B21ABB6EC4491B517DC9F7B54", hash_generated_method = "CE5F4C5E8A37A66DD57FED91570E465D")
        
public Builder setDescription(String description) {
            mPrototype.mDescription = description;
            return this;
        }

        /**
         * Sets the printer capabilities.
         *
         * @param capabilities The capabilities.
         * @return This builder.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.931 -0400", hash_original_method = "212689B7D17C1C6C2B692AE59A7C552F", hash_generated_method = "62D91EE42D10226CFEA47555C69FCD21")
        
public Builder setCapabilities(PrinterCapabilitiesInfo capabilities) {
            mPrototype.mCapabilities = capabilities;
            return this;
        }

        /**
         * Creates a new {@link PrinterInfo}.
         *
         * @return A new {@link PrinterInfo}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.931 -0400", hash_original_method = "665940BB1511C2751B4ABD7DC361FEC8", hash_generated_method = "2510C625BBE865E78BF67009315D323E")
        
public PrinterInfo build() {
            return mPrototype;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.933 -0400", hash_original_method = "099F0766B4775FD49A3DA62E7A446576", hash_generated_method = "CB8E2E70C09F6E86683006028EC7E26C")
        
private boolean isValidStatus(int status) {
            return (status == STATUS_IDLE
                    || status == STATUS_BUSY
                    || status == STATUS_UNAVAILABLE);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.923 -0400", hash_original_method = "E979038ED72A0009E40A1D28CCB39A3A", hash_generated_method = "CFEEF2E54E0C3790D9BDF1659C3A940F")
    
@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PrinterInfo{");
        builder.append("id=").append(mId);
        builder.append(", name=").append(mName);
        builder.append(", status=").append(mStatus);
        builder.append(", description=").append(mDescription);
        builder.append(", capabilities=").append(mCapabilities);
        builder.append("\"}");
        return builder.toString();
    }
}
