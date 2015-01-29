/*
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

package android.mtp;

/**
 * This class encapsulates information about an object on an MTP device.
 * This corresponds to the ObjectInfo Dataset described in
 * section 5.3.1 of the MTP specification.
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public final class MtpObjectInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.617 -0400", hash_original_field = "BE4FBA339B8964B0ABF1E6F625B8029F", hash_generated_field = "24C6DFC54244C0ECB3E13AC2BDE66375")

    private int mHandle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.619 -0400", hash_original_field = "7015602EB998005E8CF8D68C38A07905", hash_generated_field = "BE33FDB6E306D30BAB61D2858311778E")

    private int mStorageId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.621 -0400", hash_original_field = "F274D9A6D075EEEA711AF201B69FCAF4", hash_generated_field = "AB812A232FD99D518B911A3EA9A3816E")

    private int mFormat;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.622 -0400", hash_original_field = "0211096FEE3970C68FED8FEE829653B7", hash_generated_field = "33B60BBE6007864A51B765634FB66FED")

    private int mProtectionStatus;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.624 -0400", hash_original_field = "089916153CDB1EDB641BA3C04D4671A8", hash_generated_field = "8625189757597332B5C111EECB7DF87B")

    private int mCompressedSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.625 -0400", hash_original_field = "C3AFE9D96BEFA528BCFDB6F325649F94", hash_generated_field = "19B1412B7D1F08E20C625064003C1F9D")

    private int mThumbFormat;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.626 -0400", hash_original_field = "99FF370D54B308E99E1375792E4DDC73", hash_generated_field = "CB264C49A952FDD23803179A400B3364")

    private int mThumbCompressedSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.628 -0400", hash_original_field = "E8A3E0C03AFC17EECF42E3614DA3DE6B", hash_generated_field = "F1A6FC8CF6098A5AEAE968A83C54A95D")

    private int mThumbPixWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.629 -0400", hash_original_field = "31F826147491642B8E148332C7777607", hash_generated_field = "A7632757A69757F8C5D4E8F84734BAEB")

    private int mThumbPixHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.631 -0400", hash_original_field = "AE4E7F8B768DE944E3EB0E79710DCB45", hash_generated_field = "33D91F21674E8C98B92322E964BE25AF")

    private int mImagePixWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.632 -0400", hash_original_field = "9B89C8C688A01252AC1AF549F479F917", hash_generated_field = "34707851D56336D62B36F5C7E8014927")

    private int mImagePixHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.634 -0400", hash_original_field = "EC2E58E7868800BA7DC678DD62CA0A5E", hash_generated_field = "61962F4C8508359B274B80BD362BEF74")

    private int mImagePixDepth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.636 -0400", hash_original_field = "4D59729773261EFC7DA19A5CA3C6AA90", hash_generated_field = "CE37690A4FE71D80283635A1B0560E81")

    private int mParent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.637 -0400", hash_original_field = "49B474624DFA63F0A5E837C7D2717C34", hash_generated_field = "C685140030837E2593234865096E2C16")

    private int mAssociationType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.639 -0400", hash_original_field = "681BBE4ED97004D51147F026382A47D4", hash_generated_field = "4C8878DC16688B4BF19150D45A0AAB1A")

    private int mAssociationDesc;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.640 -0400", hash_original_field = "56C31CB9997E55873EAFEBDBAA906468", hash_generated_field = "97F7F0F21AEC3C9DB1DDD86234F48D6A")

    private int mSequenceNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.642 -0400", hash_original_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.643 -0400", hash_original_field = "31CB01741913A6DED45DAF2ED5AF1683", hash_generated_field = "3DB90FB953D62F9FD4B2B1740423763C")

    private long mDateCreated;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.645 -0400", hash_original_field = "241687433A79BDBEE6B437BF38032C7F", hash_generated_field = "8EF43A2FD4C1CD948A25B5C26224DA3C")

    private long mDateModified;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.646 -0400", hash_original_field = "7E104CAF423C1AC52985185C33FAF258", hash_generated_field = "87FFDF93374FB0849236486A45721B0D")

    private String mKeywords;

    // only instantiated via JNI
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.648 -0400", hash_original_method = "B1033B968FE0C00CBA0D2CC79B28A728", hash_generated_method = "0C767BE790DADDB0C04905D68BA56A0F")
    
private MtpObjectInfo() {
    }

    public MtpObjectInfo(DSOnlyType dontcare) {
        // TODO Auto-generated constructor stub
    }

    /**
     * Returns the object handle for the MTP object
     *
     * @return the object handle
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.650 -0400", hash_original_method = "AAC74442C8507125033F06E1A70A85DF", hash_generated_method = "EA6CE8F9CE20C9907993B8D0BB1969D1")
    
public final int getObjectHandle() {
        return mHandle;
    }

    /**
     * Returns the storage ID for the MTP object's storage unit
     *
     * @return the storage ID
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.651 -0400", hash_original_method = "D91614A87EF069B6CB0CB580F9424F2A", hash_generated_method = "A88D8D5DDA3C547F37961C3ED8395874")
    
public final int getStorageId() {
        return mStorageId;
    }

    /**
     * Returns the format code for the MTP object
     *
     * @return the format code
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.654 -0400", hash_original_method = "B78A65234F83C071958AAA5CAE0EF816", hash_generated_method = "E94C08B23F51B33374C33B977084613A")
    
public final int getFormat() {
        return mFormat;
    }

    /**
     * Returns the protection status for the MTP object
     * Possible values are:
     *
     * <ul>
     * <li> {@link android.mtp.MtpConstants#PROTECTION_STATUS_NONE}
     * <li> {@link android.mtp.MtpConstants#PROTECTION_STATUS_READ_ONLY}
     * <li> {@link android.mtp.MtpConstants#PROTECTION_STATUS_NON_TRANSFERABLE_DATA}
     * </ul>
     *
     * @return the protection status
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.656 -0400", hash_original_method = "865EED4B68130720D5278ABA5302AD50", hash_generated_method = "A19A779A664A377FBA9D5A021CCAC301")
    
public final int getProtectionStatus() {
        return mProtectionStatus;
    }

    /**
     * Returns the size of the MTP object
     *
     * @return the object size
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.657 -0400", hash_original_method = "A402C756F76A391713DBBD70EDC88CEB", hash_generated_method = "E6332D8A990178A42E0641B51D67CD47")
    
public final int getCompressedSize() {
        return mCompressedSize;
    }

    /**
     * Returns the format code for the MTP object's thumbnail
     * Will be zero for objects with no thumbnail
     *
     * @return the thumbnail format code
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.659 -0400", hash_original_method = "986A3A4F1A5913CDC8E3D3840D7EAF0B", hash_generated_method = "E90DB114D9509B6A7554D663C30F0568")
    
public final int getThumbFormat() {
        return mThumbFormat;
    }

    /**
     * Returns the size of the MTP object's thumbnail
     * Will be zero for objects with no thumbnail
     *
     * @return the thumbnail size
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.660 -0400", hash_original_method = "263DCEE982EABA0263035197C872C6A6", hash_generated_method = "780865CAA02B0CAE46708543FA08B5EF")
    
public final int getThumbCompressedSize() {
        return mThumbCompressedSize;
    }

    /**
     * Returns the width of the MTP object's thumbnail in pixels
     * Will be zero for objects with no thumbnail
     *
     * @return the thumbnail width
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.662 -0400", hash_original_method = "0A40BF1C825B11438E6DDA2D8DFF3DD5", hash_generated_method = "1C05C77C67AE466F0445E3DC531DB954")
    
public final int getThumbPixWidth() {
        return mThumbPixWidth;
    }

    /**
     * Returns the height of the MTP object's thumbnail in pixels
     * Will be zero for objects with no thumbnail
     *
     * @return the thumbnail height
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.664 -0400", hash_original_method = "CEB362A3E4E4E8ED35577EFBFA55A5FC", hash_generated_method = "3B58F1EB2ED9ABFF4826AB4A13B38ACD")
    
public final int getThumbPixHeight() {
        return mThumbPixHeight;
    }

    /**
     * Returns the width of the MTP object in pixels
     * Will be zero for non-image objects
     *
     * @return the image width
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.666 -0400", hash_original_method = "7ABF472C93054BC25D674F6393359249", hash_generated_method = "F39380C935854F5C7B71830E25028897")
    
public final int getImagePixWidth() {
        return mImagePixWidth;
    }

    /**
     * Returns the height of the MTP object in pixels
     * Will be zero for non-image objects
     *
     * @return the image height
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.667 -0400", hash_original_method = "B85F80F0C36E916A93AE3E9A85DAC745", hash_generated_method = "06F8577CD56803DA2970BD6FE546E3C7")
    
public final int getImagePixHeight() {
        return mImagePixHeight;
    }

    /**
     * Returns the depth of the MTP object in bits per pixel
     * Will be zero for non-image objects
     *
     * @return the image depth
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.668 -0400", hash_original_method = "5967D60302C75CBA13327044312304CB", hash_generated_method = "72C65D2322E0BCD88DB4C161EDD7ED2D")
    
public final int getImagePixDepth() {
        return mImagePixDepth;
    }

    /**
     * Returns the object handle for the object's parent
     * Will be zero for the root directory of a storage unit
     *
     * @return the object's parent
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.671 -0400", hash_original_method = "FD30E6B0409FEB039E7E583A787124EB", hash_generated_method = "09E06A70F69A81DD7DD671B461FAB68B")
    
public final int getParent() {
        return mParent;
    }

    /**
     * Returns the association type for the MTP object
     * Will be zero objects that are not of format
     * {@link android.mtp.MtpConstants#FORMAT_ASSOCIATION}
     * For directories the association type is typically
     * {@link android.mtp.MtpConstants#ASSOCIATION_TYPE_GENERIC_FOLDER}
     *
     * @return the object's association type
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.672 -0400", hash_original_method = "C3231607C36B3DFE445888960EED23AE", hash_generated_method = "7B307EB26DAC9D6301A30EAFE2568A5D")
    
public final int getAssociationType() {
        return mAssociationType;
    }

    /**
     * Returns the association description for the MTP object
     * Will be zero objects that are not of format
     * {@link android.mtp.MtpConstants#FORMAT_ASSOCIATION}
     *
     * @return the object's association description
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.674 -0400", hash_original_method = "F16C2FE87175A2988BCB10B31250AEB9", hash_generated_method = "30DDFC390CB9638E45DCBE4D1FBE7E33")
    
public final int getAssociationDesc() {
        return mAssociationDesc;
    }

   /**
     * Returns the sequence number for the MTP object
     * This field is typically not used for MTP devices,
     * but is sometimes used to define a sequence of photos
     * on PTP cameras.
     *
     * @return the object's sequence number
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.675 -0400", hash_original_method = "9C10683D67701832C62ABDA9F1146268", hash_generated_method = "B22F7A5E7F1E3AB23575728BDD428457")
    
public final int getSequenceNumber() {
        return mSequenceNumber;
    }

   /**
     * Returns the name of the MTP object
     *
     * @return the object's name
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.677 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "180770248625D86846C6E10AC417237F")
    
public final String getName() {
        return mName;
    }

   /**
     * Returns the creation date of the MTP object
     * The value is represented as milliseconds since January 1, 1970
     *
     * @return the object's creation date
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.678 -0400", hash_original_method = "920E1BFCBB57375C0934765757615702", hash_generated_method = "9D5158C780F49F23F0488A55E2993FDB")
    
public final long getDateCreated() {
        return mDateCreated;
    }

   /**
     * Returns the modification date of the MTP object
     * The value is represented as milliseconds since January 1, 1970
     *
     * @return the object's modification date
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.680 -0400", hash_original_method = "207BFC5E2C77A3367ECEC21BBDFFF74B", hash_generated_method = "E52D45A911E5B2BE8FB6B5E74621654E")
    
public final long getDateModified() {
        return mDateModified;
    }

   /**
     * Returns a comma separated list of keywords for the MTP object
     *
     * @return the object's keyword list
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.682 -0400", hash_original_method = "5264036B36C30DFB5E2A9C0A965CE979", hash_generated_method = "74E0A0CA496FA96FA7BB9B0B95EC4500")
    
public final String getKeywords() {
        return mKeywords;
    }
}
