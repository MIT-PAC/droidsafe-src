package com.android.internal.telephony.cdma.sms;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.SparseIntArray;
import com.android.internal.telephony.SmsHeader;
import com.android.internal.util.HexDump;

public class UserData {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.906 -0400", hash_original_field = "743D61CD0F8B499FFB5961C09D48393C", hash_generated_field = "1EA01C87D6AD02FA32C000798DFDC94E")

    public SmsHeader userDataHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.906 -0400", hash_original_field = "FD64E7FD0FA8FBADE1027596FFBF437C", hash_generated_field = "3554CFCCD59683AEDE92C6222AE2FA46")

    public int msgEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.906 -0400", hash_original_field = "62F34BA54F4E0C6AE52701BCD66DCF2A", hash_generated_field = "90F67D4EBD7007BE298A8A19FC5C19EA")

    public boolean msgEncodingSet = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.906 -0400", hash_original_field = "1E03BD3847301602E30C6B1964D0A5C1", hash_generated_field = "E888D55A5AA03C238E18CFE2D68CBBFF")

    public int msgType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.906 -0400", hash_original_field = "DE907A3BB3F7559AEFF7AEF45AD9E35B", hash_generated_field = "867C58A538EC8BA6F8BCCFF77F42BD57")

    public int paddingBits;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.906 -0400", hash_original_field = "5534FC955E8CA5176093CC67754FDC4B", hash_generated_field = "AAAC31C5909C6EB96CBCAA6BFC1DD04F")

    public int numFields;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.907 -0400", hash_original_field = "321C3CF486ED509164EDEC1E1981FEC8", hash_generated_field = "85C99161735D908FB014CA702C49895B")

    public byte[] payload;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.907 -0400", hash_original_field = "30A67428369694EB6CCAD88E3B4F5FA5", hash_generated_field = "3651705D811FD56278B4863F6101E60B")

    public String payloadStr;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.907 -0400", hash_original_method = "09164C91BCB463A1239D064C926A7134", hash_generated_method = "09164C91BCB463A1239D064C926A7134")
    public UserData ()
    {
        //Synthesized constructor
    }


    public static byte[] stringToAscii(String str) {
        int len = str.length();
        byte[] result = new byte[len];
        for (int i = 0; i < len; i++) {
            int charCode = charToAscii.get(str.charAt(i), -1);
            if (charCode == -1) return null;
            result[i] = (byte)charCode;
        }
        return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.907 -0400", hash_original_method = "F1C0D00F51384BB453814F967BB3AF69", hash_generated_method = "7430BB52B9D8805A770A3105F61E2AB5")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_182479142 = null; //Variable for return #1
        StringBuilder builder = new StringBuilder();
        builder.append("UserData ");
        builder.append("{ msgEncoding=" + (msgEncodingSet ? msgEncoding : "unset"));
        builder.append(", msgType=" + msgType);
        builder.append(", paddingBits=" + paddingBits);
        builder.append(", numFields=" + numFields);
        builder.append(", userDataHeader=" + userDataHeader);
        builder.append(", payload='" + HexDump.toHexString(payload) + "'");
        builder.append(", payloadStr='" + payloadStr + "'");
        builder.append(" }");
        varB4EAC82CA7396A68D541C85D26508E83_182479142 = builder.toString();
        varB4EAC82CA7396A68D541C85D26508E83_182479142.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_182479142;
        // ---------- Original Method ----------
        //StringBuilder builder = new StringBuilder();
        //builder.append("UserData ");
        //builder.append("{ msgEncoding=" + (msgEncodingSet ? msgEncoding : "unset"));
        //builder.append(", msgType=" + msgType);
        //builder.append(", paddingBits=" + paddingBits);
        //builder.append(", numFields=" + numFields);
        //builder.append(", userDataHeader=" + userDataHeader);
        //builder.append(", payload='" + HexDump.toHexString(payload) + "'");
        //builder.append(", payloadStr='" + payloadStr + "'");
        //builder.append(" }");
        //return builder.toString();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.907 -0400", hash_original_field = "68DF16ACA598304254E828732EC5CFAA", hash_generated_field = "6EFED19D30358C18169106603C5D0B76")

    public static final int ENCODING_OCTET                      = 0x00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.907 -0400", hash_original_field = "9DC7A6D78D189080E036E92D1820FB45", hash_generated_field = "36DF405A391B784B355D3FD26988ABC2")

    public static final int ENCODING_IS91_EXTENDED_PROTOCOL     = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.908 -0400", hash_original_field = "844B3914B1180CDC3B642F6BDD6C8C31", hash_generated_field = "85F0428C1915A59F21B1AE22FFAD7235")

    public static final int ENCODING_7BIT_ASCII                 = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.908 -0400", hash_original_field = "62AB538D9B5B28176553229600C64277", hash_generated_field = "0799D38D3CE4A953468A4699DB702357")

    public static final int ENCODING_IA5                        = 0x03;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.908 -0400", hash_original_field = "F9B61EAA7F47508618CA66B62B1D37C3", hash_generated_field = "2D9DB96F0E64A54F2FBFA223F53D6C48")

    public static final int ENCODING_UNICODE_16                 = 0x04;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.908 -0400", hash_original_field = "CE535BC6A882309D6951E5361AF4973F", hash_generated_field = "DDBCE45766819BE03A7F84B6B2EE0A88")

    public static final int ENCODING_LATIN                      = 0x08;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.908 -0400", hash_original_field = "E5F9AD97AB3B474B08F16BAB369BFD84", hash_generated_field = "2AE5B485EFEAE9DC1A522969C3CB6D01")

    public static final int ENCODING_GSM_7BIT_ALPHABET          = 0x09;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.908 -0400", hash_original_field = "23A103C87AD87509655C4D6207B840DE", hash_generated_field = "F48F55257C8D6A78BE9A1AC7D1803BBD")

    public static final int ENCODING_GSM_DCS                    = 0x0A;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.908 -0400", hash_original_field = "720321A46D14585125A0BCC98323C8AD", hash_generated_field = "5DF0A8AA41B72A7A9812BDA339BC753C")

    public static final int IS91_MSG_TYPE_VOICEMAIL_STATUS   = 0x82;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.908 -0400", hash_original_field = "10C865C2166000EE4F6D7B35B92B186A", hash_generated_field = "5888B89A1AE9C3C22755C91C51E6AA50")

    public static final int IS91_MSG_TYPE_SHORT_MESSAGE_FULL = 0x83;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.908 -0400", hash_original_field = "0BF83372D51BE992F8E3BBBBD71682C7", hash_generated_field = "93AA543DB6F5346E84D1153F9821EB62")

    public static final int IS91_MSG_TYPE_CLI                = 0x84;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.908 -0400", hash_original_field = "C42D116AFC79561CAC71B831333CDF9D", hash_generated_field = "1826D389E921EA18510D1B3FBF612CC7")

    public static final int IS91_MSG_TYPE_SHORT_MESSAGE      = 0x85;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.908 -0400", hash_original_field = "73E86CD3BFE210C2E283AC835969410B", hash_generated_field = "C9BDFC0D9C8169987134B82DB774F580")

    public static final char[] ASCII_MAP = {
        ' ', '!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ':', ';', '<', '=', '>', '?',
        '@', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
        'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '[', '\\', ']', '^', '_',
        '`', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
        'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '{', '|', '}', '~'};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.908 -0400", hash_original_field = "E7FDC1DEC1ACE01F4339E9E5D6C92BA1", hash_generated_field = "5509FBED9756A7BBF710EC8D69AA4912")

    static final byte UNENCODABLE_7_BIT_CHAR = 0x20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.908 -0400", hash_original_field = "08E1801A26E15C49ED35DCA256F22C74", hash_generated_field = "4F57A3848745E9724824FC859CB7ED08")

    public static final int PRINTABLE_ASCII_MIN_INDEX = 0x20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.908 -0400", hash_original_field = "C39178B1394D2D439500F71FC3B83132", hash_generated_field = "50976B5D891CEC472A67F7A2A6A939D3")

    public static final int ASCII_NL_INDEX = 0x0A;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.908 -0400", hash_original_field = "86C469F7FFE136348441224C2E7BA21A", hash_generated_field = "28BFAB009594032B6F5D6854FFE390EA")

    public static final int ASCII_CR_INDEX = 0x0D;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.908 -0400", hash_original_field = "1AE51200CD552B443D2A67678BD61EC0", hash_generated_field = "27C75A9BA429CC3EC5FD029A98E0FDDB")

    public static final SparseIntArray charToAscii = new SparseIntArray();
    static {
        for (int i = 0; i < ASCII_MAP.length; i++) {
            charToAscii.put(ASCII_MAP[i], PRINTABLE_ASCII_MIN_INDEX + i);
        }
        charToAscii.put('\n', ASCII_NL_INDEX);
        charToAscii.put('\r', ASCII_CR_INDEX);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.908 -0400", hash_original_field = "2ED7508D08FF067EC9C4F1FAEAF02F0F", hash_generated_field = "5BCF2276187D43C54298C2CB70571046")

    public static final int ASCII_MAP_BASE_INDEX = 0x20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.908 -0400", hash_original_field = "F756867F5D72C2E34F2814B3C403ACFB", hash_generated_field = "1E46FE7876CA74A0B7879986F6A7EF23")

    public static final int ASCII_MAP_MAX_INDEX = ASCII_MAP_BASE_INDEX + ASCII_MAP.length - 1;
}

