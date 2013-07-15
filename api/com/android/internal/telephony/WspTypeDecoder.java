package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.HashMap;

public class WspTypeDecoder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.639 -0400", hash_original_field = "87B087375EA22EC6DF3C6E6687D91C30", hash_generated_field = "8290EB0F02CFA38CB47A5B024440BD48")

    byte[] wspData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.639 -0400", hash_original_field = "8099F621661FD70FB137BCB82175502F", hash_generated_field = "C2C63300DBA8596D9F7506F440BE0C4D")

    int dataLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.639 -0400", hash_original_field = "7AD31D85AAE2172A581FDA7D1EAB5B0A", hash_generated_field = "3CB5D92C1A42DDEDB166C653EEBE8D94")

    long unsigned32bit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.639 -0400", hash_original_field = "5B57AB60C984EEC4BC98143F6D1E8775", hash_generated_field = "E14F733129C447B5EE9E173FE8A7AECF")

    String stringValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.639 -0400", hash_original_field = "4F8C35A54550B9400D66946BC5378404", hash_generated_field = "99E7FB2AD756216059D191866E496D5B")

    HashMap<String, String> contentParameters;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.639 -0400", hash_original_method = "5272930664D9B8230407C0BE43B28A37", hash_generated_method = "64FBC31D7C3F545B7475044B7FFE92E1")
    public  WspTypeDecoder(byte[] pdu) {
        wspData = pdu;
        // ---------- Original Method ----------
        //wspData = pdu;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.641 -0400", hash_original_method = "AD9CBD08D1B6621762343776ED03C203", hash_generated_method = "A3733DF956D02BD139450198BFBDFAD8")
    public boolean decodeTextString(int startIndex) {
        int index = startIndex;
        while
(wspData[index] != 0)        
        {
            index++;
        } //End block
        dataLength = index - startIndex + 1;
    if(wspData[startIndex] == 127)        
        {
            stringValue = new String(wspData, startIndex + 1, dataLength - 2);
        } //End block
        else
        {
            stringValue = new String(wspData, startIndex, dataLength - 1);
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_426664246 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1030907961 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1030907961;
        // ---------- Original Method ----------
        //int index = startIndex;
        //while (wspData[index] != 0) {
            //index++;
        //}
        //dataLength = index - startIndex + 1;
        //if (wspData[startIndex] == 127) {
            //stringValue = new String(wspData, startIndex + 1, dataLength - 2);
        //} else {
            //stringValue = new String(wspData, startIndex, dataLength - 1);
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.643 -0400", hash_original_method = "3D6D7F94DFC73BF2A0EB1C158A6FC357", hash_generated_method = "B977720B43AEFB67C9F7D4B985ACAF1A")
    public boolean decodeTokenText(int startIndex) {
        int index = startIndex;
        while
(wspData[index] != 0)        
        {
            index++;
        } //End block
        dataLength = index - startIndex + 1;
        stringValue = new String(wspData, startIndex, dataLength - 1);
        boolean varB326B5062B2F0E69046810717534CB09_1048885085 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1327197728 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1327197728;
        // ---------- Original Method ----------
        //int index = startIndex;
        //while (wspData[index] != 0) {
            //index++;
        //}
        //dataLength = index - startIndex + 1;
        //stringValue = new String(wspData, startIndex, dataLength - 1);
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.645 -0400", hash_original_method = "83D32C5BCB0549BFFFB2F2ED18850933", hash_generated_method = "CEE9E8839587FD2310E87221E966A4D6")
    public boolean decodeShortInteger(int startIndex) {
    if((wspData[startIndex] & 0x80) == 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_713694302 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2048137600 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2048137600;
        } //End block
        unsigned32bit = wspData[startIndex] & 0x7f;
        dataLength = 1;
        boolean varB326B5062B2F0E69046810717534CB09_572290256 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2030139958 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2030139958;
        // ---------- Original Method ----------
        //if ((wspData[startIndex] & 0x80) == 0) {
            //return false;
        //}
        //unsigned32bit = wspData[startIndex] & 0x7f;
        //dataLength = 1;
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.646 -0400", hash_original_method = "B3FA7CC1597D63764316082CF6F63FFB", hash_generated_method = "CED7773DD501D2C367BAD49CB4BAC4F5")
    public boolean decodeLongInteger(int startIndex) {
        int lengthMultiOctet = wspData[startIndex] & 0xff;
    if(lengthMultiOctet > WAP_PDU_SHORT_LENGTH_MAX)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1587477810 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1624930904 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1624930904;
        } //End block
        unsigned32bit = 0;
for(int i = 1;i <= lengthMultiOctet;i++)
        {
            unsigned32bit = (unsigned32bit << 8) | (wspData[startIndex + i] & 0xff);
        } //End block
        dataLength = 1 + lengthMultiOctet;
        boolean varB326B5062B2F0E69046810717534CB09_1533109847 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_626129501 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_626129501;
        // ---------- Original Method ----------
        //int lengthMultiOctet = wspData[startIndex] & 0xff;
        //if (lengthMultiOctet > WAP_PDU_SHORT_LENGTH_MAX) {
            //return false;
        //}
        //unsigned32bit = 0;
        //for (int i = 1; i <= lengthMultiOctet; i++) {
            //unsigned32bit = (unsigned32bit << 8) | (wspData[startIndex + i] & 0xff);
        //}
        //dataLength = 1 + lengthMultiOctet;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.647 -0400", hash_original_method = "7B23A3D94A21E730AAD2DD6C619E091C", hash_generated_method = "6169F435C3FBE3DB651CE70631A97C8E")
    public boolean decodeIntegerValue(int startIndex) {
        addTaint(startIndex);
    if(decodeShortInteger(startIndex) == true)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1946311993 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_171889408 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_171889408;
        } //End block
        boolean var8033954622ED2C7C3E6DF63209C71DC8_1182103365 = (decodeLongInteger(startIndex));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_692744010 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_692744010;
        // ---------- Original Method ----------
        //if (decodeShortInteger(startIndex) == true) {
            //return true;
        //}
        //return decodeLongInteger(startIndex);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.649 -0400", hash_original_method = "C4B929220DC6CCE2C4298A937E6A511E", hash_generated_method = "55CB7CFAECD20ABE4BA8462782C9F242")
    public boolean decodeUintvarInteger(int startIndex) {
        int index = startIndex;
        unsigned32bit = 0;
        while
((wspData[index] & 0x80) != 0)        
        {
    if((index - startIndex) >= 4)            
            {
                boolean var68934A3E9455FA72420237EB05902327_693244764 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2112498349 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2112498349;
            } //End block
            unsigned32bit = (unsigned32bit << 7) | (wspData[index] & 0x7f);
            index++;
        } //End block
        unsigned32bit = (unsigned32bit << 7) | (wspData[index] & 0x7f);
        dataLength = index - startIndex + 1;
        boolean varB326B5062B2F0E69046810717534CB09_654078509 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1467367605 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1467367605;
        // ---------- Original Method ----------
        //int index = startIndex;
        //unsigned32bit = 0;
        //while ((wspData[index] & 0x80) != 0) {
            //if ((index - startIndex) >= 4) {
                //return false;
            //}
            //unsigned32bit = (unsigned32bit << 7) | (wspData[index] & 0x7f);
            //index++;
        //}
        //unsigned32bit = (unsigned32bit << 7) | (wspData[index] & 0x7f);
        //dataLength = index - startIndex + 1;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.649 -0400", hash_original_method = "EAB4DD919BF3841A91E98F99540A239A", hash_generated_method = "E044E6D3E23B709F874089C43F6773C6")
    public boolean decodeValueLength(int startIndex) {
    if((wspData[startIndex] & 0xff) > WAP_PDU_LENGTH_QUOTE)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1442205699 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2084998103 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2084998103;
        } //End block
    if(wspData[startIndex] < WAP_PDU_LENGTH_QUOTE)        
        {
            unsigned32bit = wspData[startIndex];
            dataLength = 1;
        } //End block
        else
        {
            decodeUintvarInteger(startIndex + 1);
            dataLength++;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_582658556 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1167419133 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1167419133;
        // ---------- Original Method ----------
        //if ((wspData[startIndex] & 0xff) > WAP_PDU_LENGTH_QUOTE) {
            //return false;
        //}
        //if (wspData[startIndex] < WAP_PDU_LENGTH_QUOTE) {
            //unsigned32bit = wspData[startIndex];
            //dataLength = 1;
        //} else {
            //decodeUintvarInteger(startIndex + 1);
            //dataLength++;
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.651 -0400", hash_original_method = "EF88FEA15C53B4BFAD6A7F9FD25E8828", hash_generated_method = "514984C3657AB70B843A05AC2DEA2EC1")
    public boolean decodeExtensionMedia(int startIndex) {
        int index = startIndex;
        dataLength = 0;
        stringValue = null;
        int length = wspData.length;
        boolean rtrn = index < length;
        while
(index < length && wspData[index] != 0)        
        {
            index++;
        } //End block
        dataLength = index - startIndex + 1;
        stringValue = new String(wspData, startIndex, dataLength - 1);
        boolean varD5E08F13445DBE37781C555C27C687A1_323134789 = (rtrn);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_15617277 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_15617277;
        // ---------- Original Method ----------
        //int index = startIndex;
        //dataLength = 0;
        //stringValue = null;
        //int length = wspData.length;
        //boolean rtrn = index < length;
        //while (index < length && wspData[index] != 0) {
            //index++;
        //}
        //dataLength = index - startIndex + 1;
        //stringValue = new String(wspData, startIndex, dataLength - 1);
        //return rtrn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.651 -0400", hash_original_method = "996125374865CC4B3A630D89D596F543", hash_generated_method = "5ADB37B33969AA64CB5833788F356C1F")
    public boolean decodeConstrainedEncoding(int startIndex) {
        addTaint(startIndex);
    if(decodeShortInteger(startIndex) == true)        
        {
            stringValue = null;
            boolean varB326B5062B2F0E69046810717534CB09_1964324943 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1599374506 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1599374506;
        } //End block
        boolean var8BC14E9D2A2004401925017CFD06D048_2015025356 = (decodeExtensionMedia(startIndex));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1652324400 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1652324400;
        // ---------- Original Method ----------
        //if (decodeShortInteger(startIndex) == true) {
            //stringValue = null;
            //return true;
        //}
        //return decodeExtensionMedia(startIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.653 -0400", hash_original_method = "DFA72F248348DAACE561F2A4664CE110", hash_generated_method = "F19082E8BAD9B6A3DA7855250EAFFDCD")
    public boolean decodeContentType(int startIndex) {
        addTaint(startIndex);
        int mediaPrefixLength;
        contentParameters = new HashMap<String, String>();
        try 
        {
    if(decodeValueLength(startIndex) == false)            
            {
                boolean found = decodeConstrainedEncoding(startIndex);
    if(found)                
                {
                    expandWellKnownMimeType();
                } //End block
                boolean var6CFE61694EE1BB13AE719D47C2F80B7A_943571450 = (found);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1919277299 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1919277299;
            } //End block
            int headersLength = (int) unsigned32bit;
            mediaPrefixLength = getDecodedDataLength();
    if(decodeIntegerValue(startIndex + mediaPrefixLength) == true)            
            {
                dataLength += mediaPrefixLength;
                int readLength = dataLength;
                stringValue = null;
                expandWellKnownMimeType();
                long wellKnownValue = unsigned32bit;
                String mimeType = stringValue;
    if(readContentParameters(startIndex + dataLength,
                        (headersLength - (dataLength - mediaPrefixLength)), 0))                
                {
                    dataLength += readLength;
                    unsigned32bit = wellKnownValue;
                    stringValue = mimeType;
                    boolean varB326B5062B2F0E69046810717534CB09_58480283 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1338617524 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1338617524;
                } //End block
                boolean var68934A3E9455FA72420237EB05902327_1248637526 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1133694092 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1133694092;
            } //End block
    if(decodeExtensionMedia(startIndex + mediaPrefixLength) == true)            
            {
                dataLength += mediaPrefixLength;
                int readLength = dataLength;
                expandWellKnownMimeType();
                long wellKnownValue = unsigned32bit;
                String mimeType = stringValue;
    if(readContentParameters(startIndex + dataLength,
                        (headersLength - (dataLength - mediaPrefixLength)), 0))                
                {
                    dataLength += readLength;
                    unsigned32bit = wellKnownValue;
                    stringValue = mimeType;
                    boolean varB326B5062B2F0E69046810717534CB09_472830233 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1984975659 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1984975659;
                } //End block
            } //End block
        } //End block
        catch (ArrayIndexOutOfBoundsException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1938725128 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_40822219 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_40822219;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1916086410 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2097860313 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2097860313;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.656 -0400", hash_original_method = "C75EA04BE4FCD731CE2D1E2104C2BFC7", hash_generated_method = "ADA6C876413B62DD66C0ACB10E16D86E")
    private boolean readContentParameters(int startIndex, int leftToRead, int accumulator) {
        addTaint(leftToRead);
        addTaint(startIndex);
        int totalRead = 0;
    if(leftToRead > 0)        
        {
            byte nextByte = wspData[startIndex];
            String value = null;
            String param = null;
    if((nextByte & 0x80) == 0x00 && nextByte > 31)            
            {
                decodeTokenText(startIndex);
                param = stringValue;
                totalRead += dataLength;
            } //End block
            else
            {
    if(decodeIntegerValue(startIndex))                
                {
                    totalRead += dataLength;
                    int wellKnownParameterValue = (int) unsigned32bit;
                    param = WELL_KNOWN_PARAMETERS.get(wellKnownParameterValue);
    if(param == null)                    
                    {
                        param = "unassigned/0x" + Long.toHexString(wellKnownParameterValue);
                    } //End block
    if(wellKnownParameterValue == Q_VALUE)                    
                    {
    if(decodeUintvarInteger(startIndex + totalRead))                        
                        {
                            totalRead += dataLength;
                            value = String.valueOf(unsigned32bit);
                            contentParameters.put(param, value);
                            boolean var644C7CF034738F0F8D9A0FA2055400C5_1329417656 = (readContentParameters(startIndex + totalRead, leftToRead
                                                            - totalRead, accumulator + totalRead));
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_623016326 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_623016326;
                        } //End block
                        else
                        {
                            boolean var68934A3E9455FA72420237EB05902327_342934115 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_943079000 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_943079000;
                        } //End block
                    } //End block
                } //End block
                else
                {
                    boolean var68934A3E9455FA72420237EB05902327_820040636 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1590922324 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1590922324;
                } //End block
            } //End block
    if(decodeNoValue(startIndex + totalRead))            
            {
                totalRead += dataLength;
                value = null;
            } //End block
            else
    if(decodeIntegerValue(startIndex + totalRead))            
            {
                totalRead += dataLength;
                int intValue = (int) unsigned32bit;
    if(intValue == 0)                
                {
                    value = "";
                } //End block
                else
                {
                    value = String.valueOf(intValue);
                } //End block
            } //End block
            else
            {
                decodeTokenText(startIndex + totalRead);
                totalRead += dataLength;
                value = stringValue;
    if(value.startsWith("\""))                
                {
                    value = value.substring(1);
                } //End block
            } //End block
            contentParameters.put(param, value);
            boolean var3FE1C4D8D7EFFA1D4DF50EE46AADF783_202914955 = (readContentParameters(startIndex + totalRead, leftToRead - totalRead,
                                            accumulator + totalRead));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_616521885 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_616521885;
        } //End block
        else
        {
            dataLength = accumulator;
            boolean varB326B5062B2F0E69046810717534CB09_1885224664 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_57018823 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_57018823;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.657 -0400", hash_original_method = "7291D1B6F4C3ED0E6F576F289818668E", hash_generated_method = "286976349CCC597E8945E6562D62BE5D")
    private boolean decodeNoValue(int startIndex) {
        addTaint(startIndex);
    if(wspData[startIndex] == 0)        
        {
            dataLength = 1;
            boolean varB326B5062B2F0E69046810717534CB09_471953558 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1095578410 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1095578410;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_774670448 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_608322213 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_608322213;
        } //End block
        // ---------- Original Method ----------
        //if (wspData[startIndex] == 0) {
            //dataLength = 1;
            //return true;
        //} else {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.658 -0400", hash_original_method = "CE7AFD5926883ED0297E0E8EC7A7D731", hash_generated_method = "8EF9E10B622BAA7271DF6C50594218BC")
    private void expandWellKnownMimeType() {
    if(stringValue == null)        
        {
            int binaryContentType = (int) unsigned32bit;
            stringValue = WELL_KNOWN_MIME_TYPES.get(binaryContentType);
        } //End block
        else
        {
            unsigned32bit = -1;
        } //End block
        // ---------- Original Method ----------
        //if (stringValue == null) {
            //int binaryContentType = (int) unsigned32bit;
            //stringValue = WELL_KNOWN_MIME_TYPES.get(binaryContentType);
        //} else {
            //unsigned32bit = -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.658 -0400", hash_original_method = "6DB17C60367E4FD9EA73FA0EFFFEAB7B", hash_generated_method = "F559B01EE67891D9A19B2C72A28BF2C4")
    public boolean decodeContentLength(int startIndex) {
        addTaint(startIndex);
        boolean var08FAF2B09D4897B60CA982086268C257_851822721 = (decodeIntegerValue(startIndex));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2061470284 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2061470284;
        // ---------- Original Method ----------
        //return decodeIntegerValue(startIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.658 -0400", hash_original_method = "B28E495795E9250815D18C95A5C9BAB3", hash_generated_method = "7E9BAE3B1C69EC8C97E47B6B0392969E")
    public boolean decodeContentLocation(int startIndex) {
        addTaint(startIndex);
        boolean varD0063709730E2936081256DB7CE2954A_1645170 = (decodeTextString(startIndex));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1686208330 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1686208330;
        // ---------- Original Method ----------
        //return decodeTextString(startIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.659 -0400", hash_original_method = "AEF025906C652297B5F2A3BDE834B061", hash_generated_method = "37BA22B5AF7E97DECD9E7C64EFCA4DE9")
    public boolean decodeXWapApplicationId(int startIndex) {
        addTaint(startIndex);
    if(decodeIntegerValue(startIndex) == true)        
        {
            stringValue = null;
            boolean varB326B5062B2F0E69046810717534CB09_656591724 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_553310711 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_553310711;
        } //End block
        boolean varD0063709730E2936081256DB7CE2954A_1194921595 = (decodeTextString(startIndex));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1817540047 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1817540047;
        // ---------- Original Method ----------
        //if (decodeIntegerValue(startIndex) == true) {
            //stringValue = null;
            //return true;
        //}
        //return decodeTextString(startIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.660 -0400", hash_original_method = "BA996E98F19E8451E86BBFBC5F7B64F6", hash_generated_method = "AE04EFA7DBF1056BE36706700BCEE7F6")
    public boolean seekXWapApplicationId(int startIndex, int endIndex) {
        addTaint(endIndex);
        addTaint(startIndex);
        int index = startIndex;
        try 
        {
for(index = startIndex;index <= endIndex;)
            {
    if(decodeIntegerValue(index))                
                {
                    int fieldValue = (int) getValue32();
    if(fieldValue == PARAMETER_ID_X_WAP_APPLICATION_ID)                    
                    {
                        unsigned32bit = index + 1;
                        boolean varB326B5062B2F0E69046810717534CB09_1257495473 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1530079974 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1530079974;
                    } //End block
                } //End block
                else
                {
    if(!decodeTextString(index))                    
                    {
                    boolean var68934A3E9455FA72420237EB05902327_1826046277 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_687382422 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_687382422;
                    }
                } //End block
                index += getDecodedDataLength();
    if(index > endIndex)                
                {
                boolean var68934A3E9455FA72420237EB05902327_450242224 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_824257978 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_824257978;
                }
                byte val = wspData[index];
    if(0 <= val && val <= WAP_PDU_SHORT_LENGTH_MAX)                
                {
                    index += wspData[index] + 1;
                } //End block
                else
    if(val == WAP_PDU_LENGTH_QUOTE)                
                {
    if(index + 1 >= endIndex)                    
                    {
                    boolean var68934A3E9455FA72420237EB05902327_898934799 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2112605909 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_2112605909;
                    }
                    index++;
    if(!decodeUintvarInteger(index))                    
                    {
                    boolean var68934A3E9455FA72420237EB05902327_1418440223 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2131190776 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_2131190776;
                    }
                    index += getDecodedDataLength();
                } //End block
                else
    if(WAP_PDU_LENGTH_QUOTE < val && val <= 127)                
                {
    if(!decodeTextString(index))                    
                    {
                    boolean var68934A3E9455FA72420237EB05902327_1682559150 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1687527663 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1687527663;
                    }
                    index += getDecodedDataLength();
                } //End block
                else
                {
                    index++;
                } //End block
            } //End block
        } //End block
        catch (ArrayIndexOutOfBoundsException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_382133964 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_37933931 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_37933931;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_7262654 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_543081949 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_543081949;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.661 -0400", hash_original_method = "ABD97DC4CA444BF0EFE71949DA3B86E2", hash_generated_method = "7D08250B43914FD1749E9865992F0348")
    public boolean decodeXWapContentURI(int startIndex) {
        addTaint(startIndex);
        boolean varD0063709730E2936081256DB7CE2954A_857728771 = (decodeTextString(startIndex));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1662478898 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1662478898;
        // ---------- Original Method ----------
        //return decodeTextString(startIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.661 -0400", hash_original_method = "E928D18936C3E8793DB3C75F90F53AE7", hash_generated_method = "728D978858A01E035974F0CF54884A06")
    public boolean decodeXWapInitiatorURI(int startIndex) {
        addTaint(startIndex);
        boolean varD0063709730E2936081256DB7CE2954A_253369548 = (decodeTextString(startIndex));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2063622901 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2063622901;
        // ---------- Original Method ----------
        //return decodeTextString(startIndex);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.662 -0400", hash_original_method = "097EE97643EAEF3891CA5DC97464AC94", hash_generated_method = "5B8BF74906ECD66C686376D6CB106436")
    public int getDecodedDataLength() {
        int var8099F621661FD70FB137BCB82175502F_2025364773 = (dataLength);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1144785066 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1144785066;
        // ---------- Original Method ----------
        //return dataLength;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.662 -0400", hash_original_method = "222353B4CE9A8EDC30DC1C12168B96BB", hash_generated_method = "80D2A15BF6DDC6F175A6CEEC71284B40")
    public long getValue32() {
        long var7AD31D85AAE2172A581FDA7D1EAB5B0A_1522708344 = (unsigned32bit);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_445996299 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_445996299;
        // ---------- Original Method ----------
        //return unsigned32bit;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.662 -0400", hash_original_method = "8109E4DB1588BAB17F9AEE1B35CA6B07", hash_generated_method = "6D140BBAFA69B812C1F02741705B7323")
    public String getValueString() {
String varFF91E0F0881095C075E75F0EB79E58BA_515678672 =         stringValue;
        varFF91E0F0881095C075E75F0EB79E58BA_515678672.addTaint(taint);
        return varFF91E0F0881095C075E75F0EB79E58BA_515678672;
        // ---------- Original Method ----------
        //return stringValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.662 -0400", hash_original_method = "F1FCA07D8088CB011EA83E53B391A96C", hash_generated_method = "5B802C5181897524A836176527857FAE")
    public HashMap<String, String> getContentParameters() {
HashMap<String, String> varC17DA6B8CB924FDB4B9347F320DA03D2_1670621884 =         contentParameters;
        varC17DA6B8CB924FDB4B9347F320DA03D2_1670621884.addTaint(taint);
        return varC17DA6B8CB924FDB4B9347F320DA03D2_1670621884;
        // ---------- Original Method ----------
        //return contentParameters;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.663 -0400", hash_original_field = "964A97571D63A0AE4749BFDF31F84435", hash_generated_field = "4F6BB777BDC875F4310534E9146342C6")

    private static final int WAP_PDU_SHORT_LENGTH_MAX = 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.663 -0400", hash_original_field = "D462A4FAE5F635BB10AD018D71FFF675", hash_generated_field = "46631EBD41809AE082E75C1CC8779D4E")

    private static final int WAP_PDU_LENGTH_QUOTE = 31;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.663 -0400", hash_original_field = "ADA62C1416CCF70A475348DF41F02D6C", hash_generated_field = "F67180C752D65206BDD9E13836C7D7DA")

    public static final int PDU_TYPE_PUSH = 0x06;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.663 -0400", hash_original_field = "39E84628362C30B24B2B0F8B056DF0C2", hash_generated_field = "8B50E6D79FF4EAAE11A4EAFF8CB9C391")

    public static final int PDU_TYPE_CONFIRMED_PUSH = 0x07;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.663 -0400", hash_original_field = "5E381E15128FE3CF13099C94BC13CC9D", hash_generated_field = "74BC2112327D6DF2EED1706E173921EA")

    private final static HashMap<Integer, String> WELL_KNOWN_MIME_TYPES = new HashMap<Integer, String>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.663 -0400", hash_original_field = "4925E42664D7E5D9E30FCDC14770BC4F", hash_generated_field = "D895CB481798D1C8E4ED40299841B480")

    private final static HashMap<Integer, String> WELL_KNOWN_PARAMETERS = new HashMap<Integer, String>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.663 -0400", hash_original_field = "50FED79CAECC86960E5974F84D61AFF5", hash_generated_field = "BC518E54BB1177BA8736BADC7A57ED44")

    public static final int PARAMETER_ID_X_WAP_APPLICATION_ID = 0x2f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.663 -0400", hash_original_field = "ACEF663A39B141424AAA293CBEFAA9A2", hash_generated_field = "64F5379E14B56A016C5EE441C8ABE3C3")

    private static final int Q_VALUE = 0x00;
    static {
        WELL_KNOWN_MIME_TYPES.put(0x00, "*/*");
        WELL_KNOWN_MIME_TYPES.put(0x01, "text/*");
        WELL_KNOWN_MIME_TYPES.put(0x02, "text/html");
        WELL_KNOWN_MIME_TYPES.put(0x03, "text/plain");
        WELL_KNOWN_MIME_TYPES.put(0x04, "text/x-hdml");
        WELL_KNOWN_MIME_TYPES.put(0x05, "text/x-ttml");
        WELL_KNOWN_MIME_TYPES.put(0x06, "text/x-vCalendar");
        WELL_KNOWN_MIME_TYPES.put(0x07, "text/x-vCard");
        WELL_KNOWN_MIME_TYPES.put(0x08, "text/vnd.wap.wml");
        WELL_KNOWN_MIME_TYPES.put(0x09, "text/vnd.wap.wmlscript");
        WELL_KNOWN_MIME_TYPES.put(0x0A, "text/vnd.wap.wta-event");
        WELL_KNOWN_MIME_TYPES.put(0x0B, "multipart/*");
        WELL_KNOWN_MIME_TYPES.put(0x0C, "multipart/mixed");
        WELL_KNOWN_MIME_TYPES.put(0x0D, "multipart/form-data");
        WELL_KNOWN_MIME_TYPES.put(0x0E, "multipart/byterantes");
        WELL_KNOWN_MIME_TYPES.put(0x0F, "multipart/alternative");
        WELL_KNOWN_MIME_TYPES.put(0x10, "application/*");
        WELL_KNOWN_MIME_TYPES.put(0x11, "application/java-vm");
        WELL_KNOWN_MIME_TYPES.put(0x12, "application/x-www-form-urlencoded");
        WELL_KNOWN_MIME_TYPES.put(0x13, "application/x-hdmlc");
        WELL_KNOWN_MIME_TYPES.put(0x14, "application/vnd.wap.wmlc");
        WELL_KNOWN_MIME_TYPES.put(0x15, "application/vnd.wap.wmlscriptc");
        WELL_KNOWN_MIME_TYPES.put(0x16, "application/vnd.wap.wta-eventc");
        WELL_KNOWN_MIME_TYPES.put(0x17, "application/vnd.wap.uaprof");
        WELL_KNOWN_MIME_TYPES.put(0x18, "application/vnd.wap.wtls-ca-certificate");
        WELL_KNOWN_MIME_TYPES.put(0x19, "application/vnd.wap.wtls-user-certificate");
        WELL_KNOWN_MIME_TYPES.put(0x1A, "application/x-x509-ca-cert");
        WELL_KNOWN_MIME_TYPES.put(0x1B, "application/x-x509-user-cert");
        WELL_KNOWN_MIME_TYPES.put(0x1C, "image/*");
        WELL_KNOWN_MIME_TYPES.put(0x1D, "image/gif");
        WELL_KNOWN_MIME_TYPES.put(0x1E, "image/jpeg");
        WELL_KNOWN_MIME_TYPES.put(0x1F, "image/tiff");
        WELL_KNOWN_MIME_TYPES.put(0x20, "image/png");
        WELL_KNOWN_MIME_TYPES.put(0x21, "image/vnd.wap.wbmp");
        WELL_KNOWN_MIME_TYPES.put(0x22, "application/vnd.wap.multipart.*");
        WELL_KNOWN_MIME_TYPES.put(0x23, "application/vnd.wap.multipart.mixed");
        WELL_KNOWN_MIME_TYPES.put(0x24, "application/vnd.wap.multipart.form-data");
        WELL_KNOWN_MIME_TYPES.put(0x25, "application/vnd.wap.multipart.byteranges");
        WELL_KNOWN_MIME_TYPES.put(0x26, "application/vnd.wap.multipart.alternative");
        WELL_KNOWN_MIME_TYPES.put(0x27, "application/xml");
        WELL_KNOWN_MIME_TYPES.put(0x28, "text/xml");
        WELL_KNOWN_MIME_TYPES.put(0x29, "application/vnd.wap.wbxml");
        WELL_KNOWN_MIME_TYPES.put(0x2A, "application/x-x968-cross-cert");
        WELL_KNOWN_MIME_TYPES.put(0x2B, "application/x-x968-ca-cert");
        WELL_KNOWN_MIME_TYPES.put(0x2C, "application/x-x968-user-cert");
        WELL_KNOWN_MIME_TYPES.put(0x2D, "text/vnd.wap.si");
        WELL_KNOWN_MIME_TYPES.put(0x2E, "application/vnd.wap.sic");
        WELL_KNOWN_MIME_TYPES.put(0x2F, "text/vnd.wap.sl");
        WELL_KNOWN_MIME_TYPES.put(0x30, "application/vnd.wap.slc");
        WELL_KNOWN_MIME_TYPES.put(0x31, "text/vnd.wap.co");
        WELL_KNOWN_MIME_TYPES.put(0x32, "application/vnd.wap.coc");
        WELL_KNOWN_MIME_TYPES.put(0x33, "application/vnd.wap.multipart.related");
        WELL_KNOWN_MIME_TYPES.put(0x34, "application/vnd.wap.sia");
        WELL_KNOWN_MIME_TYPES.put(0x35, "text/vnd.wap.connectivity-xml");
        WELL_KNOWN_MIME_TYPES.put(0x36, "application/vnd.wap.connectivity-wbxml");
        WELL_KNOWN_MIME_TYPES.put(0x37, "application/pkcs7-mime");
        WELL_KNOWN_MIME_TYPES.put(0x38, "application/vnd.wap.hashed-certificate");
        WELL_KNOWN_MIME_TYPES.put(0x39, "application/vnd.wap.signed-certificate");
        WELL_KNOWN_MIME_TYPES.put(0x3A, "application/vnd.wap.cert-response");
        WELL_KNOWN_MIME_TYPES.put(0x3B, "application/xhtml+xml");
        WELL_KNOWN_MIME_TYPES.put(0x3C, "application/wml+xml");
        WELL_KNOWN_MIME_TYPES.put(0x3D, "text/css");
        WELL_KNOWN_MIME_TYPES.put(0x3E, "application/vnd.wap.mms-message");
        WELL_KNOWN_MIME_TYPES.put(0x3F, "application/vnd.wap.rollover-certificate");
        WELL_KNOWN_MIME_TYPES.put(0x40, "application/vnd.wap.locc+wbxml");
        WELL_KNOWN_MIME_TYPES.put(0x41, "application/vnd.wap.loc+xml");
        WELL_KNOWN_MIME_TYPES.put(0x42, "application/vnd.syncml.dm+wbxml");
        WELL_KNOWN_MIME_TYPES.put(0x43, "application/vnd.syncml.dm+xml");
        WELL_KNOWN_MIME_TYPES.put(0x44, "application/vnd.syncml.notification");
        WELL_KNOWN_MIME_TYPES.put(0x45, "application/vnd.wap.xhtml+xml");
        WELL_KNOWN_MIME_TYPES.put(0x46, "application/vnd.wv.csp.cir");
        WELL_KNOWN_MIME_TYPES.put(0x47, "application/vnd.oma.dd+xml");
        WELL_KNOWN_MIME_TYPES.put(0x48, "application/vnd.oma.drm.message");
        WELL_KNOWN_MIME_TYPES.put(0x49, "application/vnd.oma.drm.content");
        WELL_KNOWN_MIME_TYPES.put(0x4A, "application/vnd.oma.drm.rights+xml");
        WELL_KNOWN_MIME_TYPES.put(0x4B, "application/vnd.oma.drm.rights+wbxml");
        WELL_KNOWN_MIME_TYPES.put(0x4C, "application/vnd.wv.csp+xml");
        WELL_KNOWN_MIME_TYPES.put(0x4D, "application/vnd.wv.csp+wbxml");
        WELL_KNOWN_MIME_TYPES.put(0x4E, "application/vnd.syncml.ds.notification");
        WELL_KNOWN_MIME_TYPES.put(0x4F, "audio/*");
        WELL_KNOWN_MIME_TYPES.put(0x50, "video/*");
        WELL_KNOWN_MIME_TYPES.put(0x51, "application/vnd.oma.dd2+xml");
        WELL_KNOWN_MIME_TYPES.put(0x52, "application/mikey");
        WELL_KNOWN_MIME_TYPES.put(0x53, "application/vnd.oma.dcd");
        WELL_KNOWN_MIME_TYPES.put(0x54, "application/vnd.oma.dcdc");
        WELL_KNOWN_MIME_TYPES.put(0x0201, "application/vnd.uplanet.cacheop-wbxml");
        WELL_KNOWN_MIME_TYPES.put(0x0202, "application/vnd.uplanet.signal");
        WELL_KNOWN_MIME_TYPES.put(0x0203, "application/vnd.uplanet.alert-wbxml");
        WELL_KNOWN_MIME_TYPES.put(0x0204, "application/vnd.uplanet.list-wbxml");
        WELL_KNOWN_MIME_TYPES.put(0x0205, "application/vnd.uplanet.listcmd-wbxml");
        WELL_KNOWN_MIME_TYPES.put(0x0206, "application/vnd.uplanet.channel-wbxml");
        WELL_KNOWN_MIME_TYPES.put(0x0207, "application/vnd.uplanet.provisioning-status-uri");
        WELL_KNOWN_MIME_TYPES.put(0x0208, "x-wap.multipart/vnd.uplanet.header-set");
        WELL_KNOWN_MIME_TYPES.put(0x0209, "application/vnd.uplanet.bearer-choice-wbxml");
        WELL_KNOWN_MIME_TYPES.put(0x020A, "application/vnd.phonecom.mmc-wbxml");
        WELL_KNOWN_MIME_TYPES.put(0x020B, "application/vnd.nokia.syncset+wbxml");
        WELL_KNOWN_MIME_TYPES.put(0x020C, "image/x-up-wpng");
        WELL_KNOWN_MIME_TYPES.put(0x0300, "application/iota.mmc-wbxml");
        WELL_KNOWN_MIME_TYPES.put(0x0301, "application/iota.mmc-xml");
        WELL_KNOWN_MIME_TYPES.put(0x0302, "application/vnd.syncml+xml");
        WELL_KNOWN_MIME_TYPES.put(0x0303, "application/vnd.syncml+wbxml");
        WELL_KNOWN_MIME_TYPES.put(0x0304, "text/vnd.wap.emn+xml");
        WELL_KNOWN_MIME_TYPES.put(0x0305, "text/calendar");
        WELL_KNOWN_MIME_TYPES.put(0x0306, "application/vnd.omads-email+xml");
        WELL_KNOWN_MIME_TYPES.put(0x0307, "application/vnd.omads-file+xml");
        WELL_KNOWN_MIME_TYPES.put(0x0308, "application/vnd.omads-folder+xml");
        WELL_KNOWN_MIME_TYPES.put(0x0309, "text/directory;profile=vCard");
        WELL_KNOWN_MIME_TYPES.put(0x030A, "application/vnd.wap.emn+wbxml");
        WELL_KNOWN_MIME_TYPES.put(0x030B, "application/vnd.nokia.ipdc-purchase-response");
        WELL_KNOWN_MIME_TYPES.put(0x030C, "application/vnd.motorola.screen3+xml");
        WELL_KNOWN_MIME_TYPES.put(0x030D, "application/vnd.motorola.screen3+gzip");
        WELL_KNOWN_MIME_TYPES.put(0x030E, "application/vnd.cmcc.setting+wbxml");
        WELL_KNOWN_MIME_TYPES.put(0x030F, "application/vnd.cmcc.bombing+wbxml");
        WELL_KNOWN_MIME_TYPES.put(0x0310, "application/vnd.docomo.pf");
        WELL_KNOWN_MIME_TYPES.put(0x0311, "application/vnd.docomo.ub");
        WELL_KNOWN_MIME_TYPES.put(0x0312, "application/vnd.omaloc-supl-init");
        WELL_KNOWN_MIME_TYPES.put(0x0313, "application/vnd.oma.group-usage-list+xml");
        WELL_KNOWN_MIME_TYPES.put(0x0314, "application/oma-directory+xml");
        WELL_KNOWN_MIME_TYPES.put(0x0315, "application/vnd.docomo.pf2");
        WELL_KNOWN_MIME_TYPES.put(0x0316, "application/vnd.oma.drm.roap-trigger+wbxml");
        WELL_KNOWN_MIME_TYPES.put(0x0317, "application/vnd.sbm.mid2");
        WELL_KNOWN_MIME_TYPES.put(0x0318, "application/vnd.wmf.bootstrap");
        WELL_KNOWN_MIME_TYPES.put(0x0319, "application/vnc.cmcc.dcd+xml");
        WELL_KNOWN_MIME_TYPES.put(0x031A, "application/vnd.sbm.cid");
        WELL_KNOWN_MIME_TYPES.put(0x031B, "application/vnd.oma.bcast.provisioningtrigger");
        WELL_KNOWN_PARAMETERS.put(0x00, "Q");
        WELL_KNOWN_PARAMETERS.put(0x01, "Charset");
        WELL_KNOWN_PARAMETERS.put(0x02, "Level");
        WELL_KNOWN_PARAMETERS.put(0x03, "Type");
        WELL_KNOWN_PARAMETERS.put(0x07, "Differences");
        WELL_KNOWN_PARAMETERS.put(0x08, "Padding");
        WELL_KNOWN_PARAMETERS.put(0x09, "Type");
        WELL_KNOWN_PARAMETERS.put(0x0E, "Max-Age");
        WELL_KNOWN_PARAMETERS.put(0x10, "Secure");
        WELL_KNOWN_PARAMETERS.put(0x11, "SEC");
        WELL_KNOWN_PARAMETERS.put(0x12, "MAC");
        WELL_KNOWN_PARAMETERS.put(0x13, "Creation-date");
        WELL_KNOWN_PARAMETERS.put(0x14, "Modification-date");
        WELL_KNOWN_PARAMETERS.put(0x15, "Read-date");
        WELL_KNOWN_PARAMETERS.put(0x16, "Size");
        WELL_KNOWN_PARAMETERS.put(0x17, "Name");
        WELL_KNOWN_PARAMETERS.put(0x18, "Filename");
        WELL_KNOWN_PARAMETERS.put(0x19, "Start");
        WELL_KNOWN_PARAMETERS.put(0x1A, "Start-info");
        WELL_KNOWN_PARAMETERS.put(0x1B, "Comment");
        WELL_KNOWN_PARAMETERS.put(0x1C, "Domain");
        WELL_KNOWN_PARAMETERS.put(0x1D, "Path");
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.664 -0400", hash_original_field = "59B3B5B7A655E77C4FD204F6827F65C8", hash_generated_field = "14E991E823DE7ACB83EEE5DC7F027D18")

    public static final String CONTENT_TYPE_B_PUSH_CO = "application/vnd.wap.coc";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.664 -0400", hash_original_field = "F97FC57303985A9ABF27BBC06719A8C2", hash_generated_field = "5F0B8A7CFD7D9E331890C88C73AA57E8")

    public static final String CONTENT_TYPE_B_MMS = "application/vnd.wap.mms-message";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.664 -0400", hash_original_field = "B25CCEE30EB601FE8F066D50875C2297", hash_generated_field = "C046414E5CAA77A1305073B53831F037")

    public static final String CONTENT_TYPE_B_PUSH_SYNCML_NOTI = "application/vnd.syncml.notification";
}

