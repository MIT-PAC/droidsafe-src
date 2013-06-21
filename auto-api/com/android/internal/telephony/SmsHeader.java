package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.telephony.SmsMessage;
import com.android.internal.util.HexDump;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class SmsHeader {
    public PortAddrs portAddrs;
    public ConcatRef concatRef;
    public ArrayList<MiscElt> miscEltList = new ArrayList<MiscElt>();
    public int languageTable;
    public int languageShiftTable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.447 -0400", hash_original_method = "F06BD280EA34997B1794CB44E7D9D16A", hash_generated_method = "EBF9FF6335726A7119DA9BD07425785D")
    @DSModeled(DSC.SAFE)
    public SmsHeader() {
        // ---------- Original Method ----------
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.474 -0400", hash_original_method = "3B501A432F153619ABA258E9F603F65E", hash_generated_method = "6185035E11E358F2751DC34A2ACF3F12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder builder;
        builder = new StringBuilder();
        builder.append("UserDataHeader ");
        builder.append("{ ConcatRef ");
        {
            builder.append("unset");
        } //End block
        {
            builder.append("{ refNumber=" + concatRef.refNumber);
            builder.append(", msgCount=" + concatRef.msgCount);
            builder.append(", seqNumber=" + concatRef.seqNumber);
            builder.append(", isEightBits=" + concatRef.isEightBits);
            builder.append(" }");
        } //End block
        builder.append(", PortAddrs ");
        {
            builder.append("unset");
        } //End block
        {
            builder.append("{ destPort=" + portAddrs.destPort);
            builder.append(", origPort=" + portAddrs.origPort);
            builder.append(", areEightBits=" + portAddrs.areEightBits);
            builder.append(" }");
        } //End block
        {
            builder.append(", languageShiftTable=" + languageShiftTable);
        } //End block
        {
            builder.append(", languageTable=" + languageTable);
        } //End block
        {
            Iterator<MiscElt> var37918556E8645AADA45026E0287225E4_1179575514 = (miscEltList).iterator();
            var37918556E8645AADA45026E0287225E4_1179575514.hasNext();
            MiscElt miscElt = var37918556E8645AADA45026E0287225E4_1179575514.next();
            {
                builder.append(", MiscElt ");
                builder.append("{ id=" + miscElt.id);
                builder.append(", length=" + miscElt.data.length);
                builder.append(", data=" + HexDump.toHexString(miscElt.data));
                builder.append(" }");
            } //End block
        } //End collapsed parenthetic
        builder.append(" }");
        String var687AAF24B90629C9BFCFE9608FDCE6E7_1418299756 = (builder.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static class PortAddrs {
        public int destPort;
        public int origPort;
        public boolean areEightBits;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.474 -0400", hash_original_method = "0B312E7ECF151C35388E05EE60DB7DD4", hash_generated_method = "0B312E7ECF151C35388E05EE60DB7DD4")
                public PortAddrs ()
        {
        }


    }


    
    public static class ConcatRef {
        public int refNumber;
        public int seqNumber;
        public int msgCount;
        public boolean isEightBits;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.474 -0400", hash_original_method = "0786A43A61BEA5172FDB7BF22105EF29", hash_generated_method = "0786A43A61BEA5172FDB7BF22105EF29")
                public ConcatRef ()
        {
        }


    }


    
    public static class MiscElt {
        public int id;
        public byte[] data;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.474 -0400", hash_original_method = "61D293152108B49002664927DFA39B7E", hash_generated_method = "61D293152108B49002664927DFA39B7E")
                public MiscElt ()
        {
        }


    }


    
    public static final int ELT_ID_CONCATENATED_8_BIT_REFERENCE       = 0x00;
    public static final int ELT_ID_SPECIAL_SMS_MESSAGE_INDICATION     = 0x01;
    public static final int ELT_ID_APPLICATION_PORT_ADDRESSING_8_BIT  = 0x04;
    public static final int ELT_ID_APPLICATION_PORT_ADDRESSING_16_BIT = 0x05;
    public static final int ELT_ID_SMSC_CONTROL_PARAMS                = 0x06;
    public static final int ELT_ID_UDH_SOURCE_INDICATION              = 0x07;
    public static final int ELT_ID_CONCATENATED_16_BIT_REFERENCE      = 0x08;
    public static final int ELT_ID_WIRELESS_CTRL_MSG_PROTOCOL         = 0x09;
    public static final int ELT_ID_TEXT_FORMATTING                    = 0x0A;
    public static final int ELT_ID_PREDEFINED_SOUND                   = 0x0B;
    public static final int ELT_ID_USER_DEFINED_SOUND                 = 0x0C;
    public static final int ELT_ID_PREDEFINED_ANIMATION               = 0x0D;
    public static final int ELT_ID_LARGE_ANIMATION                    = 0x0E;
    public static final int ELT_ID_SMALL_ANIMATION                    = 0x0F;
    public static final int ELT_ID_LARGE_PICTURE                      = 0x10;
    public static final int ELT_ID_SMALL_PICTURE                      = 0x11;
    public static final int ELT_ID_VARIABLE_PICTURE                   = 0x12;
    public static final int ELT_ID_USER_PROMPT_INDICATOR              = 0x13;
    public static final int ELT_ID_EXTENDED_OBJECT                    = 0x14;
    public static final int ELT_ID_REUSED_EXTENDED_OBJECT             = 0x15;
    public static final int ELT_ID_COMPRESSION_CONTROL                = 0x16;
    public static final int ELT_ID_OBJECT_DISTR_INDICATOR             = 0x17;
    public static final int ELT_ID_STANDARD_WVG_OBJECT                = 0x18;
    public static final int ELT_ID_CHARACTER_SIZE_WVG_OBJECT          = 0x19;
    public static final int ELT_ID_EXTENDED_OBJECT_DATA_REQUEST_CMD   = 0x1A;
    public static final int ELT_ID_RFC_822_EMAIL_HEADER               = 0x20;
    public static final int ELT_ID_HYPERLINK_FORMAT_ELEMENT           = 0x21;
    public static final int ELT_ID_REPLY_ADDRESS_ELEMENT              = 0x22;
    public static final int ELT_ID_ENHANCED_VOICE_MAIL_INFORMATION    = 0x23;
    public static final int ELT_ID_NATIONAL_LANGUAGE_SINGLE_SHIFT     = 0x24;
    public static final int ELT_ID_NATIONAL_LANGUAGE_LOCKING_SHIFT    = 0x25;
    public static final int PORT_WAP_PUSH = 2948;
    public static final int PORT_WAP_WSP  = 9200;
}

