package com.android.internal.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.telephony.SmsMessage;
import com.android.internal.util.HexDump;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class SmsHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.440 -0400", hash_original_field = "0BF6DB71DA27A10BD429DE23DFC110F3", hash_generated_field = "05ED881ED743F115A7BFB64944720FFD")

    public PortAddrs portAddrs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.440 -0400", hash_original_field = "F3B9334CA04B0DBC371A7E1830FFB0CF", hash_generated_field = "EBCF5775C5867B0A4E4F7B6AA225F299")

    public ConcatRef concatRef;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.440 -0400", hash_original_field = "4277AB35BE7A7688D5BD5B0726223941", hash_generated_field = "814B4FF65F8154136005C0814930E2CF")

    public ArrayList<MiscElt> miscEltList = new ArrayList<MiscElt>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.440 -0400", hash_original_field = "B7785329B01021D25A3839E1068301ED", hash_generated_field = "3EBE9A5056219E00E65F8C29210512F1")

    public int languageTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.440 -0400", hash_original_field = "DE31467D92F70B33D61FA7B2C3DD7E3F", hash_generated_field = "35E03F3700F4C29377F021AC1C80EBE5")

    public int languageShiftTable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.440 -0400", hash_original_method = "F06BD280EA34997B1794CB44E7D9D16A", hash_generated_method = "EBF9FF6335726A7119DA9BD07425785D")
    public  SmsHeader() {
        
    }

    
        public static SmsHeader fromByteArray(byte[] data) {
        ByteArrayInputStream inStream = new ByteArrayInputStream(data);
        SmsHeader smsHeader = new SmsHeader();
        while (inStream.available() > 0) {
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.442 -0400", hash_original_method = "3B501A432F153619ABA258E9F603F65E", hash_generated_method = "21C5A00987745231BDE1498BF3228BA7")
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserDataHeader ");
        builder.append("{ ConcatRef ");
    if(concatRef == null)        
        {
            builder.append("unset");
        } 
        else
        {
            builder.append("{ refNumber=" + concatRef.refNumber);
            builder.append(", msgCount=" + concatRef.msgCount);
            builder.append(", seqNumber=" + concatRef.seqNumber);
            builder.append(", isEightBits=" + concatRef.isEightBits);
            builder.append(" }");
        } 
        builder.append(", PortAddrs ");
    if(portAddrs == null)        
        {
            builder.append("unset");
        } 
        else
        {
            builder.append("{ destPort=" + portAddrs.destPort);
            builder.append(", origPort=" + portAddrs.origPort);
            builder.append(", areEightBits=" + portAddrs.areEightBits);
            builder.append(" }");
        } 
    if(languageShiftTable != 0)        
        {
            builder.append(", languageShiftTable=" + languageShiftTable);
        } 
    if(languageTable != 0)        
        {
            builder.append(", languageTable=" + languageTable);
        } 
for(MiscElt miscElt : miscEltList)
        {
            builder.append(", MiscElt ");
            builder.append("{ id=" + miscElt.id);
            builder.append(", length=" + miscElt.data.length);
            builder.append(", data=" + HexDump.toHexString(miscElt.data));
            builder.append(" }");
        } 
        builder.append(" }");
String varF4CF030572656354ACFDF83FEE21D7A6_234489528 =         builder.toString();
        varF4CF030572656354ACFDF83FEE21D7A6_234489528.addTaint(taint);
        return varF4CF030572656354ACFDF83FEE21D7A6_234489528;
        
        
    }

    
    public static class PortAddrs {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.443 -0400", hash_original_field = "913D9EFFE74FBACDB35EDEEF6AA6FDDE", hash_generated_field = "7506CCEE3F7162FA4E3689CDC6299EE7")

        public int destPort;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.443 -0400", hash_original_field = "8E79188EEB5729063C58C1140D1C8BEA", hash_generated_field = "07B62AB65B7441D9B17362F47CDB1661")

        public int origPort;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.443 -0400", hash_original_field = "4B974444E9E6E0107D8352D4732DF827", hash_generated_field = "729FCB4410050627C3231CE24B84A18D")

        public boolean areEightBits;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.443 -0400", hash_original_method = "0146EA7913C9A86565770A69E4015B6C", hash_generated_method = "0146EA7913C9A86565770A69E4015B6C")
        public PortAddrs ()
        {
            
        }


    }


    
    public static class ConcatRef {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.443 -0400", hash_original_field = "E432C175023D50E9CDBF4DE471929173", hash_generated_field = "0F3B72757D76773A83926AA1D0D28751")

        public int refNumber;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.443 -0400", hash_original_field = "8D45A53BCE0BE51DDE4BEC6B41F9889D", hash_generated_field = "F5BEDE838A9C2FB7F48E91CAB37401CE")

        public int seqNumber;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.444 -0400", hash_original_field = "FB6BB8D362A5891D772EE4EBDED02762", hash_generated_field = "0251AE8A4048E6E755DB65AA050EB95C")

        public int msgCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.444 -0400", hash_original_field = "A0DF8EE072C8C446E9C03DFCD7186B77", hash_generated_field = "B33BB2AAEE6C2694EBA1E2C233DF4174")

        public boolean isEightBits;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.444 -0400", hash_original_method = "F12AD75E9E03099DD407C7814D08C2E0", hash_generated_method = "F12AD75E9E03099DD407C7814D08C2E0")
        public ConcatRef ()
        {
            
        }


    }


    
    public static class MiscElt {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.444 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "FA0A3841DE31A9B4AD2F31B3665056D8")

        public int id;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.444 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "F02DD38BDDF66ED8369494A65A3A6765")

        public byte[] data;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.444 -0400", hash_original_method = "424479238E621C77A92D33EDE0B97D13", hash_generated_method = "424479238E621C77A92D33EDE0B97D13")
        public MiscElt ()
        {
            
        }


    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.444 -0400", hash_original_field = "156C17975D9E1390A055177FF32CC7C1", hash_generated_field = "24E7B45A5D72C70CB2D2922762CB7ACD")

    public static final int ELT_ID_CONCATENATED_8_BIT_REFERENCE       = 0x00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.444 -0400", hash_original_field = "FD59AE9E4788A2180694EF30DA2CC541", hash_generated_field = "FBFB92D0243EAB49620E1E3BA5778CCD")

    public static final int ELT_ID_SPECIAL_SMS_MESSAGE_INDICATION     = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.444 -0400", hash_original_field = "6BFC6AA829476B6AF5797FAC3491C62C", hash_generated_field = "1894BD6AF25C23B0E936D46DA1334E87")

    public static final int ELT_ID_APPLICATION_PORT_ADDRESSING_8_BIT  = 0x04;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.444 -0400", hash_original_field = "3C8816202A31E93E7078B949877F96FC", hash_generated_field = "7E7C93251835783460CDD69A9FB11B55")

    public static final int ELT_ID_APPLICATION_PORT_ADDRESSING_16_BIT = 0x05;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.444 -0400", hash_original_field = "EFAAE62E3052C5128D9A0DD99DCA9DDD", hash_generated_field = "3C8E2DD00C01B364AFE669BF55EA9B89")

    public static final int ELT_ID_SMSC_CONTROL_PARAMS                = 0x06;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.444 -0400", hash_original_field = "9F7D15E0934812C8E637FCF94E26C7DA", hash_generated_field = "078EABC29A6EB0810ACB37F1EECFF908")

    public static final int ELT_ID_UDH_SOURCE_INDICATION              = 0x07;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.444 -0400", hash_original_field = "94E02CF9DF23120406EB60E4DE0B21DA", hash_generated_field = "F313A88EAB2289D6E0271B9984D256C7")

    public static final int ELT_ID_CONCATENATED_16_BIT_REFERENCE      = 0x08;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.445 -0400", hash_original_field = "E1FAD20E27F29C5B8817A6F6B047FE7F", hash_generated_field = "D734490B86FA530D366AF47A730DBC68")

    public static final int ELT_ID_WIRELESS_CTRL_MSG_PROTOCOL         = 0x09;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.445 -0400", hash_original_field = "1D368E0D3386623201A5C0808590F0EE", hash_generated_field = "436140762DF7B6C47A63C1C884993B15")

    public static final int ELT_ID_TEXT_FORMATTING                    = 0x0A;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.445 -0400", hash_original_field = "6F0A93B2CCC49E1B1ADE1B5C675562C8", hash_generated_field = "4EE66C9A49AB40AE60B9816E224BFAE8")

    public static final int ELT_ID_PREDEFINED_SOUND                   = 0x0B;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.445 -0400", hash_original_field = "736E3A147AD1B90A018A53BE12330280", hash_generated_field = "7F5DC13F66A5FA829919F458E7A8FA06")

    public static final int ELT_ID_USER_DEFINED_SOUND                 = 0x0C;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.445 -0400", hash_original_field = "5773B19E443F98FAD78F77EE8966A120", hash_generated_field = "549DC51CB4A70929F07713EB394CA415")

    public static final int ELT_ID_PREDEFINED_ANIMATION               = 0x0D;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.445 -0400", hash_original_field = "DBD6927646D8F07EA54F707576726EC9", hash_generated_field = "5153C325DDA958A2C07B3F04189C055C")

    public static final int ELT_ID_LARGE_ANIMATION                    = 0x0E;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.445 -0400", hash_original_field = "462E3FA2EED222FA1233223F11E86B13", hash_generated_field = "3D4927510DE1AA70409668629C4C218F")

    public static final int ELT_ID_SMALL_ANIMATION                    = 0x0F;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.445 -0400", hash_original_field = "7B8C7719C4D88666C9DDD7E637B053BB", hash_generated_field = "0478E11D6366934420227897FF0259E3")

    public static final int ELT_ID_LARGE_PICTURE                      = 0x10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.445 -0400", hash_original_field = "F86AA62A2F1DA6244021EE26A7289438", hash_generated_field = "872FD5FD66005D21DABAEC49B6004278")

    public static final int ELT_ID_SMALL_PICTURE                      = 0x11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.445 -0400", hash_original_field = "CCCC22CBD0EBAC95B037DAD0D070325B", hash_generated_field = "1A88005590CD9B5C9CE159140FADB5EE")

    public static final int ELT_ID_VARIABLE_PICTURE                   = 0x12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.445 -0400", hash_original_field = "ADB17039C76CFDDFBD6397EBE6EF8236", hash_generated_field = "15D9468ADA90FB35960E3B6BCEB6053F")

    public static final int ELT_ID_USER_PROMPT_INDICATOR              = 0x13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.445 -0400", hash_original_field = "427A76346202C7EF749B5C2FB0A9BC61", hash_generated_field = "68CAD4224C496B3D98F79B9BA3B1E1F5")

    public static final int ELT_ID_EXTENDED_OBJECT                    = 0x14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.445 -0400", hash_original_field = "D17EBC5C67EF52A7E3D789C38DABA42B", hash_generated_field = "50F4CB7991EBAE514BE9E9476D2DBFED")

    public static final int ELT_ID_REUSED_EXTENDED_OBJECT             = 0x15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.445 -0400", hash_original_field = "C8C85A0085AAD9ED7F74B0E2D8D700DE", hash_generated_field = "E7183113D4CEBD305DA0C606EA4B5F2D")

    public static final int ELT_ID_COMPRESSION_CONTROL                = 0x16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.445 -0400", hash_original_field = "F984F8FC55B60D83D4A36EFD0CF3F4FB", hash_generated_field = "B46A3C0F351F54E5367F2E0E3B07FE78")

    public static final int ELT_ID_OBJECT_DISTR_INDICATOR             = 0x17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.445 -0400", hash_original_field = "20705479B50FD105A32BDD5339711A39", hash_generated_field = "15CFC448EF0719E2ED28922684C41647")

    public static final int ELT_ID_STANDARD_WVG_OBJECT                = 0x18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.445 -0400", hash_original_field = "50FE402BCD3F428C503E83EE7BB4CB84", hash_generated_field = "446C37477DCC7D96FF49317DB0BB4DEB")

    public static final int ELT_ID_CHARACTER_SIZE_WVG_OBJECT          = 0x19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.446 -0400", hash_original_field = "F50249D3DDC7F3A12B85A461C5CAE734", hash_generated_field = "1708BCF962B245965A7DEC0EFB175472")

    public static final int ELT_ID_EXTENDED_OBJECT_DATA_REQUEST_CMD   = 0x1A;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.446 -0400", hash_original_field = "8DBF557C800021B30E1295CBE83C9CF5", hash_generated_field = "70CE14BE7C891FDE559F8729686EB710")

    public static final int ELT_ID_RFC_822_EMAIL_HEADER               = 0x20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.446 -0400", hash_original_field = "2BAA381B37EB4EAF2AFEC8C64A297CB4", hash_generated_field = "AA88AC8455D5AC37E7749724AAC6D8F5")

    public static final int ELT_ID_HYPERLINK_FORMAT_ELEMENT           = 0x21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.446 -0400", hash_original_field = "ED2E2D0EB7C7BACE73B84A16BF108711", hash_generated_field = "934B72C2CF68EF370CEC10457BB93F87")

    public static final int ELT_ID_REPLY_ADDRESS_ELEMENT              = 0x22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.446 -0400", hash_original_field = "8B8250D85294591E4F66D47499F9932E", hash_generated_field = "DC097D5AEBC0AEE5866BBD0A12ABF24C")

    public static final int ELT_ID_ENHANCED_VOICE_MAIL_INFORMATION    = 0x23;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.446 -0400", hash_original_field = "594E52A6F515C05680C5CD2ED80B5379", hash_generated_field = "BF85B023EB9BE6EFE5106ADB8E293C48")

    public static final int ELT_ID_NATIONAL_LANGUAGE_SINGLE_SHIFT     = 0x24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.446 -0400", hash_original_field = "B63823B9BEA7EBAFAC8CDF67CBEEA704", hash_generated_field = "C413A845D2100BFEC3D2613AA15622E6")

    public static final int ELT_ID_NATIONAL_LANGUAGE_LOCKING_SHIFT    = 0x25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.446 -0400", hash_original_field = "2F4C47538195D333E5818C4E2E10FA49", hash_generated_field = "1A4B7B65D84026CF96E6BD6C16BF0C96")

    public static final int PORT_WAP_PUSH = 2948;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.446 -0400", hash_original_field = "BF852AA1896B70B32ED78D1A7F895858", hash_generated_field = "7583F19EAB9670A3C7D501902942DB47")

    public static final int PORT_WAP_WSP  = 9200;
}

