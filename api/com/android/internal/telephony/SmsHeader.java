package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import android.telephony.SmsMessage;

import com.android.internal.util.HexDump;

public class SmsHeader {

    /**
     * Create structured SmsHeader object from serialized byte array representation.
     * (see TS 23.040 9.2.3.24)
     * @param data is user data header bytes
     * @return SmsHeader object
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.709 -0500", hash_original_method = "7EEA5ED41B923A03FC6EA491A90F691D", hash_generated_method = "B07DABA9EBEAE2FC26090D1F1017D5EF")
    
public static SmsHeader fromByteArray(byte[] data) {
        ByteArrayInputStream inStream = new ByteArrayInputStream(data);
        SmsHeader smsHeader = new SmsHeader();
        while (inStream.available() > 0) {
            /**
             * NOTE: as defined in the spec, ConcatRef and PortAddr
             * fields should not reoccur, but if they do the last
             * occurrence is to be used.  Also, for ConcatRef
             * elements, if the count is zero, sequence is zero, or
             * sequence is larger than count, the entire element is to
             * be ignored.
             */
            int id = inStream.read();
            int length = inStream.read();
            ConcatRef concatRef;
            PortAddrs portAddrs;
            switch (id) {
            case ELT_ID_CONCATENATED_8_BIT_REFERENCE:
                concatRef = new ConcatRef();
                concatRef.refNumber = inStream.read();
                concatRef.msgCount = inStream.read();
                concatRef.seqNumber = inStream.read();
                concatRef.isEightBits = true;
                if (concatRef.msgCount != 0 && concatRef.seqNumber != 0 &&
                        concatRef.seqNumber <= concatRef.msgCount) {
                    smsHeader.concatRef = concatRef;
                }
                break;
            case ELT_ID_CONCATENATED_16_BIT_REFERENCE:
                concatRef = new ConcatRef();
                concatRef.refNumber = (inStream.read() << 8) | inStream.read();
                concatRef.msgCount = inStream.read();
                concatRef.seqNumber = inStream.read();
                concatRef.isEightBits = false;
                if (concatRef.msgCount != 0 && concatRef.seqNumber != 0 &&
                        concatRef.seqNumber <= concatRef.msgCount) {
                    smsHeader.concatRef = concatRef;
                }
                break;
            case ELT_ID_APPLICATION_PORT_ADDRESSING_8_BIT:
                portAddrs = new PortAddrs();
                portAddrs.destPort = inStream.read();
                portAddrs.origPort = inStream.read();
                portAddrs.areEightBits = true;
                smsHeader.portAddrs = portAddrs;
                break;
            case ELT_ID_APPLICATION_PORT_ADDRESSING_16_BIT:
                portAddrs = new PortAddrs();
                portAddrs.destPort = (inStream.read() << 8) | inStream.read();
                portAddrs.origPort = (inStream.read() << 8) | inStream.read();
                portAddrs.areEightBits = false;
                smsHeader.portAddrs = portAddrs;
                break;
            case ELT_ID_NATIONAL_LANGUAGE_SINGLE_SHIFT:
                smsHeader.languageShiftTable = inStream.read();
                break;
            case ELT_ID_NATIONAL_LANGUAGE_LOCKING_SHIFT:
                smsHeader.languageTable = inStream.read();
                break;
            default:
                MiscElt miscElt = new MiscElt();
                miscElt.id = id;
                miscElt.data = new byte[length];
                inStream.read(miscElt.data, 0, length);
                smsHeader.miscEltList.add(miscElt);
            }
        }
        return smsHeader;
    }

    /**
     * Create serialized byte array representation from structured SmsHeader object.
     * (see TS 23.040 9.2.3.24)
     * @return Byte array representing the SmsHeader
     */
    @DSSink({DSSinkKind.SMS_MMS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.713 -0500", hash_original_method = "313D7507D012D5A754A21F769BA1BB3D", hash_generated_method = "E61F57DB8C58E56E795CC1C73527316C")
    
public static byte[] toByteArray(SmsHeader smsHeader) {
        if ((smsHeader.portAddrs == null) &&
            (smsHeader.concatRef == null) &&
            (smsHeader.miscEltList.isEmpty()) &&
            (smsHeader.languageShiftTable == 0) &&
            (smsHeader.languageTable == 0)) {
            return null;
        }

        ByteArrayOutputStream outStream = new ByteArrayOutputStream(SmsMessage.MAX_USER_DATA_BYTES);
        ConcatRef concatRef = smsHeader.concatRef;
        if (concatRef != null) {
            if (concatRef.isEightBits) {
                outStream.write(ELT_ID_CONCATENATED_8_BIT_REFERENCE);
                outStream.write(3);
                outStream.write(concatRef.refNumber);
            } else {
                outStream.write(ELT_ID_CONCATENATED_16_BIT_REFERENCE);
                outStream.write(4);
                outStream.write(concatRef.refNumber >>> 8);
                outStream.write(concatRef.refNumber & 0x00FF);
            }
            outStream.write(concatRef.msgCount);
            outStream.write(concatRef.seqNumber);
        }
        PortAddrs portAddrs = smsHeader.portAddrs;
        if (portAddrs != null) {
            if (portAddrs.areEightBits) {
                outStream.write(ELT_ID_APPLICATION_PORT_ADDRESSING_8_BIT);
                outStream.write(2);
                outStream.write(portAddrs.destPort);
                outStream.write(portAddrs.origPort);
            } else {
                outStream.write(ELT_ID_APPLICATION_PORT_ADDRESSING_16_BIT);
                outStream.write(4);
                outStream.write(portAddrs.destPort >>> 8);
                outStream.write(portAddrs.destPort & 0x00FF);
                outStream.write(portAddrs.origPort >>> 8);
                outStream.write(portAddrs.origPort & 0x00FF);
            }
        }
        if (smsHeader.languageShiftTable != 0) {
            outStream.write(ELT_ID_NATIONAL_LANGUAGE_SINGLE_SHIFT);
            outStream.write(1);
            outStream.write(smsHeader.languageShiftTable);
        }
        if (smsHeader.languageTable != 0) {
            outStream.write(ELT_ID_NATIONAL_LANGUAGE_LOCKING_SHIFT);
            outStream.write(1);
            outStream.write(smsHeader.languageTable);
        }
        for (MiscElt miscElt : smsHeader.miscEltList) {
            outStream.write(miscElt.id);
            outStream.write(miscElt.data.length);
            outStream.write(miscElt.data, 0, miscElt.data.length);
        }
        return outStream.toByteArray();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.573 -0500", hash_original_field = "79632825537A506154F6BE1D85B0F6E3", hash_generated_field = "6775361BD35A11211733036CA99BBA20")

    // the 'user data header' or UDH, and so the class name should
    // change to reflect this...

    /** SMS user data header information element identifiers.
     * (see TS 23.040 9.2.3.24)
     */
    public static final int ELT_ID_CONCATENATED_8_BIT_REFERENCE       = 0x00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.576 -0500", hash_original_field = "F9DE742E3FDAEACC213FB3F7FBED5322", hash_generated_field = "FBFB92D0243EAB49620E1E3BA5778CCD")

    public static final int ELT_ID_SPECIAL_SMS_MESSAGE_INDICATION     = 0x01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.579 -0500", hash_original_field = "24CDCA54DC42ED177E563D1DF4102B72", hash_generated_field = "1894BD6AF25C23B0E936D46DA1334E87")

    public static final int ELT_ID_APPLICATION_PORT_ADDRESSING_8_BIT  = 0x04;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.582 -0500", hash_original_field = "2CF98C063CDF131D6A757C4807B1C35F", hash_generated_field = "7E7C93251835783460CDD69A9FB11B55")

    public static final int ELT_ID_APPLICATION_PORT_ADDRESSING_16_BIT = 0x05;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.584 -0500", hash_original_field = "010D99014511F770EBCF547E468552E2", hash_generated_field = "3C8E2DD00C01B364AFE669BF55EA9B89")

    public static final int ELT_ID_SMSC_CONTROL_PARAMS                = 0x06;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.587 -0500", hash_original_field = "D6DF9EB26248E4683B876299FEBC332F", hash_generated_field = "078EABC29A6EB0810ACB37F1EECFF908")

    public static final int ELT_ID_UDH_SOURCE_INDICATION              = 0x07;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.589 -0500", hash_original_field = "7B1D5B8C1D5F2D3998760DFE447F2C72", hash_generated_field = "F313A88EAB2289D6E0271B9984D256C7")

    public static final int ELT_ID_CONCATENATED_16_BIT_REFERENCE      = 0x08;
    
    public static class PortAddrs {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.663 -0500", hash_original_field = "43FCC01AB1C7BC09F803AB811B014379", hash_generated_field = "7506CCEE3F7162FA4E3689CDC6299EE7")

        public int destPort;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.666 -0500", hash_original_field = "E24557E0BEB86C5F7BCA47DF704186A3", hash_generated_field = "07B62AB65B7441D9B17362F47CDB1661")

        public int origPort;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.668 -0500", hash_original_field = "31DDB23B0C27F66C0965BEE45732EBC0", hash_generated_field = "729FCB4410050627C3231CE24B84A18D")

        public boolean areEightBits;
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.190 -0400", hash_original_method = "0146EA7913C9A86565770A69E4015B6C", hash_generated_method = "0146EA7913C9A86565770A69E4015B6C")
        public PortAddrs ()
        {
            //Synthesized constructor
        }

    }
    
    public static class ConcatRef {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.674 -0500", hash_original_field = "F13A17E3B9DD4A115850D7E283D9B422", hash_generated_field = "0F3B72757D76773A83926AA1D0D28751")

        public int refNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.676 -0500", hash_original_field = "D525C5A2731D5988B0B65F7C9B5CF1F9", hash_generated_field = "F5BEDE838A9C2FB7F48E91CAB37401CE")

        public int seqNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.678 -0500", hash_original_field = "5643CD0ED1899D5B0898562BD627FF70", hash_generated_field = "0251AE8A4048E6E755DB65AA050EB95C")

        public int msgCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.681 -0500", hash_original_field = "A31E42DFABD5F5F4419F27ECD6281FC4", hash_generated_field = "B33BB2AAEE6C2694EBA1E2C233DF4174")

        public boolean isEightBits;
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.190 -0400", hash_original_method = "F12AD75E9E03099DD407C7814D08C2E0", hash_generated_method = "F12AD75E9E03099DD407C7814D08C2E0")
        public ConcatRef ()
        {
            //Synthesized constructor
        }

    }
    
    public static class MiscElt {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.686 -0500", hash_original_field = "53E65FEF28E32C7EDCD1B07B4F5A0DE3", hash_generated_field = "FA0A3841DE31A9B4AD2F31B3665056D8")

        public int id;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.688 -0500", hash_original_field = "B330DF564CD90A5498A9E4F0AB344BB9", hash_generated_field = "F02DD38BDDF66ED8369494A65A3A6765")

        public byte[] data;
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.191 -0400", hash_original_method = "424479238E621C77A92D33EDE0B97D13", hash_generated_method = "424479238E621C77A92D33EDE0B97D13")
        public MiscElt ()
        {
            //Synthesized constructor
        }

    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.592 -0500", hash_original_field = "C1AC89308DE25D85744755DF37A77351", hash_generated_field = "D734490B86FA530D366AF47A730DBC68")

    public static final int ELT_ID_WIRELESS_CTRL_MSG_PROTOCOL         = 0x09;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.595 -0500", hash_original_field = "5D399B2F4E2A98EAC2F6EE179C129970", hash_generated_field = "436140762DF7B6C47A63C1C884993B15")

    public static final int ELT_ID_TEXT_FORMATTING                    = 0x0A;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.598 -0500", hash_original_field = "EE48EA0D1E88C632176A64AB9D0FFE59", hash_generated_field = "4EE66C9A49AB40AE60B9816E224BFAE8")

    public static final int ELT_ID_PREDEFINED_SOUND                   = 0x0B;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.601 -0500", hash_original_field = "160BDA42204C9E8BE7344F9EB55554B2", hash_generated_field = "7F5DC13F66A5FA829919F458E7A8FA06")

    public static final int ELT_ID_USER_DEFINED_SOUND                 = 0x0C;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.604 -0500", hash_original_field = "BEC4F948BAF7B943481FBB6ECC237116", hash_generated_field = "549DC51CB4A70929F07713EB394CA415")

    public static final int ELT_ID_PREDEFINED_ANIMATION               = 0x0D;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.606 -0500", hash_original_field = "D786963473E5A3AA5A0C187E60BB79BC", hash_generated_field = "5153C325DDA958A2C07B3F04189C055C")

    public static final int ELT_ID_LARGE_ANIMATION                    = 0x0E;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.609 -0500", hash_original_field = "F15BA9F1D5CF1421D291AD9DEE8FA32D", hash_generated_field = "3D4927510DE1AA70409668629C4C218F")

    public static final int ELT_ID_SMALL_ANIMATION                    = 0x0F;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.612 -0500", hash_original_field = "CC065EC65898F39C38AEE95AAFD67CE5", hash_generated_field = "0478E11D6366934420227897FF0259E3")

    public static final int ELT_ID_LARGE_PICTURE                      = 0x10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.614 -0500", hash_original_field = "796EE4863502AE63132C603D12B1BBDD", hash_generated_field = "872FD5FD66005D21DABAEC49B6004278")

    public static final int ELT_ID_SMALL_PICTURE                      = 0x11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.617 -0500", hash_original_field = "D52F8DFB4DC4E469D900E1FC6709F4D8", hash_generated_field = "1A88005590CD9B5C9CE159140FADB5EE")

    public static final int ELT_ID_VARIABLE_PICTURE                   = 0x12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.619 -0500", hash_original_field = "5E0B16592E89BDEB47D73990585C518D", hash_generated_field = "15D9468ADA90FB35960E3B6BCEB6053F")

    public static final int ELT_ID_USER_PROMPT_INDICATOR              = 0x13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.622 -0500", hash_original_field = "7AC92279752E1024A17C2CD8ED7D8619", hash_generated_field = "68CAD4224C496B3D98F79B9BA3B1E1F5")

    public static final int ELT_ID_EXTENDED_OBJECT                    = 0x14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.625 -0500", hash_original_field = "7C6FFF8843D08AF2B3CA4D768D55F43F", hash_generated_field = "50F4CB7991EBAE514BE9E9476D2DBFED")

    public static final int ELT_ID_REUSED_EXTENDED_OBJECT             = 0x15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.628 -0500", hash_original_field = "8A5111C4ED61B7AA9374F61FEE7B7B0A", hash_generated_field = "E7183113D4CEBD305DA0C606EA4B5F2D")

    public static final int ELT_ID_COMPRESSION_CONTROL                = 0x16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.630 -0500", hash_original_field = "FF522436D2F46298AB31C2C0DC92841A", hash_generated_field = "B46A3C0F351F54E5367F2E0E3B07FE78")

    public static final int ELT_ID_OBJECT_DISTR_INDICATOR             = 0x17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.633 -0500", hash_original_field = "B298326B11F17D913E41F68387A92A74", hash_generated_field = "15CFC448EF0719E2ED28922684C41647")

    public static final int ELT_ID_STANDARD_WVG_OBJECT                = 0x18;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.636 -0500", hash_original_field = "5EF45912D1EF3056DB8168712E2D5987", hash_generated_field = "446C37477DCC7D96FF49317DB0BB4DEB")

    public static final int ELT_ID_CHARACTER_SIZE_WVG_OBJECT          = 0x19;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.638 -0500", hash_original_field = "7F5F9323B2308CC8610893544B68F466", hash_generated_field = "1708BCF962B245965A7DEC0EFB175472")

    public static final int ELT_ID_EXTENDED_OBJECT_DATA_REQUEST_CMD   = 0x1A;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.641 -0500", hash_original_field = "89958354C73A2778DD1E5E507E6C468A", hash_generated_field = "70CE14BE7C891FDE559F8729686EB710")

    public static final int ELT_ID_RFC_822_EMAIL_HEADER               = 0x20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.644 -0500", hash_original_field = "1EA94A920FA89D5883038B2D4C167991", hash_generated_field = "AA88AC8455D5AC37E7749724AAC6D8F5")

    public static final int ELT_ID_HYPERLINK_FORMAT_ELEMENT           = 0x21;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.647 -0500", hash_original_field = "B6CF12B3BD8996065BEC7D5F8C7CBA97", hash_generated_field = "934B72C2CF68EF370CEC10457BB93F87")

    public static final int ELT_ID_REPLY_ADDRESS_ELEMENT              = 0x22;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.649 -0500", hash_original_field = "31EFB009B0B81305352A9B62CE615DF7", hash_generated_field = "DC097D5AEBC0AEE5866BBD0A12ABF24C")

    public static final int ELT_ID_ENHANCED_VOICE_MAIL_INFORMATION    = 0x23;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.652 -0500", hash_original_field = "C6C0C2EFC4145BDCC7FFB32AFC70A63A", hash_generated_field = "BF85B023EB9BE6EFE5106ADB8E293C48")

    public static final int ELT_ID_NATIONAL_LANGUAGE_SINGLE_SHIFT     = 0x24;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.655 -0500", hash_original_field = "412B2B4073F46208D7DA19CDDAF46141", hash_generated_field = "C413A845D2100BFEC3D2613AA15622E6")

    public static final int ELT_ID_NATIONAL_LANGUAGE_LOCKING_SHIFT    = 0x25;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.657 -0500", hash_original_field = "9CE4C752A0B869515C51123B0B606E4A", hash_generated_field = "1A4B7B65D84026CF96E6BD6C16BF0C96")

    public static final int PORT_WAP_PUSH = 2948;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.660 -0500", hash_original_field = "312F2D1EA519BF905EC1FA8EF0474710", hash_generated_field = "7583F19EAB9670A3C7D501902942DB47")

    public static final int PORT_WAP_WSP  = 9200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.693 -0500", hash_original_field = "94F4C6A293B020B0E5BB3BA2A20D75C0", hash_generated_field = "05ED881ED743F115A7BFB64944720FFD")

    public PortAddrs portAddrs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.695 -0500", hash_original_field = "2DACEBF93B41EE0C8647D149EEE42E35", hash_generated_field = "EBCF5775C5867B0A4E4F7B6AA225F299")

    public ConcatRef concatRef;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.697 -0500", hash_original_field = "7858E559393E9F45CBAB074BDD28F8B8", hash_generated_field = "814B4FF65F8154136005C0814930E2CF")

    public ArrayList<MiscElt> miscEltList = new ArrayList<MiscElt>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.700 -0500", hash_original_field = "EB04DC0F9D823ECDE8E8EC505F04F3D2", hash_generated_field = "3EBE9A5056219E00E65F8C29210512F1")

    public int languageTable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.702 -0500", hash_original_field = "51586E6521B2F7C2D483B8605CB8B4F6", hash_generated_field = "35E03F3700F4C29377F021AC1C80EBE5")

    public int languageShiftTable;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.705 -0500", hash_original_method = "F06BD280EA34997B1794CB44E7D9D16A", hash_generated_method = "20434C5602DDE5E1F119335782D90E72")
    
public SmsHeader() {}

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:37.717 -0500", hash_original_method = "3B501A432F153619ABA258E9F603F65E", hash_generated_method = "A70A906DA2583C1C28BD7D300E931087")
    
@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserDataHeader ");
        builder.append("{ ConcatRef ");
        if (concatRef == null) {
            builder.append("unset");
        } else {
            builder.append("{ refNumber=" + concatRef.refNumber);
            builder.append(", msgCount=" + concatRef.msgCount);
            builder.append(", seqNumber=" + concatRef.seqNumber);
            builder.append(", isEightBits=" + concatRef.isEightBits);
            builder.append(" }");
        }
        builder.append(", PortAddrs ");
        if (portAddrs == null) {
            builder.append("unset");
        } else {
            builder.append("{ destPort=" + portAddrs.destPort);
            builder.append(", origPort=" + portAddrs.origPort);
            builder.append(", areEightBits=" + portAddrs.areEightBits);
            builder.append(" }");
        }
        if (languageShiftTable != 0) {
            builder.append(", languageShiftTable=" + languageShiftTable);
        }
        if (languageTable != 0) {
            builder.append(", languageTable=" + languageTable);
        }
        for (MiscElt miscElt : miscEltList) {
            builder.append(", MiscElt ");
            builder.append("{ id=" + miscElt.id);
            builder.append(", length=" + miscElt.data.length);
            builder.append(", data=" + HexDump.toHexString(miscElt.data));
            builder.append(" }");
        }
        builder.append(" }");
        return builder.toString();
    }
}

