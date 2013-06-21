package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.Log;
import java.util.Arrays;

public class AdnRecord implements Parcelable {
    String alphaTag = null;
    String number = null;
    String[] emails;
    int extRecord = 0xff;
    int efid;
    int recordNumber;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.603 -0400", hash_original_method = "7045C9AFF2F4A7CC7D801D193F8DA208", hash_generated_method = "AB70143B0C611F2BEAC8E2461F6933A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AdnRecord(byte[] record) {
        this(0, 0, record);
        dsTaint.addTaint(record[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.604 -0400", hash_original_method = "39E5440420DD5CB806135CB05DFC1155", hash_generated_method = "309A02AA59DBEBC9667973E2645B142E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AdnRecord(int efid, int recordNumber, byte[] record) {
        dsTaint.addTaint(record[0]);
        dsTaint.addTaint(recordNumber);
        dsTaint.addTaint(efid);
        parseRecord(record);
        // ---------- Original Method ----------
        //this.efid = efid;
        //this.recordNumber = recordNumber;
        //parseRecord(record);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.604 -0400", hash_original_method = "3103748B60A6B4F91D8C8340F4241AA3", hash_generated_method = "F7339A85A109F146F901120CAF6F7BDD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AdnRecord(String alphaTag, String number) {
        this(0, 0, alphaTag, number);
        dsTaint.addTaint(number);
        dsTaint.addTaint(alphaTag);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.604 -0400", hash_original_method = "C511B456FEBF7A32E27BD651B4B0F96B", hash_generated_method = "1C45C1C50176180157D90FCEA99F9CA0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AdnRecord(String alphaTag, String number, String[] emails) {
        this(0, 0, alphaTag, number, emails);
        dsTaint.addTaint(number);
        dsTaint.addTaint(emails[0]);
        dsTaint.addTaint(alphaTag);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.604 -0400", hash_original_method = "06878C60780B4D9C01767F1F53E52E0B", hash_generated_method = "CBB357AF71B5DDFF28CE46BDD9CA491D")
    @DSModeled(DSC.SAFE)
    public AdnRecord(int efid, int recordNumber, String alphaTag, String number, String[] emails) {
        dsTaint.addTaint(recordNumber);
        dsTaint.addTaint(number);
        dsTaint.addTaint(emails[0]);
        dsTaint.addTaint(alphaTag);
        dsTaint.addTaint(efid);
        // ---------- Original Method ----------
        //this.efid = efid;
        //this.recordNumber = recordNumber;
        //this.alphaTag = alphaTag;
        //this.number = number;
        //this.emails = emails;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.605 -0400", hash_original_method = "D0AEC6EC6E3FB2D90C73DE97D25EE860", hash_generated_method = "6F7747DB60E5BC6588605B9EC57D1774")
    @DSModeled(DSC.SAFE)
    public AdnRecord(int efid, int recordNumber, String alphaTag, String number) {
        dsTaint.addTaint(recordNumber);
        dsTaint.addTaint(number);
        dsTaint.addTaint(alphaTag);
        dsTaint.addTaint(efid);
        this.emails = null;
        // ---------- Original Method ----------
        //this.efid = efid;
        //this.recordNumber = recordNumber;
        //this.alphaTag = alphaTag;
        //this.number = number;
        //this.emails = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.605 -0400", hash_original_method = "AC3A7A9E3A191B711B11224D0DA9AF99", hash_generated_method = "EC6D83D5497AF52E22C2DBDE51A55795")
    @DSModeled(DSC.SAFE)
    public String getAlphaTag() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return alphaTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.605 -0400", hash_original_method = "EC6570D4091CFB302FD4A14DB7A9F4B4", hash_generated_method = "DB3A8DFBBB18D8D611528AFDC519CAD5")
    @DSModeled(DSC.SAFE)
    public String getNumber() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return number;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.605 -0400", hash_original_method = "92D2F53049B5866D80AA794995783C1B", hash_generated_method = "4A234FB5E5DB78563C5254448CC762CB")
    @DSModeled(DSC.SAFE)
    public String[] getEmails() {
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return emails;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.605 -0400", hash_original_method = "318E4DB00CD29A795BAB76EF64647C6C", hash_generated_method = "DFAD31CD64E0E1F08F149F78FDFC8174")
    @DSModeled(DSC.SAFE)
    public void setEmails(String[] emails) {
        dsTaint.addTaint(emails[0]);
        // ---------- Original Method ----------
        //this.emails = emails;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.606 -0400", hash_original_method = "68220200E4F2B5D293B76BDD34BEE487", hash_generated_method = "00A8C734CEA6F0FA97E632CCC4DE545C")
    @DSModeled(DSC.SAFE)
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "ADN Record '" + alphaTag + "' '" + number + " " + emails + "'";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.606 -0400", hash_original_method = "5D6691CA551F86617D7220208AC31A8F", hash_generated_method = "0A4EA21FC6CDBEB69440D81C10C64EB1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEmpty() {
        boolean var64ACE25E19B6897AA2A6A6E9C8F778BE_1840011064 = (TextUtils.isEmpty(alphaTag) && TextUtils.isEmpty(number) && emails == null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return TextUtils.isEmpty(alphaTag) && TextUtils.isEmpty(number) && emails == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.606 -0400", hash_original_method = "D17030B2DC40ED56DDEA746A2C4F2F4F", hash_generated_method = "99542B6430A47C1595512EFBD3885343")
    @DSModeled(DSC.SAFE)
    public boolean hasExtendedRecord() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return extRecord != 0 && extRecord != 0xff;
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.606 -0400", hash_original_method = "EA1ABD1A8E044AEC4146178ABB95A33B", hash_generated_method = "F34A3EBADDDCA7FE946E192CBA128291")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEqual(AdnRecord adn) {
        dsTaint.addTaint(adn.dsTaint);
        boolean var845971BACDC4C2202680A46C8D0E99B3_1238045604 = (( stringCompareNullEqualsEmpty(alphaTag, adn.alphaTag) &&
                stringCompareNullEqualsEmpty(number, adn.number) &&
                Arrays.equals(emails, adn.emails)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ( stringCompareNullEqualsEmpty(alphaTag, adn.alphaTag) &&
                //stringCompareNullEqualsEmpty(number, adn.number) &&
                //Arrays.equals(emails, adn.emails));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.607 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.607 -0400", hash_original_method = "D94966D9C7C7FE5B7B9FBD39671B9050", hash_generated_method = "DBFC35CCAC31DE58D2FBD6BDEB3E78CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeInt(efid);
        dest.writeInt(recordNumber);
        dest.writeString(alphaTag);
        dest.writeString(number);
        dest.writeStringArray(emails);
        // ---------- Original Method ----------
        //dest.writeInt(efid);
        //dest.writeInt(recordNumber);
        //dest.writeString(alphaTag);
        //dest.writeString(number);
        //dest.writeStringArray(emails);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.607 -0400", hash_original_method = "43E5A3A3017D389C996FCD504E7A9103", hash_generated_method = "75D9AD34CFDAE8144CE4D8070E17C76B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] buildAdnString(int recordSize) {
        dsTaint.addTaint(recordSize);
        byte[] bcdNumber;
        byte[] byteTag;
        byte[] adnString;
        int footerOffset;
        footerOffset = recordSize - FOOTER_SIZE_BYTES;
        adnString = new byte[recordSize];
        {
            int i;
            i = 0;
            {
                adnString[i] = (byte) 0xFF;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varDC814D5E0DD02381050A532714A4AE08_332243587 = (TextUtils.isEmpty(number));
            {
                boolean varB75E4926A07A0F24448D0547153C270E_310842488 = (number.length()
                > (ADN_DIALING_NUMBER_END - ADN_DIALING_NUMBER_START + 1) * 2);
                {
                    boolean var8B62793D8BDEB3F925313D15AB6652F7_1597840543 = (alphaTag != null && alphaTag.length() > footerOffset);
                    {
                        bcdNumber = PhoneNumberUtils.numberToCalledPartyBCD(number);
                        System.arraycopy(bcdNumber, 0, adnString,
                    footerOffset + ADN_TON_AND_NPI, bcdNumber.length);
                        adnString[footerOffset + ADN_BCD_NUMBER_LENGTH]
                    = (byte) (bcdNumber.length);
                        adnString[footerOffset + ADN_CAPABILITY_ID]
                    = (byte) 0xFF;
                        adnString[footerOffset + ADN_EXTENSION_ID]
                    = (byte) 0xFF;
                        {
                            boolean var0F1597F4B13FAF8A3AC69C4DC1446BF6_2134034884 = (!TextUtils.isEmpty(alphaTag));
                            {
                                byteTag = GsmAlphabet.stringToGsm8BitPacked(alphaTag);
                                System.arraycopy(byteTag, 0, adnString, 0, byteTag.length);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.608 -0400", hash_original_method = "D43EB4B47E694B53E14D637B6CBB15DA", hash_generated_method = "7B65D1CBC0A91AF1E2EA36B4B4269856")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void appendExtRecord(byte[] extRecord) {
        dsTaint.addTaint(extRecord[0]);
        try 
        {
            number += PhoneNumberUtils.calledPartyBCDFragmentToString(
                                        extRecord, 2, 0xff & extRecord[1]);
        } //End block
        catch (RuntimeException ex)
        { }
        // ---------- Original Method ----------
        //try {
            //if (extRecord.length != EXT_RECORD_LENGTH_BYTES) {
                //return;
            //}
            //if ((extRecord[0] & EXT_RECORD_TYPE_MASK)
                    //!= EXT_RECORD_TYPE_ADDITIONAL_DATA) {
                //return;
            //}
            //if ((0xff & extRecord[1]) > MAX_EXT_CALLED_PARTY_LENGTH) {
                //return;
            //}
            //number += PhoneNumberUtils.calledPartyBCDFragmentToString(
                                        //extRecord, 2, 0xff & extRecord[1]);
        //} catch (RuntimeException ex) {
            //Log.w(LOG_TAG, "Error parsing AdnRecord ext record", ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.608 -0400", hash_original_method = "C94E0153AA9A00481672837ABFA310B4", hash_generated_method = "09A3E39CE2EA5A4CC1E058BCD34821CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void parseRecord(byte[] record) {
        dsTaint.addTaint(record[0]);
        try 
        {
            alphaTag = IccUtils.adnStringFieldToString(
                            record, 0, record.length - FOOTER_SIZE_BYTES);
            int footerOffset;
            footerOffset = record.length - FOOTER_SIZE_BYTES;
            int numberLength;
            numberLength = 0xff & record[footerOffset];
            {
                number = "";
            } //End block
            number = PhoneNumberUtils.calledPartyBCDToString(
                            record, footerOffset + 1, numberLength);
            extRecord = 0xff & record[record.length - 1];
            emails = null;
        } //End block
        catch (RuntimeException ex)
        {
            number = "";
            alphaTag = "";
            emails = null;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    static final String LOG_TAG = "GSM";
    static final int FOOTER_SIZE_BYTES = 14;
    static final int MAX_NUMBER_SIZE_BYTES = 11;
    static final int EXT_RECORD_LENGTH_BYTES = 13;
    static final int EXT_RECORD_TYPE_ADDITIONAL_DATA = 2;
    static final int EXT_RECORD_TYPE_MASK = 3;
    static final int MAX_EXT_CALLED_PARTY_LENGTH = 0xa;
    static final int ADN_BCD_NUMBER_LENGTH = 0;
    static final int ADN_TON_AND_NPI = 1;
    static final int ADN_DIALING_NUMBER_START = 2;
    static final int ADN_DIALING_NUMBER_END = 11;
    static final int ADN_CAPABILITY_ID = 12;
    static final int ADN_EXTENSION_ID = 13;
    public static final Parcelable.Creator<AdnRecord> CREATOR = new Parcelable.Creator<AdnRecord>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.609 -0400", hash_original_method = "6D3E00478735263B7A5F1362FAEF6B0C", hash_generated_method = "31D60AA35C419AEFD211CBE45FC9376C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public AdnRecord createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
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
            AdnRecord var24A5CDFF7AE8F06F8A165689E2F0D37F_674880898 = (new AdnRecord(efid, recordNumber, alphaTag, number, emails));
            return (AdnRecord)dsTaint.getTaint();
            // ---------- Original Method ----------
            //int efid;
            //int recordNumber;
            //String alphaTag;
            //String number;
            //String[] emails;
            //efid = source.readInt();
            //recordNumber = source.readInt();
            //alphaTag = source.readString();
            //number = source.readString();
            //emails = source.readStringArray();
            //return new AdnRecord(efid, recordNumber, alphaTag, number, emails);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.609 -0400", hash_original_method = "3B6DA40AF43FC2C814B6AF21D490BC95", hash_generated_method = "64B6FD216223EAF9FFA6007799C1FEB9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public AdnRecord[] newArray(int size) {
            dsTaint.addTaint(size);
            AdnRecord[] var81253AD4CEF69138DA21916EC5D81CD3_1326062561 = (new AdnRecord[size]);
            return (AdnRecord[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new AdnRecord[size];
        }

        
}; //Transformed anonymous class
}

