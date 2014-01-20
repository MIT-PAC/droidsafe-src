package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.HashMap;

public class WspTypeDecoder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.522 -0500", hash_original_field = "737486A8B0400610DB3B9B68519E2368", hash_generated_field = "4F6BB777BDC875F4310534E9146342C6")

    private static final int WAP_PDU_SHORT_LENGTH_MAX = 30;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.524 -0500", hash_original_field = "88D3C32E1E4A3284B0997AAAF15399D1", hash_generated_field = "46631EBD41809AE082E75C1CC8779D4E")

    private static final int WAP_PDU_LENGTH_QUOTE = 31;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.528 -0500", hash_original_field = "E4D95AA773739B7024BA2FFC4086E4AC", hash_generated_field = "F67180C752D65206BDD9E13836C7D7DA")

    public static final int PDU_TYPE_PUSH = 0x06;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.530 -0500", hash_original_field = "E9DDFB52C3378A97044BB3F1F85F604E", hash_generated_field = "8B50E6D79FF4EAAE11A4EAFF8CB9C391")

    public static final int PDU_TYPE_CONFIRMED_PUSH = 0x07;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.533 -0500", hash_original_field = "DBCDD39ABEEF6F2F5891FB7B82AF1A7F", hash_generated_field = "74BC2112327D6DF2EED1706E173921EA")

    private final static HashMap<Integer, String> WELL_KNOWN_MIME_TYPES =
            new HashMap<Integer, String>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.535 -0500", hash_original_field = "88994EF51CCC3960392A8C20028A8D26", hash_generated_field = "D895CB481798D1C8E4ED40299841B480")

    private final static HashMap<Integer, String> WELL_KNOWN_PARAMETERS =
            new HashMap<Integer, String>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.538 -0500", hash_original_field = "9E09D4415292D41724E07C4096349A66", hash_generated_field = "BC518E54BB1177BA8736BADC7A57ED44")

    public static final int PARAMETER_ID_X_WAP_APPLICATION_ID = 0x2f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.540 -0500", hash_original_field = "307B2CE28D7704E7E09432614B17877C", hash_generated_field = "64F5379E14B56A016C5EE441C8ABE3C3")

    private static final int Q_VALUE = 0x00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.544 -0500", hash_original_field = "F97EFCA811D8DB37C1EAFBD9041DAA74", hash_generated_field = "14E991E823DE7ACB83EEE5DC7F027D18")

    public static final String CONTENT_TYPE_B_PUSH_CO = "application/vnd.wap.coc";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.547 -0500", hash_original_field = "30E4373950A64E1C033B12557F4B7189", hash_generated_field = "5F0B8A7CFD7D9E331890C88C73AA57E8")

    public static final String CONTENT_TYPE_B_MMS = "application/vnd.wap.mms-message";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.549 -0500", hash_original_field = "5DB804ADB8BBB28FF7C33330A8285EBC", hash_generated_field = "C046414E5CAA77A1305073B53831F037")

    public static final String CONTENT_TYPE_B_PUSH_SYNCML_NOTI = "application/vnd.syncml.notification";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.551 -0500", hash_original_field = "8290EB0F02CFA38CB47A5B024440BD48", hash_generated_field = "8290EB0F02CFA38CB47A5B024440BD48")

    byte[] wspData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.553 -0500", hash_original_field = "C2C63300DBA8596D9F7506F440BE0C4D", hash_generated_field = "C2C63300DBA8596D9F7506F440BE0C4D")

    int    dataLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.555 -0500", hash_original_field = "3CB5D92C1A42DDEDB166C653EEBE8D94", hash_generated_field = "3CB5D92C1A42DDEDB166C653EEBE8D94")

    long   unsigned32bit;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.557 -0500", hash_original_field = "E14F733129C447B5EE9E173FE8A7AECF", hash_generated_field = "E14F733129C447B5EE9E173FE8A7AECF")

    String stringValue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.560 -0500", hash_original_field = "99E7FB2AD756216059D191866E496D5B", hash_generated_field = "99E7FB2AD756216059D191866E496D5B")

    HashMap<String, String> contentParameters;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.563 -0500", hash_original_method = "5272930664D9B8230407C0BE43B28A37", hash_generated_method = "16987D918092E4ED2FA7E1E136912642")
    
public WspTypeDecoder(byte[] pdu) {
        wspData = pdu;
    }

    /**
     * Decode the "Text-string" type for WSP pdu
     *
     * @param startIndex The starting position of the "Text-string" in this pdu
     *
     * @return false when error(not a Text-string) occur
     *         return value can be retrieved by getValueString() method length of data in pdu can be
     *         retrieved by getDecodedDataLength() method
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.566 -0500", hash_original_method = "AD9CBD08D1B6621762343776ED03C203", hash_generated_method = "7A6A239677F491BDCBE9E262C9CB9B12")
    
public boolean decodeTextString(int startIndex) {
        int index = startIndex;
        while (wspData[index] != 0) {
            index++;
        }
        dataLength = index - startIndex + 1;
        if (wspData[startIndex] == 127) {
            stringValue = new String(wspData, startIndex + 1, dataLength - 2);
        } else {
            stringValue = new String(wspData, startIndex, dataLength - 1);
        }
        return true;
    }

    /**
     * Decode the "Token-text" type for WSP pdu
     *
     * @param startIndex The starting position of the "Token-text" in this pdu
     *
     * @return always true
     *         return value can be retrieved by getValueString() method
     *         length of data in pdu can be retrieved by getDecodedDataLength() method
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.568 -0500", hash_original_method = "3D6D7F94DFC73BF2A0EB1C158A6FC357", hash_generated_method = "D1E57725ACE8F38B9709E328D5A54E89")
    
public boolean decodeTokenText(int startIndex) {
        int index = startIndex;
        while (wspData[index] != 0) {
            index++;
        }
        dataLength = index - startIndex + 1;
        stringValue = new String(wspData, startIndex, dataLength - 1);

        return true;
    }

    /**
     * Decode the "Short-integer" type for WSP pdu
     *
     * @param startIndex The starting position of the "Short-integer" in this pdu
     *
     * @return false when error(not a Short-integer) occur
     *         return value can be retrieved by getValue32() method
     *         length of data in pdu can be retrieved by getDecodedDataLength() method
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.571 -0500", hash_original_method = "83D32C5BCB0549BFFFB2F2ED18850933", hash_generated_method = "667DA670555A625D54C35C40EDD4F8D3")
    
public boolean decodeShortInteger(int startIndex) {
        if ((wspData[startIndex] & 0x80) == 0) {
            return false;
        }
        unsigned32bit = wspData[startIndex] & 0x7f;
        dataLength = 1;
        return true;
    }

    /**
     * Decode the "Long-integer" type for WSP pdu
     *
     * @param startIndex The starting position of the "Long-integer" in this pdu
     *
     * @return false when error(not a Long-integer) occur
     *         return value can be retrieved by getValue32() method
     *         length of data in pdu can be retrieved by getDecodedDataLength() method
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.573 -0500", hash_original_method = "B3FA7CC1597D63764316082CF6F63FFB", hash_generated_method = "E9BDD5CAF80A503C8D79391D18792CDB")
    
public boolean decodeLongInteger(int startIndex) {
        int lengthMultiOctet = wspData[startIndex] & 0xff;

        if (lengthMultiOctet > WAP_PDU_SHORT_LENGTH_MAX) {
            return false;
        }
        unsigned32bit = 0;
        for (int i = 1; i <= lengthMultiOctet; i++) {
            unsigned32bit = (unsigned32bit << 8) | (wspData[startIndex + i] & 0xff);
        }
        dataLength = 1 + lengthMultiOctet;
        return true;
    }

    /**
     * Decode the "Integer-Value" type for WSP pdu
     *
     * @param startIndex The starting position of the "Integer-Value" in this pdu
     *
     * @return false when error(not a Integer-Value) occur
     *         return value can be retrieved by getValue32() method
     *         length of data in pdu can be retrieved by getDecodedDataLength() method
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.576 -0500", hash_original_method = "7B23A3D94A21E730AAD2DD6C619E091C", hash_generated_method = "3904AA6CD229FA5F21A9875D29E03EE1")
    
public boolean decodeIntegerValue(int startIndex) {
        if (decodeShortInteger(startIndex) == true) {
            return true;
        }
        return decodeLongInteger(startIndex);
    }

    /**
     * Decode the "Uintvar-integer" type for WSP pdu
     *
     * @param startIndex The starting position of the "Uintvar-integer" in this pdu
     *
     * @return false when error(not a Uintvar-integer) occur
     *         return value can be retrieved by getValue32() method
     *         length of data in pdu can be retrieved by getDecodedDataLength() method
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.578 -0500", hash_original_method = "C4B929220DC6CCE2C4298A937E6A511E", hash_generated_method = "A0943E9334B8AE3796A872F9E87CEFEF")
    
public boolean decodeUintvarInteger(int startIndex) {
        int index = startIndex;

        unsigned32bit = 0;
        while ((wspData[index] & 0x80) != 0) {
            if ((index - startIndex) >= 4) {
                return false;
            }
            unsigned32bit = (unsigned32bit << 7) | (wspData[index] & 0x7f);
            index++;
        }
        unsigned32bit = (unsigned32bit << 7) | (wspData[index] & 0x7f);
        dataLength = index - startIndex + 1;
        return true;
    }

    /**
     * Decode the "Value-length" type for WSP pdu
     *
     * @param startIndex The starting position of the "Value-length" in this pdu
     *
     * @return false when error(not a Value-length) occur
     *         return value can be retrieved by getValue32() method
     *         length of data in pdu can be retrieved by getDecodedDataLength() method
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.581 -0500", hash_original_method = "EAB4DD919BF3841A91E98F99540A239A", hash_generated_method = "ACC2704BDE86D228E5A53B7C188ADD0F")
    
public boolean decodeValueLength(int startIndex) {
        if ((wspData[startIndex] & 0xff) > WAP_PDU_LENGTH_QUOTE) {
            return false;
        }
        if (wspData[startIndex] < WAP_PDU_LENGTH_QUOTE) {
            unsigned32bit = wspData[startIndex];
            dataLength = 1;
        } else {
            decodeUintvarInteger(startIndex + 1);
            dataLength++;
        }
        return true;
    }

    /**
     * Decode the "Extension-media" type for WSP PDU.
     *
     * @param startIndex The starting position of the "Extension-media" in this PDU.
     *
     * @return false on error, such as if there is no Extension-media at startIndex.
     *         Side-effects: updates stringValue (available with
     *         getValueString()), which will be null on error. The length of the
     *         data in the PDU is available with getValue32(), 0 on error.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.583 -0500", hash_original_method = "EF88FEA15C53B4BFAD6A7F9FD25E8828", hash_generated_method = "486441A28B73DDFD8C18DA2A95D30528")
    
public boolean decodeExtensionMedia(int startIndex) {
        int index = startIndex;
        dataLength = 0;
        stringValue = null;
        int length = wspData.length;
        boolean rtrn = index < length;

        while (index < length && wspData[index] != 0) {
            index++;
        }

        dataLength = index - startIndex + 1;
        stringValue = new String(wspData, startIndex, dataLength - 1);

        return rtrn;
    }

    /**
     * Decode the "Constrained-encoding" type for WSP pdu
     *
     * @param startIndex The starting position of the "Constrained-encoding" in this pdu
     *
     * @return false when error(not a Constrained-encoding) occur
     *         return value can be retrieved first by getValueString() and second by getValue32() method
     *         length of data in pdu can be retrieved by getDecodedDataLength() method
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.585 -0500", hash_original_method = "996125374865CC4B3A630D89D596F543", hash_generated_method = "A60FFFB131D50C2EE9D271EAFE3CB41A")
    
public boolean decodeConstrainedEncoding(int startIndex) {
        if (decodeShortInteger(startIndex) == true) {
            stringValue = null;
            return true;
        }
        return decodeExtensionMedia(startIndex);
    }

    /**
     * Decode the "Content-type" type for WSP pdu
     *
     * @param startIndex The starting position of the "Content-type" in this pdu
     *
     * @return false when error(not a Content-type) occurs
     *         If a content type exists in the headers (either as inline string, or as well-known
     *         value), getValueString() will return it. If a 'well known value' is encountered that
     *         cannot be mapped to a string mime type, getValueString() will return null, and
     *         getValue32() will return the unknown content type value.
     *         length of data in pdu can be retrieved by getDecodedDataLength() method
     *         Any content type parameters will be accessible via getContentParameters()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.588 -0500", hash_original_method = "DFA72F248348DAACE561F2A4664CE110", hash_generated_method = "F7C2C4B56BB86CA97C3085B3DFE0A0F2")
    
public boolean decodeContentType(int startIndex) {
        int mediaPrefixLength;
        contentParameters = new HashMap<String, String>();

        try {
            if (decodeValueLength(startIndex) == false) {
                boolean found = decodeConstrainedEncoding(startIndex);
                if (found) {
                    expandWellKnownMimeType();
                }
                return found;
            }
            int headersLength = (int) unsigned32bit;
            mediaPrefixLength = getDecodedDataLength();
            if (decodeIntegerValue(startIndex + mediaPrefixLength) == true) {
                dataLength += mediaPrefixLength;
                int readLength = dataLength;
                stringValue = null;
                expandWellKnownMimeType();
                long wellKnownValue = unsigned32bit;
                String mimeType = stringValue;
                if (readContentParameters(startIndex + dataLength,
                        (headersLength - (dataLength - mediaPrefixLength)), 0)) {
                    dataLength += readLength;
                    unsigned32bit = wellKnownValue;
                    stringValue = mimeType;
                    return true;
                }
                return false;
            }
            if (decodeExtensionMedia(startIndex + mediaPrefixLength) == true) {
                dataLength += mediaPrefixLength;
                int readLength = dataLength;
                expandWellKnownMimeType();
                long wellKnownValue = unsigned32bit;
                String mimeType = stringValue;
                if (readContentParameters(startIndex + dataLength,
                        (headersLength - (dataLength - mediaPrefixLength)), 0)) {
                    dataLength += readLength;
                    unsigned32bit = wellKnownValue;
                    stringValue = mimeType;
                    return true;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //something doesn't add up
            return false;
        }
        return false;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.592 -0500", hash_original_method = "C75EA04BE4FCD731CE2D1E2104C2BFC7", hash_generated_method = "8FFE0978AA2F6BF0B07EB701B20A6D97")
    
private boolean readContentParameters(int startIndex, int leftToRead, int accumulator) {

        int totalRead = 0;

        if (leftToRead > 0) {
            byte nextByte = wspData[startIndex];
            String value = null;
            String param = null;
            if ((nextByte & 0x80) == 0x00 && nextByte > 31) { // untyped
                decodeTokenText(startIndex);
                param = stringValue;
                totalRead += dataLength;
            } else { // typed
                if (decodeIntegerValue(startIndex)) {
                    totalRead += dataLength;
                    int wellKnownParameterValue = (int) unsigned32bit;
                    param = WELL_KNOWN_PARAMETERS.get(wellKnownParameterValue);
                    if (param == null) {
                        param = "unassigned/0x" + Long.toHexString(wellKnownParameterValue);
                    }
                    // special case for the "Q" parameter, value is a uintvar
                    if (wellKnownParameterValue == Q_VALUE) {
                        if (decodeUintvarInteger(startIndex + totalRead)) {
                            totalRead += dataLength;
                            value = String.valueOf(unsigned32bit);
                            contentParameters.put(param, value);
                            return readContentParameters(startIndex + totalRead, leftToRead
                                                            - totalRead, accumulator + totalRead);
                        } else {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }

            if (decodeNoValue(startIndex + totalRead)) {
                totalRead += dataLength;
                value = null;
            } else if (decodeIntegerValue(startIndex + totalRead)) {
                totalRead += dataLength;
                int intValue = (int) unsigned32bit;
                if (intValue == 0) {
                    value = "";
                } else {
                    value = String.valueOf(intValue);
                }
            } else {
                decodeTokenText(startIndex + totalRead);
                totalRead += dataLength;
                value = stringValue;
                if (value.startsWith("\"")) {
                    // quoted string, so remove the quote
                    value = value.substring(1);
                }
            }
            contentParameters.put(param, value);
            return readContentParameters(startIndex + totalRead, leftToRead - totalRead,
                                            accumulator + totalRead);

        } else {
            dataLength = accumulator;
            return true;
        }
    }

    /**
     * Check if the next byte is No-Value
     *
     * @param startIndex The starting position of the "Content length" in this pdu
     *
     * @return true if and only if the next byte is 0x00
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.595 -0500", hash_original_method = "7291D1B6F4C3ED0E6F576F289818668E", hash_generated_method = "DD6AFDA8080022B03F0CD64EB972EE57")
    
private boolean decodeNoValue(int startIndex) {
        if (wspData[startIndex] == 0) {
            dataLength = 1;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Populate stringValue with the mime type corresponding to the value in unsigned32bit
     *
     * Sets unsigned32bit to -1 if stringValue is already populated
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.598 -0500", hash_original_method = "CE7AFD5926883ED0297E0E8EC7A7D731", hash_generated_method = "39DC581202F3DDC089AFACD3A40F9668")
    
private void expandWellKnownMimeType() {
        if (stringValue == null) {
            int binaryContentType = (int) unsigned32bit;
            stringValue = WELL_KNOWN_MIME_TYPES.get(binaryContentType);
        } else {
            unsigned32bit = -1;
        }
    }

    /**
     * Decode the "Content length" type for WSP pdu
     *
     * @param startIndex The starting position of the "Content length" in this pdu
     *
     * @return false when error(not a Content length) occur
     *         return value can be retrieved by getValue32() method
     *         length of data in pdu can be retrieved by getDecodedDataLength() method
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.600 -0500", hash_original_method = "6DB17C60367E4FD9EA73FA0EFFFEAB7B", hash_generated_method = "293C7EAF90EF82E175C90ED5777290CA")
    
public boolean decodeContentLength(int startIndex) {
        return decodeIntegerValue(startIndex);
    }

    /**
     * Decode the "Content location" type for WSP pdu
     *
     * @param startIndex The starting position of the "Content location" in this pdu
     *
     * @return false when error(not a Content location) occur
     *         return value can be retrieved by getValueString() method
     *         length of data in pdu can be retrieved by getDecodedDataLength() method
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.602 -0500", hash_original_method = "B28E495795E9250815D18C95A5C9BAB3", hash_generated_method = "BE47B1335DEB2B492ACCC080BDC577FE")
    
public boolean decodeContentLocation(int startIndex) {
        return decodeTextString(startIndex);
    }

    /**
     * Decode the "X-Wap-Application-Id" type for WSP pdu
     *
     * @param startIndex The starting position of the "X-Wap-Application-Id" in this pdu
     *
     * @return false when error(not a X-Wap-Application-Id) occur
     *         return value can be retrieved first by getValueString() and second by getValue32()
     *         method
     *         length of data in pdu can be retrieved by getDecodedDataLength() method
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.605 -0500", hash_original_method = "AEF025906C652297B5F2A3BDE834B061", hash_generated_method = "4021A63D2D7B5DC7A8CB5BB56CA6A347")
    
public boolean decodeXWapApplicationId(int startIndex) {
        if (decodeIntegerValue(startIndex) == true) {
            stringValue = null;
            return true;
        }
        return decodeTextString(startIndex);
    }

    /**
     * Seek for the "X-Wap-Application-Id" field for WSP pdu
     *
     * @param startIndex The starting position of seek pointer
     * @param endIndex Valid seek area end point
     *
     * @return false when error(not a X-Wap-Application-Id) occur
     *         return value can be retrieved by getValue32()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.608 -0500", hash_original_method = "BA996E98F19E8451E86BBFBC5F7B64F6", hash_generated_method = "7506DB28380DFC1375932D9C5FB7929C")
    
public boolean seekXWapApplicationId(int startIndex, int endIndex) {
        int index = startIndex;

        try {
            for (index = startIndex; index <= endIndex; ) {
                /**
                 * 8.4.1.1  Field name
                 * Field name is integer or text.
                 */
                if (decodeIntegerValue(index)) {
                    int fieldValue = (int) getValue32();

                    if (fieldValue == PARAMETER_ID_X_WAP_APPLICATION_ID) {
                        unsigned32bit = index + 1;
                        return true;
                    }
                } else {
                    if (!decodeTextString(index)) return false;
                }
                index += getDecodedDataLength();
                if (index > endIndex) return false;

                /**
                 * 8.4.1.2 Field values
                 * Value Interpretation of First Octet
                 * 0 - 30 This octet is followed by the indicated number (0 - 30)
                        of data octets
                 * 31 This octet is followed by a uintvar, which indicates the number
                 *      of data octets after it
                 * 32 - 127 The value is a text string, terminated by a zero octet
                        (NUL character)
                 * 128 - 255 It is an encoded 7-bit value; this header has no more data
                 */
                byte val = wspData[index];
                if (0 <= val && val <= WAP_PDU_SHORT_LENGTH_MAX) {
                    index += wspData[index] + 1;
                } else if (val == WAP_PDU_LENGTH_QUOTE) {
                    if (index + 1 >= endIndex) return false;
                    index++;
                    if (!decodeUintvarInteger(index)) return false;
                    index += getDecodedDataLength();
                } else if (WAP_PDU_LENGTH_QUOTE < val && val <= 127) {
                    if (!decodeTextString(index)) return false;
                    index += getDecodedDataLength();
                } else {
                    index++;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //seek application ID failed. WSP header might be corrupted
            return false;
        }
        return false;
    }

    /**
     * Decode the "X-Wap-Content-URI" type for WSP pdu
     *
     * @param startIndex The starting position of the "X-Wap-Content-URI" in this pdu
     *
     * @return false when error(not a X-Wap-Content-URI) occur
     *         return value can be retrieved by getValueString() method
     *         length of data in pdu can be retrieved by getDecodedDataLength() method
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.610 -0500", hash_original_method = "ABD97DC4CA444BF0EFE71949DA3B86E2", hash_generated_method = "EEFBD9DB49C2D0B1EE317844A5A57725")
    
public boolean decodeXWapContentURI(int startIndex) {
        return decodeTextString(startIndex);
    }

    /**
     * Decode the "X-Wap-Initiator-URI" type for WSP pdu
     *
     * @param startIndex The starting position of the "X-Wap-Initiator-URI" in this pdu
     *
     * @return false when error(not a X-Wap-Initiator-URI) occur
     *         return value can be retrieved by getValueString() method
     *         length of data in pdu can be retrieved by getDecodedDataLength() method
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.612 -0500", hash_original_method = "E928D18936C3E8793DB3C75F90F53AE7", hash_generated_method = "5BDA2AC05092C85B7B80EFD5084E8B80")
    
public boolean decodeXWapInitiatorURI(int startIndex) {
        return decodeTextString(startIndex);
    }

    /**
     * The data length of latest operation.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.614 -0500", hash_original_method = "097EE97643EAEF3891CA5DC97464AC94", hash_generated_method = "EC9F5ADC14F341FBC07C2F35981FE3DF")
    
public int getDecodedDataLength() {
        return dataLength;
    }
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

    /**
     * The 32-bits result of latest operation.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.617 -0500", hash_original_method = "222353B4CE9A8EDC30DC1C12168B96BB", hash_generated_method = "AC69C7C36273AF6F057F89D981224EAB")
    
public long getValue32() {
        return unsigned32bit;
    }

    /**
     * The String result of latest operation.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.619 -0500", hash_original_method = "8109E4DB1588BAB17F9AEE1B35CA6B07", hash_generated_method = "98A308431A618363FBF44E7348C16BD5")
    
public String getValueString() {
        return stringValue;
    }

    /**
     * Any parameters encountered as part of a decodeContentType() invocation.
     *
     * @return a map of content parameters keyed by their names, or null if
     *         decodeContentType() has not been called If any unassigned
     *         well-known parameters are encountered, the key of the map will be
     *         'unassigned/0x...', where '...' is the hex value of the
     *         unassigned parameter.  If a parameter has No-Value the value will be null.
     *
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:16.621 -0500", hash_original_method = "F1FCA07D8088CB011EA83E53B391A96C", hash_generated_method = "935124A4CF397E53F7FFD7156B3259CA")
    
public HashMap<String, String> getContentParameters() {
        return contentParameters;
    }
}

