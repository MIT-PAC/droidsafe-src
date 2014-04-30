package com.android.internal.telephony.cdma.sms;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.util.SparseIntArray;

import com.android.internal.telephony.SmsHeader;
import com.android.internal.util.HexDump;

public class UserData {

    /*
     * TODO(cleanup): Move this very generic functionality somewhere
     * more general.
     */
    /**
     * Given a string generate a corresponding ASCII-encoded byte
     * array, but limited to printable characters.  If the input
     * contains unprintable characters, return null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.141 -0500", hash_original_method = "DB8463E601768C30E10926755AE29405", hash_generated_method = "29CC802E44001D75D65E08FCF1636350")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.093 -0500", hash_original_field = "6FA1C4B9CDCC4AC34217A7143AEC9A61", hash_generated_field = "6EFED19D30358C18169106603C5D0B76")

    public static final int ENCODING_OCTET                      = 0x00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.096 -0500", hash_original_field = "CE8335FCDFB7AD894E746BFBE16B363E", hash_generated_field = "36DF405A391B784B355D3FD26988ABC2")

    public static final int ENCODING_IS91_EXTENDED_PROTOCOL     = 0x01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.098 -0500", hash_original_field = "9092F1564C11F1F75E967B05A1400841", hash_generated_field = "85F0428C1915A59F21B1AE22FFAD7235")

    public static final int ENCODING_7BIT_ASCII                 = 0x02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.101 -0500", hash_original_field = "6FB8DFCCDC75171572667BA92B585199", hash_generated_field = "0799D38D3CE4A953468A4699DB702357")

    public static final int ENCODING_IA5                        = 0x03;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.104 -0500", hash_original_field = "370B8333475C8DB071B8D58ABC90E57B", hash_generated_field = "2D9DB96F0E64A54F2FBFA223F53D6C48")

    public static final int ENCODING_UNICODE_16                 = 0x04;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.107 -0500", hash_original_field = "99FBA63B7AC5BDECB7446E1C99E00FEF", hash_generated_field = "91559928E8FB6EEC78F79F828FC166B6")

    //public static final int ENCODING_KOREAN                     = 0x06;
    //public static final int ENCODING_LATIN_HEBREW               = 0x07;
    public static final int ENCODING_LATIN                      = 0x08;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.109 -0500", hash_original_field = "582824A423B06B0E73756601D58ACC4F", hash_generated_field = "2AE5B485EFEAE9DC1A522969C3CB6D01")

    public static final int ENCODING_GSM_7BIT_ALPHABET          = 0x09;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.112 -0500", hash_original_field = "BCA8FEA09E055FE8851D9057A64DE969", hash_generated_field = "F48F55257C8D6A78BE9A1AC7D1803BBD")

    public static final int ENCODING_GSM_DCS                    = 0x0A;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.115 -0500", hash_original_field = "829643B51E29C4A26E19DCE6E18B3B2D", hash_generated_field = "5DF0A8AA41B72A7A9812BDA339BC753C")

    public static final int IS91_MSG_TYPE_VOICEMAIL_STATUS   = 0x82;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.117 -0500", hash_original_field = "0F8604ADF2730F4A6DD85BB21878DC5D", hash_generated_field = "5888B89A1AE9C3C22755C91C51E6AA50")

    public static final int IS91_MSG_TYPE_SHORT_MESSAGE_FULL = 0x83;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.120 -0500", hash_original_field = "C8F79C5A50913935199FE4A9371C69B9", hash_generated_field = "93AA543DB6F5346E84D1153F9821EB62")

    public static final int IS91_MSG_TYPE_CLI                = 0x84;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.123 -0500", hash_original_field = "B97EA5808680159B3C7FE5AADB3D8113", hash_generated_field = "1826D389E921EA18510D1B3FBF612CC7")

    public static final int IS91_MSG_TYPE_SHORT_MESSAGE      = 0x85;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.126 -0500", hash_original_field = "CE2B3DF4BE4D1D6951E478B5CC4E0D63", hash_generated_field = "C9BDFC0D9C8169987134B82DB774F580")

    public static final char[] ASCII_MAP = {
        ' ', '!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ':', ';', '<', '=', '>', '?',
        '@', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
        'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '[', '\\', ']', '^', '_',
        '`', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
        'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '{', '|', '}', '~'};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.128 -0500", hash_original_field = "E1766F37D45A6FBF637192EEBB6A7FBB", hash_generated_field = "5509FBED9756A7BBF710EC8D69AA4912")

    static final byte UNENCODABLE_7_BIT_CHAR = 0x20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.131 -0500", hash_original_field = "DCC48B7929B99F26ADE0099DDC308D3F", hash_generated_field = "4F57A3848745E9724824FC859CB7ED08")

    public static final int PRINTABLE_ASCII_MIN_INDEX = 0x20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.134 -0500", hash_original_field = "779CF3DFC87BD2CCCD5B340A84EAB3D9", hash_generated_field = "50976B5D891CEC472A67F7A2A6A939D3")

    public static final int ASCII_NL_INDEX = 0x0A;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.136 -0500", hash_original_field = "FA48F88663E6538806C832CD67E2FE78", hash_generated_field = "28BFAB009594032B6F5D6854FFE390EA")

    public static final int ASCII_CR_INDEX = 0x0D;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.139 -0500", hash_original_field = "04CBACED7396E5E0AF70073CAB53C18C", hash_generated_field = "27C75A9BA429CC3EC5FD029A98E0FDDB")

    public static final SparseIntArray charToAscii = new SparseIntArray();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.144 -0500", hash_original_field = "2ABCFC4C20372388F04898838FCD0610", hash_generated_field = "5BCF2276187D43C54298C2CB70571046")

    public static final int ASCII_MAP_BASE_INDEX = 0x20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.147 -0500", hash_original_field = "5A072C9AE7B4361B3CAAD5DE94931B3E", hash_generated_field = "1E46FE7876CA74A0B7879986F6A7EF23")

    public static final int ASCII_MAP_MAX_INDEX = ASCII_MAP_BASE_INDEX + ASCII_MAP.length - 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.149 -0500", hash_original_field = "532180B80C80AE52803AEB5499571541", hash_generated_field = "1EA01C87D6AD02FA32C000798DFDC94E")

    public SmsHeader userDataHeader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.152 -0500", hash_original_field = "6294430B095EE6FF529CA827A403A4D2", hash_generated_field = "3554CFCCD59683AEDE92C6222AE2FA46")

    public int msgEncoding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.154 -0500", hash_original_field = "7FE87128DE5B8E6BD0A7AE1159661320", hash_generated_field = "90F67D4EBD7007BE298A8A19FC5C19EA")

    public boolean msgEncodingSet = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.156 -0500", hash_original_field = "E1F7CA890E089473385A3CC871D268F9", hash_generated_field = "E888D55A5AA03C238E18CFE2D68CBBFF")

    public int msgType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.160 -0500", hash_original_field = "88E48F3E9BC9A39935A71F37482D370B", hash_generated_field = "867C58A538EC8BA6F8BCCFF77F42BD57")

    public int paddingBits;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.162 -0500", hash_original_field = "DA7E6F83BB7DCBEBBE77E96BE71A424C", hash_generated_field = "AAAC31C5909C6EB96CBCAA6BFC1DD04F")

    public int numFields;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.165 -0500", hash_original_field = "379AC6F271B60152FF88CC8F1BD43D4B", hash_generated_field = "85C99161735D908FB014CA702C49895B")

    public byte[] payload;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.167 -0500", hash_original_field = "CB64A64CC5A950AE0FB6CCDA66DC8325", hash_generated_field = "3651705D811FD56278B4863F6101E60B")

    public String payloadStr;
    static {
        for (int i = 0; i < ASCII_MAP.length; i++) {
            charToAscii.put(ASCII_MAP[i], PRINTABLE_ASCII_MIN_INDEX + i);
        }
        charToAscii.put('\n', ASCII_NL_INDEX);
        charToAscii.put('\r', ASCII_CR_INDEX);
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.754 -0400", hash_original_method = "09164C91BCB463A1239D064C926A7134", hash_generated_method = "09164C91BCB463A1239D064C926A7134")
    public UserData ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.170 -0500", hash_original_method = "F1C0D00F51384BB453814F967BB3AF69", hash_generated_method = "30332BD0F2A6129C141C1D7BD5FDB3B6")
    
@Override
    public String toString() {
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
        return builder.toString();
    }
}

