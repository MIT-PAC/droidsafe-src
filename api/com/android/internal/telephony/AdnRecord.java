package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.util.Arrays;

import android.os.Parcel;
import android.os.Parcelable;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;

public class AdnRecord implements Parcelable {

    /** Helper function for {@link #isEqual}. */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.027 -0500", hash_original_method = "FFF6375FFC722DE9AA4BE2FB124374C8", hash_generated_method = "67BCA36BAA2384216D92880D51BF96F5")
    
private static boolean stringCompareNullEqualsEmpty(String s1, String s2) {
        if (s1 == s2) {
            return true;
        }
        if (s1 == null) {
            s1 = "";
        }
        if (s2 == null) {
            s2 = "";
        }
        return (s1.equals(s2));
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.939 -0500", hash_original_field = "28DECCA9F494133CD6F61BCA99A50ECA", hash_generated_field = "B8386CD6D900777C9D6A0A5CA1D0B217")

    static final String LOG_TAG = "GSM";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.955 -0500", hash_original_field = "50FEE7B7F95E6475560FB7F5815BCD00", hash_generated_field = "1FF4CF0947FA8FD409EBE587CA87B949")

    //***** Constants

    // In an ADN record, everything but the alpha identifier
    // is in a footer that's 14 bytes
    static final int FOOTER_SIZE_BYTES = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.957 -0500", hash_original_field = "6858F242F03A4B86E742BAD0DF8D6BF3", hash_generated_field = "CD2EBEEB08E0EC642DA1A6AB81DF603B")

    static final int MAX_NUMBER_SIZE_BYTES = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.959 -0500", hash_original_field = "FD26004048B640359BE2CFDB35255847", hash_generated_field = "178455A461A7085A0DC6AC3C937704E0")

    static final int EXT_RECORD_LENGTH_BYTES = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.961 -0500", hash_original_field = "685FB0C917533EF920925D7CC66A249D", hash_generated_field = "273358D45598A18A00C408E116FAEB82")

    static final int EXT_RECORD_TYPE_ADDITIONAL_DATA = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.964 -0500", hash_original_field = "25C7D74D62CC68340A8B68CC54D120D8", hash_generated_field = "3CAAEABA728011FD9AB41730AE3E782F")

    static final int EXT_RECORD_TYPE_MASK = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.966 -0500", hash_original_field = "70634F5C2B952893F0DB2EF63AAFA0F2", hash_generated_field = "B2E23EBB74212C6A387FD0B8C00F38CC")

    static final int MAX_EXT_CALLED_PARTY_LENGTH = 0xa;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.969 -0500", hash_original_field = "A59D22793FEFE7056AB4091F88482F51", hash_generated_field = "667CDC09A750B86547BB85E502FD7452")

    static final int ADN_BCD_NUMBER_LENGTH = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.972 -0500", hash_original_field = "745DFF7D1822C35FDAACF6E9A68786BB", hash_generated_field = "BD3D8B49EEFB4DC2A058F01A4B595F81")

    static final int ADN_TON_AND_NPI = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.974 -0500", hash_original_field = "DF5E396FC0DCD589A4DA9A30F0F0E680", hash_generated_field = "7F0F4B8D13BB3B8240EA616F2B3E84A2")

    static final int ADN_DIALING_NUMBER_START = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.977 -0500", hash_original_field = "C55B701C8244A3381F1F12F31DDA46BF", hash_generated_field = "976F3A103109D36548168859116BF109")

    static final int ADN_DIALING_NUMBER_END = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.979 -0500", hash_original_field = "5C0E2D9B508C1886D90D65ACF73E5DFF", hash_generated_field = "351B371CE1B6F3F6A2BB7E5E7349A766")

    static final int ADN_CAPABILITY_ID = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.981 -0500", hash_original_field = "3827B5695D609123B2801030430FCAF2", hash_generated_field = "F75C98CA3CB8014717297E00FF83D4CF")

    static final int ADN_EXTENSION_ID = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.942 -0400", hash_original_field = "E8890807602BB8092FE9A75667822578", hash_generated_field = "F9654E411B123AFAFD83478F48AC874B")

    public static final Parcelable.Creator<AdnRecord> CREATOR
            = new Parcelable.Creator<AdnRecord>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.985 -0500", hash_original_method = "6D3E00478735263B7A5F1362FAEF6B0C", hash_generated_method = "5D0078611BAC042CC69D70D42DA51986")
        
public AdnRecord createFromParcel(Parcel source) {
            int efid;
            int recordNumber;
            String alphaTag;
            String number;
            String[] emails;

            efid = source.readInt();
            recordNumber = source.readInt();
            alphaTag = source.readString();
            number = source.readString();
            emails = source.readStringArray();

            return new AdnRecord(efid, recordNumber, alphaTag, number, emails);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.988 -0500", hash_original_method = "3B6DA40AF43FC2C814B6AF21D490BC95", hash_generated_method = "76EFD3737D00942FDD0D11A2F6932324")
        
public AdnRecord[] newArray(int size) {
            return new AdnRecord[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.942 -0500", hash_original_field = "8258D0DD79FD51E01DCB0F44838DA6A0", hash_generated_field = "8258D0DD79FD51E01DCB0F44838DA6A0")

    String alphaTag = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.944 -0500", hash_original_field = "C5D9AA6EDF218E348AEF048EB45AD371", hash_generated_field = "C5D9AA6EDF218E348AEF048EB45AD371")

    String number = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.946 -0500", hash_original_field = "6018210F0C36C78CE0E6A6F66DF47FDA", hash_generated_field = "6018210F0C36C78CE0E6A6F66DF47FDA")

    String[] emails;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.948 -0500", hash_original_field = "8BB493C18D39782136C2980A2ABB4984", hash_generated_field = "8BB493C18D39782136C2980A2ABB4984")

    int extRecord = 0xff;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.950 -0500", hash_original_field = "48F4A49B3891A623660D9D89A749D7FD", hash_generated_field = "48F4A49B3891A623660D9D89A749D7FD")

    int efid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.952 -0500", hash_original_field = "23F79AC71281FC94187158A5D1BA833B", hash_generated_field = "23F79AC71281FC94187158A5D1BA833B")

    int recordNumber;

    //***** Constructor
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.993 -0500", hash_original_method = "7045C9AFF2F4A7CC7D801D193F8DA208", hash_generated_method = "7B3C2EF083AA4C101D9EBF91F8EBFED7")
    
public AdnRecord (byte[] record) {
        this(0, 0, record);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.996 -0500", hash_original_method = "39E5440420DD5CB806135CB05DFC1155", hash_generated_method = "4D00703A083FF1EB709C264EF89F0582")
    
public AdnRecord (int efid, int recordNumber, byte[] record) {
        this.efid = efid;
        this.recordNumber = recordNumber;
        parseRecord(record);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.999 -0500", hash_original_method = "3103748B60A6B4F91D8C8340F4241AA3", hash_generated_method = "C69989AAF84CA79276AA3A27D331D30B")
    
public AdnRecord (String alphaTag, String number) {
        this(0, 0, alphaTag, number);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.002 -0500", hash_original_method = "C511B456FEBF7A32E27BD651B4B0F96B", hash_generated_method = "4289412C8292C413991F94D3074AAB37")
    
public AdnRecord (String alphaTag, String number, String[] emails) {
        this(0, 0, alphaTag, number, emails);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.005 -0500", hash_original_method = "06878C60780B4D9C01767F1F53E52E0B", hash_generated_method = "3E395678D9A4FAA0055588F79210104F")
    
public AdnRecord (int efid, int recordNumber, String alphaTag, String number, String[] emails) {
        this.efid = efid;
        this.recordNumber = recordNumber;
        this.alphaTag = alphaTag;
        this.number = number;
        this.emails = emails;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.008 -0500", hash_original_method = "D0AEC6EC6E3FB2D90C73DE97D25EE860", hash_generated_method = "17CDD27E8BD14FDD5BC7CA4B7BD4B5D9")
    
public AdnRecord(int efid, int recordNumber, String alphaTag, String number) {
        this.efid = efid;
        this.recordNumber = recordNumber;
        this.alphaTag = alphaTag;
        this.number = number;
        this.emails = null;
    }

    //***** Instance Methods

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.011 -0500", hash_original_method = "AC3A7A9E3A191B711B11224D0DA9AF99", hash_generated_method = "C6C026948750D4A59426CB675308E75D")
    
public String getAlphaTag() {
        return alphaTag;
    }

    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.013 -0500", hash_original_method = "EC6570D4091CFB302FD4A14DB7A9F4B4", hash_generated_method = "AA38E8BCC0B9DD17DFD73F1A7E512151")
    
public String getNumber() {
        return number;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.015 -0500", hash_original_method = "92D2F53049B5866D80AA794995783C1B", hash_generated_method = "58F920E22CF735F4E3FD4CB7C5603917")
    
public String[] getEmails() {
        return emails;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.018 -0500", hash_original_method = "318E4DB00CD29A795BAB76EF64647C6C", hash_generated_method = "580DE87ADDEB9B4B8191503D4CE92987")
    
public void setEmails(String[] emails) {
        this.emails = emails;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.020 -0500", hash_original_method = "68220200E4F2B5D293B76BDD34BEE487", hash_generated_method = "B5961EECC367908660F81F6106FD4E80")
    
public String toString() {
        return "ADN Record '" + alphaTag + "' '" + number + " " + emails + "'";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.022 -0500", hash_original_method = "5D6691CA551F86617D7220208AC31A8F", hash_generated_method = "8B468F4E33540B5C3DE3BD4ECA0D319E")
    
public boolean isEmpty() {
        return TextUtils.isEmpty(alphaTag) && TextUtils.isEmpty(number) && emails == null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.024 -0500", hash_original_method = "D17030B2DC40ED56DDEA746A2C4F2F4F", hash_generated_method = "894CFE7393A4779F327AA145E1FD3744")
    
public boolean hasExtendedRecord() {
        return extRecord != 0 && extRecord != 0xff;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.029 -0500", hash_original_method = "EA1ABD1A8E044AEC4146178ABB95A33B", hash_generated_method = "B2457EC3D8D9B632B740E9D4C3ADD563")
    
public boolean isEqual(AdnRecord adn) {
        return ( stringCompareNullEqualsEmpty(alphaTag, adn.alphaTag) &&
                stringCompareNullEqualsEmpty(number, adn.number) &&
                Arrays.equals(emails, adn.emails));
    }
    //***** Parcelable Implementation

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.032 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.034 -0500", hash_original_method = "D94966D9C7C7FE5B7B9FBD39671B9050", hash_generated_method = "961C2A013F24F99BB88420AC8D7FE0EE")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(efid);
        dest.writeInt(recordNumber);
        dest.writeString(alphaTag);
        dest.writeString(number);
        dest.writeStringArray(emails);
    }

    /**
     * Build adn hex byte array based on record size
     * The format of byte array is defined in 51.011 10.5.1
     *
     * @param recordSize is the size X of EF record
     * @return hex byte[recordSize] to be written to EF record
     *          return null for wrong format of dialing number or tag
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.039 -0500", hash_original_method = "43E5A3A3017D389C996FCD504E7A9103", hash_generated_method = "E3F599972D04B8E5D7F86AB1411559E9")
    
public byte[] buildAdnString(int recordSize) {
        byte[] bcdNumber;
        byte[] byteTag;
        byte[] adnString;
        int footerOffset = recordSize - FOOTER_SIZE_BYTES;

        // create an empty record
        adnString = new byte[recordSize];
        for (int i = 0; i < recordSize; i++) {
            adnString[i] = (byte) 0xFF;
        }

        if (TextUtils.isEmpty(number)) {
            Log.w(LOG_TAG, "[buildAdnString] Empty dialing number");
            return adnString;   // return the empty record (for delete)
        } else if (number.length()
                > (ADN_DIALING_NUMBER_END - ADN_DIALING_NUMBER_START + 1) * 2) {
            Log.w(LOG_TAG,
                    "[buildAdnString] Max length of dialing number is 20");
            return null;
        } else if (alphaTag != null && alphaTag.length() > footerOffset) {
            Log.w(LOG_TAG,
                    "[buildAdnString] Max length of tag is " + footerOffset);
            return null;
        } else {
            bcdNumber = PhoneNumberUtils.numberToCalledPartyBCD(number);

            System.arraycopy(bcdNumber, 0, adnString,
                    footerOffset + ADN_TON_AND_NPI, bcdNumber.length);

            adnString[footerOffset + ADN_BCD_NUMBER_LENGTH]
                    = (byte) (bcdNumber.length);
            adnString[footerOffset + ADN_CAPABILITY_ID]
                    = (byte) 0xFF; // Capability Id
            adnString[footerOffset + ADN_EXTENSION_ID]
                    = (byte) 0xFF; // Extension Record Id

            if (!TextUtils.isEmpty(alphaTag)) {
                byteTag = GsmAlphabet.stringToGsm8BitPacked(alphaTag);
                System.arraycopy(byteTag, 0, adnString, 0, byteTag.length);
            }

            return adnString;
        }
    }

    /**
     * See TS 51.011 10.5.10
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.042 -0500", hash_original_method = "D43EB4B47E694B53E14D637B6CBB15DA", hash_generated_method = "7FE5675D2A5F80229B9CC32689C8E510")
    
public void
    appendExtRecord (byte[] extRecord) {
        try {
            if (extRecord.length != EXT_RECORD_LENGTH_BYTES) {
                return;
            }

            if ((extRecord[0] & EXT_RECORD_TYPE_MASK)
                    != EXT_RECORD_TYPE_ADDITIONAL_DATA) {
                return;
            }

            if ((0xff & extRecord[1]) > MAX_EXT_CALLED_PARTY_LENGTH) {
                // invalid or empty record
                return;
            }

            number += PhoneNumberUtils.calledPartyBCDFragmentToString(
                                        extRecord, 2, 0xff & extRecord[1]);

            // We don't support ext record chaining.

        } catch (RuntimeException ex) {
            Log.w(LOG_TAG, "Error parsing AdnRecord ext record", ex);
        }
    }

    //***** Private Methods

    /**
     * alphaTag and number are set to null on invalid format
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.045 -0500", hash_original_method = "C94E0153AA9A00481672837ABFA310B4", hash_generated_method = "FAE8FCC29597D474481255BC020DEE6C")
    
private void
    parseRecord(byte[] record) {
        try {
            alphaTag = IccUtils.adnStringFieldToString(
                            record, 0, record.length - FOOTER_SIZE_BYTES);

            int footerOffset = record.length - FOOTER_SIZE_BYTES;

            int numberLength = 0xff & record[footerOffset];

            if (numberLength > MAX_NUMBER_SIZE_BYTES) {
                // Invalid number length
                number = "";
                return;
            }

            // Please note 51.011 10.5.1:
            //
            // "If the Dialling Number/SSC String does not contain
            // a dialling number, e.g. a control string deactivating
            // a service, the TON/NPI byte shall be set to 'FF' by
            // the ME (see note 2)."

            number = PhoneNumberUtils.calledPartyBCDToString(
                            record, footerOffset + 1, numberLength);

            extRecord = 0xff & record[record.length - 1];

            emails = null;

        } catch (RuntimeException ex) {
            Log.w(LOG_TAG, "Error parsing AdnRecord", ex);
            number = "";
            alphaTag = "";
            emails = null;
        }
    }
    // orphaned legacy method
    public AdnRecord createFromParcel(Parcel source) {
            int efid;
            int recordNumber;
            String alphaTag;
            String number;
            String[] emails;

            efid = source.readInt();
            recordNumber = source.readInt();
            alphaTag = source.readString();
            number = source.readString();
            emails = source.readStringArray();

            return new AdnRecord(efid, recordNumber, alphaTag, number, emails);
        }
    
    // orphaned legacy method
    public AdnRecord[] newArray(int size) {
            return new AdnRecord[size];
        }
    
}

