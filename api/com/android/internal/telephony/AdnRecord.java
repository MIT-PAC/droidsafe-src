package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.Log;
import java.util.Arrays;

public class AdnRecord implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.637 -0400", hash_original_field = "798BA4A06E75DF8F98A86DA56829D58F", hash_generated_field = "8258D0DD79FD51E01DCB0F44838DA6A0")

    String alphaTag = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.638 -0400", hash_original_field = "923514A5863F58F99BFC8BE708235C6E", hash_generated_field = "C5D9AA6EDF218E348AEF048EB45AD371")

    String number = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.638 -0400", hash_original_field = "AF67CA2FE7FFCEC86822126DE0FFC4D7", hash_generated_field = "6018210F0C36C78CE0E6A6F66DF47FDA")

    String[] emails;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.638 -0400", hash_original_field = "042F9382A2A61D75C637130759B477E4", hash_generated_field = "8BB493C18D39782136C2980A2ABB4984")

    int extRecord = 0xff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.638 -0400", hash_original_field = "1E3235258D1AA505A2572AF2B7877EBF", hash_generated_field = "48F4A49B3891A623660D9D89A749D7FD")

    int efid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.638 -0400", hash_original_field = "94FFE9B9C5894C1D45DFC612B295C53B", hash_generated_field = "23F79AC71281FC94187158A5D1BA833B")

    int recordNumber;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.638 -0400", hash_original_method = "7045C9AFF2F4A7CC7D801D193F8DA208", hash_generated_method = "2D209CB67E1077EC186814F0E2051BDA")
    public  AdnRecord(byte[] record) {
        this(0, 0, record);
        addTaint(record[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.639 -0400", hash_original_method = "39E5440420DD5CB806135CB05DFC1155", hash_generated_method = "667CADEBC2FC4216EF17B9A2768F90C1")
    public  AdnRecord(int efid, int recordNumber, byte[] record) {
        addTaint(record[0]);
        this.efid = efid;
        this.recordNumber = recordNumber;
        parseRecord(record);
        // ---------- Original Method ----------
        //this.efid = efid;
        //this.recordNumber = recordNumber;
        //parseRecord(record);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.640 -0400", hash_original_method = "3103748B60A6B4F91D8C8340F4241AA3", hash_generated_method = "E3DF30BA6B7D324D77BFD92060C97194")
    public  AdnRecord(String alphaTag, String number) {
        this(0, 0, alphaTag, number);
        addTaint(number.getTaint());
        addTaint(alphaTag.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.640 -0400", hash_original_method = "C511B456FEBF7A32E27BD651B4B0F96B", hash_generated_method = "8E1F468C67E51C1C26A74BACD8CDB141")
    public  AdnRecord(String alphaTag, String number, String[] emails) {
        this(0, 0, alphaTag, number, emails);
        addTaint(emails[0].getTaint());
        addTaint(number.getTaint());
        addTaint(alphaTag.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.641 -0400", hash_original_method = "06878C60780B4D9C01767F1F53E52E0B", hash_generated_method = "DB50F2CEE4F92ABE4D005D3996EFF7B3")
    public  AdnRecord(int efid, int recordNumber, String alphaTag, String number, String[] emails) {
        this.efid = efid;
        this.recordNumber = recordNumber;
        this.alphaTag = alphaTag;
        this.number = number;
        this.emails = emails;
        // ---------- Original Method ----------
        //this.efid = efid;
        //this.recordNumber = recordNumber;
        //this.alphaTag = alphaTag;
        //this.number = number;
        //this.emails = emails;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.642 -0400", hash_original_method = "D0AEC6EC6E3FB2D90C73DE97D25EE860", hash_generated_method = "3DE96C976C7EAB0FE566AB7C2BE80CAE")
    public  AdnRecord(int efid, int recordNumber, String alphaTag, String number) {
        this.efid = efid;
        this.recordNumber = recordNumber;
        this.alphaTag = alphaTag;
        this.number = number;
        this.emails = null;
        // ---------- Original Method ----------
        //this.efid = efid;
        //this.recordNumber = recordNumber;
        //this.alphaTag = alphaTag;
        //this.number = number;
        //this.emails = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.642 -0400", hash_original_method = "AC3A7A9E3A191B711B11224D0DA9AF99", hash_generated_method = "4146F1D3429F8D89CE9864394C17F1CA")
    public String getAlphaTag() {
String var64C27E170699D534429D7BBF1BBBEA29_474577840 =         alphaTag;
        var64C27E170699D534429D7BBF1BBBEA29_474577840.addTaint(taint);
        return var64C27E170699D534429D7BBF1BBBEA29_474577840;
        // ---------- Original Method ----------
        //return alphaTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.643 -0400", hash_original_method = "EC6570D4091CFB302FD4A14DB7A9F4B4", hash_generated_method = "63741F62152C56B84AEC2F95C7D2F069")
    public String getNumber() {
String var63E80DF571E08DAA47BEFBF0BD0EEBAD_1068949344 =         number;
        var63E80DF571E08DAA47BEFBF0BD0EEBAD_1068949344.addTaint(taint);
        return var63E80DF571E08DAA47BEFBF0BD0EEBAD_1068949344;
        // ---------- Original Method ----------
        //return number;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.643 -0400", hash_original_method = "92D2F53049B5866D80AA794995783C1B", hash_generated_method = "DE5E7621EC3910B6192CB981E84C2D6A")
    public String[] getEmails() {
String[] var72203EAA7D038E15106184833E380CD2_424939144 =         emails;
        var72203EAA7D038E15106184833E380CD2_424939144.addTaint(taint);
        return var72203EAA7D038E15106184833E380CD2_424939144;
        // ---------- Original Method ----------
        //return emails;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.643 -0400", hash_original_method = "318E4DB00CD29A795BAB76EF64647C6C", hash_generated_method = "8AD750FE9F5EE2A604E640BF0FA92A76")
    public void setEmails(String[] emails) {
        this.emails = emails;
        // ---------- Original Method ----------
        //this.emails = emails;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.643 -0400", hash_original_method = "68220200E4F2B5D293B76BDD34BEE487", hash_generated_method = "7D7CB69061E076AA203F693DAFA48DB2")
    public String toString() {
String var3150255CB96D67940667A85BE93CA1C9_382501963 =         "ADN Record '" + alphaTag + "' '" + number + " " + emails + "'";
        var3150255CB96D67940667A85BE93CA1C9_382501963.addTaint(taint);
        return var3150255CB96D67940667A85BE93CA1C9_382501963;
        // ---------- Original Method ----------
        //return "ADN Record '" + alphaTag + "' '" + number + " " + emails + "'";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.644 -0400", hash_original_method = "5D6691CA551F86617D7220208AC31A8F", hash_generated_method = "085A2F54C27080E5171ADEDDCED61542")
    public boolean isEmpty() {
        boolean varB679BA4A49178A5FFFFB2091D165AB85_880215156 = (TextUtils.isEmpty(alphaTag) && TextUtils.isEmpty(number) && emails == null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_415085531 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_415085531;
        // ---------- Original Method ----------
        //return TextUtils.isEmpty(alphaTag) && TextUtils.isEmpty(number) && emails == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.644 -0400", hash_original_method = "D17030B2DC40ED56DDEA746A2C4F2F4F", hash_generated_method = "9760759648391A2B209060E1D7A1199C")
    public boolean hasExtendedRecord() {
        boolean varF09E7BA1B696F5D5907F2CB3ADB1E96C_1695346652 = (extRecord != 0 && extRecord != 0xff);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1984289170 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1984289170;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.645 -0400", hash_original_method = "EA1ABD1A8E044AEC4146178ABB95A33B", hash_generated_method = "28FEF277FC1AD844EE82A7336D9ABAD2")
    public boolean isEqual(AdnRecord adn) {
        addTaint(adn.getTaint());
        boolean varC9D496DC62D726BB6AA21D01D3C73C1F_943607865 = (( stringCompareNullEqualsEmpty(alphaTag, adn.alphaTag) &&
                stringCompareNullEqualsEmpty(number, adn.number) &&
                Arrays.equals(emails, adn.emails)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1501137087 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1501137087;
        // ---------- Original Method ----------
        //return ( stringCompareNullEqualsEmpty(alphaTag, adn.alphaTag) &&
                //stringCompareNullEqualsEmpty(number, adn.number) &&
                //Arrays.equals(emails, adn.emails));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.645 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "00C9AD1A067CAF7F15ACAC19C9087E1D")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_773249365 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1327640290 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1327640290;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.645 -0400", hash_original_method = "D94966D9C7C7FE5B7B9FBD39671B9050", hash_generated_method = "CD794A4295AA7A8752E051586478080A")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.646 -0400", hash_original_method = "43E5A3A3017D389C996FCD504E7A9103", hash_generated_method = "F10C40E72619566044E926BE6E0982EB")
    public byte[] buildAdnString(int recordSize) {
        addTaint(recordSize);
        byte[] bcdNumber;
        byte[] byteTag;
        byte[] adnString;
        int footerOffset = recordSize - FOOTER_SIZE_BYTES;
        adnString = new byte[recordSize];
for(int i = 0;i < recordSize;i++)
        {
            adnString[i] = (byte) 0xFF;
        } //End block
    if(TextUtils.isEmpty(number))        
        {
            byte[] varE863D3BDC3BCB42847496E9E323A25CB_203774414 = (adnString);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1282498452 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1282498452;
        } //End block
        else
    if(number.length()
                > (ADN_DIALING_NUMBER_END - ADN_DIALING_NUMBER_START + 1) * 2)        
        {
            byte[] var37A6259CC0C1DAE299A7866489DFF0BD_1478389896 = (null);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_337100439 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_337100439;
        } //End block
        else
    if(alphaTag != null && alphaTag.length() > footerOffset)        
        {
            byte[] var37A6259CC0C1DAE299A7866489DFF0BD_1801755820 = (null);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_478874818 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_478874818;
        } //End block
        else
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
    if(!TextUtils.isEmpty(alphaTag))            
            {
                byteTag = GsmAlphabet.stringToGsm8BitPacked(alphaTag);
                System.arraycopy(byteTag, 0, adnString, 0, byteTag.length);
            } //End block
            byte[] varE863D3BDC3BCB42847496E9E323A25CB_326195632 = (adnString);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1468778079 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1468778079;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.647 -0400", hash_original_method = "D43EB4B47E694B53E14D637B6CBB15DA", hash_generated_method = "42B146F35B6BAF5F763822029579334F")
    public void appendExtRecord(byte[] extRecord) {
        try 
        {
    if(extRecord.length != EXT_RECORD_LENGTH_BYTES)            
            {
                return;
            } //End block
    if((extRecord[0] & EXT_RECORD_TYPE_MASK)
                    != EXT_RECORD_TYPE_ADDITIONAL_DATA)            
            {
                return;
            } //End block
    if((0xff & extRecord[1]) > MAX_EXT_CALLED_PARTY_LENGTH)            
            {
                return;
            } //End block
            number += PhoneNumberUtils.calledPartyBCDFragmentToString(
                                        extRecord, 2, 0xff & extRecord[1]);
        } //End block
        catch (RuntimeException ex)
        {
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.649 -0400", hash_original_method = "C94E0153AA9A00481672837ABFA310B4", hash_generated_method = "2E1CA589DBC29225A459633C75B72C33")
    private void parseRecord(byte[] record) {
        try 
        {
            alphaTag = IccUtils.adnStringFieldToString(
                            record, 0, record.length - FOOTER_SIZE_BYTES);
            int footerOffset = record.length - FOOTER_SIZE_BYTES;
            int numberLength = 0xff & record[footerOffset];
    if(numberLength > MAX_NUMBER_SIZE_BYTES)            
            {
                number = "";
                return;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.649 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "B8386CD6D900777C9D6A0A5CA1D0B217")

    static final String LOG_TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.649 -0400", hash_original_field = "655CD13E60E3C57FAF4129C7BA44F9A3", hash_generated_field = "A479997E660C0A4675A9654713189C0C")

    static final int FOOTER_SIZE_BYTES = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.649 -0400", hash_original_field = "AD737871D70A673314556EB2CA890665", hash_generated_field = "CD2EBEEB08E0EC642DA1A6AB81DF603B")

    static final int MAX_NUMBER_SIZE_BYTES = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.649 -0400", hash_original_field = "6ED7A398FF369B39E4FAFCCEAC174DBA", hash_generated_field = "178455A461A7085A0DC6AC3C937704E0")

    static final int EXT_RECORD_LENGTH_BYTES = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.649 -0400", hash_original_field = "D7D84B2E7F5FC1CBC43289664F46E05F", hash_generated_field = "273358D45598A18A00C408E116FAEB82")

    static final int EXT_RECORD_TYPE_ADDITIONAL_DATA = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.649 -0400", hash_original_field = "3F88C8E250C854A247323CDC5D48DE31", hash_generated_field = "3CAAEABA728011FD9AB41730AE3E782F")

    static final int EXT_RECORD_TYPE_MASK = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.650 -0400", hash_original_field = "16040568C05EDAAAF5F3C1552114B913", hash_generated_field = "B2E23EBB74212C6A387FD0B8C00F38CC")

    static final int MAX_EXT_CALLED_PARTY_LENGTH = 0xa;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.650 -0400", hash_original_field = "F6D83B14C37131820B202558933F613F", hash_generated_field = "667CDC09A750B86547BB85E502FD7452")

    static final int ADN_BCD_NUMBER_LENGTH = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.650 -0400", hash_original_field = "379A1918B1700155B663C0772C2CC3AF", hash_generated_field = "BD3D8B49EEFB4DC2A058F01A4B595F81")

    static final int ADN_TON_AND_NPI = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.650 -0400", hash_original_field = "8AF38E582D97EECA8310EDE63C713857", hash_generated_field = "7F0F4B8D13BB3B8240EA616F2B3E84A2")

    static final int ADN_DIALING_NUMBER_START = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.650 -0400", hash_original_field = "48007777B98A6E937CF1AB71FB3BF5EB", hash_generated_field = "976F3A103109D36548168859116BF109")

    static final int ADN_DIALING_NUMBER_END = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.650 -0400", hash_original_field = "8F64EF499FEE9C25726EDAAD611CF5CC", hash_generated_field = "351B371CE1B6F3F6A2BB7E5E7349A766")

    static final int ADN_CAPABILITY_ID = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.650 -0400", hash_original_field = "9DA62FE10CF7C78123E63294BDE8F680", hash_generated_field = "F75C98CA3CB8014717297E00FF83D4CF")

    static final int ADN_EXTENSION_ID = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.650 -0400", hash_original_field = "E8890807602BB8092FE9A75667822578", hash_generated_field = "F9654E411B123AFAFD83478F48AC874B")

    public static final Parcelable.Creator<AdnRecord> CREATOR
            = new Parcelable.Creator<AdnRecord>() {
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

        public AdnRecord[] newArray(int size) {
            return new AdnRecord[size];
        }
    };
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

