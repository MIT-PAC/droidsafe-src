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
 * This class encapsulates information about a document for printing
 * purposes. This meta-data is used by the platform and print services,
 * components that interact with printers. For example, this class
 * contains the number of pages contained in the document it describes and
 * this number of pages is shown to the user allowing him/her to select
 * the range to print. Also a print service may optimize the printing
 * process based on the content type, such as document or photo.
 * <p>
 * Instances of this class are created by the printing application and
 * passed to the {@link PrintDocumentAdapter.LayoutResultCallback#onLayoutFinished(
 * PrintDocumentInfo, boolean) PrintDocumentAdapter.LayoutResultCallback.onLayoutFinished(
 * PrintDocumentInfo, boolean)} callback after successfully laying out the
 * content which is performed in {@link PrintDocumentAdapter#onLayout(PrintAttributes,
 * PrintAttributes, android.os.CancellationSignal, PrintDocumentAdapter.LayoutResultCallback,
 * android.os.Bundle) PrintDocumentAdapter.onLayout(PrintAttributes,
 * PrintAttributes, android.os.CancellationSignal,
 * PrintDocumentAdapter.LayoutResultCallback, android.os.Bundle)}.
 * </p>
 * <p>
 * An example usage looks like this:
 * <pre>
 *
 * . . .
 *
 * public void onLayout(PrintAttributes oldAttributes, PrintAttributes newAttributes,
 *         CancellationSignal cancellationSignal, LayoutResultCallback callback,
 *         Bundle metadata) {
 *
 *        // Assume the app defined a LayoutResult class which contains
 *        // the layout result data and that the content is a document.
 *        LayoutResult result = doSomeLayoutWork();
 *
 *        PrintDocumentInfo info = new PrintDocumentInfo
 *                .Builder("printed_file.pdf")
 *                .setContentType(PrintDocumentInfo.CONTENT_TYPE_DOCUMENT)
 *                .setPageCount(result.getPageCount())
 *                .build();
 *
 *       callback.onLayoutFinished(info, result.getContentChanged());
 *   }
 *
 *   . . .
 *
 * </pre>
 * </p>
 */
public final class PrintDocumentInfo implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.869 -0400", hash_original_field = "55151E9FCD20B78F88F4DF937A1A16CE", hash_generated_field = "118EAE9BBEA7AF30755BE56B8866C1BB")

    public static final int PAGE_COUNT_UNKNOWN = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.871 -0400", hash_original_field = "9A48A5785BC0308B9BBD6870017D4E67", hash_generated_field = "13E28976E3DE07783F8EE5888194223C")

    public static final int CONTENT_TYPE_UNKNOWN = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.872 -0400", hash_original_field = "A46D6F499AC525F62AD4C82A4C1A91F0", hash_generated_field = "C06C23CB97FDF7935E100211B6EE02DA")

    public static final int CONTENT_TYPE_DOCUMENT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.874 -0400", hash_original_field = "34BFF91DD1D07BD706F004DB89036717", hash_generated_field = "D7CEF60AE4FEA7D1DBD08BE3972DB204")

    public static final int CONTENT_TYPE_PHOTO = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.921 -0400", hash_original_field = "5FBE82D5641893C78653284F81F83F0F", hash_generated_field = "E8A7F6BDA0E27853AB4A8EA5934DA551")

    public static final Parcelable.Creator<PrintDocumentInfo> CREATOR =
            new Creator<PrintDocumentInfo>() {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public PrintDocumentInfo createFromParcel(Parcel parcel) {
            return new PrintDocumentInfo(parcel);
        }

        @Override
        public PrintDocumentInfo[] newArray(int size) {
            return new PrintDocumentInfo[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.876 -0400", hash_original_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.877 -0400", hash_original_field = "29BBF728986FEA8949B12DDB2B4B7DAC", hash_generated_field = "7CA3A56A94442FB263747600355C917F")

    private int mPageCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.879 -0400", hash_original_field = "239BDE294AD3BA951C2F593176250E1F", hash_generated_field = "D4AA5BF9B37F19A42B0A0AC82BF96434")

    private int mContentType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.880 -0400", hash_original_field = "4CEF49BCB2E6B88A4A6295F34404B8EC", hash_generated_field = "E5338C315F647D6C34528A419BA6668B")

    private long mDataSize;

    /**
     * Creates a new instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.882 -0400", hash_original_method = "5702A363D6AA8AC6DC93E3805C32E157", hash_generated_method = "B62E1D2DA86DD6FBB9E0231DBC0CFAD3")
    
private PrintDocumentInfo() {
        /* do nothing */
    }

    /**
     * Creates a new instance.
     *
     * @param Prototype from which to clone.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.883 -0400", hash_original_method = "FCC09A0316D25A0FD982AB2DBCE6CE23", hash_generated_method = "02EB1BC5DBAADD8DAD8F1B7811464508")
    
private PrintDocumentInfo(PrintDocumentInfo prototype) {
        mName = prototype.mName;
        mPageCount = prototype.mPageCount;
        mContentType = prototype.mContentType;
        mDataSize = prototype.mDataSize;
    }

    /**
     * Creates a new instance.
     *
     * @param parcel Data from which to initialize.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.885 -0400", hash_original_method = "A03273C32A226825971B412B06E2104C", hash_generated_method = "1C6AF5F9751943B3824B12464BC3A948")
    
private PrintDocumentInfo(Parcel parcel) {
        mName = parcel.readString();
        mPageCount = parcel.readInt();
        mContentType = parcel.readInt();
        mDataSize = parcel.readLong();
    }

    /**
     * Gets the document name. This name may be shown to
     * the user.
     *
     * @return The document name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.886 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "AD920925278DEAFAFBD283F9C2E39E5D")
    
public String getName() {
        return mName;
    }

    /**
     * Gets the total number of pages.
     *
     * @return The number of pages.
     *
     * @see #PAGE_COUNT_UNKNOWN
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.888 -0400", hash_original_method = "37823C2DC6883B7117E6F3AF371DCF26", hash_generated_method = "B2EE1614D9DE9F917A04DC0BE3E638E1")
    
public int getPageCount() {
        return mPageCount;
    }

    /**
     * Gets the content type.
     *
     * @return The content type.
     *
     * @see #CONTENT_TYPE_UNKNOWN
     * @see #CONTENT_TYPE_DOCUMENT
     * @see #CONTENT_TYPE_PHOTO
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.891 -0400", hash_original_method = "53DB170475F1A78B5401977DFEB8B84F", hash_generated_method = "562637550CA73A8F07DF82873D41A6A2")
    
public int getContentType() {
        return mContentType;
    }

    /**
     * Gets the document data size in bytes.
     *
     * @return The data size.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.892 -0400", hash_original_method = "0F14D189299FC12BF30D1E38385D05B9", hash_generated_method = "368D6AD704366D4526F05DBDD3C30132")
    
public long getDataSize() {
        return mDataSize;
    }

    /**
     * Sets the document data size in bytes.
     *
     * @param dataSize The data size.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.894 -0400", hash_original_method = "CCFF5BA84A8BED43160348E3324D0DC8", hash_generated_method = "86159316D2E6A42C6AB0AA393EF33408")
    
public void setDataSize(long dataSize) {
        mDataSize = dataSize;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.895 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
    
@Override
    public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.897 -0400", hash_original_method = "289A21D05AB31FFC4FB8713F9107FC7E", hash_generated_method = "08F2F4385734A1B0E707142385B0ECF0")
    
@Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(mName);
        parcel.writeInt(mPageCount);
        parcel.writeInt(mContentType);
        parcel.writeLong(mDataSize);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.899 -0400", hash_original_method = "00190B41CE4E23871465A912F94CED12", hash_generated_method = "B66C3F9141D3E25A84D52FA20A7AD214")
    
@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((mName != null) ? mName.hashCode() : 0);
        result = prime * result + mContentType;
        result = prime * result + mPageCount;
        result = prime * result + (int) mDataSize;
        result = prime * result + (int) mDataSize >> 32;
        return result;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.901 -0400", hash_original_method = "89E4749DF83F9C56EE877E66D6326508", hash_generated_method = "7FFF0C94D95106931710690BCBFA28C2")
    
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
        PrintDocumentInfo other = (PrintDocumentInfo) obj;
        if (!TextUtils.equals(mName, other.mName)) {
            return false;
        }
        if (mContentType != other.mContentType) {
            return false;
        }
        if (mPageCount != other.mPageCount) {
            return false;
        }
        if (mDataSize != other.mDataSize) {
            return false;
        }
        return true;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.903 -0400", hash_original_method = "023FB5F5763A4CCF80FB078859C7A979", hash_generated_method = "5B8BC3F121B4055DF09768DE315BD450")
    
@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PrintDocumentInfo{");
        builder.append("name=").append(mName);
        builder.append(", pageCount=").append(mPageCount);
        builder.append(", contentType=").append(contentTyepToString(mContentType));
        builder.append(", dataSize=").append(mDataSize);
        builder.append("}");
        return builder.toString();
    }

    /**
     * Builder for creating a {@link PrintDocumentInfo}.
     */
    public static final class Builder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.907 -0400", hash_original_field = "454868F1222CC83B29907EAB7E2D3FB3", hash_generated_field = "536DF0BC4C9F99E249AAF65F747B4515")

        private  PrintDocumentInfo mPrototype;

        /**
         * Constructor.
         * 
         * <p>
         * The values of the relevant properties are initialized with defaults.
         * Please refer to the documentation of the individual setters for
         * information about the default values.
         * </p>
         *
         * @param name The document name which may be shown to the user and
         * is the file name if the content it describes is saved as a PDF.
         * Cannot be empty. 
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.908 -0400", hash_original_method = "0F846BDD8DD7A9F10F833E043FF57EA2", hash_generated_method = "CDA34BA3FC6393FBEABABB189692DF97")
        
public Builder(String name) {
            if (TextUtils.isEmpty(name)) {
                throw new IllegalArgumentException("name cannot be empty");
            }
            mPrototype = new PrintDocumentInfo();
            mPrototype.mName = name;
        }

        /**
         * Sets the total number of pages.
         * <p>
         * <strong>Default: </strong> {@link #PAGE_COUNT_UNKNOWN}
         * </p>
         *
         * @param pageCount The number of pages. Must be greater than
         * or equal to zero or {@link PrintDocumentInfo#PAGE_COUNT_UNKNOWN}.
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.910 -0400", hash_original_method = "10815F659EA24A8023AE0A43C1C2ADC5", hash_generated_method = "4A804237E6A5D8786EFD3D6FEE9728BA")
        
public Builder setPageCount(int pageCount) {
            if (pageCount < 0 && pageCount != PAGE_COUNT_UNKNOWN) {
                throw new IllegalArgumentException("pageCount"
                        + " must be greater than or euqal to zero or"
                        + " DocumentInfo#PAGE_COUNT_UNKNOWN");
            }
            mPrototype.mPageCount = pageCount;
            return this;
        }

        /**
         * Sets the content type.
         * <p>
         * <strong>Default: </strong> {@link #CONTENT_TYPE_UNKNOWN}
         * </p>
         *
         * @param type The content type.
         *
         * @see #CONTENT_TYPE_UNKNOWN
         * @see #CONTENT_TYPE_DOCUMENT
         * @see #CONTENT_TYPE_PHOTO
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.912 -0400", hash_original_method = "44F3536188A34FA8DBEADDD6123B1ADC", hash_generated_method = "7C9C928D405C04DB215CE6A9E07218A9")
        
public Builder setContentType(int type) {
            mPrototype.mContentType = type;
            return this;
        }

        /**
         * Creates a new {@link PrintDocumentInfo} instance.
         *
         * @return The new instance.
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.914 -0400", hash_original_method = "51AF0CA3B4DCA09459370AC3208366F0", hash_generated_method = "BAACF95DDF004C0BBB69DD37D92BD14B")
        
public PrintDocumentInfo build() {
            return new PrintDocumentInfo(mPrototype);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.904 -0400", hash_original_method = "359CE450D7CF2FFC28C4EF16926EAAAC", hash_generated_method = "5F82F189665888F6B3DD7C13E26EE37A")
    
private String contentTyepToString(int contentType) {
        switch (contentType) {
            case CONTENT_TYPE_DOCUMENT: {
                return "CONTENT_TYPE_DOCUMENT";
            }
            case CONTENT_TYPE_PHOTO: {
                return "CONTENT_TYPE_PHOTO";
            }
            default: {
                return "CONTENT_TYPE_UNKNOWN";
            }
        }
    }
}
