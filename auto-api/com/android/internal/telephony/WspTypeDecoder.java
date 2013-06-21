package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.HashMap;

public class WspTypeDecoder {
    byte[] wspData;
    int    dataLength;
    long   unsigned32bit;
    String stringValue;
    HashMap<String, String> contentParameters;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.600 -0400", hash_original_method = "5272930664D9B8230407C0BE43B28A37", hash_generated_method = "A1E7687E4877086A37DAFDC3E2D8C6E8")
    @DSModeled(DSC.SAFE)
    public WspTypeDecoder(byte[] pdu) {
        dsTaint.addTaint(pdu[0]);
        // ---------- Original Method ----------
        //wspData = pdu;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.601 -0400", hash_original_method = "AD9CBD08D1B6621762343776ED03C203", hash_generated_method = "CBB4D0EE9478FD303DD63012717BFC99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean decodeTextString(int startIndex) {
        dsTaint.addTaint(startIndex);
        int index;
        index = startIndex;
        dataLength = index - startIndex + 1;
        {
            stringValue = new String(wspData, startIndex + 1, dataLength - 2);
        } //End block
        {
            stringValue = new String(wspData, startIndex, dataLength - 1);
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.601 -0400", hash_original_method = "3D6D7F94DFC73BF2A0EB1C158A6FC357", hash_generated_method = "CE77E659CF15F2FC5735C8917A558201")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean decodeTokenText(int startIndex) {
        dsTaint.addTaint(startIndex);
        int index;
        index = startIndex;
        dataLength = index - startIndex + 1;
        stringValue = new String(wspData, startIndex, dataLength - 1);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int index = startIndex;
        //while (wspData[index] != 0) {
            //index++;
        //}
        //dataLength = index - startIndex + 1;
        //stringValue = new String(wspData, startIndex, dataLength - 1);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.601 -0400", hash_original_method = "83D32C5BCB0549BFFFB2F2ED18850933", hash_generated_method = "DD98B6F639D80464041AF364C81975D1")
    @DSModeled(DSC.SAFE)
    public boolean decodeShortInteger(int startIndex) {
        dsTaint.addTaint(startIndex);
        unsigned32bit = wspData[startIndex] & 0x7f;
        dataLength = 1;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if ((wspData[startIndex] & 0x80) == 0) {
            //return false;
        //}
        //unsigned32bit = wspData[startIndex] & 0x7f;
        //dataLength = 1;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.602 -0400", hash_original_method = "B3FA7CC1597D63764316082CF6F63FFB", hash_generated_method = "C5F35A9DF72870D7DDE1859F75E1C236")
    @DSModeled(DSC.SAFE)
    public boolean decodeLongInteger(int startIndex) {
        dsTaint.addTaint(startIndex);
        int lengthMultiOctet;
        lengthMultiOctet = wspData[startIndex] & 0xff;
        unsigned32bit = 0;
        {
            int i;
            i = 1;
            {
                unsigned32bit = (unsigned32bit << 8) | (wspData[startIndex + i] & 0xff);
            } //End block
        } //End collapsed parenthetic
        dataLength = 1 + lengthMultiOctet;
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.602 -0400", hash_original_method = "7B23A3D94A21E730AAD2DD6C619E091C", hash_generated_method = "FA78A4614EEE123026F7DBFE880B0EB1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean decodeIntegerValue(int startIndex) {
        dsTaint.addTaint(startIndex);
        {
            boolean var1C9B73C3826762586421D8059D80ABDF_391862090 = (decodeShortInteger(startIndex) == true);
        } //End collapsed parenthetic
        boolean var64119D95C8AB1E549EE2B71524C80024_215855970 = (decodeLongInteger(startIndex));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (decodeShortInteger(startIndex) == true) {
            //return true;
        //}
        //return decodeLongInteger(startIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.602 -0400", hash_original_method = "C4B929220DC6CCE2C4298A937E6A511E", hash_generated_method = "D4028FCBA4EF1DA98A3C36984B4A864B")
    @DSModeled(DSC.SAFE)
    public boolean decodeUintvarInteger(int startIndex) {
        dsTaint.addTaint(startIndex);
        int index;
        index = startIndex;
        unsigned32bit = 0;
        {
            unsigned32bit = (unsigned32bit << 7) | (wspData[index] & 0x7f);
        } //End block
        unsigned32bit = (unsigned32bit << 7) | (wspData[index] & 0x7f);
        dataLength = index - startIndex + 1;
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.603 -0400", hash_original_method = "EAB4DD919BF3841A91E98F99540A239A", hash_generated_method = "EDE7E1FA961329F6916D7B29F942F49C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean decodeValueLength(int startIndex) {
        dsTaint.addTaint(startIndex);
        {
            unsigned32bit = wspData[startIndex];
            dataLength = 1;
        } //End block
        {
            decodeUintvarInteger(startIndex + 1);
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.603 -0400", hash_original_method = "EF88FEA15C53B4BFAD6A7F9FD25E8828", hash_generated_method = "35B15E342EAA02F49B683EFDED9DD82A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean decodeExtensionMedia(int startIndex) {
        dsTaint.addTaint(startIndex);
        int index;
        index = startIndex;
        dataLength = 0;
        stringValue = null;
        int length;
        length = wspData.length;
        boolean rtrn;
        rtrn = index < length;
        dataLength = index - startIndex + 1;
        stringValue = new String(wspData, startIndex, dataLength - 1);
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.603 -0400", hash_original_method = "996125374865CC4B3A630D89D596F543", hash_generated_method = "FA61F69FC8381195E19250E316086168")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean decodeConstrainedEncoding(int startIndex) {
        dsTaint.addTaint(startIndex);
        {
            boolean var1C9B73C3826762586421D8059D80ABDF_1620163255 = (decodeShortInteger(startIndex) == true);
            {
                stringValue = null;
            } //End block
        } //End collapsed parenthetic
        boolean var4F09B9F518A18BC08FE863B1FF75D517_1245650101 = (decodeExtensionMedia(startIndex));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (decodeShortInteger(startIndex) == true) {
            //stringValue = null;
            //return true;
        //}
        //return decodeExtensionMedia(startIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.604 -0400", hash_original_method = "DFA72F248348DAACE561F2A4664CE110", hash_generated_method = "A9B1177A18F1FE49F93E5D08806FF324")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean decodeContentType(int startIndex) {
        dsTaint.addTaint(startIndex);
        int mediaPrefixLength;
        contentParameters = new HashMap<String, String>();
        try 
        {
            {
                boolean var3ABBC69DADC6991B732D0528B8EE1A67_471833059 = (decodeValueLength(startIndex) == false);
                {
                    boolean found;
                    found = decodeConstrainedEncoding(startIndex);
                    {
                        expandWellKnownMimeType();
                    } //End block
                } //End block
            } //End collapsed parenthetic
            int headersLength;
            headersLength = (int) unsigned32bit;
            mediaPrefixLength = getDecodedDataLength();
            {
                boolean var95A10877E5A6E7BBEF5BE5AD28A0F776_816862234 = (decodeIntegerValue(startIndex + mediaPrefixLength) == true);
                {
                    dataLength += mediaPrefixLength;
                    int readLength;
                    readLength = dataLength;
                    stringValue = null;
                    expandWellKnownMimeType();
                    long wellKnownValue;
                    wellKnownValue = unsigned32bit;
                    String mimeType;
                    mimeType = stringValue;
                    {
                        boolean varCCDCCCA6ACF1A67DAB9D227159E1C5CC_107992192 = (readContentParameters(startIndex + dataLength,
                        (headersLength - (dataLength - mediaPrefixLength)), 0));
                        {
                            dataLength += readLength;
                            unsigned32bit = wellKnownValue;
                            stringValue = mimeType;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                boolean varC168EC6BE78E873E9F43E6D83D876596_1776676424 = (decodeExtensionMedia(startIndex + mediaPrefixLength) == true);
                {
                    dataLength += mediaPrefixLength;
                    int readLength;
                    readLength = dataLength;
                    expandWellKnownMimeType();
                    long wellKnownValue;
                    wellKnownValue = unsigned32bit;
                    String mimeType;
                    mimeType = stringValue;
                    {
                        boolean varCCDCCCA6ACF1A67DAB9D227159E1C5CC_135336642 = (readContentParameters(startIndex + dataLength,
                        (headersLength - (dataLength - mediaPrefixLength)), 0));
                        {
                            dataLength += readLength;
                            unsigned32bit = wellKnownValue;
                            stringValue = mimeType;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (ArrayIndexOutOfBoundsException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.605 -0400", hash_original_method = "C75EA04BE4FCD731CE2D1E2104C2BFC7", hash_generated_method = "E9FB7E5EB0B649C495ECD089F80BF28B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean readContentParameters(int startIndex, int leftToRead, int accumulator) {
        dsTaint.addTaint(startIndex);
        dsTaint.addTaint(leftToRead);
        dsTaint.addTaint(accumulator);
        int totalRead;
        totalRead = 0;
        {
            byte nextByte;
            nextByte = wspData[startIndex];
            String value;
            value = null;
            String param;
            param = null;
            {
                decodeTokenText(startIndex);
                param = stringValue;
                totalRead += dataLength;
            } //End block
            {
                {
                    boolean var3CAAA8BEA3B83EA43CED18226EE493BE_1818681614 = (decodeIntegerValue(startIndex));
                    {
                        totalRead += dataLength;
                        int wellKnownParameterValue;
                        wellKnownParameterValue = (int) unsigned32bit;
                        param = WELL_KNOWN_PARAMETERS.get(wellKnownParameterValue);
                        {
                            param = "unassigned/0x" + Long.toHexString(wellKnownParameterValue);
                        } //End block
                        {
                            {
                                boolean varE161740E6212EA8B5BB2E3B363D2C1AD_1756343005 = (decodeUintvarInteger(startIndex + totalRead));
                                {
                                    totalRead += dataLength;
                                    value = String.valueOf(unsigned32bit);
                                    contentParameters.put(param, value);
                                    boolean varEBCD5665C3CB3AAE6E64A7A6D5426A79_192361066 = (readContentParameters(startIndex + totalRead, leftToRead
                                                            - totalRead, accumulator + totalRead));
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean varC6328D04C5A3761DD766CE780F5E25B3_1982863955 = (decodeNoValue(startIndex + totalRead));
                {
                    totalRead += dataLength;
                    value = null;
                } //End block
                {
                    boolean var2AF1F51211F5EA3621A475D01F6286F9_1893317063 = (decodeIntegerValue(startIndex + totalRead));
                    {
                        totalRead += dataLength;
                        int intValue;
                        intValue = (int) unsigned32bit;
                        {
                            value = "";
                        } //End block
                        {
                            value = String.valueOf(intValue);
                        } //End block
                    } //End block
                    {
                        decodeTokenText(startIndex + totalRead);
                        totalRead += dataLength;
                        value = stringValue;
                        {
                            boolean varCC1E5C31169C020911CB7872C14FA5C5_814463722 = (value.startsWith("\""));
                            {
                                value = value.substring(1);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            contentParameters.put(param, value);
            boolean var7E97E609C8A7BA25C3E276CFC52D5FB3_179359718 = (readContentParameters(startIndex + totalRead, leftToRead - totalRead,
                                            accumulator + totalRead));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.605 -0400", hash_original_method = "7291D1B6F4C3ED0E6F576F289818668E", hash_generated_method = "56EB11C007EDA0B1C95E3F4D39D4DBE6")
    @DSModeled(DSC.SAFE)
    private boolean decodeNoValue(int startIndex) {
        dsTaint.addTaint(startIndex);
        {
            dataLength = 1;
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (wspData[startIndex] == 0) {
            //dataLength = 1;
            //return true;
        //} else {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.605 -0400", hash_original_method = "CE7AFD5926883ED0297E0E8EC7A7D731", hash_generated_method = "15777DC299F40CBAF0E8026F5DA4BE86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void expandWellKnownMimeType() {
        {
            int binaryContentType;
            binaryContentType = (int) unsigned32bit;
            stringValue = WELL_KNOWN_MIME_TYPES.get(binaryContentType);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.605 -0400", hash_original_method = "6DB17C60367E4FD9EA73FA0EFFFEAB7B", hash_generated_method = "EF9EA242D4BD724DC62ABE1ACE4E8EAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean decodeContentLength(int startIndex) {
        dsTaint.addTaint(startIndex);
        boolean var7077CAEA40E22AEE07EE9069B9A30AB8_1660119103 = (decodeIntegerValue(startIndex));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return decodeIntegerValue(startIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.606 -0400", hash_original_method = "B28E495795E9250815D18C95A5C9BAB3", hash_generated_method = "2F76A988138D046F145001F4CD3C217F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean decodeContentLocation(int startIndex) {
        dsTaint.addTaint(startIndex);
        boolean varEDAF0A26C796B363F4C7D4AE22FF909E_1143172528 = (decodeTextString(startIndex));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return decodeTextString(startIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.606 -0400", hash_original_method = "AEF025906C652297B5F2A3BDE834B061", hash_generated_method = "8679C289A67AA9BC220EC983C6BCA2D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean decodeXWapApplicationId(int startIndex) {
        dsTaint.addTaint(startIndex);
        {
            boolean varDC0A767F76DF83F558A0C35EAF704F8B_1861670832 = (decodeIntegerValue(startIndex) == true);
            {
                stringValue = null;
            } //End block
        } //End collapsed parenthetic
        boolean varEDAF0A26C796B363F4C7D4AE22FF909E_1906370402 = (decodeTextString(startIndex));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (decodeIntegerValue(startIndex) == true) {
            //stringValue = null;
            //return true;
        //}
        //return decodeTextString(startIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.606 -0400", hash_original_method = "BA996E98F19E8451E86BBFBC5F7B64F6", hash_generated_method = "352CD4AF675EC8ED4EF4DA4C841DF987")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean seekXWapApplicationId(int startIndex, int endIndex) {
        dsTaint.addTaint(startIndex);
        dsTaint.addTaint(endIndex);
        int index;
        index = startIndex;
        try 
        {
            {
                index = startIndex;
                {
                    {
                        boolean var0C3AE32B8F9C0438CDB5414040BAE97E_1471299093 = (decodeIntegerValue(index));
                        {
                            int fieldValue;
                            fieldValue = (int) getValue32();
                            {
                                unsigned32bit = index + 1;
                            } //End block
                        } //End block
                        {
                            {
                                boolean var84F11A269ED33CA89590FC121EDD5BE8_1513859880 = (!decodeTextString(index));
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                    index += getDecodedDataLength();
                    byte val;
                    val = wspData[index];
                    {
                        index += wspData[index] + 1;
                    } //End block
                    {
                        {
                            boolean var4B12B0AE322D518F81AE2C4DBA083316_1396318069 = (!decodeUintvarInteger(index));
                        } //End collapsed parenthetic
                        index += getDecodedDataLength();
                    } //End block
                    {
                        {
                            boolean varD03D05721F07A95C3B6527252455DBDD_159861541 = (!decodeTextString(index));
                        } //End collapsed parenthetic
                        index += getDecodedDataLength();
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (ArrayIndexOutOfBoundsException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.607 -0400", hash_original_method = "ABD97DC4CA444BF0EFE71949DA3B86E2", hash_generated_method = "57BD1AD5ACA24DD3E6A7422D0177FD50")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean decodeXWapContentURI(int startIndex) {
        dsTaint.addTaint(startIndex);
        boolean varEDAF0A26C796B363F4C7D4AE22FF909E_551743388 = (decodeTextString(startIndex));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return decodeTextString(startIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.607 -0400", hash_original_method = "E928D18936C3E8793DB3C75F90F53AE7", hash_generated_method = "4AFA1C2ED0A59B66A3F943FFF5FB9CFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean decodeXWapInitiatorURI(int startIndex) {
        dsTaint.addTaint(startIndex);
        boolean varEDAF0A26C796B363F4C7D4AE22FF909E_807955816 = (decodeTextString(startIndex));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return decodeTextString(startIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.607 -0400", hash_original_method = "097EE97643EAEF3891CA5DC97464AC94", hash_generated_method = "F9A70073B66B23960DE76C06B64A8620")
    @DSModeled(DSC.SAFE)
    public int getDecodedDataLength() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return dataLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.607 -0400", hash_original_method = "222353B4CE9A8EDC30DC1C12168B96BB", hash_generated_method = "1E01C40BA13E44245EE94F6A4DDEB1E2")
    @DSModeled(DSC.SAFE)
    public long getValue32() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return unsigned32bit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.607 -0400", hash_original_method = "8109E4DB1588BAB17F9AEE1B35CA6B07", hash_generated_method = "BCC92E3CF863B27E66E24F9957127A15")
    @DSModeled(DSC.SAFE)
    public String getValueString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return stringValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.608 -0400", hash_original_method = "F1FCA07D8088CB011EA83E53B391A96C", hash_generated_method = "D3D41F02D360820B77255FF1D3F85180")
    @DSModeled(DSC.SAFE)
    public HashMap<String, String> getContentParameters() {
        return (HashMap<String, String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return contentParameters;
    }

    
    private static final int WAP_PDU_SHORT_LENGTH_MAX = 30;
    private static final int WAP_PDU_LENGTH_QUOTE = 31;
    public static final int PDU_TYPE_PUSH = 0x06;
    public static final int PDU_TYPE_CONFIRMED_PUSH = 0x07;
    private final static HashMap<Integer, String> WELL_KNOWN_MIME_TYPES =
            new HashMap<Integer, String>();
    private final static HashMap<Integer, String> WELL_KNOWN_PARAMETERS =
            new HashMap<Integer, String>();
    public static final int PARAMETER_ID_X_WAP_APPLICATION_ID = 0x2f;
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
    
    public static final String CONTENT_TYPE_B_PUSH_CO = "application/vnd.wap.coc";
    public static final String CONTENT_TYPE_B_MMS = "application/vnd.wap.mms-message";
    public static final String CONTENT_TYPE_B_PUSH_SYNCML_NOTI = "application/vnd.syncml.notification";
}

