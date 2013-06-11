package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Parcel;
import android.os.Parcelable;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.Log;
import java.util.Arrays;

public class AdnRecord implements Parcelable {
    static final String LOG_TAG = "GSM";
    String alphaTag = null;
    String number = null;
    String[] emails;
    int extRecord = 0xff;
    int efid;
    int recordNumber;
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.541 -0400", hash_original_method = "6D3E00478735263B7A5F1362FAEF6B0C", hash_generated_method = "81A377ED527701D67710F2AB6CDA6FB1")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.541 -0400", hash_original_method = "3B6DA40AF43FC2C814B6AF21D490BC95", hash_generated_method = "7AEE24B08816508CF03BF7F9DF38150C")
        @DSModeled(DSC.SAFE)
        public AdnRecord[] newArray(int size) {
            dsTaint.addTaint(size);
            return (AdnRecord[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new AdnRecord[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.542 -0400", hash_original_method = "7045C9AFF2F4A7CC7D801D193F8DA208", hash_generated_method = "28F199EE8BA933AEC2A109945345D8D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AdnRecord(byte[] record) {
        this(0, 0, record);
        dsTaint.addTaint(record);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.542 -0400", hash_original_method = "39E5440420DD5CB806135CB05DFC1155", hash_generated_method = "07390A5DA384BBB831C446F2B2B6990A")
    @DSModeled(DSC.SAFE)
    public AdnRecord(int efid, int recordNumber, byte[] record) {
        dsTaint.addTaint(record);
        dsTaint.addTaint(recordNumber);
        dsTaint.addTaint(efid);
        parseRecord(record);
        // ---------- Original Method ----------
        //this.efid = efid;
        //this.recordNumber = recordNumber;
        //parseRecord(record);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.542 -0400", hash_original_method = "3103748B60A6B4F91D8C8340F4241AA3", hash_generated_method = "D282EA6D20638837B40A466CEB18102C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AdnRecord(String alphaTag, String number) {
        this(0, 0, alphaTag, number);
        dsTaint.addTaint(number);
        dsTaint.addTaint(alphaTag);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.542 -0400", hash_original_method = "C511B456FEBF7A32E27BD651B4B0F96B", hash_generated_method = "81BA1EE586C3DDF221D82AA66F989CFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AdnRecord(String alphaTag, String number, String[] emails) {
        this(0, 0, alphaTag, number, emails);
        dsTaint.addTaint(number);
        dsTaint.addTaint(emails);
        dsTaint.addTaint(alphaTag);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.542 -0400", hash_original_method = "06878C60780B4D9C01767F1F53E52E0B", hash_generated_method = "E799B8B8F7BA3B5F6ED523A5B9AB72D6")
    @DSModeled(DSC.SAFE)
    public AdnRecord(int efid, int recordNumber, String alphaTag, String number, String[] emails) {
        dsTaint.addTaint(recordNumber);
        dsTaint.addTaint(number);
        dsTaint.addTaint(emails);
        dsTaint.addTaint(alphaTag);
        dsTaint.addTaint(efid);
        // ---------- Original Method ----------
        //this.efid = efid;
        //this.recordNumber = recordNumber;
        //this.alphaTag = alphaTag;
        //this.number = number;
        //this.emails = emails;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.542 -0400", hash_original_method = "D0AEC6EC6E3FB2D90C73DE97D25EE860", hash_generated_method = "25801949D05BCCBC0DDAE9295B42BF25")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.542 -0400", hash_original_method = "AC3A7A9E3A191B711B11224D0DA9AF99", hash_generated_method = "AABD74E5CCBF61E6EF72A095D3536517")
    @DSModeled(DSC.SAFE)
    public String getAlphaTag() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return alphaTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.542 -0400", hash_original_method = "EC6570D4091CFB302FD4A14DB7A9F4B4", hash_generated_method = "175A05AA3ECCF1634EEB242036B1640B")
    @DSModeled(DSC.SAFE)
    public String getNumber() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return number;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.542 -0400", hash_original_method = "92D2F53049B5866D80AA794995783C1B", hash_generated_method = "A68879C56229DBC5E5E9521F450CAE67")
    @DSModeled(DSC.SAFE)
    public String[] getEmails() {
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return emails;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.542 -0400", hash_original_method = "318E4DB00CD29A795BAB76EF64647C6C", hash_generated_method = "7A08E51A6D24E66C96F84142AD744498")
    @DSModeled(DSC.SAFE)
    public void setEmails(String[] emails) {
        dsTaint.addTaint(emails);
        // ---------- Original Method ----------
        //this.emails = emails;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.542 -0400", hash_original_method = "68220200E4F2B5D293B76BDD34BEE487", hash_generated_method = "56AD64208C536A922A6B2731E0F14808")
    @DSModeled(DSC.SAFE)
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "ADN Record '" + alphaTag + "' '" + number + " " + emails + "'";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.542 -0400", hash_original_method = "5D6691CA551F86617D7220208AC31A8F", hash_generated_method = "F71A0F5A5DE326B9671E37069F566027")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEmpty() {
        boolean var64ACE25E19B6897AA2A6A6E9C8F778BE_2081382820 = (TextUtils.isEmpty(alphaTag) && TextUtils.isEmpty(number) && emails == null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return TextUtils.isEmpty(alphaTag) && TextUtils.isEmpty(number) && emails == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.542 -0400", hash_original_method = "D17030B2DC40ED56DDEA746A2C4F2F4F", hash_generated_method = "0DE1D32BE28892DC7EE42504667E30F4")
    @DSModeled(DSC.SAFE)
    public boolean hasExtendedRecord() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return extRecord != 0 && extRecord != 0xff;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.542 -0400", hash_original_method = "FFF6375FFC722DE9AA4BE2FB124374C8", hash_generated_method = "67BCA36BAA2384216D92880D51BF96F5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.542 -0400", hash_original_method = "EA1ABD1A8E044AEC4146178ABB95A33B", hash_generated_method = "1E300B11972FB195EFA82836552D608C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEqual(AdnRecord adn) {
        dsTaint.addTaint(adn.dsTaint);
        boolean var845971BACDC4C2202680A46C8D0E99B3_429818235 = (( stringCompareNullEqualsEmpty(alphaTag, adn.alphaTag) &&
                stringCompareNullEqualsEmpty(number, adn.number) &&
                Arrays.equals(emails, adn.emails)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ( stringCompareNullEqualsEmpty(alphaTag, adn.alphaTag) &&
                //stringCompareNullEqualsEmpty(number, adn.number) &&
                //Arrays.equals(emails, adn.emails));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.543 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.543 -0400", hash_original_method = "D94966D9C7C7FE5B7B9FBD39671B9050", hash_generated_method = "3E1A07687EBA1E9ACAA8727047813A46")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.543 -0400", hash_original_method = "43E5A3A3017D389C996FCD504E7A9103", hash_generated_method = "C61065AAFAFC2D9B3346C8B0C61D3144")
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
            boolean varDC814D5E0DD02381050A532714A4AE08_1514168216 = (TextUtils.isEmpty(number));
            {
                boolean varB75E4926A07A0F24448D0547153C270E_3584707 = (number.length()
                > (ADN_DIALING_NUMBER_END - ADN_DIALING_NUMBER_START + 1) * 2);
                {
                    boolean var8B62793D8BDEB3F925313D15AB6652F7_734537768 = (alphaTag != null && alphaTag.length() > footerOffset);
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
                            boolean var0F1597F4B13FAF8A3AC69C4DC1446BF6_415603966 = (!TextUtils.isEmpty(alphaTag));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.543 -0400", hash_original_method = "D43EB4B47E694B53E14D637B6CBB15DA", hash_generated_method = "FDF95BAA65415C56F079E748B44A4AF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void appendExtRecord(byte[] extRecord) {
        dsTaint.addTaint(extRecord);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.543 -0400", hash_original_method = "C94E0153AA9A00481672837ABFA310B4", hash_generated_method = "BAEF79DD3DA25AA27FAA83D0345C49CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void parseRecord(byte[] record) {
        dsTaint.addTaint(record);
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

    
}


