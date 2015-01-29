package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

import libcore.util.EmptyArray;

public class ASN1BitString extends ASN1StringType {

    /**
     * Returns ASN.1 Bitstring type default implementation
     *
     * The default implementation works with encoding
     * that is represented as BitString object.
     *
     * @return ASN.1 Bitstring type default implementation
     * @see org.apache.harmony.security.asn1.BitString
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.099 -0500", hash_original_method = "66B1F67B2E4924691687068C01957881", hash_generated_method = "09FC42AAA2010F0F571B2693B7BFC711")
    
public static ASN1BitString getInstance() {
        return ASN1;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.093 -0500", hash_original_field = "5FC3A5862F9F55FB5D9272D657B2754F", hash_generated_field = "59CFED8D9DCC36D46CA45472623CE9C2")

    private static final ASN1BitString ASN1 = new ASN1BitString();

    /**
     * Constructs ASN.1 Bitstring type
     *
     * The constructor is provided for inheritance purposes
     * when there is a need to create a custom ASN.1 Bitstring type.
     * To get a default implementation it is recommended to use
     * getInstance() method.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.096 -0500", hash_original_method = "AD601F3532730C1588B10C0B2F4700C0", hash_generated_method = "7CF3579665197E3D9616E88D35150E2D")
    
public ASN1BitString() {
        super(TAG_BITSTRING);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.102 -0500", hash_original_method = "BF14955802A2C4E7FA1CD34E2A56A014", hash_generated_method = "8A9726D2463E2E7A1609D54C6B574E14")
    
@Override public Object decode(BerInputStream in) throws IOException {
        in.readBitString();

        if (in.isVerify) {
            return null;
        }
        return getDecodedObject(in);
    }

    /**
     * Extracts BitString object from BER input stream.
     *
     * @param in - BER input stream
     * @return BitString object
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.104 -0500", hash_original_method = "E5B2C829F55FF77DE885EB0182CA875F", hash_generated_method = "24C5744267DF28523A463FE89F8C323F")
    
@Override public Object getDecodedObject(BerInputStream in) throws IOException {
        byte[] bytes = new byte[in.length - 1];
        System.arraycopy(in.buffer, in.contentOffset + 1, bytes, 0,
                in.length - 1);
        return new BitString(bytes, in.buffer[in.contentOffset]);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.106 -0500", hash_original_method = "F26C5493E5849E857C2B791290EA66B7", hash_generated_method = "7CEE851637A8E7AE92B7EB39CF86E0C6")
    
@Override public void encodeContent(BerOutputStream out) {
        out.encodeBitString();
    }
    
    public static class ASN1NamedBitList extends ASN1BitString {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.112 -0500", hash_original_field = "B8CA03B1D4CC2487E29E89EEB5EF2F9B", hash_generated_field = "AEC1F0C6EBA822C84ED8236810752976")

        private static final byte[] SET_MASK = { (byte) 128, 64, 32, 16, 8, 4, 2, 1};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.114 -0500", hash_original_field = "C54F3354D5EB5E8AF69C37C6039B1FE9", hash_generated_field = "618353E6E65D10C1AA220A91BE6C2EFB")

        private static final BitString emptyString = new BitString(EmptyArray.BYTE, 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.116 -0500", hash_original_field = "380CACA64DC0E6BD8FFD2488CEF79F1F", hash_generated_field = "9178A989C8AB2E04888B17468392B3D6")

        private static final int INDEFINITE_SIZE = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.119 -0500", hash_original_field = "2249D5EAE5D206050241DA9164C6582A", hash_generated_field = "2B48B9A1899DE822AC4EC2D83505C6F1")

        private  int minBits;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.122 -0500", hash_original_field = "DE7F4CC3E2B8F31D9926BD3DA40DD690", hash_generated_field = "BECE67D662A881E5FD42CD7CE3FA03FC")

        private  int maxBits;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.124 -0500", hash_original_method = "C4F695AEADF70B93944D050F01760534", hash_generated_method = "B7FF9483A9A1FF95A97EEA6B3ED6558D")
        
public ASN1NamedBitList(int minBits) {
            this.minBits = minBits;
            this.maxBits = INDEFINITE_SIZE;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.128 -0500", hash_original_method = "039CEFCC208866EAEA17CE6A32A74892", hash_generated_method = "3210BEC7C6D0E61D358F2617AB453BEF")
        
@Override public Object getDecodedObject(BerInputStream in) throws IOException {
            boolean[] value;

            int unusedBits = in.buffer[in.contentOffset];
            int bitsNumber = (in.length - 1) * 8 - unusedBits;

            if (maxBits == INDEFINITE_SIZE) {
                if (minBits == INDEFINITE_SIZE) {
                    value = new boolean[bitsNumber];
                } else {
                    if (bitsNumber > minBits) {
                        value = new boolean[bitsNumber];
                    } else {
                        value = new boolean[minBits];
                    }
                }
            } else {
                if (bitsNumber > maxBits) {
                    throw new ASN1Exception("ASN.1 Named Bitstring: size constraints");
                }
                value = new boolean[maxBits];
            }

            if (bitsNumber == 0) {
                // empty bit string
                return value;
            }

            int i = 1;
            int j = 0;
            byte octet = in.buffer[in.contentOffset + i];
            for (int size = in.length - 1; i < size; i++) {
                for (int k = 0; k < 8; k++, j++) {
                    value[j] = (SET_MASK[k] & octet) != 0;
                }
                i++;
                octet = in.buffer[in.contentOffset + i];
            }

            // final octet
            for (int k = 0; k < (8 - unusedBits); k++, j++) {
                value[j] = (SET_MASK[k] & octet) != 0;
            }

            return value;
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.132 -0500", hash_original_method = "41EEFA120EBBC70AD57105C61092B6CF", hash_generated_method = "E3DE1F1CF68CFF7B1EF417A37E861FD3")
        
@Override public void setEncodingContent(BerOutputStream out) {
            boolean[] toEncode = (boolean[]) out.content;

            int index = toEncode.length - 1;
            while (index > -1 && !toEncode[index]) {
                index--;
            }

            if (index == -1) {
                out.content = emptyString;
                out.length = 1;
            } else {
                int unusedBits = 7 - index % 8;
                byte[] bytes = new byte[index / 8 + 1];

                int j = 0;
                index = bytes.length - 1;
                for (int i = 0; i < index; i++) {
                    for (int k = 0; k < 8; k++, j++) {
                        if (toEncode[j]) {
                            bytes[i] = (byte) (bytes[i] | SET_MASK[k]);
                        }
                    }
                }

                //final octet
                for (int k = 0; k < (8 - unusedBits); k++, j++) {
                    if (toEncode[j]) {
                        bytes[index] = (byte) (bytes[index] | SET_MASK[k]);
                    }
                }

                out.content = new BitString(bytes, unusedBits);
                out.length = bytes.length + 1;
            }
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.109 -0500", hash_original_method = "FF34851DE63579E10DEA6E02E8081017", hash_generated_method = "C74BF0B52156EFB4F6E4A05E92415479")
    
@Override public void setEncodingContent(BerOutputStream out) {
        out.length = ((BitString) out.content).bytes.length + 1;
    }
}

