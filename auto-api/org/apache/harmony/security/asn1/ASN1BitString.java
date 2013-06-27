package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import libcore.util.EmptyArray;

public class ASN1BitString extends ASN1StringType {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.112 -0400", hash_original_method = "AD601F3532730C1588B10C0B2F4700C0", hash_generated_method = "2D61DE183F5D6ABAA7F4E57F92D94159")
    public  ASN1BitString() {
        super(TAG_BITSTRING);
        // ---------- Original Method ----------
    }

    
        public static ASN1BitString getInstance() {
        return ASN1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.113 -0400", hash_original_method = "BF14955802A2C4E7FA1CD34E2A56A014", hash_generated_method = "DCFCBDBE0D4AF2B94AD25751F6B43F9F")
    @Override
    public Object decode(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1487037500 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1683144327 = null; //Variable for return #2
        in.readBitString();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1487037500 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1683144327 = getDecodedObject(in);
        addTaint(in.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_1589446434; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1589446434 = varB4EAC82CA7396A68D541C85D26508E83_1487037500;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1589446434 = varB4EAC82CA7396A68D541C85D26508E83_1683144327;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1589446434.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1589446434;
        // ---------- Original Method ----------
        //in.readBitString();
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.113 -0400", hash_original_method = "E5B2C829F55FF77DE885EB0182CA875F", hash_generated_method = "F850FC0975D3A8CCD7A845BF3E6C17DE")
    @Override
    public Object getDecodedObject(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_564952233 = null; //Variable for return #1
        byte[] bytes;
        bytes = new byte[in.length - 1];
        System.arraycopy(in.buffer, in.contentOffset + 1, bytes, 0,
                in.length - 1);
        varB4EAC82CA7396A68D541C85D26508E83_564952233 = new BitString(bytes, in.buffer[in.contentOffset]);
        addTaint(in.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_564952233.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_564952233;
        // ---------- Original Method ----------
        //byte[] bytes = new byte[in.length - 1];
        //System.arraycopy(in.buffer, in.contentOffset + 1, bytes, 0,
                //in.length - 1);
        //return new BitString(bytes, in.buffer[in.contentOffset]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.114 -0400", hash_original_method = "F26C5493E5849E857C2B791290EA66B7", hash_generated_method = "8EB6659EE7ACC145044172E5DDEA496D")
    @Override
    public void encodeContent(BerOutputStream out) {
        out.encodeBitString();
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.encodeBitString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.114 -0400", hash_original_method = "FF34851DE63579E10DEA6E02E8081017", hash_generated_method = "B9F78BD4A9B3EDC7CEE6D40504E08AA1")
    @Override
    public void setEncodingContent(BerOutputStream out) {
        out.length = ((BitString) out.content).bytes.length + 1;
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.length = ((BitString) out.content).bytes.length + 1;
    }

    
    public static class ASN1NamedBitList extends ASN1BitString {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.114 -0400", hash_original_field = "E9B5EF3115749AC18666D4BF999B0F5A", hash_generated_field = "2B48B9A1899DE822AC4EC2D83505C6F1")

        private int minBits;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.114 -0400", hash_original_field = "2EE20D4233C27F4EBE5662A79A1E53A3", hash_generated_field = "BECE67D662A881E5FD42CD7CE3FA03FC")

        private int maxBits;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.114 -0400", hash_original_method = "C4F695AEADF70B93944D050F01760534", hash_generated_method = "549A43448CDE686297D3DDCA79456ED8")
        public  ASN1NamedBitList(int minBits) {
            this.minBits = minBits;
            this.maxBits = INDEFINITE_SIZE;
            // ---------- Original Method ----------
            //this.minBits = minBits;
            //this.maxBits = INDEFINITE_SIZE;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.130 -0400", hash_original_method = "039CEFCC208866EAEA17CE6A32A74892", hash_generated_method = "FCC6773725BB261B16A737EEE907CB58")
        @Override
        public Object getDecodedObject(BerInputStream in) throws IOException {
            Object varB4EAC82CA7396A68D541C85D26508E83_1959794912 = null; //Variable for return #1
            Object varB4EAC82CA7396A68D541C85D26508E83_1989152874 = null; //Variable for return #2
            boolean[] value;
            int unusedBits;
            unusedBits = in.buffer[in.contentOffset];
            int bitsNumber;
            bitsNumber = (in.length - 1) * 8 - unusedBits;
            {
                {
                    value = new boolean[bitsNumber];
                } //End block
                {
                    {
                        value = new boolean[bitsNumber];
                    } //End block
                    {
                        value = new boolean[minBits];
                    } //End block
                } //End block
            } //End block
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 Named Bitstring: size constraints");
                } //End block
                value = new boolean[maxBits];
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1959794912 = value;
            } //End block
            int i;
            i = 1;
            int j;
            j = 0;
            byte octet;
            octet = in.buffer[in.contentOffset + i];
            {
                int size;
                size = in.length - 1;
                {
                    {
                        int k;
                        k = 0;
                        {
                            value[j] = (SET_MASK[k] & octet) != 0;
                        } //End block
                    } //End collapsed parenthetic
                    octet = in.buffer[in.contentOffset + i];
                } //End block
            } //End collapsed parenthetic
            {
                int k;
                k = 0;
                {
                    value[j] = (SET_MASK[k] & octet) != 0;
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1989152874 = value;
            addTaint(in.getTaint());
            Object varA7E53CE21691AB073D9660D615818899_1633103887; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1633103887 = varB4EAC82CA7396A68D541C85D26508E83_1959794912;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1633103887 = varB4EAC82CA7396A68D541C85D26508E83_1989152874;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1633103887.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1633103887;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.132 -0400", hash_original_method = "41EEFA120EBBC70AD57105C61092B6CF", hash_generated_method = "AA1320D93952E14E4E56D9600D57014B")
        @Override
        public void setEncodingContent(BerOutputStream out) {
            boolean[] toEncode;
            toEncode = (boolean[]) out.content;
            int index;
            index = toEncode.length - 1;
            {
                out.content = emptyString;
                out.length = 1;
            } //End block
            {
                int unusedBits;
                unusedBits = 7 - index % 8;
                byte[] bytes;
                bytes = new byte[index / 8 + 1];
                int j;
                j = 0;
                index = bytes.length - 1;
                {
                    int i;
                    i = 0;
                    {
                        {
                            int k;
                            k = 0;
                            {
                                {
                                    bytes[i] = (byte) (bytes[i] | SET_MASK[k]);
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    int k;
                    k = 0;
                    {
                        {
                            bytes[index] = (byte) (bytes[index] | SET_MASK[k]);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                out.content = new BitString(bytes, unusedBits);
                out.length = bytes.length + 1;
            } //End block
            addTaint(out.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.133 -0400", hash_original_field = "82B8116D8A84475E2750CC92DE9DE1EE", hash_generated_field = "2D37E40650DB98B909921D4684433CAA")

        private static byte[] SET_MASK = ;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.133 -0400", hash_original_field = "C87CDD30AF6746725900E8C27C13F470", hash_generated_field = "A0E61ABAA2A4C53F276E5F905F72B433")

        private static BitString emptyString = new BitString(EmptyArray.BYTE, 0);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.133 -0400", hash_original_field = "ED285F119BD307DA94B8580FF2D7A2B6", hash_generated_field = "0292CAB4E100E219593EA62A8E443A3E")

        private static int INDEFINITE_SIZE = -1;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.133 -0400", hash_original_field = "527079CC22747EFD81E648BF044EFFD1", hash_generated_field = "B2100D7B6CCDEA55F5487EE94DED604F")

    private static ASN1BitString ASN1 = new ASN1BitString();
}

