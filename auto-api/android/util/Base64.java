package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.UnsupportedEncodingException;

public class Base64 {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.189 -0400", hash_original_method = "B12DC6BE1A1E2EB3A4F484EDEACB8E03", hash_generated_method = "96F9E0BDD170E9FC5C3951236F2EB54E")
    private  Base64() {
        // ---------- Original Method ----------
    }

    
    public static byte[] decode(String str, int flags) {
        return decode(str.getBytes(), flags);
    }

    
    public static byte[] decode(byte[] input, int flags) {
        return decode(input, 0, input.length, flags);
    }

    
    public static byte[] decode(byte[] input, int offset, int len, int flags) {
        Decoder decoder = new Decoder(flags, new byte[len*3/4]);
        if (!decoder.process(input, offset, len, true)) {
            throw new IllegalArgumentException("bad base-64");
        }
        if (decoder.op == decoder.output.length) {
            return decoder.output;
        }
        byte[] temp = new byte[decoder.op];
        System.arraycopy(decoder.output, 0, temp, 0, decoder.op);
        return temp;
    }

    
    public static String encodeToString(byte[] input, int flags) {
        try {
            return new String(encode(input, flags), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    
    public static String encodeToString(byte[] input, int offset, int len, int flags) {
        try {
            return new String(encode(input, offset, len, flags), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    
    public static byte[] encode(byte[] input, int flags) {
        return encode(input, 0, input.length, flags);
    }

    
    public static byte[] encode(byte[] input, int offset, int len, int flags) {
        Encoder encoder = new Encoder(flags, null);
        int output_len = len / 3 * 4;
        if (encoder.do_padding) {
            if (len % 3 > 0) {
                output_len += 4;
            }
        } else {
            switch (len % 3) {
                case 0: break;
                case 1: output_len += 2; break;
                case 2: output_len += 3; break;
            }
        }
        if (encoder.do_newline && len > 0) {
            output_len += (((len-1) / (3 * Encoder.LINE_GROUPS)) + 1) *
                (encoder.do_cr ? 2 : 1);
        }
        encoder.output = new byte[output_len];
        encoder.process(input, offset, len, true);
        assert encoder.op == output_len;
        return encoder.output;
    }

    
    static abstract class Coder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.190 -0400", hash_original_field = "78E6221F6393D1356681DB398F14CE6D", hash_generated_field = "D105CC424D01A80053DB00A4050DABF0")

        public byte[] output;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.190 -0400", hash_original_field = "11D8C28A64490A987612F2332502467F", hash_generated_field = "2CC8ED7F6ECA7F350E8D1039E35F5E73")

        public int op;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.190 -0400", hash_original_method = "1EFD9A0D338C10B7A776AFC361894E38", hash_generated_method = "1EFD9A0D338C10B7A776AFC361894E38")
        public Coder ()
        {
            //Synthesized constructor
        }


        public abstract boolean process(byte[] input, int offset, int len, boolean finish);

        
        public abstract int maxOutputSize(int len);

        
    }


    
    static class Decoder extends Coder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.191 -0400", hash_original_field = "9ED39E2EA931586B6A985A6942EF573E", hash_generated_field = "26F20A2ED327951B7F331D22F1CEEC90")

        private int state;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.191 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "810C3DA5CE7DA1BA423D6BE76816E5C9")

        private int value;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.191 -0400", hash_original_field = "CAFC7170ED01C2F5C972CAC7CDE6E932", hash_generated_field = "B4B64C8D6FAE0E02F5E7C4A49CB38458")

        private int[] alphabet;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.191 -0400", hash_original_method = "28200CA179B3214BB831C341BA07009C", hash_generated_method = "98DEFCB657E518A4C86E978A542B2B12")
        public  Decoder(int flags, byte[] output) {
            this.output = output;
            alphabet = ((flags & URL_SAFE) == 0) ? DECODE : DECODE_WEBSAFE;
            state = 0;
            value = 0;
            addTaint(output[0]);
            // ---------- Original Method ----------
            //this.output = output;
            //alphabet = ((flags & URL_SAFE) == 0) ? DECODE : DECODE_WEBSAFE;
            //state = 0;
            //value = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.192 -0400", hash_original_method = "006B314D1443F75FACC9C9CF957F4174", hash_generated_method = "DF0551D3E769280A019030996774DB2C")
        public int maxOutputSize(int len) {
            addTaint(len);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_161778408 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_161778408;
            // ---------- Original Method ----------
            //return len * 3/4 + 10;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.194 -0400", hash_original_method = "5E49CA254C7BA97645BE526448794F2D", hash_generated_method = "C9C543F73B8CA65A245096890123950E")
        public boolean process(byte[] input, int offset, int len, boolean finish) {
            int p = offset;
            len += offset;
            int state = this.state;
            int value = this.value;
            int op = 0;
            final byte[] output = this.output;
            final int[] alphabet = this.alphabet;
            {
                {
                    {
                        boolean var352F1CA5F42B44E4BE0B087C79C4F4FB_1485806194 = (p+4 <= len &&
                           (value = ((alphabet[input[p] & 0xff] << 18) |
                                     (alphabet[input[p+1] & 0xff] << 12) |
                                     (alphabet[input[p+2] & 0xff] << 6) |
                                     (alphabet[input[p+3] & 0xff]))) >= 0);
                        {
                            output[op+2] = (byte) value;
                            output[op+1] = (byte) (value >> 8);
                            output[op] = (byte) (value >> 16);
                            op += 3;
                            p += 4;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                int d = alphabet[input[p++] & 0xff];
                //Begin case 0 
                {
                    value = d;
                } //End block
                {
                    this.state = 6;
                } //End block
                //End case 0 
                //Begin case 1 
                {
                    value = (value << 6) | d;
                } //End block
                {
                    this.state = 6;
                } //End block
                //End case 1 
                //Begin case 2 
                {
                    value = (value << 6) | d;
                } //End block
                {
                    output[op++] = (byte) (value >> 4);
                    state = 4;
                } //End block
                {
                    this.state = 6;
                } //End block
                //End case 2 
                //Begin case 3 
                {
                    value = (value << 6) | d;
                    output[op+2] = (byte) value;
                    output[op+1] = (byte) (value >> 8);
                    output[op] = (byte) (value >> 16);
                    op += 3;
                    state = 0;
                } //End block
                {
                    output[op+1] = (byte) (value >> 2);
                    output[op] = (byte) (value >> 10);
                    op += 2;
                    state = 5;
                } //End block
                {
                    this.state = 6;
                } //End block
                //End case 3 
                //Begin case 4 
                {
                    this.state = 6;
                } //End block
                //End case 4 
                //Begin case 5 
                {
                    this.state = 6;
                } //End block
                //End case 5 
            } //End block
            {
                this.state = state;
                this.value = value;
                this.op = op;
            } //End block
            //Begin case 1 
            this.state = 6;
            //End case 1 
            //Begin case 2 
            output[op++] = (byte) (value >> 4);
            //End case 2 
            //Begin case 3 
            output[op++] = (byte) (value >> 10);
            //End case 3 
            //Begin case 3 
            output[op++] = (byte) (value >> 2);
            //End case 3 
            //Begin case 4 
            this.state = 6;
            //End case 4 
            this.state = state;
            this.op = op;
            addTaint(input[0]);
            addTaint(offset);
            addTaint(len);
            addTaint(finish);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1097992231 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1097992231;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.194 -0400", hash_original_field = "611F478DA6534A752DBC5AF0D44769F3", hash_generated_field = "C476360DF9D857A2925681052DA07C19")

        private static final int DECODE[] = {
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63,
            52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1,
            -1,  0,  1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12, 13, 14,
            15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1,
            -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
            41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        };
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.194 -0400", hash_original_field = "F34C7E32E25EF2F32AA59D57BCF5197A", hash_generated_field = "D484883C2C35399CF99348476C2D0A97")

        private static final int DECODE_WEBSAFE[] = {
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1,
            52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1,
            -1,  0,  1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12, 13, 14,
            15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63,
            -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
            41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        };
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.195 -0400", hash_original_field = "7AD47BEDDF225CA8CF388685F0ABBB5F", hash_generated_field = "4F546CF4B8E245683DB60010E7DCC5AA")

        private static final int SKIP = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.195 -0400", hash_original_field = "270EC1947A9493FCCA3C4F63536B2E8A", hash_generated_field = "15968FF04D715A124A2832120101F3DA")

        private static final int EQUALS = -2;
    }


    
    static class Encoder extends Coder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.195 -0400", hash_original_field = "7AEA2552DFE7EB84B9443B6FC9BA6E01", hash_generated_field = "3976D48215D9CD369B9FF1E7AF7204AD")

        private byte[] tail;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.195 -0400", hash_original_field = "8BCD185842634B14855CACA64EEE03BB", hash_generated_field = "7F978AE0FA51DCF6FD5C73F0C45A5FAC")

        int tailLen;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.195 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "82CC849FCF58347832EA6BB917282DBE")

        private int count;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.195 -0400", hash_original_field = "1281B7A56518CE6647ECC1C8D9ACC4DA", hash_generated_field = "4E0FC1C064D8F3218FE12A1DD5866176")

        public boolean do_padding;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.195 -0400", hash_original_field = "BE5050F79710D26588B78A51D2196B92", hash_generated_field = "232A0ACDB2D945A1E8AF0B685CCC1422")

        public boolean do_newline;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.195 -0400", hash_original_field = "7988A80F8118ABF3532380CF22F0DC8E", hash_generated_field = "C3A36DCB9AD646054DE6D44BB1B8EC47")

        public boolean do_cr;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.195 -0400", hash_original_field = "CAFC7170ED01C2F5C972CAC7CDE6E932", hash_generated_field = "01F03DE41626851E3A4CAC48E94745D3")

        private byte[] alphabet;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.195 -0400", hash_original_method = "248AE984D731F285F53C3C8EA52608A3", hash_generated_method = "A2D7988B82301A73F8E21F6925066506")
        public  Encoder(int flags, byte[] output) {
            this.output = output;
            do_padding = (flags & NO_PADDING) == 0;
            do_newline = (flags & NO_WRAP) == 0;
            do_cr = (flags & CRLF) != 0;
            alphabet = ((flags & URL_SAFE) == 0) ? ENCODE : ENCODE_WEBSAFE;
            tail = new byte[2];
            tailLen = 0;
            count = do_newline ? LINE_GROUPS : -1;
            addTaint(output[0]);
            // ---------- Original Method ----------
            //this.output = output;
            //do_padding = (flags & NO_PADDING) == 0;
            //do_newline = (flags & NO_WRAP) == 0;
            //do_cr = (flags & CRLF) != 0;
            //alphabet = ((flags & URL_SAFE) == 0) ? ENCODE : ENCODE_WEBSAFE;
            //tail = new byte[2];
            //tailLen = 0;
            //count = do_newline ? LINE_GROUPS : -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.196 -0400", hash_original_method = "9D3D65123317D09985A4DE210ACBFBB3", hash_generated_method = "281EC7F7DD22471D20FA8FD02D3120E6")
        public int maxOutputSize(int len) {
            addTaint(len);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_268966185 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_268966185;
            // ---------- Original Method ----------
            //return len * 8/5 + 10;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.198 -0400", hash_original_method = "551D84DD57FDEAF562D9C2C55207FB04", hash_generated_method = "2F45C0B789B2F57A523757A5FC0C2234")
        public boolean process(byte[] input, int offset, int len, boolean finish) {
            final byte[] alphabet = this.alphabet;
            final byte[] output = this.output;
            int op = 0;
            int count = this.count;
            int p = offset;
            len += offset;
            int v = -1;
            //Begin case 1 
            {
                v = ((tail[0] & 0xff) << 16) |
                            ((input[p++] & 0xff) << 8) |
                            (input[p++] & 0xff);
                tailLen = 0;
            } //End block
            //End case 1 
            //Begin case 1 
            ;
            //End case 1 
            //Begin case 2 
            {
                v = ((tail[0] & 0xff) << 16) |
                            ((tail[1] & 0xff) << 8) |
                            (input[p++] & 0xff);
                tailLen = 0;
            } //End block
            //End case 2 
            {
                output[op++] = alphabet[(v >> 18) & 0x3f];
                output[op++] = alphabet[(v >> 12) & 0x3f];
                output[op++] = alphabet[(v >> 6) & 0x3f];
                output[op++] = alphabet[v & 0x3f];
                {
                    output[op++] = '\r';
                    output[op++] = '\n';
                    count = LINE_GROUPS;
                } //End block
            } //End block
            {
                v = ((input[p] & 0xff) << 16) |
                    ((input[p+1] & 0xff) << 8) |
                    (input[p+2] & 0xff);
                output[op] = alphabet[(v >> 18) & 0x3f];
                output[op+1] = alphabet[(v >> 12) & 0x3f];
                output[op+2] = alphabet[(v >> 6) & 0x3f];
                output[op+3] = alphabet[v & 0x3f];
                p += 3;
                op += 4;
                {
                    output[op++] = '\r';
                    output[op++] = '\n';
                    count = LINE_GROUPS;
                } //End block
            } //End block
            {
                {
                    int t = 0;
                    v = ((tailLen > 0 ? tail[t++] : input[p++]) & 0xff) << 4;
                    tailLen -= t;
                    output[op++] = alphabet[(v >> 6) & 0x3f];
                    output[op++] = alphabet[v & 0x3f];
                    {
                        output[op++] = '=';
                        output[op++] = '=';
                    } //End block
                    {
                        output[op++] = '\r';
                        output[op++] = '\n';
                    } //End block
                } //End block
                {
                    int t = 0;
                    v = (((tailLen > 1 ? tail[t++] : input[p++]) & 0xff) << 10) |
                        (((tailLen > 0 ? tail[t++] : input[p++]) & 0xff) << 2);
                    tailLen -= t;
                    output[op++] = alphabet[(v >> 12) & 0x3f];
                    output[op++] = alphabet[(v >> 6) & 0x3f];
                    output[op++] = alphabet[v & 0x3f];
                    {
                        output[op++] = '=';
                    } //End block
                    {
                        output[op++] = '\r';
                        output[op++] = '\n';
                    } //End block
                } //End block
                {
                    output[op++] = '\r';
                    output[op++] = '\n';
                } //End block
            } //End block
            {
                {
                    tail[tailLen++] = input[p];
                } //End block
                {
                    tail[tailLen++] = input[p];
                    tail[tailLen++] = input[p+1];
                } //End block
            } //End block
            this.op = op;
            this.count = count;
            addTaint(offset);
            addTaint(len);
            addTaint(finish);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_306522832 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_306522832;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.198 -0400", hash_original_field = "1E5B476D78E4826DF81F960BC0323F2B", hash_generated_field = "AEA37AD1BAA7CFE9FF857DBCC9155C6B")

        public static final int LINE_GROUPS = 19;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.198 -0400", hash_original_field = "BAA4DC55A7729372B7E92EF38AF267DD", hash_generated_field = "99FC3B7700D42E7A1429B46B2DABA37C")

        private static final byte ENCODE[] = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/',
        };
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.198 -0400", hash_original_field = "FAE67F9513FCD5EDF24DB79B0A052717", hash_generated_field = "DD402FEA9A4EE03692FE1322010C2742")

        private static final byte ENCODE_WEBSAFE[] = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_',
        };
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.198 -0400", hash_original_field = "D8C7884D3AEEE28E1825BF7A4F3346D4", hash_generated_field = "F5A513FC09A88F617602B5914AAD8A90")

    public static final int DEFAULT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.198 -0400", hash_original_field = "EA1F2804AD1F11E3261D3E3990F4FD35", hash_generated_field = "90B2069C15AB13D219B27D01B76F7345")

    public static final int NO_PADDING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.198 -0400", hash_original_field = "1D95CC0BA605FE020E1A018B6C1976F1", hash_generated_field = "DD1DB73525C3F37E3BC419AB114C4B75")

    public static final int NO_WRAP = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.198 -0400", hash_original_field = "55C6EBE04BB0B590CDC9899AAD1BAB2B", hash_generated_field = "2556AB718F122F12992982C57F5C3502")

    public static final int CRLF = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.198 -0400", hash_original_field = "63E4702376A879728ACA1554C9D56A6F", hash_generated_field = "E5A3AC6BA5190912C47BD41618AC8C0F")

    public static final int URL_SAFE = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.198 -0400", hash_original_field = "8A0D61CC7072AE999645132AC9B7DF00", hash_generated_field = "F8D813B2752942D8E0142FAF2E00BDCC")

    public static final int NO_CLOSE = 16;
}

